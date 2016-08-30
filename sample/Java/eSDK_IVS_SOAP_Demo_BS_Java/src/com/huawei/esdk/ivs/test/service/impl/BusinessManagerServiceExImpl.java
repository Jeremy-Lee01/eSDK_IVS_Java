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
package com.huawei.esdk.ivs.test.service.impl;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.test.bean.GetPTZPresetListResponse;
import com.huawei.esdk.ivs.test.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.test.bean.MediaAddress;
import com.huawei.esdk.ivs.test.bean.OperationLogInfos;
import com.huawei.esdk.ivs.test.bean.PTZControlInfo;
import com.huawei.esdk.ivs.test.bean.PTZPresetInfo;
import com.huawei.esdk.ivs.test.bean.PTZPresetInfoList;
import com.huawei.esdk.ivs.test.bean.PlaybackParam;
import com.huawei.esdk.ivs.test.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.test.bean.RealplayParam;
import com.huawei.esdk.ivs.test.bean.StartPlatformPlayBackByIPResponse;
import com.huawei.esdk.ivs.test.bean.StartRealPlayByIPExResponse;
import com.huawei.esdk.ivs.test.service.BusinessManagerServiceEx;
import com.huawei.esdk.ivs.test.service.impl.autogen.IVSProfessionalBusinessManager;
import com.huawei.esdk.ivs.test.utils.ClientProvider;
import com.huawei.esdk.ivs.test.utils.ExceptionUtils;

public class BusinessManagerServiceExImpl implements BusinessManagerServiceEx
{
    private static final Logger LOGGER = Logger.getLogger(BusinessManagerServiceExImpl.class);
    
    private IVSProfessionalBusinessManager ivsProfessionalBusinessManager =
        (IVSProfessionalBusinessManager)ClientProvider.getClient(IVSProfessionalBusinessManager.class);
    
    private static BusinessManagerServiceExImpl instance = null;
    
