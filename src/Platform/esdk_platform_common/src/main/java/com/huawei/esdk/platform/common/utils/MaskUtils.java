package com.huawei.esdk.platform.common.utils;

public class MaskUtils
{
    public static String mask(String content, String words)
    {
        if (StringUtils.isEmpty(words))
        {
            return content;
        }
        
        String[] sensitiveWords = words.split(",");

        for (String word : sensitiveWords)
        {
            content = replaceSensitiveWords(content, word);
        }
        return content;
    }

    private static String replaceSensitiveWords(String strBuffer, String word)
    {
        int startIndex = 0;
        while (true)
        {
            if (-1 == strBuffer.indexOf("<" + word + " ", startIndex) 
                && -1 == strBuffer.indexOf("<" + word + ">", startIndex))
            {
                break;
            }
            else
            {
                int node1Begin = strBuffer.indexOf("<" + word, startIndex);
                int node1End = strBuffer.indexOf(">", node1Begin) + 1;
                String node1 = strBuffer.substring(node1Begin, node1End);
                
                int begin = node1End;
                
                int end = strBuffer.indexOf("</" + word + ">",startIndex);
                if (begin < end)
                {
                    String exp = strBuffer.substring(begin, end);
                    StringBuffer rep = new StringBuffer(node1);
                    for (int i = 0; i < exp.length(); i++)
                    {
                        rep.append("*");
                    }
                    rep.append("</" + word + ">");
                    strBuffer = strBuffer.replace(node1 + exp + "</" + word
                            + ">", rep);
                    startIndex = end + word.length() + 3;
                }
                else
                {
                    startIndex = begin;
                }
                
            }
        }

        return strBuffer;
    }
    
    public static String maskXMLElementValue(String srcXML, String maskElement)
    {
        return maskXMLElementValue(srcXML, maskElement, '*');
    }
    
    public static String maskXMLElementValue(String srcXML, String maskElements, char maskChar)
    {
        if (StringUtils.isEmpty(srcXML) || StringUtils.isEmpty(maskElements))
        {
            return srcXML;
        }
        
        String[] words = maskElements.trim().split(",");
        String result = srcXML;
        for (String word : words)
        {
            if (StringUtils.isEmpty(word) || "null".equals(word))
            {
                continue;
            }
            result = doMaskXMLEle(result, word, '*');
        }
        
        return result;
    }
    
    private static String doMaskXMLEle(String srcXML, String maskElement, char maskChar)
    {
        
        return replaceSensitiveWords(srcXML, maskElement);
    }
    
    public static String maskJson(String content, String words)
    {
        if (StringUtils.isEmpty(words))
        {
            return content;
        }
        
        String[] sensitiveWords = words.split(",");

        for (String word : sensitiveWords)
        {
            content = replaceJsonSensitiveWords(content, word);
        }
        return content;
    }
    
    private static String replaceJsonSensitiveWords(String strBuffer, String word)
    {
        int startIndex = 0;
        int begin;
        int end;
        while (true)
        {
            if (-1 == strBuffer.indexOf("\"" + word + "\":\"", startIndex))
            {
                break;
            }
            else
            {
                begin = strBuffer.indexOf("\"" + word + "\"", startIndex) + word.length() + 4;
                if (0 == startIndex)
                {
                    startIndex = begin;
                }
                end = strBuffer.indexOf("\"", startIndex);
                if (begin != end)
                {
                    String exp = strBuffer.substring(begin, end);
                    StringBuffer rep = new StringBuffer("\"" + word + "\":\"");
                    for (int i = 0; i < exp.length(); i++)
                    {
                        rep.append("*");
                    }
                    rep.append("\"");
                    strBuffer = strBuffer.replace("\"" + word + "\":\"" + exp + "\"", rep);
                }
                
                startIndex = end + word.length() + 3;
            }
        }

        return strBuffer;
    }
}
