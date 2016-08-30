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
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * <告警类型
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  [eSDK IVS V100R003C10]
 */
public class AlarmTypeSouth extends Structure
{
    public static class ByReference extends AlarmTypeSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends AlarmTypeSouth implements Structure.ByValue
    {
    }
    
    public AlarmTypeSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public AlarmTypeSouth(Pointer p)
    {
        super(p, Structure.ALIGN_NONE);
    }
    
    /**
     * 告警类型ID
     */
    public int id;
    
    /**
     * 告警类型编码
     */
    public byte[] type = new byte[CommonConstant.AlarmModule.IVS_ALARM_CODE_LEN];
    
    /**
     * 告警类型名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~64个字符
     */
    public byte[] name = new byte[CommonConstant.AlarmModule.IVS_ALARM_NAME_LEN];
    
    /**
     * 告警源类型 IVS_ALARM_IN_TYPE
     */
    public int alarmInType;
    
    /**
     * 告警类型类别
     */
    public byte[] category = new byte[CommonConstant.AlarmModule.IVS_ALARM_TYPE_CATEGORY_LEN];
    
    /**
     * 是否为用户自定义 0-否，表示“系统定义” 1-是
     */
    public int isUserDefined;
    
    /**
     * 告警级别
     */
    public AlarmLevelSouth alarmLevel;
    
    /**
     * 是否启用 0-否 1-是
     */
    public int enable;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("id");
        list.add("type");
        list.add("name");
        list.add("alarmInType");
        list.add("category");
        list.add("isUserDefined");
        list.add("alarmLevel");
        list.add("enable");
        list.add("reserve");
        return list;
    }
    
}
