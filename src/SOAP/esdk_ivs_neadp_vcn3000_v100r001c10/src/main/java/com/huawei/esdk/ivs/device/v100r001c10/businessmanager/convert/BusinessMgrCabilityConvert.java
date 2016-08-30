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
package com.huawei.esdk.ivs.device.v100r001c10.businessmanager.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.device.v100r001c10.devicemanager.convert.DeviceMgrCabilityConvert;
import com.huawei.esdk.ivs.domain.model.Business;
import com.huawei.esdk.ivs.domain.model.bean.IPInfo;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.MediaAddress;
import com.huawei.esdk.ivs.domain.model.bean.MediaURLParam;
import com.huawei.esdk.ivs.domain.model.bean.OperationLogInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZControlInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfo;
import com.huawei.esdk.ivs.domain.model.bean.PlaybackParam;
import com.huawei.esdk.ivs.domain.model.bean.QuerySnapshotParam;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RealPlay;
import com.huawei.esdk.ivs.domain.model.bean.SnapshotInfo;
import com.huawei.esdk.ivs.domain.model.bean.SnapshotInfoList;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryFieldSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr.QueryUnifiedFormatSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.IndexRangeSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.MediaAddressSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.MediaURLParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.OperationLogInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.OperationLogListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.PTZControlInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.PTZPresetInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.PlayBackParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.QuerySnapshotParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.RealplayParamSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.SnapshotInfoListSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.SnapshotInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr.TimeSpanSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.IPInfoSouth;
import com.huawei.esdk.platform.common.utils.BytesUtils;
import com.huawei.esdk.platform.common.utils.StringUtils;

/**
 * 南向业务管理转换类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK IVS V100R003C00]
 */
public class BusinessMgrCabilityConvert
{
    
    /** 
    * 领域的预置信息改为南向预置信息
    * 
    * @param ptzPresetInfo 领域的预置信息
    * @return PTZPresetInfoSouth 南向预置信息
    * @see [类、类#方法、类#成员]
    * @since  [eSDK IVS V100R003C00]
    */
    public PTZPresetInfoSouth modifyPTZPresetModel2South(PTZPresetInfo ptzPresetInfo)
    {
        PTZPresetInfoSouth ptzPresetInfoSouth = new PTZPresetInfoSouth();
        
        //分配内存
        ptzPresetInfoSouth.clear();
        ptzPresetInfoSouth.presetIndex = ptzPresetInfo.getPresetIndex();
        
        ptzPresetInfoSouth.presetName = BytesUtils.stringToBytesForIVS(ptzPresetInfo.getPresetName());
        ptzPresetInfoSouth.reserve = BytesUtils.stringToBytesForIVS(ptzPresetInfo.getReserve());
        
        return ptzPresetInfoSouth;
    }
    
    public RealplayParamSouth getRealplayParamModel2South(RealPlay realPlay)
    {
        RealplayParamSouth realplayParamSouth = new RealplayParamSouth();
        realplayParamSouth.clear();
        
        realplayParamSouth.directFirst = realPlay.getDirectFirst();
        realplayParamSouth.streamType = realPlay.getStreamType();
        realplayParamSouth.protocolType = realPlay.getProtocolType();
        realplayParamSouth.multiCast = realPlay.getMultiCast();
        
        realplayParamSouth.reserve = BytesUtils.stringToBytesForIVS(realPlay.getReserve());
        
        return realplayParamSouth;
    }
    
    public MediaAddressSouth getMediaAddressSouthModel2South(MediaAddress mediaAddrDst)
    {
        MediaAddressSouth mediaAddressSouth = new MediaAddressSouth();
        mediaAddressSouth.clear();
        
        mediaAddressSouth.audioPort = mediaAddrDst.getAudioPort();
        mediaAddressSouth.videoPort = mediaAddrDst.getVideoPort();
        IPInfoSouth ipInfoSouth = new IPInfoSouth();
        ipInfoSouth.clear();
        
        if (null != mediaAddrDst.getDstIP())
        {
            ipInfoSouth.ip = BytesUtils.stringToBytesForIVS(mediaAddrDst.getDstIP().getIp());
            ipInfoSouth.ipType = mediaAddrDst.getDstIP().getIpType();
        }
        mediaAddressSouth.dstIP = ipInfoSouth;
        
        return mediaAddressSouth;
    }
    
