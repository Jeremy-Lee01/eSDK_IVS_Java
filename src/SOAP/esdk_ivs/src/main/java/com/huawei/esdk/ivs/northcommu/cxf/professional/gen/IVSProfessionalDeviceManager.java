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
 * 2014-02-17T19:55:03.829+08:00
 * Generated source version: 2.6.10
 * 
 */
@WebService(targetNamespace = "esdk_ivs_professional_server", name = "IVSProfessional.DeviceManager")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface IVSProfessionalDeviceManager {

    @WebResult(name = "setCameraNameResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.setCameraName")
    public SetCameraNameResponse setCameraName(
        @WebParam(partName = "parameters", name = "setCameraName", targetNamespace = "esdk_ivs_professional_server")
        SetCameraName parameters
    );

    @WebResult(name = "getDomainRouteResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.getDomainRoute")
    public GetDomainRouteResponse getDomainRoute(
        @WebParam(partName = "parameters", name = "getDomainRoute", targetNamespace = "esdk_ivs_professional_server")
        GetDomainRoute parameters
    );

    @WebResult(name = "getDeviceListResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.getDeviceList")
    public GetDeviceListResponse getDeviceList(
        @WebParam(partName = "parameters", name = "getDeviceList", targetNamespace = "esdk_ivs_professional_server")
        GetDeviceList parameters
    );

    @WebResult(name = "addDeviceResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.addDevice")
    public AddDeviceResponse addDevice(
        @WebParam(partName = "parameters", name = "addDevice", targetNamespace = "esdk_ivs_professional_server")
        AddDevice parameters
    );

    @WebResult(name = "rebootDeviceResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.rebootDevice")
    public RebootDeviceResponse rebootDevice(
        @WebParam(partName = "parameters", name = "rebootDevice", targetNamespace = "esdk_ivs_professional_server")
        RebootDevice parameters
    );

    @WebResult(name = "stopSearchDeviceResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.stopSearchDevice")
    public StopSearchDeviceResponse stopSearchDevice(
        @WebParam(partName = "parameters", name = "stopSearchDevice", targetNamespace = "esdk_ivs_professional_server")
        StopSearchDevice parameters
    );

    @WebResult(name = "startSearchDeviceResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.startSearchDevice")
    public StartSearchDeviceResponse startSearchDevice(
        @WebParam(partName = "parameters", name = "startSearchDevice", targetNamespace = "esdk_ivs_professional_server")
        StartSearchDevice parameters
    );

    @WebResult(name = "getDeviceConfigResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.getDeviceConfig")
    public GetDeviceConfigResponse getDeviceConfig(
        @WebParam(partName = "parameters", name = "getDeviceConfig", targetNamespace = "esdk_ivs_professional_server")
        GetDeviceConfig parameters
    );

    @WebResult(name = "setDeviceConfigResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.setDeviceConfig")
    public SetDeviceConfigResponse setDeviceConfig(
        @WebParam(partName = "parameters", name = "setDeviceConfig", targetNamespace = "esdk_ivs_professional_server")
        SetDeviceConfig parameters
    );

    @WebResult(name = "setMainDeviceNameResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.setMainDeviceName")
    public SetMainDeviceNameResponse setMainDeviceName(
        @WebParam(partName = "parameters", name = "setMainDeviceName", targetNamespace = "esdk_ivs_professional_server")
        SetMainDeviceName parameters
    );

    @WebResult(name = "queryDeviceListResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.queryDeviceList")
    public QueryDeviceListResponse queryDeviceList(
        @WebParam(partName = "parameters", name = "queryDeviceList", targetNamespace = "esdk_ivs_professional_server")
        QueryDeviceList parameters
    );

    @WebResult(name = "deleteDeviceResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.deleteDevice")
    public DeleteDeviceResponse deleteDevice(
        @WebParam(partName = "parameters", name = "deleteDevice", targetNamespace = "esdk_ivs_professional_server")
        DeleteDevice parameters
    );

    @WebResult(name = "getDeviceGroupResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.getDeviceGroup")
    public GetDeviceGroupResponse getDeviceGroup(
        @WebParam(partName = "parameters", name = "getDeviceGroup", targetNamespace = "esdk_ivs_professional_server")
        GetDeviceGroup parameters
    );

    @WebResult(name = "verifyDeviceResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.verifyDevice")
    public VerifyDeviceResponse verifyDevice(
        @WebParam(partName = "parameters", name = "verifyDevice", targetNamespace = "esdk_ivs_professional_server")
        VerifyDevice parameters
    );
    
    @WebResult(name = "getVideoDiagnoseResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.getVideoDiagnose")
    public GetVideoDiagnoseResponse getVideoDiagnose(
        @WebParam(partName = "parameters", name = "getVideoDiagnose", targetNamespace = "esdk_ivs_professional_server")
        GetVideoDiagnose parameters
    );

    @WebResult(name = "setVideoDiagnoseResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.setVideoDiagnose")
    public SetVideoDiagnoseResponse setVideoDiagnose(
        @WebParam(partName = "parameters", name = "setVideoDiagnose", targetNamespace = "esdk_ivs_professional_server")
        SetVideoDiagnose parameters
    );
}
