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
package com.huawei.esdk.ivs.device.v100r001c10.alarmmanager.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.Alarm;
import com.huawei.esdk.ivs.domain.model.bean.AlarmCommissionInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmEventList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmLevel;
import com.huawei.esdk.ivs.domain.model.bean.AlarmLevelList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmNotify;
import com.huawei.esdk.ivs.domain.model.bean.AlarmOperateInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmOpreateInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmReportInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceAlarmInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceAlarmNotifyInfo;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.UserIdInfo;
import com.huawei.esdk.ivs.domain.util.IVSUtil;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmCommissionSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmEventListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmEventSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmLevelListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmLevelSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmNotifySouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmOperateInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmReportSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmTypeListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.AlarmTypeSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.DeviceAlarmEventListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.DeviceAlarmNotifySouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.IndexRangeSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryFieldSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryUnifiedFormatSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.UserIdInfoSouth;
import com.huawei.esdk.platform.common.utils.BytesUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;

/**
 * 领域层与南向数据转换类
 * <p>
 * 
 * @author cWX191990
 * @see [相关类/方法]
 * @since eSDK IVS V100R003C00
 */
public class AlarmMgrCabilityConvert {

	/**
	 * 领域层的QueryUnifiedFormat转换为南向的
	 *
	 * @param queryUnifiedFormat
	 *            查询通用格式
	 * @return QueryUnifiedFormatSouth 南向查询通用格式
	 * @since eSDK IVS V100R003C00
	 */
	public QueryUnifiedFormatSouth getQueryUnifiedFormatSoap2Model(QueryUnifiedFormat queryUnifiedFormat) {
		// modify by cWX191990，fieldNum小于0时，默认也需要初始化一个查询条件，问题单号DTS2014022507270
		QueryUnifiedFormatSouth queryUnifiedFormatSouth = null;

		if (queryUnifiedFormat.getQueryField().size() == 0) {
			queryUnifiedFormatSouth = new QueryUnifiedFormatSouth(1);
		} else {
			queryUnifiedFormatSouth = new QueryUnifiedFormatSouth(queryUnifiedFormat.getQueryField().size());
		}

		// 固定内存
		queryUnifiedFormatSouth.clear();

		// 转换
		queryUnifiedFormatSouth.fieldNum = queryUnifiedFormat.getFieldNum();

		queryUnifiedFormatSouth.indexRangeSouth.fromIndex = queryUnifiedFormat.getIndex().getFromIndex();
		queryUnifiedFormatSouth.indexRangeSouth.toIndex = queryUnifiedFormat.getIndex().getToIndex();

		queryUnifiedFormatSouth.orderConditionSouth.enableOrder = queryUnifiedFormat.getOrderCondition()
				.getEnableOrder();
		queryUnifiedFormatSouth.orderConditionSouth.field = queryUnifiedFormat.getOrderCondition().getField();
		queryUnifiedFormatSouth.orderConditionSouth.isAscend = queryUnifiedFormat.getOrderCondition().getIsAscend();

		QueryFieldSouth[] qfSouth = null;

		if (queryUnifiedFormat.getQueryField().size() == 0) {
			qfSouth = new QueryFieldSouth[1];
		} else {
			qfSouth = new QueryFieldSouth[queryUnifiedFormat.getQueryField().size()];

			for (int i = 0; i < queryUnifiedFormat.getQueryField().size(); i++) {
				QueryFieldSouth qfs = new QueryFieldSouth();

				// 固定内存
				qfs.clear();
				qfs.exactQuery = queryUnifiedFormat.getQueryField().get(i).getExactQuery();
				qfs.field = queryUnifiedFormat.getQueryField().get(i).getFieldType();
				qfs.value = BytesUtils.stringToBytesForIVS(queryUnifiedFormat.getQueryField().get(i).getValue());
				qfSouth[i] = qfs;
			}
		}

		queryUnifiedFormatSouth.queryFieldSouth = qfSouth;

		return queryUnifiedFormatSouth;
	}

