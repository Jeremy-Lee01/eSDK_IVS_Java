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
 * 
 * 媒体流地址
 *
 * @author  zWX144115
 * @see  [相关类/方法]
 * @since  [V100R003]
 */
public class MediaAddress
{
    /**
     * 媒体流目的IP
     */
    private IPInfo dstIP;
    
    /**
     * 媒体流目的音频端口
     */
    private int audioPort;
    
    /**
     * 媒体流目的视频端口
     */
    private int videoPort;
    
    /**
     * 保留字段
     */
    private String reserve; 
    
    public IPInfo getDstIP()
    {
        return dstIP;
    }
    
    public void setDstIP(IPInfo dstIP)
    {
        this.dstIP = dstIP;
    }
    
    public int getAudioPort()
    {
        return audioPort;
    }
    
    public void setAudioPort(int audioPort)
    {
        this.audioPort = audioPort;
    }
    
    public int getVideoPort()
    {
        return videoPort;
    }
    
    public void setVideoPort(int videoPort)
    {
        this.videoPort = videoPort;
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
