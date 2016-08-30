package com.huawei.esdk.csdemo.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.huawei.esdk.csdemo.IVS_Demo;
import com.huawei.esdk.csdemo.common.ControlCode;
import com.huawei.esdk.csdemo.common.DeviceInfo;
import com.huawei.esdk.csdemo.common.SDKResult;
import com.huawei.esdk.csdemo.service.PtzCtrlService;
import com.huawei.esdk.csdemo.util.DeviceUtil;

public class CtrlPanel extends JPanel
{
    private static final long serialVersionUID = 8099975654184832644L;
    
    private static final Logger LOGGER = Logger.getLogger(CtrlPanel.class);
    
    public static boolean playStatus = false;
    
    private boolean isMoving = false;
    
    public static JButton playJB;
    
    private JButton upLeftJB;
    
    private JButton upJB;
    
    private JButton upRightJB;
    
    private JButton leftJB;
    
    private JButton rightJB;
    
    private JButton downLeftJB;
    
    private JButton downJB;
    
    private JButton downRightJB;
    
    private static PtzCtrlService ctrlService = PtzCtrlService.getInstance();
    
    public CtrlPanel()
    {
        initComponents();
        
        setLayout(new GridLayout(3, 3, 0, 0));
        setOpaque(false);
        add(upLeftJB);
        add(upJB);
        add(upRightJB);
        add(leftJB);
        add(playJB);
        add(rightJB);
        add(downLeftJB);
        add(downJB);
        add(downRightJB);
        setPreferredSize(new Dimension(180, 180));
    }
    
