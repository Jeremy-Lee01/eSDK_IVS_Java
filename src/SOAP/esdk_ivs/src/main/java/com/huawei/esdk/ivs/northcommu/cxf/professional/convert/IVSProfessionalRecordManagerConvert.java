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

import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.huawei.esdk.ivs.domain.model.bean.DeviceCode;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RecordBookmarkInfo;
import com.huawei.esdk.ivs.domain.model.bean.RecordInfo;
import com.huawei.esdk.ivs.domain.model.bean.RecordInfoList;
import com.huawei.esdk.ivs.domain.model.bean.RecordLockInfo;
import com.huawei.esdk.ivs.domain.model.bean.RecordPTZPresetInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddRecordPlanResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteRecordPlanResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetRecordListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetRecordPlanResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.LockInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ModifyRecordPlanResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZPresetInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PlanInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PlanInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryRecordListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RecordInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RecordPlan;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ResultInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ResultInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.ResultInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.TimeSpan;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.TimeSpanList;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 录像管理模块数据转换类
 * <p>
 * 用于南北向录像管理模块接口数据的转换
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class IVSProfessionalRecordManagerConvert
{
    
    /** 
    * 将领域层返回的结果对象转换成响应消息
    * @param result 录像计划
    * @return GetRecordPlanResponse 北向接口响应
    * @since  eSDK IVS V100R003C00
    */
    public GetRecordPlanResponse getRecordPlanModel2Soap(
        SDKResult<com.huawei.esdk.ivs.domain.model.bean.RecordPlan> result)
    {
        GetRecordPlanResponse response = new GetRecordPlanResponse();
        response.setResultCode((int)result.getErrCode());
        com.huawei.esdk.ivs.domain.model.bean.RecordPlan domain = result.getResult();
        if (null == domain || 0 != result.getErrCode())
        {
            return response;
        }
        
        RecordPlan north = new RecordPlan();
        north.setEnableRecordPlan(domain.getEnableRecordPlan());
        List<com.huawei.esdk.ivs.domain.model.bean.PlanInfo> planInfoDomains = domain.getPlanInfos();
        PlanInfoList planInfoListNorth = new PlanInfoList();
        List<PlanInfo> planInfos = planInfoListNorth.getPlanInfo();
        if (null != planInfoDomains)
        {
            for (com.huawei.esdk.ivs.domain.model.bean.PlanInfo planInfoDomain : planInfoDomains)
            {
                PlanInfo planInfo = getPlanInfoModel2Soap(planInfoDomain);
                if (null != planInfo)
                {
                    planInfos.add(planInfo);
                }
            }
        }
        north.setPlanInfoList(planInfoListNorth);
        north.setPlanInfoNum(domain.getPlanInfoNum());
        north.setRecordMethod(domain.getRecordMethod());
        north.setRecordPlanType(domain.getRecordPlanType());
        north.setReserve(domain.getReserve());
        response.setRecordPlan(north);
        return response;
    }
    
    /** 
     * 将领域层返回的结果对象转换成响应消息
     * @param result 录像计划信息
     * @return PlanInfo 北向接口响应
     * @since  eSDK IVS V100R003C00
     */
    public PlanInfo getPlanInfoModel2Soap(com.huawei.esdk.ivs.domain.model.bean.PlanInfo domain)
    {
        if (null == domain)
        {
            return null;
        }
        PlanInfo north = new PlanInfo();
        north.setDayType(domain.getDayType());
        north.setReserve(domain.getReserve());
        north.setTimeSpanInfoNum(domain.getTimeSpanInfoNum());
        List<com.huawei.esdk.ivs.domain.model.bean.TimeSpan> timeSpanDomains = domain.getTimeSpanInfos();
        TimeSpanList timeSpanListNorth = new TimeSpanList();
        List<TimeSpan> timeSpans = timeSpanListNorth.getTimeSpan();
        if (null != timeSpanDomains)
        {
            for (com.huawei.esdk.ivs.domain.model.bean.TimeSpan timeSpanDomain : timeSpanDomains)
            {
                TimeSpan timeSpanNorth = getTimeSpanModel2Soap(timeSpanDomain);
                timeSpans.add(timeSpanNorth);
            }
        }
        north.setTimeSpanInfoList(timeSpanListNorth);
        return north;
    }
    
    /** 
     * 将领域层返回的结果对象转换成响应消息
     * @param result 时间段信息
     * @return TimeSpan 北向接口响应
     * @since  eSDK IVS V100R003C00
     */
    public TimeSpan getTimeSpanModel2Soap(com.huawei.esdk.ivs.domain.model.bean.TimeSpan domain)
    {
        TimeSpan north = new TimeSpan();
        north.setStartTime(domain.getStartTime());
        north.setEndTime(domain.getEndTime());
        return north;
    }
    
    /** 
     * 将领域层返回的结果对象转换成响应消息
     * @param result 设备信息列表
     * @return DeleteRecordPlanResponse 北向接口响应
     * @since  eSDK IVS V100R003C00
     */
    public DeleteRecordPlanResponse deleteRecordPlanModel2Soap(
        SDKResult<com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList> result)
    {
        DeleteRecordPlanResponse response = new DeleteRecordPlanResponse();
        response.setResultCode((int)result.getErrCode());
        com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList domain = result.getResult();
        if (null == domain)
        {
            return response;
        }
        ResultInfos north = getResultListModel2Soap(domain);
        response.setResultInfos(north);
        return response;
    }
    
    /** 
     * 将领域层返回的结果对象转换成响应消息
     * @param result 设备信息列表
     * @return ModifyRecordPlanResponse 北向接口响应
     * @since  eSDK IVS V100R003C00
     */
    public ModifyRecordPlanResponse modifyRecordPlanModel2Soap(
        SDKResult<com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList> result)
    {
        ModifyRecordPlanResponse response = new ModifyRecordPlanResponse();
        response.setResultCode((int)result.getErrCode());
        com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList domain = result.getResult();
        if (null == domain)
        {
            return response;
        }
        ResultInfos north = getResultListModel2Soap(domain);
        response.setResultInfos(north);
        return response;
    }
    
    /** 
     * 将领域层返回的结果对象转换成响应消息
     * @param result 设备信息列表
     * @return ResultList 北向接口响应
     * @since  eSDK IVS V100R003C00
     */
    public ResultInfos getResultListModel2Soap(com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList domain)
    {
        if (null == domain)
        {
            return null;
        }
        ResultInfos north = new ResultInfos();
        north.setNumber(domain.getNum());
        ResultInfoList resultInfoListNorth = new ResultInfoList();
        List<ResultInfo> resultInfoNorths = resultInfoListNorth.getResultInfo();
        List<com.huawei.esdk.ivs.domain.model.bean.DeviceOperResult> resultDomains = domain.getDeviceOperResults();
        if (null != resultDomains)
        {
            for (com.huawei.esdk.ivs.domain.model.bean.DeviceOperResult resultDomain : resultDomains)
            {
                ResultInfo resultInfoNorth = getResultInfoModel2Soap(resultDomain);
                if (null != resultInfoNorth)
                {
                    resultInfoNorths.add(resultInfoNorth);
                }
            }
        }
        north.setResultInfoList(resultInfoListNorth);
        return north;
    }
    
    /** 
     * 将领域层返回的结果对象转换成响应消息
     * @param result 设备信息
     * @return ResultInfo 北向接口响应
     * @since  eSDK IVS V100R003C00
     */
    public ResultInfo getResultInfoModel2Soap(com.huawei.esdk.ivs.domain.model.bean.DeviceOperResult domain)
    {
        if (null == domain)
        {
            return null;
        }
        ResultInfo north = new ResultInfo();
        north.setCode(domain.getCode());
        north.setResult(domain.getResult());
        north.setSequence(domain.getSequence());
        return north;
    }
    
    /** 
     * 将soap消息转换成领域对象
     * @param result 设备信息
     * @return List<DeviceCode> 设备编码列表
     * @since  eSDK IVS V100R003C00
     */
    public List<DeviceCode> getDeviceCodeListSoap2Model(
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceCodeList norths)
    {
        return new IVSProfessionalDeviceManagerConvert().getDeviceCodeListSoap2Model(norths);
    }
    
    /** 
     * 将soap消息转换成领域对象
     * @param recordPlanSoap 北向录像计划信息bean
     * @return RecordPlan 领域层录像计划信息
     * @throws SDKException 
     * @since  eSDK IVS V100R003C00
     */
    public com.huawei.esdk.ivs.domain.model.bean.RecordPlan getRecordPlanSoap2Model(RecordPlan recordPlanSoap) throws SDKException
    {
        if (null != recordPlanSoap)
        {
            com.huawei.esdk.ivs.domain.model.bean.RecordPlan recordPlanDomain =
                new com.huawei.esdk.ivs.domain.model.bean.RecordPlan();
            recordPlanDomain.setRecordMethod(recordPlanSoap.getRecordMethod());
            recordPlanDomain.setEnableRecordPlan(recordPlanSoap.getEnableRecordPlan());
            recordPlanDomain.setRecordPlanType(recordPlanSoap.getRecordPlanType());
            recordPlanDomain.setReserve(recordPlanSoap.getReserve());
            recordPlanDomain.setPlanInfoNum(recordPlanSoap.getPlanInfoNum());
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PlanInfoList planInfoListSoap = recordPlanSoap.getPlanInfoList();
            if (null != planInfoListSoap)
            {
                List<PlanInfo> planInfoSoaps = planInfoListSoap.getPlanInfo();
                int size = planInfoSoaps.size();
                if (CommonConstant.RecordModule.IVS_MAX_PLAN_INFO_NUM < size)
                {
                    SDKException sdkException = new SDKException("DATA_ERRORCODE");
                    sdkException.setSdkErrCode(ErrInfo.IVS_DATA_INVALID_ERROR);
                    throw sdkException;
                }
                
                List<com.huawei.esdk.ivs.domain.model.bean.PlanInfo> planInfoDomains =
                    new ArrayList<com.huawei.esdk.ivs.domain.model.bean.PlanInfo>();
                com.huawei.esdk.ivs.domain.model.bean.PlanInfo planInfoDomain = null;
                
                List<TimeSpan> timeSpanSoaps = null;
                List<com.huawei.esdk.ivs.domain.model.bean.TimeSpan> timeSpanDomains = null;
                com.huawei.esdk.ivs.domain.model.bean.TimeSpan timeSpanDomain = null;
                
                for (PlanInfo planInfo : planInfoSoaps)
                {
                    planInfoDomain = new com.huawei.esdk.ivs.domain.model.bean.PlanInfo();
                    planInfoDomain.setDayType(planInfo.getDayType());
                    planInfoDomain.setTimeSpanInfoNum(planInfo.getTimeSpanInfoNum());
                    planInfoDomain.setReserve(planInfo.getReserve());
                    
                    if (null != planInfo.getTimeSpanInfoList())
                    {
                        timeSpanSoaps = planInfo.getTimeSpanInfoList().getTimeSpan();
                        int timeSpanSize = timeSpanSoaps.size();
                        if (CommonConstant.RecordModule.IVS_MAX_TIMESPAN_NUM < timeSpanSize || 0 > timeSpanSize)
                        {
                            SDKException sdkException = new SDKException("DATA_ERRORCODE");
                            sdkException.setSdkErrCode(ErrInfo.IVS_DATA_INVALID_ERROR);
                            throw sdkException;
                        }
                        if (timeSpanSize != planInfo.getTimeSpanInfoNum())
                        {
                            SDKException sdkException = new SDKException("SDK PARAM INVALID");
                            sdkException.setSdkErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
                            throw sdkException;
                        }
                        timeSpanDomains = new ArrayList<com.huawei.esdk.ivs.domain.model.bean.TimeSpan>();
                        for (TimeSpan timeSpan : timeSpanSoaps)
                        {
                            timeSpanDomain = new com.huawei.esdk.ivs.domain.model.bean.TimeSpan();
                            timeSpanDomain.setStartTime(timeSpan.getStartTime());
                            timeSpanDomain.setEndTime(timeSpan.getEndTime());
                            
                            timeSpanDomains.add(timeSpanDomain);
                        }
                        planInfoDomain.setTimeSpanInfos(timeSpanDomains);
                    }
                    
                    planInfoDomains.add(planInfoDomain);
                }
                recordPlanDomain.setPlanInfos(planInfoDomains);
            }
            
            return recordPlanDomain;
        }
        return null;
    }
    
    public AddRecordPlanResponse addRecordPlanResponseModel2Soap(SDKResult<DeviceOperResultList> result)
    {
        AddRecordPlanResponse response = new AddRecordPlanResponse();
        response.setResultCode((int)result.getErrCode());
        
        DeviceOperResultList resultListDomain = result.getResult();
        if (null != resultListDomain)
        {
            ResultInfos resultListNorth = getResultListModel2Soap(resultListDomain);
            response.setResultInfos(resultListNorth);
        }
        
        return response;
    }
    
    /** 
     * 转换北向QueryUnifiedFormat为领域层bean
     *
     * @param queryUnifiedFormat 北向录像列表查询条件
     * @return QueryUnifiedFormat 领域层录像列表查询条件
     * @since  eSDK IVS V100R003C00
     */
    public QueryUnifiedFormat getQueryUnifiedFormatSoap2Model(
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryUnifiedFormat soap)
    {
        if (null == soap)
        {
            return null;
        }
        return new IVSProfessionalDeviceManagerConvert().queryDeviceListSoap2Model(soap);
    }
    
    public QueryRecordListResponse queryRecordInfosModel2Soap(SDKResult<RecordInfoList> result)
    {
        QueryRecordListResponse response = new QueryRecordListResponse();
        response.setResultCode((int)result.getErrCode());
        
        RecordInfos recordInfos = getRecordInfosModel2Soap(result.getResult());
        if (null != recordInfos)
        {
            response.setRecordInfos(recordInfos);
        }
        
        return response;
    }
    
    private RecordInfos getRecordInfosModel2Soap(RecordInfoList domain)
    {
        if (null == domain)
        {
            return null;
        }
        RecordInfos recordInfos = new RecordInfos();
        recordInfos.setTotal(domain.getTotal());
        recordInfos.setReserve(domain.getReserve());
        IndexRange indexRange =
            new IVSProfessionalClusterManagerConvert().getIndexRangeModel2Soap(domain.getIndexRange());
        if (null != indexRange)
        {
            recordInfos.setIndexRange(indexRange);
        }
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RecordInfoList recordInfoListSoap =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RecordInfoList();
        List<RecordInfo> recordInfoDomains = domain.getRecordInfos();
        if (null != recordInfoDomains)
        {
            List<com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RecordInfo> recordInfoSoaps =
                recordInfoListSoap.getRecordInfo();
            for (RecordInfo recordInfoDoamin : recordInfoDomains)
            {
                com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RecordInfo recordInfoSoap =
                    getRecordInfoModel2Soap(recordInfoDoamin);
                if (null != recordInfoSoap)
                {
                    recordInfoSoaps.add(recordInfoSoap);
                }
            }
        }
        
        recordInfos.setRecordInfoList(recordInfoListSoap);
        return recordInfos;
    }

    private com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RecordInfo getRecordInfoModel2Soap(RecordInfo domain)
    {
        if (null == domain)
        {
            return null;
        }
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RecordInfo soap =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RecordInfo();
        soap.setAlarmType(domain.getAlarmType());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.BookmarkInfo bookmarkInfoSoap =
            getBookmarkInfoModel2Soap(domain.getBookmarkInfo());
        if (null != bookmarkInfoSoap)
        {
            soap.setBookmarkInfo(bookmarkInfoSoap);
        }
        
        soap.setFrameExtractionTimes(domain.getFrameExtractionTimes());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.LockInfo lockInfoSoap =
            getLockInfoModel2Soap(domain.getLockInfo());
        if (null != lockInfoSoap)
        {
            soap.setLockInfo(lockInfoSoap);
        }
        
        soap.setMbuDomain(domain.getMbuDomain());
        soap.setNvrCode(domain.getNvrCode());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZPresetInfo presetInfoSoap =
            getPTZPresetInfoModel2Soap(domain.getPtzPresetInfo());
        if (null != presetInfoSoap)
        {
            soap.setPtzPresetInfo(presetInfoSoap);
        }
        
        soap.setRecordFileName(domain.getRecordFileName());
        soap.setRecordMethod(domain.getRecordMethod());
        
        TimeSpan recordTimeSoap = getTimeSpanModel2Soap(domain.getTimeSpan());
        if (null != recordTimeSoap)
        {
            soap.setRecordTime(recordTimeSoap);
        }
        
        soap.setRecordType(domain.getRecordType());
        soap.setReserve(domain.getReserve());
        
        return soap;
    }
    
    private PTZPresetInfo getPTZPresetInfoModel2Soap(RecordPTZPresetInfo domain)
    {
        if (null == domain)
        {
            return null;
        }
        PTZPresetInfo soap = new PTZPresetInfo();
        soap.setPresetIndex(domain.getId());
        soap.setPresetName(domain.getName());
        soap.setReserve(domain.getReserve());
        return soap;
    }
    
    private LockInfo getLockInfoModel2Soap(RecordLockInfo domain)
    {
        if (null == domain)
        {
            return null;
        }
        LockInfo soap = new LockInfo();
        soap.setLockDesc(domain.getLockDesc());
        soap.setLockId(domain.getLockId());
        soap.setLockTime(domain.getLockTime());
        TimeSpan timeSpanSoap = getTimeSpanModel2Soap(domain.getLockTimeSpan());
        soap.setLockTimeSpan(timeSpanSoap);
        soap.setOperatorId(domain.getOperatorId());
        soap.setOperatorName(domain.getOperatorName());
        soap.setReserve(domain.getReserve());
        return soap;
    }
    
    private com.huawei.esdk.ivs.northcommu.cxf.professional.gen.BookmarkInfo getBookmarkInfoModel2Soap(
        RecordBookmarkInfo domain)
    {
        if (null == domain)
        {
            return null;
        }
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.BookmarkInfo soap =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.BookmarkInfo();
        soap.setBookmarkCreatorId(domain.getBookmarkCreatorId());
        soap.setBookmarkCreatorName(domain.getBookmarkName());
        soap.setBookmarkId(domain.getBookmarkId());
        soap.setBookmarkName(domain.getBookmarkName());
        soap.setBookmarkTime(domain.getBookmarkTime());
        soap.setCameraCode(domain.getCameraCode());
        soap.setCameraName(domain.getCameraName());
        soap.setMbuDomain(domain.getMbuDomain());
        soap.setNvrCode(domain.getNvrCode());
        soap.setReserve(domain.getReserve());
        soap.setUserDomain(domain.getUserDomain());
        return soap;
    }

    public com.huawei.esdk.ivs.domain.model.bean.TimeSpan getTimeSpanSoap2Model(TimeSpan soap)
    {
        if (null == soap)
        {
            return null;
        }
        com.huawei.esdk.ivs.domain.model.bean.TimeSpan domain = new com.huawei.esdk.ivs.domain.model.bean.TimeSpan();
        domain.setStartTime(soap.getStartTime());
        domain.setEndTime(soap.getEndTime());
        return domain;
    }

    public com.huawei.esdk.ivs.domain.model.bean.IndexRange getIndexRangeSoap2Model(IndexRange soap)
    {
        if (null == soap)
        {
            return null;
        }
        com.huawei.esdk.ivs.domain.model.bean.IndexRange domain =
            new com.huawei.esdk.ivs.domain.model.bean.IndexRange();
        domain.setFromIndex(soap.getFromIndex());
        domain.setToIndex(soap.getToIndex());
        return domain;
    }

    public GetRecordListResponse getRecordInfosModel2Soap(SDKResult<RecordInfoList> result)
    {
        GetRecordListResponse response = new GetRecordListResponse();
        response.setResultCode((int)result.getErrCode());
        RecordInfos recordInfos = getRecordInfosModel2Soap(result.getResult());
        if (null != recordInfos)
        {
            response.setRecordInfos(recordInfos);
        }
        return response;
    }
}
