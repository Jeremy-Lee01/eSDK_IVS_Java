package com.huawei.esdk.platform.flowcontrol.itf;

public interface IController
{
    // 注册登记接口，Monitor和Performer通过此接口向Controller注册，并建立通道--暂不使用，采用spring注入方式注册
    void register();

    // 手动通知开启或关闭流控---特殊场合需要实行对所有消息的流控 
    public void notifyFlowControlByNeed(boolean fcSwitch);
}
