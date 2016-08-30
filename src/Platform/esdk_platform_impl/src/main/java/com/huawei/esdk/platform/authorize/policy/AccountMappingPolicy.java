package com.huawei.esdk.platform.authorize.policy;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.authorize.itf.IAuthorize;
import com.huawei.esdk.platform.authorize.itf.IAuthorizePolicy;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;

public class AccountMappingPolicy implements IAuthorizePolicy
{
    private static Logger LOGGER = Logger.getLogger(AccountMappingPolicy.class);
    
    private static IAuthorize authorize = ApplicationContextUtil.getBean("authorize");
    
    private String deviceId;    
    
    public AccountMappingPolicy(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    @Override
    public AccountInfo getDeviceAccountInfo(String userId, String pwd)
    {
        MessageContext mc = ThreadLocalHolder.get();
        AccountInfo esdkAcctInfo = null;
        if (null != mc)
        {
            esdkAcctInfo = (AccountInfo)mc.getEntities().get(ESDKConstant.ACCT_INFO_ESDK);
        }
        
        return getAccountFromMapping(deviceId, esdkAcctInfo);
    }
    
    private AccountInfo getAccountFromMapping(String devId, AccountInfo esdkAcctInfo)
    {
        if (null == esdkAcctInfo)
        {
            return null;
        }

        AccountInfo result = authorize.getDevAccountInfo(devId, esdkAcctInfo.getUserId());
        LOGGER.debug("result=" + result);
        return result;
    }

    @Override
    public String getAuthPolicy()
    {
        return ESDKConstant.AUTH_POLICY_ACCT_MAPPING;
    }
}