    public RealPlay startRealPlayByIPExSouth2Model(MediaAddressSouth mediaAddrSrc)
    {
        RealPlay realPlay = new RealPlay();
        
        MediaAddress mediaAddressModel = new MediaAddress();
        mediaAddressModel.setAudioPort(mediaAddrSrc.audioPort);
        mediaAddressModel.setVideoPort(mediaAddrSrc.videoPort);
        mediaAddressModel.setReserve(BytesUtils.bytesToStringForIVS(mediaAddrSrc.reserve));
        
        IPInfo ipInfo = new IPInfo();
        ipInfo.setIp(BytesUtils.bytesToStringForIVS(mediaAddrSrc.dstIP.ip));
        mediaAddressModel.setDstIP(ipInfo);
        
        realPlay.setMediaAddress(mediaAddressModel);
        return realPlay;
    }
    
    /** 
    * 将南向的预置位信息列表转面领域层对象
    * 
    * @param presetInfoSouths 南向的预置位信息列表
    * @param total 预置位总数
    * @return List<PTZPresetInfo> 领域层预置位信息列表
    * @see [类、类#方法、类#成员]
    * @since  [eSDK IVS V100R003C00]
    */
    public List<PTZPresetInfo> getPTZPresetListSouth2Model(PTZPresetInfoSouth[] presetInfoSouths, int total)
    {
        List<PTZPresetInfo> list = new ArrayList<PTZPresetInfo>();
        PTZPresetInfo info = null;
        
        // 共128个对象，只需要转换有预置位的，其他的空对象舍掉
        for (int i = 0; i < total; i++)
        {
            info = new PTZPresetInfo();
            info.setPresetIndex(presetInfoSouths[i].presetIndex);
            info.setPresetName(BytesUtils.bytesToStringForIVS(presetInfoSouths[i].presetName));
            info.setReserve(BytesUtils.bytesToStringForIVS(presetInfoSouths[i].reserve));
            list.add(info);
        }
        
        return list;
    }
    
    public PTZControlInfo getPTZControlInfoSouth2Model(PTZControlInfoSouth south)
    {
        PTZControlInfo domain = new PTZControlInfo();
        IPInfo ipDomain = new DeviceMgrCabilityConvert().getIPInfoSouth2Model(south.ipInfo);
        if (ipDomain != null)
        {
            domain.setIp(ipDomain);
        }
        domain.setLockStatus(south.lockStatus);
        domain.setReleaseTimeRemain(south.releaseTimeRemain);
        domain.setReserve(BytesUtils.bytesToStringForIVS(south.reserve));
        domain.setUserId(south.userId);
        domain.setUserName(BytesUtils.bytesToStringForIVS(south.userName));
        return domain;
    }
    
    public MediaAddress getMediaAddressSouth2Model(MediaAddressSouth mediaAddressSouthOut)
    {
        MediaAddress mediaAddressModal = new MediaAddress();
        if (null != mediaAddressSouthOut)
        {
            
            mediaAddressModal.setAudioPort(mediaAddressSouthOut.audioPort);
            mediaAddressModal.setVideoPort(mediaAddressSouthOut.videoPort);
            
            IPInfoSouth ipInfoSoap = mediaAddressSouthOut.dstIP;
            if (null != ipInfoSoap)
            {
                com.huawei.esdk.ivs.domain.model.bean.IPInfo ipInfoModal =
                    new com.huawei.esdk.ivs.domain.model.bean.IPInfo();
                ipInfoModal.setIp(BytesUtils.bytesToStringForIVS(ipInfoSoap.ip));
                ipInfoModal.setIpType(ipInfoSoap.ipType);
                mediaAddressModal.setDstIP(ipInfoModal);
            }
            
            mediaAddressModal.setReserve(BytesUtils.bytesToStringForIVS(mediaAddressSouthOut.reserve));
        }
        
        return mediaAddressModal;
    }
    
