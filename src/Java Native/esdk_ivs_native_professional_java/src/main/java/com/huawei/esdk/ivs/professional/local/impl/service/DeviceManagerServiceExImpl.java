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
package com.huawei.esdk.ivs.professional.local.impl.service;

import java.util.List;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.professional.local.bean.AlarmBriefInfos;
import com.huawei.esdk.ivs.professional.local.bean.AudioBriefInfos;
import com.huawei.esdk.ivs.professional.local.bean.CameraBriefInfos;
import com.huawei.esdk.ivs.professional.local.bean.ConfigItem;
import com.huawei.esdk.ivs.professional.local.bean.DeviceBriefInfos;
import com.huawei.esdk.ivs.professional.local.bean.DeviceCodeList;
import com.huawei.esdk.ivs.professional.local.bean.DeviceConfig;
import com.huawei.esdk.ivs.professional.local.bean.DeviceGroupInfos;
import com.huawei.esdk.ivs.professional.local.bean.DeviceOperInfo;
import com.huawei.esdk.ivs.professional.local.bean.DeviceOperInfoList;
import com.huawei.esdk.ivs.professional.local.bean.DeviceOperResultInfos;
import com.huawei.esdk.ivs.professional.local.bean.DomainRouteInfos;
import com.huawei.esdk.ivs.professional.local.bean.GetDeviceListResponse;
import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.professional.local.bean.IndexRange;
import com.huawei.esdk.ivs.professional.local.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.professional.local.bean.ResultInfos;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalDeviceManager;
import com.huawei.esdk.ivs.professional.local.impl.utils.AES128Utils;
import com.huawei.esdk.ivs.professional.local.impl.utils.ClientProvider;
import com.huawei.esdk.ivs.professional.local.impl.utils.Encrypt;
import com.huawei.esdk.ivs.professional.local.impl.utils.ExceptionUtils;
import com.huawei.esdk.ivs.professional.local.impl.utils.StringUtils;
import com.huawei.esdk.ivs.professional.local.service.devicemanager.DeviceManagerServiceEx;
import com.huawei.esdk.platform.professional.local.constant.PlatformNativeConstant;

public class DeviceManagerServiceExImpl implements DeviceManagerServiceEx
{
    
    private static final Logger LOGGER = Logger.getLogger(DeviceManagerServiceExImpl.class);
    
    private IVSProfessionalDeviceManager ivsProfessionalDeviceManager =
        (IVSProfessionalDeviceManager)ClientProvider.getClient(IVSProfessionalDeviceManager.class);
    
    private static DeviceManagerServiceExImpl instance = null;
    
