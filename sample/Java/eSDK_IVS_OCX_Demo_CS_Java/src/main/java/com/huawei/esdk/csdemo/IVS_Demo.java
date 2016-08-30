package com.huawei.esdk.csdemo;

import java.awt.Image;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import com.huawei.esdk.csdemo.common.DeviceInfo;
import com.huawei.esdk.csdemo.common.SDKErrorCode;
import com.huawei.esdk.csdemo.common.SDKResult;
import com.huawei.esdk.csdemo.model.CameraBriefInfo;
import com.huawei.esdk.csdemo.model.CameraBriefInfoList;
import com.huawei.esdk.csdemo.service.CommonService;
import com.huawei.esdk.csdemo.service.QueryService;
import com.huawei.esdk.csdemo.util.DeviceUtil;
import com.huawei.esdk.csdemo.util.StringUtil;
import com.huawei.esdk.csdemo.view.LoadingPanel;
import com.huawei.esdk.csdemo.view.MainFrame;
import com.sun.jna.Native;

public class IVS_Demo
{
    private static final Logger LOGGER = Logger.getLogger(IVS_Demo.class);
    
    public static MainFrame mainFrame = new MainFrame();
    
    public static LoadingPanel loadingPanel;
    
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                loadingPanel = new LoadingPanel();
                mainFrame.setBody(loadingPanel);
                loadingPanel.showProgressMessage("初始化数据,请稍候...");
                mainFrame.setVisible(true);
                mainFrame.validate();
                LOGGER.debug("准备加载界面结束");
            }
        });
        
        try
        {
            String initResult = initData();
            if (!"success".equals(initResult))
            {
                loadingPanel.showProgressMessage("初始化失败：" + initResult);
            }
            else
            {
                loadingPanel.finish();
                mainFrame.setBody(mainFrame.createMainBody());
                mainFrame.validate();
                MainFrame.getHWND().setPointer(Native.getComponentPointer(mainFrame.getCanvas()));
            }
        }
        catch (UnsatisfiedLinkError e)
        {
            try
            {
                
                //防止界面未加载完
                Thread.sleep(1000);
            }
            catch (InterruptedException e1)
            {
                LOGGER.error(e);
            }
            LOGGER.error(e);
            loadingPanel.showProgressMessage("加载DLL类库失败");
        }
    }
    
    public static String initData()
        throws UnsatisfiedLinkError
    {
        LOGGER.info("start Init dll");
        CommonService commonService = CommonService.getInstance();
        SDKErrorCode result = commonService.init();
        if (0 != result.getErrCode())
        {
            LOGGER.error("Init Failed, resultCode:" + result.getErrCode());
            return "Init Failed, resultCode:" + result.getErrCode();
        }
        
        LOGGER.info("Init dll success");
        int resultCode = commonService.doConnection();
        if (0 != resultCode)
        {
            LOGGER.error("Login Failed, resultCode:" + resultCode);
            return "Login Failed, resultCode:" + resultCode;
        }
        LOGGER.info("login success, sessionID:" + CommonService.getSESSIONID());
        
        QueryService queryService = QueryService.getInstance();
        
        //只查询一条，获取总设备数
        SDKResult<CameraBriefInfoList> infoList = queryService.getDeviceList(1, 1);
        if (0 != infoList.getErrCode())
        {
            LOGGER.error("Get First DeviceList Failed, resultCode:" + infoList.getErrCode());
            return "Get First DeviceList Failed, resultCode:" + infoList.getErrCode();
        }
        LOGGER.info("get First DeviceList success, total:" + infoList.getResult().total);
        
        //查询所有设备(不大于1000)
        infoList = queryService.getDeviceList(1, infoList.getResult().total > 1000 ? 1000 : infoList.getResult().total);
        if (0 != infoList.getErrCode())
        {
            LOGGER.error("Get All DeviceList Failed, resultCode:" + infoList.getErrCode());
            return "Get All DeviceList Failed, resultCode:" + infoList.getErrCode();
        }
        
        for (int i = infoList.getResult().indexRange.fromIndex - 1; i < infoList.getResult().indexRange.toIndex; i++)
        {
            String code, name, vendorType, deviceModelType;
            CameraBriefInfo info = infoList.getResult().cameraBriefInfo[i];
            try
            {
                code = new String(StringUtil.trimByteArray(info.code), "GBK");
                name = new String(StringUtil.trimByteArray(info.name), "GBK");
                vendorType = new String(StringUtil.trimByteArray(info.vendorType), "GBK");
                deviceModelType = new String(StringUtil.trimByteArray(info.deviceModelType), "GBK");
            }
            catch (UnsupportedEncodingException e)
            {
                LOGGER.error("Process DeviceList Info Failed:", e);
                return "Process DeviceList Info Failed with exception:UnsupportedEncodingException";
            }
            
            LOGGER.debug(code + "\t" + info.status + "\t" + info.type + "\t" + vendorType + "\t\t" + deviceModelType
                + "\t\t" + name);
            if (null != code && null != name)
            {
                DeviceInfo deviceInfo = new DeviceInfo(code, name, info.type, info.status);
                deviceInfo.setVendorType(vendorType);
                deviceInfo.setDeviceModelType(deviceModelType);
                
                DeviceUtil.getDeviceInfos().add(deviceInfo);
            }
        }
        
        return "success";
    }
    
    public static ImageIcon getImageIcon(String image)
    {
        ImageIcon icon;
        if (null == MainFrame.class.getResource("/img/" + image))
        {
            LOGGER.error("image " + image + " is missing");
            if (null == MainFrame.class.getResource("/img/unknowOff.png"))
            {
                icon = new ImageIcon();
                LOGGER.error("image unknowOff is missing");
            }
            else
            {
                icon = new ImageIcon(MainFrame.class.getResource("/img/unknowOff.png"));
            }
        }
        else
        {
            icon = new ImageIcon(MainFrame.class.getResource("/img/" + image));
        }
        
        return icon;
    }
    
    public static Image getImage(String image)
    {
        try
        {
            if (null == MainFrame.class.getResource("/img/" + image))
            {
                LOGGER.error("image " + image + " is missing");
                if (null == MainFrame.class.getResource("/img/unknowOff.png"))
                {
                    LOGGER.error("image unknowOff is missing");
                    return null;
                }
                else
                {
                    return ImageIO.read(MainFrame.class.getResource("/img/unknowOff.png"));
                }
            }
            else
            {
                return ImageIO.read(MainFrame.class.getResource("/img/" + image));
            }
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
