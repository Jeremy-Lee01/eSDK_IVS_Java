package com.huawei.esdk.platform.common.bean.rest;

public class ResHeaderBean
{
    private String resultCode;
    
    private String resultDesc = "";
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getResultDesc()
    {
        return resultDesc;
    }
    
    public void setResultDesc(String resultDesc)
    {
        this.resultDesc = resultDesc;
    }
    
}