    public MediaAddressSouth getMediaAddressModel2South(MediaAddress mediaAddrSrc)
    {
        MediaAddressSouth mediaAddressSouth = new MediaAddressSouth();
        mediaAddressSouth.clear();
        if (null != mediaAddrSrc)
        {
            
            mediaAddressSouth.audioPort = mediaAddrSrc.getAudioPort();
            mediaAddressSouth.videoPort = mediaAddrSrc.getVideoPort();
            if (null != mediaAddrSrc.getReserve())
            {
                mediaAddressSouth.reserve = BytesUtils.stringToBytesForIVS(mediaAddrSrc.getReserve());
            }
            
            com.huawei.esdk.ivs.domain.model.bean.IPInfo ipInfoModal = mediaAddrSrc.getDstIP();
            if (null != ipInfoModal)
            {
                IPInfoSouth ipInfoSouth = new IPInfoSouth();
                ipInfoSouth.clear();
                ipInfoSouth.ip = BytesUtils.stringToBytesForIVS(ipInfoModal.getIp());
                ipInfoSouth.ipType = ipInfoModal.getIpType();
                mediaAddressSouth.dstIP = ipInfoSouth;
            }
        }
        
        return mediaAddressSouth;
    }
    
    public PlayBackParamSouth getPlayBackParamModel2South(PlaybackParam playbackParam)
    {
        PlayBackParamSouth playbackParamSouth = new PlayBackParamSouth();
        playbackParamSouth.clear();
        
        if (null != playbackParam)
        {
            
            playbackParamSouth.protocolType = playbackParam.getProtocolType();
            if (null != playbackParam.getNVRCode())
            {
                playbackParamSouth.NVRCode = BytesUtils.stringToBytesForIVS(playbackParam.getNVRCode());
            }
            playbackParamSouth.speed = playbackParam.getSpeed();
            
            com.huawei.esdk.ivs.domain.model.bean.TimeSpan recordTimeSoap = playbackParam.getRecordTime();
            
            if (null != recordTimeSoap)
            {
                TimeSpanSouth timeSpan = new TimeSpanSouth();
                timeSpan.clear();
                
                timeSpan.end = BytesUtils.stringToBytesForIVS(recordTimeSoap.getEndTime());
                timeSpan.start = BytesUtils.stringToBytesForIVS(recordTimeSoap.getStartTime());
                
                playbackParamSouth.timeSpan = timeSpan;
            }
            
        }
        
        return playbackParamSouth;
    }
    