	/**
	 * 南向告警事件列表转换成领域层告警事件列表
	 *
	 * @param alarmEventListSouth
	 *            南向告警事件列表
	 * @return AlarmEventList 领域层告警事件列表
	 * @since eSDK IVS V100R003C00
	 */
	public AlarmEventList getAlarmEventListModel2Soap(AlarmEventListSouth alarmEventListSouth) {
		AlarmEventList alarmEventList = new AlarmEventList();
		alarmEventList.setReserve(BytesUtils.bytesToStringForIVS(alarmEventListSouth.reserve));
		alarmEventList.setTotal(alarmEventListSouth.total);

		IndexRange iRange = new IndexRange();
		iRange.setFromIndex(alarmEventListSouth.indexRange.fromIndex);
		iRange.setToIndex(alarmEventListSouth.indexRange.toIndex);
		alarmEventList.setIndexRange(iRange);

		AlarmEventSouth[] alarmEventSouths = alarmEventListSouth.alarmEventSouth;

		if (null != alarmEventSouths && alarmEventSouths.length > 0) {

			int length = getLength(alarmEventListSouth.total, alarmEventSouths.length,
					alarmEventListSouth.indexRange.fromIndex, alarmEventListSouth.indexRange.toIndex);
			List<Alarm> list = alarmEventList.getAlarmEventInfos();

			for (int i = 0; i < length; i++) {
				list.add(getAlarmEventModel2Soap(alarmEventSouths[i]));
			}

			alarmEventList.setAlarmEventInfos(list);
		}

		return alarmEventList;
	}

	public int getLength(int total, int size, int fromIndex, int toIndex) {
		int length = 0;
		if (total < size) {
			length = toIndex < total ? toIndex : total;
			int temp = length - (fromIndex > 1 ? fromIndex : 1) + 1;
			length = length < temp ? length : temp;
		} else {
			length = toIndex < total ? toIndex : total;
			int temp = length - (fromIndex > 1 ? fromIndex : 1) + 1;
			length = size < temp ? size : temp;
		}
		return length;
	}

