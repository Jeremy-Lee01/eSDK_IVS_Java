package com.huawei.esdk.csdemo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.border.EtchedBorder;

import com.huawei.esdk.csdemo.IVS_Demo;
import com.huawei.esdk.csdemo.util.DeviceUtil;
import com.sun.jna.platform.win32.WinDef.HWND;

public class MainFrame extends JFrame
{
    private static final long serialVersionUID = -3495219496188239173L;
    
    private static HWND HWND = new HWND();
    
    private Color backColor = new Color(83, 83, 83);
    
    private Panel canvas;
    
    private JPanel base;
    
    public static JPanel panelList;
    
    private JPanel body = new JPanel();
    
    public static MainFrame mainFrame;
    
    public MainFrame()
    {
        mainFrame = this;
        initComponents();
        
        setTitle("IVS CS DEMO");
        setUndecorated(true);
        setBounds(200, 120, 856, 525);
        setVisible(true);
        setContentPane(base);
        
        Image img = IVS_Demo.getImage("eSpace_IVS.png");
        if (null != img)
            this.setIconImage(img);
    }
    
    private void initComponents()
    {
        body.setOpaque(false);
        
        base = new JPanel();
        base.setBackground(backColor);
        base.setLayout(new BorderLayout(0, 0));
        base.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, backColor));
        base.add("North", new TitlePanel());
        base.add("South", body);
    }
    
    public JPanel createMainBody()
    {
        
        canvas = new Panel()
        {
            private static final long serialVersionUID = -9089045715626357327L;
            
            public void paint(Graphics g)
            {
                Image img = IVS_Demo.getImage("logo.jpg");
                
                if (null != img)
                    g.drawImage(img, 0, 0, 640, 480, this);
                super.paint(g);
                
            }
        };
        
        JPanel panelCtrl = new JPanel();
        panelCtrl.add(new InfoPanel());
        
        panelCtrl.add(new CtrlPanel());
        panelCtrl.setMaximumSize(new Dimension(180, 480));
        panelCtrl.setOpaque(false);
        
        panelList = new JPanel();
        panelList.setMaximumSize(new Dimension(200, 484));
        panelList.setBackground(new Color(57, 57, 57));
        panelList.setVisible(false);
        
        if (!DeviceUtil.getDeviceInfos().isEmpty())
        {
            panelList.add(new ScrollPane().getScrollPane());
        }
        
        JPanel panelRight = new JPanel();
        panelRight.setPreferredSize(new Dimension(200, 484));
        panelRight.setBackground(new Color(70, 70, 70));
        panelRight.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLACK, backColor));
        panelRight.setLayout(new OverlayLayout(panelRight));
        panelRight.add(panelList);
        panelRight.add(panelCtrl);
        panelRight.addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseMoved(MouseEvent e)
            {
                Point point = e.getPoint();
                if (point.x > 188)
                {
                    panelList.setVisible(true);
                }
            }
        });
        panelRight.addMouseListener(new MouseAdapter()
        {
            public void mouseExited(MouseEvent e)
            {
                panelList.setVisible(false);
                InfoPanel.refreshData();
            }
        });
        
        canvas.setPreferredSize(new Dimension(640, 480));
        canvas.setBackground(Color.BLACK);
        
        JPanel panelCanvas = new JPanel();
        panelCanvas.add(canvas);
        panelCanvas.setBackground(Color.black);
        
        JPanel mainBody = new JPanel();
        mainBody.setBackground(backColor);
        mainBody.setLayout(new BorderLayout());
        mainBody.add("West", panelCanvas);
        mainBody.add("East", panelRight);
        
        return mainBody;
    }
    
    public void setBody(JPanel panel)
    {
        body.setVisible(false);
        base.remove(body);
        this.body = panel;
        base.add("South", body);
        base.repaint();
    }
    
    public static HWND getHWND()
    {
        return HWND;
    }
    
    public Panel getCanvas()
    {
        return canvas;
    }
}
