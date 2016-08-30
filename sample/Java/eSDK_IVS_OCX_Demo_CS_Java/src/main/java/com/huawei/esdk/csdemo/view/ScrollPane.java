package com.huawei.esdk.csdemo.view;

import java.awt.Adjustable;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.huawei.esdk.csdemo.IVS_Demo;
import com.huawei.esdk.csdemo.common.DeviceInfo;
import com.huawei.esdk.csdemo.util.DeviceUtil;
import com.huawei.esdk.csdemo.util.StringUtil;

public class ScrollPane
{
    
    private JScrollPane scrollPane;
    
    public JScrollPane getScrollPane()
    {
        initComponents();
        
        return scrollPane;
    }
    
    private void initComponents()
    {
        DefaultListModel mode = new DefaultListModel();
        
        for (DeviceInfo info : DeviceUtil.getDeviceInfos())
        {
            mode.addElement(info.getCode());
        }
        
        JList devicePanelslist = new JList(mode);
        devicePanelslist.setCellRenderer(new DevicePanel());
        devicePanelslist.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JList jList = (JList)e.getSource();
                
                int index = jList.locationToIndex(e.getPoint());
                String code = (String)jList.getModel().getElementAt(index);
                
                DeviceUtil.setCurrentCameraCode(code);
                
                DeviceInfo deviceInfo = DeviceUtil.getCurrentDeviceInfo();
                
                if (DeviceUtil.getDeviceInfo(code).getStatus() == 1
                    && (StringUtil.isEmpty(DeviceUtil.getRealPlayCode()) || CtrlPanel.playStatus == false))
                {
                    DeviceUtil.setRealPlayCode(code);
                }
                
                if (1 < e.getClickCount())
                {
                    //停止前一个视频播放
                    String preCode = DeviceUtil.getRealPlayCode();
                    if (!StringUtil.isEmpty(preCode) && CtrlPanel.playStatus)
                    {
                        DeviceUtil.stopRealPlay(preCode);
                    }
                    
                    MainFrame.panelList.setVisible(false);
                    InfoPanel.refreshData();
                    
                    //处理设备在线的情况
                    if (1 == deviceInfo.getStatus())
                    {
                        //设置待播放视频信息
                        DeviceUtil.setRealPlayCode(code);
                        
                        //播放选中视频
                        if (DeviceUtil.startRealPlay(code))
                        {
                            CtrlPanel.playStatus = true;
                            JButton playJB = CtrlPanel.playJB;
                            
                            playJB.setIcon(IVS_Demo.getImageIcon("arrows/stop.png"));
                            playJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/stop1.png"));
                            playJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/stop2.png"));
                        }
                    }
                    else
                    {
                        DeviceUtil.setRealPlayCode("");
                        
                        CtrlPanel.playStatus = false;
                        JButton playJB = CtrlPanel.playJB;
                        
                        playJB.setIcon(IVS_Demo.getImageIcon("arrows/play.png"));
                        playJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/play1.png"));
                        playJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/play2.png"));
                    }
                }
            }
        });
        
        scrollPane = new JScrollPane(devicePanelslist);
        scrollPane.setOpaque(false);
        scrollPane.setPreferredSize(new Dimension(181, 468));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e)
            {
                MainFrame.panelList.setVisible(true);
            }
        });
        scrollPane.addMouseWheelListener(new MouseWheelListener()
        {
            
            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                JScrollPane p = (JScrollPane)e.getSource();
                Adjustable adj = p.getVerticalScrollBar();
                if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL)
                {
                    int totalScrollAmount = e.getUnitsToScroll() * adj.getUnitIncrement() * 5;
                    adj.setValue(adj.getValue() + totalScrollAmount);
                }
            }
        });
    }
    
}
