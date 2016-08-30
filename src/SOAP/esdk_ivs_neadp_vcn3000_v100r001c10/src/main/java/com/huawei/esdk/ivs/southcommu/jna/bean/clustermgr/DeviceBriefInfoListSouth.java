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
package com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.huawei.esdk.ivs.domain.model.CommonConstant;

/**
 * 主设备列表信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class DeviceBriefInfoListSouth extends Structure
{
    
    public static class ByReference extends DeviceBriefInfoListSouth implements Structure.ByReference
    {
        public ByReference(int size)
        {
            super(size);
        }
    }
    
    public static class ByValue extends DeviceBriefInfoListSouth implements Structure.ByValue
    {
        public ByValue(int size)
        {
            super(size);
        }
    }
    
    /**
     * 总记录数
     */
    public int total;
    
    /**
     * 分页信息
     */
    public IndexRangeSouth indexRange;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    /**
     * 主设备列表信息
     */
    public DeviceBriefInfoSouth[] deviceBriefInfo = null;
    
    public DeviceBriefInfoListSouth(Pointer pointer)
    {
        super(pointer, Structure.ALIGN_NONE);
    }
    
    public DeviceBriefInfoListSouth(int size)
    {
        super(Structure.ALIGN_NONE);
        this.deviceBriefInfo = new DeviceBriefInfoSouth[size];
    }
    
    public DeviceBriefInfoListSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("total");
        list.add("indexRange");
        list.add("reserve");
        list.add("deviceBriefInfo");
        return list;
    }
}
