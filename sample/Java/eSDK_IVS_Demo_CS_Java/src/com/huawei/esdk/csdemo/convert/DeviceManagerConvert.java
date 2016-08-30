package com.huawei.esdk.csdemo.convert;

import java.awt.Color;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.huawei.esdk.csdemo.common.DemoException;
import com.huawei.esdk.csdemo.common.InterfaceNameConstant;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.tabs.GetDeviceList;
import com.huawei.esdk.csdemo.view.utils.InternationalUtils;
import com.huawei.esdk.ivs.professional.local.bean.GetDeviceListResponse;
import com.huawei.esdk.ivs.professional.local.bean.IndexRange;

public class DeviceManagerConvert
{
    
    private static GetDeviceList getDeviceListTab = (GetDeviceList)DemoApp.tabContent.getTabs()
        .get(InterfaceNameConstant.getDeviceList);
    
    public static void getParametersFromFrame(StringBuffer deviceType, IndexRange indexRange) throws DemoException
    {
        try
        {
            deviceType.append(getDeviceListTab.getInputText1().getText());
            
            //参数验证只支持2,3,4
            int deviceTy = Integer.parseInt(deviceType.toString());
            if(2 > deviceTy || 4 < deviceTy)
            {
                String errInfo = InternationalUtils.getValue("deviceType") +
                        InternationalUtils.getValue("paramNotSupport");
                    DemoException demoEx = new DemoException(errInfo);
                    throw demoEx;
            }
           
        }
        catch(NumberFormatException e)
        {
            String errInfo = InternationalUtils.getValue("deviceType") +
                InternationalUtils.getValue("paramTypeError");
            DemoException demoEx = new DemoException(errInfo);
            throw demoEx;
        }
        
        try
        {    
        	indexRange.setFromIndex(Integer.parseInt(getDeviceListTab.getInputText2().getText()));
	    }
	    catch(NumberFormatException e)
	    {
	        String errInfo = InternationalUtils.getValue("fromIndex") +
	            InternationalUtils.getValue("paramTypeError");
	        DemoException demoEx = new DemoException(errInfo);
	        throw demoEx;
	    }
        
        try
        {
        	indexRange.setToIndex(Integer.parseInt(getDeviceListTab.getInputText3().getText()));
		}
		catch(NumberFormatException e)
		{
		    String errInfo = InternationalUtils.getValue("toIndex") +
		        InternationalUtils.getValue("paramTypeError");
		    DemoException demoEx = new DemoException(errInfo);
		    throw demoEx;
		}
    }
    
    public static void showConvertErrInfo(String errInfo)
    {
        getDeviceListTab.getOutputText1().setText("");
        getDeviceListTab.getOutputText2().setText("");
        getDeviceListTab.showOperationStatus(null);
        JOptionPane.showMessageDialog(null, errInfo, "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showResultInFrame(GetDeviceListResponse result)
    {
        int resultCode = result.getResultCode();
        getDeviceListTab.getOutputText1().setText(String.valueOf(resultCode));
        getDeviceListTab.getOutputText2().setText("");
        
        if(0 != resultCode)
        {
            getDeviceListTab.getStatusPanel().setForeground(Color.red);
            getDeviceListTab.showOperationStatus(false);
            return;
        }
        
        getDeviceListTab.getStatusPanel().setForeground(Color.blue);
        getDeviceListTab.showOperationStatus(true);
        
        
        Gson gson = new Gson();
        getDeviceListTab.getOutputText2().setText(gson.toJson(result));
   
    }
    
    public static void loginFailInGetDeviceListFrame(int loginErrorCode)
    {
        getDeviceListTab.getOutputText1().setText(String.valueOf(loginErrorCode));
        getDeviceListTab.getOutputText2().setText("");
        getDeviceListTab.getStatusPanel().setForeground(Color.red);
        getDeviceListTab.showOperationStatus(false);
    }
}
