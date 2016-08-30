package com.huawei.esdk.platform.common.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.huawei.esdk.platform.common.bean.config.ConfigFile;
import com.huawei.esdk.platform.common.bean.config.ConfigItem;
import com.huawei.esdk.platform.common.utils.AES128System;
import com.huawei.esdk.platform.common.utils.Base64Utils;
import com.huawei.esdk.platform.common.utils.StringUtils;

public final class ConfigManagerUpdate
{
    private static final Logger LOGGER = Logger.getLogger(ConfigManagerUpdate.class);
    
    private static final List<ConfigFile> CONFIG_FILES = new ArrayList<ConfigFile>(8);
    
    private static final Map<String, ConfigItem> CONFIG_ITEMS = new HashMap<String, ConfigItem>(64);
    
    private static List<String> sensitiveList = new ArrayList<String>();
    
    private static List<String> sensitiveCsv = new ArrayList<String>();
    
    static
    {
        try
        {
            loadConfigs();
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
        }
        getSensitives();
        updateProperties();
    }
    
    public static void init()
    {
        
    }
    
    private static void loadConfigs()
        throws Exception
    {
        loadConfig("classpath*:*properties");
        loadConfig("classpath*:META-INF/*.properties");
    }
    
    private static void loadConfig(String pattern)
        throws Exception
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
    
    private static void processConfigFile(Resource resource)
        throws IOException
    {
        String absPath = null;
        if (null != resource.getURL() && !resource.getURL().getFile().contains("jar!"))
        {
            absPath = resource.getFile().getAbsolutePath();
        }
        LOGGER.info("Loading configuration file " + resource.getFilename() + " from " + absPath + "|" + resource);
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        ConfigFile configFile = new ConfigFile();
        configFile.setFileName(resource.getFilename());
        configFile.setFilePath(absPath);
        configFile.setConfigList(parseConfigFile(props));
        CONFIG_FILES.add(configFile);
    }
    
    private static List<ConfigItem> parseConfigFile(Properties props)
    {
        List<ConfigItem> result = new ArrayList<ConfigItem>();
        if (null != props)
        {
            ConfigItem configItem;
            for (Entry<Object, Object> config : props.entrySet())
            {
                configItem = new ConfigItem();
                configItem.setKey((String)config.getKey());
                configItem.setValue(StringUtils.trim((String)config.getValue()));
                result.add(configItem);
                CONFIG_ITEMS.put((String)config.getKey(), configItem);
            }
        }
        
        return result;
    }
    
    private static List<ConfigFile> getConfigFiles()
    {
        return CONFIG_FILES;
    }
    
