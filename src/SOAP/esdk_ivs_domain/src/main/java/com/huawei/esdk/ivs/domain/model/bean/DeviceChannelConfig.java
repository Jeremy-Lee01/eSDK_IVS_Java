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

public class DeviceChannelConfig
{
    private int maxVideoNum; // 最大视频通道数
    
    private int maxAudioInNum; // 最大音频输入通道数
    
    private int maxAudioOutNum; // 最大音频输出通道数
    
    private int maxAlarmInNum; // 最大告警输入通道数
    
    private int maxAlarmOutNum; // 最大告警输出通道数
    
    private int maxSerialNum; // 最大串口通道数
    
    private String reserve; // 保留字段

    public int getMaxVideoNum()
    {
        return maxVideoNum;
    }

    public void setMaxVideoNum(int maxVideoNum)
    {
        this.maxVideoNum = maxVideoNum;
    }

    public int getMaxAudioInNum()
    {
        return maxAudioInNum;
    }

    public void setMaxAudioInNum(int maxAudioInNum)
    {
        this.maxAudioInNum = maxAudioInNum;
    }

    public int getMaxAudioOutNum()
    {
        return maxAudioOutNum;
    }

    public void setMaxAudioOutNum(int maxAudioOutNum)
    {
        this.maxAudioOutNum = maxAudioOutNum;
    }

    public int getMaxAlarmInNum()
    {
        return maxAlarmInNum;
    }

    public void setMaxAlarmInNum(int maxAlarmInNum)
    {
        this.maxAlarmInNum = maxAlarmInNum;
    }

    public int getMaxAlarmOutNum()
    {
        return maxAlarmOutNum;
    }

    public void setMaxAlarmOutNum(int maxAlarmOutNum)
    {
        this.maxAlarmOutNum = maxAlarmOutNum;
    }

    public int getMaxSerialNum()
    {
        return maxSerialNum;
    }

    public void setMaxSerialNum(int maxSerialNum)
    {
        this.maxSerialNum = maxSerialNum;
    }

    public String getReserve()
    {
        return reserve;
    }

    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
    
}

