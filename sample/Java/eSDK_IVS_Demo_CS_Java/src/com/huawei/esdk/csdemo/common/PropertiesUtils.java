package com.huawei.esdk.csdemo.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;


public abstract class PropertiesUtils {
	private static final Logger LOGGER = Logger.getLogger(PropertiesUtils.class);

	private static Properties properties = null;

	private static Map<String,String> cache = new HashMap<String, String>();
	
	static {
		properties = loadProperty();
	}

	private static Properties loadProperty() {
		Properties p = new Properties();
		
		loadProp("user.properties",p);

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
            LOGGER.error("Exception happened in loadProp() " + conf , e);
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
		String value = properties.getProperty(key);

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
	
	public static String getHtmlFromTxt(String path)
	{
	    
	    
	    if(cache.containsKey(path))
	    {
	        return cache.get(path);
	    }
	    
	    StringBuffer sb = new StringBuffer();
	    
	    String s = new String(); 
	    
	    BufferedReader input = null;
	    try { 
	        
	        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(path);

	        input = new BufferedReader(new InputStreamReader(is, "UTF-8"));

    	    while((s = input.readLine())!=null){
    	        sb.append(s);
    	    } 
    
    	    input.close(); 
    
	    } catch (Exception e) { 
	        try
            {
                input.close();
            }
            catch (IOException e1)
            {
                LOGGER.error("Exception happened in getHtmlFromTxt", e1);
            }
	        LOGGER.error("Exception happened in getHtmlFromTxt", e);
	    } 
    	
	    String responseStr = sb.toString();
	    
	    cache.put(path, responseStr);
	    
	    return responseStr;
	 } 
}