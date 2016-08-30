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
package com.huawei.esdk.ivs.professional.local.impl.autogen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.huawei.esdk.ivs.professional.local.bean.AlarmEvent;
import com.huawei.esdk.ivs.professional.local.bean.AlarmEventInfos;
import com.huawei.esdk.ivs.professional.local.bean.AlarmLevel;
import com.huawei.esdk.ivs.professional.local.bean.AlarmLevelList;
import com.huawei.esdk.ivs.professional.local.bean.AlarmTypeInfos;
import com.huawei.esdk.ivs.professional.local.bean.QueryUnifiedFormat;

/**
 * This class was generated by Apache CXF 2.6.10
 * 2014-01-06T23:40:36.066+08:00
 * Generated source version: 2.6.10
 * 
 */
@WebService(targetNamespace = "esdk_ivs_professional_server", name = "IVSProfessional.AlarmManager")
@XmlSeeAlso({ObjectFactory.class})
public interface IVSProfessionalAlarmManager {

    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "alarmCommission", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.AlarmCommission")
    @WebMethod(action = "esdk_ivs_professional_server.alarmCommission")
    @ResponseWrapper(localName = "alarmCommissionResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.AlarmCommissionResponse")
    public java.lang.Integer alarmCommission(
        @WebParam(name = "alarmInCode", targetNamespace = "")
        java.lang.String alarmInCode,
        @WebParam(name = "alarmCommissionInfo", targetNamespace = "")
        com.huawei.esdk.ivs.professional.local.bean.AlarmCommissionInfo alarmCommissionInfo
    );

    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "alarmConfirm", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.AlarmConfirm")
    @WebMethod(action = "esdk_ivs_professional_server.alarmConfirm")
    @ResponseWrapper(localName = "alarmConfirmResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.AlarmConfirmResponse")
    public java.lang.Integer alarmConfirm(
        @WebParam(name = "alarmEventId", targetNamespace = "")
        long alarmEventId,
        @WebParam(name = "alarmInCode", targetNamespace = "")
        java.lang.String alarmInCode,
        @WebParam(name = "operateInfo", targetNamespace = "")
        com.huawei.esdk.ivs.professional.local.bean.AlarmOperateInfo operateInfo
    );

