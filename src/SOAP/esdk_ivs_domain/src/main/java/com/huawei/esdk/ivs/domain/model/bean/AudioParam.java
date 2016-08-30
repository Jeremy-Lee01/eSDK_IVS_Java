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

public class AudioParam
{
    private int pitch; // 定调
    
    private int volume; // 声道
    
    private int inputType; // 输入类型
    
    private int dataFormat; // 数据格式，参考 IVS_PAYLOAD_TYPE
    
    private int sampleRate; // 采样率
    
    private int channel; // 频道
    
    private int gain; // 增益
    
    private int sampleBits; // 比特率
    
    private String reserve;
    
    public int getPitch()
    {
        return pitch;
    }
    
    public void setPitch(int pitch)
    {
        this.pitch = pitch;
    }
    
    public int getVolume()
    {
        return volume;
    }
    
    public void setVolume(int volume)
    {
        this.volume = volume;
    }
    
    public int getInputType()
    {
        return inputType;
    }
    
    public void setInputType(int inputType)
    {
        this.inputType = inputType;
    }
    
    public int getDataFormat()
    {
        return dataFormat;
    }
    
    public void setDataFormat(int dataFormat)
    {
        this.dataFormat = dataFormat;
    }
    
    public int getSampleRate()
    {
        return sampleRate;
    }
    
    public void setSampleRate(int sampleRate)
    {
        this.sampleRate = sampleRate;
    }
    
    public int getChannel()
    {
        return channel;
    }
    
    public void setChannel(int channel)
    {
        this.channel = channel;
    }
    
    public int getGain()
    {
        return gain;
    }
    
    public void setGain(int gain)
    {
        this.gain = gain;
    }
    
    public int getSampleBits()
    {
        return sampleBits;
    }
    
    public void setSampleBits(int sampleBits)
    {
        this.sampleBits = sampleBits;
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
