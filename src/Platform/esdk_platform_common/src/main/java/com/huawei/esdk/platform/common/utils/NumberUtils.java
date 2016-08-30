package com.huawei.esdk.platform.common.utils;

public abstract class NumberUtils
{
    public static boolean isNumber(String str)
    {
        if (StringUtils.isEmpty(str))
        {
            return false;
        }
        
        return str.matches("[+-]?\\d+");
    }
    
    public static int parseIntValue(String str)
    {
        try
        {
            return Integer.parseInt(str.trim());
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException("The value of " + str + " is not a number");
        }
    }
}
