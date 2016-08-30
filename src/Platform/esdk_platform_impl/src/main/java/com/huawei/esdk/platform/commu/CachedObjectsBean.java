package com.huawei.esdk.platform.commu;

import org.apache.cxf.endpoint.Client;

public class CachedObjectsBean
{
    private Object service;
    
    private Client client;
    
    private Object reserved1;

    public Object getService()
    {
        return service;
    }

    public void setService(Object service)
    {
        this.service = service;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public Object getReserved1()
    {
        return reserved1;
    }

    public void setReserved1(Object reserved1)
    {
        this.reserved1 = reserved1;
    }
}
