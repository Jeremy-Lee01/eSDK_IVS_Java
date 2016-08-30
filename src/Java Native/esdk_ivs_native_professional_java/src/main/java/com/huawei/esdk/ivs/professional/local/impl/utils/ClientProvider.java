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
package com.huawei.esdk.ivs.professional.local.impl.utils;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalAlarmManager;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalBusinessManager;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalClusterManager;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalCommon;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalDeviceManager;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalRecordManager;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalUserManager;
import com.huawei.esdk.ivs.professional.local.impl.interceptor.MsgInInterceptor;
import com.huawei.esdk.ivs.professional.local.impl.interceptor.MsgOutInterceptor;

public abstract class ClientProvider
{
    private static final Logger LOGGER = Logger.getLogger(ClientProvider.class.getName());
    
    private static HashMap<String, Object> clientMap = new HashMap<String, Object>();
    
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
        
        String serviceUrl = getServiceUrl(clz);
        
        factory.setAddress(url + "/" + serviceUrl);
        
        Object service = null;
        service = factory.create(clz);
        
        if (url.startsWith("https"))
        {
            return configureSSL(service, clz);
        }
        else
        {
            return configureHttp(service, clz);
        }
    }
    
    @SuppressWarnings("rawtypes")
    private static String getServiceUrl(Class clz)
    {
        String serviceUrl = "";
        if (clz.getName().equals(IVSProfessionalCommon.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.common.service.url");
        }
        if (clz.getName().equals(IVSProfessionalUserManager.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.usermgr.service.url");
        }
        if (clz.getName().equals(IVSProfessionalClusterManager.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.clustermgr.service.url");
        }
        if (clz.getName().equals(IVSProfessionalAlarmManager.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.alarmmgr.service.url");
        }
        if (clz.getName().equals(IVSProfessionalDeviceManager.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.devicemgr.service.url");
        }
        if (clz.getName().equals(IVSProfessionalRecordManager.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.recordmgr.service.url");
            
        }
        if (clz.getName().equals(IVSProfessionalBusinessManager.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.businessmgr.service.url");
            
        }
        return serviceUrl;
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
//      System.setProperty("javax.net.debug", PropertiesUtils.getValue("ssl.javax.net.debug"));
        
      Client client = ClientProxy.getClient(obj);
      interceptorLoggingCtrl(client);
      addInterceptor(client);
      HTTPConduit http = (HTTPConduit)client.getConduit();
      if (null == http)
      {
          return null;
      }
      try
      {
          TLSClientParameters tlsParams = http.getTlsClientParameters();
          String prpto = PropertiesUtils.getValue("ssl.secure.socket.protocol");
          
          if (null == tlsParams)
          {
              tlsParams = new TLSClientParameters();
              tlsParams.setSecureSocketProtocol(prpto);
          }
  
          X509TrustManager tm = new X509TrustManager() {
              public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException { }

              public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException { }

              public X509Certificate[] getAcceptedIssuers() {
                  return new X509Certificate[]{};
              }
          };
          SSLContext sslContext = SSLContext.getInstance(prpto);
          
          sslContext.init(null, new TrustManager[]{tm}, null);
          SSLSocketFactory ssf = sslContext.getSocketFactory();
          tlsParams.setSSLSocketFactory(ssf);
          tlsParams.setUseHttpsURLConnectionDefaultHostnameVerifier(false);
          tlsParams.setDisableCNCheck(true);
          
          http.setTlsClientParameters(tlsParams);
          configHttpClientPolicy(http);
          
          clientMap.put(clz.getName(), obj);
      }
      catch (NoSuchAlgorithmException e)
      {
          LOGGER.log(java.util.logging.Level.WARNING, "Exception happened in configureSSL() ", e);
      }
      catch (Exception e)
      {
          LOGGER.log(java.util.logging.Level.WARNING, "Exception happened in configureSSL() ", e);
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
    
    private static void addInterceptor(Client client)
    {
        client.getOutInterceptors().add(new MsgOutInterceptor());
        client.getInInterceptors().add(new MsgInInterceptor());
    }
}
