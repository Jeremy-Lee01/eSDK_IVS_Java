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

public class NTPInfo
{
    private int ntpType; // NTP同步方式：0-DHCP，1-手动指定服务器
    
    private IPInfo ntpServerIP; // NTP服务器IP，当NTP同步方式uiNtpType为1时有效
    
    private IPInfo dnsIP; // DNS地址，当NTP同步方式uiNtpType为1时有效
    
    private String reserve;

    public int getNtpType()
    {
        return ntpType;
    }

    public void setNtpType(int ntpType)
    {
        this.ntpType = ntpType;
    }

    public IPInfo getNtpServerIP()
    {
        return ntpServerIP;
    }

    public void setNtpServerIP(IPInfo ntpServerIP)
    {
        this.ntpServerIP = ntpServerIP;
    }

    public IPInfo getDnsIP()
    {
        return dnsIP;
    }

    public void setDnsIP(IPInfo dnsIP)
    {
        this.dnsIP = dnsIP;
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