    private void initComponents()
    {
        playJB = new JButton();
        playJB.setIcon(IVS_Demo.getImageIcon("arrows/play.png"));
        playJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/play1.png"));
        playJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/play2.png"));
        playJB.setBorderPainted(false);
        playJB.setContentAreaFilled(false);
        playJB.setFocusPainted(false);
        playJB.setPreferredSize(new Dimension(40, 40));
        playJB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                playJB_actionPerformed(e);
            }
        });
        
        upLeftJB = new JButton();
        upLeftJB.setIcon(IVS_Demo.getImageIcon("arrows/a1.png"));
        upLeftJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/a2.png"));
        upLeftJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/a3.png"));
        upLeftJB.setBorderPainted(false);
        upLeftJB.setContentAreaFilled(false);
        upLeftJB.setFocusPainted(false);
        upLeftJB.setPreferredSize(new Dimension(40, 40));
        upLeftJB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (isMoving)
                {
                    stopMove();
                }
                else
                {
                    SDKResult<Integer> result = ctrlService.ControlCamera(ControlCode.PTZ_UP_LEFT);
                    if (null != result)
                    {
                        if (0 == result.getErrCode() && 0 == result.getResult())
                        {
                            isMoving = true;
                        }
                        
                        LOGGER.debug("move upleft,result:" + result.getErrCode() + ",LockStatus=" + result.getResult());
                    }
                }
            }
        });
        
        upJB = new JButton();
        upJB.setIcon(IVS_Demo.getImageIcon("arrows/b1.png"));
        upJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/b2.png"));
        upJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/b3.png"));
        upJB.setBorderPainted(false);
        upJB.setContentAreaFilled(false);
        upJB.setFocusPainted(false);
        upJB.setPreferredSize(new Dimension(40, 40));
        upJB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (isMoving)
                {
                    stopMove();
                }
                else
                {
                    SDKResult<Integer> result = ctrlService.ControlCamera(ControlCode.PTZ_UP);
                    if (null != result)
                    {
                        if (0 == result.getErrCode() && 0 == result.getResult())
                        {
                            isMoving = true;
                        }
                        
                        LOGGER.debug("move up,result:" + result.getErrCode() + ",LockStatus=" + result.getResult());
                    }
                }
            }
        });
        
        upRightJB = new JButton();
        upRightJB.setIcon(IVS_Demo.getImageIcon("arrows/c1.png"));
        upRightJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/c2.png"));
        upRightJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/c3.png"));
        upRightJB.setBorderPainted(false);
        upRightJB.setContentAreaFilled(false);
        upRightJB.setFocusPainted(false);
        upRightJB.setPreferredSize(new Dimension(40, 40));
        upRightJB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (isMoving)
                {
                    stopMove();
                }
                else
                {
                    SDKResult<Integer> result = ctrlService.ControlCamera(ControlCode.PTZ_UP_RIGHT);
                    if (null != result)
                    {
                        if (0 == result.getErrCode() && 0 == result.getResult())
                        {
                            isMoving = true;
                        }
                        
                        LOGGER
                            .debug("move upRight,result:" + result.getErrCode() + ",LockStatus=" + result.getResult());
                    }
                }
            }
        });
        
        leftJB = new JButton();
        leftJB.setIcon(IVS_Demo.getImageIcon("arrows/d1.png"));
        leftJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/d2.png"));
        leftJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/d3.png"));
        leftJB.setBorderPainted(false);
        leftJB.setContentAreaFilled(false);
        leftJB.setFocusPainted(false);
        leftJB.setPreferredSize(new Dimension(40, 40));
        leftJB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (isMoving)
                {
                    stopMove();
                }
                else
                {
                    SDKResult<Integer> result = ctrlService.ControlCamera(ControlCode.PTZ_LEFT);
                    if (null != result)
                    {
                        if (0 == result.getErrCode() && 0 == result.getResult())
                        {
                            isMoving = true;
                        }
                        
                        LOGGER.debug("move left,result:" + result.getErrCode() + ",LockStatus=" + result.getResult());
                    }
                }
            }
        });
        
        rightJB = new JButton();
        rightJB.setIcon(IVS_Demo.getImageIcon("arrows/e1.png"));
        rightJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/e2.png"));
        rightJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/e3.png"));
        rightJB.setBorderPainted(false);
        rightJB.setContentAreaFilled(false);
        rightJB.setFocusPainted(false);
        rightJB.setPreferredSize(new Dimension(40, 40));
        rightJB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (isMoving)
                {
                    stopMove();
                }
                else
                {
                    SDKResult<Integer> result = ctrlService.ControlCamera(ControlCode.PTZ_RIGHT);
                    if (null != result)
                    {
                        if (0 == result.getErrCode() && 0 == result.getResult())
                        {
                            isMoving = true;
                        }
                        
                        LOGGER.debug("move right,result:" + result.getErrCode() + ",LockStatus=" + result.getResult());
                    }
                }
            }
        });
        
        downLeftJB = new JButton();
        downLeftJB.setIcon(IVS_Demo.getImageIcon("arrows/f1.png"));
        downLeftJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/f2.png"));
        downLeftJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/f3.png"));
        downLeftJB.setBorderPainted(false);
        downLeftJB.setContentAreaFilled(false);
        downLeftJB.setFocusPainted(false);
        downLeftJB.setPreferredSize(new Dimension(40, 40));
        downLeftJB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (isMoving)
                {
                    stopMove();
                }
                else
                {
                    SDKResult<Integer> result = ctrlService.ControlCamera(ControlCode.PTZ_DOWN_LEFT);
                    if (null != result)
                    {
                        if (0 == result.getErrCode() && 0 == result.getResult())
                        {
                            isMoving = true;
                        }
                        
                        LOGGER
                            .debug("move downLeft,result:" + result.getErrCode() + ",LockStatus=" + result.getResult());
                    }
                }
            }
        });
        
        downJB = new JButton();
        downJB.setIcon(IVS_Demo.getImageIcon("arrows/g1.png"));
        downJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/g2.png"));
        downJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/g3.png"));
        downJB.setBorderPainted(false);
        downJB.setContentAreaFilled(false);
        downJB.setFocusPainted(false);
        downJB.setPreferredSize(new Dimension(40, 40));
        downJB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (isMoving)
                {
                    stopMove();
                }
                else
                {
                    SDKResult<Integer> result = ctrlService.ControlCamera(ControlCode.PTZ_DOWN);
                    if (null != result)
                    {
                        if (0 == result.getErrCode() && 0 == result.getResult())
                        {
                            isMoving = true;
                        }
                        
                        LOGGER.debug("move down,result:" + result.getErrCode() + ",LockStatus=" + result.getResult());
                    }
                }
            }
        });
        
        downRightJB = new JButton();
        downRightJB.setIcon(IVS_Demo.getImageIcon("arrows/h1.png"));
        downRightJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/h2.png"));
        downRightJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/h3.png"));
        downRightJB.setBorderPainted(false);
        downRightJB.setContentAreaFilled(false);
        downRightJB.setFocusPainted(false);
        downRightJB.setPreferredSize(new Dimension(40, 40));
        downRightJB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (isMoving)
                {
                    stopMove();
                }
                else
                {
                    SDKResult<Integer> result = ctrlService.ControlCamera(ControlCode.PTZ_DOWN_RIGHT);
                    if (null != result)
                    {
                        if (0 == result.getErrCode() && 0 == result.getResult())
                        {
                            isMoving = true;
                        }
                        
                        LOGGER.debug(
                            "move downRight,result:" + result.getErrCode() + ",LockStatus=" + result.getResult());
                    }
                }
            }
        });
    }
    
    private void playJB_actionPerformed(ActionEvent e)
    {
        DeviceInfo info = DeviceUtil.getRealPlayDeviceInfo();
        
        if (null != info)
        {
            if (1 == info.getStatus())
            {
                if (playStatus)
                {
                    System.out.println("stop play:" + info.getCode());
                    if (DeviceUtil.stopRealPlay(info.getCode()))
                    {
                        playJB.setIcon(IVS_Demo.getImageIcon("arrows/play.png"));
                        playJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/play1.png"));
                        playJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/play2.png"));
                    }
                }
                else
                {
                    String playCode = info.getCode();
                    if (!playCode.equals(DeviceUtil.getCurrentDeviceInfo().getCode()))
                    {
                        playCode = DeviceUtil.getCurrentDeviceInfo().getCode();
                        DeviceUtil.setRealPlayCode(playCode);
                    }
                    
                    System.out.println("start play:" + playCode);
                    //播放选中视频
                    if (DeviceUtil.startRealPlay(playCode))
                    {
                        playJB.setIcon(IVS_Demo.getImageIcon("arrows/stop.png"));
                        playJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/stop1.png"));
                        playJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/stop2.png"));
                    }
                }
                
                playStatus = !playStatus;
            }
            else
            {
                playJB.setIcon(IVS_Demo.getImageIcon("arrows/play.png"));
                playJB.setRolloverIcon(IVS_Demo.getImageIcon("arrows/play1.png"));
                playJB.setPressedIcon(IVS_Demo.getImageIcon("arrows/play2.png"));
            }
        }
        
    }
    
    private void stopMove()
    {
        SDKResult<Integer> result = ctrlService.ControlCamera(ControlCode.PTZ_STOP);
        if (null != result)
        {
            if (0 == result.getErrCode())
            {
                isMoving = false;
            }
            
            LOGGER.debug("stop move,result:" + result.getErrCode() + ",LockStatus=" + result.getResult());
        }
    }
}
