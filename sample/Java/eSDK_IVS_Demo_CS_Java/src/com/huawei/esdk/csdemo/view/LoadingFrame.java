package com.huawei.esdk.csdemo.view;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class LoadingFrame extends JFrame{
	/** * */
    private static final long serialVersionUID = 1L;

    private JPanel messContent = new JPanel();
	
	private JLabel lodingImg = new JLabel();
	private JLabel lodingtxt = new JLabel("LOADING");
	private JLabel mess = new JLabel();

	private Timer timer = new Timer();
	private int timerCount = 0;
	public LoadingFrame(){
	    this.setTitle("loading");
//	    this.setUndecorated(true);
		this.setLayout(null);
		this.setBounds(400, 300, 400, 250);
//		messContent.setBounds(30, 50, 240, 150);
		messContent.setLayout(null);
		
		lodingImg.setIcon(new ImageIcon(MainFrame.getPath("loading.gif")));
		
		messContent.setBounds(0, 0, 400, 250);
		messContent.setBackground(Color.white);
		
		lodingImg.setBounds(130, 80, 48, 48);
		lodingtxt.setBounds(190, 90, 80, 30);
		mess.setBounds(50, 150, 300, 40);

		mess.setForeground(Color.blue);
//		mess.set
		mess.setHorizontalAlignment(SwingConstants.CENTER);
		
		messContent.add(lodingtxt);
        messContent.add(lodingImg);
		messContent.add(mess);
		
	    this.add(messContent);
		this.setResizable(false);
		this.setAlwaysOnTop(true);

	}
	
	public  void showProgressMessage(String msg){

	        loading();
    	    
			mess.setText(msg);
			mess.repaint();
			this.repaint();
	}
	
	public  void finish(){
	    timerCount = -1;
	    this.setVisible(false);
	}
	
	private void loading(){
	    timer.schedule(new TimerTask()
        {
            
            @Override
            public void run()
            {
                if(timerCount < 0){
                    return;
                }
                
                if(timerCount < 5){
                    timerCount++;
                }else{
                    timerCount = 0; 
                }
                
                String temp = "";
                for(int i = 0; i < timerCount; i++){
                    temp +=". ";
                }
                
                temp = "loading" + temp;
                lodingtxt.setText(temp);
                
                loading();
            }
        }, 250);
	}
	
}
