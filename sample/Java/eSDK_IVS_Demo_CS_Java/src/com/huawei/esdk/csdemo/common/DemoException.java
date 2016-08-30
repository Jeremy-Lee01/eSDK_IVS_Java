package com.huawei.esdk.csdemo.common;

import org.apache.log4j.Logger;

public class DemoException extends Exception
{
    protected static final Logger LOGGER = Logger.getLogger(DemoException.class);

    private static final long serialVersionUID = 1L;

    private String errInfo;

    public DemoException(String errInfo)
    {
        this.errInfo = errInfo;
        LOGGER.error("Error Message:" + errInfo);
    }

    public String getErrInfo()
    {
        return errInfo;
    }

    public void setErrInfo(String errInfo)
    {
        this.errInfo = errInfo;
    }

}