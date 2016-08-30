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
package com.huawei.esdk.ivs.northcommu.cxf.professional.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.Business;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.MediaAddress;
import com.huawei.esdk.ivs.domain.model.bean.OrderCondition;
import com.huawei.esdk.ivs.domain.model.bean.PTZControlInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfoList;
import com.huawei.esdk.ivs.domain.model.bean.QuerySnapshotParam;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RealPlay;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetOperationLogResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.GetPTZPresetListResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MediaURLParam;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.OperationLogInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.OperationLogInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.OperationLogInfos;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PlaybackParam;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PtzControlWithLockerInfoResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryField;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SnapshotInfo;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.SnapshotInfoList;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartPlatformPlayBackByIP;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartPlatformPlayBackByIPResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartRealPlayByIPEx;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.StartRealPlayByIPExResponse;
import com.huawei.esdk.ivs.northcommu.cxf.professional.gen.TimeSpan;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 业务管理北向到领域转换类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK IVS V100R003C00]
 */
public class IVSProfessionalBusinessManagerConvert
{
    
    /** 
    * 将预置信息转换成领域对象
    * 
    * @param ptzPresetInfo 北向预置信息
    * @return PTZPresetInfo 领域预置信息
    * @see [类、类#方法、类#成员]
    * @since  [eSDK IVS V100R003C00]
    */
    public PTZPresetInfo modifyPTZPresetSoap2Model(
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZPresetInfo ptzPresetInfo)
    {
        PTZPresetInfo info = new PTZPresetInfo();
        info.setPresetIndex(ptzPresetInfo.getPresetIndex());
        info.setPresetName(ptzPresetInfo.getPresetName());
        info.setReserve(ptzPresetInfo.getReserve());
        
        return info;
    }
    
    /**
     * 
     * 实况浏览参数soap转model
     * <功能详细描述>
     * @param parameters 北向soap
     * @return RealPlay 领域对象
     * @since  [eSDK IVS V100R003C00]
     */
    public RealPlay startRealPlayByIPExSoap2Model(StartRealPlayByIPEx parameters)
    {
        RealPlay realPlay = new RealPlay();
        
        if (null != parameters.getRealplayParam())
        {
            realPlay.setDirectFirst(parameters.getRealplayParam().getDirectFirst());
            realPlay.setStreamType(parameters.getRealplayParam().getStreamType());
            realPlay.setProtocolType(parameters.getRealplayParam().getProtocolType());
            realPlay.setMultiCast(parameters.getRealplayParam().getMultiCast());
            realPlay.setReserve(parameters.getRealplayParam().getReserve());
        }
        
        if (null != parameters.getMediaAddrDst())
        {
            MediaAddress mediaAddressModel = new MediaAddress();
            mediaAddressModel.setAudioPort(parameters.getMediaAddrDst().getAudioPort());
            mediaAddressModel.setVideoPort(parameters.getMediaAddrDst().getVideoPort());
            
            if (null != parameters.getMediaAddrDst().getDstIP())
            {
                com.huawei.esdk.ivs.domain.model.bean.IPInfo dstIp = new com.huawei.esdk.ivs.domain.model.bean.IPInfo();
                dstIp.setIp(parameters.getMediaAddrDst().getDstIP().getIp());
                dstIp.setIpType(parameters.getMediaAddrDst().getDstIP().getIpType());
                mediaAddressModel.setDstIP(dstIp);
            }
            
            realPlay.setMediaAddress(mediaAddressModel);
        }
        return realPlay;
    }
    
    public StartRealPlayByIPExResponse startRealPlayByIPExModel2Soap(RealPlay realPlay)
    {
        StartRealPlayByIPExResponse response = new StartRealPlayByIPExResponse();
        
        response.setHandle(realPlay.getHandle());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MediaAddress mediaAddressSoap =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MediaAddress();
            
        mediaAddressSoap.setAudioPort(realPlay.getMediaAddress().getAudioPort());
        mediaAddressSoap.setVideoPort(realPlay.getMediaAddress().getVideoPort());
        mediaAddressSoap.setReserve(realPlay.getMediaAddress().getReserve());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo ipInfoSoap =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IPInfo();
        ipInfoSoap.setIp(realPlay.getMediaAddress().getDstIP().getIp());
        ipInfoSoap.setIpType(realPlay.getMediaAddress().getDstIP().getIpType());
        
        mediaAddressSoap.setDstIP(ipInfoSoap);
        
        response.setMediaAddrSrc(mediaAddressSoap);
        return response;
    }
    
