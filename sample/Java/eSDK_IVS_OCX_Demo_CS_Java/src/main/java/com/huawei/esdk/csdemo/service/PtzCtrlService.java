package com.huawei.esdk.csdemo.service;

import com.huawei.esdk.csdemo.BaseCablilityJNA;
import com.huawei.esdk.csdemo.common.ControlCode;
import com.huawei.esdk.csdemo.common.SDKResult;
import com.huawei.esdk.csdemo.util.DeviceUtil;
import com.huawei.esdk.csdemo.util.StringUtil;
import com.huawei.esdk.csdemo.view.CtrlPanel;
import com.sun.jna.ptr.IntByReference;

public class PtzCtrlService
{
    private static PtzCtrlService service = null;
    
    public static synchronized PtzCtrlService getInstance()
    {
        if (null == service)
        {
            service = new PtzCtrlService();
        }
        return service;
    }
    
    public synchronized SDKResult<Integer> ControlCamera(ControlCode controlCode)
    {
        SDKResult<Integer> result = null;
        
        if (CtrlPanel.playStatus)
        {
            result = new SDKResult<Integer>();
                
            String cameraCode = DeviceUtil.getRealPlayCode();
            
            int order = controlCode.ordinal() + 1;
            IntByReference lockStatus = new IntByReference(-1);
            int resultCode = BaseCablilityJNA.INSTANCE.IVS_SDK_PtzControl(CommonService.getSESSIONID(),
                StringUtil.getNativeBytes(cameraCode, 64),
                order,
                "2",
                "3",
                lockStatus);
                
            result.setErrCode(resultCode);
            result.setResult(lockStatus.getValue());
        }
        return result;
    }
}
