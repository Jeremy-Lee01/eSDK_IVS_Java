package com.huawei.esdk.platform.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;

import com.huawei.esdk.platform.authorize.DefaultAuthorizeAdapter;
import com.huawei.esdk.platform.authorize.itf.IAuthorizeAdapter;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;

public class AppAuthorize extends AbstractPhaseInterceptor<Message>
{
    private static final Logger LOGGER = Logger.getLogger(AppAuthorize.class);
    
    private List<IAuthorizeAdapter> authorizeAdapters = new ArrayList<IAuthorizeAdapter>(1);
    
    private IAuthorizeAdapter defaultAuthorizeAdapter;
    
    public void regAuthorizeAdapter(IAuthorizeAdapter authorizeAdapter)
    {
        authorizeAdapters.add(authorizeAdapter);
    }
    
    public IAuthorizeAdapter getDefaultAuthorizeAdapter()
    {
        if (null == defaultAuthorizeAdapter)
        {
            defaultAuthorizeAdapter = new DefaultAuthorizeAdapter();
        }
        
        return defaultAuthorizeAdapter;
    }
    
    public AppAuthorize()
    {
        super(Phase.PRE_INVOKE);
    }
    
    @Override
    public void handleMessage(Message message)
        throws Fault
    {
        HttpServletRequest req = (HttpServletRequest)message.get("HTTP.REQUEST");
        String soapAction = req.getHeader("SOAPAction");
        
        IAuthorizeAdapter authorizeAdapter = getAuthorizeAdapter(soapAction, message);
        
        if (authorizeAdapter.needAuthorize(soapAction, message))
        {
            String aaResult = null;
            try
            {
                aaResult = authorizeAdapter.authorize(message);
                if (null == aaResult)
                {
                    throw new Exception();
                }
            }
            catch(Fault e)
            {
                throw e;
            }
            catch (Exception e)
            {
                LOGGER.error("userLogin method error", e);
                SOAPException soapExc = new SOAPException("");
                Fault fault = new Fault(soapExc);
                fault.setFaultCode(new QName(Integer.toString(ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR)));
                throw fault;
            }
            if (!"0".equals(aaResult))
            {
                SOAPException soapExc = new SOAPException("");
                Fault fault = new Fault(soapExc);
                fault.setFaultCode(new QName(aaResult));
                throw fault;
            }
        }
    }
    
    private IAuthorizeAdapter getAuthorizeAdapter(String soapAction, Message message)
    {
        for (IAuthorizeAdapter item : authorizeAdapters)
        {
            if (item.reqMsgMatchesBuiness(soapAction, message))
            {
                return item;
            }
        }
        
        return getDefaultAuthorizeAdapter();
    }
}