    public static synchronized DeviceManagerServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new DeviceManagerServiceExImpl();
        }
        return instance;
    }
    
    @Override
    public IVSSDKResponse<DeviceOperResultInfos> addDevice(String domainCode, Integer deviceNum,
        DeviceOperInfoList deviceOperInfo)
    {
        LOGGER.info("begin to execute addDevice method");
        
        IVSSDKResponse<DeviceOperResultInfos> result = new IVSSDKResponse<DeviceOperResultInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<DeviceOperResultInfos> deviceOperResultList = new Holder<DeviceOperResultInfos>();
        List<DeviceOperInfo> operInfo = deviceOperInfo.getDeviceOperInfo();
        if (null != operInfo)
        {
            for (DeviceOperInfo info : operInfo)
            {
                DeviceConfig config = info.getDeviceConfig();
                
                if (null != config)
                {
                    if (!StringUtils.isNullOrEmpty(config.getDevicePassword()))
                    {
                        try
                        {
                            // 加密方式向下兼容
                            String devicePwd = Encrypt.getEncryptPwd(config.getDevicePassword());
                            if (StringUtils.isNullOrEmpty(devicePwd))
                            {
                                LOGGER.debug("encode password error");
                                result.setResultCode(PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE);
                                return result;
                            }
                            config.setDevicePassword(devicePwd);
                        }
                        catch (Exception e)
                        {
                            LOGGER.debug("encode password error");
                            result.setResultCode(PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE);
                            return result;
                        }
                    }
                    
                    if (!StringUtils.isNullOrEmpty(config.getDeviceRegPassword()))
                    {
                        try
                        {
                            // 加密方式向下兼容
                            String deviceRegPwd = Encrypt.getEncryptPwd(config.getDeviceRegPassword());
                            if (StringUtils.isNullOrEmpty(deviceRegPwd))
                            {
                                LOGGER.debug("encode password error");
                                result.setResultCode(PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE);
                                return result;
                            }
                            config.setDeviceRegPassword(deviceRegPwd);
                        }
                        catch (Exception e)
                        {
                            LOGGER.debug("encode password error");
                            result.setResultCode(PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE);
                            return result;
                        }
                    }
                }
            }
        }
        try
        {
            
            ivsProfessionalDeviceManager.addDevice(domainCode,
                deviceNum,
                deviceOperInfo,
                resultCode,
                deviceOperResultList);
        }
        catch (Exception e)
        {
            LOGGER.error("addDevice method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(deviceOperResultList.value);
        
        LOGGER.info("execute addDevice method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<ResultInfos> deleteDevice(String domainCode, Integer deviceNum, DeviceCodeList deviceCode)
    {
        LOGGER.info("begin to execute deleteDevice method");
        
        IVSSDKResponse<ResultInfos> result = new IVSSDKResponse<ResultInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<ResultInfos> resultList = new Holder<ResultInfos>();
        
        try
        {
            ivsProfessionalDeviceManager.deleteDevice(domainCode, deviceNum, deviceCode, resultCode, resultList);
        }
        catch (Exception e)
        {
            LOGGER.error("deleteDevice method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(resultList.value);
        
        LOGGER.info("execute deleteDevice method completed");
        
        return result;
        
    }
    
    @Override
    public IVSSDKResponse<ConfigItem> getDeviceConfig(String deviceCode, Integer configType)
    {
        LOGGER.info("begin to execute getDeviceConfig method");
        
        IVSSDKResponse<ConfigItem> result = new IVSSDKResponse<ConfigItem>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<ConfigItem> configItem = new Holder<ConfigItem>();
        
        try
        {
            ivsProfessionalDeviceManager.getDeviceConfig(deviceCode, configType, resultCode, configItem);
        }
        catch (Exception e)
        {
            LOGGER.error("getDeviceConfig method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        ConfigItem configItemValue = configItem.value;
        if (null != configItemValue && null != configItemValue.getDeviceConfig())
        {
            DeviceConfig deviceConfig = configItemValue.getDeviceConfig();
            String psw = deviceConfig.getDevicePassword();
            if (!StringUtils.isNullOrEmpty(psw))
            {
                try
                {
                    deviceConfig.setDevicePassword(AES128Utils.decodeFromBase64(psw));
                }
                catch (Exception e)
                {
                    LOGGER.error("devicePassword decode error", e);
                }
                
            }
            else
            {
                deviceConfig.setDevicePassword("");
            }
            
            String rpsw = deviceConfig.getDeviceRegPassword();
            if (!StringUtils.isNullOrEmpty(rpsw))
            {
                try
                {
                    deviceConfig.setDeviceRegPassword(AES128Utils.decodeFromBase64(rpsw));
                }
                catch (Exception e)
                {
                    LOGGER.error("devicePassword decode error", e);
                }
            }
            else
            {
                deviceConfig.setDeviceRegPassword("");
            }
        }
        result.setResult(configItemValue);
        
        LOGGER.info("execute getDeviceConfig method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<GetDeviceListResponse> getDeviceList(Integer deviceType, IndexRange indexRange)
    {
        LOGGER.info("begin to execute getDeviceList method");
        IVSSDKResponse<GetDeviceListResponse> result = new IVSSDKResponse<GetDeviceListResponse>();
        GetDeviceListResponse getDeviceListResponse = new GetDeviceListResponse();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<CameraBriefInfos> cameraList = new Holder<CameraBriefInfos>();
        Holder<AudioBriefInfos> audioList = new Holder<AudioBriefInfos>();
        Holder<AlarmBriefInfos> alarmList = new Holder<AlarmBriefInfos>();
        
        try
        {
            ivsProfessionalDeviceManager.getDeviceList(deviceType,
                indexRange,
                resultCode,
                cameraList,
                audioList,
                alarmList);
        }
        catch (Exception e)
        {
            LOGGER.error("getDeviceList method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        getDeviceListResponse.setCameraBriefInfos(cameraList.value);
        getDeviceListResponse.setAudioBriefInfos(audioList.value);
        getDeviceListResponse.setAlarmBriefInfos(alarmList.value);
        
        result.setResult(getDeviceListResponse);
        result.setResultCode(resultCode.value);
        
        LOGGER.info("execute getDeviceList method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<DomainRouteInfos> getDomainRoute()
    {
        LOGGER.info("begin to execute getDomainRoute method");
        
        IVSSDKResponse<DomainRouteInfos> result = new IVSSDKResponse<DomainRouteInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<DomainRouteInfos> domainRouteList = new Holder<DomainRouteInfos>();
        
        try
        {
            ivsProfessionalDeviceManager.getDomainRoute(resultCode, domainRouteList);
        }
        catch (Exception e)
        {
            LOGGER.error("getDomainRoute method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(domainRouteList.value);
        
        LOGGER.info("execute getDomainRoute method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<DeviceBriefInfos> queryDeviceList(String domainCode, Integer deviceType,
        QueryUnifiedFormat queryFormat)
    {
        LOGGER.info("begin to execute queryDeviceList method");
        
        IVSSDKResponse<DeviceBriefInfos> result = new IVSSDKResponse<DeviceBriefInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<DeviceBriefInfos> deviceBriefInfos = new Holder<DeviceBriefInfos>();
        
        try
        {
            ivsProfessionalDeviceManager.queryDeviceList(domainCode,
                deviceType,
                queryFormat,
                resultCode,
                deviceBriefInfos);
        }
        catch (Exception e)
        {
            LOGGER.error("queryDeviceList method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResult(deviceBriefInfos.value);
        result.setResultCode(resultCode.value);
        
        LOGGER.info("execute queryDeviceList method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<String> verifyDevice(String domainCode, String verifyInfo)
    {
        LOGGER.info("begin to execute verifyDevice method");
        
        IVSSDKResponse<String> response = new IVSSDKResponse<String>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<String> responseXML = new Holder<String>();
        try
        {
            ivsProfessionalDeviceManager.verifyDevice(domainCode, verifyInfo, resultCode, responseXML);
        }
        catch (Exception e)
        {
            LOGGER.error("verifyDevice method exception happened", e);
            
            response.setResultCode(ExceptionUtils.processSoapException(e));
            return response;
        }
        
        response.setResult(responseXML.value);
        response.setResultCode(resultCode.value);
        
        LOGGER.info("execute verifyDevice method completed");
        
        return response;
    }
    
    @Override
    public Integer rebootDevice(String deviceCode, Integer rebootType)
    {
        LOGGER.info("begin to execute rebootDevice method");
        
        try
        {
            Integer errorCode = ivsProfessionalDeviceManager.rebootDevice(deviceCode, rebootType);
            LOGGER.info("execute rebootDevice method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("rebootDevice method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public Integer setCameraName(String cameraCode, String newCameraName)
    {
        LOGGER.info("begin to execute setCameraName method");
        
        try
        {
            Integer errorCode = ivsProfessionalDeviceManager.setCameraName(cameraCode, newCameraName);
            LOGGER.info("execute setCameraName method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("setCameraName method exception happened", e);
            
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public Integer setDeviceConfig(String deviceCode, Integer configType, ConfigItem configItem)
    {
        LOGGER.info("begin to execute setDeviceConfig method");
        
        int CONFIG_DEVICE_CFG = 1;
        if (CONFIG_DEVICE_CFG == configType && null != configItem.getDeviceConfig())
        {
            
            DeviceConfig config = configItem.getDeviceConfig();
            
            if (null != config)
            {
                if (!StringUtils.isNullOrEmpty(config.getDevicePassword()))
                {
                    try
                    {
                        // 加密方式向下兼容
                        String devicePwd = Encrypt.getEncryptPwd(config.getDevicePassword());
                        if (StringUtils.isNullOrEmpty(devicePwd))
                        {
                            return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
                        }
                        config.setDevicePassword(devicePwd);
                    }
                    catch (Exception e)
                    {
                        LOGGER.debug("encode password error");
                        return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
                    }
                }
                
                if (!StringUtils.isNullOrEmpty(config.getDeviceRegPassword()))
                {
                    try
                    {
                        // 加密方式向下兼容
                        String deviceRegPwd = Encrypt.getEncryptPwd(config.getDeviceRegPassword());
                        if (StringUtils.isNullOrEmpty(deviceRegPwd))
                        {
                            return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
                        }
                        config.setDeviceRegPassword(deviceRegPwd);
                    }
                    catch (Exception e)
                    {
                        LOGGER.debug("encode password error");
                        return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
                    }
                }
            }
            
        }
        
        try
        {
            
            Integer errorCode = ivsProfessionalDeviceManager.setDeviceConfig(deviceCode, configType, configItem);
            LOGGER.info("execute setDeviceConfig method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("setDeviceConfig method exception happened", e);
            
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public Integer setMainDeviceName(String deviceCode, String newDeviceName)
    {
        LOGGER.info("begin to execute setMainDeviceName method");
        
        try
        {
            Integer errorCode = ivsProfessionalDeviceManager.setMainDeviceName(deviceCode, newDeviceName);
            LOGGER.info("execute setMainDeviceName method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("setMainDeviceName method exception happened", e);
            
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public Integer startSearchDevice(String domainCode, String searchInfo)
    {
        LOGGER.info("begin to execute startSearchDevice method");
        
        try
        {
            Integer errorCode = ivsProfessionalDeviceManager.startSearchDevice(domainCode, searchInfo);
            LOGGER.info("execute startSearchDevice method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("startSearchDevice method exception happened", e);
            
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public Integer stopSearchDevice(String domainCode, String searchInfo)
    {
        LOGGER.info("begin to execute stopSearchDevice method");
        
        try
        {
            Integer errorCode = ivsProfessionalDeviceManager.stopSearchDevice(domainCode, searchInfo);
            LOGGER.info("execute stopSearchDevice method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("stopSearchDevice method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public IVSSDKResponse<DeviceGroupInfos> getDeviceGroup(String domainCode, Integer deviceGroupCode)
    {
        LOGGER.info("begin to execute getDeviceGroup method");
        IVSSDKResponse<DeviceGroupInfos> response = new IVSSDKResponse<DeviceGroupInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<DeviceGroupInfos> deviceGroupInfos = new Holder<DeviceGroupInfos>();
        
        try
        {
            ivsProfessionalDeviceManager.getDeviceGroup(domainCode, deviceGroupCode, resultCode, deviceGroupInfos);
            LOGGER.info("execute getDeviceGroup method completed");
            
        }
        catch (Exception e)
        {
            LOGGER.error("getDeviceGroup method exception happened", e);
            response.setResultCode(ExceptionUtils.processSoapException(e));
            return response;
        }
        
        response.setResult(deviceGroupInfos.value);
        response.setResultCode(resultCode.value);
        
        return response;
    }
    
    @Override
    public Integer setVideoDiagnose(String diagnoseXML)
    {
        LOGGER.info("begin to execute setVideoDiagnose method");
        
        try
        {
            Integer errorCode = ivsProfessionalDeviceManager.setVideoDiagnose(diagnoseXML);
            
            LOGGER.info("execute setVideoDiagnose method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("setVideoDiagnose method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public IVSSDKResponse<String> getVideoDiagnose(String domainCode, String cameraCode)
    {
        LOGGER.info("begin to execute getVideoDiagnose method");
        
        IVSSDKResponse<String> response = new IVSSDKResponse<String>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<String> responseXML = new Holder<String>();
        try
        {
            ivsProfessionalDeviceManager.getVideoDiagnose(domainCode, cameraCode, resultCode, responseXML);
        }
        catch (Exception e)
        {
            LOGGER.error("getVideoDiagnose method exception happened", e);
            
            response.setResultCode(ExceptionUtils.processSoapException(e));
            return response;
        }
        
        response.setResult(responseXML.value);
        response.setResultCode(resultCode.value);
        
        LOGGER.info("execute getVideoDiagnose method completed");
        
        return response;
    }
    
}