    /** 
     * 将领域预置信息列表转换成北向预置位信息列表
     * 
     * @param result 领域封装的预置位信息列表
     * @return GetPTZPresetListResponse 北向响应体信息
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    public GetPTZPresetListResponse getPTZPresetListModel2Soap(SDKResult<PTZPresetInfoList> result)
    {
        GetPTZPresetListResponse response = new GetPTZPresetListResponse();
        response.setResultCode((int)result.getErrCode());
        
        if (null != result.getResult() && null != result.getResult().getPresetInfos()
            && !result.getResult().getPresetInfos().isEmpty())
        {
            response.setPtzPresetNum(result.getResult().getPtzPresetNum());
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZPresetInfoList ptzPresetInfoList =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZPresetInfoList();
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZPresetInfo ptzPresetInfo = null;
            
            for (PTZPresetInfo info : result.getResult().getPresetInfos())
            {
                ptzPresetInfo = new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZPresetInfo();
                ptzPresetInfo.setPresetIndex(info.getPresetIndex());
                ptzPresetInfo.setPresetName(info.getPresetName());
                ptzPresetInfo.setReserve(info.getReserve());
                ptzPresetInfoList.getPtzPresetInfo().add(ptzPresetInfo);
            }
            
            response.setPtzPresetInfoList(ptzPresetInfoList);
        }
        
        return response;
    }
    
    /** 
    * 锁定用户信息领域对象转换为北向bean
    * @param result 锁定用户信息领域对象
    * @return 锁定用户信息北向bean
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public PtzControlWithLockerInfoResponse getPTZControlWithLockerInfoModel2Soap(SDKResult<PTZControlInfo> result)
    {
        PtzControlWithLockerInfoResponse response = new PtzControlWithLockerInfoResponse();
        response.setResultCode((int)result.getErrCode());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZControlInfo soap =
            getPTZControlInfoModel2Soap(result.getResult());
        if (null != soap)
        {
            response.setPtzControlInfo(soap);
        }
        
        return response;
    }
    
    private com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZControlInfo getPTZControlInfoModel2Soap(
        PTZControlInfo domain)
    {
        if (null == domain)
        {
            return null;
        }
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZControlInfo soap =
            new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.PTZControlInfo();
        IPInfo ipSoap = new IVSProfessionalDeviceManagerConvert().getIPInfoModel2Soap(domain.getIp());
        if (null != ipSoap)
        {
            soap.setIp(ipSoap);
        }
        soap.setLockStatus(domain.getLockStatus());
        soap.setReleaseTimeRemain(domain.getReleaseTimeRemain());
        soap.setReserve(domain.getReserve());
        soap.setUserId(domain.getUserId());
        soap.setUserName(domain.getUserName());
        return soap;
    }
    
    public Business startPlatformPlayBackByIPSoap2Model(StartPlatformPlayBackByIP parameters)
        throws SDKException
    {
        Business business = new Business();
        
        business.setCameraCode(parameters.getCameraCode());
        
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MediaAddress mediaAddressSoap =
            parameters.getMediaAddrDst();
        if (null != mediaAddressSoap)
        {
            com.huawei.esdk.ivs.domain.model.bean.MediaAddress mediaAddressModal =
                new com.huawei.esdk.ivs.domain.model.bean.MediaAddress();
            mediaAddressModal.setAudioPort(mediaAddressSoap.getAudioPort());
            mediaAddressModal.setVideoPort(mediaAddressSoap.getVideoPort());
            
            IPInfo ipInfoSoap = mediaAddressSoap.getDstIP();
            if (null != ipInfoSoap)
            {
                com.huawei.esdk.ivs.domain.model.bean.IPInfo ipInfoModal =
                    new com.huawei.esdk.ivs.domain.model.bean.IPInfo();
                ipInfoModal.setIp(ipInfoSoap.getIp());
                ipInfoModal.setIpType(ipInfoSoap.getIpType());
                mediaAddressModal.setDstIP(ipInfoModal);
            }
            mediaAddressModal.setReserve(mediaAddressSoap.getReserve());
            
            business.setMediaAddrSrc(mediaAddressModal);
        }
        
        PlaybackParam playbackParamSoap = parameters.getPlaybackParam();
        if (null != playbackParamSoap)
        {
            com.huawei.esdk.ivs.domain.model.bean.PlaybackParam playbackParamModal =
                new com.huawei.esdk.ivs.domain.model.bean.PlaybackParam();
            playbackParamModal.setProtocolType(playbackParamSoap.getProtocolType());
            playbackParamModal.setNVRCode(playbackParamSoap.getNVRCode());
            playbackParamModal.setSpeed((float)playbackParamSoap.getSpeed());
            
            TimeSpan recordTimeSoap = playbackParamSoap.getRecordTime();
            
            if (null != recordTimeSoap)
            {
                com.huawei.esdk.ivs.domain.model.bean.TimeSpan timeSpan =
                    new com.huawei.esdk.ivs.domain.model.bean.TimeSpan();
                    
                timeSpan.setEndTime(recordTimeSoap.getEndTime());
                
                timeSpan.setStartTime(recordTimeSoap.getStartTime());
                
                playbackParamModal.setRecordTime(timeSpan);
            }
            
            business.setPlaybackParam(playbackParamModal);
        }
        
        return business;
    }
    
    public StartPlatformPlayBackByIPResponse startPlatformPlayBackByIPModel2Soap(SDKResult<Business> result)
    {
        StartPlatformPlayBackByIPResponse startPlatformPlayBackByIPResponse = new StartPlatformPlayBackByIPResponse();
        
        startPlatformPlayBackByIPResponse.setResultCode((int)result.getErrCode());
        
        if (0 != result.getErrCode())
        {
            return startPlatformPlayBackByIPResponse;
        }
        
        Business business = result.getResult();
        if (null != business)
        {
            startPlatformPlayBackByIPResponse.setHandle(business.getHandle());
            
            com.huawei.esdk.ivs.domain.model.bean.MediaAddress mediaAddrSrcModal = business.getMediaAddrSrc();
            if (null != mediaAddrSrcModal)
            {
                com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MediaAddress mediaAddrSrcSoap =
                    new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.MediaAddress();
                mediaAddrSrcSoap.setAudioPort(mediaAddrSrcModal.getAudioPort());
                mediaAddrSrcSoap.setVideoPort(mediaAddrSrcModal.getVideoPort());
                
                com.huawei.esdk.ivs.domain.model.bean.IPInfo ipInfoModal = mediaAddrSrcModal.getDstIP();
                if (null != ipInfoModal)
                {
                    IPInfo ipInfoSoap = new IPInfo();
                    ipInfoSoap.setIp(ipInfoModal.getIp());
                    ipInfoSoap.setIpType(ipInfoModal.getIpType());
                    mediaAddrSrcSoap.setDstIP(ipInfoSoap);
                }
                
                mediaAddrSrcSoap.setReserve(mediaAddrSrcModal.getReserve());
                
                startPlatformPlayBackByIPResponse.setMediaAddrSrc(mediaAddrSrcSoap);
            }
        }
        
        return startPlatformPlayBackByIPResponse;
    }
    
    /** 
    * 转换北向QueryUnifiedFormat为领域层bean
    * 
    * @param unifiedQuery 北向获取用户列表查询条件
    * @return QueryUnifiedFormat 领域层获取用户列表查询条件
    * @see [类、类#方法、类#成员]
    */
    public QueryUnifiedFormat getQueryUnfiedSoap2Modal(
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QueryUnifiedFormat unifiedQuery)
    {
        if (null == unifiedQuery)
        {
            return null;
        }
        
        QueryUnifiedFormat queryUnifiedFormat = new QueryUnifiedFormat();
        queryUnifiedFormat.setFieldNum(unifiedQuery.getFieldNum());
        if (null != unifiedQuery.getIndex())
        {
            IndexRange index = new IndexRange();
            index.setFromIndex(unifiedQuery.getIndex().getFromIndex());
            index.setToIndex(unifiedQuery.getIndex().getToIndex());
            queryUnifiedFormat.setIndex(index);
        }
        if (null != unifiedQuery.getOrderCondition())
        {
            OrderCondition order = new OrderCondition();
            order.setEnableOrder(unifiedQuery.getOrderCondition().getEnableOrder());
            order.setField(unifiedQuery.getOrderCondition().getFieldType());
            order.setIsAscend(unifiedQuery.getOrderCondition().getIsAscend());
            queryUnifiedFormat.setOrderCondition(order);
        }
        if (null != unifiedQuery.getQueryFieldList())
        {
            List<com.huawei.esdk.ivs.domain.model.bean.QueryField> queryFields =
                new ArrayList<com.huawei.esdk.ivs.domain.model.bean.QueryField>();
            for (QueryField item : unifiedQuery.getQueryFieldList().getQueryField())
            {
                com.huawei.esdk.ivs.domain.model.bean.QueryField field =
                    new com.huawei.esdk.ivs.domain.model.bean.QueryField();
                field.setExactQuery(item.getExactQuery());
                field.setFieldType(item.getFieldType());
                field.setValue(item.getValue());
                queryFields.add(field);
            }
            queryUnifiedFormat.setQueryField(queryFields);
        }
        return queryUnifiedFormat;
    }
    
