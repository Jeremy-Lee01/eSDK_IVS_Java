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
package com.huawei.esdk.ivs.northcommu.cxf.professional;

import org.apache.log4j.Logger;
import com.huawei.esdk.ivs.business.professional.alarmmgr.AlarmMgrService;
import com.huawei.esdk.ivs.common.CipherUtils;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.Alarm;
import com.huawei.esdk.ivs.domain.model.bean.AlarmEventList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmLevel;
import com.huawei.esdk.ivs.domain.model.bean.AlarmLevelList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceAlarmInfos;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.util.IVSUtil;
import com.huawei.esdk.ivs.northcommu.cxf.professional.convert.IVSProfessionalAlarmManagerConvert;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddAlarmLinkage;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddAlarmLinkageResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmCancel;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmCancelResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmCommission;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmCommissionResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmConfirm;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmConfirmResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmReport;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmReportResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteAlarmLinkage;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteAlarmLinkageResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmEventInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmEventInfoResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmEventList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmEventListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLevel;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLevelList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLevelListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLevelResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLinkage;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLinkageAction;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLinkageActionResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLinkageList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLinkageListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLinkageResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmSnapshotList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmSnapshotListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmTypeList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmTypeListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceAlarmList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceAlarmListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IVSProfessionalAlarmManager;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ModifyAlarmLinkage;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ModifyAlarmLinkageResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetAlarmTypeLevel;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetAlarmTypeLevelResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartAlarmOut;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartAlarmOutResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StopAlarmOut;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StopAlarmOutResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SubscribeAlarm;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SubscribeAlarmQuery;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SubscribeAlarmQueryResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SubscribeAlarmResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.UserAuthentication;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.UserAuthenticationResponse;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

