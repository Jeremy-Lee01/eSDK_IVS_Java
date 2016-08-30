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
package com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.IndexRangeSouth;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * 南向告警事件列表
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmEventListSouth extends Structure
{
    public AlarmEventListSouth(Pointer p)
    {
        super(p, Structure.ALIGN_NONE);
    }
    
    public AlarmEventListSouth(int size)
    {
        super(Structure.ALIGN_NONE);
        this.alarmEventSouth = new AlarmEventSouth[size];
    }
    
    /**
     * 总条目
     */
    public int total;
    
    /**
     * 分页信息
     */
    public IndexRangeSouth indexRange;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    /**
     * 告警事件信息
     */
    public AlarmEventSouth[] alarmEventSouth = null;
    
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("total");
        list.add("indexRange");
        list.add("reserve");
        list.add("alarmEventSouth");
        return list;
    }
}
