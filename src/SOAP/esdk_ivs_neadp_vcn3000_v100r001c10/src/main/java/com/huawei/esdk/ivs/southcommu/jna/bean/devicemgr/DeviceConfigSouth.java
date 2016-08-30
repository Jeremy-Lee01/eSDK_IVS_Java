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
package com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.IPInfoSouth;
import com.sun.jna.Structure;

/**
 * 主设备信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class DeviceConfigSouth extends Structure
{
    public DeviceConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends DeviceConfigSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends DeviceConfigSouth implements Structure.ByValue
    {
    }
    
    /**
     * 主设备基本信息
     */
    public DeviceBasicInfoSouth deviceBasicInfo = new DeviceBasicInfoSouth();
    
    /**
     * 主设备协议类型: "TEYES"-千里眼   "ONVIF"  "HWSDK"-华为SDK "HIKSDK"-海康SDK
     */
    public byte[] protocolType = new byte[CommonConstant.DeviceModule.IVS_MAX_PROTOCOLTYPE_NAME_LEN];
    
    /**
     * 认证类型：参考 IVS_LOGINTYPE 驱动为ONVIF时认证类型可设置，认证类型有三种（0:None、1:HTTP Digest、2:WS-Usernametoken Authentication）
     */
    public int loginType;
    
    /**
     * 设备告警使能 1-启用（ON） 0-停用（OFF）参考：IVS_VIDEO_STANDARD
     */
    public int enableAlarm;
    
    /**
     * 视频制式 1-PAL 2-NTSC
     */
    public int videoFormat;
    
    /**
     * 是否直连优先： 0-非直连优先 1-直连优先
     */
    public int directConnectFirst;
    
    /**
     * 最大直连数目
     */
    public int maxDirectConnectNum;
    
    /**
     * 是否启用集群调度：0-否, 1-是(NVR CODE 不为空)
     */
    public int enableSchedule;
    
    /**
     * 设备所属NVR编码, 表示该设备被该NVR管理
     */
    public byte[] nvrCode = new byte[CommonConstant.DeviceModule.IVS_NVR_CODE_LEN];
    
    /**
     * 设备所属TAS编码, 当是被通过独立部署的DCG接入时使用
     */
    public byte[] tasCode = new byte[CommonConstant.DeviceModule.IVS_TAS_CODE_LEN];
    
    public IPInfoSouth tasIp;
    
    /**
     * 设备登录用户名
     */
    public byte[] devUser = new byte[CommonConstant.UserModule.IVS_NAME_LEN];
    
    /**
     * 设备登录密码
     */
    public byte[] devPasswd = new byte[CommonConstant.UserModule.IVS_PWD_LEN];
    
    /**
     * 设备向平台注册密码
     */
    public byte[] devRegPasswd = new byte[CommonConstant.UserModule.IVS_PWD_LEN];
    
    /**
     * 设备通道信息
     */
    public DeviceChannelConfigSouth deviceChannel = new DeviceChannelConfigSouth();
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("deviceBasicInfo");
        list.add("protocolType");
        list.add("loginType");
        list.add("enableAlarm");
        list.add("videoFormat");
        list.add("directConnectFirst");
        list.add("maxDirectConnectNum");
        list.add("enableSchedule");
        list.add("nvrCode");
        list.add("tasCode");
        list.add("tasIp");
        list.add("devUser");
        list.add("devPasswd");
        list.add("devRegPasswd");
        list.add("deviceChannel");
        list.add("reserve");
        return list;
    }
}
