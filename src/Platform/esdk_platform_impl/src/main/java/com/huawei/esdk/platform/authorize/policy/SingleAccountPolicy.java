package com.huawei.esdk.platform.authorize.policy;

import com.huawei.esdk.platform.authorize.itf.IAuthorizePolicy;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.constants.ESDKConstant;

public class SingleAccountPolicy implements IAuthorizePolicy
{
    private String deviceId;
    
    public SingleAccountPolicy(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    @Override
    public AccountInfo getDeviceAccountInfo(String userId, String pwd)
    {
        AccountInfo result = new AccountInfo();
        result.setDevId(deviceId);
        result.setUserId(userId);
        result.setPassword(pwd);
        
        return result;
    }
    
    @Override
    public String getAuthPolicy()
    {
        return ESDKConstant.AUTH_POLICY_SINGLE_ACCT;
    }
}
