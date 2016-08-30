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
package com.huawei.esdk.ivs.professional.local.impl.service.callback;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.URL;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.xml.ws.Endpoint;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.professional.local.constant.NativeConstant;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalCommon;
import com.huawei.esdk.ivs.professional.local.impl.utils.AESCbc128Utils;
import com.huawei.esdk.ivs.professional.local.impl.utils.Base64Utils;
import com.huawei.esdk.ivs.professional.local.impl.utils.ClientProvider;
import com.huawei.esdk.ivs.professional.local.impl.utils.ExceptionUtils;
import com.huawei.esdk.ivs.professional.local.service.callback.IVSCallbackServiceEx;
import com.huawei.esdk.ivs.professional.local.service.callback.IVSEventCallBack;
import com.huawei.esdk.ivs.professional.local.service.callback.IVSProfessionalCallback;
import com.huawei.esdk.platform.professional.local.impl.utils.PropertiesUtils;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;

@SuppressWarnings("rawtypes")
public class IVSCallbackServiceExImpl implements IVSCallbackServiceEx
{
    
    private static IVSCallbackServiceExImpl instance = null;
    
    private IVSProfessionalCommon ivsProfessionalCommon =
        (IVSProfessionalCommon)ClientProvider.getClient(IVSProfessionalCommon.class);
    
    static Map<Class, IVSProfessionalCallback> callbacks = null;
    
    static Map<String, Endpoint> services = null;
    
    static
    {
        callbacks = new HashMap<Class, IVSProfessionalCallback>();
        services = new HashMap<String, Endpoint>();
        
    }
    
    private final static Logger LOGGER = Logger.getLogger(IVSCallbackServiceExImpl.class);
    
    public static synchronized IVSCallbackServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new IVSCallbackServiceExImpl();
        }
        return instance;
    }
    
    @Override
    public Integer regeditCallback(String wsUrl, IVSProfessionalCallback ivsCallback)
    {
        LOGGER.info("begin to execute regeditCallback method");
        
        int result = NativeConstant.REDEGIT_CALLBAK_ERRORCODE;
        
        if (ivsCallback instanceof IVSEventCallBack)
        {
            result = publishServices(wsUrl, new IVSProfessionalEventCallBackImpl());
            
            if (0 == result)
            {
                callbacks.put(IVSEventCallBack.class, ivsCallback);
            }
            return result;
        }
        
        LOGGER.info("execute regeditCallback method completed");
        return result;
    }
    
    private int publishServices(String url, Object clz)
    {
        
        int result = NativeConstant.REDEGIT_CALLBAK_ERRORCODE;
        
        //取消注册
        if (null == url || url.isEmpty())
        {
            try
            {
                int unRegisterResultCode = ivsProfessionalCommon.registerNotification(url);
                
                if (0 == unRegisterResultCode)
                {
                    for (Entry<String, Endpoint> endPoint : services.entrySet())
                    {
                        endPoint.getValue().stop();
                    }
                }
                return unRegisterResultCode;
            }
            catch (Exception e)
            {
                LOGGER.error("regeditCallback method exception happened", e);
                return ExceptionUtils.processSoapException(e);
            }
        }
        
        Endpoint endpoint = services.get(url);
        if (null == endpoint || !endpoint.isPublished())
        {
            InputStream is = null;
            try
            {
                if (null != url && url.contains("https:"))
                {
                    String keystoreFile = PropertiesUtils.getValue("callback.keystore.path");
                    
                    String keyPass =
                            new String(
                                AESCbc128Utils.decode(Base64Utils.getFromBASE64(PropertiesUtils.getValue("callback.ssl.keystore.password"))),"UTF-8");
                    
                    URL uri = new URL(url);
                    int port = uri.getPort();
                    
                    SSLContext ssl = SSLContext.getInstance("TLSv1.1");
                             
                    KeyManagerFactory keyFactory =
                        KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                    KeyStore store =
                        KeyStore.getInstance(getDefaultValueIfEmpty(PropertiesUtils.getValue("callback.ssl.keystore.type"), "JKS"),
                            getDefaultValueIfEmpty(PropertiesUtils.getValue("callback.ssl.keystore.provider"), "SUN"));
                    
                    is = Thread.currentThread().getContextClassLoader().getResourceAsStream(keystoreFile);
                    store.load(is, keyPass.toCharArray());
                    
                    keyFactory.init(store, keyPass.toCharArray());
                    
                    ssl.init(keyFactory.getKeyManagers(), null, null);
                    
                    HttpsConfigurator configurator = new HttpsConfigurator(ssl);
                    
                    HttpsServer httpsServer = HttpsServer.create(new InetSocketAddress(uri.getHost(), port), 0);
                    httpsServer.setHttpsConfigurator(configurator);
                    
                    ExecutorService threads = Executors.newFixedThreadPool(200);
                    httpsServer.setExecutor(threads);
                    httpsServer.start();
                    
                    com.sun.net.httpserver.HttpContext httpContext = httpsServer.createContext(uri.getPath());
                    
                    endpoint = new com.sun.xml.internal.ws.spi.ProviderImpl().createEndpoint(null, clz);
                    endpoint.publish(httpContext);
                }
                else
                {
                    endpoint = Endpoint.publish(url, clz);
                }
                
                services.put(url, endpoint);
            }
            catch (Exception e)
            {
            	e.printStackTrace();
                LOGGER.error("regeditCallback method exception happened", e);
                return ExceptionUtils.processSoapException(e);
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
                        LOGGER.error("Exception happened in publishServices() ", e);
                    }
                }
            }
        }
        
        if (endpoint.isPublished())
        {
            try
            {
                return ivsProfessionalCommon.registerNotification(url);
            }
            catch (Exception e)
            {
                LOGGER.error("regeditCallback method exception happened", e);
                return ExceptionUtils.processSoapException(e);
            }
        }
        return result;
    }
    
    private String getDefaultValueIfEmpty(String value, String defaultValue)
    {
        if (null == value || value.trim().isEmpty())
        {
            return defaultValue;
        }
        return value;
    }
    
}