    /** 
    * 将南向返回的领域封装对象转成北向的响应体
    * 
    * @param result 南向返回的领域封装对象
    * @return GetUserListResponse 北向用户列表响应体
    * @see [类、类#方法、类#成员]
    */
    public GetOperationLogResponse getOperationLogResponseModal2Soap(SDKResult<Business> result)
    {
        
        GetOperationLogResponse getOperationLogResponse = new GetOperationLogResponse();
        getOperationLogResponse.setResultCode((int)result.getErrCode());
        
        Business businessModal = result.getResult();
        
        if (null == businessModal || null == businessModal.getOperationLogInfoList())
        {
            return getOperationLogResponse;
        }
        
        OperationLogInfos operationLogInfos = new OperationLogInfos();
        
        operationLogInfos.setTotal(businessModal.getTotal());
        if (null != businessModal.getIndexRange())
        {
            com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange indexSoap =
                new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange();
            indexSoap.setFromIndex(businessModal.getIndexRange().getFromIndex());
            indexSoap.setToIndex(businessModal.getIndexRange().getToIndex());
            operationLogInfos.setIndexRange(indexSoap);
        }
        
        OperationLogInfoList operationLogInfoList = new OperationLogInfoList();
        for (com.huawei.esdk.ivs.domain.model.bean.OperationLogInfo operationLogInfo : businessModal
            .getOperationLogInfoList())
        {
            operationLogInfoList.getOperationLogInfo().add(getOperationLogInfoModal2Soap(operationLogInfo));
        }
        operationLogInfos.setOperationLogInfoList(operationLogInfoList);
        
        getOperationLogResponse.setOperationLogInfos(operationLogInfos);
        
        return getOperationLogResponse;
    }
    
