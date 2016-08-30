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
package com.huawei.esdk.ivs.northcommu.callback.cxf.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Content")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StreamExceptionInfo", propOrder = {})
public class StreamExceptionInfo
{
    @XmlElement(name = "eSDKSessionId")
    private String eSDKSessionId;
    
    @XmlElement(name = "handle")
    private long handle;
    
    @XmlElement(name = "exceptionCode")
    private int exceptionCode;
    
    @XmlElement(name = "reseved")
    private int reseved;
    
    @XmlElement(name = "deviceCode")
    private String deviceCode;
    
    public String geteSDKSessionId()
    {
        return eSDKSessionId;
    }
    
    public void seteSDKSessionId(String eSDKSessionId)
    {
        this.eSDKSessionId = eSDKSessionId;
    }
    
    public long getHandle()
    {
        return handle;
    }
    
    public void setHandle(long handle)
    {
        this.handle = handle;
    }
    
    public int getExceptionCode()
    {
        return exceptionCode;
    }
    
    public void setExceptionCode(int exceptionCode)
    {
        this.exceptionCode = exceptionCode;
    }
    
    public int getReseved()
    {
        return reseved;
    }
    
    public void setReseved(int reseved)
    {
        this.reseved = reseved;
    }
    
    public String getDeviceCode()
    {
        return deviceCode;
    }
    
    public void setDeviceCode(String deviceCode)
    {
        this.deviceCode = deviceCode;
    }
    
}
