package com.huawei.esdk.platform.abnormalevent.itf;

import com.huawei.esdk.platform.common.bean.abnormalevent.AbnormaleventBean;

public interface IAbnormalevent
{
    public final static String WRONG_FORMAT = "wrong.file.format";
    
    public final static String FAIL_TO_AUTHENTICATE = "fail.to.authenticate";
    
    public final static String FAIL_TO_CONNECT = "fail.to.connect";
    
    void occurException(String id,AbnormaleventBean bean);
    
    void endException(String id,AbnormaleventBean bean);
    
    boolean existException(String id);
    
}
