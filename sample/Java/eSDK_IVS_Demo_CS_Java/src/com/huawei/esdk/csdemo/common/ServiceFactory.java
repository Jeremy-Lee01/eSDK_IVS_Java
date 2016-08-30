package com.huawei.esdk.csdemo.common;

import com.huawei.esdk.ivs.professional.local.ServiceFactoryEx;
import com.huawei.esdk.ivs.professional.local.service.alarmmanager.AlarmManagerServiceEx;
import com.huawei.esdk.ivs.professional.local.service.common.CommonServiceEx;
import com.huawei.esdk.ivs.professional.local.service.devicemanager.DeviceManagerServiceEx;

public class ServiceFactory {
    
    //native服务单例
	private static ServiceFactory instance;
	
	//公用管理模块服务接口
	private CommonServiceEx commonServiceEx;
	
	// 告警管理模块服务接口
	private AlarmManagerServiceEx alarmManagerServiceEx;

    // 设备管理模块服务接口
	private DeviceManagerServiceEx deviceManagerServiceEx;
	
	private ServiceFactory()
	{
	    // 从native包中ServiceFactoryEx类中获取相应的服务 
	    commonServiceEx = ServiceFactoryEx.getService(CommonServiceEx.class);
	    alarmManagerServiceEx = ServiceFactoryEx.getService(AlarmManagerServiceEx.class);
	    deviceManagerServiceEx = ServiceFactoryEx.getService(DeviceManagerServiceEx.class);
	}
	
	//获取native服务单例
	public static ServiceFactory getInstance()
	{
		if(null == instance)
		{
			instance = new ServiceFactory();
		}
		return instance;
	}

    public CommonServiceEx getCommonServiceEx()
    {
        return commonServiceEx;
    }

    public AlarmManagerServiceEx getAlarmManagerServiceEx()
    {
        return alarmManagerServiceEx;
    }

    public DeviceManagerServiceEx getDeviceManagerServiceEx()
    {
        return deviceManagerServiceEx;
    }
}
