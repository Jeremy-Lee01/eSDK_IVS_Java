package com.huawei.esdk.csdemo.common;

import java.io.Serializable;

public class SDKErrorCode implements Serializable
{
    
    private static final long serialVersionUID = -3029969913161060909L;
    
    private String errCodeAsString = "0";
    
    private String subSystem;
    
    private String description;
    
    public long getErrCode()
    {
        try
        {
            return new Long(errCodeAsString);
        }
        catch (NumberFormatException ex)
        {
            throw new IllegalArgumentException(errCodeAsString + " is invalid number.");
        }
    }
    
    public String getErrCodeStr()
    {
        return errCodeAsString;
    }
    
    public void setErrCode(String errCodeAsString)
    {
        this.errCodeAsString = errCodeAsString;
    }
    
    public void setErrCode(long errCode)
    {
        this.errCodeAsString = String.valueOf(errCode);
    }
    
    public void setErrCode(Integer errCode)
    {
        long lErrCode = (null == errCode ? -1 : Long.valueOf(errCode));
        this.errCodeAsString = String.valueOf(lErrCode);
    }
    
    public String getSubSystem()
    {
        return subSystem;
    }
    
    public void setSubSystem(String subSystem)
    {
        this.subSystem = subSystem;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
}
