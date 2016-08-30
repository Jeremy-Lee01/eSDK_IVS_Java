/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.ivs.authorize;

import java.util.Date;

import com.huawei.esdk.ivs.business.professional.commonmgr.CommonMgrService;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.huawei.esdk.ivs.domain.model.bean.LoginInfo;
import com.huawei.esdk.platform.abnormalevent.itf.IAbnormalevent;
import com.huawei.esdk.platform.authorize.itf.IAuthorize;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.bean.abnormalevent.AbnormaleventBean;
import com.huawei.esdk.platform.common.bean.callback.CallbackItfInfo;
import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;
import com.huawei.esdk.platform.common.bean.config.UserConfig;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.nemgr.base.NotifyCollector;
import com.huawei.esdk.platform.usermgr.itf.IUserLockManager;
import com.huawei.esdk.platform.usermgr.itf.IUserManager;

public class AuthenticateService
{
    private CommonMgrService commonMgrService;
    
    private IAuthorize authorize;
    
    /**
     * 用户管理
     */
    private IUserManager userManager;
    
    /**
     * 用户锁定管理
     */
    private IUserLockManager userLockManager;
    
    private IAbnormalevent abnormaleventManager;
    
    private NotifyCollector collector;
    
    public SDKErrorCode login(LoginInfo loginInfo)
        throws SDKException
    {
        MessageContext mc = ThreadLocalHolder.get();
        String sessionId = (String)mc.getEntities().get(InfoKeys.SDK_SESSION_ID.toString());
        AccountInfo acctInfo = new AccountInfo();
        mc.getEntities().put(ESDKConstant.ACCT_INFO_ESDK, acctInfo);
        acctInfo.setUserId(loginInfo.getUserName());
        acctInfo.setPassword(loginInfo.getPassword());
        
        SDKErrorCode result;
        if (authorize.isLocalAuth("ivs"))
        {
            result = new SDKErrorCode();
            result.setErrCode(checkUser(loginInfo.getUserName(), loginInfo.getPassword()));
            if (0 == result.getErrCode())
            {
                String devId = ConfigManager.getInstance().getValue("esdk.ivs_vcn_device");
                publishMessage(devId, ESDKConstant.NOTIFY_ITFNAME_CONNECT, devId);
                result.setErrCode((Integer)ThreadLocalHolder.get()
                    .getEntities()
                    .get(InfoKeys.IVS_RESULT_CODE.toString()));
            }
        }
        else
        {
            result = commonMgrService.login(loginInfo);
        }
        
        if (0 == result.getErrCode() || CommonConstant.UserModule.IVS_SMU_USER_FIRST_LOGIN == result.getErrCode()
            || CommonConstant.UserModule.IVS_SMU_USER_PWD_NEED_MOD == result.getErrCode())
        {
            //保存登录状态
            SessionManager.getInstance().getSDKSession(sessionId).setLogged(true);
        }
        else
        {
            //登录失败时删除session
            SessionManager.getInstance().removeSDKSession(sessionId);
            ThreadLocalHolder.unset();
        }
        
        processAbnormalEvent(result.getErrCode(), loginInfo.getUserName());
        
        return result;
    }
    
    private void processAbnormalEvent(long successFlag, String userName)
    {
        AbnormaleventBean bean = new AbnormaleventBean();
        bean.setObjName(userName);
        bean.setOccurrence(IAbnormalevent.FAIL_TO_AUTHENTICATE);
        
        if (0 != successFlag)
        {
            // add by taochunlong 鉴权失败记入异常信息管理            
            bean.setOccurTime(new Date());
            bean.setExceptionMessage("");
            abnormaleventManager.occurException(bean.getObjName() + "_" + bean.getOccurrence(), bean);
        }
        else
        {
            // add by taochunlong 鉴权成功后若有异常信息则将信终止
            bean.setEndTime(new Date());
            abnormaleventManager.endException(bean.getObjName() + "_" + bean.getOccurrence(), bean);
        }
    }
    
    private int checkUser(String userName, String pwd)
    {
        UserConfig user = userManager.getUserById(userName);
        if (user != null)
        {
            if (user.getPassword().equals(pwd))
            {
                return 0;
            }
        }
        
        return ErrInfo.APPPWD_ERRORCODE;
    }
    
    public SDKErrorCode logout()
        throws SDKException
    {
        String sessionId = (String)ThreadLocalHolder.get().getEntities().get(InfoKeys.SDK_SESSION_ID.toString());
        SDKErrorCode result;
        
        if (authorize.isLocalAuth("ivs"))
        {
            SessionManager sessionMgr = SessionManager.getInstance();
            int ivsSessionId = sessionMgr.getSDKSession(sessionId).getVCNSessionId();
            ThreadLocalHolder.get().getEntities().put(InfoKeys.IVS_SESSION_ID.toString(), ivsSessionId);
            result = new SDKErrorCode();
            result.setErrCode(0);
        }
        else
        {
            result = commonMgrService.logout();
        }
        String devId = ConfigManager.getInstance().getValue("esdk.ivs_vcn_device");
        publishMessage(devId, ESDKConstant.NOTIFY_ITFNAME_DISCONNECT, devId);
        SessionManager.getInstance().removeSDKSession(sessionId);
        
        return result;
    }
    
    private void publishMessage(String devId, String itfName, String processorId)
    {
        CallbackMessage message = new CallbackMessage();
        CallbackItfInfo callbackItfInfo = new CallbackItfInfo();
        callbackItfInfo.setDevId(devId);
        callbackItfInfo.setItfName(itfName);
        callbackItfInfo.setNotifyMsgType(ESDKConstant.NOTIFY_MSG_TYPE_ESDK_EVENT);
        callbackItfInfo.setProcessorId(processorId);
        message.setCallbackItfInfo(callbackItfInfo);
        collector.publishNotify(message);
    }
    
    public IUserManager getUserManager()
    {
        return userManager;
    }
    
    public void setUserManager(IUserManager userManager)
    {
        this.userManager = userManager;
    }
    
    public IUserLockManager getUserLockManager()
    {
        return userLockManager;
    }
    
    public void setUserLockManager(IUserLockManager userLockManager)
    {
        this.userLockManager = userLockManager;
    }
    
    public IAbnormalevent getAbnormaleventManager()
    {
        return abnormaleventManager;
    }
    
    public void setAbnormaleventManager(IAbnormalevent abnormaleventManager)
    {
        this.abnormaleventManager = abnormaleventManager;
    }
    
    public NotifyCollector getCollector()
    {
        return collector;
    }
    
    public void setCollector(NotifyCollector collector)
    {
        this.collector = collector;
    }
    
    public CommonMgrService getCommonMgrService()
    {
        return commonMgrService;
    }
    
    public void setCommonMgrService(CommonMgrService commonMgrService)
    {
        this.commonMgrService = commonMgrService;
    }
    
    public IAuthorize getAuthorize()
    {
        return authorize;
    }
    
    public void setAuthorize(IAuthorize authorize)
    {
        this.authorize = authorize;
    }
}
