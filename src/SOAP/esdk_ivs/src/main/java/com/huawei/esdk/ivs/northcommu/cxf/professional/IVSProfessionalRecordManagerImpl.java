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

import com.huawei.esdk.ivs.business.professional.recordmgr.RecordMgrService;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.RecordInfoList;
import com.huawei.esdk.ivs.domain.model.bean.RecordPlan;
import com.huawei.esdk.ivs.domain.util.IVSUtil;
import com.huawei.esdk.ivs.northcommu.cxf.professional.convert.IVSProfessionalRecordManagerConvert;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddRecordPlan;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddRecordPlanResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteRecordPlan;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteRecordPlanResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetRecordList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetRecordListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetRecordPlan;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetRecordPlanResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IVSProfessionalRecordManager;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ModifyRecordPlan;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ModifyRecordPlanResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryRecordList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryRecordListResponse;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 录像管理
 * <p>
 * 新增、修改、删除 和 查询平台录像计划
 * <p>
 * @author  sWX198756
 * @see  com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IVSProfessionalRecordManager
 * @since  eSDK IVS V100R003C00
 */
public class IVSProfessionalRecordManagerImpl implements IVSProfessionalRecordManager
{
    /**
     * 录像管理service层
     */
    private RecordMgrService recordMgrService = null;
    
    /**
     * 录像管理转换类：北向到领域，领域到北向
     */
    private IVSProfessionalRecordManagerConvert ivsProfessionalRecordManagerConvert = null;
    
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(IVSProfessionalClusterManagerImpl.class);
    
