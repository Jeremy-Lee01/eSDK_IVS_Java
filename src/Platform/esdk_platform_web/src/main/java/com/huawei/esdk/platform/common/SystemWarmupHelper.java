package com.huawei.esdk.platform.common;


import org.apache.log4j.Logger;

public class SystemWarmupHelper
{
    private static final Logger LOGGER = Logger.getLogger(SystemWarmupHelper.class);
    
    public void init()
    {
        LOGGER.debug("SystemWarmupHelper.init() is called");
        //Put the code here which need to be executed when system is starting up
    }
}
