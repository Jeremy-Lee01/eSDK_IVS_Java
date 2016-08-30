package com.huawei.esdk.platform.config.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.bean.config.AppMappingConfig;
import com.huawei.esdk.platform.common.utils.AES128System;
import com.huawei.esdk.platform.common.utils.Base64Utils;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.config.dao.AppMappingDAO;
import com.huawei.esdk.platform.config.dao.itf.IAppMappingDAO;
import com.huawei.esdk.platform.config.service.itf.IAppMappingConfigService;

/**
 * 设备和eSDK用户的一一映射
 * @author sWX198756
 * @since  eSDK Platform V100R003C10
 */
public final class AppMappingConfigService extends BaseService implements IAppMappingConfigService
{
    private static final Logger LOGGER = Logger.getLogger(AppMappingConfigService.class);
    
    private static IAppMappingConfigService instance = new AppMappingConfigService();
    
    private IAppMappingDAO appMappingDAO;
    
    public static IAppMappingConfigService getInstance()
    {
        return instance;
    }
    
    public AppMappingConfigService()
    {
        try
        {
            String file = getFilePath("app_device_app_mapping.xml");
            
            appMappingDAO = new AppMappingDAO(file);
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
        }
    }
    
    @Override
    public boolean addAppMapping(AppMappingConfig appMapping)
    {
        try
        {
            appMapping.setDeviceAppPwd(Base64Utils.encode(AES128System.encryptPwdByNewKey((appMapping.getDeviceApp() + appMapping.getDeviceAppPwd()).getBytes("UTF-8"))));
            boolean result = appMappingDAO.addAppMapping(appMapping);
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
    public boolean updateAppMapping(AppMappingConfig appMapping)
    {
        try
        {
            appMapping.setDeviceAppPwd(Base64Utils.encode(AES128System.encryptPwdByNewKey((appMapping.getDeviceApp() + appMapping.getDeviceAppPwd()).getBytes("UTF-8"))));
            boolean result = appMappingDAO.updateAppMapping(appMapping);
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
    public boolean deleteAppMapping(String deviceId, String esdkApp)
    {
        boolean result = appMappingDAO.deleteAppMapping(deviceId, esdkApp);
        if (result)
        {
            notifyObservers();
        }
        
        return result;
    }
    
    @Override
    public AppMappingConfig getAppMappingByESDKApp(String esdkApp)
    {
        return appMappingDAO.getAppMappingByESDKApp(esdkApp);
    }
    
    @Override
    public List<AppMappingConfig> getAllAppMappings()
    {
        List<AppMappingConfig> result = appMappingDAO.getAllAppMappings();
        if (null != result && !result.isEmpty())
        {
            for (AppMappingConfig item : result)
            {
                if (null != item && !StringUtils.isEmpty(item.getDeviceAppPwd()))
                {
                    item.setDeviceAppPwd(AES128System.decryptPwdByOldKey(item.getDeviceApp(), item.getDeviceAppPwd()));
                }
            }
        }
        return result;
    }
}
