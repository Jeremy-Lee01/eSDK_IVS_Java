package com.huawei.esdk.platform.common;

import java.util.HashMap;
import java.util.Map;

public abstract class ThreadLocalHolder
{
    public static final ThreadLocal<MessageContext> userThreadLocal = new ThreadLocal<MessageContext>();

    public static void set(MessageContext user)
    {
        userThreadLocal.set(user);
    }

    public static void unset()
    {
        userThreadLocal.remove();
    }

    public static MessageContext get()
    {
        MessageContext result = userThreadLocal.get();
        if (null == result)
        {
            result = new MessageContext();
            set(result);
        }
        return result;
    }    
    
    public static void put(String key, Object value)
    {
        MessageContext mc = get();
        Map<String, Object> entities = mc.getEntities();
        if (null == entities)
        {
            entities = new HashMap<String, Object>();
        }
        mc.setEntities(entities);
        entities.put(key, value);
        
        ThreadLocalHolder.set(mc);
    }
    
    public static Object get(String key)
    {
        MessageContext mc = get();
        if (null != mc.getEntities())
        {
            return mc.getEntities().get(key);
        }
        
        return null;
    }
}
