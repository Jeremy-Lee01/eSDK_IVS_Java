package com.huawei.esdk.csdemo.view.utils.bean;

public class MyNode
{
    private String key;
    private String value;
    private String displayName;
    
    public MyNode(String key, String value){
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString()
    {
        return displayName;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    
}

