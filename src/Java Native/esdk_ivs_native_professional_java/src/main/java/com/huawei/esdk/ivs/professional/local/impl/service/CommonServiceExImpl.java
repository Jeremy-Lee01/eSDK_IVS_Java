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
package com.huawei.esdk.ivs.professional.local.impl.service;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.professional.local.constant.NativeConstant;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalCommon;
import com.huawei.esdk.ivs.professional.local.impl.utils.AES128Utils;
import com.huawei.esdk.ivs.professional.local.impl.utils.Base64Utils;
import com.huawei.esdk.ivs.professional.local.impl.utils.ClientProvider;
import com.huawei.esdk.ivs.professional.local.impl.utils.Encrypt;
import com.huawei.esdk.ivs.professional.local.impl.utils.ExceptionUtils;
import com.huawei.esdk.ivs.professional.local.impl.utils.StringUtils;
import com.huawei.esdk.ivs.professional.local.service.common.CommonServiceEx;
import com.huawei.esdk.platform.professional.local.PlatformServiceFactoryEx;
import com.huawei.esdk.platform.professional.local.bean.SDKResponse;
import com.huawei.esdk.platform.professional.local.constant.PlatformNativeConstant;
import com.huawei.esdk.platform.professional.local.impl.utils.RSA2048Utils;
import com.huawei.esdk.platform.professional.local.service.common.PlatformKeyServiceEx;

public class CommonServiceExImpl implements CommonServiceEx
{
    private static final Logger LOGGER = Logger.getLogger(CommonServiceExImpl.class);
    
    private IVSProfessionalCommon ivsProfessionalCommon =
        (IVSProfessionalCommon)ClientProvider.getClient(IVSProfessionalCommon.class);
    
    private PlatformKeyServiceEx keyServiceEx = PlatformServiceFactoryEx.getService(PlatformKeyServiceEx.class);
    
    private static CommonServiceExImpl instance = null;
    
    public static synchronized CommonServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new CommonServiceExImpl();
        }
        return instance;
    }
    
    @Override
    public Integer login(String userName, String pwd)
    {
        LOGGER.info("begin to execute getPublicKey method");
        SDKResponse<String> key = keyServiceEx.getPublicKey("RSA2048");
        if (null == key || 0 != key.getResultCode())
        {
            LOGGER.info("failed to get publicKey");
            return PlatformNativeConstant.FAILED_TO_GET_PUTLIC_KEY;
        }
        LOGGER.info("execute getPublicKey method completed");
        
        Integer setSecretKeyResultCode = setSecretKey();
        if (null == setSecretKeyResultCode || 0 != setSecretKeyResultCode)
        {
            return PlatformNativeConstant.FAILED_TO_SET_SECRET_KEY;
        }
        
        LOGGER.info("begin to execute login method");
        
        if (StringUtils.isNullOrEmpty(pwd))
        {
            LOGGER.info("execute login method completed");
            return NativeConstant.SDK_PARAM_NOT_COMPLETE_ERRORCODE;
        }
        
        String encodePwd = null;
        try
        {
            // 加密方式向下兼容
            encodePwd = Encrypt.getEncryptPwd(pwd);
            
            if (StringUtils.isNullOrEmpty(encodePwd))
            {
                return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
            }
        }
        catch (Exception e1)
        {
            LOGGER.debug("encode password error");
            return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
        }
        
        try
        {
            Integer errorCode = ivsProfessionalCommon.login(userName, encodePwd);
            
            LOGGER.info("execute login method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("login method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
        
    }
    
    @Override
    public Integer logout()
    {
        LOGGER.info("begin to execute logout method");
        
        try
        {
            Integer errorCode = ivsProfessionalCommon.logout();
            LOGGER.info("execute logout method completed");
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("logout method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public Integer keepAlive()
    {
        LOGGER.info("begin to execute keepAlive method");
        
        try
        {
            Integer errorCode = ivsProfessionalCommon.keepAlive();
            
            LOGGER.info("execute keepAlive method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("keepAlive method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public IVSSDKResponse<String> getVersion()
    {
        LOGGER.info("begin to execute getVersion method");
        
        IVSSDKResponse<String> result = new IVSSDKResponse<String>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<String> version = new Holder<String>();
        
        try
        {
            ivsProfessionalCommon.getVersion(resultCode, version);
        }
        catch (Exception e)
        {
            LOGGER.error("getVersion method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(version.value);
        
        LOGGER.info("execute getVersion method completed");
        
        return result;
        
    }
    
    private Integer setSecretKey()
    {
        LOGGER.info("begin to execute setSecretKey method");
        byte[] secretKey = AES128Utils.getBT_KEY();
        byte[] iv = AES128Utils.getBT_IV();
        Integer resultCode = null;
        try
        {
            String secretKeyStr =
                Base64Utils.encode(RSA2048Utils.encode(AES128Utils.byte2Hex(secretKey).getBytes("UTF-8")));
            String ivStr = Base64Utils.encode(RSA2048Utils.encode(AES128Utils.byte2Hex(iv).getBytes("UTF-8")));
            
            resultCode = keyServiceEx.setSecretKey("AES128", secretKeyStr, ivStr);
        }
        catch (Exception e)
        {
            LOGGER.info("failed to setSecretKey");
            resultCode = PlatformNativeConstant.FAILED_TO_SET_SECRET_KEY;
        }
        LOGGER.info("execute setSecretKey method completed");
        return resultCode;
    }
}
