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
package com.huawei.esdk.ivs.domain.model;

import java.util.List;

import com.huawei.esdk.ivs.device.vcn3000.usermanager.IUserMgrCability;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.UserGroupInfo;
import com.huawei.esdk.ivs.domain.util.DeviceServiceProxy;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 
 * 领域模型 用户组
 * <p>
 * @author  zWX144115
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C10
 */
public class UserGroup
{
    /**
     * 返回的用户数量个数
     */
    private int total; 
    
    /**
     * 分页信息
     */
    private IndexRange indexRange;
    
    /**
     * 预留字段
     */
    private String reserve; 
    
    /**
     * 用户组列表
     */
    private List<UserGroupInfo> userGroupList; 

    /**
     * 
     * 查询用户组列表
     * 
     * @param domainCode 域编码
     * @param indexRange 查询条件
     * @return  用户组列表
     * @throws SDKException
     * @since  eSDK IVS V100R003C10
     */
    public SDKResult<UserGroup> getUserGroupList(String domainCode, IndexRange indexRange)
        throws SDKException
    {
        SDKResult<UserGroup> result = null;
        
        IUserMgrCability userMgrCability =
            DeviceServiceProxy.getInstance().getDeviceServiceProxy(IUserMgrCability.class);
        result = userMgrCability.getUserGroupList(domainCode, indexRange);
        
        return result;
    }
    
    
    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public IndexRange getIndexRange()
    {
        return indexRange;
    }

    public void setIndexRange(IndexRange indexRange)
    {
        this.indexRange = indexRange;
    }

    public String getReserve()
    {
        return reserve;
    }

    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }

    public List<UserGroupInfo> getUserGroupList()
    {
        return userGroupList;
    }

    public void setUserGroupList(List<UserGroupInfo> userGroupList)
    {
        this.userGroupList = userGroupList;
    }
}
