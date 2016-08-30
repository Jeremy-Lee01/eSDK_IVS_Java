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
 * 领域层业务告警通知信息
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmNotify
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
     * 设备所属域编码
     */
    private String deviceDomainCode;
    
    /**
     * 告警源类型
     */
    private int alarmInType;
    
    /**
     * 告警源名称
     */
    private String alarmInName;
    
    /**
     * 告警级别权值,1~100
     */
    private int alarmLevelValue;
    
    /**
     * 告警级别名称,汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符
     */
    private String alarmLevelName;
    
    /**
     * 告警级别颜色,使用颜色字符串表示ARGB,例如#FFFF0000 表示红色，不透明
     */
    private String alarmLevelColor;
    
    /**
     * 告警类型
     */
    private String alarmType;
    
    /**
     * 告警类型名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~64个字符
     */
    private String alarmTypeName;
    
    /**
     * 告警类型类别
     */
    private String alarmCategory;
    
    /**
     * 告警发生时间：yyyyMMddHHmmss
     */
    private String occurentTime;
    
    /**
     * 告警发生次数
     */
    private int occurentNumber;
    
    /**
     * 告警状态
     */
    private int alarmStatus;
    
    /**
     * 是否为授权告警信息：0-否，1-是
     */
    private int isCommission;
    
    /**
     * 在存在联动抓拍或者智能分析时的图片预览URL
     */
    private String previewUrl;
    
    /**
     * 是否存在告警录像：0-否，1-是
     */
    private int existsRecord;
    
    /**
     * NVR编码，可用于更新NVR路由
     */
    private String nvrCode;
    
    /**
     * 保留字段
     */
    private String reserve;
    
    /**
     * 告警描述信息，键盘可见字符和中文，0~256字符
     */
    private String alarmDesc;
    
    /**
     * 扩展参数
     */
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
