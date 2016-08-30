package com.huawei.esdk.platform.flowcontrol.itf;

public interface IPerformer
{
    // 流控指令下发接口
    void doFlowControl(int flowCtrlDegree);
    
    // 系统收到新消息后调用该接口进行过滤，返回流控结果
    boolean doFilter(Object message);
}
