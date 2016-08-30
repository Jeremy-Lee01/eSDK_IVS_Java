package com.huawei.esdk.platform.config.service.itf;

import com.huawei.esdk.platform.common.exception.SDKException;

public interface IEncryptService
{
    /**
     * 
     * 加密字符串，使用AES128算法
     *
     * @param content 需要加密的内容
     * @return 加密后的密文
     * @since eSDK Solutions Platform V100R003C00
     */
    String encryptContent(String content) throws SDKException;
    
    /**
     * 
     * 加密字符串
     *
     * @param content 需要加密的内容
     * @param algorithm 指定需要使用的加密算法
     * @return 加密后的密文
     * @since eSDK Solutions Platform V100R003C00
     */
    
    String encryptContent(String content, String algorithm) throws SDKException;;
}
