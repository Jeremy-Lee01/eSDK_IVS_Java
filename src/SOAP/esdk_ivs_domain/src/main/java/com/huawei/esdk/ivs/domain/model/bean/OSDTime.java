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

public class OSDTime
{
    private int enableOSDTime; // 是否显示时间：0-不显示，1-显示
    
    private int timeFormat; // 时间显示格式：？1: XXXX-XX-XX XX:XX:XX(如2009-09-09 09:09:09), 2: XXXX年XX月XX日 XX :XX :XX(2009年09月09日 09 :09 :09；3: UTC时间
    
    private float timeX; // 时间X坐标，以左上角为原点
    
    private float timeY; // 时间Y坐标，以左上角为原点
    
    private String reserve; // 保留字段

    public int getEnableOSDTime()
    {
        return enableOSDTime;
    }

    public void setEnableOSDTime(int enableOSDTime)
    {
        this.enableOSDTime = enableOSDTime;
    }

    public int getTimeFormat()
    {
        return timeFormat;
    }

    public void setTimeFormat(int timeFormat)
    {
        this.timeFormat = timeFormat;
    }

    public float getTimeX()
    {
        return timeX;
    }

    public void setTimeX(float timeX)
    {
        this.timeX = timeX;
    }

    public float getTimeY()
    {
        return timeY;
    }

    public void setTimeY(float timeY)
    {
        this.timeY = timeY;
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
