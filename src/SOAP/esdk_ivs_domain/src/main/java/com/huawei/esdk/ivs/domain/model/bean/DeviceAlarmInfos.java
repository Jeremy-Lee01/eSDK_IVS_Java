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

import java.util.ArrayList;
import java.util.List;

/**
 * 设备告警事件列表
 * <p>
 * 
 * @author l00295065
 * @see com.huawei.esdk.ivs.domain.model.bean.DeviceAlarmInfos
 * @since eSDK IVS V100R005C70
 */
public class DeviceAlarmInfos {

	/**
	 * 总记录数
	 */
	private int total;

	/**
	 * 分页信息
	 */
	private IndexRange indexRange;

	/**
	 * 保留字段
	 */
	private String reserve;

	/**
	 * 告警事件列表
	 */
	private List<DeviceAlarmNotifyInfo> deviceAlarmNotifies;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public IndexRange getIndexRange() {
		return indexRange;
	}

	public void setIndexRange(IndexRange indexRange) {
		this.indexRange = indexRange;
	}

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	public List<DeviceAlarmNotifyInfo> getDeviceAlarmNotifies() {
		if (null == deviceAlarmNotifies)
        {
            return new ArrayList<DeviceAlarmNotifyInfo>();
        }
        
        return deviceAlarmNotifies;
	}

	public void setDeviceAlarmNotifies(List<DeviceAlarmNotifyInfo> deviceAlarmNotifies) {
		this.deviceAlarmNotifies = deviceAlarmNotifies;
	}

}
