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
package com.huawei.esdk.ivs.business.professional.usermgr;

import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.User;
import com.huawei.esdk.ivs.domain.model.UserGroup;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RoleInfos;
import com.huawei.esdk.ivs.domain.model.bean.UserInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public class UserMgrService
{
    
    public SDKErrorCode changePassword(String oldPassword, String newPassword)
        throws SDKException
    {
        User user = new User();
        SDKErrorCode errorCode = user.changePassword(oldPassword, newPassword);
        return errorCode;
        
    }
    
    public SDKResult<Integer> getUserId()
        throws SDKException
    {
        
        User user = new User();
        SDKResult<Integer> res = user.getUserId();
        return res;
        
    }
    
    public SDKResult<UserInfo> getUserInfo(int userId, String domainCode)
        throws SDKException
    {
        User user = new User();
        SDKResult<UserInfo> res = user.getUserInfo(userId, domainCode);
        return res;
    }
    
    public SDKErrorCode deleteUser(int userId, String domainCode)
        throws SDKException
    {
        User user = new User();
        SDKErrorCode errorCode = user.deleteUser(userId, domainCode);
        return errorCode;
    }
    
    public SDKErrorCode modifyUser(UserInfo userInfo)
        throws SDKException
    {
        SDKErrorCode errorCode = new  SDKErrorCode();
        if(null == userInfo)
        {
            errorCode.setErrCode(ErrInfo.DATA_ERRORCODE);   
            return errorCode;
        }
        User user = new User();
        errorCode = user.modifyUser(userInfo);
        return errorCode;
    }
    
    public SDKResult<User> getUserList(String domainCode, QueryUnifiedFormat unifiedQuery)
        throws SDKException
    {
        SDKResult<User> res = new SDKResult<User>();
        if(null == unifiedQuery)
        {
            res.setErrCode(ErrInfo.DATA_ERRORCODE);   
            return res;
        }
        User user = new User();
        res = user.getUserList(domainCode, unifiedQuery);
        return res;
    }
    
    public SDKResult<Integer> addUser(UserInfo userInfo)
        throws SDKException
    {
        SDKResult<Integer> res = new SDKResult<Integer>();
        if(null == userInfo)
        {
            res.setErrCode(ErrInfo.DATA_ERRORCODE);   
            return res;
        }
        User user = new User();
        res = user.addUser(userInfo);
        return res;
    }

    public SDKResult<RoleInfos> getRoleList(String domainCode)
        throws SDKException
    {
        SDKResult<RoleInfos> res = new SDKResult<RoleInfos>();
        User user = new User();
        res = user.getRoleList(domainCode);
        return res;
    }
    
    public SDKResult<UserGroup> getUserGroupList(String domainCode, IndexRange indexRange) 
        throws SDKException
    {
        SDKResult<UserGroup> res = new SDKResult<UserGroup>();
        if(null == indexRange)
        {
            res.setErrCode(ErrInfo.DATA_ERRORCODE);   
            return res;
        }
        UserGroup userGroup = new UserGroup();
        res = userGroup.getUserGroupList(domainCode, indexRange);
        return res;
    }
}
