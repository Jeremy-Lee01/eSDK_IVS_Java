package com.huawei.esdk.platform.config.service.itf;

import java.util.List;

import com.huawei.esdk.platform.common.bean.config.UserConfig;

public interface IUserConfigService
{
    boolean addUser(UserConfig user);
    
    boolean updateUser(UserConfig user);
    
    boolean deleteUser(String userId);
    
    UserConfig getUserById(String userId);
    
    List<UserConfig> getAllUsers();
    
    void registerObserver(IConfigObserver observer);
}
