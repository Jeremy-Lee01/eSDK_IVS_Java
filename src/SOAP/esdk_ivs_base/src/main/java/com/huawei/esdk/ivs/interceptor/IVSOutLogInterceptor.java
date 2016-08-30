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

import java.io.OutputStream;
import java.util.Date;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;

import com.huawei.esdk.platform.common.bean.log.InterfaceLogBean;
import com.huawei.esdk.platform.common.bean.log.LogBean;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.log.itf.IInterfaceLog;

public class IVSOutLogInterceptor extends LoggingOutInterceptor
{
    public IVSOutLogInterceptor()
    {
        super(Phase.PRE_STREAM);
    }

    @Override
    public void handleMessage(Message message) throws Fault
    {
        String messageId = (String) message.getExchange().get(
                LoggingMessage.ID_KEY);
        LogBean bean = new LogBean();
        bean.setResponseTime(new Date());

        OutputStream stream = message.getContent(OutputStream.class);
        final CacheAndWriteOutputStream newOut = new CacheAndWriteOutputStream(
                stream);
        message.setContent(OutputStream.class, newOut);
        newOut.registerCallback(new LoggingCallback(messageId,bean));

    }

    public class LoggingCallback implements CachedOutputStreamCallback
    {
        private String messageId;
        
        private LogBean bean;
        
        public LoggingCallback(String messageId,LogBean bean)
        {
            this.messageId = messageId;
            this.bean = bean;
        }
        public void onFlush(CachedOutputStream cos)
        {
        }

        public void onClose(CachedOutputStream cos)
        {
            try
            {
                StringBuilder builder = new StringBuilder();
                cos.writeCacheTo(builder, limit);
                // here comes my xml:
                String xml = builder.toString();
                if (!xml.contains("resultCode"))
                {
                    if (xml.contains("faultstring"))
                    {
                        int first = xml.lastIndexOf("<faultstring>") + 13;
                        int end = xml.lastIndexOf("</faultstring>");
                        if (first == end)
                        {
                            first = xml.lastIndexOf("<faultcode>") + 11;
                            end = xml.lastIndexOf("</faultcode>");
                        }
                        bean.setResultCode(xml.substring(first, end)
                                .replaceAll("\r\n", " ").replaceAll("\n", " "));
                    }
                    else
                    {
                        bean.setResultCode("0");
                    }
                }
                else
                {
                    int first = xml.lastIndexOf("<resultCode>") + 12;
                    int end = xml.lastIndexOf("</resultCode>");
                    bean.setResultCode(xml.substring(first, end));
                }
                
                
                InterfaceLogBean interfaceLogBean = new InterfaceLogBean();
                interfaceLogBean.setTransactionId(messageId);
                interfaceLogBean.setReq(false);
                interfaceLogBean.setRespTime(new Date());
                interfaceLogBean.setResultCode(bean.getResultCode());
                
                IInterfaceLog logger = ApplicationContextUtil.getBean("interfaceLogger");
                logger.info(interfaceLogBean);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
