package com.huawei.esdk.platform.common;

import java.util.HashMap;
import java.util.Map;

public class MessageContext
{
    private Map<String, Object> entities = new HashMap<String, Object>();

    public Map<String, Object> getEntities()
    {
        return entities;
    }

    public void setEntities(Map<String, Object> entities)
    {
        this.entities = entities;
    }
}
