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
package com.huawei.esdk.ivs.device.v100r001c10.common.convert;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.huawei.esdk.ivs.domain.model.bean.IPInfo;
import com.huawei.esdk.ivs.domain.model.bean.LoginInfo;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.IPInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.LoginInfoSouth;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.BytesUtils;
import com.huawei.esdk.platform.common.utils.NumberUtils;

public class CommonCapabilityConvert
{
    private static final Logger LOGGER = Logger.getLogger(CommonCapabilityConvert.class);
    
    public LoginInfoSouth getLoginInfoModel2South(LoginInfo domain)
    {
        LoginInfoSouth south = new LoginInfoSouth();
        south.clear();
        south.userName = BytesUtils.stringToBytesForIVS(domain.getUserName());
        south.password = BytesUtils.stringToBytesForIVS(domain.getPassword());
        south.port = domain.getServerPort();
        
        south.ipInfo = getIPInfoModel2South(domain.getServerIp());
        
        south.clientType = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("loginInfo.clientType"));
        south.loginType = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("loginInfo.loginType"));
        south.ipInfo.ipType = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("loginInfo.ipType"));
        
        return south;
    }
    
    public IPInfoSouth getIPInfoModel2South(IPInfo serverIp)
    {
        IPInfoSouth south = new IPInfoSouth();
        south.clear();
        south.ip = BytesUtils.stringToBytesForIVS(serverIp.getIp());
        south.ipType = serverIp.getIpType();
        return south;
    }
    
    /** 
    * 将设备返回的SDK整型版本号转换为字符串格式
    * @param version SDK整型版本号
    * @return SDK字符串格式版本号
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public String getVersionSouth2Model(int version)
    {
        String versionStr = "";
        String versionBin = Integer.toBinaryString(version);
        String temp = null;
        if (versionBin.length() > CommonConstant.IVS_VERSION_SUB_LEN)
        {
            temp = versionBin.substring(versionBin.length() - CommonConstant.IVS_VERSION_SUB_LEN);
            versionStr = Integer.parseInt(temp, CommonConstant.IVS_BINARY) + versionStr;
            versionBin = versionBin.substring(0, versionBin.length() - CommonConstant.IVS_VERSION_SUB_LEN);
        }
        while (versionBin.length() > CommonConstant.IVS_VERSION_SUB_LEN)
        {
            temp = versionBin.substring(versionBin.length() - CommonConstant.IVS_VERSION_SUB_LEN);
            versionStr = Integer.parseInt(temp, CommonConstant.IVS_BINARY) + "." + versionStr;
            versionBin = versionBin.substring(0, versionBin.length() - CommonConstant.IVS_VERSION_SUB_LEN);
        }
        if (versionBin.length() > 0)
        {
            versionStr = Integer.parseInt(versionBin, 2) + "." + versionStr;
        }
        else
        {
        	LOGGER.debug("versionBin.length()=" + versionBin.length());
        }
        return versionStr;
    }
}
