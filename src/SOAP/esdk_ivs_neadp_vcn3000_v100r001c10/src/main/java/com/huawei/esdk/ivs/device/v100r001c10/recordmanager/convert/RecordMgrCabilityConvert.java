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
package com.huawei.esdk.ivs.device.v100r001c10.recordmanager.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.device.v100r001c10.alarmmanager.convert.AlarmMgrCabilityConvert;
import com.huawei.esdk.ivs.device.v100r001c10.devicemanager.convert.DeviceMgrCabilityConvert;
import com.huawei.esdk.ivs.domain.model.bean.DeviceCode;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResult;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.PlanInfo;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RecordBookmarkInfo;
import com.huawei.esdk.ivs.domain.model.bean.RecordInfo;
import com.huawei.esdk.ivs.domain.model.bean.RecordInfoList;
import com.huawei.esdk.ivs.domain.model.bean.RecordLockInfo;
import com.huawei.esdk.ivs.domain.model.bean.RecordPTZPresetInfo;
import com.huawei.esdk.ivs.domain.model.bean.RecordPlan;
import com.huawei.esdk.ivs.domain.model.bean.TimeSpan;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.IndexRangeSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryUnifiedFormatSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceCodeListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.ResultInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.ResultListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.PlanInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.RecordBookmarkInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.RecordInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.RecordInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.RecordLockInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.RecordPTZPresetInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.RecordPlanSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.TimeSpanSouth;
import com.huawei.esdk.platform.common.utils.BytesUtils;

public class RecordMgrCabilityConvert
{
    public RecordPlan getRecordPlanSouth2Model(RecordPlanSouth south)
    {
        if (null == south)
        {
            return null;
        }
        RecordPlan domain = new RecordPlan();
        domain.setRecordMethod(south.recordMethod);
        domain.setEnableRecordPlan(south.enableRecordPlan);
        domain.setRecordPlanType(south.recordPlanType);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setPlanInfoNum(south.planInfoNum);
        PlanInfoSouth[] planInfoSouths = south.planInfos;
        if (null != planInfoSouths && planInfoSouths.length > 0 && south.planInfoNum > 0)
        {
            List<PlanInfo> planInfos = new ArrayList<PlanInfo>();
            for (int i = 0, length = south.planInfoNum; i < length; i++)
            {
                PlanInfo planInfo = getPlanInfoSouth2Model(planInfoSouths[i]);
                if (null != planInfo)
                {
                    planInfos.add(planInfo);
                }
            }
            if (planInfos.size() > 0)
            {
                domain.setPlanInfos(planInfos);
            }
        }
        return domain;
    }
    