	/**
	 * 将南向的bean转换成领域层的bean
	 *
	 * @param alarmEventSouth
	 *            南向告警对象
	 * @return Alarm 领域层告警对象
	 * @since eSDK IVS V100R003C00
	 */
	public Alarm getAlarmEventModel2Soap(AlarmEventSouth alarmEventSouth) {
		// 定义领域层和南向的bean对象
		Alarm alarm = new Alarm();
		AlarmNotify alarmNotify = new AlarmNotify();
		AlarmOpreateInfo alarmOpreateInfo = new AlarmOpreateInfo();

		AlarmNotifySouth alarmNotifySouth = alarmEventSouth.alarmNotifySouth;
		AlarmOperateInfoSouth alarmOperateInfoSouth = alarmEventSouth.alarmOperateInfoSouth;

		// 数据转换
		alarmNotify.setAlarmCategory(BytesUtils.bytesToStringForIVS(alarmNotifySouth.alarmCategory));
		alarmNotify.setAlarmDesc(BytesUtils.bytesToStringForIVS(alarmNotifySouth.alarmDesc));
		alarmNotify.setAlarmEventId(alarmNotifySouth.alarmEventId);
		alarmNotify.setAlarmInCode(BytesUtils.bytesToStringForIVS(alarmNotifySouth.alarmInCode));
		alarmNotify.setAlarmInName(BytesUtils.bytesToStringForIVS(alarmNotifySouth.alarmInName));
		alarmNotify.setAlarmInType(alarmNotifySouth.alarmInType);
		alarmNotify.setAlarmLevelColor(BytesUtils.bytesToStringForIVS(alarmNotifySouth.alarmLevelColor));
		alarmNotify.setAlarmLevelName(BytesUtils.bytesToStringForIVS(alarmNotifySouth.alarmLevelName));
		alarmNotify.setAlarmLevelValue(alarmNotifySouth.alarmLevelValue);
		alarmNotify.setAlarmStatus(alarmNotifySouth.alarmStatus);
		alarmNotify.setAlarmType(BytesUtils.bytesToStringForIVS(alarmNotifySouth.alarmType));
		alarmNotify.setAlarmTypeName(BytesUtils.bytesToStringForIVS(alarmNotifySouth.alarmTypeName));
		alarmNotify.setDeviceDomainCode(BytesUtils.bytesToStringForIVS(alarmNotifySouth.deviceDomainCode));
		alarmNotify.setExistsRecord(alarmNotifySouth.existsRecord);
		alarmNotify.setExtParam(BytesUtils.bytesToStringForIVS(alarmNotifySouth.extParam));
		alarmNotify.setIsCommission(alarmNotifySouth.isCommission);
		alarmNotify.setNvrCode(BytesUtils.bytesToStringForIVS(alarmNotifySouth.nvrCode));
		alarmNotify.setOccurentNumber(alarmNotifySouth.occurentNumber);
		alarmNotify.setOccurentTime(BytesUtils.bytesToStringForIVS(alarmNotifySouth.occurentTime));
		alarmNotify.setPreviewUrl(BytesUtils.bytesToStringForIVS(alarmNotifySouth.previewUrl));
		alarmNotify.setReserve(BytesUtils.bytesToStringForIVS(alarmNotifySouth.reserve));

		alarmOpreateInfo.setOperateInfo(BytesUtils.bytesToStringForIVS(alarmOperateInfoSouth.operateInfo));
		alarmOpreateInfo.setOperateTime(BytesUtils.bytesToStringForIVS(alarmOperateInfoSouth.operateTime));
		alarmOpreateInfo.setOperatorId(alarmOperateInfoSouth.operatorId);
		alarmOpreateInfo.setOperatorName(BytesUtils.bytesToStringForIVS(alarmOperateInfoSouth.operatorName));
		alarmOpreateInfo.setReserver(BytesUtils.bytesToStringForIVS(alarmOperateInfoSouth.reserver));

		alarm.setAlarmNotify(alarmNotify);
		alarm.setAlarmOpreateInfo(alarmOpreateInfo);

		return alarm;
	}

