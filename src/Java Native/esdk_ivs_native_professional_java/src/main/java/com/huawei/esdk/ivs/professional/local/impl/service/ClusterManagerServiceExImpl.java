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
package com.huawei.esdk.ivs.professional.local.impl.service;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.professional.local.bean.DeviceBriefInfos;
import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.professional.local.bean.IndexRange;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalClusterManager;
import com.huawei.esdk.ivs.professional.local.impl.utils.ClientProvider;
import com.huawei.esdk.ivs.professional.local.impl.utils.ExceptionUtils;
import com.huawei.esdk.ivs.professional.local.service.clusterManager.ClusterManagerServiceEx;

public class ClusterManagerServiceExImpl implements ClusterManagerServiceEx
{
    private static final Logger LOGGER = Logger.getLogger(ClusterManagerServiceExImpl.class);
    
    private IVSProfessionalClusterManager ivsProfessionalClusterManager =
        (IVSProfessionalClusterManager)ClientProvider.getClient(IVSProfessionalClusterManager.class);
    
    private static ClusterManagerServiceExImpl instance = null;
    
    public static synchronized ClusterManagerServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new ClusterManagerServiceExImpl();
        }
        return instance;
    }
    
    @Override
    public IVSSDKResponse<DeviceBriefInfos> getNVRList(String domainCode, Integer serverType, IndexRange indexRange)
    {
        LOGGER.info("begin to execute getNVRList method");
        
        IVSSDKResponse<DeviceBriefInfos> result = new IVSSDKResponse<DeviceBriefInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<DeviceBriefInfos> nvrList = new Holder<DeviceBriefInfos>();
        try
        {
            ivsProfessionalClusterManager.getNVRList(domainCode, serverType, indexRange, resultCode, nvrList);
        }
        catch (Exception e)
        {
            LOGGER.error("getNVRList method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(nvrList.value);
        
        LOGGER.info("execute getNVRList method completed");
        
        return result;
    }
}
