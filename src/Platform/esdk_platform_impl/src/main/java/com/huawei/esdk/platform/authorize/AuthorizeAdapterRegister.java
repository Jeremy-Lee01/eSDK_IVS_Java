package com.huawei.esdk.platform.authorize;

import com.huawei.esdk.platform.authorize.itf.IAuthorizeAdapter;
import com.huawei.esdk.platform.authorize.itf.IAuthorizeAdapterRegister;
import com.huawei.esdk.platform.interceptor.AppAuthorize;

public class AuthorizeAdapterRegister implements IAuthorizeAdapterRegister
{
    private AppAuthorize appAuthorize;
    
    private RestAppAuthorize restAppAuthorize;
    
    public AppAuthorize getAppAuthorize()
    {
        return appAuthorize;
    }

    public void setAppAuthorize(AppAuthorize appAuthorize)
    {
        this.appAuthorize = appAuthorize;
    }

    public RestAppAuthorize getRestAppAuthorize()
    {
        return restAppAuthorize;
    }

    public void setRestAppAuthorize(RestAppAuthorize restAppAuthorize)
    {
        this.restAppAuthorize = restAppAuthorize;
    }

    @Override
    public void regAuthorizeAdapter(IAuthorizeAdapter authorizeAdapter)
    {
        if ("rest".equalsIgnoreCase(authorizeAdapter.getAdapterType()))
        {
            if (null != restAppAuthorize)
            {
                restAppAuthorize.regAuthorizeAdapter(authorizeAdapter);
            }
        }
        else if ("all".equalsIgnoreCase(authorizeAdapter.getAdapterType()))
        {
            if (null != restAppAuthorize)
            {
                restAppAuthorize.regAuthorizeAdapter(authorizeAdapter);
            }
            if (null != appAuthorize)
            {
                appAuthorize.regAuthorizeAdapter(authorizeAdapter);
            }
        }
        else if ("soap".equalsIgnoreCase(authorizeAdapter.getAdapterType()))
        {
            if (null != appAuthorize)
            {
                appAuthorize.regAuthorizeAdapter(authorizeAdapter);
            }
        }
    }    
}
