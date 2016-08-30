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

public class AlarmOutConfig
{
    private String alarmOutName; // 告警输出设备名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符。
    
    private int alarmOutChanIndex; // 告警输出通道索引
    
    private int switchType; // 设备开关类型 0-常闭 1-常开
    
    private int alarmOutMode; // 告警输出模式：0-单稳态，1-双稳态    
    
    private int holdTime; // 延迟时间，1秒~600秒；默认：10秒（单稳态时有效）
    
    private String reserve;
    
    public String getAlarmOutName()
    {
        return alarmOutName;
    }
    
    public void setAlarmOutName(String alarmOutName)
    {
        this.alarmOutName = alarmOutName;
    }
    
    public int getAlarmOutChanIndex()
    {
        return alarmOutChanIndex;
    }
    
    public void setAlarmOutChanIndex(int alarmOutChanIndex)
    {
        this.alarmOutChanIndex = alarmOutChanIndex;
    }
    
    public int getSwitchType()
    {
        return switchType;
    }
    
    public void setSwitchType(int switchType)
    {
        this.switchType = switchType;
    }
    
    public int getAlarmOutMode()
    {
        return alarmOutMode;
    }
    
    public void setAlarmOutMode(int alarmOutMode)
    {
        this.alarmOutMode = alarmOutMode;
    }
    
    public int getHoldTime()
    {
        return holdTime;
    }
    
    public void setHoldTime(int holdTime)
    {
        this.holdTime = holdTime;
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
