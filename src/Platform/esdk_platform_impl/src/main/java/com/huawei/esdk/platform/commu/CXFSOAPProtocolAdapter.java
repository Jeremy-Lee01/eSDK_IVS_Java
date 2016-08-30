package com.huawei.esdk.platform.commu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.commu.itf.ICXFSOAPCustProvider;
import com.huawei.esdk.platform.commu.itf.ICXFSOAPProtocolAdapter;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdatperCustProvider;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class CXFSOAPProtocolAdapter implements ICXFSOAPProtocolAdapter
{
    private static final Logger LOGGER = Logger
            .getLogger(CXFSOAPProtocolAdapter.class);

    /*
     * 设备访问点地址
     */
    private String serviceAccessPoint;
    
    /*
     * CXF协议定制化需求提供器
     */
    private ICXFSOAPCustProvider cxfSOAPCustProvider;
    
    /*
     * 接口调用对象Map
     */
    private static final Map<String, CachedObjectsBean> CLIENT_MAP = new HashMap<String, CachedObjectsBean>();

    public CXFSOAPProtocolAdapter(String serviceAccessPoint)
    {
        this.serviceAccessPoint = serviceAccessPoint;
    }

    @Override
    public Object syncSendMessageWithCxf(Object reqMessage,
            String itfClassName, String serviceApiName)
            throws ProtocolAdapterException
    {
        try
        {
            Object proxy = getClient(getURL(itfClassName),
                    Class.forName(itfClassName));
            if (null == proxy)
            {
                throw new ProtocolAdapterException(
                        "syncSendMessageWithCxf error: proxy is null",
                        ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
            }

            Method m = proxy.getClass().getMethod(serviceApiName,
                    reqMessage.getClass());
            Object res = m.invoke(proxy, reqMessage);

            return res;
        }
        catch (JAXBException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("syncSendMessageWithCxf error",
                    e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("syncSendMessageWithCxf error",
                    e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        catch (SecurityException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("syncSendMessageWithCxf error",
                    e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        catch (NoSuchMethodException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("syncSendMessageWithCxf error",
                    e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        catch (IllegalArgumentException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("syncSendMessageWithCxf error",
                    e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        catch (IllegalAccessException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("syncSendMessageWithCxf error",
                    e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        catch (InvocationTargetException e)
        {
            LOGGER.error("", e);
            Throwable t = e.getTargetException();
            if (null != t && t instanceof SOAPFaultException)
            {
                SOAPFaultException sfe = (SOAPFaultException) t;
                LOGGER.error("fault code = " + sfe.getFault().getFaultCode());
                if (null != sfe.getFault().getDetail()
                        && null != sfe.getFault().getDetail().getFirstChild())
                {
                    LOGGER.error("detail = "
                            + sfe.getFault().getDetail().getFirstChild()
                                    .getTextContent());
                }
                LOGGER.error("faultactor = " + sfe.getFault().getFaultActor());
                LOGGER.error("fault string = "
                        + sfe.getFault().getFaultString());
                
                if (null != t.getMessage()
                    && (t.getMessage().contains("Connection timed out") || t.getMessage().contains("连接超时")))
                {
                    throw new ProtocolAdapterException("syncSendMessageWithCxf error", e,
                        ESDKErrorCodeConstant.ERROR_CODE_NETWORK_ERROR);
                }
                
                throw new ProtocolAdapterException(
                        "syncSendMessageWithCxf error",
                        e,
                        ESDKErrorCodeConstant.ERROR_CODE_DEVICE_SERVICE_EXCEPTION);
            }
            throw new ProtocolAdapterException("syncSendMessageWithCxf error",
                    e, ESDKErrorCodeConstant.ERROR_CODE_NETWORK_ERROR);
        }
        catch (NoSuchAlgorithmException e)
        {
            LOGGER.error("No Such Algorithm Exception", e);
            throw new ProtocolAdapterException("syncSendMessageWithCxf error",
                    e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        catch (KeyManagementException e)
        {
            LOGGER.error("Key Management Exception", e);
            throw new ProtocolAdapterException("syncSendMessageWithCxf error",
                    e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
    }

    private String getURL(String itfClassName)
    {
        String resultURI = null;
        String resultURL = null;
        if (null != cxfSOAPCustProvider && null != cxfSOAPCustProvider.getSerivceURIMapping() && null != itfClassName)
        {
            String key = itfClassName;
            int index = itfClassName.lastIndexOf(".");
            if (index > -1)
            {
                key = itfClassName.substring(index + 1);
            }
            resultURI = cxfSOAPCustProvider.getSerivceURIMapping().get(key);
        }
        
        if (StringUtils.isEmpty(resultURI))
        {
            resultURL = this.serviceAccessPoint;
        }
        else
        {
            resultURL = this.serviceAccessPoint + resultURI;
        }
        
        if (null != cxfSOAPCustProvider)
        {
            resultURL = cxfSOAPCustProvider.reBuildNewUrl(resultURL, itfClassName);
        }
        
        return resultURL;
    }
    
    protected Object getClient(String url,
            Class<? extends Object> clz) throws JAXBException, NoSuchAlgorithmException, KeyManagementException
    {
    	CachedObjectsBean item = null;
    	synchronized(this)
    	{
    		item = CLIENT_MAP.get(url + clz.getName());
    	}
    	
        if (null != item)
        {
            Client client = item.getClient();
            client.getRequestContext().put(Header.HEADER_LIST, getHeaderList());
            return item.getService();
        }
        else
        {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setAddress(url.split("\\|")[0]);

            Object service = factory.create(clz);
            Client client = ClientProxy.getClient(service);

            // Add the SOAP HEADER info
            client.getRequestContext().put(Header.HEADER_LIST, getHeaderList());

            client.getOutInterceptors().addAll(getOutInterceptors());
            client.getInInterceptors().addAll(getInInterceptors());

            // Setting HTTP Related information
            HTTPConduit http = (HTTPConduit) client.getConduit();
            if (null == http)
            {
                return null;
            }
            
            if(url.startsWith(ESDKConstant.PROTOCOL_ADAPTER_TYPE_HTTPS))
            {
                TLSClientParameters tlsParams = http.getTlsClientParameters();
                
                if (null == tlsParams)
                {
                    tlsParams = new TLSClientParameters();
                    tlsParams.setSecureSocketProtocol(ESDKConstant.SSL_SECURE_SOCKET_PROTOCOL_TLS11);
                }
                
                X509TrustManager tm = new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException { }

                    public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException { }

                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }
                };
                SSLContext sslContext = SSLContext.getInstance(ESDKConstant.SSL_SECURE_SOCKET_PROTOCOL_TLS11);
                
                sslContext.init(null, new TrustManager[]{tm}, null);
                SSLSocketFactory ssf = sslContext.getSocketFactory();
                tlsParams.setSSLSocketFactory(ssf);
                tlsParams.setUseHttpsURLConnectionDefaultHostnameVerifier(false);
                tlsParams.setDisableCNCheck(true);
                
                http.setTlsClientParameters(tlsParams);
            }
            
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setConnectionTimeout(36000);
            httpClientPolicy.setAllowChunking(false);
            httpClientPolicy.setReceiveTimeout(32000);
            http.setClient(httpClientPolicy);

            item = new CachedObjectsBean();
            item.setService(service);
            item.setClient(client);            
            synchronized(this)
            {
            	CLIENT_MAP.put(url + clz.getName(), item);
            }
            return service;
        }
    }
    
    private List<Header> getHeaderList()
    {
        List<Header> result = new ArrayList<Header>();
        if (null == cxfSOAPCustProvider)
        {
            return result;
        }
        
        Map<String, String> headers = cxfSOAPCustProvider.getSoapHeaders();
        if (null != headers)
        {
            Header header;
            Set<Entry<String, String>> entries = headers.entrySet();
            for (Entry<String, String> entry : entries)
            {
                try
                {
                    header = new Header(new QName("", entry.getKey()),
                            entry.getValue(), new JAXBDataBinding(String.class));
                    result.add(header);
                }
                catch (JAXBException e)
                {
                    LOGGER.error("Prepare header error of " + entry.getKey() + ":"
                            + entry.getValue(), e);
                }
            }
        }
        
        return result;
    }
    
    @SuppressWarnings("unchecked")
    private List<Interceptor<Message>> getInInterceptors()
    {
        List<Interceptor<Message>> inInterceptors = new ArrayList<Interceptor<Message>>();        
        if (null != cxfSOAPCustProvider && null != cxfSOAPCustProvider.getInInterceptors())
        {
            List<Object> pInInterceptors = cxfSOAPCustProvider.getInInterceptors();
            for (Object obj : pInInterceptors)
            {
                if (obj instanceof Interceptor<?>)
                {
                    inInterceptors.add((Interceptor<Message>)obj);
                }
            }
        }
        
        return inInterceptors;
    }
    
    @SuppressWarnings("unchecked")
    private List<Interceptor<Message>> getOutInterceptors()
    {
        List<Interceptor<Message>> outInterceptors = new ArrayList<Interceptor<Message>>();    
        if (null != cxfSOAPCustProvider && null != cxfSOAPCustProvider.getOutInterceptors())
        {
            List<Object> pOutInterceptors = cxfSOAPCustProvider.getOutInterceptors();
            for (Object obj : pOutInterceptors)
            {
                if (obj instanceof Interceptor<?>)
                {
                    outInterceptors.add((Interceptor<Message>)obj);
                }
            }
        }
        
        return outInterceptors;
    }
    
    @Override
    public Object syncSendMessage(Object reqMessage, String serviceApiName,
            String resObjClass) throws ProtocolAdapterException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public String syncSendMessage(String messageContent, String serviceApiName)
            throws ProtocolAdapterException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean heartBeat() throws ProtocolAdapterException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int login(String userName, String pwd)
            throws ProtocolAdapterException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int logout() throws ProtocolAdapterException
    {
        throw new UnsupportedOperationException();
    }

    public String getServiceAccessPoint()
    {
        return serviceAccessPoint;
    }

    public void setServiceAccessPoint(String serviceAccessPoint)
    {
        this.serviceAccessPoint = serviceAccessPoint;
    }
    
    public ICXFSOAPCustProvider getCXFSOAPCustProvider()
    {
        return cxfSOAPCustProvider;
    }

    public void setCXFSOAPCustProvider(ICXFSOAPCustProvider cxfSOAPCustProvider)
    {
        this.cxfSOAPCustProvider = cxfSOAPCustProvider;
    }

    @Override
    public ISDKProtocolAdatperCustProvider getSdkProtocolAdatperCustProvider()
    {
        return null;
    }

    @Override
    public void setSdkProtocolAdatperCustProvider(
            ISDKProtocolAdatperCustProvider sdkProtocolAdatperCustProvider)
    {
    }

    @Override
    public Object syncSendMessageWithCxf(Class<?> itfClass, String serviceApi, Object... reqMessage) throws ProtocolAdapterException
    {
    	return syncSendMessageWithCxf(itfClass, serviceApi, null, reqMessage);
    }
    
    @Override
    public Object syncSendMessageWithCxf(Class<?> itfClass, String serviceApi, Class[] clsz, Object... reqMessage) throws ProtocolAdapterException
    {
    	try
    	{
    		Object proxy = getClient(getURL(itfClass.getName()), itfClass);
    		if (null == proxy)
    		{
    			throw new ProtocolAdapterException(
    					"syncSendMessageWithCxf error: proxy is null",
    					ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
    		}
    		
    		if (null == clsz)
    		{
    			clsz = new Class[]{};
    		}
    		Method m = proxy.getClass().getMethod(serviceApi, clsz);
    		Object res = m.invoke(proxy, reqMessage);
    		
    		return res;
    	}
    	catch (JAXBException e)
    	{
    		LOGGER.error("", e);
    		throw new ProtocolAdapterException("syncSendMessageWithCxf error",
    				e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
    	}
    	catch (SecurityException e)
    	{
    		LOGGER.error("", e);
    		throw new ProtocolAdapterException("syncSendMessageWithCxf error",
    				e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
    	}
    	catch (NoSuchMethodException e)
    	{
    		LOGGER.error("", e);
    		throw new ProtocolAdapterException("syncSendMessageWithCxf error",
    				e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
    	}
    	catch (IllegalArgumentException e)
    	{
    		LOGGER.error("", e);
    		throw new ProtocolAdapterException("syncSendMessageWithCxf error",
    				e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
    	}
    	catch (IllegalAccessException e)
    	{
    		LOGGER.error("", e);
    		throw new ProtocolAdapterException("syncSendMessageWithCxf error",
    				e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
    	}
    	catch (InvocationTargetException e)
    	{
    		LOGGER.error("", e);
    		Throwable t = e.getTargetException();
    		if (null != t && t instanceof SOAPFaultException)
    		{
    			SOAPFaultException sfe = (SOAPFaultException) t;
    			LOGGER.error("fault code = " + sfe.getFault().getFaultCode());
    			if (null != sfe.getFault().getDetail()
    					&& null != sfe.getFault().getDetail().getFirstChild())
    			{
    				LOGGER.error("detail = "
    						+ sfe.getFault().getDetail().getFirstChild()
    						.getTextContent());
    			}
    			LOGGER.error("faultactor = " + sfe.getFault().getFaultActor());
    			LOGGER.error("fault string = "
    					+ sfe.getFault().getFaultString());
    			
    			if (null != t.getMessage()
    					&& (t.getMessage().contains("Connection timed out") || t.getMessage().contains("连接超时")))
    			{
    				throw new ProtocolAdapterException("syncSendMessageWithCxf error", e,
    						ESDKErrorCodeConstant.ERROR_CODE_NETWORK_ERROR);
    			}
    			
    			throw new ProtocolAdapterException(
    					"syncSendMessageWithCxf error",
    					e,
    					ESDKErrorCodeConstant.ERROR_CODE_DEVICE_SERVICE_EXCEPTION);
    		}
    		throw new ProtocolAdapterException("syncSendMessageWithCxf error",
    				e, ESDKErrorCodeConstant.ERROR_CODE_NETWORK_ERROR);
    	}
    	catch (NoSuchAlgorithmException e)
    	{
    		LOGGER.error("No Such Algorithm Exception", e);
    		throw new ProtocolAdapterException("syncSendMessageWithCxf error",
    				e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
    	}
    	catch (KeyManagementException e)
    	{
    		LOGGER.error("Key Management Exception", e);
    		throw new ProtocolAdapterException("syncSendMessageWithCxf error",
    				e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
    	}
    }
    
}
