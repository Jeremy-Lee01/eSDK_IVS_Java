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

public class RoleInfo
{
    private String domainCode;
    
    private String roleID;
    
    private String roleName;
    
    private String roleDescribe;
    
    private String roleType;
    
    private String right;
    
    private AccountRule accountRule;
    
    private String reserve;
    
    public String getDomainCode()
    {
        return domainCode;
    }
    
    public void setDomainCode(String domainCode)
    {
        this.domainCode = domainCode;
    }
    
    public String getRoleID()
    {
        return roleID;
    }
    
    public void setRoleID(String roleID)
    {
        this.roleID = roleID;
    }
    
    public String getRoleName()
    {
        return roleName;
    }
    
    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
    
    public String getRoleDescribe()
    {
        return roleDescribe;
    }
    
    public void setRoleDescribe(String roleDescribe)
    {
        this.roleDescribe = roleDescribe;
    }
    
    public String getRoleType()
    {
        return roleType;
    }
    
    public void setRoleType(String roleType)
    {
        this.roleType = roleType;
    }
    
    public String getRight()
    {
        return right;
    }
    
    public void setRight(String right)
    {
        this.right = right;
    }
    
    public AccountRule getAccountRule()
    {
        return accountRule;
    }
    
    public void setAccountRule(AccountRule accountRule)
    {
        this.accountRule = accountRule;
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
