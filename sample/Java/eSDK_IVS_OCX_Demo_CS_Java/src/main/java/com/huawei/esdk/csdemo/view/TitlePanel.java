package com.huawei.esdk.csdemo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.huawei.esdk.csdemo.IVS_Demo;
import com.huawei.esdk.csdemo.service.CommonService;

public class TitlePanel extends JPanel
{
    private static final long serialVersionUID = -6950681104963240030L;
    
    private Point pressedPoint;
    
    private JPanel panelOprate;
    
    private JPanel panelLabel;
    
    private JLabel titleLabel;
    
    public TitlePanel()
    {
        initComponents();
        
        setBackground(new Color(57, 57, 57));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 30));
        add("West", panelLabel);
        add("East", panelOprate);
        
        addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                title_mouseDragged(e);
            }
        });
        
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                pressedPoint = e.getPoint();
            }
        });
    }
    
    private void initComponents()
    {
        titleLabel = new JLabel();
        titleLabel = new JLabel("IVS CS DEMO", IVS_Demo.getImageIcon("logo.png"), SwingConstants.RIGHT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 13));
        titleLabel.setForeground(new Color(200, 200, 200));
        
        panelLabel = new JPanel();
        panelLabel.add(titleLabel);
        panelLabel.setPreferredSize(new Dimension(130, 30));
        panelLabel.setOpaque(false);
        
        JButton minJB = new JButton();
        minJB.setIcon(IVS_Demo.getImageIcon("min.png"));
        minJB.setRolloverIcon(IVS_Demo.getImageIcon("min_rollover.png"));
        minJB.setPressedIcon(IVS_Demo.getImageIcon("min_pressed.png"));
        minJB.setFocusPainted(false);
        minJB.setBorderPainted(false);
        minJB.setContentAreaFilled(false);
        minJB.setPreferredSize(new Dimension(28, 16));
        minJB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                MainFrame.mainFrame.setExtendedState(JFrame.ICONIFIED);
            }
        });
        
        JButton closeJB = new JButton();
        closeJB.setIcon(IVS_Demo.getImageIcon("close.png"));
        closeJB.setRolloverIcon(IVS_Demo.getImageIcon("close_rollover.png"));
        closeJB.setPressedIcon(IVS_Demo.getImageIcon("close_pressed.png"));
        closeJB.setFocusPainted(false);
        closeJB.setBorderPainted(false);
        closeJB.setContentAreaFilled(false);
        closeJB.setPreferredSize(new Dimension(28, 16));
        closeJB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                closeJB_actionPerformed(e);
            }
        });
        
        panelOprate = new JPanel();
        panelOprate.setPreferredSize(new Dimension(90, 30));
        panelOprate.setOpaque(false);
        panelOprate.setLayout(new FlowLayout());
        panelOprate.add(minJB);
        panelOprate.add(closeJB);
    }
    
    private void title_mouseDragged(MouseEvent e)
    {
        Point point = e.getPoint();
        Point localPoint = MainFrame.mainFrame.getLocation();
        int x = point.x + localPoint.x - pressedPoint.x;
        int y = point.y + localPoint.y - pressedPoint.y;
        
        MainFrame.mainFrame.setLocation(x, y);
    }
    
    private void closeJB_actionPerformed(ActionEvent e)
    {
        MainFrame.mainFrame.dispose();
        CommonService commonService = CommonService.getInstance();
        commonService.destroyConnection();
        try
        {
            commonService.cleanup();
        }
        catch (NoClassDefFoundError e1)
        {
        }
        System.exit(0);
    }
}
