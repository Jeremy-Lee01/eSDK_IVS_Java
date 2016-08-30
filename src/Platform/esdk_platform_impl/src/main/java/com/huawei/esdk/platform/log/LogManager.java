package com.huawei.esdk.platform.log;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.base.BaseManager;
import com.huawei.esdk.platform.common.bean.log.LogBean;
import com.huawei.esdk.platform.log.itf.LogInterface;

public class LogManager extends BaseManager implements LogInterface
{
    private static final Logger LOGGER = Logger.getLogger(LogManager.class);

    private Map<String, LogBean> logMap = new HashMap<String, LogBean>();

    private void writeLog(LogBean bean)
    {
        String format="yyyyMMddHHmmss";
        SimpleDateFormat sdf=new SimpleDateFormat(format); 
        String logStr = bean.getActionName() + "," + bean.getIp() + ","
                + bean.getPort() + ","
                + sdf.format(bean.getRequestTime()) + ","
                + sdf.format(bean.getResponseTime()) + ","
                + bean.getResultCode();
        LOGGER.info(logStr);
    }

    @Override
    public void saveRequestLog(String messageId, LogBean log)
    {
        synchronized (logMap)
        {
            logMap.put(messageId, log);
        }
    }

    @Override
    public void saveResponseLog(String messageId, LogBean log)
    {
        LogBean bean;
        synchronized (logMap)
        {
            bean = logMap.get(messageId);
            if (null == bean)
            {
                return;
            }
            bean.setResponseTime(log.getResponseTime());
            bean.setResultCode(log.getResultCode());
            logMap.remove(messageId);
        }
        writeLog(bean);
    }

}
