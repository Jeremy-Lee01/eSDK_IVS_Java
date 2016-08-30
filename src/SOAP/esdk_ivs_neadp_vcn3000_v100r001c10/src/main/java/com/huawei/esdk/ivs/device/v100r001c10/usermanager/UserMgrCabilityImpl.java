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
package com.huawei.esdk.ivs.device.v100r001c10.usermanager;

import com.huawei.esdk.ivs.device.BaseCability;
import com.huawei.esdk.ivs.device.v100r001c10.usermanager.convert.UserMgrSouthConvert;
import com.huawei.esdk.ivs.device.vcn3000.usermanager.IUserMgrCability;
import com.huawei.esdk.ivs.domain.model.User;
import com.huawei.esdk.ivs.domain.model.UserGroup;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RoleInfos;
import com.huawei.esdk.ivs.domain.model.bean.UserInfo;
import com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.IndexRangeSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.QueryUnifiedFormatSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.RoleInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.UserGroupInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.UserInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.UserInfoSouth;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.NumberUtils;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByReference;
import com.sun.jna.ptr.IntByReference;

/**
 * 用户管理接口南向实现类
 * <p>
 * @author  gWX169839
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class UserMgrCabilityImpl extends BaseCability implements IUserMgrCability
{
	private static final int INDEX_RANGE = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("index.range"));
	
    private static UserGroupInfoListSouth USERGROUPLIST = new UserGroupInfoListSouth(
    		INDEX_RANGE);
    
    private static UserInfoListSouth PUSERLIST = new UserInfoListSouth(INDEX_RANGE);
    
    /**
     * 
     * 南向数据转换类
     * 
     */
    UserMgrSouthConvert userMgrSouthConvert = new UserMgrSouthConvert();
    
    /** 
     * 增加用户
     *
     * @param userInfo 用户信息
     * @return SDKResult<Integer> 封装领域层的SDKResult对象
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SDKResult<Integer> addUser(UserInfo userInfo)
    {
        int sessionId = getIVSSessionId();
        
        SDKResult<Integer> response = new SDKResult<Integer>();
        
        UserInfoSouth userInfoSouth = userMgrSouthConvert.getUserInfoModal2Soap(userInfo);
        
        ByReference refuserId = new IntByReference(-1);
        int errCode = super.getBaseCablilityJNA().IVS_SDK_AddUser(sessionId, userInfoSouth, refuserId);
        response.setErrCode(errCode);
        
        if (0 == errCode)
        {
            response.setResult(((IntByReference)refuserId).getValue());
        }
        
        return response;
    }
    
    /** 
     * 增加用户
     *
     * @param userInfo 用户信息
     * @return SDKResult<Integer> 封装领域层的SDKResult对象
     * @since eSDK IVS V100R003C00
     */
    @Override
    public synchronized SDKResult<User> getUserList(String domainCode, QueryUnifiedFormat unifiedQuery)
    {
        int sessionId = getIVSSessionId();
        
        SDKResult<User> response = new SDKResult<User>();
        
        QueryUnifiedFormatSouth pUnifiedQuery = userMgrSouthConvert.getUnifiedQueryModal2Soap(unifiedQuery);
        
        int fromIndex = unifiedQuery.getIndex().getFromIndex();
        int toIndex = unifiedQuery.getIndex().getToIndex();
        
        int resultArraySize = toIndex - fromIndex + 1;
        
        if (1 > resultArraySize)
        {
            resultArraySize = 1;
        }
        
        PUSERLIST.clear();
        Pointer userInfoListSouthPoint = PUSERLIST.getPointer();
        
        int errCode =
            super.getBaseCablilityJNA().IVS_SDK_GetUserList(sessionId,
                domainCode,
                pUnifiedQuery,
                userInfoListSouthPoint,
                1072 * resultArraySize + 44);
        response.setErrCode(errCode);
        
        PUSERLIST.read();
        
        if (0 == errCode)
        {
            response.setResult(userMgrSouthConvert.getUserListSoap2Modal(PUSERLIST));
        }
        
        return response;
    }
    
    /** 
     * 修改用户
     *
     * @param userInfo 用户信息
     * @return SDKErrorCode 封装领域层的SDKResult对象
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SDKErrorCode modifyUser(UserInfo userInfo)
    {
        int sessionId = getIVSSessionId();
        
        SDKErrorCode response = new SDKErrorCode();
        
        UserInfoSouth userInfoSouth = userMgrSouthConvert.getUserInfoModal2Soap(userInfo);
        
        int errCode = super.getBaseCablilityJNA().IVS_SDK_ModifyUser(sessionId, userInfoSouth);
        
        response.setErrCode(errCode);
        
        return response;
    }
    
    /** 
     * 删除用户
     *
     * @param userId 用户Id
     * @param domainCode 领域码
     * @return SDKErrorCode 封装领域层的SDKResult对象
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SDKErrorCode deleteUser(int userId, String domainCode)
    {
        int sessionId = getIVSSessionId();
        
        SDKErrorCode response = new SDKErrorCode();
        
        int errCode = super.getBaseCablilityJNA().IVS_SDK_DeleteUser(sessionId, domainCode, userId);
        
        response.setErrCode(errCode);
        
        return response;
    }
    
    /** 
     * 获取用户信息
     *
     * @param userId 用户Id
     * @param domainCode 领域码
     * @return SDKResult<UserInfo> 封装领域层的SDKResult对象
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SDKResult<UserInfo> getUserInfo(int userId, String domainCode)
    {
        int sessionId = getIVSSessionId();
        
        SDKResult<UserInfo> response = new SDKResult<UserInfo>();
        
        UserInfoSouth userInfoSouth = new UserInfoSouth();
        int errCode = super.getBaseCablilityJNA().IVS_SDK_GetUserInfo(sessionId, domainCode, userId, userInfoSouth);
        
        response.setErrCode(errCode);
        if (0 == errCode)
        {
            UserInfo user = userMgrSouthConvert.getUserInfoSoap2Modal(userInfoSouth);
            response.setResult(user);
        }
        
        return response;
    }
    
    /** 
     * 获取用户Id
     *
     * @return SDKResult<Integer> 封装领域层的SDKResult对象
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SDKResult<Integer> getUserId()
    {
        int sessionId = getIVSSessionId();
        
        SDKResult<Integer> response = new SDKResult<Integer>();
        
        IntByReference refuserId = new IntByReference();
        int errCode = super.getBaseCablilityJNA().IVS_SDK_GetUserID(sessionId, refuserId);
        
        response.setErrCode(errCode);
        if (0 == errCode)
        {
            response.setResult(refuserId.getValue());
        }
        
        return response;
    }
    
    /** 
     * 获取用户信息
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return SDKErrorCode 封装领域层的SDKResult对象
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SDKErrorCode changePassword(String oldPassword, String newPassword)
    {
        int sessionId = getIVSSessionId();
        
        SDKErrorCode response = new SDKErrorCode();
        
        int errCode = super.getBaseCablilityJNA().IVS_SDK_ChangePWD(sessionId, oldPassword, newPassword);
        
        response.setErrCode(errCode);
        
        return response;
    }

    @Override
    public synchronized SDKResult<UserGroup> getUserGroupList(String domainCode, IndexRange indexRange)
    {
        int sessionId = getIVSSessionId();
        SDKResult<UserGroup> result = new  SDKResult<UserGroup>();
        
        int fromIndex = indexRange.getFromIndex();
        int toIndex = indexRange.getToIndex();
        
        int resultArraySize = toIndex - fromIndex + 1;
        
        if (1 > resultArraySize)
        {
            resultArraySize = 1;
        }
        
        USERGROUPLIST.clear();
        IndexRangeSouth indexRangeSouth = new IndexRangeSouth();
        indexRangeSouth.clear();
        indexRangeSouth.fromIndex = fromIndex;
        indexRangeSouth.toIndex = toIndex;
        
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetUserGroupList(sessionId,
                domainCode,
                indexRangeSouth,
                USERGROUPLIST.getPointer(),
                resultArraySize * 460 + 44);
        result.setErrCode(resultCode);
        
        USERGROUPLIST.read();
        if(0 == resultCode)
        {
            result.setResult(userMgrSouthConvert.getUserGroupListJNA2Model(USERGROUPLIST));
        }
        
        return result;
    }

    @Override
    public SDKResult<RoleInfos> getRoleList(String domainCode)
    {
        int sessionId = getIVSSessionId();
        
        SDKResult<RoleInfos> response = new SDKResult<RoleInfos>();
        
        //一个区域类最大可创建的角色数
        int roleListMaxSize = 128;
        RoleInfoListSouth roleInfoList = new RoleInfoListSouth(roleListMaxSize);
        
        int bufferSize = roleInfoList.size();
        Pointer roleInfoListSouthPoint = roleInfoList.getPointer();
        
        com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.IndexRangeSouth indexRange = 
            new com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.IndexRangeSouth();
        
        int errCode = super.getBaseCablilityJNA().IVS_SDK_GetRoleList(sessionId, domainCode, indexRange,
            roleInfoListSouthPoint, bufferSize);
        
        response.setErrCode(errCode);
        
        roleInfoList.read();
        
        if (0 == errCode)
        {
            response.setResult(userMgrSouthConvert.getRoleListSoap2Modal(roleInfoList));
        }
        return response;
    }
}
