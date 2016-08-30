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
package com.huawei.esdk.ivs.device.v100r001c10.callback.convert;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.common.constants.IVSConstant;
import com.huawei.esdk.ivs.device.v100r001c10.callback.CallbackEventImpl;
import com.huawei.esdk.ivs.domain.model.bean.AlarmNotify;
import com.huawei.esdk.ivs.domain.model.bean.AlarmOperateInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmStatusNotify;
import com.huawei.esdk.ivs.domain.model.bean.EventType;
import com.huawei.esdk.ivs.domain.model.bean.UserOfflineInfo;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmNotifySouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.StreamExceptionInfo;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.UserDataSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AlarmOperateInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.AlarmStatusNotifySouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.UserOfflineInfoSouth;
import com.huawei.esdk.platform.common.utils.BytesUtils;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

/**
 * 告警信息南向bean转换类
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CallbackEventConvert
{
    
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(CallbackEventImpl.class);
    
    /** 
     * 回调信息南向bean转换为领域bean
     * @param eventType 回调事件类型
     * @param eventBuf 回调信息南向bean
     * @param bufSize
     * @return Object 领域bean
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public Object getCallbackMessage(int eventType, Pointer eventBuf, int bufSize, UserDataSouth userDataSouth)
    {
        LOGGER.info("ivs call back, event type: " + eventType);
        LOGGER.info("ivs call back, session id: " + BytesUtils.bytesToStringForIVS(userDataSouth.sessionId));
        
        if (EventType.IVS_EVENT_AUTO_CONNECT_SUCCEED == eventType)
        {
            return BytesUtils.bytesToStringForIVS(userDataSouth.sessionId);
        }
        else if (EventType.IVS_EVENT_KEEP_ALIVE_FAILED == eventType)
        {
            return BytesUtils.bytesToStringForIVS(userDataSouth.sessionId);
        }
        else if (EventType.IVS_EVENT_REPORT_ALARM == eventType)
        {
            AlarmNotifySouth alarmNotifySouth = new AlarmNotifySouth(eventBuf);
            alarmNotifySouth.read();
            
            LOGGER.info("alarm event id: " + alarmNotifySouth.alarmEventId);
            LOGGER.info("alarm in type: " + alarmNotifySouth.alarmInType);
            LOGGER.info("alarm type: " + BytesUtils.bytesToStringForIVS(alarmNotifySouth.alarmType));
            LOGGER.info("alarm status: " + alarmNotifySouth.alarmStatus);
            
            return getAlarmNotifySouth2Model(alarmNotifySouth);
        }
        else if (EventType.IVS_EVENT_REPORT_ALARM_STATUS == eventType)
        {
            AlarmStatusNotifySouth alarmStatusNotifySouth = new AlarmStatusNotifySouth(eventBuf);
            alarmStatusNotifySouth.read();
            
            LOGGER.info("alarm event id: " + alarmStatusNotifySouth.alarmEventId);
            LOGGER.info("alarm type: " + BytesUtils.bytesToStringForIVS(alarmStatusNotifySouth.alarmType));
            LOGGER.info("alarm status: " + alarmStatusNotifySouth.alarmStatus);
            
            return getAlarmStatusNotifySouth2Model(alarmStatusNotifySouth);
        }
        else if (EventType.IVS_EVENT_USER_OFFLINE == eventType)
        {
            UserOfflineInfoSouth userOfflineInfoSouth = new UserOfflineInfoSouth(eventBuf);
            userOfflineInfoSouth.read();
            
            LOGGER.info("offline type: " + userOfflineInfoSouth.offlineType);
            
            return getUserOfflineInfoSouth2Model(userOfflineInfoSouth, userDataSouth);
        }
        else if (EventType.IVS_EVENT_FIND_DEVICE == eventType)
        {
            String deviceXML = eventBuf.getString(0);
            
            LOGGER.info("device info XML: " + deviceXML);
            
            return deviceXML;
        }
        else if (EventType.IVS_EVENT_REMOTE_PLAYBACK_FAILED == eventType)
        {
            StreamExceptionInfo streamExceptionInfo = new StreamExceptionInfo(eventBuf);
            streamExceptionInfo.read();
            
            LOGGER.info("ivs call back, sdk session id: " + streamExceptionInfo.sessionId);
            if (IVSConstant.IVS_OS_32 == NativeLong.SIZE)
            {
                LOGGER.info("handle: " + streamExceptionInfo.handle.intValue());
            }
            else
            {
                LOGGER.info("handle: " + streamExceptionInfo.handle.longValue());
            }
            LOGGER.info("exception code : " + streamExceptionInfo.exceptionCode);
            
            return getStreamExceptionInfoSouth2Model(streamExceptionInfo, userDataSouth);
        }
        else
        {
            LOGGER.info("event type is not defined.");
            
            return null;
        }
    }
    
    private com.huawei.esdk.ivs.domain.model.bean.StreamExceptionInfo getStreamExceptionInfoSouth2Model(
        StreamExceptionInfo streamExceptionInfo, UserDataSouth userDataSouth)
    {
        com.huawei.esdk.ivs.domain.model.bean.StreamExceptionInfo model =
            new com.huawei.esdk.ivs.domain.model.bean.StreamExceptionInfo();
        if (IVSConstant.IVS_OS_32 == NativeLong.SIZE)
        {
            model.setHandle(streamExceptionInfo.handle.intValue());
        }
        else
        {
            model.setHandle(streamExceptionInfo.handle.longValue());
        }
        model.setDeviceCode(BytesUtils.bytesToStringForIVS(streamExceptionInfo.deviceCode));
        model.setExceptionCode(streamExceptionInfo.exceptionCode);
        model.setReseved(streamExceptionInfo.reseved);
        model.setSessionId(streamExceptionInfo.sessionId);
        model.seteSDKSessionId(BytesUtils.bytesToStringForIVS(userDataSouth.sessionId));
        
        return model;
    }

    /** 
     * 用户下线通知南向bean转换为领域bean
     * @param south 用户下线通知信息南向bean
     * @return UserOfflineInfo 用户下线通知领域bean
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    private UserOfflineInfo getUserOfflineInfoSouth2Model(UserOfflineInfoSouth south, UserDataSouth userDataSouth)
    {
        UserOfflineInfo domain = new UserOfflineInfo();
        domain.setSessionId(south.sessionId);
        domain.setOfflineType(south.offlineType);
        domain.setEsdkSessionId(BytesUtils.bytesToStringForIVS(userDataSouth.sessionId));
        return domain;
    }
    
    /** 
    * 告警信息南向bean转换为领域bean
    * @param south 告警信息南向bean
    * @return AlarmNotify 领域bean
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public AlarmNotify getAlarmNotifySouth2Model(com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmNotifySouth south)
    {
        AlarmNotify domain = new AlarmNotify();
        domain.setAlarmCategory(BytesUtils.bytesToStringForIVS(south.alarmCategory));
        domain.setAlarmDesc(BytesUtils.bytesToStringForIVS(south.alarmDesc));
        domain.setAlarmEventId(south.alarmEventId);
        domain.setAlarmInCode(BytesUtils.bytesToStringForIVS(south.alarmInCode));
        domain.setAlarmInName(BytesUtils.bytesToStringForIVS(south.alarmInName));
        domain.setAlarmInType(south.alarmInType);
        domain.setAlarmLevelColor(BytesUtils.bytesToStringForIVS(south.alarmLevelColor));
        domain.setAlarmLevelName(BytesUtils.bytesToStringForIVS(south.alarmLevelName));
        domain.setAlarmLevelValue(south.alarmLevelValue);
        domain.setAlarmStatus(south.alarmStatus);
        domain.setAlarmType(BytesUtils.bytesToStringForIVS(south.alarmType));
        domain.setAlarmTypeName(BytesUtils.bytesToStringForIVS(south.alarmTypeName));
        domain.setDeviceDomainCode(BytesUtils.bytesToStringForIVS(south.deviceDomainCode));
        domain.setExistsRecord(south.existsRecord);
        domain.setExtParam(BytesUtils.bytesToStringForIVS(south.extParam));
        domain.setIsCommission(south.isCommission);
        domain.setNvrCode(BytesUtils.bytesToStringForIVS(south.nvrCode));
        domain.setOccurentNumber(south.occurentNumber);
        domain.setOccurentTime(BytesUtils.bytesToStringForIVS(south.occurentTime));
        domain.setPreviewUrl(BytesUtils.bytesToStringForIVS(south.previewUrl));
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
    
    /** 
     * 告警状态通知信息南向bean转换为领域bean
     * @param south 告警状态通知南向bean
     * @return AlarmStatusNotify 告警状态通知信息领域bean
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public AlarmStatusNotify getAlarmStatusNotifySouth2Model(AlarmStatusNotifySouth south)
    {
        AlarmStatusNotify domain = new AlarmStatusNotify();
        domain.setAlarmEventId(south.alarmEventId);
        domain.setAlarmInCode(BytesUtils.bytesToStringForIVS(south.alarmInCode));
        domain.setAlarmStatus(south.alarmStatus);
        domain.setAlarmType(BytesUtils.bytesToStringForIVS(south.alarmType));
        domain.setDevDomainCode(BytesUtils.bytesToStringForIVS(south.devDomainCode));
        domain.setOccurNumber(south.occurNumber);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        if (null != south.operateInfo)
        {
            domain.setOperateInfo(getAlarmOperateInfoSouth2Model(south.operateInfo));
        }
        
        return domain;
    }
    
    /** 
     * 告警处理信息信息南向bean转换为领域bean
     * @param south 告警处理信息南向bean
     * @return AlarmOperateInfo 告警处理信息领域bean
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public AlarmOperateInfo getAlarmOperateInfoSouth2Model(AlarmOperateInfoSouth south)
    {
        AlarmOperateInfo domain = new AlarmOperateInfo();
        domain.setOperateInfo(BytesUtils.bytesToStringForIVS(south.operateInfo));
        domain.setOperateTime(BytesUtils.bytesToStringForIVS(south.operateTime));
        domain.setOperatorId(south.operatorId);
        domain.setOperatorName(BytesUtils.bytesToStringForIVS(south.operatorName));
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        return domain;
    }
}
