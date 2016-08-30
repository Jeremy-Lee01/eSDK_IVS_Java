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


public class DeviceBriefInfo
{
    protected DeviceBasicInfo deviceBasicInfo;
    
    protected String protocolType;
    
    protected int loginType;
    
    protected int enableSchedule;
    
    protected int status;
    
    protected String reserve;

    public DeviceBasicInfo getDeviceBasicInfo()
    {
        return deviceBasicInfo;
    }

    public void setDeviceBasicInfo(DeviceBasicInfo deviceBasicInfo)
    {
        this.deviceBasicInfo = deviceBasicInfo;
    }

    public String getProtocolType()
    {
        return protocolType;
    }

    public void setProtocolType(String protocolType)
    {
        this.protocolType = protocolType;
    }

    public int getLoginType()
    {
        return loginType;
    }

    public void setLoginType(int loginType)
    {
        this.loginType = loginType;
    }

    public int getEnableSchedule()
    {
        return enableSchedule;
    }

    public void setEnableSchedule(int enableSchedule)
    {
        this.enableSchedule = enableSchedule;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
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
