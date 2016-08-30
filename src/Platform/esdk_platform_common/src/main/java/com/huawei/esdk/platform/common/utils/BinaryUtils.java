package com.huawei.esdk.platform.common.utils;

public abstract class BinaryUtils
{
    public static String toBinaryString(int i)
    {
        return Integer.toBinaryString(i);
    }
    
    public static String toBinaryStringWithPadding(int i, int length)
    {
        String result = Integer.toBinaryString(i);
        return StringUtils.formatNumber(result, length, true, '0');
    }
    
    public static String toBinaryString(long l)
    {
        return Long.toBinaryString(l);
    }
    
    public static String toBinaryStringWithPadding(long l, int length)
    {
        String result = Long.toBinaryString(l);
        return StringUtils.formatNumber(result, length, true, '0');
    }
}