	/**
	 * 告警处理信息领域bean转换为南向bean
	 * 
	 * @param alarmOperateInfo
	 *            告警处理信息领域bean
	 * @return 告警处理信息南向bean
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	public AlarmOperateInfoSouth getAlarmOperateInfoModel2South(AlarmOperateInfo domain) {
		AlarmOperateInfoSouth south = new AlarmOperateInfoSouth();
		south.clear();
		south.operateInfo = BytesUtils.stringToBytesForIVS(domain.getOperateInfo());
		south.operateTime = BytesUtils.stringToBytesForIVS(domain.getOperateTime());
		south.operatorId = domain.getOperatorId();
		south.operatorName = BytesUtils.stringToBytesForIVS(domain.getOperatorName());
		south.reserver = BytesUtils.stringToBytesForIVS(domain.getReserve());
		return south;
	}

	/**
	 * 告警授权信息领域bean转换为南向bean
	 * 
	 * @param slarmCommissionInfo
	 *            告警授权信息领域bean
	 * @return 告警授权信息南向bean
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	public AlarmCommissionSouth getAlarmCommissionModel2South(AlarmCommissionInfo domain) {
		AlarmCommissionSouth south = new AlarmCommissionSouth();
		south.alarmEventId = domain.getAlarmEventId();
		south.userNum = domain.getUserNum();
		List<UserIdInfo> userIdInfos = domain.getUserIdInfos();
		if (null != userIdInfos) {
			UserIdInfoSouth[] userInfoSouths = new UserIdInfoSouth[userIdInfos.size()];
			for (int i = 0; i < userIdInfos.size(); i++) {
				UserIdInfo userIdInfo = userIdInfos.get(i);
				if (null != userIdInfo) {
					UserIdInfoSouth userIdInfoSouth = new UserIdInfoSouth();
					userIdInfoSouth.domainCode = BytesUtils.stringToBytesForIVS(userIdInfo.getDomainCode());
					userIdInfoSouth.userId = userIdInfo.getUserId();
					userInfoSouths[i] = userIdInfoSouth;
				}
			}
			south.userInfos = userInfoSouths;
		}
		return south;
	}

	/**
	 * 告警上报信息领域bean转换为南向bean
	 * 
	 * @param alarmReportInfo
	 *            告警上报信息领域bean
	 * @return 告警上报信息南向bean
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	public AlarmReportSouth getAlarmReportModel2South(AlarmReportInfo domain) {
		AlarmReportSouth south = new AlarmReportSouth();
		south.clear();

		south.action = domain.getAction();
		south.alarmDesc = BytesUtils.stringToBytesForIVS(domain.getAlarmDesc());
		south.alarmID = BytesUtils.stringToBytesForIVS(domain.getAlarmId());
		south.alarmInCode = BytesUtils.stringToBytesForIVS(domain.getAlarmInCode());
		south.alarmType = BytesUtils.stringToBytesForIVS(domain.getAlarmType());
		south.devDomainCode = BytesUtils.stringToBytesForIVS(domain.getDeviceDomainCode());
		south.extParam = BytesUtils.stringToBytesForIVS(domain.getExtParam());
		south.nvrCode = BytesUtils.stringToBytesForIVS(domain.getNvrCode());
		south.occurNumber = domain.getOccurNumber();
		south.occurTime = BytesUtils.stringToBytesForIVS(domain.getOccurTime());
		south.reportTime = BytesUtils.stringToBytesForIVS(domain.getReportTime());
		south.reserve = BytesUtils.stringToBytesForIVS(domain.getReserve());
		return south;
	}

	/**
	 * 告警类型级别领域bean转换为南向bean
	 * 
	 * @param domain
	 *            告警类型级别领域bean
	 * @return 告警类型级别南向bean
	 * @see [类、类#方法、类#成员]
	 * @since [eSDK IVS V100R003C10]
	 */
	public AlarmTypeListSouth getAlarmTypeListModel2South(AlarmTypeInfos domain) {
		int size = domain.getAlarmTypeListInfos().size();
		AlarmTypeListSouth south = new AlarmTypeListSouth(size);
		south.clear();
		south.total = domain.getTotal();
		if (!StringUtils.isEmpty(domain.getReserve())) {
			south.reserve = BytesUtils.stringToBytesForIVS(domain.getReserve());
		}

		south.indexRange = getIndexRangeModel2South(domain.getIndexRange());

		for (int i = 0; i < size; i++) {
			AlarmTypeSouth alarmTypeSouth = getAlarmTypeModel2South(domain.getAlarmTypeListInfos().get(i));

			south.alarmTypes[i] = alarmTypeSouth;
		}

		return south;
	}

	public AlarmTypeSouth[] getAlarmTypeListInfosModel2South(List<AlarmTypeInfo> domains) {
		int size = domains.size();
		AlarmTypeSouth[] souths = new AlarmTypeSouth[size];

		for (int i = 0; i < size; i++) {
			souths[i] = getAlarmTypeModel2South(domains.get(i));
		}

		return souths;
	}

	public AlarmTypeSouth getAlarmTypeModel2South(AlarmTypeInfo domain) {
		AlarmTypeSouth south = new AlarmTypeSouth();
		south.clear();
		south.alarmInType = domain.getAlarmInType();
		south.alarmLevel = getAlarmLevelModel2South(domain.getAlarmLevel());
		south.category = BytesUtils.stringToBytesForIVS(domain.getCategory());
		south.enable = domain.getEnable();
		south.id = domain.getAlarmTypeID();
		south.isUserDefined = domain.getIsUserDefined();
		south.name = BytesUtils.stringToBytesForIVS(domain.getAlarmTypeName());
		if (!StringUtils.isEmpty(domain.getReserve())) {
			south.reserve = BytesUtils.stringToBytesForIVS(domain.getReserve());
		}
		south.type = BytesUtils.stringToBytesForIVS(domain.getAlarmTypeCode());

		return south;
	}