    public PlanInfo getPlanInfoSouth2Model(PlanInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        PlanInfo planInfo = new PlanInfo();
        planInfo.setDayType(south.dayType);
        planInfo.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        planInfo.setTimeSpanInfoNum(south.timeSpanInfoNum);
        TimeSpanSouth[] timeSpanSouths = south.timeSpanInfos;
        if (null != timeSpanSouths && timeSpanSouths.length > 0 && south.timeSpanInfoNum > 0)
        {
            List<TimeSpan> timeSpanInfos = new ArrayList<TimeSpan>();
            for (int i = 0, length = south.timeSpanInfoNum; i < length; i++)
            {
                TimeSpan timeSpan = getTimeSpanSouth2Model(timeSpanSouths[i]);
                if (null != timeSpan)
                {
                    timeSpanInfos.add(timeSpan);
                }
            }
            if (timeSpanInfos.size() > 0)
            {
                planInfo.setTimeSpanInfos(timeSpanInfos);
            }
        }
        return planInfo;
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
    
    public DeviceCodeListSouth getDeviceCodeListSouthModel2South(List<DeviceCode> deviceCodes)
    {
        return new DeviceMgrCabilityConvert().getDeviceCodeListSouthModel2South(deviceCodes);
    }
    
    public DeviceOperResultList getDeviceOperResultListSouth2Model(ResultListSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceOperResultList domainList = new DeviceOperResultList();
        domainList.setNum(south.number);
        
        ResultInfoSouth[] resultInfoSouths = south.resultInfoSouths;
        if (null != resultInfoSouths && resultInfoSouths.length > 0 && south.number > 0)
        {
            List<DeviceOperResult> deviceOperResults = new ArrayList<DeviceOperResult>();
            for (int i = 0, length = south.number; i < length; i++)
            {
                DeviceOperResult deviceOperResult = getDeviceOperResultSouth2Model(resultInfoSouths[i]);
                if (null != deviceOperResult)
                {
                    deviceOperResults.add(deviceOperResult);
                }
            }
            if (deviceOperResults.size() > 0)
            {
                domainList.setDeviceOperResults(deviceOperResults);
            }
        }
        return domainList;
    }
    
    public DeviceOperResult getDeviceOperResultSouth2Model(ResultInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        DeviceOperResult domain = new DeviceOperResult();
        domain.setSequence(south.sequence);
        domain.setResult(south.result);
        domain.setCode(BytesUtils.bytesToStringForIVS(south.code));
        return domain;
    }
    
    public RecordPlanSouth getRecordPlanModel2South(RecordPlan recordPlanDomain)
    {
        RecordPlanSouth recordPlanSouth = null;
        
        if (null != recordPlanDomain)
        {
            //领域的计划时间信息
            List<PlanInfo> planInfoDomains = recordPlanDomain.getPlanInfos();
            recordPlanSouth = new RecordPlanSouth();
            recordPlanSouth.clear();
            
            recordPlanSouth.recordMethod = recordPlanDomain.getRecordMethod();
            recordPlanSouth.enableRecordPlan = recordPlanDomain.getEnableRecordPlan();
            recordPlanSouth.recordPlanType = recordPlanDomain.getRecordPlanType();
            if (null != recordPlanDomain.getReserve())
            {
                recordPlanSouth.reserve = BytesUtils.stringToBytesForIVS(recordPlanDomain.getReserve());
            }
            recordPlanSouth.planInfoNum = recordPlanDomain.getPlanInfoNum();
            
            if (null != planInfoDomains && 0 < planInfoDomains.size())
            {
                PlanInfoSouth[] planInfoSouths = recordPlanSouth.planInfos;
                List<TimeSpan> timeSpanDomains = null;
                
                //根据领域的RecordPlan中PlanInfo转换为南向RecordPlanSouth中的PlanInfo
                for (int i = 0; i < planInfoDomains.size(); i++)
                {
                    planInfoSouths[i] = new PlanInfoSouth();
                    planInfoSouths[i].dayType = planInfoDomains.get(i).getDayType();
                    planInfoSouths[i].timeSpanInfoNum = planInfoDomains.get(i).getTimeSpanInfoNum();
                    planInfoSouths[i].reserve = BytesUtils.stringToBytesForIVS(planInfoDomains.get(i).getReserve());
                    
                    timeSpanDomains = planInfoDomains.get(i).getTimeSpanInfos();
                    if (null != timeSpanDomains && 0 < timeSpanDomains.size())
                    {
                        for (int j = 0; j < timeSpanDomains.size(); j++)
                        {
                            planInfoSouths[i].timeSpanInfos[j] = new TimeSpanSouth();
                            planInfoSouths[i].timeSpanInfos[j].clear();
                            planInfoSouths[i].timeSpanInfos[j].start =
                                BytesUtils.stringToBytesForIVS(timeSpanDomains.get(j).getStartTime());
                            planInfoSouths[i].timeSpanInfos[j].end =
                                BytesUtils.stringToBytesForIVS(timeSpanDomains.get(j).getEndTime());
                        }
                    }
                }
            }
            
            return recordPlanSouth;
        }
        
        return null;
    }
    
    /** 
     * 领域层的QueryUnifiedFormat转换为南向的
     *
     * @param queryUnifiedFormat 查询通用格式
     * @return QueryUnifiedFormatSouth 南向查询通用格式
     * @since  eSDK IVS V100R003C00
     */
    public QueryUnifiedFormatSouth getQueryUnifiedFormatModel2South(QueryUnifiedFormat queryUnifiedFormat)
    {
        return new AlarmMgrCabilityConvert().getQueryUnifiedFormatSoap2Model(queryUnifiedFormat);
    }
    
    /** 
    * 南向录像信息列表转换为领域层对象
    * @param recordInfoListSouth 南向录像信息列表
    * @return 领域层录像信息列表
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public RecordInfoList getRecordInfoListSouth2Model(RecordInfoListSouth south)
    {
        if (null == south)
        {
            return null;
        }
        RecordInfoList domain = new RecordInfoList();
        domain.setTotal(south.total);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        IndexRange indexRangeDomain = getIndexRangeSouth2Model(south.indexRange);
        if (null != indexRangeDomain)
        {
            domain.setIndexRange(indexRangeDomain);
        }
        List<RecordInfo> recordInfos = null;
        RecordInfoSouth[] recordInfoSouths = south.recordInfos;
        int length = 0;
        if (null != recordInfoSouths && null != indexRangeDomain)
        {
            
            length =
                getLength(south.total, recordInfoSouths.length, south.indexRange.fromIndex, south.indexRange.toIndex);
            
        }
        if (0 < length)
        {
            recordInfos = new ArrayList<RecordInfo>();
            for (int i = 0; i < length; i++)
            {
                RecordInfo recordInfoDomain = getRecordInfoSouth2Model(recordInfoSouths[i]);
                if (null != recordInfoDomain)
                {
                    recordInfos.add(recordInfoDomain);
                }
            }
            domain.setRecordInfos(recordInfos);
        }
        return domain;
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
    
    private RecordInfo getRecordInfoSouth2Model(RecordInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        RecordInfo domain = new RecordInfo();
        domain.setAlarmType(BytesUtils.bytesToStringForIVS(south.alarmType));
        
        RecordBookmarkInfo bookmarkInfoDomain = getRecordBookmarkInfoSouth2Model(south.bookmarkInfo);
        if (null != bookmarkInfoDomain)
        {
            domain.setBookmarkInfo(bookmarkInfoDomain);
        }
        
        domain.setFrameExtractionTimes(south.frameExtractionTimes);
        
        RecordLockInfo lockInfoDomain = getRecordLockInfoSouth2Model(south.lockInfo);
        if (null != lockInfoDomain)
        {
            domain.setLockInfo(lockInfoDomain);
        }
        
        domain.setMbuDomain(BytesUtils.bytesToStringForIVS(south.mbuDomain));
        domain.setNvrCode(BytesUtils.bytesToStringForIVS(south.nvrCode));
        
        RecordPTZPresetInfo ptzPresetInfoDomain = getRecordPTZPresetInfoSouth2Model(south.ptzPresetInfo);
        if (null != ptzPresetInfoDomain)
        {
            domain.setPtzPresetInfo(ptzPresetInfoDomain);
        }
        
        domain.setRecordFileName(BytesUtils.bytesToStringForIVS(south.recordFileName));
        domain.setRecordMethod(south.recordMethod);
        domain.setRecordType(south.recordType);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        
        TimeSpan timeSpan = getTimeSpanSouth2Model(south.timeSpan);
        if (null != timeSpan)
        {
            domain.setTimeSpan(timeSpan);
        }
        
        return domain;
    }
    
    private RecordPTZPresetInfo getRecordPTZPresetInfoSouth2Model(RecordPTZPresetInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        RecordPTZPresetInfo domain = new RecordPTZPresetInfo();
        domain.setId(south.id);
        domain.setName(BytesUtils.bytesToStringForIVS(south.name));
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
    
    private RecordLockInfo getRecordLockInfoSouth2Model(RecordLockInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        RecordLockInfo domain = new RecordLockInfo();
        domain.setLockDesc(BytesUtils.bytesToStringForIVS(south.lockDesc));
        domain.setLockId(south.lockId);
        domain.setLockTime(BytesUtils.bytesToStringForIVS(south.lockTime));
        
        TimeSpan lockTimeSpanDomain = getTimeSpanSouth2Model(south.lockTimeSpan);
        if (null != lockTimeSpanDomain)
        {
            domain.setLockTimeSpan(lockTimeSpanDomain);
        }
        
        domain.setOperatorId(south.operatorId);
        domain.setOperatorName(BytesUtils.bytesToStringForIVS(south.operatorName));
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
    
    private RecordBookmarkInfo getRecordBookmarkInfoSouth2Model(RecordBookmarkInfoSouth south)
    {
        if (null == south)
        {
            return null;
        }
        RecordBookmarkInfo domain = new RecordBookmarkInfo();
        domain.setBookmarkCreatorId(south.bookmarkCreatorId);
        domain.setBookmarkCreatorName(BytesUtils.bytesToStringForIVS(south.bookmarkCreatorName));
        domain.setBookmarkId(south.bookmarkId);
        domain.setBookmarkName(BytesUtils.bytesToStringForIVS(south.bookmarkName));
        domain.setBookmarkTime(BytesUtils.bytesToStringForIVS(south.bookmarkTime));
        domain.setCameraCode(BytesUtils.bytesToStringForIVS(south.cameraCode));
        domain.setCameraName(BytesUtils.bytesToStringForIVS(south.cameraName));
        domain.setMbuDomain(BytesUtils.bytesToStringForIVS(south.mbuDomain));
        domain.setNvrCode(BytesUtils.bytesToStringForIVS(south.nvrCode));
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setUserDomain(BytesUtils.bytesToStringForIVS(south.userDomain));
        return domain;
    }
    
    public IndexRange getIndexRangeSouth2Model(IndexRangeSouth south)
    {
        if (null == south)
        {
            return null;
        }
        IndexRange domain = new IndexRange();
        domain.setFromIndex(south.fromIndex);
        domain.setToIndex(south.toIndex);
        return domain;
    }
    
    public TimeSpanSouth getTimeSpanModel2South(TimeSpan domain)
    {
        TimeSpanSouth south = new TimeSpanSouth();
        south.start = BytesUtils.stringToBytesForIVS(domain.getStartTime());
        south.end = BytesUtils.stringToBytesForIVS(domain.getEndTime());
        return south;
    }
    
    public com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.IndexRangeSouth getIndexRangeModel2South(IndexRange domain)
    {
        com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.IndexRangeSouth south =
            new com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.IndexRangeSouth();
        south.fromIndex = domain.getFromIndex();
        south.toIndex = domain.getToIndex();
        return south;
    }
}