    /** 
    * 将南向返回的领域封装对象转成北向的响应体
    * 
    * @param operationLog
    * @return
    * @see [类、类#方法、类#成员]
    */
    private OperationLogInfo getOperationLogInfoModal2Soap(
        com.huawei.esdk.ivs.domain.model.bean.OperationLogInfo operationLog)
    {
        if (null == operationLog)
        {
            return null;
        }
        OperationLogInfo operationLogInfo = new OperationLogInfo();
        operationLogInfo.setAccount(operationLog.getAccount());
        operationLogInfo.setClientIp(operationLog.getClientIp());
        operationLogInfo.setLogGrade(operationLog.getLogGrade());
        operationLogInfo.setServiceCode(operationLog.getServiceCode());
        operationLogInfo.setModuleType(operationLog.getModuleType());
        operationLogInfo.setModuleCode(operationLog.getModuleCode());
        operationLogInfo.setOperationCode(operationLog.getOperationCode());
        operationLogInfo.setOperationObjectCode(operationLog.getOperationObjectCode());
        operationLogInfo.setOccurTime(operationLog.getOccurTime());
        operationLogInfo.setErrorCode(operationLog.getErrorCode());
        operationLogInfo.setResult(operationLog.getResult());
        operationLogInfo.setAdditionalInfo(operationLog.getAdditionalInfo());
        operationLogInfo.setReserve(operationLog.getReserve());
        return operationLogInfo;
    }
    
    /** 
     * 将预置信息转换成领域对象
     * 
     * @param querySnapshotParam
     * @author likun/l00295065
     * @return
     * @see [类、类#方法、类#成员]
     */
    public QuerySnapshotParam getQuerySnapshotParamSoap2Model(
        com.huawei.esdk.ivs.northcommu.cxf.professional.gen.QuerySnapshotParam querySnapshotParam)
    {
        QuerySnapshotParam param = new QuerySnapshotParam();
        
        param.setSnapType(querySnapshotParam.getSnapType());
        param.setReserve(querySnapshotParam.getReserve());
        
        param.setIndexRange(new IndexRange());
        param.setTimeSpan(new com.huawei.esdk.ivs.domain.model.bean.TimeSpan());
        
        param.getIndexRange().setFromIndex(querySnapshotParam.getIndexRange().getFromIndex());
        param.getIndexRange().setToIndex(querySnapshotParam.getIndexRange().getToIndex());
        
        param.getTimeSpan().setStartTime(querySnapshotParam.getTimeSpan().getStartTime());
        param.getTimeSpan().setEndTime(querySnapshotParam.getTimeSpan().getEndTime());
        
        return param;
    }
    
