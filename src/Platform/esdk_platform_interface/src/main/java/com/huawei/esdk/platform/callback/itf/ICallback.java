package com.huawei.esdk.platform.callback.itf;

import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;

public interface ICallback
{

    Object onNotifyMsg(CallbackMessage callbackMessage);
    
}
