package com.huawei.esdk.csdemo.service;

import com.huawei.esdk.csdemo.BaseCablilityJNA;
import com.huawei.esdk.csdemo.common.SDKErrorCode;
import com.huawei.esdk.csdemo.common.SDKResult;
import com.huawei.esdk.csdemo.model.RealplayParam;
import com.huawei.esdk.csdemo.util.PropertiesUtils;
import com.huawei.esdk.csdemo.util.StringUtil;
import com.huawei.esdk.csdemo.view.MainFrame;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.LongByReference;

public class RealPlayService
{
    private static RealPlayService service = null;
    
    public static synchronized RealPlayService getInstance()
    {
        if (null == service)
        {
            service = new RealPlayService();
        }
        return service;
    }
    
    /** 
     * 开始实况浏览
     * 
     * @param cameraCode 摄像机编码
     * @param realPlay 实况浏览信息
     * @return SDKResult<RealPlay> 领域层封装的返回码对象
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R005C30]
     */
    public SDKResult<Long> startRealPlay(String cameraCode)
    {
        RealplayParam realplayParam = new RealplayParam();
        realplayParam.clear();
        
        realplayParam.directFirst = "0".equals(PropertiesUtils.getValue("realplay.directFirst")) ? 0 : 1;
        realplayParam.streamType = 0;
          
        realplayParam.protocolType = "2".equals(PropertiesUtils.getValue("realplay.protocolType")) ? 2 : 1;
        realplayParam.multiCast = 0;
        //realplayParam.reserve = StringUtil.getNativeBytes("");
        
        LongByReference handle = new LongByReference();
        int sessionID = CommonService.getSESSIONID();
        int resultCode = BaseCablilityJNA.INSTANCE.IVS_SDK_StartRealPlay(sessionID,
            realplayParam,
            StringUtil.getNativeBytes(cameraCode, 64),
            MainFrame.getHWND(),
            handle);
            
        SDKResult<Long> result = new SDKResult<Long>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            result.setResult(handle.getValue());
        }
        
        return result;
    }
    
    /** 
     * 停止实况浏览
     * 
     * @param handle 播放句柄
     * @return SDKErrorCode 领域层封装的返回码对象
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R005C30]
     */
    public SDKErrorCode stopRealPlay(long handle)
    {
        SDKErrorCode result = new SDKErrorCode();
        
        if (!checkHandle(handle))
        {
            result.setErrCode(1);
            return result;
        }
        
        int sessionId = CommonService.getSESSIONID();
        
        NativeLong nativaLong = new NativeLong(handle);
        
        int resultCode = BaseCablilityJNA.INSTANCE.IVS_SDK_StopRealPlay(sessionId, nativaLong);
        
        result.setErrCode(resultCode);
        return result;
    }
    
    private boolean checkHandle(long playHandle)
    {
        if (4 == NativeLong.SIZE)
        {
            if (4294967295L < playHandle || -2147483648L > playHandle)
            {
                return false;
            }
        }
        return true;
    }
}
