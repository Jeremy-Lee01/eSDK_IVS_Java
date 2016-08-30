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

/**
 * Domain层语音设备信息
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AudioBriefInfo
{
    /**
     * 设备组ID
     */
    private int deviceGroupId;
    
    /**
     * 语音通道编码长度
     */
    private String audioCode;
    
    /**
     * 所属域编码
     */
    private String domainCode;
    
    /**
     * 语音通道名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符
     */
    private String audioName;
    
    /**
     * 通道类型 0-语音输入 1-语音输出
     */
    private int channelType;
    
    /**
     * 保留字段
     */
    private String reserve;
    
    public int getDeviceGroupId()
    {
        return deviceGroupId;
    }
    
    public void setDeviceGroupId(int deviceGroupId)
    {
        this.deviceGroupId = deviceGroupId;
    }
    
    public String getAudioCode()
    {
        return audioCode;
    }
    
    public void setAudioCode(String audioCode)
    {
        this.audioCode = audioCode;
    }
    
    public String getDomainCode()
    {
        return domainCode;
    }
    
    public void setDomainCode(String domainCode)
    {
        this.domainCode = domainCode;
    }
    
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
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
    
}
