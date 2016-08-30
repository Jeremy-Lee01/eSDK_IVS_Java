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
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import java.util.List;

import com.sun.jna.Structure;

/**
 * 主设备通道信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class DeviceChannelConfigSouth extends Structure
{
    public DeviceChannelConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends DeviceChannelConfigSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends DeviceChannelConfigSouth implements Structure.ByValue
    {
    }
    
    /**
     * 最大视频通道数
     */
    public int maxVideoNum;
    
    /**
     * 最大音频输入通道数
     */
    public int maxAudioInNum;
    
    /**
     * 最大音频输出通道数
     */
    public int maxAudioOutNum;
    
    /**
     * 最大告警输入通道数
     */
    public int maxAlarmInNum;
    
    /**
     * 最大告警输出通道数
     */
    public int maxAlarmOutNum;
    
    /**
     * 最大串口通道数
     */
    public int maxSerialNum;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("maxVideoNum");
        list.add("maxAudioInNum");
        list.add("maxAudioOutNum");
        list.add("maxAlarmInNum");
        list.add("maxAlarmOutNum");
        list.add("maxSerialNum");
        list.add("reserve");
        return list;
    }
}
