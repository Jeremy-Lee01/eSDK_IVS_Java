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

/**
 * 
 * 南向实况浏览媒体参数
 * 
 * @author  zWX144115
 * @since  [eSDK IVS V100R003C00]
 */
public class RealplayParamSouth extends Structure
{
    public static class ByReference extends RealplayParamSouth implements Structure.ByReference
    {
        
    }
    
    public static class ByValue extends RealplayParamSouth implements Structure.ByValue
    {
        
    }
    
    public RealplayParamSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    /**
     * 码流类型
     */
    public int streamType;
    
    /**
     * 协议类型
     */
    public int protocolType;
    
    /**
     * 是否直连优先
     */
    public int directFirst;
    
    /**
     * 是否开启组播
     */
    public int multiCast;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("streamType");
        list.add("protocolType");
        list.add("directFirst");
        list.add("multiCast");
        list.add("reserve");
        
        return list;
    }
}
