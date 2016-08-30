package com.huawei.esdk.platform.common.bean.nemgr;

import java.util.ArrayList;
import java.util.List;

public class Proxys
{
    private List<DeviceProxy> list = new ArrayList<DeviceProxy>();
    
    public List<DeviceProxy> getList()
    {
        return list;
    }
    
    public void setList(List<DeviceProxy> list)
    {
        this.list = list;
    }
    
    /**
     * 供Digester调用的方法
     * @param deviceClass
     */
    public void addDeviceClass(DeviceProxy deviceProxy)
    {
        this.list.add(deviceProxy);
    }
}
