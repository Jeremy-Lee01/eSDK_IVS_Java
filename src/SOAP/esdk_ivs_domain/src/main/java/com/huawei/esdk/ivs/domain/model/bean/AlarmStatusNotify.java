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
 * 告警信息状态通知
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmStatusNotify
{
    /**
     * 告警事件ID
     */
    private long alarmEventId;
    
    /**
     * 告警源编码
     */
    private String alarmInCode;
    
    /**
     * 告警源域编码
     */
    private String devDomainCode;
    
    /**
     * 告警类型
     */
    private String alarmType;
    
    /**
     * 告警发生次数
     */
    public int occurNumber;
    
    /**
     * 告警状态
     */
    private int alarmStatus;
    
    /**
     * 保留字段
     */
    private String reserve;
    
    /**
     * 告警处理信息
     */
    private AlarmOperateInfo operateInfo;
    
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
    
    public AlarmOperateInfo getOperateInfo()
    {
        return operateInfo;
    }
    
    public void setOperateInfo(AlarmOperateInfo operateInfo)
    {
        this.operateInfo = operateInfo;
    }
    
}
