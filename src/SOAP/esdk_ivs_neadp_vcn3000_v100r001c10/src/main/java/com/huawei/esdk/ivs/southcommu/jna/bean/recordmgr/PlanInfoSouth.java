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
 * 录像管理南向相关bean
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class PlanInfoSouth extends Structure
{
    
    public static class ByReference extends PlanInfoSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends PlanInfoSouth implements Structure.ByValue
    {
    }
    
    public PlanInfoSouth()
    {
        super(Structure.ALIGN_NONE);
        this.clear();
    }
    
    /**
     * 星期几：参考 IVS_DAY_TYPE 0 – 每天 1 – 周一 2 – 周二 3 – 周三 4 – 周四 5 – 周五 6 – 周六 7 – 周日
     */
    public int dayType;
    
    /**
     * 时间段数量
     */
    public int timeSpanInfoNum;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    /**
     * 时间段信息
     */
    public TimeSpanSouth[] timeSpanInfos = new TimeSpanSouth[CommonConstant.RecordModule.IVS_MAX_TIMESPAN_NUM];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("dayType");
        list.add("timeSpanInfoNum");
        list.add("reserve");
        list.add("timeSpanInfos");
        return list;
    }
    
}
