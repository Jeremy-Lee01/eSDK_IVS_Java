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
package com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * 告警信息状态通知
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmStatusNotifySouth extends Structure
{
    
    public AlarmStatusNotifySouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public AlarmStatusNotifySouth(Pointer p)
    {
        super(p, Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends AlarmStatusNotifySouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends AlarmStatusNotifySouth implements Structure.ByValue
    {
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
     * 告警源域编码
     */
    public byte[] devDomainCode = new byte[CommonConstant.AlarmModule.IVS_DOMAIN_CODE_LEN];
    
    /**
     * 告警类型
     */
    public byte[] alarmType = new byte[CommonConstant.AlarmModule.IVS_ALARM_TYPE_LEN];
    
    /**
     * 告警发生次数
     */
    public int occurNumber;
    
    /**
     * 告警状态
     */
    public int alarmStatus;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    /**
     * 告警处理信息
     */
    public AlarmOperateInfoSouth operateInfo;
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("alarmEventId");
        list.add("alarmInCode");
        list.add("devDomainCode");
        list.add("alarmType");
        list.add("occurNumber");
        list.add("alarmStatus");
        list.add("reserve");
        list.add("operateInfo");
        return list;
    }
    
}
