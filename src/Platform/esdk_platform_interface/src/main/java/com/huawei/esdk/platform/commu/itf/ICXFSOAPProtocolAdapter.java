package com.huawei.esdk.platform.commu.itf;

import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public interface ICXFSOAPProtocolAdapter extends ISDKProtocolAdapter
{
    public Object syncSendMessageWithCxf(Object reqMessage,
            String itfClassName, String serviceApiName) throws ProtocolAdapterException;
    
    public Object syncSendMessageWithCxf(Class<?> serviceApi, String itfClassName, Object... reqMessage) throws ProtocolAdapterException;
    
    public Object syncSendMessageWithCxf(Class<?> serviceApi, String itfClassName, Class[] claz, Object... reqMessage) throws ProtocolAdapterException;
    
    public void setCXFSOAPCustProvider(ICXFSOAPCustProvider cxfSOAPCustProvider);
    
    public ICXFSOAPCustProvider getCXFSOAPCustProvider();
}