    private synchronized static void updateProperties()
    {
        List<ConfigFile> configFiles = getConfigFiles();
        if (null != configFiles && !configFiles.isEmpty())
        {
            List<String> fileLines = null;
            for (ConfigFile configFile : configFiles)
            {
                if (!StringUtils.isEmpty(configFile.getFilePath()))
                {
                    fileLines = readConfigFile(configFile.getFilePath());
                }
                
                List<ConfigItem> configList = configFile.getConfigList();
                boolean needUpdate = false;
                if (null != configList && !configList.isEmpty())
                {
                    for (ConfigItem configItem : configList)
                    {
                        if (null != configItem && !StringUtils.isEmpty(configItem.getKey()))
                        {
                            String value = configItem.getValue();
                            if (sensitiveList.contains(configItem.getKey()))
                            {
                                if (!StringUtils.isEmpty(value))
                                {
                                    value = AES128System.decryptPwdByOldKey("", value);
                                    try
                                    {
                                        value =
                                            Base64Utils.encode(AES128System.encryptPwdByNewKey(value.getBytes("UTF-8")));
                                    }
                                    catch (UnsupportedEncodingException e)
                                    {
                                        LOGGER.error("UnsupportedEncodingException: ", e);
                                        value = "";
                                    }
                                    
                                    if (null != fileLines && !fileLines.isEmpty())
                                    {
                                        for (int i = 0; i < fileLines.size(); i++)
                                        {
                                            String fileLine = fileLines.get(i);
                                            if (!StringUtils.isEmpty(fileLine) && !fileLine.startsWith("#"))
                                            {
                                                fileLine = fileLine.replaceAll(" ", "");
                                                if (fileLine.startsWith(configItem.getKey() + "="))
                                                {
                                                    fileLines.set(i, configItem.getKey() + "=" + value);
                                                    needUpdate = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else if (sensitiveCsv.contains(configItem.getKey()))
                            {
                                if (!StringUtils.isEmpty(value))
                                {
                                    String[] pwds = value.split(",");
                                    String valueTemp = "";
                                    for (int i = 0; i < pwds.length; i++)
                                    {
                                        String temp = AES128System.decryptPwdByOldKey("", pwds[i]);
                                        try
                                        {
                                            temp =
                                                Base64Utils.encode(AES128System.encryptPwdByNewKey(temp.getBytes("UTF-8")));
                                        }
                                        catch (UnsupportedEncodingException e)
                                        {
                                            LOGGER.error("UnsupportedEncodingException: ", e);
                                            temp = "";
                                        }
                                        
                                        valueTemp = valueTemp + "," + temp;
                                    }
                                    value = valueTemp.replaceFirst(",", "");
                                    
                                    if (null != fileLines && !fileLines.isEmpty())
                                    {
                                        for (int i = 0; i < fileLines.size(); i++)
                                        {
                                            String fileLine = fileLines.get(i);
                                            if (!StringUtils.isEmpty(fileLine) && !fileLine.startsWith("#"))
                                            {
                                                fileLine = fileLine.replaceAll(" ", "");
                                                if (fileLine.startsWith(configItem.getKey() + "="))
                                                {
                                                    fileLines.set(i, configItem.getKey() + "=" + value);
                                                    needUpdate = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (needUpdate)
                    {
                        if (!StringUtils.isEmpty(configFile.getFilePath()))
                        {
                            saveConfigFile(configFile.getFilePath(), fileLines);
                        }
                    }
                }
            }
        }
    }
    
    private static List<String> readConfigFile(String filePath)
    {
        LOGGER.info("ConfigManagerUpdate.readConfigFile(): " + filePath);
        List<String> fileLines = null;
        InputStream is = null;
        try
        {
            is = new FileInputStream(filePath);
            fileLines = IOUtils.readLines(is, "UTF-8");
        }
        catch (IOException e1)
        {
            LOGGER.error("ConfigManagerUpdate.readConfigFile() error", e1);
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
                    LOGGER.error("ConfigManagerUpdate.readConfigFile() error", e);
                }
            }
        }
        return fileLines;
    }
    
    private static void saveConfigFile(String filePath, List<String> fileLines)
    {
        LOGGER.info("ConfigManagerUpdate.saveConfigFile(): " + filePath);
        OutputStream out = null;
        try
        {
            out = new FileOutputStream(filePath);
            IOUtils.writeLines(fileLines, null, out, "UTF-8");
        }
        catch (IOException e)
        {
            LOGGER.error("ConfigManagerUpdate.saveConfigFile() error", e);
        }
        finally
        {
            if (null != out)
            {
                try
                {
                    out.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("ConfigManagerUpdate.saveConfigFile() error", e);
                }
            }
        }
    }
    
    private static void getSensitives()
    {
        String sensitive = ConfigManagerNoDecrypt.getInstance().getValue("platform.config.sensitive.words");
        if (!StringUtils.isEmpty(sensitive))
        {
            String[] sens = sensitive.split(",");
            sensitiveList.addAll(Arrays.asList(sens));
        }
        
        sensitive = ConfigManagerNoDecrypt.getInstance().getValue("platform.config.sensitive.wordcsv");
        if (!StringUtils.isEmpty(sensitive))
        {
            String[] sens = sensitive.split(",");
            sensitiveCsv.addAll(Arrays.asList(sens));
        }
        LOGGER.info("platform.config.sensitive.words: " + sensitive);
    }
}
