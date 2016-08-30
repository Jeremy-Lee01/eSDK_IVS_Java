package com.huawei.esdk.platform.commu;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.AES128System;

public class ESDKAuthenticator extends Authenticator
{
    private static final Logger DEBUGGER = Logger.getLogger(Authenticator.class);

    public PasswordAuthentication getPasswordAuthentication()
    {
        DEBUGGER.debug("getRequestingHost()=" + getRequestingHost());
        DEBUGGER.debug("Feeding username and password for "
                + getRequestingScheme());
        String encryptPwd = ConfigManager.getInstance().getValue("sms.http.gateway.user.pwd");
        String pwd = null;
        pwd = AES128System.decryptPwdByOldKey("", encryptPwd);
        if (null == pwd)
        {
            pwd = encryptPwd;
        }
        
        return (new PasswordAuthentication(
                ConfigManager.getInstance().getValue("sms.http.gateway.user.id"),
                pwd.toCharArray()));
    }
}
