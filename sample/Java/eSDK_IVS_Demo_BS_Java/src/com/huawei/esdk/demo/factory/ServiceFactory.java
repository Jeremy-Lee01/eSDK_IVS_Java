package com.huawei.esdk.demo.factory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.huawei.esdk.ivs.professional.local.ServiceFactoryEx;
import com.huawei.esdk.ivs.professional.local.service.alarmmanager.AlarmManagerServiceEx;
import com.huawei.esdk.ivs.professional.local.service.common.CommonServiceEx;
import com.huawei.esdk.ivs.professional.local.service.devicemanager.DeviceManagerServiceEx;

/**
 * 业务工厂管理类
 * 
 * @author  xxxxxx
 * @see  [无]
 * @since  [eSDK IVS V100R003C00]
 */
public class ServiceFactory extends HttpServlet
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 4659959607228940247L;

    /**
     * 告警管理模块服务接口
     */
    private static AlarmManagerServiceEx alarmManagerServiceEx;
    
    /**
     * 设备管理模块服务接口
     */
    private static DeviceManagerServiceEx deviceManagerServiceEx;
    
    /**
     * 公用管理模块服务接口
     */
    private static CommonServiceEx commonServiceEx;
    
    /** 
     * 重写init方法 
     */
    public void init(ServletConfig config)
        throws ServletException
    {
        super.init(config);
        
        // 从native包中ServiceFactoryEx类中获取相应的服务
        commonServiceEx = ServiceFactoryEx.getService(CommonServiceEx.class);
        alarmManagerServiceEx = ServiceFactoryEx.getService(AlarmManagerServiceEx.class);
        deviceManagerServiceEx = ServiceFactoryEx.getService(DeviceManagerServiceEx.class);
    }
    
    public static AlarmManagerServiceEx getAlarmManagerServiceEx()
    {
        return alarmManagerServiceEx;
    }
    
    public static DeviceManagerServiceEx getDeviceManagerServiceEx()
    {
        return deviceManagerServiceEx;
    }
    
    public static CommonServiceEx getCommonServiceEx()
    {
        return commonServiceEx;
    }
}
