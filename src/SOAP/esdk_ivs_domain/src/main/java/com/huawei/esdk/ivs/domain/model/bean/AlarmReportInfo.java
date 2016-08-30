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

public class AlarmReportInfo
{
    private String alarmInCode;
    
    private String deviceDomainCode;
    
    private String alarmType;
    
    private String occurTime;
    
    private String reportTime;
    
    private int action;
    
    private String alarmId;
    
    private int occurNumber;
    
    private String nvrCode;
    
    private String reserve;
    
    private String alarmDesc;
    
    private String extParam;
    
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
    
    public String getAlarmType()
    {
        return alarmType;
    }
    
    public void setAlarmType(String alarmType)
    {
        this.alarmType = alarmType;
    }
    
    public String getOccurTime()
    {
        return occurTime;
    }
    
    public void setOccurTime(String occurTime)
    {
        this.occurTime = occurTime;
    }
    
    public String getReportTime()
    {
        return reportTime;
    }
    
    public void setReportTime(String reportTime)
    {
        this.reportTime = reportTime;
    }
    
    public int getAction()
    {
        return action;
    }
    
    public void setAction(int action)
    {
        this.action = action;
    }
    
    public String getAlarmId()
    {
        return alarmId;
    }
    
    public void setAlarmId(String alarmId)
    {
        this.alarmId = alarmId;
    }
    
    public int getOccurNumber()
    {
        return occurNumber;
    }
    
    public void setOccurNumber(int occurNumber)
    {
        this.occurNumber = occurNumber;
    }
    
    public String getNvrCode()
    {
        return nvrCode;
    }
    
    public void setNvrCode(String nvrCode)
    {
        this.nvrCode = nvrCode;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
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
