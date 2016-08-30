package com.huawei.esdk.platform.flowcontrol;

import java.util.concurrent.atomic.AtomicLong;

import com.huawei.esdk.platform.flowcontrol.itf.IMonitor;

public class Monitor implements IMonitor
{
    // 监控周期内SOAP接口访问次数
    private static AtomicLong visitCnt = new AtomicLong();;

    @Override
    public void reportStatus(int msgVisitCnt) //报告当前消息状态
    {
        // 调用次数+msgVisitCnt
        long visitAccount = visitCnt.addAndGet(msgVisitCnt);
        visitCnt.set(visitAccount);
        return;
    }

    @Override
    public long getStatus() //获取当前消息状态
    {
        long visitAccount = visitCnt.get();
        visitCnt.set(0);
        return visitAccount;
    }
}
