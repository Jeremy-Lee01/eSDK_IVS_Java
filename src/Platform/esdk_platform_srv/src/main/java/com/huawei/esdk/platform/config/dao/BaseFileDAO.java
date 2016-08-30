package com.huawei.esdk.platform.config.dao;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultElement;

public class BaseFileDAO
{
//    protected IFileService fileService;
    
    public BaseFileDAO()
    {
//        fileService = FileService.getInstance();
    }
    
    protected Element buildElement(String name, String value)
    {
        Element ele = new DefaultElement(name);
        ele.setText(value);
        return ele;
    }
    
    protected void writeXmlFile(Document document, String file)
        throws IOException
    {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        
        XMLWriter writer;
        writer = new XMLWriter(new FileOutputStream(file), format);
        writer.write(document);
        writer.close();
        
        synFile(file);
    }
    
    protected void synFile(String file)
    {
        //        String destDir = ConfigManager.getInstance().getValue("file.sync.driver");
        //        if (!StringUtils.isEmpty(destDir) && !fileService.synFile(destDir, file))
        //        {
        //        	PrinterUtils.println(I18nPropUtils.getValue("msg.syn.file.failed",
        //                    new String[]
        //                    { PropertiesUtils.getValue("file.sync.driver") }));
        //        }
    }
}
