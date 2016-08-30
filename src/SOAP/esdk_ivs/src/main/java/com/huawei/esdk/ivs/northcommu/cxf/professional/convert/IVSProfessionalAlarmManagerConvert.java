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
package com.huawei.esdk.ivs.northcommu.cxf.professional.convert;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.common.util.StringUtils;

import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.Alarm;
import com.huawei.esdk.ivs.domain.model.bean.AlarmCommissionInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmEventList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmLevelList;
import com.huawei.esdk.ivs.domain.model.bean.AlarmReportInfo;
import com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceAlarmInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceAlarmNotifyInfo;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.OrderCondition;
import com.huawei.esdk.ivs.domain.model.bean.QueryField;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddAlarmLinkageResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmEvent;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmEventInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmLevel;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmNotify;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmOperateInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmTypeInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmTypeInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceAlarmEvents;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceAlarmNotify;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmEventInfoResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmEventListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLevelListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmLevelResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetAlarmTypeListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceAlarmListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SubscribeAlarmQueryResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SubscribeAlarmResponse;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 告警管理模块数据转换类
 * <p>
 * 用于南北向告警管理模块接口数据的转换
 * <p>
 * 
 * @author cWX191990
 * @see [相关类/方法]
 * @since eSDK IVS V100R003C00
 */
public class IVSProfessionalAlarmManagerConvert {

	/**
	 * 将领域层返回的结果对象转换成响应消息
	 *
	 * @param result
	 *            封装领域层的SDKResult对象
	 * @return GetAlarmEventInfoResponse 北向接口响应
	 * @since eSDK IVS V100R003C00
	 */
	public GetAlarmEventInfoResponse getAlarmEventInfoModel2Soap(SDKResult<Alarm> result) {
		GetAlarmEventInfoResponse response = new GetAlarmEventInfoResponse();
		response.setResultCode((int) result.getErrCode());

		if (0 == result.getErrCode()) {
			response.setAlarmEvent(getAlarmEventModel2Soap(result.getResult()));
		}

		return response;
	}

	/**
	 * 转换北向QueryUnifiedFormat为领域层bean
	 *
	 * @param queryUnifiedFormat
	 *            北向获取告警列表查询条件
	 * @return QueryUnifiedFormat 领域层获取告警列表查询条件
	 * @since eSDK IVS V100R003C00
	 */
	public QueryUnifiedFormat getAlarmEventListSoap2Model(
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryUnifiedFormat queryUnifiedFormat) {
		return getQueryUnifiedFormatSoap2Model(queryUnifiedFormat);
	}

	/**
	 * 将南向返回的领域封装对象转成北向的响应体
	 *
	 * @param result
	 *            南向返回的领域封装对象
	 * @return GetAlarmEventListResponse 获取告警列表响应体
	 * @since eSDK IVS V100R003C00
	 */
	public GetAlarmEventListResponse getAlarmEventListModel2Soap(SDKResult<AlarmEventList> result) {
		GetAlarmEventListResponse response = new GetAlarmEventListResponse();
		response.setResultCode((int) result.getErrCode());

		if (0 == result.getErrCode()) {
			AlarmEventInfos alarmEventInfos = new AlarmEventInfos();
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmEventInfoList aeiList = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmEventInfoList();
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange iRange = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
			iRange.setFromIndex(result.getResult().getIndexRange().getFromIndex());
			iRange.setToIndex(result.getResult().getIndexRange().getToIndex());
			alarmEventInfos.setIndexRange(iRange);
			alarmEventInfos.setReserve(result.getResult().getReserve());
			alarmEventInfos.setTotal(result.getResult().getTotal());

			for (Alarm alarm : result.getResult().getAlarmEventInfos()) {
				aeiList.getAlarmEventInfo().add(getAlarmEventModel2Soap(alarm));
			}

			alarmEventInfos.setAlarmEventInfoList(aeiList);
			response.setAlarmEventInfos(alarmEventInfos);
		}

		return response;
	}

	/**
	 * 将SDKErrorCode转成SubscribeAlarmResponse
	 *
	 * @param result
	 *            SDK封装的结果类
	 * @return SubscribeAlarmResponse 告警订阅响应体
	 * @since eSDK IVS V100R003C00
	 */
	public SubscribeAlarmResponse subscribeAlarmModel2Soap(SDKErrorCode result) {
		SubscribeAlarmResponse response = new SubscribeAlarmResponse();
		response.setResultCode((int) result.getErrCode());
		return response;
	}

