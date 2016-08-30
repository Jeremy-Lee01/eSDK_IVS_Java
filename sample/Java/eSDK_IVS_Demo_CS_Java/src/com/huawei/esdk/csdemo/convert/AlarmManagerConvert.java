package com.huawei.esdk.csdemo.convert;

import java.awt.Color;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.huawei.esdk.csdemo.common.DemoException;
import com.huawei.esdk.csdemo.common.InterfaceNameConstant;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.tabs.GetAlarmEventInfo;
import com.huawei.esdk.csdemo.view.tabs.SubscribeAlarm;
import com.huawei.esdk.csdemo.view.utils.InternationalUtils;
import com.huawei.esdk.ivs.professional.local.bean.AlarmEvent;
import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;

public class AlarmManagerConvert
{
    
    private static GetAlarmEventInfo getAlarmEventInfoTab = (GetAlarmEventInfo)DemoApp.tabContent.getTabs()
        .get(InterfaceNameConstant.getAlarmEventInfo);
    
    private static SubscribeAlarm subscribeAlarmTab = (SubscribeAlarm)DemoApp.tabContent.getTabs()
        .get(InterfaceNameConstant.subscribeAlarm);
    
    public static void getParametersFromGetAlarmEventFrame(StringBuffer alarmEventId, StringBuffer alarmInCode) throws DemoException
    {
        alarmEventId.append(getAlarmEventInfoTab.getInputText1().getText());
        alarmInCode.append(getAlarmEventInfoTab.getInputText2().getText());
        
        
        try
        {
            Long.parseLong(alarmEventId.toString());
        }
        catch(NumberFormatException e)
        {
            String errInfo = InternationalUtils.getValue("alarmEventId") +
                InternationalUtils.getValue("paramTypeError");
            DemoException demoEx = new DemoException(errInfo);
            throw demoEx;
        }
    }
    
    public static void showResultInGetAlarmEventFrame(IVSSDKResponse<AlarmEvent> response)
    {
        int resultCode = response.getResultCode();
        getAlarmEventInfoTab.getOutputText1().setText(String.valueOf(resultCode));
        getAlarmEventInfoTab.getOutputText2().setText("");
        
        if(0 != resultCode)
        {
            getAlarmEventInfoTab.getStatusPanel().setForeground(Color.red);
            getAlarmEventInfoTab.showOperationStatus(false);
            return;
        }
        
        getAlarmEventInfoTab.getStatusPanel().setForeground(Color.blue);
        getAlarmEventInfoTab.showOperationStatus(true);
        
        
        AlarmEvent result = response.getResult();
        Gson gson = new Gson();
        getAlarmEventInfoTab.getOutputText2().setText(gson.toJson(result));
   
    }
    public static void loginFailInGetAlarmEventFrame(int resultCode)
    {
        getAlarmEventInfoTab.getOutputText1().setText(String.valueOf(resultCode));
        getAlarmEventInfoTab.getOutputText2().setText("");
        getAlarmEventInfoTab.getStatusPanel().setForeground(Color.red);
        getAlarmEventInfoTab.showOperationStatus(false);
    }
    
    public static void showGetAlarmEventConvertErrInfo(String errInfo)
    {
        getAlarmEventInfoTab.getOutputText1().setText("");
        getAlarmEventInfoTab.getOutputText2().setText("");
        getAlarmEventInfoTab.showOperationStatus(null);
        JOptionPane.showMessageDialog(null, errInfo, "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void getParametersFromSubscribeAlarmFrame(StringBuffer requestXML)
    {
        requestXML.append(subscribeAlarmTab.getInputText1().getText());
        
    }

    public static void showResultInSubscribeAlarmFrame(Integer result)
    {
        subscribeAlarmTab.getOutputText1().setText(String.valueOf(result));
        
        if(0 != result)
        {
            subscribeAlarmTab.getStatusPanel().setForeground(Color.red);
            subscribeAlarmTab.showOperationStatus(false);
            return;
        }
        
        subscribeAlarmTab.getStatusPanel().setForeground(Color.blue);
        subscribeAlarmTab.showOperationStatus(true);
    }
    
    public static void loginFailInSubscribeAlarmFrame(int resultCode)
    {
        subscribeAlarmTab.getOutputText1().setText(String.valueOf(resultCode));
        subscribeAlarmTab.getStatusPanel().setForeground(Color.red);
        subscribeAlarmTab.showOperationStatus(false);
    }

    public static void showSubscribeAlarmConvertErrInfo(String errInfo)
    {
        subscribeAlarmTab.getOutputText1().setText("");
        subscribeAlarmTab.showOperationStatus(null);
        JOptionPane.showMessageDialog(null, errInfo, "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }
}
