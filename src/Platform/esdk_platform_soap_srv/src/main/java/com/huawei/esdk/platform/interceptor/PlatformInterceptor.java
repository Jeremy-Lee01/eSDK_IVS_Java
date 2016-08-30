package com.huawei.esdk.platform.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.log.InterfaceLogBean;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.constants.InfoKeys;
import com.huawei.esdk.platform.log.itf.IInterfaceLog;

public class PlatformInterceptor extends AbstractPhaseInterceptor<Message>
{
    private static final Logger LOGGER = Logger.getLogger(PlatformInterceptor.class);
    
    public PlatformInterceptor()
    {
        super(Phase.PRE_INVOKE);
    }
    
    @Override
    public void handleMessage(Message message)
        throws Fault
    {
        
        HttpServletRequest req = (HttpServletRequest)message.get("HTTP.REQUEST");
        String soapAction = req.getHeader("SOAPAction");
        
        String ip = req.getRemoteAddr();
        Thread current = Thread.currentThread();
        LOGGER.info(soapAction + " is triggered by " + req.getRemoteHost() + ":" + req.getRemotePort()
            + ",thread id is :" + current.getId());
        
        String auth = req.getHeader("user");
        boolean httpBasedAuth = false;
        if (!StringUtils.isEmpty(auth))
        {
            MessageContext mc = ThreadLocalHolder.get();
            if (mc == null)
            {
                mc = new MessageContext();
                ThreadLocalHolder.set(mc);
            }
            mc.getEntities().put(InfoKeys.SDK_SESSION_ID.toString(), auth + "_" + ip + "_SOAP");
            httpBasedAuth = true;
        }
        
        String sessionId = req.getSession().getId();
        
        MessageContext mc = ThreadLocalHolder.get();
        if (mc == null)
        {
            mc = new MessageContext();
            ThreadLocalHolder.set(mc);
        }
        
        String interfaceName = soapAction.substring(soapAction.lastIndexOf("/") + 1, soapAction.length() - 1);
        
        if (soapAction.contains("getPublicKey"))
        {
            mc.getEntities().put(InfoKeys.SDK_METHOD.toString(), "getPublicKey");
            interfaceName = "getPublicKey";
        }
        
        if (soapAction.contains("setSecretKey"))
        {
            interfaceName = "setSecretKey";
        }
        
        if (!httpBasedAuth)
        {
            mc.getEntities().put(ESDKConstant.ESDK_CLIENT_IP, ip);
            mc.getEntities().put(InfoKeys.SDK_SESSION_ID.toString(), sessionId);
        }
        
        String messageId = (String)message.getExchange().get(LoggingMessage.ID_KEY);
        if (messageId == null)
        {
            messageId = LoggingMessage.nextId();
            message.getExchange().put(LoggingMessage.ID_KEY, messageId);
        }
        
        InterfaceLogBean bean = new InterfaceLogBean();
        bean.setTransactionId(messageId);
        bean.setProduct("Platform");
        bean.setInterfaceType("1");
        bean.setProtocolType("SOAP");
        bean.setReq(true);
        bean.setName(interfaceName);
        bean.setSourceAddr(req.getRemoteHost());
        bean.setTargetAddr(req.getLocalAddr());
        bean.setReqTime(new Date());
//            bean.setReqParams();
        
        IInterfaceLog logger = ApplicationContextUtil.getBean("interfaceLogger");
        logger.info(bean);

    }
}
