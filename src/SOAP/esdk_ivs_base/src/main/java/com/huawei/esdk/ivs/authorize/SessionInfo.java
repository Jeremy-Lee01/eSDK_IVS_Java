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
package com.huawei.esdk.ivs.authorize;

import java.util.HashMap;
import java.util.Map;

public class SessionInfo
{
    private int vcnSessionId;

    private String userName;
    
    private Map<String, String> ivsSDKSessions = new HashMap<String, String>();
    
    private boolean isLogged;
    
    private byte[] secretKey;
    
    private byte[] iv;

    public boolean isLogged()
    {
        return isLogged;
    }

    public void setLogged(boolean isLogged)
    {
        this.isLogged = isLogged;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }


    public int getVCNSessionId()
    {
        return vcnSessionId;
    }

    public void setVCNSessionId(int vcnSessionId)
    {
        this.vcnSessionId = vcnSessionId;
    }

    public Map<String, String> getIvsSDKSessions()
    {
        return ivsSDKSessions;
    }

    public void setIvsSDKSessions(Map<String, String> ivsSDKSessions)
    {
        this.ivsSDKSessions = ivsSDKSessions;
    }

    public byte[] getSecretKey()
    {
        return secretKey;
    }

    public void setSecretKey(byte[] secretKey)
    {
        this.secretKey = secretKey;
    }

    public byte[] getIv()
    {
        return iv;
    }

    public void setIv(byte[] iv)
    {
        this.iv = iv;
    }

}
