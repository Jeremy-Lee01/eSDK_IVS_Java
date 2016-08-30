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

public class Exposure
{
    private int exposureMode; // 曝光模式 0-自动；1-手动
    
    private int exposurePriority; // 曝光优先模式 0-低噪优先；1-帧率优先
    
    private RectFloat rectWindow; // 曝光窗口
    
    private int exposureTime; // 曝光时间（单位微秒us）
    
    private int exposureGain; // 曝光增益（单位dB）
    
    private int exposureIris; // 光圈
    
    private String reserve; // 保留字段

    public int getExposureMode()
    {
        return exposureMode;
    }

    public void setExposureMode(int exposureMode)
    {
        this.exposureMode = exposureMode;
    }

    public int getExposurePriority()
    {
        return exposurePriority;
    }

    public void setExposurePriority(int exposurePriority)
    {
        this.exposurePriority = exposurePriority;
    }

    public RectFloat getRectWindow()
    {
        return rectWindow;
    }

    public void setRectWindow(RectFloat rectWindow)
    {
        this.rectWindow = rectWindow;
    }

    public int getExposureTime()
    {
        return exposureTime;
    }

    public void setExposureTime(int exposureTime)
    {
        this.exposureTime = exposureTime;
    }

    public int getExposureGain()
    {
        return exposureGain;
    }

    public void setExposureGain(int exposureGain)
    {
        this.exposureGain = exposureGain;
    }

    public int getExposureIris()
    {
        return exposureIris;
    }

    public void setExposureIris(int exposureIris)
    {
        this.exposureIris = exposureIris;
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
