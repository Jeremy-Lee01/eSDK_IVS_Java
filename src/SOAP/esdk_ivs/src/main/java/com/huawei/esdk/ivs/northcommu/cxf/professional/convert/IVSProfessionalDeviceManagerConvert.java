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

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.common.CipherUtils;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.huawei.esdk.ivs.domain.model.Device;
import com.huawei.esdk.ivs.domain.model.bean.AlarmBriefInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmInConfig;
import com.huawei.esdk.ivs.domain.model.bean.AlarmOutConfig;
import com.huawei.esdk.ivs.domain.model.bean.AudioBriefInfo;
import com.huawei.esdk.ivs.domain.model.bean.AudioBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.AudioConfig;
import com.huawei.esdk.ivs.domain.model.bean.AudioParam;
import com.huawei.esdk.ivs.domain.model.bean.BackLight;
import com.huawei.esdk.ivs.domain.model.bean.BroadCastInfo;
import com.huawei.esdk.ivs.domain.model.bean.CameraBriefInfo;
import com.huawei.esdk.ivs.domain.model.bean.CameraBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.CameraConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraDisplayConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraExtendConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraImagingConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraOSDConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraPosition;
import com.huawei.esdk.ivs.domain.model.bean.CameraRecordStreamConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraSnapShotConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraStreamConfig;
import com.huawei.esdk.ivs.domain.model.bean.ConfigItemEnum;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfo;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.DeviceChannelConfig;
import com.huawei.esdk.ivs.domain.model.bean.DeviceCode;
import com.huawei.esdk.ivs.domain.model.bean.DeviceGroup;
import com.huawei.esdk.ivs.domain.model.bean.DeviceGroupInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceNetConfig;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResult;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.DeviceTimeConfig;
import com.huawei.esdk.ivs.domain.model.bean.Exposure;
import com.huawei.esdk.ivs.domain.model.bean.Focus;
import com.huawei.esdk.ivs.domain.model.bean.IPInfo;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.MediaSecurityConfig;
import com.huawei.esdk.ivs.domain.model.bean.MotionDetection;
import com.huawei.esdk.ivs.domain.model.bean.NTPInfo;
import com.huawei.esdk.ivs.domain.model.bean.OSDName;
import com.huawei.esdk.ivs.domain.model.bean.OSDTime;
import com.huawei.esdk.ivs.domain.model.bean.OrderCondition;
import com.huawei.esdk.ivs.domain.model.bean.PTZConfig;
import com.huawei.esdk.ivs.domain.model.bean.QueryField;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RectFloat;
import com.huawei.esdk.ivs.domain.model.bean.SerialChannelConfig;
import com.huawei.esdk.ivs.domain.model.bean.StreamInfo;
import com.huawei.esdk.ivs.domain.model.bean.TimeSpan;
import com.huawei.esdk.ivs.domain.model.bean.VideoHideAlarm;
import com.huawei.esdk.ivs.domain.model.bean.VideoMask;
import com.huawei.esdk.ivs.domain.model.bean.WhiteBalance;
import com.huawei.esdk.ivs.domain.model.bean.WideDynamic;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmBriefInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioBriefInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraBriefInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ConfigItem;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteDeviceResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceBasicInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceBriefInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceChannel;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceConfig;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceGroupList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceOperInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceOperInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceOperResultInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DomainRoute;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DomainRouteInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DomainRouteList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceConfigResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceGroupResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDomainRouteResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryDeviceListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ResultInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ResultInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ResultInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StreamInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.TimeSpanList;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 设备管理模块数据转换类
 * <p>
 * 用于南北向设备管理模块接口数据的转换
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class IVSProfessionalDeviceManagerConvert
{
    
    public List<Device> addDeviceSoap2Model(DeviceOperInfoList deviceOperInfoList) throws SDKException
    {
        if (null == deviceOperInfoList || null == deviceOperInfoList.getDeviceOperInfo()
            || deviceOperInfoList.getDeviceOperInfo().isEmpty())
        {
            return null;
        }
        List<Device> deviceList = new ArrayList<Device>();
        
        Device deviceModel = null;
        com.huawei.esdk.ivs.domain.model.bean.DeviceOperInfo deviceOperInfoModel = null;
        
        for (DeviceOperInfo deviceOperInfo : deviceOperInfoList.getDeviceOperInfo())
        {
            deviceModel = new Device();
            
            deviceModel.setSequence(deviceOperInfo.getSequence());
            deviceModel.setReserve(deviceOperInfo.getReserve());
            
            // convert basicInfo
            com.huawei.esdk.ivs.domain.model.bean.DeviceBasicInfo deviceBasicInfoModel =
                new com.huawei.esdk.ivs.domain.model.bean.DeviceBasicInfo();
            getDeviceBasicInfoSoap2Model(deviceOperInfo.getDeviceConfig().getDeviceBasicInfo(), deviceBasicInfoModel);
            deviceModel.setDeviceBasicInfo(deviceBasicInfoModel);
            
            // convert channelConfig
            com.huawei.esdk.ivs.domain.model.bean.DeviceChannelConfig deviceChannelConfigModel =
                new com.huawei.esdk.ivs.domain.model.bean.DeviceChannelConfig();
            getDeviceChannelSoap2Model(deviceOperInfo.getDeviceConfig().getDeviceChannel(), deviceChannelConfigModel);
            deviceModel.setDeviceChannelConfig(deviceChannelConfigModel);
            
            // convert deviceOperInfo
            deviceOperInfoModel = new com.huawei.esdk.ivs.domain.model.bean.DeviceOperInfo();
            getDeviceOperInfoSoap2Model(deviceOperInfo.getDeviceConfig(), deviceOperInfoModel);
            deviceModel.setDeviceOperInfo(deviceOperInfoModel);
            
            deviceList.add(deviceModel);
        }
        
        return deviceList;
    }
    
    /**
     * 主设备配置参数转换
     * @throws SDKException 
     * @throws PasswordErrorException 
     */
    public void getDeviceOperInfoSoap2Model(DeviceConfig deviceConfigSoap,
        com.huawei.esdk.ivs.domain.model.bean.DeviceOperInfo deviceOperInfoModel)
        throws SDKException
    {
        //当DevicePassword非空时，对其进行解密
        String  encodeDevicePas = null;
        if (!StringUtils.isEmpty(deviceConfigSoap.getDevicePassword()))
        {
            encodeDevicePas = CipherUtils.decodeFromBase64(deviceConfigSoap.getDevicePassword());
            
            if (StringUtils.isEmpty(encodeDevicePas))
            {
                SDKException sdkException = new SDKException(ErrInfo.PWD_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.PWD_ERRORCODE);
                throw sdkException;
            }
        }
        else
        {
            encodeDevicePas = deviceConfigSoap.getDevicePassword();
        }
        deviceOperInfoModel.setDevPasswd(encodeDevicePas);
        
        //当DeviceRegPassword非空时，对其进行解密
        String  encodeDeviceRegPas = null;
        if (!StringUtils.isEmpty(deviceConfigSoap.getDeviceRegPassword()))
        {
            encodeDeviceRegPas = CipherUtils.decodeFromBase64(deviceConfigSoap.getDeviceRegPassword());
            
            if (StringUtils.isEmpty(encodeDeviceRegPas))
            {
                SDKException sdkException = new SDKException(ErrInfo.PWD_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.PWD_ERRORCODE);
                throw sdkException;
            }
        }
        else
        {
            encodeDeviceRegPas = deviceConfigSoap.getDeviceRegPassword();
        }
        deviceOperInfoModel.setDevRegPasswd(encodeDeviceRegPas);
        
        deviceOperInfoModel.setDevUser(deviceConfigSoap.getDeviceUser());
        deviceOperInfoModel.setEnableAlarm(deviceConfigSoap.getEnableAlarm());
        deviceOperInfoModel.setEnableSchedule(deviceConfigSoap.getEnableSchedule());
        deviceOperInfoModel.setIsDirectConnectFirst(deviceConfigSoap.getDirectConnectFirst());
        deviceOperInfoModel.setLoginType(deviceConfigSoap.getLoginType());
        deviceOperInfoModel.setMaxDirectConnectNum(deviceConfigSoap.getMaxDirectConnectNum());
        deviceOperInfoModel.setNvrCode(deviceConfigSoap.getNvrCode());
        deviceOperInfoModel.setProtocolType(deviceConfigSoap.getProtocolType());
        deviceOperInfoModel.setTasCode(deviceConfigSoap.getTasCode());
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo ipInfo = deviceConfigSoap.getTasIP();
        if (null != ipInfo)
        {
            IPInfo tasIp = new IPInfo();
            tasIp.setIp(ipInfo.getIp());
            tasIp.setIpType(ipInfo.getIpType());
            deviceOperInfoModel.setTasIp(tasIp);
        }
        deviceOperInfoModel.setVideoFormat(deviceConfigSoap.getVideoFormat());
        deviceOperInfoModel.setReserve(deviceConfigSoap.getReserve());
    }
    
    /**
     * 主设备基本信息转换
     */
    public void getDeviceBasicInfoSoap2Model(DeviceBasicInfo deviceBasicInfoSoap,
        com.huawei.esdk.ivs.domain.model.bean.DeviceBasicInfo deviceBasicInfoModel)
    {
        deviceBasicInfoModel.setCode(deviceBasicInfoSoap.getCode());
        deviceBasicInfoModel.setDomainCode(deviceBasicInfoSoap.getDomainCode());
        deviceBasicInfoModel.setModel(deviceBasicInfoSoap.getModel());
        deviceBasicInfoModel.setName(deviceBasicInfoSoap.getName());
        deviceBasicInfoModel.setParentCode(deviceBasicInfoSoap.getParentCode());
        deviceBasicInfoModel.setPort(deviceBasicInfoSoap.getPort());
        deviceBasicInfoModel.setReserve(deviceBasicInfoSoap.getReserve());
        deviceBasicInfoModel.setSerialNumber(deviceBasicInfoSoap.getSerialNumber());
        deviceBasicInfoModel.setType(deviceBasicInfoSoap.getType());
        deviceBasicInfoModel.setVendorType(deviceBasicInfoSoap.getVendorType());
        
        IPInfo ipInfo = new IPInfo();
        ipInfo.setIp(deviceBasicInfoSoap.getIpInfo().getIp());
        ipInfo.setIpType(deviceBasicInfoSoap.getIpInfo().getIpType());
        
        deviceBasicInfoModel.setIpInfo(ipInfo);
    }
    
    /**
     * 设备通道信息转换
     */
    public void getDeviceChannelSoap2Model(DeviceChannel deviceChannelSoap, DeviceChannelConfig deviceChannelModel)
    {
        deviceChannelModel.setMaxAlarmInNum(deviceChannelSoap.getMaxAlarmInNum());
        deviceChannelModel.setMaxAlarmOutNum(deviceChannelSoap.getMaxAlarmOutNum());
        deviceChannelModel.setMaxAudioInNum(deviceChannelSoap.getMaxAudioInNum());
        deviceChannelModel.setMaxAudioOutNum(deviceChannelSoap.getMaxAudioOutNum());
        deviceChannelModel.setMaxSerialNum(deviceChannelSoap.getMaxSerialNum());
        deviceChannelModel.setMaxVideoNum(deviceChannelSoap.getMaxVideoNum());
        deviceChannelModel.setReserve(deviceChannelSoap.getReserve());
    }
    
    public GetDomainRouteResponse getDomainRouteResponseModel2Soap(
        SDKResult<com.huawei.esdk.ivs.domain.model.bean.DomainRouteList> result)
    {
        GetDomainRouteResponse response = new GetDomainRouteResponse();
        response.setResultCode((int)result.getErrCode());
        com.huawei.esdk.ivs.domain.model.bean.DomainRouteList domain = result.getResult();
        if (0 != result.getErrCode() || null == domain)
        {
            return response;
        }
        DomainRouteInfos domainRouteInfoNorth = new DomainRouteInfos();
        domainRouteInfoNorth.setTotal(domain.getTotal());
        DomainRouteList domainRouteListNorth = new DomainRouteList();
        List<DomainRoute> domainRoutes = domainRouteListNorth.getDomainRoute();
        List<com.huawei.esdk.ivs.domain.model.bean.DomainRoute> domainRouteModels = domain.getDomainRoutes();
        if (null != domainRouteModels)
        {
            for (com.huawei.esdk.ivs.domain.model.bean.DomainRoute domainRouteModel : domainRouteModels)
            {
                DomainRoute domainRoute = getDomainRouteModel2Soap(domainRouteModel);
                domainRoutes.add(domainRoute);
            }
        }
        domainRouteInfoNorth.setDomainRouteList(domainRouteListNorth);
        response.setDomainRouteInfos(domainRouteInfoNorth);
        return response;
    }
    
    public DomainRoute getDomainRouteModel2Soap(com.huawei.esdk.ivs.domain.model.bean.DomainRoute domain)
    {
        DomainRoute domainRoute = new DomainRoute();
        domainRoute.setDomainCode(domain.getDomainCode());
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo ip = getIPInfoModel2Soap(domain.getDomainIPInfo());
        if (null != ip)
        {
            domainRoute.setDomainIPInfo(ip);
        }
        domainRoute.setDomainName(domain.getDomainName());
        domainRoute.setDomainPort(domain.getDomainPort());
        domainRoute.setDomainType(domain.getDomainType());
        domainRoute.setIsAgent(domain.getIsAgent());
        domainRoute.setIsLocalDomain(domain.getIsLocalDomain());
        domainRoute.setReserve(domain.getReserve());
        domainRoute.setSuperDomain(domain.getSuperDomain());
        return domainRoute;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo getIPInfoModel2Soap(IPInfo domain)
    {
        if (null == domain)
        {
            return null;
        }
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo ip =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo();
        ip.setIp(domain.getIp());
        ip.setIpType(domain.getIpType());
        return ip;
    }
    
    public List<DeviceCode> getDeviceCodeListSoap2Model(
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceCodeList norths)
    {
        if (null == norths || null == norths.getDeviceCode())
        {
            return null;
        }
        List<String> deviceCodeNorths = norths.getDeviceCode();
        List<DeviceCode> domainList = new ArrayList<DeviceCode>();
        for (String north : deviceCodeNorths)
        {
            DeviceCode domain = new DeviceCode();
            domain.setDevCode(north);
            domainList.add(domain);
        }
        return domainList;
    }
    
    public DeleteDeviceResponse getDeleteDeviceResponseModel2Soap(SDKResult<DeviceOperResultList> result)
    {
        DeleteDeviceResponse response = new DeleteDeviceResponse();
        response.setResultCode((int)result.getErrCode());
        DeviceOperResultList domain = result.getResult();
        if (null == domain)
        {
            return response;
        }
        ResultInfos resultList = new ResultInfos();
        resultList.setNumber(domain.getNum());
        List<DeviceOperResult> deviceOperResults = domain.getDeviceOperResults();
        ResultInfoList resultInfoListNorth = new ResultInfoList();
        List<ResultInfo> resultInfos = resultInfoListNorth.getResultInfo();
        if (null != deviceOperResults)
        {
            for (DeviceOperResult deviceOperResult : deviceOperResults)
            {
                ResultInfo resultInfo = getResultInfoModel2Soap(deviceOperResult);
                if (null != resultInfo)
                {
                    resultInfos.add(resultInfo);
                }
            }
        }
        resultList.setResultInfoList(resultInfoListNorth);
        response.setResultInfos(resultList);
        return response;
    }
    
    public IndexRange getDeviceListSoap2Model(com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexRange)
    {
        IndexRange iRange = new IndexRange();
        iRange.setFromIndex(indexRange.getFromIndex());
        iRange.setToIndex(indexRange.getToIndex());
        return iRange;
    }
    
    public GetDeviceListResponse getDeviceListModel2Soap(SDKResult<Object> result, int deviceType)
    {
        if (CommonConstant.DeviceModule.DEVICE_TYPE_CAMERA == deviceType)
        {
            // camera
            return getCameraBriefInfoListModel2Soap((CameraBriefInfoList)result.getResult(), result.getErrCode());
        }
        else if (CommonConstant.DeviceModule.DEVICE_TYPE_VOICE == deviceType)
        {
            // audio
            return getAudioBriefInfoListModel2Soap((AudioBriefInfoList)result.getResult(), result.getErrCode());
        }
        else
        {
            // alarm
            return getAlarmBriefInfoListModel2Soap((AlarmBriefInfoList)result.getResult(), result.getErrCode());
        }
    }
    
    public GetDeviceListResponse getCameraBriefInfoListModel2Soap(CameraBriefInfoList cameraBriefInfoList,
        long resultCode)
    {
        GetDeviceListResponse response = new GetDeviceListResponse();
        response.setResultCode((int)resultCode);
        
        if (0 == resultCode)
        {
            CameraBriefInfos cList = new CameraBriefInfos();
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraBriefInfoList cbInfoList =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraBriefInfoList();
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexRange =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
            indexRange.setFromIndex(cameraBriefInfoList.getIndexRange().getFromIndex());
            indexRange.setToIndex(cameraBriefInfoList.getIndexRange().getToIndex());
            
            cList.setTotal(cameraBriefInfoList.getTotal());
            cList.setIndexRange(indexRange);
            
            for (CameraBriefInfo cameraBriefInfo : cameraBriefInfoList.getCameraBriefInfo())
            {
                cbInfoList.getCameraBriefInfo().add(getCameraBriefInfoModel2Soap(cameraBriefInfo));
            }
            
            cList.setCameraBriefInfoList(cbInfoList);
            response.setCameraBriefInfos(cList);
        }
        
        return response;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraBriefInfo getCameraBriefInfoModel2Soap(
        CameraBriefInfo cameraBriefInfo)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraBriefInfo cbInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraBriefInfo();
        cbInfo.setCameraLocation(cameraBriefInfo.getCameraLocation());
        cbInfo.setCameraStatus(cameraBriefInfo.getCameraStatus());
        cbInfo.setCode(cameraBriefInfo.getCode());
        cbInfo.setDeviceCreateTime(cameraBriefInfo.getDeviceCreateTime());
        cbInfo.setDeviceFormType(cameraBriefInfo.getDeviceFormType());
        cbInfo.setDeviceGroupCode(cameraBriefInfo.getDeviceGroupCode());
        cbInfo.setDeviceIP(cameraBriefInfo.getDeviceIp());
        cbInfo.setDeviceModelType(cameraBriefInfo.getDeviceModelType());
        cbInfo.setDomainCode(cameraBriefInfo.getDomainCode());
        cbInfo.setEnableVoice(cameraBriefInfo.getEnableVoice());
        cbInfo.setIsExDomain(cameraBriefInfo.getIsExDomain());
        cbInfo.setIsSupportIntelligent(cameraBriefInfo.getIsSupportIntelligent());
        cbInfo.setName(cameraBriefInfo.getName());
        cbInfo.setNetType(cameraBriefInfo.getNetType());
        cbInfo.setNvrCode(cameraBriefInfo.getNvrCode());
        cbInfo.setParentCode(cameraBriefInfo.getParentCode());
        cbInfo.setReserve(cameraBriefInfo.getReserve());
        cbInfo.setStatus(cameraBriefInfo.getStatus());
        cbInfo.setType(cameraBriefInfo.getType());
        cbInfo.setVendorType(cameraBriefInfo.getVendorType());
        
        return cbInfo;
    }
    
    public GetDeviceListResponse getAudioBriefInfoListModel2Soap(AudioBriefInfoList audioBriefInfoList, long resultCode)
    {
        GetDeviceListResponse response = new GetDeviceListResponse();
        response.setResultCode((int)resultCode);
        
        if (0 == resultCode)
        {
            AudioBriefInfos aList = new AudioBriefInfos();
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioBriefInfoList abInfoList =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioBriefInfoList();
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexRange =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
            indexRange.setFromIndex(audioBriefInfoList.getIndexRange().getFromIndex());
            indexRange.setToIndex(audioBriefInfoList.getIndexRange().getToIndex());
            
            aList.setTotal(audioBriefInfoList.getTotal());
            aList.setReserve(audioBriefInfoList.getReserve());
            aList.setIndexRange(indexRange);
            
            for (AudioBriefInfo audioBriefInfo : audioBriefInfoList.getAudioBriefInfo())
            {
                abInfoList.getAudioBriefInfo().add(getAudioBriefInfoModel2Soap(audioBriefInfo));
            }
            
            aList.setAudioBriefInfoList(abInfoList);
            response.setAudioBriefInfos(aList);
        }
        
        return response;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioBriefInfo getAudioBriefInfoModel2Soap(
        AudioBriefInfo audioBriefInfo)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioBriefInfo abInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioBriefInfo();
        abInfo.setAudioCode(audioBriefInfo.getAudioCode());
        abInfo.setAudioName(audioBriefInfo.getAudioName());
        abInfo.setChannelType(audioBriefInfo.getChannelType());
        abInfo.setDeviceGroupId(audioBriefInfo.getDeviceGroupId());
        abInfo.setDomainCode(audioBriefInfo.getDomainCode());
        abInfo.setReserve(audioBriefInfo.getReserve());
        return abInfo;
    }
    
    public GetDeviceListResponse getAlarmBriefInfoListModel2Soap(AlarmBriefInfoList alarmBriefInfoList, long resultCode)
    {
        GetDeviceListResponse response = new GetDeviceListResponse();
        response.setResultCode((int)resultCode);
        
        if (0 == resultCode)
        {
            AlarmBriefInfos aList = new AlarmBriefInfos();
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmBriefInfoList abInfoList =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmBriefInfoList();
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexRange =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
            indexRange.setFromIndex(alarmBriefInfoList.getIndexRange().getFromIndex());
            indexRange.setToIndex(alarmBriefInfoList.getIndexRange().getToIndex());
            
            aList.setTotal(alarmBriefInfoList.getTotal());
            aList.setReserve(alarmBriefInfoList.getReserve());
            aList.setIndexRange(indexRange);
            
            for (AlarmBriefInfo alarmBriefInfo : alarmBriefInfoList.getAlarmBriefInfo())
            {
                abInfoList.getAlarmBriefInfo().add(getAlarmBriefInfoModel2Soap(alarmBriefInfo));
            }
            
            aList.setAlarmBriefInfoList(abInfoList);
            response.setAlarmBriefInfos(aList);
        }
        
        return response;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmBriefInfo getAlarmBriefInfoModel2Soap(
        AlarmBriefInfo alarmBriefInfo)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmBriefInfo abInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmBriefInfo();
        abInfo.setAlarmCode(alarmBriefInfo.getAlarmCode());
        abInfo.setAlarmName(alarmBriefInfo.getAlarmName());
        abInfo.setChannelType(alarmBriefInfo.getChannelType());
        abInfo.setDeviceGroupCode(alarmBriefInfo.getDeviceGroupCode());
        abInfo.setDomainCode(alarmBriefInfo.getDomainCode());
        abInfo.setIsExDomain(alarmBriefInfo.getIsExDomain());
        abInfo.setParentCode(alarmBriefInfo.getParentCode());
        abInfo.setReserve(alarmBriefInfo.getReserve());
        return abInfo;
    }
    
    public QueryDeviceListResponse queryDeviceListModel2Soap(SDKResult<Object> result)
    {
        QueryDeviceListResponse response = new QueryDeviceListResponse();
        response.setResultCode((int)result.getErrCode());
        
        if (0 == result.getErrCode())
        {
            DeviceBriefInfoList deviceBriefInfoList = (DeviceBriefInfoList)result.getResult();
            DeviceBriefInfos dList = new DeviceBriefInfos();
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceBriefInfoList dbInfoList =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceBriefInfoList();
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexRange =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
            indexRange.setFromIndex(deviceBriefInfoList.getIndexRange().getFromIndex());
            indexRange.setToIndex(deviceBriefInfoList.getIndexRange().getToIndex());
            dList.setTotal(deviceBriefInfoList.getTotal());
            dList.setReserve(deviceBriefInfoList.getReserve());
            dList.setIndexRange(indexRange);
            
            for (DeviceBriefInfo deviceBriefInfo : deviceBriefInfoList.getDeviceBriefInfo())
            {
                dbInfoList.getDeviceBriefInfo().add(getDeviceBriefInfoModel2Soap(deviceBriefInfo));
            }
            
            dList.setDeviceBriefInfoList(dbInfoList);
            response.setDeviceBriefInfos(dList);
        }
        
        return response;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceBriefInfo getDeviceBriefInfoModel2Soap(
        DeviceBriefInfo deviceBriefInfo)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceBriefInfo dbInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceBriefInfo();
        dbInfo.setEnableSchedule(deviceBriefInfo.getEnableSchedule());
        dbInfo.setLoginType(deviceBriefInfo.getLoginType());
        dbInfo.setProtocolType(deviceBriefInfo.getProtocolType());
        dbInfo.setReserve(deviceBriefInfo.getReserve());
        dbInfo.setStatus(deviceBriefInfo.getStatus());
        
        DeviceBasicInfo deviceBasicInfo = new DeviceBasicInfo();
        deviceBasicInfo.setCode(deviceBriefInfo.getDeviceBasicInfo().getCode());
        deviceBasicInfo.setDomainCode(deviceBriefInfo.getDeviceBasicInfo().getDomainCode());
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo ipInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo();
        ipInfo.setIp(deviceBriefInfo.getDeviceBasicInfo().getIpInfo().getIp());
        ipInfo.setIpType(deviceBriefInfo.getDeviceBasicInfo().getIpInfo().getIpType());
        deviceBasicInfo.setIpInfo(ipInfo);
        deviceBasicInfo.setModel(deviceBriefInfo.getDeviceBasicInfo().getModel());
        deviceBasicInfo.setName(deviceBriefInfo.getDeviceBasicInfo().getName());
        deviceBasicInfo.setParentCode(deviceBriefInfo.getDeviceBasicInfo().getParentCode());
        deviceBasicInfo.setPort(deviceBriefInfo.getDeviceBasicInfo().getPort());
        deviceBasicInfo.setReserve(deviceBriefInfo.getDeviceBasicInfo().getReserve());
        deviceBasicInfo.setSerialNumber(deviceBriefInfo.getDeviceBasicInfo().getSerialNumber());
        deviceBasicInfo.setType(deviceBriefInfo.getDeviceBasicInfo().getType());
        deviceBasicInfo.setVendorType(deviceBriefInfo.getDeviceBasicInfo().getVendorType());
        
        dbInfo.setDeviceBasicInfo(deviceBasicInfo);
        return dbInfo;
    }
    
    /** 
     * 转换北向QueryUnifiedFormat为领域层bean
     *
     * @param queryUnifiedFormat 北向获取告警列表查询条件
     * @return QueryUnifiedFormat 领域层获取告警列表查询条件
     */
    public QueryUnifiedFormat queryDeviceListSoap2Model(
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryUnifiedFormat queryUnifiedFormat)
    {
        QueryUnifiedFormat qUnifiedFormat = new QueryUnifiedFormat();
        IndexRange indexRange = new IndexRange();
        OrderCondition orderCondition = new OrderCondition();
        QueryField queryField = null;
        List<QueryField> list = new ArrayList<QueryField>();
        
        // 转换fieldNum
        qUnifiedFormat.setFieldNum(queryUnifiedFormat.getFieldNum());
        
        // 转换分页信息
        indexRange.setFromIndex(queryUnifiedFormat.getIndex().getFromIndex());
        indexRange.setToIndex(queryUnifiedFormat.getIndex().getToIndex());
        qUnifiedFormat.setIndex(indexRange);
        
        // 转换排序条件
        orderCondition.setEnableOrder(queryUnifiedFormat.getOrderCondition().getEnableOrder());
        orderCondition.setField(queryUnifiedFormat.getOrderCondition().getFieldType());
        orderCondition.setIsAscend(queryUnifiedFormat.getOrderCondition().getIsAscend());
        qUnifiedFormat.setOrderCondition(orderCondition);
        
        // 转换查询条件
        for (com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryField qf : queryUnifiedFormat.getQueryFieldList()
            .getQueryField())
        {
            queryField = new QueryField();
            queryField.setExactQuery(qf.getExactQuery());
            queryField.setFieldType(qf.getFieldType());
            queryField.setValue(qf.getValue());
            list.add(queryField);
        }
        qUnifiedFormat.setQueryField(list);
        
        return qUnifiedFormat;
    }
    
    public ResultInfo getResultInfoModel2Soap(DeviceOperResult domain)
    {
        if (null == domain)
        {
            return null;
        }
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(domain.getCode());
        resultInfo.setResult(domain.getResult());
        resultInfo.setSequence(domain.getSequence());
        return resultInfo;
    }
    
    public Object setDeviceConfigSoap2Model(int configType, ConfigItem configItem) throws SDKException
    {
        if (null == configItem)
        {
            return null;
        }
        
        if (configType == ConfigItemEnum.CONFIG_DEVICE_CFG)
        {
            DeviceConfig deviceConfig = configItem.getDeviceConfig();
            if (null != deviceConfig)
            {
                Device device = new Device();
                com.huawei.esdk.ivs.domain.model.bean.DeviceOperInfo deviceOperInfoModel =
                    new com.huawei.esdk.ivs.domain.model.bean.DeviceOperInfo();
                getDeviceOperInfoSoap2Model(deviceConfig, deviceOperInfoModel);
                device.setDeviceOperInfo(deviceOperInfoModel);
                
                com.huawei.esdk.ivs.domain.model.bean.DeviceBasicInfo deviceBasicInfoModel =
                    new com.huawei.esdk.ivs.domain.model.bean.DeviceBasicInfo();
                getDeviceBasicInfoSoap2Model(deviceConfig.getDeviceBasicInfo(), deviceBasicInfoModel);
                device.setDeviceBasicInfo(deviceBasicInfoModel);
                
                com.huawei.esdk.ivs.domain.model.bean.DeviceChannelConfig deviceChannelConfigModel =
                    new com.huawei.esdk.ivs.domain.model.bean.DeviceChannelConfig();
                getDeviceChannelSoap2Model(deviceConfig.getDeviceChannel(), deviceChannelConfigModel);
                device.setDeviceChannelConfig(deviceChannelConfigModel);
                
                return device;
            }
            else
            {
                return null;
            }
        }
        else if (configType == ConfigItemEnum.CONFIG_DEVICE_NET_CFG)
        {
            DeviceNetConfig deviceNetConfig = new DeviceNetConfig();
            if (null == configItem.getDeviceNetConfig())
            {
                return null;
            }
            deviceNetConfig.setMaxMtu(configItem.getDeviceNetConfig().getMaxMtu());
            deviceNetConfig.setPuPort(configItem.getDeviceNetConfig().getPuPort());
            deviceNetConfig.setReserve(configItem.getDeviceNetConfig().getReserve());
            
            IPInfo puIp = new IPInfo();
            puIp.setIp(configItem.getDeviceNetConfig().getPuIP().getIp());
            puIp.setIpType(configItem.getDeviceNetConfig().getPuIP().getIpType());
            deviceNetConfig.setPuIp(puIp);
            
            IPInfo puGateway = new IPInfo();
            puGateway.setIp(configItem.getDeviceNetConfig().getPuGateway().getIp());
            puGateway.setIpType(configItem.getDeviceNetConfig().getPuGateway().getIpType());
            deviceNetConfig.setPuGateway(puGateway);
            
            IPInfo subNetMask = new IPInfo();
            subNetMask.setIp(configItem.getDeviceNetConfig().getSubNetMask().getIp());
            subNetMask.setIpType(configItem.getDeviceNetConfig().getSubNetMask().getIpType());
            deviceNetConfig.setSubNetMask(subNetMask);
            
            return deviceNetConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_DEVICE_TIME_CFG)
        {
            if (null == configItem.getDeviceTimeConfig())
            {
                return null;
            }
            
            DeviceTimeConfig deviceTimeConfig = new DeviceTimeConfig();
            deviceTimeConfig.setEnableDst(configItem.getDeviceTimeConfig().getEnableDST());
            deviceTimeConfig.setEnableNtp(configItem.getDeviceTimeConfig().getEnableNTP());
            deviceTimeConfig.setTimezone(configItem.getDeviceTimeConfig().getTimezone());
            deviceTimeConfig.setReserve(configItem.getDeviceTimeConfig().getReserve());
            
            NTPInfo ntpInfo = new NTPInfo();
            ntpInfo.setNtpType(configItem.getDeviceTimeConfig().getNtp().getNtpType());
            ntpInfo.setReserve(configItem.getDeviceTimeConfig().getNtp().getReserve());
            
            IPInfo ntpServerIP = new IPInfo();
            ntpServerIP.setIp(configItem.getDeviceTimeConfig().getNtp().getNtpServerIP().getIp());
            ntpServerIP.setIpType(configItem.getDeviceTimeConfig().getNtp().getNtpServerIP().getIpType());
            ntpInfo.setNtpServerIP(ntpServerIP);
            
            IPInfo dnsIP = new IPInfo();
            dnsIP.setIp(configItem.getDeviceTimeConfig().getNtp().getDnsIP().getIp());
            dnsIP.setIpType(configItem.getDeviceTimeConfig().getNtp().getDnsIP().getIpType());
            ntpInfo.setDnsIP(dnsIP);
            
            deviceTimeConfig.setNtp(ntpInfo);
            
            return deviceTimeConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_CFG)
        {
            if (null == configItem.getCameraConfig())
            {
                return null;
            }
            
            CameraConfig cameraConfig = new CameraConfig();
            
            cameraConfig.setCameraCode(configItem.getCameraConfig().getCameraCode());
            cameraConfig.setVideoChannel(configItem.getCameraConfig().getVideoChannel());
            cameraConfig.setCameraName(configItem.getCameraConfig().getCameraName());
            cameraConfig.setSupportBroadcast(configItem.getCameraConfig().getIsSupportBroadcast());
            cameraConfig.setEnableVoice(configItem.getCameraConfig().getEnableVoice());
            cameraConfig.setVoiceOutCode(configItem.getCameraConfig().getVoiceOutCode());
            cameraConfig.setParentCode(configItem.getCameraConfig().getParentCode());
            cameraConfig.setNvrCode(configItem.getCameraConfig().getNvrCode());
            cameraConfig.setCameraType(configItem.getCameraConfig().getCameraType());
            cameraConfig.setCameraStatus(configItem.getCameraConfig().getCameraStatus());
            cameraConfig.setReserve(configItem.getCameraConfig().getReserve());
            
            CameraPosition cameraPosition = new CameraPosition();
            
            cameraPosition.setCameraLocationDesc(configItem.getCameraConfig()
                .getCameraPosition()
                .getCameraLocationDesc());
            cameraPosition.setLongitude(configItem.getCameraConfig().getCameraPosition().getLongitude());
            cameraPosition.setLatitude(configItem.getCameraConfig().getCameraPosition().getLatitude());
            cameraPosition.setHeight(configItem.getCameraConfig().getCameraPosition().getHeight());
            cameraPosition.setReserve(configItem.getCameraConfig().getCameraPosition().getReserve());
            cameraConfig.setPositionInfo(cameraPosition);
            
            BroadCastInfo broadCastInfo = new BroadCastInfo();
            
            broadCastInfo.setPort(configItem.getCameraConfig().getBroadcastInfo().getPort());
            broadCastInfo.setTimeToLive(configItem.getCameraConfig().getBroadcastInfo().getTimeToLive());
            broadCastInfo.setReserve(configItem.getCameraConfig().getBroadcastInfo().getReserve());
            
            IPInfo ipInfo = new IPInfo();
            ipInfo.setIp(configItem.getCameraConfig().getBroadcastInfo().getIp().getIp());
            ipInfo.setIpType(configItem.getCameraConfig().getBroadcastInfo().getIp().getIpType());
            broadCastInfo.setIpInfo(ipInfo);
            
            cameraConfig.setBroadcastInfo(broadCastInfo);
            
            return cameraConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_STREAM_CFG)
        {
            if (null == configItem.getCameraStreamConfig())
            {
                return null;
            }
            int size = configItem.getCameraStreamConfig().getStreamInfoNum();
            if(size > CommonConstant.DeviceModule.IVS_MAX_STREAM_NUM || size < 0)
            {
                SDKException sdkException = new SDKException("DATA_ERRORCODE");
                sdkException.setSdkErrCode(ErrInfo.IVS_DATA_INVALID_ERROR);
                throw sdkException;
            }
            
            if( null != configItem.getCameraStreamConfig().getStreamInfoList() &&
                null != configItem.getCameraStreamConfig().getStreamInfoList().getStreamInfo() && 
                configItem.getCameraStreamConfig().getStreamInfoList().getStreamInfo().size() != size)
            {
                SDKException sdkException = new SDKException("IVS_XML_INVALID_ERROR");
                sdkException.setSdkErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
                throw sdkException;
            }
            
            CameraStreamConfig cameraStreamConfig = new CameraStreamConfig();
            cameraStreamConfig.setReserve(configItem.getCameraStreamConfig().getReserve());
            cameraStreamConfig.setStreamInfoNum(configItem.getCameraStreamConfig().getStreamInfoNum());
            
            List<StreamInfo> streamInfos = new ArrayList<StreamInfo>();
            StreamInfo streamInfo = null;
            if( null != configItem.getCameraStreamConfig().getStreamInfoList())
            {
                for (com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StreamInfo streamInfoSoap : configItem.getCameraStreamConfig()
                    .getStreamInfoList()
                    .getStreamInfo())
                {
                    streamInfo = new StreamInfo();
                    streamInfo.setBitRate(streamInfoSoap.getBitRate());
                    streamInfo.setStreamType(streamInfoSoap.getStreamType());
                    streamInfo.setEncodeType(streamInfoSoap.getEncodeType());
                    streamInfo.setProfile(streamInfoSoap.getProfile());
                    streamInfo.setFrameInterval(streamInfoSoap.getFrameInterval());
                    streamInfo.setResolution(streamInfoSoap.getResolution());
                    streamInfo.setPicQuality(streamInfoSoap.getPicQuality());
                    streamInfo.setTransProtocol(streamInfoSoap.getTransProtocol());
                    streamInfo.setPktProtocol(streamInfoSoap.getPktProtocol());
                    streamInfo.setBitRateType(streamInfoSoap.getBitRateType());
                    streamInfo.setFrameRate(streamInfoSoap.getFrameRate());
                    streamInfo.setReserve(streamInfoSoap.getReserve());
                    
                    streamInfos.add(streamInfo);
                }
            }
            cameraStreamConfig.setStreamInfos(streamInfos);
            
            return cameraStreamConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_DISPLAY_CFG)
        {
            if (null == configItem.getCameraDisplayConfig())
            {
                return null;
            }
            
            CameraDisplayConfig cameraDisplayConfig = new CameraDisplayConfig();
            
            cameraDisplayConfig.setBrightness(configItem.getCameraDisplayConfig().getBrightness());
            cameraDisplayConfig.setContrast(configItem.getCameraDisplayConfig().getContrast());
            cameraDisplayConfig.setHue(configItem.getCameraDisplayConfig().getHue());
            cameraDisplayConfig.setSaturation(configItem.getCameraDisplayConfig().getSaturation());
            cameraDisplayConfig.setReserve(configItem.getCameraDisplayConfig().getReserve());
            
            return cameraDisplayConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_IMAGING_CFG)
        {
            if (null == configItem.getCameraImagingConfig())
            {
                return null;
            }
            
            CameraImagingConfig cameraImagingConfig = new CameraImagingConfig();
            cameraImagingConfig.setIrCutFilter(configItem.getCameraImagingConfig().getIrCutFilter());
            cameraImagingConfig.setSharpness(configItem.getCameraImagingConfig().getSharpness());
            cameraImagingConfig.setReserve(configItem.getCameraImagingConfig().getReserve());
            
            BackLight backLight = new BackLight();
            backLight.setBacklightLevel(configItem.getCameraImagingConfig().getBacklight().getBacklightLevel());
            backLight.setBacklightMode(configItem.getCameraImagingConfig().getBacklight().getBacklightMode());
            backLight.setReserve(configItem.getCameraImagingConfig().getBacklight().getReserve());
            cameraImagingConfig.setBacklight(backLight);
            
            Exposure exposure = new Exposure();
            exposure.setExposureGain(configItem.getCameraImagingConfig().getExposure().getExposureGain());
            exposure.setExposureMode(configItem.getCameraImagingConfig().getExposure().getExposureMode());
            exposure.setExposurePriority(configItem.getCameraImagingConfig().getExposure().getExposurePriority());
            exposure.setExposureTime(configItem.getCameraImagingConfig().getExposure().getExposureTime());
            exposure.setExposureIris(configItem.getCameraImagingConfig().getExposure().getExposureIris());
            exposure.setReserve(configItem.getCameraImagingConfig().getExposure().getReserve());
            
            RectFloat rectFloat = new RectFloat();
            rectFloat.setBottom((float)configItem.getCameraImagingConfig().getExposure().getRectWindow().getBottom());
            rectFloat.setLeft((float)configItem.getCameraImagingConfig().getExposure().getRectWindow().getLeft());
            rectFloat.setTop((float)configItem.getCameraImagingConfig().getExposure().getRectWindow().getTop());
            rectFloat.setRight((float)configItem.getCameraImagingConfig().getExposure().getRectWindow().getRight());
            
            exposure.setRectWindow(rectFloat);
            cameraImagingConfig.setExposure(exposure);
            
            Focus focus = new Focus();
            focus.setFocusMode(configItem.getCameraImagingConfig().getFocus().getFocusMode());
            focus.setFarLimit(configItem.getCameraImagingConfig().getFocus().getFarLimit());
            focus.setFocusSpeed(configItem.getCameraImagingConfig().getFocus().getFocusSpeed());
            focus.setNearLimit(configItem.getCameraImagingConfig().getFocus().getNearLimit());
            focus.setReserve(configItem.getCameraImagingConfig().getFocus().getReserve());
            cameraImagingConfig.setFocus(focus);
            
            WideDynamic wideDynamic = new WideDynamic();
            wideDynamic.setWideDynamicMode(configItem.getCameraImagingConfig().getWideDynamic().getWideDynamicMode());
            wideDynamic.setWideDynamicLevel(configItem.getCameraImagingConfig().getWideDynamic().getWideDynamicLevel());
            wideDynamic.setReserve(configItem.getCameraImagingConfig().getWideDynamic().getReserve());
            cameraImagingConfig.setWideDynamic(wideDynamic);
            
            WhiteBalance whiteBalance = new WhiteBalance();
            whiteBalance.setCbGain(configItem.getCameraImagingConfig().getWhiteBalance().getBlueGain());
            whiteBalance.setCrGain(configItem.getCameraImagingConfig().getWhiteBalance().getRedGain());
            whiteBalance.setWhiteBalanceMode(configItem.getCameraImagingConfig()
                .getWhiteBalance()
                .getWhiteBalanceMode());
            whiteBalance.setReserve(configItem.getCameraImagingConfig().getWhiteBalance().getReserve());
            cameraImagingConfig.setWhiteBalance(whiteBalance);
            
            return cameraImagingConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_OSD_CFG)
        {
            if (null == configItem.getCameraOSDConfig())
            {
                return null;
            }
            
            CameraOSDConfig cameraOSDConfig = new CameraOSDConfig();
            
            cameraOSDConfig.setEnableOSD(configItem.getCameraOSDConfig().getEnableOSD());
            cameraOSDConfig.setReserve(configItem.getCameraOSDConfig().getReserve());
            
            OSDTime osdTime = new OSDTime();
            
            osdTime.setEnableOSDTime(configItem.getCameraOSDConfig().getOsdTime().getEnableOSDTime());
            osdTime.setTimeFormat(configItem.getCameraOSDConfig().getOsdTime().getTimeFormat());
            osdTime.setTimeX((float)configItem.getCameraOSDConfig().getOsdTime().getTimeX());
            osdTime.setTimeY((float)configItem.getCameraOSDConfig().getOsdTime().getTimeY());
            osdTime.setReserve(configItem.getCameraOSDConfig().getOsdTime().getReserve());
            cameraOSDConfig.setOsdTime(osdTime);
            
            OSDName osdName = new OSDName();
            osdName.setEnableOSDName(configItem.getCameraOSDConfig().getOsdName().getEnableOSDName());
            osdName.setOsdNameText(configItem.getCameraOSDConfig().getOsdName().getOsdNameText());
            osdName.setEnableSwitch(configItem.getCameraOSDConfig().getOsdName().getEnableSwitch());
            osdName.setSwitchInterval(configItem.getCameraOSDConfig().getOsdName().getSwitchInterval());
            osdName.setEnableTextBlink(configItem.getCameraOSDConfig().getOsdName().getEnableTextBlink());
            osdName.setEnableTextTranslucent(configItem.getCameraOSDConfig().getOsdName().getEnableTextTranslucent());
            osdName.setTextTranslucentPercent(configItem.getCameraOSDConfig().getOsdName().getTextTranslucentPercent());
            osdName.setReserve(configItem.getCameraOSDConfig().getOsdName().getReserve());
            
            RectFloat rectFloat = new RectFloat();
            rectFloat.setBottom((float)configItem.getCameraOSDConfig().getOsdName().getRectText().getBottom());
            rectFloat.setLeft((float)configItem.getCameraOSDConfig().getOsdName().getRectText().getLeft());
            rectFloat.setTop((float)configItem.getCameraOSDConfig().getOsdName().getRectText().getTop());
            rectFloat.setRight((float)configItem.getCameraOSDConfig().getOsdName().getRectText().getRight());
            osdName.setRectText(rectFloat);
            cameraOSDConfig.setOsdName(osdName);
            
            return cameraOSDConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_MOTION_DETECTION_CFG)
        {
            if (null == configItem.getMotionDetection())
            {
                return null;
            }
            
            int size = configItem.getMotionDetection().getRectNum();
            
            if(size > CommonConstant.DeviceModule.IVS_MAX_MOTION_DETECTION_AREA_NUM || size < 0)
            {
                SDKException sdkException = new SDKException("DATA_ERRORCODE");
                sdkException.setSdkErrCode(ErrInfo.IVS_DATA_INVALID_ERROR);
                throw sdkException;
            }
            
            if( null != configItem.getMotionDetection().getRectDetectionList() &&
                null != configItem.getMotionDetection().getRectDetectionList().getRectInfo() &&
                configItem.getMotionDetection().getRectDetectionList().getRectInfo().size() != size)
            {
                SDKException sdkException = new SDKException("IVS_XML_INVALID_ERROR");
                sdkException.setSdkErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
                throw sdkException;
            }
            
            MotionDetection motionDetection = new MotionDetection();
            
            motionDetection.setAutoClearAlarmTime(configItem.getMotionDetection().getAutoClearAlarmTime());
            motionDetection.setMotionDetectionEnable(configItem.getMotionDetection().getMotionDetectionEnable());
            motionDetection.setPlatformMotionDetection(configItem.getMotionDetection().getPlatformMotionDetection());
            motionDetection.setDetectInterval(configItem.getMotionDetection().getDetectInterval());
            motionDetection.setSensitivity(configItem.getMotionDetection().getSensitivity());
            motionDetection.setRectNum(configItem.getMotionDetection().getRectNum());
            motionDetection.setReserve(configItem.getMotionDetection().getReserve());
            
            List<RectFloat> rectDetections = new ArrayList<RectFloat>();
            RectFloat rectFloat = null;
            
            if(null != configItem.getMotionDetection().getRectDetectionList())
            {
                for (RectInfo rectInfoSoap : configItem.getMotionDetection().getRectDetectionList().getRectInfo())
                {
                    rectFloat = new RectFloat();
                    rectFloat.setBottom((float)rectInfoSoap.getBottom());
                    rectFloat.setLeft((float)rectInfoSoap.getLeft());
                    rectFloat.setTop((float)rectInfoSoap.getTop());
                    rectFloat.setRight((float)rectInfoSoap.getRight());
                    
                    rectDetections.add(rectFloat);
                }
            }
            
            motionDetection.setRectDetections(rectDetections);
            
            return motionDetection;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_VIDEO_HIDE_ALARM_CFG)
        {
            if (null == configItem.getVideoHideAlarm())
            {
                return null;
            }
            
            int size = configItem.getVideoHideAlarm().getAreaNum();
            if(size > CommonConstant.DeviceModule.IVS_MAX_VIDEO_HIDE_AREA_NUM || size < 0)
            {
                SDKException sdkException = new SDKException("DATA_ERRORCODE");
                sdkException.setSdkErrCode(ErrInfo.IVS_DATA_INVALID_ERROR);
                throw sdkException;
            }
            
            if( null != configItem.getVideoHideAlarm().getRectAreaList() &&
                null != configItem.getVideoHideAlarm().getRectAreaList().getRectInfo() && 
                configItem.getVideoHideAlarm().getRectAreaList().getRectInfo().size() != size)
            {
                SDKException sdkException = new SDKException("IVS_XML_INVALID_ERROR");
                sdkException.setSdkErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
                throw sdkException;
            }
            
            int guardTimeNum = configItem.getVideoHideAlarm().getGuardTimeNum();
            if(guardTimeNum > CommonConstant.DeviceModule.IVS_MAX_VIDEO_HIDE_GUARD_TIME_NUM || guardTimeNum < 0)
            {
                SDKException sdkException = new SDKException("DATA_ERRORCODE");
                sdkException.setSdkErrCode(ErrInfo.IVS_DATA_INVALID_ERROR);
                throw sdkException;
            }
            if( null != configItem.getVideoHideAlarm().getGuardTimeList() &&
                null != configItem.getVideoHideAlarm().getGuardTimeList().getTimeSpan() && 
                configItem.getVideoHideAlarm().getGuardTimeList().getTimeSpan().size() != guardTimeNum)
            {
                SDKException sdkException = new SDKException("IVS_XML_INVALID_ERROR");
                sdkException.setSdkErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
                throw sdkException;
            }
            
            VideoHideAlarm videoHideAlarm = new VideoHideAlarm();
            videoHideAlarm.setAreaNum(configItem.getVideoHideAlarm().getAreaNum());
            videoHideAlarm.setEnableVideoHide(configItem.getVideoHideAlarm().getEnableVideoHide());
            videoHideAlarm.setSensitivity(configItem.getVideoHideAlarm().getSensitivity());
            videoHideAlarm.setAutoClearAlarmTime(configItem.getVideoHideAlarm().getAutoClearAlarmTime());
            videoHideAlarm.setGuardTimeNum(configItem.getVideoHideAlarm().getGuardTimeNum());
            videoHideAlarm.setReserve(configItem.getVideoHideAlarm().getReserve());
            
            List<TimeSpan> guardTimeList = new ArrayList<TimeSpan>();
            TimeSpan timeSpan = null;
            if(null != configItem.getVideoHideAlarm().getGuardTimeList())
            {
                for (com.huawei.esdk.ivs.northcommu.cxf.professional.gen.TimeSpan guardTimeSoap : configItem.getVideoHideAlarm()
                    .getGuardTimeList()
                    .getTimeSpan())
                {
                    timeSpan = new TimeSpan();
                    timeSpan.setStartTime(guardTimeSoap.getStartTime());
                    timeSpan.setEndTime(guardTimeSoap.getEndTime());
                    guardTimeList.add(timeSpan);
                }
            }
            
            videoHideAlarm.setGuardTimes(guardTimeList);
            
            List<RectFloat> rectAreas = new ArrayList<RectFloat>();
            RectFloat rectFloat = null;
            if (null != configItem.getVideoHideAlarm().getRectAreaList())
            {
                for (RectInfo rectInfoSoap : configItem.getVideoHideAlarm().getRectAreaList().getRectInfo())
                {
                    rectFloat = new RectFloat();
                    rectFloat.setBottom((float)rectInfoSoap.getBottom());
                    rectFloat.setLeft((float)rectInfoSoap.getLeft());
                    rectFloat.setTop((float)rectInfoSoap.getTop());
                    rectFloat.setRight((float)rectInfoSoap.getRight());
                    
                    rectAreas.add(rectFloat);
                }
            }
            videoHideAlarm.setRectAreas(rectAreas);
            
            return videoHideAlarm;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_VIDEO_MASK_CFG)
        {
            if (null == configItem.getVideoMask())
            {
                return null;
            }
            
            int size = configItem.getVideoMask().getAreaNum();
            
            if(size > CommonConstant.DeviceModule.IVS_MAX_VIDEO_MASK_AREA_NUM || size < 0)
            {
                SDKException sdkException = new SDKException("DATA_ERRORCODE");
                sdkException.setSdkErrCode(ErrInfo.IVS_DATA_INVALID_ERROR);
                throw sdkException;
            }
            if( null != configItem.getVideoMask().getRectAreaList() &&
                null != configItem.getVideoMask().getRectAreaList().getRectInfo() && 
                configItem.getVideoMask().getRectAreaList().getRectInfo().size() != size)
            {
                SDKException sdkException = new SDKException("IVS_XML_INVALID_ERROR");
                sdkException.setSdkErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
                throw sdkException;
            }
            VideoMask videoMask = new VideoMask();
            
            videoMask.setAreaNum(configItem.getVideoMask().getAreaNum());
            videoMask.setReserve(configItem.getVideoMask().getReserve());
            videoMask.setEnableVideoMask(configItem.getVideoMask().getEnableVideoMask());
            
            List<RectFloat> rectAreas = new ArrayList<RectFloat>();
            RectFloat rectFloat = null;
            
            if(null != configItem.getVideoMask().getRectAreaList())
            {
                for (RectInfo rectInfoSoap : configItem.getVideoMask().getRectAreaList().getRectInfo())
                {
                    rectFloat = new RectFloat();
                    rectFloat.setBottom((float)rectInfoSoap.getBottom());
                    rectFloat.setLeft((float)rectInfoSoap.getLeft());
                    rectFloat.setTop((float)rectInfoSoap.getTop());
                    rectFloat.setRight((float)rectInfoSoap.getRight());
                    
                    rectAreas.add(rectFloat);
                }
            }
            videoMask.setRectAreas(rectAreas);
            
            return videoMask;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_AUDIO_CFG)
        {
            if (null == configItem.getAudioConfig())
            {
                return null;
            }
            
            AudioConfig audioConfig = new AudioConfig();
            
            audioConfig.setAudioIndex(configItem.getAudioConfig().getAudioIndex());
            audioConfig.setAudioName(configItem.getAudioConfig().getAudioName());
            audioConfig.setChannelType(configItem.getAudioConfig().getChannelType());
            audioConfig.setReserve(configItem.getAudioConfig().getReserve());
            
            AudioParam audioParam = new AudioParam();
            audioParam.setChannel(configItem.getAudioConfig().getAudioParam().getChannel());
            audioParam.setPitch(configItem.getAudioConfig().getAudioParam().getPitch());
            audioParam.setVolume(configItem.getAudioConfig().getAudioParam().getVolume());
            audioParam.setInputType(configItem.getAudioConfig().getAudioParam().getInputType());
            audioParam.setDataFormat(configItem.getAudioConfig().getAudioParam().getDataFormat());
            audioParam.setSampleRate(configItem.getAudioConfig().getAudioParam().getSampleRate());
            audioParam.setGain(configItem.getAudioConfig().getAudioParam().getGain());
            audioParam.setSampleBits(configItem.getAudioConfig().getAudioParam().getSampleBits());
            audioParam.setReserve(configItem.getAudioConfig().getAudioParam().getReserve());
            
            audioConfig.setAudioParam(audioParam);
            
            return audioConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_SERIAL_CHANNEL_CFG)
        {
            if (null == configItem.getSerialChannelConfig())
            {
                return null;
            }
            
            SerialChannelConfig serialChannelConfig = new SerialChannelConfig();
            
            serialChannelConfig.setBaudRate(configItem.getSerialChannelConfig().getBaudRate());
            serialChannelConfig.setSerialName(configItem.getSerialChannelConfig().getSerialName());
            serialChannelConfig.setSerialIndex(configItem.getSerialChannelConfig().getSerialIndex());
            serialChannelConfig.setSerialType(configItem.getSerialChannelConfig().getSerialType());
            serialChannelConfig.setDataBit(configItem.getSerialChannelConfig().getDataBit());
            serialChannelConfig.setParity(configItem.getSerialChannelConfig().getParity());
            serialChannelConfig.setStopBit(configItem.getSerialChannelConfig().getStopBit());
            serialChannelConfig.setFlowControl(configItem.getSerialChannelConfig().getFlowControl());
            serialChannelConfig.setReserve(configItem.getSerialChannelConfig().getReserve());
            
            return serialChannelConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_ALARM_IN_CFG)
        {
            if (null == configItem.getAlarmInConfig())
            {
                return null;
            }
            
            AlarmInConfig alarmInConfig = new AlarmInConfig();
            
            alarmInConfig.setAlarmInChanIndex(configItem.getAlarmInConfig().getAlarmInChanIndex());
            alarmInConfig.setAlarmInName(configItem.getAlarmInConfig().getAlarmInName());
            alarmInConfig.setSwitchType(configItem.getAlarmInConfig().getSwitchType());
            alarmInConfig.setAutoClearAlarmTime(configItem.getAlarmInConfig().getAutoClearAlarmTime());
            alarmInConfig.setReserve(configItem.getAlarmInConfig().getReserve());
            
            return alarmInConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_ALARM_OUT_CFG)
        {
            if (null == configItem.getAlarmOutConfig())
            {
                return null;
            }
            
            AlarmOutConfig alarmOutConfig = new AlarmOutConfig();
            
            alarmOutConfig.setAlarmOutChanIndex(configItem.getAlarmOutConfig().getAlarmOutChanIndex());
            alarmOutConfig.setAlarmOutName(configItem.getAlarmOutConfig().getAlarmOutName());
            alarmOutConfig.setSwitchType(configItem.getAlarmOutConfig().getSwitchType());
            alarmOutConfig.setAlarmOutMode(configItem.getAlarmOutConfig().getAlarmOutMode());
            alarmOutConfig.setReserve(configItem.getAlarmOutConfig().getReserve());
            alarmOutConfig.setHoldTime(configItem.getAlarmOutConfig().getHoldTime());
            
            return alarmOutConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_DEVICE_PTZ_CFG)
        {
            if (null == configItem.getPtzConfig())
            {
                return null;
            }
            
            PTZConfig ptzConfig = new PTZConfig();
            
            ptzConfig.setDecoderAddress(configItem.getPtzConfig().getDecoderAddress());
            ptzConfig.setDecoderType(configItem.getPtzConfig().getDecoderType());
            ptzConfig.setPosNegDirectControl(configItem.getPtzConfig().getPosNegDirectControl());
            ptzConfig.setSerialCode(configItem.getPtzConfig().getSerialCode());
            ptzConfig.setReserve(configItem.getPtzConfig().getReserve());
            
            return ptzConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_EXTEND_CFG)
        {
            if (null == configItem.getCameraExtendConfig())
            {
                return null;
            }
            
            CameraExtendConfig cameraExtendConfig = new CameraExtendConfig();
            
            cameraExtendConfig.setEnableBandwidthAdaptive(configItem.getCameraExtendConfig()
                .getEnableBandwidthAdaptive());
            cameraExtendConfig.setEnableWatermark(configItem.getCameraExtendConfig().getEnableWatermark());
            cameraExtendConfig.setReliableTransmission(configItem.getCameraExtendConfig().getReliableTransmission());
            cameraExtendConfig.setFecMatrix(configItem.getCameraExtendConfig().getFecMatrix());
            cameraExtendConfig.setEnableCache(configItem.getCameraExtendConfig().getEnableCache());
            cameraExtendConfig.setReserve(configItem.getCameraExtendConfig().getReserve());
            
            MediaSecurityConfig mediaSecurityConfig = new MediaSecurityConfig();
            mediaSecurityConfig.setEnableMediaSecurity(configItem.getCameraExtendConfig()
                .getMediaSecurityConfig()
                .getEnableMediaSecurity());
            mediaSecurityConfig.setEnableSecureStorage(configItem.getCameraExtendConfig()
                .getMediaSecurityConfig()
                .getEnableSecureStorage());
            mediaSecurityConfig.setMediaSecurityAlgorithm(configItem.getCameraExtendConfig()
                .getMediaSecurityConfig()
                .getMediaSecurityAlgorithm());
            mediaSecurityConfig.setReserve(configItem.getCameraExtendConfig().getMediaSecurityConfig().getReserve());
            cameraExtendConfig.setMediaSecurityCfg(mediaSecurityConfig);
            
            return cameraExtendConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_SNAPSHOT_CFG)
        {
            if (null == configItem.getCameraSnapShotConfig())
            {
                return null;
            }
            
            CameraSnapShotConfig cameraSnapShotConfig = new CameraSnapShotConfig();
            
            cameraSnapShotConfig.setSnapCount(configItem.getCameraSnapShotConfig().getSnapCount());
            cameraSnapShotConfig.setSnapInterval(configItem.getCameraSnapShotConfig().getSnapInterval());
            cameraSnapShotConfig.setReserve(configItem.getCameraSnapShotConfig().getReserve());
            
            return cameraSnapShotConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_RECORD_STREAM_CFG)
        {
            if (null == configItem.getCameraRecordStreamConfig())
            {
                return null;
            }
            
            CameraRecordStreamConfig cameraRecordStreamConfig = new CameraRecordStreamConfig();
            
            cameraRecordStreamConfig.setStreamType(configItem.getCameraRecordStreamConfig().getStreamType());
            cameraRecordStreamConfig.setReserve(configItem.getCameraRecordStreamConfig().getReserve());
            return cameraRecordStreamConfig;
        }
        else
        {
            return null;
        }
        
    }
    
    /** 
    * getDeviceConfig领域层到北向的转换
    * 将转换后的结果封成成GetDeviceConfigResponse对象并返回
    *
    * @param result 领域层封装的getDeviceConfig结果对象
    * @param deviceType 设备类型
    * @return GetDeviceConfigResponse 获取设备配置响应体
     * @throws SDKException 
    */
    public GetDeviceConfigResponse getDeviceConfigModel2Soap(SDKResult<Object> result, int deviceType) throws SDKException
    {
        GetDeviceConfigResponse response = new GetDeviceConfigResponse();
        response.setResultCode((int)result.getErrCode());
        
        if (null == result.getResult())
        {
            return response;
        }
        
        Object config = result.getResult();
        ConfigItem configItem = new ConfigItem();
        
        if (ConfigItemEnum.CONFIG_DEVICE_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceConfig deviceConfig =
                deviceConfigModel2Soap(config);
            configItem.setDeviceConfig(deviceConfig);
        }
        else if (ConfigItemEnum.CONFIG_DEVICE_NET_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceNetConfig deviceNetConfig =
                deviceNetConfigModel2Soap(config);
            configItem.setDeviceNetConfig(deviceNetConfig);
        }
        else if (ConfigItemEnum.CONFIG_DEVICE_TIME_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceTimeConfig deviceTimeConfig =
                deviceTimeConfigModel2Soap(config);
            configItem.setDeviceTimeConfig(deviceTimeConfig);
            
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraConfig cameraConfig =
                cameraConfigModel2Soap(config);
            
            configItem.setCameraConfig(cameraConfig);
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_STREAM_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraStreamConfig cameraStreamConfig =
                cameraStreamConfigModel2Soap(config);
            
            configItem.setCameraStreamConfig(cameraStreamConfig);
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_DISPLAY_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraDisplayConfig cameraDisplayConfig =
                cameraDisplayConfigModel2Soap(config);
            
            configItem.setCameraDisplayConfig(cameraDisplayConfig);
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_IMAGING_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraImagingConfig cameraImagingConfig =
                cameraImageingConfigModel2Soap(config);
            
            configItem.setCameraImagingConfig(cameraImagingConfig);
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_OSD_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraOSDConfig cameraOSDConfig =
                cameraOSDConfigModel2Soap(config);
            
            configItem.setCameraOSDConfig(cameraOSDConfig);
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_MOTION_DETECTION_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MotionDetection motionDetection =
                motionDetectionModel2Soap(config);
            configItem.setMotionDetection(motionDetection);
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_VIDEO_HIDE_ALARM_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.VideoHideAlarm videoHideAlarm =
                videoHideAlarmModel2Soap(config);
            configItem.setVideoHideAlarm(videoHideAlarm);
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_VIDEO_MASK_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.VideoMask videoMask = videoMaskModel2Soap(config);
            
            configItem.setVideoMask(videoMask);
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_AUDIO_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioConfig audioConfig = audioConfigModel2Soap(config);
            configItem.setAudioConfig(audioConfig);
        }
        else if (ConfigItemEnum.CONFIG_SERIAL_CHANNEL_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SerialChannelConfig serialChannelConfig =
                serialChannelConfigModel2Soap(config);
            configItem.setSerialChannelConfig(serialChannelConfig);
        }
        else if (ConfigItemEnum.CONFIG_ALARM_IN_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmInConfig alarmInConfig =
                alarmInConfigModel2Soap(config);
            configItem.setAlarmInConfig(alarmInConfig);
        }
        else if (ConfigItemEnum.CONFIG_ALARM_OUT_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmOutConfig alarmOutConfig =
                alarmOutConfigModel2Soap(config);
            configItem.setAlarmOutConfig(alarmOutConfig);
        }
        else if (ConfigItemEnum.CONFIG_DEVICE_PTZ_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZConfig ptzConfig = ptzConfigModel2Soap(config);
            configItem.setPtzConfig(ptzConfig);
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_EXTEND_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraExtendConfig cameraExtendConfig =
                cameraExtendConfigModel2Soap(config);
            configItem.setCameraExtendConfig(cameraExtendConfig);
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_SNAPSHOT_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraSnapShotConfig cameraSnapShotConfig =
                cameraSnapShotConfigModel2Soap(config);
            configItem.setCameraSnapShotConfig(cameraSnapShotConfig);
        }
        else if (ConfigItemEnum.CONFIG_CAMERA_RECORD_STREAM_CFG == deviceType)
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraRecordStreamConfig cameraRecordStreamConfig =
                cameraRecordStreamConfigModel2Soap(config);
            configItem.setCameraRecordStreamConfig(cameraRecordStreamConfig);
        }
        else
        {
            Logger.getLogger(IVSProfessionalDeviceManagerConvert.class).error("deivceType error!");
        }
        
        response.setConfigItem(configItem);
        return response;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraRecordStreamConfig cameraRecordStreamConfigModel2Soap(
        Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraRecordStreamConfig cameraRecordStreamConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraRecordStreamConfig();
        com.huawei.esdk.ivs.domain.model.bean.CameraRecordStreamConfig crStreamConfig =
            (com.huawei.esdk.ivs.domain.model.bean.CameraRecordStreamConfig)config;
        cameraRecordStreamConfig.setReserve(crStreamConfig.getReserve());
        cameraRecordStreamConfig.setStreamType(crStreamConfig.getStreamType());
        return cameraRecordStreamConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraSnapShotConfig cameraSnapShotConfigModel2Soap(
        Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraSnapShotConfig cameraSnapShotConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraSnapShotConfig();
        com.huawei.esdk.ivs.domain.model.bean.CameraSnapShotConfig csShotConfig =
            (com.huawei.esdk.ivs.domain.model.bean.CameraSnapShotConfig)config;
        cameraSnapShotConfig.setReserve(csShotConfig.getReserve());
        cameraSnapShotConfig.setSnapCount(csShotConfig.getSnapCount());
        cameraSnapShotConfig.setSnapInterval(csShotConfig.getSnapInterval());
        return cameraSnapShotConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraExtendConfig cameraExtendConfigModel2Soap(
        Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraExtendConfig cameraExtendConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraExtendConfig();
        com.huawei.esdk.ivs.domain.model.bean.CameraExtendConfig ceConfig =
            (com.huawei.esdk.ivs.domain.model.bean.CameraExtendConfig)config;
        cameraExtendConfig.setEnableBandwidthAdaptive(ceConfig.getEnableBandwidthAdaptive());
        cameraExtendConfig.setEnableCache(ceConfig.getEnableCache());
        cameraExtendConfig.setEnableWatermark(ceConfig.getEnableWatermark());
        cameraExtendConfig.setFecMatrix(ceConfig.getFecMatrix());
        cameraExtendConfig.setReliableTransmission(ceConfig.getReliableTransmission());
        cameraExtendConfig.setReserve(ceConfig.getReserve());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MediaSecurityConfig mediaSecurityConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MediaSecurityConfig();
        mediaSecurityConfig.setEnableMediaSecurity(ceConfig.getMediaSecurityCfg().getEnableMediaSecurity());
        mediaSecurityConfig.setEnableSecureStorage(ceConfig.getMediaSecurityCfg().getEnableSecureStorage());
        mediaSecurityConfig.setMediaSecurityAlgorithm(ceConfig.getMediaSecurityCfg().getMediaSecurityAlgorithm());
        mediaSecurityConfig.setReserve(ceConfig.getMediaSecurityCfg().getReserve());
        cameraExtendConfig.setMediaSecurityConfig(mediaSecurityConfig);
        return cameraExtendConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZConfig ptzConfigModel2Soap(Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZConfig ptzConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZConfig();
        com.huawei.esdk.ivs.domain.model.bean.PTZConfig pConfig =
            (com.huawei.esdk.ivs.domain.model.bean.PTZConfig)config;
        ptzConfig.setDecoderAddress(pConfig.getDecoderAddress());
        ptzConfig.setDecoderType(pConfig.getDecoderType());
        ptzConfig.setPosNegDirectControl(pConfig.getPosNegDirectControl());
        ptzConfig.setReserve(pConfig.getReserve());
        ptzConfig.setSerialCode(pConfig.getSerialCode());
        return ptzConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmOutConfig alarmOutConfigModel2Soap(Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmOutConfig alarmOutConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmOutConfig();
        com.huawei.esdk.ivs.domain.model.bean.AlarmOutConfig aoConfig =
            (com.huawei.esdk.ivs.domain.model.bean.AlarmOutConfig)config;
        alarmOutConfig.setAlarmOutChanIndex(aoConfig.getAlarmOutChanIndex());
        alarmOutConfig.setAlarmOutMode(aoConfig.getAlarmOutMode());
        alarmOutConfig.setAlarmOutName(aoConfig.getAlarmOutName());
        alarmOutConfig.setHoldTime(aoConfig.getHoldTime());
        alarmOutConfig.setReserve(aoConfig.getReserve());
        alarmOutConfig.setSwitchType(aoConfig.getSwitchType());
        return alarmOutConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmInConfig alarmInConfigModel2Soap(Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmInConfig alarmInConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmInConfig();
        com.huawei.esdk.ivs.domain.model.bean.AlarmInConfig aiConfig =
            (com.huawei.esdk.ivs.domain.model.bean.AlarmInConfig)config;
        alarmInConfig.setAlarmInChanIndex(aiConfig.getAlarmInChanIndex());
        alarmInConfig.setAlarmInName(aiConfig.getAlarmInName());
        alarmInConfig.setAutoClearAlarmTime(aiConfig.getAutoClearAlarmTime());
        alarmInConfig.setReserve(aiConfig.getReserve());
        alarmInConfig.setSwitchType(aiConfig.getSwitchType());
        return alarmInConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SerialChannelConfig serialChannelConfigModel2Soap(
        Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SerialChannelConfig serialChannelConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SerialChannelConfig();
        com.huawei.esdk.ivs.domain.model.bean.SerialChannelConfig scConfig =
            (com.huawei.esdk.ivs.domain.model.bean.SerialChannelConfig)config;
        serialChannelConfig.setBaudRate(scConfig.getBaudRate());
        serialChannelConfig.setDataBit(scConfig.getDataBit());
        serialChannelConfig.setFlowControl(scConfig.getFlowControl());
        serialChannelConfig.setParity(scConfig.getParity());
        serialChannelConfig.setReserve(scConfig.getReserve());
        serialChannelConfig.setSerialIndex(scConfig.getSerialIndex());
        serialChannelConfig.setSerialName(scConfig.getSerialName());
        serialChannelConfig.setSerialType(scConfig.getSerialType());
        serialChannelConfig.setStopBit(scConfig.getStopBit());
        return serialChannelConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioConfig audioConfigModel2Soap(Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioConfig audioConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioConfig();
        com.huawei.esdk.ivs.domain.model.bean.AudioConfig aConfig =
            (com.huawei.esdk.ivs.domain.model.bean.AudioConfig)config;
        audioConfig.setAudioIndex(aConfig.getAudioIndex());
        audioConfig.setAudioName(aConfig.getAudioName());
        audioConfig.setChannelType(aConfig.getChannelType());
        audioConfig.setReserve(aConfig.getReserve());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioParam audioParam =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AudioParam();
        audioParam.setChannel(aConfig.getAudioParam().getChannel());
        audioParam.setDataFormat(aConfig.getAudioParam().getDataFormat());
        audioParam.setGain(aConfig.getAudioParam().getGain());
        audioParam.setInputType(aConfig.getAudioParam().getInputType());
        audioParam.setPitch(aConfig.getAudioParam().getPitch());
        audioParam.setReserve(aConfig.getAudioParam().getReserve());
        audioParam.setSampleBits(aConfig.getAudioParam().getSampleBits());
        audioParam.setSampleRate(aConfig.getAudioParam().getSampleRate());
        audioParam.setVolume(aConfig.getAudioParam().getVolume());
        audioConfig.setAudioParam(audioParam);
        return audioConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.VideoMask videoMaskModel2Soap(Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.VideoMask videoMask =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.VideoMask();
        com.huawei.esdk.ivs.domain.model.bean.VideoMask vMask = (com.huawei.esdk.ivs.domain.model.bean.VideoMask)config;
        videoMask.setAreaNum(vMask.getAreaNum());
        videoMask.setEnableVideoMask(vMask.getEnableVideoMask());
        videoMask.setReserve(vMask.getReserve());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo rectInfo = null;
        if (null != vMask.getRectAreas())
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfoList rectAreas = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfoList();
            List<com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo> rectInfoList = rectAreas.getRectInfo();
            for (RectFloat rf : vMask.getRectAreas())
            {
                rectInfo = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo();
                rectInfo.setBottom(rf.getBottom());
                rectInfo.setLeft(rf.getLeft());
                rectInfo.setRight(rf.getRight());
                rectInfo.setTop(rf.getTop());
                
                rectInfoList.add(rectInfo);
            }
            videoMask.setRectAreaList(rectAreas);
        }
        return videoMask;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.VideoHideAlarm videoHideAlarmModel2Soap(Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.VideoHideAlarm videoHideAlarm =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.VideoHideAlarm();
        com.huawei.esdk.ivs.domain.model.bean.VideoHideAlarm vhAlarm =
            (com.huawei.esdk.ivs.domain.model.bean.VideoHideAlarm)config;
        videoHideAlarm.setAreaNum(vhAlarm.getAreaNum());
        videoHideAlarm.setAutoClearAlarmTime(vhAlarm.getAutoClearAlarmTime());
        videoHideAlarm.setEnableVideoHide(vhAlarm.getEnableVideoHide());
        videoHideAlarm.setGuardTimeNum(vhAlarm.getGuardTimeNum());
        videoHideAlarm.setReserve(vhAlarm.getReserve());
        videoHideAlarm.setSensitivity(vhAlarm.getSensitivity());
        
        List<com.huawei.esdk.ivs.domain.model.bean.TimeSpan> timeSpanDomains = vhAlarm.getGuardTimes();
        TimeSpanList timeSpanListNorth = new TimeSpanList();
        List<com.huawei.esdk.ivs.northcommu.cxf.professional.gen.TimeSpan> timeSpans = timeSpanListNorth.getTimeSpan();
        if (null != timeSpanDomains && 0 < vhAlarm.getGuardTimeNum())
        {
            for (int i = 0; i < vhAlarm.getGuardTimeNum(); i++)
            {
                com.huawei.esdk.ivs.northcommu.cxf.professional.gen.TimeSpan timeSpanNorth =
                    getTimeSpanModel2Soap(timeSpanDomains.get(i));
                timeSpans.add(timeSpanNorth);
            }
        }
        videoHideAlarm.setGuardTimeList(timeSpanListNorth);
        
        List<com.huawei.esdk.ivs.domain.model.bean.RectFloat> rectFloatDomains = vhAlarm.getRectAreas();
        RectInfoList rectAreaListNorth = new RectInfoList();
        List<com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo> rectInfos = rectAreaListNorth.getRectInfo();
        if (null != rectFloatDomains && 0 < vhAlarm.getAreaNum())
        {
            for (int i = 0; i < vhAlarm.getAreaNum(); i++)
            {
                com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo rectInfoNorth =
                    getRectFloatModel2Soap(rectFloatDomains.get(i));
                rectInfos.add(rectInfoNorth);
            }
        }
        videoHideAlarm.setRectAreaList(rectAreaListNorth);
        
        return videoHideAlarm;
    }
    
    private RectInfo getRectFloatModel2Soap(RectFloat domain)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo rectInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo();
        rectInfo.setBottom(domain.getBottom());
        rectInfo.setLeft(domain.getLeft());
        rectInfo.setRight(domain.getRight());
        rectInfo.setTop(domain.getTop());
        return rectInfo;
    }

    private com.huawei.esdk.ivs.northcommu.cxf.professional.gen.TimeSpan getTimeSpanModel2Soap(TimeSpan domain)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.TimeSpan north =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.TimeSpan();
        north.setStartTime(domain.getStartTime());
        north.setEndTime(domain.getEndTime());
        return north;
    }

    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MotionDetection motionDetectionModel2Soap(Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MotionDetection motionDetection =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MotionDetection();
        MotionDetection detection = (MotionDetection)config;
        motionDetection.setAutoClearAlarmTime(detection.getAutoClearAlarmTime());
        motionDetection.setDetectInterval(detection.getDetectInterval());
        motionDetection.setMotionDetectionEnable(detection.getMotionDetectionEnable());
        motionDetection.setPlatformMotionDetection(detection.getPlatformMotionDetection());
        motionDetection.setRectNum(detection.getRectNum());
        motionDetection.setReserve(detection.getReserve());
        motionDetection.setSensitivity(detection.getSensitivity());
        return motionDetection;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraOSDConfig cameraOSDConfigModel2Soap(Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraOSDConfig cameraOSDConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraOSDConfig();
        com.huawei.esdk.ivs.domain.model.bean.CameraOSDConfig caConfig =
            (com.huawei.esdk.ivs.domain.model.bean.CameraOSDConfig)config;
        
        cameraOSDConfig.setEnableOSD(caConfig.getEnableOSD());
        cameraOSDConfig.setReserve(caConfig.getReserve());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.OSDName osdName =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.OSDName();
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo rectInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo();
        rectInfo.setBottom(caConfig.getOsdName().getRectText().getBottom());
        rectInfo.setLeft(caConfig.getOsdName().getRectText().getLeft());
        rectInfo.setRight(caConfig.getOsdName().getRectText().getRight());
        rectInfo.setTop(caConfig.getOsdName().getRectText().getTop());
        osdName.setRectText(rectInfo);
        osdName.setEnableOSDName(caConfig.getOsdName().getEnableOSDName());
        osdName.setEnableSwitch(caConfig.getOsdName().getEnableSwitch());
        osdName.setEnableTextBlink(caConfig.getOsdName().getEnableTextBlink());
        osdName.setEnableTextTranslucent(caConfig.getOsdName().getEnableTextTranslucent());
        osdName.setOsdNameText(caConfig.getOsdName().getOsdNameText());
        osdName.setReserve(caConfig.getOsdName().getReserve());
        osdName.setSwitchInterval(caConfig.getOsdName().getSwitchInterval());
        osdName.setTextTranslucentPercent(caConfig.getOsdName().getTextTranslucentPercent());
        cameraOSDConfig.setOsdName(osdName);
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.OSDTime osdTime =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.OSDTime();
        osdTime.setEnableOSDTime(caConfig.getOsdTime().getEnableOSDTime());
        osdTime.setReserve(caConfig.getOsdTime().getReserve());
        osdTime.setTimeFormat(caConfig.getOsdTime().getTimeFormat());
        osdTime.setTimeX(caConfig.getOsdTime().getTimeX());
        osdTime.setTimeY(caConfig.getOsdTime().getTimeY());
        cameraOSDConfig.setOsdTime(osdTime);
        return cameraOSDConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraImagingConfig cameraImageingConfigModel2Soap(
        Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraImagingConfig cameraImagingConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraImagingConfig();
        CameraImagingConfig ciConfig = (CameraImagingConfig)config;
        
        cameraImagingConfig.setIrCutFilter(ciConfig.getIrCutFilter());
        cameraImagingConfig.setReserve(ciConfig.getReserve());
        cameraImagingConfig.setSharpness(ciConfig.getSharpness());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.Backlight backlight =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.Backlight();
        backlight.setBacklightLevel(ciConfig.getBacklight().getBacklightLevel());
        backlight.setBacklightMode(ciConfig.getBacklight().getBacklightMode());
        backlight.setReserve(ciConfig.getBacklight().getReserve());
        cameraImagingConfig.setBacklight(backlight);
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.Exposure exposure =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.Exposure();
        exposure.setExposureGain(ciConfig.getExposure().getExposureGain());
        exposure.setExposureIris(ciConfig.getExposure().getExposureIris());
        exposure.setExposureMode(ciConfig.getExposure().getExposureMode());
        exposure.setExposurePriority(ciConfig.getExposure().getExposurePriority());
        exposure.setExposureTime(ciConfig.getExposure().getExposureTime());
        exposure.setReserve(ciConfig.getExposure().getReserve());
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo rectInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RectInfo();
        rectInfo.setBottom(ciConfig.getExposure().getRectWindow().getBottom());
        rectInfo.setLeft(ciConfig.getExposure().getRectWindow().getLeft());
        rectInfo.setRight(ciConfig.getExposure().getRectWindow().getRight());
        rectInfo.setTop(ciConfig.getExposure().getRectWindow().getTop());
        exposure.setRectWindow(rectInfo);
        cameraImagingConfig.setExposure(exposure);
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.Focus focus =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.Focus();
        focus.setFarLimit(ciConfig.getFocus().getFarLimit());
        focus.setFocusMode(ciConfig.getFocus().getFocusMode());
        focus.setFocusSpeed(ciConfig.getFocus().getFocusSpeed());
        focus.setNearLimit(ciConfig.getFocus().getNearLimit());
        focus.setReserve(ciConfig.getFocus().getReserve());
        cameraImagingConfig.setFocus(focus);
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.Stabilization stabilization =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.Stabilization();
        stabilization.setReserve(ciConfig.getStabilization().getReserve());
        stabilization.setStabilizationLevel(ciConfig.getStabilization().getStabilizationLevel());
        stabilization.setStabilizationMode(ciConfig.getStabilization().getStabilizationMode());
        cameraImagingConfig.setStabilization(stabilization);
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.WhiteBalance whiteBalance =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.WhiteBalance();
        whiteBalance.setBlueGain(ciConfig.getWhiteBalance().getCbGain());
        whiteBalance.setRedGain(ciConfig.getWhiteBalance().getCrGain());
        whiteBalance.setReserve(ciConfig.getWhiteBalance().getReserve());
        whiteBalance.setWhiteBalanceMode(ciConfig.getWhiteBalance().getWhiteBalanceMode());
        cameraImagingConfig.setWhiteBalance(whiteBalance);
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.WideDynamic wideDynamic =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.WideDynamic();
        wideDynamic.setReserve(ciConfig.getWideDynamic().getReserve());
        wideDynamic.setWideDynamicLevel(ciConfig.getWideDynamic().getWideDynamicLevel());
        wideDynamic.setWideDynamicMode(ciConfig.getWideDynamic().getWideDynamicMode());
        cameraImagingConfig.setWideDynamic(wideDynamic);
        return cameraImagingConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraDisplayConfig cameraDisplayConfigModel2Soap(
        Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraDisplayConfig cameraDisplayConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraDisplayConfig();
        CameraDisplayConfig cdConfig = (CameraDisplayConfig)config;
        cameraDisplayConfig.setBrightness(cdConfig.getBrightness());
        cameraDisplayConfig.setContrast(cdConfig.getContrast());
        cameraDisplayConfig.setHue(cdConfig.getHue());
        cameraDisplayConfig.setReserve(cdConfig.getReserve());
        cameraDisplayConfig.setSaturation(cdConfig.getSaturation());
        return cameraDisplayConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraStreamConfig cameraStreamConfigModel2Soap(
        Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraStreamConfig cameraStreamConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraStreamConfig();
        CameraStreamConfig csConfig = (CameraStreamConfig)config;
        cameraStreamConfig.setStreamInfoNum(csConfig.getStreamInfoNum());
        cameraStreamConfig.setReserve(csConfig.getReserve());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StreamInfo streamInfo = null;
        if (null != csConfig.getStreamInfos())
        {
            StreamInfoList streamInfos = new StreamInfoList();
            List<com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StreamInfo> streamInfoList = streamInfos.getStreamInfo();
            for (com.huawei.esdk.ivs.domain.model.bean.StreamInfo si : csConfig.getStreamInfos())
            {
                streamInfo = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StreamInfo();
                streamInfo.setBitRate(si.getBitRate());
                streamInfo.setBitRateType(si.getBitRateType());
                streamInfo.setEncodeType(si.getEncodeType());
                streamInfo.setFrameInterval(si.getFrameInterval());
                streamInfo.setFrameRate(si.getFrameRate());
                streamInfo.setPicQuality(si.getPicQuality());
                streamInfo.setPktProtocol(si.getPktProtocol());
                streamInfo.setProfile(si.getProfile());
                streamInfo.setReserve(si.getReserve());
                streamInfo.setResolution(si.getResolution());
                streamInfo.setStreamType(si.getStreamType());
                streamInfo.setTransProtocol(si.getTransProtocol());
                
                streamInfoList.add(streamInfo);
            }
            cameraStreamConfig.setStreamInfoList(streamInfos);
        }
        return cameraStreamConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraConfig cameraConfigModel2Soap(Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraConfig cameraConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraConfig();
        CameraConfig cConfig = (CameraConfig)config;
        cameraConfig.setCameraCode(cConfig.getCameraCode());
        cameraConfig.setCameraName(cConfig.getCameraName());
        cameraConfig.setCameraStatus(cConfig.getCameraStatus());
        cameraConfig.setCameraType(cConfig.getCameraType());
        cameraConfig.setEnableVoice(cConfig.getEnableVoice());
        cameraConfig.setIsSupportBroadcast(cConfig.getSupportBroadcast());
        cameraConfig.setNvrCode(cConfig.getNvrCode());
        cameraConfig.setParentCode(cConfig.getParentCode());
        cameraConfig.setReserve(cConfig.getReserve());
        cameraConfig.setVideoChannel(cConfig.getVideoChannel());
        cameraConfig.setVoiceOutCode(cConfig.getVoiceOutCode());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.BroadcastInfo broadcastInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.BroadcastInfo();
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo ipInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo();
        ipInfo.setIp(cConfig.getBroadcastInfo().getIpInfo().getIp());
        ipInfo.setIpType(cConfig.getBroadcastInfo().getIpInfo().getIpType());
        broadcastInfo.setIp(ipInfo);
        broadcastInfo.setPort(cConfig.getBroadcastInfo().getPort());
        broadcastInfo.setReserve(cConfig.getBroadcastInfo().getReserve());
        broadcastInfo.setTimeToLive(cConfig.getBroadcastInfo().getTimeToLive());
        cameraConfig.setBroadcastInfo(broadcastInfo);
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraPosition cameraPosition =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.CameraPosition();
        cameraPosition.setCameraLocationDesc(cConfig.getPositionInfo().getCameraLocationDesc());
        cameraPosition.setHeight(cConfig.getPositionInfo().getHeight());
        cameraPosition.setLatitude(cConfig.getPositionInfo().getLatitude());
        cameraPosition.setLongitude(cConfig.getPositionInfo().getLongitude());
        cameraPosition.setReserve(cConfig.getPositionInfo().getReserve());
        cameraConfig.setCameraPosition(cameraPosition);
        return cameraConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceTimeConfig deviceTimeConfigModel2Soap(Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceTimeConfig deviceTimeConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceTimeConfig();
        DeviceTimeConfig dtConfig = (DeviceTimeConfig)config;
        deviceTimeConfig.setEnableDST(dtConfig.getEnableDst());
        deviceTimeConfig.setEnableNTP(dtConfig.getEnableNtp());
        deviceTimeConfig.setReserve(dtConfig.getReserve());
        deviceTimeConfig.setTimezone(dtConfig.getTimezone());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.NTPInfo ntpInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.NTPInfo();
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo ipInfo = null;
        
        ipInfo = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo();
        ipInfo.setIp(dtConfig.getNtp().getDnsIP().getIp());
        ipInfo.setIpType(dtConfig.getNtp().getDnsIP().getIpType());
        ntpInfo.setDnsIP(ipInfo);
        
        ipInfo = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo();
        ipInfo.setIp(dtConfig.getNtp().getNtpServerIP().getIp());
        ipInfo.setIpType(dtConfig.getNtp().getNtpServerIP().getIpType());
        ntpInfo.setNtpServerIP(ipInfo);
        
        ntpInfo.setNtpType(dtConfig.getNtp().getNtpType());
        ntpInfo.setReserve(dtConfig.getNtp().getReserve());
        
        deviceTimeConfig.setNtp(ntpInfo);
        return deviceTimeConfig;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceNetConfig deviceNetConfigModel2Soap(Object config)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceNetConfig deviceNetConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceNetConfig();
        DeviceNetConfig dnConfig = (DeviceNetConfig)config;
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo ipInfo = null;
        
        deviceNetConfig.setMaxMtu(dnConfig.getMaxMtu());
        deviceNetConfig.setPuPort(dnConfig.getPuPort());
        deviceNetConfig.setReserve(dnConfig.getReserve());
        
        ipInfo = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo();
        ipInfo.setIp(dnConfig.getPuGateway().getIp());
        ipInfo.setIpType(dnConfig.getPuGateway().getIpType());
        deviceNetConfig.setPuGateway(ipInfo);
        
        ipInfo = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo();
        ipInfo.setIp(dnConfig.getPuIp().getIp());
        ipInfo.setIpType(dnConfig.getPuIp().getIpType());
        deviceNetConfig.setPuIP(ipInfo);
        
        ipInfo = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo();
        ipInfo.setIp(dnConfig.getSubNetMask().getIp());
        ipInfo.setIpType(dnConfig.getSubNetMask().getIpType());
        deviceNetConfig.setSubNetMask(ipInfo);
        return deviceNetConfig;
    }
    
    public DeviceConfig deviceConfigModel2Soap(Object config) throws SDKException
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceConfig deviceConfig =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceConfig();
        Device device = (Device)config;
        
        String psw = device.getDeviceOperInfo().getDevPasswd();
        String rpsw = device.getDeviceOperInfo().getDevRegPasswd();
        
        if (!StringUtils.isEmpty(psw))
        {
            String devicePas = "";
            try
            {
                devicePas = CipherUtils.encode(psw);
            }
            catch (SDKException e)
            {
                throw e;
            }
            if (StringUtils.isEmpty(devicePas))
            {
                SDKException sdkException = new SDKException(ErrInfo.PWD_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.PWD_ERRORCODE);
                throw sdkException;
            }
            deviceConfig.setDevicePassword(devicePas);
            
        }
        else
        {
            deviceConfig.setDevicePassword(psw);
        }
        
        if (!StringUtils.isEmpty(rpsw))
        {
            String deviceRegPas = "";
            try
            {
                deviceRegPas = CipherUtils.encode(rpsw);
            }
            catch (SDKException e)
            {
                throw e;
            }
            if (StringUtils.isEmpty(deviceRegPas))
            {
                SDKException sdkException = new SDKException(ErrInfo.PWD_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.PWD_ERRORCODE);
                throw sdkException;
            }
            deviceConfig.setDeviceRegPassword(deviceRegPas);
        }
        else
        {
            deviceConfig.setDeviceRegPassword(rpsw);
        }
        
        deviceConfig.setDeviceUser(device.getDeviceOperInfo().getDevUser());
        deviceConfig.setDirectConnectFirst(device.getDeviceOperInfo().getIsDirectConnectFirst());
        deviceConfig.setEnableAlarm(device.getDeviceOperInfo().getEnableAlarm());
        deviceConfig.setEnableSchedule(device.getDeviceOperInfo().getEnableSchedule());
        deviceConfig.setLoginType(device.getDeviceOperInfo().getLoginType());
        deviceConfig.setMaxDirectConnectNum(device.getDeviceOperInfo().getMaxDirectConnectNum());
        deviceConfig.setNvrCode(device.getDeviceOperInfo().getNvrCode());
        deviceConfig.setProtocolType(device.getDeviceOperInfo().getProtocolType());
        deviceConfig.setReserve(device.getDeviceOperInfo().getReserve());
        deviceConfig.setTasCode(device.getDeviceOperInfo().getTasCode());
        if (null != device.getDeviceOperInfo().getTasIp())
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo tasIp =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo();
            tasIp.setIp(device.getDeviceOperInfo().getTasIp().getIp());
            tasIp.setIpType(device.getDeviceOperInfo().getTasIp().getIpType());
            deviceConfig.setTasIP(tasIp);
        }
        deviceConfig.setVideoFormat(device.getDeviceOperInfo().getVideoFormat());
        
        DeviceBasicInfo deviceBasicInfo = new DeviceBasicInfo();
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo ipInfo =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo();
        ipInfo.setIp(device.getDeviceBasicInfo().getIpInfo().getIp());
        ipInfo.setIpType(device.getDeviceBasicInfo().getIpInfo().getIpType());
        deviceBasicInfo.setIpInfo(ipInfo);
        deviceBasicInfo.setCode(device.getDeviceBasicInfo().getCode());
        deviceBasicInfo.setDomainCode(device.getDeviceBasicInfo().getDomainCode());
        deviceBasicInfo.setModel(device.getDeviceBasicInfo().getModel());
        deviceBasicInfo.setName(device.getDeviceBasicInfo().getName());
        deviceBasicInfo.setParentCode(device.getDeviceBasicInfo().getParentCode());
        deviceBasicInfo.setPort(device.getDeviceBasicInfo().getPort());
        deviceBasicInfo.setReserve(device.getDeviceBasicInfo().getReserve());
        deviceBasicInfo.setSerialNumber(device.getDeviceBasicInfo().getSerialNumber());
        deviceBasicInfo.setType(device.getDeviceBasicInfo().getType());
        deviceBasicInfo.setVendorType(device.getDeviceBasicInfo().getVendorType());
        
        DeviceChannel deviceChannel = new DeviceChannel();
        deviceChannel.setMaxAlarmInNum(device.getDeviceChannelConfig().getMaxAlarmInNum());
        deviceChannel.setMaxAlarmOutNum(device.getDeviceChannelConfig().getMaxAlarmOutNum());
        deviceChannel.setMaxAudioInNum(device.getDeviceChannelConfig().getMaxAudioInNum());
        deviceChannel.setMaxAudioOutNum(device.getDeviceChannelConfig().getMaxAudioOutNum());
        deviceChannel.setMaxSerialNum(device.getDeviceChannelConfig().getMaxSerialNum());
        deviceChannel.setMaxVideoNum(device.getDeviceChannelConfig().getMaxVideoNum());
        deviceChannel.setReserve(device.getDeviceChannelConfig().getReserve());
        
        deviceConfig.setDeviceBasicInfo(deviceBasicInfo);
        deviceConfig.setDeviceChannel(deviceChannel);
        return deviceConfig;
    }
    
    public DeviceOperResultInfos addDeviceModel2Soap(DeviceOperResultList deviceOperResultList)
    {
        DeviceOperResultInfos deviceOperResultInfo = new DeviceOperResultInfos();
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceOperResultList deviceOperResultListSoap =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceOperResultList();
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceOperResult deviceOperResultSoap = null;
        deviceOperResultInfo.setNumber(deviceOperResultList.getNum());
        if (null != deviceOperResultList.getDeviceOperResults())
        {
            for (DeviceOperResult deviceOperResultModel : deviceOperResultList.getDeviceOperResults())
            {
                deviceOperResultSoap = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceOperResult();
                deviceOperResultSoap.setDeviceCode(deviceOperResultModel.getCode());
                deviceOperResultSoap.setNvrCode(deviceOperResultModel.getNvrCode());
                deviceOperResultSoap.setReserve(deviceOperResultModel.getReserve());
                deviceOperResultSoap.setResult(deviceOperResultModel.getResult());
                deviceOperResultSoap.setSequence(deviceOperResultModel.getSequence());
                
                deviceOperResultListSoap.getDeviceOperResult().add(deviceOperResultSoap);
            }
        }
        deviceOperResultInfo.setDeviceOperResultList(deviceOperResultListSoap);
        return deviceOperResultInfo;
    }
    
    public GetDeviceGroupResponse getDeviceGroupResponseModel2Soap(SDKResult<DeviceGroupInfos> result)
    {
        GetDeviceGroupResponse response = new GetDeviceGroupResponse();
        response.setResultCode((int)result.getErrCode());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceGroupInfos soap =
            getDeviceGroupInfosModel2Soap(result.getResult());
        if (null != soap)
        {
            response.setDeviceGroupInfos(soap);
        }
        return response;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceGroupInfos getDeviceGroupInfosModel2Soap(
        DeviceGroupInfos domain)
    {
        if (null == domain)
        {
            return null;
        }
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceGroupInfos soap =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceGroupInfos();
        soap.setTotal(domain.getTotal());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexRangeSoap =
            new IVSProfessionalClusterManagerConvert().getIndexRangeModel2Soap(domain.getIndexRange());
        if (null != indexRangeSoap)
        {
            soap.setIndexRange(indexRangeSoap);
        }
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceGroupList deviceGroupListSoap =
            getDeviceGroupListModel2Soap(domain.getDeviceGroupList());
        if (null != deviceGroupListSoap)
        {
            soap.setDeviceGroupList(deviceGroupListSoap);
        }
        
        return soap;
    }
    
    public DeviceGroupList getDeviceGroupListModel2Soap(com.huawei.esdk.ivs.domain.model.bean.DeviceGroupList domain)
    {
        if (null == domain)
        {
            return null;
        }
        DeviceGroupList soap = new DeviceGroupList();
        List<com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceGroup> deviceGroupSoaps = soap.getDeviceGroup();
        List<com.huawei.esdk.ivs.domain.model.bean.DeviceGroup> deviceGroups = domain.getDeviceGroups();
        if (null != deviceGroups)
        {
            for (com.huawei.esdk.ivs.domain.model.bean.DeviceGroup deviceGroup : deviceGroups)
            {
                com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceGroup deviceGroupSoap =
                    getDeviceGroupModel2Soap(deviceGroup);
                if (null != deviceGroupSoap)
                {
                    deviceGroupSoaps.add(deviceGroupSoap);
                }
            }
        }
        return soap;
    }
    
    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceGroup getDeviceGroupModel2Soap(DeviceGroup domain)
    {
        if (null == domain)
        {
            return null;
        }
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceGroup soap =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceGroup();
        
        soap.setDomainCode(domain.getDomainCode());
        soap.setGroupCode(domain.getGroupCode());
        soap.setGroupName(domain.getGroupName());
        soap.setIsExDomain(domain.getIsExDomain());
        soap.setParentGroupCode(domain.getParentGroupCode());
        soap.setReserve(domain.getReserve());
        return soap;
    }
}
