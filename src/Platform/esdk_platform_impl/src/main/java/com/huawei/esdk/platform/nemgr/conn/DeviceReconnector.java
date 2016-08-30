package com.huawei.esdk.platform.nemgr.conn;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.abnormalevent.itf.IAbnormalevent;
import com.huawei.esdk.platform.common.bean.abnormalevent.AbnormaleventBean;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.DeviceConnManager;
import com.huawei.esdk.platform.nemgr.DeviceFactory;
import com.huawei.esdk.platform.nemgr.conn.itf.IDeviceReconnector;
import com.huawei.esdk.platform.nemgr.itf.IDeviceConnection;

/**
 * 设备重连接
 * 
 * @author j00160659
 * 
 */
public class DeviceReconnector implements IDeviceReconnector
{
    private static final Logger LOGGER = Logger.getLogger(DeviceReconnector.class);
    
    private DeviceConnManager connMgr;
    
    private List<IDeviceConnection> connectingDeviceConns = new LinkedList<IDeviceConnection>();
    
    private DeviceFactory deviceFactory;
    
    IAbnormalevent abnormaleventManager = ApplicationContextUtil.getBean("abnormaleventManager");
    
    public void addDevice(IDeviceConnection conn)
    {
        synchronized (connectingDeviceConns)
        {
            connectingDeviceConns.add(conn);
        }
    }
    
    @Override
    public void removeDevice(IDeviceConnection conn)
    {
        
        synchronized (connectingDeviceConns)
        {
            for (int i = 0; i < connectingDeviceConns.size(); i++)
            {
                if (retrieveStrValueFromCon(connectingDeviceConns.get(i), "deviceId")
                    .equals(retrieveStrValueFromCon(conn, "deviceId"))
                    && retrieveStrValueFromCon(connectingDeviceConns.get(i), "connId")
                        .equals(retrieveStrValueFromCon(conn, "connId")))
                {
                    connectingDeviceConns.remove(i);
                    break;
                }
            }
        }
    }
    
    private String retrieveStrValueFromCon(IDeviceConnection conn, String valueKey)
    {
         String result = (String) conn.getAdditionalData(valueKey);
         if (null == result)
         {
             result = "";
         }
         return result;
    }
    
    private void reConnectDevice()
    {
        synchronized (connectingDeviceConns)
        {
            for (int i = 0; i < connectingDeviceConns.size(); i++)
            {
                String connId = (String)connectingDeviceConns.get(i).getAdditionalData("connId");
                
                String exp = connId.substring(0, connId.length() / 2);
                StringBuilder repSb = new StringBuilder("");
                for (int j = 0; j < exp.length(); j++)
                {
                    repSb.append("*");
                }
                
                LOGGER.info(connectingDeviceConns.get(i).getAdditionalData("deviceId") + "_"
                    + connId.replace(exp, repSb.toString()) + " will reconnect");
                IDeviceConnection conn = connectingDeviceConns.get(i);
                
                if (conn.initConn((String)conn.getAdditionalData("connId")))
                {
                    // 如果连接成功，则将此设备从待重连列表中剔除，且将其放入保活列表中
                    connectingDeviceConns.remove(i);
                    conn.setAdditionalData("failTime", 0);
                    connMgr.addToKeepAliveSchedule(conn);
                    
                    AbnormaleventBean ebean = new AbnormaleventBean();
                    ebean.setEndTime(new Date());
                    abnormaleventManager.endException(conn.getAdditionalData("deviceName") + "_"
                        + IAbnormalevent.FAIL_TO_CONNECT, ebean);
                }
            }
        }
    }
    
    public void run()
    {
        reConnectDevice();
    }
    
    public DeviceConnManager getConnMgr()
    {
        return connMgr;
    }
    
    public void setConnMgr(DeviceConnManager connMgr)
    {
        this.connMgr = connMgr;
    }
    
    public DeviceFactory getDeviceFactory()
    {
        return deviceFactory;
    }
    
    public void setDeviceFactory(DeviceFactory deviceFactory)
    {
        this.deviceFactory = deviceFactory;
    }
}
