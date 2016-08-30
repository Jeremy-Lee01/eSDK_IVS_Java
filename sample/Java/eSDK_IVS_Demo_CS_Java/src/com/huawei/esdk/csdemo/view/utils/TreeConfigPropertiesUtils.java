package com.huawei.esdk.csdemo.view.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class TreeConfigPropertiesUtils {
	private static final Logger LOGGER = Logger.getLogger(TreeConfigPropertiesUtils.class);

	private static Properties properties = null;

	private static List<String> keys = new ArrayList<String>();
	
	static {
		properties = loadProperty();
	}

	private static Properties loadProperty() {
		Properties p = new Properties();
		
		loadProp("tree_config.properties",p);

		return p;
	}
	
	private static void setKeys(InputStream is) throws IOException{
	    
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        
        String line = null;
        while(null != (line =bufferedReader.readLine()))
        {
            if(null != line && !("".equals(line)) && !("#".equals(String.valueOf(line.charAt(0)))))
            {
                if(line.indexOf("=") != -1){
                    keys.add(line.substring(0, line.indexOf("=")));
                }            
            }
            

        }
	}
	
    private static void loadProp(String conf, Properties p)
    {
        InputStream is = null;
        try
        {
            is = getInputStream(conf);
            if (null != is)
            {
                setKeys(is);

            }
            
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
	
	public static List<String[]> getAllValue() {
  
        List<String[]> result = new ArrayList<String[]>();
        for(String key : keys){
            String value = properties.getProperty(key);
            if(null != value)
            {
                result.add(new String[]{key, value});
            }
            
        }
        
        return result;
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