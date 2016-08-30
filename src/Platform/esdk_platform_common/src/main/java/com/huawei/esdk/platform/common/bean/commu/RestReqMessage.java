package com.huawei.esdk.platform.common.bean.commu;

import java.util.HashMap;
import java.util.Map;

public class RestReqMessage
{
    //JSON, XML
    private String mediaType;
    
    //GET, POST, PUT, DELETE
    private String httpMethod;
    
    //HTTP protocol headers info
    private Map<String, String> httpHeaders;
    
    //Query parameters
    private Map<String, String> parameters;
    
    //Message payload
    private Object payload;
    
    public RestReqMessage()
    {
        httpHeaders = new HashMap<String, String>();
        parameters = new HashMap<String, String>();
    }
    
    public String getMediaType()
    {
        return mediaType;
    }
    
    public void setMediaType(String mediaType)
    {
        this.mediaType = mediaType;
    }
    
    public String getHttpMethod()
    {
        return httpMethod;
    }
    
    public void setHttpMethod(String httpMethod)
    {
        this.httpMethod = httpMethod;
    }
    
    public Map<String, String> getHttpHeaders()
    {
        if (null == httpHeaders)
        {
            httpHeaders = new HashMap<String, String>();
        }
        return httpHeaders;
    }
    
    public void setHttpHeaders(Map<String, String> httpHeaders)
    {
        this.httpHeaders = httpHeaders;
    }
    
    public Map<String, String> getParameters()
    {
        return parameters;
    }
    
    public void setParameters(Map<String, String> parameters)
    {
        this.parameters = parameters;
    }
    
    public Object getPayload()
    {
        return payload;
    }
    
    public void setPayload(Object payload)
    {
        this.payload = payload;
    }
}
