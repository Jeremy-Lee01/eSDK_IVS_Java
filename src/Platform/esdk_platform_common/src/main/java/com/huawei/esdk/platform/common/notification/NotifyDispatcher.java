package com.huawei.esdk.platform.common.notification;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class NotifyDispatcher<T>
{
    private LinkedList<T> listeners = new LinkedList<T>();

    public void registerListener(T listener)
    {
        if (listener == null)
        {
            return;
        }
        synchronized (listeners)
        {
            listeners.add(listener);
        }
    }

    public void unregisterListener(T listener)
    {
        if (listener == null)
        {
            synchronized (listeners)
            {
                listeners.clear();
            }
        }
        else
        {
            synchronized (listeners)
            {
                listeners.remove(listener);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public boolean fireNotify(String ntfId, Object msg, Object additionalInfo)
    {
        LinkedList<T> backup;
        synchronized (listeners)
        {
            backup = (LinkedList<T>) listeners.clone();
        }
        boolean bReturn = false;
        for (Iterator<T> it = backup.iterator(); !bReturn && it.hasNext();)
        {
            bReturn = notifyToOneListener(it.next(), ntfId, msg, additionalInfo);
        }
        return bReturn;
    }

    public abstract boolean notifyToOneListener(T listener, String ntfId,
            Object msg, Object additionalInfo);
}
