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
 * Domain层告警设备信息
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmBriefInfo
{
    /**
     * 所属设备组编码
     */
    private String deviceGroupCode;
    
    /**
     * 告警设备编码
     */
    private String alarmCode;
    
    /**
     * 所属域编码
     */
    private String domainCode;
    
    /**
     * 语音通道名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符
     */
    private String alarmName;
    
    /**
     * 通道类型 0-告警输入 1-告警输出
     */
    private int channelType;
    
    /**
     * 主设备编码
     */
    private String parentCode;
    
    /**
     * 是否为外部域 0-否  1-是
     */
    private int isExDomain;
    
    /**
     * 保留字段
     */
    private String reserve;
    
    public String getDeviceGroupCode()
    {
        return deviceGroupCode;
    }
    
    public void setDeviceGroupCode(String deviceGroupCode)
    {
        this.deviceGroupCode = deviceGroupCode;
    }
    
    public String getDomainCode()
    {
        return domainCode;
    }
    
    public void setDomainCode(String domainCode)
    {
        this.domainCode = domainCode;
    }
    
    public String getAlarmName()
    {
        return alarmName;
    }
    
    public void setAlarmName(String alarmName)
    {
        this.alarmName = alarmName;
    }
    
    public int getChannelType()
    {
        return channelType;
    }
    
    public void setChannelType(int channelType)
    {
        this.channelType = channelType;
    }
    
    public String getParentCode()
    {
        return parentCode;
    }
    
    public void setParentCode(String parentCode)
    {
        this.parentCode = parentCode;
    }
    
    public int getIsExDomain()
    {
        return isExDomain;
    }
    
    public void setIsExDomain(int isExDomain)
    {
        this.isExDomain = isExDomain;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
    
    public String getAlarmCode()
    {
        return alarmCode;
    }
    
    public void setAlarmCode(String alarmCode)
    {
        this.alarmCode = alarmCode;
    }
    
}
