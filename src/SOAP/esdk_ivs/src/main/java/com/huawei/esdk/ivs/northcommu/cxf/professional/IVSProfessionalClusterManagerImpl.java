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
package com.huawei.esdk.ivs.northcommu.cxf.professional;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.business.professional.clustermgr.ClusterService;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.bean.DeviceBriefInfoList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.util.IVSUtil;
import com.huawei.esdk.ivs.northcommu.cxf.professional.convert.IVSProfessionalClusterManagerConvert;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetNVRList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetNVRListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IVSProfessionalClusterManager;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 集群管理
 * <p>
 * 集群管理接口的实现
 * <p>
 * @author  sWX198756
 * @see  com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IVSProfessionalClusterManager
 * @since  eSDK IVS V100R003C00
 */
public class IVSProfessionalClusterManagerImpl implements IVSProfessionalClusterManager
{
    
    /**
     * 集群管理service层
     */
    private ClusterService clusterService;
    
    /**
     * 集群管理转换类：北向到领域，领域到北向
     */
    private IVSProfessionalClusterManagerConvert ivsProfessionalClusterManagerConvert;
    
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(IVSProfessionalClusterManagerImpl.class);
    
    /**
     * @param parameters NVR设备信息
     * @return GetNVRListResponse NVR设备列表
     * @exception SDKException  SDK异常
     * @exception Exception  系统错误（正常情况不应该出现）
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public GetNVRListResponse getNVRList(GetNVRList parameters)
    {
        GetNVRListResponse response = null;
        SDKResult<DeviceBriefInfoList> result = null;
        
        IndexRange indexRange = null;
        
        if (null == parameters)
        {
            // 参数错误
            LOGGER.error("The input parameter of getNVRList method is error");
            response = new GetNVRListResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        else
        {
            indexRange = ivsProfessionalClusterManagerConvert.getIndexRangeSoap2Model(parameters.getIndexRange());
            if (null == indexRange)
            {
                // 参数错误
                LOGGER.error("The input indexRange of getNVRList method is error");
                response = new GetNVRListResponse();
                response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
                return response;
            }
            
            // 分页信息判断
            if (!IVSUtil.validateIndexRange(indexRange.getFromIndex(), indexRange.getToIndex()))
            {
                LOGGER.error("The indexRange is error");
                response = new GetNVRListResponse();
                response.setResultCode(ErrInfo.IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR);
                return response;
            }
        }
        
        try
        {
            result = clusterService.getNVRList(parameters.getDomainCode(), parameters.getServerType(), indexRange);
        }
        catch (SDKException e)
        {
            LOGGER.error("getNVRList method SDK error", e);
            response = null == response ? new GetNVRListResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("getNVRList method error", e);
            response = null == response ? new GetNVRListResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        response = ivsProfessionalClusterManagerConvert.getNVRListModel2Soap(result);
        return response;
    }
    
    /** 
    * 利用spring IOC 注入service对象
    *
    * @param clusterService
    * @since eSDK IVS V100R003C00
    */
    public void setClusterService(ClusterService clusterService)
    {
        this.clusterService = clusterService;
    }
    
    /** 
     * 利用spring IOC 注入转换类的对象
     *
     * @param ivsProfessionalClusterManagerConvert
     * @since eSDK IVS V100R003C00
     */
    public void setIvsProfessionalClusterManagerConvert(
        IVSProfessionalClusterManagerConvert ivsProfessionalClusterManagerConvert)
    {
        this.ivsProfessionalClusterManagerConvert = ivsProfessionalClusterManagerConvert;
    }
    
}
