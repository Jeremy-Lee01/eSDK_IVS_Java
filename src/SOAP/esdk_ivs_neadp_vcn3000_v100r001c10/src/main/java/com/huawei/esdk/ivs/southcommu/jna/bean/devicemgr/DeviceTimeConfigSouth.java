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
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import java.util.List;

import com.sun.jna.Structure;

/**
 * 主设备时间参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class DeviceTimeConfigSouth extends Structure
{
    public DeviceTimeConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends DeviceTimeConfigSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends DeviceTimeConfigSouth implements Structure.ByValue
    {
    }
    
    /**
     * 是否启用NTP同步：0-不启用（手动设置时间），1-启用（自动同步时间）
     */
    public int enableNtp;
    
    /**
     * NTP信息(单独接口实现) 时间参数（当bEnableNtp值为1，自动同步时间时有效）
     */
    public NTPInfoSouth stNTP;
    
    /**
     * 设备所在时区，以时区偏移量记录-50400~50400秒 （当bEnableNtp值为0，手动设置时间时有效）
     */
    public int timezone;
    
    /**
     * 是否启用夏令时 0:不启用,1:启用 （当bEnableNtp值为0，手动设置时间时有效）
     */
    public int enableDst;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("enableNtp");
        list.add("stNTP");
        list.add("timezone");
        list.add("enableDst");
        list.add("reserve");
        return list;
    }
    
}
