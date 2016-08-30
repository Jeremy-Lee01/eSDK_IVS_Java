package com.huawei.esdk.csdemo.view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.huawei.esdk.csdemo.action.impl.GetAlarmEventBtnActionImpl;
import com.huawei.esdk.csdemo.action.impl.GetDeviceListBtnActionImpl;
import com.huawei.esdk.csdemo.action.impl.Sence1BtnActionImpl;
import com.huawei.esdk.csdemo.action.impl.SubscribeAlarmBtnActionImpl;
import com.huawei.esdk.csdemo.common.InterfaceNameConstant;
import com.huawei.esdk.csdemo.common.ServiceFactory;

public class DemoApp
{
    public static MainFrame mainFrame;
    
    public static TabPanelContent tabContent;
    
    public static LoadingFrame loadingFrame = new LoadingFrame();
    
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                
                loadingFrame = new LoadingFrame();
                loadingFrame.setLocationRelativeTo(null);
                loadingFrame.setVisible(true);
                loadingFrame.showProgressMessage("加载Native模块,请稍候...");
            }
        });
        ServiceFactory.getInstance();
        
        try
        {
            System.setProperty("org.apache.cxf.JDKBugHacks.defaultUsesCaches", "true");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
        
        loadingFrame.showProgressMessage("初始化Demo组件,请稍候...");
        lunchFrame();
        
    }
    
    public static void lunchFrame()
    {
        tabContent = new TabPanelContent();
        tabContent.init();
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                mainFrame = new MainFrame(tabContent);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setVisible(true);
                loadingFrame.finish();
            }
        });
        
        // 向各个接口对应的面板中加入执行native方法的事件，start
        GetAlarmEventBtnActionImpl getAlarmEventBtnAction = new GetAlarmEventBtnActionImpl();
        tabContent.getTabs().get(InterfaceNameConstant.getAlarmEventInfo).setAction(getAlarmEventBtnAction);
        
        GetDeviceListBtnActionImpl getDeviceListBtnAction = new GetDeviceListBtnActionImpl();
        tabContent.getTabs().get(InterfaceNameConstant.getDeviceList).setAction(getDeviceListBtnAction);
        
        SubscribeAlarmBtnActionImpl subscribeAlarmBtnAction = new SubscribeAlarmBtnActionImpl();
        tabContent.getTabs().get(InterfaceNameConstant.subscribeAlarm).setAction(subscribeAlarmBtnAction);
        
        Sence1BtnActionImpl sence1BtnAction = new Sence1BtnActionImpl();
        tabContent.getTabs().get(InterfaceNameConstant.scene1).setAction(sence1BtnAction);
        // end
        
    }
    
}
