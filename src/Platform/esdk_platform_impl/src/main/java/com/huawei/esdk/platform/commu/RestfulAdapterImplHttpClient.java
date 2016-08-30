package com.huawei.esdk.platform.commu;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.DigestScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.aa.AccountInfo;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdatperCustProvider;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class RestfulAdapterImplHttpClient implements ISDKProtocolAdapter
{
    private static Logger LOGGER = Logger.getLogger(RestfulAdapterImplHttpClient.class);
    
    private int serverNounceCount;
    
    private ISDKProtocolAdatperCustProvider sdkProtocolAdatperCustProvider;
    
    private String serverUrl;
    
    private DefaultHttpClient httpClient;
    
    private String user;
    
    private String pwd;
    
    private HttpHost target;
    
    private BasicHttpContext localContext;
    
    public RestfulAdapterImplHttpClient(String serverUrl)
    {
        //判断RSE业务，以便应用平台的发送消息方法--1
        boolean rseFlag = false;
        if (null !=serverUrl && serverUrl.endsWith("rse"))
        {
            serverUrl = serverUrl.substring(0, serverUrl.lastIndexOf("rse"));
            rseFlag = true;
        }
        serverUrl = StringUtils.isEmpty(serverUrl) ? "" : serverUrl;
        this.serverUrl = serverUrl;
        ClientConnectionManager conMgr = new PoolingClientConnectionManager();
        httpClient = new DefaultHttpClient(conMgr);
        
        httpClient.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 60000);
        httpClient.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 60000);
        
        target = buildHttpHost();
        
        if (serverUrl.startsWith(ESDKConstant.PROTOCOL_ADAPTER_TYPE_HTTPS))
        {
            try
            {
                URL server = new URL(serverUrl);
                int port = server.getPort();
                port = 0 < port ? port : ESDKConstant.PROTOCOL_ADAPTER_TYPE_HTTPS_DEFAULT_PORT;
                
                SSLContext ctx;
                //判断RSE业务，以便应用平台的发送消息方法--2
                if (rseFlag)
                {
                    ctx = SSLContext.getInstance(ESDKConstant.SSL_SECURE_SOCKET_PROTOCOL_TLS11);
                }
                else
                {
                    ctx = SSLContext.getInstance(ESDKConstant.SSL_SECURE_SOCKET_PROTOCOL);
                }
                
                X509TrustManager tm = new X509TrustManager()
                {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers()
                    {
                        return new java.security.cert.X509Certificate[] {};
                    }
                    
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
                        throws java.security.cert.CertificateException
                    {
                    }
                    
                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
                        throws java.security.cert.CertificateException
                    {
                    }
                    
                };
                ctx.init(null, new TrustManager[] {tm}, null);
                SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                SchemeRegistry registry = conMgr.getSchemeRegistry();
                registry.register(new Scheme(ESDKConstant.PROTOCOL_ADAPTER_TYPE_HTTPS, port, ssf));
            }
            catch (KeyManagementException e)
            {
                LOGGER.error("https error", e);
            }
            catch (NoSuchAlgorithmException e)
            {
                LOGGER.error("https error", e);
            }
            catch (MalformedURLException e)
            {
                LOGGER.error("https error", e);
            }
        }
    }
    
    private HttpHost buildHttpHost()
    {
        if (StringUtils.isEmpty(serverUrl))
        {
            return null;
        }
        
        HttpHost result;
        
        String scheme = serverUrl.substring(0, serverUrl.indexOf("://"));
        String server = serverUrl.substring(serverUrl.indexOf("://") + 3, serverUrl.indexOf("/", scheme.length() + 3));
        if (server.contains(":"))
        {
            result = new HttpHost(server.split(":")[0], Integer.valueOf(server.split(":")[1]), scheme);
        }
        else
        {
            result = new HttpHost(server, 80, scheme);
        }
        
        return result;
    }
    
    @Override
    public String getServiceAccessPoint()
    {
        return this.serverUrl;
    }
    
    private synchronized void checkLocalContext()
    {
        if (null != sdkProtocolAdatperCustProvider && null != target)
        {
            // Create AuthCache instance
            AuthCache authCache = new BasicAuthCache();
            // Generate DIGEST scheme object, initialize it and add it to the local auth cache
            String authType = (String) ThreadLocalHolder.get().getEntities().get("AuthType");
            if ("Basic".equals(authType))
            {
                LOGGER.debug("authentication type: basic");
            }
            else
            {
                DigestScheme digestAuth = new DigestScheme();
                digestAuth.overrideParamter("nc", String.valueOf(serverNounceCount++));
                digestAuth.overrideParamter("cnonce", UUID.randomUUID().toString().replaceAll("-", ""));
                digestAuth.overrideParamter("qop", "auth");
                authCache.put(target, digestAuth);
            }
            
            // Add AuthCache to the execution context
            localContext = new BasicHttpContext();
            localContext.setAttribute(ClientContext.AUTH_CACHE, authCache);
        }
    }
    
    @Override
    public Object syncSendMessage(Object reqMessage, String serviceApiName, String resObjClass)
        throws ProtocolAdapterException
    {
        if (!(reqMessage instanceof RestReqMessage))
        {
            throw new IllegalArgumentException("reqMessage is not a instance of RestReqMessage");
        }
        RestReqMessage restReq = (RestReqMessage)reqMessage;
        
        checkLocalContext();
        
        HttpRequestBase request = null;
        try
        {
            preSend(restReq);
            
            request = buildHttpRequest(restReq, serviceApiName);
            // Send the http request
            HttpResponse response = httpClient.execute(target, request, localContext);
            ThreadLocalHolder.get().getEntities().put("HTTP_RES_CODE", String.valueOf(response.getStatusLine().getStatusCode()));
            
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2"))
            {
                LOGGER.info("HTTP status code is " + response.getStatusLine().getStatusCode());
                LOGGER.info("HTTP response body: " + EntityUtils.toString(response.getEntity()));
                throw new ProtocolAdapterException("Status code is not 200", response.getStatusLine().getStatusCode());
            }
            // Process the response header
            return postSend(response, resObjClass);
        }
        catch (ProtocolAdapterException ex)
        {
            LOGGER.error("", ex);
            throw ex;
        }
        catch (ClientProtocolException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("", ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        catch (UnsupportedEncodingException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("", ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("", ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        catch (URISyntaxException e)
        {
            LOGGER.error("", e);
            throw new ProtocolAdapterException("", ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR);
        }
        finally
        {
            if (null != request)
            {
                request.releaseConnection();
            }
        }
    }
    
    private void preSend(RestReqMessage restReq)
    {
        if (null != sdkProtocolAdatperCustProvider)
        {
            AccountInfo accountInfo = sdkProtocolAdatperCustProvider.getProtocolAuthInfo();
            if (null != accountInfo && null != accountInfo.getUserId())
            {
                if (!StringUtils.strsEquals(accountInfo.getUserId(), user) || !StringUtils.strsEquals(accountInfo.getPassword(), pwd))
                {
                    httpClient.getCredentialsProvider().setCredentials(new AuthScope(target.getHostName(),
                        target.getPort()),
                        new UsernamePasswordCredentials(accountInfo.getUserId(), accountInfo.getPassword()));
                    this.user = accountInfo.getUserId();
                    this.pwd = accountInfo.getPassword();
                }
            }
            
            sdkProtocolAdatperCustProvider.preProcessReq(restReq);
            sdkProtocolAdatperCustProvider.preSend(restReq);
        }
    }
    
    private Object postSend(HttpResponse response, String resObjClass)
        throws ProtocolAdapterException, ParseException, IOException
    {
        HttpEntity entity = response.getEntity();
        String responsePayload = EntityUtils.toString(entity);
        
        if (null != sdkProtocolAdatperCustProvider)
        {
            sdkProtocolAdatperCustProvider.postSend(responsePayload);
            return sdkProtocolAdatperCustProvider.postBuildRes(responsePayload, resObjClass);
        }
        else
        {
            // Process the response body
            LOGGER.debug("The response content is:" + response);
            return responsePayload;
        }
    }
    
    private HttpRequestBase buildHttpRequest(RestReqMessage restReq, String serviceApiName)
        throws URISyntaxException, UnsupportedEncodingException
    {
        HttpRequestBase request;
        if (ESDKConstant.HTTP_METHOD_GET.equalsIgnoreCase(restReq.getHttpMethod()))
        {
            HttpGet httpGet = new HttpGet(getURL(serviceApiName));
            setParameters(httpGet, restReq.getParameters());
            request = httpGet;
        }
        else if (ESDKConstant.HTTP_METHOD_POST.equalsIgnoreCase(restReq.getHttpMethod()))
        {
            HttpPost httpPost = new HttpPost(getURL(serviceApiName));
            setParameters(httpPost, restReq.getParameters());
            httpPost.setEntity(new StringEntity(getPayloadAsString(restReq), "UTF-8"));
            request = httpPost;
        }
        else if (ESDKConstant.HTTP_METHOD_PUT.equalsIgnoreCase(restReq.getHttpMethod()))
        {
            HttpPut httpPut = new HttpPut(getURL(serviceApiName));
            httpPut.setEntity(new StringEntity(getPayloadAsString(restReq), "UTF-8"));
            request = httpPut;
        }
        else if (ESDKConstant.HTTP_METHOD_DELETE.equalsIgnoreCase(restReq.getHttpMethod()))
        {
            HttpDelete httpDelete = new HttpDelete(getURL(serviceApiName));
            setParameters(httpDelete, restReq.getParameters());
            request = httpDelete;
        }
        else
        {
            String msg = restReq.getHttpMethod() + " is not a valid HTTP method";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
        
        setHttpHeaders(request, restReq.getHttpHeaders());
        
        return request;
    }
    
    private String getURL(String serviceApiName)
    {
        if (null != sdkProtocolAdatperCustProvider)
        {
            return sdkProtocolAdatperCustProvider.reBuildNewUrl(serverUrl, serviceApiName);
        }
        else
        {
            return serverUrl;
        }
    }
    
    private String getPayloadAsString(RestReqMessage restReq)
    {
        String mediaType = restReq.getMediaType();
        mediaType = (mediaType == null ? "" : mediaType.toLowerCase(Locale.ENGLISH));
        if (mediaType.contains("json"))
        {
            if (null != sdkProtocolAdatperCustProvider)
            {
                return sdkProtocolAdatperCustProvider.getContent4Sending(restReq.getPayload());
            }
            else
            {
                Gson gson = new Gson();
                String reqPayloadInJSON = gson.toJson(restReq.getPayload());
                return reqPayloadInJSON;
            }
        }
        else if (mediaType.contains("xml"))
        {
            if (null != sdkProtocolAdatperCustProvider)
            {
                return sdkProtocolAdatperCustProvider.getContent4Sending(restReq);
            }
            else
            {
                return restReq.getPayload().toString();
            }
        }
        else
        {
            return restReq.getPayload().toString();
        }
    }
    
    private void setParameters(HttpRequestBase httpRequest, Map<String, String> parameters)
        throws URISyntaxException
    {
        if (null != parameters && !parameters.isEmpty())
        {
            URIBuilder uriBuilder = new URIBuilder(httpRequest.getURI());
            
            for (Map.Entry<String, String> entry : parameters.entrySet())
            {
                uriBuilder.addParameter(entry.getKey(), entry.getValue());
            }
            
            httpRequest.setURI(uriBuilder.build());
        }
    }
    
    private void setHttpHeaders(HttpRequestBase request, Map<String, String> pHeaders)
    {
        for (Map.Entry<String, String> entry : pHeaders.entrySet())
        {
            request.addHeader(entry.getKey(), entry.getValue());
        }
        
        Map<String, String> headers = getRequestHeaders();
        if (headers != null)
        {
            Set<Map.Entry<String, String>> es = headers.entrySet();
            for (Map.Entry<String, String> item : es)
            {
                request.addHeader(item.getKey(), item.getValue());
            }
        }
    }
    
    @Override
    public String syncSendMessage(String messageContent, String serviceApiName)
        throws ProtocolAdapterException
    {
        throw new UnsupportedOperationException(
            "syncSendMessage(String messageContent, String serviceApiName) is not supported");
    }
    
    @Override
    public boolean heartBeat()
        throws ProtocolAdapterException
    {
        return true;
    }
    
    @Override
    public int login(String userName, String pwd)
        throws ProtocolAdapterException
    {
        return 0;
    }
    
    @Override
    public int logout()
        throws ProtocolAdapterException
    {
        return 0;
    }
    
    protected Map<String, String> getRequestHeaders()
    {
        // For override by derived class
        if (null != sdkProtocolAdatperCustProvider)
        {
            return sdkProtocolAdatperCustProvider.getRequestHeaders();
        }
        return null;
    }
    
    @Override
    public ISDKProtocolAdatperCustProvider getSdkProtocolAdatperCustProvider()
    {
        return sdkProtocolAdatperCustProvider;
    }
    
    @Override
    public void setSdkProtocolAdatperCustProvider(ISDKProtocolAdatperCustProvider sdkProtocolAdatperCustProvider)
    {
        this.sdkProtocolAdatperCustProvider = sdkProtocolAdatperCustProvider;
    }
}
