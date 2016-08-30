package com.huawei.esdk.platform.log.itf;

import com.huawei.esdk.platform.common.bean.log.OperationLogBean;

public interface IOperationLog
{
    void debug(OperationLogBean logBean);
    
    void info(OperationLogBean logBean);
    
    void warn(OperationLogBean logBean);
    
    void error(OperationLogBean logBean);
}
