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
package com.huawei.esdk.ivs.northcommu.cxf.professional;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.authorize.AuthenticateService;
import com.huawei.esdk.ivs.authorize.SessionManager;
import com.huawei.esdk.ivs.business.professional.callback.register.CallbackRegisterService;
import com.huawei.esdk.ivs.business.professional.commonmgr.CommonMgrService;
import com.huawei.esdk.ivs.common.CipherUtils;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.ivs.domain.model.bean.LoginInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetVersion;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetVersionResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IVSProfessionalCommon;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.KeepAlive;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.KeepAliveResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.Login;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.LoginResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.Logout;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.LogoutResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RegisterNotification;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RegisterNotificationResponse;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.listener.ISessionListener;
import com.huawei.esdk.platform.listener.ISessionListenerManager;

/**
 * 登陆访问
 * <p>
 * @author  sWX198756
 * @see  com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IVSProfessionalCommon
 * @since  eSDK IVS V100R003C00
 */
public class IVSProfessionalCommonImpl implements IVSProfessionalCommon
{    
    private CommonMgrService commonMgrService;
    
    private AuthenticateService authorizeService = null;
    
    private ISessionListener sessionListener;
    
    private ISessionListenerManager sessionListenerManager;
    
    private CallbackRegisterService callbackRegisterService;
    
    private static final Logger LOGGER = Logger.getLogger(IVSProfessionalCommonImpl.class);
    
    public void init()
    {
        sessionListenerManager.registerListner(sessionListener);
    }
    
    /**
     * 用户登录
     * @param parameters 登录信息 
     * @return LoginResponse 登录结果
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public LoginResponse login(Login parameters)
    {
        LoginResponse response = new LoginResponse();
        String sessionId = (String)ThreadLocalHolder.get().getEntities().get(InfoKeys.SDK_SESSION_ID.toString()); 
        
        if (null == parameters || StringUtils.isEmpty(parameters.getUserName())
            || StringUtils.isEmpty(parameters.getPassword()))
        {
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        String tempPwd = null;
        try
        {
            tempPwd = CipherUtils.decodeFromBase64(parameters.getPassword());
        }
        catch (SDKException e1)
        {
            LOGGER.error("loginRequest method error", e1);
            response.setResultCode((int)e1.getSdkErrCode());
            return response;
        }
        
        if (StringUtils.isEmpty(tempPwd))
        {
            response.setResultCode(ErrInfo.PWD_ERRORCODE);
            return response;
        }
        
        //保存Session信息
        String model = ConfigManager.getInstance().getValue("sensitive.information.transmission.mode",
            ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_AES128_CONSULTED);
        if (!ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_AES128_CONSULTED.equalsIgnoreCase(model))
        {
            if (!SessionManager.getInstance().saveSDKSession(sessionId))
            {
                response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
                return response;
            }
        }
        
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUserName(parameters.getUserName());
        loginInfo.setPassword(tempPwd);
        try
        {
            SDKErrorCode result = authorizeService.login(loginInfo);
            response.setResultCode((int)result.getErrCode());
        }
        catch(SDKException e)
        {
            LOGGER.error("loginRequest method error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("loginRequest method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /**
     * 用户注销
     * @return LogoutResponse 注销结果
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public LogoutResponse logout(Logout parameters)
    {
        LogoutResponse response = new LogoutResponse();
        try
        {
            if (null == parameters)
            {
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            SDKErrorCode result = authorizeService.logout();
            response.setResultCode((int)result.getErrCode());
        }
        catch(SDKException e)
        {
            LOGGER.error("loginRequest method error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    @Override
    public KeepAliveResponse keepAlive(KeepAlive parameters)
    {
        KeepAliveResponse response = new KeepAliveResponse();
        try
        {
            if (null == parameters)
            {
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            
            response.setResultCode(0);
        }
        catch (Exception e)
        {
            LOGGER.error("keepAlive method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /**
     * 注册回调事件
     * @param parameters 注册信息 
     * @return LoginResponse 注册结果
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public RegisterNotificationResponse registerNotification(RegisterNotification parameters)
    {
        RegisterNotificationResponse response = new RegisterNotificationResponse();
        SDKErrorCode result = null;
        try
        {
            result = callbackRegisterService.register(parameters.getWsUri());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("registerNotification method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("registerNotificationRequest error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    public AuthenticateService getAuthorizeService()
    {
        return authorizeService;
    }
    
    public ISessionListener getSessionListener()
    {
        return sessionListener;
    }
    
    public void setAuthorizeService(AuthenticateService authorizeService)
    {
        this.authorizeService = authorizeService;
    }
    
    public void setSessionListener(ISessionListener sessionListener)
    {
        this.sessionListener = sessionListener;
    }
    
    public ISessionListenerManager getSessionListenerManager()
    {
        return sessionListenerManager;
    }
    
    public void setSessionListenerManager(ISessionListenerManager sessionListenerManager)
    {
        this.sessionListenerManager = sessionListenerManager;
    }
    
    public void setCallbackRegisterService(CallbackRegisterService callbackRegisterService)
    {
        this.callbackRegisterService = callbackRegisterService;
    }
    
    public void setCommonMgrService(CommonMgrService commonMgrService)
    {
        this.commonMgrService = commonMgrService;
    }
    
    /** 
     * 获取SDK的版本号
     * @return 成功返回SDK版本号，高16位表示主版本号，低16位表示次版本号，失败返回负数错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public GetVersionResponse getVersion(GetVersion parameters)
    {
        GetVersionResponse response = new GetVersionResponse();
        SDKResult<String> result = null;
        try
        {
            result = commonMgrService.getVersion();
            response.setResultCode((int)result.getErrCode());
            if (0 <= result.getErrCode())
            {
                response.setVersion(result.getResult());
            }
        }
        catch (SDKException e)
        {
            LOGGER.error("getVersion method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getVersion method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
}
