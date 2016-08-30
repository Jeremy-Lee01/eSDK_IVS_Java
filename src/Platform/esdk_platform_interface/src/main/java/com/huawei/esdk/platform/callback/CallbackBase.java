package com.huawei.esdk.platform.callback;

import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;
import com.huawei.esdk.platform.common.notification.NotifyDispatcher;

public class CallbackBase
{
    protected NotifyDispatcher<?> notifyDispatcher;

    public Object onNotifyMsg(CallbackMessage callbackMessage)
    {
        if (null != notifyDispatcher)
        {
            return notifyDispatcher.fireNotify(callbackMessage.getCallbackItfInfo().getItfName(),
                    callbackMessage.getPayload(),
                    callbackMessage.getExtendedInfo());
        }
        else
        {
            return new Object();
        }
    }
    
    public NotifyDispatcher<?> getNotifyDispatcher()
    {
        return notifyDispatcher;
    }

    public void setNotifyDispatcher(NotifyDispatcher<?> notifyDispatcher)
    {
        this.notifyDispatcher = notifyDispatcher;
    }
}
