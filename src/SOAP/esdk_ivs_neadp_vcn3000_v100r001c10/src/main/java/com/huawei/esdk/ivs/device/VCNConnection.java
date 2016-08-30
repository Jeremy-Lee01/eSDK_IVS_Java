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
package com.huawei.esdk.ivs.device;

import java.lang.reflect.Proxy;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.authorize.SessionManager;
import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.ivs.device.IVSDeviceConnectionBase;
import com.huawei.esdk.ivs.device.v100r001c10.common.convert.CommonCapabilityConvert;
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.huawei.esdk.ivs.domain.model.bean.IPInfo;
import com.huawei.esdk.ivs.domain.model.bean.LoginInfo;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.LoginInfoSouth;
import com.huawei.esdk.platform.authorize.itf.IAuthorize;
import com.huawei.esdk.platform.authorize.itf.IAuthorizePolicy;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.sun.jna.ptr.IntByReference;

public class VCNConnection extends IVSDeviceConnectionBase
{
    private static final Logger LOGGER = Logger.getLogger(VCNConnection.class);
    
    private VCNDevice device;
    
    private IAuthorizePolicy authorizePolicy;
    
    private IAuthorize authorize = ApplicationContextUtil.getBean("authorize");
    
    private CommonCapabilityConvert commonCapabilityConvert = ApplicationContextUtil.getBean("commonCapabilityConvert");
    
    private String sap;
    
    public String getSap()
    {
        return sap;
    }
    
    public void setSap(String sap)
    {
        this.sap = sap;
    }
    
    protected VCNConnection(String sap, VCNDevice device, String user, String pwd, IAuthorizePolicy authorizePolicy)
    {
        super(user, pwd);
        this.sap = sap;
        this.device = device;
        this.authorizePolicy = authorizePolicy;
    }
    
    @Override
    public Object getServiceProxy(Class<?>[] itfs)
        throws SDKException
    {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), itfs, device.getService(itfs));
    }
    
    @Override
    public boolean doHeartbeat(String connId)
    {
        return true;
    }
    
    @Override
    public boolean initConn(String connId)
    {
        LOGGER.debug("init connection start");
        boolean result;
        if (authorize.isLocalAuth("ivs"))
        {
            AccountInfo devAcctInfo = getDevAcctInfo(authorizePolicy);
            if (null == devAcctInfo)
            {
                LOGGER.error("Cannot derive account from the input user " + getLoginUser());
                return false;
            }
            result = doConnection(devAcctInfo.getUserId(), devAcctInfo.getPassword());
        }
        else
        {
            result = true;
        }
        LOGGER.debug("init connection end");
        
        return result;
    }
    
    private boolean doConnection(String userName, String password)
    {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUserName(userName);
        loginInfo.setPassword(password);
        IPInfo ip = new IPInfo();
        ip.setIp(sap.split(":")[0]);
        loginInfo.setServerIp(ip);
        loginInfo.setServerPort(Integer.valueOf(sap.split(":")[1]));
        
        LoginInfoSouth loginInfoSouth = commonCapabilityConvert.getLoginInfoModel2South(loginInfo);
        IntByReference ref = new IntByReference();
        
        int resultCode = BaseCability.getBaseCablilityJNA().IVS_SDK_Login(loginInfoSouth, ref);
        
        LOGGER.info("login result code: " + resultCode);
        
        ThreadLocalHolder.get().getEntities().put(InfoKeys.IVS_RESULT_CODE.toString(), resultCode);
        
        String sdkSession = (String)ThreadLocalHolder.get().getEntities().get(InfoKeys.SDK_SESSION_ID.toString());
        int sessionId = ref.getValue();
        if (0 == resultCode || CommonConstant.UserModule.IVS_SMU_USER_FIRST_LOGIN == resultCode
            || CommonConstant.UserModule.IVS_SMU_USER_PWD_NEED_MOD == resultCode)
        {
            SessionManager.getInstance().getSDKSession(sdkSession).setVCNSessionId(sessionId);
            return true;
        }
        
        return false;
    }
    
    @Override
    public void destroyConn(String connId)
    {
        LOGGER.debug("destroy connection start");
        if (!authorize.isLocalAuth("ivs"))
        {
            return;
        }
        MessageContext mc = ThreadLocalHolder.get();
        int ivsSessionId = -1;
        if (null != mc)
        {
            ivsSessionId = (Integer)mc.getEntities().get(InfoKeys.IVS_SESSION_ID.toString());
            LOGGER.debug("getIVSSessionId success");
        }
        int result = BaseCability.getBaseCablilityJNA().IVS_SDK_Logout(ivsSessionId);
        
        if (0 == result)
        {
            LOGGER.debug("destroy connection success");
        }
        else
        {
            LOGGER.error("destroy connection failed");
        }
        LOGGER.debug("destroy connection end");
    }
}
