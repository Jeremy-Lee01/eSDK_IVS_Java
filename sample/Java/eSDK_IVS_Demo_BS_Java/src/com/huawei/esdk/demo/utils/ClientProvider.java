package com.huawei.esdk.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.configuration.security.FiltersType;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.huawei.esdk.demo.gen.IVSProfessionalCommon;
import com.huawei.esdk.demo.gen.IVSProfessionalDeviceManager;
import com.huawei.esdk.demo.interceptor.MsgInInterceptor;
import com.huawei.esdk.demo.interceptor.MsgOutInterceptor;
import com.huawei.esdk.demo.keygen.PlatformKeyMgr;
import com.huawei.esdk.ivs.professional.local.impl.utils.AESCbc128Utils;
import com.huawei.esdk.ivs.professional.local.impl.utils.Base64Utils;
import com.huawei.esdk.platform.professional.local.impl.utils.PropertiesUtils;

public abstract class ClientProvider
{
    private static final Logger LOGGER = Logger.getLogger(ClientProvider.class.getName());
    
    private static Map<String, Object> clientMap = new HashMap<String, Object>();
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static synchronized Object getClient(Class clz)
    {
        Object clientObj = clientMap.get(clz.getName());
        if (null != clientObj)
        {
            return clientObj;
        }
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        String url = PropertiesUtils.getValue("sdkserver.url");
        
        if (null == url || (!url.startsWith("http:") && !url.startsWith("https:")))
        {
            url = "";
        }
        if (!Boolean.valueOf(PropertiesUtils.getValue("ssl.support")))
        {
            url = url.replaceFirst("https", "http");
        }
        
        String serviceUrl = "";
        if (clz.getName().equals(IVSProfessionalDeviceManager.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("deviceMgr.service.url");
        }
        else if (clz.getName().equals(IVSProfessionalCommon.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("commonMgr.service.url");
        }
        else if (clz.getName().equals(PlatformKeyMgr.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.key.service.url");
        }
        
        factory.setAddress(url + "/" + serviceUrl);
        
        Object service = null;
        service = factory.create(clz);
        
        if (Boolean.valueOf(PropertiesUtils.getValue("ssl.support")) && url.startsWith("https"))
        {
            return configureSSL(service, clz);
        }
        else
        {
            return configureHttp(service, clz);
        }
    }
    
    @SuppressWarnings("rawtypes")
    private static Object configureHttp(Object obj, Class clz)
    {
        Client client = ClientProxy.getClient(obj);
        addInterceptor(client);
        
        interceptorLoggingCtrl(client);
        
        HTTPConduit http = (HTTPConduit)client.getConduit();
        if (null == http)
        {
            return null;
        }
        configHttpClientPolicy(http);
        
        clientMap.put(clz.getName(), obj);
        return obj;
    }
    
    @SuppressWarnings("rawtypes")
    private static Object configureSSL(Object obj, Class clz)
    {
        
        System.setProperty("javax.net.debug", PropertiesUtils.getValue("ssl.javax.net.debug"));
        
        Client client = ClientProxy.getClient(obj);
        addInterceptor(client);
        
        interceptorLoggingCtrl(client);
        HTTPConduit http = (HTTPConduit)client.getConduit();
        if (null == http)
        {
            return null;
        }
        InputStream is = null;
        try
        {
            TLSClientParameters tlsParams = http.getTlsClientParameters();// new
                                                                          // TLSClientParameters();
            if (null == tlsParams)
            {
                tlsParams = new TLSClientParameters();
                tlsParams.setSecureSocketProtocol(PropertiesUtils.getValue("ssl.secure.socket.protocol"));
            }
            
            KeyStore keyStore =
                KeyStore.getInstance(PropertiesUtils.getValue("ssl.keystore.type"),
                    PropertiesUtils.getValue("ssl.keystore.provider"));
            
            String storePassword =
                new String(
                    AESCbc128Utils.decode(Base64Utils.getFromBASE64(PropertiesUtils.getValue("ssl.keystore.password"))), "UTF-8");
            is =
                (InputStream)ClassLoader.getSystemClassLoader()
                    .getResourceAsStream(PropertiesUtils.getValue("ssl.keystore"));
            if (null == is)
            {
                is =
                    Thread.currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream(PropertiesUtils.getValue("ssl.keystore"));
            }
            keyStore.load(is, storePassword.toCharArray());
            TrustManagerFactory trustFactory =
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(keyStore);
            TrustManager[] trustManagers = trustFactory.getTrustManagers();
            
            SSLContext sslContext = SSLContext.getInstance(PropertiesUtils.getValue("ssl.secure.socket.protocol"));
            sslContext.init(null, trustManagers, new java.security.SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            tlsParams.setSSLSocketFactory(ssf);
            
            tlsParams.setTrustManagers(trustManagers);
            tlsParams.setUseHttpsURLConnectionDefaultHostnameVerifier(false);
            
            FiltersType filtersTypes = new FiltersType();
            filtersTypes.getInclude().add(".*_EXPORT_.*");
            filtersTypes.getInclude().add(".*_EXPORT1024_.*");
            filtersTypes.getInclude().add(".*_WITH_DES_.*");
            filtersTypes.getInclude().add(".*_WITH_AES_.*");
            filtersTypes.getInclude().add(".*_WITH_NULL_.*");
            filtersTypes.getExclude().add(".*_DH_anon_.*");
            
            tlsParams.setCipherSuitesFilter(filtersTypes);
            tlsParams.setDisableCNCheck(true);
            
            http.setTlsClientParameters(tlsParams);
            configHttpClientPolicy(http);
            
            clientMap.put(clz.getName(), obj);
            
        }
        catch (Exception e)
        {
            LOGGER.log(java.util.logging.Level.WARNING, "Exception happened in configureSSL() ", e);
        }
        finally
        {
            if (null != is)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    LOGGER.log(java.util.logging.Level.WARNING, "Exception happened in configureSSL() ", e);
                }
            }
        }
        return obj;
    }
    
    private static void interceptorLoggingCtrl(Client client)
    {
        if (Boolean.valueOf(PropertiesUtils.getValue("cxf.logging.interceptor.on")))
        {
            client.getOutInterceptors().add(new LoggingOutInterceptor());
            client.getInInterceptors().add(new LoggingInInterceptor());
        }
    }
    
    private static void configHttpClientPolicy(HTTPConduit http)
    {
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(60000);
        httpClientPolicy.setAllowChunking(false);
        httpClientPolicy.setReceiveTimeout(60000);
        http.setClient(httpClientPolicy);
    }
    
    @SuppressWarnings("unchecked")
    private static void addInterceptor(Client client)
    {
        client.getOutInterceptors().add(new MsgOutInterceptor());
        client.getInInterceptors().add(new MsgInInterceptor());
    }
    
}