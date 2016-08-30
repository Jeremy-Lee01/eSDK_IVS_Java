package com.huawei.esdk.demo.interceptor;

import java.util.List;
import java.util.Map;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

@SuppressWarnings("rawtypes")
public class MsgOutInterceptor extends AbstractPhaseInterceptor
{
    
    public MsgOutInterceptor()
    {
        super(Phase.PRE_STREAM);
    }
    
    @SuppressWarnings("unchecked")
    public void handleMessage(Message message)
        throws Fault
    {
        // 在header中添加set-cookie属性
        // Set-Cookie=[ASP.NET_SessionId=ib1iynjzjjosqkkb3rcbnz54; path=/;HttpOnly],
        List<String> session = MsgSessionHolder.getInstance().getSession();
        if (null != session && !session.isEmpty())
        {
            Map<String, List<String>> headers = (Map<String, List<String>>)message.get(Message.PROTOCOL_HEADERS);
            headers.put("Cookie", session);
        }
    }
}
