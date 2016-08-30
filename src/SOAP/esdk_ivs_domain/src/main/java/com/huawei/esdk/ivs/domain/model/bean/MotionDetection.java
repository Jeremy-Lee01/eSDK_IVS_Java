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

import java.util.List;

public class MotionDetection
{
    private int motionDetectionEnable; // 设备运动检测告警使能 0-停用运动检测 1-启用运动检测
    
    private int platformMotionDetection; // 平台运动检测告警使能 0-停用运动检测 1-启用运动检测
    
    private int detectInterval; // 运动监测的时间间隔，在该间隔内的运动都作为同一个运动，取值范围：1~30秒 单位:秒 默认为：10秒
    
    private int sensitivity; // 运动监测的灵敏度，共分5级：1-5，数字越高表示灵敏度越高
    
    private int autoClearAlarmTime; // 告警检测时间间隔1-255，单位：秒。默认为120秒，即每隔120秒检测一次是否在告警状态，并上报
    
    private int rectNum; // 有效区域信息的个数
    
    private List<RectFloat> rectDetections; // 运动检测区域列表
    
    private String reserve;

    public int getMotionDetectionEnable()
    {
        return motionDetectionEnable;
    }

    public void setMotionDetectionEnable(int motionDetectionEnable)
    {
        this.motionDetectionEnable = motionDetectionEnable;
    }

    public int getPlatformMotionDetection()
    {
        return platformMotionDetection;
    }

    public void setPlatformMotionDetection(int platformMotionDetection)
    {
        this.platformMotionDetection = platformMotionDetection;
    }

    public int getDetectInterval()
    {
        return detectInterval;
    }

    public void setDetectInterval(int detectInterval)
    {
        this.detectInterval = detectInterval;
    }

    public int getSensitivity()
    {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity)
    {
        this.sensitivity = sensitivity;
    }

    public int getAutoClearAlarmTime()
    {
        return autoClearAlarmTime;
    }

    public void setAutoClearAlarmTime(int autoClearAlarmTime)
    {
        this.autoClearAlarmTime = autoClearAlarmTime;
    }

    public int getRectNum()
    {
        return rectNum;
    }

    public void setRectNum(int rectNum)
    {
        this.rectNum = rectNum;
    }

    public List<RectFloat> getRectDetections()
    {
        return rectDetections;
    }

    public void setRectDetections(List<RectFloat> rectDetections)
    {
        this.rectDetections = rectDetections;
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
