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

import com.sun.jna.Structure;

/**
 * 排序的结构体
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class OrderConditionSouth extends Structure
{
    public static class ByReference extends OrderConditionSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends OrderConditionSouth implements Structure.ByValue
    {
    }
    
    public OrderConditionSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    /**
     * 是否启用排序 0 - 不排序 1 - 排序
     */
    public int enableOrder;
    
    /**
     * 排序的字段
     */
    public int field;
    
    /**
     * 是否升序：0-降序，1-升序
     */
    public int isAscend;
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("enableOrder");
        list.add("field");
        list.add("isAscend");
        return list;
    }
    
}
