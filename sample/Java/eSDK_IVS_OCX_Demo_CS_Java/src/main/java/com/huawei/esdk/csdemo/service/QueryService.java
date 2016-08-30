package com.huawei.esdk.csdemo.service;

import com.huawei.esdk.csdemo.BaseCablilityJNA;
import com.huawei.esdk.csdemo.common.SDKResult;
import com.huawei.esdk.csdemo.model.CameraBriefInfoList;
import com.huawei.esdk.csdemo.model.IndexRange;
import com.sun.jna.Pointer;

public class QueryService
{
    private static QueryService service = null;
    
    public static synchronized QueryService getInstance()
    {
        if (null == service)
        {
            service = new QueryService();
        }
        return service;
    }
    
    public synchronized SDKResult<CameraBriefInfoList> getDeviceList(int fromIndex, int toIndex)
    {
        SDKResult<CameraBriefInfoList> result = new SDKResult<CameraBriefInfoList>();
        
        IndexRange indexRange = new IndexRange();
        indexRange.clear();
        indexRange.fromIndex = fromIndex;
        indexRange.toIndex = toIndex;
        
        int size = toIndex - fromIndex + 1;
        
        if (1 > size)
        {
            size = 1;
        }
        
        // 目前deviceType仅支持：摄像头
        CameraBriefInfoList cameraBriefInfoList = new CameraBriefInfoList(1000);
        cameraBriefInfoList.clear();
        Pointer pointer = cameraBriefInfoList.getPointer();
        //bufferSize = CAMERA_BRIEF_INFO_LIST_SOUTH.size();
        
        int sessionid = CommonService.getSESSIONID();
        int resultCode =
            BaseCablilityJNA.INSTANCE.IVS_SDK_GetDeviceList(sessionid, 2, indexRange, pointer, size * 980 + 12);
            
        cameraBriefInfoList.read();
        result.setErrCode(resultCode);
        
        if (0 == resultCode)
        {
            result.setResult(cameraBriefInfoList);
        }
        
        return result;
    }
}
