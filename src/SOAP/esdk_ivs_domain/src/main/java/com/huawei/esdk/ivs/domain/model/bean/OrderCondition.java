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

public class OrderCondition
{
    
    protected int enableOrder;
    
    protected int field;
    
    protected int isAscend;
    
    public int getEnableOrder()
    {
        return enableOrder;
    }
    
    public void setEnableOrder(int value)
    {
        this.enableOrder = value;
    }
    
    public int getField()
    {
        return field;
    }
    
    public void setField(int value)
    {
        this.field = value;
    }
    
    public int getIsAscend()
    {
        return isAscend;
    }
    
    public void setIsAscend(int value)
    {
        this.isAscend = value;
    }
    
}