    @RequestWrapper(localName = "getAlarmLinkageAction", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmLinkageAction")
    @WebMethod(action = "esdk_ivs_professional_server.getAlarmLinkageAction")
    @ResponseWrapper(localName = "getAlarmLinkageActionResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmLinkageActionResponse")
    public void getAlarmLinkageAction(
        @WebParam(name = "requestXML", targetNamespace = "")
        java.lang.String requestXML,
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "responseXML", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.String> responseXML
    );

    @RequestWrapper(localName = "getAlarmLinkageList", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmLinkageList")
    @WebMethod(action = "esdk_ivs_professional_server.getAlarmLinkageList")
    @ResponseWrapper(localName = "getAlarmLinkageListResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmLinkageListResponse")
    public void getAlarmLinkageList(
        @WebParam(name = "requestXML", targetNamespace = "")
        java.lang.String requestXML,
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "responseXML", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.String> responseXML
    );

    @RequestWrapper(localName = "getAlarmEventList", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmEventList")
    @WebMethod(action = "esdk_ivs_professional_server.getAlarmEventList")
    @ResponseWrapper(localName = "getAlarmEventListResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmEventListResponse")
    public void getAlarmEventList(
        @WebParam(name = "unifiedQuery", targetNamespace = "")
        com.huawei.esdk.ivs.professional.local.bean.QueryUnifiedFormat unifiedQuery,
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "alarmEventInfos", targetNamespace = "")
        javax.xml.ws.Holder<AlarmEventInfos> alarmEventInfos
    );

    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "stopAlarmOut", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.StopAlarmOut")
    @WebMethod(action = "esdk_ivs_professional_server.stopAlarmOut")
    @ResponseWrapper(localName = "stopAlarmOutResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.StopAlarmOutResponse")
    public java.lang.Integer stopAlarmOut(
        @WebParam(name = "alarmOutCode", targetNamespace = "")
        java.lang.String alarmOutCode
    );

    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "deleteAlarmLinkage", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.DeleteAlarmLinkage")
    @WebMethod(action = "esdk_ivs_professional_server.deleteAlarmLinkage")
    @ResponseWrapper(localName = "deleteAlarmLinkageResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.DeleteAlarmLinkageResponse")
    public java.lang.Integer deleteAlarmLinkage(
        @WebParam(name = "requestXML", targetNamespace = "")
        java.lang.String requestXML
    );

    @RequestWrapper(localName = "addAlarmLinkage", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.AddAlarmLinkage")
    @WebMethod(action = "esdk_ivs_professional_server.addAlarmLinkage")
    @ResponseWrapper(localName = "addAlarmLinkageResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.AddAlarmLinkageResponse")
    public void addAlarmLinkage(
        @WebParam(name = "requestXML", targetNamespace = "")
        java.lang.String requestXML,
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "responseXML", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.String> responseXML
    );

    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "modifyAlarmLinkage", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.ModifyAlarmLinkage")
    @WebMethod(action = "esdk_ivs_professional_server.modifyAlarmLinkage")
    @ResponseWrapper(localName = "modifyAlarmLinkageResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.ModifyAlarmLinkageResponse")
    public java.lang.Integer modifyAlarmLinkage(
        @WebParam(name = "requestXML", targetNamespace = "")
        java.lang.String requestXML
    );

    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "alarmReport", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.AlarmReport")
    @WebMethod(action = "esdk_ivs_professional_server.alarmReport")
    @ResponseWrapper(localName = "alarmReportResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.AlarmReportResponse")
    public java.lang.Integer alarmReport(
        @WebParam(name = "alarmReportInfo", targetNamespace = "")
        com.huawei.esdk.ivs.professional.local.bean.AlarmReportInfo alarmReportInfo
    );

    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "startAlarmOut", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.StartAlarmOut")
    @WebMethod(action = "esdk_ivs_professional_server.startAlarmOut")
    @ResponseWrapper(localName = "startAlarmOutResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.StartAlarmOutResponse")
    public java.lang.Integer startAlarmOut(
        @WebParam(name = "alarmOutCode", targetNamespace = "")
        java.lang.String alarmOutCode
    );

    @RequestWrapper(localName = "getAlarmLinkage", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmLinkage")
    @WebMethod(action = "esdk_ivs_professional_server.getAlarmLinkage")
    @ResponseWrapper(localName = "getAlarmLinkageResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmLinkageResponse")
    public void getAlarmLinkage(
        @WebParam(name = "requestXML", targetNamespace = "")
        java.lang.String requestXML,
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "responseXML", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.String> responseXML
    );

    @RequestWrapper(localName = "subscribeAlarmQuery", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.SubscribeAlarmQuery")
    @WebMethod(action = "esdk_ivs_professional_server.subscribeAlarmQuery")
    @ResponseWrapper(localName = "subscribeAlarmQueryResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.SubscribeAlarmQueryResponse")
    public void subscribeAlarmQuery(
        @WebParam(name = "requestXML", targetNamespace = "")
        java.lang.String requestXML,
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "responseXML", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.String> responseXML
    );

    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "subscribeAlarm", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.SubscribeAlarm")
    @WebMethod(action = "esdk_ivs_professional_server.subscribeAlarm")
    @ResponseWrapper(localName = "subscribeAlarmResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.SubscribeAlarmResponse")
    public java.lang.Integer subscribeAlarm(
        @WebParam(name = "requestXML", targetNamespace = "")
        java.lang.String requestXML
    );

    @RequestWrapper(localName = "getAlarmEventInfo", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmEventInfo")
    @WebMethod(action = "esdk_ivs_professional_server.getAlarmEventInfo")
    @ResponseWrapper(localName = "getAlarmEventInfoResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmEventInfoResponse")
    public void getAlarmEventInfo(
        @WebParam(name = "alarmEventId", targetNamespace = "")
        long alarmEventId,
        @WebParam(name = "alarmInCode", targetNamespace = "")
        java.lang.String alarmInCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "alarmEvent", targetNamespace = "")
        javax.xml.ws.Holder<AlarmEvent> alarmEvent
    );

    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "alarmCancel", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.AlarmCancel")
    @WebMethod(action = "esdk_ivs_professional_server.alarmCancel")
    @ResponseWrapper(localName = "alarmCancelResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.AlarmCancelResponse")
    public java.lang.Integer alarmCancel(
        @WebParam(name = "alarmEventId", targetNamespace = "")
        long alarmEventId,
        @WebParam(name = "alarmInCode", targetNamespace = "")
        java.lang.String alarmInCode,
        @WebParam(name = "operateInfo", targetNamespace = "")
        com.huawei.esdk.ivs.professional.local.bean.AlarmOperateInfo operateInfo
    );
    
    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "userAuthentication", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.UserAuthentication")
    @WebMethod(action = "esdk_ivs_professional_server.userAuthentication")
    @ResponseWrapper(localName = "userAuthenticationResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.UserAuthenticationResponse")
    public java.lang.Integer userAuthentication(
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );
    
    @RequestWrapper(localName = "getAlarmLevelList", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.bean.GetAlarmLevelList")
    @WebMethod(action = "esdk_ivs_professional_server.getAlarmLevelList")
    @ResponseWrapper(localName = "getAlarmLevelListResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.bean.GetAlarmLevelListResponse")
    public void getAlarmLevelList(
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "alarmLevelNum", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> alarmLevelNum,
        @WebParam(mode = WebParam.Mode.OUT, name = "alarmLevelList", targetNamespace = "")
        javax.xml.ws.Holder<AlarmLevelList> alarmLevelList
    );

    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "setAlarmTypeLevel", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.SetAlarmTypeLevel")
    @WebMethod(action = "esdk_ivs_professional_server.setAlarmTypeLevel")
    @ResponseWrapper(localName = "setAlarmTypeLevelResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.SetAlarmTypeLevelResponse")
    public java.lang.Integer setAlarmTypeLevel(
        @WebParam(name = "alarmTypeInfos", targetNamespace = "")
        AlarmTypeInfos alarmTypeInfos
    );
    
    @RequestWrapper(localName = "getAlarmTypeList", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmTypeList")
    @WebMethod(action = "esdk_ivs_professional_server.getAlarmTypeList")
    @ResponseWrapper(localName = "getAlarmTypeListResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmTypeListResponse")
    public void getAlarmTypeList(
        @WebParam(name = "unifiedQuery", targetNamespace = "")
        QueryUnifiedFormat unifiedQuery,
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "alarmTypeInfos", targetNamespace = "")
        javax.xml.ws.Holder<AlarmTypeInfos> alarmTypeInfos
    );
    
    @RequestWrapper(localName = "getAlarmLevel", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmLevel")
    @WebMethod(action = "esdk_ivs_professional_server.getAlarmLevel")
    @ResponseWrapper(localName = "getAlarmLevelResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmLevelResponse")
    public void getAlarmLevel(
        @WebParam(name = "alarmLevelID", targetNamespace = "")
        java.lang.Integer alarmLevelID,
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "alarmLevel", targetNamespace = "")
        javax.xml.ws.Holder<AlarmLevel> alarmLevel
    );
    
    @RequestWrapper(localName = "getAlarmSnapshotList", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmSnapshotList")
    @WebMethod(action = "esdk_ivs_professional_server.getAlarmSnapshotList")
    @ResponseWrapper(localName = "getAlarmSnapshotListResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetAlarmSnapshotListResponse")
    public void getAlarmSnapshotList(
        @WebParam(name = "requestXML", targetNamespace = "")
        java.lang.String requestXML,
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "responseXML", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.String> responseXML
    );
		
    @RequestWrapper(localName = "getDeviceAlarmList", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetDeviceAlarmList")
    @WebMethod(action = "esdk_ivs_professional_server.getDeviceAlarmList")
    @ResponseWrapper(localName = "getDeviceAlarmListResponse", targetNamespace = "esdk_ivs_professional_server", className = "com.huawei.esdk.ivs.professional.local.impl.autogen.GetDeviceAlarmListResponse")
	public void getDeviceAlarmList(
			@WebParam(name = "unifiedQuery", targetNamespace = "")
	        com.huawei.esdk.ivs.professional.local.bean.QueryUnifiedFormat unifiedQuery,
	        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
	        javax.xml.ws.Holder<java.lang.Integer> resultCode,
	        @WebParam(mode = WebParam.Mode.OUT, name = "deviceAlarmEvents", targetNamespace = "")
	        javax.xml.ws.Holder<DeviceAlarmEvents> deviceAlarmEvents
    );
    
}
