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
package com.huawei.esdk.ivs.domain.model.bean;

import java.util.List;

/**
 * 领域层查询通用格式实体类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class QueryUnifiedFormat
{
    
    /**
     * 分页信息
     */
    protected IndexRange index;
    
    /**
     * 排序条件
     */
    protected OrderCondition orderCondition;
    
    /**
     * 字段的数量，为0表示无查询限制条件
     */
    protected int fieldNum;
    
    /**
     * 查询条件
     */
    protected List<QueryField> queryField;
    
    public IndexRange getIndex()
    {
        return index;
    }
    
    public void setIndex(IndexRange value)
    {
        this.index = value;
    }
    
    public OrderCondition getOrderCondition()
    {
        return orderCondition;
    }
    
    public void setOrderCondition(OrderCondition value)
    {
        this.orderCondition = value;
    }
    
    public int getFieldNum()
    {
        return fieldNum;
    }
    
    public void setFieldNum(int value)
    {
        this.fieldNum = value;
    }
    
    public List<QueryField> getQueryField()
    {
        return queryField;
    }
    
    public void setQueryField(List<QueryField> queryField)
    {
        this.queryField = queryField;
    }
    
}
