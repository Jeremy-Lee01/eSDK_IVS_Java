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

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.professional.local.bean.AlarmCommissionInfo;
import com.huawei.esdk.ivs.professional.local.bean.AlarmEvent;
import com.huawei.esdk.ivs.professional.local.bean.AlarmEventInfos;
import com.huawei.esdk.ivs.professional.local.bean.AlarmLevel;
import com.huawei.esdk.ivs.professional.local.bean.AlarmLevelList;
import com.huawei.esdk.ivs.professional.local.bean.AlarmOperateInfo;
import com.huawei.esdk.ivs.professional.local.bean.AlarmReportInfo;
import com.huawei.esdk.ivs.professional.local.bean.AlarmTypeInfos;
import com.huawei.esdk.ivs.professional.local.bean.GetAlarmLevelListResponse;
import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.professional.local.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.professional.local.constant.NativeConstant;
import com.huawei.esdk.ivs.professional.local.impl.autogen.DeviceAlarmEvents;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalAlarmManager;
import com.huawei.esdk.ivs.professional.local.impl.utils.ClientProvider;
import com.huawei.esdk.ivs.professional.local.impl.utils.Encrypt;
import com.huawei.esdk.ivs.professional.local.impl.utils.ExceptionUtils;
import com.huawei.esdk.ivs.professional.local.impl.utils.StringUtils;
import com.huawei.esdk.ivs.professional.local.service.alarmmanager.AlarmManagerServiceEx;
import com.huawei.esdk.platform.professional.local.constant.PlatformNativeConstant;

public class AlarmManagerServiceExImpl implements AlarmManagerServiceEx
{
    private static final Logger LOGGER = Logger.getLogger(AlarmManagerServiceExImpl.class);
    
    private IVSProfessionalAlarmManager ivsProfessionalAlarmManager =
        (IVSProfessionalAlarmManager)ClientProvider.getClient(IVSProfessionalAlarmManager.class);
    
    private static AlarmManagerServiceExImpl instance = null;
    
