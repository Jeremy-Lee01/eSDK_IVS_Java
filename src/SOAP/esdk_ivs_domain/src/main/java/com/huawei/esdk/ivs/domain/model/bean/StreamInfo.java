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

public class StreamInfo
{
    private int streamType; // 码流类型：参考 IVS_STREAM_TYPE
    
    private int encodeType; // 编码格式：参考 IVS_VIDEO_DEC_TYPE
    
    private int profile; // 根据uiEncodeType确定，如果是H.264：参考IVS_H264_PROFILE；如果是MJPEG：参考IVS_MJPEG_PROFILE
    
    private int frameInterval; // I帧间隔
    
    private String resolution; // 分辨率，如“177*144”
    
    private int picQuality; // 图像质量 （0-高 1-中 2-低） IVS_IMAGING_QUALITY
    
    private int transProtocol; // 传输协议：参考 IVS_PROTOCOL_TYPE
    
    private int pktProtocol; // 打包协议：参考 IVS_PACK_PROTOCOL_TYPE
    
    private int bitRateType; // 码率类型：参考 IVS_BITRATE_TYPE
    
    private int bitRate; // 码率，单位(kbps)
    
    private int frameRate; // 帧率，单位(fps)，范围1-60
    
    private String reserve;

    public int getStreamType()
    {
        return streamType;
    }

    public void setStreamType(int streamType)
    {
        this.streamType = streamType;
    }

    public int getEncodeType()
    {
        return encodeType;
    }

    public void setEncodeType(int encodeType)
    {
        this.encodeType = encodeType;
    }

    public int getProfile()
    {
        return profile;
    }

    public void setProfile(int profile)
    {
        this.profile = profile;
    }

    public int getFrameInterval()
    {
        return frameInterval;
    }

    public void setFrameInterval(int frameInterval)
    {
        this.frameInterval = frameInterval;
    }

    public String getResolution()
    {
        return resolution;
    }

    public void setResolution(String resolution)
    {
        this.resolution = resolution;
    }

    public int getPicQuality()
    {
        return picQuality;
    }

    public void setPicQuality(int picQuality)
    {
        this.picQuality = picQuality;
    }

    public int getTransProtocol()
    {
        return transProtocol;
    }

    public void setTransProtocol(int transProtocol)
    {
        this.transProtocol = transProtocol;
    }

    public int getPktProtocol()
    {
        return pktProtocol;
    }

    public void setPktProtocol(int pktProtocol)
    {
        this.pktProtocol = pktProtocol;
    }

    public int getBitRateType()
    {
        return bitRateType;
    }

    public void setBitRateType(int bitRateType)
    {
        this.bitRateType = bitRateType;
    }

    public int getBitRate()
    {
        return bitRate;
    }

    public void setBitRate(int bitRate)
    {
        this.bitRate = bitRate;
    }

    public int getFrameRate()
    {
        return frameRate;
    }

    public void setFrameRate(int frameRate)
    {
        this.frameRate = frameRate;
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
