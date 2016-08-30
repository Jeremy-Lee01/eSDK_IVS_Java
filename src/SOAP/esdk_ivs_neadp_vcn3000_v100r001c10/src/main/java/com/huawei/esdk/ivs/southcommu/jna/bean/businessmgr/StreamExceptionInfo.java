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
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * 
 * 1006时间消息体
 * 
 * @author  sWX198756
 * @since  [eSDK IVS V100R005C10T]
 */
public class StreamExceptionInfo extends Structure
{
    public static class ByReference extends StreamExceptionInfo implements Structure.ByReference
    {
        
    }
    
    public static class ByValue extends StreamExceptionInfo implements Structure.ByValue
    {
        
    }
    
    public StreamExceptionInfo()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public StreamExceptionInfo(Pointer p)
    {
        super(p, Structure.ALIGN_NONE);
    }
    
    /**
     * 登录返回的会话ID
     */
    public int sessionId;
    
    /**
     * 句柄
     */
    public NativeLong handle;
    
    /**
     * 错误码
     */
    public int exceptionCode;
    
    /**
     * 备用
     */
    public int reseved;
    
    /**
     * 设备编码
     */
    public byte[] deviceCode = new byte[CommonConstant.DeviceModule.IVS_DEV_CODE_LEN];
    
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("sessionId");
        list.add("handle");
        list.add("exceptionCode");
        list.add("reseved");
        list.add("deviceCode");
        
        return list;
    }
}
