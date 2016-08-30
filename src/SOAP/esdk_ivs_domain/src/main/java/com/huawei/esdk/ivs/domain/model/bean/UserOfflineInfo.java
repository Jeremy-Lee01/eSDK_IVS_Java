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

public class UserOfflineInfo
{
    /**
     * 下线用户的SessionID
     */
    private int sessionId;
    
    /**
     * 下线类型
     */
    private int offlineType;
    
    private String esdkSessionId;
    
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

    public String getEsdkSessionId()
    {
        return esdkSessionId;
    }

    public void setEsdkSessionId(String esdkSessionId)
    {
        this.esdkSessionId = esdkSessionId;
    }
    
}