	public AlarmLevelSouth getAlarmLevelModel2South(AlarmLevel domain) {
		AlarmLevelSouth south = new AlarmLevelSouth();
		south.clear();
		south.alarmLevelId = domain.getAlarmLevelId();
		south.color = BytesUtils.stringToBytesForIVS(domain.getColor());
		south.description = BytesUtils.stringToBytesForIVS(domain.getDescription());
		south.isUserDefined = domain.getIsUserDefined();
		south.name = BytesUtils.stringToBytesForIVS(domain.getAlarmLevelName());
		if (!StringUtils.isEmpty(domain.getReserve())) {
			south.reserve = BytesUtils.stringToBytesForIVS(domain.getReserve());
		}
		south.value = domain.getValue();
		return south;
	}

	public IndexRangeSouth getIndexRangeModel2South(IndexRange domain) {
		IndexRangeSouth south = new IndexRangeSouth();
		if (null != domain) {
			south.fromIndex = domain.getFromIndex();
			south.toIndex = domain.getToIndex();
		}
		return south;
	}

	/**
	 * 获取告警类型列表南向转领域
	 * 
	 * @param alarmTypeListSouth
	 *            告警类型列表
	 * @return AlarmTypeInfos 领域层告警类型列表
	 * @see [类、类#方法、类#成员]
	 * @since [eSDK IVS V100R001C10B001]
	 */
	public AlarmTypeInfos getAlarmTypeListModel2Soap(AlarmTypeListSouth alarmTypeListSouth) {
		AlarmTypeInfos alarmTypeInfos = new AlarmTypeInfos();

		// 转换总记录数和保留字段
		alarmTypeInfos.setTotal(alarmTypeListSouth.total);
		alarmTypeInfos.setReserve(BytesUtils.bytesToStringForIVS(alarmTypeListSouth.reserve));

		// 转换分页信息
		IndexRange iRange = new IndexRange();
		iRange.setFromIndex(alarmTypeListSouth.indexRange.fromIndex);
		iRange.setToIndex(alarmTypeListSouth.indexRange.toIndex);
		alarmTypeInfos.setIndexRange(iRange);

		AlarmTypeSouth[] alarmTypeSouths = alarmTypeListSouth.alarmTypes;

		if (null != alarmTypeSouths && alarmTypeSouths.length > 0) {

			int length = getLength(alarmTypeListSouth.total, alarmTypeSouths.length,
					alarmTypeListSouth.indexRange.fromIndex, alarmTypeListSouth.indexRange.toIndex);

			List<AlarmTypeInfo> list = alarmTypeInfos.getAlarmTypeListInfos();

			for (int i = 0; i < length; i++) {
				list.add(getAlarmTypeInfoModel2Soap(alarmTypeSouths[i]));
			}

			alarmTypeInfos.setAlarmTypeListInfos(list);
		}

		return alarmTypeInfos;
	}

