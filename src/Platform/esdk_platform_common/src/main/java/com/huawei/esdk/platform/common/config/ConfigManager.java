package com.huawei.esdk.platform.common.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.huawei.esdk.platform.common.bean.config.ConfigFile;
import com.huawei.esdk.platform.common.bean.config.ConfigItem;
import com.huawei.esdk.platform.common.utils.ESDKIOUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;

public final class ConfigManager
{
    private static final Logger LOGGER = Logger.getLogger(ConfigManager.class);
    
    private static final List<ConfigFile> CONFIG_FILES = new ArrayList<ConfigFile>(8);
    
    private static final Map<String, ConfigItem> CONFIG_ITEMS = new HashMap<String, ConfigItem>(64);
    
    private static ConfigManager instance = new ConfigManager();
    
    private ConfigManager()
    {
        ConfigManagerUpdate.init();
        
        try
        {
            loadConfigs();
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
        }
    }
    
    public static ConfigManager getInstance()
    {
        return instance;
    }
    
    private void loadConfigs()
        throws Exception
    {
    	loadConfig("classpath*:*properties");
    	loadConfig("classpath*:META-INF/*.properties");
    }
    
    private void loadConfig(String pattern)throws Exception
    {
    	ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(pattern);
        
        if (null != resources)
        {
            for (Resource item : resources)
            {
                processConfigFile(item);
            }
        }
    }
    
    private void processConfigFile(Resource resource)
        throws IOException
    {
    	String absPath = null;
    	if (null != resource.getURL() && !resource.getURL().getFile().contains("jar!"))
    	{
    		absPath = resource.getFile().getAbsolutePath();
    	}
        ConfigFile configFile = new ConfigFile();
        configFile.setFileName(resource.getFilename());
        configFile.setFilePath(absPath);
        configFile.setConfigList(parseConfigFile(resource, absPath));
        CONFIG_FILES.add(configFile);
    }
    
    private List<ConfigItem> parseConfigFile(Resource resource, String absPath) throws IOException
    {
        LOGGER.info("Loading configuration file " + resource.getFilename() + " from " + absPath + "|" + resource);
        InputStream is = null;
        List<String> lines = null;
        try
        {
            is = resource.getInputStream();
            lines = IOUtils.readLines(is, Charset.forName("UTF-8"));
        }
        finally
        {
            if (null != is)
            {
                ESDKIOUtils.closeInputStream(is);
            }
        }
        
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        
        List<ConfigItem> result = new ArrayList<ConfigItem>();
        if (null != lines)
        {
            ConfigItem configItem;
            String key;
            for (String line : lines)
            {
                if (StringUtils.isEmpty(line) || line.startsWith("#")
                    || !line.contains("="))
                {
                    continue;
                }
                key = getKeyFromLine(line);
                if (StringUtils.isEmpty(key) || !props.containsKey(key))
                {
                    continue;
                }
                configItem = new ConfigItem();
                configItem.setKey(key);
                configItem.setValue(StringUtils.trim((String)props.get(key)));
                result.add(configItem);
                CONFIG_ITEMS.put(key, configItem);
            }
        }
        
        return result;
    }
    
    private String getKeyFromLine(String line)
    {
        line = line.trim();
        int index = line.indexOf("=");
        if (index < 0)
        {
            return null;
        }
        
        return line.substring(0, index).trim();
    }
    
    public Map<String, ConfigItem> getAllConfigs()
    {
        return CONFIG_ITEMS;
    }
    
    public List<ConfigFile> getConfigFiles()
    {
        return CONFIG_FILES;
    }
    
    public String getValue(String key)
    {
        return getValue(key, null);
    }
    
    public String getPureValue(String key)
    {
        String fileName = null;
        for (ConfigFile item : CONFIG_FILES)
        {
            for (ConfigItem inItem : item.getConfigList())
            {
                if (inItem.getKey().equals(key))
                {
                    fileName = item.getFilePath();
                    break;
                }
            }
            
            if (null != fileName)
            {
                break;
            }
        }
        
        if (null != fileName)
        {
            InputStream is = null;
            try
            {
                is = new FileInputStream(fileName);
                List<String> contents = IOUtils.readLines(is);
                for (String line : contents)
                {
                    if (line.startsWith(key))
                    {
                        return line.split("=")[1];
                    }
                }
            }
            catch (FileNotFoundException e)
            {
                LOGGER.error("", e);
            }
            catch (IOException e)
            {
                LOGGER.error("", e);
            }
            finally
            {
                ESDKIOUtils.closeInputStream(is);
            }
        }
        
        return null;
    }
    
    public String getValue(String key, String defaultValue)
    {
        ConfigItem configItem = CONFIG_ITEMS.get(key);
        String result = null;
        if (null != configItem)
        {
            result = configItem.getValue();
        }
        else
        {
            LOGGER.warn("Cannot find the configuration key of " + key);
        }
        
        if (null == result)
        {
            result = defaultValue;
        }
        
        return result;
    }
}
