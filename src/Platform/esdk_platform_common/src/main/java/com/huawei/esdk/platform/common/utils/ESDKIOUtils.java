package com.huawei.esdk.platform.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 * 
 * eSDK IO操作的工具类 
 *
 * @author  z00209306
 * @since  eSDK Solutions Platform V100R003C00
 */
public abstract class ESDKIOUtils
{
    private static final Logger LOGGER = Logger.getLogger(ESDKIOUtils.class);
    
    /**
     * 
     * 从classpath下的文件中获取文件内容
     *
     * @param fileName 文件名
     * @return 文件内容
     * @since eSDK Solutions Platform V100R003C00
     */
    public static String getClasspathFileContent(String fileName)
    {
        return getClasspathFileContent(fileName, "UTF-8");
    }
    
    /**
     * 
     * 从classpath下的文件中获取文件内容
     *
     * @param fileName 文件名
     * @param fileEncode 文件编码
     * @return 文件内容
     * @since eSDK Solutions Platform V100R003C00
     */
    public static String getClasspathFileContent(String fileName, String fileEncode)
    {
        InputStream in = null;
        StringWriter writer = new StringWriter();
        try
        {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            IOUtils.copy(in, writer, fileEncode);
        }
        catch (IOException e)
        {
            LOGGER.error("File load failed[fileName=" + fileName + "]", e);
        }
        finally
        {
            try
            {
                if (null != in)
                {
                    in.close();
                }
            }
            catch (IOException e)
            {
                LOGGER.error("", e);
            }
        }
        
        return writer.toString();
    }
    
    public static void closeReader(Reader reader)
    {
        try
        {
            if (null != reader)
            {
                reader.close();
            }
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
        }
    }
    
    public static void closeInputStream(InputStream is)
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
            LOGGER.error("", e);
        }
    }
    
    public static void closeOutputStream(OutputStream out)
    {
        try
        {
            if (null != out)
            {
                out.close();
            }
        }
        catch (IOException e)
        {
            LOGGER.error("", e);
        }
    }
}