	public SubscribeAlarmQueryResponse subscribeAlarmQueryModel2Soap(SDKResult<String> result) {
		SubscribeAlarmQueryResponse response = new SubscribeAlarmQueryResponse();
		response.setResultCode((int) result.getErrCode());

		if (0 == result.getErrCode()) {
			response.setResponseXML(result.getResult());
		}

		return response;
	}

	public AddAlarmLinkageResponse addAlarmLinkageModel2Soap(SDKResult<String> result) {
		AddAlarmLinkageResponse response = new AddAlarmLinkageResponse();
		response.setResultCode((int) result.getErrCode());
		response.setResponseXML(result.getResult());
		return response;
	}

	/**
	 * 将领域层的bean转换成北向的bean
	 *
	 * @param alarm
	 *            领域层的告警对象
	 * @return AlarmEvent 北向告警对象
	 * @since eSDK IVS V100R003C00
	 */
	protected AlarmEvent getAlarmEventModel2Soap(Alarm alarm) {
		// 初始化北向的告警bean
		AlarmEvent alarmEvent = new AlarmEvent();
		AlarmNotify alarmNotify = new AlarmNotify();
		AlarmOperateInfo alarmOpreateInfo = new AlarmOperateInfo();

		// 获取领域告警bean
		com.huawei.esdk.ivs.domain.model.bean.AlarmNotify aNotify = alarm.getAlarmNotify();
		com.huawei.esdk.ivs.domain.model.bean.AlarmOpreateInfo aOpreateInfo = alarm.getAlarmOpreateInfo();

		// 转换AlarmNotify
		alarmNotify.setAlarmCategory(aNotify.getAlarmCategory());
		alarmNotify.setAlarmDesc(aNotify.getAlarmDesc());
		alarmNotify.setAlarmEventId(aNotify.getAlarmEventId());
		alarmNotify.setAlarmInCode(aNotify.getAlarmInCode());
		alarmNotify.setAlarmInName(aNotify.getAlarmInName());
		alarmNotify.setAlarmInType(aNotify.getAlarmInType());
		alarmNotify.setAlarmLevelColor(aNotify.getAlarmLevelColor());
		alarmNotify.setAlarmLevelName(aNotify.getAlarmLevelName());
		alarmNotify.setAlarmLevelValue(aNotify.getAlarmLevelValue());
		alarmNotify.setAlarmStatus(aNotify.getAlarmStatus());
		alarmNotify.setAlarmType(aNotify.getAlarmType());
		alarmNotify.setAlarmTypeName(aNotify.getAlarmTypeName());
		alarmNotify.setDeviceDomainCode(aNotify.getDeviceDomainCode());
		alarmNotify.setExistsRecord(aNotify.getExistsRecord());
		alarmNotify.setExtParam(aNotify.getExtParam());
		alarmNotify.setIsCommission(aNotify.getIsCommission());
		alarmNotify.setNvrCode(aNotify.getNvrCode());
		alarmNotify.setOccurNumber(aNotify.getOccurentNumber());
		alarmNotify.setOccurTime(aNotify.getOccurentTime());
		alarmNotify.setPreviewUrl(aNotify.getPreviewUrl());
		alarmNotify.setReserve(aNotify.getReserve());

		// 转换AlarmOpreateInfo
		alarmOpreateInfo.setOperateInfo(aOpreateInfo.getOperateInfo());
		alarmOpreateInfo.setOperateTime(aOpreateInfo.getOperateTime());
		alarmOpreateInfo.setOperatorId(aOpreateInfo.getOperatorId());
		alarmOpreateInfo.setOperatorName(aOpreateInfo.getOperatorName());
		alarmOpreateInfo.setReserver(aOpreateInfo.getReserver());

		alarmEvent.setAlarmNotify(alarmNotify);
		alarmEvent.setOperateInfo(alarmOpreateInfo);

		return alarmEvent;
	}

