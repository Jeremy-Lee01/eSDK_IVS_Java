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

public class DeviceNetConfig
{
    private IPInfo puIp; // 前端IP
    
    private IPInfo puGateway; // 前端网关(onvif设备)
    
    private int puPort; // 设备端口
    
    private int maxMtu; // 最大MTU值
    
    private IPInfo subNetMask; // 子网掩码
    
    private String reserve;

    public IPInfo getPuIp()
    {
        return puIp;
    }

    public void setPuIp(IPInfo puIp)
    {
        this.puIp = puIp;
    }

    public IPInfo getPuGateway()
    {
        return puGateway;
    }

    public void setPuGateway(IPInfo puGateway)
    {
        this.puGateway = puGateway;
    }

    public int getPuPort()
    {
        return puPort;
    }

    public void setPuPort(int puPort)
    {
        this.puPort = puPort;
    }

    public int getMaxMtu()
    {
        return maxMtu;
    }

    public void setMaxMtu(int maxMtu)
    {
        this.maxMtu = maxMtu;
    }

    public IPInfo getSubNetMask()
    {
        return subNetMask;
    }

    public void setSubNetMask(IPInfo subNetMask)
    {
        this.subNetMask = subNetMask;
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

