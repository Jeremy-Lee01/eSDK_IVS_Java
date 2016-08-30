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
package com.huawei.esdk.ivs.test.service;

import com.huawei.esdk.ivs.test.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.test.bean.IndexRange;
import com.huawei.esdk.ivs.test.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.test.bean.RoleInfos;
import com.huawei.esdk.ivs.test.bean.UserGroupInfos;
import com.huawei.esdk.ivs.test.bean.UserInfo;
import com.huawei.esdk.ivs.test.bean.UserInfos;

public interface UserManagerServiceEx {

    IVSSDKResponse<Integer> getUserId();
    IVSSDKResponse<UserInfo> getUserInfo(String domainCode, Integer userId);
    IVSSDKResponse<Integer> addUser(UserInfo userInfo);
    Integer changePassword(String oldPassword, String newPassword);
    Integer modifyUser(UserInfo userInfo);
    Integer deleteUser(String domainCode, Integer userId);
    IVSSDKResponse<UserInfos> getUserList(String domainCode, QueryUnifiedFormat unifiedQuery);
    IVSSDKResponse<RoleInfos> getRoleList(String domainCode);
    IVSSDKResponse<UserGroupInfos> getUserGroupList(String domainCode, IndexRange indexRange);
}
