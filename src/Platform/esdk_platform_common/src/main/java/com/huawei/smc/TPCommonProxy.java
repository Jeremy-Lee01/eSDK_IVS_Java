package com.huawei.smc;

public class TPCommonProxy implements com.huawei.smc.TPCommon {
  private String _endpoint = null;
  private com.huawei.smc.TPCommon tPCommon = null;
  
  public TPCommonProxy() {
    _initTPCommonProxy();
  }
  
  public TPCommonProxy(String endpoint) {
    _endpoint = endpoint;
    _initTPCommonProxy();
  }
  
  private void _initTPCommonProxy() {
    try {
      tPCommon = (new com.huawei.smc.TPCommonServiceLocator()).getTPCommonPort();
      if (tPCommon != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tPCommon)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tPCommon)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tPCommon != null)
      ((javax.xml.rpc.Stub)tPCommon)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.huawei.smc.TPCommon getTPCommon() {
    if (tPCommon == null)
      _initTPCommonProxy();
    return tPCommon;
  }
  
  public int authenticate(byte[] encryptPassword) throws java.rmi.RemoteException{
    if (tPCommon == null)
      _initTPCommonProxy();
    return tPCommon.authenticate(encryptPassword);
  }
  
  public int keepAlive() throws java.rmi.RemoteException{
    if (tPCommon == null)
      _initTPCommonProxy();
    return tPCommon.keepAlive();
  }
  
  public int logout() throws java.rmi.RemoteException{
    if (tPCommon == null)
      _initTPCommonProxy();
    return tPCommon.logout();
  }
  
  public void loginRequest(java.lang.String userName, java.lang.String clientType, java.lang.Integer version, javax.xml.rpc.holders.IntHolder resultCode, javax.xml.rpc.holders.ByteArrayHolder randomSequence, javax.xml.rpc.holders.ByteArrayHolder salt, javax.xml.rpc.holders.StringHolder hashType) throws java.rmi.RemoteException{
    if (tPCommon == null)
      _initTPCommonProxy();
    tPCommon.loginRequest(userName, clientType, version, resultCode, randomSequence, salt, hashType);
  }
  
  
}