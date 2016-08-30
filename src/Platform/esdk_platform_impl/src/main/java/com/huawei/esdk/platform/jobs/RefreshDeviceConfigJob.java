package com.huawei.esdk.platform.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class RefreshDeviceConfigJob extends QuartzJobBean
{
    private IDeviceManager deviceManager;
    
    @Override
    protected void executeInternal(JobExecutionContext arg0)
        throws JobExecutionException
    {
        deviceManager.refreshDevices();
    }
    
    public IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public void setDeviceManager(IDeviceManager deviceManager)
    {
        this.deviceManager = deviceManager;
    }
}
