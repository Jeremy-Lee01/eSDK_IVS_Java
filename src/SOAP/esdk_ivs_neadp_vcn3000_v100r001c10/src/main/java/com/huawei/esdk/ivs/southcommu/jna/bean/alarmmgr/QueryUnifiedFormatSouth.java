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
 * 查询通用格式
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class QueryUnifiedFormatSouth extends Structure
{
    public QueryUnifiedFormatSouth(int size)
    {
        super(Structure.ALIGN_NONE);
        this.queryFieldSouth = new QueryFieldSouth[size];
    }
    
    /**
     * 分页信息
     */
    public IndexRangeSouth indexRangeSouth;
    
    /**
     * 排序条件
     */
    public OrderConditionSouth orderConditionSouth;
    
    /**
     * 字段的数量，为0表示无查询限制条件
     */
    public int fieldNum;
    
    /**
     * 查询的结构体
     */
    public QueryFieldSouth[] queryFieldSouth = null;
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("indexRangeSouth");
        list.add("orderConditionSouth");
        list.add("fieldNum");
        list.add("queryFieldSouth");
        return list;
    }
    
}
