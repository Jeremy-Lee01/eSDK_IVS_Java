package com.huawei.esdk.platform.common.bean.log;

import java.util.Date;

public class LogBean
{
    private String actionName;
    
    private String ip;
    
    private String port;
    
    private Date requestTime;
    
    private Date responseTime;
    
    private String resultCode;
    
    public String getActionName()
    {
        return actionName;
    }
    
    public void setActionName(String actionName)
    {
        this.actionName = actionName;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public String getPort()
    {
        return port;
    }
    
    public void setPort(String port)
    {
        this.port = port;
    }
    
    public Date getRequestTime()
    {
        return requestTime;
    }
    
    public void setRequestTime(Date requestTime)
    {
        this.requestTime = requestTime;
    }
    
    public Date getResponseTime()
    {
        return responseTime;
    }
    
    public void setResponseTime(Date responseTime)
    {
        this.responseTime = responseTime;
    }
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
}
