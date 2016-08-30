package com.huawei.esdk.platform.commu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URL;
import java.util.Locale;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.utils.AES128System;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class HttpProtocolJDKAdapter extends HttpProtocolAdapter
{
    private static final Logger LOGGER = Logger.getLogger(HttpProtocolJDKAdapter.class);
    
    public HttpProtocolJDKAdapter(String sap)
    {
        super(sap);
    }
    
    @Override
    public Object syncSendMessage(Object reqMessage, String serviceApiName, String resObjClass)
        throws ProtocolAdapterException
    {
        getSdkProtocolAdatperCustProvider().preProcessReq(reqMessage);
        
        String res =
            syncSendMessage(getSdkProtocolAdatperCustProvider().getContent4Sending(reqMessage), serviceApiName);
        
        return getSdkProtocolAdatperCustProvider().postBuildRes(res, resObjClass);
    }
    
    @Override
    public String syncSendMessage(String messageContent, String serviceApiName)
        throws ProtocolAdapterException
    {
        try
        {
            if ("GET".equals(serviceApiName))
            {
                messageContent = messageContent.replaceAll(" ", "%20");
                if (StringUtils.isNotEmpty(messageContent))
                {
                    return doGet(getServerUrl() + "?" + messageContent);
                }
                else
                {
                    return doGet(getServerUrl());
                }
            }
            else
            {
                throw new UnsupportedOperationException();
            }
        }
        catch (UnsupportedEncodingException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("syncSendMessage error", e, ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        catch (ClientProtocolException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("syncSendMessage error", e,
                ESDKErrorCodeConstant.ERROR_CODE_NETWORK_ERROR);
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("syncSendMessage error", e,
                ESDKErrorCodeConstant.ERROR_CODE_NETWORK_ERROR);
        }
    }
    
    private String doGet(String urlAsString)
        throws IOException
    {
        InputStream in = null;
        BufferedReader reader = null;
        try
        {
            String[] tempArray = urlAsString.split("msg");
            LOGGER.debug("Sending a HTTP GET request:" + tempArray[0].substring(0, tempArray[0].length() - 1));
            
            CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
            
            Authenticator.setDefault(new ESDKAuthenticator());
            
            URL url = new URL(urlAsString);
            if (urlAsString.toLowerCase(Locale.getDefault()).startsWith("https"))
            {
                prepareHttpsProperties();
            }
            
            in = url.openConnection().getInputStream();
            
            reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            
            StringBuilder sb = new StringBuilder();
            String str = reader.readLine();
            while (null != str)
            {
                sb.append(str);
                str = reader.readLine();
            }
            
            LOGGER.debug("The response is " + sb.toString());
            
            return sb.toString();
        }
        finally
        {
            if (null != reader)
            {
                try
                {
                    reader.close();
                }
                catch (Exception e)
                {
                    LOGGER.error("", e);
                }
            }
            
            if (null != in)
            {
                try
                {
                    in.close();
                }
                catch (Exception e)
                {
                    LOGGER.error("", e);
                }
            }
        }
    }
    
    private void prepareHttpsProperties()
    {
        String temp = ConfigManager.getInstance().getValue("sms.ssl.trustStore");
        if (!StringUtils.isEmpty(temp))
        {
            System.setProperty("javax.net.ssl.trustStore", temp);
        }
        
        temp = ConfigManager.getInstance().getValue("sms.ssl.trustStorePassword");
        if (!StringUtils.isEmpty(temp))
        {
            System.setProperty("javax.net.ssl.trustStorePassword", AES128System.decryptPwdByOldKey("", temp));
        }
        
        temp = ConfigManager.getInstance().getValue("sms.ssl.keyStore");
        if (!StringUtils.isEmpty(temp))
        {
            System.setProperty("javax.net.ssl.keyStore", temp);
        }
        
        temp = ConfigManager.getInstance().getValue("sms.ssl.keyStorePassword");
        if (!StringUtils.isEmpty(temp))
        {
            temp = AES128System.decryptPwdByOldKey("", temp);
            System.setProperty("javax.net.ssl.keyStorePassword", temp);
        }
        
        temp = ConfigManager.getInstance().getValue("sms.ssl.keyStoreType");
        if (!StringUtils.isEmpty(temp))
        {
            System.setProperty("javax.net.ssl.keyStoreType", temp);
        }
    }
}
