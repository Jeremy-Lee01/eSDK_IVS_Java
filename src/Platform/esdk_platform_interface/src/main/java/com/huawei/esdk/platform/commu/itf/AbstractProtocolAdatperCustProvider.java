package com.huawei.esdk.platform.commu.itf;

import com.huawei.esdk.platform.common.bean.aa.AccountInfo;

public abstract class AbstractProtocolAdatperCustProvider implements ISDKProtocolAdatperCustProvider
{
    public AccountInfo getProtocolAuthInfo()
    {
        return new AccountInfo();
    }
}
