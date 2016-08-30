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
package com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr;

public class CommonConstant
{
    // 通用常量定义
    public static final int IVS_TIME_LEN = 20; // 时间长度
    
    public static final int IVS_NAME_LEN = 128; // 名称长度
    
    public static final int IVS_PWD_LEN = 64; // 密码长度(网络传输使用密文)
    
    public static final int IVS_GROUP_CODE_LEN = 64; // 组编号长度
    
    public static final int IVS_DESCRIBE_LEN = 256; // 描述长度
    
    public static final int IVS_IP_LEN = 64; // IP长度
    
    public static final int IVS_URL_LEN = 256; // URL长度
    
    public static final int IVS_FILE_NAME_LEN = 256; // 文件名最大长度
    
    // 用户
    public static final int IVS_MACHINE_NAME_LEN = 128; // PC机器名长度
    
    public static final int IVS_DOMAIN_LEN = 64; // Windows域名长度
    
    public static final int IVS_PHONE_NUMBER_LEN = 64; // 电话号码最大长度
    
    public static final int IVS_MAX_OPERATION_RIGHT = 128; // 操作权限个数上线
    
    public static final int IVS_EMAILE_LEN = 128; // 用户Email长度
    
    // 设备信息
    public static final int IVS_DEV_SERIALNO_LEN = 64; // 设备序列号长度
    
    public static final int IVS_DEV_CODE_LEN = 64; // 设备编码最大长度
    
    public static final int IVS_DEVICE_GROUP_LEN = 128; // 设备组编码最大长度
    
    public static final int IVS_TAS_CODE_LEN = 32; // TAS编码长度
    
    public static final int IVS_NVR_CODE_LEN = 32; // NVR编码长度
    
    public static final int IVS_DOMAIN_CODE_LEN = 32; // 域编码最大长度
    
    public static final int IVS_DEV_MODEL_LEN = 32; // 设备型号最大长度
    
    public static final int IVS_MRU_CODE_LEN = 64; //MRU分配方式
    
    public static final int IVS_MAX_RIGHT_GROUP_NAME_LEN = 64; // 权限组最大英文名长度（多语言由客户端自己映射实现）
    
    public static final int IVS_MAX_PROTOCOLTYPE_NAME_LEN = 64; // 协议类型描述最大长度
    
    public static final int IVS_DEVICE_NAME_LEN = 128; // 主设备名称长度
    
    public static final int IVS_MAX_VENDOR_TYPE_NAME_LEN = 32; // 厂商名称最大长度
    
    public static final int IVS_QUERY_VALUE_LEN = 2048; // 查询字段大小
    
    public static final int IVS_ALARM_DESCRIPTION_LEN = 1024;
    
    public static final int IVS_MAX_TIMESPAN_NUM = 24; // 时间段最大数量
    
    public static final int IVS_MAX_PLAN_INFO_NUM = 7; // 最大计划信息个数（一周7天）
    
    public static final int IVS_MAX_USER_GROUP_LEVEL = 4; // 用户组层级最大个数
    
    public static final int IVS_MAX_USER_GROUP_DESC_LEN = 256; // 用户组备注
    
    public static final int IVS_CAMERA_NAME_LEN = 192;// 摄像机名称长度
    
    public static final int IVS_RESOLUTION_LEN = 16; // 分辨率字符串长度
    
    public static final int IVS_MAX_STREAM_NUM = 8; //视频流信息
    
    public static final int IVS_MAX_OSD_TEXT_LEN = 256; // OSD文字最大长字节数
    
    public static final int IVS_MAX_MOTION_DETECTION_AREA_NUM = 8; // 运动检测区域个数
    
    public static final int IVS_MAX_VIDEO_HIDE_GUARD_TIME_NUM = 12; // 最大视频遮挡布防时间段个数
    
    public static final int IVS_MAX_VIDEO_HIDE_AREA_NUM = 5; // 最大图像遮挡告警区域个数
    
    public static final int IVS_MAX_VIDEO_MASK_AREA_NUM = 5; // 最大隐私保护区域个数
    
    public static final int IVS_AUDIO_NAME_LEN = 128; // 音频子设备名称长度
    
    public static final int IVS_SERIAL_NAME_LEN = 128; // 串口设备名称长度
    
    public static final int IVS_ALARM_IN_NAME_LEN = 260; // 告警输入子设备名称长度
    
    public static final int IVS_ALARM_OUT_NAME_LEN = 128; // 告警输出子设备名称长度
    
    public static final int IVS_MAX_DOMAIN_ROUTE_NUM = 128; // 域路由最大记录数
    
    public static final int IVS_RESERVE_64_LEN = 64; //预留字段长度
    
    public static final int IVS_RESERVE_32_LEN = 32; //预留字段长度

    private CommonConstant()
    {
    }
}
