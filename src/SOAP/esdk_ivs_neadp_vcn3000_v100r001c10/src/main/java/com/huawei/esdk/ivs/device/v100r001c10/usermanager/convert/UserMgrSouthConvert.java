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
package com.huawei.esdk.ivs.device.v100r001c10.usermanager.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.User;
import com.huawei.esdk.ivs.domain.model.UserGroup;
import com.huawei.esdk.ivs.domain.model.bean.AccountRule;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.OrderCondition;
import com.huawei.esdk.ivs.domain.model.bean.PwdConsist;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RoleInfo;
import com.huawei.esdk.ivs.domain.model.bean.RoleInfos;
import com.huawei.esdk.ivs.domain.model.bean.UserGroupInfo;
import com.huawei.esdk.ivs.domain.model.bean.UserInfo;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.PwdConsistSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.QueryFieldSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.QueryUnifiedFormatSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.RoleInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.RoleInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.UserGroupInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.UserGroupInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.UserInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.UserInfoSouth;
import com.huawei.esdk.platform.common.utils.BytesUtils;

/**
 * 南向转化类
 * <p>
 * @author  gWX169839
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class UserMgrSouthConvert
{
    /** 
    * 领域层的userInfo转换为南向的对象
    *
    * @param userInfo 领域层的用户信息
    * @return UserInfoSouth 南向的用户信息
    * @since  eSDK IVS V100R003C00
    */
    public UserInfoSouth getUserInfoModal2Soap(UserInfo userInfo)
    {
        UserInfoSouth userInfoSouth = new UserInfoSouth();
        userInfoSouth.clear();
        
        if (null != userInfo.getDomainCode())
        {
            userInfoSouth.domainCode = BytesUtils.stringToBytesForIVS(userInfo.getDomainCode());
        }
        if (null != userInfo.getEmail())
        {
            userInfoSouth.email = BytesUtils.stringToBytesForIVS(userInfo.getEmail());
        }
        
        userInfoSouth.groupId = userInfo.getGroupId();
        
        if (null != userInfo.getIsFirstLogin())
        {
            userInfoSouth.isFirstLogin = userInfo.getIsFirstLogin() ? 1 : 0;
        }
        
        if (null != userInfo.getLockTime())
        {
            userInfoSouth.lockTime = BytesUtils.stringToBytesForIVS(userInfo.getLockTime());
        }
        if (null != userInfo.getLoginName())
        {
            userInfoSouth.loginName = BytesUtils.stringToBytesForIVS(userInfo.getLoginName());
        }
        
        userInfoSouth.maxSessionCount = userInfo.getMaxSessionCount();
        
        userInfoSouth.maxVideoCount = userInfo.getMaxVideoCount();
        
        if (null != userInfo.getPassword())
        {
            userInfoSouth.password = BytesUtils.stringToBytesForIVS(userInfo.getPassword());
        }
        if (null != userInfo.getPhone())
        {
            userInfoSouth.phone = BytesUtils.stringToBytesForIVS(userInfo.getPhone());
        }
        
        userInfoSouth.ptzLevel = userInfo.getPtzLevel();
        
        if (null != userInfo.getPwdModifyDate())
        {
            userInfoSouth.pwdModifyDate = BytesUtils.stringToBytesForIVS(userInfo.getPwdModifyDate());
        }
        if (null != userInfo.getRegisterDate())
        {
            userInfoSouth.registerDate = BytesUtils.stringToBytesForIVS(userInfo.getRegisterDate());
        }
        if (null != userInfo.getReserve())
        {
            userInfoSouth.reserve = BytesUtils.stringToBytesForIVS(userInfo.getReserve());
        }
        
        userInfoSouth.roleId = userInfo.getRoleId();
        
        userInfoSouth.sex = userInfo.getSex();
        
        userInfoSouth.validDateFlag = userInfo.getValidDateFlag();
        
        userInfoSouth.validDateStart = BytesUtils.stringToBytesForIVS(userInfo.getValidDateStart());
        
        userInfoSouth.validDateEnd = BytesUtils.stringToBytesForIVS(userInfo.getValidDateEnd());
        
        userInfoSouth.status = userInfo.getStatus();
        
        if (null != userInfo.getUserDesc())
        {
            userInfoSouth.userDesc = BytesUtils.stringToBytesForIVS(userInfo.getUserDesc());
        }
        if (null != userInfo.getUserDomain())
        {
            userInfoSouth.userDomain = BytesUtils.stringToBytesForIVS(userInfo.getUserDomain());
        }
        
        userInfoSouth.userId = userInfo.getId();
        
        if (null != userInfo.getUserName())
        {
            userInfoSouth.userName = BytesUtils.stringToBytesForIVS(userInfo.getUserName());
        }
        
        userInfoSouth.userType = userInfo.getUserType();
        
        return userInfoSouth;
    }
    
    /** 
    * 领域层的QueryUnifiedFormat转换为南向的
    *
    * @param queryUnifiedFormat 查询通用格式
    * @return QueryUnifiedFormatSouth 南向查询通用格式
    * @since  eSDK IVS V100R003C00
    */
    public QueryUnifiedFormatSouth getUnifiedQueryModal2Soap(QueryUnifiedFormat unifiedQuery)
    {
        // modify by cWX191990，fieldNum小于0时，默认也需要初始化一个查询条件，问题单号DTS2014022507270
        QueryUnifiedFormatSouth queryUnifiedFormatSouth = null;
        
        if (unifiedQuery.getQueryField().size() == 0)
        {
            queryUnifiedFormatSouth = new QueryUnifiedFormatSouth(1);
        }
        else
        {
            queryUnifiedFormatSouth = new QueryUnifiedFormatSouth(unifiedQuery.getQueryField().size());
        }
        
        queryUnifiedFormatSouth.clear();
        
        queryUnifiedFormatSouth.iFieldNum = unifiedQuery.getFieldNum();
        
        com.huawei.esdk.ivs.domain.model.bean.IndexRange indexModal = unifiedQuery.getIndex();
        if (null != indexModal)
        {
            queryUnifiedFormatSouth.index.fromIndex = indexModal.getFromIndex();
            queryUnifiedFormatSouth.index.toIndex = indexModal.getToIndex();
        }
        
        QueryFieldSouth[] qfSouth = null;
        
        if (unifiedQuery.getQueryField().size() == 0)
        {
            qfSouth = new QueryFieldSouth[1];
        }
        else
        {
            qfSouth = new QueryFieldSouth[unifiedQuery.getQueryField().size()];
            
            for (int i = 0; i < unifiedQuery.getQueryField().size(); i++)
            {
                QueryFieldSouth qfs = new QueryFieldSouth();
                
                // 固定内存
                qfs.clear();
                qfs.isExactQuery = unifiedQuery.getQueryField().get(i).getExactQuery();
                qfs.eFieId = unifiedQuery.getQueryField().get(i).getFieldType();
                qfs.value = BytesUtils.stringToBytesForIVS(unifiedQuery.getQueryField().get(i).getValue());
                qfSouth[i] = qfs;
            }
        }
        
        queryUnifiedFormatSouth.queryFields = qfSouth;
        
        OrderCondition orderConditionModal = unifiedQuery.getOrderCondition();
        
        if (null != orderConditionModal)
        {
            queryUnifiedFormatSouth.stOrderCond.enableOrder = orderConditionModal.getEnableOrder();
            queryUnifiedFormatSouth.stOrderCond.eFieId = orderConditionModal.getField();
            queryUnifiedFormatSouth.stOrderCond.isAscend = orderConditionModal.getIsAscend();
        }
        
        return queryUnifiedFormatSouth;
    }
    
    /** 
    * 南向的UserInfoListSouth转换为领域层的对象
    *
    * @param UserInfoListSouth 南向的用户列表信息
    * @return User 领域层的用户对象
    * @since  eSDK IVS V100R003C00
    */
    public User getUserListSoap2Modal(UserInfoListSouth pUserList)
    {
        
        User userModal = new User();
        
        userModal.setTotal(pUserList.total);
        
        userModal.setReserve(BytesUtils.bytesToStringForIVS(pUserList.reserve));
        
        IndexRange indexRange = new IndexRange();
        indexRange.setFromIndex(pUserList.index.fromIndex);
        indexRange.setToIndex(pUserList.index.toIndex);
        userModal.setIndexRange(indexRange);
        
        UserInfoSouth[] userListSouth = pUserList.userInfos;
        
        List<UserInfo> userList = new ArrayList<UserInfo>();
        
        if (null != userListSouth && userListSouth.length > 0)
        {
            
            int length =
                getLength(pUserList.total, userListSouth.length, indexRange.getFromIndex(), indexRange.getToIndex());
            
            for (int i = 0; i < length; i++)
            {
                UserInfo user = getUserInfoSoap2Modal(userListSouth[i]);
                userList.add(user);
            }
            
        }
        
        userModal.setUserList(userList);
        
        return userModal;
    }
    
    public int getLength(int total, int size, int fromIndex, int toIndex)
    {
        int length = 0;
        if (total < size)
        {
            length = toIndex < total ? toIndex : total;
            int temp = length - (fromIndex > 1 ? fromIndex : 1) + 1;
            length = length < temp ? length : temp;
        }
        else
        {
            length = toIndex < total ? toIndex : total;
            int temp = length - (fromIndex > 1 ? fromIndex : 1) + 1;
            length = size < temp ? size : temp;
        }
        return length;
    }
    
    /** 
    * 南向的UserInfoSouth转换为领域层的对象
    *
    * @param UserInfoSouth 南向的用户信息
    * @return UserInfo 领域层的用户对象
    * @since  eSDK IVS V100R003C00
    */
    public UserInfo getUserInfoSoap2Modal(UserInfoSouth userInfoSouth)
    {
        UserInfo usermodal = new UserInfo();
        
        usermodal.setDomainCode(BytesUtils.bytesToStringForIVS(userInfoSouth.domainCode));
        usermodal.setEmail(BytesUtils.bytesToStringForIVS(userInfoSouth.email));
        usermodal.setGroupId(userInfoSouth.groupId);
        usermodal.setIsFirstLogin(0 == userInfoSouth.isFirstLogin ? false : true);
        usermodal.setLockTime(BytesUtils.bytesToStringForIVS(userInfoSouth.lockTime));
        usermodal.setLoginName(BytesUtils.bytesToStringForIVS(userInfoSouth.loginName));
        usermodal.setMaxSessionCount(userInfoSouth.maxSessionCount);
        usermodal.setMaxVideoCount(userInfoSouth.maxVideoCount);
        usermodal.setPassword(BytesUtils.bytesToStringForIVS(userInfoSouth.password));
        usermodal.setPhone(BytesUtils.bytesToStringForIVS(userInfoSouth.phone));
        usermodal.setPtzLevel(userInfoSouth.ptzLevel);
        usermodal.setPwdModifyDate(BytesUtils.bytesToStringForIVS(userInfoSouth.pwdModifyDate));
        usermodal.setRegisterDate(BytesUtils.bytesToStringForIVS(userInfoSouth.registerDate));
        usermodal.setReserve(BytesUtils.bytesToStringForIVS(userInfoSouth.reserve));
        usermodal.setRoleId(userInfoSouth.roleId);
        usermodal.setSex(userInfoSouth.sex);
        
        usermodal.setValidDateFlag(userInfoSouth.validDateFlag);
        usermodal.setValidDateStart(BytesUtils.bytesToStringForIVS(userInfoSouth.validDateStart));
        usermodal.setValidDateEnd(BytesUtils.bytesToStringForIVS(userInfoSouth.validDateEnd));
        
        usermodal.setStatus(userInfoSouth.status);
        usermodal.setUserDesc(BytesUtils.bytesToStringForIVS(userInfoSouth.userDesc));
        usermodal.setUserDomain(BytesUtils.bytesToStringForIVS(userInfoSouth.userDomain));
        usermodal.setId(userInfoSouth.userId);
        usermodal.setUserName(BytesUtils.bytesToStringForIVS(userInfoSouth.userName));
        usermodal.setUserType(userInfoSouth.userType);
        
        return usermodal;
    }
    
    public UserGroup getUserGroupListJNA2Model(UserGroupInfoListSouth userGroupList)
    {
        UserGroup userGroup = new UserGroup();
        
        userGroup.setTotal(userGroupList.total);
        userGroup.setReserve(BytesUtils.bytesToStringForIVS(userGroupList.reserve));
        
        IndexRange indexRange = new IndexRange();
        indexRange.setFromIndex(userGroupList.index.fromIndex);
        indexRange.setToIndex(userGroupList.index.toIndex);
        userGroup.setIndexRange(indexRange);
        
        UserGroupInfoSouth[] userGroupListSouth = userGroupList.userGroupInfos;
        
        List<UserGroupInfo> userGroupModelList = new ArrayList<UserGroupInfo>();
        
        if (null != userGroupListSouth && userGroupListSouth.length > 0)
        {
            int length =
                getLength(userGroupList.total,
                    userGroupListSouth.length,
                    indexRange.getFromIndex(),
                    indexRange.getToIndex());
            
            for (int i = 0; i < length; i++)
            {
                UserGroupInfo userGroupInfo = getUserGroupInfoJNA2Model(userGroupListSouth[i]);
                userGroupModelList.add(userGroupInfo);
            }
            
        }
        
        userGroup.setUserGroupList(userGroupModelList);
        return userGroup;
    }
    
    public UserGroupInfo getUserGroupInfoJNA2Model(UserGroupInfoSouth userGroupInfoSouth)
    {
        UserGroupInfo userGroupInfo = new UserGroupInfo();
        
        userGroupInfo.setDomainCode(BytesUtils.bytesToStringForIVS(userGroupInfoSouth.domainCode));
        userGroupInfo.setGroupDesc(BytesUtils.bytesToStringForIVS(userGroupInfoSouth.groupDesc));
        userGroupInfo.setGroupID(userGroupInfoSouth.id);
        userGroupInfo.setGroupName(BytesUtils.bytesToStringForIVS(userGroupInfoSouth.name));
        userGroupInfo.setLevel(userGroupInfoSouth.level);
        userGroupInfo.setParentGroupID(userGroupInfoSouth.parentId);
        userGroupInfo.setReserve(BytesUtils.bytesToStringForIVS(userGroupInfoSouth.reserve));
        
        return userGroupInfo;
    }
    
    public RoleInfos getRoleListSoap2Modal(RoleInfoListSouth roleInfoList)
    {
        
        RoleInfos roleInfos = new RoleInfos();
        if (null != roleInfoList.indexRange)
        {
            IndexRange indexRange = new IndexRange();
            indexRange.setFromIndex(roleInfoList.indexRange.fromIndex);
            indexRange.setToIndex(roleInfoList.indexRange.toIndex);
            roleInfos.setIndexRange(indexRange);
        }
        
        roleInfos.setTotal(roleInfoList.total);
        roleInfos.setReserve(BytesUtils.bytesToStringForIVS(roleInfoList.reserve));
        
        if (null != roleInfoList.roleInfos)
        {
            List<RoleInfo> roleInfoListModal = new ArrayList<RoleInfo>();
            int count = 0;
            for (RoleInfoSouth roleInfoSouth : roleInfoList.roleInfos)
            {
                if (count < roleInfoList.total)
                {
                    roleInfoListModal.add(getRoleInfoSoap2Modal(roleInfoSouth));
                }
                else
                {
                    break;
                }
                count++;
            }
            roleInfos.setRoleInfoList(roleInfoListModal);
        }
        
        return roleInfos;
    }
    
    public RoleInfo getRoleInfoSoap2Modal(RoleInfoSouth roleInfoSouth)
    {
        RoleInfo roleInfo = new RoleInfo();
        if (null != roleInfoSouth.accountRule)
        {
            AccountRule accountRule = new AccountRule();
            accountRule.setAccountBackNotFit(roleInfoSouth.accountRule.accountBackNotFit);
            accountRule.setAccountLockElapse(roleInfoSouth.accountRule.accountLockElapse);
            accountRule.setAccountLockInterval(roleInfoSouth.accountRule.accountLockInterval);
            accountRule.setAccountLockNum(roleInfoSouth.accountRule.accountLockNum);
            accountRule.setAccountNotFit(roleInfoSouth.accountRule.accountNotFit);
            accountRule.setCheckOldPwd(roleInfoSouth.accountRule.checkOldPwd);
            accountRule.setDomainAccCheckPwd(roleInfoSouth.accountRule.domainAccCheckPwd);
            accountRule.setEnable(roleInfoSouth.accountRule.enable);
            accountRule.setFirstModify(roleInfoSouth.accountRule.firstModify);
            
            PwdConsistSouth pwdConsistSouth = roleInfoSouth.accountRule.pwdConsist;
            if (null != pwdConsistSouth)
            {
                PwdConsist pwdConsistModal = new PwdConsist();
                pwdConsistModal.setCapital(pwdConsistSouth.bCapital);
                pwdConsistModal.setFigure(pwdConsistSouth.bFigure);
                pwdConsistModal.setLowercase(pwdConsistSouth.bLowercase);
                pwdConsistModal.setReserve(BytesUtils.bytesToStringForIVS(pwdConsistSouth.reserve));
                pwdConsistModal.setSpecialChar(pwdConsistSouth.bSpecialChar);
                accountRule.setPwdConsist(pwdConsistModal);
            }
            
            accountRule.setPwdDifferentNum(roleInfoSouth.accountRule.pwdDifferentNum);
            accountRule.setPwdExpireForceNotify(roleInfoSouth.accountRule.pwdExpireForceNotify);
            accountRule.setPwdExpireNotifyTime(roleInfoSouth.accountRule.pwdExpireNotifyTime);
            accountRule.setPwdExpireTime(roleInfoSouth.accountRule.pwdExpireTime);
            accountRule.setPwdMinLen(roleInfoSouth.accountRule.pwdMinLen);
            accountRule.setReserve(BytesUtils.bytesToStringForIVS(roleInfoSouth.accountRule.reserve));
            roleInfo.setAccountRule(accountRule);
        }
        
        roleInfo.setDomainCode(BytesUtils.bytesToStringForIVS(roleInfoSouth.domainCode));
        roleInfo.setReserve(BytesUtils.bytesToStringForIVS(roleInfoSouth.reserve));
        roleInfo.setRight(BytesUtils.bytesToStringForIVS(roleInfoSouth.right));
        roleInfo.setRoleDescribe(BytesUtils.bytesToStringForIVS(roleInfoSouth.roleDescribe));
        roleInfo.setRoleID(String.valueOf(roleInfoSouth.roleId));
        roleInfo.setRoleName(BytesUtils.bytesToStringForIVS(roleInfoSouth.roleName));
        roleInfo.setRoleType(String.valueOf(roleInfoSouth.roleType));
        
        return roleInfo;
    }
}
