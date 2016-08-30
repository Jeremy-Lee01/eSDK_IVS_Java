package com.huawei.esdk.platform.commu;

import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.commu.itf.IProtocolAdapterManager;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;

public class ProtocolAdapterManager implements IProtocolAdapterManager, ESDKConstant
{
    
    @Override
    public ISDKProtocolAdapter getProtocolInstanceByType(String protocolAdapterType, String sap)
    {
        if (PROTOCOL_ADAPTER_TYPE_SOAP_CXF.equals(protocolAdapterType))
        {
            return new CXFSOAPProtocolAdapter(sap);
        }
        else if (PROTOCOL_ADAPTER_TYPE_HTTP.equals(protocolAdapterType))
        {
            return new HttpProtocolAdapter(sap);
        }
        else if (PROTOCOL_ADAPTER_TYPE_HTTP_JDK.equals(protocolAdapterType))
        {
            return new HttpProtocolJDKAdapter(sap);
        }
        else if (PROTOCOL_ADAPTER_TYPE_REST.equals(protocolAdapterType))
        {
            return new RestfulAdapterImplHttpClient(sap);
        }
        else if (PROTOCOL_ADAPTER_TYPE_REST_HTLS.equals(protocolAdapterType))
        {
            return new RestfulAdapterImplHttpClientHTLS(sap);
        }
        
        return null;
    }
    
}
