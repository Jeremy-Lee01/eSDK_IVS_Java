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

public class RecordPlan
{
    private int recordMethod;
    
    private int enableRecordPlan;
    
    private int recordPlanType;
    
    private String reserve;
    
    private int planInfoNum;
    
    private List<PlanInfo> planInfos;
    
    public int getRecordMethod()
    {
        return recordMethod;
    }
    
    public void setRecordMethod(int recordMethod)
    {
        this.recordMethod = recordMethod;
    }
    
    public int getEnableRecordPlan()
    {
        return enableRecordPlan;
    }
    
    public void setEnableRecordPlan(int enableRecordPlan)
    {
        this.enableRecordPlan = enableRecordPlan;
    }
    
    public int getRecordPlanType()
    {
        return recordPlanType;
    }
    
    public void setRecordPlanType(int recordPlanType)
    {
        this.recordPlanType = recordPlanType;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
    
    public int getPlanInfoNum()
    {
        return planInfoNum;
    }
    
    public void setPlanInfoNum(int planInfoNum)
    {
        this.planInfoNum = planInfoNum;
    }
    
    public List<PlanInfo> getPlanInfos()
    {
        return planInfos;
    }
    
    public void setPlanInfos(List<PlanInfo> planInfos)
    {
        this.planInfos = planInfos;
    }
    
}
