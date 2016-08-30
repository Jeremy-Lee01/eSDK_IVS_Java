package com.huawei.esdk.platform.nemgr.base;

import com.huawei.esdk.platform.nemgr.itf.IDevice;
import com.huawei.esdk.platform.nemgr.itf.IDeviceConnection;

/**
 * 设备适配基础类，应用可从这个类继承以减少非业务部分的工作
 * 
 * @author j00160659
 * 
 */
public abstract class SingleConnDeviceBase<CONNTYPE extends IDeviceConnection> implements IDevice
{
    private IDeviceConnection conn = null;
    
    private Integer refCount = 0;
    
    /**
     * 获取设备使用的业务协议类型
     * 
     * @return
     */
    public abstract String getProtocolType();
    
    public abstract boolean doHeartbeat(String coonId);
    
    @Override
    public IDeviceConnection getConnById(String key)
    {
        return conn;
    }
    
    @Override
    public synchronized void addId2ConnMap(String key, IDeviceConnection value)
    {
        this.conn = value;
        if (value == null)
        {
            refCount = 0;
        }
        else
        {
            ++refCount;
        }
    }
    
    @Override
    public synchronized boolean removeConnId(String key)
    {
        if (refCount > 0)
        {
            --refCount;
        }
        if (refCount == 0)
        {
            this.conn = null;
        }
        return true;
    }
}
