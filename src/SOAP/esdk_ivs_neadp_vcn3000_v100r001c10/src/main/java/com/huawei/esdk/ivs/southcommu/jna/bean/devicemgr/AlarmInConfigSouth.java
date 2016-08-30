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
package com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.sun.jna.Structure;

/**
 * 告警输入子设备
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmInConfigSouth extends Structure
{
    
    public AlarmInConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends AlarmInConfigSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends AlarmInConfigSouth implements Structure.ByValue
    {
    }
    
    /**
     * 告警输入设备名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符
     */
    public byte[] alarmInName = new byte[CommonConstant.DeviceModule.IVS_ALARM_IN_NAME_LEN];
    
    /**
     * 告警输入通道索引
     */
    public int alarmInChanIndex;
    
    /**
     * 设备开关类型 0-常闭 1-常开 
     */
    public int switchType;
    
    /**
     * 告警检测时间间隔1-255，单位：秒。默认为120秒，即每隔120秒检测一次是否在告警状态，并上报，数字
     */
    public int autoClearAlarmTime;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("alarmInName");
        list.add("alarmInChanIndex");
        list.add("switchType");
        list.add("autoClearAlarmTime");
        list.add("reserve");
        return list;
    }
    
}
