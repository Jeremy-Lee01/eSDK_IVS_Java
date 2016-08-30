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
package com.huawei.esdk.ivs.device.v100r001c10.callback;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.authorize.SessionInfo;
import com.huawei.esdk.ivs.authorize.SessionManager;
import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.ivs.device.v100r001c10.common.CommonCapabilityImpl;
import com.huawei.esdk.ivs.domain.model.Notify;
import com.huawei.esdk.ivs.domain.model.bean.CallbackMsg;
import com.huawei.esdk.ivs.domain.model.bean.EventType;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.callback.CallbackItfInfo;
import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.base.NotifyCollector;

public class CallbackThread implements Runnable
{
    private static final Logger LOGGER = Logger.getLogger(CallbackThread.class);
    
    protected NotifyCollector notifyCollector = ApplicationContextUtil.getBean("notifyCollector");
    
    private BlockingQueue<CallbackMsg> callbackMsgQueue;
    
    public CallbackThread()
    {
        callbackMsgQueue = CallbackEventImpl.getCallbackMsgQueue();
    }
    
    protected CallbackMessage buildCallbackMessage(Object payload, Object extendedInfo, String itfName,
        String sessionId)
    {
        
        CallbackMessage callbackMsg = new CallbackMessage();
        callbackMsg.setPayload(payload);
        callbackMsg.setExtendedInfo(extendedInfo);
        
        CallbackItfInfo callbackItfInfo = new CallbackItfInfo();
        callbackItfInfo.setNotifyMsgType(ESDKConstant.NOTIFY_MSG_TYPE_ESDK_EVENT);
        callbackItfInfo.setProcessorId(sessionId);
        callbackItfInfo.setItfName(itfName);
        callbackItfInfo.setModule(sessionId);
        callbackMsg.setCallbackItfInfo(callbackItfInfo);
        
        return callbackMsg;
    }
    
    @Override
    public void run()
    {
        while (true)
        {
            // 出队
            CallbackMsg callbackMsg = null;
            try
            {
                callbackMsg = callbackMsgQueue.poll(30, TimeUnit.SECONDS);
            }
            catch (InterruptedException e1)
            {
                LOGGER.error("InterruptedException happened");
                break;
            }
            LOGGER.debug("callbackMsgQueue size: " + callbackMsgQueue.size());
            if (null != callbackMsg)
            {
                long waitTime = new Date().getTime() - callbackMsg.getDate().getTime();
                if (10 * 60 * 1000 > waitTime)
                {
                    LOGGER.debug("send callback message start: " + callbackMsg.getEventType());
                    
                    // 流异常回调事件
                    if (EventType.IVS_EVENT_REMOTE_PLAYBACK_FAILED == callbackMsg.getEventType())
                    {
                        notifyCollector.publishNotify(buildCallbackMessage(callbackMsg.getMsg(),
                            String.valueOf(callbackMsg.getEventType()),
                            "notify",
                            callbackMsg.getEsdkSessionId()));
                    }
                    else
                    {
                        SessionManager sessionMgr = SessionManager.getInstance();
                        SessionInfo info = sessionMgr.getSDKSession(callbackMsg.getEsdkSessionId());
                        Integer ivsSessionId = info.getVCNSessionId();
                        
                        //modify begin
                        //DTS2016042505692
                        //处理巴基斯坦S1项目 回调消息向ISV推送失败的问题
                        //问题描述：多台ISV客户端时，后来ISV执行注册回调接口之后又与esdk server断连后，其他与esdk相连的ISV收不到IVS回调消息推送
                        if (-1 == ivsSessionId)
                        {
                            LOGGER.error("Get ivsSessionId by sessionMgr failed:" + callbackMsg.getEsdkSessionId());
                            ivsSessionId = CommonCapabilityImpl.getSessionIdByNorth(callbackMsg.getEsdkSessionId());
                            LOGGER.info("Get ivsSessionId by CommonCapabilityImpl.getSessionIdByNorth finished:"
                                + ivsSessionId);
                                
                            handleDisconnect(ivsSessionId, callbackMsg.getEsdkSessionId());
                        }
                        //modify end
                        
                        List<String> esdkSessionIds = sessionMgr.getSDKSessonList(ivsSessionId);
                        try
                        {
                            if (null != esdkSessionIds)
                            {
                                for (String id : esdkSessionIds)
                                {
                                    notifyCollector.publishNotify(buildCallbackMessage(callbackMsg.getMsg(),
                                        String.valueOf(callbackMsg.getEventType()),
                                        "notify",
                                        id));
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            LOGGER.error("callBack method error", e);
                        }
                    }
                    
                    LOGGER.debug("send callback message end");
                }
            }
        }
    }
    
    /**
     * 处理ISV与ESDK断连后eSdkSessionId失效的问题
     * @author  likun/l00295065
     * @param ivsSessionId
     * @param eSdkSessionId
     */
    private void handleDisconnect(Integer ivsSessionId, String eSdkSessionId)
    {
        LOGGER.info("method handleDisconnect start");
        
        //设置当前线程的session变量
        ThreadLocalHolder.get().getEntities().put(InfoKeys.SDK_SESSION_ID.toString(), eSdkSessionId);
        
        //向sessionMgr临时加入已经失效的session变量
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setVCNSessionId(ivsSessionId);
        SessionManager.getInstance().saveSDKSession(eSdkSessionId, sessionInfo);
        
        try
        {
            //移除该eSdkSessionId北向相关回调关系
            notifyCollector.unsubscribeNotify(eSdkSessionId);
            
            if (-1 == ivsSessionId)
            {
                LOGGER.error("get ivsSessionId by relativeList failed");
                return;
            }
            
            //从relativeMap中删除当前eSdkSession
            CommonCapabilityImpl.deleteSdkSessionInRelative(ivsSessionId, eSdkSessionId);
            
            //使用下一个eSdkSession注册回调
            List<String> relative = CommonCapabilityImpl.relativeMap.get(ivsSessionId);
            if (null != relative && !relative.isEmpty())
            {
                SDKErrorCode result = new Notify().registerNotification(relative.get(0), true);
                LOGGER.info("registerNotification eSdkSessionId" + relative.get(0) + " finished. resultCode:"
                    + result.getErrCode());
            }
            
        }
        catch (SDKException e)
        {
            LOGGER.error("handleDisconnect method with SDKException", e);
        }
        catch (Exception e)
        {
            LOGGER.error("handleDisconnect method with exception", e);
        }
        
        //移除临时向sessionMgr加入的已经失效的session
        SessionManager.getInstance().removeSDKSession(eSdkSessionId);
        
        //移除当前线程的session变量
        ThreadLocalHolder.get().getEntities().remove(InfoKeys.SDK_SESSION_ID.toString());
        
        LOGGER.info("method handleDisconnect end");
    }
    
}
