package com.huawei.esdk.platform.nemgr.itf;

/**
 * 设备处理类注册接口
 * 
 * @author j00160659
 * 
 */
public interface IDeviceClassRegister
{
    /**
     * 注册某种设备类型的设备处理类
     * 
     * @param devType
     *            设备类型
     * @param devCls
     *            设备处理类
     * @return
     */
    boolean registerDeviceClass(String devType, Class<? extends IDevice> devCls);
    
    /**
     * 注册某种设备类型的设备处理类
     * 
     * @param devType
     *            设备类型
     * @param devCls
     *            设备处理类
     * @param verStart
     *            匹配的设备版本下限
     * @param verEnd
     *            匹配的设备版本上限，实际匹配为[verStart,verEnd)半开半闭区间内的版本
     * @return
     */
    boolean registerDeviceClass(String devType, Class<? extends IDevice> devCls, String verStart, String verEnd);
}
