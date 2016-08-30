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
 * 告警上报信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmReportSouth extends Structure
{
    public AlarmReportSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public AlarmReportSouth(Pointer p)
    {
        super(p, Structure.ALIGN_NONE);
    }
    
    /**
     * 告警源编码
     */
    public byte[] alarmInCode = new byte[CommonConstant.AlarmModule.IVS_ALARM_CODE_LEN];
    
    /**
     * 设备所属域编码
     */
    public byte[] devDomainCode = new byte[CommonConstant.AlarmModule.IVS_DOMAIN_CODE_LEN];
    
    /**
     * 告警源类型 英文字符串
     */
    public byte[] alarmType = new byte[CommonConstant.AlarmModule.IVS_ALARM_TYPE_LEN];
    
    /**
     * 告警发生时间：yyyyMMddHHmmss
     */
    public byte[] occurTime = new byte[CommonConstant.AlarmModule.IVS_TIME_LEN];
    
    /**
     * 告警上报时间：yyyyMMddHHmmss
     */
    public byte[] reportTime = new byte[CommonConstant.AlarmModule.IVS_TIME_LEN];
    
    /**
     * 0-告警消除 1-告警
     */
    public int action;
    
    /**
     * 告警ID，“告警消除”与“告警”时的告警ID相同
     */
    public byte[] alarmID = new byte[CommonConstant.AlarmModule.IVS_ALARM_REPORT_ID_LEN];
    
    /**
     * 告警发生次数，默认值1
     */
    public int occurNumber;
    
    /**
     *  NVR编码，可用于更新NVR路由
     */
    public byte[] nvrCode = new byte[CommonConstant.AlarmModule.IVS_NVR_CODE_LEN];
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    /**
     * 告警描述信息，键盘可见字符和中文，1024字节
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
        list.add("alarmInCode");
        list.add("devDomainCode");
        list.add("alarmType");
        list.add("occurTime");
        list.add("reportTime");
        list.add("action");
        list.add("alarmID");
        list.add("occurNumber");
        list.add("nvrCode");
        list.add("reserve");
        list.add("alarmDesc");
        list.add("extParam");
        return list;
    }
    
}
