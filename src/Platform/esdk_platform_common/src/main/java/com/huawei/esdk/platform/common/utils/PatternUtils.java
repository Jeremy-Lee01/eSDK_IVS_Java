package com.huawei.esdk.platform.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PatternUtils
{
    public static boolean isMatch(String string, Pattern pattern)
    {
        Matcher matcher = pattern.matcher(string);
        
        if (matcher.matches())
        {
            return true;
        }
        
        return false;
    }
}