	/**
	 * 告警授权信息soap消息转换为领域bean
	 * 
	 * @param soap
	 *            告警授权信息soap消息
	 * @return 告警授权信息领域bean
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	public AlarmCommissionInfo getAlarmCommissionInfoSoap2Model(
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmCommissionInfo soap) {
		AlarmCommissionInfo domain = new AlarmCommissionInfo();
		domain.setAlarmEventId(soap.getAlarmEventId());
		domain.setUserNum(soap.getUserNum());

		List<com.huawei.esdk.ivs.northcommu.cxf.professional.gen.UserIdInfo> userIdInfoSoaps = soap.getUserIdInfoList()
				.getUserIdInfo();
		List<com.huawei.esdk.ivs.domain.model.bean.UserIdInfo> userIdInfoDomains = new ArrayList<com.huawei.esdk.ivs.domain.model.bean.UserIdInfo>();
		for (com.huawei.esdk.ivs.northcommu.cxf.professional.gen.UserIdInfo userIdInfoSoap : userIdInfoSoaps) {
			com.huawei.esdk.ivs.domain.model.bean.UserIdInfo userIdInfoDomain = new com.huawei.esdk.ivs.domain.model.bean.UserIdInfo();
			userIdInfoDomain.setUserId(userIdInfoSoap.getUserId());
			userIdInfoDomain.setDomainCode(userIdInfoSoap.getDomainCode());
			userIdInfoDomains.add(userIdInfoDomain);
		}
		domain.setUserIdInfos(userIdInfoDomains);

		return domain;
	}

	/**
	 * 告警操作信息soap消息转换为领域bean
	 * 
	 * @param soap
	 *            告警操作信息soap消息
	 * @return 告警操作信息领域bean
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	public com.huawei.esdk.ivs.domain.model.bean.AlarmOperateInfo getAlarmOperateInfoSoap2Model(AlarmOperateInfo soap) {
		com.huawei.esdk.ivs.domain.model.bean.AlarmOperateInfo domain = new com.huawei.esdk.ivs.domain.model.bean.AlarmOperateInfo();
		domain.setOperateInfo(soap.getOperateInfo());
		domain.setOperateTime(soap.getOperateTime());
		domain.setOperatorId(soap.getOperatorId());
		domain.setOperatorName(soap.getOperatorName());
		domain.setReserve(soap.getReserver());
		return domain;
	}

	/**
	 * 告警上报信息soap消息转换为领域bean
	 * 
	 * @param soap
	 *            告警上报信息soap消息
	 * @return 告警上报信息领域bean
	 * @see [类、类#方法、类#成员]
	 * @since eSDK IVS V100R003C00
	 */
	public AlarmReportInfo getAlarmReportInfoSoap2Model(
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmReportInfo soap) {
		AlarmReportInfo domain = new AlarmReportInfo();
		domain.setAction(soap.getAction());
		domain.setAlarmDesc(soap.getAlarmDesc());
		domain.setAlarmId(soap.getAlarmId());
		domain.setAlarmInCode(soap.getAlarmInCode());
		domain.setAlarmType(soap.getAlarmType());
		domain.setDeviceDomainCode(soap.getDeviceDomainCode());
		domain.setExtParam(soap.getExtParam());
		domain.setNvrCode(soap.getNvrCode());
		domain.setOccurNumber(soap.getOccurNumber());
		domain.setOccurTime(soap.getOccurTime());
		domain.setReportTime(soap.getReportTime());
		domain.setReserve(soap.getReserve());
		return domain;
	}

	/**
	 * 告警类型级别soap消息转换为领域bean
	 * 
	 * @param domain
	 *            告警类型级别soap消息
	 * @return 告警类型级别领域bean
	 * @throws SDKException
	 * @see [类、类#方法、类#成员]
	 * @since [eSDK IVS V100R003C10]
	 */
	public com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfos getAlarmTypeLevelSoap2Model(
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmTypeInfos soap) throws SDKException {
		com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfos domain = new com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfos();
		domain.setTotal(soap.getTotal());
		domain.setReserve(soap.getReserve());
		if (null != soap.getIndexRange()) {
			domain.setIndexRange(getIndexRangeSoap2Model(soap.getIndexRange()));
		}
		domain.setAlarmTypeListInfos(getAlarmTypeListInfosSoap2Model(soap.getAlarmTypeInfoList()));
		return domain;
	}

	public List<com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfo> getAlarmTypeListInfosSoap2Model(
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmTypeInfoList soap) throws SDKException {
		List<com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmTypeInfo> alarmTypeInfoSoaps = soap
				.getAlarmTypeInfo();
		List<com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfo> domains = new ArrayList<com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfo>();
		for (com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmTypeInfo alarmTypeInfoSoap : alarmTypeInfoSoaps) {
			com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfo domain = getAlarmTypeInfoSoap2Model(alarmTypeInfoSoap);
			domains.add(domain);
		}
		return domains;
	}

