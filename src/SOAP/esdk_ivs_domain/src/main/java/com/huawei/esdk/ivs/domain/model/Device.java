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
package com.huawei.esdk.ivs.domain.model;

import java.util.List;

import com.huawei.esdk.ivs.device.vcn3000.devicemanager.IDeviceMgrCability;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBasicInfo;
import com.huawei.esdk.ivs.domain.model.bean.DeviceChannelConfig;
import com.huawei.esdk.ivs.domain.model.bean.DeviceCode;
import com.huawei.esdk.ivs.domain.model.bean.DeviceGroupInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperInfo;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.DomainRouteList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.util.DeviceServiceProxy;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 
 * 设备领域模型
 * 
 * @author  zWX144115
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Device
{
    // 主设备操作信息
    private DeviceOperInfo deviceOperInfo;
    
    // 设备批量操作结果列表
    private DeviceOperResultList deviceOperResultList;
    
    // 通用设备信息
    private DeviceBasicInfo deviceBasicInfo;
    
    // 设备通道信息
    private DeviceChannelConfig deviceChannelConfig;
    
    //设备序号
    private int sequence;
    
    private String reserve;
    
    //重启设备
    public SDKErrorCode rebootDevice(String deviceCode, int rebootType)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return deviceMgrCability.rebootDevice(deviceCode, rebootType);
    }
    
    //开始搜索设备
    public SDKErrorCode startSearchDevice(String domainCode, String searchInfo)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return deviceMgrCability.startSearchDevice(domainCode, searchInfo);
    }
    
    //停止搜索设备
    public SDKErrorCode stopSearchDevice(String domainCode, String searchInfo)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return deviceMgrCability.stopSearchDevice(domainCode, searchInfo);
    }
    
    //验证前端设备
    public SDKResult<String> verifyDevice(String domainCode, String verfyInfo)
        throws SDKException
    {
        
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return deviceMgrCability.verifyDevice(domainCode, verfyInfo);
    }
    
    //修改主设备名称
    public SDKErrorCode setMainDeviceName(String deviceCode, String deviceNewName)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return deviceMgrCability.setMainDeviceName(deviceCode, deviceNewName);
    }
    
    //修改摄像头名称
    public SDKErrorCode setCameraName(String cameraCode, String cameraNewName)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return deviceMgrCability.setCameraName(cameraCode, cameraNewName);
    }
    
    //添加设备
    public SDKResult<DeviceOperResultList> addDevice(String deviceCode, int deviceNum, List<Device> deviceInfos)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return deviceMgrCability.addDevice(deviceCode, deviceNum, deviceInfos);
    }
    
    //设置设备参数
    public SDKErrorCode setDeviceConfig(String deviceCode, int configType, Object dataBuffer)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return deviceMgrCability.setDeviceConfig(deviceCode, configType, dataBuffer);
    }
    
    public SDKResult<Object> getDeviceList(int deviceType, IndexRange indexRange)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        
        return deviceMgrCability.getDeviceList(deviceType, indexRange);
    }
    
    public SDKResult<Object> queryDeviceList(int deviceType, QueryUnifiedFormat queryUnifiedFormat, String domainCode)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        
        return deviceMgrCability.queryDeviceList(deviceType, queryUnifiedFormat, domainCode);
    }
    
    /** 
    * 获取用户拥有权限的整个系统中的域路由信息
    *
    * @return
    * @throws SDKException
    * @attention <描述使用该函数时的注意事项，没有请写“无”>
    * @par <示例的作用和实现了那些功能点>
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [V100R003]
    */
    public SDKResult<DomainRouteList> getDomainRoute()
        throws SDKException
    {
        IDeviceMgrCability iDeviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        SDKResult<DomainRouteList> result = iDeviceMgrCability.getDomainRoute();
        return result;
    }
    
    /** 
    * 删除主设备
    *
    * @param domainCode
    * @param deviceNum
    * @param deviceCodeList
    * @return
    * @throws SDKException
    * @attention <无>
    * @par <示例的作用和实现了那些功能点>
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [V100R003]
    */
    public SDKResult<DeviceOperResultList> deleteDevice(String domainCode, int deviceNum,
        List<DeviceCode> deviceCodeList)
        throws SDKException
    {
        IDeviceMgrCability iDeviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return iDeviceMgrCability.deleteDevice(domainCode, deviceNum, deviceCodeList);
    }
    
    /** 
    * 查询摄像机码流能力
    *
    * @param capabilityType 设置类型
    * @param devCode 设备编码
    * @return
    * @throws SDKException
    * @attention <描述使用该函数时的注意事项，没有请写“无”>
    * @par <示例的作用和实现了那些功能点>
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [V100R003]
    */
    public SDKResult<String> getDeviceCapability(int capabilityType, String devCode)
        throws SDKException
    {
        IDeviceMgrCability iDeviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return iDeviceMgrCability.getDeviceCapability(capabilityType, devCode);
    }
    
    /** 
    * 获取设备参数
    * @param deviceCode 设备编码
    * @param configType 配置类型
    * @return
    * @throws SDKException SDK异常
    * @see [类、类#方法、类#成员]
    * @since eSDK IVS V100R003C00
    */
    public SDKResult<Object> getDeviceConfig(String deviceCode, int configType)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return deviceMgrCability.getDeviceConfig(deviceCode, configType);
    }
    
    /** 
     * 获取设备组列表
     * @param domainCode 设备组所属域编码
     * @param deviceGroupCode 设备组编码, 根设备组编码为0
     * @return  SDKResult<DeviceGroupInfos> 设备组列表
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public SDKResult<DeviceGroupInfos> getDeviceGroup(String domainCode, int deviceGroupCode)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IDeviceMgrCability.class)
            .getDeviceGroup(domainCode, deviceGroupCode);
    }
    
    public DeviceOperInfo getDeviceOperInfo()
    {
        return deviceOperInfo;
    }
    
    public void setDeviceOperInfo(DeviceOperInfo deviceOperInfo)
    {
        this.deviceOperInfo = deviceOperInfo;
    }
    
    public DeviceOperResultList getDeviceOperResultList()
    {
        return deviceOperResultList;
    }
    
    public void setDeviceOperResultList(DeviceOperResultList deviceOperResultList)
    {
        this.deviceOperResultList = deviceOperResultList;
    }
    
    public DeviceBasicInfo getDeviceBasicInfo()
    {
        return deviceBasicInfo;
    }
    
    public void setDeviceBasicInfo(DeviceBasicInfo deviceBasicInfo)
    {
        this.deviceBasicInfo = deviceBasicInfo;
    }
    
    public DeviceChannelConfig getDeviceChannelConfig()
    {
        return deviceChannelConfig;
    }
    
    public void setDeviceChannelConfig(DeviceChannelConfig deviceChannelConfig)
    {
        this.deviceChannelConfig = deviceChannelConfig;
    }
    
    public int getSequence()
    {
        return sequence;
    }
    
    public void setSequence(int sequence)
    {
        this.sequence = sequence;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }

    /**
     * @param cameraCode 摄像机编码
     * @param domainCode 域编码
     * @return 单台VCN的视频质量诊断计划xml
     * @throws SDKException
     */
    public SDKResult<String> getVideoDiagnose(String cameraCode, String domainCode)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return deviceMgrCability.getVideoDiagnose(domainCode, cameraCode);
    }
    
    /**
     * @param diagnoseXML 单台VCN的视频质量诊断计划xml
     * @return
     * @throws SDKException
     */
    public SDKErrorCode setVideoDiagnose(String diagnoseXML)
        throws SDKException
    {
        IDeviceMgrCability deviceMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IDeviceMgrCability.class);
        return deviceMgrCability.setVideoDiagnose(diagnoseXML);
    }
    
}
