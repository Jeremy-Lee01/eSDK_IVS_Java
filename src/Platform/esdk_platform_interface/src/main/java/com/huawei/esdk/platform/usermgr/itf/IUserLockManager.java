package com.huawei.esdk.platform.usermgr.itf;

import java.util.Date;

public interface IUserLockManager
{
    boolean lockUser(String userId);
    
    boolean unlockUser(String userId);
    
    boolean tryUnlockUser(String userId);
    
    boolean isUserLocked(String userId);
    
    int getRetryTimes(String userId);
    
    void increaseRetryTimes(String userId);
    
    void resetRetryTimes(String userId);
    
    void setRetryTime(String userId, Date date);
    
    boolean reachMaxRetryTimes(String userId);
}
