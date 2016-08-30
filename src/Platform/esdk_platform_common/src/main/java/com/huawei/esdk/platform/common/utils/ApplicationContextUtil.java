package com.huawei.esdk.platform.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtil implements ApplicationContextAware
{
    private static ApplicationContext context;// 声明一个静态变量保存
    
    public static void setApplicationContextValue(ApplicationContext context)
        throws BeansException
    {
        ApplicationContextUtil.context = context;
    }
    
    public static ApplicationContext getContext()
    {
        return context;
    }
    
    @Override
    public void setApplicationContext(ApplicationContext context)
    {
        setApplicationContextValue(context);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name)
    {
        return (T)ApplicationContextUtil.getContext().getBean(name);
    }
}
