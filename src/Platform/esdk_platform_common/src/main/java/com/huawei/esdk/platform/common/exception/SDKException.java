package com.huawei.esdk.platform.common.exception;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.SDKErrorCode;

public class SDKException extends Exception
{
    protected static final Logger LOGGER = Logger.getLogger(SDKException.class);

    private static final long serialVersionUID = 1L;

    private SDKErrorCode errInfo;

    public SDKException(String msg)
    {
        super(msg);
        errInfo = new SDKErrorCode();
        LOGGER.error("Error Message:" + msg);
    }

    public SDKException(String msg, Throwable t)
    {
        super(msg, t);
        errInfo = new SDKErrorCode();
        LOGGER.error("Error Message:" + msg, t);
    }

    public SDKException(Throwable t)
    {
        super(t);
        errInfo = new SDKErrorCode();
        LOGGER.error(t);
    }

    public String getSdkErrDesc()
    {
        return errInfo.getDescription();
    }

    public void setSdkErrDesc(String sdkErrDesc)
    {
        errInfo.setDescription(sdkErrDesc);
    }

    public long getSdkErrCode()
    {
        return errInfo.getErrCode();
    }

    public void setSdkErrCode(int sdkErrCode)
    {
        errInfo.setErrCode(sdkErrCode);
    }

    public void setSdkErrCode(Integer sdkErrCode)
    {
        errInfo.setErrCode(sdkErrCode);
    }

}