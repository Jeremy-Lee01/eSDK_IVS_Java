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

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.authorize.SessionManager;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.log.LogBean;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.log.itf.LogInterface;

public class IVSInterceptor extends AbstractPhaseInterceptor<Message>
{
    private static final Logger LOGGER = Logger.getLogger(IVSInterceptor.class);

    public IVSInterceptor()
    {
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(Message message) throws Fault
    {
        
        HttpServletRequest req = (HttpServletRequest) message
                .get("HTTP.REQUEST");
        String soapAction = req.getHeader("SOAPAction");
        Thread current = Thread.currentThread();
        LOGGER.info(soapAction + " is triggered by " + req.getRemoteHost()
                + ":" + req.getRemotePort() + ",thread id is :"
                + current.getId());
        
        //获得HttpSesson的sessionId
        String sessionId = req.getSession().getId();
        LOGGER.warn("++++++++++++++++sdksession is " + sessionId);
        SessionManager sessionMgr = SessionManager.getInstance();

        MessageContext mc = ThreadLocalHolder.get();
        if (mc == null)
        {
            mc = new MessageContext();
            ThreadLocalHolder.set(mc);
        }

        if (soapAction.contains("login"))
        {
            if (null == sessionId)
            {
                SOAPException soapExc = new SOAPException("");
                Fault fault = new Fault(soapExc);
                fault.setFaultCode(new QName(String
                        .valueOf(ErrInfo.SDK_SYSTEM_ERRORCODE)));
                throw fault;
            }
            // save SDK SessionID
            if (!sessionMgr.saveSDKSession(sessionId))
            {
                SOAPException soapExc = new SOAPException("repetive login");
                Fault fault = new Fault(soapExc);
                fault.setFaultCode(new QName(String
                        .valueOf(ErrInfo.LOGIN_REPETITIVE_ERRORCODE)));
                throw fault;
            }
        }
        else
        {
            // SessionID is not correct! Or Session is expired
            if (!sessionMgr.isSDKSessionExists(sessionId))
            {
                SOAPException soapExc = new SOAPException("");
                Fault fault = new Fault(soapExc);
                fault.setFaultCode(new QName(String
                        .valueOf(ErrInfo.AUTHORIZE_ERRORCODE)));
                throw fault;
            }
        }

        mc.getEntities().put(InfoKeys.SDK_SESSION_ID.toString(), sessionId);
        
        String interfaceName = soapAction.substring(
                soapAction.lastIndexOf(".") + 1, soapAction.length() - 1);
        if (!"keepAlive".equals(interfaceName))
        {
            String messageId = (String) message.getExchange().get(
                    LoggingMessage.ID_KEY);
            if (messageId == null)
            {
                messageId = LoggingMessage.nextId();
                message.getExchange().put(LoggingMessage.ID_KEY, messageId);
            }

            LogBean bean = new LogBean();
            bean.setActionName(interfaceName);
            bean.setRequestTime(new Date());
            bean.setIp(req.getRemoteHost());
            bean.setPort(req.getRemotePort() + "");
            LogInterface log = ApplicationContextUtil.getBean("logManager");
            log.saveRequestLog(messageId, bean);
        }
    }
}
