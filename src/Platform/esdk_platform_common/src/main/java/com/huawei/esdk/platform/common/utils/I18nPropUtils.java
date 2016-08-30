package com.huawei.esdk.platform.common.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public abstract class I18nPropUtils
{
    private static ResourceBundle bundle = ResourceBundle.getBundle("i18n/resources", Locale.getDefault());
    
    public static String getValue(String key)
    {
        return bundle.getString(key);
    }
    
    public static String getValue(String key, String[] parameters)
    {
        String value = bundle.getString(key);
        
        if (null == parameters)
        {
            return value;
        }
        
        for (int i = 0; i < parameters.length; i++)
        {
            value = value.replace("{" + i + "}", parameters[i] == null ? "" : parameters[i]);
        }
        
        return value;
    }    
}
