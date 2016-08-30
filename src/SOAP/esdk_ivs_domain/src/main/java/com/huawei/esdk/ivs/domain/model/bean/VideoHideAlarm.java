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

public class VideoHideAlarm
{
    private int enableVideoHide; // 0-关闭视频遮挡告警，1-启用视频遮挡告警
    
    private int sensitivity; // 图像遮挡监测的灵敏度，共分5级：1-5，数字越高表示灵敏度越高
    
    private int autoClearAlarmTime; // 告警检测时间间隔1-255，单位：秒。默认为120秒，即每隔120秒检测一次是否在告警状态，并上报
    
    private int guardTimeNum; // 实际告警时间个数
    
    private List<TimeSpan> guardTimes;// 视频遮挡布防时间段
    
    private int areaNum; // 实际设置的图像遮挡告警区域个数
    
    private List<RectFloat> rectAreas; // 图像遮挡告警区域数组
    
    private String reserve;

    public int getEnableVideoHide()
    {
        return enableVideoHide;
    }

    public void setEnableVideoHide(int enableVideoHide)
    {
        this.enableVideoHide = enableVideoHide;
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

    public int getGuardTimeNum()
    {
        return guardTimeNum;
    }

    public void setGuardTimeNum(int guardTimeNum)
    {
        this.guardTimeNum = guardTimeNum;
    }

    public List<TimeSpan> getGuardTimes()
    {
        return guardTimes;
    }

    public void setGuardTimes(List<TimeSpan> guardTimes)
    {
        this.guardTimes = guardTimes;
    }

    public int getAreaNum()
    {
        return areaNum;
    }

    public void setAreaNum(int areaNum)
    {
        this.areaNum = areaNum;
    }

    public List<RectFloat> getRectAreas()
    {
        return rectAreas;
    }

    public void setRectAreas(List<RectFloat> rectAreas)
    {
        this.rectAreas = rectAreas;
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
