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
package com.huawei.esdk.ivs.device.vcn3000.recordmanager;

import java.util.List;

import com.huawei.esdk.ivs.domain.model.bean.DeviceCode;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RecordInfoList;
import com.huawei.esdk.ivs.domain.model.bean.RecordPlan;
import com.huawei.esdk.ivs.domain.model.bean.TimeSpan;
import com.huawei.esdk.platform.common.SDKResult;

public interface IRecordMgrCability
{
    public SDKResult<RecordPlan> getRecordPlan(String cameraCode, int recordMethod);
    
    public SDKResult<DeviceOperResultList> deleteRecordPlan(int deviceNum, List<DeviceCode> deviceCodes,
        int recordMethod);
    
    public SDKResult<DeviceOperResultList> addRecordPlan(int deviceNum, List<DeviceCode> deviceCodes,
        RecordPlan recordPlan);
    
    public SDKResult<DeviceOperResultList> modifyRecordPlan(int deviceNum, List<DeviceCode> deviceCodes,
        RecordPlan recordPlan);
    
    /** 
    * 查询录像列表
    * @param queryUnifiedFormat 通用查询结构
    * @return 返回录像查询结构列表
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<RecordInfoList> queryRecordList(QueryUnifiedFormat queryUnifiedFormat);
    
    
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
    public SDKResult<RecordInfoList> getRecordList(String cameraCode, int recordMethod, TimeSpan timeSpan,
        IndexRange indexRange);
    
}
