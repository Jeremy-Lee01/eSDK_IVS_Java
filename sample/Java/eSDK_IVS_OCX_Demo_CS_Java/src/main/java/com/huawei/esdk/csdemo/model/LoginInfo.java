package com.huawei.esdk.csdemo.model;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Structure;

/**
 * 南向login对象类
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class LoginInfo extends Structure
{
    public static class ByReference extends LoginInfo implements Structure.ByReference
    {
    }
    
    public static class ByValue extends LoginInfo implements Structure.ByValue
    {
    }
    
    public byte[] userName = new byte[128];
    
    public byte[] password = new byte[64];
    
    public IPInfo ipInfo = new IPInfo();
    
    public int port;
    
    public int loginType;
    
    public byte[] domainName = new byte[64];
    
    public byte[] machineName = new byte[128];
    
    public int clientType;
    
    public byte[] reserve = new byte[32];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("userName");
        list.add("password");
        list.add("ipInfo");
        list.add("port");
        list.add("loginType");
        list.add("domainName");
        list.add("machineName");
        list.add("clientType");
        list.add("reserve");
        return list;
    }
}
