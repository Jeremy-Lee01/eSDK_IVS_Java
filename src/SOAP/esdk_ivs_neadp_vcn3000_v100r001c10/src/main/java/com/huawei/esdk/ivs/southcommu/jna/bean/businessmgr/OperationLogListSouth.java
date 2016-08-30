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

import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.IndexRangeSouth;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * 南向操作日志列表
 * 
 * @author  wWX202775
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C10
 */
public class OperationLogListSouth extends Structure
{
    public OperationLogListSouth(Pointer pointer)
    {
        super(pointer, Structure.ALIGN_NONE);
    }
    
    public OperationLogListSouth(int size)
    {
        super(Structure.ALIGN_NONE);
        this.operationLogs = new OperationLogInfoSouth[size];
    }
    
    public int total;
    
    public IndexRangeSouth index;
    
    public OperationLogInfoSouth[] operationLogs = null;
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("total");
        list.add("index");
        list.add("operationLogs");
        return list;
    }
    
}
