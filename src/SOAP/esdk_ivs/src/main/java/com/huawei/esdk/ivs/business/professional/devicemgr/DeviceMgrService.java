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
package com.huawei.esdk.ivs.business.professional.devicemgr;

import java.util.List;

import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.Device;
import com.huawei.esdk.ivs.domain.model.bean.DeviceCode;
import com.huawei.esdk.ivs.domain.model.bean.DeviceGroupInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.DomainRouteList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 设备管理模块
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class DeviceMgrService
{
    /**
    * 设置主设备，子设备参数
     * @throws SDKException 
    */
    
     /** 
     * 设置主设备，子设备参数
     * @param deviceCode 设备编码
     * @param configType 设置类型
     * @param dataBuffer
     * @return SDK对象
     * @throws SDKException
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode setDeviceConfig(String deviceCode, int configType, Object dataBuffer) throws SDKException
    {
        SDKErrorCode result = new SDKErrorCode();
        if(null == dataBuffer)
        {
            result.setErrCode(ErrInfo.DATA_ERRORCODE);
            return result;
        }
        
        Device device = new Device();
        result = device.setDeviceConfig(deviceCode, configType, dataBuffer);
        return result;
    }
    
    public SDKErrorCode rebootDevice(String deviceCode, int rebootType)
        throws SDKException
    {
        Device device = new Device();
        SDKErrorCode result = device.rebootDevice(deviceCode, rebootType);
        return result;
    }
    
    public SDKErrorCode startSearchDevice(String domainCode, String searchInfo)
        throws SDKException
    {
        Device device = new Device();
        SDKErrorCode result = device.startSearchDevice(domainCode, searchInfo);
        return result;
    }
    
    public SDKErrorCode stopSearchDevice(String domainCode, String searchInfo)
        throws SDKException
    {
        Device device = new Device();
        SDKErrorCode result = device.stopSearchDevice(domainCode, searchInfo);
        return result;
    }
    
    public SDKResult<String> verifyDevice(String domainCode, String verifyInfo)
        throws SDKException
    {
        Device device = new Device();
        SDKResult<String> result = device.verifyDevice(domainCode, verifyInfo);
        return result;
    }
    
    public SDKErrorCode setMainDeviceName(String deviceCode, String deviceNewName)
        throws SDKException
    {
        Device device = new Device();
        SDKErrorCode result = device.setMainDeviceName(deviceCode, deviceNewName);
        return result;
    }
    
    public SDKResult<DeviceOperResultList> addDevice(String deviceCode, int deviceNum, List<Device> deviceInfos)
        throws SDKException
    {
        SDKResult<DeviceOperResultList> result = new  SDKResult<DeviceOperResultList>();
        if(null != deviceInfos)
        {
            if (deviceInfos.size() != deviceNum)
            {
                result.setErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
                return result;
            }
            
            Device device = new Device();
            result = device.addDevice(deviceCode, deviceNum, deviceInfos);
        }
        else
        {
            result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
        }
        return result;
    }
    
    public SDKErrorCode setCameraName(String cameraCode, String cameraNewName)
        throws SDKException
    {
        Device device = new Device();
        SDKErrorCode result = device.setCameraName(cameraCode, cameraNewName);
        return result;
    }
    
    public SDKResult<Object> getDeviceList(int deviceType, IndexRange indexRange) throws SDKException
    {
        return new Device().getDeviceList(deviceType, indexRange);
    }
    
    public SDKResult<Object> queryDeviceList(int deviceType, QueryUnifiedFormat queryUnifiedFormat, String domainCode) throws SDKException
    {
        return new Device().queryDeviceList(deviceType, queryUnifiedFormat, domainCode);
    }
    
    /** 
    * 删除主设备
    * @param domainCode 域编码
    * @param deviceNum 批量操作的设备数目
    * @param deviceCodeList 设备编码列表
    * @return SDKResult<DeviceOperResultList> 封装领域层的SDKResult对象
    * @throws SDKException SDK异常
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<DeviceOperResultList> deleteDevice(String domainCode, int deviceNum,
        List<DeviceCode> deviceCodeList)
        throws SDKException
    {
        SDKResult<DeviceOperResultList> result = null;
        if (null == domainCode || null == deviceCodeList || deviceCodeList.size() < 1)
        {
            result = new SDKResult<DeviceOperResultList>();
            result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        
        if (deviceNum != deviceCodeList.size())
        {
            result = new SDKResult<DeviceOperResultList>();
            result.setErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return result;
        }
        
        result = new Device().deleteDevice(domainCode, deviceNum, deviceCodeList);
        return result;
    }
    
    /** 
    * 获取用户拥有权限的整个系统中的域路由信息
    * @return SDKResult<DomainRouteList> 封装领域层的SDKResult对象
    * @throws SDKException SDK异常
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<DomainRouteList> getDomainRoute()
        throws SDKException
    {
        return new Device().getDomainRoute();
    }
    
    /** 
    * 查询摄像机码流能力
    * @param capabilityType 码流能力类型
    * @param devCode 设备编码
    * @return SDKResult<String> 码流能力xml
    * @throws SDKException SDK异常
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<String> getDeviceCapability(int capabilityType, String devCode)
        throws SDKException
    {
        SDKResult<String> result = null;
        if (null == devCode)
        {
            result = new SDKResult<String>();
            result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        result = new Device().getDeviceCapability(capabilityType, devCode);
        return result;
    }
    
    
    
    /** 
    * 查询设备设置信息
    * @param deviceCode 设备编码
    * @param configType 设置类型
    * @return SDKResult<Object> 封装领域层的SDKResult对象
    * @throws SDKException SDK异常
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<Object> getDeviceConfig(String deviceCode, int configType)
        throws SDKException
    {
        SDKResult<Object> result = null;
        
        if (null == deviceCode)
        {
            result = new SDKResult<Object>();
            result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        
        result = new Device().getDeviceConfig(deviceCode, configType);
        
        if (null == result)
        {
            result = new SDKResult<Object>();
            result.setErrCode(ErrInfo.DATA_ERRORCODE);
            return result;
        }
        
        return result;
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
        return new Device().getDeviceGroup(domainCode, deviceGroupCode);
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
        return new Device().getVideoDiagnose(cameraCode, domainCode);
    }
    
    /**
     * @param diagnoseXML 单台VCN的视频质量诊断计划xml
     * @return
     * @throws SDKException
     */
    public SDKErrorCode setVideoDiagnose(String diagnoseXML)
        throws SDKException
    {
        return new Device().setVideoDiagnose(diagnoseXML);
    }
}
