package com.huawei.esdk.platform.common.bean.commu;

import java.util.HashMap;
import java.util.Map;

public class BaseBean
{
    private Map<String, String> context = new HashMap<String, String>(4);
    
    public Map<String, String> getContext()
    {
        return context;
    }
    
    public void setContext(Map<String, String> context)
    {
        this.context = context;
    }
}
