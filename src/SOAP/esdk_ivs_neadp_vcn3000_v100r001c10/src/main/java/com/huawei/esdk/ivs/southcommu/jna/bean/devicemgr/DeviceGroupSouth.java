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

public class DeviceGroupSouth extends Structure
{
    public DeviceGroupSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public DeviceGroupSouth(Pointer p)
    {
        super(p, Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends DeviceGroupSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends DeviceGroupSouth implements Structure.ByValue
    {
    }
    
    /**
     * 设备组编码
     */
    public byte[] groupCode = new byte[CommonConstant.DeviceModule.IVS_DEVICE_GROUP_LEN];
    
    /**
     * 设备组名称
     */
    public byte[] groupName = new byte[CommonConstant.DeviceModule.IVS_NAME_LEN];
    
    /**
     * 父设备组编码
     */
    public byte[] parentGroupCode = new byte[CommonConstant.DeviceModule.IVS_DEVICE_GROUP_LEN];
    
    /**
     * 域编码
     */
    public byte[] domainCode = new byte[CommonConstant.DeviceModule.IVS_DOMAIN_CODE_LEN];
    
    /**
     * 是否外部域设备/组   0：否，1：是
     */
    public int isExDomain;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("groupCode");
        list.add("groupName");
        list.add("parentGroupCode");
        list.add("domainCode");
        list.add("isExDomain");
        list.add("reserve");
        return list;
    }
    
}
