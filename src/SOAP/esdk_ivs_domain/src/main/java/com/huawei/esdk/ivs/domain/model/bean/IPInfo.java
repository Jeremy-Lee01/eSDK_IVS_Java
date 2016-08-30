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

/**
 * 
 * IP信息
 * @author  zWX144115
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class IPInfo
{
    private int ipType; // IP类型：参考 IVS_IP_TYPE
    
    private String ip; // IP地址
    
    public int getIpType()
    {
        return ipType;
    }

    public void setIpType(int ipType)
    {
        this.ipType = ipType;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

}
