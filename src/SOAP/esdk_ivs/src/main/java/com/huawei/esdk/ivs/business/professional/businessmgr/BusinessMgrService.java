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
package com.huawei.esdk.ivs.business.professional.businessmgr;

import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.Business;
import com.huawei.esdk.ivs.domain.model.bean.MediaURLParam;
import com.huawei.esdk.ivs.domain.model.bean.PTZControlInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfo;
import com.huawei.esdk.ivs.domain.model.bean.PTZPresetInfoList;
import com.huawei.esdk.ivs.domain.model.bean.QuerySnapshotParam;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RealPlay;
import com.huawei.esdk.ivs.domain.model.bean.SnapshotInfoList;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 业务管理业务层
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class BusinessMgrService
{
    /** 
     * 增加指定摄像机预置位
     *
     * @param cameraCode 摄像机编码
     * @param presetName 预置位名称
     * @return SDKResult<Integer> 封装领域层的SDKResult<Integer>对象
     * @throws SDKException SDK异常
     * @since  eSDK IVS V100R003C00
     */
    public SDKResult<Integer> addPTZPreset(String cameraCode, String presetName)
        throws SDKException
    {
        return new Business().addPTZPreset(cameraCode, presetName);
    }
    
    /** 
     * 删除指定摄像机预置位
     *
     * @param cameraCode 摄像机编码
     * @param presetIndex 预置位编码
     * @return SDKErrorCode 封装领域层的SDKErrorCode对象
     * @throws SDKException SDK异常
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode deletePTZPreset(String cameraCode, int presetIndex)
        throws SDKException
    {
        return new Business().deletePTZPreset(cameraCode, presetIndex);
    }
    
    /** 
     * 修改指定摄像机预置位
     *
     * @param cameraCode 摄像机编码
     * @param ptzPresetInfo 预置位信息
     * @return SDKErrorCode 封装领域层的SDKErrorCode对象
     * @throws SDKException SDK异常
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode modifyPTZPreset(String cameraCode, PTZPresetInfo ptzPresetInfo)
        throws SDKException
    {
        return new Business().modifyPTZPreset(cameraCode, ptzPresetInfo);
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
        SDKResult<Integer> result = null;
        if (null == cameraCode || null == controlPara1 || null == controlPara2)
        {
            result = new SDKResult<Integer>();
            result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        result = new Business().ptzControl(cameraCode, controlCode, controlPara1, controlPara2);
        return result;
    }
    
    /** 
     * 查询摄像机预置位列表
     *
     * @param cameraCode 摄像机编码
     * @return SDKResult<PTZPresetInfoList> 封装的摄像机预置位列表对象
     * @throws SDKException SDK异常
     * @since  eSDK IVS V100R003C00
     */
    public SDKResult<PTZPresetInfoList> getPTZPresetList(String cameraCode)
        throws SDKException
    {
        return new Business().getPTZPresetList(cameraCode);
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
        SDKResult<PTZControlInfo> result = null;
        if (null == cameraCode || null == controlPara1 || null == controlPara2)
        {
            result = new SDKResult<PTZControlInfo>();
            result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        result = new Business().ptzControlWithLockerInfo(cameraCode, controlCode, controlPara1, controlPara2);
        return result;
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
        return new Business().stopPlatformPlayBackByIP(handle);
    }
    
    public SDKResult<RealPlay> startRealPlayByIPEx(String cameraCode, RealPlay realPlay)
        throws SDKException
    {
        return new Business().startRealPlayByIPEx(cameraCode, realPlay);
    }
    
    public SDKErrorCode stopRealPlayByIPEx(long handle)
        throws SDKException
    {
        return new Business().stopRealPlayByIPEx(handle);
    }
    
    /** 
     * 开始平台录像播放
     * 此接口用于开始平台录像播放，可设置播放参数，并将媒体流发送到指定的目标IP地址和端口
     * @param business 平台录像播放参数
     * @return  SDKResult<Business> 详细的平台录像播放参数
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public SDKResult<Business> startPlatformPlayBackByIP(Business business)
        throws SDKException
    {
        return business.startPlatformPlayBackByIP();
    }
    
    /** 
     * 开始平台录像
     * 
     * @param cameraCode 摄像机编码
     * @param recordTime 录像时间
     * @return  SDKErrorCode 错误码
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode startPlatformRecord(String cameraCode, int recordTime)
        throws SDKException
    {
        return new Business().startPlatformRecord(cameraCode, recordTime);
    }
    
    /** 
     * 停止平台录像
     * 
     * @param cameraCode 摄像机编码
     * @return  SDKErrorCode 错误码
     * @throws SDKException SDK异常
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public SDKErrorCode stopPlatformRecord(String cameraCode)
        throws SDKException
    {
        return new Business().stopPlatformRecord(cameraCode);
    }
    
    /** 
    * 查询操作日志
    * 
    * @param queryUnifiedFormat 日志查询条件
    * @return SDKResult<Business>
    * @throws SDKException 错误码
    * @see [类、类#方法、类#成员]
    * since eSDK IVS V100R003C10B002
    */
    public SDKResult<Business> getOperationLog(QueryUnifiedFormat queryUnifiedFormat)
        throws SDKException
    {
        return new Business().getOperationLog(queryUnifiedFormat);
    }
    
    public SDKErrorCode platformPlayBackPauseByIP(long playHandle)
        throws SDKException
    {
        return new Business().platformPlayBackPauseByIP(playHandle);
    }
    
    public SDKErrorCode platformPlayBackResumeByIP(long playHandle)
        throws SDKException
    {
        return new Business().platformPlayBackResumeByIP(playHandle);
    }
    
    /** 
     * 设置平台录像码流回放时间
     * 
     * @param playHandle 播放句柄
     * @param time 回放时间
     * @return  SDKErrorCode 错误码
     * @throws SDKException SDK异常
     * @see 
     * @since  eSDK IVS V100R003C30SPC100
     */
    public SDKErrorCode setPlayBackTimeByIP(long playHandle, int time)
        throws SDKException
    {
        return new Business().setPlayBackTimeByIP(playHandle, time);
    }
    
    /** 
     * 设置平台录像码流回放速度
     * 
     * @param playHandle 播放句柄
     * @param speed 播放速度
     * @return  SDKErrorCode 错误码
     * @throws SDKException SDK异常
     * @see 
     * @since  eSDK IVS V100R003C30SPC100
     */
    public SDKErrorCode setPlayBackSpeedByIP(long playHandle, float speed)
        throws SDKException
    {
        return new Business().setPlayBackSpeedByIP(playHandle, speed);
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
        return new Business().getSnapshotList(cameraCode, param);
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
        return new Business().platformSnapshot(cameraCode);
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
        return new Business().deleteSnapshot(cameraCode, pictureID);
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
        return new Business().getRtspURL(cameraCode, mediaURLParam);
    }
}
