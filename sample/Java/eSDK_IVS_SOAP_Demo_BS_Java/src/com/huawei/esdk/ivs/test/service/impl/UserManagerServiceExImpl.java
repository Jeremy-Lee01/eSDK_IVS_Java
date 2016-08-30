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
package com.huawei.esdk.ivs.test.service.impl;

import java.util.List;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.test.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.test.bean.IndexRange;
import com.huawei.esdk.ivs.test.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.test.bean.RoleInfos;
import com.huawei.esdk.ivs.test.bean.UserGroupInfos;
import com.huawei.esdk.ivs.test.bean.UserInfo;
import com.huawei.esdk.ivs.test.bean.UserInfos;
import com.huawei.esdk.ivs.test.constant.NativeConstant;
import com.huawei.esdk.ivs.test.service.UserManagerServiceEx;
import com.huawei.esdk.ivs.test.service.impl.autogen.IVSProfessionalUserManager;
import com.huawei.esdk.ivs.test.utils.AES128Utils;
import com.huawei.esdk.ivs.test.utils.ClientProvider;
import com.huawei.esdk.ivs.test.utils.Encrypt;
import com.huawei.esdk.ivs.test.utils.ExceptionUtils;
import com.huawei.esdk.ivs.test.utils.StringUtils;
import com.huawei.esdk.platform.professional.local.constant.PlatformNativeConstant;

public class UserManagerServiceExImpl implements UserManagerServiceEx
{
    private static final Logger LOGGER = Logger.getLogger(UserManagerServiceExImpl.class);
    
    private IVSProfessionalUserManager ivsProfessionalUserManager =
        (IVSProfessionalUserManager)ClientProvider.getClient(IVSProfessionalUserManager.class);
    
    private static UserManagerServiceExImpl instance = null;
    
