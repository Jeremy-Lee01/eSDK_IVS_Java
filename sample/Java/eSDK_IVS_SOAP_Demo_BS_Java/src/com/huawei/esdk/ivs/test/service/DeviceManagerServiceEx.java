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
package com.huawei.esdk.ivs.test.service;

import com.huawei.esdk.ivs.test.bean.ConfigItem;
import com.huawei.esdk.ivs.test.bean.DeviceBriefInfos;
import com.huawei.esdk.ivs.test.bean.DeviceCodeList;
import com.huawei.esdk.ivs.test.bean.DeviceGroupInfos;
import com.huawei.esdk.ivs.test.bean.DeviceOperInfoList;
import com.huawei.esdk.ivs.test.bean.DeviceOperResultInfos;
import com.huawei.esdk.ivs.test.bean.DomainRouteInfos;
import com.huawei.esdk.ivs.test.bean.GetDeviceListResponse;
import com.huawei.esdk.ivs.test.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.test.bean.IndexRange;
import com.huawei.esdk.ivs.test.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.test.bean.ResultInfos;

public interface DeviceManagerServiceEx
{
    IVSSDKResponse<DeviceOperResultInfos> addDevice(String domainCode, Integer deviceNum, DeviceOperInfoList deviceOperInfo);
    
    IVSSDKResponse<ResultInfos> deleteDevice(String domainCode, Integer deviceNum, DeviceCodeList deviceCode);
    
    IVSSDKResponse<ConfigItem> getDeviceConfig(String deviceCode, Integer configType);
    
    IVSSDKResponse<GetDeviceListResponse> getDeviceList(Integer deviceType, IndexRange indexRange);
    
    IVSSDKResponse<DomainRouteInfos> getDomainRoute();
    
    IVSSDKResponse<DeviceBriefInfos> queryDeviceList(String domainCode, Integer deviceType, QueryUnifiedFormat queryFormat);
    
    IVSSDKResponse<String> verifyDevice(String domainCode, String verifyInfo);
    
    Integer rebootDevice(String deviceCode, Integer rebootType);
    
    Integer setCameraName(String cameraCode, String newCameraName);
    
    Integer setDeviceConfig(String deviceCode, Integer configType, ConfigItem configItem);
    
    Integer setMainDeviceName(String deviceCode, String newDeviceName);
    
    Integer startSearchDevice(String domainCode, String searchInfo);
    
    Integer stopSearchDevice(String domainCode, String searchInfo);

    IVSSDKResponse<DeviceGroupInfos> getDeviceGroup(String domainCode, Integer deviceGroupCode);
    
    Integer setVideoDiagnose(String diagnoseXML);
    
    IVSSDKResponse<String> getVideoDiagnose(String domainCode, String cameraCode);

}
