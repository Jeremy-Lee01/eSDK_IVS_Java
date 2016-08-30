/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.ivs.authorize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.session.itf.ISessionMgr;

/**
 * @author sWX198756
 *
 */
public final class SessionManager
{
    private static final Logger LOGGER = Logger.getLogger(SessionManager.class);

    private static Map<String, SessionInfo> sessionMap = new ConcurrentHashMap<String, SessionInfo>();
    
    private ISessionMgr sessionMgrPlatform = ApplicationContextUtil.getBean("sessionMgrC50");
    
    private static SessionManager sessionManager;

    private SessionManager()
    {
    }

    public static synchronized SessionManager getInstance()
    {
        if (null == sessionManager)
        {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public synchronized boolean saveSDKSession(String sdkSession)
    {
        if (null == sdkSession)
        {
            return false;
        }
        SessionInfo ds = sessionMap.get(sdkSession);
        if (null != ds)
        {
            return false;
        }

        ds = new SessionInfo();
        ds.setVCNSessionId(-1);
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
    
    public synchronized boolean saveSDKSession(String sdkSession,SessionInfo info)
    {
        if (null == sdkSession)
        {
            return false;
        }
        
        if (null != sessionMap.get(sdkSession))
        {
            return true;
        }
        try
        {
            sessionMap.put(sdkSession, info);
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
            return false;
        }
        return true;
    }
    
    public synchronized void saveSDKSessionInfo(String sdkSession, SessionInfo info)
    {
        sessionMap.put(sdkSession, info);
    }
    
    public synchronized SessionInfo getSDKSession(String sdkSession)
    {
        SessionInfo ds = sessionMap.get(sdkSession);
                
        if (null != ds)
        {
            return ds;
        }
        ds = new SessionInfo();
        ds.setVCNSessionId(-1);
        return ds;
    }
    
    public synchronized List<SessionInfo> getSDKSessionInfoList()
    {
        Iterator<SessionInfo> it = sessionMap.values().iterator();
        List<SessionInfo> sessionInfos = new ArrayList<SessionInfo>();
        while (it.hasNext())
        {
            sessionInfos.add(it.next());
        }
        return sessionInfos;
    }
    
    public synchronized List<String> getSDKSessonList(int ivsSessionId)
    {
        List<String> matchedIds = new ArrayList<String>();
        Set<String> esdkSessionIds = sessionMap.keySet();
        if (null != esdkSessionIds)
        {
            for (String id : esdkSessionIds)
            {
                SessionInfo sessionInfo = sessionMap.get(id);
                if (null != sessionInfo && ivsSessionId == sessionInfo.getVCNSessionId())
                {
                    matchedIds.add(id);
                }
            }
        }
        return matchedIds;
    }
    

    public synchronized boolean saveUserName(String sdkSession, String userName)
    {
        if (null == sdkSession)
        {
            return false;
        }

        try
        {
            SessionInfo ds = sessionMap.get(sdkSession);
            if (ds != null)
            {
                ds.setUserName(userName);
                return true;
            }
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
            return false;
        }

        return false;
    }

    public synchronized String getUserName(String sdkSession)
    {
        String userName = null;

        try
        {
            SessionInfo ds = sessionMap.get(sdkSession);
            userName = ds.getUserName();
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
        }
        LOGGER.debug("userName=" + userName);
        return userName;
    }


    public synchronized boolean isSDKSessionExists(String sdkSession)
    {
        return null == sdkSession ? false : sessionMap.containsKey(sdkSession);                
    }

    public synchronized void removeSDKSession(String sdkSession)
    {
        if (null == sdkSession)
        {
            return;
        }
        sessionMgrPlatform.removeSDKSession(sdkSession);
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

    public synchronized boolean saveLoginStatus(String sdkSession, Boolean isLogin)
    {
        if (null == sdkSession)
        {
            return false;
        }

        try
        {
            SessionInfo ds = sessionMap.get(sdkSession);
            if (ds != null)
            {
                ds.setLogged(isLogin);
                return true;
            }
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
            return false;
        }

        return false;
    }

    public synchronized Boolean getLoginStatus(String sdkSession)
    {
        Boolean isLogin = false;

        try
        {
            SessionInfo ds = sessionMap.get(sdkSession);
            isLogin = ds.isLogged();
        }
        catch (Exception e)
        {
            LOGGER.error("", e);
        }
        LOGGER.debug("isLogin=" + isLogin);
        return isLogin;
    }

    public synchronized String getESDKSessionId()
    {
        MessageContext mc = ThreadLocalHolder.get();
        if (null != mc)
        {
            return (String)mc.getEntities().get(InfoKeys.SDK_SESSION_ID.toString());
        }
        return null;
    }
    
    /** 
     * 判断同一个用户是否多处登录
     * @return 多处登录返回-1，否则返回ivsSessionId
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public synchronized int isUserRepeatedOnline()
    {
        MessageContext mc = ThreadLocalHolder.get();
        if (mc == null)
        {
            mc = new MessageContext();
            ThreadLocalHolder.set(mc);
        }
        
        SessionManager sessionMgr = SessionManager.getInstance();
        
        String esdkSessionId = (String)mc.getEntities().get(InfoKeys.SDK_SESSION_ID.toString());
        SessionInfo info = sessionMgr.getSDKSession(esdkSessionId);
        sessionMgr.removeSDKSession(esdkSessionId);
        List<SessionInfo> sessionInfos = sessionMgr.getSDKSessionInfoList();
        if (null != sessionInfos)
        {
            for (SessionInfo sessionInfo : sessionInfos)
            {
                if (null != sessionInfo && null != sessionInfo.getUserName() && null != info.getUserName()
                    && info.getUserName().equals(sessionInfo.getUserName()))
                {
                    return -1;
                }
            }
        }
        return info.getVCNSessionId();
    }
    
    
    /**
     * 检查该用户名是否在session表中
     * @param userName
     * @return
     */
    public synchronized int checkUserName(String userName)
    {
        Iterator<SessionInfo> it = sessionMap.values().iterator();
        SessionInfo info = null;
        while (it.hasNext())
        {
            info = it.next();
            if (null != info && !StringUtils.isEmpty(info.getUserName()) && !StringUtils.isEmpty(userName)
                && info.getUserName().equals(userName))
            {
                return info.getVCNSessionId();
            }
        }
        return -1;
    }
    
    public synchronized boolean saveSecretKey(String sdkSession, byte[] secretKey)
    {
        return saveSecretKey(sdkSession, secretKey, null);
    }
    
    public synchronized boolean saveSecretKey(String sdkSession, byte[] secretKey, byte[] iv)
    {
        if (null == sdkSession)
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
}
