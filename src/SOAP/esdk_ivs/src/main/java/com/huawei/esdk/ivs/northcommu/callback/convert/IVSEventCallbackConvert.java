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
package com.huawei.esdk.ivs.northcommu.callback.convert;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.domain.model.bean.EventType;
import com.huawei.esdk.ivs.northcommu.callback.cxf.bean.AlarmNotify;
import com.huawei.esdk.ivs.northcommu.callback.cxf.bean.AlarmOperateInfo;
import com.huawei.esdk.ivs.northcommu.callback.cxf.bean.AlarmStatusNotify;
import com.huawei.esdk.ivs.northcommu.callback.cxf.bean.StreamExceptionInfo;
import com.huawei.esdk.ivs.northcommu.callback.cxf.bean.UserOfflineInfo;
import com.huawei.esdk.ivs.northcommu.callback.cxf.gen.EventCallBack;

public class IVSEventCallbackConvert
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(IVSEventCallbackConvert.class);
    
    /** 
    * 回调消息领域对象转换为北向bean
    * @param domain回调消息领域对象
    * @param eventType 事件类型
    * @return EventCallBack 回调信息
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public EventCallBack getNotifyModel2Soap(Object domain, String eventType)
    {
        EventCallBack eventCallBack = new EventCallBack();
        eventCallBack.setEventType(eventType);
        
        int eventTypeInt = Integer.parseInt(eventType);
        if (EventType.IVS_EVENT_REPORT_ALARM == eventTypeInt)
        {
            com.huawei.esdk.ivs.domain.model.bean.AlarmNotify alarmNotifyDomain =
                (com.huawei.esdk.ivs.domain.model.bean.AlarmNotify)domain;
            AlarmNotify alarmNotifyNorth = getAlarmNotifyModel2Soap(alarmNotifyDomain);
            String xml = getEventContentXmlModel2Soap(alarmNotifyNorth);
            if (null != xml)
            {
                eventCallBack.setEventData(xml);
            }
        }
        else if (EventType.IVS_EVENT_REPORT_ALARM_STATUS == eventTypeInt)
        {
            com.huawei.esdk.ivs.domain.model.bean.AlarmStatusNotify alarmStatusNotifyDomain =
                (com.huawei.esdk.ivs.domain.model.bean.AlarmStatusNotify)domain;
            AlarmStatusNotify alarmStatusNotifyNorth = getAlarmStatusNotifyModel2Soap(alarmStatusNotifyDomain);
            String xml = getEventContentXmlModel2Soap(alarmStatusNotifyNorth);
            if (null != xml)
            {
                eventCallBack.setEventData(xml);
            }
        }
        else if (EventType.IVS_EVENT_USER_OFFLINE == eventTypeInt)
        {
            com.huawei.esdk.ivs.domain.model.bean.UserOfflineInfo userOfflineInfoDomain =
                (com.huawei.esdk.ivs.domain.model.bean.UserOfflineInfo)domain;
            UserOfflineInfo userOfflineInfoNorth = getUserOfflineInfoModel2Soap(userOfflineInfoDomain);
            String xml = getEventContentXmlModel2Soap(userOfflineInfoNorth);
            if (null != xml)
            {
                eventCallBack.setEventData(xml);
            }
        }
        else if (EventType.IVS_EVENT_FIND_DEVICE == eventTypeInt)
        {
            String deviceXml = (String)domain;
            eventCallBack.setEventData(deviceXml);
        }
        else if (EventType.IVS_EVENT_REMOTE_PLAYBACK_FAILED == eventTypeInt)
        {
            com.huawei.esdk.ivs.domain.model.bean.StreamExceptionInfo streamExceptionInfo =
                (com.huawei.esdk.ivs.domain.model.bean.StreamExceptionInfo)domain;
            
            StreamExceptionInfo north = getStreamExceptionInfoModel2Soap(streamExceptionInfo);
            String xml = getEventContentXmlModel2Soap(north);
            if (null != xml)
            {
                eventCallBack.setEventData(xml);
            }
        }
        else
        {
            Logger.getLogger(IVSEventCallbackConvert.class).error("eventType error!");
        }
        
        return eventCallBack;
    }
    
    private StreamExceptionInfo getStreamExceptionInfoModel2Soap(
        com.huawei.esdk.ivs.domain.model.bean.StreamExceptionInfo model)
    {
        StreamExceptionInfo north = new StreamExceptionInfo();
        north.setDeviceCode(model.getDeviceCode());
        north.seteSDKSessionId(model.geteSDKSessionId());
        north.setExceptionCode(model.getExceptionCode());
        north.setHandle(model.getHandle());
        north.setReseved(model.getReseved());
        return north;
    }

    /** 
     * 下线用户信息领域bean转换为北向bean
     * @param domain 下线用户信息领域bean
     * @return UserOfflineInfo 下线用户信息北向bean
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    private UserOfflineInfo getUserOfflineInfoModel2Soap(com.huawei.esdk.ivs.domain.model.bean.UserOfflineInfo domain)
    {
        UserOfflineInfo north = new UserOfflineInfo();
        north.setOfflineType(domain.getOfflineType());
        north.setSessionId(domain.getSessionId());
        return north;
    }
    
    /** 
     * 告警状态通知信息领域bean转换为北向bean
     * @param domain 告警状态通知领域bean
     * @return AlarmStatusNotify 告警状态通知信息北向bean
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    private AlarmStatusNotify getAlarmStatusNotifyModel2Soap(
        com.huawei.esdk.ivs.domain.model.bean.AlarmStatusNotify domain)
    {
        AlarmStatusNotify north = new AlarmStatusNotify();
        north.setAlarmEventId(domain.getAlarmEventId());
        north.setAlarmInCode(domain.getAlarmInCode());
        north.setAlarmStatus(domain.getAlarmStatus());
        north.setAlarmType(domain.getAlarmType());
        north.setDevDomainCode(domain.getDevDomainCode());
        north.setOccurNumber(domain.getOccurNumber());
        north.setReserve(domain.getReserve());
        if (null != domain.getOperateInfo())
        {
            north.setAlarmOperateInfo(getAlarmOperateInfoModel2Soap(domain.getOperateInfo()));
        }
        return north;
    }
    
    /** 
     * 告警处理信息信息领域bean转换为北向bean
     * @param domain 告警处理信息领域bean
     * @return AlarmOperateInfo 告警处理信息北向bean
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    private AlarmOperateInfo getAlarmOperateInfoModel2Soap(com.huawei.esdk.ivs.domain.model.bean.AlarmOperateInfo domain)
    {
        AlarmOperateInfo north = new AlarmOperateInfo();
        north.setOperateInfo(domain.getOperateInfo());
        north.setOperateTime(domain.getOperateTime());
        north.setOperatorId(domain.getOperatorId());
        north.setOperatorName(domain.getOperatorName());
        north.setReserve(domain.getReserve());
        return north;
    }
    
    /** 
    * 告警信息领域对象转换为北向bean
    * @param domain 告警信息领域对象 
    * @return AlarmNotify 告警信息北向bean
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public AlarmNotify getAlarmNotifyModel2Soap(com.huawei.esdk.ivs.domain.model.bean.AlarmNotify domain)
    {
        AlarmNotify north = new AlarmNotify();
        north.setAlarmCategory(domain.getAlarmCategory());
        north.setAlarmDesc(domain.getAlarmDesc());
        north.setAlarmEventId(domain.getAlarmEventId());
        north.setAlarmInCode(domain.getAlarmInCode());
        north.setAlarmInName(domain.getAlarmInName());
        north.setAlarmInType(domain.getAlarmInType());
        north.setAlarmLevelColor(domain.getAlarmLevelColor());
        north.setAlarmLevelName(domain.getAlarmLevelName());
        north.setAlarmLevelValue(domain.getAlarmLevelValue());
        north.setAlarmStatus(domain.getAlarmStatus());
        north.setAlarmType(domain.getAlarmType());
        north.setAlarmTypeName(domain.getAlarmTypeName());
        north.setDeviceDomainCode(domain.getDeviceDomainCode());
        north.setExistsRecord(domain.getExistsRecord());
        north.setExtParam(domain.getExtParam());
        north.setIsCommission(domain.getIsCommission());
        north.setNvrCode(domain.getNvrCode());
        north.setOccurentNumber(domain.getOccurentNumber());
        north.setOccurentTime(domain.getOccurentTime());
        north.setPreviewUrl(domain.getPreviewUrl());
        return north;
    }
    
    public String getEventContentXmlModel2Soap(Object obj)
    {
        String xml = null;
        StringWriter sw = new StringWriter();
        Marshaller marshaller;
        try
        {
            Class.forName("javax.xml.bind.JAXBContext");
            JAXBContext jc = JAXBContext.newInstance(obj.getClass());
            marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            marshaller.marshal(obj, sw);
            xml = sw.toString();
        }
        catch (JAXBException e)
        {
            LOGGER.error("getEventContentXmlModel2Soap method error", e);
        }
        catch (Exception e)
        {
            LOGGER.error("getEventContentXmlModel2Soap method error", e);
        }
        return xml;
    }
}
