package com.huawei.esdk.platform.authorize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;

import com.huawei.esdk.platform.authorize.itf.IAuthorizeAdapter;

public class RestAppAuthorize
{
    private static final Logger LOGGER = Logger.getLogger(RestAppAuthorize.class);
    
    private List<IAuthorizeAdapter> authorizeAdapters = new ArrayList<IAuthorizeAdapter>(1);
    
    private IAuthorizeAdapter defaultAuthorizeAdapter;
    
    public void regAuthorizeAdapter(IAuthorizeAdapter authorizeAdapter)
    {
        authorizeAdapters.add(authorizeAdapter);
    }
    
    public IAuthorizeAdapter getDefaultAuthorizeAdapter()
    {
        if (null == defaultAuthorizeAdapter)
        {
            defaultAuthorizeAdapter = new DefaultAuthorizeAdapter();
        }
        
        return defaultAuthorizeAdapter;
    }

    public int verify(String interfaceName, Map<String, String> message)
    {
        IAuthorizeAdapter authorizeAdapter = getAuthorizeAdapter(interfaceName, message);
        
        if (authorizeAdapter.needAuthorize(interfaceName, message))
        {
            String aaResult = null;
            try
            {                
                aaResult = authorizeAdapter.authorize(message);
            }
            catch (Exception e)
            {
                LOGGER.error("userLogin method error", e);
                return -1;
            }
            if (!"0".equals(aaResult))
            {
                LOGGER.warn("aaResult=" + aaResult);
                return -1;
            }
        }
        
        return 4;
    }
    
    private IAuthorizeAdapter getAuthorizeAdapter(String interfaceName, Map<String, String> message)
    {
        for (IAuthorizeAdapter item : authorizeAdapters)
        {
            if ("rest".equalsIgnoreCase(item.getAdapterType()) && item.reqMsgMatchesBuiness(interfaceName, message))
            {
                return item;
            }
        }
        
        return getDefaultAuthorizeAdapter();
    }
}
