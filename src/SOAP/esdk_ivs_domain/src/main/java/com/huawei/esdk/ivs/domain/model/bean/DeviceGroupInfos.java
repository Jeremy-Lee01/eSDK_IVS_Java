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

public class DeviceGroupInfos
{
    private int total;
    
    private IndexRange indexRange;
    
    private DeviceGroupList deviceGroupList;
    
    public int getTotal()
    {
        return total;
    }
    
    public void setTotal(int total)
    {
        this.total = total;
    }
    
    public IndexRange getIndexRange()
    {
        return indexRange;
    }
    
    public void setIndexRange(IndexRange indexRange)
    {
        this.indexRange = indexRange;
    }
    
    public DeviceGroupList getDeviceGroupList()
    {
        return deviceGroupList;
    }
    
    public void setDeviceGroupList(DeviceGroupList deviceGroupList)
    {
        this.deviceGroupList = deviceGroupList;
    }
    
}