	public com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfo getAlarmTypeInfoSoap2Model(
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmTypeInfo soap) throws SDKException {
		if (null == soap || null == soap.getAlarmLevel() || StringUtils.isEmpty(soap.getAlarmTypeName())
				|| StringUtils.isEmpty(soap.getCategory()) || StringUtils.isEmpty(soap.getAlarmTypeCode())) {
			SDKException ex = new SDKException(ErrInfo.DATA_ERRORDESC);
			ex.setSdkErrCode(ErrInfo.DATA_ERRORCODE);
			throw ex;
		}
		com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfo domain = new com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfo();
		domain.setAlarmInType(soap.getAlarmInType());
		domain.setAlarmLevel(getAlarmLevelSoap2Model(soap.getAlarmLevel()));
		domain.setAlarmTypeID(soap.getAlarmTypeID());
		domain.setAlarmTypeName(soap.getAlarmTypeName());
		domain.setCategory(soap.getCategory());
		domain.setEnable(soap.getEnable());
		domain.setIsUserDefined(soap.getIsUserDefined());
		domain.setReserve(soap.getReserve());
		domain.setAlarmTypeCode(soap.getAlarmTypeCode());
		return domain;
	}

	public com.huawei.esdk.ivs.domain.model.bean.AlarmLevel getAlarmLevelSoap2Model(
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmLevel soap) throws SDKException {
		if (StringUtils.isEmpty(soap.getAlarmLevelName()) || StringUtils.isEmpty(soap.getColor())
				|| StringUtils.isEmpty(soap.getDescription())) {
			SDKException ex = new SDKException(ErrInfo.DATA_ERRORDESC);
			ex.setSdkErrCode(ErrInfo.DATA_ERRORCODE);
			throw ex;
		}
		com.huawei.esdk.ivs.domain.model.bean.AlarmLevel domain = new com.huawei.esdk.ivs.domain.model.bean.AlarmLevel();
		domain.setAlarmLevelId(soap.getAlarmLevelId());
		domain.setAlarmLevelName(soap.getAlarmLevelName());
		domain.setColor(soap.getColor());
		domain.setDescription(soap.getDescription());
		domain.setIsUserDefined(soap.getIsUserDefined());
		domain.setReserve(soap.getReserve());
		domain.setValue(soap.getValue());
		return domain;
	}

	public IndexRange getIndexRangeSoap2Model(com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange soap) {
		com.huawei.esdk.ivs.domain.model.bean.IndexRange domain = new com.huawei.esdk.ivs.domain.model.bean.IndexRange();
		domain.setFromIndex(soap.getFromIndex());
		domain.setToIndex(soap.getToIndex());
		return domain;
	}

	public GetAlarmTypeListResponse getAlarmTypeListModel2Soap(SDKResult<AlarmTypeInfos> result) {
		GetAlarmTypeListResponse response = new GetAlarmTypeListResponse();
		response.setResultCode((int) result.getErrCode());

		if (0 == result.getErrCode()) {
			AlarmTypeInfos domain = result.getResult();

			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmTypeInfos alarmTypeInfos = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmTypeInfos();
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexRange = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
			AlarmTypeInfoList alarmTypeInfoList = new AlarmTypeInfoList();
			AlarmTypeInfo info = null;
			AlarmLevel level = null;

			alarmTypeInfos.setTotal(domain.getTotal());
			alarmTypeInfos.setReserve(domain.getReserve());

			indexRange.setFromIndex(domain.getIndexRange().getFromIndex());
			indexRange.setToIndex(domain.getIndexRange().getToIndex());
			alarmTypeInfos.setIndexRange(indexRange);

			for (com.huawei.esdk.ivs.domain.model.bean.AlarmTypeInfo alarmTypeInfo : domain.getAlarmTypeListInfos()) {
				info = new AlarmTypeInfo();
				info.setAlarmInType(alarmTypeInfo.getAlarmInType());
				info.setAlarmTypeID(alarmTypeInfo.getAlarmTypeID());
				info.setAlarmTypeName(alarmTypeInfo.getAlarmTypeName());
				info.setCategory(alarmTypeInfo.getCategory());
				info.setEnable(alarmTypeInfo.getEnable());
				info.setIsUserDefined(alarmTypeInfo.getIsUserDefined());
				info.setReserve(alarmTypeInfo.getReserve());
				info.setAlarmTypeCode(alarmTypeInfo.getAlarmTypeCode());

				level = new AlarmLevel();
				level.setAlarmLevelId(alarmTypeInfo.getAlarmLevel().getAlarmLevelId());
				level.setAlarmLevelName(alarmTypeInfo.getAlarmLevel().getAlarmLevelName());
				level.setColor(alarmTypeInfo.getAlarmLevel().getColor());
				level.setDescription(alarmTypeInfo.getAlarmLevel().getDescription());
				level.setIsUserDefined(alarmTypeInfo.getAlarmLevel().getIsUserDefined());
				level.setReserve(alarmTypeInfo.getAlarmLevel().getReserve());
				level.setValue(alarmTypeInfo.getAlarmLevel().getValue());

				info.setAlarmLevel(level);

				alarmTypeInfoList.getAlarmTypeInfo().add(info);
			}

			alarmTypeInfos.setAlarmTypeInfoList(alarmTypeInfoList);

			response.setAlarmTypeInfos(alarmTypeInfos);
		}

		return response;
	}

