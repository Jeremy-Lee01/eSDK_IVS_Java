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

public class PlayBackParamSouth extends Structure
{
    public static class ByReference extends PlayBackParamSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends PlayBackParamSouth implements Structure.ByValue
    {
    }
    
    // 协议类型，1-UDP 2-TCP，默认为1
    public int protocolType;     
    // 实况启动、结束时间
    public TimeSpanSouth timeSpan;     
    // 回放速率
    public float speed;      
    
    public byte[] NVRCode = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("protocolType");
        list.add("timeSpan");
        list.add("speed");
        list.add("NVRCode");
        
        return list;
    }
}
