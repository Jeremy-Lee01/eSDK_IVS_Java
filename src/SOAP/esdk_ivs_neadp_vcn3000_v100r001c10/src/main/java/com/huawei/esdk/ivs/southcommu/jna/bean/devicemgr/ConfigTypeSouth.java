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
package com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr;

public enum ConfigTypeSouth
{
    /**
     * 主设备基本参数 IVS_DEVICE_CFG
     */
    CONFIG_DEVICE_CFG,
    /**
     * 主设备网络参数 IVS_DEVICE_NET_CFG
     */
    CONFIG_DEVICE_NET_CFG,
    /**
     * 主设备时间参数（NTP、时区）IVS_DEVICE_TIME_CFG
     */
    CONFIG_DEVICE_TIME_CFG,
    /**
     * 摄像机基本参数设置 IVS_CAMERA_CFG
     */
    CONFIG_CAMERA_CFG,
    /**
     * 摄像机码流参数设置 IVS_CAMERA_STREAM_CFG
     */
    CONFIG_CAMERA_STREAM_CFG,
    /**
     * 摄像机基本显示参数设置 IVS_CAMERA_DISPLAY_CFG
     */
    CONFIG_CAMERA_DISPLAY_CFG,
    /**
     * 摄像机图像参数设置 IVS_CAMERA_IMAGING_CFG
     */
    CONFIG_CAMERA_IMAGING_CFG,
    /**
     * 摄像机OSD参数设置 IVS_CAMERA_OSD_CFG
     */
    CONFIG_CAMERA_OSD_CFG,
    /**
     * 摄像机运动检测参数设置 IVS_MOTION_DETECTION
     */
    CONFIG_CAMERA_MOTION_DETECTION_CFG,
    /**
     * 摄像机遮挡告警参数设置 IVS_VIDEO_HIDE_ALARM
     */
    CONFIG_CAMERA_VIDEO_HIDE_ALARM_CFG,
    /**
     * 摄像机隐私保护参数设置 IVS_VIDEO_MASK
     */
    CONFIG_CAMERA_VIDEO_MASK_CFG,
    /**
     * 摄像机音频参数设置 IVS_AUDIO_CFG
     */
    CONFIG_CAMERA_AUDIO_CFG,

    /**
     * 摄像机串口参数设置 IVS_SERIAL_CHANNEL_CFG
     */
    CONFIG_SERIAL_CHANNEL_CFG,
    /**
     * 告警输入子设备设置 IVS_ALARM_IN_CFG
     */
    CONFIG_ALARM_IN_CFG,
    /**
     * 告警输出子设备设置 IVS_ALARM_OUT_CFG
     */
    CONFIG_ALARM_OUT_CFG,
    /**
     * 云台参数设置 IVS_PTZ_CFG
     */
    CONFIG_DEVICE_PTZ_CFG,
    /**
     * 摄像机扩展参数设置 IVS_CAMERA_EXTEND_CFG
     */
    CONFIG_CAMERA_EXTEND_CFG,
    /**
     * 摄像机抓拍参数设置 IVS_CAMERA_SNAPSHOT_CFG
     */
    CONFIG_CAMERA_SNAPSHOT_CFG,
    /**
     * 摄像机前端录像码流设置 IVS_CAMERA_RECORD_STREAM_CFG
     */
    CONFIG_CAMERA_RECORD_STREAM_CFG
}
