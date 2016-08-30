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

public class PlanInfo
{
    private int dayType;
    
    private int timeSpanInfoNum;
    
    private String reserve;
    
    private List<TimeSpan> timeSpanInfos;
    
    public int getDayType()
    {
        return dayType;
    }
    
    public void setDayType(int dayType)
    {
        this.dayType = dayType;
    }
    
    public int getTimeSpanInfoNum()
    {
        return timeSpanInfoNum;
    }
    
    public void setTimeSpanInfoNum(int timeSpanInfoNum)
    {
        this.timeSpanInfoNum = timeSpanInfoNum;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
    
    public List<TimeSpan> getTimeSpanInfos()
    {
        return timeSpanInfos;
    }
    
    public void setTimeSpanInfos(List<TimeSpan> timeSpanInfos)
    {
        this.timeSpanInfos = timeSpanInfos;
    }
}
