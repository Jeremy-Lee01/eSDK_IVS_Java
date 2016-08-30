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
package com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * 南向AlarmNotify对象类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmNotifySouth extends Structure
{
    public static class ByReference extends AlarmNotifySouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends AlarmNotifySouth implements Structure.ByValue
    {
    }
    
    public AlarmNotifySouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public AlarmNotifySouth(Pointer p)
    {
        super(p, Structure.ALIGN_NONE);
    }
    
    /**
     * 告警事件ID
     */
    public long alarmEventId;
    
    /**
     * 告警源编码
     */
    public byte[] alarmInCode = new byte[CommonConstant.AlarmModule.IVS_ALARM_CODE_LEN];
    
    /**
     * 设备所属域编码
     */
    public byte[] deviceDomainCode = new byte[CommonConstant.AlarmModule.IVS_DOMAIN_CODE_LEN];
    
    /**
     * 告警源类型
     */
    public int alarmInType;
    
    /**
     * 告警源名称
     */
    public byte[] alarmInName = new byte[CommonConstant.AlarmModule.IVS_ALARM_NAME_LEN];
    
    /**
     * 告警级别权值,1~100
     */
    public int alarmLevelValue;
    
    /**
     * 告警级别名称,汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符
     */
    public byte[] alarmLevelName = new byte[CommonConstant.AlarmModule.IVS_NAME_LEN];
    
    /**
     * 告警级别颜色,使用颜色字符串表示ARGB,例如#FFFF0000 表示红色，不透明
     */
    public byte[] alarmLevelColor = new byte[CommonConstant.AlarmModule.IVS_ALARM_LEVEL_COLOR_LEN];
    
    /**
     * 告警类型
     */
    public byte[] alarmType = new byte[CommonConstant.AlarmModule.IVS_ALARM_TYPE_LEN];
    
    /**
     * 告警类型名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~64个字符
     */
    public byte[] alarmTypeName = new byte[CommonConstant.AlarmModule.IVS_ALARM_NAME_LEN];
    
    /**
     * 告警类型类别
     */
    public byte[] alarmCategory = new byte[CommonConstant.AlarmModule.IVS_ALARM_CATEGORY_LEN];
    
    /**
     * 告警发生时间：yyyyMMddHHmmss
     */
    public byte[] occurentTime = new byte[CommonConstant.AlarmModule.IVS_TIME_LEN];
    
    /**
     * 告警发生次数
     */
    public int occurentNumber;
    
    /**
     * 告警状态
     */
    public int alarmStatus;
    
    /**
     * 是否为授权告警信息
     */
    public int isCommission;
    
    /**
     * 在存在联动抓拍或者智能分析时的图片预览URL
     */
    public byte[] previewUrl = new byte[CommonConstant.AlarmModule.IVS_URL_LEN];
    
    /**
     * 是否存在告警录像
     */
    public int existsRecord;
    
    /**
     * NVR编码，可用于更新NVR路由
     */
    public byte[] nvrCode = new byte[CommonConstant.AlarmModule.IVS_NVR_CODE_LEN];
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    /**
     * 告警描述信息，键盘可见字符和中文，0~256字符
     */
    public byte[] alarmDesc = new byte[CommonConstant.AlarmModule.IVS_ALARM_DESCRIPTION_LEN];
    
    /**
     * 扩展参数
     */
    public byte[] extParam = new byte[CommonConstant.AlarmModule.IVS_ALARM_EX_PARAM_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("alarmEventId");
        list.add("alarmInCode");
        list.add("deviceDomainCode");
        list.add("alarmInType");
        list.add("alarmInName");
        list.add("alarmLevelValue");
        list.add("alarmLevelName");
        list.add("alarmLevelColor");
        list.add("alarmType");
        list.add("alarmTypeName");
        list.add("alarmCategory");
        list.add("occurentTime");
        list.add("occurentNumber");
        list.add("alarmStatus");
        list.add("isCommission");
        list.add("previewUrl");
        list.add("existsRecord");
        list.add("nvrCode");
        list.add("reserve");
        list.add("alarmDesc");
        list.add("extParam");
        return list;
    }
}
