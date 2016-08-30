package com.huawei.esdk.platform.interceptor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.log.InterfaceLogBean;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.constants.InfoKeys;
import com.huawei.esdk.platform.log.itf.IInterfaceLog;

public class PlatformOutInterceptor extends AbstractPhaseInterceptor<Message>
{
    private static final Logger logger = Logger.getLogger(PlatformOutInterceptor.class);
    
    public PlatformOutInterceptor()
    {
        super(Phase.PRE_STREAM);
    }
    
    public void handleMessage(Message message)
        throws Fault
    {
        @SuppressWarnings("unchecked")
        Map<String, List<String>> headers = (Map<String, List<String>>)message.get(Message.PROTOCOL_HEADERS);
        if (headers == null)
        {
            headers = new HashMap<String, List<String>>();
        }
        
        doInterfaceLog(message);
        
        String sessionId;
        try
        {
            if (null != ThreadLocalHolder.get())
            {
                sessionId = (String)ThreadLocalHolder.get().getEntities().get(InfoKeys.SDK_SESSION_ID.toString());
                
                headers.put("Set-Cookie", Collections.singletonList("JSESSIONID=" + sessionId));
                message.put(Message.PROTOCOL_HEADERS, headers);
                
                //将sessionId添加到soapHeader中
                String soapMethod = (String)ThreadLocalHolder.get().getEntities().get(InfoKeys.SDK_METHOD.toString());
                if (!StringUtils.isEmpty(soapMethod) && soapMethod.contains("getPublicKey"))
                {
                    QName qname = new QName("sessionID");
                    Document doc = DOMUtils.createDocument();
                    Element root = doc.createElementNS("", "tns:sessionID");
                    root.setTextContent(sessionId);
                    SoapHeader head = new SoapHeader(qname, root);
                    List<Header> headerss = ((SoapMessage)message).getHeaders();
                    headerss.add(head);
                }
                ThreadLocalHolder.unset();
            }
        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new Fault(e);
        }
    }
    
    private void doInterfaceLog(Message message)
    {
        String messageId = (String)message.getExchange().get(LoggingMessage.ID_KEY);
        String currentEnvelopeMessage = "";
        /*****/
        OutputStream os = message.getContent(OutputStream.class);        
        CachedStream cs = new CachedStream();
        message.setContent(OutputStream.class, cs);
        
        message.getInterceptorChain().doIntercept(message);
        
        try
        {
            cs.flush();
            IOUtils.closeQuietly(cs);
            CachedOutputStream csnew = (CachedOutputStream)message.getContent(OutputStream.class);
            
            currentEnvelopeMessage = IOUtils.toString(csnew.getInputStream(), "UTF-8");
            csnew.flush();
            IOUtils.closeQuietly(csnew);
            
            InputStream replaceInStream = IOUtils.toInputStream(currentEnvelopeMessage, "UTF-8");
            
            IOUtils.copy(replaceInStream, os);
            replaceInStream.close();
            IOUtils.closeQuietly(replaceInStream);
            
            os.flush();
            message.setContent(OutputStream.class, os);
            IOUtils.closeQuietly(os);
        }
        catch (IOException ioe)
        {
            throw new RuntimeException(ioe);
        }
        /*****/
        
        InterfaceLogBean bean = new InterfaceLogBean();
        bean.setTransactionId(messageId);
        bean.setReq(false);
        bean.setRespTime(new Date());
        bean.setResultCode(getResultCode(currentEnvelopeMessage));
        
        IInterfaceLog logger = ApplicationContextUtil.getBean("interfaceLogger");
        logger.info(bean);
    }
    
    private String getResultCode(String xmlPayload)
    {
        String resultCode;
        if (!xmlPayload.contains("resultCode"))
        {
            if (xmlPayload.contains("faultstring"))
            {
                int first = xmlPayload.lastIndexOf("<faultstring>") + 13;
                int end = xmlPayload.lastIndexOf("</faultstring>");
                if (first == end)
                {
                    first = xmlPayload.lastIndexOf("<faultcode>") + 11;
                    end = xmlPayload.lastIndexOf("</faultcode>");
                }
                resultCode = xmlPayload.substring(first, end).replaceAll("\r\n", " ").replaceAll("\n", " ");
            }
            else
            {
                resultCode = "0";
            }
        }
        else
        {
            int first = xmlPayload.lastIndexOf("<resultCode>") + 12;
            int end = xmlPayload.lastIndexOf("</resultCode>");
            resultCode = xmlPayload.substring(first, end);
        }
        
        return resultCode;
    }
    
    private class CachedStream extends CachedOutputStream
    {
        public CachedStream()
        {
            super();
        }
        
        protected void doFlush()
            throws IOException
        {
            currentStream.flush();
        }
        
        protected void doClose()
            throws IOException
        {
        }
        
        protected void onWrite()
            throws IOException
        {
        }
    }
}
