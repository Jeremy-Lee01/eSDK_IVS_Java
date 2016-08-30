package com.huawei.esdk.platform.authorize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.authorize.itf.IAuthorize;
import com.huawei.esdk.platform.authorize.itf.IAuthorizePolicy;
import com.huawei.esdk.platform.authorize.policy.AccountMappingPolicy;
import com.huawei.esdk.platform.authorize.policy.PassThroughPolicy;
import com.huawei.esdk.platform.authorize.policy.SingleAccountPolicy;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.bean.config.AppMappingConfig;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.config.SystemConfig;
import com.huawei.esdk.platform.config.service.AppMappingConfigService;

public class Authorize implements IAuthorize
{
    private static final Logger LOGGER = Logger.getLogger(Authorize.class);
    
    private Map<String, String> productAuthPolicy =  new HashMap<String, String>();
    
    static
    {
        // 加载系统密钥，更新系统密钥，更新xml配置文件
        LOGGER.info("Load Authorize");
        SystemConfig.init();
    }
    
    public Authorize()
    {
    }
    
    @Override
    public void setAuthPolicy(String product, String authPolicy)
    {
        productAuthPolicy.put(product, authPolicy);
    }
    
    @Override
    public String getAuthPolicy(String product)
    {
        String authPolicy = productAuthPolicy.get(product);
        if (null == authPolicy)
        {
            authPolicy = ConfigManager.getInstance().getValue(product + ".authentication.policy");
            if (null == authPolicy)
            {
                authPolicy = ESDKConstant.AUTH_POLICY_SINGLE_ACCT;
            }
            productAuthPolicy.put(product, authPolicy);
        }
        
        return authPolicy;
    }
    
    @Override
    public boolean isLocalAuth(String product)
    {
        if (ESDKConstant.AUTH_POLICY_PASS_THROUGH.equalsIgnoreCase(getAuthPolicy(product)))
        {
            return false;
        }
        
        return true;
    }
    
    @Override
    public AccountInfo getESDKAccountInfo(String product, String devId, String devAppId)
    {
        AccountInfo acctInfo = new AccountInfo();
        acctInfo.setDevId(devId);
        if (ESDKConstant.AUTH_POLICY_ACCT_MAPPING.equalsIgnoreCase(getAuthPolicy(product)))
        {
            List<AppMappingConfig> mappings = AppMappingConfigService.getInstance().getAllAppMappings();
            for (AppMappingConfig item : mappings)
            {
                if ((null == devId || devId.equals(item.getDeviceId())) && devAppId.equals(item.getDeviceApp()))
                {
                    acctInfo.setUserId(item.getDeviceApp());
                    break;
                }
            }
        }
        else
        {
            acctInfo.setUserId(devAppId);
        }
        
        return acctInfo;
    }
    
    @Override
    public AccountInfo getDevAccountInfo(String devId, String esdkAppId)
    {
        AccountInfo result = new AccountInfo();
        List<AppMappingConfig> mappings = AppMappingConfigService.getInstance().getAllAppMappings();
        for (AppMappingConfig item : mappings)
        {
            if (devId.equals(item.getDeviceId()) && esdkAppId.equals(item.getEsdkApp()))
            {
                result.setDevId(devId);
                result.setUserId(item.getDeviceApp());
                result.setPassword(item.getDeviceAppPwd());
                break;
            }
        }
        
        return result;
    }
    
    @Override
    public IAuthorizePolicy getAuthPolicyImpl(String authPolicy, String deviceId)
    {
        if (ESDKConstant.AUTH_POLICY_PASS_THROUGH.equals(authPolicy))
        {
            return PassThroughPolicy.getInstance();
        }
        else if (ESDKConstant.AUTH_POLICY_SINGLE_ACCT.equals(authPolicy))
        {
            return new SingleAccountPolicy(deviceId);
        }
        else if (ESDKConstant.AUTH_POLICY_ACCT_MAPPING.equals(authPolicy))
        {
            return new AccountMappingPolicy(deviceId);
        }
        
        throw new IllegalArgumentException("AuthPolicy is invalid");
    }
}
