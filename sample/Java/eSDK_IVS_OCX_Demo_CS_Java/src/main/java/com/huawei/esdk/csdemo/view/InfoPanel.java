package com.huawei.esdk.csdemo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.huawei.esdk.csdemo.IVS_Demo;
import com.huawei.esdk.csdemo.common.DeviceInfo;
import com.huawei.esdk.csdemo.util.DeviceUtil;

public class InfoPanel extends JPanel
{
    private static final long serialVersionUID = 1478575255346555785L;
    
    private Color backColor = new Color(83, 83, 83);
    
    private Color foreColor = new Color(220, 220, 220);
    
    private static JLabel listLabel, nameLabel, codeLabel, typeLabel, statusLabel, deviceModelTypeLabel, vendorTypeLabel;
    
    private JPanel infoPanel;
    
    public static InfoPanel base;
    
    public InfoPanel()
    {
        initComponents();
        
        setPreferredSize(new Dimension(180, 270));
        setBackground(new Color(70, 70, 70));
        setLayout(new BorderLayout(0, 0));
        
        JPanel northPanel = new JPanel();
        northPanel.setOpaque(false);
        northPanel.setLayout(new BorderLayout(0, 0));
        
        listLabel = new JLabel(IVS_Demo.getImageIcon("list.png"));
        listLabel.setPreferredSize(new Dimension(40, 40));
        
        listLabel.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                MainFrame.panelList.setVisible(true);
            }
            
            public void mousePressed(MouseEvent e)
            {
                listLabel.setIcon(IVS_Demo.getImageIcon("list1.png"));
            }
            
            public void mouseReleased(MouseEvent e)
            {
                listLabel.setIcon(IVS_Demo.getImageIcon("list.png"));
            }
        });
        northPanel.add("West", nameLabel);
        northPanel.add("East", listLabel);
        
        JPanel southPanel = new JPanel();
        southPanel.setBackground(backColor);
        southPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.gray, Color.BLACK));
        southPanel.setLayout(new BorderLayout(0, 0));
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(8, 200));
        emptyPanel.setOpaque(false);
        
        southPanel.add("West", emptyPanel);
        southPanel.add("East", infoPanel);
        
        add("North", northPanel);
        add("South", southPanel);
        base = this;
    }
    
    private void initComponents()
    {
        nameLabel = new JLabel("Show device list", JLabel.CENTER);
        nameLabel.setPreferredSize(new Dimension(140, 40));
        nameLabel.setForeground(foreColor);
        nameLabel.setFont(new Font("default", Font.PLAIN, 14));
        
        codeLabel = new JLabel();
        codeLabel.setText("");
        codeLabel.setPreferredSize(new Dimension(160, 40));
        codeLabel.setForeground(foreColor);
        codeLabel.setFont(new Font("default", Font.PLAIN, 12));
        
        typeLabel = new JLabel();
        typeLabel.setText("");
        typeLabel.setPreferredSize(new Dimension(160, 40));
        typeLabel.setForeground(foreColor);
        typeLabel.setFont(new Font("default", Font.PLAIN, 12));
        
        statusLabel = new JLabel();
        statusLabel.setText("");
        statusLabel.setPreferredSize(new Dimension(160, 40));
        statusLabel.setForeground(foreColor);
        statusLabel.setFont(new Font("default", Font.PLAIN, 12));
        
        deviceModelTypeLabel = new JLabel();
        deviceModelTypeLabel.setText("");
        deviceModelTypeLabel.setPreferredSize(new Dimension(160, 40));
        deviceModelTypeLabel.setForeground(foreColor);
        deviceModelTypeLabel.setFont(new Font("default", Font.PLAIN, 12));
        
        vendorTypeLabel = new JLabel();
        vendorTypeLabel.setText("");
        vendorTypeLabel.setPreferredSize(new Dimension(160, 40));
        vendorTypeLabel.setForeground(foreColor);
        vendorTypeLabel.setFont(new Font("default", Font.PLAIN, 12));
        
        infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(164, 230));
        infoPanel.setOpaque(false);
        
        infoPanel.setLayout(new GridLayout(5, 1));
        infoPanel.add(codeLabel);
        infoPanel.add(typeLabel);
        infoPanel.add(statusLabel);
        infoPanel.add(deviceModelTypeLabel);
        infoPanel.add(vendorTypeLabel);
    }
    
    public static void refreshData()
    {
        DeviceInfo info = DeviceUtil.getCurrentDeviceInfo();
        if (null != info)
        {
            String status, type;
            if (0 == info.getStatus())
            {
                status = "Offline";
            }
            else
            {
                if (1 == info.getStatus())
                    status = "Online";
                else
                    status = "Sleep";
            }
            
            switch (info.getType())
            {
                case 0:
                    type = "Fix";
                    break;
                case 1:
                    type = "PTZ";
                    break;
                case 2:
                    type = "DOME";
                    break;
                case 3:
                    type = "FIX_DOME";
                    break;
                case 4:
                    type = "BULLET";
                    break;
                    
                default:
                    type = "";
                    break;
            }
            
            nameLabel.setText(info.getName());
            codeLabel.setText("Code   : " + info.getCode());
            typeLabel.setText("Type    : " + type);
            statusLabel.setText("Status : " + status);
            deviceModelTypeLabel.setText("Model  : " + info.getDeviceModelType());
            vendorTypeLabel.setText("Vendor: " + info.getVendorType());
            
            base.validate();
        }
    }

}