	public AlarmTypeInfo getAlarmTypeInfoModel2Soap(AlarmTypeSouth alarmTypeSouth) {
		AlarmTypeInfo alarmTypeInfo = new AlarmTypeInfo();

		alarmTypeInfo.setAlarmTypeID(alarmTypeSouth.id);
		alarmTypeInfo.setAlarmInType(alarmTypeSouth.alarmInType);
		alarmTypeInfo.setAlarmTypeName(BytesUtils.bytesToStringForIVS(alarmTypeSouth.name));
		alarmTypeInfo.setCategory(BytesUtils.bytesToStringForIVS(alarmTypeSouth.category));
		alarmTypeInfo.setEnable(alarmTypeSouth.enable);
		alarmTypeInfo.setIsUserDefined(alarmTypeSouth.isUserDefined);
		alarmTypeInfo.setReserve(BytesUtils.bytesToStringForIVS(alarmTypeSouth.reserve));
		alarmTypeInfo.setAlarmTypeCode(BytesUtils.bytesToStringForIVS(alarmTypeSouth.type));

		AlarmLevel alarmLevel = new AlarmLevel();
		alarmLevel.setAlarmLevelId(alarmTypeSouth.alarmLevel.alarmLevelId);
		alarmLevel.setAlarmLevelName(BytesUtils.bytesToStringForIVS(alarmTypeSouth.alarmLevel.name));
		alarmLevel.setColor(BytesUtils.bytesToStringForIVS(alarmTypeSouth.alarmLevel.color));
		alarmLevel.setDescription(BytesUtils.bytesToStringForIVS(alarmTypeSouth.alarmLevel.description));
		alarmLevel.setIsUserDefined(alarmTypeSouth.alarmLevel.isUserDefined);
		alarmLevel.setReserve(BytesUtils.bytesToStringForIVS(alarmTypeSouth.alarmLevel.reserve));
		alarmLevel.setValue(alarmTypeSouth.alarmLevel.value);

		alarmTypeInfo.setAlarmLevel(alarmLevel);

		return alarmTypeInfo;
	}

	public AlarmLevel getAlarmLevelModel2Soap(AlarmLevelSouth alarmLevelSouth) {
		AlarmLevel alarmLevel = new AlarmLevel();
		alarmLevel.setAlarmLevelId(alarmLevelSouth.alarmLevelId);
		alarmLevel.setAlarmLevelName(BytesUtils.bytesToStringForIVS(alarmLevelSouth.name));
		alarmLevel.setColor(BytesUtils.bytesToStringForIVS(alarmLevelSouth.color));
		alarmLevel.setDescription(BytesUtils.bytesToStringForIVS(alarmLevelSouth.description));
		alarmLevel.setIsUserDefined(alarmLevelSouth.isUserDefined);
		alarmLevel.setReserve(BytesUtils.bytesToStringForIVS(alarmLevelSouth.reserve));
		alarmLevel.setValue(alarmLevelSouth.value);

		return alarmLevel;
	}

	public AlarmLevelList getAlarmLevelListModel2Soap(AlarmLevelListSouth alarmLevelListSouth, int alarmLevelSize) {
		AlarmLevelList alarmLevelList = new AlarmLevelList();
		alarmLevelList.setAlarmLevelNum(alarmLevelSize);

		List<AlarmLevel> list = new ArrayList<AlarmLevel>();
		// AlarmLevel alarmLevel = null;

		for (int i = 0; i < alarmLevelSize; i++) {
			// alarmLevel = new AlarmLevel();
			// alarmLevel.setAlarmLevelId(alarmLevelListSouth.alarmLevelSouths[i].alarmLevelId);
			// alarmLevel.setAlarmLevelName(BytesUtils.bytesToStringForIVS(alarmLevelListSouth.alarmLevelSouths[i].name));
			// alarmLevel.setColor(BytesUtils.bytesToStringForIVS(alarmLevelListSouth.alarmLevelSouths[i].color));
			// alarmLevel.setDescription(BytesUtils.bytesToStringForIVS(alarmLevelListSouth.alarmLevelSouths[i].description));
			// alarmLevel.setIsUserDefined(alarmLevelListSouth.alarmLevelSouths[i].isUserDefined);
			// alarmLevel.setReserve(BytesUtils.bytesToStringForIVS(alarmLevelListSouth.alarmLevelSouths[i].reserve));
			// alarmLevel.setValue(alarmLevelListSouth.alarmLevelSouths[i].value);
			list.add(getAlarmLevelModel2Soap(alarmLevelListSouth.alarmLevelSouths[i]));
		}

		if (!IVSUtil.isCollectionEmpty(list)) {
			alarmLevelList.setAlarmLevels(list);
		}

		return alarmLevelList;
	}

