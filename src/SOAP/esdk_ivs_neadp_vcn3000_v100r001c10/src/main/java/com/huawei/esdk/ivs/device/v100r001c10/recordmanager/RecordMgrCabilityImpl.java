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
package com.huawei.esdk.ivs.device.v100r001c10.recordmanager;

import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.device.BaseCability;
import com.huawei.esdk.ivs.device.v100r001c10.recordmanager.convert.RecordMgrCabilityConvert;
import com.huawei.esdk.ivs.device.vcn3000.recordmanager.IRecordMgrCability;
import com.huawei.esdk.ivs.domain.model.bean.DeviceCode;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RecordInfoList;
import com.huawei.esdk.ivs.domain.model.bean.RecordPlan;
import com.huawei.esdk.ivs.domain.model.bean.TimeSpan;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryUnifiedFormatSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceCodeListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.ResultListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.RecordInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.RecordPlanSouth;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.NumberUtils;

public class RecordMgrCabilityImpl extends BaseCability implements IRecordMgrCability
{
    RecordMgrCabilityConvert recordMgrCabilityConvert = ApplicationContextUtil.getBean("recordMgrCabilityConvert");
    
    private static final int INDEX_RANGE = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("index.range"));
    
    private static final RecordInfoListSouth QUERY_RECORD_INFO_LIST_SOUTH = new RecordInfoListSouth(
    		INDEX_RANGE);
    
    private static final RecordInfoListSouth GET_RECORD_INFO_LIST_SOUTH = new RecordInfoListSouth(
    		INDEX_RANGE);
    
    private static final Logger LOGGER = Logger.getLogger(RecordMgrCabilityImpl.class);
    
    @Override
    public SDKResult<RecordPlan> getRecordPlan(String cameraCode, int recordMethod)
    {
        SDKResult<RecordPlan> result = new SDKResult<RecordPlan>();
        int sessionId = getIVSSessionId();
        RecordPlanSouth recordPlanSouth = new RecordPlanSouth();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetRecordPlan(sessionId,
                cameraCode,
                recordMethod,
                recordPlanSouth.getPointer());
        recordPlanSouth.read();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            RecordPlan recordPlan = recordMgrCabilityConvert.getRecordPlanSouth2Model(recordPlanSouth);
            result.setResult(recordPlan);
        }
        return result;
    }
    
    @Override
    public SDKResult<DeviceOperResultList> deleteRecordPlan(int deviceNum, List<DeviceCode> deviceCodes,
        int recordMethod)
    {
        SDKResult<DeviceOperResultList> result = new SDKResult<DeviceOperResultList>();
        int sessionId = getIVSSessionId();
        DeviceCodeListSouth deviceCodeListSouth =
            recordMgrCabilityConvert.getDeviceCodeListSouthModel2South(deviceCodes);
        ResultListSouth resultListSouth = new ResultListSouth(deviceCodes.size());
        resultListSouth.clear();
        int resultBufferSize = resultListSouth.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_DeleteRecordPlan(sessionId,
                deviceNum,
                deviceCodeListSouth,
                recordMethod,
                resultListSouth.getPointer(),
                resultBufferSize);
        resultListSouth.read();
        result.setErrCode(resultCode);
        if (0 != resultCode)
        {
            DeviceOperResultList domainList =
                recordMgrCabilityConvert.getDeviceOperResultListSouth2Model(resultListSouth);
            result.setResult(domainList);
        }
        return result;
    }
    
    @Override
    public SDKResult<DeviceOperResultList> addRecordPlan(int deviceNum, List<DeviceCode> deviceCodes,
        RecordPlan recordPlan)
    {
        SDKResult<DeviceOperResultList> result = new SDKResult<DeviceOperResultList>();
        int sessionId = getIVSSessionId();
        ResultListSouth resultListSouth = new ResultListSouth(deviceNum);
        int resultBufferSize = resultListSouth.size();
        resultListSouth.getPointer();
        
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_AddRecordPlan(sessionId,
                deviceNum,
                recordMgrCabilityConvert.getDeviceCodeListSouthModel2South(deviceCodes),
                recordMgrCabilityConvert.getRecordPlanModel2South(recordPlan),
                resultListSouth.getPointer(),
                resultBufferSize);
        resultListSouth.read();
        result.setErrCode(resultCode);
        if (0 != resultCode)
        {
            DeviceOperResultList deviceOperResultList =
                recordMgrCabilityConvert.getDeviceOperResultListSouth2Model(resultListSouth);
            result.setResult(deviceOperResultList);
        }
        
        return result;
    }
    
    @Override
    public SDKResult<DeviceOperResultList> modifyRecordPlan(int deviceNum, List<DeviceCode> deviceCodes,
        RecordPlan recordPlan)
    {
        SDKResult<DeviceOperResultList> result = new SDKResult<DeviceOperResultList>();
        int sessionId = getIVSSessionId();
        DeviceCodeListSouth deviceCodeListSouth =
            recordMgrCabilityConvert.getDeviceCodeListSouthModel2South(deviceCodes);
        RecordPlanSouth recordPlanSouth = recordMgrCabilityConvert.getRecordPlanModel2South(recordPlan);
        ResultListSouth resultListSouth = new ResultListSouth(deviceNum);
        int resultBufferSize = resultListSouth.size();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_ModifyRecordPlan(sessionId,
                deviceNum,
                deviceCodeListSouth,
                recordPlanSouth,
                resultListSouth.getPointer(),
                resultBufferSize);
        resultListSouth.read();
        result.setErrCode(resultCode);
        if (0 != resultCode)
        {
            DeviceOperResultList deviceOperResultList =
                recordMgrCabilityConvert.getDeviceOperResultListSouth2Model(resultListSouth);
            result.setResult(deviceOperResultList);
        }
        return result;
    }
    
    /** 
     * 查询录像列表
     * @param queryUnifiedFormat 通用查询结构
     * @return SDKResult<RecordInfoList> 返回录像查询结构列表
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public synchronized SDKResult<RecordInfoList> queryRecordList(QueryUnifiedFormat queryUnifiedFormat)
    {
        LOGGER.info("queryRecordList method start--->>>");
        SDKResult<RecordInfoList> result = new SDKResult<RecordInfoList>();
        int sessionId = getIVSSessionId();
        IndexRange indexRange = queryUnifiedFormat.getIndex();
        
        int size = indexRange.getToIndex() - indexRange.getFromIndex() + 1;
        if (1 > size)
        {
            size = 1;
        }
        
        QueryUnifiedFormatSouth queryUnifiedFormatSouth =
            recordMgrCabilityConvert.getQueryUnifiedFormatModel2South(queryUnifiedFormat);
        //RecordInfoListSouth recordInfoListSouth = new RecordInfoListSouth(size);
        //int bufferSize = recordInfoListSouth.size();
        QUERY_RECORD_INFO_LIST_SOUTH.clear();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_QueryRecordList(sessionId,
                queryUnifiedFormatSouth,
                QUERY_RECORD_INFO_LIST_SOUTH.getPointer(),
                size * 4192 + 44);
        QUERY_RECORD_INFO_LIST_SOUTH.read();
        result.setErrCode(resultCode);
        
        LOGGER.info("queryRecordList method result code:" + resultCode);
        
        RecordInfoList recordInfoList =
            recordMgrCabilityConvert.getRecordInfoListSouth2Model(QUERY_RECORD_INFO_LIST_SOUTH);
        if (null != recordInfoList)
        {
            result.setResult(recordInfoList);
        }
        
        LOGGER.info("queryRecordList method end--->>>");
        
        return result;
    }
    
    /** 
     * 查询录像列表
     * @param cameraCode 摄像机ID
     * @param recordMethod 录像存储位置
     * @param timeSpan 时间段信息
     * @param indexRange 分页信息
     * @return 录像查询结构列表
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public synchronized SDKResult<RecordInfoList> getRecordList(String cameraCode, int recordMethod, TimeSpan timeSpan,
        IndexRange indexRange)
    {
        LOGGER.info("getRecordList method start--->>>");
        SDKResult<RecordInfoList> result = new SDKResult<RecordInfoList>();
        int sessionId = getIVSSessionId();
        int size = indexRange.getToIndex() - indexRange.getFromIndex() + 1;
        if (1 > size)
        {
            size = 1;
        }
        
        // RecordInfoListSouth recordInfoListSouth = new RecordInfoListSouth(size);
        //int bufSize = recordInfoListSouth.size();
        GET_RECORD_INFO_LIST_SOUTH.clear();
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetRecordList(sessionId,
                cameraCode,
                recordMethod,
                recordMgrCabilityConvert.getTimeSpanModel2South(timeSpan),
                recordMgrCabilityConvert.getIndexRangeModel2South(indexRange),
                GET_RECORD_INFO_LIST_SOUTH.getPointer(),
                size * 4192 + 44);
        GET_RECORD_INFO_LIST_SOUTH.read();
        result.setErrCode(resultCode);
        
        LOGGER.info("getRecordList method result code:" + resultCode);
        
        RecordInfoList recordInfoList =
            recordMgrCabilityConvert.getRecordInfoListSouth2Model(GET_RECORD_INFO_LIST_SOUTH);
        if (null != recordInfoList)
        {
            result.setResult(recordInfoList);
        }
        
        LOGGER.info("getRecordList method end--->>>");
        
        return result;
    }
    
}
