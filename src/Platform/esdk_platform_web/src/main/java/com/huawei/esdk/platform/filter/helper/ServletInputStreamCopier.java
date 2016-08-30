package com.huawei.esdk.platform.filter.helper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletInputStream;

public class ServletInputStreamCopier extends ServletInputStream
{
    private InputStream inputStream;
    
    private ByteArrayOutputStream copy;
 
    public ServletInputStreamCopier(InputStream inputStream)
    {
        this.inputStream = inputStream;
        this.copy = new ByteArrayOutputStream(1024);
    }

    public byte[] getCopy() throws IOException
    {
        return copy.toByteArray();
    }

    @Override
    public int read()
        throws IOException
    {
        int res = inputStream.read();
        
        if (res != -1)
        {
            this.copy.write(res);
        }
        
        return res;
    }
    
}
