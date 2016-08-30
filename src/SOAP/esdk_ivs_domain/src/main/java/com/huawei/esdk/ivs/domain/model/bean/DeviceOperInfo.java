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

public class DeviceOperInfo
{
    private String protocolType; // 主设备协议类型: "TEYES"-千里眼   "ONVIF"  "HWSDK"-华为SDK "HIKSDK"-海康SDK
    
    private int loginType; // 认证类型：参考 IVS_LOGINTYPE 驱动为ONVIF时认证类型可设置，认证类型有三种（0:None、1:HTTP Digest、2:WS-Usernametoken Authentication）
    
    private int enableAlarm; // 设备告警使能 1-启用（ON） 0-停用（OFF）参考：IVS_VIDEO_STANDARD
    
    private int videoFormat; // 视频制式 1-PAL 2-NTSC
    
    private int isDirectConnectFirst; // 是否直连优先： 0-非直连优先 1-直连优先
    
    private int maxDirectConnectNum; // 最大直连数目
    
    private int enableSchedule; // 是否启用集群调度：0-否, 1-是(NVR CODE 不为空)
    
    private String nvrCode; // 设备所属NVR编码, 表示该设备被该NVR管理
    
    private String tasCode; // 设备所属TAS编码, 当是被通过独立部署的DCG接入时使用
    
    private IPInfo tasIp;
    
    private String devUser; // 设备登录用户名
    
    private String devPasswd; // 设备登录密码
    
    private String devRegPasswd; // 设备向平台注册密码
    
    private String reserve;

    public String getProtocolType()
    {
        return protocolType;
    }

    public void setProtocolType(String protocolType)
    {
        this.protocolType = protocolType;
    }

    public int getLoginType()
    {
        return loginType;
    }

    public void setLoginType(int loginType)
    {
        this.loginType = loginType;
    }

    public int getEnableAlarm()
    {
        return enableAlarm;
    }

    public void setEnableAlarm(int enableAlarm)
    {
        this.enableAlarm = enableAlarm;
    }

    public int getVideoFormat()
    {
        return videoFormat;
    }

    public void setVideoFormat(int videoFormat)
    {
        this.videoFormat = videoFormat;
    }

    public int getIsDirectConnectFirst()
    {
        return isDirectConnectFirst;
    }

    public void setIsDirectConnectFirst(int isDirectConnectFirst)
    {
        this.isDirectConnectFirst = isDirectConnectFirst;
    }

    public int getMaxDirectConnectNum()
    {
        return maxDirectConnectNum;
    }

    public void setMaxDirectConnectNum(int maxDirectConnectNum)
    {
        this.maxDirectConnectNum = maxDirectConnectNum;
    }

    public int getEnableSchedule()
    {
        return enableSchedule;
    }

    public void setEnableSchedule(int enableSchedule)
    {
        this.enableSchedule = enableSchedule;
    }

    public String getNvrCode()
    {
        return nvrCode;
    }

    public void setNvrCode(String nvrCode)
    {
        this.nvrCode = nvrCode;
    }

    public String getTasCode()
    {
        return tasCode;
    }

    public void setTasCode(String tasCode)
    {
        this.tasCode = tasCode;
    }

    public IPInfo getTasIp()
    {
        return tasIp;
    }

    public void setTasIp(IPInfo tasIp)
    {
        this.tasIp = tasIp;
    }

    public String getDevUser()
    {
        return devUser;
    }

    public void setDevUser(String devUser)
    {
        this.devUser = devUser;
    }

    public String getDevPasswd()
    {
        return devPasswd;
    }

    public void setDevPasswd(String devPasswd)
    {
        this.devPasswd = devPasswd;
    }

    public String getDevRegPasswd()
    {
        return devRegPasswd;
    }

    public void setDevRegPasswd(String devRegPasswd)
    {
        this.devRegPasswd = devRegPasswd;
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
