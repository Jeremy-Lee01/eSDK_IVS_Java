package com.huawei.esdk.platform.session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import com.huawei.esdk.platform.session.itf.ISessionMgr;

public class SessionMgrC50Default implements ISessionMgr
{
    private static final Logger LOGGER = Logger.getLogger(SessionMgrC50Default.class);
    
    private static Map<String, SessionInfo> sessionMap = new ConcurrentHashMap<String, SessionInfo>();
    
    private static SessionMgrC50Default sessionManager;
    
    private SessionMgrC50Default()
    {
    }
    
    public static synchronized SessionMgrC50Default getInstance()
    {
        if (null == sessionManager)
        {
            sessionManager = new SessionMgrC50Default();
        }
        return sessionManager;
    }
    
    @Override
    public synchronized boolean saveSDKSession(String sdkSession)
    {
        if (StringUtils.isEmpty(sdkSession))
        {
            return false;
        }
        SessionInfo ds = sessionMap.get(sdkSession);
        if (null != ds)
        {
            return false;
        }
        
        ds = new SessionInfo();
        try
        {
            sessionMap.put(sdkSession, ds);
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
            return false;
        }
        return true;
    }
    
    public synchronized boolean saveSecretKey(String sdkSession, byte[] secretKey)
    {
        return saveSecretKey(sdkSession, secretKey, null);
    }
    
    public synchronized boolean saveSecretKey(String sdkSession, byte[] secretKey, byte[] iv)
    {
        if (StringUtils.isEmpty(sdkSession))
        {
            return false;
        }
        
        SessionInfo info = sessionMap.get(sdkSession);
        if (null == info)
        {
            info = new SessionInfo();
        }
        info.setSecretKey(secretKey);
        info.setIv(iv);
        
        sessionMap.put(sdkSession, info);
        return true;
    }
    
    @Override
    public synchronized boolean isSDKSessionExists(String sdkSession)
    {
        return null == sdkSession ? false : sessionMap.containsKey(sdkSession);
    }
    
    @Override
    public synchronized void removeSDKSession(String sdkSession)
    {
        if (StringUtils.isEmpty(sdkSession))
        {
            return;
        }
        try
        {
            if (!sessionMap.containsKey(sdkSession))
                return;
            sessionMap.remove(sdkSession);
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
        }
    }
    
    @Override
    public synchronized byte[] getSecretKey(String sdkSession)
    {
        if (StringUtils.isEmpty(sdkSession))
        {
            return null;
        }
        SessionInfo ds = sessionMap.get(sdkSession);
        
        if (null != ds)
        {
            return ds.getSecretKey();
        }
        return null;
    }
    
    @Override
    public synchronized byte[] getIv(String sdkSession)
    {
        if (StringUtils.isEmpty(sdkSession))
        {
            return null;
        }
        SessionInfo ds = sessionMap.get(sdkSession);
        
        if (null != ds)
        {
            return ds.getIv();
        }
        return null;
    }
    
}
