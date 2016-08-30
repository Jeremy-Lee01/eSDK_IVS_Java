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
package com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Structure;
import com.huawei.esdk.ivs.domain.model.CommonConstant;

/**
 * 南向login对象类
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class LoginInfoSouth extends Structure
{
    public static class ByReference extends LoginInfoSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends LoginInfoSouth implements Structure.ByValue
    {
    }
    
    public byte[] userName = new byte[CommonConstant.UserModule.IVS_NAME_LEN];
    
    public byte[] password = new byte[CommonConstant.UserModule.IVS_PWD_LEN];
    
    public IPInfoSouth ipInfo = new IPInfoSouth();
    
    public int port;
    
    public int loginType;
    
    public byte[] domainName = new byte[CommonConstant.IVS_DOMAIN_LEN];
    
    public byte[] machineName = new byte[CommonConstant.IVS_MACHINE_NAME_LEN];
    
    public int clientType;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("userName");
        list.add("password");
        list.add("ipInfo");
        list.add("port");
        list.add("loginType");
        list.add("domainName");
        list.add("machineName");
        list.add("clientType");
        list.add("reserve");
        return list;
    }
}
