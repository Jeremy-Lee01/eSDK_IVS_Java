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

import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class LoginInfo
{
    private String userName;
    
    private String password;
    
    private IPInfo serverIp;
    
    private int serverPort;
    
    private int loginType;
    
    private String domainName;
    
    private String machineName;
    
    private String clientType;
    
    private String reserve;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public IPInfo getServerIp()
    {
        return serverIp;
    }
    
    public void setServerIp(IPInfo serverIp)
    {
        this.serverIp = serverIp;
    }
    
    public int getServerPort()
    {
        return serverPort;
    }
    
    public void setServerPort(int serverPort)
    {
        this.serverPort = serverPort;
    }
    
    public int getLoginType()
    {
        return loginType;
    }
    
    public void setLoginType(int loginType)
    {
        this.loginType = loginType;
    }
    
    public String getDomainName()
    {
        return domainName;
    }
    
    public void setDomainName(String domainName)
    {
        this.domainName = domainName;
    }
    
    public String getMachineName()
    {
        return machineName;
    }
    
    public void setMachineName(String machineName)
    {
        this.machineName = machineName;
    }
    
    public String getClientType()
    {
        return clientType;
    }
    
    public void setClientType(String clientType)
    {
        this.clientType = clientType;
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