    /** 
    * 领域层的QueryUnifiedFormat转换为南向的
    *
    * @param queryUnifiedFormat 查询通用格式
    * @return QueryUnifiedFormatSouth 南向查询通用格式
    * @see [类、类#方法、类#成员]
    */
    public QueryUnifiedFormatSouth getQueryUnifiedFormatSoap2Model(QueryUnifiedFormat queryUnifiedFormat)
    {
        // modify by cWX191990，fieldNum小于0时，默认也需要初始化一个查询条件，问题单号DTS2014022507270
        QueryUnifiedFormatSouth queryUnifiedFormatSouth = null;
        
        if (queryUnifiedFormat.getQueryField().size() == 0)
        {
            queryUnifiedFormatSouth = new QueryUnifiedFormatSouth(1);
        }
        else
        {
            queryUnifiedFormatSouth = new QueryUnifiedFormatSouth(queryUnifiedFormat.getQueryField().size());
        }
        
        // 固定内存
        queryUnifiedFormatSouth.clear();
        
        // 转换
        queryUnifiedFormatSouth.fieldNum = queryUnifiedFormat.getFieldNum();
        
        queryUnifiedFormatSouth.indexRangeSouth.fromIndex = queryUnifiedFormat.getIndex().getFromIndex();
        queryUnifiedFormatSouth.indexRangeSouth.toIndex = queryUnifiedFormat.getIndex().getToIndex();
        
        queryUnifiedFormatSouth.orderConditionSouth.enableOrder =
            queryUnifiedFormat.getOrderCondition().getEnableOrder();
        queryUnifiedFormatSouth.orderConditionSouth.field = queryUnifiedFormat.getOrderCondition().getField();
        queryUnifiedFormatSouth.orderConditionSouth.isAscend = queryUnifiedFormat.getOrderCondition().getIsAscend();
        
        QueryFieldSouth[] qfSouth = null;
        
        if (queryUnifiedFormat.getQueryField().size() == 0)
        {
            qfSouth = new QueryFieldSouth[1];
        }
        else
        {
            qfSouth = new QueryFieldSouth[queryUnifiedFormat.getQueryField().size()];
            
            for (int i = 0; i < queryUnifiedFormat.getQueryField().size(); i++)
            {
                QueryFieldSouth qfs = new QueryFieldSouth();
                
                // 固定内存
                qfs.clear();
                qfs.exactQuery = queryUnifiedFormat.getQueryField().get(i).getExactQuery();
                qfs.field = queryUnifiedFormat.getQueryField().get(i).getFieldType();
                qfs.value = BytesUtils.stringToBytesForIVS(queryUnifiedFormat.getQueryField().get(i).getValue());
                qfSouth[i] = qfs;
            }
        }
        
        queryUnifiedFormatSouth.queryFieldSouth = qfSouth;
        
        return queryUnifiedFormatSouth;
    }
    
    /** 
    * 南向的OperationLogListSouth转换为领域层的对象
    * 
    * @param pOperationLogList
    * @return
    * @see [类、类#方法、类#成员]
    * since eSDK IVS V100R003C10B002
    */
    public Business getOperationLogListSoap2Modal(OperationLogListSouth pOperationLogList)
    {
        Business businessModal = new Business();
        
        businessModal.setTotal(pOperationLogList.total);
        
        IndexRange indexRange = new IndexRange();
        indexRange.setFromIndex(pOperationLogList.index.fromIndex);
        indexRange.setToIndex(pOperationLogList.index.toIndex);
        businessModal.setIndexRange(indexRange);
        
        OperationLogInfoSouth[] operationLogInfoSouth = pOperationLogList.operationLogs;
        
        List<OperationLogInfo> operationLogInfoList = new ArrayList<OperationLogInfo>();
        
        if (null != operationLogInfoSouth && operationLogInfoSouth.length > 0)
        {
            int length = operationLogInfoSouth.length > pOperationLogList.total ? pOperationLogList.total
                : operationLogInfoSouth.length;
                
            for (int i = 0; i < length; i++)
            {
                OperationLogInfo operationLogInfo = getOperationLogInfoSoap2Modal(operationLogInfoSouth[i]);
                operationLogInfoList.add(operationLogInfo);
            }
            
        }
        
        businessModal.setOperationLogInfoList(operationLogInfoList);
        
        return businessModal;
    }
    
