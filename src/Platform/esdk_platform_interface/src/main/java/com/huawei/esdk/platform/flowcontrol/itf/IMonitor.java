package com.huawei.esdk.platform.flowcontrol.itf;

public interface IMonitor
{
    // 系统上报运行状态 ，消息访问个数上报
    void reportStatus(int msgVisitCnt);

    // 控制器获取监控数据，供Controller调用
    long getStatus();
}
