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

public class DeviceTimeConfig
{
    private int enableNtp; // 是否启用NTP同步：0-不启用（手动设置时间），1-启用（自动同步时间）
    
    private NTPInfo ntp; // NTP信息(单独接口实现) 时间参数（当bEnableNtp值为1，自动同步时间时有效）
    
    private int timezone; // 设备所在时区，以时区偏移量记录-50400~50400秒 （当bEnableNtp值为0，手动设置时间时有效）
    
    private int enableDst; // 是否启用夏令时 0:不启用,1:启用 （当bEnableNtp值为0，手动设置时间时有效）
    
    private String reserve; // 保留字段

    public int getEnableNtp()
    {
        return enableNtp;
    }

    public void setEnableNtp(int enableNtp)
    {
        this.enableNtp = enableNtp;
    }

    public NTPInfo getNtp()
    {
        return ntp;
    }

    public void setNtp(NTPInfo ntp)
    {
        this.ntp = ntp;
    }

    public int getTimezone()
    {
        return timezone;
    }

    public void setTimezone(int timezone)
    {
        this.timezone = timezone;
    }

    public int getEnableDst()
    {
        return enableDst;
    }

    public void setEnableDst(int enableDst)
    {
        this.enableDst = enableDst;
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
