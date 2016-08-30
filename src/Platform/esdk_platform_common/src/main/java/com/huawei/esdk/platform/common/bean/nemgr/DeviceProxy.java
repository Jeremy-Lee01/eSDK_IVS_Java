package com.huawei.esdk.platform.common.bean.nemgr;

public class DeviceProxy
{
    private String className;
    
    private String deviceType;
    
    private String startVersion;
    
    private String endVersion;
    
    public String getClassName()
    {
        return className;
    }
    
    public void setClassName(String className)
    {
        this.className = className;
    }
    
    public String getDeviceType()
    {
        return deviceType;
    }
    
    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }
    
    public String getStartVersion()
    {
        return startVersion;
    }
    
    public void setStartVersion(String startVersion)
    {
        this.startVersion = startVersion;
    }
    
    public String getEndVersion()
    {
        return endVersion;
    }
    
    public void setEndVersion(String endVersion)
    {
        this.endVersion = endVersion;
    }
}
