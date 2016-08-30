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
package com.huawei.esdk.ivs.business.professional.clustermgr;

import com.huawei.esdk.ivs.domain.model.Cluster;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 集群管理层
 * @author  sWX198756
 * @since  eSDK IVS V100R003C00
 */

public class ClusterService
{
    
    /** 
    * 集群管理层
    *
    * @param domainCode 域编码
    * @param serverType NVR类型 0 全部，1 NVR，2 TAS，3 MBS
    * @param indexRange 分页索引
    * @return SDKResult<DeviceBriefInfoList> NVR列表
    * @throws SDKException  SDK异常
    * @since eSDK IVS V100R003C00
    */
    public SDKResult<DeviceBriefInfoList> getNVRList(String domainCode, int serverType, IndexRange indexRange)
        throws SDKException
    {
        return new Cluster().getNVRList(domainCode, serverType, indexRange);
    }
}
