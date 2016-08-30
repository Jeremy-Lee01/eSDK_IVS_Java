package com.huawei.esdk.platform.config;

import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.bean.config.AppMappingConfig;
import com.huawei.esdk.platform.common.bean.config.DeviceConfig;
import com.huawei.esdk.platform.common.bean.config.UserConfig;
import com.huawei.esdk.platform.common.config.ConfigManagerNoDecrypt;
import com.huawei.esdk.platform.common.config.ConfigManagerUpdate;
import com.huawei.esdk.platform.common.utils.AES128System;
import com.huawei.esdk.platform.config.service.AppMappingConfigService;
import com.huawei.esdk.platform.config.service.DeviceConfigService;
import com.huawei.esdk.platform.config.service.UserConfigService;
import com.huawei.esdk.platform.config.service.itf.IAppMappingConfigService;
import com.huawei.esdk.platform.config.service.itf.IDeviceConfigService;
import com.huawei.esdk.platform.config.service.itf.IUserConfigService;

public class SystemConfig
{
    private static final Logger LOGGER = Logger.getLogger(SystemConfig.class);
    
    static
    {
        // 加载系统密钥，更新系统密钥，更新xml配置文件
        LOGGER.info("Load SystemConfig");
        AES128System.init();
        if ("Y".equalsIgnoreCase(ConfigManagerNoDecrypt.getInstance().getValue("esdk.platform.web", "N"))
            && "N".equalsIgnoreCase(ConfigManagerNoDecrypt.getInstance().getValue("platform.config.tool", "N"))
            && "N".equalsIgnoreCase(ConfigManagerNoDecrypt.getInstance().getValue("platform.mgmt.srv", "N")))
        {
            // 更新devices.xml
            LOGGER.info("update devices.xml--->start");
            IDeviceConfigService deviceConfigService = DeviceConfigService.getInstance();
            List<DeviceConfig> devices = deviceConfigService.getAllDevices();
            if (null != devices)
            {
                LOGGER.info("update devices.xml; sizes: " + devices.size());
                for (DeviceConfig item : devices)
                {
                    deviceConfigService.updateDevice(item);
                }
            }
            LOGGER.info("update devices.xml--->end");
            
            // 更新users.xml
            LOGGER.info("update users.xml--->start");
            IUserConfigService userConfigService = UserConfigService.getInstance();
            List<UserConfig> users = userConfigService.getAllUsers();
            if (null != users)
            {
                LOGGER.info("update users.xml; sizes: " + users.size());
                for (UserConfig item : users)
                {
                    userConfigService.updateUser(item);
                }
            }
            LOGGER.info("update users.xml--->end");
            
            // 更新app_device_app_mapping.xml
            LOGGER.info("update app_device_app_mapping.xml--->start");
            IAppMappingConfigService appMappingService = AppMappingConfigService.getInstance();
            List<AppMappingConfig> mappings = appMappingService.getAllAppMappings();
            if (null != mappings)
            {
                LOGGER.info("update app_device_app_mapping.xml; size: " + mappings.size());
                for (AppMappingConfig item : mappings)
                {
                    appMappingService.updateAppMapping(item);
                }
            }
            LOGGER.info("update app_device_app_mapping.xml--->end");
            
            // 更新properties文件
            LOGGER.info("update *.properties--->start");
            updateProperties();
            LOGGER.info("update *.properties--->end");
            
            // 配置文件更新完后，覆盖旧key
            AES128System.balanceKey();
        }
    }
    
    public static void init()
    {
    }
    
    private static void updateProperties()
    {
        ConfigManagerUpdate.init();
    }
    
}
