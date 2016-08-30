/**
 * TPCommon.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huawei.smc;

public interface TPCommon extends java.rmi.Remote {
    public int authenticate(byte[] encryptPassword) throws java.rmi.RemoteException;
    public int keepAlive() throws java.rmi.RemoteException;
    public int logout() throws java.rmi.RemoteException;
    public void loginRequest(java.lang.String userName, java.lang.String clientType, java.lang.Integer version, javax.xml.rpc.holders.IntHolder resultCode, javax.xml.rpc.holders.ByteArrayHolder randomSequence, javax.xml.rpc.holders.ByteArrayHolder salt, javax.xml.rpc.holders.StringHolder hashType) throws java.rmi.RemoteException;
}
