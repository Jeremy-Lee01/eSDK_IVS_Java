package com.huawei.esdk.platform.commu.itf;

import java.util.Map;

import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public interface ISDKProtocolAdatperCustProvider
{
    Object preProcessReq(Object reqMessage);

    Map<String, String> getRequestHeaders();
    
    String getContent4Sending(Object reqMessage);
    
    Object preSend(Object reqMessage);
    
    String reBuildNewUrl(String url, String interfaceName);
    
    Object postSend(Object resMessage) throws ProtocolAdapterException;
    
    Object postBuildRes(Object resMessage, String resObjClass) throws ProtocolAdapterException;
    
    AccountInfo getProtocolAuthInfo();    
}
