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
import com.sun.jna.Structure;

/**
 * 告警设备信息
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmBriefInfoSouth extends Structure
{
    public static class ByReference extends AlarmBriefInfoSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends AlarmBriefInfoSouth implements Structure.ByValue
    {
    }
    
    public AlarmBriefInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    /**
     * 所属设备组编码
     */
    public byte[] deviceGroupCode = new byte[CommonConstant.DeviceModule.IVS_DEVICE_GROUP_LEN];
    
    /**
     * 告警设备编码
     */
    public byte[] alarmCode = new byte[CommonConstant.DeviceModule.IVS_DEV_CODE_LEN];
    
    /**
     * 所属域编码
     */
    public byte[] domainCode = new byte[CommonConstant.DeviceModule.IVS_DOMAIN_CODE_LEN];
    
    /**
     * 语音通道名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符
     */
    public byte[] alarmName = new byte[CommonConstant.DeviceModule.IVS_ALARM_IN_NAME_LEN];
    
    /**
     * 通道类型 0-告警输入 1-告警输出
     */
    public int channelType;
    
    /**
     * 主设备编码
     */
    public byte[] parentCode = new byte[CommonConstant.DeviceModule.IVS_DEV_CODE_LEN];
    
    /**
     * 是否为外部域 0-否  1-是
     */
    public int isExDomain;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("deviceGroupCode");
        list.add("alarmCode");
        list.add("domainCode");
        list.add("alarmName");
        list.add("channelType");
        list.add("parentCode");
        list.add("isExDomain");
        list.add("reserve");
        return list;
    }
    
}
