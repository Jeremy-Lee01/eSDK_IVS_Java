package com.huawei.esdk.platform.listener.http;

import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.listener.ISessionListener;
import com.huawei.esdk.platform.listener.ISessionListenerManager;

public class ESDKHttpSessionListener implements HttpSessionListener
{
    private ISessionListenerManager sessionListenerManager;
        
    @Override
    public void sessionCreated(HttpSessionEvent httpsessionevent)
    {
        if (null == sessionListenerManager)
        {
            sessionListenerManager = ApplicationContextUtil.getBean("sessionListenerManager");
        }
        List<ISessionListener> listeners = sessionListenerManager.getListeners();
        for (ISessionListener listener : listeners)
        {
            listener.sessionCreated(httpsessionevent.getSession().getId());
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpsessionevent)
    {
        if (null == sessionListenerManager)
        {
            sessionListenerManager = ApplicationContextUtil.getBean("sessionListenerManager");
        }
        List<ISessionListener> listeners = sessionListenerManager.getListeners();
        for (ISessionListener listener : listeners)
        {
            listener.sessionDestroyed(httpsessionevent.getSession().getId());
        }
    }
}
