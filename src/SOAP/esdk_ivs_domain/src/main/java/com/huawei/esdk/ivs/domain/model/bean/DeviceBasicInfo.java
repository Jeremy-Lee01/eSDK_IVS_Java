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

public class DeviceBasicInfo
{
    private int type; // 主设备类型：参考 IVS_MAIN_DEVICE_TYPE
    
    private String serialNumber; // 序列号(SN/IMEI)
    
    private String code; // 设备编码
    
    private String name; // 设备名称
    
    private String parentCode; // 父设备编码，如果不为空，表示通过eNVR接入
    
    private String domainCode; // 域编码
    
    private String vendorType; // 设备提供商类型: "HUAWEI" "HIK"
    
    private String model; // 设备型号
    
    private IPInfo ipInfo; // 设备IP信息
    
    private int port; // 设备连接端口
    
    private String reserve;

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getParentCode()
    {
        return parentCode;
    }

    public void setParentCode(String parentCode)
    {
        this.parentCode = parentCode;
    }

    public String getDomainCode()
    {
        return domainCode;
    }

    public void setDomainCode(String domainCode)
    {
        this.domainCode = domainCode;
    }

    public String getVendorType()
    {
        return vendorType;
    }

    public void setVendorType(String vendorType)
    {
        this.vendorType = vendorType;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public IPInfo getIpInfo()
    {
        return ipInfo;
    }

    public void setIpInfo(IPInfo ipInfo)
    {
        this.ipInfo = ipInfo;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
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