    /** 
    * 南向的operationLogInfoSouth转换为领域层的对象
    * 
    * @param operationLogInfoSouth
    * @return
    * @see [类、类#方法、类#成员]
    * since eSDK IVS V100R003C10B002
    */
    private OperationLogInfo getOperationLogInfoSoap2Modal(OperationLogInfoSouth operationLogInfoSouth)
    {
        OperationLogInfo operationLogInfo = new OperationLogInfo();
        
        operationLogInfo.setAccount(BytesUtils.bytesToStringForIVS(operationLogInfoSouth.account));
        operationLogInfo.setClientIp(BytesUtils.bytesToStringForIVS(operationLogInfoSouth.clientIp));
        operationLogInfo.setLogGrade(operationLogInfoSouth.grade);
        operationLogInfo.setServiceCode(BytesUtils.bytesToStringForIVS(operationLogInfoSouth.serviceCode));
        operationLogInfo.setModuleType(BytesUtils.bytesToStringForIVS(operationLogInfoSouth.moduleType));
        operationLogInfo.setModuleCode(BytesUtils.bytesToStringForIVS(operationLogInfoSouth.moduleCode));
        operationLogInfo.setOperationCode(BytesUtils.bytesToStringForIVS(operationLogInfoSouth.operationCode));
        operationLogInfo
            .setOperationObjectCode(BytesUtils.bytesToStringForIVS(operationLogInfoSouth.operationObjectCode));
        operationLogInfo.setOccurTime(BytesUtils.bytesToStringForIVS(operationLogInfoSouth.occurTime));
        operationLogInfo.setErrorCode(BytesUtils.bytesToStringForIVS(operationLogInfoSouth.errorCode));
        operationLogInfo.setResult(Integer.toString(operationLogInfoSouth.result));
        operationLogInfo.setAdditionalInfo(BytesUtils.bytesToStringForIVS(operationLogInfoSouth.additionalInfo));
        operationLogInfo.setReserve(BytesUtils.bytesToStringForIVS(operationLogInfoSouth.reserve));
        
        return operationLogInfo;
    }
    
    /** 
     * 南向的SnapshotInfoListSouth转换为领域层的对象
     * 
     * @param infoListSouth
     * @return
     * @see [类、类#方法、类#成员]
     * since eSDK IVS V100R003C10B002
     */
    public SnapshotInfoList getSnapshotInfoListSoap2Modal(SnapshotInfoListSouth infoListSouth)
    {
        SnapshotInfoList infoList = new SnapshotInfoList();
        
        infoList.setTotal(infoListSouth.total);
        
        infoList.setIndexRange(new IndexRange());
        infoList.getIndexRange().setFromIndex(infoListSouth.indexRange.fromIndex);
        infoList.getIndexRange().setToIndex(infoListSouth.indexRange.toIndex);
        
        if (null != infoListSouth.snapshotInfos && infoListSouth.snapshotInfos.length > 0)
        {
            int length = infoListSouth.snapshotInfos.length > infoListSouth.total ? infoListSouth.total
                : infoListSouth.snapshotInfos.length;
            for (int i = 0; i < length; i++)
            {
                SnapshotInfo snapshotInfo = getSnapshotInfoSoap2Modal(infoListSouth.snapshotInfos[i]);
                infoList.getSnapshotInfos().add(snapshotInfo);
            }
        }
        
        return infoList;
    }
    
    /** 
     * 南向的SnapshotInfoSouth转换为领域层的对象
     * 
     * @param infoSouth
     * @return
     * @see [类、类#方法、类#成员]
     * since eSDK IVS V100R005C60
     */
    private SnapshotInfo getSnapshotInfoSoap2Modal(SnapshotInfoSouth infoSouth)
    {
        if (null == infoSouth)
        {
            return null;
        }
        
        SnapshotInfo snapshotInfo = new SnapshotInfo();
        snapshotInfo.setCameraCode(BytesUtils.bytesToStringForIVS(infoSouth.cameraCode));
        snapshotInfo.setSnapTime(BytesUtils.bytesToStringForIVS(infoSouth.snapTime));
        snapshotInfo.setSnapType(infoSouth.snapType);
        snapshotInfo.setPictureID(infoSouth.pictureID);
        snapshotInfo.setPictureName(BytesUtils.bytesToStringForIVS(infoSouth.pictureName));
        snapshotInfo.setPictureSize(infoSouth.pictureSize);
        snapshotInfo.setPreviewUrl(BytesUtils.bytesToStringForIVS(infoSouth.previewUrl));
        snapshotInfo.setPictureUrl(BytesUtils.bytesToStringForIVS(infoSouth.pictureUrl));
        snapshotInfo.setReserve(BytesUtils.bytesToStringForIVS(infoSouth.reserve));
        
        return snapshotInfo;
    }
    
