package com.huawei.esdk.csdemo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.huawei.esdk.csdemo.IVS_Demo;

public class LoadingPanel extends JPanel
{
    
    private static final long serialVersionUID = 448169740006538897L;

    private JLabel loadingLabel = new JLabel("LOADING");
    
    private JLabel messLabel = new JLabel();
    
    private Timer timer = new Timer();
    
    private int timerCount = 0;
    
    public LoadingPanel()
    {
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(10, 70));
        emptyPanel.setOpaque(false);
        
        JLabel lodingImg = new JLabel();
        lodingImg.setIcon(IVS_Demo.getImageIcon("loading.gif"));
        lodingImg.setPreferredSize(new Dimension(70, 70));
        
        loadingLabel.setPreferredSize(new Dimension(100, 70));
        loadingLabel.setForeground(new Color(200, 200, 200));
        
        JPanel loadPanel = new JPanel();
        loadPanel.setOpaque(false);
        loadPanel.setPreferredSize(new Dimension(500, 120));
        loadPanel.add(lodingImg);
        loadPanel.add(emptyPanel);
        loadPanel.add(loadingLabel);
        
        JPanel messPanel = new JPanel();
        messPanel.setOpaque(false);
        messPanel.setPreferredSize(new Dimension(500, 230));
        
        messLabel.setForeground(new Color(200, 200, 200));
        messLabel.setFont(new Font("Default", Font.PLAIN, 15));
        
        messPanel.add(messLabel);
        
        this.setLayout(new BorderLayout());
        this.add("North", loadPanel);
        this.add("South", messPanel);
        
        this.setPreferredSize(new Dimension(500, 350));
        this.setBackground(new Color(83, 83, 83));
    }
    
    public void showProgressMessage(String msg)
    {
        loading();
        
        messLabel.setText(msg);
        messLabel.repaint();
        this.repaint();
    }
    
    public void finish()
    {
        timerCount = -1;
        this.setVisible(false);
    }
    
    private void loading()
    {
        timer.schedule(new TimerTask()
        {
            
            @Override
            public void run()
            {
                if (timerCount < 0)
                {
                    return;
                }
                
                if (timerCount < 5)
                {
                    timerCount++;
                }
                else
                {
                    timerCount = 0;
                }
                
                String temp = "";
                for (int i = 0; i < timerCount; i++)
                {
                    temp += ". ";
                }
                
                temp = "LOADING " + temp;
                loadingLabel.setText(temp);
                
                loading();
            }
        }, 250);
    }
    
}
