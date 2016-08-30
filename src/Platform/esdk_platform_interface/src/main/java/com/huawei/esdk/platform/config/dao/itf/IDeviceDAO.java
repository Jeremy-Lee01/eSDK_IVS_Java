package com.huawei.esdk.platform.config.dao.itf;

import java.util.List;

import com.huawei.esdk.platform.common.bean.config.DeviceConfig;

public interface IDeviceDAO
{
    boolean addDevice(DeviceConfig device);

    boolean updateDevice(DeviceConfig device);

    boolean deleteDevice(String deviceID);

    DeviceConfig getDeviceById(String deviceId);

    List<DeviceConfig> getAllDevices();
}
