package com.huawei.esdk.platform.authorize.itf;

public interface IAuthorizeAdapter
{
    public String getBusinessName();
    
    public boolean reqMsgMatchesBuiness(String funcName, Object message);
    
    public boolean needAuthorize(String funcName, Object message);
    
    public String authorize(Object message);
    
    String getAdapterType();
}
