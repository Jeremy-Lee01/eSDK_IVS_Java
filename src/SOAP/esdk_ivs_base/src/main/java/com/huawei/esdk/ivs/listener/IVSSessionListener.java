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
package com.huawei.esdk.ivs.listener;

import com.huawei.esdk.ivs.authorize.SessionManager;
import com.huawei.esdk.ivs.base.BaseService;
import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.listener.ISessionListener;


public class IVSSessionListener extends BaseService implements ISessionListener
{

    @Override
    public void sessionCreated(String sessionId)
    {
    }

    @Override
    public void sessionDestroyed(String sessionId)
    {
        
        MessageContext mc = ThreadLocalHolder.get();
        if (mc == null)
        {
            mc = new MessageContext();
        }
        mc.getEntities().put(InfoKeys.SDK_SESSION_ID.toString(), sessionId);
        ThreadLocalHolder.set(mc);
        SessionManager sessionMgr = SessionManager.getInstance();
        int ivsSessionId = sessionMgr.isUserRepeatedOnline();
        if (0 <= ivsSessionId)
        {
            mc.getEntities().put(InfoKeys.IVS_SESSION_ID.toString(), ivsSessionId);
            deviceManager.closeConn(ConfigManager.getInstance().getValue("esdk.ivs_vcn_device"));
        }
        
    }

}
