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

public class CameraConfig
{
    private int videoChannel; // 视频输入通道号
    
    private String cameraCode; // 设备编码
    
    private String cameraName; // 摄像机名称
    
    private CameraPosition positionInfo; // 摄像头位置信息
    
    private int supportBroadcast; // 是否支持组播 0: 否 1:是
    
    private BroadCastInfo broadcastInfo; // 组播信息
    
    private int enableVoice; // 随路音频是否启用 0-停用 1-启用
    
    private String voiceOutCode; // 摄像机绑定的音频输出通道，只能为同主设备上的音频输出通道。
    
    // 非用户修改信息
    private String parentCode; // 主设备编码
    
    private String nvrCode; // 设备所属NVR编码, 表示该设备被该NVR管理
    
    private int cameraType; // 摄像机类型 IVS_CAMERA_TYPE
    
    private int cameraStatus; // 摄像机扩展状态：1 – 正常   2 – 视频丢失
    
    private String reserve;

    public int getVideoChannel()
    {
        return videoChannel;
    }

    public void setVideoChannel(int videoChannel)
    {
        this.videoChannel = videoChannel;
    }

    public String getCameraCode()
    {
        return cameraCode;
    }

    public void setCameraCode(String cameraCode)
    {
        this.cameraCode = cameraCode;
    }

    public String getCameraName()
    {
        return cameraName;
    }

    public void setCameraName(String cameraName)
    {
        this.cameraName = cameraName;
    }

    public CameraPosition getPositionInfo()
    {
        return positionInfo;
    }

    public void setPositionInfo(CameraPosition positionInfo)
    {
        this.positionInfo = positionInfo;
    }

    public int getSupportBroadcast()
    {
        return supportBroadcast;
    }

    public void setSupportBroadcast(int supportBroadcast)
    {
        this.supportBroadcast = supportBroadcast;
    }

    public BroadCastInfo getBroadcastInfo()
    {
        return broadcastInfo;
    }

    public void setBroadcastInfo(BroadCastInfo broadcastInfo)
    {
        this.broadcastInfo = broadcastInfo;
    }

    public int getEnableVoice()
    {
        return enableVoice;
    }

    public void setEnableVoice(int enableVoice)
    {
        this.enableVoice = enableVoice;
    }

    public String getVoiceOutCode()
    {
        return voiceOutCode;
    }

    public void setVoiceOutCode(String voiceOutCode)
    {
        this.voiceOutCode = voiceOutCode;
    }

    public String getParentCode()
    {
        return parentCode;
    }

    public void setParentCode(String parentCode)
    {
        this.parentCode = parentCode;
    }

    public String getNvrCode()
    {
        return nvrCode;
    }

    public void setNvrCode(String nvrCode)
    {
        this.nvrCode = nvrCode;
    }

    public int getCameraType()
    {
        return cameraType;
    }

    public void setCameraType(int cameraType)
    {
        this.cameraType = cameraType;
    }

    public int getCameraStatus()
    {
        return cameraStatus;
    }

    public void setCameraStatus(int cameraStatus)
    {
        this.cameraStatus = cameraStatus;
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
