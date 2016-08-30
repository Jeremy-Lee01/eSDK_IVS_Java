package com.huawei.esdk.platform.common.bean.abnormalevent;

import java.io.Serializable;
import java.util.Date;

public class AbnormaleventBean implements Serializable
{
    /**
     * UID
     */
    private static final long serialVersionUID = 1L;
    
    private String objName;
    
    private String occurrence;
    
    private Date occurTime;
    
    private Date endTime;
    
    private String exceptionMessage;
    
    public String getObjName()
    {
        return objName;
    }
    
    public void setObjName(String objName)
    {
        this.objName = objName;
    }
    
    public String getOccurrence()
    {
        return occurrence;
    }
    
    public void setOccurrence(String occurrence)
    {
        this.occurrence = occurrence;
    }
    
    public Date getOccurTime()
    {
        return occurTime;
    }
    
    public void setOccurTime(Date occurTime)
    {
        this.occurTime = occurTime;
    }
    
    public Date getEndTime()
    {
        return endTime;
    }
    
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }
    
    public String getExceptionMessage()
    {
        return exceptionMessage;
    }
    
    public void setExceptionMessage(String exceptionMessage)
    {
        this.exceptionMessage = exceptionMessage;
    }
}
