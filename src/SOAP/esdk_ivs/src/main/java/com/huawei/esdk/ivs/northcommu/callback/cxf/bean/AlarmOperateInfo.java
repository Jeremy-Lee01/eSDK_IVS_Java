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

@XmlRootElement(name = "AlarmOperateInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {})
public class AlarmOperateInfo
{
    @XmlElement(name = "OperatorId")
    private int operatorId;
    
    @XmlElement(name = "OperatorName")
    private String operatorName;
    
    @XmlElement(name = "OperateTime")
    private String operateTime;
    
    @XmlElement(name = "Reserve")
    private String reserve;
    
    @XmlElement(name = "OperateInfo")
    private String operateInfo;
    
    public int getOperatorId()
    {
        return operatorId;
    }
    
    public void setOperatorId(int operatorId)
    {
        this.operatorId = operatorId;
    }
    
    public String getOperatorName()
    {
        return operatorName;
    }
    
    public void setOperatorName(String operatorName)
    {
        this.operatorName = operatorName;
    }
    
    public String getOperateTime()
    {
        return operateTime;
    }
    
    public void setOperateTime(String operateTime)
    {
        this.operateTime = operateTime;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
    
    public String getOperateInfo()
    {
        return operateInfo;
    }
    
    public void setOperateInfo(String operateInfo)
    {
        this.operateInfo = operateInfo;
    }
    
}
