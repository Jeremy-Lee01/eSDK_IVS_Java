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
package com.huawei.esdk.ivs.device.v100r001c10.alarmmanager;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.device.BaseCability;
import com.huawei.esdk.ivs.device.v100r001c10.alarmmanager.convert.AlarmMgrCabilityConvert;
import com.huawei.esdk.ivs.device.vcn3000.alarmmanager.IAlarmMgrCability;
import com.huawei.esdk.ivs.domain.model.Alarm;
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.huawei.esdk.ivs.domain.model.bean.AlarmCommissionInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmEventList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmLevel;
import com.huawei.esdk.ivs.domain.model.bean.AlarmLevelList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmOperateInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmReportInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceAlarmInfos;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmCommissionSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmEventListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmEventSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmLevelListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmLevelSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmOperateInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmReportSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmTypeListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.DeviceAlarmEventListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryUnifiedFormatSouth;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.NumberUtils;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.IntByReference;

/**
 * 警告模块南向接口管理类
 * <p>
 * 
 * @author cWX191990
 * @see [相关类/方法]
 * @since eSDK IVS V100R003C00
 */
public class AlarmMgrCability extends BaseCability implements IAlarmMgrCability {
	/**
	 * 日志对象
	 */
	private static final Logger LOGGER = Logger.getLogger(AlarmMgrCability.class);

