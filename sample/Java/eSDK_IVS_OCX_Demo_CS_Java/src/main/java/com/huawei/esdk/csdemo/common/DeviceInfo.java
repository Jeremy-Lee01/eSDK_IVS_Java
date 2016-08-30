package com.huawei.esdk.csdemo.common;

public class DeviceInfo
{
    private String code;
    
    private String name;
    
    private int type;
    
    private int status;
    
    private String deviceModelType;
    
    private String vendorType;
    
    private long handle = -1l;
    
    public DeviceInfo(String code, String name, int type, int status)
    {
        this.code = code;
        this.name = name;
        this.type = type;
        this.status = status;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public void setCode(String code)
    {
        this.code = code;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getType()
    {
        return type;
    }
    
    public void setType(int type)
    {
        this.type = type;
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public String getDeviceModelType()
    {
        return deviceModelType;
    }
    
    public void setDeviceModelType(String deviceModelType)
    {
        this.deviceModelType = deviceModelType;
    }
    
    public String getVendorType()
    {
        return vendorType;
    }
    
    public void setVendorType(String vendorType)
    {
        this.vendorType = vendorType;
    }

    public long getHandle()
    {
        return handle;
    }

    public void setHandle(long handle)
    {
        this.handle = handle;
    }
    
}
