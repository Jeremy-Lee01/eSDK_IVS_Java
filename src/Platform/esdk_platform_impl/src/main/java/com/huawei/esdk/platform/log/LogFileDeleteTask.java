package com.huawei.esdk.platform.log;

import java.util.Date;

import org.apache.log4j.Logger;


public class LogFileDeleteTask
{
    private static final Logger LOGGER = Logger.getLogger(LogFileDeleteTask.class);
    public void work()
    {
        // quartz定时任务调度
        LOGGER.info("LogFileDeleteTask start at " + new Date().toString());
        LogFileUploaderHelper.deleteBackupFile();
    }
}
