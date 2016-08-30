package com.huawei.esdk.platform.nemgr;

import com.huawei.esdk.platform.nemgr.itf.IDevice;

public class DeviceClassInfo
{
    private String devType;
    
    private String verStart;
    
    private String verEnd;
    
    private Class<? extends IDevice> inst;
    
    public String getDevType()
    {
        return devType;
    }
    
    public void setDevType(String devType)
    {
        this.devType = devType;
    }
    
    public String getVerStart()
    {
        return verStart;
    }
    
    public void setVerStart(String verStart)
    {
        this.verStart = verStart;
    }
    
    public String getVerEnd()
    {
        return verEnd;
    }
    
    public void setVerEnd(String verEnd)
    {
        this.verEnd = verEnd;
    }
    
    public Class<? extends IDevice> getInst()
    {
        return inst;
    }
    
    public void setInst(Class<? extends IDevice> inst)
    {
        this.inst = inst;
    }
    
    public boolean isVersionSupported(DeviceInstance devInfo)
    {
        if (null != verStart && null != verEnd)
        {
            return verStart.compareToIgnoreCase(devInfo.getDeviceVersion()) <= 0
                && (verEnd.isEmpty() || verEnd.compareToIgnoreCase(devInfo.getDeviceVersion()) > 0);
        }
        else
        {
            return true;
        }
    }
}