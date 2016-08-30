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

import com.huawei.esdk.platform.common.bean.callback.CallbackItfInfo;
import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.base.NotifyCollector;

/**
 * 南向事件回调基类
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CallbackSouthBase
{
    
    protected NotifyCollector notifyCollector = ApplicationContextUtil.getBean("notifyCollector");
    
    protected CallbackMessage buildCallbackMessage(Object payload,
            Object extendedInfo, String itfName, String sessionId)
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
}
