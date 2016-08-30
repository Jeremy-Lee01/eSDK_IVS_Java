package com.huawei.esdk.platform.listener;

import java.util.List;

public interface ISessionListenerManager
{
    List<ISessionListener> getListeners();
    
    void registerListner(ISessionListener listener);
        
    void unRegisterListner(ISessionListener listener);    
}