    public static synchronized BusinessManagerServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new BusinessManagerServiceExImpl();
        }
        return instance;
    }
    
    @Override
    public IVSSDKResponse<Integer> addPTZPreset(String cameraCode, String presetName)
    {
        LOGGER.info("begin to execute addPTZPreset method");
        
        IVSSDKResponse<Integer> result = new IVSSDKResponse<Integer>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<Integer> presetIndex = new Holder<Integer>();
        try
        {
            ivsProfessionalBusinessManager.addPTZPreset(cameraCode, presetName, resultCode, presetIndex);
        }
        catch (Exception e)
        {
            LOGGER.error("addPTZPreset method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(presetIndex.value);
        
        LOGGER.info("execute addPTZPreset method completed");
        
        return result;
    }
    
    @Override
    public Integer deletePTZPreset(String cameraCode, Integer presetIndex)
    {
        LOGGER.info("begin to execute deletePTZPreset method");
        
        try
        {
            Integer errorCode = ivsProfessionalBusinessManager.deletePTZPreset(cameraCode, presetIndex);
            LOGGER.info("execute deletePTZPreset method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("deletePTZPreset method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public IVSSDKResponse<GetPTZPresetListResponse> getPTZPresetList(String cameraCode)
    {
        LOGGER.info("begin to execute getPTZPresetList method");
        
        IVSSDKResponse<GetPTZPresetListResponse> result = new IVSSDKResponse<GetPTZPresetListResponse>();
        GetPTZPresetListResponse response = new GetPTZPresetListResponse();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<PTZPresetInfoList> ptzPresetInfoList = new Holder<PTZPresetInfoList>();
        Holder<Integer> ptzPresetNum = new Holder<Integer>();
        
        try
        {
            ivsProfessionalBusinessManager.getPTZPresetList(cameraCode, resultCode, ptzPresetInfoList, ptzPresetNum);
        }
        catch (Exception e)
        {
            LOGGER.error("getPTZPresetList method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        response.setPtzPresetNum(ptzPresetNum.value);
        response.setPtzPresetInfoList(ptzPresetInfoList.value);
        result.setResult(response);
        
        LOGGER.info("execute getPTZPresetList method completed");
        
        return result;
    }
    
    @Override
    public Integer modifyPTZPreset(String cameraCode, PTZPresetInfo ptzPresetInfo)
    {
        LOGGER.info("begin to execute modifyPTZPreset method");
        
        try
        {
            Integer errorCode = ivsProfessionalBusinessManager.modifyPTZPreset(cameraCode, ptzPresetInfo);
            LOGGER.info("execute modifyPTZPreset method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("modifyPTZPreset method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public IVSSDKResponse<Integer> ptzControl(String cameraCode, Integer controlCode, String controlPara1,
        String controlPara2)
    {
        LOGGER.info("begin to execute addPTZPreset method");
        
        IVSSDKResponse<Integer> result = new IVSSDKResponse<Integer>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<Integer> lockStatus = new Holder<Integer>();
        
        try
        {
            ivsProfessionalBusinessManager.ptzControl(cameraCode,
                controlCode,
                controlPara1,
                controlPara2,
                resultCode,
                lockStatus);
        }
        catch (Exception e)
        {
            LOGGER.error("addPTZPreset method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(lockStatus.value);
        
        LOGGER.info("execute addPTZPreset method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<PTZControlInfo> ptzControlWithLockerInfo(String cameraCode, Integer controlCode,
        String controlPara1, String controlPara2)
    {
        LOGGER.info("begin to execute ptzControlWithLockerInfo method");
        
        IVSSDKResponse<PTZControlInfo> result = new IVSSDKResponse<PTZControlInfo>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<PTZControlInfo> ptzControlInfo = new Holder<PTZControlInfo>();
        
        try
        {
            ivsProfessionalBusinessManager.ptzControlWithLockerInfo(cameraCode,
                controlCode,
                controlPara1,
                controlPara2,
                resultCode,
                ptzControlInfo);
        }
        catch (Exception e)
        {
            LOGGER.error("ptzControlWithLockerInfo method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(ptzControlInfo.value);
        
        LOGGER.info("execute ptzControlWithLockerInfo method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<StartPlatformPlayBackByIPResponse> startPlatformPlayBackByIP(String cameraCode,
        PlaybackParam playbackParam, MediaAddress mediaAddrDst)
    {
        LOGGER.info("begin to execute startPlatformPlayBackByIP method");
        
        IVSSDKResponse<StartPlatformPlayBackByIPResponse> result =
            new IVSSDKResponse<StartPlatformPlayBackByIPResponse>();
        StartPlatformPlayBackByIPResponse response = new StartPlatformPlayBackByIPResponse();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<MediaAddress> mediaAddrSrc = new Holder<MediaAddress>();
        Holder<Long> handle = new Holder<Long>();
        
        try
        {
            ivsProfessionalBusinessManager.startPlatformPlayBackByIP(playbackParam,
                cameraCode,
                mediaAddrDst,
                resultCode,
                mediaAddrSrc,
                handle);
        }
        catch (Exception e)
        {
            LOGGER.error("startPlatformPlayBackByIP method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        response.setMediaAddrSrc(mediaAddrSrc.value);
        response.setHandle(handle.value);
        result.setResult(response);
        
        LOGGER.info("execute startPlatformPlayBackByIP method completed");
        
        return result;
    }
    
    @Override
    public Integer startPlatformRecord(String cameraCode, Integer recordTime)
    {
        LOGGER.info("begin to execute startPlatformRecord method");
        
        try
        {
            Integer errorCode = ivsProfessionalBusinessManager.startPlatformRecord(cameraCode, recordTime);
            LOGGER.info("execute startPlatformRecord method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("startPlatformRecord method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public IVSSDKResponse<StartRealPlayByIPExResponse> startRealPlayByIPEx(String cameraCode,
        RealplayParam realplayParam, MediaAddress mediaAddrDst)
    {
        LOGGER.info("begin to execute startPlatformPlayBackByIP method");
        
        IVSSDKResponse<StartRealPlayByIPExResponse> result = new IVSSDKResponse<StartRealPlayByIPExResponse>();
        StartRealPlayByIPExResponse response = new StartRealPlayByIPExResponse();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<MediaAddress> mediaAddrSrc = new Holder<MediaAddress>();
        Holder<Long> handle = new Holder<Long>();
        
        try
        {
            ivsProfessionalBusinessManager.startRealPlayByIPEx(realplayParam,
                cameraCode,
                mediaAddrDst,
                resultCode,
                mediaAddrSrc,
                handle);
        }
        catch (Exception e)
        {
            LOGGER.error("startPlatformPlayBackByIP method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        response.setMediaAddrSrc(mediaAddrSrc.value);
        response.setHandle(handle.value);
        result.setResult(response);
        
        LOGGER.info("execute startPlatformPlayBackByIP method completed");
        
        return result;
    }
    
    @Override
    public Integer stopPlatformPlayBackByIP(Long handle)
    {
        LOGGER.info("begin to execute stopPlatformPlayBackByIP method");
        
        try
        {
            Integer errorCode = ivsProfessionalBusinessManager.stopPlatformPlayBackByIP(handle);
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("stopPlatformPlayBackByIP method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public Integer stopPlatformRecord(String cameraCode)
    {
        LOGGER.info("begin to execute stopPlatformRecord method");
        
        try
        {
            Integer errorCode = ivsProfessionalBusinessManager.stopPlatformRecord(cameraCode);
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("stopPlatformRecord method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public Integer stopRealPlayByIPEx(Long handle)
    {
        LOGGER.info("begin to execute stopRealPlayByIPEx method");
        
        try
        {
            Integer errorCode = ivsProfessionalBusinessManager.stopRealPlayByIPEx(handle);
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("stopRealPlayByIPEx method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public IVSSDKResponse<OperationLogInfos> getOperationLog(QueryUnifiedFormat unifiedQuery)
    {
        LOGGER.info("begin to execute getOperationLog method");
        
        IVSSDKResponse<OperationLogInfos> result = new IVSSDKResponse<OperationLogInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<OperationLogInfos> operationLogInfos = new Holder<OperationLogInfos>();
        try
        {
            ivsProfessionalBusinessManager.getOperationLog(unifiedQuery, resultCode, operationLogInfos);
        }
        catch (Exception e)
        {
            LOGGER.error("getOperationLog method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(operationLogInfos.value);
        
        LOGGER.info("execute getOperationLog method completed");
        
        return result;
    }
    
    @Override
    public Integer platformPlayBackPauseByIP(Long playHandle)
    {
        LOGGER.info("begin to execute platformPlayBackPauseByIP method");
        
        try
        {
            Integer errorCode = ivsProfessionalBusinessManager.platformPlayBackPauseByIP(playHandle);
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("platformPlayBackPauseByIP method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public Integer platformPlayBackResumeByIP(Long playHandle)
    {
        LOGGER.info("begin to execute platformPlayBackResumeByIP method");
        
        try
        {
            Integer errorCode = ivsProfessionalBusinessManager.platformPlayBackResumeByIP(playHandle);
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("platformPlayBackResumeByIP method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public Integer setPlayBackTimeByIP(Long playHandle, Integer time)
    {
        LOGGER.info("begin to execute platformPlayBackResumeByIP method");
        
        try
        {
            Integer errorCode = ivsProfessionalBusinessManager.setPlayBackTimeByIP(playHandle, time);
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("platformPlayBackResumeByIP method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    @Override
    public Integer setPlayBackSpeedByIP(Long playHandle, Float speed)
    {
        LOGGER.info("begin to execute platformPlayBackResumeByIP method");
        
        try
        {
            Integer errorCode = ivsProfessionalBusinessManager.setPlayBackSpeedByIP(playHandle, speed);
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("platformPlayBackResumeByIP method exception happened", e);
            return ExceptionUtils.processSoapException(e);
        }
    }
}