    public static synchronized UserManagerServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new UserManagerServiceExImpl();
        }
        return instance;
    }
    
    public IVSSDKResponse<Integer> addUser(UserInfo userInfo)
    {
        
        LOGGER.info("begin to execute addUser method");
        
        IVSSDKResponse<Integer> result = new IVSSDKResponse<Integer>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<Integer> userId = new Holder<Integer>();
        
        if (null == userInfo)
        {
            result.setResultCode(NativeConstant.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        
        if (!StringUtils.isNullOrEmpty(userInfo.getPassword()))
        {
            String encodePwd = null;
            try
            {
                // 加密方式向下兼容
                encodePwd = Encrypt.getEncryptPwd(userInfo.getPassword());
                if (StringUtils.isNullOrEmpty(encodePwd))
                {
                    result.setResultCode(PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE);
                    return result;
                }
            }
            catch (Exception e)
            {
                LOGGER.debug("encode password error");
                result.setResultCode(PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE);
                return result;
            }
            userInfo.setPassword(encodePwd);
        }
        else
        {
            result.setResultCode(NativeConstant.PWD_ERRORCODE);
            return result;
        }
        
        try
        {
            ivsProfessionalUserManager.addUser(userInfo, resultCode, userId);
        }
        catch (Exception e)
        {
            LOGGER.error("addUser method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        result.setResult(userId.value);
        result.setResultCode(resultCode.value);
        
        LOGGER.info("execute addUser method completed");
        
        return result;
    }
    
    public IVSSDKResponse<Integer> getUserId()
    {
        LOGGER.info("begin to execute getUserId method");
        
        IVSSDKResponse<Integer> result = new IVSSDKResponse<Integer>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<Integer> userId = new Holder<Integer>();
        try
        {
            ivsProfessionalUserManager.getUserId(resultCode, userId);
        }
        catch (Exception e)
        {
            LOGGER.error("getUserId method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        result.setResult(userId.value);
        result.setResultCode(resultCode.value);
        
        LOGGER.info("execute getUserId method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<UserInfo> getUserInfo(String domainCode, Integer userId)
    {
        LOGGER.info("begin to execute getUserInfo method");
        
        IVSSDKResponse<UserInfo> result = new IVSSDKResponse<UserInfo>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<UserInfo> userInfo = new Holder<UserInfo>();
        try
        {
            ivsProfessionalUserManager.getUserInfo(domainCode, userId, resultCode, userInfo);
        }
        catch (Exception e)
        {
            LOGGER.error("getUserInfo method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        UserInfo user = userInfo.value;
        if (null != user && !StringUtils.isNullOrEmpty(user.getPassword()))
        {
            user.setPassword(AES128Utils.decodeFromBase64(user.getPassword()));
        }
        
        result.setResult(user);
        result.setResultCode(resultCode.value);
        
        LOGGER.info("execute getUserInfo method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<UserInfos> getUserList(String domainCode, QueryUnifiedFormat unifiedQuery)
    {
        LOGGER.info("begin to execute getUserList method");
        
        IVSSDKResponse<UserInfos> result = new IVSSDKResponse<UserInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<UserInfos> userInfoList = new Holder<UserInfos>();
        try
        {
            ivsProfessionalUserManager.getUserList(domainCode, unifiedQuery, resultCode, userInfoList);
        }
        catch (Exception e)
        {
            LOGGER.error("getUserList method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        UserInfos users = userInfoList.value;
        if (null != users && null != users.getUserInfoList())
        {
            List<UserInfo> userInfos = users.getUserInfoList().getUserInfo();
            if (null != userInfos && !userInfos.isEmpty())
            {
                for (UserInfo userInfo : userInfos)
                {
                    if (!StringUtils.isNullOrEmpty(userInfo.getPassword()))
                    {
                        userInfo.setPassword(AES128Utils.decodeFromBase64(userInfo.getPassword()));
                    }
                }
            }
        }
        
        result.setResult(users);
        result.setResultCode(resultCode.value);
        
        LOGGER.info("execute getUserList method completed");
        
        return result;
    }
    
    @Override
    public Integer deleteUser(String domainCode, Integer userId)
    {
        LOGGER.info("begin to execute deleteUser method");
        
        try
        {
            Integer errorCode = ivsProfessionalUserManager.deleteUser(domainCode, userId);
            LOGGER.info("execute deleteUser method completed");
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("deleteUser method exception happened", e);
            
            return ExceptionUtils.processSoapException(e);
        }
        
    }
    
    @Override
    public Integer modifyUser(UserInfo userInfo)
    {
        
        LOGGER.info("begin to execute modifyUser method");
        
        if (null == userInfo)
        {
            return NativeConstant.SDK_PARAM_NOT_COMPLETE_ERRORCODE;
        }
        
        if (!StringUtils.isNullOrEmpty(userInfo.getPassword()))
        {
            String encodePwd = null;
            try
            {
                // 加密方式向下兼容
                encodePwd = Encrypt.getEncryptPwd(userInfo.getPassword());
                if (StringUtils.isNullOrEmpty(encodePwd))
                {
                    return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
                }
            }
            catch (Exception e)
            {
                LOGGER.debug("encode password error");
                return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
            }
            userInfo.setPassword(encodePwd);
        }
        
        try
        {
            
            Integer errorCode = ivsProfessionalUserManager.modifyUser(userInfo);
            LOGGER.info("execute modifyUser method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("modifyUser method exception happened", e);
            
            return ExceptionUtils.processSoapException(e);
        }
        
    }
    
    @Override
    public Integer changePassword(String oldPwd, String newPwd)
    {
        LOGGER.info("begin to execute changePassword method");
        
        String encodeNewPwd = null;
        String encodeOldPwd = null;
        if (!StringUtils.isNullOrEmpty(oldPwd) && !StringUtils.isNullOrEmpty(newPwd))
        {
            try
            {
                // 加密方式向下兼容
                encodeNewPwd = Encrypt.getEncryptPwd(newPwd);
                if (StringUtils.isNullOrEmpty(encodeNewPwd))
                {
                    return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
                }
            }
            catch (Exception e)
            {
                LOGGER.debug("encode password error");
                return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
            }
            
            try
            {
                // 加密方式向下兼容
                encodeOldPwd = Encrypt.getEncryptPwd(oldPwd);
                if (StringUtils.isNullOrEmpty(encodeOldPwd))
                {
                    return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
                }
            }
            catch (Exception e)
            {
                LOGGER.debug("encode password error");
                return PlatformNativeConstant.SDK_TP_PASSWORD_ENCODE_ERRORCODE;
            }
        }
        else
        {
            return NativeConstant.SDK_PARAM_NOT_COMPLETE_ERRORCODE;
        }
        
        try
        {
            
            Integer errorCode = ivsProfessionalUserManager.changePassword(encodeOldPwd, encodeNewPwd);
            LOGGER.info("execute changePassword method completed");
            
            return errorCode;
        }
        catch (Exception e)
        {
            LOGGER.error("changePassword method exception happened", e);
            
            return ExceptionUtils.processSoapException(e);
        }
        
    }
    
    @Override
    public IVSSDKResponse<UserGroupInfos> getUserGroupList(String domainCode, IndexRange indexRange)
    {
        LOGGER.info("begin to execute getUserGroupList method");
        
        IVSSDKResponse<UserGroupInfos> result = new IVSSDKResponse<UserGroupInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<UserGroupInfos> userGroupInfos = new Holder<UserGroupInfos>();
        try
        {
            ivsProfessionalUserManager.getUserGroupList(domainCode, indexRange, resultCode, userGroupInfos);
        }
        catch (Exception e)
        {
            LOGGER.error("getUserGroupList method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResult(userGroupInfos.value);
        result.setResultCode(resultCode.value);
        
        LOGGER.info("execute getUserGroupList method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<RoleInfos> getRoleList(String domainCode)
    {
        LOGGER.info("begin to execute getRoleList method");
        
        IVSSDKResponse<RoleInfos> result = new IVSSDKResponse<RoleInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<RoleInfos> roleInfos = new Holder<RoleInfos>();
        try
        {
            ivsProfessionalUserManager.getRoleList(domainCode, resultCode, roleInfos);
        }
        catch (Exception e)
        {
            LOGGER.error("getRoleList method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResult(roleInfos.value);
        result.setResultCode(resultCode.value);
        
        LOGGER.info("execute getRoleList method completed");
        
        return result;
    }
}
