package com.huawei.esdk.platform.common.bean.config;

import java.util.List;

public class ConfigFile
{
    private String fileName;
    
    private String filePath;
    
    private List<ConfigItem> configList;
    
    public String getFileName()
    {
        return fileName;
    }
    
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    public String getFilePath()
    {
        return filePath;
    }
    
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }
    
    public List<ConfigItem> getConfigList()
    {
        return configList;
    }
    
    public void setConfigList(List<ConfigItem> configList)
    {
        this.configList = configList;
    }
}
