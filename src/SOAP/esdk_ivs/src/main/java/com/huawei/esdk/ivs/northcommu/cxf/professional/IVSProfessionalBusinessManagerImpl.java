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
import com.huawei.esdk.ivs.business.professional.businessmgr.BusinessMgrService;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.Business;
import com.huawei.esdk.ivs.domain.model.bean.PTZControlInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfoList;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RealPlay;
import com.huawei.esdk.ivs.domain.model.bean.SnapshotInfoList;
import com.huawei.esdk.ivs.domain.util.IVSUtil;
import com.huawei.esdk.ivs.northcommu.cxf.professional.convert.IVSProfessionalBusinessManagerConvert;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddPTZPreset;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddPTZPresetResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeletePTZPreset;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeletePTZPresetResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteSnapshot;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteSnapshotResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetOperationLog;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetOperationLogResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetPTZPresetList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetPTZPresetListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetRtspURL;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetRtspURLResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetSnapshotList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetSnapshotListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IVSProfessionalBusinessManager;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ModifyPTZPreset;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ModifyPTZPresetResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PlatformPlayBackPauseByIP;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PlatformPlayBackPauseByIPResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PlatformPlayBackResumeByIP;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PlatformPlayBackResumeByIPResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PlatformSnapshot;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PlatformSnapshotResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PtzControl;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PtzControlResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PtzControlWithLockerInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PtzControlWithLockerInfoResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetPlayBackSpeedByIP;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetPlayBackSpeedByIPResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetPlayBackTimeByIP;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetPlayBackTimeByIPResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartPlatformPlayBackByIP;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartPlatformPlayBackByIPResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartPlatformRecord;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartPlatformRecordResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartRealPlayByIPEx;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartRealPlayByIPExResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StopPlatformPlayBackByIP;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StopPlatformPlayBackByIPResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StopPlatformRecord;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StopPlatformRecordResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StopRealPlayByIPEx;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StopRealPlayByIPExResponse;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

