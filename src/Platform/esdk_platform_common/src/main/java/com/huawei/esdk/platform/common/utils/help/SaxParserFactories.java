package com.huawei.esdk.platform.common.utils.help;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;

public class SaxParserFactories
{
    private static final Logger LOGGER = Logger.getLogger(SaxParserFactories.class);
    
    private SaxParserFactories()
    {
    }
    
    public static SAXParserFactory newSecurityInstance()
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try
        {
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        }
        catch (Exception ex)
        {
            LOGGER.error("FAILED to set feature http://xml.org/sax/features/external-general-entities to false", ex);
        }
        try
        {
            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        }
        catch (Exception ex)
        {
            LOGGER.error("FAILED to set feature http://xml.org/sax/features/external-parameter-entities to false", ex);
        }
        try
        {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        }
        catch (Exception ex)
        {
            LOGGER.error("FAILED to set feature XMLConstants.FEATURE_SECURE_PROCESSING to true", ex);
        }
        
        return factory;
    }
}
