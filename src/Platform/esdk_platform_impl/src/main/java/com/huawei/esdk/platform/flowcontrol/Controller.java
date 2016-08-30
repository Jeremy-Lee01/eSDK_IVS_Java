package com.huawei.esdk.platform.flowcontrol;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.NumberUtils;
import com.huawei.esdk.platform.flowcontrol.itf.IController;
import com.huawei.esdk.platform.flowcontrol.itf.IMonitor;
import com.huawei.esdk.platform.flowcontrol.itf.IPerformer;
import com.huawei.esdk.platform.flowcontrol.itf.IPolicies;

public class Controller implements IController, Runnable
{
    private static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Controller.class);
    
    // 流控策略
    private IPolicies policies;
    
    // 监控器
    private IMonitor monitor;
    
    // 监控执行模块
    private IPerformer performer;
    
    // 执行线程
    private Thread runningThread;
    
    // SOAP接口访问监控周期（s）
    private final int MONITER_INTERVAL = 1;
    
    // 强制流控等级
    private final int MAXDEGREE = 100;
    
    // 线程执行标志位
    private volatile  int flowCtrlFlag;
    
    // 启动监控线程
    @Override
    public void run()
    {
        while (true)
        {
            if (getFlowCtrlFlag() > 0)
            {
                // 采集数据
                long soapCallCnt = (Long)monitor.getStatus();
                // 评估数据,返回评估结果（流控等级）
                int flowCtrlDegree = policies.loadEvaluate(soapCallCnt);
                // 根据评估数据通知Performer执行
                performer.doFlowControl(flowCtrlDegree);
            }
            try
            {
                // 采样间隔
                Thread.sleep(MONITER_INTERVAL * 1000);
            }
            catch (InterruptedException e)
            {
                LOGGER.error("running thread is interrupted", e);
            }
        }
    }
    
    // 系统启动后即启动监控线程
    public void startMonitor()
    {
    	flowCtrlFlag = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("flowControlFlag"));
        runningThread = new Thread(this);
        try
        {
            runningThread.start();
        }
        catch (IllegalThreadStateException e)
        {
            LOGGER.error("monitor thread run error", e);
        }
    }
    
    // 注册登记接口，Monitor和Performer通过此接口向Controller注册，并建立通道--暂不使用，采用spring注入方式注册
    @Override
    public void register()
    {
        return;
    }
    
    // 手动通知开启或关闭流控---特殊场合需要实行对所有消息的流控 
    public void notifyFlowControlByNeed(boolean fcSwitch)
    {
        if (fcSwitch)
        {
            setFlowCtrlFlag(0); // 关闭流控监测
            performer.doFlowControl(MAXDEGREE); // 通知执行流控
        }
        else
        {
            setFlowCtrlFlag(1); // 开启流控监测
        }
        return;
    }
    
    public void setPolicies(IPolicies policies)
    {
        this.policies = policies;
    }
    
    public void setMonitor(IMonitor monitor)
    {
        this.monitor = monitor;
    }
    
    public void setPerformer(IPerformer performer)
    {
        this.performer = performer;
    }

    public void setFlowCtrlFlag(int flowCtrlFlag)
    {
        this.flowCtrlFlag = flowCtrlFlag;
    }

    public int getFlowCtrlFlag()
    {
        return flowCtrlFlag;
    }
}
