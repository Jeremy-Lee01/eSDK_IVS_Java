package com.huawei.esdk.platform.log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.utils.NumberUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class LogFileUploaderTask implements Runnable
{
    private static final Logger LOGGER = Logger.getLogger(LogFileUploaderTask.class);
    
    private static final String LOG_PRODUCT_SERVER = "eSDK-Server";
    
    private static String SSL_SECURE_SOCKET_PROTOCOL = "TLS";
    
    private ClientConnectionManager conMgr = new PoolingClientConnectionManager();
    
    private HttpClient httpClient = new DefaultHttpClient(conMgr);
    
    private static boolean gzip = Boolean.parseBoolean(ConfigManager.getInstance()
        .getValue("platform.upload.log.file.gzip", "false"));
    
    private long getSleepTime()
    {
        Random generator = new Random();
        double num = generator.nextDouble() / 2;
        
        long result =
            (long)(60L * NumberUtils.parseIntValue(ConfigManager.getInstance()
                .getValue("platform.upload.log.file.interval", "60")) * num);
        
        return result;
    }
    
    @Override
    public void run()
    {
        try
        {
            long sleepTime;
            while (true)
            {
                sleepTime = getSleepTime();
                LOGGER.debug("sleepTime=" + sleepTime);
                TimeUnit.SECONDS.sleep(sleepTime);
                try
                {
                    //upload Logs
                    uploadLogFiles();
                }
                catch (Exception e)
                {
                    LOGGER.error("", e);
                }
            }
        }
        catch (InterruptedException e)
        {
            //InterruptedException Exception happened
            LOGGER.error("", e);
        }
    }
    
    private boolean hasUploadRights()
    {
        String serverUrl = ConfigManager.getInstance().getValue("log.server.url");
        
        httpClient.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 60000);
        httpClient.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 60000);
        
        if (serverUrl.toLowerCase().startsWith(ESDKConstant.PROTOCOL_ADAPTER_TYPE_HTTPS))
        {
            try
            {
                URL server = new URL(serverUrl);
                int port = server.getPort();
                port = 0 < port ? port : ESDKConstant.PROTOCOL_ADAPTER_TYPE_HTTPS_DEFAULT_PORT;
                
                SSLContext ctx = SSLContext.getInstance(ESDKConstant.SSL_SECURE_SOCKET_PROTOCOL);
                ctx.init(null, new TrustManager[] {myX509TrustManager}, null);
                org.apache.http.conn.ssl.SSLSocketFactory ssf =
                    new org.apache.http.conn.ssl.SSLSocketFactory(ctx,
                        org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                conMgr.getSchemeRegistry().register(new Scheme(ESDKConstant.PROTOCOL_ADAPTER_TYPE_HTTPS, port, ssf));
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
                LOGGER.error("", e);
            }
        }
        
        HttpPost httpPost = new HttpPost(serverUrl);
        MultipartEntity mutiEntity = new MultipartEntity(HttpMultipartMode.STRICT);
        httpPost.setEntity(mutiEntity);
        try
        {
            mutiEntity.addPart("LogFileInfo",
                new StringBody("{\"product\":\"" + LOG_PRODUCT_SERVER + "\"}", Charset.forName("UTF-8")));
        }
        catch (UnsupportedEncodingException e)
        {
            LOGGER.error("UTF-8 is not supported encode");
        }
        
        HttpResponse httpResponse;
        try
        {
            httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            String content = EntityUtils.toString(httpEntity);
            if (content.contains("\"resultCode\":\"3\""))
            {
                return false;
            }
        }
        catch (ClientProtocolException e)
        {
            LOGGER.error("", e);
            return false;
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
            return false;
        }
        finally
        {
            httpPost.releaseConnection();
        }
        
        return true;
    }
    
    private void uploadLogFiles()
    {
        LOGGER.debug("uploadLogFiles begin");
        if (!hasUploadRights())
        {
            LOGGER.debug("Current machine is not allowed to upload file to server or the server has something wrong.");
            return;
        }
        
        String uploadLogTypes = ConfigManager.getInstance().getValue("platform.upload.log.file.type");
        if (StringUtils.isEmpty(uploadLogTypes))
        {
            uploadLogTypes = "interface";
        }
        
        String[] logTypes = new String[] {"run", "interface", "operation"};
        String logFile;
        File file;
        boolean currentWritingLogFileFlag = false;
        for (String logType : logTypes)
        {
            if (uploadLogTypes.contains(logType))
            {
                //Reset variables
                currentWritingLogFileFlag = false;
                
                //Loop all log files for specified log type
                while (true)
                {
                    logFile = LogFileUploaderHelper.getOldestLogFile(logType);
                    LOGGER.debug("logFile=" + logFile);
                    if (StringUtils.isEmpty(logFile)
                        || (currentWritingLogFileFlag && !LogFileUploaderHelper.isBackLogFile(logFile)))
                    {
                        break;
                    }
                    else
                    {
                        if (!LogFileUploaderHelper.isBackLogFile(logFile))
                        {
                            currentWritingLogFileFlag = true;
                        }
                        file = new File(logFile);
                        if (0 == file.length())
                        {
                            continue;
                        }
                        
                        if (!LogFileUploaderHelper.isBackLogFile(logFile))
                        {
                            logFile = processCurrentLogFile(logType, logFile);
                        }
                        if (StringUtils.isEmpty(logFile))
                        {
                            continue;
                        }
                        logFile = moveFile(logFile);
                        if (doLogFileUpload(logFile, LOG_PRODUCT_SERVER))
                        {
                            LogFileUploaderHelper.backup(logFile, logType);
                        }
                    }
                }
            }
        }
        
        LOGGER.debug("uploadLogFiles end");
    }
    
    private String moveFile(String logFile)
    {
        if (StringUtils.isEmpty(logFile))
        {
            return logFile;
        }
        
        File file = new File(logFile);
        //Move the file to temp folder for uploading
        File destFile = new File(file.getParent() + File.separator + "temp" + File.separator + file.getName());
        try
        {
            if (destFile.exists())
            {
                destFile.delete();
            }
            FileUtils.moveFile(file, destFile);
            file = destFile;
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
        }
        
        return file.getPath();
    }
    
    private String processCurrentLogFile(String logType, String logFile)
    {
        File file = new File(logFile);
        //Different appenders for different file types
        RollingFileAppender appender;
        if ("interface".equalsIgnoreCase(logType))
        {
            appender =
                (RollingFileAppender)Logger.getLogger("com.huawei.esdk.platform.log.InterfaceLog").getAppender("FILE1");
        }
        else if ("operation".equalsIgnoreCase(logType))
        {
            try
            {
                File destDir = new File(file.getParent() + File.separator + "temp" + File.separator + file.getName());
                FileUtils.moveFile(file, destDir);
                FileUtils.moveFile(destDir, file);
                return logFile;
            }
            catch (IOException e)
            {
                return "";
            }
        }
        else
        {
            appender = (RollingFileAppender)Logger.getRootLogger().getAppender("fileLogger");
        }
        
        long origSize = appender.getMaximumFileSize();
        appender.setMaximumFileSize(file.length());
        if ("interface".equalsIgnoreCase(logType))
        {
            LOGGER.debug("Rolling the interface log file");
            //Call the rooOver method in order to backup the current log file for uploading
            appender.rollOver();
        }
        else
        {
            //Call the rooOver method in order to backup the current log file for uploading
            appender.rollOver();
            LOGGER.debug("Log File size reset");
        }
        LOGGER.debug("origSize=" + origSize + ", logType=" + logType);
        appender.setMaximumFileSize(origSize);
        String result = logFile + ".1";
        file = new File(result);
        if (file.exists())
        {
            return result;
        }
        else
        {
            return "";
        }
    }
    
    private boolean doLogFileUpload(String fileNameWithPath, String product)
    {
        if (StringUtils.isEmpty(fileNameWithPath))
        {
            return true;
        }
        
        String content = "";
        String logServerUrl = ConfigManager.getInstance().getValue("log.server.url");
        
        if (logServerUrl.toLowerCase().startsWith(ESDKConstant.PROTOCOL_ADAPTER_TYPE_HTTPS))
        {
            content = doUploadByHttpsURLConnection(logServerUrl, fileNameWithPath, product);
        }
        else
        {
            content = doUploadByHttpURLConnection(logServerUrl, fileNameWithPath, product);
        }
            
        
        if (content.contains("\"resultCode\":\"0\""))
        {
            return true;
        }
        else
        {
            LOGGER.warn("File file " + fileNameWithPath + " is uploaded to log server failed,"
                + " the response from server is " + content);
        }
        
        return false;
    }
    
    private String doUploadByHttpURLConnection(String logServerUrl, String fileNameWithPath, String product)
    {
        String boundary = UUID.randomUUID().toString();
        System.out.println(boundary);
        String crlf = "\r\n";
        String twoHyphens = "--";
        File file = new File(fileNameWithPath);
        InputStream responseStream = null;
        BufferedReader responseStreamReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection httpUrlConnection = null;
        ByteArrayOutputStream baos = null;
        GZIPOutputStream gzipOut = null;
        
        try
        {
            URL url = new URL(logServerUrl);
            httpUrlConnection = (HttpURLConnection)url.openConnection();
            httpUrlConnection.setUseCaches(false);
            httpUrlConnection.setDoOutput(true);
            
            httpUrlConnection.setRequestMethod("POST");
            httpUrlConnection.setRequestProperty("Connection", "Keep-Alive");
            httpUrlConnection.setRequestProperty("Cache-Control", "no-cache");
            httpUrlConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (gzip)
            {
                httpUrlConnection.setRequestProperty("Content-Encoding", "gzip");
            }
            
            DataOutputStream request = new DataOutputStream(httpUrlConnection.getOutputStream());
            //JSON String
            request.writeBytes(twoHyphens + boundary + crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"LogFileInfo\"" + crlf);
            request.writeBytes(crlf);
            request.writeBytes("{\"product\":\"" + product + "\"}");
            request.writeBytes(crlf);
            
            //Content wrapper
            request.writeBytes(twoHyphens + boundary + crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"LogFile\"; filename=\"" + file.getName() + "\""
                + crlf);
            request.writeBytes("Content-Type: text/plain" + crlf);
            request.writeBytes(crlf);
            
            //Write File content
            if (gzip)
            {
                baos = new ByteArrayOutputStream();  
                gzipOut = new GZIPOutputStream(baos);  
                gzipOut.write(FileUtils.readFileToByteArray(file));
                gzipOut.finish();
                request.write(baos.toByteArray());
            }
            else
            {
                request.write(FileUtils.readFileToByteArray(file));
            }
            
            //End content wrapper:
            request.writeBytes(crlf);
            request.writeBytes(twoHyphens + boundary + twoHyphens + crlf);
            
            //Flush output buffer:
            request.flush();
            request.close();
            
            int responseCode = httpUrlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK)
            {
                //Get Response
                responseStream = new BufferedInputStream(httpUrlConnection.getInputStream());
                
                responseStreamReader = new BufferedReader(new InputStreamReader(responseStream, "UTF-8"));
                
            }
            else if (responseCode == HttpURLConnection.HTTP_NOT_FOUND)
            {
                return HttpURLConnection.HTTP_NOT_FOUND + "";
            }
            else
            {
                return "";
            }
            String line = "";
            
            while ((line = responseStreamReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
        }
        catch (ClientProtocolException e)
        {
            LOGGER.error("", e);
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
        }
        finally
        {
            if (null != responseStreamReader)
            {
                try
                {
                    responseStreamReader.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("", e);
                }
            }
            if (null != responseStream)
            {
                try
                {
                    responseStream.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("", e);
                }
            }
            
            if (null != baos)
            {
                try
                {
                    baos.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("", e);
                }
            }
            
            if (null != gzipOut)
            {
                try
                {
                    gzipOut.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("", e);
                }
            }
        }
        
        if (null != httpUrlConnection)
        {
            httpUrlConnection.disconnect();
        }
        
        return stringBuilder.toString();
    }
    
    private String doUploadByHttpsURLConnection(String logServerUrl, String fileNameWithPath, String product)
    {
        String boundary = UUID.randomUUID().toString();
        System.out.println(boundary);
        String crlf = "\r\n";
        String twoHyphens = "--";
        File file = new File(fileNameWithPath);
        InputStream responseStream = null;
        BufferedReader responseStreamReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        HttpsURLConnection httpsUrlConnection = null;
        ByteArrayOutputStream baos = null;
        GZIPOutputStream gzipOut = null;
        
        try
        {
            HostnameVerifier hostnameVerifier = new HostnameVerifier() {

                @Override
                public boolean verify(String hostname, SSLSession session)
                {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
            
            SSLContext sslcontext = SSLContext.getInstance(SSL_SECURE_SOCKET_PROTOCOL);
            sslcontext.init(null, new TrustManager[] {myX509TrustManager}, null);
            
            URL url = new URL(logServerUrl);
            httpsUrlConnection = (HttpsURLConnection)url.openConnection();
            httpsUrlConnection.setSSLSocketFactory(sslcontext.getSocketFactory());
            httpsUrlConnection.setUseCaches(false);
            httpsUrlConnection.setDoOutput(true);
            
            httpsUrlConnection.setRequestMethod("POST");
            httpsUrlConnection.setRequestProperty("Connection", "Keep-Alive");
            httpsUrlConnection.setRequestProperty("Cache-Control", "no-cache");
            httpsUrlConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (gzip)
            {
                httpsUrlConnection.setRequestProperty("Content-Encoding", "gzip");
            }
            
            DataOutputStream request = new DataOutputStream(httpsUrlConnection.getOutputStream());
            //JSON String
            request.writeBytes(twoHyphens + boundary + crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"LogFileInfo\"" + crlf);
            request.writeBytes(crlf);
            request.writeBytes("{\"product\":\"" + product + "\"}");
            request.writeBytes(crlf);
            
            //Content wrapper
            request.writeBytes(twoHyphens + boundary + crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"LogFile\"; filename=\"" + file.getName() + "\""
                + crlf);
            request.writeBytes("Content-Type: text/plain" + crlf);
            request.writeBytes(crlf);
            
            //Write File content
            if (gzip)
            {
                baos = new ByteArrayOutputStream();  
                gzipOut = new GZIPOutputStream(baos);  
                gzipOut.write(FileUtils.readFileToByteArray(file));
                gzipOut.finish();
                request.write(baos.toByteArray());
            }
            else
            {
                request.write(FileUtils.readFileToByteArray(file));
            }
            
            //End content wrapper:
            request.writeBytes(crlf);
            request.writeBytes(twoHyphens + boundary + twoHyphens + crlf);
            
            //Flush output buffer:
            request.flush();
            request.close();
            
            int responseCode = httpsUrlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK)
            {
                //Get Response
                responseStream = new BufferedInputStream(httpsUrlConnection.getInputStream());
                
                responseStreamReader = new BufferedReader(new InputStreamReader(responseStream, "UTF-8"));
                
            }
            else if (responseCode == HttpURLConnection.HTTP_NOT_FOUND)
            {
                return HttpURLConnection.HTTP_NOT_FOUND + "";
            }
            else
            {
                return "";
            }
            String line = "";
            
            while ((line = responseStreamReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }
        }
        catch (ClientProtocolException e)
        {
            LOGGER.error("", e);
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
        }
        catch (NoSuchAlgorithmException e)
        {
            LOGGER.error("", e);
        }
        catch (KeyManagementException e)
        {
            LOGGER.error("", e);
        }
        finally
        {
            if (null != responseStreamReader)
            {
                try
                {
                    responseStreamReader.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("", e);
                }
            }
            
            if (null != responseStream)
            {
                try
                {
                    responseStream.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("", e);
                }
            }
            
            if (null != baos)
            {
                try
                {
                    baos.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("", e);
                }
            }
            
            if (null != gzipOut)
            {
                try
                {
                    gzipOut.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("", e);
                }
            }
        }
        
        if (null != httpsUrlConnection)
        {
            httpsUrlConnection.disconnect();
        }
        
        return stringBuilder.toString();
    }
    
    private static TrustManager myX509TrustManager = new X509TrustManager()
    {
        
        @Override
        public X509Certificate[] getAcceptedIssuers()
        {
            return new java.security.cert.X509Certificate[] {};
        }
        
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException
        {
        }
        
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException
        {
        }
    };
    
}
