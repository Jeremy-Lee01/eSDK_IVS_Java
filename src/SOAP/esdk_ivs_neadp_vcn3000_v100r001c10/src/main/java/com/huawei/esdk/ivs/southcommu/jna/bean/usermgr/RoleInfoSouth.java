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
package com.huawei.esdk.ivs.southcommu.jna.bean.usermgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.CommonConstant;
import com.sun.jna.Structure;

public class RoleInfoSouth  extends Structure
{
    // 角色所属域编码
    public byte[] domainCode = new byte[CommonConstant.IVS_DOMAIN_CODE_LEN];   
    // 角色ID
    public int roleId;             
    // 角色名称
    public byte[] roleName = new byte[CommonConstant.IVS_NAME_LEN];    
    // 角色描述
    public byte[] roleDescribe = new byte[CommonConstant.IVS_DESCRIBE_LEN];    
    // 角色类型：值参考 IVS_ROLE_TYPE
    public int roleType;  
    // 角色权限数组：0-没权限，1-有权限，权限值参考 IVS_OPERATION_RIGHT
    public byte[] right = new byte[CommonConstant.IVS_MAX_OPERATION_RIGHT];    
    // 账号规则ID：参考 IVS_ROLE_ACCOUNT_RULE
    public RoleAccountRuleSouth   accountRule;          
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_64_LEN];    
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("domainCode");
        list.add("roleId");
        list.add("roleName");
        list.add("roleDescribe");
        list.add("roleType");
        list.add("right");
        list.add("accountRule");
        list.add("reserve");
        return list;
    } 
}
