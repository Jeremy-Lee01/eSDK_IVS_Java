package com.huawei.esdk.platform.nemgr.itf;

import java.util.Date;

import com.huawei.esdk.platform.common.exception.SDKException;

public interface IDeviceConnection
{
    /**
     * 获取连接附加信息
     * 
     * @param key
     * @return
     */
    Object getAdditionalData(String key);
    
    /**
     * 设置连接附加信息
     * 
     * @param key
     * @param data
     */
    void setAdditionalData(String key, Object data);
    
    /**
     * 获取设备服务代理的访问类
     * @param itfs 需要获取的接口类
     * 
     * @return
     * @throws SDKException 
     */
    Object getServiceProxy(Class<?>[] itfs)
        throws SDKException;
    
    /**
     * 进行设备心跳连接
     * 
     * @return 心跳调用失败则返回false
     */
    boolean doHeartbeat(String connId);
    
    /**
     * 初始化设备连接
     * @return 
     */
    boolean initConn(String connId);
    
    /**
     * 断开设备连接
     * @throws SDKException 
     */
    void destroyConn(String connId);
    
    /**
    * 保活次数
    * 
    * @return
    */
    int getKeepAliveTimes();
    
    /**
     * 保活需要的时间间隔
     * 
     * @return
     */
    int getKeepAlivePeriod();
    
    
     /** 
     * 保活定时任务开始时间
     * 
     * 由业务自行定义开始时间。默认为new Date()
     * @return
     */
    Date getStartTime();
    
    boolean isLocalAuth();
}
