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
 * 南向域路由对象类
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class DomainRouteSouth extends Structure
{
    
    public static class ByReference extends DomainRouteSouth implements Structure.ByReference
    {
    }
    
    /**
     * SMU工作模式，参考 IVS_DOMAIN_TYPE 1-堆叠 2-集群 3-单机
     */
    public int domainType;
    
    /**
     * 是否代理0-不是 1-是
     */
    public int isAgent;
    
    /**
     * 域编码
     */
    public byte[] domainCode = new byte[CommonConstant.DeviceModule.IVS_DOMAIN_CODE_LEN];
    
    /**
     * 域名称
     */
    public byte[] domainName = new byte[CommonConstant.DeviceModule.IVS_NAME_LEN];
    
    /**
     * 域IP
     */
    public IPInfoSouth ip;
    
    /**
     * 域端口
     */
    public int port;
    
    /**
     * 设备状态：0-离线，1-在线，2-休眠
     */
    public int status;
    
    /**
     * 上级域编码
     */
    public byte[] superDomain = new byte[CommonConstant.DeviceModule.IVS_DOMAIN_CODE_LEN];
    
    /**
     * 是否本域 0-不是 1-是
     */
    public int isLocalDomain;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_64_LEN];
    
    public DomainRouteSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("domainType");
        list.add("isAgent");
        list.add("domainCode");
        list.add("domainName");
        list.add("ip");
        list.add("port");
        list.add("status");
        list.add("superDomain");
        list.add("isLocalDomain");
        list.add("reserve");
        return list;
    }
    
}
