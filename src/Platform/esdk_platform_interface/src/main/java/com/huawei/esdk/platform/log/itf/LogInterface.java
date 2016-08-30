package com.huawei.esdk.platform.log.itf;

import com.huawei.esdk.platform.common.bean.log.LogBean;

public interface LogInterface
{
    void saveRequestLog(String messageId, LogBean log);
    
    void saveResponseLog(String messageId, LogBean log);
}
