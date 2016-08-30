package com.huawei.esdk.platform.common.utils.help;

import java.io.InputStream;
import java.io.Reader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public final class SaxSources
{
    private SaxSources()
    {
    }
    
    public static SAXSource newSecurityUnmarshalSource(InputStream in)
        throws ParserConfigurationException, SAXException
    {
        return newSecurityUnmarshalSource(new InputSource(in));
    }
    
    public static SAXSource newSecurityUnmarshalSource(Reader reader)
        throws ParserConfigurationException, SAXException
    {
        return newSecurityUnmarshalSource(new InputSource(reader));
    }
    
    public static SAXSource newSecurityUnmarshalSource(InputSource inputSource)
        throws ParserConfigurationException, SAXException
    {
        SAXParserFactory factory = SaxParserFactories.newSecurityInstance();
        // as followed copy from javax.xml.bind.helpers.AbstractUnmarshallerImpl.getXMLReader()
        factory.setNamespaceAware(true);
        // there is no point in asking a validation because there is no guarantee that the document will come with a proper schemaLocation.
        factory.setValidating(false);
        XMLReader xmlReader = factory.newSAXParser().getXMLReader();
        SAXSource saxSource = new SAXSource(xmlReader, inputSource);
        
        return saxSource;
    }
}
