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
package com.huawei.esdk.ivs.domain.model;

import java.util.List;

import com.huawei.esdk.ivs.authorize.SessionInfo;
import com.huawei.esdk.ivs.authorize.SessionManager;
import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.ivs.device.vcn3000.common.ICommonCapability;
import com.huawei.esdk.ivs.domain.model.bean.IPInfo;
import com.huawei.esdk.ivs.domain.model.bean.LoginInfo;
import com.huawei.esdk.ivs.domain.util.DeviceServiceProxy;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class Authenticate
{
    
    /**
     * 用户登录
     * @param loginInfo 用户登录信息 
     * @return SDKErrorCode 登录结果
     * @exception  SDKException  SDK异常
     * @since eSDK IVS V100R003C00
     */
    public SDKErrorCode login(LoginInfo loginInfo)
        throws SDKException
    {
        String deviceServiceAccessPort = DeviceServiceProxy.getDeviceServiceAccessPort();
        
        // DTS2015020602859 2015.03.17 c00316442
        if (StringUtils.isEmpty(deviceServiceAccessPort) || deviceServiceAccessPort.split(":").length != 2)
        {
            // 抛出错误
            SDKResult<Integer> result = new SDKResult<Integer>();
            result.setErrCode(ESDKErrorCodeConstant.ERROR_CODE_CONN_NULL);
            return result;
        }
        else
        //if (null != deviceServiceAccessPort && null != deviceServiceAccessPort.split(":") && 1 < deviceServiceAccessPort.split(":").length)
        {
            IPInfo ip = new IPInfo();
            ip.setIp(deviceServiceAccessPort.split(":")[0]);
            loginInfo.setServerIp(ip);
            loginInfo.setServerPort(Integer.parseInt(deviceServiceAccessPort.split(":")[1]));
        }
        
        SessionManager sessionMgr = SessionManager.getInstance();
        MessageContext mc = ThreadLocalHolder.get();
        if (mc == null)
        {
            mc = new MessageContext();
            ThreadLocalHolder.set(mc);
        }
        String esdkSessionId = (String)mc.getEntities().get(InfoKeys.SDK_SESSION_ID.toString());
        SessionInfo info = sessionMgr.getSDKSession(esdkSessionId);
        
        SDKResult<Integer> result = new SDKResult<Integer>();
        int vcnSessionId = sessionMgr.checkUserName(loginInfo.getUserName());
        if (0 <= vcnSessionId)
        {
            List<String> esdkSessionidList = sessionMgr.getSDKSessonList(vcnSessionId);
            
            // 调用鉴权接口，如果鉴权通过，新增session表。鉴权失败，返回错误码。
            result =
                DeviceServiceProxy.getInstance()
                    .getDeviceServiceProxy(ICommonCapability.class)
                    .passwdValidation(vcnSessionId, loginInfo.getUserName(), loginInfo.getPassword());
            if (0 == result.getErrCode())
            {
                info.setUserName(loginInfo.getUserName());
                info.setVCNSessionId(vcnSessionId);
                sessionMgr.saveSDKSession(esdkSessionId, info);
                
                ThreadLocalHolder.set(mc);
            }
            else if (CommonConstant.UserModule.IVS_SMU_USER_SESSION_INVALID == result.getErrCode())
            {
                result =
                    DeviceServiceProxy.getInstance().getDeviceServiceProxy(ICommonCapability.class).login(loginInfo);
                if (0 == result.getErrCode()
                    || CommonConstant.UserModule.IVS_SMU_USER_FIRST_LOGIN == result.getErrCode()
                    || CommonConstant.UserModule.IVS_SMU_USER_PWD_NEED_MOD == result.getErrCode())
                {
                    
                    info.setUserName(loginInfo.getUserName());
                    info.setVCNSessionId(result.getResult());
                    sessionMgr.saveSDKSession(esdkSessionId, info);
                    
                    if (null != esdkSessionidList && !esdkSessionidList.isEmpty())
                    {
                        for (String esdkSessionTemp : esdkSessionidList)
                        {
                            sessionMgr.getSDKSession(esdkSessionTemp).setVCNSessionId(result.getResult());
                        }
                    }
                    
                    ThreadLocalHolder.set(mc);
                }
                else
                {
                    if (null != esdkSessionidList && !esdkSessionidList.isEmpty())
                    {
                        for (String esdkSessionTemp : esdkSessionidList)
                        {
                            sessionMgr.removeSDKSession(esdkSessionTemp);
                        }
                    }
                    sessionMgr.removeSDKSession(esdkSessionId);
                }
            }
            else
            {
                // RM需求。同一帐号多点登录，有一处登录失败，原有逻辑会将其他几处的Session也会删除，需要保留
                // if (null != esdkSessionidList && !esdkSessionidList.isEmpty())
                // {
                //     for (String esdkSessionTemp : esdkSessionidList)
                //     {
                //         sessionMgr.removeSDKSession(esdkSessionTemp);
                //     }
                // }

                sessionMgr.removeSDKSession(esdkSessionId);
            }
            return result;
        }
        
        result = DeviceServiceProxy.getInstance().getDeviceServiceProxy(ICommonCapability.class).login(loginInfo);
        
        if (0 == result.getErrCode() || CommonConstant.UserModule.IVS_SMU_USER_FIRST_LOGIN == result.getErrCode()
            || CommonConstant.UserModule.IVS_SMU_USER_PWD_NEED_MOD == result.getErrCode())
        {
            
            info.setUserName(loginInfo.getUserName());
            info.setVCNSessionId(result.getResult());
            sessionMgr.saveSDKSession(esdkSessionId, info);
            
            ThreadLocalHolder.set(mc);
        }
        return result;
    }
    
    /** 
     * 用户注销
     * @return
     * @see [类、类#方法、类#成员]
     * @exception  SDKException  SDK异常
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode logout()
        throws SDKException
    {
        int ivsSessionId = SessionManager.getInstance().isUserRepeatedOnline();
        if (0 > ivsSessionId)
        {
            SDKErrorCode result = new SDKErrorCode();
            result.setErrCode(0);
            return result;
        }
        return DeviceServiceProxy.getInstance().getDeviceServiceProxy(ICommonCapability.class).logout(ivsSessionId);
    }
    
}
