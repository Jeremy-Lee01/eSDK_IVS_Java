package com.huawei.esdk.platform.config.service.itf;

import java.util.List;

import com.huawei.esdk.platform.common.bean.config.AppMappingConfig;


/**
 * 设备和eSDK用户的一一映射
 * @author sWX198756
 * @since  eSDK Platform V100R003C10
 */
public interface IAppMappingConfigService
{
    boolean addAppMapping(AppMappingConfig appMapping);
    
    boolean updateAppMapping(AppMappingConfig appMapping);
    
    boolean deleteAppMapping(String deviceId, String esdkApp);
    
    AppMappingConfig getAppMappingByESDKApp(String esdkApp);
    
    List<AppMappingConfig> getAllAppMappings();
    
    void registerObserver(IConfigObserver observer);
}
