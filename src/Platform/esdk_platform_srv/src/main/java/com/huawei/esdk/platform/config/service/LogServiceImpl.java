package com.huawei.esdk.platform.config.service;

import java.util.List;

import com.huawei.esdk.platform.common.bean.log.LogBean;
import com.huawei.esdk.platform.config.dao.LogDaoImpl;
import com.huawei.esdk.platform.config.dao.itf.ILogDao;
import com.huawei.esdk.platform.config.service.itf.ILogService;


public final class LogServiceImpl implements ILogService
{

    private static ILogService instance = new LogServiceImpl();

    private ILogDao logDao;
    
    public static ILogService getInstance()
    {
        return instance;
    }

    private LogServiceImpl()
    {
        logDao = new LogDaoImpl();
    }

    @Override
    public List<LogBean> listLogs(Long beginTime, Long endTime,Integer pageSize)
    {
        return logDao.listLogs(beginTime, endTime,pageSize);
    }

    @Override
    public void closeReader()
    {
        logDao.closeReader();
    }

}