    public static synchronized AlarmManagerServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new AlarmManagerServiceExImpl();
        }
        return instance;
    }
    
    @Override
    public IVSSDKResponse<AlarmEvent> getAlarmEventInfo(Long alarmEventId, String alarmInCode)
    {
        LOGGER.info("begin to execute getAlarmEventInfo method");
        
        IVSSDKResponse<AlarmEvent> result = new IVSSDKResponse<AlarmEvent>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<AlarmEvent> alarmEvent = new Holder<AlarmEvent>();
        try
        {
            ivsProfessionalAlarmManager.getAlarmEventInfo(alarmEventId, alarmInCode, resultCode, alarmEvent);
        }
        catch (Exception e)
        {
            LOGGER.error("getAlarmEventInfo method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(alarmEvent.value);
        
        LOGGER.info("execute getAlarmEventInfo method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<AlarmEventInfos> getAlarmEventList(QueryUnifiedFormat unifiedQuery)
    {
        LOGGER.info("begin to execute getAlarmEventList method");
        
        IVSSDKResponse<AlarmEventInfos> result = new IVSSDKResponse<AlarmEventInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<AlarmEventInfos> alarmEventList = new Holder<AlarmEventInfos>();
        try
        {
            ivsProfessionalAlarmManager.getAlarmEventList(unifiedQuery, resultCode, alarmEventList);
        }
        catch (Exception e)
        {
            LOGGER.error("getAlarmEventList method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(alarmEventList.value);
        
        LOGGER.info("execute getAlarmEventList method completed");
        
        return result;
    }
    
    @Override
    public Integer subscribeAlarm(String requestXML)
    {
        LOGGER.info("begin to execute subscribeAlarm method");
        
        try
        {
            int errorCode = ivsProfessionalAlarmManager.subscribeAlarm(requestXML);
            
            LOGGER.info("execute subscribeAlarm method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("subscribeAlarm method exception happened", e);
            return ExceptionUtils.processSoapException(e);
            
        }
        
    }
    
    @Override
    public IVSSDKResponse<String> subscribeAlarmQuery(String requestXML)
    {
        LOGGER.info("begin to execute subscribeAlarmQuery method");
        
        IVSSDKResponse<String> result = new IVSSDKResponse<String>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<String> responseXML = new Holder<String>();
        try
        {
            ivsProfessionalAlarmManager.subscribeAlarmQuery(requestXML, resultCode, responseXML);
        }
        catch (Exception e)
        {
            LOGGER.error("subscribeAlarmQuery method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(responseXML.value);
        
        LOGGER.info("execute subscribeAlarmQuery method completed");
        
        return result;
    }
    
    @Override
    public Integer alarmConfirm(Long alarmEventId, String alarmInCode, AlarmOperateInfo operateInfo)
    {
        LOGGER.info("begin to execute alarmConfirm method");
        
        try
        {
            int errorCode = ivsProfessionalAlarmManager.alarmConfirm(alarmEventId, alarmInCode, operateInfo);
            
            LOGGER.info("execute alarmConfirm method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("alarmConfirm method exception happened", e);
            return ExceptionUtils.processSoapException(e);
            
        }
        
    }
    
    @Override
    public Integer alarmCancel(Long alarmEventId, String alarmInCode, AlarmOperateInfo operateInfo)
    {
        LOGGER.info("begin to execute alarmCancel method");
        
        try
        {
            int errorCode = ivsProfessionalAlarmManager.alarmCancel(alarmEventId, alarmInCode, operateInfo);
            
            LOGGER.info("execute alarmCancel method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("alarmCancel method exception happened", e);
            return ExceptionUtils.processSoapException(e);
            
        }
        
    }
    
    @Override
    public Integer alarmCommission(String alarmInCode, AlarmCommissionInfo alarmCommissionInfo)
    {
        LOGGER.info("begin to execute alarmCommission method");
        
        try
        {
            int errorCode = ivsProfessionalAlarmManager.alarmCommission(alarmInCode, alarmCommissionInfo);
            
            LOGGER.info("execute alarmCommission method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("alarmCommission method exception happened", e);
            return ExceptionUtils.processSoapException(e);
            
        }
        
    }
    
    @Override
    public Integer alarmReport(AlarmReportInfo alarmReportInfo)
    {
        LOGGER.info("begin to execute alarmReport method");
        
        try
        {
            int errorCode = ivsProfessionalAlarmManager.alarmReport(alarmReportInfo);
            
            LOGGER.info("execute alarmReport method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("alarmReport method exception happened", e);
            return ExceptionUtils.processSoapException(e);
            
        }
    }
    
    @Override
    public IVSSDKResponse<String> addAlarmLinkage(String requestXML)
    {
        LOGGER.info("begin to execute addAlarmLinkage method");
        
        IVSSDKResponse<String> result = new IVSSDKResponse<String>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<String> responseXML = new Holder<String>();
        try
        {
            ivsProfessionalAlarmManager.addAlarmLinkage(requestXML, resultCode, responseXML);
        }
        catch (Exception e)
        {
            LOGGER.error("addAlarmLinkage method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(responseXML.value);
        
        LOGGER.info("execute addAlarmLinkage method completed");
        
        return result;
    }
    
    @Override
    public Integer modifyAlarmLinkage(String requestXML)
    {
        LOGGER.info("begin to execute modifyAlarmLinkage method");
        
        try
        {
            int errorCode = ivsProfessionalAlarmManager.modifyAlarmLinkage(requestXML);
            
            LOGGER.info("execute modifyAlarmLinkage method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("modifyAlarmLinkage method exception happened", e);
            return ExceptionUtils.processSoapException(e);
            
        }
    }
    
    @Override
    public Integer deleteAlarmLinkage(String requestXML)
    {
        LOGGER.info("begin to execute deleteAlarmLinkage method");
        
        try
        {
            int errorCode = ivsProfessionalAlarmManager.deleteAlarmLinkage(requestXML);
            
            LOGGER.info("execute deleteAlarmLinkage method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("deleteAlarmLinkage method exception happened", e);
            return ExceptionUtils.processSoapException(e);
            
        }
    }
    
    @Override
    public IVSSDKResponse<String> getAlarmLinkage(String requestXML)
    {
        LOGGER.info("begin to execute getAlarmLinkage method");
        
        IVSSDKResponse<String> result = new IVSSDKResponse<String>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<String> responseXML = new Holder<String>();
        try
        {
            ivsProfessionalAlarmManager.getAlarmLinkage(requestXML, resultCode, responseXML);
        }
        catch (Exception e)
        {
            LOGGER.error("getAlarmLinkage method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(responseXML.value);
        
        LOGGER.info("execute getAlarmLinkage method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<String> getAlarmLinkageList(String requestXML)
    {
        LOGGER.info("begin to execute getAlarmLinkageList method");
        
        IVSSDKResponse<String> result = new IVSSDKResponse<String>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<String> responseXML = new Holder<String>();
        try
        {
            ivsProfessionalAlarmManager.getAlarmLinkageList(requestXML, resultCode, responseXML);
        }
        catch (Exception e)
        {
            LOGGER.error("getAlarmLinkageList method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(responseXML.value);
        
        LOGGER.info("execute getAlarmLinkageList method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<String> getAlarmLinkageAction(String requestXML)
    {
        LOGGER.info("begin to execute getAlarmLinkageAction method");
        
        IVSSDKResponse<String> result = new IVSSDKResponse<String>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<String> responseXML = new Holder<String>();
        try
        {
            ivsProfessionalAlarmManager.getAlarmLinkageAction(requestXML, resultCode, responseXML);
        }
        catch (Exception e)
        {
            LOGGER.error("getAlarmLinkageAction method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(responseXML.value);
        
        LOGGER.info("execute getAlarmLinkageAction method completed");
        
        return result;
    }
    
    @Override
    public Integer startAlarmOut(String alarmOutCode)
    {
        LOGGER.info("begin to execute startAlarmOut method");
        
        try
        {
            int errorCode = ivsProfessionalAlarmManager.startAlarmOut(alarmOutCode);
            
            LOGGER.info("execute startAlarmOut method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("startAlarmOut method exception happened", e);
            return ExceptionUtils.processSoapException(e);
            
        }
    }
    
    @Override
    public Integer stopAlarmOut(String alarmOutCode)
    {
        LOGGER.info("begin to execute stopAlarmOut method");
        
        try
        {
            int errorCode = ivsProfessionalAlarmManager.stopAlarmOut(alarmOutCode);
            
            LOGGER.info("execute stopAlarmOut method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("stopAlarmOut method exception happened", e);
            return ExceptionUtils.processSoapException(e);
            
        }
        
    }
    
    @Override
    public Integer userAuthentication(String password)
    {
        LOGGER.info("begin to execute userAuthentication method");
        
        String encodePwd = null;
        
        if (!StringUtils.isNullOrEmpty(password))
        {
            try
            {
                // 加密方式向下兼容
                encodePwd = Encrypt.getEncryptPwd(password);
                if (StringUtils.isNullOrEmpty(encodePwd))
                {
                    return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
                }
            }
            catch (Exception e)
            {
                LOGGER.debug("encode password error");
                return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
            }
        }
        else
        {
            return NativeConstant.DATA_ERRORCODE;
        }
        
        try
        {
            
            int errorCode = ivsProfessionalAlarmManager.userAuthentication(encodePwd);
            
            LOGGER.info("execute userAuthentication method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("userAuthentication method exception happened", e);
            return ExceptionUtils.processSoapException(e);
            
        }
        
    }
    
    @Override
    public IVSSDKResponse<AlarmTypeInfos> getAlarmTypeList(QueryUnifiedFormat unifiedQuery)
    {
        LOGGER.info("begin to execute getAlarmTypeList method");
        
        IVSSDKResponse<AlarmTypeInfos> result = new IVSSDKResponse<AlarmTypeInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<AlarmTypeInfos> alarmTypeInfos = new Holder<AlarmTypeInfos>();
        try
        {
            ivsProfessionalAlarmManager.getAlarmTypeList(unifiedQuery, resultCode, alarmTypeInfos);
        }
        catch (Exception e)
        {
            LOGGER.error("getAlarmTypeList method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(alarmTypeInfos.value);
        
        LOGGER.info("execute getAlarmTypeList method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<GetAlarmLevelListResponse> getAlarmLevelList()
    {
        LOGGER.info("begin to execute getAlarmLevelList method");
        
        IVSSDKResponse<GetAlarmLevelListResponse> result = new IVSSDKResponse<GetAlarmLevelListResponse>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<Integer> alarmLevelNum = new Holder<Integer>();
        Holder<AlarmLevelList> alarmLevelList = new Holder<AlarmLevelList>();
        try
        {
            ivsProfessionalAlarmManager.getAlarmLevelList(resultCode, alarmLevelNum, alarmLevelList);
        }
        catch (Exception e)
        {
            LOGGER.error("getAlarmLevelList method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        
        GetAlarmLevelListResponse getAlarmLevelListResponse = new GetAlarmLevelListResponse();
        getAlarmLevelListResponse.setAlarmLevelNum(alarmLevelNum.value);
        getAlarmLevelListResponse.setAlarmLevelList(alarmLevelList.value);
        
        result.setResult(getAlarmLevelListResponse);
        
        LOGGER.info("execute getAlarmLevelList method completed");
        
        return result;
    }
    
    @Override
    public Integer setAlarmTypeLevel(AlarmTypeInfos alarmTypeInfos)
    {
        LOGGER.info("begin to execute setAlarmTypeLevel method");
        
        try
        {
            int errorCode = ivsProfessionalAlarmManager.setAlarmTypeLevel(alarmTypeInfos);
            
            LOGGER.info("execute setAlarmTypeLevel method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("setAlarmTypeLevel method exception happened", e);
            return ExceptionUtils.processSoapException(e);
            
        }
        
    }
    
    @Override
    public IVSSDKResponse<AlarmLevel> getAlarmLevel(Integer alarmLevelID)
    {
        LOGGER.info("begin to execute AlarmLevel method");
        
        IVSSDKResponse<AlarmLevel> result = new IVSSDKResponse<AlarmLevel>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<AlarmLevel> alarmLevel = new Holder<AlarmLevel>();
        try
        {
            ivsProfessionalAlarmManager.getAlarmLevel(alarmLevelID, resultCode, alarmLevel);
        }
        catch (Exception e)
        {
            LOGGER.error("AlarmLevel method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(alarmLevel.value);
        
        LOGGER.info("execute AlarmLevel method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<String> getAlarmSnapshotList(String requestXML)
    {
        LOGGER.info("begin to execute getAlarmSnapshotList method");
        
        IVSSDKResponse<String> result = new IVSSDKResponse<String>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<String> responseXML = new Holder<String>();
        try
        {
            ivsProfessionalAlarmManager.getAlarmSnapshotList(requestXML, resultCode, responseXML);
        }
        catch (Exception e)
        {
            LOGGER.error("getAlarmSnapshotList method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(responseXML.value);
        
        LOGGER.info("execute getAlarmSnapshotList method completed");
        
        return result;
    }

	@Override
	public IVSSDKResponse<DeviceAlarmEvents> getDeviceAlarmList(QueryUnifiedFormat unifiedQuery) {
		LOGGER.info("begin to execute getDeviceAlarmList method");
        
        IVSSDKResponse<DeviceAlarmEvents> result = new IVSSDKResponse<DeviceAlarmEvents>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<DeviceAlarmEvents> deviceAlarmEvents = new Holder<DeviceAlarmEvents>();
        try
        {
            ivsProfessionalAlarmManager.getDeviceAlarmList(unifiedQuery, resultCode, deviceAlarmEvents);
        }
        catch (Exception e)
        {
            LOGGER.error("getDeviceAlarmList method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(deviceAlarmEvents.value);
        
        LOGGER.info("execute getDeviceAlarmList method completed");
        
        return result;
	}
}
