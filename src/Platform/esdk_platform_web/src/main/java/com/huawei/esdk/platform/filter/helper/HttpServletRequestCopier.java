package com.huawei.esdk.platform.filter.helper;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class HttpServletRequestCopier extends HttpServletRequestWrapper
{
    private ServletInputStream inputStream;
    
    private BufferedReader reader;
    
    private ServletInputStreamCopier copier;
    
    public HttpServletRequestCopier(HttpServletRequest response)
        throws IOException
    {
        super(response);
    }
    
    
    @Override
    public ServletInputStream getInputStream()
        throws IOException
    {   
        if (reader != null)
        {
            throw new IllegalStateException("getWriter() has already been called on this response.");
        }
        
        if (inputStream == null)
        {
            inputStream = getRequest().getInputStream();
            copier = new ServletInputStreamCopier(inputStream);
        }
        
        return copier;
    }

    @Override
    public BufferedReader getReader()
        throws IOException
    {
        return super.getReader();
    }

    public byte[] getCopy() throws IOException
    {
        if (copier != null)
        {
            return copier.getCopy();
        }
        else
        {
            return new byte[0];
        }
    }
    
}
