package com.huawei.esdk.platform.commu.itf;

import java.util.List;
import java.util.Map;

public interface ICXFSOAPCustProvider
{
    Map<String, String> getSoapHeaders();
    
    List<Object> getInInterceptors();
    
    List<Object> getOutInterceptors();
    
    Map<String, String> getSerivceURIMapping();
    
    String reBuildNewUrl(String url, String interfaceName);
}
