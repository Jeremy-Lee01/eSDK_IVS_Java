package com.huawei.esdk.platform.common.bean.config;

public class ConfigItem
{
    /*
     * 系统，如UC, IVS, TP, SMS, SSO
     */
    private String system;
    
    /*
     * 子系统， 如UC， Parlayx，TOOA
     */
    private String subSystem;
    
    /*
     * 模块，如南向，XXX网元
     */
    private String module;
    
    /*
     * I - Internal, 内部使用，外部用户不可以修改
     * E - External，外部使用，外部用户可以修改
     */
    private String type;
    
    /*
     * A - Active - 有效
     * I - Inactive - 无效
     */
    private String status;
    
    private String key;
    
    private String value;
    
    public String getSystem()
    {
        return system;
    }
    
    public void setSystem(String system)
    {
        this.system = system;
    }
    
    public String getSubSystem()
    {
        return subSystem;
    }
    
    public void setSubSystem(String subSystem)
    {
        this.subSystem = subSystem;
    }
    
    public String getModule()
    {
        return module;
    }
    
    public void setModule(String module)
    {
        this.module = module;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
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
    
    public String[] getValues()
    {
        if (null != value)
        {
            return value.split(",");
        }
        
        return new String[0];
    }
}
