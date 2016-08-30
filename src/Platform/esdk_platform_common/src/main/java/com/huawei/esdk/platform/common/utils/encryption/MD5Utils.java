package com.huawei.esdk.platform.common.utils.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.utils.BytesUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;

public abstract class MD5Utils
{
    private static final Logger LOGGER = Logger.getLogger(MD5Utils.class);
    
    public static String do16BitMD5(String plainStr)
    {
        String result = do32BitMD5(plainStr);
        if (StringUtils.isNotEmpty(result) && result.length() >= 24)
        {
            result = result.substring(8, 24);
        }
        
        return result;
    }
    
    public static String do32BitMD5(String plainStr)
    {
        if (null == plainStr)
        {
            return plainStr;
        }
        
        String result;
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(BytesUtils.getBytes(plainStr));
            byte b[] = md.digest();
            int i;
            StringBuilder sb = new StringBuilder("");
            for (int index = 0; index < b.length; index++)
            {
                i = b[index];
                if (i < 0)
                {
                    i += 256;
                }
                if (i < 16)
                {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            result = sb.toString();            
        }
        catch (NoSuchAlgorithmException e)
        {
            LOGGER.error("", e);
            result = plainStr;
        }
        
        return result;
    }
}
