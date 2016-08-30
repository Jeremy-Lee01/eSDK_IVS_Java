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

import java.util.Date;

public class CallbackMsg
{
    private int eventType;
    
    private String esdkSessionId;
    
    private Date date;
    
    private Object msg;
    
    public int getEventType()
    {
        return eventType;
    }
    
    public void setEventType(int eventType)
    {
        this.eventType = eventType;
    }
    
    public String getEsdkSessionId()
    {
        return esdkSessionId;
    }
    
    public void setEsdkSessionId(String esdkSessionId)
    {
        this.esdkSessionId = esdkSessionId;
    }
    
    public Object getMsg()
    {
        return msg;
    }
    
    public void setMsg(Object msg)
    {
        this.msg = msg;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
    
}
