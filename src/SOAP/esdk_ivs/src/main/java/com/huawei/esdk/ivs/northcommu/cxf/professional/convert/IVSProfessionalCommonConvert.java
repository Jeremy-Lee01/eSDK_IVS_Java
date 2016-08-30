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
package com.huawei.esdk.ivs.northcommu.cxf.professional.convert;

import com.huawei.esdk.ivs.domain.model.bean.IPInfo;
import com.huawei.esdk.ivs.domain.model.bean.LoginInfo;



/**
 * 登录访问模块数据转换类
 * <p>
 * 登录访问模块接口数据的转换
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [V100R003]
 */
public class IVSProfessionalCommonConvert
{
    public LoginInfo convertLoginSoap2Model(com.huawei.esdk.ivs.northcommu.cxf.professional.gen.LoginInfo loginInfo)
    {
        if (null == loginInfo)
        {
            return null;
        }
        LoginInfo model = new LoginInfo();
        model.setClientType(loginInfo.getClientType());
        model.setDomainName(loginInfo.getDomainName());
        model.setLoginType(loginInfo.getLoginType());
        model.setMachineName(loginInfo.getMachineName());
        model.setPassword(loginInfo.getPassword());
        model.setReserve(loginInfo.getReserve());
        model.setServerPort(loginInfo.getServerPort());
        model.setUserName(loginInfo.getUserName());
        IPInfo ip = convertToIp(loginInfo.getServerIp());
        if (null != ip)
        {
            model.setServerIp(ip);
        }
        return model;
    }
    
    public IPInfo convertToIp(com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo ipInfo)
    {
        if (null == ipInfo)
        {
            return null;
        }
        IPInfo ip = new IPInfo();
        ip.setIp(ipInfo.getIp());
        ip.setIpType(ipInfo.getIpType());
        return ip;
    }
}
