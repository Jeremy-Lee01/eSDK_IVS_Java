/**
 * Copyright 2016 Huawei Technologies Co., Ltd. All rights reserved.
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

public class MediaURLParamSouth extends Structure
{
    
    public static class ByReference extends PlayBackParamSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends PlayBackParamSouth implements Structure.ByValue
    {
    }
    
    public int serviceType;
    
    public int packProtocolType;
    
    public TimeSpanSouth timeSpan;
    
    public byte[] fileName = new byte[CommonConstant.IVS_FILE_NAME_LEN];
    
    public int clientType;
    
    public int streamType;
    
    public int protocolType;
    
    public int transMode;
    
    public int broadCastType;
    
    public int videoDecType;
    
    public int audioDecType;
    
    public byte[] nvrCode = new byte[CommonConstant.DeviceModule.IVS_NVR_CODE_LEN];
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];;
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("serviceType");
        list.add("packProtocolType");
        list.add("timeSpan");
        list.add("fileName");
        list.add("clientType");
        list.add("streamType");
        list.add("protocolType");
        list.add("transMode");
        list.add("broadCastType");
        list.add("videoDecType");
        list.add("audioDecType");
        list.add("nvrCode");
        list.add("reserve");
        
        return list;
    }
    
}
