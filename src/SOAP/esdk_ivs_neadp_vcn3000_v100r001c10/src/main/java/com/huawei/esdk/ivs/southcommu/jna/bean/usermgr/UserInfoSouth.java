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

/**
 * 南向用户信息类
 * <p>
 * @author  gWX169839
 * @see  [相关类/方法]
 * @since  eSDK Solution V100R003C00
 */
public class UserInfoSouth extends Structure
{
 
    public byte[] domainCode = new byte[CommonConstant.IVS_DOMAIN_CODE_LEN];
    
    public int userId;
    
    public int isFirstLogin;
    
    public int roleId;
    
    public int groupId;
    
    public byte[] loginName = new byte[CommonConstant.IVS_NAME_LEN];
    
    public byte[] password = new byte[CommonConstant.IVS_PWD_LEN];
    
    public byte[] pwdModifyDate = new byte[CommonConstant.IVS_TIME_LEN];
    
    public int userType;
    
    public byte[] userDomain = new byte[CommonConstant.IVS_DOMAIN_LEN];
    
    public int status;
    
    public byte[] registerDate = new byte[CommonConstant.IVS_TIME_LEN];
    
    public byte[] userDesc = new byte[CommonConstant.IVS_DESCRIBE_LEN];
    
    public int ptzLevel;
    
    public int maxSessionCount;
    
    public int maxVideoCount;
    
    public byte[] lockTime = new byte[CommonConstant.IVS_TIME_LEN];
    
    public byte[] userName = new byte[CommonConstant.IVS_NAME_LEN];
    
    public byte[] email = new byte[CommonConstant.IVS_EMAILE_LEN];
    
    public byte[] phone = new byte[CommonConstant.IVS_PHONE_NUMBER_LEN];
    
    public int sex;
    
    public int validDateFlag;
    
    public byte[] validDateStart = new byte[CommonConstant.IVS_TIME_LEN];
    
    public byte[] validDateEnd = new byte[CommonConstant.IVS_TIME_LEN];
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_64_LEN];
    
    public UserInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("domainCode");
        list.add("userId");
        list.add("isFirstLogin");
        list.add("roleId");
        list.add("groupId");
        list.add("loginName");
        list.add("password");
        list.add("pwdModifyDate");
        list.add("userType");
        list.add("userDomain");
        list.add("status");
        list.add("registerDate");
        list.add("userDesc");
        list.add("ptzLevel");
        list.add("maxSessionCount");
        list.add("maxVideoCount");
        list.add("lockTime");
        list.add("userName");
        list.add("email");
        list.add("phone");
        list.add("sex");
        list.add("validDateFlag");
        list.add("validDateStart");
        list.add("validDateEnd");
        list.add("reserve");
        return list;
    }
    
}
