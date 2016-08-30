package com.huawei.esdk.demo.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class PropertiesUtils
{
    
    private static Properties properties = null;
    
    static
    {
        properties = loadProperty();
    }
    
    private static Properties loadProperty()
    {
        Properties p = new Properties();
        try
        {
            p.load(getInputStream("esdk_ivs_config.properties"));
            if (p == null || p.isEmpty())
            {
                System.out.println("The property file cannot be load");
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception happened in loadProperty()" + e);
        }
        
        return p;
    }
    
    public static String getValue(String key)
    {
        if (properties.containsKey(key))
        {
            String value = properties.getProperty(key);
            if (isValue(value))
            {
                value = value.trim();
            }
            
            return value;
        }
        else
        {
            return "";
        }
    }
    
    public static boolean isBlank(String str)
    {
        if (str == null || str.isEmpty() || (str.trim()).isEmpty() || str.equals("") || str.trim().equals("")
            || str.equals("null") || str.trim().equals("null"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean isValue(String str)
    {
        return !isBlank(str);
    }
    
    private static InputStream getInputStream(String path)
        throws IOException
    {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        
        if (is == null)
        {
            throw new FileNotFoundException(path + " cannot be opened because it does not exist");
        }
        
        return is;
    }
}