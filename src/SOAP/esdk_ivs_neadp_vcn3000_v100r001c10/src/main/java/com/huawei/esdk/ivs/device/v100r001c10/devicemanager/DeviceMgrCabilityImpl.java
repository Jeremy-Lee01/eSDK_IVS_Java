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
package com.huawei.esdk.ivs.device.v100r001c10.devicemanager;

import java.util.List;
import org.apache.log4j.Logger;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.device.BaseCability;
import com.huawei.esdk.ivs.device.v100r001c10.devicemanager.convert.DeviceMgrCabilityConvert;
import com.huawei.esdk.ivs.device.vcn3000.devicemanager.IDeviceMgrCability;
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.huawei.esdk.ivs.domain.model.Device;
import com.huawei.esdk.ivs.domain.model.bean.AlarmBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmInConfig;
import com.huawei.esdk.ivs.domain.model.bean.AlarmOutConfig;
import com.huawei.esdk.ivs.domain.model.bean.AudioBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.AudioConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.CameraConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraDisplayConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraExtendConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraImagingConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraOSDConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraRecordStreamConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraSnapShotConfig;
import com.huawei.esdk.ivs.domain.model.bean.CameraStreamConfig;
import com.huawei.esdk.ivs.domain.model.bean.ConfigItemEnum;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.DeviceCode;
import com.huawei.esdk.ivs.domain.model.bean.DeviceGroupInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceNetConfig;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.DeviceTimeConfig;
import com.huawei.esdk.ivs.domain.model.bean.DomainRouteList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.MotionDetection;
import com.huawei.esdk.ivs.domain.model.bean.PTZConfig;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.SerialChannelConfig;
import com.huawei.esdk.ivs.domain.model.bean.VideoHideAlarm;
import com.huawei.esdk.ivs.domain.model.bean.VideoMask;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.IndexRangeSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryUnifiedFormatSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.DeviceBriefInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AlarmBriefInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AlarmInConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AlarmOutConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AudioBriefInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AudioConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraBriefInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraDisplayConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraExtendConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraImagingConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraOSDConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraRecordStreamConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraSnapshotConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.CameraStreamConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceCodeListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceGroupListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceNetConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceOperInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceOperResultListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceTimeConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DomainRouteListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.MotionDetectionSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.PTZConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.ResultListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.SerialChannelConfigSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.VideoHideAlarmSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.VideoMaskSouth;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.BytesUtils;
import com.huawei.esdk.platform.common.utils.NumberUtils;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;

