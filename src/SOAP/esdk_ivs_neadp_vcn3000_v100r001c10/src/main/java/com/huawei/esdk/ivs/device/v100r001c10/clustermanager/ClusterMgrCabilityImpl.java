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
package com.huawei.esdk.ivs.device.v100r001c10.clustermanager;

import com.huawei.esdk.ivs.device.BaseCability;
import com.huawei.esdk.ivs.device.v100r001c10.clustermanager.convert.ClusterMgrCabilityConvert;
import com.huawei.esdk.ivs.device.vcn3000.clustermanager.IClusterMgrCability;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.DeviceBriefInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr.IndexRangeSouth;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.NumberUtils;

/**
 * 集群管理接口
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class ClusterMgrCabilityImpl extends BaseCability implements IClusterMgrCability
{
    
    private static final DeviceBriefInfoListSouth NVR_LIST = new DeviceBriefInfoListSouth(
        NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("index.range")));
    
    /**
     * 南向数据转换类
     */
    private ClusterMgrCabilityConvert clusterMgrCabilityConvert =
        ApplicationContextUtil.getBean("clusterMgrCabilityConvert");
    
    public synchronized SDKResult<DeviceBriefInfoList> getNVRList(String domainCode, int serverType, IndexRange indexRange)
    {
        // 将领域层的bean转换成南向的bean
        IndexRangeSouth indexRangeSouth = clusterMgrCabilityConvert.convertIndexRangeSouthModel2South(indexRange);
        int sessionId = getIVSSessionId();
        
        int size = indexRangeSouth.toIndex - indexRangeSouth.fromIndex + 1;
        
        // 容错
        if (size < 1)
        {
            size = 1;
        }
        
        //DeviceBriefInfoListSouth nvrList = new DeviceBriefInfoListSouth(size);
        //int bufferSize = nvrList.size();
        NVR_LIST.clear();
        
        int resultCode =
            super.getBaseCablilityJNA().IVS_SDK_GetNVRList(sessionId,
                domainCode,
                serverType,
                indexRangeSouth,
                NVR_LIST.getPointer(),
                size * 632 + 44);
        NVR_LIST.read();
        
        //将南向bean转换成领域层的bean
        SDKResult<DeviceBriefInfoList> result = new SDKResult<DeviceBriefInfoList>();
        result.setErrCode(resultCode);
        if (0 == resultCode)
        {
            DeviceBriefInfoList deviceBriefInfoList =
                clusterMgrCabilityConvert.convertDeviceNvrBriefInfoSouth2Model(NVR_LIST);
            if (null != deviceBriefInfoList)
            {
                result.setResult(deviceBriefInfoList);
            }
        }
        
        return result;
    }
    
}
