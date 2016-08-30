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
import com.sun.jna.Structure;

/**
 * 南向AlarmOperateInfo对象类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmOperateInfoSouth extends Structure
{
    
    public static class ByReference extends AlarmOperateInfoSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends AlarmOperateInfoSouth implements Structure.ByValue
    {
    }
    
    public AlarmOperateInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    /**
     * 处理人ID
     */
    public int operatorId;
    
    /**
     * 处理人名
     */
    public byte[] operatorName = new byte[CommonConstant.AlarmModule.IVS_NAME_LEN];
    
    /**
     * 告警处理时间
     */
    public byte[] operateTime = new byte[CommonConstant.AlarmModule.IVS_TIME_LEN];
    
    /**
     * 保留字段
     */
    public byte[] reserver = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    /**
     * 告警处理人员输入的信息
     */
    public byte[] operateInfo = new byte[CommonConstant.AlarmModule.IVS_ALARM_DESCRIPTION_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("operatorId");
        list.add("operatorName");
        list.add("operateTime");
        list.add("reserver");
        list.add("operateInfo");
        return list;
    }
    
}
