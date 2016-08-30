package com.huawei.esdk.csdemo.service;

import org.apache.log4j.Logger;

import com.huawei.esdk.csdemo.BaseCablilityJNA;
import com.huawei.esdk.csdemo.common.SDKErrorCode;
import com.huawei.esdk.csdemo.model.LoginInfo;
import com.huawei.esdk.csdemo.util.PropertiesUtils;
import com.huawei.esdk.csdemo.util.StringUtil;
import com.sun.jna.ptr.IntByReference;

public class CommonService
{
    private static final Logger LOGGER = Logger.getLogger(CommonService.class);
    
    private static int SESSIONID = -1;
    
    private static CommonService service = null;
    
    public static synchronized CommonService getInstance()
    {
        if (null == service)
        {
            service = new CommonService();
        }
        return service;
    }
    
    public static CommonService getService()
    {
        return service;
    }
    
    public static void setService(CommonService service)
    {
        CommonService.service = service;
    }
    
    public static int getSESSIONID()
    {
        return SESSIONID;
    }
    
    public static void setSESSIONID(int sESSIONID)
    {
        SESSIONID = sESSIONID;
    }
    
    public static Logger getLogger()
    {
        return LOGGER;
    }
    
    public SDKErrorCode init()
    {
        LOGGER.info("init start --->>> ");
        
        SDKErrorCode result = new SDKErrorCode();
        int resultCode = BaseCablilityJNA.INSTANCE.IVS_SDK_Init();
        result.setErrCode(resultCode);
        
        LOGGER.info("init result code: " + resultCode);
        LOGGER.info("init end --->>> ");
        
        return result;
    }
    
    public SDKErrorCode cleanup()
    {
        LOGGER.info("cleanup start --->>> ");
        
        SDKErrorCode result = new SDKErrorCode();
        int resultCode = BaseCablilityJNA.INSTANCE.IVS_SDK_Cleanup();
        result.setErrCode(resultCode);
        
        LOGGER.info("cleanup result code: " + resultCode);
        LOGGER.info("cleanup end --->>> ");
        return result;
    }
    
    public int doConnection()
    {
        
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.clear();
        
        loginInfo.userName = StringUtil.getNativeBytes(PropertiesUtils.getValue("connect.username"));
        loginInfo.password = StringUtil.getNativeBytes(PropertiesUtils.getValue("connect.passwd"));
        loginInfo.port = Integer.valueOf(PropertiesUtils.getValue("connect.port"));
        loginInfo.ipInfo.ip = StringUtil.getNativeBytes(PropertiesUtils.getValue("connect.ip"));
        loginInfo.ipInfo.ipType = 0;
        loginInfo.clientType = 0;
        loginInfo.loginType = 0;
        
        IntByReference ref = new IntByReference();
        int resultCode = BaseCablilityJNA.INSTANCE.IVS_SDK_Login(loginInfo, ref);
        
        LOGGER.info("login result code: " + resultCode);
        
        if (0 == resultCode)
        {
            CommonService.setSESSIONID(ref.getValue());
        }
        
        return resultCode;
    }
    
    public int destroyConnection()
    {
        LOGGER.info("destroy connection start");
        
        int result = 1;
        
        if (-1 != CommonService.getSESSIONID())
        {
            result = BaseCablilityJNA.INSTANCE.IVS_SDK_Logout(CommonService.getSESSIONID());
        }
        
        if (0 == result)
        {
            LOGGER.info("destroy connection success");
            CommonService.setSESSIONID(-1);
        }
        else
        {
            LOGGER.error("destroy connection failed");
        }
        LOGGER.info("destroy connection end");
        return result;
    }
}
