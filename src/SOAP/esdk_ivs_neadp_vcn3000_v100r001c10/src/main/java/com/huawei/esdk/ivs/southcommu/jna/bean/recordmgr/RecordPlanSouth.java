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
package com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.sun.jna.Structure;

/**
 * 录像计划
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class RecordPlanSouth extends Structure
{
    public RecordPlanSouth()
    {
        super(Structure.ALIGN_NONE);
        this.clear();
    }
    
    /**
     * 录像存储位置：参考 IVS_RECORD_METHOD
     */
    public int recordMethod;
    
    /**
     * 是否启用录像计划 0-未启用，1-启用
     */
    public int enableRecordPlan;
    
    /**
     * 计划方式：参考 IVS_RECORD_PLAN_TYPE 0-(WEEK)周计划,1(DAY)-日计划，周一到周日计划相同，2-全程录像
     */
    public int recordPlanType;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_64_LEN];
    
    /**
     * 录像计划信息条数：周计划-7，日计划-1，全程录像-0
     */
    public int planInfoNum;
    
    /**
     * 录像计划信息：周计划-最多7个计划信息，日计划-1一个计划信息，全程录像-无
     */
    public PlanInfoSouth[] planInfos = new PlanInfoSouth[CommonConstant.RecordModule.IVS_MAX_PLAN_INFO_NUM];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("recordMethod");
        list.add("enableRecordPlan");
        list.add("recordPlanType");
        list.add("reserve");
        list.add("planInfoNum");
        list.add("planInfos");
        return list;
    }
}
