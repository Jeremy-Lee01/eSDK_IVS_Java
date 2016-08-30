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
package com.huawei.esdk.ivs.northcommu.cxf.professional.convert;

import java.util.List;

import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceBasicInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceBriefInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceBriefInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceBriefInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetNVRListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * 集群管理模块数据转换类
 * <p>
 * 用于南北向集群理模块接口数据的转换
 * <p>
 * @author  cWX191990
 * @since  eSDK IVS V100R003C00
 */
public class IVSProfessionalClusterManagerConvert
{

    /** 
     * 将soap消息转换成领域对象
     * @param parameters 北向分页信息
     * @return IndexRange 领域层分页信息
     * @since  eSDK IVS V100R003C00
     */
    public IndexRange getIndexRangeSoap2Model(
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange parameters)
    {
        if (null == parameters)
        {
            return null;
        }
        IndexRange indexRange = new IndexRange();
        indexRange.setFromIndex(parameters.getFromIndex());
        indexRange.setToIndex(parameters.getToIndex());
        return indexRange;
    }
    
    
    /** 
    * 将领域层返回的结果对象转换成响应消息
    * @param result 领域层返回的结果对象
    * @return GetNVRListResponse 北向接口响应
    * @since  eSDK IVS V100R003C00
    */
    public GetNVRListResponse getNVRListModel2Soap(
        SDKResult<com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfoList> result)
    {
        GetNVRListResponse response = new GetNVRListResponse();
        response.setResultCode((int)result.getErrCode());
        
        com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfoList domain = result.getResult();
        if (null == domain || 0 != result.getErrCode())
        {
            return response;
        }
        DeviceBriefInfos north = new DeviceBriefInfos();
        north.setTotal(domain.getTotal());
        north.setReserve(domain.getReserve());
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange northIndexRange =
            getIndexRangeModel2Soap(domain.getIndexRange());
        if (null != northIndexRange)
        {
            north.setIndexRange(northIndexRange);
        }
        DeviceBriefInfoList deviceBriefInfoList = new DeviceBriefInfoList();
        List<DeviceBriefInfo> deviceBriefInfos = deviceBriefInfoList.getDeviceBriefInfo();
        List<com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfo> deviceBriefInfoDomain = domain.getDeviceBriefInfo();
        if (null != deviceBriefInfoDomain)
        {
            for (com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfo aDeviceBriefInfoDomain : deviceBriefInfoDomain)
            {
                DeviceBriefInfo deviceBriefInfoNorth = getDeviceBriefInfoModel2Soap(aDeviceBriefInfoDomain);
                if (null != deviceBriefInfoNorth)
                {
                    deviceBriefInfos.add(deviceBriefInfoNorth);
                }
            }
        }
        north.setDeviceBriefInfoList(deviceBriefInfoList);
        response.setNvrInfos(north);
        return response;
    }
    
    
    /** 
    * 将领域层返回的结果对象转换成响应消息
    * @param domain 领域层分页信息
    * @return IndexRange 北向接口响应
    * @since  eSDK IVS V100R003C00
    */
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange getIndexRangeModel2Soap(IndexRange domain)
    {
        if (null == domain)
        {
            return null;
        }
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange north =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
        north.setFromIndex(domain.getFromIndex());
        north.setToIndex(domain.getToIndex());
        return north;
    }
    
    public DeviceBriefInfo getDeviceBriefInfoModel2Soap(
        com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfo domain)
    {
        if (null == domain)
        {
            return null;
        }
        DeviceBriefInfo north = new DeviceBriefInfo();
        north.setEnableSchedule(domain.getEnableSchedule());
        north.setLoginType(domain.getLoginType());
        north.setProtocolType(domain.getProtocolType());
        north.setReserve(domain.getReserve());
        north.setStatus(domain.getStatus());
        
        DeviceBasicInfo deviceBasicInfoNorth = getDeviceBasicInfoModel2Soap(domain.getDeviceBasicInfo());
        if (null != deviceBasicInfoNorth)
        {
            north.setDeviceBasicInfo(deviceBasicInfoNorth);
        }
        return north;
    }
    
    public DeviceBasicInfo getDeviceBasicInfoModel2Soap(
        com.huawei.esdk.ivs.domain.model.bean.DeviceBasicInfo domain)
    {
        if (null == domain)
        {
            return null;
        }
        DeviceBasicInfo north = new DeviceBasicInfo();
        north.setCode(domain.getCode());
        north.setDomainCode(domain.getDomainCode());
        IPInfo ipInfoNorth = getIPInfoModel2Soap(domain.getIpInfo());
        if (null != ipInfoNorth)
        {
            north.setIpInfo(ipInfoNorth);
        }
        north.setModel(domain.getModel());
        north.setName(domain.getName());
        north.setParentCode(domain.getParentCode());
        north.setPort(domain.getPort());
        north.setReserve(domain.getReserve());
        north.setSerialNumber(domain.getSerialNumber());
        north.setType(domain.getType());
        north.setVendorType(domain.getVendorType());
        return north;
    }
    
    public IPInfo getIPInfoModel2Soap(com.huawei.esdk.ivs.domain.model.bean.IPInfo domain)
    {
        if (null == domain)
        {
            return null;
        }
        IPInfo north = new IPInfo();
        north.setIp(domain.getIp());
        north.setIpType(domain.getIpType());
        return north;
    }
}
