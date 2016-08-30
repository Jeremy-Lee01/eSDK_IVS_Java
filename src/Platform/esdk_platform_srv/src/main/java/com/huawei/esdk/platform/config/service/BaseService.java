package com.huawei.esdk.platform.config.service;

import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.platform.common.utils.OSUtils;
import com.huawei.esdk.platform.config.service.itf.IConfigObserver;

public abstract class BaseService
{
    protected List<IConfigObserver> configObservers = new ArrayList<IConfigObserver>();
    
    protected String getFilePath(String configFile)
        throws Exception
    {
        String file = null;
        
        URL url = this.getClass().getClassLoader().getResource(configFile);
        if (url != null)
        {
            file = url.getFile();
            if (OSUtils.isWindows())
            {
                if (file.startsWith("/"))
                {
                    file = file.substring(1);
                }
            }
        }
        if (file != null)
        {
        	file = URLDecoder.decode(file, "UTF-8");
        }
        return file;
    }
    
    public void registerObserver(IConfigObserver observer)
    {
        configObservers.add(observer);
    }
    
    protected void notifyObservers()
    {
        for (IConfigObserver observer : configObservers)
        {
            observer.doAction();
        }
    }
}
