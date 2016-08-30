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
package com.huawei.esdk.ivs.professional.local.service.recordmanager;

import com.huawei.esdk.ivs.professional.local.bean.DeviceCodeList;
import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.professional.local.bean.IndexRange;
import com.huawei.esdk.ivs.professional.local.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.professional.local.bean.RecordInfos;
import com.huawei.esdk.ivs.professional.local.bean.RecordPlan;
import com.huawei.esdk.ivs.professional.local.bean.ResultInfos;
import com.huawei.esdk.ivs.professional.local.bean.TimeSpan;

public interface RecordManagerServiceEx
{

    IVSSDKResponse<ResultInfos> modifyRecordPlan(Integer deviceNum, DeviceCodeList deviceCodes, RecordPlan recordPlan);

    IVSSDKResponse<RecordPlan> getRecordPlan(String cameraCode, Integer recordMethod);

    IVSSDKResponse<ResultInfos> deleteRecordPlan(Integer deviceNum, DeviceCodeList deviceCodes, Integer recordMethod);

    IVSSDKResponse<ResultInfos> addRecordPlan(Integer deviceNum, DeviceCodeList deviceCodes, RecordPlan recordPlan);

    IVSSDKResponse<RecordInfos> getRecordList(String cameraCode, Integer recordMethod, TimeSpan timeSpan,
        IndexRange indexRange);

    IVSSDKResponse<RecordInfos> queryRecordList(QueryUnifiedFormat queryFormat);
    
}
