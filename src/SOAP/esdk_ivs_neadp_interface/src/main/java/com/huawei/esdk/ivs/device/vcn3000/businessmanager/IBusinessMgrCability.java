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
package com.huawei.esdk.ivs.device.vcn3000.businessmanager;

import com.huawei.esdk.ivs.domain.model.Business;
import com.huawei.esdk.ivs.domain.model.bean.MediaAddress;
import com.huawei.esdk.ivs.domain.model.bean.MediaURLParam;
import com.huawei.esdk.ivs.domain.model.bean.PTZControlInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfo;
import com.huawei.esdk.ivs.domain.model.bean.PlaybackParam;
import com.huawei.esdk.ivs.domain.model.bean.QuerySnapshotParam;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RealPlay;
import com.huawei.esdk.ivs.domain.model.bean.SnapshotInfoList;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfoList;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * 业务管理接口
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK IVS V100R003C00]
 */
public interface IBusinessMgrCability
{
    /** 
     * 增加指定摄像机预置位
     * 
     * @param cameraCode 摄像机编码
     * @param presetName 预置位名称
     * @return SDKResult<Integer> 领域层封装的返回码对象
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    SDKResult<Integer> addPTZPreset(String cameraCode, String presetName);
    
    /** 
     * 删除指定摄像机预置位
     * 
     * @param cameraCode 摄像机编码
     * @param presetIndex 预置位编号
     * @return SDKErrorCode 领域层封装的返回码对象
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    SDKErrorCode deletePTZPreset(String cameraCode, int presetIndex);
    
    /** 
     * 修改指定摄像机预置位
     * 
     * @param cameraCode 摄像机编码
     * @param ptzPresetInfo 预置信息
     * @return SDKErrorCode 领域层封装的返回码对象
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    public SDKErrorCode modifyPTZPreset(String cameraCode, PTZPresetInfo ptzPresetInfo);
    
    SDKResult<RealPlay> startRealPlayByIPEx(String cameraCode, RealPlay realPlay);
    
    SDKErrorCode stopRealPlayByIPEx(long handle);
    
    /** 
    * 云镜控制命令
    * 此接口用于操作摄像机云台和设置摄像机镜头
    * @param cameraCode 摄像机编码
    * @param controlCode 云镜控制码
    * @param controlPara1 云镜控制参数1
    * @param controlPara2 云镜控制参数2
    * @return  SDKResult<Integer> 云台是否锁定
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<Integer> ptzControl(String cameraCode, int controlCode, String controlPara1, String controlPara2);
    
    /** 
     * 查询摄像机预置位列表
     * 
     * @param cameraCode 摄像机编码
     * @return SDKResult<PTZPresetInfoList> 封装的摄像机预置位列表对象
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    public SDKResult<PTZPresetInfoList> getPTZPresetList(String cameraCode);
    
    /** 
     * 云镜控制命令
     * 此接口用于操作摄像机云台和设置摄像机镜头
     * @param cameraCode 摄像机编码
     * @param controlCode 云镜控制码
     * @param controlPara1 云镜控制参数1
     * @param controlPara2 云镜控制参数2
     * @return  SDKResult<PTZControlInfo> 详细的锁定用户信息
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    SDKResult<PTZControlInfo> ptzControlWithLockerInfo(String cameraCode, int controlCode, String controlPara1,
        String controlPara2);
        
    /** 
     * 停止平台录像播放
     *
     * @param handle 播放句柄
     * @return SDKErrorCode 封装领域层的SDKErrorCode对象
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode stopPlatformPlayBackByIP(long handle);
    
    /** 
     * 开始平台录像播放
     * 
     * @param cameraCode 摄像机编码
     * @return SDKResult<Business> 封装的摄像机预置位列表对象
     * @see [类、类#方法、类#成员]
     * @since  [eSDK IVS V100R003C00]
     */
    SDKResult<Business> startPlatformPlayBackByIP(String cameraCode, MediaAddress mediaAddrSrc,
        PlaybackParam playbackParam);
        
    /** 
     * 开始平台录像
     *
     * @param cameraCode 摄像机编码
     * @param recordTime 录像时间
     * @return SDKErrorCode 封装领域层的SDKErrorCode对象
     * @since  eSDK IVS V100R003C00
     */
    SDKErrorCode startPlatformRecord(String cameraCode, int recordTime);
    
    /** 
     * 停止平台录像
     *
     * @param cameraCode 摄像机编码
     * @return SDKErrorCode 封装领域层的SDKErrorCode对象
     * @since  eSDK IVS V100R003C00
     */
    SDKErrorCode stopPlatformRecord(String cameraCode);
    
    /** 
    * 查询操作日志
    * 
    * @param unifiedQuery 日志查询条件
    * @return
    * @see [类、类#方法、类#成员]
    * since eSDK IVS V100R003C10B002
    */
    SDKResult<Business> getOperationLog(QueryUnifiedFormat unifiedQuery);
    
    SDKErrorCode platformPlayBackPauseByIP(long playHandle);
    
    SDKErrorCode platformPlayBackResumeByIP(long playHandle);
    
    /** 
     * 设置平台录像码流回放时间
     * 
     * @param playHandle 播放句柄
     * @param time 回放时间
     * @return SDKErrorCode 领域层封装的返回码对象
     * @see 
     * @since  eSDK IVS V100R003C30SPC100
     */
    SDKErrorCode setPlayBackTimeByIP(long playHandle, int time);
    
    /** 
     * 设置平台录像码流回放速度
     * 
     * @param playHandle 播放句柄
     * @param speed 播放速度
     * @return SDKErrorCode 领域层封装的返回码对象
     * @see 
     * @since  eSDK IVS V100R003C30SPC100
     */
    SDKErrorCode setPlayBackSpeedByIP(long playHandle, float speed);
    
    /**
     * 获取平台抓拍图片列表
     * 
     * @param cameraCode 摄像机编码
     * @param param 获取平台抓拍图片列表参数
     * @return 响应码 与 图片信息结果集
     * @author likun/l00295065
     * @since eSDK IVS V100R005C60
     */
    SDKResult<SnapshotInfoList> getSnapshotList(String cameraCode, QuerySnapshotParam param);
    
    /**
     * 平台抓拍
     * 
     * @param cameraCode 摄像机编码
     * @return 响应码
     * @author likun/l00295065
     * @since eSDK IVS V100R005C60
     */
    SDKErrorCode platformSnapshot(String cameraCode);
    
    /**
     * 删除平台抓拍图片
     * 
     * @param cameraCode 摄像机编码
     * @param pictureID 抓拍图片ID
     * @return 响应码
     * @author likun/l00295065
     * @since eSDK IVS V100R005C60
     */
    SDKErrorCode deleteSnapshot(String cameraCode, int pictureID);
    
    /**
     * 获取RtspURL
     * 
     * @param cameraCode 摄像机编码
     * @param mediaURLParam 媒体URL参数
     * @return 响应码和RTSP URL
     * @author likun/l00295065
     * @since eSDK IVS V100R005C70
     */
    SDKResult<String> getRtspURL(String cameraCode, MediaURLParam mediaURLParam);
}
