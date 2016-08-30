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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.device.CallbackSouthBase;
import com.huawei.esdk.ivs.device.v100r001c10.callback.convert.CallbackEventConvert;
import com.huawei.esdk.ivs.domain.model.bean.CallbackMsg;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.UserDataSouth;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class CallbackEventImpl extends CallbackSouthBase
{
    private CallbackEventConvert callbackEventConvert;
    
    private static BlockingQueue<CallbackMsg> callbackMsgQueue = new ArrayBlockingQueue<CallbackMsg>(10000);

    
    private static final Logger LOGGER = Logger.getLogger(CallbackEventImpl.class);
    
    /** 
    * 回调事件处理
    * @param eventType 事件类型
    * @param eventBuf 回调信息南向bean
    * @param bufSize
    * @param userData sessionId
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public void callBack(int eventType, Pointer eventBuf, int bufSize, Pointer userData)
    {
        LOGGER.debug("ivs event " + eventType + " call back start --->>>");
        UserDataSouth userDataSouth = new UserDataSouth(userData);
        userDataSouth.read();
        Object msg = callbackEventConvert.getCallbackMessage(eventType, eventBuf, bufSize, userDataSouth);
        
        String esdkSessionId = Native.toString(userDataSouth.sessionId);
        
        if (null != msg)
        {
            CallbackMsg callbackMsg = new CallbackMsg();
            
            callbackMsg.setEventType(eventType);
            callbackMsg.setEsdkSessionId(esdkSessionId);
            callbackMsg.setDate(new Date());
            callbackMsg.setMsg(msg);
            
            // 入队
            callbackMsgQueue.offer(callbackMsg);
            LOGGER.debug("callbackMsgQueue.offer size: " + callbackMsgQueue.size());
            LOGGER.debug("callbackMsgQueue.offer enentType: " + eventType);
        }

        LOGGER.debug("ivs event " + eventType + " call back end --->>>");
    }
    
    public void setCallbackEventConvert(CallbackEventConvert callbackEventConvert)
    {
        this.callbackEventConvert = callbackEventConvert;
    }

    public static BlockingQueue<CallbackMsg> getCallbackMsgQueue()
    {
        return callbackMsgQueue;
    }
    
    
}
