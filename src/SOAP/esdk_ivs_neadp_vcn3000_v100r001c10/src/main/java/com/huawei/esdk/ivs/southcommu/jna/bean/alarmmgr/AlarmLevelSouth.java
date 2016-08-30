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
 * 告警级别
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  [eSDK IVS V100R003C10]
 */
public class AlarmLevelSouth extends Structure
{
    public static class ByReference extends AlarmLevelSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends AlarmLevelSouth implements Structure.ByValue
    {
    }
    
    public AlarmLevelSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public AlarmLevelSouth(Pointer p)
    {
        super(p, Structure.ALIGN_NONE);
    }
    
    /**
     * 告警级别ID
     */
    public int alarmLevelId;
    
    /**
     * 告警级别名称,汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符
     */
    public byte[] name = new byte[CommonConstant.AlarmModule.IVS_NAME_LEN];
    
    /**
     * 告警级别权值,1~100
     */
    public int value;
    
    /**
     * 告警级别颜色,使用颜色字符串表示ARGB,例如#FFFF0000 表示红色，不透明
     */
    public byte[] color = new byte[CommonConstant.AlarmModule.IVS_ALARM_LEVEL_COLOR_16];
    
    /**
     * 告警级别描述,键盘可见字符和中文，0~256个字符
     */
    public byte[] description = new byte[CommonConstant.AlarmModule.IVS_ALARM_DESCRIPTION_LEN];
    
    /**
     * 是否为用户自定义 0-否，表示“系统定义” 1-是
     */
    public int isUserDefined;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("alarmLevelId");
        list.add("name");
        list.add("value");
        list.add("color");
        list.add("description");
        list.add("isUserDefined");
        list.add("reserve");
        return list;
    }
    
}
