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

public class AudioConfig
{
    private String audioName; // 语音通道名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符。
    
    private int channelType; // 通道类型 0-语音输入 1-语音输出
    
    private int audioIndex; // 语音通道索引，正整数。
    
    private AudioParam audioParam; // 音频参数
    
    private String reserve;
    
    public String getAudioName()
    {
        return audioName;
    }
    
    public void setAudioName(String audioName)
    {
        this.audioName = audioName;
    }
    
    public int getChannelType()
    {
        return channelType;
    }
    
    public void setChannelType(int channelType)
    {
        this.channelType = channelType;
    }
    
    public int getAudioIndex()
    {
        return audioIndex;
    }
    
    public void setAudioIndex(int audioIndex)
    {
        this.audioIndex = audioIndex;
    }
    
    public AudioParam getAudioParam()
    {
        return audioParam;
    }
    
    public void setAudioParam(AudioParam audioParam)
    {
        this.audioParam = audioParam;
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
