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
package com.huawei.esdk.ivs.authorize;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.platform.authorize.itf.AbstractAuthorizeAdapter;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.log.InterfaceLogBean;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.log.itf.IInterfaceLog;
import com.huawei.esdk.platform.session.itf.ISessionMgr;

public class LoginAuthorize extends AbstractAuthorizeAdapter
{
    private static final Logger LOGGER = Logger.getLogger(LoginAuthorize.class);
    
    public static final String model = ConfigManager.getInstance().getValue("sensitive.information.transmission.mode",
        ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_AES128_CONSULTED);
    
    private ISessionMgr sessionMgrPlatform = ApplicationContextUtil.getBean("sessionMgrC50");
    
    public LoginAuthorize(String businessName)
    {
        super(businessName);
    }
    
    @Override
    public boolean needAuthorize(String funcName, Object message)
    {
        return true;
    }
    
    private MessageContext getMessageContext()
    {
        MessageContext mc = ThreadLocalHolder.get();
        if (mc == null)
        {
            mc = new MessageContext();
            ThreadLocalHolder.set(mc);
        }
        
        return mc;
    }
    
    @Override
    public String authorize(Object message)
    {
        SoapMessage soapMessage = (SoapMessage)message;
        if (null == soapMessage)
        {
            return Integer.toString(ESDKErrorCodeConstant.ERROR_CODE_SDK_AUTHORIZE_FAILURE);
        }
        HttpServletRequest req = (HttpServletRequest)soapMessage.get("HTTP.REQUEST");
        
        MessageContext mc = getMessageContext();
        String soapAction = req.getHeader("SOAPAction");
        if (StringUtils.isEmpty(soapAction))
        {
            SOAPException soapExc = new SOAPException("soapAction can not be null");
            Fault fault = new Fault(soapExc);
            fault.setStatusCode(400);
            fault.setFaultCode(new QName(String.valueOf(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE)));
            throw fault;
        }
        
        String sessionId = req.getSession().getId();
        SessionManager sessionMgr = SessionManager.getInstance();
        
        if (ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_AES128_CONSULTED.equalsIgnoreCase(model))
        {
            if (soapAction.contains("login"))
            {
                if (sessionMgrPlatform.isSDKSessionExists(sessionId))
                {
                    sessionId = renewSession(req, sessionId, mc);
                }
                else
                {
                    SOAPException soapExc = new SOAPException("");
                    Fault fault = new Fault(soapExc);
                    fault.setStatusCode(401);
                    fault.setFaultCode(new QName(String.valueOf(ESDKErrorCodeConstant.SESSIONID_ERRORCODE)));
                    throw fault;
                }
            }
        }
        mc.getEntities().put(InfoKeys.SDK_SESSION_ID.toString(), sessionId);
        
        if (!soapAction.contains("login"))
        {
            //Need check the session exists and has logged in
            if (!sessionMgr.isSDKSessionExists(sessionId) || !sessionMgr.getSDKSession(sessionId).isLogged())
            {
                SOAPException soapExc = new SOAPException("");
                Fault fault = new Fault(soapExc);
                fault.setStatusCode(401);
                fault.setFaultCode(new QName(String.valueOf(ErrInfo.AUTHORIZE_ERRORCODE)));
                throw fault;
            }
        }
        else
        {
            // save SDK SessionID
            if (sessionMgr.isSDKSessionExists(sessionId) && sessionMgr.getSDKSession(sessionId).isLogged())
            {
                LOGGER.debug("Repetive Login");
                SOAPException soapExc = new SOAPException("repetive login");
                Fault fault = new Fault(soapExc);
                fault.setStatusCode(403);
                fault.setFaultCode(new QName(String.valueOf(ErrInfo.LOGIN_REPETITIVE_ERRORCODE)));
                throw fault;
            }
        }
        
        logOperation(soapMessage, req, soapAction);
        
        return "0";
    }
    
    private void logOperation(SoapMessage soapMessage, HttpServletRequest req, String soapAction)
    {
        String interfaceName = soapAction.substring(
            soapAction.lastIndexOf(".") + 1, soapAction.length() - 1);;
        if (!soapAction.equals("keepAlive"))
        {
            String messageId = (String) soapMessage.getExchange().get(
                    LoggingMessage.ID_KEY);
            if (messageId == null)
            {
                messageId = LoggingMessage.nextId();
                soapMessage.getExchange().put(LoggingMessage.ID_KEY, messageId);
            }
    
            InterfaceLogBean bean = new InterfaceLogBean();
            bean.setTransactionId(messageId);
            bean.setProduct("IVS");
            bean.setInterfaceType("1");
            bean.setProtocolType("SOAP");
            bean.setReq(true);
            bean.setName(interfaceName);
            bean.setSourceAddr(req.getRemoteHost());
            bean.setTargetAddr(req.getLocalAddr());
            bean.setReqTime(new Date());
            
            IInterfaceLog logger = ApplicationContextUtil.getBean("interfaceLogger");
            logger.info(bean);
        }
    }
    
    @Override
    public boolean reqMsgMatchesBuiness(String funcName, Object message)
    {
        if (StringUtils.isNotEmpty(funcName) && funcName.contains("esdk_ivs_professional_server"))
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * Renew the session for security purpose
     * 
     * @param req HttpServletRequest
     * @param oldSessionId The session ID generated in the setSecretKey
     * @since eSDK V001R003C50
     */
    private String renewSession(HttpServletRequest req, String oldSessionId, MessageContext mc)
    {
        byte [] secretKey = sessionMgrPlatform.getSecretKey(oldSessionId);
        byte [] iv = sessionMgrPlatform.getIv(oldSessionId);
        sessionMgrPlatform.removeSDKSession(oldSessionId);
        //Retrieve the session info from the manager first
        SessionManager sessionMgr = SessionManager.getInstance();
        
        //Then renew the session, when the invalidate method is called the session listener
        //will be called also which will call the sessionMgr.removeSDKSession(sessionId)
        req.getSession().invalidate();
        //after the invalidate method is called, the variables stored in the thread local may be removed
        //so need store it again here
        ThreadLocalHolder.set(mc);
        
        String newSDKSessionId = req.getSession().getId();
        
        sessionMgr.saveSDKSession(newSDKSessionId);
        
        sessionMgrPlatform.saveSecretKey(newSDKSessionId, secretKey, iv);
        
        return newSDKSessionId;
    }
}
