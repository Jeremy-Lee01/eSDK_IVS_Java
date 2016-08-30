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

import java.util.List;

import com.huawei.esdk.ivs.device.vcn3000.businessmanager.IBusinessMgrCability;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.MediaAddress;
import com.huawei.esdk.ivs.domain.model.bean.MediaURLParam;
import com.huawei.esdk.ivs.domain.model.bean.OperationLogInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZControlInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfoList;
import com.huawei.esdk.ivs.domain.model.bean.PlaybackParam;
import com.huawei.esdk.ivs.domain.model.bean.QuerySnapshotParam;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RealPlay;
import com.huawei.esdk.ivs.domain.model.bean.SnapshotInfoList;
import com.huawei.esdk.ivs.domain.util.DeviceServiceProxy;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public class Business
{
    private String cameraCode;
    
    private MediaAddress mediaAddrSrc;
    
    private PlaybackParam playbackParam;
    
    private Long handle;
    
    //返回的用户数量个数
    private int total;
    
    //分页信息
    private IndexRange indexRange;
    
    //操作日志列表
    private List<OperationLogInfo> operationLogInfoList;
    
    /** 
     * 修改指定摄像机预置位
     * 
     * @param cameraCode 摄像机编码
     * @param ptzPresetInfo 预置信息
     * @return SDKErrorCode 领域层封装的返回码对象
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    public SDKErrorCode modifyPTZPreset(String cameraCode, PTZPresetInfo ptzPresetInfo)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .modifyPTZPreset(cameraCode, ptzPresetInfo);
    }
    
    /** 
     * 查询摄像机预置位列表
     * 
     * @param cameraCode 摄像机编码
     * @return SDKResult<PTZPresetInfoList> 封装的摄像机预置位列表对象
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    public SDKResult<PTZPresetInfoList> getPTZPresetList(String cameraCode)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .getPTZPresetList(cameraCode);
    }
    
    /** 
     * 增加指定摄像机预置位
     * 
     * @param cameraCode 摄像机编码
     * @param presetName 预置位名称
     * @return SDKResult<Integer> 领域层封装的返回码对象
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    public SDKResult<Integer> addPTZPreset(String cameraCode, String presetName)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .addPTZPreset(cameraCode, presetName);
    }
    
    /** 
     * 删除指定摄像机预置位
     * 
     * @param cameraCode 摄像机编码
     * @param presetIndex 预置位编号
     * @return SDKErrorCode 领域层封装的返回码对象
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    public SDKErrorCode deletePTZPreset(String cameraCode, int presetIndex)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .deletePTZPreset(cameraCode, presetIndex);
    }
    
    public SDKResult<RealPlay> startRealPlayByIPEx(String cameraCode, RealPlay realPlay)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .startRealPlayByIPEx(cameraCode, realPlay);
    }
    
    public SDKErrorCode stopRealPlayByIPEx(long handle)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .stopRealPlayByIPEx(handle);
    }
    
    /** 
     * 云镜控制命令
     * 此接口用于操作摄像机云台和设置摄像机镜头
     * @param cameraCode 摄像机编码
     * @param controlCode 云镜控制码
     * @param controlPara1 云镜控制参数1
     * @param controlPara2 云镜控制参数2
     * @return  SDKResult<Integer> 云台是否锁定
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public SDKResult<Integer> ptzControl(String cameraCode, int controlCode, String controlPara1, String controlPara2)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance().getDeviceServiceProxy(IBusinessMgrCability.class).ptzControl(cameraCode,
            controlCode,
            controlPara1,
            controlPara2);
    }
    
    /** 
     * 云镜控制命令
     * 此接口用于操作摄像机云台和设置摄像机镜头
     * @param cameraCode 摄像机编码
     * @param controlCode 云镜控制码
     * @param controlPara1 云镜控制参数1
     * @param controlPara2 云镜控制参数2
     * @return  SDKResult<PTZControlInfo> 详细的锁定用户信息
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public SDKResult<PTZControlInfo> ptzControlWithLockerInfo(String cameraCode, int controlCode, String controlPara1,
        String controlPara2)
            throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .ptzControlWithLockerInfo(cameraCode, controlCode, controlPara1, controlPara2);
    }
    
    /** 
     * 停止平台录像播放
     *
     * @param handle 播放句柄
     * @return SDKErrorCode 封装领域层的SDKErrorCode对象
     * @throws SDKException SDK异常
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode stopPlatformPlayBackByIP(long handle)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .stopPlatformPlayBackByIP(handle);
    }
    
    /** 
     * 开始平台录像播放
     * 
     * @param cameraCode 摄像机编码
     * @param mediaAddrSrc 预置位编号
     * @param playbackParam 预置位编号
     * @return SDKResult<Business> 领域层封装的返回码对象
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    public SDKResult<Business> startPlatformPlayBackByIP()
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .startPlatformPlayBackByIP(cameraCode, mediaAddrSrc, playbackParam);
    }
    
    /** 
     * 开始平台录像
     * 
     * @param cameraCode 摄像机编码
     * @param recordTime 录像时间
     * @return SDKErrorCode 领域层封装的返回码对象
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    public SDKErrorCode startPlatformRecord(String cameraCode, int recordTime)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .startPlatformRecord(cameraCode, recordTime);
    }
    
    /** 
     * 停止平台录像
     * 
     * @param cameraCode 摄像机编码
     * @return SDKErrorCode 领域层封装的返回码对象
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    public SDKErrorCode stopPlatformRecord(String cameraCode)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .stopPlatformRecord(cameraCode);
    }
    
    /** 
    * 查询操作日志
    * @param queryUnifiedFormat 日志查询条件
    *
    * @return SDKResult<Business>
    * @throws SDKException SDK异常
    * @see [类、类#方法、类#成员]
    */
    public SDKResult<Business> getOperationLog(QueryUnifiedFormat queryUnifiedFormat)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .getOperationLog(queryUnifiedFormat);
    }
    
    public SDKErrorCode platformPlayBackPauseByIP(long playHandle)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .platformPlayBackPauseByIP(playHandle);
    }
    
    public SDKErrorCode platformPlayBackResumeByIP(long playHandle)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .platformPlayBackResumeByIP(playHandle);
    }
    
    /** 
     * 设置平台录像码流回放时间
     * 
     * @param playHandle 播放句柄
     * @param time 回放时间
     * @return SDKErrorCode 领域层封装的返回码对象
     * @see 
     * @since  eSDK IVS V100R003C30SPC100
     */
    public SDKErrorCode setPlayBackTimeByIP(long playHandle, int time)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .setPlayBackTimeByIP(playHandle, time);
    }
    
    /** 
     * 设置平台录像码流回放速度
     * 
     * @param playHandle 播放句柄
     * @param speed 播放速度
     * @return SDKErrorCode 领域层封装的返回码对象
     * @throws SDKException SDK异常
     * @see 
     * @since  eSDK IVS V100R003C30SPC100
     */
    public SDKErrorCode setPlayBackSpeedByIP(long playHandle, float speed)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .setPlayBackSpeedByIP(playHandle, speed);
    }
    
    /**
     * 获取平台抓拍图片列表
     * 
     * @param cameraCode 摄像机编码
     * @param param 获取平台抓拍图片列表参数
     * @return 响应码 与 图片信息结果集
     * @author likun/l00295065
     * @since eSDK IVS V100R005C60
     */
    public SDKResult<SnapshotInfoList> getSnapshotList(String cameraCode, QuerySnapshotParam param)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .getSnapshotList(cameraCode, param);
    }
    
    /**
     * 平台抓拍
     * 
     * @param cameraCode 摄像机编码
     * @return 响应码
     * @author likun/l00295065
     * @since eSDK IVS V100R005C60
     */
    public SDKErrorCode platformSnapshot(String cameraCode)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .platformSnapshot(cameraCode);
    }
    
    /**
     * 删除平台抓拍图片
     * 
     * @param cameraCode 摄像机编码
     * @param pictureID 抓拍图片ID
     * @return 响应码
     * @author likun/l00295065
     * @since eSDK IVS V100R005C60
     */
    public SDKErrorCode deleteSnapshot(String cameraCode, int pictureID)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .deleteSnapshot(cameraCode, pictureID);
    }
    
    /**
     * 获取RtspURL
     * 
     * @param cameraCode 摄像机编码
     * @param mediaURLParam 媒体URL参数
     * @return 响应码和RTSP URL
     * @author likun/l00295065
     * @since eSDK IVS V100R005C70
     */
    public SDKResult<String> getRtspURL(String cameraCode, MediaURLParam  mediaURLParam)
        throws SDKException
    {
        return DeviceServiceProxy.getInstance()
            .getDeviceServiceProxy(IBusinessMgrCability.class)
            .getRtspURL(cameraCode, mediaURLParam);
    }
    
    public String getCameraCode()
    {
        return cameraCode;
    }
    
    public void setCameraCode(String cameraCode)
    {
        this.cameraCode = cameraCode;
    }
    
    public MediaAddress getMediaAddrSrc()
    {
        return mediaAddrSrc;
    }
    
    public void setMediaAddrSrc(MediaAddress mediaAddrSrc)
    {
        this.mediaAddrSrc = mediaAddrSrc;
    }
    
    public PlaybackParam getPlaybackParam()
    {
        return playbackParam;
    }
    
    public void setPlaybackParam(PlaybackParam playbackParam)
    {
        this.playbackParam = playbackParam;
    }
    
    public Long getHandle()
    {
        return handle;
    }
    
    public void setHandle(Long handle)
    {
        this.handle = handle;
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void setTotal(int total)
    {
        this.total = total;
    }
    
    public IndexRange getIndexRange()
    {
        return indexRange;
    }
    
    public void setIndexRange(IndexRange indexRange)
    {
        this.indexRange = indexRange;
    }
    
    public void setOperationLogInfoList(List<OperationLogInfo> operationLogInfoList)
    {
        this.operationLogInfoList = operationLogInfoList;
    }
    
    public List<OperationLogInfo> getOperationLogInfoList()
    {
        return operationLogInfoList;
    }
}
