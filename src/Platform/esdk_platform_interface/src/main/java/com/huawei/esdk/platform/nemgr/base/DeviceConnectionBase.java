package com.huawei.esdk.platform.nemgr.base;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import com.huawei.esdk.platform.authorize.itf.IAuthorizePolicy;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.nemgr.itf.IDeviceConnection;

public abstract class DeviceConnectionBase implements IDeviceConnection
{
    protected ConcurrentHashMap<String, Object> mapData = new ConcurrentHashMap<String, Object>();
    
    protected String loginUser;
    
    protected String loginPassword;
    
    protected String session;
    
    protected DeviceConnectionBase(String user, String pwd)
    {
        loginUser = user;
        loginPassword = pwd;
    }
    
    protected AccountInfo getDevAcctInfo(IAuthorizePolicy authorizePolicy)
    {
        MessageContext mc = ThreadLocalHolder.get();
        AccountInfo devAcctInfo = authorizePolicy.getDeviceAccountInfo(getLoginUser(), getLoginPassword());
        if (null == devAcctInfo)
        {
            //For reconnection case
            AccountInfo esdkAcct = (AccountInfo)getAdditionalData(ESDKConstant.ACCT_INFO_ESDK);
            if (null != esdkAcct)
            {
                mc.getEntities().put(ESDKConstant.ACCT_INFO_ESDK, esdkAcct);
                devAcctInfo = authorizePolicy.getDeviceAccountInfo(esdkAcct.getUserId(), esdkAcct.getPassword());
            }
        }
        
        return devAcctInfo;
    }
    
    @Override
    public Object getAdditionalData(String key)
    {
        return mapData.get(key);
    }
    
    @Override
    public void setAdditionalData(String key, Object data)
    {
        mapData.put(key, data);
    }
    
    @Override
    public int getKeepAliveTimes()
    {
        return 1;
    }
    
    @Override
    public int getKeepAlivePeriod()
    {
        return 10000;
    }
    
    @Override
    public Date getStartTime()
    {
        return new Date();
    }
    
    public String getLoginUser()
    {
        return loginUser;
    }
    
    public void setLoginUser(String loginUser)
    {
        this.loginUser = loginUser;
    }
    
    public String getLoginPassword()
    {
        return loginPassword;
    }
    
    public void setLoginPassword(String loginPassword)
    {
        this.loginPassword = loginPassword;
    }
    
    public String getSession()
    {
        return session;
    }
    
    public void setSession(String session)
    {
        this.session = session;
    }

    @Override
    public boolean isLocalAuth()
    {
        // TODO Auto-generated method stub
        return true;
    }
    
    
}
