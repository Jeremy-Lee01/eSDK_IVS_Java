package com.huawei.esdk.platform.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class SHA256Utils
{
    /**
     * 对字符串加密,加密算法使用MD5,SHA-1,SHA-256,默认使用SHA-256
     * 
     * @param strSrc 要加密的字符串
     * @param encName 加密类型
     * @return strDes 加密结果
     */
    public static String encrypt(String strSrc, String encName)
    {
        MessageDigest md = null;
        String strDes = null;

        try
        {
            byte[] bt = strSrc.getBytes("UTF-8");
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        }
        catch (NoSuchAlgorithmException e)
        {
            return null;
        }
        catch (UnsupportedEncodingException e)
        {
            return null;
        }
        return strDes.toUpperCase(Locale.getDefault());
    }

    public static String encrypt(String strSrc)
    {
        if (StringUtils.isEmpty(strSrc))
        {
            return strSrc;
        }
        return encrypt(strSrc, "SHA-256");
    }

    public static String bytes2Hex(byte[] bts)
    {
        StringBuilder desSb = new StringBuilder("");
        String tmp = null;
        for (int i = 0; i < bts.length; i++)
        {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1)
            {
                desSb.append("0");
            }
            desSb.append(tmp);
        }
        return desSb.toString();
    }
}
