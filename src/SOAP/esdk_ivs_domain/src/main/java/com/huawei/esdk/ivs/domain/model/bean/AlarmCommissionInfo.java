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
package com.huawei.esdk.ivs.domain.model.bean;

import java.util.List;

public class AlarmCommissionInfo
{
    private long alarmEventId;
    
    private int userNum;
    
    private List<UserIdInfo> userIdInfos;
    
    public long getAlarmEventId()
    {
        return alarmEventId;
    }
    
    public void setAlarmEventId(long alarmEventId)
    {
        this.alarmEventId = alarmEventId;
    }
    
    public int getUserNum()
    {
        return userNum;
    }
    
    public void setUserNum(int userNum)
    {
        this.userNum = userNum;
    }
    
    public List<UserIdInfo> getUserIdInfos()
    {
        return userIdInfos;
    }
    
    public void setUserIdInfos(List<UserIdInfo> userIdInfos)
    {
        this.userIdInfos = userIdInfos;
    }
    
}
