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

/**
 * Domain层视频子设备列表简要信息
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CameraBriefInfo
{
    /**
     * 设备编码
     */
    private String code;
    
    /**
     * 摄像机名称
     */
    private String name;
    
    /**
     * 所属设备组编码
     */
    private String deviceGroupCode;
    
    /**
     * 父设备编码
     */
    private String parentCode;
    
    /**
     * 域编码
     */
    private String domainCode;
    
    /**
     * 主设备型号
     */
    private String deviceModelType;
    
    /**
     * 设备提供商类型: "HUAWEI" "HIK" "DAHUA"
     */
    private String vendorType;
    
    /**
     * 主设备类型：参考 IVS_MAIN_DEVICE_TYPE
     */
    private int deviceFormType;
    
    /**
     * 摄像机类型
     */
    private int type;
    
    /**
     * 摄像机安装位置描述
     */
    private String cameraLocation;
    
    /**
     * 摄像机扩展状态：1 – 正常   2 – 视频丢失
     */
    private int cameraStatus;
    
    /**
     * 设备状态：0-离线，1-在线，2-休眠
     */
    private int status;
    
    /**
     * 网络类型 0-有线  1-无线
     */
    private int netType;
    
    /**
     * 是否支持智能分析  0-不支持 1-支持
     */
    private int isSupportIntelligent;
    
    /**
     * 随路音频是否启用 0-停用 1-启用
     */
    private int enableVoice;
    
    /**
     * 设备所属NVR编码, 表示该设备被该NVR管理
     */
    private String nvrCode;
    
    /**
     * 设备创建时间
     */
    private String deviceCreateTime;
    
    /**
     * 是否为外部域 0-否  1-是
     */
    private int isExDomain;
    
    /**
     * 前端IP
     */
    private String deviceIp;
    
    /**
     * 保留字段
     */
    private String reserve;
    
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
    
    public String getDeviceGroupCode()
    {
        return deviceGroupCode;
    }
    
    public void setDeviceGroupCode(String deviceGroupCode)
    {
        this.deviceGroupCode = deviceGroupCode;
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
    
    public String getDeviceModelType()
    {
        return deviceModelType;
    }
    
    public void setDeviceModelType(String deviceModelType)
    {
        this.deviceModelType = deviceModelType;
    }
    
    public String getVendorType()
    {
        return vendorType;
    }
    
    public void setVendorType(String vendorType)
    {
        this.vendorType = vendorType;
    }
    
    public int getDeviceFormType()
    {
        return deviceFormType;
    }
    
    public void setDeviceFormType(int deviceFormType)
    {
        this.deviceFormType = deviceFormType;
    }
    
    public int getType()
    {
        return type;
    }
    
    public void setType(int type)
    {
        this.type = type;
    }
    
    public String getCameraLocation()
    {
        return cameraLocation;
    }
    
    public void setCameraLocation(String cameraLocation)
    {
        this.cameraLocation = cameraLocation;
    }
    
    public int getCameraStatus()
    {
        return cameraStatus;
    }
    
    public void setCameraStatus(int cameraStatus)
    {
        this.cameraStatus = cameraStatus;
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public int getNetType()
    {
        return netType;
    }
    
    public void setNetType(int netType)
    {
        this.netType = netType;
    }
    
    public int getIsSupportIntelligent()
    {
        return isSupportIntelligent;
    }
    
    public void setIsSupportIntelligent(int isSupportIntelligent)
    {
        this.isSupportIntelligent = isSupportIntelligent;
    }
    
    public int getEnableVoice()
    {
        return enableVoice;
    }
    
    public void setEnableVoice(int enableVoice)
    {
        this.enableVoice = enableVoice;
    }
    
    public String getNvrCode()
    {
        return nvrCode;
    }
    
    public void setNvrCode(String nvrCode)
    {
        this.nvrCode = nvrCode;
    }
    
    public String getDeviceCreateTime()
    {
        return deviceCreateTime;
    }
    
    public void setDeviceCreateTime(String deviceCreateTime)
    {
        this.deviceCreateTime = deviceCreateTime;
    }
    
    public int getIsExDomain()
    {
        return isExDomain;
    }
    
    public void setIsExDomain(int isExDomain)
    {
        this.isExDomain = isExDomain;
    }
    
    public String getDeviceIp()
    {
        return deviceIp;
    }
    
    public void setDeviceIp(String deviceIp)
    {
        this.deviceIp = deviceIp;
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
