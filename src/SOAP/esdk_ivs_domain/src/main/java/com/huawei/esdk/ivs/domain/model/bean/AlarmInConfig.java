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

public class AlarmInConfig
{
    private String alarmInName; // 告警输入设备名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符。
    
    private int alarmInChanIndex; // 告警输入通道索引
    
    private int switchType; // 设备开关类型 0-常闭 1-常开 
    
    private int autoClearAlarmTime; // 告警检测时间间隔1-255，单位：秒。默认为120秒，即每隔120秒检测一次是否在告警状态，并上报，数字。
    
    private String reserve;
    
    public String getAlarmInName()
    {
        return alarmInName;
    }
    
    public void setAlarmInName(String alarmInName)
    {
        this.alarmInName = alarmInName;
    }
    
    public int getAlarmInChanIndex()
    {
        return alarmInChanIndex;
    }
    
    public void setAlarmInChanIndex(int alarmInChanIndex)
    {
        this.alarmInChanIndex = alarmInChanIndex;
    }
    
    public int getSwitchType()
    {
        return switchType;
    }
    
    public void setSwitchType(int switchType)
    {
        this.switchType = switchType;
    }
    
    public int getAutoClearAlarmTime()
    {
        return autoClearAlarmTime;
    }
    
    public void setAutoClearAlarmTime(int autoClearAlarmTime)
    {
        this.autoClearAlarmTime = autoClearAlarmTime;
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
