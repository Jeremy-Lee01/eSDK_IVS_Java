package com.huawei.esdk.platform.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.digester3.Digester;
import org.apache.cxf.helpers.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.xml.sax.SAXException;

import com.huawei.esdk.platform.callback.ISouthCallbackService;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;

public class ESDKCallbackRestServlet extends HttpServlet
{
	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(ESDKCallbackRestServlet.class);
	
	private static Map<String, ISouthCallbackService> services = new HashMap<String, ISouthCallbackService>();
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException
    {
		String reqUri = req.getRequestURI();
		
		String result = null;
		InputStream is = null;
        OutputStream os = null;
		try
		{
			is = req.getInputStream();
			String inMsg = inputStream2String(req.getInputStream());
			LOGGER.debug("eSDK received a callback message:" + inMsg);
			for (Map.Entry<String, ISouthCallbackService> item : services.entrySet())
			{
				if (reqUri.contains(item.getKey()))
				{
					result = item.getValue().processCallbackMessage(inMsg);
					break;
				}
			}
			
			if (null == result)
			{
				LOGGER.warn("There is no proper service to process the callback message" + inMsg);
				// modify 2014.9.19，forytify问题，requestUri可能会存在数据注入，记录日志会出现恶意数据攻击
				//LOGGER.warn("The request uri is " + reqUri);
				result = "eSDK cannot process the message.";
			}
		}
		catch(IOException e)
		{
			LOGGER.error("", e);
			result = "eSDK internal exception, process the callback message failed";
		}
		catch(Exception e)
		{
			LOGGER.error("", e);
			result = "eSDK internal exception, process the callback message failed";
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
                LOGGER.error(e);
            }
		}
		
		try
        {
			LOGGER.debug("eSDK response to the callback message:" + result);
            os = resp.getOutputStream();
            os.write(result.getBytes("UTF-8"));
        }
        catch (IOException e)
        {
            LOGGER.error(e);
        }
        finally
        {
            try
            {
                if (null != os)
                {
                    os.close();
                }
            }
            catch (IOException e)
            {
                LOGGER.error(e);
            }
        }
    }

	@Override
	public void init() throws ServletException {
		super.init();
		List<CallbackServiceBean> configs = getCallbackServiceConfig();
		ISouthCallbackService service;
		for (CallbackServiceBean item : configs)
		{
			service = ApplicationContextUtil.getBean(item.getServiceClass());
			if (null != service)
			{
				services.put(item.getServiceId(), service);
			}
		}
	}

	@SuppressWarnings("unchecked")
    private List<CallbackServiceBean> getCallbackServiceConfig()
    {
        List<CallbackServiceBean> result = new ArrayList<CallbackServiceBean>();
        try
        {
            Digester digest = new Digester();
            digest.setValidating(false);
            digest.addObjectCreate("callback-services", ArrayList.class);
            digest.addObjectCreate("callback-services/callback-service", CallbackServiceBean.class);
            digest.addBeanPropertySetter("callback-services/callback-service/service-id", "serviceId");
            digest.addBeanPropertySetter("callback-services/callback-service/service-spring-id", "serviceClass");
            digest.addSetNext("callback-services/callback-service", "add");
            
            //Read configuration file
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath*:META-INF/callback_service*.xml");
            LOGGER.info("##############callback service count:" + resources.length);
            for (Resource resource : resources)
            {
                LOGGER.debug(resource.getFilename());
                result.addAll((List<CallbackServiceBean>)digest.parse(resource.getURL()));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("Load Rest Callback Service configuration failed.", e);
        }
        catch (SAXException e)
        {
            LOGGER.error("Load Rest Callback Service configuration failed.", e);
        }
        
        return result;
    }
	
	/**
     * 
     * 输入流转化为string
     *
     * @param is
     * @return
     * @throws IOException    
     * @since eSDK Solution Platform SSO V1R3C10
     */
    private String inputStream2String(InputStream is)
        throws IOException
    {
        if (null == is)
        {
            return "";
        }
        
        return IOUtils.toString(is, "UTF-8");
    } 
}
