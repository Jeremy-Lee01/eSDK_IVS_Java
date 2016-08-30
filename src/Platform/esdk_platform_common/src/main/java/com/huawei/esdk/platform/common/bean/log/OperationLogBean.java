package com.huawei.esdk.platform.common.bean.log;

public class OperationLogBean
{
    /*
     * 内部模块名称，暂时分为：login、config、log、version
     */
    private String moduleName;
    
    /*
     * 操作用户
     */
    private String userId;
    
    /*
     * 操作客户端标识，一般为客户端IP
     */
    private String clientFlag;
    
    /*
     * resultCode:指操作成功还是失败，用"successful"、"failed"标识
     */
    private String resultCode;
    
    /*
     * 关键描述信息
     */
    private String keyInfo;

    public String getModuleName()
    {
        return moduleName;
    }

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getClientFlag()
    {
        return clientFlag;
    }

    public void setClientFlag(String clientFlag)
    {
        this.clientFlag = clientFlag;
    }

    public String getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }

    public String getKeyInfo()
    {
        return keyInfo;
    }

    public void setKeyInfo(String keyInfo)
    {
        this.keyInfo = keyInfo;
    }
}
