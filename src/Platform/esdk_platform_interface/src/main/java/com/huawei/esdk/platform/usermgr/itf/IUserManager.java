package com.huawei.esdk.platform.usermgr.itf;

import java.util.List;

import com.huawei.esdk.platform.common.bean.config.UserConfig;

public interface IUserManager
{	
    /**
     * 获取所有用户列表
     * 
     * @return 所有用户列表
     */
    List<UserConfig> getUserList();
    
    /**
     * 根据用户ID获取用户信息
     * 
     * @param userId 用户ID
     * @return 用户信息
     */
    UserConfig getUserById(String userId);
    
    /**
     * 刷新用户，重新从文件中载入
     */
    void refreshUsers();
    
    /**
     * 检查用户名是否合法
     * 
     * @param userId 用户名
     * @param password 用户密码
     * @return true如果用户名密码正确否则返回false
     */
    boolean checkUser(String userId, String password);
}
