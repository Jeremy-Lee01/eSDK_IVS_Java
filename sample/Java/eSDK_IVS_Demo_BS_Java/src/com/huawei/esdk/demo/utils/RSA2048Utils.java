package com.huawei.esdk.demo.utils;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.professional.local.impl.utils.Base64Utils;

public class RSA2048Utils
{
    private static final Logger LOGGER = Logger.getLogger(RSA2048Utils.class);
    
    public static final String ALGORITHM = "RSA";
    
    private static String RSA_TRANSFORMATION = "RSA/ECB/OAEPWithSHA-512AndMGF1Padding";
    
    public static String key =
        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiXAQxbZ8B83glMxB454BVhx/Jl4UQB75qxEyVO/njnVS+keEqn+RZlXWfHQc+jmirZQUcESInmlSYkvnKiSAkYpH4VUjHj+h5A7zC+akAS8IYQC/nalHckGgyv+9AEi5vCEi+OOgRCJ4S3FtM/OS5qDOL9y93+TrLcUv/sF7NoglMwO0dVAnQPbWK9Km6uVk2JlfdqZF5Qf6TzFGQgmj54NWmEzQTNJPw6whi/IB7L1w8rnvLOPlY3UTWMvLXXqjmwk+xLZc82xxKaI1rCgh10b0kOHGw4XC6Jsx3y1s18q01kT5rgXCrOFj+eZvbyiWrcEJYXS951id0gtwE4/W/wIDAQAB";
    
    public static byte[] encode(byte[] data)
        throws Exception
    {
        // 对公钥解密
        byte[] keyBytes = Base64Utils.getFromBASE64(key);
        
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        
        // 对数据加密
        Cipher cipher = Cipher.getInstance(RSA_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        
        return cipher.doFinal(data);
    }
    
    public static byte[] decode(byte[] data)
        throws Exception
    {
        return data;
    }
    
    public static String decodeFromBase64(String password)
    {
        try
        {
            return new String(RSA2048Utils.decode(Base64Utils.getFromBASE64(password)), "UTF-8");
        }
        catch (Exception e)
        {
            LOGGER.error("password decode error", e);
            return "";
        }
    }
    
    public static void setPublicKey(String key)
    {
        RSA2048Utils.key = key;
    }
}
