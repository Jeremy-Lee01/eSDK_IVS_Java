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
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RoleInfos;
import com.huawei.esdk.ivs.domain.model.bean.UserInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

/**
 * 领域层告警信息类
 * <p>
 * @author  gWX169839
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class User
{
    private int total; //返回的用户数量个数
    
    private IndexRange indexRange; //分页信息
    
    private String reserve; //预留字段
    
    private List<UserInfo> userList; //用户列表信息
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public SDKResult<Integer> addUser(UserInfo userInfo)
        throws SDKException
    {
        SDKResult<Integer> result = null;
        
        IUserMgrCability userMgrCability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ivs_vcn_device"),
                IUserMgrCability.class);
        result = userMgrCability.addUser(userInfo);
        
        return result;
    }
    
    public SDKResult<User> getUserList(String domainCode2, QueryUnifiedFormat unifiedQuery)
        throws SDKException
    {
        SDKResult<User> result = null;
        
        IUserMgrCability userMgrCability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ivs_vcn_device"),
                IUserMgrCability.class);
        result = userMgrCability.getUserList(domainCode2, unifiedQuery);
        
        return result;
    }
    
    public SDKErrorCode modifyUser(UserInfo userInfo)
        throws SDKException
    {
        SDKErrorCode result = null;
        
        IUserMgrCability userMgrCability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ivs_vcn_device"),
                IUserMgrCability.class);
        result = userMgrCability.modifyUser(userInfo);
        
        return result;
    }
    
    public SDKErrorCode deleteUser(int userId, String domainCode)
        throws SDKException
    {
        SDKErrorCode result = null;
        
        IUserMgrCability userMgrCability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ivs_vcn_device"),
                IUserMgrCability.class);
        result = userMgrCability.deleteUser(userId, domainCode);
        
        return result;
    }
    
    public SDKResult<UserInfo> getUserInfo(int userId, String domainCode)
        throws SDKException
    {
        SDKResult<UserInfo> result = null;
        
        IUserMgrCability userMgrCability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ivs_vcn_device"),
                IUserMgrCability.class);
        result = userMgrCability.getUserInfo(userId, domainCode);
        
        return result;
    }
    
    public SDKResult<Integer> getUserId()
        throws SDKException
    {
        SDKResult<Integer> result = null;
        
        IUserMgrCability userMgrCability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ivs_vcn_device"),
                IUserMgrCability.class);
        result = userMgrCability.getUserId();
        
        return result;
    }
    
    public SDKErrorCode changePassword(String oldPassword, String newPassword)
        throws SDKException
    {
        SDKErrorCode result = null;
        
        IUserMgrCability userMgrCability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ivs_vcn_device"),
                IUserMgrCability.class);
        result = userMgrCability.changePassword(oldPassword, newPassword);
        
        return result;
    }
    

    public SDKResult<RoleInfos> getRoleList(String domainCode)
        throws SDKException
    {
        SDKResult<RoleInfos> result = null;
        
        IUserMgrCability userMgrCability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ivs_vcn_device"),
                IUserMgrCability.class);
        result = userMgrCability.getRoleList(domainCode);
        
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
    
    public List<UserInfo> getUserList()
    {
        return userList;
    }
    
    public void setUserList(List<UserInfo> userList)
    {
        this.userList = userList;
    }

}
