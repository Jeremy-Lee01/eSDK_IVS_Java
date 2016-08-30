package com.huawei.esdk.platform.log.itf;

import com.huawei.esdk.platform.common.bean.log.InterfaceLogBean;

public interface IInterfaceLog
{
    void info(String log);
    
    void info(InterfaceLogBean logBean);
    
    void error(InterfaceLogBean logBean);
}
