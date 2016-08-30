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
package com.huawei.esdk.ivs.business.professional.alarmmgr;

import com.huawei.esdk.ivs.domain.model.Alarm;
import com.huawei.esdk.ivs.domain.model.bean.AlarmCommissionInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmEventList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmLevel;
import com.huawei.esdk.ivs.domain.model.bean.AlarmLevelList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmOperateInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmReportInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceAlarmInfos;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 告警管理业务层
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmMgrService
{
    
    /** 
    * 获取告警事件信息
    *
    * @param alarmEventId 告警事件id
    * @param alarmInCode 告警源编码
    * @return SDKResult<Alarm> 封装领域层的SDKResult对象
    * @throws SDKException SDK异常
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<Alarm> getAlarmEventInfo(long alarmEventId, String alarmInCode)
        throws SDKException
    {
        return new Alarm().getAlarmEventInfo(alarmEventId, alarmInCode);
    }
    
    /** 
    * 获取告警事件列表
    *
    * @param queryUnifiedFormat 查询条件，包含索引范围、排序条件和查询条件类型
    * @return SDKResult<AlarmEventList> 告警事件列表
    * @throws SDKException SDK异常
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<AlarmEventList> getAlarmEventList(QueryUnifiedFormat queryUnifiedFormat)
        throws SDKException
    {
        return new Alarm().getAlarmEventList(queryUnifiedFormat);
    }
    
    /** 
    * 告警订阅
    *
    * @param requestXML 告警订阅请求xml
    * @return SDKErrorCode SDK返回码封装类
    * @throws SDKException SDK异常
    * @since  eSDK IVS V100R003C00
    */
    public SDKErrorCode subscribeAlarm(String requestXML)
        throws SDKException
    {
        return new Alarm().subscribeAlarm(requestXML);
    }
    
    /** 
     * 告警订阅
     *
     * @param requestXML 告警订阅请求xml
     * @return SDKResult<String> 告警订阅查询响应xml
     * @throws SDKException SDK异常
     * @since  eSDK IVS V100R003C00
     */
    public SDKResult<String> subscribeAlarmQuery(String requestXML)
        throws SDKException
    {
        return new Alarm().subscribeAlarmQuery(requestXML);
    }
    
    /** 
     * 获取告警联动策略动作详情
     *
     * @param requestXML 获取告警联动策略动作详情请求xml
     * @return SDKResult<String> 获取告警联动策略动作详情响应xml
     * @throws SDKException SDK异常
     * @since  eSDK IVS V100R003C00
     */
    public SDKResult<String> getAlarmLinkageAction(String requestXML)
        throws SDKException
    {
        return new Alarm().getAlarmLinkageAction(requestXML);
    }
    
    /** 
     * 获取告警联动策略列表
     *
     * @param requestXML 获取告警联动策略列表请求xml
     * @return SDKResult<String> 获取告警联动策略列表响应xml
     * @throws SDKException SDK异常
     * @since  eSDK IVS V100R003C00
     */
    public SDKResult<String> getAlarmLinkageList(String requestXML)
        throws SDKException
    {
        return new Alarm().getAlarmLinkageList(requestXML);
    }
    
    public SDKResult<String> getAlarmLinkage(String requestXML)
        throws SDKException
    {
        return new Alarm().getAlarmLinkage(requestXML);
    }
    
    public SDKErrorCode userAuthentication(String password)
        throws SDKException
    {
        return new Alarm().userAuthentication(password);
    }
    
    /** 
     * 新增告警联动策略
     *
     * @param requestXML 告警联动策略xml
     * @return SDKResult<String> 新增告警联动策略响应xml
     * @since eSDK IVS V100R003C00
     */
    public SDKResult<String> addAlarmLinkage(String requestXML)
        throws SDKException
    {
        return new Alarm().addAlarmLinkage(requestXML);
    }
    
    /** 
     * 修改告警联动策略
     *
     * @param requestXML 修改联动策略xml
     * @return SDKErrorCode 修改告警联动策略响应xml
     * @since eSDK IVS V100R003C00
     */
    public SDKErrorCode modifyAlarmLinkage(String requestXML)
        throws SDKException
    {
        return new Alarm().modifyAlarmLinkage(requestXML);
    }
    
    /** 
     * 删除告警联动策略
     *
     * @param requestXML 删除联动策略xml
     * @return SDKErrorCode 删除告警联动策略响应xml
     * @since eSDK IVS V100R003C00
     */
    public SDKErrorCode deleteAlarmLinkage(String requestXML)
        throws SDKException
    {
        return new Alarm().deleteAlarmLinkage(requestXML);
    }
    
    /** 
     * 启动开关量输出告警
     *
     * @param alarmOutCode 开关量输出设备编码
     * @return SDKErrorCode 启动开关量输出告警响应
     * @since eSDK IVS V100R003C00
     */
    public SDKErrorCode startAlarmOut(String alarmOutCode)
        throws SDKException
    {
        return new Alarm().startAlarmOut(alarmOutCode);
    }
    
    /** 
     * 停止开关量输出告警
     *
     * @param alarmOutCode 开关量输出设备编码
     * @return SDKErrorCode 停止开关量输出告警响应
     * @since eSDK IVS V100R003C00
     */
    public SDKErrorCode stopAlarmOut(String alarmOutCode)
        throws SDKException
    {
        return new Alarm().stopAlarmOut(alarmOutCode);
    }
    
    /** 
     * 告警确认
     * 此接口用于确认告警信息为真实告警
     * @param alarmEventID 告警事件ID
     * @param alarmInCode 告警源编码
     * @param alarmOperateInfo 告警处理信息
     * @return SDKErrorCode  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode alarmConfirm(long alarmEventId, String alarmInCode, AlarmOperateInfo alarmOperateInfo)
        throws SDKException
    {
        return new Alarm().alarmConfirm(alarmEventId, alarmInCode, alarmOperateInfo);
    }
    
    /** 
     * 告警撤销
     * 此接口用于撤销无效告警信息
     * @param alarmEventID 告警事件ID
     * @param alarmInCode 告警源编码
     * @param alarmOperateInfo 告警处理信息
     * @return SDKErrorCode  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode alarmCancel(long alarmEventId, String alarmInCode, AlarmOperateInfo alarmOperateInfo)
        throws SDKException
    {
        return new Alarm().alarmCancel(alarmEventId, alarmInCode, alarmOperateInfo);
    }
    
    /** 
     * 告警授权
     * 此接口用于将选定的告警信息授权给其他用户处理
     * @param alarmInCode 告警源编码 
     * @param slarmCommissionInfo 告警授权信息
     * @return SDKErrorCode  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode alarmCommission(String alarmInCode, AlarmCommissionInfo alarmCommissionInfo)
        throws SDKException
    {
        return new Alarm().alarmCommission(alarmInCode, alarmCommissionInfo);
    }
    
    /** 
     * 告警上报
     * @param alarmReportInfo 告警上报信息
     * @return SDKErrorCode  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode alarmReport(AlarmReportInfo alarmReportInfo)
        throws SDKException
    {
        return new Alarm().alarmReport(alarmReportInfo);
    }
    
    /** 
     * 设置告警类型级别
     * @param AlarmTypeList 需要设置的告警类型列表
     * @return SDKErrorCode  成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C10]
     */
    public SDKErrorCode setAlarmTypeLevel(AlarmTypeInfos alarmTypeList)
        throws SDKException
    {
        return new Alarm().setAlarmTypeLevel(alarmTypeList);
    }
    
    /** 
    * 查询告警类型列表
    * 
    * @param queryUnifiedFormat 查询结构体
    * @return SDKResult<AlarmTypeInfos> 告警类型列表
    * @throws SDKException SDK异常
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C10B001
    */
    public SDKResult<AlarmTypeInfos> getAlarmTypeList(QueryUnifiedFormat queryUnifiedFormat)
        throws SDKException
    {
        return new Alarm().getAlarmTypeList(queryUnifiedFormat);
    }
    
    /** 
    * 查询告警级别信息
    * 
    * @param alarmLevelId 告警级别ID
    * @return SDKResult<AlarmLevel> 告警级别信息
    * @throws SDKException SDK异常
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C10B001
    */
    public SDKResult<AlarmLevel> getAlarmLevel(int alarmLevelId)
        throws SDKException
    {
        return new Alarm().getAlarmLevel(alarmLevelId);
    }
    
    /** 
     * 查询告警级别列表
     * 
     * @return SDKResult<AlarmLevelList> 告警级别信息列表
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C10B001
     */
    public SDKResult<AlarmLevelList> getAlarmLevelList() throws SDKException
    {
        return new Alarm().getAlarmLevelList();
    }

    public SDKResult<String> getAlarmSnapshotList(String requestXML) throws SDKException
    {
        return new Alarm().getAlarmSnapshotList(requestXML);
    }
    
    /** 
    * 获取设备告警事件列表
    *
    * @param queryUnifiedFormat 查询条件，包含索引范围、排序条件和查询条件类型
    * @return SDKResult<DeviceAlarmInfos> 设备告警事件列表
    * @throws SDKException SDK异常
    * @since  eSDK IVS V100R005C70
    */
    public SDKResult<DeviceAlarmInfos> getDeviceAlarmList(QueryUnifiedFormat queryUnifiedFormat)
        throws SDKException
    {
        return new Alarm().getDeviceAlarmList(queryUnifiedFormat);
    }
}
