package com.huawei.esdk.platform.common.bean.aa;

import java.util.Date;

public class UserLockInfo
{
    private String userId;
    
    private boolean isLocked;
    
    private int retryTimes;
    
    private Date lastRetryTime;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public boolean isLocked()
    {
        return isLocked;
    }
    
    public void setLocked(boolean isLocked)
    {
        this.isLocked = isLocked;
    }
    
    public int getRetryTimes()
    {
        return retryTimes;
    }
    
    public void setRetryTimes(int retryTimes)
    {
        this.retryTimes = retryTimes;
    }
    
    public Date getLastRetryTime()
    {
        return lastRetryTime;
    }
    
    public void setLastRetryTime(Date lastRetryTime)
    {
        this.lastRetryTime = lastRetryTime;
    }
}
