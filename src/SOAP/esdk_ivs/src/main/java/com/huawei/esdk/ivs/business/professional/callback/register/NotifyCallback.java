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
package com.huawei.esdk.ivs.business.professional.callback.register;

import java.util.HashMap;
import java.util.Map;

import com.huawei.esdk.ivs.authorize.SessionManager;
import com.huawei.esdk.platform.callback.itf.ICallback;
import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;

public class NotifyCallback implements ICallback
{
    private static final Map<String, ICallback> MODULE_CALLBACKS = new HashMap<String, ICallback>();
    
    SessionManager sessionMgr = SessionManager.getInstance();
    
    @Override
    public Object onNotifyMsg(CallbackMessage callbackMessage)
    {
        ICallback moduleCallback = MODULE_CALLBACKS.get(callbackMessage.getCallbackItfInfo().getModule());
        if (null != moduleCallback)
        {
            return moduleCallback.onNotifyMsg(callbackMessage);
        }
        return null;
    }
    
    public void registerCallback(String sessionId, ICallback callback)
    {
        MODULE_CALLBACKS.put(sessionId, callback);
    }
    
    public void unRegisterCallback(String sessionId)
    {
        MODULE_CALLBACKS.remove(sessionId);
    }
    
    public boolean hasRegisteredModule()
    {
        return !MODULE_CALLBACKS.isEmpty();
    }
}