    public QuerySnapshotParamSouth getQuerySnapshotParamModel2South(QuerySnapshotParam param)
    {
        if (null == param)
        {
            return null;
        }
        
        QuerySnapshotParamSouth paramSouth = new QuerySnapshotParamSouth();
        paramSouth.snapType = param.getSnapType();
        if (StringUtils.isNotEmpty(param.getReserve()))
            paramSouth.reserve = BytesUtils.stringToBytesForIVS(param.getReserve());
            
        if (null != param.getIndexRange())
        {
            paramSouth.indexRange = new IndexRangeSouth();
            paramSouth.indexRange.fromIndex = param.getIndexRange().getFromIndex();
            paramSouth.indexRange.toIndex = param.getIndexRange().getToIndex();
        }
        
        if (null != param.getTimeSpan())
        {
            paramSouth.timeSpan = new TimeSpanSouth();
            paramSouth.timeSpan.start = BytesUtils.stringToBytesForIVS(param.getTimeSpan().getStartTime());
            paramSouth.timeSpan.end = BytesUtils.stringToBytesForIVS(param.getTimeSpan().getEndTime());
        }
        
        return paramSouth;
    }
    
    public MediaURLParamSouth getMediaURLParamModel2South(MediaURLParam mediaURLParam)
    {
        MediaURLParamSouth mediaURLParamSouth = new MediaURLParamSouth();
        mediaURLParamSouth.clear();
        
        if (null != mediaURLParam)
        {
            
            mediaURLParamSouth.serviceType = mediaURLParam.getServiceType();
            mediaURLParamSouth.packProtocolType = mediaURLParam.getPackProtocolType();
            mediaURLParamSouth.clientType = mediaURLParam.getClientType();
            mediaURLParamSouth.streamType = mediaURLParam.getStreamType();
            mediaURLParamSouth.protocolType = mediaURLParam.getProtocolType();
            mediaURLParamSouth.transMode = mediaURLParam.getTransMode();
            mediaURLParamSouth.broadCastType = mediaURLParam.getBroadCastType();
            mediaURLParamSouth.videoDecType = mediaURLParam.getVideoDecType();
            mediaURLParamSouth.audioDecType = mediaURLParam.getAudioDecType();
            
            if (null != mediaURLParam.getTimeSpan())
            {
                TimeSpanSouth timeSpan = new TimeSpanSouth();
                timeSpan.clear();
                
                timeSpan.start = BytesUtils.stringToBytesForIVS(mediaURLParam.getTimeSpan().getStartTime());
                timeSpan.end = BytesUtils.stringToBytesForIVS(mediaURLParam.getTimeSpan().getEndTime());
                
                mediaURLParamSouth.timeSpan = timeSpan;
            }
            
            if (null != mediaURLParam.getFileName())
            {
                mediaURLParamSouth.fileName = BytesUtils.stringToBytesForIVS(mediaURLParam.getFileName());
            }
            
            if (null != mediaURLParam.getNvrCode())
            {
                mediaURLParamSouth.nvrCode = BytesUtils.stringToBytesForIVS(mediaURLParam.getNvrCode());
            }
            
            if (null != mediaURLParam.getReserve())
            {
                mediaURLParamSouth.reserve = BytesUtils.stringToBytesForIVS(mediaURLParam.getReserve());
            }
            
        }
        
        return mediaURLParamSouth;
    }
    
    /**
     * 删除Byte数组中第一个数值为0的节点及其后面的节点
     * @param bytes
     * @return
     */
    public byte[] trimByteArray(byte[] bytes)
    {
        byte[] result = null;
        if (null == bytes || 0 == bytes.length)
        {
            return new byte[0];
        }
        
        int i = 0;
        while (i < bytes.length && 0 != bytes[i])
        {
            i++;
        }
        
        result = new byte[i];
        System.arraycopy(bytes, 0, result, 0, i);
        
        return result;
    }

}
