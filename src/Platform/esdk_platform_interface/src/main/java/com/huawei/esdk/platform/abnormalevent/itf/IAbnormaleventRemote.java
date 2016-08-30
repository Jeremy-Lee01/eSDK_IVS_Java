package com.huawei.esdk.platform.abnormalevent.itf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.huawei.esdk.platform.common.bean.abnormalevent.AbnormaleventBean;

public interface IAbnormaleventRemote extends Remote
{
    List<Integer> sumExceptions() throws RemoteException;
    
    List<AbnormaleventBean> queryExceptionInfos() throws RemoteException;
}
