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
package com.huawei.esdk.ivs.northcommu.callback.cxf.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Content")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {})
public class AlarmStatusNotify
{
    @XmlElement(name = "AlarmEventId")
    private long alarmEventId;
    
    @XmlElement(name = "AlarmInCode")
    private String alarmInCode;
    
    @XmlElement(name = "DevDomainCode")
    private String devDomainCode;
    
    @XmlElement(name = "AlarmType")
    private String alarmType;
    
    @XmlElement(name = "OccurNumber")
    private int occurNumber;
    
    @XmlElement(name = "AlarmStatus")
    private int alarmStatus;
    
    @XmlElement(name = "Reserve")
    private String reserve;
    
    @XmlElement(name = "AlarmOperateInfo")
    private AlarmOperateInfo alarmOperateInfo;
    
    public long getAlarmEventId()
    {
        return alarmEventId;
    }
    
    public void setAlarmEventId(long alarmEventId)
    {
        this.alarmEventId = alarmEventId;
    }
    
    public String getAlarmInCode()
    {
        return alarmInCode;
    }
    
    public void setAlarmInCode(String alarmInCode)
    {
        this.alarmInCode = alarmInCode;
    }
    
    public String getDevDomainCode()
    {
        return devDomainCode;
    }
    
    public void setDevDomainCode(String devDomainCode)
    {
        this.devDomainCode = devDomainCode;
    }
    
    public String getAlarmType()
    {
        return alarmType;
    }
    
    public void setAlarmType(String alarmType)
    {
        this.alarmType = alarmType;
    }
    
    public int getOccurNumber()
    {
        return occurNumber;
    }
    
    public void setOccurNumber(int occurNumber)
    {
        this.occurNumber = occurNumber;
    }
    
    public int getAlarmStatus()
    {
        return alarmStatus;
    }
    
    public void setAlarmStatus(int alarmStatus)
    {
        this.alarmStatus = alarmStatus;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
    
    public AlarmOperateInfo getAlarmOperateInfo()
    {
        return alarmOperateInfo;
    }
    
    public void setAlarmOperateInfo(AlarmOperateInfo alarmOperateInfo)
    {
        this.alarmOperateInfo = alarmOperateInfo;
    }
    
}
