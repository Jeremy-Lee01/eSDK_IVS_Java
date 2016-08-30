package com.huawei.esdk.platform.authorize.policy;

import com.huawei.esdk.platform.authorize.itf.IAuthorizePolicy;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.constants.ESDKConstant;

public final class PassThroughPolicy implements IAuthorizePolicy
{
    private static PassThroughPolicy instance = new PassThroughPolicy();
    
    private PassThroughPolicy()
    {
        //Singleton
    }
    
    public static PassThroughPolicy getInstance()
    {
        return instance;
    }
    
    @Override
    public AccountInfo getDeviceAccountInfo(String userId, String pwd)
    {
        return getAccountInfoFromContext();
    }
    
    private AccountInfo getAccountInfoFromContext()
    {
        MessageContext mc = ThreadLocalHolder.get();
        if (null != mc)
        {
            return (AccountInfo) mc.getEntities().get(ESDKConstant.ACCT_INFO_ESDK);
        }
        
        return null;
    }

    @Override
    public String getAuthPolicy()
    {
        return ESDKConstant.AUTH_POLICY_PASS_THROUGH;
    }
}
