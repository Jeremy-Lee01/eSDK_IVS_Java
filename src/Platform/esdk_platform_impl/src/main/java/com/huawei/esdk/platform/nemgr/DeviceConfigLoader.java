package com.huawei.esdk.platform.nemgr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.digester3.Digester;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.xml.sax.SAXException;

import com.huawei.esdk.platform.common.bean.config.DeviceConfig;
import com.huawei.esdk.platform.common.bean.nemgr.DeviceProxy;
import com.huawei.esdk.platform.nemgr.itf.IDevice;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager.DEV_CONN_MODE_TYPE;

public class DeviceConfigLoader
{
    private static final Logger LOGGER = Logger.getLogger(DeviceConfigLoader.class);
    
    private static List<DeviceProxy> proxys = new ArrayList<DeviceProxy>();
    
    @SuppressWarnings("unchecked")
    public static void loadDeviceProxys(DeviceFactory deviceFactory)
    {
        // 以下是解析device 注册代理配置文件并注册
        Digester digest = new Digester();
        digest.setValidating(false);
        digest.addObjectCreate("proxys", ArrayList.class);
        digest.addObjectCreate("proxys/deviceProxy", DeviceProxy.class);
        digest.addBeanPropertySetter("proxys/deviceProxy/className", "className");
        digest.addBeanPropertySetter("proxys/deviceProxy/deviceType", "deviceType");
        digest.addBeanPropertySetter("proxys/deviceProxy/startVersion", "startVersion");
        digest.addBeanPropertySetter("proxys/deviceProxy/endVersion", "endVersion");
        
        digest.addSetNext("proxys/deviceProxy", "add");
        try
        {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath*:META-INF/device-proxy-config/device_proxy*.xml");
            LOGGER.debug("##########################################" + resources.length);
            for (Resource resource : resources)
            {
                proxys.addAll((List<DeviceProxy>)digest.parse(resource.getURL()));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
        }
        catch (SAXException e)
        {
            LOGGER.error("", e);
        }
        
        if (!proxys.isEmpty())
        {
            // 遍历proxys，注册
            for (DeviceProxy proxy : proxys)
            {
                if (LOGGER.isDebugEnabled())
                {
                    LOGGER.debug(new StringBuilder("Load DeviceProxy:").append(" ")
                        .append(proxy.getDeviceType())
                        .append("|")
                        .append(proxy.getClassName())
                        .toString());
                }
                if (null != proxy.getClassName() && null != proxy.getDeviceType())
                {
                    try
                    {
                        boolean b =
                            deviceFactory.registerDeviceClass(proxy.getDeviceType(),
                                (Class<? extends IDevice>)Class.forName(proxy.getClassName()),
                                proxy.getStartVersion(),
                                proxy.getEndVersion());
                        if (LOGGER.isDebugEnabled())
                        {
                            LOGGER.debug(new StringBuffer("register to ").append(deviceFactory)
                                .append(" with type=")
                                .append(proxy.getDeviceType())
                                .append(" return ")
                                .append(b)
                                .toString());
                        }
                    }
                    catch (ClassNotFoundException e)
                    {
                        LOGGER.error(e.getMessage() + " not founded!");
                    }
                }
            }
        }
        else
        {
            LOGGER.warn("No deviceProxy found!");
        }
    }
    
    public static DeviceProxy getDeviceProxyConfig(String devType)
    {
        for (DeviceProxy item : proxys)
        {
            if (item.getDeviceType().equals(devType))
            {
                return item;
            }
        }
        LOGGER.warn("The devType[" + devType + "] cannot be found from configuration file");
        throw new IllegalArgumentException("The devType " + devType + " is invalid");
    }
    
    public static DeviceConfig deviceInstance2Device(DeviceInstance deviceInfo)
    {
        DeviceConfig device = new DeviceConfig();
        device.setDeviceId(deviceInfo.getDeviceId());
        device.setDeviceName(deviceInfo.getDeviceName());
        device.setDeviceType(deviceInfo.getDeviceType());
        device.setDeviceVersion(deviceInfo.getDeviceVersion());
        device.setLoginPwd(deviceInfo.getLoginPwd());
        device.setLoginUser(deviceInfo.getLoginUser());
        device.setServiceAccessPoint(deviceInfo.getServiceAccessPoint());
        DEV_CONN_MODE_TYPE type = deviceInfo.getConnMode();
        if (type.equals(DEV_CONN_MODE_TYPE.CONNECT_AUTOMATIC))
        {
            device.setConnMode("0");
        }
        else
        {
            device.setConnMode("1");
        }
        device.setReserver1(deviceInfo.getReserver1());
        device.setReserver2(deviceInfo.getReserver2());
        device.setAsDefault(deviceInfo.isAsDefault());
        return device;
    }
    
    public static Map<String, Object> deviceInstance2Map(DeviceInstance deviceInfo)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("deviceId", deviceInfo.getDeviceId());
        map.put("deviceType", deviceInfo.getDeviceType());
        map.put("deviceName", deviceInfo.getDeviceName());
        map.put("deviceVersion", deviceInfo.getDeviceVersion());
        map.put("password", deviceInfo.getLoginPwd());
        map.put("username", deviceInfo.getLoginUser());
        map.put("sap", deviceInfo.getServiceAccessPoint());
        DEV_CONN_MODE_TYPE type = deviceInfo.getConnMode();
        if (type.equals(DEV_CONN_MODE_TYPE.CONNECT_AUTOMATIC))
        {
            map.put("connMode", "auto_connect");
        }
        else
        {
            map.put("connMode", "not_auto_connect");
        }
        map.put("reserver1", deviceInfo.getReserver1());
        map.put("reserver2", deviceInfo.getReserver2());
        
        return map;
    }
}
