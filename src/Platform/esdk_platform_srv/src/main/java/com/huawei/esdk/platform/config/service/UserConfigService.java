package com.huawei.esdk.platform.config.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.bean.config.UserConfig;
import com.huawei.esdk.platform.common.utils.AES128System;
import com.huawei.esdk.platform.common.utils.Base64Utils;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.config.dao.UserFileDAO;
import com.huawei.esdk.platform.config.dao.itf.IUserDAO;
import com.huawei.esdk.platform.config.service.itf.IUserConfigService;

public final class UserConfigService extends BaseService implements IUserConfigService
{
    private static final Logger LOGGER = Logger.getLogger(UserConfigService.class);
    
    private static IUserConfigService instance = new UserConfigService();
    
    private IUserDAO userDao;
    
    public static IUserConfigService getInstance()
    {
        return instance;
    }
    
    public UserConfigService()
    {
        try
        {
            String file = getFilePath("users.xml");
            
            userDao = new UserFileDAO(file);
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
        }
    }
    
    @Override
    public boolean addUser(UserConfig user)
    {
        try
        {
            user.setPassword(Base64Utils.encode(AES128System.encryptPwdByNewKey((user.getUserId() + user.getPassword()).getBytes("UTF-8"))));
            boolean result = userDao.addUser(user);
            if (result)
            {
                notifyObservers();
            }
            return result;
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
            return false;
        }
    }
    
    @Override
    public boolean updateUser(UserConfig user)
    {
        try
        {
            user.setPassword(Base64Utils.encode(AES128System.encryptPwdByNewKey((user.getUserId() + user.getPassword()).getBytes("UTF-8"))));
            boolean result = userDao.updateUser(user);
            if (result)
            {
                notifyObservers();
            }
            
            return result;
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
            return false;
        }
    }
    
    @Override
    public boolean deleteUser(String userId)
    {
        boolean result = userDao.deleteUser(userId);
        if (result)
        {
            notifyObservers();
        }
        
        return result;
    }
    
    @Override
    public UserConfig getUserById(String userId)
    {
        return userDao.getUserById(userId);
    }
    
    @Override
    public List<UserConfig> getAllUsers()
    {
        List<UserConfig> result = userDao.getAllUsers();
        if (null != result && !result.isEmpty())
        {
            for (UserConfig user : result)
            {
                if (null != user && !StringUtils.isEmpty(user.getPassword()))
                {
                    user.setPassword(AES128System.decryptPwdByOldKey(user.getUserId(), user.getPassword()));
                }
            }
        }
        
        return result;
    }
    
    public IUserDAO getUserDao()
    {
        return userDao;
    }
    
    public void setUserDao(IUserDAO userDao)
    {
        this.userDao = userDao;
    }
}
