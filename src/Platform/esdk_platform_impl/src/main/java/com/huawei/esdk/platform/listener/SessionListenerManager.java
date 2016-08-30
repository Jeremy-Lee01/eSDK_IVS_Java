package com.huawei.esdk.platform.listener;

import java.util.ArrayList;
import java.util.List;

public class SessionListenerManager implements ISessionListenerManager
{
    private List<ISessionListener> listeners = new ArrayList<ISessionListener>(2);
    
    @Override
    public synchronized List<ISessionListener> getListeners()
    {
        return this.listeners;
    }
    
    @Override
    public synchronized void registerListner(ISessionListener listener)
    {
        listeners.add(listener);
    }
    
    @Override
    public synchronized void unRegisterListner(ISessionListener listener)
    {
        listeners.remove(listener);
    }
}
