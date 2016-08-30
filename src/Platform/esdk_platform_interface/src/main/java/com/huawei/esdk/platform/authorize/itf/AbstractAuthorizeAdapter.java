package com.huawei.esdk.platform.authorize.itf;

public abstract class AbstractAuthorizeAdapter implements IAuthorizeAdapter
{
    private IAuthorizeAdapterRegister authorizeAdapterRegister;
    
    private String businessName;
    
    public AbstractAuthorizeAdapter(String businessName)
    {
        this.businessName = businessName;
    }
    
    public String getAdapterType()
    {
        return "soap";
    }
    
    public void init()
    {
        getAuthorizeAdapterRegister().regAuthorizeAdapter(this);
    }
    
    @Override
    public String getBusinessName()
    {
        return businessName;
    }
    
    public IAuthorizeAdapterRegister getAuthorizeAdapterRegister()
    {
        return authorizeAdapterRegister;
    }

    public void setAuthorizeAdapterRegister(IAuthorizeAdapterRegister authorizeAdapterRegister)
    {
        this.authorizeAdapterRegister = authorizeAdapterRegister;
    }
}
