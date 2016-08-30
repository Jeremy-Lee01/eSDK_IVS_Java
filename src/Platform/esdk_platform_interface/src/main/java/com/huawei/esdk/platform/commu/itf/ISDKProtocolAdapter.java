package com.huawei.esdk.platform.commu.itf;

import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public interface ISDKProtocolAdapter
{
    String getServiceAccessPoint();
    
    Object syncSendMessage(Object reqMessage, String serviceApiName,
            String resObjClass) throws ProtocolAdapterException;

    String syncSendMessage(String messageContent, String serviceApiName)
            throws ProtocolAdapterException;

    boolean heartBeat() throws ProtocolAdapterException;

    int login(String userName, String pwd) throws ProtocolAdapterException;

    int logout() throws ProtocolAdapterException;
    
    ISDKProtocolAdatperCustProvider getSdkProtocolAdatperCustProvider();

    void setSdkProtocolAdatperCustProvider(
            ISDKProtocolAdatperCustProvider sdkProtocolAdatperCustProvider);
}
