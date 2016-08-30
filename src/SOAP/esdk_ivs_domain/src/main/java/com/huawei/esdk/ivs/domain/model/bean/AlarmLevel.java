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
 * 告警级别
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  [eSDK IVS V100R003C10]
 */
public class AlarmLevel
{
    /**
     * 告警级别ID
     */
    private int alarmLevelId;
    
    /**
     * 告警级别名称,汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符
     */
    private String alarmLevelName;
    
    /**
     * 告警级别权值,1~100
     */
    private int value;
    
    /**
     * 告警级别颜色,使用颜色字符串表示ARGB,例如#FFFF0000 表示红色，不透明
     */
    private String color;
    
    /**
     * 告警级别描述,键盘可见字符和中文，0~256个字符
     */
    private String description;
    
    /**
     * 是否为用户自定义 0-否，表示“系统定义” 1-是
     */
    private int isUserDefined;
    
    /**
     * 保留字段
     */
    private String reserve;
    
    public int getAlarmLevelId()
    {
        return alarmLevelId;
    }
    
    public void setAlarmLevelId(int alarmLevelId)
    {
        this.alarmLevelId = alarmLevelId;
    }
    
    public String getAlarmLevelName()
    {
        return alarmLevelName;
    }
    
    public void setAlarmLevelName(String alarmLevelName)
    {
        this.alarmLevelName = alarmLevelName;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public void setValue(int value)
    {
        this.value = value;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public int getIsUserDefined()
    {
        return isUserDefined;
    }
    
    public void setIsUserDefined(int isUserDefined)
    {
        this.isUserDefined = isUserDefined;
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
