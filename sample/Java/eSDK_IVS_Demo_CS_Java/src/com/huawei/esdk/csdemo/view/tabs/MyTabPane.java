package com.huawei.esdk.csdemo.view.tabs;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import com.huawei.esdk.csdemo.action.DemoAction;

public class MyTabPane extends JTabbedPane
{
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    //执行按钮
    protected JButton actionBtn;
    
    //用于调用Native方法
    private DemoAction action;
    
    public MyTabPane(){
        actionBtn = new JButton();
        actionBtn.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        //执行native方法
                        action.executeNativeMethod();
                    }
                });
            }

        });
    }

    public void International(int languageFlag){
        
    }
    
    public JButton getActionBtn()
    {
        return actionBtn;
    }

    public void setActionBtn(JButton actionBtn)
    {
        this.actionBtn = actionBtn;
    }

    public DemoAction getAction()
    {
        return action;
    }

    public void setAction(DemoAction action)
    {
        this.action = action;
    }

}
