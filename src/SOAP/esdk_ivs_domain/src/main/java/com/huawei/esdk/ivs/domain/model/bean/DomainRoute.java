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
 * 系统中的域路由信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  [V100R003]
 */
public class DomainRoute
{
    /**
     * SMU工作模式，参考 IVS_DOMAIN_TYPE 1-堆叠 2-集群 3-单机
     */
    private int domainType;
    
    /**
     * 是否代理
     */
    private int isAgent;
    
    /**
     * 域编码
     */
    private String domainCode;
    
    /**
     * 域名称
     */
    private String domainName;
    
    /**
     * 域IP
     */
    private IPInfo domainIPInfo;
    
    /**
     * 域端口
     */
    private int domainPort;
    
    /**
     * 上级域编码
     */
    private String superDomain;
    
    /**
     * 是否本域 0-不是 1-是
     */
    private int isLocalDomain;
    
    private String reserve;
    
    public int getDomainType()
    {
        return domainType;
    }
    
    public void setDomainType(int domainType)
    {
        this.domainType = domainType;
    }
    
    public int getIsAgent()
    {
        return isAgent;
    }
    
    public void setIsAgent(int isAgent)
    {
        this.isAgent = isAgent;
    }
    
    public String getDomainCode()
    {
        return domainCode;
    }
    
    public void setDomainCode(String domainCode)
    {
        this.domainCode = domainCode;
    }
    
    public String getDomainName()
    {
        return domainName;
    }
    
    public void setDomainName(String domainName)
    {
        this.domainName = domainName;
    }
    
    public IPInfo getDomainIPInfo()
    {
        return domainIPInfo;
    }
    
    public void setDomainIPInfo(IPInfo domainIPInfo)
    {
        this.domainIPInfo = domainIPInfo;
    }
    
    public int getDomainPort()
    {
        return domainPort;
    }
    
    public void setDomainPort(int domainPort)
    {
        this.domainPort = domainPort;
    }
    
    public String getSuperDomain()
    {
        return superDomain;
    }
    
    public void setSuperDomain(String superDomain)
    {
        this.superDomain = superDomain;
    }
    
    public int getIsLocalDomain()
    {
        return isLocalDomain;
    }
    
    public void setIsLocalDomain(int isLocalDomain)
    {
        this.isLocalDomain = isLocalDomain;
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