    /** 
     * 将南向返回的领域封装对象转成北向的响应体
     * 
     * @param snapshotInfoList
     * @author likun/l00295065
     * @return
     * @see [类、类#方法、类#成员]
     */
    public SnapshotInfoList getSnapshotInfoListModel2Soap(
        com.huawei.esdk.ivs.domain.model.bean.SnapshotInfoList snapshotInfoList)
    {
        if (null == snapshotInfoList)
        {
            return null;
        }
        
        SnapshotInfoList resultList = new SnapshotInfoList();
        resultList.setTotal(snapshotInfoList.getTotal());
        
        resultList.setIndexRange(new com.huawei.esdk.ivs.northcommu.cxf.professional.gen.IndexRange());
        resultList.getIndexRange().setFromIndex(snapshotInfoList.getIndexRange().getFromIndex());
        resultList.getIndexRange().setToIndex(snapshotInfoList.getIndexRange().getToIndex());
        
        List<SnapshotInfo> snapshotInfos = resultList.getSnapshotInfos();
        if (null != snapshotInfoList.getSnapshotInfos())
        {
            for (com.huawei.esdk.ivs.domain.model.bean.SnapshotInfo info : snapshotInfoList.getSnapshotInfos())
            {
                SnapshotInfo snapshotInfo = new SnapshotInfo();
                snapshotInfo.setCameraCode(info.getCameraCode());
                snapshotInfo.setSnapTime(info.getSnapTime());
                snapshotInfo.setSnapType(info.getSnapType());
                snapshotInfo.setPictureID(info.getPictureID());
                snapshotInfo.setPictureName(info.getPictureName());
                snapshotInfo.setPictureSize(info.getPictureSize());
                snapshotInfo.setPreviewUrl(info.getPreviewUrl());
                snapshotInfo.setPictureUrl(info.getPictureUrl());
                snapshotInfo.setReserve(info.getReserve());
                
                snapshotInfos.add(snapshotInfo);
            }
        }
        
        return resultList;
    }
    
    public com.huawei.esdk.ivs.domain.model.bean.MediaURLParam mediaURLParamSoap2Model(MediaURLParam mediaURLParam)
    {
        com.huawei.esdk.ivs.domain.model.bean.MediaURLParam mediaURLParamModel = null;
        if (null != mediaURLParam)
        {
            mediaURLParamModel = new com.huawei.esdk.ivs.domain.model.bean.MediaURLParam();
            mediaURLParamModel.setServiceType(mediaURLParam.getServiceType());
            mediaURLParamModel.setPackProtocolType(mediaURLParam.getPackProtocolType());
            mediaURLParamModel.setFileName(mediaURLParam.getFileName());
            mediaURLParamModel.setClientType(mediaURLParam.getClientType());
            mediaURLParamModel.setStreamType(mediaURLParam.getStreamType());
            mediaURLParamModel.setProtocolType(mediaURLParam.getProtocolType());
            mediaURLParamModel.setTransMode(mediaURLParam.getTransMode());
            mediaURLParamModel.setBroadCastType(mediaURLParam.getBroadCastType());
            mediaURLParamModel.setVideoDecType(mediaURLParam.getVideoDecType());
            mediaURLParamModel.setAudioDecType(mediaURLParam.getAudioDecType());
            mediaURLParamModel.setNvrCode(mediaURLParam.getNVRCode());
            mediaURLParamModel.setReserve(mediaURLParam.getReserve());
            
            if (null != mediaURLParam.getTimeSpan())
            {
                com.huawei.esdk.ivs.domain.model.bean.TimeSpan timeSpan =
                    new com.huawei.esdk.ivs.domain.model.bean.TimeSpan();
                timeSpan.setStartTime(mediaURLParam.getTimeSpan().getStartTime());
                timeSpan.setEndTime(mediaURLParam.getTimeSpan().getEndTime());
                mediaURLParamModel.setTimeSpan(timeSpan);
            }
            
        }
        return mediaURLParamModel;
    }
}
