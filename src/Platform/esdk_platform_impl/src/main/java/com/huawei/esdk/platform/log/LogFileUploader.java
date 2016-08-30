package com.huawei.esdk.platform.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class LogFileUploader
{
    private static final Logger LOGGER = Logger.getLogger(LogFileUploader.class);
    
    private String logServerURL;
    
    private ExecutorService es = Executors.newFixedThreadPool(1);
    
    public void init()
    {
        logServerURL = ConfigManager.getInstance().getValue("log.server.url");
        if (StringUtils.isNotEmpty(logServerURL))
        {
            es.execute(new LogFileUploaderTask());
            LOGGER.info("The Log uploader thread started");
        }
    }
    
    public void destroy()
    {
        es.shutdownNow();
    }
}
