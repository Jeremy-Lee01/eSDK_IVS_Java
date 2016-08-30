package com.huawei.esdk.platform.config.dao.itf;

import java.util.List;

import com.huawei.esdk.platform.common.bean.config.UserConfig;

public interface IUserDAO
{
    boolean addUser(UserConfig user);

    boolean updateUser(UserConfig user);

    boolean deleteUser(String userId);

    UserConfig getUserById(String userId);

    List<UserConfig> getAllUsers();
}
