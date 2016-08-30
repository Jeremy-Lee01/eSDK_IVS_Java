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
package com.huawei.esdk.ivs.northcommu.cxf.professional.convert;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.common.util.StringUtils;

import com.huawei.esdk.ivs.common.CipherUtils;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.User;
import com.huawei.esdk.ivs.domain.model.UserGroup;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.OrderCondition;
import com.huawei.esdk.ivs.domain.model.bean.PwdConsist;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RoleInfo;
import com.huawei.esdk.ivs.domain.model.bean.RoleInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetUserGroupListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetUserInfoResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetUserListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryField;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RoleInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.UserGroupInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.UserGroupInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.UserGroupInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.UserInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.UserInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.UserInfos;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 用户管理模块数据转换类
 * <p>
 * 用于南北向用户管理模块接口数据的转换
 * <p>
 * @author  gWX169839
 * @see  [相关类/方法]
 * @since eSDK IVS V100R003C00
 */
public class IVSProfessionalUserManagerConvert
{
    
    /** 
    * 将南向返回的领域封装对象转成北向的响应体
    *
    * @param result 南向返回的领域封装对象
    * @return GetUserListResponse 北向用户列表响应体
     * @throws SDKException 
    * @since  eSDK IVS V100R003C00
    */
    public GetUserListResponse getUserListResponseModal2Soap(SDKResult<User> result) throws SDKException
    {
        
        GetUserListResponse getUserListResponse = new GetUserListResponse();
        getUserListResponse.setResultCode((int)result.getErrCode());
        
        User userModal = result.getResult();
        
        if (null == userModal)
        {
            return getUserListResponse;
        }
        
        UserInfos userList = new UserInfos();
        
        userList.setTotal(userModal.getTotal());
        userList.setReserve(userModal.getReserve());
        if (null != userModal.getIndexRange())
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexSoap =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
            indexSoap.setFromIndex(userModal.getIndexRange().getFromIndex());
            indexSoap.setToIndex(userModal.getIndexRange().getToIndex());
            userList.setIndexRange(indexSoap);
        }
        
        UserInfoList userInfoList = new UserInfoList();
        if (null != userModal.getUserList() && !userModal.getUserList().isEmpty())
        {
            for (com.huawei.esdk.ivs.domain.model.bean.UserInfo user : userModal.getUserList())
            {
                userInfoList.getUserInfo().add(getUserInfoModal2Soap(user));
            }
        }
        userList.setUserInfoList(userInfoList);
        
        getUserListResponse.setUserInfos(userList);
        
