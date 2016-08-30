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
 * 设备编码
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class DeviceCodeSouth extends Structure
{
    public DeviceCodeSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends DeviceCodeSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends DeviceCodeSouth implements Structure.ByValue
    {
    }
    
    /**
     * 设备编码
     */
    public byte[] deviceCode = new byte[CommonConstant.DeviceModule.IVS_DEV_CODE_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("deviceCode");
        return list;
    }
    
}
