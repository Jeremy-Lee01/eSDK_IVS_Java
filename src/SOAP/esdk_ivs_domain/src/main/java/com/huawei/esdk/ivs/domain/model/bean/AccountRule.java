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

public class AccountRule
{
    private int enable;
    
    private PwdConsist pwdConsist;
    
    private int firstModify;
    
    private int checkOldPwd;
    
    private int accountNotFit;
    
    private int accountBackNotFit;
    
    private int domainAccCheckPwd;
    
    private int pwdMinLen;
    
    private int pwdDifferentNum;
    
    private int accountLockNum;
    
    private int accountLockElapse;
    
    private int accountLockInterval;
    
    private int pwdExpireTime;
    
    private int pwdExpireNotifyTime;
    
    private int pwdExpireForceNotify;
    
    private String reserve;
    
    public int getEnable()
    {
        return enable;
    }
    
    public void setEnable(int enable)
    {
        this.enable = enable;
    }
    
    public PwdConsist getPwdConsist()
    {
        return pwdConsist;
    }
    
    public void setPwdConsist(PwdConsist pwdConsist)
    {
        this.pwdConsist = pwdConsist;
    }
    
    public int getFirstModify()
    {
        return firstModify;
    }
    
    public void setFirstModify(int firstModify)
    {
        this.firstModify = firstModify;
    }
    
    public int getCheckOldPwd()
    {
        return checkOldPwd;
    }
    
    public void setCheckOldPwd(int checkOldPwd)
    {
        this.checkOldPwd = checkOldPwd;
    }
    
    public int getAccountNotFit()
    {
        return accountNotFit;
    }
    
    public void setAccountNotFit(int accountNotFit)
    {
        this.accountNotFit = accountNotFit;
    }
    
    public int getAccountBackNotFit()
    {
        return accountBackNotFit;
    }
    
    public void setAccountBackNotFit(int accountBackNotFit)
    {
        this.accountBackNotFit = accountBackNotFit;
    }
    
    public int getDomainAccCheckPwd()
    {
        return domainAccCheckPwd;
    }
    
    public void setDomainAccCheckPwd(int domainAccCheckPwd)
    {
        this.domainAccCheckPwd = domainAccCheckPwd;
    }
    
    public int getPwdMinLen()
    {
        return pwdMinLen;
    }
    
    public void setPwdMinLen(int pwdMinLen)
    {
        this.pwdMinLen = pwdMinLen;
    }
    
    public int getPwdDifferentNum()
    {
        return pwdDifferentNum;
    }
    
    public void setPwdDifferentNum(int pwdDifferentNum)
    {
        this.pwdDifferentNum = pwdDifferentNum;
    }
    
    public int getAccountLockNum()
    {
        return accountLockNum;
    }
    
    public void setAccountLockNum(int accountLockNum)
    {
        this.accountLockNum = accountLockNum;
    }
    
    public int getAccountLockElapse()
    {
        return accountLockElapse;
    }
    
    public void setAccountLockElapse(int accountLockElapse)
    {
        this.accountLockElapse = accountLockElapse;
    }
    
    public int getAccountLockInterval()
    {
        return accountLockInterval;
    }
    
    public void setAccountLockInterval(int accountLockInterval)
    {
        this.accountLockInterval = accountLockInterval;
    }
    
    public int getPwdExpireTime()
    {
        return pwdExpireTime;
    }
    
    public void setPwdExpireTime(int pwdExpireTime)
    {
        this.pwdExpireTime = pwdExpireTime;
    }
    
    public int getPwdExpireNotifyTime()
    {
        return pwdExpireNotifyTime;
    }
    
    public void setPwdExpireNotifyTime(int pwdExpireNotifyTime)
    {
        this.pwdExpireNotifyTime = pwdExpireNotifyTime;
    }
    
    public int getPwdExpireForceNotify()
    {
        return pwdExpireForceNotify;
    }
    
    public void setPwdExpireForceNotify(int pwdExpireForceNotify)
    {
        this.pwdExpireForceNotify = pwdExpireForceNotify;
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
