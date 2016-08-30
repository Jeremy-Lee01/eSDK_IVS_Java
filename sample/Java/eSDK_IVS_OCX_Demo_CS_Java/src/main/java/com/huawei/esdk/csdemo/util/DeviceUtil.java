package com.huawei.esdk.csdemo.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.huawei.esdk.csdemo.common.DeviceInfo;
import com.huawei.esdk.csdemo.common.SDKErrorCode;
import com.huawei.esdk.csdemo.common.SDKResult;
import com.huawei.esdk.csdemo.service.RealPlayService;

public class DeviceUtil
{
    private static final Logger LOGGER = Logger.getLogger(DeviceUtil.class);
    
    private static String currentCameraCode;
    
    private static String realPlayCode;
    
    private static ArrayList<DeviceInfo> deviceInfos = new ArrayList<DeviceInfo>();
    
    private static RealPlayService playService = RealPlayService.getInstance();
    
    public static DeviceInfo getCurrentDeviceInfo()
    {
        if (StringUtil.isEmpty(currentCameraCode))
        {
            return null;
        }
        else
        {
            return getDeviceInfo(currentCameraCode);
        }
    }
    
    public static DeviceInfo getRealPlayDeviceInfo()
    {
        if (StringUtil.isEmpty(realPlayCode))
        {
            return null;
        }
        else
        {
            return getDeviceInfo(realPlayCode);
        }
    }
    
    public static DeviceInfo getDeviceInfo(String code)
    {
        DeviceInfo deviceInfo = null;
        if (!deviceInfos.isEmpty())
        {
            for (DeviceInfo info : deviceInfos)
            {
                if (code.equals(info.getCode()))
                {
                    deviceInfo = info;
                    break;
                }
            }
        }
        return deviceInfo;
    }
    
    public static boolean startRealPlay(String code)
    {
        LOGGER.info("start RealPlay, camera code: " + code);
        
        SDKResult<Long> playResult = playService.startRealPlay(code);
        if (0 == playResult.getErrCode())
        {
            DeviceInfo info = getDeviceInfo(code);
            info.setHandle(playResult.getResult());
            return true;
        }
        LOGGER.info("start RealPlay end, resultCode:" + playResult.getErrCode() + ",handle:" + playResult.getResult());
        return false;
    }
    
    public static boolean stopRealPlay(String code)
    {
        LOGGER.info("stop RealPlay start");
        DeviceInfo info = getDeviceInfo(code);
        if (info != null)
        {
            SDKErrorCode stopResult = playService.stopRealPlay(info.getHandle());
            if (0 == stopResult.getErrCode())
            {
                info.setHandle(-1l);
                return true;
            }
            LOGGER.info("start RealPlay end, resultCode:" + stopResult.getErrCode());
        }
        else
        {
            LOGGER.error("start RealPlay failed, no such device. code:" + code);
        }
        return false;
        
    }
    
    public static String getCurrentCameraCode()
    {
        return currentCameraCode;
    }
    
    public static void setCurrentCameraCode(String currentCameraCode)
    {
        DeviceUtil.currentCameraCode = currentCameraCode;
    }
    
    public static String getRealPlayCode()
    {
        return realPlayCode;
    }
    
    public static void setRealPlayCode(String realPlayCode)
    {
        DeviceUtil.realPlayCode = realPlayCode;
    }
    
    public static ArrayList<DeviceInfo> getDeviceInfos()
    {
        return deviceInfos;
    }
    
}
