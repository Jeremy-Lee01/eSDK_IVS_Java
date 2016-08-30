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

public class UserGroupInfoSouth extends Structure
{
    public UserGroupInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    /**
     * 用户组所属域编码
     */
    public byte[] domainCode = new byte[CommonConstant.IVS_DOMAIN_CODE_LEN];
    
    /**
     *  用户组ID
     */
    public int id;
    
    /**
     * 用户组名称
     */
    public byte[] name = new byte[CommonConstant.IVS_NAME_LEN];
    
    /**
     * 父用户组ID
     */
    public int parentId;
    
    /**
     * 用户组层级，最多支持4层（包含根组在内）
     */
    public int level;
    
    /**
     * 用户组备注，键盘可见字符和中文，0~64字符。值可以为空
     */
    public byte[] groupDesc = new byte[CommonConstant.IVS_MAX_USER_GROUP_DESC_LEN];
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("domainCode");
        list.add("id");
        list.add("name");
        list.add("parentId");
        list.add("level");
        list.add("groupDesc");
        list.add("reserve");
        return list;
    }
    
}
