package com.huawei.esdk.platform.common.bean.callback;

/**
 * 回调信息Bean
 * 
 * @author z00209306
 * @since V001V002C01
 */
public class CallbackMessage
{
    /*
     * 该回调消息所属的接口信息
     */
    private CallbackItfInfo callbackItfInfo;
    
    private Object payload;
    
    private Object extendedInfo;
    
    public Object getPayload()
    {
        return payload;
    }
    
    public void setPayload(Object payload)
    {
        this.payload = payload;
    }
    
    public Object getExtendedInfo()
    {
        return extendedInfo;
    }
    
    public void setExtendedInfo(Object extendedInfo)
    {
        this.extendedInfo = extendedInfo;
    }
    
    public CallbackItfInfo getCallbackItfInfo()
    {
        return callbackItfInfo;
    }
    
    public void setCallbackItfInfo(CallbackItfInfo callbackItfInfo)
    {
        this.callbackItfInfo = callbackItfInfo;
    }
}
