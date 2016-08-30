package com.huawei.esdk.platform.flowcontrol;

import com.huawei.esdk.platform.flowcontrol.itf.IPerformer;

public class Performer implements IPerformer
{
    @Override
    public void doFlowControl(int flowCtrlDegree)
    {
        return;
    }

    // 对本消息进行流控，返回流控结果，false：无需处理；true：消息已被流控
    @Override
    public boolean doFilter(Object message)
    {
        return false;
    }
}
