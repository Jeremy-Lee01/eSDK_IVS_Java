/**
 * Copyright 2016 Huawei Technologies Co., Ltd. All rights reserved.
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

public class MediaURLParam
{
    
    private int serviceType;
    
    private int packProtocolType;
    
    private TimeSpan timeSpan;
    
    private String fileName;
    
    private int clientType;
    
    private int streamType;
    
    private int protocolType;
    
    private int transMode;
    
    private int broadCastType;
    
    private int videoDecType;
    
    private int audioDecType;
    
    private String nvrCode;
    
    private String reserve;
    
    public int getServiceType()
    {
        return serviceType;
    }
    
    public void setServiceType(int serviceType)
    {
        this.serviceType = serviceType;
    }
    
    public int getPackProtocolType()
    {
        return packProtocolType;
    }
    
    public void setPackProtocolType(int packProtocolType)
    {
        this.packProtocolType = packProtocolType;
    }
    
    public TimeSpan getTimeSpan()
    {
        return timeSpan;
    }
    
    public void setTimeSpan(TimeSpan timeSpan)
    {
        this.timeSpan = timeSpan;
    }
    
    public String getFileName()
    {
        return fileName;
    }
    
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    public int getClientType()
    {
        return clientType;
    }
    
    public void setClientType(int clientType)
    {
        this.clientType = clientType;
    }
    
    public int getStreamType()
    {
        return streamType;
    }
    
    public void setStreamType(int streamType)
    {
        this.streamType = streamType;
    }
    
    public int getProtocolType()
    {
        return protocolType;
    }
    
    public void setProtocolType(int protocolType)
    {
        this.protocolType = protocolType;
    }
    
    public int getTransMode()
    {
        return transMode;
    }
    
    public void setTransMode(int transMode)
    {
        this.transMode = transMode;
    }
    
    public int getBroadCastType()
    {
        return broadCastType;
    }
    
    public void setBroadCastType(int broadCastType)
    {
        this.broadCastType = broadCastType;
    }
    
    public int getVideoDecType()
    {
        return videoDecType;
    }
    
    public void setVideoDecType(int videoDecType)
    {
        this.videoDecType = videoDecType;
    }
    
    public int getAudioDecType()
    {
        return audioDecType;
    }
    
    public void setAudioDecType(int audioDecType)
    {
        this.audioDecType = audioDecType;
    }
    
    public String getNvrCode()
    {
        return nvrCode;
    }
    
    public void setNvrCode(String nvrCode)
    {
        this.nvrCode = nvrCode;
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