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
 * <告警类型
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  [eSDK IVS V100R003C10]
 */
public class AlarmTypeInfo
{
    /**
     * 告警类型ID
     */
    private int alarmTypeID;
    
    /**
     * 告警类型编码
     */
    private String alarmTypeCode;
    
    /**
     * 告警类型名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~64个字符
     */
    private String alarmTypeName;
    
    /**
     * 告警源类型 IVS_ALARM_IN_TYPE
     */
    private int alarmInType;
    
    /**
     * 告警类型类别
     */
    private String category;
    
    /**
     * 是否为用户自定义 0-否，表示“系统定义” 1-是
     */
    private int isUserDefined;
    
    /**
     * 告警级别
     */
    private AlarmLevel alarmLevel;
    
    /**
     * 是否启用 0-否 1-是
     */
    private int enable;
    
    /**
     * 保留字段
     */
    private String reserve;
    
    public int getAlarmTypeID()
    {
        return alarmTypeID;
    }
    
    public void setAlarmTypeID(int alarmTypeID)
    {
        this.alarmTypeID = alarmTypeID;
    }
    
    public String getAlarmTypeCode()
    {
        return alarmTypeCode;
    }
    
    public void setAlarmTypeCode(String alarmTypeCode)
    {
        this.alarmTypeCode = alarmTypeCode;
    }
    
    public String getAlarmTypeName()
    {
        return alarmTypeName;
    }
    
    public void setAlarmTypeName(String alarmTypeName)
    {
        this.alarmTypeName = alarmTypeName;
    }
    
    public int getAlarmInType()
    {
        return alarmInType;
    }
    
    public void setAlarmInType(int alarmInType)
    {
        this.alarmInType = alarmInType;
    }
    
    public String getCategory()
    {
        return category;
    }
    
    public void setCategory(String category)
    {
        this.category = category;
    }
    
    public int getIsUserDefined()
    {
        return isUserDefined;
    }
    
    public void setIsUserDefined(int isUserDefined)
    {
        this.isUserDefined = isUserDefined;
    }
    
    public AlarmLevel getAlarmLevel()
    {
        return alarmLevel;
    }
    
    public void setAlarmLevel(AlarmLevel alarmLevel)
    {
        this.alarmLevel = alarmLevel;
    }
    
    public int getEnable()
    {
        return enable;
    }
    
    public void setEnable(int enable)
    {
        this.enable = enable;
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
