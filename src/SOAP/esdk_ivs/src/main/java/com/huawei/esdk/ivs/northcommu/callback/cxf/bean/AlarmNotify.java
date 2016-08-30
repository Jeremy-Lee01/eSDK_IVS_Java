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
@XmlType(name = "AlarmNotify", propOrder = {})
public class AlarmNotify
{
    @XmlElement(name = "AlarmEventId")
    private long alarmEventId;
    
    @XmlElement(name = "AlarmInCode")
    private String alarmInCode;
    
    @XmlElement(name = "DevDomainCode")
    private String deviceDomainCode;
    
    @XmlElement(name = "AlarmInType")
    private int alarmInType;
    
    @XmlElement(name = "AlarmInName")
    private String alarmInName;
    
    @XmlElement(name = "AlarmLevelValue")
    private int alarmLevelValue;
    
    @XmlElement(name = "AlarmLevelName")
    private String alarmLevelName;
    
    @XmlElement(name = "AlarmLevelColor")
    private String alarmLevelColor;
    
    @XmlElement(name = "AlarmType")
    private String alarmType;
    
    @XmlElement(name = "AlarmTypeName")
    private String alarmTypeName;
    
    @XmlElement(name = "AlarmCategory")
    private String alarmCategory;
    
    @XmlElement(name = "OccurTime")
    private String occurentTime;
    
    @XmlElement(name = "OccurNumber")
    private int occurentNumber;
    
    @XmlElement(name = "AlarmStatus")
    private int alarmStatus;
    
    @XmlElement(name = "IsCommission")
    private int isCommission;
    
    @XmlElement(name = "PreviewUrl")
    private String previewUrl;
    
    @XmlElement(name = "ExistsRecord")
    private int existsRecord;
    
    @XmlElement(name = "NVRCode")
    private String nvrCode;
    
    @XmlElement(name = "AlarmDesc")
    private String alarmDesc;
    
    @XmlElement(name = "ExtParam")
    private String extParam;
    
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
    
    public String getDeviceDomainCode()
    {
        return deviceDomainCode;
    }
    
    public void setDeviceDomainCode(String deviceDomainCode)
    {
        this.deviceDomainCode = deviceDomainCode;
    }
    
    public int getAlarmInType()
    {
        return alarmInType;
    }
    
    public void setAlarmInType(int alarmInType)
    {
        this.alarmInType = alarmInType;
    }
    
    public String getAlarmInName()
    {
        return alarmInName;
    }
    
    public void setAlarmInName(String alarmInName)
    {
        this.alarmInName = alarmInName;
    }
    
    public int getAlarmLevelValue()
    {
        return alarmLevelValue;
    }
    
    public void setAlarmLevelValue(int alarmLevelValue)
    {
        this.alarmLevelValue = alarmLevelValue;
    }
    
    public String getAlarmLevelName()
    {
        return alarmLevelName;
    }
    
    public void setAlarmLevelName(String alarmLevelName)
    {
        this.alarmLevelName = alarmLevelName;
    }
    
    public String getAlarmLevelColor()
    {
        return alarmLevelColor;
    }
    
    public void setAlarmLevelColor(String alarmLevelColor)
    {
        this.alarmLevelColor = alarmLevelColor;
    }
    
    public String getAlarmType()
    {
        return alarmType;
    }
    
    public void setAlarmType(String alarmType)
    {
        this.alarmType = alarmType;
    }
    
    public String getAlarmTypeName()
    {
        return alarmTypeName;
    }
    
    public void setAlarmTypeName(String alarmTypeName)
    {
        this.alarmTypeName = alarmTypeName;
    }
    
    public String getAlarmCategory()
    {
        return alarmCategory;
    }
    
    public void setAlarmCategory(String alarmCategory)
    {
        this.alarmCategory = alarmCategory;
    }
    
    public String getOccurentTime()
    {
        return occurentTime;
    }
    
    public void setOccurentTime(String occurentTime)
    {
        this.occurentTime = occurentTime;
    }
    
    public int getOccurentNumber()
    {
        return occurentNumber;
    }
    
    public void setOccurentNumber(int occurentNumber)
    {
        this.occurentNumber = occurentNumber;
    }
    
    public int getAlarmStatus()
    {
        return alarmStatus;
    }
    
    public void setAlarmStatus(int alarmStatus)
    {
        this.alarmStatus = alarmStatus;
    }
    
    public int getIsCommission()
    {
        return isCommission;
    }
    
    public void setIsCommission(int isCommission)
    {
        this.isCommission = isCommission;
    }
    
    public String getPreviewUrl()
    {
        return previewUrl;
    }
    
    public void setPreviewUrl(String previewUrl)
    {
        this.previewUrl = previewUrl;
    }
    
    public int getExistsRecord()
    {
        return existsRecord;
    }
    
    public void setExistsRecord(int existsRecord)
    {
        this.existsRecord = existsRecord;
    }
    
    public String getNvrCode()
    {
        return nvrCode;
    }
    
    public void setNvrCode(String nvrCode)
    {
        this.nvrCode = nvrCode;
    }
    
    public String getAlarmDesc()
    {
        return alarmDesc;
    }
    
    public void setAlarmDesc(String alarmDesc)
    {
        this.alarmDesc = alarmDesc;
    }
    
    public String getExtParam()
    {
        return extParam;
    }
    
    public void setExtParam(String extParam)
    {
        this.extParam = extParam;
    }
    
}