	private static final AlarmTypeListSouth ALARM_TYPE_LIST_SOUTH = new AlarmTypeListSouth(
			NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("index.range")));

	private static final AlarmEventListSouth ALARM_EVENT_LIST_SOUTH = new AlarmEventListSouth(
			NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("index.range")));

	/**
	 * 南向数据转换类
	 */
	private AlarmMgrCabilityConvert alarmMgrCabilityConvert = new AlarmMgrCabilityConvert();

	/**
	 * 获取告警信息
	 *
	 * @param alarmEventId
	 *            告警事件ID
	 * @param alarmInCode
	 *            告警源编码
	 * @return SDKResult<Alarm> 封装领域层的SDKResult对象
	 * @since eSDK IVS V100R003C00
	 */
	public SDKResult<Alarm> getAlarmEventInfo(long alarmEventId, String alarmInCode) {
		AlarmEventSouth alarmEventSouth = new AlarmEventSouth();

		int sessionId = super.getIVSSessionId();

		Pointer pointer = alarmEventSouth.getPointer();
		int resultCode = 0;
		try {
			resultCode = super.getBaseCablilityJNA().IVS_SDK_GetAlarmEventInfo(sessionId, alarmEventId,
					alarmInCode.getBytes(System.getProperty("file.encoding")), pointer);
		} catch (UnsupportedEncodingException e) {
			resultCode = ErrInfo.DATA_ERRORCODE;
		}
		alarmEventSouth.read();

		// 转换成领域层的bean
		SDKResult<Alarm> result = new SDKResult<Alarm>();

		if (0 == resultCode) {
			Alarm alarm = alarmMgrCabilityConvert.getAlarmEventModel2Soap(alarmEventSouth);
			result.setResult(alarm);
		}

		result.setErrCode(resultCode);
		return result;
	}

	/**
	 * 获取告警事件列表
	 *
	 * @param queryUnifiedFormat
	 *            查询条件，包含索引范围、排序条件和查询条件类型
	 * @return SDKResult<AlarmEventList> 告警事件列表
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public synchronized SDKResult<AlarmEventList> getAlarmEventList(QueryUnifiedFormat queryUnifiedFormat) {
		QueryUnifiedFormatSouth queryUnifiedFormatSouth = alarmMgrCabilityConvert
				.getQueryUnifiedFormatSoap2Model(queryUnifiedFormat);

		int size = queryUnifiedFormatSouth.indexRangeSouth.toIndex - queryUnifiedFormatSouth.indexRangeSouth.fromIndex
				+ 1;

		// 若分页信息有误，则默认给一个初始值，由eSDK来返回错误码
		if (size < 1) {
			size = 1;
		}

		// AlarmEventListSouth alarmEventList = new AlarmEventListSouth(size);
		ALARM_EVENT_LIST_SOUTH.clear();
		// int bufferSize = alarmEventList.size();
		Pointer point = ALARM_EVENT_LIST_SOUTH.getPointer();

		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetAlarmEventList(sessionId, queryUnifiedFormatSouth,
				point, size * 5484 + 44);
		ALARM_EVENT_LIST_SOUTH.read();

		SDKResult<AlarmEventList> result = new SDKResult<AlarmEventList>();

		if (0 == resultCode) {
			result.setResult(alarmMgrCabilityConvert.getAlarmEventListModel2Soap(ALARM_EVENT_LIST_SOUTH));
		}

		result.setErrCode(resultCode);

		return result;
	}

	/**
	 * 告警订阅
	 *
	 * @param requestXML
	 *            告警订阅请求xml
	 * @return SDKErrorCode SDK返回码封装类
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode subscribeAlarm(String requestXML) {
		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_SubscribeAlarm(sessionId, requestXML);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);
		return result;
	}

	/**
	 * 告警订阅查询
	 *
	 * @param requestXML
	 *            告警订阅请求xml
	 * @return SDKResult<String> 告警订阅查询响应xml
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKResult<String> subscribeAlarmQuery(String requestXML) {
		int sessionId = super.getIVSSessionId();
		String[] strings = { "" };
		StringArray respXml = new StringArray(strings);
		respXml.clear();
		Pointer res = respXml;

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_SubscribeAlarmQuery(sessionId, requestXML, res);

		respXml.read();
		SDKResult<String> result = new SDKResult<String>();

		if (0 == resultCode) {
			strings = respXml.getStringArray(0);
			if (null != strings && 0 < strings.length) {
				result.setResult(strings[0]);
			}
		}

		result.setErrCode(resultCode);
		return result;
	}

	@Override
	public SDKResult<String> getAlarmLinkageAction(String requestXML) {
		int sessionId = super.getIVSSessionId();
		String[] strings = { "" };
		StringArray respXml = new StringArray(strings);
		respXml.clear();
		Pointer res = respXml;

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetAlarmLinkageAction(sessionId, requestXML, res);

		respXml.read();
		SDKResult<String> result = new SDKResult<String>();

		if (0 == resultCode) {
			strings = respXml.getStringArray(0);
			if (null != strings && 0 < strings.length) {
				result.setResult(strings[0]);
			}
		}

		result.setErrCode(resultCode);
		return result;
	}

	@Override
	public SDKResult<String> getAlarmLinkageList(String requestXML) {
		int sessionId = super.getIVSSessionId();
		String[] strings = { "" };
		StringArray respXml = new StringArray(strings);
		respXml.clear();
		Pointer res = respXml;

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetAlarmlinkageList(sessionId, requestXML, res);

		respXml.read();
		SDKResult<String> result = new SDKResult<String>();

		if (0 == resultCode) {
			strings = respXml.getStringArray(0);
			if (null != strings && 0 < strings.length) {
				result.setResult(strings[0]);
			}
		}

		result.setErrCode(resultCode);
		return result;
	}

	@Override
	public SDKResult<String> getAlarmLinkage(String requestXML) {
		int sessionId = super.getIVSSessionId();
		String[] strings = { "" };
		StringArray respXml = new StringArray(strings);
		respXml.clear();
		Pointer res = respXml;

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetAlarmLinkage(sessionId, requestXML, res);

		respXml.read();
		SDKResult<String> result = new SDKResult<String>();

		if (0 == resultCode) {
			strings = respXml.getStringArray(0);
			if (null != strings && 0 < strings.length) {
				result.setResult(strings[0]);
			}
		}

		result.setErrCode(resultCode);
		return result;
	}

	@Override
	public SDKErrorCode userAuthentication(String password) {
		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_UserAuthentication(sessionId, password);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);

		return result;
	}

	/**
	 * 新增告警联动策略
	 *
	 * @param requestXML
	 *            告警联动策略xml
	 * @return SDKResult<String> 新增告警联动策略响应xml
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKResult<String> addAlarmLinkage(String requestXML) {
		int sessionId = super.getIVSSessionId();
		String[] strings = { "" };
		StringArray respXml = new StringArray(strings);
		respXml.clear();
		Pointer res = respXml;

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_AddAlarmLinkage(sessionId, requestXML, res);

		respXml.read();
		SDKResult<String> result = new SDKResult<String>();

		if (0 == resultCode) {
			strings = respXml.getStringArray(0);
			if (null != strings && 0 < strings.length) {
				result.setResult(strings[0]);
			}
		}

		result.setErrCode(resultCode);
		return result;
	}

	/**
	 * 修改告警联动策略
	 *
	 * @param requestXML
	 *            修改联动策略xml
	 * @return SDKErrorCode 修改告警联动策略响应xml
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode modifyAlarmLinkage(String requestXML) {
		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_ModifyAlarmLinkage(sessionId, requestXML);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);
		return result;
	}

	/**
	 * 删除告警联动策略
	 *
	 * @param requestXML
	 *            删除告警联动策略xml
	 * @return SDKErrorCode 删除告警联动策略响应xml
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode deleteAlarmLinkage(String requestXML) {
		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_DeleteAlarmLinkage(sessionId, requestXML);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);
		return result;
	}

	/**
	 * 启动开关量输出告警
	 *
	 * @param alarmOutCode
	 *            开关量输出设备编码
	 * @return SDKErrorCode 启动开关量输出告警响应
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode startAlarmOut(String alarmOutCode) {
		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_StartAlarmOut(sessionId, alarmOutCode);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);
		return result;
	}

	/**
	 * 停止开关量输出告警
	 *
	 * @param alarmOutCode
	 *            开关量输出设备编码
	 * @return SDKErrorCode 停止开关量输出告警响应
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode stopAlarmOut(String alarmOutCode) {
		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_StopAlarmOut(sessionId, alarmOutCode);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);
		return result;
	}

	/**
	 * 告警确认 此接口用于确认告警信息为真实告警
	 * 
	 * @param alarmEventID
	 *            告警事件ID
	 * @param alarmInCode
	 *            告警源编码
	 * @param alarmOperateInfo
	 *            告警处理信息
	 * @return SDKErrorCode 成功返回0，失败返回错误码
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode alarmConfirm(long alarmEventId, String alarmInCode, AlarmOperateInfo alarmOperateInfo) {
		LOGGER.info("IVS_SDK_AlarmConfirm start --->>> ");

		int sessionId = super.getIVSSessionId();
		AlarmOperateInfoSouth south = alarmMgrCabilityConvert.getAlarmOperateInfoModel2South(alarmOperateInfo);
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_AlarmConfirm(sessionId, alarmEventId, alarmInCode, south);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);

		LOGGER.info("IVS_SDK_AlarmConfirm result code: " + resultCode);
		LOGGER.info("IVS_SDK_AlarmConfirm end --->>> ");

		return result;
	}

	/**
	 * 告警撤销 此接口用于撤销无效告警信息
	 * 
	 * @param alarmEventID
	 *            告警事件ID
	 * @param alarmInCode
	 *            告警源编码
	 * @param alarmOperateInfo
	 *            告警处理信息
	 * @return SDKErrorCode 成功返回0，失败返回错误码
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode alarmCancel(long alarmEventId, String alarmInCode, AlarmOperateInfo alarmOperateInfo) {
		LOGGER.info("IVS_SDK_AlarmCancel start --->>> ");

		int sessionId = super.getIVSSessionId();
		AlarmOperateInfoSouth south = alarmMgrCabilityConvert.getAlarmOperateInfoModel2South(alarmOperateInfo);
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_AlarmCancel(sessionId, alarmEventId, alarmInCode, south);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);

		LOGGER.info("IVS_SDK_AlarmCancel result code: " + resultCode);
		LOGGER.info("IVS_SDK_AlarmCancel end --->>> ");

		return result;
	}

	/**
	 * 告警授权 此接口用于将选定的告警信息授权给其他用户处理
	 * 
	 * @param alarmInCode
	 *            告警源编码
	 * @param alarmCommissionInfo
	 *            告警授权信息
	 * @return SDKErrorCode 成功返回0，失败返回错误码
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode alarmCommission(String alarmInCode, AlarmCommissionInfo alarmCommissionInfo) {
		LOGGER.info("IVS_SDK_AlarmCommission start --->>> ");

		int sessionId = super.getIVSSessionId();
		AlarmCommissionSouth south = alarmMgrCabilityConvert.getAlarmCommissionModel2South(alarmCommissionInfo);
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_AlarmCommission(sessionId, alarmInCode, south);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);

		LOGGER.info("IVS_SDK_AlarmCommission result code: " + resultCode);
		LOGGER.info("IVS_SDK_AlarmCommission end --->>> ");

		return result;
	}

	/**
	 * 告警上报
	 * 
	 * @param alarmReportInfo
	 *            告警上报信息
	 * @return SDKErrorCode 成功返回0，失败返回错误码
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	@Override
	public SDKErrorCode alarmReport(AlarmReportInfo alarmReportInfo) {
		LOGGER.info("IVS_SDK_AlarmReport start --->>> ");

		int sessionId = super.getIVSSessionId();
		AlarmReportSouth south = alarmMgrCabilityConvert.getAlarmReportModel2South(alarmReportInfo);
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_AlarmReport(sessionId, south);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);

		LOGGER.info("IVS_SDK_AlarmReport result code: " + resultCode);
		LOGGER.info("IVS_SDK_AlarmReport end --->>> ");

		return result;
	}

	/**
	 * 设置告警类型级别
	 * 
	 * @param AlarmTypeList
	 *            需要设置的告警类型列表
	 * @return SDKErrorCode 成功返回0，失败返回错误码
	 * @see [类、类#方法、类#成员]
	 * @since [eSDK IVS V100R003C10]
	 */
	@Override
	public SDKErrorCode setAlarmTypeLevel(AlarmTypeInfos alarmTypeList) {
		LOGGER.info("setAlarmTypeLevel start --->>> ");

		int sessionId = super.getIVSSessionId();
		AlarmTypeListSouth alarmTypeListSouth = alarmMgrCabilityConvert.getAlarmTypeListModel2South(alarmTypeList);
		int resultCode = super.getBaseCablilityJNA().IVS_SDK_SetAlarmTypeLevel(sessionId, alarmTypeListSouth);

		SDKErrorCode result = new SDKErrorCode();
		result.setErrCode(resultCode);

		LOGGER.info("setAlarmTypeLevel result code: " + resultCode);
		LOGGER.info("setAlarmTypeLevel end --->>> ");
		return result;
	}

	/**
	 * 查询告警类型列表
	 * 
	 * @param queryUnifiedFormat
	 *            查询结构体
	 * @return SDKResult<AlarmTypeInfos> 告警类型列表
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C10B001
	 */
	@Override
	public synchronized SDKResult<AlarmTypeInfos> getAlarmTypeList(QueryUnifiedFormat queryUnifiedFormat) {
		QueryUnifiedFormatSouth queryUnifiedFormatSouth = alarmMgrCabilityConvert
				.getQueryUnifiedFormatSoap2Model(queryUnifiedFormat);

		int size = queryUnifiedFormatSouth.indexRangeSouth.toIndex - queryUnifiedFormatSouth.indexRangeSouth.fromIndex
				+ 1;

		// 若分页信息有误，则默认给一个初始值，由eSDK来返回错误码
		if (size < 1) {
			size = 1;
		}

		// AlarmTypeListSouth alarmTypeList = new AlarmTypeListSouth(size);
		ALARM_TYPE_LIST_SOUTH.clear();
		// int bufferSize = alarmTypeList.size();
		Pointer point = ALARM_TYPE_LIST_SOUTH.getPointer();
		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetAlarmTypeList(sessionId, queryUnifiedFormatSouth, point,
				size * 1592 + 44);

		ALARM_TYPE_LIST_SOUTH.read();
		SDKResult<AlarmTypeInfos> result = new SDKResult<AlarmTypeInfos>();

		if (0 == resultCode) {
			// 转换成领域层对象
			result.setResult(alarmMgrCabilityConvert.getAlarmTypeListModel2Soap(ALARM_TYPE_LIST_SOUTH));
		}

		result.setErrCode(resultCode);

		return result;
	}

	/**
	 * 查询告警级别信息
	 * 
	 * @param alarmLevelId
	 *            告警级别ID
	 * @return SDKResult<AlarmLevel> 告警级别信息
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C10B001
	 */
	@Override
	public SDKResult<AlarmLevel> getAlarmLevel(int alarmLevelId) {
		AlarmLevelSouth alarmLevelSouth = new AlarmLevelSouth();
		Pointer pointer = alarmLevelSouth.getPointer();
		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetAlarmLevel(sessionId, alarmLevelId, pointer);
		alarmLevelSouth.read();

		SDKResult<AlarmLevel> result = new SDKResult<AlarmLevel>();
		result.setErrCode(resultCode);

		if (0 == resultCode) {
			// 转换
			result.setResult(alarmMgrCabilityConvert.getAlarmLevelModel2Soap(alarmLevelSouth));
		}

		return result;
	}

	/**
	 * 查询告警级别列表
	 * 
	 * @return SDKResult<AlarmLevelList> 告警级别信息列表
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C10B001
	 */
	@Override
	public SDKResult<AlarmLevelList> getAlarmLevelList() {
		// 固定最大个数为20
		int maxAlarmLevelNum = CommonConstant.AlarmModule.IVS_MAX_ALARM_LEVEL_NUM;
		AlarmLevelListSouth alarmLevelListSouth = new AlarmLevelListSouth(maxAlarmLevelNum);
		Pointer pointer = alarmLevelListSouth.getPointer();
		int bufferSize = alarmLevelListSouth.size();
		IntByReference alarmLevelNum = new IntByReference();
		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetAlarmLevelList(sessionId, maxAlarmLevelNum,
				alarmLevelNum, pointer, bufferSize);
		alarmLevelListSouth.read();

		SDKResult<AlarmLevelList> result = new SDKResult<AlarmLevelList>();
		result.setErrCode(resultCode);

		if (0 == resultCode) {
			// 转换
			result.setResult(
					alarmMgrCabilityConvert.getAlarmLevelListModel2Soap(alarmLevelListSouth, alarmLevelNum.getValue()));
		}

		return result;
	}

	/**
	 * 查询告警快照列表
	 * 
	 * @return SDKResult<AlarmLevelList> 告警快照信息列表
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R005C10
	 */
	@Override
	public SDKResult<String> getAlarmSnapshotList(String requestXML) {
		int sessionId = super.getIVSSessionId();
		String[] strings = { "" };
		StringArray respXml = new StringArray(strings);
		respXml.clear();
		Pointer res = respXml;

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetAlarmSnapshotList(sessionId, requestXML, res);

		respXml.read();
		SDKResult<String> result = new SDKResult<String>();

		if (0 == resultCode) {
			strings = respXml.getStringArray(0);
			if (null != strings && 0 < strings.length) {
				result.setResult(strings[0]);
			}
		}

		result.setErrCode(resultCode);
		return result;
	}

	@Override
	public SDKResult<DeviceAlarmInfos> getDeviceAlarmList(QueryUnifiedFormat queryUnifiedFormat) {
		QueryUnifiedFormatSouth queryUnifiedFormatSouth = alarmMgrCabilityConvert
				.getQueryUnifiedFormatSoap2Model(queryUnifiedFormat);

		int size = queryUnifiedFormatSouth.indexRangeSouth.toIndex - queryUnifiedFormatSouth.indexRangeSouth.fromIndex
				+ 1;

		// 若分页信息有误，则默认给一个初始值，由eSDK来返回错误码
		if (size < 1) {
			size = 1;
		}

		DeviceAlarmEventListSouth deviceAlarmEventListSouth = new DeviceAlarmEventListSouth(NumberUtils
				.parseIntValue(ConfigManager.getInstance().getValue("index.range")));
		deviceAlarmEventListSouth.clear();

		int sessionId = super.getIVSSessionId();

		int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetDeviceAlarmList(sessionId, queryUnifiedFormatSouth,
				deviceAlarmEventListSouth.getPointer(), size * 3984 + 44);
		deviceAlarmEventListSouth.read();

		SDKResult<DeviceAlarmInfos> result = new SDKResult<DeviceAlarmInfos>();

		if (0 == resultCode) {
			result.setResult(alarmMgrCabilityConvert.getDeviceAlarmEventListModel2Soap(deviceAlarmEventListSouth));
		}

		result.setErrCode(resultCode);

		return result;
	}
}
