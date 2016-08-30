package com.huawei.esdk.platform.authorize.itf;

import com.huawei.esdk.platform.common.bean.aa.AccountInfo;

public interface IAuthorizePolicy
{
    AccountInfo getDeviceAccountInfo(String userId, String pwd);
    
    String getAuthPolicy();
}
