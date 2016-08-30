package com.huawei.esdk.platform.session.itf;


public interface ISessionMgr
{
    public boolean saveSDKSession(String sdkSession);
    
    public boolean saveSecretKey(String sdkSession, byte[] secretKey);
    
    public boolean saveSecretKey(String sdkSession, byte[] secretKey, byte[] iv);
    
    public boolean isSDKSessionExists(String sdkSession);
    
    public void removeSDKSession(String sdkSession);
    
    public byte[] getSecretKey(String sdkSession);
    
    public byte[] getIv(String sdkSession);
    
}
