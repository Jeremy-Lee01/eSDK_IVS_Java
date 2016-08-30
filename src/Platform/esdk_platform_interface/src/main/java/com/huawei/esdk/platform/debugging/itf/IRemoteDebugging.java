package com.huawei.esdk.platform.debugging.itf;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteDebugging extends Remote
{
    boolean setLoggerLevel(String packageName,String level) throws RemoteException;
}
