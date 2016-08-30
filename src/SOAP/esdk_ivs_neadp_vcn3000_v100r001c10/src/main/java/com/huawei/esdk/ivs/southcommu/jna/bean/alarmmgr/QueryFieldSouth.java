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
import com.sun.jna.Structure;

/**
 * 查询的结构体
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class QueryFieldSouth extends Structure
{
    public static class ByReference extends QueryFieldSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends QueryFieldSouth implements Structure.ByValue
    {
    }
    
    public QueryFieldSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    /**
     * 查询字段类型
     */
    public int field;
    
    /**
     * 字段的值
     */
    public byte[] value = new byte[CommonConstant.IVS_QUERY_VALUE_LEN];
    
    /**
     * 是否精确查询：0-否，1-是
     */
    public int exactQuery;
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("field");
        list.add("value");
        list.add("exactQuery");
        return list;
    }
    
}
