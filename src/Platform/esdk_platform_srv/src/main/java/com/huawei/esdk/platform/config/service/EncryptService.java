package com.huawei.esdk.platform.config.service;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.AES128System;
import com.huawei.esdk.platform.common.utils.Base64Utils;
import com.huawei.esdk.platform.config.service.itf.IEncryptService;

public class EncryptService extends BaseService implements IEncryptService
{
    private static final Logger LOGGER = Logger.getLogger(EncryptService.class);
    
    private static EncryptService instance = new EncryptService();
    
    public static EncryptService getInstance()
    {
        return instance;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String encryptContent(String content)
        throws SDKException
    {
        if (null == content)
        {
            return content;
        }
        
        try
        {
            return Base64Utils.encode(AES128System.encryptPwdByNewKey(content.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
            throw new SDKException("Encryption error");
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String encryptContent(String content, String algorithm)
        throws SDKException
    {
        if ("AES128".equalsIgnoreCase(algorithm))
        {
            return encryptContent(content);
        }
        else
        {
            throw new IllegalArgumentException("Algorithm is not supported");
        }
    }
}
