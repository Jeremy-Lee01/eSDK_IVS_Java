package com.huawei.esdk.csdemo.model;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Structure;

/**
 * ip信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class IPInfo extends Structure
{
    
    public static class ByReference extends IPInfo implements Structure.ByReference
    {
    }
    
    public static class ByValue extends IPInfo implements Structure.ByValue
    {
    }
    
    public int ipType;
    
    public byte[] ip = new byte[64];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("ipType");
        list.add("ip");
        
        return list;
    }
    
}