	public QueryUnifiedFormat getAlarmTypeListSoap2Model(
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryUnifiedFormat queryUnifiedFormat) {
		return getQueryUnifiedFormatSoap2Model(queryUnifiedFormat);
	}

	private QueryUnifiedFormat getQueryUnifiedFormatSoap2Model(
			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryUnifiedFormat queryUnifiedFormat) {
		QueryUnifiedFormat qUnifiedFormat = new QueryUnifiedFormat();
		IndexRange indexRange = new IndexRange();
		OrderCondition orderCondition = new OrderCondition();
		QueryField queryField = null;
		List<QueryField> list = new ArrayList<QueryField>();

		// 转换fieldNum
		qUnifiedFormat.setFieldNum(queryUnifiedFormat.getFieldNum());

		// 转换分页信息
		indexRange.setFromIndex(queryUnifiedFormat.getIndex().getFromIndex());
		indexRange.setToIndex(queryUnifiedFormat.getIndex().getToIndex());
		qUnifiedFormat.setIndex(indexRange);

		// 转换排序条件
		orderCondition.setEnableOrder(queryUnifiedFormat.getOrderCondition().getEnableOrder());
		orderCondition.setField(queryUnifiedFormat.getOrderCondition().getFieldType());
		orderCondition.setIsAscend(queryUnifiedFormat.getOrderCondition().getIsAscend());
		qUnifiedFormat.setOrderCondition(orderCondition);

		// 转换查询条件
		for (com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryField qf : queryUnifiedFormat.getQueryFieldList()
				.getQueryField()) {
			queryField = new QueryField();
			queryField.setExactQuery(qf.getExactQuery());
			queryField.setFieldType(qf.getFieldType());
			queryField.setValue(qf.getValue());
			list.add(queryField);
		}
		qUnifiedFormat.setQueryField(list);

		return qUnifiedFormat;
	}

	public GetAlarmLevelResponse getAlarmLevelModel2Soap(
			SDKResult<com.huawei.esdk.ivs.domain.model.bean.AlarmLevel> result) {
		GetAlarmLevelResponse response = new GetAlarmLevelResponse();
		response.setResultCode((int) result.getErrCode());

		if (0 == result.getErrCode()) {
			AlarmLevel alarmLevel = new AlarmLevel();
			alarmLevel.setAlarmLevelId(result.getResult().getAlarmLevelId());
			alarmLevel.setAlarmLevelName(result.getResult().getAlarmLevelName());
			alarmLevel.setColor(result.getResult().getColor());
			alarmLevel.setDescription(result.getResult().getDescription());
			alarmLevel.setIsUserDefined(result.getResult().getIsUserDefined());
			alarmLevel.setReserve(result.getResult().getReserve());
			alarmLevel.setValue(result.getResult().getValue());

			response.setAlarmLevel(alarmLevel);
		}

		return response;
	}

