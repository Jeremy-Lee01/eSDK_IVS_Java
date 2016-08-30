package com.huawei.esdk.platform.common.utils.help;

import javax.xml.stream.XMLInputFactory;

import org.apache.log4j.Logger;

public final class XmlInputFactories
{
    private static final Logger LOGGER = Logger.getLogger(XmlInputFactories.class);
    
    private XmlInputFactories()
    {
    }
    
    public static XMLInputFactory newSecurityInstance()
    {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try
        {
            factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        }
        catch (Exception ex)
        {
            LOGGER.error("FAILED to set XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES to false", ex);
        }
        
        try
        {
            factory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);
        }
        catch (Exception ex)
        {
            LOGGER.error("FAEILD to set XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES to false", ex);
        }
        
        return factory;
    }
}
