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
package com.huawei.esdk.ivs.business.professional.callback;

import com.huawei.esdk.ivs.authorize.SessionManager;
import com.huawei.esdk.ivs.business.professional.callback.register.CallbackRegisterService;
import com.huawei.esdk.ivs.domain.model.bean.EventType;
import com.huawei.esdk.ivs.domain.model.bean.UserOfflineInfo;
import com.huawei.esdk.ivs.northcommu.callback.IVSNotifyListener;
import com.huawei.esdk.platform.common.notification.NotifyDispatcher;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;

public class IVSNotifyDispatcher extends NotifyDispatcher<IVSNotifyListener>
{
    private CallbackRegisterService callbackRegisterService = ApplicationContextUtil.getBean("callbackRegisterService");
    
    private SessionManager sessionMgr = SessionManager.getInstance();
    
    /**
     * 向北向发送回调事件的消息
     * <p>
     * @param listener 北向监听器
     * @param ntfId 接口
     * @param msg 消息体
     * @param additionalInfo 附加消息体
     * @author  sWX198756
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public boolean notifyToOneListener(IVSNotifyListener listener, String ntfId, Object msg, Object additionalInfo)
    {
        String eventType = (String)additionalInfo;
        listener.notify(msg, eventType);
        
        int eventTypeInt = Integer.parseInt(eventType);
        if (EventType.IVS_EVENT_AUTO_CONNECT_SUCCEED == eventTypeInt)
        {
            String esdkSessionId = (String)msg;
            callbackRegisterService.unRegister(esdkSessionId);
            sessionMgr.removeSDKSession(esdkSessionId);
        }
        else if (EventType.IVS_EVENT_KEEP_ALIVE_FAILED == eventTypeInt)
        {
            String esdkSessionId = (String)msg;
            callbackRegisterService.unRegister(esdkSessionId);
            sessionMgr.removeSDKSession(esdkSessionId);
        }
        else if (EventType.IVS_EVENT_USER_OFFLINE == eventTypeInt)
        {
            UserOfflineInfo userOfflineInfo = (UserOfflineInfo)msg;
            callbackRegisterService.unRegister(userOfflineInfo.getEsdkSessionId());
            sessionMgr.removeSDKSession(userOfflineInfo.getEsdkSessionId());
        }
        return true;
    }
}
