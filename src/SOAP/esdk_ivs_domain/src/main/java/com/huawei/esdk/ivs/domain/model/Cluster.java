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
package com.huawei.esdk.ivs.domain.model;

import com.huawei.esdk.ivs.device.vcn3000.clustermanager.IClusterMgrCability;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

/**
 * 领域层集群类
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  [V100R003]
 */
public class Cluster
{
    /**
     * 设备管理接口
     */
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    /** 
    * 查询NVR设备列表
    *
    * @param domainCode 域编码
    * @param serverType NVR类型 0 全部，1 NVR，2 TAS，3 MBS
    * @param indexRange 分页索引
    * @return NVR列表
    * @throws SDKException
    * @since eSDK IVS V100R003C00
    */
    public SDKResult<DeviceBriefInfoList> getNVRList(String domainCode, int serverType, IndexRange indexRange)
        throws SDKException
    {
        IClusterMgrCability iClusterMgrCability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ivs_vcn_device"),
                IClusterMgrCability.class);
        
        return iClusterMgrCability.getNVRList(domainCode, serverType, indexRange);
    }
}
