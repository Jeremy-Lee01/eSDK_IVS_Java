/*
 * ====================================================================
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import org.apache.http.annotation.Immutable;

import org.apache.commons.logging.Log;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.MaskUtils;

/**
 * Logs data to the wire LOG.
 *
 *
 * @since 4.0
 */
@Immutable
public class Wire
{
    
    private final Log log;
    
    private final String id;

    /**
     * @since 4.3
     */
    public Wire(final Log log, final String id) {
        this.log = log;
        this.id = id;
    }
    
    public Wire(final Log log) {
        this(log, "");
    }
    
    private void wire(String header, InputStream instream)
        throws IOException
    {
        StringBuilder buffer = new StringBuilder();
        int ch;
        while ((ch = instream.read()) != -1)
        {
            if (ch == 13)
            {
                buffer.append("[\\r]");
            }
            else if (ch == 10)
            {
                buffer.append("[\\n]\"");
                buffer.insert(0, "\"");
                buffer.insert(0, header);
                String logMessage = buffer.toString();
                if (null != logMessage)
                {
                    logMessage = replaceSession(logMessage);
                    // modify by cWX191990, UC2.2打印了明文，将通用敏感词移至平台内部配置文件中                    
                    String sensetiveWords = ConfigManager.getInstance().getValue("sms.http.gateway.content.sensetive.elements")
                        + "," + ConfigManager.getInstance().getValue("platform.sensetive.elements")
                        + ",pwd,password";// 密码比较敏感，不做配置项，硬编码过滤
                    
                    logMessage = MaskUtils.maskXMLElementValue(logMessage, sensetiveWords, '*');
                    // modify end
                }
                if (!"Y".equals(ConfigManager.getInstance().getValue("sms.http.north.gateway.flag")))
                {
                    log.debug(logMessage);                    
                }
                buffer.setLength(0);
            }
            else if ((ch < 32) || (ch > 127))
            {
                buffer.append("[0x");
                buffer.append(Integer.toHexString(ch));
                buffer.append("]");
            }
            else
            {
                buffer.append((char)ch);
            }
        }
        if (buffer.length() > 0)
        {
            buffer.append('\"');
            buffer.insert(0, '\"');
            buffer.insert(0, header);
            
            if (-1 != buffer.indexOf("password"))
            {
                int start = buffer.indexOf("password") + 11;
                int end = buffer.indexOf("}") - 1;
                if (start < buffer.length() && end >= start)
                {
                    buffer = buffer.replace(start, end, "******");
                }
            }
            
//            log.debug(buffer.toString());
            if (!"Y".equals(ConfigManager.getInstance().getValue("sms.http.north.gateway.flag")))
            {
                log.debug(MaskUtils.maskXMLElementValue(buffer.toString(), 
                    ConfigManager.getInstance().getValue("platform.sensetive.elements"), '*'));
            }
        }
    }
    
    public boolean enabled()
    {
        return log.isDebugEnabled();
    }
    
    public void output(InputStream outstream)
        throws IOException
    {
        if (outstream == null)
        {
            throw new IllegalArgumentException("Output may not be null");
        }
        wire(">> ", outstream);
    }
    
    public void input(InputStream instream)
        throws IOException
    {
        if (instream == null)
        {
            throw new IllegalArgumentException("Input may not be null");
        }
        wire("<< ", instream);
    }
    
    public void output(byte[] b, int off, int len)
        throws IOException
    {
        if (b == null)
        {
            throw new IllegalArgumentException("Output may not be null");
        }
        wire(">> ", new ByteArrayInputStream(b, off, len));
    }
    
    public void input(byte[] b, int off, int len)
        throws IOException
    {
        if (b == null)
        {
            throw new IllegalArgumentException("Input may not be null");
        }
        wire("<< ", new ByteArrayInputStream(b, off, len));
    }
    
    public void output(byte[] b)
        throws IOException
    {
        if (b == null)
        {
            throw new IllegalArgumentException("Output may not be null");
        }
        wire(">> ", new ByteArrayInputStream(b));
    }
    
    public void input(byte[] b)
        throws IOException
    {
        if (b == null)
        {
            throw new IllegalArgumentException("Input may not be null");
        }
        wire("<< ", new ByteArrayInputStream(b));
    }
    
    public void output(int b)
        throws IOException
    {
        output(new byte[] {(byte)b});
    }
    
    public void input(int b)
        throws IOException
    {
        input(new byte[] {(byte)b});
    }
    
    /**
     * @deprecated (4.1)  do not use
     */
    @Deprecated
    public void output(final String s)
        throws IOException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Output may not be null");
        }
        output(s.getBytes("UTF-8"));
    }
    
    /**
     * @deprecated (4.1)  do not use
     */
    @Deprecated
    public void input(final String s)
        throws IOException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Input may not be null");
        }
        input(s.getBytes("UTF-8"));
    }
    
    private String replaceSession(String logMessage)
    {
        int begin = 0;
        if (-1 < logMessage.indexOf("SessionID="))
        {
            begin = logMessage.indexOf("SessionID=") + 10;
        }
        else if (-1 < logMessage.indexOf("SessionID:"))
        {
            begin = logMessage.indexOf("SessionID:") + 10;
        }
        else
        {
            return logMessage;
        }
        int end = logMessage.indexOf("[", begin);
        if (end > begin)
        {
            int length = (end - begin) / 2;
            String temp = logMessage.substring(begin, end);
            StringBuffer rep = new StringBuffer();
            for (int i = 0; i < length; i++)
            {
                rep.append("*");
            }
            rep.append(logMessage.substring(begin + length, end));
            logMessage = logMessage.replace(temp, rep);
        }
        return logMessage;
    }
}
