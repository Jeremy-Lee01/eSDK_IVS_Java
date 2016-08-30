package com.huawei.esdk.platform.authorize.itf;

import com.huawei.esdk.platform.common.bean.aa.AccountInfo;

public interface IAuthorize
{
    String getAuthPolicy(String product);
    
    void setAuthPolicy(String product, String authPolicy);
    
    boolean isLocalAuth(String product);
    
    AccountInfo getESDKAccountInfo(String product, String devId, String devAppId);
    
    AccountInfo getDevAccountInfo(String devId, String esdkAppId);
    
    IAuthorizePolicy getAuthPolicyImpl(String authPolicy, String deviceId);
}