        return getUserListResponse;
    }
    
    /** 
    * 将南向返回的领域封装对象转成北向的响应体
    *
    * @param result 南向返回的领域封装对象
    * @return GetUserInfoResponse 北向用户信息响应体
     * @throws SDKException 
    * @since  eSDK IVS V100R003C00
    */
    public GetUserInfoResponse getUserInfoResponseModal2Soap(
        SDKResult<com.huawei.esdk.ivs.domain.model.bean.UserInfo> result) throws SDKException
    {
        GetUserInfoResponse getUserInfoResponse = new GetUserInfoResponse();
        getUserInfoResponse.setResultCode((int)result.getErrCode());
        
        if(0 == result.getErrCode())
        {
            getUserInfoResponse.setUserInfo(getUserInfoModal2Soap(result.getResult()));
        }
        
        return getUserInfoResponse;
    }
    
    /** 
    * 转换领域层用户信息为北向bean
    *
    * @param user 领域层用户信息
    * @return UserInfo 北向用户信息
     * @throws SDKException 
    * @since  eSDK IVS V100R003C00
    */
    private UserInfo getUserInfoModal2Soap(com.huawei.esdk.ivs.domain.model.bean.UserInfo user) throws SDKException
    {
        if(null == user)
        {
            return null;
        }
        
        UserInfo userInfo = new UserInfo();
        
        userInfo.setDomainCode(user.getDomainCode());
        userInfo.setMail(user.getEmail());
        userInfo.setGroupId(user.getGroupId());
        userInfo.setUserId(user.getId());
        userInfo.setIsFirstLogin(user.getIsFirstLogin() ? 1 : 0);
        userInfo.setLockTime(user.getLockTime());
        userInfo.setLoginName(user.getLoginName());
        userInfo.setMaxSessionCount(user.getMaxSessionCount());
        userInfo.setMaxVideoCount(user.getMaxVideoCount());
        if (!StringUtils.isEmpty(user.getPassword()))
        {
            String pas = "";
            try
            {
                pas = CipherUtils.encode(user.getPassword());
            }
            catch (SDKException e)
            {
                throw e;
            }
            if (StringUtils.isEmpty(pas))
            {
                SDKException sdkException = new SDKException(ErrInfo.PWD_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.PWD_ERRORCODE);
                throw sdkException;
            }
            
            userInfo.setPassword(pas);
        }
        else
        {
            userInfo.setPassword(user.getPassword());
        }
        userInfo.setPhone(user.getPhone());
        userInfo.setPtzLevel(user.getPtzLevel());
        userInfo.setPwdModifyDate(user.getPwdModifyDate());
        userInfo.setRegisterDate(user.getRegisterDate());
        userInfo.setReserve(user.getReserve());
        userInfo.setRoleId(user.getRoleId());
        userInfo.setSex(user.getSex());
        
        userInfo.setValidDateFlag(user.getValidDateFlag());
        userInfo.setValidDateStart(user.getValidDateStart());
        userInfo.setValidDateEnd(user.getValidDateEnd());
        
        userInfo.setStatus(user.getStatus());
        userInfo.setUserDesc(user.getUserDesc());
        userInfo.setUserDomain(user.getUserDomain());
        userInfo.setUserName(user.getUserName());
        userInfo.setUserType(user.getUserType());
        return userInfo;
    }
    
    /** 
    * 转换北向用户信息为领域层bean
    *
    * @param UserInfo 北向用户信息
    * @return UserInfo 领域层用户信息
     * @throws SDKException 
    * @since  eSDK IVS V100R003C00
    */
    public com.huawei.esdk.ivs.domain.model.bean.UserInfo getUserInfoSoap2Modal(UserInfo userInfo) throws SDKException
    {
        if(null == userInfo)
        {
            return null;
        }
        
        com.huawei.esdk.ivs.domain.model.bean.UserInfo user = new com.huawei.esdk.ivs.domain.model.bean.UserInfo();
        user.setDomainCode(userInfo.getDomainCode());
        user.setEmail(userInfo.getMail());
        user.setGroupId(userInfo.getGroupId());
        user.setId(userInfo.getUserId());
        user.setIsFirstLogin(0 == userInfo.getIsFirstLogin() ? false : true);
        user.setLockTime(userInfo.getLockTime());
        user.setLoginName(userInfo.getLoginName());
        user.setMaxSessionCount(userInfo.getMaxSessionCount());
        user.setMaxVideoCount(userInfo.getMaxVideoCount());
        String password = userInfo.getPassword();
        if (!StringUtils.isEmpty(password))
        {
            password = CipherUtils.decodeFromBase64(password);
            if (StringUtils.isEmpty(password))
            {
                SDKException sdkException = new SDKException(ErrInfo.PWD_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.PWD_ERRORCODE);
                throw sdkException;
            }
        }
        user.setPassword(password);
        user.setPhone(userInfo.getPhone());
        user.setPtzLevel(userInfo.getPtzLevel());
        user.setPwdModifyDate(userInfo.getPwdModifyDate());
        user.setRegisterDate(userInfo.getRegisterDate());
        user.setReserve(userInfo.getReserve());
        user.setRoleId(userInfo.getRoleId());
        user.setSex(userInfo.getSex());
        
        user.setValidDateFlag(userInfo.getValidDateFlag());
        user.setValidDateStart(userInfo.getValidDateStart());
        user.setValidDateEnd(userInfo.getValidDateEnd());
        
        user.setStatus(userInfo.getStatus());
        user.setUserDesc(userInfo.getUserDesc());
        user.setUserDomain(userInfo.getUserDomain());
        user.setUserName(userInfo.getUserName());
        user.setUserType(userInfo.getUserType());
        return user;
    }
    
    /** 
    * 转换北向QueryUnifiedFormat为领域层bean
    *
    * @param unifiedQuery 北向获取用户列表查询条件
    * @return QueryUnifiedFormat 领域层获取用户列表查询条件
    * @since  eSDK IVS V100R003C00
    */
    public QueryUnifiedFormat getQueryUnfiedSoap2Modal(
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryUnifiedFormat unifiedQuery)
    {
        if(null == unifiedQuery)
        {
            return null;
        }
        
        QueryUnifiedFormat queryUnifiedFormat = new QueryUnifiedFormat();
        queryUnifiedFormat.setFieldNum(unifiedQuery.getFieldNum());
        if (null != unifiedQuery.getIndex())
        {
            IndexRange index = new IndexRange();
            index.setFromIndex(unifiedQuery.getIndex().getFromIndex());
            index.setToIndex(unifiedQuery.getIndex().getToIndex());
            queryUnifiedFormat.setIndex(index);
        }
        if (null != unifiedQuery.getOrderCondition())
        {
            OrderCondition order = new OrderCondition();
            order.setEnableOrder(unifiedQuery.getOrderCondition().getEnableOrder());
            order.setField(unifiedQuery.getOrderCondition().getFieldType());
            order.setIsAscend(unifiedQuery.getOrderCondition().getIsAscend());
            queryUnifiedFormat.setOrderCondition(order);
        }
        if (null != unifiedQuery.getQueryFieldList())
        {
            List<com.huawei.esdk.ivs.domain.model.bean.QueryField> queryFields =
                new ArrayList<com.huawei.esdk.ivs.domain.model.bean.QueryField>();
            for (QueryField item : unifiedQuery.getQueryFieldList().getQueryField())
            {
                com.huawei.esdk.ivs.domain.model.bean.QueryField field =
                    new com.huawei.esdk.ivs.domain.model.bean.QueryField();
                field.setExactQuery(item.getExactQuery());
                field.setFieldType(item.getFieldType());
                field.setValue(item.getValue());
                queryFields.add(field);
            }
            queryUnifiedFormat.setQueryField(queryFields);
        }
        return queryUnifiedFormat;
    }
    
    public IndexRange getIndexRangeSoap2Model(com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexRangeSoap)
    {
        IndexRange indexRangeModel = new IndexRange();
        indexRangeModel.setFromIndex(indexRangeSoap.getFromIndex());
        indexRangeModel.setToIndex(indexRangeSoap.getToIndex());
        
        return indexRangeModel;
    }
    
    public GetUserGroupListResponse getUserGroupListResponseModel2Soap(SDKResult<UserGroup> result)
    {
        GetUserGroupListResponse response = new GetUserGroupListResponse();
        
        UserGroup userGroupModel = result.getResult();
        
        if (null == userGroupModel)
        {
            return response;
        }
        
        UserGroupInfos userGroupinfo = new UserGroupInfos();
        
        userGroupinfo.setTotal(userGroupModel.getTotal());
        userGroupinfo.setReserve(userGroupModel.getReserve());
        if (null != userGroupModel.getIndexRange())
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexSoap =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
            indexSoap.setFromIndex(userGroupModel.getIndexRange().getFromIndex());
            indexSoap.setToIndex(userGroupModel.getIndexRange().getToIndex());
            userGroupinfo.setIndexRange(indexSoap);
        }
        
        UserGroupInfoList userGroupInfoList = new UserGroupInfoList();
        if (null != userGroupModel.getUserGroupList() && !userGroupModel.getUserGroupList().isEmpty())
        {
            for (com.huawei.esdk.ivs.domain.model.bean.UserGroupInfo userGroup : userGroupModel.getUserGroupList())
            {
                userGroupInfoList.getUserGroupInfo().add(getUserGroupInfoModel2Soap(userGroup));
            }
        }
        userGroupinfo.setUserGroupInfoList(userGroupInfoList);
        
        response.setUserGroupInfos(userGroupinfo);
        
        return response;
    }
    
    public UserGroupInfo getUserGroupInfoModel2Soap(com.huawei.esdk.ivs.domain.model.bean.UserGroupInfo userGroup)
    {
        UserGroupInfo userGroupInfo = new UserGroupInfo();
       
        userGroupInfo.setDomainCode(userGroup.getDomainCode());
        userGroupInfo.setGroupDesc(userGroup.getGroupDesc());
        userGroupInfo.setGroupID(userGroup.getGroupID());
        userGroupInfo.setGroupName(userGroup.getGroupName());
        userGroupInfo.setLevel(userGroup.getLevel());
        userGroupInfo.setParentGroupID(userGroup.getParentGroupID());
        userGroupInfo.setReserve(userGroup.getReserve());
        
        return userGroupInfo;
    }

    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RoleInfos getRoleListModal2Soap(RoleInfos result)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RoleInfos roleInfos = 
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RoleInfos();
        if(null != result.getIndexRange())
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexRange = 
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
            indexRange.setFromIndex(result.getIndexRange().getFromIndex());
            indexRange.setToIndex(result.getIndexRange().getToIndex());
            roleInfos.setIndexRange(indexRange);
        }
        
        roleInfos.setTotal(result.getTotal());
        roleInfos.setReserve(result.getReserve());
        
        if(null != result.getRoleInfoList())
        {
            RoleInfoList roleInfoListSoap = new RoleInfoList();
            for(RoleInfo roleInfoModal : result.getRoleInfoList())
            {
                roleInfoListSoap.getRoleInfo().add(getRoleInfoModal2Soap(roleInfoModal));
                
            }
            roleInfos.setRoleInfoList(roleInfoListSoap);
        }
        
        return roleInfos;
    }

    public com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RoleInfo 
        getRoleInfoModal2Soap(RoleInfo roleInfoModal)
    {
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RoleInfo roleInfo = 
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RoleInfo();
        
        if(null != roleInfoModal.getAccountRule())
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AccountRule accountRule = 
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AccountRule();
            accountRule.setAccountBackNotFit(roleInfoModal.getAccountRule().getAccountBackNotFit());
            accountRule.setAccountLockElapse(roleInfoModal.getAccountRule().getAccountLockElapse());
            accountRule.setAccountLockInterval(roleInfoModal.getAccountRule().getAccountLockInterval());
            accountRule.setAccountLockNum(roleInfoModal.getAccountRule().getAccountLockNum());
            accountRule.setAccountNotFit(roleInfoModal.getAccountRule().getAccountNotFit());
            accountRule.setCheckOldPwd(roleInfoModal.getAccountRule().getCheckOldPwd());
            accountRule.setDomainAccCheckPwd(roleInfoModal.getAccountRule().getDomainAccCheckPwd());
            accountRule.setEnable(roleInfoModal.getAccountRule().getEnable());
            accountRule.setFirstModify(roleInfoModal.getAccountRule().getFirstModify());
            
            PwdConsist pwdConsistModal = roleInfoModal.getAccountRule().getPwdConsist();
            if(null != pwdConsistModal)
            {
                com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PwdConsist pwdConsistSoap = 
                    new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PwdConsist();
                pwdConsistSoap.setCapital(pwdConsistModal.getCapital());
                pwdConsistSoap.setFigure(pwdConsistModal.getFigure());
                pwdConsistSoap.setLowercase(pwdConsistModal.getLowercase());
                pwdConsistSoap.setReserve(pwdConsistModal.getReserve());
                pwdConsistSoap.setSpecialChar(pwdConsistModal.getSpecialChar());
                accountRule.setPwdConsist(pwdConsistSoap);
            }
            
            accountRule.setPwdDifferentNum(roleInfoModal.getAccountRule().getPwdDifferentNum());
            accountRule.setPwdExpireForceNotify(roleInfoModal.getAccountRule().getPwdExpireForceNotify());
            accountRule.setPwdExpireNotifyTime(roleInfoModal.getAccountRule().getPwdExpireNotifyTime());
            accountRule.setPwdExpireTime(roleInfoModal.getAccountRule().getPwdExpireTime());
            accountRule.setPwdMinLen(roleInfoModal.getAccountRule().getPwdMinLen());
            accountRule.setReserve(roleInfoModal.getAccountRule().getReserve());
            roleInfo.setAccountRule(accountRule);
        }
  
        roleInfo.setDomainCode(roleInfoModal.getDomainCode());
        roleInfo.setReserve(roleInfoModal.getReserve());
        roleInfo.setRight(roleInfoModal.getRight());
        roleInfo.setRoleDescribe(roleInfoModal.getRoleDescribe());
        roleInfo.setRoleID(roleInfoModal.getRoleID());
        roleInfo.setRoleName(roleInfoModal.getRoleName());
        roleInfo.setRoleType(roleInfoModal.getRoleType());
        
        return roleInfo;
    }
}
