package com.huawei.esdk.platform.listener;

public interface ISessionListener
{
    public void sessionCreated(String sessionId);

    public void sessionDestroyed(String sessionId);
}
