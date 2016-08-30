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
package com.huawei.esdk.ivs.device.v100r001c10.devicemanager.convert;

import java.util.ArrayList;
import java.util.List;

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
import com.huawei.esdk.ivs.domain.model.bean.DeviceBasicInfo;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfo;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.DeviceChannelConfig;
import com.huawei.esdk.ivs.domain.model.bean.DeviceCode;
import com.huawei.esdk.ivs.domain.model.bean.DeviceGroup;
import com.huawei.esdk.ivs.domain.model.bean.DeviceGroupInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceGroupList;
import com.huawei.esdk.ivs.domain.model.bean.DeviceNetConfig;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperInfo;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResult;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.DeviceTimeConfig;
import com.huawei.esdk.ivs.domain.model.bean.DomainRoute;
import com.huawei.esdk.ivs.domain.model.bean.DomainRouteList;
import com.huawei.esdk.ivs.domain.model.bean.Exposure;
import com.huawei.esdk.ivs.domain.model.bean.Focus;
import com.huawei.esdk.ivs.domain.model.bean.IPInfo;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.MediaSecurityConfig;
import com.huawei.esdk.ivs.domain.model.bean.MotionDetection;
import com.huawei.esdk.ivs.domain.model.bean.NTPInfo;
import com.huawei.esdk.ivs.domain.model.bean.OSDName;
import com.huawei.esdk.ivs.domain.model.bean.OSDTime;
import com.huawei.esdk.ivs.domain.model.bean.PTZConfig;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RectFloat;
import com.huawei.esdk.ivs.domain.model.bean.SerialChannelConfig;
import com.huawei.esdk.ivs.domain.model.bean.Stabilization;
import com.huawei.esdk.ivs.domain.model.bean.StreamInfo;
import com.huawei.esdk.ivs.domain.model.bean.TimeSpan;
import com.huawei.esdk.ivs.domain.model.bean.VideoHideAlarm;
import com.huawei.esdk.ivs.domain.model.bean.VideoMask;
import com.huawei.esdk.ivs.domain.model.bean.WhiteBalance;
import com.huawei.esdk.ivs.domain.model.bean.WideDynamic;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.IndexRangeSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryFieldSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryUnifiedFormatSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.DeviceBriefInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.DeviceBriefInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.IPInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AlarmBriefInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AlarmBriefInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AlarmInConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AlarmOutConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AudioBriefInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AudioBriefInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AudioConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AudioParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.BacklightSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.BroadcastInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraBriefInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraBriefInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraDisplayConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraExtendConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraImagingConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraOSDConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraPositionSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraRecordStreamConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraSnapshotConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraStreamConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceBasicInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceChannelConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceCodeListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceCodeSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceGroupListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceGroupSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceNetConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceOperInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceOperResultListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceOperResultSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceTimeConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DomainRouteListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DomainRouteSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.ExposureSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.FocusSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.MediaSecurityConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.MotionDetectionSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.NTPInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.OSDNameSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.OSDTimeSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.PTZConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.RectFloatSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.ResultInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.ResultListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.SerialChannelConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.StabilizationSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.StreamInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.VideoHideAlarmSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.VideoMaskSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.WhiteBalanceSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.WideDynamicSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.TimeSpanSouth;
import com.huawei.esdk.platform.common.utils.BytesUtils;
import com.sun.jna.Native;
import com.sun.jna.Structure;

/**
 * 领域层与南向数据转换类
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  [V100R003]
 */
public class DeviceMgrCabilityConvert
{
    public DomainRouteList getDomainRouteListSouth2Model(DomainRouteListSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DomainRouteList domain = new DomainRouteList();
        domain.setTotal(south.total);
        List<DomainRoute> domainRoutes = null;
        DomainRouteSouth[] domainRouteSouths = south.domainRoutes;
        if (null != domainRouteSouths && south.total > 0)
        {
            domainRoutes = new ArrayList<DomainRoute>();
            int length = south.total;
            for (int i = 0; i < length; i++)
            {
                DomainRoute domainRoute = getDomainRouteSouth2Model(domainRouteSouths[i]);
                if (null != domainRoute)
                {
                    domainRoutes.add(domainRoute);
                }
            }
            domain.setDomainRoutes(domainRoutes);
        }
        return domain;
    }
    
    public DomainRoute getDomainRouteSouth2Model(DomainRouteSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DomainRoute domain = new DomainRoute();
        domain.setDomainCode(BytesUtils.bytesToStringForIVS(south.domainCode));
        IPInfo ip = getIPInfoSouth2Model(south.ip);
        if (null != ip)
        {
            domain.setDomainIPInfo(ip);
        }
        domain.setDomainName(BytesUtils.bytesToStringForIVS(south.domainName));
        domain.setDomainPort(south.port);
        domain.setDomainType(south.domainType);
        domain.setIsAgent(south.isAgent);
        domain.setIsLocalDomain(south.isLocalDomain);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSuperDomain(BytesUtils.bytesToStringForIVS(south.superDomain));
        return domain;
    }
    
    public IPInfo getIPInfoSouth2Model(IPInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        IPInfo ip = new IPInfo();
        ip.setIp(BytesUtils.bytesToStringForIVS(south.ip));
        ip.setIpType(south.ipType);
        return ip;
    }
    
    public DeviceCodeListSouth getDeviceCodeListSouthModel2South(List<DeviceCode> deviceCodes)
    {
        if (null == deviceCodes || deviceCodes.size() < 1)
        {
            return null;
        }
        int length = deviceCodes.size();
        DeviceCodeListSouth deviceCodeListSouth = new DeviceCodeListSouth(length);
        deviceCodeListSouth.clear();
        DeviceCodeSouth[] deviceCodeSouths = deviceCodeListSouth.deviceCodeSouths;
        for (int i = 0; i < length; i++)
        {
            DeviceCode deviceCode = deviceCodes.get(i);
            DeviceCodeSouth deviceCodeSouth = new DeviceCodeSouth();
            deviceCodeSouth.clear();
            deviceCodeSouth.deviceCode =
                BytesUtils.stringToBytesForIVS(deviceCode.getDevCode(), CommonConstant.DeviceModule.IVS_DEV_CODE_LEN);
            deviceCodeSouths[i] = deviceCodeSouth;
        }
        return deviceCodeListSouth;
    }
    
    public DeviceOperResultList getResultListSouth2Model(ResultListSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceOperResultList domain = new DeviceOperResultList();
        domain.setNum(south.number);
        ResultInfoSouth[] resultInfoSouth = south.resultInfoSouths;
        if (null != resultInfoSouth && south.number > 0)
        {
            List<DeviceOperResult> resultInfos = new ArrayList<DeviceOperResult>();
            for (int i = 0, length = south.number; i < length; i++)
            {
                DeviceOperResult resultInfo = getResultInfoSouth2Model(resultInfoSouth[i]);
                if (null != resultInfo)
                {
                    resultInfos.add(resultInfo);
                }
            }
            if (resultInfos.size() > 0)
            {
                domain.setDeviceOperResults(resultInfos);
            }
        }
        return domain;
    }
    
    public DeviceOperResult getResultInfoSouth2Model(ResultInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceOperResult domain = new DeviceOperResult();
        domain.setCode(BytesUtils.bytesToStringForIVS(south.code));
        domain.setResult(south.result);
        domain.setSequence(south.sequence);
        return domain;
    }
    
