package com.huawei.esdk.platform.nemgr.callback;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.callback.itf.ICallback;
import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class NemgrCallback implements ICallback
{
    private static final Logger LOGGER = Logger.getLogger(NemgrCallback.class);
    
    @Override
    public Object onNotifyMsg(CallbackMessage callbackMessage)
    {
        IDeviceManager deviceManager = ApplicationContextUtil.getBean("deviceManager");
        String itfName = callbackMessage.getCallbackItfInfo().getItfName();
        String devId = callbackMessage.getCallbackItfInfo().getDevId();
        
        if (ESDKConstant.NOTIFY_ITFNAME_CONNECT.equals(itfName))
        {
            try
            {
                deviceManager.connect(devId);
            }
            catch (SDKException e)
            {
                LOGGER.error("", e);
            }
        }
        else if (ESDKConstant.NOTIFY_ITFNAME_DISCONNECT.equals(itfName))
        {
            deviceManager.closeConn(devId);
        }
        return null;
    }
}
