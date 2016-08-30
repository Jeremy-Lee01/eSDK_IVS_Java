package com.huawei.esdk.platform.servlet;

import org.apache.cxf.transport.servlet.CXFServlet;

import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.constants.ESDKConstant;

import javax.servlet.*;
import javax.servlet.http.*;

public class ESDKCallbackCXFServlet extends CXFServlet
{
    /**
     * UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * To override the super method in order to retrieve the appId and deviceId.
     * * @see org.apache.cxf.transport.servlet.AbstractHTTPServlet#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException
    {
        String appId = request.getParameter(ESDKConstant.APP_ID);
        String deviceId = request.getParameter(ESDKConstant.DEVICE_ID);
        ThreadLocalHolder.put(ESDKConstant.APP_ID, appId);
        ThreadLocalHolder.put(ESDKConstant.DEVICE_ID, deviceId);
        
        super.handleRequest(request, response);
    }
}