	/**
	 * 南向设备告警事件列表转换成领域层设备告警事件列表
	 *
	 * @param deviceAlarmEventListSouth
	 *            南向设备告警事件列表
	 * @return deviceAlarmEventList 领域层设备告警事件列表
	 * @since eSDK IVS V100R005C70
	 */
	public DeviceAlarmInfos getDeviceAlarmEventListModel2Soap(DeviceAlarmEventListSouth deviceAlarmEventListSouth) {
		DeviceAlarmInfos deviceAlarmInfos = new DeviceAlarmInfos();
		deviceAlarmInfos.setReserve(BytesUtils.bytesToStringForIVS(deviceAlarmEventListSouth.reserve));
		deviceAlarmInfos.setTotal(deviceAlarmEventListSouth.total);

		IndexRange iRange = new IndexRange();
		iRange.setFromIndex(deviceAlarmEventListSouth.indexRange.fromIndex);
		iRange.setToIndex(deviceAlarmEventListSouth.indexRange.toIndex);
		deviceAlarmInfos.setIndexRange(iRange);

		DeviceAlarmNotifySouth[] deviceAlarmNotifies = deviceAlarmEventListSouth.deviceAlarmNotifies;

		if (null != deviceAlarmNotifies && deviceAlarmNotifies.length > 0) {

			int length = getLength(deviceAlarmEventListSouth.total, deviceAlarmNotifies.length,
					deviceAlarmEventListSouth.indexRange.fromIndex, deviceAlarmEventListSouth.indexRange.toIndex);
			List<DeviceAlarmNotifyInfo> list = deviceAlarmInfos.getDeviceAlarmNotifies();

			for (int i = 0; i < length; i++) {
				list.add(getAlarmNotifyModel2Soap(deviceAlarmNotifies[i]));
			}

			deviceAlarmInfos.setDeviceAlarmNotifies(list);
		}

		return deviceAlarmInfos;
	}

	/**
	 * 将南向的bean转换成领域层的bean
	 *
	 * @param deviceAlarmNotify
	 *            南向设备告警对象
	 * @return DeviceAlarmNotifyInfo 领域层设备告警对象
	 * @since eSDK IVS V100R005C70
	 */
	public DeviceAlarmNotifyInfo getAlarmNotifyModel2Soap(DeviceAlarmNotifySouth deviceAlarmNotify) {
		// 定义领域层和南向的bean对象
		DeviceAlarmNotifyInfo deviceAlarmNotifyInfo = new DeviceAlarmNotifyInfo();

		// 数据转换
		deviceAlarmNotifyInfo.setAlarmEventID(deviceAlarmNotify.alarmEventID);
		deviceAlarmNotifyInfo.setAlarmInCode(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.alarmInCode));
		deviceAlarmNotifyInfo.setAlarmInType(deviceAlarmNotify.alarmInType);
		deviceAlarmNotifyInfo.setAlarmInName(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.alarmInName));
		deviceAlarmNotifyInfo.setNodeType(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.nodeType));
		deviceAlarmNotifyInfo.setAlarmLevelValue(deviceAlarmNotify.alarmLevelValue);
		deviceAlarmNotifyInfo.setAlarmType(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.alarmType));
		deviceAlarmNotifyInfo.setAlarmCategory(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.alarmCategory));
		deviceAlarmNotifyInfo.setOccurFirstTime(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.occurFirstTime));
		deviceAlarmNotifyInfo.setOccurEndTime(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.occurEndTime));
		deviceAlarmNotifyInfo.setOccurNumber(deviceAlarmNotify.occurNumber);
		deviceAlarmNotifyInfo.setReserver(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.reserver));
		deviceAlarmNotifyInfo.setLocationInfo(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.locationInfo));
		deviceAlarmNotifyInfo.setNetEleID(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.netEleID));
		deviceAlarmNotifyInfo.setNetName(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.netName));
		deviceAlarmNotifyInfo.setAlarmDest(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.alarmDest));
		deviceAlarmNotifyInfo.setExtParam(BytesUtils.bytesToStringForIVS(deviceAlarmNotify.extParam));

		return deviceAlarmNotifyInfo;
	}
}
