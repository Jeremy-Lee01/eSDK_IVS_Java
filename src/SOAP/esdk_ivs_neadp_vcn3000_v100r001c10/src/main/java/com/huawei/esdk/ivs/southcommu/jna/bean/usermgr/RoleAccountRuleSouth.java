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

public class RoleAccountRuleSouth extends Structure
{
    // 是否启用
    public int    enable;   
    // 密码复杂性要求
    public PwdConsistSouth pwdConsist; 
    // 首次登录修改密码，是否选中
    public int    firstModify;  
    // 修改密码时验证旧密码，是否选中
    public int    checkOldPwd;  
    // 口令不能和帐号一样，是否选中
    public int    accountNotFit;  
    // 口令不能和帐号的倒写一样，是否选中
    public int    accountBackNotFit; 
    // Windows本地账号登录需要输入密码，是否选中
    public int    domainAccCheckPwd; 
    // 密码长度最小值，数值范围在6-64位。
    public int  pwdMinLen;  
    // 新旧密码不相同字符，数值范围在0-密码长度
    public int  pwdDifferentNum;  
    // 账号锁定阈值，0表示无锁定限制，最大999
    public int  accountLockNum;  
    // 账号锁定时长，数值范围在1-1440分钟
    public int  accountLockElapse;
    // 账号锁定间隔，数值范围在0-999分钟，0表示不自动清零，锁定后需要管理员手动解锁
    public int  accountLockInterval;  
    // 密码过期时间，密码创建或修改后开始计时，单位：天，范围：0-999
    public int  pwdExpireTime;  
    // 密码过期提醒时间，密码过期时间到达前开始提醒，单位：天，范围：0-99
    public int  pwdExpireNotifyTime;  
    // 密码过期强制修改，是否选中。0-不强制修改，1-强制修改
    public int    pwdExpireForceNotify;  
    // 保留字段
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_64_LEN];              
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("enable");
        list.add("pwdConsist");
        list.add("firstModify");
        list.add("checkOldPwd");
        
        list.add("accountNotFit");
        list.add("accountBackNotFit");
        list.add("domainAccCheckPwd");
        list.add("pwdMinLen");
        list.add("pwdDifferentNum");
        
        list.add("accountLockNum");
        list.add("accountLockElapse");
        list.add("accountLockInterval");
        list.add("pwdExpireTime");
        
        list.add("pwdExpireNotifyTime");
        list.add("pwdExpireForceNotify");
        
        list.add("reserve");
        return list;
    }  
}
