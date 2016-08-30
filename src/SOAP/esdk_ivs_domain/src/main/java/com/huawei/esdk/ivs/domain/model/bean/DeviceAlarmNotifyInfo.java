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
package com.huawei.esdk.ivs.domain.model.bean;

/**
 * 设备告警通知信息（OMU告警通知信息）
 * 
 * @author l00295065
 * @since eSDK IVS V100R005C70
 */
public class DeviceAlarmNotifyInfo {
	/**
	 * 告警事件ID
	 */
	protected long alarmEventID;

	/**
	 * 告警源编码
	 */
	protected String alarmInCode;

	/**
	 * 告警源类型 IVS_ALARM_IN_TYPE
	 */
	protected int alarmInType;

	/**
	 * 告警源名称
	 */
	protected String alarmInName;

	/**
	 * 告警所属网元类型,如30858
	 */
	protected String nodeType;

	/**
	 * 告警级别权值，只有四种：1-提示；50-一般；80-重要；100-紧急；
	 */
	protected int alarmLevelValue;

	/**
	 * 告警类型
	 */
	protected String alarmType;

	/**
	 * 告警类型类别 01：业务类告警 02：网管类告警 03：状态类告警
	 */
	protected String alarmCategory;

	/**
	 * 告警首次发生时间：yyyyMMddHHmmss（告警抑制的第一次告警产生时间）
	 */
	protected String occurFirstTime;

	/**
	 * 告警最后发生时间：yyyyMMddHHmmss（告警抑制的最后一次告警产生时间）
	 */
	protected String occurEndTime;

	/**
	 * 告警发生次数
	 */
	protected int occurNumber;

	/**
	 * 保留字段
	 */
	protected String reserver;

	/**
	 * 告警定位信息。
	 */
	protected String locationInfo;

	/**
	 * 告警产生模块归属的网元ID
	 */
	protected String netEleID;

	/**
	 * 所属网元名称
	 */
	protected String netName;

	/**
	 * 告警描述信息，键盘可见字符和中文，0~256字符。
	 */
	protected String alarmDest;

	/**
	 * 扩展参数
	 */
	protected String extParam;

	public long getAlarmEventID() {
		return alarmEventID;
	}

	public void setAlarmEventID(long alarmEventID) {
		this.alarmEventID = alarmEventID;
	}

	public String getAlarmInCode() {
		return alarmInCode;
	}

	public void setAlarmInCode(String alarmInCode) {
		this.alarmInCode = alarmInCode;
	}

	public int getAlarmInType() {
		return alarmInType;
	}

	public void setAlarmInType(int alarmInType) {
		this.alarmInType = alarmInType;
	}

	public String getAlarmInName() {
		return alarmInName;
	}

	public void setAlarmInName(String alarmInName) {
		this.alarmInName = alarmInName;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public int getAlarmLevelValue() {
		return alarmLevelValue;
	}

	public void setAlarmLevelValue(int alarmLevelValue) {
		this.alarmLevelValue = alarmLevelValue;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public String getAlarmCategory() {
		return alarmCategory;
	}

	public void setAlarmCategory(String alarmCategory) {
		this.alarmCategory = alarmCategory;
	}

	public String getOccurFirstTime() {
		return occurFirstTime;
	}

	public void setOccurFirstTime(String occurFirstTime) {
		this.occurFirstTime = occurFirstTime;
	}

	public String getOccurEndTime() {
		return occurEndTime;
	}

	public void setOccurEndTime(String occurEndTime) {
		this.occurEndTime = occurEndTime;
	}

	public int getOccurNumber() {
		return occurNumber;
	}

	public void setOccurNumber(int occurNumber) {
		this.occurNumber = occurNumber;
	}

	public String getReserver() {
		return reserver;
	}

	public void setReserver(String reserver) {
		this.reserver = reserver;
	}

	public String getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(String locationInfo) {
		this.locationInfo = locationInfo;
	}

	public String getNetEleID() {
		return netEleID;
	}

	public void setNetEleID(String netEleID) {
		this.netEleID = netEleID;
	}

	public String getNetName() {
		return netName;
	}

	public void setNetName(String netName) {
		this.netName = netName;
	}

	public String getAlarmDest() {
		return alarmDest;
	}

	public void setAlarmDest(String alarmDest) {
		this.alarmDest = alarmDest;
	}

	public String getExtParam() {
		return extParam;
	}

	public void setExtParam(String extParam) {
		this.extParam = extParam;
	}

}