	public GetAlarmLevelListResponse getAlarmLevelListModel2Soap(SDKResult<AlarmLevelList> result) {
		GetAlarmLevelListResponse response = new GetAlarmLevelListResponse();
		response.setResultCode((int) result.getErrCode());

		if (0 == result.getErrCode()) {
			response.setAlarmLevelNum(result.getResult().getAlarmLevelNum());

			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmLevelList alarmLevelList = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AlarmLevelList();

			AlarmLevel alarmLevel = null;

			for (com.huawei.esdk.ivs.domain.model.bean.AlarmLevel aLevel : result.getResult().getAlarmLevels()) {
				alarmLevel = new AlarmLevel();
				alarmLevel.setAlarmLevelId(aLevel.getAlarmLevelId());
				alarmLevel.setAlarmLevelName(aLevel.getAlarmLevelName());
				alarmLevel.setColor(aLevel.getColor());
				alarmLevel.setDescription(aLevel.getDescription());
				alarmLevel.setIsUserDefined(aLevel.getIsUserDefined());
				alarmLevel.setReserve(aLevel.getReserve());
				alarmLevel.setValue(aLevel.getValue());
				alarmLevelList.getAlarmLevel().add(alarmLevel);
			}

			response.setAlarmLevelList(alarmLevelList);
		}

		return response;
	}

	/**
	 * 将南向返回的领域封装对象转成北向的响应体
	 *
	 * @param result
	 *            南向返回的领域封装对象
	 * @return GetDeviceAlarmListResponse 获取设备告警列表响应体
	 * @since eSDK IVS V100R003C00
	 */
	public GetDeviceAlarmListResponse getDeviceAlarmEventListModel2Soap(SDKResult<DeviceAlarmInfos> result) {
		GetDeviceAlarmListResponse response = new GetDeviceAlarmListResponse();
		response.setResultCode((int) result.getErrCode());

		if (0 == result.getErrCode()) {
			DeviceAlarmEvents deviceAlarmEvents = new DeviceAlarmEvents();

			com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange iRange = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
			iRange.setFromIndex(result.getResult().getIndexRange().getFromIndex());
			iRange.setToIndex(result.getResult().getIndexRange().getToIndex());
			deviceAlarmEvents.setIndexRange(iRange);
			deviceAlarmEvents.setReserve(result.getResult().getReserve());
			deviceAlarmEvents.setTotal(result.getResult().getTotal());

			List<DeviceAlarmNotify> deviceAlarmNotifies = deviceAlarmEvents.getDeviceAlarmNotifies();
			for (DeviceAlarmNotifyInfo alarmNotify : result.getResult().getDeviceAlarmNotifies()) {
				deviceAlarmNotifies.add(getAlarmNotifyModel2Soap(alarmNotify));
			}

			response.setDeviceAlarmEvents(deviceAlarmEvents);
		}

		return response;
	}

	/**
	 * 将领域层的bean转换成北向的bean
	 *
	 * @param alarmNotify
	 *            领域层的告警对象
	 * @return DeviceAlarmNotify 北向告警对象
	 * @since eSDK IVS V100R005C70
	 */
	protected DeviceAlarmNotify getAlarmNotifyModel2Soap(DeviceAlarmNotifyInfo alarmNotify) {
		// 定义领域层和南向的bean对象
		DeviceAlarmNotify deviceAlarmNotify = new DeviceAlarmNotify();

		// 数据转换
		deviceAlarmNotify.setAlarmEventID(alarmNotify.getAlarmEventID());
		deviceAlarmNotify.setAlarmInCode(alarmNotify.getAlarmInCode());
		deviceAlarmNotify.setAlarmInType(alarmNotify.getAlarmInType());
		deviceAlarmNotify.setAlarmInName(alarmNotify.getAlarmInName());
		deviceAlarmNotify.setNodeType(alarmNotify.getNodeType());
		deviceAlarmNotify.setAlarmLevelValue(alarmNotify.getAlarmLevelValue());
		deviceAlarmNotify.setAlarmType(alarmNotify.getAlarmType());
		deviceAlarmNotify.setAlarmCategory(alarmNotify.getAlarmCategory());
		deviceAlarmNotify.setOccurFirstTime(alarmNotify.getOccurFirstTime());
		deviceAlarmNotify.setOccurEndTime(alarmNotify.getOccurEndTime());
		deviceAlarmNotify.setOccurNumber(alarmNotify.getOccurNumber());
		deviceAlarmNotify.setReserver(alarmNotify.getReserver());
		deviceAlarmNotify.setLocationInfo(alarmNotify.getLocationInfo());
		deviceAlarmNotify.setNetEleID(alarmNotify.getNetEleID());
		deviceAlarmNotify.setNetName(alarmNotify.getNetName());
		deviceAlarmNotify.setAlarmDest(alarmNotify.getAlarmDest());

		deviceAlarmNotify.setExtParam(alarmNotify.getExtParam());

		return deviceAlarmNotify;
	}
}
