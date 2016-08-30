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
package com.huawei.esdk.ivs.professional.local.service.alarmmanager;

import com.huawei.esdk.ivs.professional.local.bean.AlarmCommissionInfo;
import com.huawei.esdk.ivs.professional.local.bean.AlarmEvent;
import com.huawei.esdk.ivs.professional.local.bean.AlarmEventInfos;
import com.huawei.esdk.ivs.professional.local.bean.AlarmLevel;
import com.huawei.esdk.ivs.professional.local.bean.AlarmOperateInfo;
import com.huawei.esdk.ivs.professional.local.bean.AlarmReportInfo;
import com.huawei.esdk.ivs.professional.local.bean.AlarmTypeInfos;
import com.huawei.esdk.ivs.professional.local.bean.GetAlarmLevelListResponse;
import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.professional.local.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.professional.local.impl.autogen.DeviceAlarmEvents;

public interface AlarmManagerServiceEx
{
    
    IVSSDKResponse<AlarmEvent> getAlarmEventInfo(Long alarmEventId, String alarmInCode);
    
    IVSSDKResponse<AlarmEventInfos> getAlarmEventList(QueryUnifiedFormat unifiedQuery);
    
    Integer subscribeAlarm(String requestXML);
    
    IVSSDKResponse<String> subscribeAlarmQuery(String requestXML);

    Integer alarmConfirm(Long alarmEventId, String alarmInCode, AlarmOperateInfo operateInfo);

    Integer alarmCancel(Long alarmEventId, String alarmInCode, AlarmOperateInfo operateInfo);

    Integer alarmCommission(String alarmInCode, AlarmCommissionInfo alarmCommissionInfo);

    Integer alarmReport(AlarmReportInfo alarmReportInfo);

    IVSSDKResponse<String> addAlarmLinkage(String requestXML);

    Integer modifyAlarmLinkage(String requestXML);

    Integer deleteAlarmLinkage(String requestXML);

    IVSSDKResponse<String> getAlarmLinkage(String requestXML);

    IVSSDKResponse<String> getAlarmLinkageList(String requestXML);

    IVSSDKResponse<String> getAlarmLinkageAction(String requestXML);

    Integer startAlarmOut(String alarmOutCode);

    Integer stopAlarmOut(String alarmOutCode);

    Integer userAuthentication(String password);

    IVSSDKResponse<AlarmTypeInfos> getAlarmTypeList(QueryUnifiedFormat unifiedQuery);

    IVSSDKResponse<GetAlarmLevelListResponse> getAlarmLevelList();

    Integer setAlarmTypeLevel(AlarmTypeInfos alarmTypeInfos);

    IVSSDKResponse<AlarmLevel> getAlarmLevel(Integer alarmLevelID);
    
    IVSSDKResponse<String> getAlarmSnapshotList(String requestXML);
    
    IVSSDKResponse<DeviceAlarmEvents> getDeviceAlarmList(QueryUnifiedFormat unifiedQuery);
}
