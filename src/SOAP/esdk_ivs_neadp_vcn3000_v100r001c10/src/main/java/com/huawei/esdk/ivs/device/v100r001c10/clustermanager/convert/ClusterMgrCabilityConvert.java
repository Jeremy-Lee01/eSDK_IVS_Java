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
package com.huawei.esdk.ivs.device.v100r001c10.clustermanager.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.bean.DeviceBasicInfo;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfo;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.IPInfo;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.DeviceBasicInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.DeviceBriefInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.DeviceBriefInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.IndexRangeSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.IPInfoSouth;
import com.huawei.esdk.platform.common.utils.BytesUtils;

public class ClusterMgrCabilityConvert
{
    public IndexRangeSouth convertIndexRangeSouthModel2South(IndexRange domain)
    {
        IndexRangeSouth south = new IndexRangeSouth();
        south.clear();
        south.fromIndex = domain.getFromIndex();
        south.toIndex = domain.getToIndex();
        return south;
    }
    
    /** 
     * 将南向的bean转换成领域层的bean
     *
     * @param south 南向设备信息列表对象
     * @return DeviceBriefInfoList 领域层设备信息列表对象
     * @since  eSDK IVS V100R003C00
     */
    public DeviceBriefInfoList convertDeviceNvrBriefInfoSouth2Model(DeviceBriefInfoListSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceBriefInfoList domain = new DeviceBriefInfoList();
        domain.setTotal(south.total);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        IndexRange indexRange = convertIndexRangeSouth2Model(south.indexRange);
        domain.setIndexRange(indexRange);
        DeviceBriefInfoSouth[] deviceBriefInfoSouths = south.deviceBriefInfo;
        if (null != deviceBriefInfoSouths && deviceBriefInfoSouths.length > 0 && south.total > 0)
        {
            List<DeviceBriefInfo> deviceBriefInfos = new ArrayList<DeviceBriefInfo>();
            
            int length =
                getLength(south.total,
                    deviceBriefInfoSouths.length,
                    south.indexRange.fromIndex,
                    south.indexRange.toIndex);
            
            for (int i = 0; i < length; i++)
            {
                DeviceBriefInfo deviceBriefInfo = convertDeviceBriefInfoSouth2Model(deviceBriefInfoSouths[i]);
                if (null != deviceBriefInfo)
                {
                    deviceBriefInfos.add(deviceBriefInfo);
                }
            }
            domain.setDeviceBriefInfo(deviceBriefInfos);
        }
        return domain;
    }
    
    public int getLength(int total, int size, int fromIndex, int toIndex)
    {
        int length = 0;
        if (total < size)
        {
            length = toIndex < total ? toIndex : total;
            int temp = length - (fromIndex > 1 ? fromIndex : 1) + 1;
            length = length < temp ? length : temp;
        }
        else
        {
            length = toIndex < total ? toIndex : total;
            int temp = length - (fromIndex > 1 ? fromIndex : 1) + 1;
            length = size < temp ? size : temp;
        }
        return length;
    }
    
    public IndexRange convertIndexRangeSouth2Model(IndexRangeSouth south)
    {
        IndexRange domain = new IndexRange();
        domain.setFromIndex(south.fromIndex);
        domain.setToIndex(south.toIndex);
        return domain;
    }
    
    /** 
     * 将南向的bean转换成领域层的bean
     *
     * @param south 南向设备信息对象
     * @return DeviceBriefInfo 领域层设备信息对象
     * @since  eSDK IVS V100R003C00
     */
    public DeviceBriefInfo convertDeviceBriefInfoSouth2Model(DeviceBriefInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        
        DeviceBriefInfo domain = new DeviceBriefInfo();
        domain.setEnableSchedule(south.enableSchedule);
        domain.setLoginType(south.loginType);
        domain.setProtocolType(BytesUtils.bytesToStringForIVS(south.protocolType));
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setStatus(south.status);
        DeviceBasicInfo deviceBasicInfo = convertDeviceBasicInfoSouth2Model(south.deviceBasicInfoSouth);
        if (null != deviceBasicInfo)
        {
            domain.setDeviceBasicInfo(deviceBasicInfo);
        }
        return domain;
    }
    
    public DeviceBasicInfo convertDeviceBasicInfoSouth2Model(DeviceBasicInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceBasicInfo domain = new DeviceBasicInfo();
        domain.setCode(BytesUtils.bytesToStringForIVS(south.code));
        domain.setDomainCode(BytesUtils.bytesToStringForIVS(south.domainCode));
        IPInfo ip = convertIPInfoSouth2Model(south.ip);
        if (null != ip)
        {
            domain.setIpInfo(ip);
        }
        domain.setModel(BytesUtils.bytesToStringForIVS(south.model));
        domain.setName(BytesUtils.bytesToStringForIVS(south.name));
        domain.setParentCode(BytesUtils.bytesToStringForIVS(south.parentCode));
        domain.setPort(south.port);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSerialNumber(BytesUtils.bytesToStringForIVS(south.serialNumber));
        domain.setType(south.type);
        domain.setVendorType(BytesUtils.bytesToStringForIVS(south.vendorType));
        return domain;
    }
    
    public IPInfo convertIPInfoSouth2Model(IPInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        IPInfo domain = new IPInfo();
        domain.setIp(BytesUtils.bytesToStringForIVS(south.ip));
        domain.setIpType(south.ipType);
        return domain;
    }
}