    public DeviceOperInfoSouth[] addDeviceModel2South(List<Device> deviceInfos)
    {
        DeviceOperInfoSouth deviceSouth = new DeviceOperInfoSouth();
        DeviceOperInfoSouth[] deviceSouths = (DeviceOperInfoSouth[])deviceSouth.toArray(deviceInfos.size());
        
        for (int i = 0; i < deviceInfos.size(); i++)
        {
            Device deviceInfo = deviceInfos.get(i);
            
            deviceSouths[i].reserve = BytesUtils.stringToBytesForIVS(deviceInfo.getReserve());
            deviceSouths[i].sequence = deviceInfo.getSequence();
            
            DeviceConfigSouth deviceConfigSouth = new DeviceConfigSouth();
            deviceConfigSouth.clear();
            
            deviceConfigSouth.devPasswd = BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceOperInfo().getDevPasswd());
            deviceConfigSouth.devRegPasswd =
                BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceOperInfo().getDevRegPasswd());
            deviceConfigSouth.devUser = BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceOperInfo().getDevUser());
            deviceConfigSouth.directConnectFirst = deviceInfo.getDeviceOperInfo().getIsDirectConnectFirst();
            deviceConfigSouth.enableAlarm = deviceInfo.getDeviceOperInfo().getEnableAlarm();
            deviceConfigSouth.enableSchedule = deviceInfo.getDeviceOperInfo().getEnableSchedule();
            deviceConfigSouth.loginType = deviceInfo.getDeviceOperInfo().getLoginType();
            deviceConfigSouth.maxDirectConnectNum = deviceInfo.getDeviceOperInfo().getMaxDirectConnectNum();
            deviceConfigSouth.nvrCode = BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceOperInfo().getNvrCode());
            deviceConfigSouth.protocolType =
                BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceOperInfo().getProtocolType());
            deviceConfigSouth.reserve = BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceOperInfo().getReserve());
            deviceConfigSouth.tasCode = BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceOperInfo().getTasCode());
            
            if (null != deviceInfo.getDeviceOperInfo().getTasIp())
            {
                IPInfoSouth ipInfoSouth = new IPInfoSouth();
                ipInfoSouth.clear();
                ipInfoSouth.ip = BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceOperInfo().getTasIp().getIp());
                ipInfoSouth.ipType = deviceInfo.getDeviceOperInfo().getTasIp().getIpType();
                deviceConfigSouth.tasIp = ipInfoSouth;
            }
            
            deviceConfigSouth.videoFormat = deviceInfo.getDeviceOperInfo().getVideoFormat();
            
            DeviceBasicInfoSouth deviceBasicInfoSouth = new DeviceBasicInfoSouth();
            deviceBasicInfoSouth.clear();
            
            deviceBasicInfoSouth.code = BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceBasicInfo().getCode());
            deviceBasicInfoSouth.domainCode =
                BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceBasicInfo().getDomainCode());
            deviceBasicInfoSouth.name = BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceBasicInfo().getName());
            deviceBasicInfoSouth.parentCode =
                BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceBasicInfo().getParentCode());
            deviceBasicInfoSouth.port = deviceInfo.getDeviceBasicInfo().getPort();
            deviceBasicInfoSouth.reserve = BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceBasicInfo().getReserve());
            deviceBasicInfoSouth.serialNumber =
                BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceBasicInfo().getSerialNumber());
            deviceBasicInfoSouth.type = deviceInfo.getDeviceBasicInfo().getType();
            deviceBasicInfoSouth.vendorType =
                BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceBasicInfo().getVendorType());
            
            IPInfoSouth ipInfoSouth = new IPInfoSouth();
            ipInfoSouth.clear();
            ipInfoSouth.ip = BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceBasicInfo().getIpInfo().getIp());
            ipInfoSouth.ipType = deviceInfo.getDeviceBasicInfo().getIpInfo().getIpType();
            deviceBasicInfoSouth.stIP = ipInfoSouth;
            
            deviceConfigSouth.deviceBasicInfo = deviceBasicInfoSouth;
            
            DeviceChannelConfigSouth deviceChannelConfigSouth = new DeviceChannelConfigSouth();
            deviceChannelConfigSouth.clear();
            
            deviceChannelConfigSouth.maxAlarmInNum = deviceInfo.getDeviceChannelConfig().getMaxAlarmInNum();
            deviceChannelConfigSouth.maxAlarmOutNum = deviceInfo.getDeviceChannelConfig().getMaxAlarmOutNum();
            deviceChannelConfigSouth.maxAudioInNum = deviceInfo.getDeviceChannelConfig().getMaxAudioInNum();
            deviceChannelConfigSouth.maxAudioOutNum = deviceInfo.getDeviceChannelConfig().getMaxAudioOutNum();
            deviceChannelConfigSouth.maxSerialNum = deviceInfo.getDeviceChannelConfig().getMaxSerialNum();
            deviceChannelConfigSouth.maxVideoNum = deviceInfo.getDeviceChannelConfig().getMaxVideoNum();
            deviceChannelConfigSouth.reserve =
                BytesUtils.stringToBytesForIVS(deviceInfo.getDeviceChannelConfig().getReserve());
            deviceConfigSouth.deviceChannel = deviceChannelConfigSouth;
            
            deviceSouths[i].deviceConfigSouth = deviceConfigSouth;
        }
        
        return deviceSouths;
    }
    
    public IndexRangeSouth convertIndexRangeToSouth(IndexRange indexRange)
    {
        IndexRangeSouth indexRangeSouth = new IndexRangeSouth();
        indexRangeSouth.clear();
        indexRangeSouth.fromIndex = indexRange.getFromIndex();
        indexRangeSouth.toIndex = indexRange.getToIndex();
        return indexRangeSouth;
    }
    
    public IndexRange convertIndexRangeSouthToDomain(IndexRangeSouth indexRangeSouth)
    {
        IndexRange indexRange = new IndexRange();
        indexRange.setFromIndex(indexRangeSouth.fromIndex);
        indexRange.setToIndex(indexRangeSouth.toIndex);
        return indexRange;
    }
    
    public AlarmBriefInfoList convertAlarmBriefInfoListSouthToDomain(AlarmBriefInfoListSouth alarmBriefInfoListSouth)
    {
        AlarmBriefInfoList alarmBriefInfoList = new AlarmBriefInfoList();
        
        // 转换
        alarmBriefInfoList.setTotal(alarmBriefInfoListSouth.total);
        alarmBriefInfoList.setReserve(BytesUtils.bytesToStringForIVS(alarmBriefInfoListSouth.reserve));
        alarmBriefInfoList.setIndexRange(convertIndexRangeSouthToDomain(alarmBriefInfoListSouth.indexRange));
        AlarmBriefInfoSouth[] alarmBriefInfoSouths = alarmBriefInfoListSouth.alarmBriefInfoSouth;
        
        if (null != alarmBriefInfoSouths && alarmBriefInfoSouths.length > 0)
        {
            
            int length =
                getLength(alarmBriefInfoListSouth.total,
                    alarmBriefInfoSouths.length,
                    alarmBriefInfoListSouth.indexRange.fromIndex,
                    alarmBriefInfoListSouth.indexRange.toIndex);

            List<AlarmBriefInfo> list = new ArrayList<AlarmBriefInfo>();
            
            for (int i = 0; i < length; i++)
            {
                list.add(convertAlarmBriefInfoSouthToDomain(alarmBriefInfoSouths[i]));
            }
            
            alarmBriefInfoList.setAlarmBriefInfo(list);
        }
        
        return alarmBriefInfoList;
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
    
    public AudioBriefInfoList convertAudioBriefInfoListSouthToDomain(AudioBriefInfoListSouth audioBriefInfoListSouth)
    {
        AudioBriefInfoList audioBriefInfoList = new AudioBriefInfoList();
        
        // 转换
        audioBriefInfoList.setTotal(audioBriefInfoListSouth.total);
        audioBriefInfoList.setReserve(BytesUtils.bytesToStringForIVS(audioBriefInfoListSouth.reserve));
        audioBriefInfoList.setIndexRange(convertIndexRangeSouthToDomain(audioBriefInfoListSouth.indexRange));
        AudioBriefInfoSouth[] audioBriefInfoSouths = audioBriefInfoListSouth.audioBriefInfoSouth;
        
        if (null != audioBriefInfoSouths && audioBriefInfoSouths.length > 0)
        {
            
            int length =
                getLength(audioBriefInfoListSouth.total,
                    audioBriefInfoSouths.length,
                    audioBriefInfoListSouth.indexRange.fromIndex,
                    audioBriefInfoListSouth.indexRange.toIndex);
            
            List<AudioBriefInfo> list = new ArrayList<AudioBriefInfo>();
            
            for (int i = 0; i < length; i++)
            {
                list.add(convertAudioBriefInfoSouthToDomain(audioBriefInfoSouths[i]));
            }
            
            audioBriefInfoList.setAudioBriefInfo(list);
        }
        
        return audioBriefInfoList;
    }
    
    public CameraBriefInfoList convertCameraBriefInfoListSouthToDomain(CameraBriefInfoListSouth cameraBriefInfoListSouth)
    {
        CameraBriefInfoList cameraBriefInfoList = new CameraBriefInfoList();
        
        // 转换
        cameraBriefInfoList.setTotal(cameraBriefInfoListSouth.total);
        cameraBriefInfoList.setIndexRange(convertIndexRangeSouthToDomain(cameraBriefInfoListSouth.indexRange));
        CameraBriefInfoSouth[] cameraBriefInfoSouths = cameraBriefInfoListSouth.cameraBriefInfoSouth;
        
        if (null != cameraBriefInfoSouths && cameraBriefInfoSouths.length > 0)
        {
            int length =
                getLength(cameraBriefInfoListSouth.total,
                    cameraBriefInfoSouths.length,
                    cameraBriefInfoListSouth.indexRange.fromIndex,
                    cameraBriefInfoListSouth.indexRange.toIndex);
            
            List<CameraBriefInfo> list = new ArrayList<CameraBriefInfo>();
            
            for (int i = 0; i < length; i++)
            {
                list.add(convertCameraBriefInfoSouthToDomain(cameraBriefInfoSouths[i]));
            }
            
            cameraBriefInfoList.setCameraBriefInfo(list);
        }
        
        return cameraBriefInfoList;
    }
    
    public DeviceBriefInfoList convertDeviceBriefInfoListSouthToDomain(DeviceBriefInfoListSouth deviceBriefInfoListSouth)
    {
        DeviceBriefInfoList deviceBriefInfoList = new DeviceBriefInfoList();
        
        // 转换
        deviceBriefInfoList.setTotal(deviceBriefInfoListSouth.total);
        deviceBriefInfoList.setReserve(BytesUtils.bytesToStringForIVS(deviceBriefInfoListSouth.reserve));
        IndexRange indexRange = new IndexRange();
        indexRange.setFromIndex(deviceBriefInfoListSouth.indexRange.fromIndex);
        indexRange.setToIndex(deviceBriefInfoListSouth.indexRange.toIndex);
        deviceBriefInfoList.setIndexRange(indexRange);
        DeviceBriefInfoSouth[] deviceBriefInfoSouths = deviceBriefInfoListSouth.deviceBriefInfo;
        
        if (null != deviceBriefInfoSouths && deviceBriefInfoSouths.length > 0)
        {
            
            int length =
                getLength(deviceBriefInfoListSouth.total,
                    deviceBriefInfoSouths.length,
                    deviceBriefInfoListSouth.indexRange.fromIndex,
                    deviceBriefInfoListSouth.indexRange.toIndex);
            
            List<DeviceBriefInfo> list = new ArrayList<DeviceBriefInfo>();
            
            for (int i = 0; i < length; i++)
            {
                list.add(convertDeviceBriefInfoSouthToDomain(deviceBriefInfoSouths[i]));
            }
            
            deviceBriefInfoList.setDeviceBriefInfo(list);
        }
        
        return deviceBriefInfoList;
    }
    
    public DeviceBriefInfo convertDeviceBriefInfoSouthToDomain(DeviceBriefInfoSouth dbInfoSouth)
    {
        DeviceBriefInfo deviceBriefInfo = new DeviceBriefInfo();
        deviceBriefInfo.setEnableSchedule(dbInfoSouth.enableSchedule);
        deviceBriefInfo.setLoginType(dbInfoSouth.loginType);
        deviceBriefInfo.setProtocolType(BytesUtils.bytesToStringForIVS(dbInfoSouth.protocolType));
        deviceBriefInfo.setReserve(BytesUtils.bytesToStringForIVS(dbInfoSouth.reserve));
        deviceBriefInfo.setStatus(dbInfoSouth.status);
        deviceBriefInfo.setDeviceBasicInfo(convertDeviceBasicInfoSouthToDomain(dbInfoSouth.deviceBasicInfoSouth));
        return deviceBriefInfo;
    }
    
    public DeviceBasicInfo convertDeviceBasicInfoSouthToDomain(
        com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.DeviceBasicInfoSouth dbInfoSouth)
    {
        DeviceBasicInfo deviceBasicInfo = new DeviceBasicInfo();
        deviceBasicInfo.setCode(BytesUtils.bytesToStringForIVS(dbInfoSouth.code));
        deviceBasicInfo.setDomainCode(BytesUtils.bytesToStringForIVS(dbInfoSouth.domainCode));
        
        IPInfo ipInfo = new IPInfo();
        ipInfo.setIp(BytesUtils.bytesToStringForIVS(dbInfoSouth.ip.ip));
        ipInfo.setIpType(dbInfoSouth.ip.ipType);
        deviceBasicInfo.setIpInfo(ipInfo);
        
        deviceBasicInfo.setModel(BytesUtils.bytesToStringForIVS(dbInfoSouth.model));
        deviceBasicInfo.setName(BytesUtils.bytesToStringForIVS(dbInfoSouth.name));
        deviceBasicInfo.setParentCode(BytesUtils.bytesToStringForIVS(dbInfoSouth.parentCode));
        deviceBasicInfo.setPort(dbInfoSouth.port);
        deviceBasicInfo.setReserve(BytesUtils.bytesToStringForIVS(dbInfoSouth.reserve));
        deviceBasicInfo.setSerialNumber(BytesUtils.bytesToStringForIVS(dbInfoSouth.serialNumber));
        deviceBasicInfo.setType(dbInfoSouth.type);
        deviceBasicInfo.setVendorType(BytesUtils.bytesToStringForIVS(dbInfoSouth.vendorType));
        
        return deviceBasicInfo;
    }
    
    public AlarmBriefInfo convertAlarmBriefInfoSouthToDomain(AlarmBriefInfoSouth abInfoSouth)
    {
        AlarmBriefInfo alarmBriefInfo = new AlarmBriefInfo();
        alarmBriefInfo.setAlarmCode(BytesUtils.bytesToStringForIVS(abInfoSouth.alarmCode));
        alarmBriefInfo.setAlarmName(BytesUtils.bytesToStringForIVS(abInfoSouth.alarmName));
        alarmBriefInfo.setChannelType(abInfoSouth.channelType);
        alarmBriefInfo.setDeviceGroupCode(BytesUtils.bytesToStringForIVS(abInfoSouth.deviceGroupCode));
        alarmBriefInfo.setDomainCode(BytesUtils.bytesToStringForIVS(abInfoSouth.domainCode));
        alarmBriefInfo.setIsExDomain(abInfoSouth.isExDomain);
        alarmBriefInfo.setParentCode(BytesUtils.bytesToStringForIVS(abInfoSouth.parentCode));
        alarmBriefInfo.setReserve(BytesUtils.bytesToStringForIVS(abInfoSouth.reserve));
        return alarmBriefInfo;
    }
    
    public AudioBriefInfo convertAudioBriefInfoSouthToDomain(AudioBriefInfoSouth abInfoSouth)
    {
        AudioBriefInfo audioBriefInfo = new AudioBriefInfo();
        audioBriefInfo.setAudioCode(BytesUtils.bytesToStringForIVS(abInfoSouth.audioCode));
        audioBriefInfo.setAudioName(BytesUtils.bytesToStringForIVS(abInfoSouth.audioName));
        audioBriefInfo.setChannelType(abInfoSouth.channelType);
        audioBriefInfo.setDeviceGroupId(abInfoSouth.deviceGroupId);
        audioBriefInfo.setDomainCode(BytesUtils.bytesToStringForIVS(abInfoSouth.domainCode));
        audioBriefInfo.setReserve(BytesUtils.bytesToStringForIVS(abInfoSouth.reserve));
        return audioBriefInfo;
    }
    
    public CameraBriefInfo convertCameraBriefInfoSouthToDomain(CameraBriefInfoSouth cbInfoSouth)
    {
        CameraBriefInfo cameraBriefInfo = new CameraBriefInfo();
        cameraBriefInfo.setCameraLocation(BytesUtils.bytesToStringForIVS(cbInfoSouth.cameraLocation));
        cameraBriefInfo.setCameraStatus(cbInfoSouth.cameraStatus);
        cameraBriefInfo.setCode(BytesUtils.bytesToStringForIVS(cbInfoSouth.code));
        cameraBriefInfo.setDeviceCreateTime(BytesUtils.bytesToStringForIVS(cbInfoSouth.deviceCreateTime));
        cameraBriefInfo.setDeviceFormType(cbInfoSouth.deviceFormType);
        cameraBriefInfo.setDeviceGroupCode(BytesUtils.bytesToStringForIVS(cbInfoSouth.deviceGroupCode));
        cameraBriefInfo.setDeviceIp(BytesUtils.bytesToStringForIVS(cbInfoSouth.deviceIp));
        cameraBriefInfo.setDeviceModelType(BytesUtils.bytesToStringForIVS(cbInfoSouth.deviceModelType));
        cameraBriefInfo.setDomainCode(BytesUtils.bytesToStringForIVS(cbInfoSouth.domainCode));
        cameraBriefInfo.setEnableVoice(cbInfoSouth.enableVoice);
        cameraBriefInfo.setIsExDomain(cbInfoSouth.isExDomain);
        cameraBriefInfo.setIsSupportIntelligent(cbInfoSouth.supportIntelligent);
        cameraBriefInfo.setName(BytesUtils.bytesToStringForIVS(cbInfoSouth.name));
        cameraBriefInfo.setNetType(cbInfoSouth.netType);
        cameraBriefInfo.setNvrCode(BytesUtils.bytesToStringForIVS(cbInfoSouth.nvrCode));
        cameraBriefInfo.setParentCode(BytesUtils.bytesToStringForIVS(cbInfoSouth.parentCode));
        cameraBriefInfo.setReserve(BytesUtils.bytesToStringForIVS(cbInfoSouth.reserve));
        cameraBriefInfo.setStatus(cbInfoSouth.status);
        cameraBriefInfo.setType(cbInfoSouth.type);
        cameraBriefInfo.setVendorType(BytesUtils.bytesToStringForIVS(cbInfoSouth.vendorType));
        return cameraBriefInfo;
    }
    
    /** 
     * 领域层的QueryUnifiedFormat转换为南向的
     *
     * @param queryUnifiedFormat 查询通用格式
     * @return QueryUnifiedFormatSouth 南向查询通用格式
     */
    public QueryUnifiedFormatSouth convertQueryUnifiedFormatToSouth(QueryUnifiedFormat queryUnifiedFormat)
    {
        // modify by cWX191990，fieldNum小于0时，默认也需要初始化一个查询条件，问题单号DTS2014022507270
        QueryUnifiedFormatSouth queryUnifiedFormatSouth = null;
        
        if (queryUnifiedFormat.getQueryField().size() == 0)
        {
            queryUnifiedFormatSouth = new QueryUnifiedFormatSouth(1);
        }
        else
        {
            queryUnifiedFormatSouth = new QueryUnifiedFormatSouth(queryUnifiedFormat.getQueryField().size());
        }
        
        queryUnifiedFormatSouth.clear();
        
        // 转换
        queryUnifiedFormatSouth.fieldNum = queryUnifiedFormat.getFieldNum();
        
        queryUnifiedFormatSouth.indexRangeSouth.fromIndex = queryUnifiedFormat.getIndex().getFromIndex();
        queryUnifiedFormatSouth.indexRangeSouth.toIndex = queryUnifiedFormat.getIndex().getToIndex();
        
        queryUnifiedFormatSouth.orderConditionSouth.enableOrder =
            queryUnifiedFormat.getOrderCondition().getEnableOrder();
        queryUnifiedFormatSouth.orderConditionSouth.field = queryUnifiedFormat.getOrderCondition().getField();
        queryUnifiedFormatSouth.orderConditionSouth.isAscend = queryUnifiedFormat.getOrderCondition().getIsAscend();
        
        QueryFieldSouth[] qfSouth = null;
        
        if (queryUnifiedFormat.getQueryField().size() == 0)
        {
            qfSouth = new QueryFieldSouth[1];
        }
        else
        {
            qfSouth = new QueryFieldSouth[queryUnifiedFormat.getQueryField().size()];
            
            for (int i = 0; i < queryUnifiedFormat.getQueryField().size(); i++)
            {
                QueryFieldSouth qfs = new QueryFieldSouth();
                qfs.clear();
                qfs.exactQuery = queryUnifiedFormat.getQueryField().get(i).getExactQuery();
                qfs.field = queryUnifiedFormat.getQueryField().get(i).getFieldType();
                qfs.value = BytesUtils.stringToBytesForIVS(queryUnifiedFormat.getQueryField().get(i).getValue());
                qfSouth[i] = qfs;
            }
        }
        
        queryUnifiedFormatSouth.queryFieldSouth = qfSouth;
        
        return queryUnifiedFormatSouth;
    }
    
    /*
     * getDeviceConfig接口，南向bean转成领域模型
     */
    public Device getDeviceSouth2Model(DeviceConfigSouth south)
    {
        Device device = new Device();
        DeviceOperInfo deviceOperInfo = getDeviceOperInfoSouth2Model(south);
        if (null != deviceOperInfo)
        {
            device.setDeviceOperInfo(deviceOperInfo);
        }
        DeviceBasicInfo deviceBasicInfo = getDeviceBasicInfoSouth2Model(south.deviceBasicInfo);
        if (null != deviceBasicInfo)
        {
            device.setDeviceBasicInfo(deviceBasicInfo);
        }
        DeviceChannelConfig deviceChannelConfig = getDeviceChannelConfigSouth2Model(south.deviceChannel);
        if (null != deviceChannelConfig)
        {
            device.setDeviceChannelConfig(deviceChannelConfig);
        }
        return device;
    }
    
    public DeviceOperInfo getDeviceOperInfoSouth2Model(DeviceConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceOperInfo domain = new DeviceOperInfo();
        domain.setDevPasswd(BytesUtils.bytesToStringForIVS(south.devPasswd));
        domain.setDevRegPasswd(BytesUtils.bytesToStringForIVS(south.devRegPasswd));
        domain.setDevUser(BytesUtils.bytesToStringForIVS(south.devUser));
        domain.setEnableAlarm(south.enableAlarm);
        domain.setEnableSchedule(south.enableSchedule);
        domain.setIsDirectConnectFirst(south.directConnectFirst);
        domain.setLoginType(south.loginType);
        domain.setMaxDirectConnectNum(south.maxDirectConnectNum);
        domain.setNvrCode(BytesUtils.bytesToStringForIVS(south.nvrCode));
        domain.setProtocolType(BytesUtils.bytesToStringForIVS(south.protocolType));
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setTasCode(BytesUtils.bytesToStringForIVS(south.tasCode));
        
        IPInfo tasIp = getIPInfoSouth2Model(south.tasIp);
        if (null != tasIp)
        {
            domain.setTasIp(tasIp);
        }
        
        domain.setVideoFormat(south.videoFormat);
        return domain;
    }
    
    public DeviceBasicInfo getDeviceBasicInfoSouth2Model(DeviceBasicInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceBasicInfo domain = new DeviceBasicInfo();
        domain.setCode(BytesUtils.bytesToStringForIVS(south.code));
        domain.setDomainCode(BytesUtils.bytesToStringForIVS(south.domainCode));
        IPInfo ip = convertIPInfoSouth2Model(south.stIP);
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
    
    public DeviceChannelConfig getDeviceChannelConfigSouth2Model(DeviceChannelConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceChannelConfig domain = new DeviceChannelConfig();
        domain.setMaxVideoNum(south.maxVideoNum);
        domain.setMaxAlarmInNum(south.maxAlarmInNum);
        domain.setMaxAlarmOutNum(south.maxAlarmOutNum);
        domain.setMaxAudioInNum(south.maxAudioInNum);
        domain.setMaxAudioOutNum(south.maxAudioOutNum);
        domain.setMaxSerialNum(south.maxSerialNum);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
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
    
    public DeviceNetConfig getDeviceNetConfigSouth2Model(DeviceNetConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceNetConfig domain = new DeviceNetConfig();
        domain.setMaxMtu(south.maxMtu);
        domain.setPuPort(south.port);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        IPInfo puIp = convertIPInfoSouth2Model(south.puIp);
        if (null != puIp)
        {
            domain.setPuIp(puIp);
        }
        IPInfo puGateway = convertIPInfoSouth2Model(south.puGateway);
        if (null != puGateway)
        {
            domain.setPuGateway(puGateway);
        }
        IPInfo subNetMask = convertIPInfoSouth2Model(south.subNetMask);
        if (null != subNetMask)
        {
            domain.setSubNetMask(subNetMask);
        }
        return domain;
    }
    
    public DeviceTimeConfig getDeviceTimeConfigSouth2Model(DeviceTimeConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceTimeConfig domain = new DeviceTimeConfig();
        domain.setEnableDst(south.enableDst);
        domain.setEnableNtp(south.enableNtp);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setTimezone(south.timezone);
        NTPInfo ntp = getNTPInfoSouth2Model(south.stNTP);
        if (null != ntp)
        {
            domain.setNtp(ntp);
        }
        return domain;
    }
    
    public NTPInfo getNTPInfoSouth2Model(NTPInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        NTPInfo domain = new NTPInfo();
        domain.setNtpType(south.ntpType);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        IPInfo ntpServerIP = convertIPInfoSouth2Model(south.ntpServerIP);
        if (null != ntpServerIP)
        {
            domain.setNtpServerIP(ntpServerIP);
        }
        IPInfo dnsIP = convertIPInfoSouth2Model(south.dnsIP);
        if (null != dnsIP)
        {
            domain.setDnsIP(dnsIP);
        }
        return domain;
        
    }
    
    public CameraConfig getCameraConfigSouth2Model(CameraConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        CameraConfig domain = new CameraConfig();
        BroadCastInfo broadCastInfo = getBroadCastInfoSouth2Model(south.broadcast);
        if (null != broadCastInfo)
        {
            domain.setBroadcastInfo(broadCastInfo);
        }
        domain.setCameraCode(BytesUtils.bytesToStringForIVS(south.cameraCode));
        domain.setCameraName(BytesUtils.bytesToStringForIVS(south.cameraName));
        domain.setCameraStatus(south.cameraStatus);
        domain.setCameraType(south.cameraType);
        domain.setEnableVoice(south.enableVoice);
        domain.setNvrCode(BytesUtils.bytesToStringForIVS(south.nvrCode));
        domain.setParentCode(BytesUtils.bytesToStringForIVS(south.parentCode));
        CameraPosition cameraPosition = getCameraPositionSouth2Model(south.position);
        if (null != cameraPosition)
        {
            domain.setPositionInfo(cameraPosition);
        }
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSupportBroadcast(south.supportBroadcast);
        domain.setVideoChannel(south.videoChannel);
        domain.setVoiceOutCode(BytesUtils.bytesToStringForIVS(south.voiceOutCode));
        return domain;
    }
    
    public BroadCastInfo getBroadCastInfoSouth2Model(BroadcastInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        BroadCastInfo domain = new BroadCastInfo();
        domain.setPort(south.port);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setTimeToLive(south.ttl);
        IPInfo ipInfo = convertIPInfoSouth2Model(south.ip);
        if (null != ipInfo)
        {
            domain.setIpInfo(ipInfo);
        }
        return domain;
    }
    
    public CameraPosition getCameraPositionSouth2Model(CameraPositionSouth south)
    {
        if (null == south)
        {
            return null;
        }
        CameraPosition domain = new CameraPosition();
        domain.setCameraLocationDesc(BytesUtils.bytesToStringForIVS(south.cameraLocation));
        domain.setHeight(south.height);
        domain.setLatitude(south.latitude);
        domain.setLongitude(south.longitude);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
    
    public CameraStreamConfig getCameraStreamConfigSouth2Model(CameraStreamConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        CameraStreamConfig domain = new CameraStreamConfig();
        domain.setStreamInfoNum(south.streamInfoNum);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        StreamInfoSouth[] streamInfoSouths = south.streamInfo;
        if (null != streamInfoSouths && streamInfoSouths.length > 0 && south.streamInfoNum > 0)
        {
            List<StreamInfo> streamInfos = new ArrayList<StreamInfo>();
            for (int i = 0, length = south.streamInfoNum; i < length; i++)
            {
                StreamInfo streamInfo = getStreamInfoSouth2Model(streamInfoSouths[i]);
                if (null != streamInfo)
                {
                    streamInfos.add(streamInfo);
                }
            }
            if (streamInfos.size() > 0)
            {
                domain.setStreamInfos(streamInfos);
            }
        }
        return domain;
    }
    
    public StreamInfo getStreamInfoSouth2Model(StreamInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        StreamInfo domain = new StreamInfo();
        domain.setBitRate(south.bitRate);
        domain.setBitRateType(south.bitRateType);
        domain.setEncodeType(south.encodeType);
        domain.setFrameInterval(south.frameInterval);
        domain.setFrameRate(south.frameRate);
        domain.setPicQuality(south.picQuality);
        domain.setPktProtocol(south.pktProtocol);
        domain.setProfile(south.profile);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setResolution(BytesUtils.bytesToStringForIVS(south.resolution));
        domain.setStreamType(south.streamType);
        domain.setTransProtocol(south.transProtocol);
        return domain;
    }
    
    public CameraDisplayConfig getCameraDisplayConfigSouth2Model(CameraDisplayConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        CameraDisplayConfig domain = new CameraDisplayConfig();
        domain.setBrightness(south.brightness);
        domain.setContrast(south.contrast);
        domain.setHue(south.hue);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSaturation(south.saturation);
        return domain;
    }
    
    public CameraImagingConfig getCameraImagingConfigSouth2Model(CameraImagingConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        CameraImagingConfig domain = new CameraImagingConfig();
        BackLight backLight = getBackLightSouth2Model(south.backlight);
        if (null != backLight)
        {
            domain.setBacklight(backLight);
        }
        Exposure exposure = getExposureSouth2Model(south.exposure);
        if (null != exposure)
        {
            domain.setExposure(exposure);
        }
        Focus focus = getFocusSouth2Model(south.focus);
        if (null != focus)
        {
            domain.setFocus(focus);
        }
        domain.setIrCutFilter(south.irCutFilter);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSharpness(south.sharpness);
        Stabilization stabilization = getStabilizationSouth2Model(south.stabilization);
        if (null != stabilization)
        {
            domain.setStabilization(stabilization);
        }
        WhiteBalance whiteBalance = getWhiteBalanceSouth2Model(south.whiteBalance);
        if (null != whiteBalance)
        {
            domain.setWhiteBalance(whiteBalance);
        }
        WideDynamic wideDynamic = getWideDynamicSouth2Model(south.wideDynamic);
        if (null != wideDynamic)
        {
            domain.setWideDynamic(wideDynamic);
        }
        return domain;
    }
    
    public BackLight getBackLightSouth2Model(BacklightSouth south)
    {
        if (null == south)
        {
            return null;
        }
        BackLight domain = new BackLight();
        domain.setBacklightLevel(south.backlightLevel);
        domain.setBacklightMode(south.backlightMode);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
    
    public Exposure getExposureSouth2Model(ExposureSouth south)
    {
        if (null == south)
        {
            return null;
        }
        Exposure domain = new Exposure();
        domain.setExposureGain(south.exposureGain);
        domain.setExposureIris(south.exposureIris);
        domain.setExposureMode(south.exposureMode);
        domain.setExposurePriority(south.exposurePriority);
        domain.setExposureTime(south.exposureTime);
        RectFloat rectFloat = getRectFloatSouth2Model(south.rectWindow);
        if (null != rectFloat)
        {
            domain.setRectWindow(rectFloat);
        }
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
    
    public RectFloat getRectFloatSouth2Model(RectFloatSouth south)
    {
        if (null == south)
        {
            return null;
        }
        RectFloat domain = new RectFloat();
        domain.setBottom(south.bottom);
        domain.setLeft(south.left);
        domain.setRight(south.right);
        domain.setTop(south.top);
        return domain;
    }
    
    public Focus getFocusSouth2Model(FocusSouth south)
    {
        if (null == south)
        {
            return null;
        }
        Focus domain = new Focus();
        domain.setFarLimit(south.farLimit);
        domain.setFocusMode(south.focusMode);
        domain.setFocusSpeed(south.focusSpeed);
        domain.setNearLimit(south.nearLimit);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
    
    public Stabilization getStabilizationSouth2Model(StabilizationSouth south)
    {
        if (null == south)
        {
            return null;
        }
        Stabilization domain = new Stabilization();
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setStabilizationLevel(south.stabilizationLevel);
        domain.setStabilizationMode(south.stabilizationMode);
        return domain;
    }
    
    public WhiteBalance getWhiteBalanceSouth2Model(WhiteBalanceSouth south)
    {
        if (null == south)
        {
            return null;
        }
        WhiteBalance domain = new WhiteBalance();
        domain.setCbGain(south.cbGain);
        domain.setCrGain(south.crGain);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setWhiteBalanceMode(south.whiteBalanceMode);
        return domain;
    }
    
    public WideDynamic getWideDynamicSouth2Model(WideDynamicSouth south)
    {
        if (null == south)
        {
            return null;
        }
        WideDynamic domain = new WideDynamic();
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setWideDynamicLevel(south.wideDynamicLevel);
        domain.setWideDynamicMode(south.wideDynamicMode);
        return domain;
    }
    
    public CameraOSDConfig getCameraOSDConfigSouth2Model(CameraOSDConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        CameraOSDConfig domain = new CameraOSDConfig();
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setEnableOSD(south.enableOSD);
        OSDName osdName = getOSDName(south.osdName);
        if (null != osdName)
        {
            domain.setOsdName(osdName);
        }
        OSDTime osdTime = getOSDTimeSouth2Model(south.osdTime);
        if (null != osdTime)
        {
            domain.setOsdTime(osdTime);
        }
        return domain;
    }
    
    public OSDName getOSDName(OSDNameSouth south)
    {
        if (null == south)
        {
            return null;
        }
        OSDName domain = new OSDName();
        domain.setEnableOSDName(south.enableOSDName);
        domain.setEnableSwitch(south.enableSwitch);
        domain.setEnableTextBlink(south.enableTextBlink);
        domain.setEnableTextTranslucent(south.enableTextTranslucent);
        domain.setOsdNameText(BytesUtils.bytesToStringForIVS(south.osdNameText));
        RectFloat rectFloat = getRectFloatSouth2Model(south.rectText);
        if (null != rectFloat)
        {
            domain.setRectText(rectFloat);
        }
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSwitchInterval(south.switchInterval);
        domain.setTextTranslucentPercent(south.textTranslucentPercent);
        return domain;
    }
    
    public OSDTime getOSDTimeSouth2Model(OSDTimeSouth south)
    {
        if (null == south)
        {
            return null;
        }
        OSDTime domain = new OSDTime();
        domain.setEnableOSDTime(south.enableOSDTime);
        domain.setTimeX(south.timeX);
        domain.setTimeY(south.timeY);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setTimeFormat(south.timeFormat);
        return domain;
    }
    
    public MotionDetection getMotionDetectionSouth2Model(MotionDetectionSouth south)
    {
        if (null == south)
        {
            return null;
        }
        MotionDetection domain = new MotionDetection();
        domain.setAutoClearAlarmTime(south.autoClearAlarmTime);
        domain.setDetectInterval(south.detectInterval);
        domain.setMotionDetectionEnable(south.motionDetectionEnable);
        domain.setPlatformMotionDetection(south.platformMotionDetection);
        RectFloatSouth[] rectDetectionSouths = south.rectDetection;
        if (null != rectDetectionSouths && rectDetectionSouths.length > 0)
        {
            List<RectFloat> rectFloats = new ArrayList<RectFloat>();
            for (int i = 0, length = rectDetectionSouths.length; i < length; i++)
            {
                RectFloat rectFloat = getRectFloatSouth2Model(rectDetectionSouths[i]);
                if (null != rectFloat)
                {
                    rectFloats.add(rectFloat);
                }
            }
            if (rectFloats.size() > 0)
            {
                domain.setRectDetections(rectFloats);
            }
        }
        domain.setRectNum(south.rectNum);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSensitivity(south.sensitivity);
        return domain;
    }
    
    public VideoHideAlarm getVideoHideAlarmSouth2Model(VideoHideAlarmSouth south)
    {
        if (null == south)
        {
            return null;
        }
        VideoHideAlarm domain = new VideoHideAlarm();
        domain.setAreaNum(south.areaNum);
        domain.setAutoClearAlarmTime(south.autoClearAlarmTime);
        domain.setEnableVideoHide(south.enableVideoHide);
        TimeSpanSouth[] timeSpanSouths = south.guardTime;
        if (null != timeSpanSouths && timeSpanSouths.length > 0)
        {
            List<TimeSpan> timeSpanInfos = new ArrayList<TimeSpan>();
            for (int i = 0, length = timeSpanSouths.length; i < length; i++)
            {
                TimeSpan timeSpan = getTimeSpanSouth2Model(timeSpanSouths[i]);
                if (null != timeSpan)
                {
                    timeSpanInfos.add(timeSpan);
                }
            }
            if (timeSpanInfos.size() > 0)
            {
                domain.setGuardTimes(timeSpanInfos);
            }
        }
        domain.setGuardTimeNum(south.guardTimeNum);
        RectFloatSouth[] rectAreaSouths = south.rectArea;
        if (null != rectAreaSouths && rectAreaSouths.length > 0)
        {
            List<RectFloat> rectFloats = new ArrayList<RectFloat>();
            for (int i = 0, length = rectAreaSouths.length; i < length; i++)
            {
                RectFloat rectFloat = getRectFloatSouth2Model(rectAreaSouths[i]);
                if (null != rectFloat)
                {
                    rectFloats.add(rectFloat);
                }
            }
            if (rectFloats.size() > 0)
            {
                domain.setRectAreas(rectFloats);
            }
        }
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSensitivity(south.sensitivity);
        return domain;
    }
    
    public TimeSpan getTimeSpanSouth2Model(TimeSpanSouth south)
    {
        if (null == south)
        {
            return null;
        }
        TimeSpan domain = new TimeSpan();
        domain.setStartTime(BytesUtils.bytesToStringForIVS(south.start));
        domain.setEndTime(BytesUtils.bytesToStringForIVS(south.end));
        return domain;
    }
    
    public VideoMask getVideoMaskSouth2Model(VideoMaskSouth south)
    {
        if (null == south)
        {
            return null;
        }
        VideoMask domain = new VideoMask();
        domain.setAreaNum(south.areaNum);
        domain.setEnableVideoMask(south.enableVideoMask);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        RectFloatSouth[] rectAreaSouths = south.rectArea;
        if (null != rectAreaSouths && rectAreaSouths.length > 0 && south.areaNum > 0)
        {
            List<RectFloat> rectFloats = new ArrayList<RectFloat>();
            for (int i = 0, length = south.areaNum; i < length; i++)
            {
                RectFloat rectFloat = getRectFloatSouth2Model(rectAreaSouths[i]);
                if (null != rectFloat)
                {
                    rectFloats.add(rectFloat);
                }
            }
            if (rectFloats.size() > 0)
            {
                domain.setRectAreas(rectFloats);
            }
        }
        return domain;
    }
    
    public AudioConfig getAudioConfigSouth2Model(AudioConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        AudioConfig domain = new AudioConfig();
        domain.setAudioIndex(south.audioIndex);
        domain.setAudioName(BytesUtils.bytesToStringForIVS(south.audioName));
        AudioParam audioParam = getAudioParamSouth2Model(south.audioParam);
        if (null != audioParam)
        {
            domain.setAudioParam(audioParam);
        }
        domain.setChannelType(south.channelType);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
    
    public AudioParam getAudioParamSouth2Model(AudioParamSouth south)
    {
        if (null == south)
        {
            return null;
        }
        AudioParam domain = new AudioParam();
        domain.setChannel(south.channel);
        domain.setDataFormat(south.dataFormat);
        domain.setGain(south.gain);
        domain.setInputType(south.inputType);
        domain.setPitch(south.pitch);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSampleBits(south.sampleBits);
        domain.setSampleRate(south.sampleRate);
        domain.setVolume(south.volume);
        return domain;
    }
    
    public SerialChannelConfig getSerialChannelConfigSouth2Model(SerialChannelConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        SerialChannelConfig domain = new SerialChannelConfig();
        domain.setBaudRate(south.baudRate);
        domain.setDataBit(south.dataBit);
        domain.setFlowControl(south.flowControl);
        domain.setParity(south.parity);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSerialIndex(south.serialIndex);
        domain.setSerialName(BytesUtils.bytesToStringForIVS(south.serialName));
        domain.setSerialType(south.serialType);
        domain.setStopBit(south.stopBit);
        return domain;
    }
    
    public AlarmInConfig getAlarmInConfigSouth2Model(AlarmInConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        AlarmInConfig domain = new AlarmInConfig();
        domain.setAlarmInChanIndex(south.alarmInChanIndex);
        domain.setAlarmInName(BytesUtils.bytesToStringForIVS(south.alarmInName));
        domain.setAutoClearAlarmTime(south.autoClearAlarmTime);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSwitchType(south.switchType);
        return domain;
    }
    
    public AlarmOutConfig getAlarmOutConfigSouth2Model(AlarmOutConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        AlarmOutConfig domain = new AlarmOutConfig();
        domain.setAlarmOutChanIndex(south.alarmOutChanIndex);
        domain.setAlarmOutMode(south.alarmOutMode);
        domain.setAlarmOutName(BytesUtils.bytesToStringForIVS(south.alarmOutName));
        domain.setHoldTime(south.holdTime);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSwitchType(south.switchType);
        return domain;
    }
    
    public PTZConfig getPTZConfigSouth2Model(PTZConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        PTZConfig domain = new PTZConfig();
        domain.setDecoderAddress(south.decoderAddress);
        domain.setDecoderType(south.decoderType);
        domain.setPosNegDirectControl(south.posNegDirectControl);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSerialCode(Native.toString(south.serialCode));
        return domain;
    }
    
    public CameraExtendConfig getCameraExtendConfigSouth2Model(CameraExtendConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        CameraExtendConfig domain = new CameraExtendConfig();
        domain.setEnableBandwidthAdaptive(south.enableBandwidthAdaptive);
        domain.setEnableCache(south.enableCache);
        domain.setEnableWatermark(south.enableWatermark);
        domain.setFecMatrix(south.fecMatrix);
        MediaSecurityConfig mediaSecurityConfig = getMediaSecurityConfigSouth2Model(south.mediaSecurityCfg);
        if (null != mediaSecurityConfig)
        {
            domain.setMediaSecurityCfg(mediaSecurityConfig);
        }
        domain.setReliableTransmission(south.reliableTransmission);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
    
    public MediaSecurityConfig getMediaSecurityConfigSouth2Model(MediaSecurityConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        MediaSecurityConfig domain = new MediaSecurityConfig();
        domain.setEnableMediaSecurity(south.enableMediaSecurity);
        domain.setEnableSecureStorage(south.enableSecureStorage);
        domain.setMediaSecurityAlgorithm(south.mediaSecurityAlgorithm);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
    
    public CameraSnapShotConfig getCameraSnapShotConfigSouth2Model(CameraSnapshotConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        CameraSnapShotConfig domain = new CameraSnapShotConfig();
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setSnapCount(south.snapCount);
        domain.setSnapInterval(south.snapInterval);
        return domain;
    }
    
    public CameraRecordStreamConfig getCameraRecordStreamConfigSouth2Model(CameraRecordStreamConfigSouth south)
    {
        if (null == south)
        {
            return null;
        }
        CameraRecordStreamConfig domain = new CameraRecordStreamConfig();
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setStreamType(south.streamType);
        return domain;
    }
    
    public Structure setDeviceConfigModel2South(int configType, Object dataBuffer)
    {
        if (null == dataBuffer)
        {
            return null;
        }
        
        if (configType == ConfigItemEnum.CONFIG_DEVICE_CFG)
        {
            Device device = (Device)dataBuffer;
            
            DeviceConfigSouth deviceConfig = new DeviceConfigSouth();
            deviceConfig.getPointer();
            
            DeviceOperInfo deviceOperInfoModel = device.getDeviceOperInfo();
            if (null != deviceOperInfoModel)
            {
                deviceConfig.devPasswd = BytesUtils.stringToBytesForIVS(deviceOperInfoModel.getDevPasswd());
                deviceConfig.devRegPasswd = BytesUtils.stringToBytesForIVS(deviceOperInfoModel.getDevRegPasswd());
                deviceConfig.devUser = BytesUtils.stringToBytesForIVS(deviceOperInfoModel.getDevUser());
                deviceConfig.enableAlarm = deviceOperInfoModel.getEnableAlarm();
                deviceConfig.enableSchedule = deviceOperInfoModel.getEnableSchedule();
                deviceConfig.directConnectFirst = deviceOperInfoModel.getIsDirectConnectFirst();
                deviceConfig.loginType = deviceOperInfoModel.getLoginType();
                deviceConfig.maxDirectConnectNum = deviceOperInfoModel.getMaxDirectConnectNum();
                deviceConfig.nvrCode = BytesUtils.stringToBytesForIVS(deviceOperInfoModel.getNvrCode());
                deviceConfig.protocolType = BytesUtils.stringToBytesForIVS(deviceOperInfoModel.getProtocolType());
                deviceConfig.tasCode = BytesUtils.stringToBytesForIVS(deviceOperInfoModel.getTasCode());
                deviceConfig.videoFormat = deviceOperInfoModel.getVideoFormat();
                deviceConfig.reserve = BytesUtils.stringToBytesForIVS(deviceOperInfoModel.getReserve());
            }
            
            DeviceBasicInfo deviceBasicInfoModel = device.getDeviceBasicInfo();
            if (null != deviceBasicInfoModel)
            {
                DeviceBasicInfoSouth deviceBasicInfo = new DeviceBasicInfoSouth();
                deviceBasicInfo.clear();
                
                deviceBasicInfo.code = BytesUtils.stringToBytesForIVS(deviceBasicInfoModel.getCode());
                deviceBasicInfo.domainCode = BytesUtils.stringToBytesForIVS(deviceBasicInfoModel.getDomainCode());
                deviceBasicInfo.model = BytesUtils.stringToBytesForIVS(deviceBasicInfoModel.getModel());
                deviceBasicInfo.name = BytesUtils.stringToBytesForIVS(deviceBasicInfoModel.getName());
                deviceBasicInfo.parentCode = BytesUtils.stringToBytesForIVS(deviceBasicInfoModel.getParentCode());
                deviceBasicInfo.port = deviceBasicInfoModel.getPort();
                deviceBasicInfo.reserve = BytesUtils.stringToBytesForIVS(deviceBasicInfoModel.getReserve());
                deviceBasicInfo.serialNumber = BytesUtils.stringToBytesForIVS(deviceBasicInfoModel.getSerialNumber());
                deviceBasicInfo.type = deviceBasicInfoModel.getType();
                deviceBasicInfo.vendorType = BytesUtils.stringToBytesForIVS(deviceBasicInfoModel.getVendorType());
                if (null != deviceBasicInfoModel.getIpInfo())
                {
                    IPInfoSouth ipInfoSouth = new IPInfoSouth();
                    ipInfoSouth.clear();
                    
                    ipInfoSouth.ipType = deviceBasicInfoModel.getIpInfo().getIpType();
                    ipInfoSouth.ip = BytesUtils.stringToBytesForIVS(deviceBasicInfoModel.getIpInfo().getIp());
                    deviceBasicInfo.stIP = ipInfoSouth;
                }
                deviceConfig.deviceBasicInfo = deviceBasicInfo;
            }
            DeviceChannelConfig deviceChannelConfigModel = device.getDeviceChannelConfig();
            if (null != deviceChannelConfigModel)
            {
                DeviceChannelConfigSouth deviceChannel = new DeviceChannelConfigSouth();
                deviceChannel.clear();
                
                deviceChannel.maxAlarmInNum = deviceChannelConfigModel.getMaxAlarmInNum();
                deviceChannel.maxAlarmOutNum = deviceChannelConfigModel.getMaxAlarmOutNum();
                deviceChannel.maxAudioInNum = deviceChannelConfigModel.getMaxAudioInNum();
                deviceChannel.maxAudioOutNum = deviceChannelConfigModel.getMaxAudioOutNum();
                deviceChannel.maxSerialNum = deviceChannelConfigModel.getMaxSerialNum();
                deviceChannel.maxVideoNum = deviceChannelConfigModel.getMaxVideoNum();
                deviceChannel.reserve = BytesUtils.stringToBytesForIVS(deviceChannelConfigModel.getReserve());
                
                deviceConfig.deviceChannel = deviceChannel;
            }
            return deviceConfig;
        }
        else if (configType == ConfigItemEnum.CONFIG_DEVICE_NET_CFG)
        {
            DeviceNetConfig deviceNetConfig = (DeviceNetConfig)dataBuffer;
            
            DeviceNetConfigSouth deviceNetConfigSouth = new DeviceNetConfigSouth();
            deviceNetConfigSouth.getPointer();
            
            deviceNetConfigSouth.maxMtu = deviceNetConfig.getMaxMtu();
            deviceNetConfigSouth.port = deviceNetConfig.getPuPort();
            deviceNetConfigSouth.reserve = BytesUtils.stringToBytesForIVS(deviceNetConfig.getReserve());
            
            if (null != deviceNetConfig.getPuGateway())
            {
                IPInfoSouth puGateway = new IPInfoSouth();
                puGateway.clear();
                
                puGateway.ip = BytesUtils.stringToBytesForIVS(deviceNetConfig.getPuGateway().getIp());
                puGateway.ipType = deviceNetConfig.getPuGateway().getIpType();
                deviceNetConfigSouth.puGateway = puGateway;
            }
            
            if (null != deviceNetConfig.getPuIp())
            {
                IPInfoSouth puIp = new IPInfoSouth();
                puIp.clear();
                
                puIp.ip = BytesUtils.stringToBytesForIVS(deviceNetConfig.getPuIp().getIp());
                puIp.ipType = deviceNetConfig.getPuIp().getIpType();
                deviceNetConfigSouth.puIp = puIp;
            }
            
            if (null != deviceNetConfig.getSubNetMask())
            {
                IPInfoSouth subNetMask = new IPInfoSouth();
                subNetMask.clear();
                
                subNetMask.ip = BytesUtils.stringToBytesForIVS(deviceNetConfig.getSubNetMask().getIp());
                subNetMask.ipType = deviceNetConfig.getSubNetMask().getIpType();
                deviceNetConfigSouth.subNetMask = subNetMask;
            }
            
            return deviceNetConfigSouth;
            
        }
        else if (configType == ConfigItemEnum.CONFIG_DEVICE_TIME_CFG)
        {
            DeviceTimeConfig deviceTimeConfig = (DeviceTimeConfig)dataBuffer;
            
            DeviceTimeConfigSouth deviceTimeConfigSouth = new DeviceTimeConfigSouth();
            deviceTimeConfigSouth.getPointer();
            
            deviceTimeConfigSouth.enableDst = deviceTimeConfig.getEnableDst();
            deviceTimeConfigSouth.enableNtp = deviceTimeConfig.getEnableNtp();
            deviceTimeConfigSouth.timezone = deviceTimeConfig.getTimezone();
            deviceTimeConfigSouth.reserve = BytesUtils.stringToBytesForIVS(deviceTimeConfig.getReserve());
            
            NTPInfo ntpModel = deviceTimeConfig.getNtp();
            if (null != ntpModel)
            {
                NTPInfoSouth stNTPSouth = new NTPInfoSouth();
                stNTPSouth.clear();
                
                stNTPSouth.ntpType = ntpModel.getNtpType();
                stNTPSouth.reserve = BytesUtils.stringToBytesForIVS(ntpModel.getReserve());
                
                if (null != ntpModel.getDnsIP())
                {
                    IPInfoSouth dnsIP = new IPInfoSouth();
                    dnsIP.clear();
                    
                    dnsIP.ip = BytesUtils.stringToBytesForIVS(ntpModel.getDnsIP().getIp());
                    dnsIP.ipType = ntpModel.getDnsIP().getIpType();
                    stNTPSouth.dnsIP = dnsIP;
                }
                if (null != ntpModel.getNtpServerIP())
                {
                    IPInfoSouth ntpServerIP = new IPInfoSouth();
                    ntpServerIP.clear();
                    
                    ntpServerIP.ip = BytesUtils.stringToBytesForIVS(ntpModel.getNtpServerIP().getIp());
                    ntpServerIP.ipType = ntpModel.getNtpServerIP().getIpType();
                    stNTPSouth.ntpServerIP = ntpServerIP;
                }
                
                deviceTimeConfigSouth.stNTP = stNTPSouth;
            }
            
            return deviceTimeConfigSouth;
            
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_CFG)
        {
            CameraConfig cameraConfig = (CameraConfig)dataBuffer;
            
            CameraConfigSouth cameraConfigSouth = new CameraConfigSouth();
            cameraConfigSouth.getPointer();
            
            cameraConfigSouth.cameraCode = BytesUtils.stringToBytesForIVS(cameraConfig.getCameraCode());
            cameraConfigSouth.videoChannel = cameraConfig.getVideoChannel();
            cameraConfigSouth.cameraName = BytesUtils.stringToBytesForIVS(cameraConfig.getCameraName());
            cameraConfigSouth.supportBroadcast = cameraConfig.getSupportBroadcast();
            cameraConfigSouth.enableVoice = cameraConfig.getEnableVoice();
            cameraConfigSouth.voiceOutCode = BytesUtils.stringToBytesForIVS(cameraConfig.getVoiceOutCode());
            cameraConfigSouth.parentCode = BytesUtils.stringToBytesForIVS(cameraConfig.getParentCode());
            cameraConfigSouth.nvrCode = BytesUtils.stringToBytesForIVS(cameraConfig.getNvrCode());
            cameraConfigSouth.cameraType = cameraConfig.getCameraType();
            cameraConfigSouth.cameraStatus = cameraConfig.getCameraStatus();
            cameraConfigSouth.reserve = BytesUtils.stringToBytesForIVS(cameraConfig.getReserve());
            
            CameraPosition positionInfoModel = cameraConfig.getPositionInfo();
            if (null != positionInfoModel)
            {
                
                CameraPositionSouth cameraPosition = new CameraPositionSouth();
                cameraPosition.clear();
                
                cameraPosition.cameraLocation =
                    BytesUtils.stringToBytesForIVS(positionInfoModel.getCameraLocationDesc());
                cameraPosition.longitude = positionInfoModel.getLongitude();
                cameraPosition.latitude = positionInfoModel.getLatitude();
                cameraPosition.height = positionInfoModel.getHeight();
                cameraPosition.reserve = BytesUtils.stringToBytesForIVS(positionInfoModel.getReserve());
                
                cameraConfigSouth.position = cameraPosition;
            }
            
            BroadCastInfo broadcastInfoModel = cameraConfig.getBroadcastInfo();
            if (null != broadcastInfoModel)
            {
                BroadcastInfoSouth broadCastInfo = new BroadcastInfoSouth();
                broadCastInfo.clear();
                
                if (null != broadcastInfoModel.getIpInfo())
                {
                    IPInfoSouth ipInfo = new IPInfoSouth();
                    ipInfo.clear();
                    
                    ipInfo.ip = BytesUtils.stringToBytesForIVS(broadcastInfoModel.getIpInfo().getIp());
                    ipInfo.ipType = broadcastInfoModel.getIpInfo().getIpType();
                    broadCastInfo.ip = ipInfo;
                }
                
                broadCastInfo.port = broadcastInfoModel.getPort();
                broadCastInfo.ttl = broadcastInfoModel.getTimeToLive();
                broadCastInfo.reserve = BytesUtils.stringToBytesForIVS(broadcastInfoModel.getReserve());
                
                cameraConfigSouth.broadcast = broadCastInfo;
            }
            
            return cameraConfigSouth;
            
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_STREAM_CFG)
        {
            CameraStreamConfig cameraStreamConfig = (CameraStreamConfig)dataBuffer;
            
            CameraStreamConfigSouth cameraStreamConfigSouth = new CameraStreamConfigSouth();
            cameraStreamConfigSouth.getPointer();
            
            cameraStreamConfigSouth.streamInfoNum = cameraStreamConfig.getStreamInfoNum();
            cameraStreamConfigSouth.reserve = BytesUtils.stringToBytesForIVS(cameraStreamConfig.getReserve());
            
            List<StreamInfo> streamInfosModel = cameraStreamConfig.getStreamInfos();
            
            if (null != streamInfosModel)
            {
                int i = 0;
                for (StreamInfo streamInfoModel : streamInfosModel)
                {
                    StreamInfoSouth streamInfoSouth = new StreamInfoSouth();
                    streamInfoSouth.clear();
                    
                    streamInfoSouth.streamType = streamInfoModel.getStreamType();
                    streamInfoSouth.encodeType = streamInfoModel.getEncodeType();
                    streamInfoSouth.profile = streamInfoModel.getProfile();
                    streamInfoSouth.frameInterval = streamInfoModel.getFrameInterval();
                    streamInfoSouth.resolution = BytesUtils.stringToBytesForIVS(streamInfoModel.getResolution());
                    streamInfoSouth.picQuality = streamInfoModel.getPicQuality();
                    streamInfoSouth.transProtocol = streamInfoModel.getTransProtocol();
                    streamInfoSouth.pktProtocol = streamInfoModel.getPktProtocol();
                    streamInfoSouth.bitRateType = streamInfoModel.getBitRateType();
                    streamInfoSouth.bitRate = streamInfoModel.getBitRate();
                    streamInfoSouth.frameRate = streamInfoModel.getFrameRate();
                    streamInfoSouth.reserve = BytesUtils.stringToBytesForIVS(streamInfoModel.getReserve());
                    
                    cameraStreamConfigSouth.streamInfo[i] = streamInfoSouth;
                    i++;
                }
            }
            
            return cameraStreamConfigSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_DISPLAY_CFG)
        {
            CameraDisplayConfig cameraDisplayConfig = (CameraDisplayConfig)dataBuffer;
            
            CameraDisplayConfigSouth cameraDisplayConfigSouth = new CameraDisplayConfigSouth();
            cameraDisplayConfigSouth.getPointer();
            
            cameraDisplayConfigSouth.brightness = cameraDisplayConfig.getBrightness();
            cameraDisplayConfigSouth.contrast = cameraDisplayConfig.getContrast();
            cameraDisplayConfigSouth.hue = cameraDisplayConfig.getHue();
            cameraDisplayConfigSouth.saturation = cameraDisplayConfig.getSaturation();
            cameraDisplayConfigSouth.reserve = BytesUtils.stringToBytesForIVS(cameraDisplayConfig.getReserve());
            
            return cameraDisplayConfigSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_IMAGING_CFG)
        {
            CameraImagingConfig cameraImagingConfig = (CameraImagingConfig)dataBuffer;
            
            CameraImagingConfigSouth cameraImagingConfigSouth = new CameraImagingConfigSouth();
            cameraImagingConfigSouth.getPointer();
            
            cameraImagingConfigSouth.irCutFilter = cameraImagingConfig.getIrCutFilter();
            cameraImagingConfigSouth.sharpness = cameraImagingConfig.getSharpness();
            cameraImagingConfigSouth.reserve = BytesUtils.stringToBytesForIVS(cameraImagingConfig.getReserve());
            
            if (null != cameraImagingConfig.getBacklight())
            {
                BacklightSouth backLight = new BacklightSouth();
                backLight.clear();
                
                backLight.backlightLevel = cameraImagingConfig.getBacklight().getBacklightLevel();
                backLight.backlightMode = cameraImagingConfig.getBacklight().getBacklightMode();
                backLight.reserve = BytesUtils.stringToBytesForIVS(cameraImagingConfig.getBacklight().getReserve());
                cameraImagingConfigSouth.backlight = backLight;
            }
            
            if (null != cameraImagingConfig.getExposure())
            {
                ExposureSouth exposure = new ExposureSouth();
                exposure.clear();
                
                exposure.exposureGain = cameraImagingConfig.getExposure().getExposureGain();
                exposure.exposureMode = cameraImagingConfig.getExposure().getExposureMode();
                exposure.exposurePriority = cameraImagingConfig.getExposure().getExposurePriority();
                exposure.exposureTime = cameraImagingConfig.getExposure().getExposureTime();
                exposure.exposureIris = cameraImagingConfig.getExposure().getExposureIris();
                exposure.reserve = BytesUtils.stringToBytesForIVS(cameraImagingConfig.getExposure().getReserve());
                
                RectFloat rectFloatModel = cameraImagingConfig.getExposure().getRectWindow();
                if (null != rectFloatModel)
                {
                    RectFloatSouth rectFloat = new RectFloatSouth();
                    rectFloat.clear();
                    
                    rectFloat.bottom = rectFloatModel.getBottom();
                    rectFloat.left = rectFloatModel.getLeft();
                    rectFloat.right = rectFloatModel.getRight();
                    rectFloat.top = rectFloatModel.getTop();
                    exposure.rectWindow = rectFloat;
                }
                cameraImagingConfigSouth.exposure = exposure;
            }
            
            if (null != cameraImagingConfig.getFocus())
            {
                FocusSouth focus = new FocusSouth();
                focus.clear();
                
                focus.focusMode = cameraImagingConfig.getFocus().getFocusMode();
                focus.farLimit = cameraImagingConfig.getFocus().getFarLimit();
                focus.focusSpeed = cameraImagingConfig.getFocus().getFocusSpeed();
                focus.nearLimit = cameraImagingConfig.getFocus().getNearLimit();
                focus.reserve = BytesUtils.stringToBytesForIVS(cameraImagingConfig.getFocus().getReserve());
                
                cameraImagingConfigSouth.focus = focus;
            }
            
            if (null != cameraImagingConfig.getWideDynamic())
            {
                WideDynamicSouth wideDynamic = new WideDynamicSouth();
                wideDynamic.clear();
                
                wideDynamic.wideDynamicMode = cameraImagingConfig.getWideDynamic().getWideDynamicMode();
                wideDynamic.wideDynamicLevel = cameraImagingConfig.getWideDynamic().getWideDynamicLevel();
                wideDynamic.reserve = BytesUtils.stringToBytesForIVS(cameraImagingConfig.getWideDynamic().getReserve());
                cameraImagingConfigSouth.wideDynamic = wideDynamic;
            }
            
            if (null != cameraImagingConfig.getWhiteBalance())
            {
                WhiteBalanceSouth whiteBalance = new WhiteBalanceSouth();
                whiteBalance.clear();
                
                whiteBalance.cbGain = cameraImagingConfig.getWhiteBalance().getCbGain();
                whiteBalance.crGain = cameraImagingConfig.getWhiteBalance().getCrGain();
                whiteBalance.whiteBalanceMode = cameraImagingConfig.getWhiteBalance().getWhiteBalanceMode();
                whiteBalance.reserve =
                    BytesUtils.stringToBytesForIVS(cameraImagingConfig.getWideDynamic().getReserve());
                cameraImagingConfigSouth.whiteBalance = whiteBalance;
            }
            
            return cameraImagingConfigSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_OSD_CFG)
        {
            CameraOSDConfigSouth cameraOSDConfigSouth = new CameraOSDConfigSouth();
            cameraOSDConfigSouth.getPointer();
            
            CameraOSDConfig cameraOSDConfig = (CameraOSDConfig)dataBuffer;
            
            cameraOSDConfigSouth.enableOSD = cameraOSDConfig.getEnableOSD();
            cameraOSDConfigSouth.reserve = BytesUtils.stringToBytesForIVS(cameraOSDConfig.getReserve());
            
            OSDTimeSouth osdTimeSouth = new OSDTimeSouth();
            osdTimeSouth.clear();
            
            osdTimeSouth.enableOSDTime = cameraOSDConfig.getOsdTime().getEnableOSDTime();
            osdTimeSouth.timeFormat = cameraOSDConfig.getOsdTime().getTimeFormat();
            osdTimeSouth.timeX = cameraOSDConfig.getOsdTime().getTimeX();
            osdTimeSouth.timeY = cameraOSDConfig.getOsdTime().getTimeY();
            osdTimeSouth.reserve = BytesUtils.stringToBytesForIVS(cameraOSDConfig.getOsdTime().getReserve());
            cameraOSDConfigSouth.osdTime = osdTimeSouth;
            
            OSDNameSouth osdNameSouth = new OSDNameSouth();
            osdNameSouth.clear();
            
            osdNameSouth.enableOSDName = cameraOSDConfig.getOsdName().getEnableOSDName();
            osdNameSouth.enableSwitch = cameraOSDConfig.getOsdName().getEnableSwitch();
            osdNameSouth.switchInterval = cameraOSDConfig.getOsdName().getSwitchInterval();
            osdNameSouth.enableTextBlink = cameraOSDConfig.getOsdName().getEnableTextBlink();
            osdNameSouth.enableTextTranslucent = cameraOSDConfig.getOsdName().getEnableTextTranslucent();
            osdNameSouth.textTranslucentPercent = cameraOSDConfig.getOsdName().getTextTranslucentPercent();
            osdNameSouth.reserve = BytesUtils.stringToBytesForIVS(cameraOSDConfig.getOsdName().getReserve());
            osdNameSouth.osdNameText = BytesUtils.stringToBytesForIVS(cameraOSDConfig.getOsdName().getOsdNameText());
            
            RectFloatSouth rectFloatSouth = new RectFloatSouth();
            rectFloatSouth.clear();
            
            rectFloatSouth.bottom = cameraOSDConfig.getOsdName().getRectText().getBottom();
            rectFloatSouth.left = cameraOSDConfig.getOsdName().getRectText().getLeft();
            rectFloatSouth.top = cameraOSDConfig.getOsdName().getRectText().getTop();
            rectFloatSouth.right = cameraOSDConfig.getOsdName().getRectText().getRight();
            osdNameSouth.rectText = rectFloatSouth;
            
            cameraOSDConfigSouth.osdName = osdNameSouth;
            
            return cameraOSDConfigSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_MOTION_DETECTION_CFG)
        {
            MotionDetectionSouth motionDetectionSouth = new MotionDetectionSouth();
            motionDetectionSouth.getPointer();
            
            MotionDetection motionDetection = (MotionDetection)dataBuffer;
            motionDetectionSouth.autoClearAlarmTime = motionDetection.getAutoClearAlarmTime();
            motionDetectionSouth.motionDetectionEnable = motionDetection.getMotionDetectionEnable();
            motionDetectionSouth.platformMotionDetection = motionDetection.getPlatformMotionDetection();
            motionDetectionSouth.detectInterval = motionDetection.getDetectInterval();
            motionDetectionSouth.sensitivity = motionDetection.getSensitivity();
            motionDetectionSouth.rectNum = motionDetection.getRectNum();
            motionDetectionSouth.reserve = BytesUtils.stringToBytesForIVS(motionDetection.getReserve());
            
            if (null != motionDetection.getRectDetections())
            {
                for (int i = 0; i < motionDetection.getRectDetections().size(); i++)
                {
                    RectFloatSouth item = new RectFloatSouth();
                    item.clear();
                    
                    item.bottom = motionDetection.getRectDetections().get(i).getBottom();
                    item.left = motionDetection.getRectDetections().get(i).getLeft();
                    item.top = motionDetection.getRectDetections().get(i).getTop();
                    item.right = motionDetection.getRectDetections().get(i).getRight();
                    
                    motionDetectionSouth.rectDetection[i] = item;
                }
            }
            
            return motionDetectionSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_VIDEO_HIDE_ALARM_CFG)
        {
            VideoHideAlarmSouth videoHideAlarmSouth = new VideoHideAlarmSouth();
            videoHideAlarmSouth.getPointer();
            
            VideoHideAlarm videoHideAlarm = (VideoHideAlarm)dataBuffer;
            videoHideAlarmSouth.areaNum = videoHideAlarm.getAreaNum();
            videoHideAlarmSouth.enableVideoHide = videoHideAlarm.getEnableVideoHide();
            videoHideAlarmSouth.sensitivity = videoHideAlarm.getSensitivity();
            videoHideAlarmSouth.autoClearAlarmTime = videoHideAlarm.getAutoClearAlarmTime();
            videoHideAlarmSouth.guardTimeNum = videoHideAlarm.getGuardTimeNum();
            videoHideAlarmSouth.reserve = BytesUtils.stringToBytesForIVS(videoHideAlarm.getReserve());
            
            if (null != videoHideAlarm.getGuardTimes())
            {
                for (int i = 0; i < videoHideAlarm.getGuardTimes().size(); i++)
                {
                    TimeSpanSouth item = new TimeSpanSouth();
                    item.clear();
                    
                    item.start = BytesUtils.stringToBytesForIVS(videoHideAlarm.getGuardTimes().get(i).getStartTime());
                    item.end = BytesUtils.stringToBytesForIVS(videoHideAlarm.getGuardTimes().get(i).getEndTime());
                    
                    videoHideAlarmSouth.guardTime[i] = item;
                }
            }
            
            if (null != videoHideAlarm.getRectAreas())
            {
                for (int i = 0; i < videoHideAlarm.getRectAreas().size(); i++)
                {
                    RectFloatSouth item = new RectFloatSouth();
                    item.clear();
                    
                    item.bottom = videoHideAlarm.getRectAreas().get(i).getBottom();
                    item.left = videoHideAlarm.getRectAreas().get(i).getLeft();
                    item.top = videoHideAlarm.getRectAreas().get(i).getTop();
                    item.right = videoHideAlarm.getRectAreas().get(i).getRight();
                    
                    videoHideAlarmSouth.rectArea[i] = item;
                }
            }
            
            return videoHideAlarmSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_VIDEO_MASK_CFG)
        {
            VideoMaskSouth videoMaskSouth = new VideoMaskSouth();
            videoMaskSouth.getPointer();
            
            VideoMask videoMask = (VideoMask)dataBuffer;
            videoMaskSouth.areaNum = videoMask.getAreaNum();
            videoMaskSouth.enableVideoMask = videoMask.getEnableVideoMask();
            videoMaskSouth.reserve = BytesUtils.stringToBytesForIVS(videoMask.getReserve());
            
            if (null != videoMask.getRectAreas())
            {
                for (int i = 0; i < videoMask.getRectAreas().size(); i++)
                {
                    RectFloatSouth item = new RectFloatSouth();
                    item.clear();
                    
                    item.bottom = videoMask.getRectAreas().get(i).getBottom();
                    item.left = videoMask.getRectAreas().get(i).getLeft();
                    item.top = videoMask.getRectAreas().get(i).getTop();
                    item.right = videoMask.getRectAreas().get(i).getRight();
                    
                    videoMaskSouth.rectArea[i] = item;
                }
            }
            return videoMaskSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_AUDIO_CFG)
        {
            AudioConfigSouth audioConfigSouth = new AudioConfigSouth();
            audioConfigSouth.getPointer();
            
            AudioConfig audioConfig = (AudioConfig)dataBuffer;
            audioConfigSouth.audioIndex = audioConfig.getAudioIndex();
            audioConfigSouth.channelType = audioConfig.getChannelType();
            audioConfigSouth.audioName = BytesUtils.stringToBytesForIVS(audioConfig.getAudioName());
            audioConfigSouth.reserve = BytesUtils.stringToBytesForIVS(audioConfig.getReserve());
            
            AudioParamSouth audioParamSouth = new AudioParamSouth();
            audioParamSouth.clear();
            
            audioParamSouth.channel = audioConfig.getAudioParam().getChannel();
            audioParamSouth.pitch = audioConfig.getAudioParam().getPitch();
            audioParamSouth.volume = audioConfig.getAudioParam().getVolume();
            audioParamSouth.inputType = audioConfig.getAudioParam().getInputType();
            audioParamSouth.dataFormat = audioConfig.getAudioParam().getDataFormat();
            audioParamSouth.sampleRate = audioConfig.getAudioParam().getSampleRate();
            audioParamSouth.gain = audioConfig.getAudioParam().getGain();
            audioParamSouth.sampleBits = audioConfig.getAudioParam().getSampleBits();
            audioParamSouth.reserve = BytesUtils.stringToBytesForIVS(audioConfig.getAudioParam().getReserve());
            
            audioConfigSouth.audioParam = audioParamSouth;
            return audioConfigSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_SERIAL_CHANNEL_CFG)
        {
            SerialChannelConfigSouth serialChannelConfigSouth = new SerialChannelConfigSouth();
            serialChannelConfigSouth.getPointer();
            
            SerialChannelConfig serialChannelConfig = (SerialChannelConfig)dataBuffer;
            serialChannelConfigSouth.baudRate = serialChannelConfig.getBaudRate();
            serialChannelConfigSouth.serialIndex = serialChannelConfig.getSerialIndex();
            serialChannelConfigSouth.serialType = serialChannelConfig.getSerialType();
            serialChannelConfigSouth.dataBit = serialChannelConfig.getDataBit();
            serialChannelConfigSouth.parity = serialChannelConfig.getParity();
            serialChannelConfigSouth.stopBit = serialChannelConfig.getStopBit();
            serialChannelConfigSouth.flowControl = serialChannelConfig.getFlowControl();
            serialChannelConfigSouth.serialName = BytesUtils.stringToBytesForIVS(serialChannelConfig.getSerialName());
            serialChannelConfigSouth.reserve = BytesUtils.stringToBytesForIVS(serialChannelConfig.getReserve());
            
            return serialChannelConfigSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_ALARM_IN_CFG)
        {
            AlarmInConfigSouth alarmInConfigSouth = new AlarmInConfigSouth();
            alarmInConfigSouth.getPointer();
            
            AlarmInConfig alarmInConfig = (AlarmInConfig)dataBuffer;
            alarmInConfigSouth.alarmInChanIndex = alarmInConfig.getAlarmInChanIndex();
            alarmInConfigSouth.switchType = alarmInConfig.getSwitchType();
            alarmInConfigSouth.autoClearAlarmTime = alarmInConfig.getAutoClearAlarmTime();
            alarmInConfigSouth.alarmInName = BytesUtils.stringToBytesForIVS(alarmInConfig.getAlarmInName());
            alarmInConfigSouth.reserve = BytesUtils.stringToBytesForIVS(alarmInConfig.getReserve());
            
            return alarmInConfigSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_ALARM_OUT_CFG)
        {
            AlarmOutConfigSouth alarmOutConfigSouth = new AlarmOutConfigSouth();
            alarmOutConfigSouth.getPointer();
            
            AlarmOutConfig alarmOutConfig = (AlarmOutConfig)dataBuffer;
            alarmOutConfigSouth.alarmOutChanIndex = alarmOutConfig.getAlarmOutChanIndex();
            alarmOutConfigSouth.alarmOutMode = alarmOutConfig.getAlarmOutMode();
            alarmOutConfigSouth.holdTime = alarmOutConfig.getHoldTime();
            alarmOutConfigSouth.switchType = alarmOutConfig.getSwitchType();
            alarmOutConfigSouth.alarmOutName = BytesUtils.stringToBytesForIVS(alarmOutConfig.getAlarmOutName());
            alarmOutConfigSouth.reserve = BytesUtils.stringToBytesForIVS(alarmOutConfig.getReserve());
            
            return alarmOutConfigSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_DEVICE_PTZ_CFG)
        {
            PTZConfigSouth ptzConfigSouth = new PTZConfigSouth();
            ptzConfigSouth.getPointer();
            
            PTZConfig ptzConfig = (PTZConfig)dataBuffer;
            ptzConfigSouth.decoderAddress = ptzConfig.getDecoderAddress();
            ptzConfigSouth.decoderType = ptzConfig.getDecoderType();
            ptzConfigSouth.posNegDirectControl = ptzConfig.getPosNegDirectControl();
            ptzConfigSouth.serialCode =
                BytesUtils.stringToBytesForIVS(ptzConfig.getSerialCode(),
                    CommonConstant.DeviceModule.IVS_DEV_SERIALNO_LEN);
            ptzConfigSouth.reserve = BytesUtils.stringToBytesForIVS(ptzConfig.getReserve());
            
            return ptzConfigSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_EXTEND_CFG)
        {
            CameraExtendConfigSouth cameraExtendConfigSouth = new CameraExtendConfigSouth();
            cameraExtendConfigSouth.getPointer();
            
            CameraExtendConfig cameraExtendConfig = (CameraExtendConfig)dataBuffer;
            cameraExtendConfigSouth.enableBandwidthAdaptive = cameraExtendConfig.getEnableBandwidthAdaptive();
            cameraExtendConfigSouth.enableCache = cameraExtendConfig.getEnableCache();
            cameraExtendConfigSouth.enableWatermark = cameraExtendConfig.getEnableWatermark();
            cameraExtendConfigSouth.fecMatrix = cameraExtendConfig.getFecMatrix();
            cameraExtendConfigSouth.reliableTransmission = cameraExtendConfig.getReliableTransmission();
            cameraExtendConfigSouth.reserve = BytesUtils.stringToBytesForIVS(cameraExtendConfig.getReserve());
            
            MediaSecurityConfigSouth mediaSecurityConfigSouth = new MediaSecurityConfigSouth();
            mediaSecurityConfigSouth.clear();
            
            mediaSecurityConfigSouth.enableMediaSecurity =
                cameraExtendConfig.getMediaSecurityCfg().getEnableMediaSecurity();
            mediaSecurityConfigSouth.enableSecureStorage =
                cameraExtendConfig.getMediaSecurityCfg().getEnableSecureStorage();
            mediaSecurityConfigSouth.mediaSecurityAlgorithm =
                cameraExtendConfig.getMediaSecurityCfg().getMediaSecurityAlgorithm();
            mediaSecurityConfigSouth.reserve =
                BytesUtils.stringToBytesForIVS(cameraExtendConfig.getMediaSecurityCfg().getReserve());
            cameraExtendConfigSouth.mediaSecurityCfg = mediaSecurityConfigSouth;
            
            return cameraExtendConfigSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_SNAPSHOT_CFG)
        {
            CameraSnapshotConfigSouth cameraSnapshotConfigSouth = new CameraSnapshotConfigSouth();
            cameraSnapshotConfigSouth.getPointer();
            
            CameraSnapShotConfig cameraSnapshotConfig = (CameraSnapShotConfig)dataBuffer;
            cameraSnapshotConfigSouth.snapInterval = cameraSnapshotConfig.getSnapInterval();
            cameraSnapshotConfigSouth.snapCount = cameraSnapshotConfig.getSnapCount();
            cameraSnapshotConfigSouth.reserve = BytesUtils.stringToBytesForIVS(cameraSnapshotConfig.getReserve());
            
            return cameraSnapshotConfigSouth;
        }
        else if (configType == ConfigItemEnum.CONFIG_CAMERA_RECORD_STREAM_CFG)
        {
            CameraRecordStreamConfigSouth cameraRecordStreamConfigSouth = new CameraRecordStreamConfigSouth();
            cameraRecordStreamConfigSouth.getPointer();
            
            CameraRecordStreamConfig cameraRecordStreamConfig = (CameraRecordStreamConfig)dataBuffer;
            cameraRecordStreamConfigSouth.streamType = cameraRecordStreamConfig.getStreamType();
            cameraRecordStreamConfigSouth.reserve =
                BytesUtils.stringToBytesForIVS(cameraRecordStreamConfig.getReserve());
            
            return cameraRecordStreamConfigSouth;
        }
        else
        {
            return null;
        }
    }
    
    public DeviceOperResultList addDeviceSouth2Model(DeviceOperResultListSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceOperResultList domain = new DeviceOperResultList();
        domain.setNum(south.num);
        
        DeviceOperResultSouth[] resultInfoSouth = south.deviceOperResultSouths;
        if (null != resultInfoSouth && south.num > 0)
        {
            List<DeviceOperResult> resultInfos = new ArrayList<DeviceOperResult>();
            
            DeviceOperResult resultInfo = null;
            for (int i = 0, length = south.num; i < length; i++)
            {
                resultInfo = new DeviceOperResult();
                resultInfo.setCode(BytesUtils.bytesToStringForIVS(resultInfoSouth[i].code));
                resultInfo.setNvrCode(BytesUtils.bytesToStringForIVS(resultInfoSouth[i].nvrCode));
                resultInfo.setResult(resultInfoSouth[i].result);
                resultInfo.setSequence(resultInfoSouth[i].sequence);
                resultInfo.setReserve(BytesUtils.bytesToStringForIVS(resultInfoSouth[i].reserve));
                
                resultInfos.add(resultInfo);
            }
            if (resultInfos.size() > 0)
            {
                domain.setDeviceOperResults(resultInfos);
            }
        }
        return domain;
    }
    
    /** 
    * 设备组列表南向bean转换为领域bean
    * @param deviceGroupListSouth 设备组列表南向bean
    * @return 设备组列表领域bean
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public DeviceGroupInfos getDeviceGroupInfosSouth2Model(DeviceGroupListSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceGroupInfos domain = new DeviceGroupInfos();
        domain.setTotal(south.total);
        domain.setIndexRange(convertIndexRangeSouthToDomain(south.indexRange));
        
        DeviceGroupSouth[] deviceGroupSouths = south.deviceGroups;
        if (null != deviceGroupSouths)
        {
            DeviceGroupList deviceGroupList = new DeviceGroupList();
            List<DeviceGroup> deviceGroupDomains = new ArrayList<DeviceGroup>();
            deviceGroupList.setDeviceGroups(deviceGroupDomains);
            int length = south.total < deviceGroupSouths.length ? south.total : deviceGroupSouths.length;
            for (int i = 0; i < length; i++)
            {
                DeviceGroup deviceGroupDomain = getDeviceGroupListSouth2Model(deviceGroupSouths[i]);
                if (null != deviceGroupDomain)
                {
                    deviceGroupDomains.add(deviceGroupDomain);
                }
            }
            domain.setDeviceGroupList(deviceGroupList);
        }
        
        return domain;
    }
    
    public DeviceGroup getDeviceGroupListSouth2Model(DeviceGroupSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceGroup domain = new DeviceGroup();
        domain.setDomainCode(BytesUtils.bytesToStringForIVS(south.domainCode));
        domain.setGroupCode(BytesUtils.bytesToStringForIVS(south.groupCode));
        domain.setGroupName(BytesUtils.bytesToStringForIVS(south.groupName));
        domain.setIsExDomain(south.isExDomain);
        domain.setParentGroupCode(BytesUtils.bytesToStringForIVS(south.parentGroupCode));
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
}
