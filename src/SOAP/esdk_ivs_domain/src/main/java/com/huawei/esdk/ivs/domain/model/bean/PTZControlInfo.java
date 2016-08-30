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

public class PTZControlInfo
{
    private int lockStatus;
    
    private int userId;
    
    private String userName;
    
    private IPInfo ip;
    
    private int releaseTimeRemain;
    
    private String reserve;
    
    public int getLockStatus()
    {
        return lockStatus;
    }
    
    public void setLockStatus(int lockStatus)
    {
        this.lockStatus = lockStatus;
    }
    
    public int getUserId()
    {
        return userId;
    }
    
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public IPInfo getIp()
    {
        return ip;
    }
    
    public void setIp(IPInfo ip)
    {
        this.ip = ip;
    }
    
    public int getReleaseTimeRemain()
    {
        return releaseTimeRemain;
    }
    
    public void setReleaseTimeRemain(int releaseTimeRemain)
    {
        this.releaseTimeRemain = releaseTimeRemain;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
    
}
