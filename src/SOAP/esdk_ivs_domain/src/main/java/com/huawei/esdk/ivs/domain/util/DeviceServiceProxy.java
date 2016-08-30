/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.ivs.domain.util;

import java.util.List;

import com.huawei.esdk.platform.common.bean.config.DeviceConfig;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

/**
 * 南向设备连接管理类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK IVS V100R003C00]
 */
public final class DeviceServiceProxy
{
    /**
     * 设备管理接口
     */
    public static final IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    /**
     * 单例
     */
    public static final DeviceServiceProxy deviceServiceProxy = new DeviceServiceProxy();
    
    public static final String devID = ConfigManager.getInstance().getValue("esdk.ivs_vcn_device");
    
    private DeviceServiceProxy()
    {
        
    }
    
    public static DeviceServiceProxy getInstance()
    {
        return deviceServiceProxy;
    }
    
    public <T> T getDeviceServiceProxy(Class<T> clazz)
        throws SDKException
    {
        return deviceManager.getDeviceServiceProxy(devID, clazz);
    }
    
    public static String getDeviceServiceAccessPort()
    {
        List<DeviceConfig> devices = deviceManager.queryAllDeviceInfo();
        if (null != devices)
        {
            for (DeviceConfig device : devices)
            {
                if (null != device && null != device.getDeviceId() && devID.equals(device.getDeviceId().trim()))
                {
                    return device.getServiceAccessPoint();
                }
            }
        }
        return null;
    }
    
}
