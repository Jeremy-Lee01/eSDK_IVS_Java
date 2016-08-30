/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.ivs.test.utils;

import javax.net.ssl.SSLHandshakeException;
import javax.xml.ws.soap.SOAPFaultException;

import com.huawei.esdk.ivs.test.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.test.constant.NativeConstant;


public abstract class ExceptionUtils
{
    public static void processSoapException(IVSSDKResponse<? extends Object> resp, Exception e)
    {
        if (e instanceof SOAPFaultException)
        {
            String faultCodeString = ((SOAPFaultException)e).getFault().getFaultCode();
            String faultString = ((SOAPFaultException)e).getFault().getFaultString();
            if (faultCodeString.contains(":"))
            {
                String[] faultCodeStringArr = faultCodeString.split(":");
                if (faultCodeStringArr[1].equals(String.valueOf(NativeConstant.AUTHORIZE_ERRORCODE)))
                {
                    resp.setResultCode(NativeConstant.AUTHORIZE_ERRORCODE);
                }
                else if (faultCodeStringArr[1].equals(String.valueOf(NativeConstant.SYSTEM_ERRORCODE)))
                {
                    resp.setResultCode(NativeConstant.SYSTEM_ERRORCODE);
                }
                else if (faultCodeStringArr[1].equals(String.valueOf(NativeConstant.ACCOUNT_LOCKED)))
                {
                    resp.setResultCode(NativeConstant.ACCOUNT_LOCKED);
                }
                else if (faultCodeString.equals("soap:Client") && faultString.contains("Unmarshalling Error"))
                {
                    //					if (faultString.contains("is expected")) 
                    //					{
                    //
                    //						resp.setResultCode(NativeConstant.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                    //					} 
                    //					else 
                    //					{
                    resp.setResultCode(NativeConstant.SDK_DATA_INCORRECT_ERRORCODE);
                    //					}
                }
                else if (faultString.contains("Connection refused: connect")
                    || faultString.contains("Connection reset")) // || e.getMessage().contains("Could not send Message")
                {
                    resp.setResultCode(NativeConstant.ERROR_CODE_NETWORK_ERROR);
                }
                else if (faultString.contains("handshake_failure")
                    || faultString.contains("trustAnchors parameter must be non-empty"))
                {
                    resp.setResultCode(NativeConstant.SSL_HANDSHAKE_FAILURE);
                }
                else
                {
                    resp.setResultCode(NativeConstant.NATIVE_EXCEPTION);
                }
            }
            else
            {
                resp.setResultCode(NativeConstant.NATIVE_EXCEPTION);
            }
        }
        else
        {
            if (e.getCause() instanceof SSLHandshakeException)
            {
                resp.setResultCode(NativeConstant.SSL_HANDSHAKE_FAILURE);
            }
            else if (null != e.getCause().getMessage() && e.getCause().getMessage().contains("no protocol"))
            {
                resp.setResultCode(NativeConstant.NATIVE_URL_FORMAT_ERRORCODE);
            }
            else if (e.getMessage().contains("Could not send Message"))
            {
                resp.setResultCode(NativeConstant.ERROR_CODE_NETWORK_ERROR);
            }
            else
            {
                resp.setResultCode(NativeConstant.NATIVE_EXCEPTION);
            }
        }
        
    }
    
    public static Integer processSoapException(Exception e)
    {
        try
        {
            if (e instanceof SOAPFaultException)
            {
                String faultCodeString = ((SOAPFaultException)e).getFault().getFaultCode();
                String faultString = ((SOAPFaultException)e).getFault().getFaultString();
                
                if (null == faultString)
                {
                    faultString = "";
                }
                
                if (null == faultCodeString)
                {
                    faultCodeString = "";
                }
                
                if (faultCodeString.contains(":"))
                {
                    String[] faultCodeStringArr = faultCodeString.split(":");
                    if (faultCodeStringArr[1].equals(String.valueOf(NativeConstant.AUTHORIZE_ERRORCODE)))
                    {
                        return NativeConstant.AUTHORIZE_ERRORCODE;
                    }
                    else if (faultCodeStringArr[1].equals(String.valueOf(NativeConstant.SYSTEM_ERRORCODE)))
                    {
                        return NativeConstant.SYSTEM_ERRORCODE;
                    }
                    else if (faultCodeString.equals("soap:Client") && faultString.contains("Unmarshalling Error"))
                    {
                        return NativeConstant.SDK_DATA_INCORRECT_ERRORCODE;
                    }
                    else if (faultString.equals("Connection refused: connect")
                        || faultString.contains("Connection reset")) // || faultString.contains("Could not send Message")
                    {
                        return NativeConstant.ERROR_CODE_NETWORK_ERROR;
                    }
                    else if (faultString.contains("handshake_failure")
                        || faultString.contains("trustAnchors parameter must be non-empty"))
                    {
                        return NativeConstant.SSL_HANDSHAKE_FAILURE;
                    }
                    else
                    {
                        
                        try
                        {
                            String soapErrorCode = faultCodeStringArr[1];
                            int returnCode = Integer.parseInt(soapErrorCode);
                            return returnCode;
                            
                        }
                        catch (Exception ex)
                        {
                            return NativeConstant.NATIVE_EXCEPTION;
                        }
                        
                    }
                }
                else
                {
                    return NativeConstant.NATIVE_EXCEPTION;
                }
            }
            else
            {
                if (e.getCause() instanceof SSLHandshakeException)
                {
                    return NativeConstant.SSL_HANDSHAKE_FAILURE;
                }
                else if (null != e.getCause().getMessage() && e.getCause().getMessage().contains("no protocol"))
                {
                    return NativeConstant.NATIVE_URL_FORMAT_ERRORCODE;
                }
                else if (e.getMessage().contains("Could not send Message"))
                {
                    return NativeConstant.ERROR_CODE_NETWORK_ERROR;
                }
                else if (e.getMessage().contains("Could not start Jetty server")
                    || e.getMessage().contains("ServiceConstructionException"))
                {
                    return NativeConstant.REDEGIT_CALLBAK_ERRORCODE;
                }
                else
                {
                    return NativeConstant.NATIVE_EXCEPTION;
                }
            }
        }
        catch (Exception ee)
        {
            return NativeConstant.NATIVE_EXCEPTION;
        }
    }
}
