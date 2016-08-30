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
package com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.sun.jna.Structure;

public class QuerySnapshotParamSouth extends Structure
{
    public static class ByReference extends QuerySnapshotParamSouth implements Structure.ByReference
    {
    
    }
    
    public static class ByValue extends QuerySnapshotParamSouth implements Structure.ByValue
    {
    
    }
    
    public TimeSpanSouth timeSpan;
    
    public IndexRangeSouth indexRange;
    
    public int snapType;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_64_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("timeSpan");
        list.add("indexRange");
        list.add("snapType");
        list.add("reserve");
        return list;
    }
}
