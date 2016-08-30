/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.ivs.interceptor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.MaskUtils;

public class IVSLoggingInInterceptor extends LoggingInInterceptor
{
    private static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger
    .getLogger(IVSLoggingInInterceptor.class);
    
    private static String SENSITIVE_WORDS = "";

    static 
    {
        SENSITIVE_WORDS = ConfigManager.getInstance().getValue("sensitive.words");
        LOGGER.debug("test:" + SENSITIVE_WORDS);
    }
    
    @Override
    protected void logging(Logger logger, Message message) throws Fault
    {
        if (message.containsKey(LoggingMessage.ID_KEY))
        {
            return;
        }
        String id = (String) message.getExchange().get(LoggingMessage.ID_KEY);
        if (id == null)
        {
            id = LoggingMessage.nextId();
            message.getExchange().put(LoggingMessage.ID_KEY, id);
        }
        message.put(LoggingMessage.ID_KEY, id);
        final LoggingMessage buffer = new LoggingMessage(
                "Inbound Message\n----------------------------", id);

        Integer responseCode = (Integer) message.get(Message.RESPONSE_CODE);
        if (responseCode != null)
        {
            buffer.getResponseCode().append(responseCode);
        }

        String encoding = (String) message.get(Message.ENCODING);

        if (encoding != null)
        {
            buffer.getEncoding().append(encoding);
        }
        String httpMethod = (String) message.get(Message.HTTP_REQUEST_METHOD);
        if (httpMethod != null)
        {
            buffer.getHttpMethod().append(httpMethod);
        }
        String ct = (String) message.get(Message.CONTENT_TYPE);
        if (ct != null)
        {
            buffer.getContentType().append(ct);
        }
        @SuppressWarnings("unchecked")
        Map<String, List<String>> headers = (Map<String, List<String>>) message
                .get(Message.PROTOCOL_HEADERS);

        if (headers != null)
        {
            // by taochunlong 替换session
            List<String> sessions = headers.get("cookie");
            if (null != sessions && !sessions.isEmpty() && null != sessions.get(0) && 12 < sessions.get(0).length())
            {
                String exp = sessions.get(0).substring(
                        11,
                        sessions.get(0).length()
                                - (sessions.get(0).length() - 11) / 2);
                StringBuffer rep = new StringBuffer();
                for (int i = 0; i < exp.length(); i++)
                {
                    rep.append("*");
                }
                List<String> list = new ArrayList<String>();
                list.add(sessions.get(0).replace(exp, rep));
                headers.put("cookie", list);
            }

            buffer.getHeader().append(headers);
        }
        String uri = (String) message.get(Message.REQUEST_URL);
        if (uri != null)
        {
            buffer.getAddress().append(uri);
            String query = (String) message.get(Message.QUERY_STRING);
            if (query != null)
            {
                buffer.getAddress().append("?").append(query);
            }
        }

        InputStream is = message.getContent(InputStream.class);
        if (is != null)
        {
            CachedOutputStream bos = new CachedOutputStream();
            try
            {
                IOUtils.copy(is, bos);

                bos.flush();
//                is.close();
                File tempTile = bos.getTempFile();
                message.setContent(InputStream.class, bos.getInputStream());
                if (tempTile != null)
                {
                    // large thing on disk...
                    buffer.getMessage().append(
                            "\nMessage (saved to tmp file):\n");
                    buffer.getMessage().append(
                            "Filename: " + tempTile.getAbsolutePath()
                                    + "\n");
                }
                if (bos.size() > limit)
                {
                    buffer.getMessage().append(
                            "(message truncated to " + limit + " bytes)\n");
                }
                
                writePayload(buffer.getPayload(), bos, encoding, ct);

//                bos.close();
            }
            catch (Exception e)
            {
                throw new Fault(e);
            }
            finally
            {
                try
                {
                    if (null != is)
                    {
                        is.close();
                    }
                }
                catch (IOException e)
                {
                    LOGGER.error("handleMessage os close error", e);
                }
                try
                {
                    if (null != bos)
                    {
                        bos.close();
                    }
                }
                catch (IOException e)
                {
                    LOGGER.error("handleMessage os close error", e);
                }
            }
        }
        
        String strBuffer = buffer.toString();
        log(logger, MaskUtils.mask(strBuffer, SENSITIVE_WORDS));
    }

}
