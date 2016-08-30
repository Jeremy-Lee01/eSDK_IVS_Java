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
 * 2014-02-17T19:55:03.863+08:00
 * Generated source version: 2.6.10
 * 
 */
@WebService(targetNamespace = "esdk_ivs_professional_server", name = "IVSProfessional.RecordManager")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface IVSProfessionalRecordManager {

    @WebResult(name = "queryRecordListResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.queryRecordList")
    public QueryRecordListResponse queryRecordList(
        @WebParam(partName = "parameters", name = "queryRecordList", targetNamespace = "esdk_ivs_professional_server")
        QueryRecordList parameters
    );

    @WebResult(name = "getRecordPlanResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.getRecordPlan")
    public GetRecordPlanResponse getRecordPlan(
        @WebParam(partName = "parameters", name = "getRecordPlan", targetNamespace = "esdk_ivs_professional_server")
        GetRecordPlan parameters
    );

    @WebResult(name = "getRecordListResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.getRecordList")
    public GetRecordListResponse getRecordList(
        @WebParam(partName = "parameters", name = "getRecordList", targetNamespace = "esdk_ivs_professional_server")
        GetRecordList parameters
    );

    @WebResult(name = "deleteRecordPlanResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.deleteRecordPlan")
    public DeleteRecordPlanResponse deleteRecordPlan(
        @WebParam(partName = "parameters", name = "deleteRecordPlan", targetNamespace = "esdk_ivs_professional_server")
        DeleteRecordPlan parameters
    );

    @WebResult(name = "modifyRecordPlanResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.modifyRecordPlan")
    public ModifyRecordPlanResponse modifyRecordPlan(
        @WebParam(partName = "parameters", name = "modifyRecordPlan", targetNamespace = "esdk_ivs_professional_server")
        ModifyRecordPlan parameters
    );

    @WebResult(name = "addRecordPlanResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.addRecordPlan")
    public AddRecordPlanResponse addRecordPlan(
        @WebParam(partName = "parameters", name = "addRecordPlan", targetNamespace = "esdk_ivs_professional_server")
        AddRecordPlan parameters
    );
}
