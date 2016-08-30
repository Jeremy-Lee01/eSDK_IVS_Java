package com.huawei.esdk.csdemo.view.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class InternationalUtils {
	public static int languageFlag = 0;
	private static Properties properties_en = null;
	private static Properties properties_zh = null;
	
    private static final Logger LOGGER = Logger.getLogger(InternationalUtils.class);
	static {
	    properties_en = loadProperty_en();
	    properties_zh = loadProperty_zh();
	}

	private static Properties loadProperty_en() {
		Properties p = new Properties();
		
		loadProp("messageResource_en_US.properties",p);

		return p;
	}
	
    private static Properties loadProperty_zh() {
        Properties p = new Properties();
        
        loadProp("messageResource_zh_CN.properties",p);

        return p;
     }
	   
    private static void loadProp(String conf, Properties p)
    {
        InputStream is = null;
        try
        {
            is = getInputStream(conf);
            
            if (null != is)
            {
                p.load(is);
            }
        }
        catch (IOException e)
        {
            LOGGER.error( "Exception happened in loadProp() " + conf , e);
        }
        finally
        {
            if (null != is)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("Exception happened in loadProperty()" + conf , e);
                }
            }
        }
    }
	public static String getValue(String key) {
	    String value = null;
	    if (0 == languageFlag)
	    {
	        value = properties_zh.getProperty(key);
	    }
	    else if (1 == languageFlag)
	    {
	        value = properties_en.getProperty(key); 
	    }
	    
	    
		return null == value ? "" : value;
	}

	private static InputStream getInputStream(String path) throws IOException {
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(path);
		if (null == is) {
			throw new FileNotFoundException(path
					+ " cannot be opened because it does not exist");
		}
		return is;
	}
}