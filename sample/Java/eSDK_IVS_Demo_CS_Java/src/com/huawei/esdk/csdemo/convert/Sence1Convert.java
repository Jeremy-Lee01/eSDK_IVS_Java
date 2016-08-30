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

public class Sence1Convert
{
    
    private static GetDeviceList sence1Tab = (GetDeviceList)DemoApp.tabContent.getTabs()
        .get(InterfaceNameConstant.scene1);
    
    public static void getParametersFromFrame(StringBuffer deviceType, IndexRange indexRange) throws DemoException
    {
        try
        {
            deviceType.append(sence1Tab.getInputText1().getText());
            
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
        	indexRange.setFromIndex(Integer.parseInt(sence1Tab.getInputText2().getText()));
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
        	indexRange.setToIndex(Integer.parseInt(sence1Tab.getInputText3().getText()));
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
        sence1Tab.getOutputText1().setText("");
        sence1Tab.getOutputText2().setText("");
        sence1Tab.showOperationStatus(null);
        JOptionPane.showMessageDialog(null, errInfo, "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showResultInFrame(GetDeviceListResponse result)
    {
        int resultCode = result.getResultCode();
        sence1Tab.getOutputText1().setText(String.valueOf(resultCode));
        sence1Tab.getOutputText2().setText("");
        
        if(0 != resultCode)
        {
            sence1Tab.getStatusPanel().setForeground(Color.red);
            sence1Tab.showOperationStatus(false);
            return;
        }
        
        sence1Tab.getStatusPanel().setForeground(Color.blue);
        sence1Tab.showOperationStatus(true);
        
        
        Gson gson = new Gson();
        sence1Tab.getOutputText2().setText(gson.toJson(result));
   
    }
    
    public static void loginFailInGetDeviceListFrame(int loginErrorCode)
    {
        sence1Tab.getOutputText1().setText(String.valueOf(loginErrorCode));
        sence1Tab.getOutputText2().setText("");
        sence1Tab.getStatusPanel().setForeground(Color.red);
        sence1Tab.showOperationStatus(false);
    }
}
