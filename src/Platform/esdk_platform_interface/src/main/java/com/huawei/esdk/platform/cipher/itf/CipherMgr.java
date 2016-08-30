package com.huawei.esdk.platform.cipher.itf;

import java.security.interfaces.RSAPublicKey;

public interface CipherMgr
{
    public RSAPublicKey getPublicKey();
    
    public void updatePrivateKey() throws Exception;
    
    public void updateSystemKey() throws Exception;
    
    public void initSystemKey() throws Exception;
}
