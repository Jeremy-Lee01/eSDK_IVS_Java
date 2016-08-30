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
package com.huawei.esdk.ivs.device.v100r001c10;

import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmCommissionSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmOperateInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmReportSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmTypeListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryUnifiedFormatSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.MediaAddressSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.MediaURLParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.PTZPresetInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.PlayBackParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.QuerySnapshotParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.RealplayParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.IndexRangeSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.EventCallBackSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.LoginInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceCodeListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr.DeviceOperInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.RecordPlanSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.TimeSpanSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.UserInfoSouth;
import com.sun.jna.Library;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.ByReference;
import com.sun.jna.ptr.LongByReference;

/**
 * 告警JNA底层库调用管理接口
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public interface BaseCablilityJNA extends Library
{
    /** 
     * 查询告警事件信息
     * 根据告警ID获取告警事件信息，在返回成功的同时会返回业务告警通知信息和告警处理信息
     *
     * @param iSessionId[in] 用户的sessionId
     * @param alarmEventId[in] 告警事件ID
     * @param alarmInCode[in] 告警源编码
     * @param pAlarmEvent[out] 告警事件
     * @return 成功  0/失败，参见错误码
     * @attention 无
     * @par 示例
     * @code
       AlarmEventSouth alarmEventSouth = new AlarmEventSouth();
       int resultCode =
            iAlarmMgrCability.IVS_SDK_GetAlarmEventInfo(iSessionId,
                alarmEventId,
                alarmCode,
                alarmEventSouth.getPointer());
       alarmEventSouth.read();
     * @endcode
     * @since V100R003
     */
    public int IVS_SDK_GetAlarmEventInfo(int iSessionId, long alarmEventId, byte[] alarmInCode, Pointer pAlarmEvent);
    
    /** 
    * 查询告警事件列表
    * 根据查询索引范围、排序条件和查询条件类型查询出告警事件列表，当查询条件类型为摄像机编码为多个时，以英文“,”分割，最多30个编码
    *
    * @param iSessionId[in] 用户的sessionId
    * @param queryUnifiedFormatSouth[in] 查询条件，包含索引范围、排序条件和查询条件类型
    * @param pAlarmEventList[out] 告警事件列表
    * @param uiBufferSize[in] 缓存大小
    * @return 成功  0/失败，参见错误码
    * @attention 无
    * @par 示例
    * @code
      int size =
            queryUnifiedFormatSouth.indexRangeSouth.toIndex - queryUnifiedFormatSouth.indexRangeSouth.fromIndex + 1;
      AlarmEventListSouth alarmEventList = new AlarmEventListSouth(size);
      int bufferSize = alarmEventList.size();
      Pointer point = alarmEventList.getPointer();
      int sessionId = super.getIVSSessionId();
        
      int resultCode =
           iAlarmMgrCability.IVS_SDK_GetAlarmEventList(sessionId,
               queryUnifiedFormatSouth,
               point,
               bufferSize);
      alarmEventList.read();
    * @endcode
    * @since <V100R003>
    */
    public int IVS_SDK_GetAlarmEventList(int iSessionId, QueryUnifiedFormatSouth queryUnifiedFormatSouth,
        Pointer pAlarmEventList, int uiBufferSize);
        
    /** 
    * 告警订阅
    * 传入告警订阅请求的xml，以字符串方式拼接
    *
    * @param iSessionId[in] 用户的sessionId
    * @param requestXML[in] 告警订阅请求xml
    * @return 成功  0/失败，参见错误码
    * @attention 无
    * @par 示例
    * @code
      int sessionId = super.getIVSSessionId();
      int resultCode = iAlarmMgrCability.IVS_SDK_SubscribeAlarm(sessionId, requestXML.getBytes());
    * @endcode
    * @since <V100R003>
    */
    public int IVS_SDK_SubscribeAlarm(int iSessionId, String requestXML);
    
    public int IVS_SDK_SubscribeAlarmQuery(int iSessionId, String requestXML, Pointer pointer);
    
    public int IVS_SDK_GetNVRList(int sessionID, String domainCode, int serverType, IndexRangeSouth indexRange,
        Pointer nvrList, int bufferSize);
        
    public int IVS_SDK_Init();
    
    public int IVS_SDK_Cleanup();
    
    public int IVS_SDK_Login(LoginInfoSouth loginInfoSouth, ByReference pSessionId);
    
    public int IVS_SDK_Logout(int sessionId);
    
    /** 
    * 设置事件回调函数
    * @param sessionId
    * @param eventCallBackSouth
    * @param userData
    * @return 成功返回0，失败返回错误码
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public int IVS_SDK_SetEventCallBack(int sessionId, EventCallBackSouth eventCallBackSouth, Pointer userData);
    
    /** 
     * 新增平台录像计划
     *
     * @param sessionID 登录成功后的会话ID
     * @param deviceNum 摄像机个数
     * @param deviceList 摄像机编码列表
     * @param recordPlan 录像计划
     * @param resultList 新增录像计划的返回结果列表
     * @param resultBufferSize 缓存大小
     * @return 成功返回0，失败返回错误码和详细信息
     * @attention <无>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_AddRecordPlan(int sessionID, int deviceNum, DeviceCodeListSouth deviceList,
        RecordPlanSouth recordPlan, Pointer resultList, int resultBufferSize);
        
    /** 
    * 删除平台录像计划
    *
    * @param sessionID 登录成功后的会话ID
    * @param deviceNum 摄像机个数
    * @param deviceList 摄像机编码列表
    * @param recordMethod 录像方式：0-平台录像 1-前端录像
    * @param resultList 录像计划删除结果
    * @param resultBufferSize 缓存大小
    * @return 成功返回0，失败返回错误码
    * @attention <无>
    * @par <示例的作用和实现了那些功能点>
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [eSDK IVS V100R003C00]
    */
    public int IVS_SDK_DeleteRecordPlan(int sessionId, int deviceNum, DeviceCodeListSouth deviceCodeList,
        int recordMethod, Pointer resultList, int resultBufferSize);
        
    /** 
    * 查询平台录像计划
    *
    * @param sessionID 登录成功后的会话ID
    * @param cameraCode 摄像机编码
    * @param recordMethod 录像方式：0-平台录像 1-前端录像
    * @param recordPlan 录像计划
    * @return 成功返回0，失败返回错误码
    * @attention <描述使用该函数时的注意事项，没有请写“无”>
    * @par <示例的作用和实现了那些功能点>
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [eSDK IVS V100R003C00]
    */
    public int IVS_SDK_GetRecordPlan(int sessionId, String cameraCode, int recordMethod, Pointer recordPlan);
    
    /** 
    * <修改平台录像计划
    *
    * @param sessionId 登录成功后的会话ID
    * @param deviceNum 摄像机个数
    * @param deviceCodeList 摄像机编码列表
    * @param recordPlan 录像计划
    * @param resultList 录像计划结果
    * @param resultBufferSize 缓存大小
    * @return 成功返回0，失败返回错误码
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [eSDK IVS V100R003C00]
    */
    public int IVS_SDK_ModifyRecordPlan(int sessionId, int deviceNum, DeviceCodeListSouth deviceCodeList,
        RecordPlanSouth recordPlan, Pointer resultList, int resultBufferSize);
        
    /** 
    * 增加用户
    *
    * @param sessionId 登录成功后的会话ID
    * @param userInfo 用户信息
    * @param userId 增加成功返回的userId
    * @return 成功返回0，失败返回错误码
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [eSDK IVS V100R003C00]
    */
    public int IVS_SDK_AddUser(int sessionId, UserInfoSouth userInfo, ByReference userId);
    
    /** 
    * 修改用户
    *
    * @param sessionId 登录成功后的会话ID
    * @param userInfo 用户信息
    * @return 成功返回0，失败返回错误码
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [eSDK IVS V100R003C00]
    */
    public int IVS_SDK_ModifyUser(int sessionId, UserInfoSouth userInfo);
    
    /** 
    * 删除用户
    *
    * @param sessionId 登录成功后的会话ID
    * @param pDomainCode 领域码
    * @param userId 要删除的userId
    * @return 成功返回0，失败返回错误码
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [eSDK IVS V100R003C00]
    */
    public int IVS_SDK_DeleteUser(int sessionId, String pDomainCode, int uiUserID);
    
    /** 
    * 获取用户信息
    *
    * @param sessionId 登录成功后的会话ID
    * @param domainCode 领域码
    * @param userId 要查询的userId
    * @param userInfo 查询返回的用户信息
    * @return 成功返回0，失败返回错误码
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [eSDK IVS V100R003C00]
    */
    public int IVS_SDK_GetUserInfo(int iSessionID, String domainCode, int uiUserID, UserInfoSouth userInfo);
    
    /** 
    * 获取用户Id
    *
    * @param sessionId 登录成功后的会话ID
    * @param domainCode 领域码
    * @param userId 查询的userId
    * @return 成功返回0，失败返回错误码
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [eSDK IVS V100R003C00]
    */
    public int IVS_SDK_GetUserID(int sessionId, ByReference userId);
    
    /** 
    * 修改密码
    *
    * @param sessionId 登录成功后的会话ID
    * @param oldPwd 旧密码
    * @param newPwd 新密码
    * @return 成功返回0，失败返回错误码
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [eSDK IVS V100R003C00]
    */
    public int IVS_SDK_ChangePWD(int sessionId, String oldPwd, String newPwd);
    
    /** 
    * 获取用户列表
    *
    * @param sessionId 登录成功后的会话ID
    * @param domainCode 领域码
    * @param pUnifiedQuery 查询条件
    * @param pUserList 查询返回的用户列表
    * @param uiBufferSize 返回数据大小
    * @return 成功返回0，失败返回错误码
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [eSDK IVS V100R003C00]
    */
    public int IVS_SDK_GetUserList(int iSessionID, String domainCode,
        com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.QueryUnifiedFormatSouth pUnifiedQuery, Pointer pUserList,
        int uiBufferSize);
        
    /**
     * 
     * 重启前端设备
     *
     * @param sessionId 登录成功后的会话ID
     * @param deviceCode  设备编码
     * @param rebootType 重启类型
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since <版本号>
     */
    public int IVS_SDK_RebootDevice(int sessionId, String deviceCode, int rebootType);
    
    /** 
    * 获取用户拥有权限的整个系统中的域路由信息， 域最大数目 IVS_MAX_DOMAIN_ROUTE_NUM 128
    *
    * @param sessionID 登录成功后的会话ID
    * @param domainRouteList 域路由信息
    * @param uiBufferSize 缓存大小
    * @return
    * @attention <无>
    * @par <示例的作用和实现了那些功能点>
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [V100R003]
    */
    public int IVS_SDK_GetDomainRoute(int sessionId, Pointer domainRouteList, int bufferSize);
    
    /** 
    * 删除主设备
    *
    * @param sessionID 登录成功后的会话ID
    * @param domainCode 域编码
    * @param deviceNum 批量增加是的设备数目
    * @param devCode 设备编码
    * @param resultList 结果结构体，存放SMU返回的结果
    * @param resultBufferSize 缓存大小
    * @return
    * @attention <无>
    * @par <示例的作用和实现了那些功能点>
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode
    * @see \ref function1Example | fuction2Example
    * @since [V100R003]
    */
    public int IVS_SDK_DeleteDevice(int sessionId, String domainCode, int deviceNum, DeviceCodeListSouth devCodeList,
        Pointer resultList, int resultBufferSize);
        
    /**
     * 
     * 启动搜索前端设备
     *
     * @param sessionId 登录成功后的会话ID
     * @param domainCode 域编码
     * @param searchInfo 设备搜索信息XML
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since <版本号>
     */
    public int IVS_SDK_StartSearchDevice(int sessionId, String domainCode, String searchInfo);
    
    /**
     * 
     * 停止搜索前端设备
     *
     * @param sessionId 登录成功后的会话ID
     * @param domainCode 域编码
     * @param searchInfo 设备搜索信息XML
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since <版本号>
     */
    public int IVS_SDK_StopSearchDevice(int sessionId, String domainCode, String searchInfo);
    
    /**
     * 
     * 验证前端设备
     *
     * @param sessionId 登录成功后的会话ID
     * @param domainCode 域编码
     * @param verifyInfo 设备验证信息XML
     * @param respXml 验证结果XML
     * @return 
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since <版本号>
     */
    public int IVS_SDK_VerifyDevice(int sessionId, String domainCode, String verifyInfo, Pointer respXml);
    
    /**
     * 
     * 修改主设备名称
     *
     * @param sessionId 登录成功后的会话ID
     * @param devCode 设备编码
     * @param newDevName 设备新名称
     * @return 
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since <版本号>
     */
    public int IVS_SDK_SetMainDeviceName(int sessionId, String devCode, byte[] newDevName);
    
    /**
     * 
     * 修改摄像机名称
     *
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @param cameraNewName 摄像机新名称
     * @return 
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since <版本号>
     */
    public int IVS_SDK_SetCameraName(int sessionId, String cameraCode, byte[] cameraNewName);
    
    /**
     * 
     * 添加设备
     *
     * @param sessionId 登录成功后的会话ID
     * @param domainCode 域编码
     * @param deviceNum 添加的设备数目
     * @param deviceNum 添加的设备数目
     * @param deviceNum 添加的设备数目
     * @return 
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since <版本号>
     */
    public int IVS_SDK_AddDevice(int sessionId, String domainCode, int deviceNum, DeviceOperInfoSouth[] deviceInfo,
        Pointer resultList, int resultBufferSize);
        
    /** 
    * 获取设备列表（摄像机、音频、告警设备）
    * 目前支持获取摄像机、语音和告警设置列表获取
    *
    * @param iSessionID[in] 登录成功后的会话ID
    * @param uiDeviceType[in] 设备类型
    * @param pIndexRange[in] 分页信息
    * @param pDeviceList[out] 设备列表指针
    * @param uiBufferSize[in] 缓存大小
    * @return 成功  0/失败，参见错误码
    * @attention 无
    * @par 示例
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode 
    * @since <V100R003>
    */
    public int IVS_SDK_GetDeviceList(int iSessionID, int uiDeviceType,
        com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.IndexRangeSouth indexRangeSouth, Pointer pDeviceList,
        int uiBufferSize);
        
    /** 
     * <查询摄像机码流能力
     *
     * @param sessionId 登录成功后的会话ID
     * @param capabilityType 设置类型
     * @param devCode 设备编码
     * @param rspXml 查询XML
     * @return
     * @attention <无>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [V100R003]
     */
    public int IVS_SDK_GetDeviceCapability(int sessionId, int capabilityType, String devCode, Pointer rspXml);
    
    public int IVS_SDK_QueryDeviceList(int sessionId, String domainCode, int deviceType,
        QueryUnifiedFormatSouth queryUnifiedFormatSouth, Pointer pDeviceList, int bufferSize);
        
    /** 
     * 设置设备参数
     *
     * @param sessionId 登录成功后的会话ID
     * @param devCode 设备代码
     * @param configType 配置设备类型
     * @param buffer 返回参数结构体指针
     * @param bufSize
     * @return
     * @attention <描述使用该函数时的注意事项，没有请写“无”>
     * @par <示例的作用和实现了那些功能点>
     * @code
     * <示例代码(示例代码如果添加注释,请使用//)>
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [V100R003]
     */
    public int IVS_SDK_GetDeviceConfig(int sessionId, String devCode, int configType, Pointer buffer, int bufSize);
    
    public int IVS_SDK_SetDeviceConfig(int sessionId, String deviceCode, int configType, Structure dataBuffer,
        int bufferSize);
        
    /** 
    * 获取SDK版本号
    * @return 成功返回SDK版本号，高16位表示主版本号，低16位表示次版本号，失败返回负数错误码
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public int IVS_SDK_GetVersion();
    
    /** 
     * 增加指定摄像机预置位
     *
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @param presetName 预置位名称
     * @param uiPresetIndex 预置位编号
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_AddPTZPreset(int sessionId, String cameraCode, byte[] presetName, ByReference presetIndex);
    
    /** 
    * 查询录像列表
    * @param sessionId 登录成功后的会话ID
    * @param queryUnifiedFormatSouth 通用查询结构
    * @param recordInfoList 返回录像查询结构列表
    * @param uiBufferSize 分配内存大小
    * @return
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public int IVS_SDK_QueryRecordList(int sessionId, QueryUnifiedFormatSouth queryUnifiedFormatSouth,
        Pointer recordInfoList, int bufferSize);
        
    /** 
     * 查询录像列表
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机ID
     * @param recordMethod 录像存储位置
     * @param timeSpan 时间段信息
     * @param indexRange 分页信息
     * @param recordList 录像列表
     * @param bufSize
     * @return 成功返回0，失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public int IVS_SDK_GetRecordList(int sessionId, String cameraCode, int recordMethod, TimeSpanSouth timeSpan,
        IndexRangeSouth indexRange, Pointer recordList, int bufSize);
        
    /** 
     * 删除指定摄像机预置位
     *
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @param uiPresetIndex 预置位编号
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_DelPTZPreset(int iSessionID, String pCameraCode, int uiPresetIndex);
    
    /** 
     * 修改指定摄像机预置位
     *
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @param ptzPresetInfoSouth 预置信息
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_ModPTZPreset(int sessionId, byte[] cameraCode, PTZPresetInfoSouth ptzPresetInfoSouth);
    
    /** 
     * 开始实况浏览
     *
     * @param sessionId 登录成功后的会话ID
     * @param realplayParamSouth 实况浏览媒体参数
     * @param cameraCode 摄像机编码
     * @param mediaAddrDst 媒体流目标地址
     * @param mediaAddrSrc 媒体流源地址
     * @param handle 播放句柄
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_StartRealPlayByIPEx(int sessionId, RealplayParamSouth realplayParamSouth, byte[] cameraCode,
        MediaAddressSouth mediaAddrDst, Pointer mediaAddrSrc, ByReference handle);
        
    /** 
     * 停止实况浏览
     *
     * @param sessionId 登录成功后的会话ID
     * @param handle 播放句柄
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_StopRealPlayByIPEx(int sessionId, NativeLong handle);
    
    /** 
     * 修改指定摄像机预置位
     *
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @param pPTZPresetList 预置位信息列表
     * @param bufferSize 缓存大小
     * @param ptzPresetNum 预置位信息列表个数
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_GetPTZPresetList(int sessionId, byte[] cameraCode, Pointer pPTZPresetList, int bufferSize,
        ByReference ptzPresetNum);
        
    /** 
    * 云镜控制命令
    * 此接口用于操作摄像机云台和设置摄像机镜头
    * @param sessionId 登录成功后的会话ID
    * @param cameraCode 摄像机ID
    * @param controlCode 云台控制码
    * @param controlPara1 参数1
    * @param controlPara2 参数2
    * @param pLockStatus 云台是否锁定
    * @return 成功返回0；失败返回错误码
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public int IVS_SDK_PtzControl(int sessionId, String cameraCode, int controlCode, String controlPara1,
        String controlPara2, ByReference lockStatus);
        
    /** 
     * 云镜控制命令
     * 此接口用于操作摄像机云台和设置摄像机镜头
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机ID
     * @param controlCode 云台控制码
     * @param controlPara1 参数1
     * @param controlPara2 参数2
     * @param ptzControlInfoSouth 云台是否锁定详细信息
     * @return 成功返回0；失败返回错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public int IVS_SDK_PtzControlWithLockerInfo(int sessionId, String cameraCode, int controlCode, String controlPara1,
        String controlPara2, Pointer ptzControlInfoSouth);
        
    /** 
     * 停止平台录像播放
     *
     * @param sessionId 登录成功后的会话ID
     * @param handle 播放句柄
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_StopPlatformPlayBackByIP(int sessionId, NativeLong handle);
    
    /** 
     * 开始客户端平台录像回放
     *
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @param playbackParam 回放参数
     * @param handle 播放句柄
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_StartPlatformPlayBackByIP(int sessionId, String cameraCode, PlayBackParamSouth playbackParam,
        MediaAddressSouth mediaAddrDst, Pointer mediaAddrSrc, LongByReference handle);
        
    public int IVS_SDK_GetAlarmLinkageAction(int iSessionId, String requestXML, Pointer pointer);
    
    public int IVS_SDK_GetAlarmlinkageList(int iSessionId, String requestXML, Pointer pointer);
    
    public int IVS_SDK_GetAlarmLinkage(int iSessionId, String requestXML, Pointer pointer);
    
    public int IVS_SDK_UserAuthentication(int iSessionId, String password);
    
    /** 
     * 增加告警联动策略
     *
     * @param sessionId 登录成功后的会话ID
     * @param requestXML 告警联动xml
     * @param pointer 响应信息
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_AddAlarmLinkage(int sessionId, String requestXML, Pointer pointer);
    
    /** 
     * 修改告警联动策略
     *
     * @param sessionId 登录成功后的会话ID
     * @param requestXML 告警联动xml
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_ModifyAlarmLinkage(int sessionId, String requestXML);
    
    /** 
     * 删除告警联动策略
     *
     * @param sessionId 登录成功后的会话ID
     * @param requestXML 告警联动xml
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_DeleteAlarmLinkage(int sessionId, String requestXML);
    
    /** 
     * 启动开关量输出告警
     *
     * @param sessionId 登录成功后的会话ID
     * @param alarmOutCode 开关量输出设备编码
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_StartAlarmOut(int sessionId, String alarmOutCode);
    
    /** 
     * 停止开关量输出告警
     *
     * @param sessionId 登录成功后的会话ID
     * @param alarmOutCode 开关量输出设备编码
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_StopAlarmOut(int sessionId, String alarmOutCode);
    
    /** 
    * 告警确认
    * @param sessionId 登录成功后的会话ID
    * @param alarmEventId 告警事件ID
    * @param alarmInCode 告警源编码
    * @param alarmOperateInfo 告警处理信息
    * @return 成功返回0，失败返回负数错误码
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public int IVS_SDK_AlarmConfirm(int sessionId, long alarmEventId, String alarmInCode,
        AlarmOperateInfoSouth alarmOperateInfo);
        
    /** 
    * 告警撤销
    * @param sessionId 登录成功后的会话ID
    * @param alarmEventId 告警事件ID
    * @param alarmInCode 告警源编码
    * @param alarmOperateInfo 告警处理信息
    * @return 成功返回0，失败返回负数错误码
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public int IVS_SDK_AlarmCancel(int sessionId, long alarmEventId, String alarmInCode,
        AlarmOperateInfoSouth alarmOperateInfo);
        
    /** 
    * 告警授权
    * @param sessionId 登录成功后的会话ID
    * @param alarmInCode 告警源编码
    * @param alarmCommission 告警授权结构体
    * @return 成功返回0，失败返回负数错误码
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public int IVS_SDK_AlarmCommission(int sessionId, String alarmInCode, AlarmCommissionSouth alarmCommission);
    
    /** 
    * 告警信息上报（告警推送）
    * @param sessionId 登录成功后的会话ID
    * @param alarmReport 信息上报结构体
    * @return 成功返回0，失败返回负数错误码
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public int IVS_SDK_AlarmReport(int sessionId, AlarmReportSouth alarmReport);
    
    /** 
     * 开始平台录像
     *
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @param recordTime 录像时长
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_StartPlatformRecord(int sessionId, String cameraCode, int recordTime);
    
    /** 
     * 停止平台录像
     *
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R003C00]
     */
    public int IVS_SDK_StopPlatformRecord(int sessionId, String cameraCode);
    
    /** 
    * 获取设备组列表
    * @param sessionId 登录成功后的会话ID
    * @param domainCode 域编码
    * @param devGroupCode 设备组编码
    * @param deviceGroupList 设备组列表
    * @param bufferSize 
    * @return 成功  0/失败，参见错误码
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public int IVS_SDK_GetDeviceGroup(int sessionId, String domainCode, String devGroupCode, Pointer deviceGroupList,
        int bufferSize);
        
    /** 
    * 设置告警类型级别
    * @param sessionId 登录成功后的会话ID
    * @param alarmTypeList 需要设置的告警类型列表
    * @return 成功  0/失败，参见错误码
    * @see [类、类#方法、类#成员]
    * @since  [eSDK IVS V100R003C10]
    */
    public int IVS_SDK_SetAlarmTypeLevel(int sessionId, AlarmTypeListSouth alarmTypeList);
    
    /** 
     * 查询告警类型列表
     * @param sessionId 登录成功后的会话ID
     * @param QueryUnifiedFormatSouth 查询结构体
     * @param alarmTypeList 告警类型列表指针
     * @param bufferSize 结构体大小
     * @return 成功  0/失败，参见错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C10B001
     */
    public int IVS_SDK_GetAlarmTypeList(int sessionId, QueryUnifiedFormatSouth queryUnifiedFormatSouth,
        Pointer alarmTypeList, int bufferSize);
        
    /** 
     * 查询告警类型列表
     * @param sessionId 登录成功后的会话ID
     * @param alarmLevelId 告警级别ID
     * @param alarmLevel 告警级别指针
     * @return 成功  0/失败，参见错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C10B001
     */
    public int IVS_SDK_GetAlarmLevel(int sessionId, int alarmLevelId, Pointer alarmLevel);
    
    /** 
     * 查询告警类型列表
     * @param sessionId 登录成功后的会话ID
     * @param maxAlarmLevelNum IVS系统最大告警级别个数
     * @param alarmLevelNum 系统实际告警级别个数
     * @param pointer 告警级别列表指针
     * @param bufferSize 缓存大小
     * @return 成功  0/失败，参见错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C10B001
     */
    public int IVS_SDK_GetAlarmLevelList(int sessionId, int maxAlarmLevelNum, ByReference alarmLevelNum,
        Pointer pointer, int bufferSize);
        
    /**
     * 
     * 此接口用于查询用户分组列表
     *
     * @param sessionId 登录成功后的会话ID
     * @param domainCode 域编码
     * @param indexRangeSouth 分页索引结构体
     * @param userGroupList 用户分组查询分页信息
     * @param bufferSize 结构体大小
     * @return 成功  0/失败，参见错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C10
     */
    public int IVS_SDK_GetUserGroupList(int sessionId, String domainCode, IndexRangeSouth indexRangeSouth,
        Pointer userGroupList, int bufferSize);
        
    /** 
    * 查询操作日志
    * <功能详细描述>
    * @param iSessionID 登录成功后的会话ID
    * @param pUnifiedQuery 查询条件
    * @param pOperationLogList 操作日志列表查询分页信息
    * @param uiBufferSize 结构体大小
    * @return
    * @see [类、类#方法、类#成员]
    * since eSDK IVS V100R003C10B002
    */
    public int IVS_SDK_GetOperationLog(int iSessionID, QueryUnifiedFormatSouth pUnifiedQuery, Pointer pOperationLogList,
        int uiBufferSize);
        
    /**
     * 
     * 此接口用于查询角色列表
     *
     * @param sessionId 登录成功后的会话ID
     * @param domainCode 域编码
     * @param indexRangeSouth 分页索引结构体
     * @param roleInfoList 角色列表查询分页信息
     * @param bufferSize 结构体大小
     * @return 成功  0/失败，参见错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C10
     */
    public int IVS_SDK_GetRoleList(int sessionId, String domainCode,
        com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.IndexRangeSouth indexRangeSouth, Pointer roleInfoList,
        int bufferSize);
        
    /**
     * 此接口用于相同用户第二次登录时的鉴权
     * @param sessionId
     * @param userName
     * @param password
     * @return
     */
    public int IVS_SDK_PasswdValidation(int sessionId, String userName, String password);
    
    public int IVS_SDK_PlatformPlayBackPauseByIP(int sessionId, NativeLong playHandle);
    
    public int IVS_SDK_PlatformPlayBackResumeByIP(int sessionId, NativeLong playHandle);
    
    /**
     * 
     * 此接口用于设置平台录像码流回放时间
     *
     * @param sessionId 登录成功后的会话ID
     * @param playHandle 播放句柄
     * @param time 回放时间
     * @return 成功  0/失败，参见错误码
     * @see 
     * @since  eSDK IVS V100R003C30SPC100
     */
    public int IVS_SDK_SetPlayBackTimeByIP(int sessionId, NativeLong playHandle, int time);
    
    /**
     * 
     * 此接口用于设置平台录像码流回放速度
     *
     * @param sessionId 登录成功后的会话ID
     * @param playHandle 播放句柄
     * @param speed 播放速度
     * @return 成功  0/失败，参见错误码
     * @see 
     * @since  eSDK IVS V100R003C30SPC100
     */
    public int IVS_SDK_SetPlayBackSpeedByIP(int sessionId, NativeLong playHandle, float speed);
    
    /**
     * @param sessionId 登录成功后的会话ID
     * @param domainCode 域编码
     * @param cameraCode 摄像机编码
     * @param pointer 单台VCN的视频质量诊断计划xml
     * @return 成功返回0（IVS_SUCCEED），失败返回错误码
     */
    public int IVS_SDK_GetVideoDiagnose(int sessionId, String domainCode, String cameraCode, Pointer pointer);
    
    /**
     * @param sessionId 登录成功后的会话ID
     * @param reqXml 单台VCN的视频质量诊断计划xml
     * @return 成功返回0（IVS_SUCCEED），失败返回错误码
     */
    public int IVS_SDK_SetVideoDiagnose(int sessionId, String reqXml);
    
    /** 
     * 获取告警快照列表
     *
     * @param sessionId 登录成功后的会话ID
     * @param requestXML 传入xml数据
     * @param response 返回xml数据
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R005C10]
     */
    public int IVS_SDK_GetAlarmSnapshotList(int sessionId, String requestXML, Pointer response);
    
    /**
     * 平台抓拍
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @author  likun/l00295065
     * @return 成功  0/失败，参见错误码
     */
    public int IVS_SDK_PlatformSnapshot(int sessionId, String cameraCode);
    
    /**
     * 获取平台抓拍图片列表
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @param queryShapshotParam 抓拍图片查询参数
     * @param pointer 返回 抓拍图片列表信息
     * @param bufSize 缓存大小
     * @author  likun/l00295065
     * @return 成功  0/失败，参见错误码
     */
    public int IVS_SDK_GetSnapshotList(int sessionId, String cameraCode, QuerySnapshotParamSouth queryShapshotParam,
        Pointer pointer, int bufSize);
        
    /**
     * 删除平台抓拍图片
     * 
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @param pictureID 抓拍图片ID
     * @return 成功  0/失败，参见错误码
     * @author likun/l00295065
     * @since eSDK IVS V100R005C60
     */
    public int IVS_SDK_DeleteSnapshot(int sessionId, String cameraCode, int pictureID);
    
    /**
     * 获取RtspURL
     * 
     * @param sessionId 登录成功后的会话ID
     * @param cameraCode 摄像机编码
     * @param mediaURLParamSouth RTSP URL参数结构体
     * @param pointer 返回的RTSP URL地址
     * @param bufSize 存放URL的内存大小
     * @author  likun/l00295065
     * @return 成功  0/失败，参见错误码
     * @see [类、类#方法、类#成员]
     */
    public int IVS_SDK_GetRtspURL(int sessionId, String cameraCode, MediaURLParamSouth mediaURLParamSouth,
        Pointer pointer, int bufSize);
    
    /** 
    * 查询OMU告警事件列表
    * 根据查询索引范围、排序条件和查询条件类型查询出告警事件列表，当查询条件类型为摄像机编码为多个时，以英文“,”分割，最多30个编码
    *
    * @param iSessionId[in] 用户的sessionId
    * @param queryUnifiedFormatSouth[in] 查询条件，包含索引范围、排序条件和查询条件类型
    * @param pAlarmEventList[out] 告警事件列表
    * @param uiBufferSize[in] 缓存大小
    * @return 成功  0/失败，参见错误码
    * @author  likun/l00295065
    * @since <V100R005C70>
    */
    public int IVS_SDK_GetDeviceAlarmList(int iSessionId, QueryUnifiedFormatSouth queryUnifiedFormatSouth,
        Pointer pAlarmEventList, int uiBufferSize);
}
