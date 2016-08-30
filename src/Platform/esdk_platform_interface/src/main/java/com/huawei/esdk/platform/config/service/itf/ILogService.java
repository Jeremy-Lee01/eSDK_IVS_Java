package com.huawei.esdk.platform.config.service.itf;

import java.util.List;

import com.huawei.esdk.platform.common.bean.log.LogBean;

public interface ILogService
{
    List<LogBean> listLogs(Long beginTime,Long endTime,Integer pageSize);

    void closeReader();
}
