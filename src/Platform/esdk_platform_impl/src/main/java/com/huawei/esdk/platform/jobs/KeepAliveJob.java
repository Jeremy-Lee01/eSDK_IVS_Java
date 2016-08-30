package com.huawei.esdk.platform.jobs;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.huawei.esdk.platform.abnormalevent.itf.IAbnormalevent;
import com.huawei.esdk.platform.common.bean.abnormalevent.AbnormaleventBean;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.DeviceConnManager;
import com.huawei.esdk.platform.nemgr.DeviceInstance;
import com.huawei.esdk.platform.nemgr.DeviceManager;
import com.huawei.esdk.platform.nemgr.conn.DeviceReconnector;
import com.huawei.esdk.platform.nemgr.itf.IDeviceConnection;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager.DEV_CONN_MODE_TYPE;

/**
 * 保活的job类
 * 
 * @author t00212088
 * 
 */
public class KeepAliveJob extends QuartzJobBean
{
    private static final Logger LOGGER = Logger.getLogger(KeepAliveJob.class);
    
    private IDeviceConnection deviceConn;
    
    private DeviceConnManager conn;
    
    private DeviceReconnector reConn;
    
    private DeviceManager deviceManager;
    
    @Override
    protected void executeInternal(JobExecutionContext arg0)
        throws JobExecutionException
    {
        IAbnormalevent abnormaleventManager = ApplicationContextUtil.getBean("abnormaleventManager");
        // 先判断是不是需要长连接
        String deviceId = (String)deviceConn.getAdditionalData("deviceId");
        String connId = (String)deviceConn.getAdditionalData("connId");
        String deviceName = (String)deviceConn.getAdditionalData("deviceName");
        
        String exp = connId.substring(0, connId.length() / 2);
        StringBuilder repSb = new StringBuilder("");
        for (int i = 0; i < exp.length(); i++)
        {
            repSb.append("*");
        }
        LOGGER.info(deviceId + "_" + connId.replace(exp, repSb.toString()) + " begin to keep alive");
        
        DeviceInstance dev = deviceManager.getDeviceFromMap(deviceId);
        // 非长连接的连接判断上次调用时间距此次保活时间是否大于保活间隔，若是，则断开连接；反之，则进行保活
        if (null != dev && dev.getConnMode() == DEV_CONN_MODE_TYPE.NOT_CONNECT_AUTOMATIC)
        {
            Date date = (Date)deviceConn.getAdditionalData("lastTime");
            long period = new Date().getTime() - date.getTime();
            int seconds = deviceConn.getKeepAlivePeriod();
            // 长时间未使用，则断开连接
            if (period > Long.parseLong(String.valueOf(seconds)) * 1000)
            {
                // 从保活队列中移除
                conn.removeFromKeepAliveSchedule(deviceConn);
                // 从设备的session pool中移除
                dev.getDeviceItf().removeConnId(deviceId + "_" + connId);
                // 断开connection
                deviceConn.destroyConn(connId);
                // 置空connection
                deviceConn = null;
            }
            else
            {
                // 保活
                if (deviceConn.doHeartbeat(connId))
                {
                    deviceConn.setAdditionalData("failTime", 0);
                }
                else
                {
                    //保活失败记录断连异常  by taochunlong
                    AbnormaleventBean ebean = new AbnormaleventBean();
                    ebean.setObjName(deviceName);
                    ebean.setOccurrence(IAbnormalevent.FAIL_TO_CONNECT);
                    ebean.setOccurTime(new Date());
                    ebean.setExceptionMessage("");
                    abnormaleventManager.occurException(ebean.getObjName() + "_" + ebean.getOccurrence(), ebean);
                    
                    // 一次保活失败， 调用断开方法
                    conn.removeFromKeepAliveSchedule(deviceConn);
                    //  不需要重连，从connection pool中移除
                    dev.getDeviceItf().removeConnId(deviceId + "_" + connId);
                }
            }
        }
        else
        {
            if (deviceConn.doHeartbeat(connId))
            {
                deviceConn.setAdditionalData("failTime", 0);
            }
            else
            {
                // 如果保活失败次数达到上限，则判断设备已经断开连接
                deviceConn.setAdditionalData("failTime", (Integer)deviceConn.getAdditionalData("failTime") + 1);
                if ((Integer)deviceConn.getAdditionalData("failTime") == deviceConn.getKeepAliveTimes())
                {
                    //断开需要记录断开异常
                    AbnormaleventBean ebean = new AbnormaleventBean();
                    ebean.setObjName(deviceName);
                    ebean.setOccurrence(IAbnormalevent.FAIL_TO_CONNECT);
                    ebean.setOccurTime(new Date());
                    ebean.setExceptionMessage("");
                    abnormaleventManager.occurException(ebean.getObjName() + "_" + ebean.getOccurrence(), ebean);
                    
                    // 调用断开方法
                    conn.removeFromKeepAliveSchedule(deviceConn);
                    if (deviceConn.isLocalAuth())
                    {
                        reConn.addDevice(deviceConn);
                    }
                }
            }
        }
    }
    
    public IDeviceConnection getDeviceConn()
    {
        return deviceConn;
    }
    
    public void setDeviceConn(IDeviceConnection deviceConn)
    {
        this.deviceConn = deviceConn;
    }
    
    public DeviceConnManager getConn()
    {
        return conn;
    }
    
    public void setConn(DeviceConnManager conn)
    {
        this.conn = conn;
    }
    
    public DeviceReconnector getReConn()
    {
        return reConn;
    }
    
    public void setReConn(DeviceReconnector reConn)
    {
        this.reConn = reConn;
    }
    
    public DeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public void setDeviceManager(DeviceManager deviceManager)
    {
        this.deviceManager = deviceManager;
    }
}
