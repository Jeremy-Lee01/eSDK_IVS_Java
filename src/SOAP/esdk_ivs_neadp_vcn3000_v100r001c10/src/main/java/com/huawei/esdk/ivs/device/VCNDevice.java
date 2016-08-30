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
import com.huawei.esdk.ivs.device.v100r001c10.alarmmanager.AlarmMgrCability;
import com.huawei.esdk.ivs.device.v100r001c10.businessmanager.BusinessMgrCability;
import com.huawei.esdk.ivs.device.v100r001c10.clustermanager.ClusterMgrCabilityImpl;
import com.huawei.esdk.ivs.device.v100r001c10.devicemanager.DeviceMgrCabilityImpl;
import com.huawei.esdk.ivs.device.v100r001c10.recordmanager.RecordMgrCabilityImpl;
import com.huawei.esdk.ivs.device.v100r001c10.usermanager.UserMgrCabilityImpl;
import com.huawei.esdk.ivs.device.vcn3000.alarmmanager.IAlarmMgrCability;
import com.huawei.esdk.ivs.device.vcn3000.businessmanager.IBusinessMgrCability;
import com.huawei.esdk.ivs.device.vcn3000.clustermanager.IClusterMgrCability;
import com.huawei.esdk.ivs.device.vcn3000.common.ICommonCapability;
import com.huawei.esdk.ivs.device.vcn3000.devicemanager.IDeviceMgrCability;
import com.huawei.esdk.ivs.device.vcn3000.recordmanager.IRecordMgrCability;
import com.huawei.esdk.ivs.device.vcn3000.usermanager.IUserMgrCability;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.base.MultiConnDeviceBase;
import com.huawei.esdk.platform.nemgr.itf.IDeviceConnection;

public class VCNDevice extends MultiConnDeviceBase
{
    public VCNDevice(String sap)
    {
        prepareDeviceCapability();
    }
    
    protected void prepareDeviceCapability()
    {
        addServiceObjectMap(IDeviceMgrCability.class,
                new DeviceMgrCabilityImpl());
        addServiceObjectMap(IClusterMgrCability.class,
                new ClusterMgrCabilityImpl());
        addServiceObjectMap(IAlarmMgrCability.class,
            new AlarmMgrCability());
        addServiceObjectMap(IUserMgrCability.class,
                new UserMgrCabilityImpl());
        addServiceObjectMap(IRecordMgrCability.class,
            new RecordMgrCabilityImpl());
        addServiceObjectMap(ICommonCapability.class,
            ApplicationContextUtil.getBean("commonCapability"));
        addServiceObjectMap(IBusinessMgrCability.class,
            new BusinessMgrCability());
    }

    @Override
    public IDeviceConnection createConnection(String connId, String sap, String loginUser, String loginPwd)
    {
        return new VCNConnection(sap, this, loginUser, loginPwd, authorizePolicy);
    }

    @Override
    public String getConnIdFromContext()
    {        
        return (String) ThreadLocalHolder.get().getEntities().get(InfoKeys.SDK_SESSION_ID.toString());
    }

    @Override
    public Boolean releaseConns()
    {
        return true;
    }
    
}
