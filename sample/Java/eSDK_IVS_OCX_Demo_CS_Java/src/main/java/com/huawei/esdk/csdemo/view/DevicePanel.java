package com.huawei.esdk.csdemo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EtchedBorder;

import com.huawei.esdk.csdemo.IVS_Demo;
import com.huawei.esdk.csdemo.common.DeviceInfo;
import com.huawei.esdk.csdemo.util.DeviceUtil;

public class DevicePanel extends JPanel implements ListCellRenderer
{
    private static final long serialVersionUID = -244150178994463506L;
    
    private JLabel label;
    
    private String cameraCode;
    
    public DevicePanel()
    {
        JPanel lineUp = new JPanel();
        lineUp.setPreferredSize(new Dimension(120, 1));
        lineUp.setBackground(new Color(57, 57, 57));
        JPanel lineDown = new JPanel();
        lineDown.setPreferredSize(new Dimension(120, 1));
        lineDown.setBackground(new Color(57, 57, 57));
        
        JPanel lineLeft = new JPanel();
        lineLeft.setPreferredSize(new Dimension(5, 40));
        //lineLeft.setBackground(new Color(57, 57, 57));
        lineLeft.setOpaque(false);
        
        this.setLayout(new BorderLayout());
        this.add("West", lineLeft);
        this.add("North", lineUp);
        this.add("Center", label = new JLabel());
        this.add("South", lineDown);
        label.setFont(new Font("default", Font.PLAIN, 12));
        this.setPreferredSize(new Dimension(180, 40));
        this.setBackground(new Color(87, 87, 87));
        this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(87, 87, 87), new Color(150, 150, 150)));
    }
    
    private ImageIcon getIcon(int type, int status)
    {
        if (0 == status)
        {
            if (0 == type)
            {
                return IVS_Demo.getImageIcon("FixedBoltOff.png");//离线枪
            }
            if (2 == type)
            {
                return IVS_Demo.getImageIcon("ballOff.png");//离线球
            }
            
            return IVS_Demo.getImageIcon("unknowOff.png");//其他
        }
        
        if (1 == status)
        {
            if (0 == type)
            {
                return IVS_Demo.getImageIcon("FixedBoltOn.png");//在线枪
            }
            if (2 == type)
            {
                return IVS_Demo.getImageIcon("ballOn.png");//在线球
            }
            
            return IVS_Demo.getImageIcon("unknowOn.png");//其他
        }
        
        return IVS_Demo.getImageIcon("unknowOff.png");//其他
    }
    
    public JLabel getLabel()
    {
        return label;
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
        boolean cellHasFocus)
    {
        this.cameraCode = value.toString();
        
        DeviceInfo info = DeviceUtil.getDeviceInfo(this.cameraCode);
        ImageIcon icon = getIcon(info.getType(), info.getStatus());
        label.setIcon(icon);
        label.setText(info.getName());
        label.setForeground(Color.WHITE);
        Color background;
        
        if (isSelected)
        {
            background = new Color(150, 150, 150);
        }
        else
        {
            background = new Color(87, 87, 87);
        }
        setBackground(background);
        return this;
    }
    
}
