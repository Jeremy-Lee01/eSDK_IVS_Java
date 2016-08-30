package com.huawei.esdk.csdemo.util;

import java.io.UnsupportedEncodingException;

public class StringUtil
{
    
    public static boolean isEmpty(String value)
    {
        if(null == value)
        {
            return true;
        }
        
        return value.isEmpty();
    }
    
    /** 
     * 将字符串转换为系统编码格式的byte数组
     * 
     * @param 字符串
     * @return 字节数组
     * @see [类、类#方法、类#成员]
     */
    public static byte[] getNativeBytes(String value)
    {
        if (null == value)
        {
            return new byte[0];
        }
        
        try
        {
            return value.getBytes(System.getProperty("file.encoding"));
        }
        catch (UnsupportedEncodingException e)
        {
            return new byte[0];
        }
    }
    
    /** 
     * 将字符串转换为系统编码格式并且长度为length的byte数组
     * 
     * @param 字符串， 整形
     * @return 字节数组
     * @see [类、类#方法、类#成员]
     */
    public static byte[] getNativeBytes(String value, int length)
    {
        if (length < value.length())
        {
            value = value.substring(0, length);
        }
        return initBytesLength(getNativeBytes(value), length);
    }
    
    /** 
     * 将byte数组转换为长度为length的byte数组
     * 
     * @param 字节数组， 整形 
     * @return 字节数组
     * @see [类、类#方法、类#成员]
     */
    public static byte[] initBytesLength(byte[] value, int length)
    {
        byte[] res = new byte[length];
        System.arraycopy(value, 0, res, 0, value.length);
        return res;
    }
    
    public static byte[] trimByteArray(byte[] bytes)
    {
        byte[] result = null;
        if (null == bytes || 0 == bytes.length)
        {
            return result;
        }
        int length = 0;
        for (int i = bytes.length - 1; i >= 0; i--)
        {
            if (0 != bytes[i])
                break;
            length++;
        }
        result = new byte[bytes.length - length];
        
        System.arraycopy(bytes, 0, result, 0, result.length);
        return result;
    }
}
