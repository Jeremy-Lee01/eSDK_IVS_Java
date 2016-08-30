package com.huawei.esdk.platform.config.service.itf;

import java.util.List;

import com.huawei.esdk.platform.common.bean.config.DeviceConfig;

public interface IDeviceConfigService
{
    boolean addDevice(DeviceConfig device);
    
    boolean updateDevice(DeviceConfig device);
    
    boolean deleteDevice(String deviceId);
    
    DeviceConfig getDeviceById(String deviceId);
    
    List<DeviceConfig> getAllDevices();
    
    void registerObserver(IConfigObserver observer);
}
