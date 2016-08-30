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
package com.huawei.esdk.ivs.northcommu.cxf.professional.gen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.10
 * 2014-02-17T19:55:03.727+08:00
 * Generated source version: 2.6.10
 * 
 */
@WebService(targetNamespace = "esdk_ivs_professional_server", name = "IVSProfessional.Common")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface IVSProfessionalCommon {

    @WebResult(name = "registerNotificationResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.registerNotification")
    public RegisterNotificationResponse registerNotification(
        @WebParam(partName = "parameters", name = "registerNotification", targetNamespace = "esdk_ivs_professional_server")
        RegisterNotification parameters
    );

    @WebResult(name = "keepAliveResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.keepAlive")
    public KeepAliveResponse keepAlive(
        @WebParam(partName = "parameters", name = "keepAlive", targetNamespace = "esdk_ivs_professional_server")
        KeepAlive parameters
    );

    @WebResult(name = "loginResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.login")
    public LoginResponse login(
        @WebParam(partName = "parameters", name = "login", targetNamespace = "esdk_ivs_professional_server")
        Login parameters
    );

    @WebResult(name = "getVersionResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.getVersion")
    public GetVersionResponse getVersion(
        @WebParam(partName = "parameters", name = "getVersion", targetNamespace = "esdk_ivs_professional_server")
        GetVersion parameters
    );

    @WebResult(name = "logoutResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.logout")
    public LogoutResponse logout(
        @WebParam(partName = "parameters", name = "logout", targetNamespace = "esdk_ivs_professional_server")
        Logout parameters
    );
}
