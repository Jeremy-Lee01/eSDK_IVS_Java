package com.huawei.esdk.platform.log;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.bean.log.OperationLogBean;
import com.huawei.esdk.platform.log.itf.IOperationLog;

public class OperationLog implements IOperationLog
{
    private static final Logger LOGGER = Logger.getLogger(OperationLog.class);
    
    private static OperationLog instance = new OperationLog();
    
    private OperationLog()
    {
        
    }
    
    public static OperationLog getInstance()
    {
        return instance;
    }
    
    @Override
    public void debug(OperationLogBean logBean)
    {
        if (LOGGER.isDebugEnabled())
        {
            LOGGER.debug(buildLogMsg(logBean));
        }
    }

    @Override
    public void info(OperationLogBean logBean)
    {
        if (LOGGER.isInfoEnabled())
        {
            LOGGER.info(buildLogMsg(logBean));
        }
        
    }

    @Override
    public void warn(OperationLogBean logBean)
    {
        LOGGER.warn(buildLogMsg(logBean));
    }

    @Override
    public void error(OperationLogBean logBean)
    {
        LOGGER.debug(buildLogMsg(logBean));
        
    }
    
    private String buildLogMsg(OperationLogBean logBean)
    {
        StringBuilder sb = new StringBuilder();
        if (null != logBean)
        {
            sb.append(logBean.getModuleName()).append("|");
            sb.append(logBean.getUserId()).append("|");
            sb.append(logBean.getClientFlag()).append("|");
            sb.append(logBean.getResultCode()).append("|");
            sb.append(logBean.getKeyInfo());
        }
        
        return sb.toString();
    }
}
