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
package com.huawei.esdk.ivs.device;


import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.nemgr.base.DeviceConnectionBase;

public abstract class IVSDeviceConnectionBase extends DeviceConnectionBase
{

	protected IVSDeviceConnectionBase(String user, String pwd)
	{
		super(user, pwd);
	}

	public void prepareSessionId(String connId)
	{
		MessageContext mc = ThreadLocalHolder.get();
		if (mc == null)
		{
			mc = new MessageContext();
		}

		mc.getEntities().put(InfoKeys.SDK_SESSION_ID.toString(), connId);
		
		ThreadLocalHolder.set(mc);
	}
}
