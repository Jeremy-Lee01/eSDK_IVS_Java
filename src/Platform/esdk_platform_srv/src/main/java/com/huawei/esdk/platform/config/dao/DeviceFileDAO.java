package com.huawei.esdk.platform.config.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultElement;

import com.huawei.esdk.platform.common.bean.config.DeviceConfig;
import com.huawei.esdk.platform.config.dao.itf.IDeviceDAO;

public class DeviceFileDAO extends BaseFileDAO implements IDeviceDAO
{
    private static final Logger LOGGER = Logger.getLogger(DeviceFileDAO.class);
    
    private Document document;
    
    private String file;
    
    public DeviceFileDAO(String file)
    {
        this.file = file;
        if (file != null)
        {
            try
            {
                SAXReader reader = new SAXReader();
                reader.setEncoding("UTF-8");
                document = reader.read(new File(file));
            }
            catch (DocumentException e)
            {
                LOGGER.error("", e);
            }
        }
    }
    
    public DeviceFileDAO(InputStream is, String fileName)
    {
        this.file = fileName;
        try
        {
            SAXReader reader = new SAXReader();
            reader.setEncoding("UTF-8");
            document = reader.read(is);
        }
        catch (DocumentException e)
        {
            LOGGER.error("", e);
        }
    }
    
    @Override
    public boolean addDevice(DeviceConfig device)
    {
        Element rootElm = document.getRootElement();
        Element deviceEle = new DefaultElement("device");
        deviceEle.add(buildElement("deviceId", device.getDeviceId()));
        deviceEle.add(buildElement("deviceName", device.getDeviceName()));
        deviceEle.add(buildElement("serviceAccessPoint", device.getServiceAccessPoint()));
        deviceEle.add(buildElement("loginUser", device.getLoginUser()));
        deviceEle.add(buildElement("loginPwd", device.getLoginPwd()));
        deviceEle.add(buildElement("deviceType", device.getDeviceType()));
        deviceEle.add(buildElement("deviceVersion", device.getDeviceVersion()));
        deviceEle.add(buildElement("connMode", device.getConnMode()));
        deviceEle.add(buildElement("reserver1", device.getReserver1() == null ? "" : device.getReserver1()));
        deviceEle.add(buildElement("reserver2", device.getReserver2() == null ? "" : device.getReserver2()));
        
        rootElm.add(deviceEle);
        
        try
        {
            writeXmlFile(document, this.file);
        }
        catch (IOException e)
        {
            rootElm.remove(deviceEle);
            LOGGER.error("", e);
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean updateDevice(DeviceConfig device)
    {
        try
        {
            Element rootElm = document.getRootElement();
            Element element = null;
            for (@SuppressWarnings("unchecked")
            Iterator<Element> it = rootElm.elementIterator(); it.hasNext();)
            {
                element = it.next();
                if (element.element("deviceId").getTextTrim().equals(device.getDeviceId()))
                {
                    element.element("deviceName").setText(device.getDeviceName());
                    element.element("serviceAccessPoint").setText(device.getServiceAccessPoint());
                    element.element("loginUser").setText(device.getLoginUser());
                    element.element("loginPwd").setText(device.getLoginPwd());
                    element.element("deviceType").setText(device.getDeviceType());
                    element.element("deviceVersion").setText(device.getDeviceVersion());
                    element.element("connMode").setText(device.getConnMode());
                    element.element("reserver1").setText(device.getReserver1() == null ? "" : device.getReserver1());
                    element.element("reserver2").setText(device.getReserver2() == null ? "" : device.getReserver2());
                    
                    writeXmlFile(document, this.file);
                    return true;
                }
            }
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
            return false;
        }
        return false;
    }
    
    @Override
    public boolean deleteDevice(String deviceId)
    {
        try
        {
            Element rootElm = document.getRootElement();
            Element element = null;
            for (@SuppressWarnings("unchecked")
            Iterator<Element> it = rootElm.elementIterator(); it.hasNext();)
            {
                element = it.next();
                if (element.element("deviceId").getTextTrim().equals(deviceId))
                {
                    rootElm.remove(element);
                    writeXmlFile(document, this.file);
                    return true;
                }
            }
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
            return false;
        }
        return false;
    }
    
    @Override
    public DeviceConfig getDeviceById(String deviceId)
    {
        List<DeviceConfig> devices = getAllDevices();
        for (DeviceConfig device : devices)
        {
            if (device.getDeviceId().equals(deviceId))
            {
                return device;
            }
        }
        
        return null;
    }
    
    @Override
    public List<DeviceConfig> getAllDevices()
    {
    	List<DeviceConfig> devices = new ArrayList<DeviceConfig>();
        if (null == file)
        {
        	return devices;
        }
        
        SAXReader reader = new SAXReader();
        reader.setEncoding("UTF-8");
        try
        {
            document = reader.read(new File(file));
        }
        catch (DocumentException e)
        {
            LOGGER.error("DeviceFileDAO.getAllDevices() error", e);
        }
        
        Element rootElm = document.getRootElement();
        @SuppressWarnings("unchecked")
        List<Element> elements = rootElm.elements("device");
        DeviceConfig device = null;
        for (Element ele : elements)
        {
            device = new DeviceConfig();
            device.setDeviceId(ele.element("deviceId").getTextTrim());
            device.setDeviceName(ele.element("deviceName").getTextTrim());
            device.setServiceAccessPoint(ele.element("serviceAccessPoint").getTextTrim());
            device.setLoginUser(ele.element("loginUser").getTextTrim());
            device.setLoginPwd(ele.element("loginPwd").getTextTrim());
            device.setDeviceType(ele.element("deviceType").getTextTrim());
            device.setDeviceVersion(ele.element("deviceVersion").getTextTrim());
            device.setConnMode(ele.element("connMode").getTextTrim());
            device.setReserver1(ele.element("reserver1").getTextTrim());
            device.setReserver2(ele.element("reserver2").getTextTrim());
            
            devices.add(device);
        }
        
        return devices;
    }
}
