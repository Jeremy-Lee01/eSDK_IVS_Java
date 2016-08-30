package com.huawei.esdk.csdemo.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JPanel;
import com.huawei.esdk.csdemo.common.InterfaceNameConstant;
import com.huawei.esdk.csdemo.view.tabs.GetAlarmEventInfo;
import com.huawei.esdk.csdemo.view.tabs.GetDeviceList;
import com.huawei.esdk.csdemo.view.tabs.MyTabPane;
import com.huawei.esdk.csdemo.view.tabs.SubscribeAlarm;

public class TabPanelContent extends JPanel
{
    
    /**
     * 序列号
     */
    private static final long serialVersionUID = -8045395902158394465L;
    
    //存放所有接口对应的界面
    private Map<String, MyTabPane> tabs = new HashMap<String, MyTabPane>();


    
    public void init(){
        GetAlarmEventInfo  getAlarmEventInfoTab = new GetAlarmEventInfo();
        getAlarmEventInfoTab.initComponents();
        getAlarmEventInfoTab.setVisible(false);
        this.add(getAlarmEventInfoTab);
        tabs.put(InterfaceNameConstant.getAlarmEventInfo, getAlarmEventInfoTab);
        
        GetDeviceList  getDeviceListTab = new GetDeviceList();
        getDeviceListTab.initComponents();
        getDeviceListTab.setVisible(false);
        this.add(getDeviceListTab);
        tabs.put(InterfaceNameConstant.getDeviceList, getDeviceListTab);
        
        SubscribeAlarm  subscribeAlarm = new SubscribeAlarm();
        subscribeAlarm.initComponents();
        subscribeAlarm.setVisible(false);
        this.add(subscribeAlarm);
        tabs.put(InterfaceNameConstant.subscribeAlarm, subscribeAlarm);
        
        GetDeviceList  sence1Tab = new GetDeviceList();
        sence1Tab.initComponents();
        sence1Tab.setVisible(false);
        this.add(sence1Tab);
        tabs.put(InterfaceNameConstant.scene1, sence1Tab);
    }
    
    public void showTabByName(String name){
        
        if(!tabs.containsKey(name)){
            return;
        }
        
        for(Entry<String, MyTabPane> entry :tabs.entrySet()){
            if(entry.getKey().equals(name)){
                if(!entry.getValue().isVisible()){
                    entry.getValue().setVisible(true);
                }
            }else{
                if(entry.getValue().isVisible()){
                    entry.getValue().setVisible(false);
                }
            }
        }
    }

    public Map<String, MyTabPane> getTabs()
    {
        return tabs;
    }

    public void setTabs(Map<String, MyTabPane> tabs)
    {
        this.tabs = tabs;
    }
   
    
}
