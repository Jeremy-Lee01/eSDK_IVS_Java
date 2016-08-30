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

import java.util.ArrayList;
import java.util.List;

public class SnapshotInfoList
{
    protected int total;
    
    protected IndexRange indexRange;
    
    protected List<SnapshotInfo> snapshotInfos;
    
    /**
     * Gets the value of the total property.
     * 
     */
    public int getTotal()
    {
        return total;
    }
    
    /**
     * Sets the value of the total property.
     * 
     */
    public void setTotal(int value)
    {
        this.total = value;
    }
    
    /**
     * Gets the value of the indexRange property.
     * 
     * @return
     *     possible object is
     *     {@link IndexRange }
     *     
     */
    public IndexRange getIndexRange()
    {
        return indexRange;
    }
    
    /**
     * Sets the value of the indexRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndexRange }
     *     
     */
    public void setIndexRange(IndexRange value)
    {
        this.indexRange = value;
    }
    
    /**
     * Gets the value of the snapshotInfos property.
     */
    public List<SnapshotInfo> getSnapshotInfos()
    {
        if (snapshotInfos == null)
        {
            snapshotInfos = new ArrayList<SnapshotInfo>();
        }
        return this.snapshotInfos;
    }
    
}
