package com.huawei.esdk.platform.nemgr.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DeviceServiceHandler implements InvocationHandler
{
    /**
     * Constructs a DeviceCommuProxyHandler
     * 
     * @param t
     *            the implicit parameter of the method call
     */
    public DeviceServiceHandler(Object t)
    {
        target = t;
    }
    
    public Object invoke(Object proxy, Method m, Object[] args)
        throws Throwable// 此方法在代理类中
    {
        // invoke actual method
        return m.invoke(target, args);
    }
    
    private Object target;
}