    /**
     * 查询录像计划
     * 查询平台/前端录像计划
     * @param parameters 摄像机信息
     * @return GetRecordPlanResponse 录像计划
     * @exception SDKException  SDK异常
     * @exception Exception  系统错误（正常情况不应该出现）
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public GetRecordPlanResponse getRecordPlan(GetRecordPlan parameters)
    {
        GetRecordPlanResponse response = null;
        if (null == parameters)
        {
            // 参数错误
            LOGGER.error("The input parameter of getRecordPlan method is error");
            response = new GetRecordPlanResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKResult<RecordPlan> result =
                recordMgrService.getRecordPlan(parameters.getCameraCode(), parameters.getRecordMethod());
            response = ivsProfessionalRecordManagerConvert.getRecordPlanModel2Soap(result);
        }
        catch (SDKException e)
        {
            LOGGER.error("getRecordPlan method SDK error", e);
            response = new GetRecordPlanResponse();
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getRecordPlan method error", e);
            response = null == response ? new GetRecordPlanResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /**
     * 修改录像计划
     * 修改平台/前端录像计划（批量）
     * @param parameters 摄像机录像计划信息
     * @return ModifyRecordPlanResponse 录像计划
     * @exception SDKException  SDK异常
     * @exception Exception  系统错误（正常情况不应该出现）
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public ModifyRecordPlanResponse modifyRecordPlan(ModifyRecordPlan parameters)
    {
        ModifyRecordPlanResponse response = null;
        if (null == parameters)
        {
            // 参数错误
            LOGGER.error("The input parameter of modifyRecordPlan method is error");
            response = new ModifyRecordPlanResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKResult<DeviceOperResultList> result =
                recordMgrService.modifyRecordPlan(parameters.getDeviceNum(),
                    ivsProfessionalRecordManagerConvert.getDeviceCodeListSoap2Model(parameters.getDeviceCodeList()),
                    ivsProfessionalRecordManagerConvert.getRecordPlanSoap2Model(parameters.getRecordPlan()));
            response = ivsProfessionalRecordManagerConvert.modifyRecordPlanModel2Soap(result);
        }
        catch (SDKException e)
        {
            LOGGER.error("modifyRecordPlan method SDK error", e);
            response = null == response ? new ModifyRecordPlanResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("modifyRecordPlan method error", e);
            response = null == response ? new ModifyRecordPlanResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /**
     * 删除录像计划
     * 删除平台/前端录像计划 （批量）
     * @param parameters 摄像机信息
     * @return DeleteRecordPlanResponse 录像计划
     * @exception SDKException  SDK异常
     * @exception Exception  系统错误（正常情况不应该出现）
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public DeleteRecordPlanResponse deleteRecordPlan(DeleteRecordPlan parameters)
    {
        DeleteRecordPlanResponse response = null;
        if (null == parameters)
        {
            // 参数错误
            LOGGER.error("The input parameter of deleteRecordPlan method is error");
            response = new DeleteRecordPlanResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKResult<DeviceOperResultList> result =
                recordMgrService.deleteRecordPlan(parameters.getDeviceNum(),
                    ivsProfessionalRecordManagerConvert.getDeviceCodeListSoap2Model(parameters.getDeviceCodeList()),
                    parameters.getRecordMethod());
            response = ivsProfessionalRecordManagerConvert.deleteRecordPlanModel2Soap(result);
        }
        catch (SDKException e)
        {
            LOGGER.error("deleteRecordPlan method SDK error", e);
            response = null == response ? new DeleteRecordPlanResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("deleteRecordPlan method error", e);
            response = null == response ? new DeleteRecordPlanResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /**
     * 新增平台录像计划
     * 新增平台/前端录像计划（批量）
     * @param  addRecordPlan  北向添加录像计划Bean  
     * @return  AddRecordPlanResponse  北向添加录像计划返回结果Bean   
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     * 
     */
    @Override
    public AddRecordPlanResponse addRecordPlan(AddRecordPlan addRecordPlan)
    {
        AddRecordPlanResponse response = null;
        
        if (null == addRecordPlan)
        {
            response = new AddRecordPlanResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKResult<DeviceOperResultList> result =
                recordMgrService.addRecordPlan(addRecordPlan.getDeviceNum(),
                    ivsProfessionalRecordManagerConvert.getDeviceCodeListSoap2Model(addRecordPlan.getDeviceCodeList()),
                    ivsProfessionalRecordManagerConvert.getRecordPlanSoap2Model(addRecordPlan.getRecordPlan()));
            response = ivsProfessionalRecordManagerConvert.addRecordPlanResponseModel2Soap(result);
        }
        catch (SDKException e)
        {
            LOGGER.error("addRecordPlan method SDKException: ", e);
            if (null == response)
            {
                response = new AddRecordPlanResponse();
            }
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("addRecordPlan method Exception: ", e);
            if (null == response)
            {
                response = new AddRecordPlanResponse();
            }
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    public void setRecordMgrService(RecordMgrService recordMgrService)
    {
        this.recordMgrService = recordMgrService;
    }
    
    public void setIvsProfessionalRecordManagerConvert(
        IVSProfessionalRecordManagerConvert ivsProfessionalRecordManagerConvert)
    {
        this.ivsProfessionalRecordManagerConvert = ivsProfessionalRecordManagerConvert;
    }
    
    /** 
     * 查询录像列表
     * @param parameters 通用查询结构
     * @return  QueryRecordListResponse 返回录像查询结构列表
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public QueryRecordListResponse queryRecordList(QueryRecordList parameters)
    {
        QueryRecordListResponse response = null;
        if (null == parameters)
        {
            // 参数错误
            LOGGER.error("The input parameter of queryRecordList method is error");
            response = new QueryRecordListResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        //分页条件判断
        if (!IVSUtil.validateIndexRange(parameters.getQueryFormat().getIndex().getFromIndex(),
            parameters.getQueryFormat().getIndex().getToIndex()))
        {
            LOGGER.error("The indexRange is error");
            response = new QueryRecordListResponse();
            response.setResultCode(ErrInfo.IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR);
            return response;
        }
        
        try
        {
            SDKResult<RecordInfoList> result =
                recordMgrService.queryRecordList(ivsProfessionalRecordManagerConvert.getQueryUnifiedFormatSoap2Model(parameters.getQueryFormat()));
            response = ivsProfessionalRecordManagerConvert.queryRecordInfosModel2Soap(result);
        }
        catch (SDKException e)
        {
            LOGGER.error("queryRecordList method SDK error", e);
            response = null == response ? new QueryRecordListResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("queryRecordList method error", e);
            response = null == response ? new QueryRecordListResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /** 
     * 查询录像列表
     * @param parameters 查询参数：摄像机ID，录像存储位置，时间段信息，分页信息
     * @return  GetRecordListResponse 返回录像查询结构列表
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public GetRecordListResponse getRecordList(GetRecordList parameters)
    {
        GetRecordListResponse response = null;
        if (null == parameters)
        {
            // 参数错误
            LOGGER.error("The input parameter of getRecordList method is error");
            response = new GetRecordListResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        //分页条件判断
        if (!IVSUtil.validateIndexRange(parameters.getIndexRange().getFromIndex(), parameters.getIndexRange()
            .getToIndex()))
        {
            LOGGER.error("The indexRange is error");
            response = new GetRecordListResponse();
            response.setResultCode(ErrInfo.IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR);
            return response;
        }
        
        try
        {
            SDKResult<RecordInfoList> result =
                recordMgrService.getRecordList(parameters.getCameraCode(),
                    parameters.getRecordMethod(),
                    ivsProfessionalRecordManagerConvert.getTimeSpanSoap2Model(parameters.getTimeSpan()),
                    ivsProfessionalRecordManagerConvert.getIndexRangeSoap2Model(parameters.getIndexRange()));
            response = ivsProfessionalRecordManagerConvert.getRecordInfosModel2Soap(result);
        }
        catch (SDKException e)
        {
            LOGGER.error("getRecordList method SDK error", e);
            response = null == response ? new GetRecordListResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getRecordList method error", e);
            response = null == response ? new GetRecordListResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
}
