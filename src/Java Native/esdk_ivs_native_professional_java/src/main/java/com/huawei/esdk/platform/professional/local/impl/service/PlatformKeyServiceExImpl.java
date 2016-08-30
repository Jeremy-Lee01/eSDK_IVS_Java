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
package com.huawei.esdk.platform.professional.local.impl.service;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.professional.local.impl.utils.ExceptionUtils;
import com.huawei.esdk.platform.professional.local.bean.SDKResponse;
import com.huawei.esdk.platform.professional.local.impl.autogen.PlatformKeyMgr;
import com.huawei.esdk.platform.professional.local.impl.utils.ClientProvider;
import com.huawei.esdk.platform.professional.local.impl.utils.RSA2048Utils;
import com.huawei.esdk.platform.professional.local.service.common.PlatformKeyServiceEx;

public class PlatformKeyServiceExImpl implements PlatformKeyServiceEx
{
    private static final Logger LOGGER = Logger.getLogger(PlatformKeyServiceExImpl.class);
    
    private PlatformKeyMgr platformKeyMgr = (PlatformKeyMgr)ClientProvider.getClient(PlatformKeyMgr.class);
    
    private static PlatformKeyServiceExImpl instance = null;
    
    public static synchronized PlatformKeyServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new PlatformKeyServiceExImpl();
        }
        return instance;
    }
    
    @Override
    public SDKResponse<String> getPublicKey(String secretType)
    {
        LOGGER.debug("begin to execute getPublicKey method");
        
        SDKResponse<String> result = new SDKResponse<String>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<String> publicKey = new Holder<String>();
        
        try
        {
            platformKeyMgr.getPublicKey(secretType, resultCode, publicKey);
        }
        catch (Exception e)
        {
            LOGGER.error("getPublicKey method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(publicKey.value);
        
        LOGGER.debug("execute getPublicKey method completed");
        
        LOGGER.debug("begin to execute setPublicKey method");
        
        RSA2048Utils.setPublicKey(publicKey.value);
        
        LOGGER.debug("execute setPublicKey method completed");
        
        return result;
        
    }
    
    @Override
    public Integer setSecretKey(String secretType, String secretKey, String iv)
    {
        LOGGER.debug("begin to execute setSecretKey method");
        
        Integer resultCode = null;
        
        try
        {
            resultCode = platformKeyMgr.setSecretKey(secretType, secretKey, iv);
        }
        catch (Exception e)
        {
            LOGGER.error("setSecretKey method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
        
        LOGGER.debug("execute setSecretKey method completed");
        return resultCode;
    }
    
}