/**
 * 设备管理模块南向接口管理类
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class DeviceMgrCabilityImpl extends BaseCability implements IDeviceMgrCability
{
	private static final int INDEX_RANGE = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("index.range"));
	
    private static final CameraBriefInfoListSouth CAMERA_BRIEF_INFO_LIST_SOUTH = new CameraBriefInfoListSouth(
    		INDEX_RANGE);
    
    private static final AudioBriefInfoListSouth AUDIO_BRIEF_INFO_LIST_SOUTH = new AudioBriefInfoListSouth(
    		INDEX_RANGE);
    
    private static final AlarmBriefInfoListSouth ALARM_BRIEF_INFO_LIST_SOUTH = new AlarmBriefInfoListSouth(
    		INDEX_RANGE);
    
    private static final DeviceBriefInfoListSouth DEVICE_BRIEF_INFO_LIST_SOUTH = new DeviceBriefInfoListSouth(
    		INDEX_RANGE);
    
    /**
     * 日志对象 
     */
    private static final Logger LOGGER = Logger.getLogger(DeviceMgrCabilityImpl.class);
    
    private DeviceMgrCabilityConvert deviceMgrCabilityConvert =
        ApplicationContextUtil.getBean("deviceMgrCabilityConvert");
    
    public SDKErrorCode rebootDevice(String deviceCode, int rebootType)
    {
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        int sessionId = getIVSSessionId();
        
        int result = super.getBaseCablilityJNA().IVS_SDK_RebootDevice(sessionId, deviceCode, rebootType);
        sdkResult.setErrCode(result);
        
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode startSearchDevice(String domainCode, String searchInfo)
    {
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        int sessionId = getIVSSessionId();
        
        int result = super.getBaseCablilityJNA().IVS_SDK_StartSearchDevice(sessionId, domainCode, searchInfo);
        sdkResult.setErrCode(result);
        
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode stopSearchDevice(String domainCode, String searchInfo)
    {
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        int sessionId = getIVSSessionId();
        
        int result = super.getBaseCablilityJNA().IVS_SDK_StopSearchDevice(sessionId, domainCode, searchInfo);
        sdkResult.setErrCode(result);
        
        return sdkResult;
    }
    
    @Override
    public SDKResult<String> verifyDevice(String domainCode, String verifyInfo)
    {
        SDKResult<String> sdkResult = new SDKResult<String>();
        
        int sessionId = getIVSSessionId();
        
        String[] strings = {""};
        StringArray respXml = new StringArray(strings);
        respXml.clear();
        Pointer res = respXml;
        
        int result = super.getBaseCablilityJNA().IVS_SDK_VerifyDevice(sessionId, domainCode, verifyInfo, res);
        
        respXml.read();
        
        if (0 == result)
        {
            strings = respXml.getStringArray(0);
            if(null != strings && 0 < strings.length)
            {
                sdkResult.setResult(strings[0]);
            }
        }
        sdkResult.setErrCode(result);
        
        return sdkResult;
    }
    
    @Override
    public SDKResult<DeviceOperResultList> addDevice(String domainCode, int deviceNum, List<Device> deviceInfos)
    {
        SDKResult<DeviceOperResultList> sdkResult = new SDKResult<DeviceOperResultList>();
        
        int sessionId = getIVSSessionId();
        
        DeviceOperInfoSouth[] deviceSouths = deviceMgrCabilityConvert.addDeviceModel2South(deviceInfos);
        
        DeviceOperResultListSouth resultListSouth = new DeviceOperResultListSouth(deviceInfos.size());
        int resultBufferSize = resultListSouth.size();
        resultListSouth.clear();
        
        int result =
            super.getBaseCablilityJNA().IVS_SDK_AddDevice(sessionId,
                domainCode,
                deviceNum,
                deviceSouths,
                resultListSouth.getPointer(),
                resultBufferSize);
        resultListSouth.read();
        
        DeviceOperResultList resultList = deviceMgrCabilityConvert.addDeviceSouth2Model(resultListSouth);
        sdkResult.setResult(resultList);
        
        sdkResult.setErrCode(result);
        
        return sdkResult;
    }
    
    @Override
    public SDKResult<DeviceOperResultList> deleteDevice(String domainCode, int deviceNum,
        List<DeviceCode> deviceCodeList)
    {
        int sessionId = getIVSSessionId();
        DeviceCodeListSouth deviceCodeListSouth =
            deviceMgrCabilityConvert.getDeviceCodeListSouthModel2South(deviceCodeList);
        ResultListSouth resultListSouth = new ResultListSouth(deviceCodeList.size());
        int resultBufferSize = resultListSouth.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_DeleteDevice(sessionId,
                domainCode,
                deviceNum,
                deviceCodeListSouth,
                resultListSouth.getPointer(),
                resultBufferSize);
        resultListSouth.read();
        
        SDKResult<DeviceOperResultList> result = new SDKResult<DeviceOperResultList>();
        result.setErrCode(resultCode);
        DeviceOperResultList resultList = deviceMgrCabilityConvert.getResultListSouth2Model(resultListSouth);
        if (null != resultList)
        {
            result.setResult(resultList);
        }
        
        return result;
    }
    
    @Override
    public SDKErrorCode setMainDeviceName(String deviceCode, String deviceNewName)
    {
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        int sessionId = getIVSSessionId();
        
        // modify by cWX191990, IVS Bug:该接口的deviceNewName不支持传String，且转成byte后还要固定长度128
        // 长度为128个字节
        int result =
            super.getBaseCablilityJNA().IVS_SDK_SetMainDeviceName(sessionId,
                deviceCode,
                BytesUtils.stringToBytesForIVS(deviceNewName, CommonConstant.DeviceModule.IVS_DEVICE_NAME_LEN));
        sdkResult.setErrCode(result);
        
        return sdkResult;
    }
    
    @Override
    public SDKErrorCode setDeviceConfig(String deviceCode, int configType, Object dataBuffer)
    {
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        int sessionId = getIVSSessionId();
        
        Structure southDataBuffer = deviceMgrCabilityConvert.setDeviceConfigModel2South(configType, dataBuffer);
        if (null == southDataBuffer)
        {
            sdkResult.setErrCode(ErrInfo.DATA_ERRORCODE);
            return sdkResult;
        }
        
        int bufferSize = southDataBuffer.size();
        
        int result =
            super.getBaseCablilityJNA().IVS_SDK_SetDeviceConfig(sessionId,
                deviceCode,
                configType,
                southDataBuffer,
                bufferSize);
        
        sdkResult.setErrCode(result);
        
        return sdkResult;
    }
    
    @Override
    public SDKResult<DomainRouteList> getDomainRoute()
    {
        int sessionId = getIVSSessionId();
        DomainRouteListSouth domainRouteListSouth = new DomainRouteListSouth();
        int bufferSize = domainRouteListSouth.size();
        int resultCode =
            super.getBaseCablilityJNA()
                .IVS_SDK_GetDomainRoute(sessionId, domainRouteListSouth.getPointer(), bufferSize);
        domainRouteListSouth.read();
        SDKResult<DomainRouteList> result = new SDKResult<DomainRouteList>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            DomainRouteList domainRouteList =
                deviceMgrCabilityConvert.getDomainRouteListSouth2Model(domainRouteListSouth);
            if (null != domainRouteList)
            {
                result.setResult(domainRouteList);
            }
        }
        return result;
    }
    
    @Override
    public SDKErrorCode setCameraName(String cameraCode, String cameraNewName)
    {
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        int sessionId = getIVSSessionId();
        
        // modify by cWX191990, IVS Bug:该接口的cameraNewName不支持传String，且转成byte后还要固定长度192
        // 长度为192个字节
        int result =
            super.getBaseCablilityJNA().IVS_SDK_SetCameraName(sessionId,
                cameraCode,
                BytesUtils.stringToBytesForIVS(cameraNewName, CommonConstant.DeviceModule.IVS_CAMERA_NAME_LEN));
        sdkResult.setErrCode(result);
        
        return sdkResult;
    }
    
    @Override
    public synchronized SDKResult<Object> getDeviceList(int deviceType, IndexRange indexRange)
    {
        SDKResult<Object> result = new SDKResult<Object>();
        IndexRangeSouth indexRangeSouth = deviceMgrCabilityConvert.convertIndexRangeToSouth(indexRange);
        int sessionId = getIVSSessionId();
        int size = indexRange.getToIndex() - indexRange.getFromIndex() + 1;
        
        if (1 > size)
        {
            size = 1;
        }
        
        //int bufferSize;
        int resultCode;
        
        // 目前deviceType仅支持三种：摄像头，语音和告警
        if (2 == deviceType)
        {
            // CameraBriefInfoListSouth cameraBriefInfoListSouth = new CameraBriefInfoListSouth(size);
            CAMERA_BRIEF_INFO_LIST_SOUTH.clear();
            Pointer pointer = CAMERA_BRIEF_INFO_LIST_SOUTH.getPointer();
            //bufferSize = CAMERA_BRIEF_INFO_LIST_SOUTH.size();
            resultCode =
                super.getBaseCablilityJNA().IVS_SDK_GetDeviceList(sessionId,
                    deviceType,
                    indexRangeSouth,
                    pointer,
                    size * 980 + 12);
            CAMERA_BRIEF_INFO_LIST_SOUTH.read();
            result.setErrCode(resultCode);
            
            if (0 == resultCode)
            {
                CameraBriefInfoList cameraBriefInfoList =
                    deviceMgrCabilityConvert.convertCameraBriefInfoListSouthToDomain(CAMERA_BRIEF_INFO_LIST_SOUTH);
                result.setResult(cameraBriefInfoList);
            }
            
            return result;
        }
        else if (3 == deviceType)
        {
            // AudioBriefInfoListSouth audioBriefInfoListSouth = new AudioBriefInfoListSouth(size);
            AUDIO_BRIEF_INFO_LIST_SOUTH.clear();
            Pointer pointer = AUDIO_BRIEF_INFO_LIST_SOUTH.getPointer();
            //bufferSize = AUDIO_BRIEF_INFO_LIST_SOUTH.size();
            resultCode =
                super.getBaseCablilityJNA().IVS_SDK_GetDeviceList(sessionId,
                    deviceType,
                    indexRangeSouth,
                    pointer,
                    size * 264 + 44);
            AUDIO_BRIEF_INFO_LIST_SOUTH.read();
            result.setErrCode(resultCode);
            
            if (0 == resultCode)
            {
                AudioBriefInfoList audioBriefInfoList =
                    deviceMgrCabilityConvert.convertAudioBriefInfoListSouthToDomain(AUDIO_BRIEF_INFO_LIST_SOUTH);
                result.setResult(audioBriefInfoList);
            }
            
            return result;
        }
        else if (4 == deviceType)
        {
            // AlarmBriefInfoListSouth alarmBriefInfoListSouth = new AlarmBriefInfoListSouth(size);
            ALARM_BRIEF_INFO_LIST_SOUTH.clear();
            Pointer pointer = ALARM_BRIEF_INFO_LIST_SOUTH.getPointer();
            //bufferSize = ALARM_BRIEF_INFO_LIST_SOUTH.size();
            resultCode =
                super.getBaseCablilityJNA().IVS_SDK_GetDeviceList(sessionId,
                    deviceType,
                    indexRangeSouth,
                    pointer,
                    size * 588 + 44);
            ALARM_BRIEF_INFO_LIST_SOUTH.read();
            result.setErrCode(resultCode);
            
            if (0 == resultCode)
            {
                AlarmBriefInfoList alarmBriefInfoList =
                    deviceMgrCabilityConvert.convertAlarmBriefInfoListSouthToDomain(ALARM_BRIEF_INFO_LIST_SOUTH);
                result.setResult(alarmBriefInfoList);
            }
            
            return result;
        }
        else
        {
            LOGGER.error("deviceType error");
            
            // 输入参数非法
            result.setErrCode(2);
            return result;
        }
    }
    
    @Override
    public synchronized SDKResult<Object> queryDeviceList(int deviceType, QueryUnifiedFormat queryUnifiedFormat,
        String domainCode)
    {
        QueryUnifiedFormatSouth queryUnifiedFormatSouth =
            deviceMgrCabilityConvert.convertQueryUnifiedFormatToSouth(queryUnifiedFormat);
        int sessionId = getIVSSessionId();
        
        int size =
            queryUnifiedFormatSouth.indexRangeSouth.toIndex - queryUnifiedFormatSouth.indexRangeSouth.fromIndex + 1;
        
        if (1 > size)
        {
            size = 1;
        }
        
        //DeviceBriefInfoListSouth deviceBriefInfoListSouth = new DeviceBriefInfoListSouth(size);
        //int bufferSize = deviceBriefInfoListSouth.size();
        DEVICE_BRIEF_INFO_LIST_SOUTH.clear();
        Pointer pointer = DEVICE_BRIEF_INFO_LIST_SOUTH.getPointer();
        
        // TODO 目前仅支持主设备查询(deviceType=1)，后续可能会支持摄像机查询，为方便扩展，返回类型使用Object
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_QueryDeviceList(sessionId,
                domainCode,
                deviceType,
                queryUnifiedFormatSouth,
                pointer,
                size * 632 + 44);
        DEVICE_BRIEF_INFO_LIST_SOUTH.read();
        
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        
        if (0 == resultCode)
        {
            DeviceBriefInfoList deviceBriefInfoList =
                deviceMgrCabilityConvert.convertDeviceBriefInfoListSouthToDomain(DEVICE_BRIEF_INFO_LIST_SOUTH);
            result.setResult(deviceBriefInfoList);
        }
        
        return result;
    }
    
    @Override
    public SDKResult<String> getDeviceCapability(int capabilityType, String devCode)
    {
        SDKResult<String> result = new SDKResult<String>();
        int sessionId = getIVSSessionId();
        String[] strings = {""};
        StringArray rspXml = new StringArray(strings);
        rspXml.clear();
        Pointer p = rspXml;
        int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetDeviceCapability(sessionId, capabilityType, devCode, p);
        rspXml.read();
        result.setErrCode(resultCode);
        //成功返回0，失败返回错误码
        if (0 == resultCode)
        {
            strings = rspXml.getStringArray(0);
            if (null != strings && strings.length > 0)
            {
                result.setResult(strings[0]);
            }
        }
        return result;
    }
    
    @Override
    public SDKResult<Object> getDeviceConfig(String devCode, int configType)
    {
        int sessionId = getIVSSessionId();
        switch (configType)
        {
            case ConfigItemEnum.CONFIG_DEVICE_CFG:
                return getCommonDeviceConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_DEVICE_NET_CFG:
                return getDeviceNetConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_DEVICE_TIME_CFG:
                return getDeviceTimeConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_CFG:
                return getCameraConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_STREAM_CFG:
                return getCameraStreamConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_DISPLAY_CFG:
                return getCameraDisplayConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_IMAGING_CFG:
                return getCameraImagingConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_OSD_CFG:
                return getCameraOSDConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_MOTION_DETECTION_CFG:
                return getMotionDetection(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_VIDEO_HIDE_ALARM_CFG:
                return getVideoHideAlarm(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_VIDEO_MASK_CFG:
                return getVideoMask(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_AUDIO_CFG:
                return getAudioConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_SERIAL_CHANNEL_CFG:
                return getSerialChannelConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_ALARM_IN_CFG:
                return getAlarmInConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_ALARM_OUT_CFG:
                return getAlarmOutConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_DEVICE_PTZ_CFG:
                return getPTZConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_EXTEND_CFG:
                return getCameraExtendConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_SNAPSHOT_CFG:
                return getCameraSnapShotConfig(sessionId, devCode, configType);
            case ConfigItemEnum.CONFIG_CAMERA_RECORD_STREAM_CFG:
                return getCameraRecordStreamConfig(sessionId, devCode, configType);
            default:
                return null;
        }
    }
    
    private SDKResult<Object> getCommonDeviceConfig(int sessionId, String devCode, int configType)
    {
        DeviceConfigSouth south = new DeviceConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            Device device = deviceMgrCabilityConvert.getDeviceSouth2Model(south);
            if (null != device)
            {
                result.setResult(device);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getDeviceNetConfig(int sessionId, String devCode, int configType)
    {
        DeviceNetConfigSouth south = new DeviceNetConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            DeviceNetConfig domain = deviceMgrCabilityConvert.getDeviceNetConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getDeviceTimeConfig(int sessionId, String devCode, int configType)
    {
        DeviceTimeConfigSouth south = new DeviceTimeConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            DeviceTimeConfig domain = deviceMgrCabilityConvert.getDeviceTimeConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getCameraConfig(int sessionId, String devCode, int configType)
    {
        CameraConfigSouth south = new CameraConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            CameraConfig domain = deviceMgrCabilityConvert.getCameraConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getCameraStreamConfig(int sessionId, String devCode, int configType)
    {
        CameraStreamConfigSouth south = new CameraStreamConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            CameraStreamConfig domain = deviceMgrCabilityConvert.getCameraStreamConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getCameraDisplayConfig(int sessionId, String devCode, int configType)
    {
        CameraDisplayConfigSouth south = new CameraDisplayConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            CameraDisplayConfig domain = deviceMgrCabilityConvert.getCameraDisplayConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getCameraImagingConfig(int sessionId, String devCode, int configType)
    {
        CameraImagingConfigSouth south = new CameraImagingConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            CameraImagingConfig domain = deviceMgrCabilityConvert.getCameraImagingConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getCameraOSDConfig(int sessionId, String devCode, int configType)
    {
        CameraOSDConfigSouth south = new CameraOSDConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            CameraOSDConfig domain = deviceMgrCabilityConvert.getCameraOSDConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getMotionDetection(int sessionId, String devCode, int configType)
    {
        MotionDetectionSouth south = new MotionDetectionSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            MotionDetection domain = deviceMgrCabilityConvert.getMotionDetectionSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getVideoHideAlarm(int sessionId, String devCode, int configType)
    {
        VideoHideAlarmSouth south = new VideoHideAlarmSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            VideoHideAlarm domain = deviceMgrCabilityConvert.getVideoHideAlarmSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    //VideoMask
    private SDKResult<Object> getVideoMask(int sessionId, String devCode, int configType)
    {
        VideoMaskSouth south = new VideoMaskSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            VideoMask domain = deviceMgrCabilityConvert.getVideoMaskSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getAudioConfig(int sessionId, String devCode, int configType)
    {
        AudioConfigSouth south = new AudioConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            AudioConfig domain = deviceMgrCabilityConvert.getAudioConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getSerialChannelConfig(int sessionId, String devCode, int configType)
    {
        SerialChannelConfigSouth south = new SerialChannelConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            SerialChannelConfig domain = deviceMgrCabilityConvert.getSerialChannelConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getAlarmInConfig(int sessionId, String devCode, int configType)
    {
        AlarmInConfigSouth south = new AlarmInConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            AlarmInConfig domain = deviceMgrCabilityConvert.getAlarmInConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getAlarmOutConfig(int sessionId, String devCode, int configType)
    {
        AlarmOutConfigSouth south = new AlarmOutConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            AlarmOutConfig domain = deviceMgrCabilityConvert.getAlarmOutConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    //PTZConfig
    private SDKResult<Object> getPTZConfig(int sessionId, String devCode, int configType)
    {
        PTZConfigSouth south = new PTZConfigSouth();
        south.clear();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            PTZConfig domain = deviceMgrCabilityConvert.getPTZConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getCameraExtendConfig(int sessionId, String devCode, int configType)
    {
        CameraExtendConfigSouth south = new CameraExtendConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            CameraExtendConfig domain = deviceMgrCabilityConvert.getCameraExtendConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getCameraSnapShotConfig(int sessionId, String devCode, int configType)
    {
        CameraSnapshotConfigSouth south = new CameraSnapshotConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            CameraSnapShotConfig domain = deviceMgrCabilityConvert.getCameraSnapShotConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    private SDKResult<Object> getCameraRecordStreamConfig(int sessionId, String devCode, int configType)
    {
        CameraRecordStreamConfigSouth south = new CameraRecordStreamConfigSouth();
        int bufSize = south.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceConfig(sessionId,
                devCode,
                configType,
                south.getPointer(),
                bufSize);
        south.read();
        SDKResult<Object> result = new SDKResult<Object>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            CameraRecordStreamConfig domain = deviceMgrCabilityConvert.getCameraRecordStreamConfigSouth2Model(south);
            if (null != domain)
            {
                result.setResult(domain);
            }
        }
        return result;
    }
    
    /** 
     * 获取设备组列表
     * @param domainCode 设备组所属域编码
     * @param deviceGroupCode 设备组编码, 根设备组编码为0
     * @return  SDKResult<DeviceGroupInfos> 设备组列表
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public SDKResult<DeviceGroupInfos> getDeviceGroup(String domainCode, int deviceGroupCode)
    {
        LOGGER.info("IVS_SDK_GetDeviceGroup start --->>> ");
        
        SDKResult<DeviceGroupInfos> result = new SDKResult<DeviceGroupInfos>();
        int sessionId = getIVSSessionId();
        DeviceGroupListSouth deviceGroupListSouth = new DeviceGroupListSouth();
        deviceGroupListSouth.clear();
        int bufferSize = deviceGroupListSouth.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetDeviceGroup(sessionId,
                domainCode,
                String.valueOf(deviceGroupCode),
                deviceGroupListSouth.getPointer(),
                bufferSize);
        
        result.setErrCode(resultCode);
        deviceGroupListSouth.read();
        LOGGER.info("IVS_SDK_GetDeviceGroup result code: " + resultCode);
        LOGGER.info("IVS_SDK_GetDeviceGroup end --->>> ");
        
        DeviceGroupInfos domain = deviceMgrCabilityConvert.getDeviceGroupInfosSouth2Model(deviceGroupListSouth);
        if (null != domain)
        {
            result.setResult(domain);
        }
        return result;
    }

    @Override
    public SDKErrorCode setVideoDiagnose(String reqXml)
    {
        LOGGER.info("setVideoDiagnose method start--->>>");
        LOGGER.debug("input parameter reqXml:" + reqXml);
        
        SDKErrorCode result = new SDKErrorCode();
        int sessionId = super.getIVSSessionId();
        
        int resultCode = super.getBaseCablilityJNA().IVS_SDK_SetVideoDiagnose(sessionId, reqXml);
        
        result.setErrCode(resultCode);
        
        LOGGER.info("setVideoDiagnose method result code:" + resultCode);
        LOGGER.info("setVideoDiagnose method end--->>>");
        
        return result;
    }

    @Override
    public SDKResult<String> getVideoDiagnose(String domainCode, String cameraCode)
    {
        LOGGER.info("getVideoDiagnose method start--->>>");
        LOGGER.debug("input parameter domainCode:" + domainCode);
        LOGGER.debug("input parameter cameraCode:" + cameraCode);
        
        int sessionId = super.getIVSSessionId();
        String[] strings = {""};
        StringArray respXml = new StringArray(strings);
        respXml.clear();
        Pointer res = respXml;
        
        int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetVideoDiagnose(sessionId, domainCode, cameraCode, res);
        
        respXml.read();
        SDKResult<String> result = new SDKResult<String>();
        
        if (0 == resultCode)
        {
            strings = respXml.getStringArray(0);
            if(null != strings && 0 < strings.length)
            {
                result.setResult(strings[0]);
            }
        }
        
        result.setErrCode(resultCode);
        
        LOGGER.info("getVideoDiagnose method result code:" + resultCode);
        LOGGER.info("getVideoDiagnose method end--->>>");
        
        return result;
    }
    
}
