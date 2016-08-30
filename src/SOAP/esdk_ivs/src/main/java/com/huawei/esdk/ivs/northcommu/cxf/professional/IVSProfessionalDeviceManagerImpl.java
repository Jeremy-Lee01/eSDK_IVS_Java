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

import com.huawei.esdk.ivs.business.professional.devicemgr.DeviceMgrService;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.bean.DeviceGroupInfos;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.DomainRouteList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.util.IVSUtil;
import com.huawei.esdk.ivs.northcommu.cxf.professional.convert.IVSProfessionalDeviceManagerConvert;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddDevice;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.AddDeviceResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteDevice;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeleteDeviceResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.DeviceOperResultInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceConfig;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceConfigResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceGroup;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceGroupResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDeviceListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDomainRoute;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetDomainRouteResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetVideoDiagnose;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetVideoDiagnoseResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IVSProfessionalDeviceManager;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryDeviceList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryDeviceListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RebootDevice;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.RebootDeviceResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetCameraName;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetCameraNameResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetDeviceConfig;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetDeviceConfigResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetMainDeviceName;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetMainDeviceNameResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetVideoDiagnose;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SetVideoDiagnoseResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartSearchDevice;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartSearchDeviceResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StopSearchDevice;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StopSearchDeviceResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.VerifyDevice;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.VerifyDeviceResponse;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class IVSProfessionalDeviceManagerImpl implements IVSProfessionalDeviceManager
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(IVSProfessionalDeviceManagerImpl.class);
    
    /**
     * 设备管理service层
     */
    private DeviceMgrService deviceMgrService;
    
    /**
     * 设备管理转换类：北向到领域，领域到北向
     */
    private IVSProfessionalDeviceManagerConvert ivsProfessionalDeviceManagerConvert;
    
    /**
     * 修改摄像机名称
     * @param parameters 设置参数 
     * @return SetCameraNameResponse 设置结果
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SetCameraNameResponse setCameraName(SetCameraName parameters)
    {
        SetCameraNameResponse response = new SetCameraNameResponse();
        try
        {
            SDKErrorCode result =
                deviceMgrService.setCameraName(parameters.getCameraCode(), parameters.getNewCameraName());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("setMainDeviceName method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("setMainDeviceName method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /**
     * 获取用户拥有权限的整个系统中的域路由信息
     * @param parameters 域路由信息
     * @return GetDomainRouteResponse 域路由信息
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public GetDomainRouteResponse getDomainRoute(GetDomainRoute parameters)
    {
        GetDomainRouteResponse response = null;
        try
        {
            SDKResult<DomainRouteList> result = deviceMgrService.getDomainRoute();
            response = ivsProfessionalDeviceManagerConvert.getDomainRouteResponseModel2Soap(result);
        }
        catch (SDKException e)
        {
            LOGGER.error("getDomainRoute method SDK error", e);
            response = null == response ? new GetDomainRouteResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getDomainRoute method error", e);
            response = null == response ? new GetDomainRouteResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    @Override
    public GetDeviceListResponse getDeviceList(GetDeviceList parameters)
    {
        GetDeviceListResponse response = new GetDeviceListResponse();
        
        if (null == parameters)
        {
            LOGGER.error("The input parameter of getDeviceList method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        //分页条件判断
        if (!IVSUtil.validateIndexRange(parameters.getIndexRange().getFromIndex(), parameters.getIndexRange()
            .getToIndex()))
        {
            LOGGER.error("The indexRange is error");
            response.setResultCode(ErrInfo.IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR);
            return response;
        }
        
        SDKResult<Object> result = new SDKResult<Object>();
        
        IndexRange indexRange = ivsProfessionalDeviceManagerConvert.getDeviceListSoap2Model(parameters.getIndexRange());
        
        try
        {
            result = deviceMgrService.getDeviceList(parameters.getDeviceType(), indexRange);
        }
        catch (SDKException e)
        {
            LOGGER.error("getDeviceList method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("getDeviceList method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response = ivsProfessionalDeviceManagerConvert.getDeviceListModel2Soap(result, parameters.getDeviceType());
        return response;
    }
    
    /**
     * 添加设备
     * @param parameters 设备具体信息
     * @return AddDeviceResponse 添加结果
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public AddDeviceResponse addDevice(AddDevice parameters)
    {
        AddDeviceResponse response = new AddDeviceResponse();
        SDKResult<DeviceOperResultList> result = new SDKResult<DeviceOperResultList>();
        try
        {
            result =
                deviceMgrService.addDevice(parameters.getDomainCode(),
                    parameters.getDeviceNum(),
                    ivsProfessionalDeviceManagerConvert.addDeviceSoap2Model(parameters.getDeviceOperInfos()));
            response.setResultCode((int)result.getErrCode());
            
            DeviceOperResultInfos deviceOperResultInfo =
                ivsProfessionalDeviceManagerConvert.addDeviceModel2Soap(result.getResult());
            response.setDeviceOperResultInfos(deviceOperResultInfo);
        }
        catch (SDKException e)
        {
            LOGGER.error("add device failed", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("add device failed", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /**
     * 重启设备
     * @param parameters 待重启的设备
     * @return RebootDeviceResponse 重启结果
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public RebootDeviceResponse rebootDevice(RebootDevice parameters)
    {
        RebootDeviceResponse response = new RebootDeviceResponse();
        SDKErrorCode result = null;
        try
        {
            result = deviceMgrService.rebootDevice(parameters.getDeviceCode(), parameters.getRebootType());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("reboot device sdk error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("reboot device exception", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /**
     * 停止搜索设备
     * @param parameters 停止搜索设备入参
     * @return StopSearchDeviceResponse 停止搜索设备结果
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public StopSearchDeviceResponse stopSearchDevice(StopSearchDevice parameters)
    {
        StopSearchDeviceResponse response = new StopSearchDeviceResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getDomainCode())
            || StringUtils.isEmpty(parameters.getSearchInfo()))
        {
            // 参数错误
            LOGGER.error("The input parameter of stopSearchDevice method is error");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        try
        {
            SDKErrorCode result = deviceMgrService.stopSearchDevice(parameters.getDomainCode(), parameters.getSearchInfo());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("stop search device sdk error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("stop search device exception", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /**
     * 开始搜索设备
     * @param parameters 开始搜索设备入参
     * @return RebootDeviceResponse 开始搜索设备结果
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public StartSearchDeviceResponse startSearchDevice(StartSearchDevice parameters)
    {
        StartSearchDeviceResponse response = new StartSearchDeviceResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getDomainCode())
            || StringUtils.isEmpty(parameters.getSearchInfo()))
        {
            // 参数错误
            LOGGER.error("The input parameter of startSearchDevice method is error");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKErrorCode result = deviceMgrService.startSearchDevice(parameters.getDomainCode(), parameters.getSearchInfo());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("startSearchDevice method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("startSearchDevice method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /**
     * 获取设置设备参数
     * @param  parameters  北向设备Bean  
     * @return  GetDeviceConfigResponse  北向设备参数返回结果Bean   
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public GetDeviceConfigResponse getDeviceConfig(GetDeviceConfig parameters)
    {
        GetDeviceConfigResponse response = null;
        if (null == parameters)
        {
            // 参数错误
            LOGGER.error("The input parameter of getDeviceConfig method is error");
            response = new GetDeviceConfigResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKResult<Object> result =
                deviceMgrService.getDeviceConfig(parameters.getDeviceCode(), parameters.getConfigType());
            response =
                ivsProfessionalDeviceManagerConvert.getDeviceConfigModel2Soap(result, parameters.getConfigType());
        }
        catch (SDKException e)
        {
            LOGGER.error("getDeviceConfig method SDK error", e);
            response = null == response ? new GetDeviceConfigResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getDeviceConfig method error", e);
            response = null == response ? new GetDeviceConfigResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /**
     * 设置设备参数
     * @param  parameters  设置设备与具体参数  
     * @return  SetDeviceConfigResponse  设置结果   
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SetDeviceConfigResponse setDeviceConfig(SetDeviceConfig parameters)
    {
        SetDeviceConfigResponse response = new SetDeviceConfigResponse();
        try
        {
            Object dataBuffer =
                ivsProfessionalDeviceManagerConvert.setDeviceConfigSoap2Model(parameters.getConfigType(),
                    parameters.getConfigItem());
            
            SDKErrorCode result =
                deviceMgrService.setDeviceConfig(parameters.getDeviceCode(), parameters.getConfigType(), dataBuffer);
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("set device config sdk error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("set device config exception", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        
        return response;
    }
    
    /**
     * 设置主设备名称
     * @param  parameters  设置主设备名称入参
     * @return  SetMainDeviceNameResponse  设置结果   
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SetMainDeviceNameResponse setMainDeviceName(SetMainDeviceName parameters)
    {
        SetMainDeviceNameResponse response = new SetMainDeviceNameResponse();
        try
        {
            SDKErrorCode result =
                deviceMgrService.setMainDeviceName(parameters.getDeviceCode(), parameters.getNewDeviceName());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("setMainDeviceName method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("setMainDeviceName method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    @Override
    public QueryDeviceListResponse queryDeviceList(QueryDeviceList parameters)
    {
        QueryDeviceListResponse response = new QueryDeviceListResponse();
        
        if (null == parameters || null == parameters.getQueryFormat()
            || null == parameters.getQueryFormat().getQueryFieldList())
        {
            LOGGER.error("The input parameter of queryDeviceList method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        int size = parameters.getQueryFormat().getQueryFieldList().getQueryField().size();
        if (parameters.getQueryFormat().getFieldNum() != size)
        {
            LOGGER.error("The input parameter of queryDeviceList method is error");
            response.setResultCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return response;
        }
        
        //分页条件判断
        if (!IVSUtil.validateIndexRange(parameters.getQueryFormat().getIndex().getFromIndex(),
            parameters.getQueryFormat().getIndex().getToIndex()))
        {
            LOGGER.error("The indexRange is error");
            response.setResultCode(ErrInfo.IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR);
            return response;
        }
        
        QueryUnifiedFormat queryUnifiedFormat =
            ivsProfessionalDeviceManagerConvert.queryDeviceListSoap2Model(parameters.getQueryFormat());
        
        SDKResult<Object> result = new SDKResult<Object>();
        
        try
        {
            result =
                deviceMgrService.queryDeviceList(parameters.getDeviceType(),
                    queryUnifiedFormat,
                    parameters.getDomainCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("queryDeviceList method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception e)
        {
            LOGGER.error("queryDeviceList method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        
        response = ivsProfessionalDeviceManagerConvert.queryDeviceListModel2Soap(result);
        
        return response;
    }
    
    /**
     * 删除主设备
     * 删除主设备 （批量）
     * @param parameters 主设备信息
     * @return DeleteDeviceResponse 删除主设备的返回信息
     * @exception SDKException  SDK异常
     * @exception Exception  系统错误（正常情况不应该出现）
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public DeleteDeviceResponse deleteDevice(DeleteDevice parameters)
    {
        DeleteDeviceResponse response = null;
        if (null == parameters || null == parameters.getDeviceCodeList())
        {
            // 参数错误
            LOGGER.error("The input parameter of deleteDevice method is error");
            response = new DeleteDeviceResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            SDKResult<DeviceOperResultList> result =
                deviceMgrService.deleteDevice(parameters.getDomainCode(),
                    parameters.getDeviceNum(),
                    ivsProfessionalDeviceManagerConvert.getDeviceCodeListSoap2Model(parameters.getDeviceCodeList()));
            response = ivsProfessionalDeviceManagerConvert.getDeleteDeviceResponseModel2Soap(result);
        }
        catch (SDKException e)
        {
            LOGGER.error("deleteDevice method SDK error", e);
            response = null == response ? new DeleteDeviceResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("deleteDevice method error", e);
            response = null == response ? new DeleteDeviceResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    //产品未实现该方法，暂时注释
    //    /**
    //     * 查询摄像机码流能力
    //     * @param parameters 摄像机信息
    //     * @return DeleteDeviceResponse 录像任务XML
    //     * @exception SDKException  SDK异常
    //     * @exception Exception  系统错误（正常情况不应该出现）
    //     * @since  eSDK IVS V100R003C00
    //     */
    //    @Override
    //    public GetDeviceCapabilityResponse getDeviceCapability(GetDeviceCapability parameters)
    //    {
    //        GetDeviceCapabilityResponse response = null;
    //        if (null == parameters)
    //        {
    //            // 参数错误
    //            LOGGER.error("The input parameter of getDeviceCapability method is error");
    //            response = new GetDeviceCapabilityResponse();
    //            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
    //            return response;
    //        }
    //        try
    //        {
    //            response = new GetDeviceCapabilityResponse();
    //            SDKResult<String> result =
    //                deviceMgrService.getDeviceCapability(parameters.getCapabilityType(), parameters.getDeviceCode());
    //            response.setResultCode((int)result.getErrCode());
    //            if (0 == result.getErrCode())
    //            {
    //                response.setResponseXML(result.getResult());
    //            }
    //        }
    //        catch (SDKException e)
    //        {
    //            LOGGER.error("deleteDevice method SDK error", e);
    //            response = null == response ? new GetDeviceCapabilityResponse() : response;
    //            response.setResultCode((int)e.getSdkErrCode());
    //        }
    //        catch (Exception e)
    //        {
    //            LOGGER.error("deleteDevice method error", e);
    //            response = null == response ? new GetDeviceCapabilityResponse() : response;
    //            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
    //        }
    //        return response;
    //    }
    
    /**
     * 校验设备
     * @param  parameters  校验设备入参
     * @return  VerifyDeviceResponse  校验设备结果   
     * @exception  SDKException  SDK异常
     * @exception  Exception  系统错误（正常情况不应该出现）
     * @since eSDK IVS V100R003C00
     */
    @Override
    public VerifyDeviceResponse verifyDevice(VerifyDevice parameters)
    {
        VerifyDeviceResponse response = new VerifyDeviceResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getDomainCode())
            || StringUtils.isEmpty(parameters.getVerifyInfo()))
        {
            // 参数错误
            LOGGER.error("The input parameter of verifyDevice method is error");
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        
        try
        {
            SDKResult<String> result = deviceMgrService.verifyDevice(parameters.getDomainCode(), parameters.getVerifyInfo());
            response.setResultCode((int)result.getErrCode());
            if (0 == result.getErrCode())
            {
                response.setResponseXML(result.getResult());
            }
        }
        catch (SDKException e)
        {
            LOGGER.error("verifyDevice method SDK error", e);
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("verifyDevice method error", e);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    public void setDeviceMgrService(DeviceMgrService deviceMgrService)
    {
        this.deviceMgrService = deviceMgrService;
    }
    
    public void setIvsProfessionalDeviceManagerConvert(
        IVSProfessionalDeviceManagerConvert ivsProfessionalDeviceManagerConvert)
    {
        this.ivsProfessionalDeviceManagerConvert = ivsProfessionalDeviceManagerConvert;
    }
    
    /** 
     * 获取设备组列表
     * @param parameters 设备组
     * @return  GetDeviceGroupResponse 设备组列表
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public GetDeviceGroupResponse getDeviceGroup(GetDeviceGroup parameters)
    {
        GetDeviceGroupResponse response = new GetDeviceGroupResponse();
        
        if (null == parameters || StringUtils.isEmpty(parameters.getDomainCode()))
        {
            // 参数错误
            LOGGER.error("The input parameter of getDeviceGroup method is error");
            response.setResultCode(ErrInfo.DATA_ERRORCODE);
            return response;
        }
        
        SDKResult<DeviceGroupInfos> result = null;
        
        try
        {
            result = deviceMgrService.getDeviceGroup(parameters.getDomainCode(), parameters.getDeviceGroupCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("getDeviceGroup method failed", e);
            response.setResultCode((int)e.getSdkErrCode());
            return response;
        }
        catch (Exception ex)
        {
            LOGGER.error("getDeviceGroup method failed", ex);
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
            return response;
        }
        response = ivsProfessionalDeviceManagerConvert.getDeviceGroupResponseModel2Soap(result);
        return response;
    }

    /**
     * @param parameters 设备信息
     * @return GetVideoDiagnoseResponse 单台VCN的视频质量诊断计划xml
     * @since  eSDK IVS V100R003C30
     */
    @Override
    public GetVideoDiagnoseResponse getVideoDiagnose(GetVideoDiagnose parameters)
    {
        GetVideoDiagnoseResponse response = null;
        if (null == parameters || StringUtils.isEmpty(parameters.getCameraCode()) || StringUtils.isEmpty(parameters.getDomainCode()))
        {
            // 参数错误
            LOGGER.error("The input parameter of getVideoDiagnose method is error");
            response = new GetVideoDiagnoseResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            response = new GetVideoDiagnoseResponse();
            SDKResult<String> result =
                deviceMgrService.getVideoDiagnose(parameters.getCameraCode(), parameters.getDomainCode());
            response.setResultCode((int)result.getErrCode());
            response.setDiagnoseXML(result.getResult());
        }
        catch (SDKException e)
        {
            LOGGER.error("getVideoDiagnose method SDK error", e);
            response = null == response ? new GetVideoDiagnoseResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("getVideoDiagnose method error", e);
            response = null == response ? new GetVideoDiagnoseResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
    /**
     * @param parameters 单台VCN的视频质量诊断计划xml
     * @return SetVideoDiagnoseResponse
     * @since  eSDK IVS V100R003C30
     */
    @Override
    public SetVideoDiagnoseResponse setVideoDiagnose(SetVideoDiagnose parameters)
    {
        SetVideoDiagnoseResponse response = null;
        if (null == parameters || StringUtils.isEmpty(parameters.getDiagnoseXML()))
        {
            // 参数错误
            LOGGER.error("The input parameter of setVideoDiagnose method is error");
            response = new SetVideoDiagnoseResponse();
            response.setResultCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return response;
        }
        try
        {
            response = new SetVideoDiagnoseResponse();
            SDKErrorCode result =
                deviceMgrService.setVideoDiagnose(parameters.getDiagnoseXML());
            response.setResultCode((int)result.getErrCode());
        }
        catch (SDKException e)
        {
            LOGGER.error("setVideoDiagnose method SDK error", e);
            response = null == response ? new SetVideoDiagnoseResponse() : response;
            response.setResultCode((int)e.getSdkErrCode());
        }
        catch (Exception e)
        {
            LOGGER.error("setVideoDiagnose method error", e);
            response = null == response ? new SetVideoDiagnoseResponse() : response;
            response.setResultCode(ErrInfo.SDK_SYSTEM_ERRORCODE);
        }
        return response;
    }
    
}
