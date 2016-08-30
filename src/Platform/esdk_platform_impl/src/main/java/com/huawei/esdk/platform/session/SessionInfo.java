package com.huawei.esdk.platform.session;

public class SessionInfo
{
    private String userName;
    
    private byte[] secretKey;
    
    private byte[] iv;
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public byte[] getSecretKey()
    {
        return secretKey;
    }
    
    public void setSecretKey(byte[] secretKey)
    {
        this.secretKey = secretKey;
    }
    
    public byte[] getIv()
    {
        return iv;
    }
    
    public void setIv(byte[] iv)
    {
        this.iv = iv;
    }
    
}
