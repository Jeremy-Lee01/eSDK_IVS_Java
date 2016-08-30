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
 * 领域层告警信息类
 * <p>
 * @author  gWX169839
 * @see  [相关类/方法]
 * @since  eSDK Solution V100R003C00
 */
public class UserInfo
{
    private String domainCode;
    
    private int id;
    
    private Boolean isFirstLogin;
    
    private int roleId;
    
    private int groupId;
    
    private String loginName;
    
    private String password;
    
    private String pwdModifyDate;;
    
    private int userType;
    
    private String userDomain;
    
    private int status;
    
    private String registerDate;
    
    private String userDesc;
    
    private int ptzLevel;
    
    private int maxSessionCount;
    
    private int maxVideoCount;
    
    private String lockTime;
    
    private String userName;
    
    private String email;
    
    private String phone;
    
    private int sex;
    
    private int validDateFlag;
    
    private String validDateStart;
    
    private String validDateEnd;
    
    private String reserve;
    
    public String getDomainCode()
    {
        return domainCode;
    }
    
    public void setDomainCode(String domainCode)
    {
        this.domainCode = domainCode;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public Boolean getIsFirstLogin()
    {
        return isFirstLogin;
    }
    
    public void setIsFirstLogin(Boolean isFirstLogin)
    {
        this.isFirstLogin = isFirstLogin;
    }
    
    public int getRoleId()
    {
        return roleId;
    }
    
    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }
    
    public int getGroupId()
    {
        return groupId;
    }
    
    public void setGroupId(int groupId)
    {
        this.groupId = groupId;
    }
    
    public String getLoginName()
    {
        return loginName;
    }
    
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPwdModifyDate()
    {
        return pwdModifyDate;
    }
    
    public void setPwdModifyDate(String pwdModifyDate)
    {
        this.pwdModifyDate = pwdModifyDate;
    }
    
    public int getUserType()
    {
        return userType;
    }
    
    public void setUserType(int userType)
    {
        this.userType = userType;
    }
    
    public String getUserDomain()
    {
        return userDomain;
    }
    
    public void setUserDomain(String userDomain)
    {
        this.userDomain = userDomain;
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public String getRegisterDate()
    {
        return registerDate;
    }
    
    public void setRegisterDate(String registerDate)
    {
        this.registerDate = registerDate;
    }
    
    public String getUserDesc()
    {
        return userDesc;
    }
    
    public void setUserDesc(String userDesc)
    {
        this.userDesc = userDesc;
    }
    
    public int getPtzLevel()
    {
        return ptzLevel;
    }
    
    public void setPtzLevel(int ptzLevel)
    {
        this.ptzLevel = ptzLevel;
    }
    
    public int getMaxSessionCount()
    {
        return maxSessionCount;
    }
    
    public void setMaxSessionCount(int maxSessionCount)
    {
        this.maxSessionCount = maxSessionCount;
    }
    
    public String getLockTime()
    {
        return lockTime;
    }
    
    public void setLockTime(String lockTime)
    {
        this.lockTime = lockTime;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public int getSex()
    {
        return sex;
    }
    
    public void setSex(int sex)
    {
        this.sex = sex;
    }
    
    public int getValidDateFlag()
    {
        return validDateFlag;
    }

    public void setValidDateFlag(int validDateFlag)
    {
        this.validDateFlag = validDateFlag;
    }

    public String getValidDateStart()
    {
        return validDateStart;
    }

    public void setValidDateStart(String validDateStart)
    {
        this.validDateStart = validDateStart;
    }

    public String getValidDateEnd()
    {
        return validDateEnd;
    }

    public void setValidDateEnd(String validDateEnd)
    {
        this.validDateEnd = validDateEnd;
    }

    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }

    public int getMaxVideoCount()
    {
        return maxVideoCount;
    }

    public void setMaxVideoCount(int maxVideoCount)
    {
        this.maxVideoCount = maxVideoCount;
    }
    
}
