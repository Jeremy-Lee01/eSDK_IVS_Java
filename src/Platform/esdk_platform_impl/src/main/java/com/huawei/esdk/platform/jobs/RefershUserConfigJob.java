package com.huawei.esdk.platform.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.huawei.esdk.platform.usermgr.itf.IUserManager;

public class RefershUserConfigJob extends QuartzJobBean
{
    private IUserManager userManager;
    
    @Override
    protected void executeInternal(JobExecutionContext arg0)
        throws JobExecutionException
    {
        userManager.refreshUsers();
    }
    
    public IUserManager getUserManager()
    {
        return userManager;
    }
    
    public void setUserManager(IUserManager userManager)
    {
        this.userManager = userManager;
    }
}