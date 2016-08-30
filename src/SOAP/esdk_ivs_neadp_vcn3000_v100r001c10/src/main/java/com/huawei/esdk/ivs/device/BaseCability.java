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
package com.huawei.esdk.ivs.device;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.authorize.SessionManager;
import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.ivs.device.v100r001c10.BaseCablilityJNA;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.sun.jna.Native;

/**
 * 
 * 基础公共能力
 * 
 * @author  zWX144115
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public abstract class BaseCability
{
    private static final Logger LOGGER = Logger.getLogger(BaseCability.class);
    
    private static final BaseCablilityJNA baseCablilityJNA = (BaseCablilityJNA)Native.loadLibrary("IVS_SDK",
        BaseCablilityJNA.class);
    
    public int getIVSSessionId()
    {
        LOGGER.debug("getIVSSessionId start");
        SessionManager sessionMgr = SessionManager.getInstance();
        MessageContext mc = ThreadLocalHolder.get();
        if (null != mc)
        {
            String esdkSessionId = (String)mc.getEntities().get(InfoKeys.SDK_SESSION_ID.toString());
            LOGGER.debug("getIVSSessionId success");
            return sessionMgr.getSDKSession(esdkSessionId).getVCNSessionId();
        }
        return -1;
    }
    
    public static BaseCablilityJNA getBaseCablilityJNA()
    {
        return baseCablilityJNA;
    }
}
