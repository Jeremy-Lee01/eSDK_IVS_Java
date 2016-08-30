package com.huawei.esdk.platform.usermgr;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import com.huawei.esdk.platform.base.BaseManager;
import com.huawei.esdk.platform.common.bean.config.UserConfig;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.NumberUtils;
import com.huawei.esdk.platform.common.utils.SHA256Utils;
import com.huawei.esdk.platform.config.SystemConfig;
import com.huawei.esdk.platform.config.service.itf.IConfigObserver;
import com.huawei.esdk.platform.config.service.itf.IUserConfigService;
import com.huawei.esdk.platform.jobs.RefershUserConfigJob;
import com.huawei.esdk.platform.usermgr.itf.IUserManager;

public class UserManager extends BaseManager implements IUserManager
{
    private static final Logger LOGGER = Logger.getLogger(UserManager.class);
    
    private Scheduler scheduler;
    
    private List<UserConfig> users;
    
    IUserConfigService userConfigService;
    
    public synchronized void init()
    {
        // 加载系统密钥，更新系统密钥，并保存至文件。
        LOGGER.info("UserManager init()");
        SystemConfig.init();
        
        refreshUsers();
        
        userConfigService.registerObserver(new IConfigObserver()
        {
            @Override
            public void doAction()
            {
                LOGGER.info("users configuration changed");
                refreshUsers();
            }
        });
        
        try
        {
            JobDetail jobDetail = JobBuilder.newJob(RefershUserConfigJob.class).withIdentity("refresh_user_config").build();
//            jobDetail.setName("refresh_user_config");
            jobDetail.getJobDataMap().put("userManager", this);
//            jobDetail.setJobClass(RefershUserConfigJob.class);
            
            Trigger trigger =
                TriggerBuilder.newTrigger()
                    .withIdentity("cron_refersh_user_config", "eSDK_Jobs")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .repeatMinutelyForever(NumberUtils.parseIntValue(ConfigManager.getInstance()
                            .getValue("refreshInterval", "30")))
                        .repeatForever())
                    .build();
            
            
//            SimpleTrigger trigger =
//                new SimpleTrigger("cron_refersh_user_config", "eSDK_Jobs", new Date(), null,
//                    SimpleTrigger.REPEAT_INDEFINITELY, 1000L * 60 * NumberUtils.parseIntValue(ConfigManager.getInstance()
//                        .getValue("refreshInterval", "30")));
            
            scheduler.scheduleJob(jobDetail, trigger);
        }
        catch (SchedulerException e)
        {
            LOGGER.error("User configuration job trigger error", e);
        }
    }
    
    public synchronized void refreshUsers()
    {
        users = userConfigService.getAllUsers();
    }
    
    @Override
    public synchronized List<UserConfig> getUserList()
    {
        if (null == users)
        {
            users = userConfigService.getAllUsers();
        }
        
        return users;
    }
    
    @Override
    public synchronized UserConfig getUserById(String userId)
    {
        if (null == users)
        {
            users = userConfigService.getAllUsers();
        }
        
        for (UserConfig user : users)
        {
            if (user.getUserId().equals(userId))
            {
                return user;
            }
        }
        
        return null;
    }
    
    @Override
    public synchronized boolean checkUser(String userId, String password)
    {
        UserConfig user = getUserById(userId);
        if (null == user)
        {
            return false;
        }
        String pwdWithSHA256 = SHA256Utils.encrypt(user.getPassword());
        if (password.equals(pwdWithSHA256))
        {
            return true;
        }
        
        return false;
    }
    
    public IUserConfigService getUserConfigService()
    {
        return userConfigService;
    }
    
    public void setUserConfigService(IUserConfigService userConfigService)
    {
        this.userConfigService = userConfigService;
    }
    
    public Scheduler getScheduler()
    {
        return scheduler;
    }
    
    public void setScheduler(Scheduler scheduler)
    {
        this.scheduler = scheduler;
    }
}
