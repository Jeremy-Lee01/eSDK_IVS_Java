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
package com.huawei.esdk.ivs.device.vcn3000.usermanager;

import com.huawei.esdk.ivs.domain.model.User;
import com.huawei.esdk.ivs.domain.model.UserGroup;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RoleInfos;
import com.huawei.esdk.ivs.domain.model.bean.UserInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * 用户管理接口管理类
 * <p>
 * @author  gWX169839
 * @see  [相关类/方法]
 * @since  eSDK Solution V100R003C00
 */
public interface IUserMgrCability
{
    /** 
    * 增加用户
    *
    * @param userInfo 用户信息
    * @return SDKResult<Integer> 封装领域层的对象
    * @since  eSDK Solution V100R003C00
    */
    SDKResult<Integer> addUser(UserInfo userInfo);

    /** 
    * 获取用户列表信息
    *
    * @param domainCode 区域码
    * @param unifiedQuery 查询条件
    * @return SDKResult<User> 封装领域层的对象
    * @since  eSDK Solution V100R003C00
    */
    SDKResult<User> getUserList(String domainCode, QueryUnifiedFormat unifiedQuery);

    /** 
    * 修改用户信息
    *
    * @param userInfo 用户信息
    * @return SDKResult<Integer> 封装领域层的对象
    * @since  eSDK Solution V100R003C00
    */
    SDKErrorCode modifyUser(UserInfo userInfo);

    /** 
    * 删除用户
    *
    * @param userId 用户Id
    * @param domainCode 区域码
    * @return SDKResult<Integer> 封装领域层的对象
    * @since  eSDK Solution V100R003C00
    */
    SDKErrorCode deleteUser(int userId, String domainCode);

    /** 
    * 获取用户信息
    *
    * @param userId 用户信息
    * @param domainCode 区域码
    * @return SDKResult<Integer> 封装领域层的对象
    * @since  eSDK Solution V100R003C00
    */
    SDKResult<UserInfo> getUserInfo(int userId, String domainCode);

    /** 
    * 获取用户Id
    *
    * @return SDKResult<Integer> 封装领域层的对象
    * @since  eSDK Solution V100R003C00
    */
    SDKResult<Integer> getUserId();

    /** 
    * 修改密码
    *
    * @param oldPassword 旧密码
    * @param newPassword 新密码
    * @return SDKErrorCode 封装领域层的对象
    * @since  eSDK Solution V100R003C00
    */
    SDKErrorCode changePassword(String oldPassword, String newPassword);
    
    /**
     * 
     * 获取用户组列表
     * 
     * @param domainCode 域编码
     * @param indexRange  查询范围
     * @return SDKResult<UserGroup> 封装领域层的对象
     * @see eSDK Solution V100R003C10
     */
    SDKResult<UserGroup> getUserGroupList(String domainCode, IndexRange indexRange);
    
    /** 
    * 获取角色列表
    *
    * @param domainCode 区域码
    * @return SDKResult<RoleInfos> 封装领域层的对象
    * @since  eSDK Solution V100R003C00
    */
    SDKResult<RoleInfos> getRoleList(String domainCode);

}
