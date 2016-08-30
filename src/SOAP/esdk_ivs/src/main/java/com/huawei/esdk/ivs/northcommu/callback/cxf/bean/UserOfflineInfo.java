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
@XmlType(name = "UserOfflineInfo", propOrder = {})
public class UserOfflineInfo
{
    @XmlElement(name = "LoginID")
    private int sessionId;
    
    @XmlElement(name = "OfflineType")
    private int offlineType;
    
    public int getSessionId()
    {
        return sessionId;
    }
    
    public void setSessionId(int sessionId)
    {
        this.sessionId = sessionId;
    }
    
    public int getOfflineType()
    {
        return offlineType;
    }
    
    public void setOfflineType(int offlineType)
    {
        this.offlineType = offlineType;
    }
    
}
