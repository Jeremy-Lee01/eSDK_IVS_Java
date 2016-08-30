package com.huawei.esdk.platform.nemgr.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.huawei.esdk.platform.callback.itf.ICallback;
import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;
import com.huawei.esdk.platform.common.constants.ESDKConstant;

public class NotifyCollector
{
    private static final Map<String, ICallback> CALLBACK_MAPPING = new ConcurrentHashMap<String, ICallback>();
    
    public void publishNotify(CallbackMessage callbackMessage)
    {
        String key = null;
        if (ESDKConstant.NOTIFY_MSG_TYPE_ESDK_EVENT.equalsIgnoreCase(callbackMessage.getCallbackItfInfo()
            .getNotifyMsgType()))
        {
            key = callbackMessage.getCallbackItfInfo().getProcessorId();
        }
        else
        {
            key =
                callbackMessage.getCallbackItfInfo().getDevId()
                    + callbackMessage.getCallbackItfInfo().getConnectionId();
        }
        
        ICallback callbackImpl = CALLBACK_MAPPING.get(key);
        if (null != callbackImpl)
        {
            callbackImpl.onNotifyMsg(callbackMessage);
        }
    }
    
    public boolean subscribeNotify(String id, ICallback callback)
    {
        CALLBACK_MAPPING.put(id, callback);
        return true;
    }
    
    public boolean subscribeNotify(String neId, String connectionId, ICallback callback)
    {
        CALLBACK_MAPPING.put(neId + connectionId, callback);
        return true;
    }
    
    public void unsubscribeNotify(String neId, String connectionId)
    {
        CALLBACK_MAPPING.remove(neId + connectionId);
    }
    
    public void unsubscribeNotify(String id)
    {
        CALLBACK_MAPPING.remove(id);
    }
}
