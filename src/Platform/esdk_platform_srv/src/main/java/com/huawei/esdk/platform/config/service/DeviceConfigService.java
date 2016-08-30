package com.huawei.esdk.platform.config.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.bean.config.DeviceConfig;
import com.huawei.esdk.platform.common.utils.AES128System;
import com.huawei.esdk.platform.common.utils.Base64Utils;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.config.dao.DeviceFileDAO;
import com.huawei.esdk.platform.config.dao.itf.IDeviceDAO;
import com.huawei.esdk.platform.config.service.itf.IDeviceConfigService;

public final class DeviceConfigService extends BaseService implements IDeviceConfigService
{
    private static final Logger LOGGER = Logger.getLogger(DeviceConfigService.class);
    
    private static IDeviceConfigService instance = new DeviceConfigService();
    
    private IDeviceDAO deviceDao;
    
    public static IDeviceConfigService getInstance()
    {
        return instance;
    }
    
    public DeviceConfigService()
    {
        try
        {
            String file = getFilePath("devices.xml");
            
            deviceDao = new DeviceFileDAO(file);
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
        }
    }
    
    @Override
    public boolean addDevice(DeviceConfig device)
    {
        try
        {
            device.setLoginPwd(Base64Utils.encode(AES128System.encryptPwdByNewKey((device.getLoginUser() + device.getLoginPwd()).getBytes("UTF-8"))));
            boolean result = deviceDao.addDevice(device);
            if (result)
            {
                notifyObservers();
            }
            
            return result;
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
            return false;
        }
    }
    
    @Override
    public boolean updateDevice(DeviceConfig device)
    {
        try
        {
            device.setLoginPwd(Base64Utils.encode(AES128System.encryptPwdByNewKey((device.getLoginUser() + device.getLoginPwd()).getBytes("UTF-8"))));
            boolean result = deviceDao.updateDevice(device);
            if (result)
            {
                notifyObservers();
            }
            
            return result;
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
            return false;
        }
    }
    
    @Override
    public boolean deleteDevice(String deviceId)
    {
        boolean result = deviceDao.deleteDevice(deviceId);
        if (result)
        {
            notifyObservers();
        }
        
        return result;
    }
    
    @Override
    public DeviceConfig getDeviceById(String deviceId)
    {
        return deviceDao.getDeviceById(deviceId);
    }
    
    @Override
    public List<DeviceConfig> getAllDevices()
    {
        List<DeviceConfig> result = deviceDao.getAllDevices();
        
        if (null != result && !result.isEmpty())
        {
            for (DeviceConfig deviceConfig : result)
            {
                if (null != deviceConfig && !StringUtils.isEmpty(deviceConfig.getLoginPwd()))
                {
                    deviceConfig.setLoginPwd(AES128System.decryptPwdByOldKey(deviceConfig.getLoginUser(), deviceConfig.getLoginPwd()));
                }
            }
        }
        
        return result;
    }
    
}
