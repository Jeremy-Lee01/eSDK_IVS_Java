package com.huawei.esdk.platform.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.log.InterfaceLogBean;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.filter.helper.HttpServletRequestCopier;
import com.huawei.esdk.platform.filter.helper.HttpServletResponseCopier;
import com.huawei.esdk.platform.log.itf.IInterfaceLog;

public class ESDKRestFilter implements Filter
{
    private static Map<String, String> PRODUCTS = new HashMap<String, String>();
    
    private static final Logger LOGGER = Logger.getLogger(ESDKRestFilter.class);
    
    @Override
    public void init(FilterConfig filterConfig)
        throws ServletException
    {
        PRODUCTS.put("uc", "UC");
        PRODUCTS.put("tp", "TP");
        PRODUCTS.put("tpoa", "TPOA");
        PRODUCTS.put("ivs", "IVS");
        PRODUCTS.put("controller", "Controller");
        PRODUCTS.put("storage", "Storage");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        Date reqDate = new Date();
        HttpServletRequest req = (HttpServletRequest)request;
        String sessionId = req.getSession().getId();

        String auth = req.getHeader("authorization");
        LOGGER.debug("ESDKRestFilter auth info:" + auth);
        
        Map<String, String> params = null;
        if (!StringUtils.isEmpty(auth) && auth.contains("username="))
        {
            auth = auth.substring(auth.indexOf("username=") + 10, auth.indexOf(",", auth.indexOf("username=") + 9) - 1);
            String ip = req.getRemoteAddr();
            MessageContext mc = ThreadLocalHolder.get();
            if (mc == null)
            {
                mc = new MessageContext();
                ThreadLocalHolder.set(mc);
            }

            /**
             * modify start
             */
            //把调用者账号，请求IP放入线程变量中，用于记录接口运行日志
            mc.getEntities().put("userName", auth);
            mc.getEntities().put("remoteIp", ip);
            
            //对于GET，DELETE请求为了方便，需要把请求的参数放入线程变量中，用于记录接口运行日志
            Map<String, String[]> paramsMap = request.getParameterMap();
            if(null != paramsMap && !paramsMap.isEmpty())
            {
                params = new LinkedHashMap<String, String>();
                for(Entry<String, String[]> paramItem : paramsMap.entrySet())
                {
                    if(null != paramItem.getValue() &&
                        0 < paramItem.getValue().length)
                    {
                        params.put(paramItem.getKey(), paramItem.getValue()[0]);
                    }
                }
                mc.getEntities().put("queryParams", params);
            }
            /**
             * modify end
             */

            mc.getEntities().put(ESDKConstant.SDK_SESSION_ID, auth + "_" + ip + "_REST");
        }
        HttpServletResponse res = (HttpServletResponse)response;
        res.addHeader("Set-Cookie", "JSESSIONID=" + sessionId);
        
        //输入流，输出流的复制
        HttpServletResponseCopier responseCopier = new HttpServletResponseCopier((HttpServletResponse) response);
        HttpServletRequestCopier requestCopier = new HttpServletRequestCopier((HttpServletRequest) request);
        
        chain.doFilter(requestCopier, responseCopier);
        
        //接口请求参数日志打印
        String uuid = UUID.randomUUID().toString();  
        
        //入参
        byte[] reqCopy = requestCopier.getCopy();
        LOGGER.debug("");
        LOGGER.debug(">>Msg uuid:" + uuid +",Request info:");
        
        if(null != reqCopy && 0 != reqCopy.length)
        {
            String reqBody = new String(reqCopy, request.getCharacterEncoding());
            LOGGER.debug(">>Payload:" + reqBody);
        }
        
        String reqInfoLog = null;
        if(null != params && 0 == params.size())
        {
            reqInfoLog = params.entrySet().toString();
        }
        if(null != reqInfoLog && !"".equals(reqInfoLog.trim()))
        {
            LOGGER.debug(">>Parameters:" + reqInfoLog);
        }
        
        //返回
        byte[] copy = responseCopier.getCopy();
        String resPayload = new String(copy, response.getCharacterEncoding());
        LOGGER.debug("<<Msg uuid:" + uuid +",Response info:");
        LOGGER.debug("<<" + resPayload);
        LOGGER.debug("");
        
        if (200 == responseCopier.getStatus())
        {
            doInterfaceLogReq(uuid, req, reqDate);
            doInterfaceLogRes(uuid, resPayload);
        }
    }
    
    private void doInterfaceLogReq(String messageId, HttpServletRequest req, Date reqDate)
    {
        String uri = req.getRequestURI();
        while (uri.endsWith("/"))
        {
            uri = uri.substring(0, uri.length() - 1);
        }
        String interfaceName = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
        String module = "";
        int begin = uri.indexOf("/rest/");
        if (begin > -1)
        {
            int end = uri.indexOf("/", begin + 6);
            module = uri.substring(begin + 6, end);
        }
        module = PRODUCTS.get(module);
        if (StringUtils.isEmpty(module))
        {
            module = "Platform";
        }
        
        InterfaceLogBean bean = new InterfaceLogBean();
        bean.setTransactionId(messageId);
        bean.setProduct(module);
        bean.setInterfaceType("1");
        bean.setProtocolType("REST");
        bean.setReq(true);
        bean.setName(interfaceName);
        bean.setSourceAddr(req.getRemoteHost());
        bean.setTargetAddr(req.getLocalAddr());
        bean.setReqTime(reqDate);
        
        IInterfaceLog logger = ApplicationContextUtil.getBean("interfaceLogger");
        logger.info(bean);
    }
    
    private void doInterfaceLogRes(String messageId, String jsonPayload)
    {
        int first = jsonPayload.indexOf("\"resultCode\"") + 14;
        int end = jsonPayload.indexOf("\"", first);
        String resultCode;
        if (first > -1)
        {
            resultCode = jsonPayload.substring(first, end);
        }
        else
        {
            resultCode = "-1";
        }
        
        InterfaceLogBean bean = new InterfaceLogBean();
        bean.setTransactionId(messageId);
        bean.setReq(false);
        bean.setRespTime(new Date());
        bean.setResultCode(resultCode);
        
        IInterfaceLog logger = ApplicationContextUtil.getBean("interfaceLogger");
        logger.info(bean);
    }
    
    @Override
    public void destroy()
    {
        
    }
}