/**
 * 告警管理接口实现类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class IVSProfessionalAlarmManagerImpl implements IVSProfessionalAlarmManager
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(IVSProfessionalAlarmManagerImpl.class);
    
    /**
     * 告警管理service层
     */
    private AlarmMgrService alarmMgrService;
    
    /**
     * 北向与领域层之前的转换类
     */
    private IVSProfessionalAlarmManagerConvert ivsProfessionalAlarmManagerConvert;
    
    public AlarmMgrService getAlarmMgrService()
    {
        return alarmMgrService;
    }
    
    public void setAlarmMgrService(AlarmMgrService alarmMgrService)
    {
        this.alarmMgrService = alarmMgrService;
    }
    
    public IVSProfessionalAlarmManagerConvert getIvsProfessionalAlarmManagerConvert()
    {
        return ivsProfessionalAlarmManagerConvert;
    }
    
    public void setIvsProfessionalAlarmManagerConvert(
        IVSProfessionalAlarmManagerConvert ivsProfessionalAlarmManagerConvert)
    {
        this.ivsProfessionalAlarmManagerConvert = ivsProfessionalAlarmManagerConvert;
    }
    
    /** 
     * 查询告警事件列表
     *
     * @param parameters 告警入参，包括unifiedQuery参数
     * @return GetAlarmEventListResponse 响应信息，包含告警事件列表
     * @since eSDK IVS V100R003C00
     */
    @Override
    public GetAlarmEventListResponse getAlarmEventList(GetAlarmEventList parameters)
    {
        GetAlarmEventListResponse response = new GetAlarmEventListResponse();
        
        if (null == parameters || null == parameters.getUnifiedQuery()
            || null == parameters.getUnifiedQuery().getQueryFieldList())
        {
            LOGGER.error("The input parameter of getAlarmEventList method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        int size = parameters.getUnifiedQuery().getQueryFieldList().getQueryField().size();
        if (parameters.getUnifiedQuery().getFieldNum() != size)
        {
            LOGGER.error("The input parameter of getAlarmEventList method is error");
            response.setResultCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return response;
        }
        
        // 分页条件判断
        if (!IVSUtil.validateIndexRange(parameters.getUnifiedQuery().getIndex().getFromIndex(),
            parameters.getUnifiedQuery().getIndex().getToIndex()))
        {
            LOGGER.error("The indexRange is error");
            response.setResultCode(ErrInfo.IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR);
            return response;
        }
        
        // 转换QueryUnifiedFormat为领域层对象
        QueryUnifiedFormat queryUnifiedFormat =
            ivsProfessionalAlarmManagerConvert.getAlarmEventListSoap2Model(parameters.getUnifiedQuery());
        
        SDKResult<AlarmEventList> result = new SDKResult<AlarmEventList>();
        
        try
        {
            result = alarmMgrService.getAlarmEventList(queryUnifiedFormat);
        }
        catch (SDKException e)
        {
            LOGGER.error("getAlarmEventList failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getAlarmEventList failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response = ivsProfessionalAlarmManagerConvert.getAlarmEventListModel2Soap(result);
        return response;
    }
    
    /** 
     * 查询告警事件信息
     *
     * @param parameters 告警入参，包括alarmEventId和alarmInCode
     * @return GetAlarmEventInfoResponse 响应信息，包含错误码和告警信息
     * @since eSDK IVS V100R003C00
     */
    @Override
    public GetAlarmEventInfoResponse getAlarmEventInfo(GetAlarmEventInfo parameters)
    {
        GetAlarmEventInfoResponse response = new GetAlarmEventInfoResponse();
        
        if (null == parameters || null == parameters.getAlarmInCode())
        {
            // 参数错误
            LOGGER.error("The input parameter of getAlarmEventInfo method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKResult<Alarm> result = new SDKResult<Alarm>();
        
        try
        {
            result = alarmMgrService.getAlarmEventInfo(parameters.getAlarmEventId(), parameters.getAlarmInCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("getAlarmEventInfo failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getAlarmEventInfo failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        // 将领域层的Alarm转换成AlarmEvent
        response = ivsProfessionalAlarmManagerConvert.getAlarmEventInfoModel2Soap(result);
        return response;
    }
    
    /** 
     * 告警订阅查询
     *
     * @param parameters 告警入参，主要信息为xmlString
     * @return SubscribeAlarmQueryResponse 响应信息，包含错误码和订阅信息
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SubscribeAlarmQueryResponse subscribeAlarmQuery(SubscribeAlarmQuery parameters)
    {
        SubscribeAlarmQueryResponse response = new SubscribeAlarmQueryResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getRequestXML()))
        {
            // 参数错误
            LOGGER.error("The input parameter of subscribeAlarmQuery method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKResult<String> result = new SDKResult<String>();
        
        try
        {
            result = alarmMgrService.subscribeAlarmQuery(parameters.getRequestXML());
        }
        catch (SDKException e)
        {
            LOGGER.error("subscribeAlarmQuery failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("subscribeAlarmQuery failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response = ivsProfessionalAlarmManagerConvert.subscribeAlarmQueryModel2Soap(result);
        return response;
    }
    
    /** 
     * 告警订阅
     *
     * @param parameters 告警订阅请求参数，包含告警订阅xml
     * @return SubscribeAlarmResponse 订阅响应
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SubscribeAlarmResponse subscribeAlarm(SubscribeAlarm parameters)
    {
        SubscribeAlarmResponse response = new SubscribeAlarmResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getRequestXML()))
        {
            // 参数错误
            LOGGER.error("The input parameter of subscribeAlarm method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = new SDKErrorCode();
        
        try
        {
            result = alarmMgrService.subscribeAlarm(parameters.getRequestXML());
        }
        catch (SDKException e)
        {
            LOGGER.error("subscribeAlarm failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("subscribeAlarm failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response = ivsProfessionalAlarmManagerConvert.subscribeAlarmModel2Soap(result);
        return response;
    }
    
    /** 
     * 告警授权
     * 此接口用于将选定的告警信息授权给其他用户处理
     * @param parameters 告警授权信息
     * @return AlarmCommissionResponse 成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public AlarmCommissionResponse alarmCommission(AlarmCommission parameters)
    {
        AlarmCommissionResponse response = new AlarmCommissionResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getAlarmInCode())
            || null == parameters.getAlarmCommissionInfo()
            || null == parameters.getAlarmCommissionInfo().getUserIdInfoList()
            || 1 > parameters.getAlarmCommissionInfo().getUserIdInfoList().getUserIdInfo().size())
        {
            // 参数错误
            LOGGER.error("The input parameter of alarmCommission method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        int size = parameters.getAlarmCommissionInfo().getUserIdInfoList().getUserIdInfo().size();
        if (parameters.getAlarmCommissionInfo().getUserNum() != size)
        {
            // 参数错误
            LOGGER.error("The input parameter of alarmCommission method is error");
            response.setResultCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return response;
        }
        
        SDKErrorCode result = new SDKErrorCode();
        
        try
        {
            result =
                alarmMgrService.alarmCommission(parameters.getAlarmInCode(),
                    ivsProfessionalAlarmManagerConvert.getAlarmCommissionInfoSoap2Model(parameters.getAlarmCommissionInfo()));
        }
        catch (SDKException e)
        {
            LOGGER.error("alarmCommission failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("alarmCommission failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        
        return response;
    }
    
    /** 
     * 告警确认
     * 此接口用于确认告警信息为真实告警
     * @param parameters 告警确认信息
     * @return AlarmConfirmResponse 成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public AlarmConfirmResponse alarmConfirm(AlarmConfirm parameters)
    {
        AlarmConfirmResponse response = new AlarmConfirmResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getAlarmInCode())
            || null == parameters.getOperateInfo() || StringUtils.isEmpty(parameters.getOperateInfo().getOperateTime())
            || StringUtils.isEmpty(parameters.getOperateInfo().getOperatorName())
            || null == parameters.getOperateInfo().getReserver()
            || StringUtils.isEmpty(parameters.getOperateInfo().getOperateInfo()))
        {
            // 参数错误
            LOGGER.error("The input parameter of alarmConfirm method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = new SDKErrorCode();
        
        try
        {
            result =
                alarmMgrService.alarmConfirm(parameters.getAlarmEventId(),
                    parameters.getAlarmInCode(),
                    ivsProfessionalAlarmManagerConvert.getAlarmOperateInfoSoap2Model(parameters.getOperateInfo()));
        }
        catch (SDKException e)
        {
            LOGGER.error("alarmConfirm method failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("alarmConfirm method failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        
        return response;
    }
    
    /** 
     * 获取告警联动策略动作详情
     * 
     * @param parameters 联动策略动作查询条件
     * @return GetAlarmLinkageActionResponse  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public GetAlarmLinkageActionResponse getAlarmLinkageAction(GetAlarmLinkageAction parameters)
    {
        GetAlarmLinkageActionResponse response = new GetAlarmLinkageActionResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getRequestXML()))
        {
            // 参数错误
            LOGGER.error("The input parameter of getAlarmLinkageAction method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKResult<String> result = new SDKResult<String>();
        
        try
        {
            result = alarmMgrService.getAlarmLinkageAction(parameters.getRequestXML());
            
        }
        catch (SDKException e)
        {
            LOGGER.error("getAlarmLinkageAction failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getAlarmLinkageAction failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        if (0 == result.getErrCode())
        {
            response.setResponseXML(result.getResult());
        }
        return response;
    }
    
    /** 
     * 获取告警联动策略列表
     * 
     * @param parameters 联动策略列表查询条件
     * @return GetAlarmLinkageListResponse  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public GetAlarmLinkageListResponse getAlarmLinkageList(GetAlarmLinkageList parameters)
    {
        GetAlarmLinkageListResponse response = new GetAlarmLinkageListResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getRequestXML()))
        {
            // 参数错误
            LOGGER.error("The input parameter of getAlarmLinkageList method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKResult<String> result = new SDKResult<String>();
        
        try
        {
            result = alarmMgrService.getAlarmLinkageList(parameters.getRequestXML());
            
        }
        catch (SDKException e)
        {
            LOGGER.error("getAlarmLinkageList failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getAlarmLinkageList failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        if (0 == result.getErrCode())
        {
            response.setResponseXML(result.getResult());
        }
        return response;
    }
    
    /** 
     * 停止开关量输出告警
     *
     * @param parameters 停止开关量输出告警请求参数，包含开关量输出设备编码
     * @return StopAlarmOutResponse 停止开关量输出告警响应
     * @since eSDK IVS V100R003C00
     */
    @Override
    public StopAlarmOutResponse stopAlarmOut(StopAlarmOut parameters)
    {
        StopAlarmOutResponse response = new StopAlarmOutResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getAlarmOutCode()))
        {
            // 参数错误
            LOGGER.error("The input parameter of stopAlarmOut method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = new SDKErrorCode();
        
        try
        {
            result = alarmMgrService.stopAlarmOut(parameters.getAlarmOutCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("stopAlarmOut failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("stopAlarmOut failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        return response;
    }
    
    /** 
     * 删除告警联动策略
     *
     * @param parameters 删除告警联动策略请求参数，包含告警联动策略xml
     * @return DeleteAlarmLinkageResponse 删除告警联动策略响应
     * @since eSDK IVS V100R003C00
     */
    @Override
    public DeleteAlarmLinkageResponse deleteAlarmLinkage(DeleteAlarmLinkage parameters)
    {
        DeleteAlarmLinkageResponse response = new DeleteAlarmLinkageResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getRequestXML()))
        {
            // 参数错误
            LOGGER.error("The input parameter of deleteAlarmLinkage method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = new SDKErrorCode();
        
        try
        {
            result = alarmMgrService.deleteAlarmLinkage(parameters.getRequestXML());
        }
        catch (SDKException e)
        {
            LOGGER.error("deleteAlarmLinkage failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("deleteAlarmLinkage failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        return response;
    }
    
    /** 
     * 新增告警联动策略
     *
     * @param parameters 新增告警联动策略请求参数，包含告警联动策略xml
     * @return AddAlarmLinkageResponse 新增告警联动策略响应
     * @since eSDK IVS V100R003C00
     */
    @Override
    public AddAlarmLinkageResponse addAlarmLinkage(AddAlarmLinkage parameters)
    {
        AddAlarmLinkageResponse response = null;
        
        if (null == parameters || StringUtils.isEmpty(parameters.getRequestXML()))
        {
            // 参数错误
            LOGGER.error("The input parameter of addAlarmLinkage method is error");
            response = new AddAlarmLinkageResponse();
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKResult<String> result = new SDKResult<String>();
        
        try
        {
            result = alarmMgrService.addAlarmLinkage(parameters.getRequestXML());
        }
        catch (SDKException e)
        {
            LOGGER.error("addAlarmLinkage failed", e);
            response = new AddAlarmLinkageResponse();
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("addAlarmLinkage failed", ex);
            response = new AddAlarmLinkageResponse();
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response = ivsProfessionalAlarmManagerConvert.addAlarmLinkageModel2Soap(result);
        return response;
    }
    
    /** 
     * 修改告警联动策略
     *
     * @param parameters 修改告警联动策略请求参数，包含告警联动策略xml
     * @return ModifyAlarmLinkageResponse 修改告警联动策略响应
     * @since eSDK IVS V100R003C00
     */
    @Override
    public ModifyAlarmLinkageResponse modifyAlarmLinkage(ModifyAlarmLinkage parameters)
    {
        ModifyAlarmLinkageResponse response = new ModifyAlarmLinkageResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getRequestXML()))
        {
            // 参数错误
            LOGGER.error("The input parameter of modifyAlarmLinkage method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = new SDKErrorCode();
        
        try
        {
            result = alarmMgrService.modifyAlarmLinkage(parameters.getRequestXML());
        }
        catch (SDKException e)
        {
            LOGGER.error("modifyAlarmLinkage failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("modifyAlarmLinkage failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        return response;
    }
    
    /** 
     * 告警上报
     * @param parameters 告警上报信息
     * @return AlarmReportResponse  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public AlarmReportResponse alarmReport(AlarmReport parameters)
    {
        AlarmReportResponse response = new AlarmReportResponse();
        
        if (null == parameters || null == parameters.getAlarmReportInfo()
            || null == parameters.getAlarmReportInfo().getAlarmDesc()
            || null == parameters.getAlarmReportInfo().getAlarmId()
            || null == parameters.getAlarmReportInfo().getAlarmInCode()
            || null == parameters.getAlarmReportInfo().getAlarmType()
            || null == parameters.getAlarmReportInfo().getDeviceDomainCode()
            || null == parameters.getAlarmReportInfo().getExtParam()
            || null == parameters.getAlarmReportInfo().getNvrCode()
            || null == parameters.getAlarmReportInfo().getOccurTime()
            || null == parameters.getAlarmReportInfo().getReportTime()
            || null == parameters.getAlarmReportInfo().getReserve())
        {
            // 参数错误
            LOGGER.error("The input parameter of alarmReport method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = new SDKErrorCode();
        
        try
        {
            result =
                alarmMgrService.alarmReport(ivsProfessionalAlarmManagerConvert.getAlarmReportInfoSoap2Model(parameters.getAlarmReportInfo()));
        }
        catch (SDKException e)
        {
            LOGGER.error("alarmReport method failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("alarmReport method failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        
        return response;
    }
    
    /** 
     * 启动开关量输出告警
     *
     * @param parameters 启动开关量输出告警请求参数，包含开关量输出设备编码
     * @return StartAlarmOutResponse 启动开关量输出告警响应
     * @since eSDK IVS V100R003C00
     */
    @Override
    public StartAlarmOutResponse startAlarmOut(StartAlarmOut parameters)
    {
        StartAlarmOutResponse response = new StartAlarmOutResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getAlarmOutCode()))
        {
            // 参数错误
            LOGGER.error("The input parameter of startAlarmOut method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = new SDKErrorCode();
        
        try
        {
            result = alarmMgrService.startAlarmOut(parameters.getAlarmOutCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("startAlarmOut failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("startAlarmOut failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        return response;
    }
    
    /** 
     * 获取告警联动策略详情
     * 
     * @param parameters 联动信息查询条件
     * @return GetAlarmLinkageResponse  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public GetAlarmLinkageResponse getAlarmLinkage(GetAlarmLinkage parameters)
    {
        GetAlarmLinkageResponse response = new GetAlarmLinkageResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getRequestXML()))
        {
            // 参数错误
            LOGGER.error("The input parameter of getAlarmLinkage method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKResult<String> result = new SDKResult<String>();
        
        try
        {
            result = alarmMgrService.getAlarmLinkage(parameters.getRequestXML());
            
        }
        catch (SDKException e)
        {
            LOGGER.error("getAlarmLinkage failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getAlarmLinkage failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        if (0 == result.getErrCode())
        {
            response.setResponseXML(result.getResult());
        }
        return response;
    }
    
    /** 
     * 告警撤销
     * 此接口用于撤销无效告警信息
     * @param parameters 告警撤销信息
     * @return AlarmCancelResponse  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public AlarmCancelResponse alarmCancel(AlarmCancel parameters)
    {
        AlarmCancelResponse response = new AlarmCancelResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getAlarmInCode())
            || null == parameters.getOperateInfo() || StringUtils.isEmpty(parameters.getOperateInfo().getOperateTime())
            || StringUtils.isEmpty(parameters.getOperateInfo().getOperatorName())
            || null == parameters.getOperateInfo().getReserver()
            || StringUtils.isEmpty(parameters.getOperateInfo().getOperateInfo()))
        {
            // 参数错误
            LOGGER.error("The input parameter of alarmCancel method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = null;
        
        try
        {
            result =
                alarmMgrService.alarmCancel(parameters.getAlarmEventId(),
                    parameters.getAlarmInCode(),
                    ivsProfessionalAlarmManagerConvert.getAlarmOperateInfoSoap2Model(parameters.getOperateInfo()));
        }
        catch (SDKException e)
        {
            LOGGER.error("alarmCancel method failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("alarmCancel method failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        return response;
    }
    
    /** 
     * 授权告警用户认证
     * 
     * @param parameters 登录密码
     * @return UserAuthenticationResponse  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public UserAuthenticationResponse userAuthentication(UserAuthentication parameters)
    {
        UserAuthenticationResponse response = new UserAuthenticationResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getPassword()))
        {
            // 参数错误
            LOGGER.error("The input parameter of userAuthentication method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = null;
        
        try
        {
            String tempPwd = CipherUtils.decodeFromBase64(parameters.getPassword());
            if (StringUtils.isEmpty(tempPwd))
            {
                response.setResultCode(ErrInfo.PWD_ERRORCODE);
                return response;
            }
            result = alarmMgrService.userAuthentication(tempPwd);
            
        }
        catch (SDKException e)
        {
            LOGGER.error("userAuthentication failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("userAuthentication failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        return response;
    }
    
    /** 
     * 设置告警类型级别
     * 
     * @param parameters 需要设置的告警类型列表
     * @return SetAlarmTypeLevelResponse  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C10
     */
    @Override
    public SetAlarmTypeLevelResponse setAlarmTypeLevel(SetAlarmTypeLevel parameters)
    {
        SetAlarmTypeLevelResponse response = new SetAlarmTypeLevelResponse();
        
        if (null == parameters || null == parameters.getAlarmTypeInfos()
            || null == parameters.getAlarmTypeInfos().getAlarmTypeInfoList())
        {
            // 参数错误
            LOGGER.error("The input parameter of setAlarmTypeLevel method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        int size = parameters.getAlarmTypeInfos().getAlarmTypeInfoList().getAlarmTypeInfo().size();
        if (1 > size || size != parameters.getAlarmTypeInfos().getTotal())
        {
            LOGGER.error("The input parameter of setAlarmTypeLevel method is error");
            response.setResultCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return response;
        }
        
        SDKErrorCode result = null;
        
        try
        {
            result =
                alarmMgrService.setAlarmTypeLevel(ivsProfessionalAlarmManagerConvert.getAlarmTypeLevelSoap2Model(parameters.getAlarmTypeInfos()));
        }
        catch (SDKException e)
        {
            LOGGER.error("setAlarmTypeLevel method failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("setAlarmTypeLevel method failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        return response;
    }
    
    /** 
     * 查询告警类型列表
     * 
     * @param parameters 入参，包含查询结构体
     * @return GetAlarmTypeListResponse  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C10B001
     */
    @Override
    public GetAlarmTypeListResponse getAlarmTypeList(GetAlarmTypeList parameters)
    {
        GetAlarmTypeListResponse response = new GetAlarmTypeListResponse();
        
        if (null == parameters || null == parameters.getUnifiedQuery()
            || null == parameters.getUnifiedQuery().getQueryFieldList())
        {
            LOGGER.error("The input parameter of getAlarmTypeList method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        int size = parameters.getUnifiedQuery().getQueryFieldList().getQueryField().size();
        if (parameters.getUnifiedQuery().getFieldNum() != size)
        {
            LOGGER.error("The input parameter of getAlarmTypeList method is error");
            response.setResultCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return response;
        }
        
        // 分页条件判断
        if (!IVSUtil.validateIndexRange(parameters.getUnifiedQuery().getIndex().getFromIndex(),
            parameters.getUnifiedQuery().getIndex().getToIndex()))
        {
            LOGGER.error("The indexRange is error");
            response.setResultCode(ErrInfo.IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR);
            return response;
        }
        
        // 转换QueryUnifiedFormat为领域层对象
        QueryUnifiedFormat queryUnifiedFormat =
            ivsProfessionalAlarmManagerConvert.getAlarmTypeListSoap2Model(parameters.getUnifiedQuery());
        
        SDKResult<AlarmTypeInfos> result = null;
        
        try
        {
            result = alarmMgrService.getAlarmTypeList(queryUnifiedFormat);
        }
        catch (SDKException e)
        {
            LOGGER.error("getAlarmTypeList failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getAlarmTypeList failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        // 转换
        response = ivsProfessionalAlarmManagerConvert.getAlarmTypeListModel2Soap(result);
        
        return response;
    }
    
    /** 
     * 查询告警级别列表
     * @param parameters 空入参
     * @return GetAlarmLevelListResponse 告警级别信息列表
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C10B001
     */
    @Override
    public GetAlarmLevelListResponse getAlarmLevelList(GetAlarmLevelList parameters)
    {
        GetAlarmLevelListResponse response = new GetAlarmLevelListResponse();
        SDKResult<AlarmLevelList> result = null;
        
        try
        {
            result = alarmMgrService.getAlarmLevelList();
        }
        catch (SDKException e)
        {
            LOGGER.error("getAlarmLevelList failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getAlarmLevelList failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response = ivsProfessionalAlarmManagerConvert.getAlarmLevelListModel2Soap(result);
        return response;
    }
    
    /** 
     * 查询告警级别信息
     * 
     * @param parameters 入参，包含告警级别ID
     * @return GetAlarmLevelResponse 告警级别信息
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C10B001
     */
    @Override
    public GetAlarmLevelResponse getAlarmLevel(GetAlarmLevel parameters)
    {
        GetAlarmLevelResponse response = new GetAlarmLevelResponse();
        
        if (null == parameters)
        {
            LOGGER.error("The input parameter of getAlarmLevel method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKResult<AlarmLevel> result = new SDKResult<AlarmLevel>();
        
        try
        {
            result = alarmMgrService.getAlarmLevel(parameters.getAlarmLevelID());
        }
        catch (SDKException e)
        {
            LOGGER.error("getAlarmLevel failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getAlarmLevel failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response = ivsProfessionalAlarmManagerConvert.getAlarmLevelModel2Soap(result);
        return response;
    }

    /** 
     * 查询告警快照信息
     * 
     * @param parameters 入参，包含请求xml参数
     * @return GetAlarmSnapshotListResponse 告警快照信息
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R005C10
     */
    @Override
    public GetAlarmSnapshotListResponse getAlarmSnapshotList(GetAlarmSnapshotList parameters)
    {
        GetAlarmSnapshotListResponse response = new GetAlarmSnapshotListResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getRequestXML()))
        {
            LOGGER.error("The input parameter of getAlarmSnapshotList method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKResult<String> result = new SDKResult<String>();
        
        try
        {
            result = alarmMgrService.getAlarmSnapshotList(parameters.getRequestXML());
            response.setResultCode((int)result.getErrCode());
            response.setResponseXML(result.getResult());
        }
        catch (SDKException e)
        {
            LOGGER.error("getAlarmSnapshotList failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getAlarmSnapshotList failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        return response;
    }

	@Override
	public GetDeviceAlarmListResponse getDeviceAlarmList(GetDeviceAlarmList parameters)
	{
		GetDeviceAlarmListResponse response = new GetDeviceAlarmListResponse();
        
        if (null == parameters || null == parameters.getUnifiedQuery()
            || null == parameters.getUnifiedQuery().getQueryFieldList())
        {
            LOGGER.error("The input parameter of getAlarmEventList method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        int size = parameters.getUnifiedQuery().getQueryFieldList().getQueryField().size();
        if (parameters.getUnifiedQuery().getFieldNum() != size)
        {
            LOGGER.error("The input parameter of getAlarmEventList method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        // 分页条件判断
        if (!IVSUtil.validateIndexRange(parameters.getUnifiedQuery().getIndex().getFromIndex(),
            parameters.getUnifiedQuery().getIndex().getToIndex()))
        {
            LOGGER.error("The indexRange is error");
            response.setResultCode(ErrInfo.IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR);
            return response;
        }
        
        // 转换QueryUnifiedFormat为领域层对象
        QueryUnifiedFormat queryUnifiedFormat =
            ivsProfessionalAlarmManagerConvert.getAlarmEventListSoap2Model(parameters.getUnifiedQuery());
        
        SDKResult<DeviceAlarmInfos> result = new SDKResult<DeviceAlarmInfos>();
        
        try
        {
            result = alarmMgrService.getDeviceAlarmList(queryUnifiedFormat);
        }
        catch (SDKException e)
        {
            LOGGER.error("getAlarmEventList failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getAlarmEventList failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response = ivsProfessionalAlarmManagerConvert.getDeviceAlarmEventListModel2Soap(result);
        return response;
	}
    
}