/**
 * 业务管理接口实现类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class IVSProfessionalBusinessManagerImpl implements IVSProfessionalBusinessManager
{
    
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(IVSProfessionalBusinessManagerImpl.class);
    
    /**
     * 业务管理service层
     */
    private BusinessMgrService businessMgrService;
    
    /**
     * 北向与领域层之前的转换类
     */
    private IVSProfessionalBusinessManagerConvert ivsProfessionalBusinessManagerConvert;
    
    public BusinessMgrService getBusinessMgrService()
    {
        return businessMgrService;
    }
    
    public void setBusinessMgrService(BusinessMgrService businessMgrService)
    {
        this.businessMgrService = businessMgrService;
    }
    
    public IVSProfessionalBusinessManagerConvert getIvsProfessionalBusinessManagerConvert()
    {
        return ivsProfessionalBusinessManagerConvert;
    }
    
    public void setIvsProfessionalBusinessManagerConvert(
        IVSProfessionalBusinessManagerConvert ivsProfessionalBusinessManagerConvert)
    {
        this.ivsProfessionalBusinessManagerConvert = ivsProfessionalBusinessManagerConvert;
    }
    
    /** 
     * 开始实况浏览
     *
     * @param parameters 实况浏览入参，包括实况浏览媒体参数，摄像机编码，媒体流目标地址
     * @return GetAlarmEventInfoResponse 响应信息，包含错误码和播放句柄，媒体流源地址
     * @since eSDK IVS V100R003C00
     */
    @Override
    public StartRealPlayByIPExResponse startRealPlayByIPEx(StartRealPlayByIPEx parameters)
    {
        //定义返回对象
        StartRealPlayByIPExResponse response = new StartRealPlayByIPExResponse();
        if (null == parameters)
        {
            LOGGER.error("The input parameter of startRealPlayByIPEx method is null");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        SDKResult<RealPlay> result = new SDKResult<RealPlay>();
        try
        {
            RealPlay realPlay = ivsProfessionalBusinessManagerConvert.startRealPlayByIPExSoap2Model(parameters);
            //调用service层方法
            result = businessMgrService.startRealPlayByIPEx(parameters.getCameraCode(), realPlay);
            if (0 == result.getErrCode())
            {
                response = ivsProfessionalBusinessManagerConvert.startRealPlayByIPExModel2Soap(result.getResult());
            }
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("startRealPlayByIPEx SDKException", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("startRealPlayByIPEx failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 开始平台录像播放
     *
     * @param parameters 实况浏览入参，包括录像播放媒体参数，摄像机编码，媒体流目标地址
     * @return GetAlarmEventInfoResponse 响应信息，包含错误码和播放句柄，媒体流源地址
     * @since eSDK IVS V100R003C00
     */
    @Override
    public StartPlatformPlayBackByIPResponse startPlatformPlayBackByIP(StartPlatformPlayBackByIP parameters)
    {
        SDKResult<Business> result = new SDKResult<Business>();
        
        //定义返回对象
        StartPlatformPlayBackByIPResponse response = new StartPlatformPlayBackByIPResponse();
        try
        {
            if (null == parameters)
            {
                LOGGER.error("The input parameter of startPlatformPlayBackByIP method is null");
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            
            //调用service层方法
            result = businessMgrService.startPlatformPlayBackByIP(
                ivsProfessionalBusinessManagerConvert.startPlatformPlayBackByIPSoap2Model(parameters));
                
        }
        catch (SDKException ex)
        {
            LOGGER.error("startPlatformPlayBackByIP failed", ex);
            response.setResultCode((int)ex.getSdkErrCode());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("startPlatformPlayBackByIP failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response = ivsProfessionalBusinessManagerConvert.startPlatformPlayBackByIPModel2Soap(result);
        
        return response;
    }
    
    /** 
     * 停止实况浏览
     *
     * @param parameters 实况浏览入参，包括播放句柄
     * @return GetAlarmEventInfoResponse 响应信息，包含错误码
     * @since eSDK IVS V100R003C00
     */
    @Override
    public StopRealPlayByIPExResponse stopRealPlayByIPEx(StopRealPlayByIPEx parameters)
    {
        //定义返回对象
        StopRealPlayByIPExResponse response = new StopRealPlayByIPExResponse();
        if (null == parameters)
        {
            LOGGER.error("The input parameter of stopRealPlayByIPEx method is null");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = new SDKErrorCode();
        try
        {
            //调用service层方法
            result = businessMgrService.stopRealPlayByIPEx(parameters.getHandle());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("stopRealPlayByIPEx SDKException", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("stopRealPlayByIPEx failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 查询预置位列表
     *
     * @param parameters 查询预置位列表入参，包括摄像机编码
     * @return GetAlarmEventInfoResponse 响应信息，包含错误码
     * @since eSDK IVS V100R003C00
     */
    @Override
    public GetPTZPresetListResponse getPTZPresetList(GetPTZPresetList parameters)
    {
        GetPTZPresetListResponse response = null;
        
        if (null == parameters || StringUtils.isEmpty(parameters.getCameraCode()))
        {
            LOGGER.error("The input parameter of getPTZPresetList method is error");
            response = new GetPTZPresetListResponse();
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKResult<PTZPresetInfoList> result = null;
        
        try
        {
            result = businessMgrService.getPTZPresetList(parameters.getCameraCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("getPTZPresetList failed", e);
            response = new GetPTZPresetListResponse();
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getPTZPresetList failed", ex);
            response = new GetPTZPresetListResponse();
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response = ivsProfessionalBusinessManagerConvert.getPTZPresetListModel2Soap(result);
        return response;
    }
    
    /** 
     * 云镜控制命令
     * 此接口用于操作摄像机云台和设置摄像机镜头
     * @param parameters 摄像机编码,云镜控制码
     * @return  PtzControlResponse 云台是否锁定
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public PtzControlResponse ptzControl(PtzControl parameters)
    {
        PtzControlResponse response = null;
        if (null == parameters)
        {
            // 参数错误
            LOGGER.error("The input parameter of ptzControl method is error");
            response = new PtzControlResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            response = new PtzControlResponse();
            SDKResult<Integer> result = businessMgrService.ptzControl(parameters.getCameraCode(),
                parameters.getControlCode(),
                parameters.getControlPara1(),
                parameters.getControlPara2());
            response.setResultCode((int)result.getErrCode());
            response.setLockStatus(result.getResult());
        }
        catch (SDKException e)
        {
            LOGGER.error("ptzControl method SDK error", e);
            response = null == response ? new PtzControlResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("ptzControl method error", e);
            response = null == response ? new PtzControlResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /** 
     * 停止平台录像播放
     *
     * @param parameters 停止平台录像播放入参，包含播放句柄
     * @return StopPlatformPlayBackByIPResponse 响应信息：返回码
     * @since eSDK IVS V100R003C00
     */
    @Override
    public StopPlatformPlayBackByIPResponse stopPlatformPlayBackByIP(StopPlatformPlayBackByIP parameters)
    {
        StopPlatformPlayBackByIPResponse response = new StopPlatformPlayBackByIPResponse();
        
        if (null == parameters)
        {
            LOGGER.error("The input parameter of stopPlatformPlayBackByIP method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKErrorCode result = null;
        
        try
        {
            result = businessMgrService.stopPlatformPlayBackByIP(parameters.getHandle());
        }
        catch (SDKException e)
        {
            LOGGER.error("stopPlatformPlayBackByIP failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("stopPlatformPlayBackByIP failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        return response;
    }
    
    /** 
     * 云镜控制命令
     * 此接口用于操作摄像机云台和设置摄像机镜头
     * @param parameters 摄像机编码,云镜控制码
     * @return  PtzControlWithLockerInfoResponse 返回的信息中包含详细的锁定用户信息
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public PtzControlWithLockerInfoResponse ptzControlWithLockerInfo(PtzControlWithLockerInfo parameters)
    {
        PtzControlWithLockerInfoResponse response = null;
        if (null == parameters)
        {
            // 参数错误
            LOGGER.error("The input parameter of ptzControlWithLockerInfo method is error");
            response = new PtzControlWithLockerInfoResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKResult<PTZControlInfo> result = businessMgrService.ptzControlWithLockerInfo(parameters.getCameraCode(),
                parameters.getControlCode(),
                parameters.getControlPara1(),
                parameters.getControlPara2());
            response = ivsProfessionalBusinessManagerConvert.getPTZControlWithLockerInfoModel2Soap(result);
        }
        catch (SDKException e)
        {
            LOGGER.error("ptzControlWithLockerInfo method SDK error", e);
            response = null == response ? new PtzControlWithLockerInfoResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("ptzControlWithLockerInfo method error", e);
            response = null == response ? new PtzControlWithLockerInfoResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /** 
     * 修改指定摄像机预置位
     *
     * @param parameters 预置信息入参，包含摄像机编码和预置信息
     * @return ModifyPTZPresetResponse 响应信息：返回码
     * @since eSDK IVS V100R003C00
     */
    @Override
    public ModifyPTZPresetResponse modifyPTZPreset(ModifyPTZPreset parameters)
    {
        ModifyPTZPresetResponse response = new ModifyPTZPresetResponse();
        
        if (null == parameters || null == parameters.getPtzPresetInfo()
            || StringUtils.isEmpty(parameters.getCameraCode()))
        {
            LOGGER.error("The input parameter of modifyPTZPreset method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        PTZPresetInfo ptzPresetInfo =
            ivsProfessionalBusinessManagerConvert.modifyPTZPresetSoap2Model(parameters.getPtzPresetInfo());
            
        SDKErrorCode result = null;
        
        try
        {
            result = businessMgrService.modifyPTZPreset(parameters.getCameraCode(), ptzPresetInfo);
        }
        catch (SDKException e)
        {
            LOGGER.error("modifyPTZPreset failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("modifyPTZPreset failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response.setResultCode((int)result.getErrCode());
        return response;
    }
    
    /** 
     * 增加指定摄像机预置位
     *
     * @param parameters 预置信息入参，包含摄像机编码和预置位名称
     * @return AddPTZPresetResponse 响应信息：返回码
     * @since eSDK IVS V100R003C00
     */
    @Override
    public AddPTZPresetResponse addPTZPreset(AddPTZPreset parameters)
    {
        SDKResult<Integer> result = new SDKResult<Integer>();
        //定义返回对象
        AddPTZPresetResponse response = new AddPTZPresetResponse();
        try
        {
            if (null == parameters)
            {
                LOGGER.error("The input parameter of addPTZPreset method is null");
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            //调用service层方法
            result = businessMgrService.addPTZPreset(parameters.getCameraCode(), parameters.getPresetName());
            response.setResultCode((int)result.getErrCode());
            response.setPresetIndex(result.getResult());
        }
        catch (SDKException ex)
        {
            LOGGER.error("addPTZPreset failed", ex);
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("addPTZPreset failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 删除指定摄像机预置位
     *
     * @param parameters 预置信息入参，包含摄像机编码和预置位编号
     * @return DeletePTZPresetResponse 响应信息：返回码
     * @since eSDK IVS V100R003C00
     */
    @Override
    public DeletePTZPresetResponse deletePTZPreset(DeletePTZPreset parameters)
    {
        SDKErrorCode result = new SDKErrorCode();
        //定义返回对象
        DeletePTZPresetResponse response = new DeletePTZPresetResponse();
        try
        {
            if (null == parameters)
            {
                LOGGER.error("The input parameter of deletePTZPreset method is null");
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            //调用service层方法
            result = businessMgrService.deletePTZPreset(parameters.getCameraCode(), parameters.getPresetIndex());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException ex)
        {
            LOGGER.error("deletePTZPreset failed", ex);
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("deletePTZPreset failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 停止平台录像
     *
     * @param parameters 入参包含摄像机编码
     * @return StopPlatformRecordResponse 响应信息：返回码
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public StopPlatformRecordResponse stopPlatformRecord(StopPlatformRecord parameters)
    {
        SDKErrorCode result = new SDKErrorCode();
        //定义返回对象
        StopPlatformRecordResponse response = new StopPlatformRecordResponse();
        try
        {
            if (null == parameters)
            {
                LOGGER.error("The input parameter of stopPlatformRecord method is null");
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            //调用service层方法
            result = businessMgrService.stopPlatformRecord(parameters.getCameraCode());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException ex)
        {
            LOGGER.error("stopPlatformRecord failed", ex);
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("stopPlatformRecord failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 开始平台录像
     *
     * @param parameters 入参包含摄像机编码和录像时间
     * @return StartPlatformRecordResponse 响应信息：返回码
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public StartPlatformRecordResponse startPlatformRecord(StartPlatformRecord parameters)
    {
        SDKErrorCode result = new SDKErrorCode();
        //定义返回对象
        StartPlatformRecordResponse response = new StartPlatformRecordResponse();
        try
        {
            if (null == parameters)
            {
                LOGGER.error("The input parameter of startPlatformRecord method is null");
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            //调用service层方法
            result = businessMgrService.startPlatformRecord(parameters.getCameraCode(), parameters.getRecordTime());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException ex)
        {
            LOGGER.error("startPlatformRecord failed", ex);
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("startPlatformRecord failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /**
     * 查询操作日志
     *
     * @param parameters 日志查询条件
     * @return GetOperationLogResponse 响应信息：返回码;日志查询结果
     * @since eSDK IVS V100R003C10
     */
    
    /** 
    * 查询操作日志
    * 
    * @param parameters 日志查询条件
    * @return GetOperationLogResponse 响应信息：返回码;日志查询结果
    * @see [类、类#方法、类#成员]
    */
    @Override
    public GetOperationLogResponse getOperationLog(GetOperationLog parameters)
    {
        SDKResult<Business> result = new SDKResult<Business>();
        //定义返回对象
        GetOperationLogResponse response = new GetOperationLogResponse();
        
        if (null == parameters || null == parameters.getUnifiedQuery()
            || null == parameters.getUnifiedQuery().getQueryFieldList())
        {
            LOGGER.error("The input parameter of getOperationLog method is null");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryUnifiedFormat fiedQuery = parameters.getUnifiedQuery();
        
        //分页条件判断
        if (!IVSUtil.validateIndexRange(fiedQuery.getIndex().getFromIndex(), fiedQuery.getIndex().getToIndex()))
        {
            LOGGER.error("The indexRange is error");
            response.setResultCode(ErrInfo.IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR);
            return response;
        }
        
        //判断fieldNum的大小是否和QueryFieldList中查询条件个数相同
        if (fiedQuery.getFieldNum() != fiedQuery.getQueryFieldList().getQueryField().size())
        {
            response.setResultCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return response;
        }
        
        try
        {
            //调用service层方法
            QueryUnifiedFormat queryUnfied =
                ivsProfessionalBusinessManagerConvert.getQueryUnfiedSoap2Modal(parameters.getUnifiedQuery());
                
            result = businessMgrService.getOperationLog(queryUnfied);
            
            response = ivsProfessionalBusinessManagerConvert.getOperationLogResponseModal2Soap(result);
        }
        catch (SDKException ex)
        {
            LOGGER.error("getOperationLog failed", ex);
            response.setResultCode((int)ex.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getOperationLog failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 暂停平台录像回放
     * 
     * @param parameters 
     * @return 
     * @see [类、类#方法、类#成员]
     */
    @Override
    public PlatformPlayBackPauseByIPResponse platformPlayBackPauseByIP(PlatformPlayBackPauseByIP parameters)
    {
        PlatformPlayBackPauseByIPResponse response = null;
        if (null == parameters)
        {
            // 参数错误
            LOGGER.error("The input parameter of platformPlayBackPauseByIP method is error");
            response = new PlatformPlayBackPauseByIPResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            response = new PlatformPlayBackPauseByIPResponse();
            SDKErrorCode result = businessMgrService.platformPlayBackPauseByIP(parameters.getPlayHandle());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("platformPlayBackPauseByIP method SDK error", e);
            response = null == response ? new PlatformPlayBackPauseByIPResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("platformPlayBackPauseByIP method error", e);
            response = null == response ? new PlatformPlayBackPauseByIPResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /** 
     * 恢复平台录像回放
     * 
     * @param parameters
     * @return 
     * @see [类、类#方法、类#成员]
     */
    @Override
    public PlatformPlayBackResumeByIPResponse platformPlayBackResumeByIP(PlatformPlayBackResumeByIP parameters)
    {
        PlatformPlayBackResumeByIPResponse response = null;
        if (null == parameters)
        {
            // 参数错误
            LOGGER.error("The input parameter of platformPlayBackResumeByIP method is error");
            response = new PlatformPlayBackResumeByIPResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            response = new PlatformPlayBackResumeByIPResponse();
            SDKErrorCode result = businessMgrService.platformPlayBackResumeByIP(parameters.getPlayHandle());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("platformPlayBackResumeByIP method SDK error", e);
            response = null == response ? new PlatformPlayBackResumeByIPResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("platformPlayBackResumeByIP method error", e);
            response = null == response ? new PlatformPlayBackResumeByIPResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /** 
     * 设置平台录像码流回放时间
     * 
     * @param parameters 设置平台录像码流回放时间入参，包括播放句柄、回放时间
     * @return SetPlayBackTimeByIPResponse 响应消息，包括结果码
     * @see 
     * @since eSDK IVS V100R003C30SPC100
     */
    @Override
    public SetPlayBackTimeByIPResponse setPlayBackTimeByIP(SetPlayBackTimeByIP parameters)
    {
        SetPlayBackTimeByIPResponse response = new SetPlayBackTimeByIPResponse();
        if (null == parameters)
        {
            //参数错误
            LOGGER.error("The input parameter of setPlayBackTimeByIP method is error");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKErrorCode result =
                businessMgrService.setPlayBackTimeByIP(parameters.getPlayHandle(), parameters.getTime());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("setPlayBackTimeByIP method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("setPlayBackTimeByIP method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /** 
     * 设置平台录像码流回放速度
     * 
     * @param parameters 设置平台录像码流回放时间入参，包括播放句柄、播放速度
     * @return SetPlayBackSpeedByIPResponse 响应消息，包括结果码
     * @see 
     * @since eSDK IVS V100R003C30SPC100
     */
    @Override
    public SetPlayBackSpeedByIPResponse setPlayBackSpeedByIP(SetPlayBackSpeedByIP parameters)
    {
        SetPlayBackSpeedByIPResponse response = new SetPlayBackSpeedByIPResponse();
        if (null == parameters)
        {
            //参数错误
            LOGGER.error("The input parameter of setPlayBackSpeedByIP method is error");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKErrorCode result =
                businessMgrService.setPlayBackSpeedByIP(parameters.getPlayHandle(), parameters.getSpeed());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("setPlayBackSpeedByIP method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("setPlayBackSpeedByIP method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /**
     * 获取平台抓拍图片列表
     * 
     * @param parameters 获取平台抓拍图片列表入参
     * @return 响应码 与 图片信息结果集
     * @author likun/l00295065
     * @since eSDK IVS V100R005C60
     */
    @Override
    public GetSnapshotListResponse getSnapshotList(GetSnapshotList parameters)
    {
        LOGGER.debug("Enter north method getSnapshotList");
        
        GetSnapshotListResponse response = new GetSnapshotListResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getCameraCode())
            || null == parameters.getQuerySnapshotParam() || null == parameters.getQuerySnapshotParam().getIndexRange()
            || null == parameters.getQuerySnapshotParam().getTimeSpan()
            || StringUtils.isEmpty(parameters.getQuerySnapshotParam().getTimeSpan().getStartTime())
            || StringUtils.isEmpty(parameters.getQuerySnapshotParam().getTimeSpan().getEndTime()))
        {
            //参数错误
            LOGGER.error("The input parameter of getSnapshotList method is error");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        try
        {
            SDKResult<SnapshotInfoList> result = businessMgrService.getSnapshotList(parameters.getCameraCode(),
                ivsProfessionalBusinessManagerConvert
                    .getQuerySnapshotParamSoap2Model(parameters.getQuerySnapshotParam()));
                    
            LOGGER.info("getSnapshotList finished with errCode:" + result.getErrCode());
            response.setResultCode((int)result.getErrCode());
            response.setSnapshotInfoList(
                ivsProfessionalBusinessManagerConvert.getSnapshotInfoListModel2Soap(result.getResult()));
        }
        catch (SDKException e)
        {
            LOGGER.error("getSnapshotList method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getSnapshotList method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        LOGGER.debug("Leave north method getSnapshotList");
        return response;
    }
    
    /**
     * 平台抓拍
     * 
     * @param parameters 平台抓拍入参：摄像机编码
     * @return 响应码
     * @author likun/l00295065
     * @since eSDK IVS V100R005C60
     */
    @Override
    public PlatformSnapshotResponse platformSnapshot(PlatformSnapshot parameters)
    {
        LOGGER.debug("Enter north method platformSnapshot");
        
        PlatformSnapshotResponse response = new PlatformSnapshotResponse();
        if (null == parameters || StringUtils.isEmpty(parameters.getCameraCode()))
        {
            //参数错误
            LOGGER.error("The input parameter of platformSnapshot method is error");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKErrorCode result = businessMgrService.platformSnapshot(parameters.getCameraCode());
            
            LOGGER.info("platformSnapshot finished with errCode:" + result.getErrCode());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("platformSnapshot method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("platformSnapshot method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        LOGGER.debug("Leave north method platformSnapshot");
        return response;
    }
    
    /**
     * 删除平台抓拍图片
     * 
     * @param parameters 平台抓拍入参：摄像机编码,抓拍图片ID
     * @return 响应码
     * @author likun/l00295065
     * @since eSDK IVS V100R005C60
     */
    @Override
    public DeleteSnapshotResponse deleteSnapshot(DeleteSnapshot parameters)
    {
        LOGGER.debug("Enter north method deleteSnapshot");
        
        DeleteSnapshotResponse response = new DeleteSnapshotResponse();
        if (null == parameters || StringUtils.isEmpty(parameters.getCameraCode()))
        {
            //参数错误
            LOGGER.error("The input parameter of deleteSnapshot method is error");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKErrorCode result =
                businessMgrService.deleteSnapshot(parameters.getCameraCode(), parameters.getPictureID());
                
            LOGGER.info("deleteSnapshot finished with errCode:" + result.getErrCode());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("deleteSnapshot method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("deleteSnapshot method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        LOGGER.debug("Leave north method deleteSnapshot");
        return response;
    }
    
    /**
     * 获取RtspURL
     * 
     * @param parameters 查询入参：摄像机编码,媒体URL参数
     * @return 响应码
     * @author likun/l00295065
     * @since eSDK IVS V100R005C70
     */
    @Override
    public GetRtspURLResponse getRtspURL(GetRtspURL parameters)
    {
        LOGGER.debug("Enter north method getRtspURL");
        
        GetRtspURLResponse response = new GetRtspURLResponse();
        if (null == parameters || StringUtils.isEmpty(parameters.getCameraCode()))
        {
            //参数错误
            LOGGER.error("The input parameter of getRtspURL method is error");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        try
        {
            SDKResult<String> result = businessMgrService.getRtspURL(parameters.getCameraCode(),
                ivsProfessionalBusinessManagerConvert.mediaURLParamSoap2Model(parameters.getMediaURLParam()));
                
            LOGGER.info("getRtspURL finished with errCode:" + result.getErrCode());
            response.setResultCode((int)result.getErrCode());
            response.setRtspURL(result.getResult());
        }
        catch (SDKException e)
        {
            LOGGER.error("getRtspURL method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getRtspURL method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        LOGGER.debug("Leave north method getRtspURL");
        return response;
    }
}
