/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.platform.professional.local.impl.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public abstract class PropertiesUtils {
    
    private static final Logger logger = Logger
        .getLogger(PropertiesUtils.class);

	private static Properties properties = null;

	static {
		properties = loadProperty();
	}

    private static Properties loadProperty()
    {
        Properties p = new Properties();
        loadProp("esdk_ivs_config.properties", p);
        loadProp("ivs_professional_url.properties",p);
        loadProp("platform_professional_url.properties", p);
        
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
            logger.error( "Exception happened in loadProp() " + conf , e);
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
                    logger.error( "Exception happened in loadProperty()" + conf , e);
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
}
