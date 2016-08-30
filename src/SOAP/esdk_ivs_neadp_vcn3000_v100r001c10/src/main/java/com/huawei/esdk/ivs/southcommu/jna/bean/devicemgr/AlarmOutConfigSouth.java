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
 * 告警输出子设备
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmOutConfigSouth extends Structure
{
    public AlarmOutConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends AlarmOutConfigSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends AlarmOutConfigSouth implements Structure.ByValue
    {
    }
    
    /**
     * 告警输出设备名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符
     */
    public byte[] alarmOutName = new byte[CommonConstant.DeviceModule.IVS_ALARM_OUT_NAME_LEN];
    
    /**
     * 告警输出通道索引
     */
    public int alarmOutChanIndex;
    
    /**
     * 设备开关类型 0-常闭 1-常开
     */
    public int switchType;
    
    /**
     * 告警输出模式：0-单稳态，1-双稳态
     */
    public int alarmOutMode;
    
    /**
     * 延迟时间，1秒~600秒；默认：10秒（单稳态时有效）
     */
    public int holdTime;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("alarmOutName");
        list.add("alarmOutChanIndex");
        list.add("switchType");
        list.add("alarmOutMode");
        list.add("holdTime");
        list.add("reserve");
        return list;
    }
    
}
