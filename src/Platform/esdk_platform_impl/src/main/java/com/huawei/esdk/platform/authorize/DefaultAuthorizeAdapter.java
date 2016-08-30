package com.huawei.esdk.platform.authorize;

import com.huawei.esdk.platform.authorize.itf.IAuthorizeAdapter;

public class DefaultAuthorizeAdapter implements IAuthorizeAdapter
{
    
    @Override
    public boolean needAuthorize(String funcName, Object message)
    {
        return false;
    }

    @Override
    public String authorize(Object message)
    {
        return "0";
    }

    @Override
    public String getBusinessName()
    {
        return "";
    }

    @Override
    public boolean reqMsgMatchesBuiness(String funcName, Object message)
    {
        return true;
    }

    @Override
    public String getAdapterType()
    {
        return "all";
    }
    
}
