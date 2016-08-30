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
package com.huawei.esdk.ivs.device.vcn3000.devicemanager;

import java.util.List;

import com.huawei.esdk.ivs.domain.model.Device;
import com.huawei.esdk.ivs.domain.model.bean.DeviceCode;
import com.huawei.esdk.ivs.domain.model.bean.DeviceGroupInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.DomainRouteList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

public interface IDeviceMgrCability
{
    /**
     * 
     * 重启设备
     *
     * @param deviceCode
     * @param rebootType
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since eSDK IVS V100R003C00
     */
    public SDKErrorCode rebootDevice(String deviceCode, int rebootType);
    
    /**
     * 
     * 启动搜索前端设备
     * 
     * @param searchInfo 设备搜索信息XML
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since eSDK IVS V100R003C00
     */
    public SDKErrorCode startSearchDevice(String domainCode, String searchInfo);
    
    /**
     * 
     * 停止搜索前端设备
     *
     * @param searchInfo 停止设备搜索信息XML
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @sincee SDK IVS V100R003C00
     */
    public SDKErrorCode stopSearchDevice(String domainCode, String searchInfo);
    
    /**
     * 
     * 验证前端设备
     *
     * @param verifyInfo 设备验证信息XML
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since eSDK IVS V100R003C00
     */
    public SDKResult<String> verifyDevice(String domainCode, String verifyInfo);
    
    /**
     * 
     * 增加设备
     *
     * @param domainCode 域编码
     * @param deviceNum 批量增加的设备数目
     * @param deviceInfos 设备信息
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since eSDK IVS V100R003C00
     */
    public SDKResult<DeviceOperResultList> addDevice(String domainCode, int deviceNum, List<Device> deviceInfos);
    
    /**
     * 
     * 删除主设备
     *
     * @param domainCode 域编码
     * @param deviceNum 批量删除的设备数目
     * @param deviceCodeList 设备编码列表
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since eSDK IVS V100R003C00
     */
    public SDKResult<DeviceOperResultList> deleteDevice(String domainCode, int deviceNum,
        List<DeviceCode> deviceCodeList);
    
    /**
     *  
     * 修改主设备名称
     *
     * @param deviceCode  设备编码
     * @param deviceNewName 设备新名称
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since eSDK IVS V100R003C00
     */
    public SDKErrorCode setMainDeviceName(String deviceCode, String deviceNewName);
    
    /**
     *  
     * 修改摄像机名称
     *
     * @param cameraCode  摄像机编码
     * @param cameraNewName 摄像机新名称
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since eSDK IVS V100R003C00
     */
    public SDKErrorCode setCameraName(String cameraCode, String cameraNewName);
    
    /**
     * 
     * 设置设备参数
     *
     * @param deviceCode 设备编码
     * @param configType 设置参数类型
     * @param dataBuffer 数据buffer
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since eSDK IVS V100R003C00
     */
    public SDKErrorCode setDeviceConfig(String deviceCode, int configType, Object dataBuffer);
    
    /**
     * 
     * 获取用户拥有权限的整个系统中的域路由信息
     *
     * @return 域路由信息
     * @attention <无>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since eSDK IVS V100R003C00
     */
    public SDKResult<DomainRouteList> getDomainRoute();
    
    /** 
    * 查询摄像机码流能力
    *
    * @param capabilityType 设置类型
    * @param devCode 设备编码
    * @return
    * @attention <无>
    * @par <示例的作用和实现了那些功能点>
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since eSDK IVS V100R003C00
    */
    public SDKResult<String> getDeviceCapability(int capabilityType, String devCode);
    
    public SDKResult<Object> getDeviceList(int deviceType, IndexRange indexRange);
    
    public SDKResult<Object> queryDeviceList(int deviceType, QueryUnifiedFormat queryUnifiedFormat, String domainCode);
    
    public SDKResult<Object> getDeviceConfig(String devCode, int configType);
    
    
    /** 
    * 获取设备组列表
    * @param domainCode 设备组所属域编码
    * @param deviceGroupCode 设备组编码, 根设备组编码为0
    * @return  SDKResult<DeviceGroupInfos> 设备组列表
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00]
    */
    public SDKResult<DeviceGroupInfos> getDeviceGroup(String domainCode, int deviceGroupCode);
    
    
    /** 
     * @param reqXml 单台VCN的视频质量诊断计划xml
     * @return 成功返回0，失败返回错误码
     */
    public SDKErrorCode setVideoDiagnose(String reqXml);
    
    /**
     * @param domainCode 域编码
     * @param cameraCode 摄像机编码
     * @return 单台VCN的视频质量诊断计划xml
     */
    public SDKResult<String> getVideoDiagnose(String domainCode, String cameraCode);
    
}
