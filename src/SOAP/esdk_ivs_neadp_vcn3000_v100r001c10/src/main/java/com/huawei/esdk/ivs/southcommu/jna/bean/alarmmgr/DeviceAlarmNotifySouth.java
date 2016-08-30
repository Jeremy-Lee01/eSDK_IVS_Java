/**
 * Copyright 2016 Huawei Technologies Co., Ltd. All rights reserved.
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
package com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.sun.jna.Structure;

public class DeviceAlarmNotifySouth extends Structure {

	public static class ByReference extends OrderConditionSouth implements Structure.ByReference {
	}

	public static class ByValue extends OrderConditionSouth implements Structure.ByValue {
	}

	/**
	 * 告警事件ID
	 */
	public long alarmEventID;

	/**
	 * 告警源编码
	 */
	public byte[] alarmInCode = new byte[CommonConstant.AlarmModule.IVS_ALARM_CODE_LEN];

	/**
	 * 告警源类型 IVS_ALARM_IN_TYPE
	 */
	public int alarmInType;

	/**
	 * 告警源名称
	 */
	public byte[] alarmInName = new byte[CommonConstant.AlarmModule.IVS_ALARM_NAME_LEN];

	/**
	 * 告警所属网元类型,如30858
	 */
	public byte[] nodeType = new byte[CommonConstant.AlarmModule.IVS_NODE_TYPE_LEN];

	/**
	 * 告警级别权值，只有四种：1-提示；50-一般；80-重要；100-紧急；
	 */
	public int alarmLevelValue;

	/**
	 * 告警类型
	 */
	public byte[] alarmType = new byte[CommonConstant.AlarmModule.IVS_ALARM_CODE_LEN];

	/**
	 * 告警类型类别 01：业务类告警 02：网管类告警 03：状态类告警
	 */
	public byte[] alarmCategory = new byte[CommonConstant.AlarmModule.IVS_ALARM_CATEGORY_LEN];

	/**
	 * 告警首次发生时间：yyyyMMddHHmmss（告警抑制的第一次告警产生时间）
	 */
	public byte[] occurFirstTime = new byte[CommonConstant.AlarmModule.IVS_TIME_LEN];

	/**
	 * 告警最后发生时间：yyyyMMddHHmmss（告警抑制的最后一次告警产生时间）
	 */
	public byte[] occurEndTime = new byte[CommonConstant.AlarmModule.IVS_TIME_LEN];

	/**
	 * 告警发生次数
	 */
	public int occurNumber;

	/**
	 * 保留字段
	 */
	public byte[] reserver = new byte[CommonConstant.IVS_RESERVE_32_LEN];

	/**
	 * 告警定位信息。
	 */
	public byte[] locationInfo = new byte[CommonConstant.AlarmModule.IVS_DEVICE_ALARM_LOCATION_INFO_LEN];

	/**
	 * 告警产生模块归属的网元ID
	 */
	public byte[] netEleID = new byte[CommonConstant.AlarmModule.IVS_NET_ELEMENT_ID_LEN];

	/**
	 * 所属网元名称
	 */
	public byte[] netName = new byte[128];

	/**
	 * 告警描述信息，键盘可见字符和中文，0~256字符。
	 */
	public byte[] alarmDest = new byte[CommonConstant.AlarmModule.IVS_ALARM_DESCRIPTION_LEN];

	/**
	 * 扩展参数
	 */
	public byte[] extParam = new byte[CommonConstant.AlarmModule.IVS_ALARM_EX_PARAM_LEN];

	@Override
	protected List<String> getFieldOrder() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("alarmEventID");
		list.add("alarmInCode");
		list.add("alarmInType");
		list.add("alarmInName");
		list.add("nodeType");
		list.add("alarmLevelValue");
		list.add("alarmType");
		list.add("alarmCategory");
		list.add("occurFirstTime");
		list.add("occurEndTime");
		list.add("occurNumber");
		list.add("reserver");
		list.add("locationInfo");
		list.add("netEleID");
		list.add("netName");
		list.add("alarmDest");
		list.add("extParam");
		return list;
	}

}
