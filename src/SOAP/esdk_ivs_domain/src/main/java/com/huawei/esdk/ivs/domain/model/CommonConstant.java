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

/**
 * IVS常量类
 * 公共常量、告警模块常量、集群模块常量、设备模块常量、录像模块常量、用户模块常量
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public interface CommonConstant
{
    // 公共常量定义区
    
    /**
     * 保留字段
     */
    public static final int IVS_RESERVE_64_LEN = 64;
    
    public static final int IVS_RESERVE_32_LEN = 32;
    
    public static final int IVS_RESERVE_8_LEN = 8;
    
    /**
     * URL长度
     */
    public static final int IVS_URL_LEN = 256;
    
    /**
     * 时间长度
     */
    public static final int IVS_TIME_LEN = 20;
    
    /**
     * IP长度
     */
    public static final int IVS_IP_LEN = 64;
    
    /**
     * 文件名最大长度
     */
    public static final int IVS_FILE_NAME_LEN = 256;
    
    /**
     * esdk session 长度
     */
    public static final int IVS_SESSION_LEN = 512;
    
    /**
     * Windows域名长度
     */
    public static final int IVS_DOMAIN_LEN = 64;
    
    /**
     * PC机器名长度
     */
    public static final int IVS_MACHINE_NAME_LEN = 128;
    
    /**
     * IVS_QUERY_FIELD结构体value字段长度
     */
    public static final int IVS_QUERY_VALUE_LEN = 2048;
    
    public static final int IVS_VERSION_SUB_LEN = 8;
    
    public static final int IVS_BINARY = 2;
    
    /**
     * 告警模块常量
     */
    interface AlarmModule
    {
        /**
         * 告警源编码长度
         */
        public static final int IVS_ALARM_CODE_LEN = 64;
        
        /**
         * 域编码最大长度
         */
        public static final int IVS_DOMAIN_CODE_LEN = 32;
        
        /**
         * 告警源名称长度
         */
        public static final int IVS_ALARM_NAME_LEN = 260;
        
        /**
         * 告警级别名称长度
         */
        public static final int IVS_NAME_LEN = 128;
        
        /**
         * 告警级别颜色长度
         */
        public static final int IVS_ALARM_LEVEL_COLOR_LEN = 16;
        
        /**
         * 告警类型长度
         */
        public static final int IVS_ALARM_TYPE_LEN = 64;
        
        /**
         * 告警类型类别长度
         */
        public static final int IVS_ALARM_CATEGORY_LEN = 8;
        
        /**
         * 告警发生时间长度
         */
        public static final int IVS_TIME_LEN = 20;
        
        /**
         * 图片预览URL长度
         */
        public static final int IVS_URL_LEN = 256;
        
        /**
         * NVR编码长度
         */
        public static final int IVS_NVR_CODE_LEN = 32;
        
        /**
         * 告警描述信息长度
         */
        public static final int IVS_ALARM_DESCRIPTION_LEN = 1024;
        
        /**
         * 告警上报扩展参数长度
         */
        public static final int IVS_ALARM_EX_PARAM_LEN = 2048;
        
        /**
         * 查询字段大小
         */
        public static final int IVS_QUERY_VALUE_LEN = 2048;
        
        /**
         * 告警上报ID
         */
        public static final int IVS_ALARM_REPORT_ID_LEN = 32;

        /**
         * 告警类型
         */
        public static final int IVS_ALARM_TYPE_CATEGORY_LEN = 8;

        /**
         * 告警级别颜色,使用颜色字符串表示ARGB
         */
        public static final int IVS_ALARM_LEVEL_COLOR_16 = 16;
        
        /**
         * 告警级别最大个数
         */
        public static final int IVS_MAX_ALARM_LEVEL_NUM = 20;
        
        /**
         * 告警网元类型长度
         */
        public static final int IVS_NODE_TYPE_LEN = 8;
        
        /**
         * 告警定位信息长度
         */
        public static final int IVS_DEVICE_ALARM_LOCATION_INFO_LEN = 256;
        
        /**
         * 告警产生模块归属的网元ID长度
         */
        public static final int IVS_NET_ELEMENT_ID_LEN = 32;
    }
    
    /**
     * 集群模块常量
     */
    interface ClusterModule
    {
        /**
         * 设备序列号长度
         */
        public static final int IVS_DEV_SERIALNO_LEN = 64;
        
        /**
         * 设备编码最大长度
         */
        public static final int IVS_DEV_CODE_LEN = 64;
        
        /**
         * 主设备名称长度
         */
        public static final int IVS_DEVICE_NAME_LEN = 128;
        
        /**
         * 域编码最大长度
         */
        public static final int IVS_DOMAIN_CODE_LEN = 32;
        
        /**
         * 厂商名称最大长度
         */
        public static final int IVS_MAX_VENDOR_TYPE_NAME_LEN = 32;
        
        /**
         * 设备型号最大长度
         */
        public static final int IVS_DEV_MODEL_LEN = 32;
        
        /**
         * 协议类型描述最大长度
         */
        public static final int IVS_MAX_PROTOCOLTYPE_NAME_LEN = 64;
    }
    
    /**
     * 设备模块常量
     */
    interface DeviceModule
    {
        /**
         * 设备序列号长度
         */
        public static final int IVS_DEV_SERIALNO_LEN = 64;
        
        /**
         * 所属设备组编码长度
         */
        public static final int IVS_DEVICE_GROUP_LEN = 128;
        
        /**
         * 设备编码最大长度
         */
        public static final int IVS_DEV_CODE_LEN = 64;
        
        /**
         * TAS编码长度
         */
        public static final int IVS_TAS_CODE_LEN = 32;
        
        /**
         * 域编码最大长度 
         */
        public static final int IVS_DOMAIN_CODE_LEN = 32;
        
        /**
         * MRU分配方式
         */
        public static final int IVS_MRU_CODE_LEN = 64;
        
        /**
         *  协议类型描述最大长度
         */
        public static final int IVS_MAX_PROTOCOLTYPE_NAME_LEN = 64;
        
        /**
         * 主设备名称长度
         */
        public static final int IVS_DEVICE_NAME_LEN = 128;
        
        /**
         * 查询字段大小
         */
        public static final int IVS_QUERY_VALUE_LEN = 2048;
        
        /**
         * 分辨率字符串长度
         */
        public static final int IVS_RESOLUTION_LEN = 16;
        
        /**
         * 视频流信息
         */
        public static final int IVS_MAX_STREAM_NUM = 8;
        
        /**
         *  OSD文字最大长字节数
         */
        public static final int IVS_MAX_OSD_TEXT_LEN = 256;
        
        /**
         * 运动检测区域个数
         */
        public static final int IVS_MAX_MOTION_DETECTION_AREA_NUM = 8;
        
        /**
         * 最大视频遮挡布防时间段个数
         */
        public static final int IVS_MAX_VIDEO_HIDE_GUARD_TIME_NUM = 12;
        
        /**
         * 最大图像遮挡告警区域个数
         */
        public static final int IVS_MAX_VIDEO_HIDE_AREA_NUM = 5;
        
        /**
         * 最大隐私保护区域个数
         */
        public static final int IVS_MAX_VIDEO_MASK_AREA_NUM = 5;
        
        /**
         * 音频子设备名称长度
         */
        public static final int IVS_AUDIO_NAME_LEN = 128;
        
        /**
         * 串口设备名称长度
         */
        public static final int IVS_SERIAL_NAME_LEN = 128;
        
        /**
         * 告警输出子设备名称长度
         */
        public static final int IVS_ALARM_OUT_NAME_LEN = 128;
        
        /**
         * 语音通道名称长度
         */
        public static final int IVS_ALARM_IN_NAME_LEN = 260;
        
        /**
         * 摄像机名称长度
         */
        public static final int IVS_CAMERA_NAME_LEN = 192;
        
        /**
         * 主设备型号长度
         */
        public static final int IVS_DEV_MODEL_LEN = 32;
        
        /**
         * 设备提供商类型长度
         */
        public static final int IVS_MAX_VENDOR_TYPE_NAME_LEN = 32;
        
        /**
         * 摄像机安装位置描述长度
         */
        public static final int IVS_DESCRIBE_LEN = 256;
        
        /**
         * 设备所属NVR编码长度
         */
        public static final int IVS_NVR_CODE_LEN = 32;
        
        /**
         * 设备创建时间长度
         */
        public static final int IVS_TIME_LEN = 20;
        
        /**
         * 前端IP长度
         */
        public static final int IVS_IP_LEN = 64;
        
        /**
         * 域路由最大记录数
         */
        public static final int IVS_MAX_DOMAIN_ROUTE_NUM = 128;
        
        /**
         * 域路由名称长度
         */
        public static final int IVS_NAME_LEN = 128;
        
        /**
         * 主设备
         */
        public static final int DEVICE_TYPE_MAIN = 1;
        
        /**
         * 摄像头设备
         */
        public static final int DEVICE_TYPE_CAMERA = 2;
        
        /**
         * 语音设备
         */
        public static final int DEVICE_TYPE_VOICE = 3;
        
        /**
         * 告警设备（同时获取告警输入、告警输出）
         */
        public static final int DEVICE_TYPE_ALARM = 4;
        
        /**
         * 串口设备
         */
        public static final int DEVICE_TYPE_SERIAL = 5;
        
        /**
         * 系统支持一个设备组下最多5000个子设备组
         */
        public static final int IVS_DEVICE_GROUP_NUM = 5000;
    }
    
    /**
     * 录像模块常量
     */
    interface RecordModule
    {
        /**
         * 时间段最大数量
         */
        public static final int IVS_MAX_TIMESPAN_NUM = 24;
        
        /**
         * 最大计划信息个数（一周7天）
         */
        public static final int IVS_MAX_PLAN_INFO_NUM = 7;
        
        /**
         * 文件名最大长度
         */
        public static final int IVS_FILE_NAME_LEN = 256;
        
        /**
         * 标签名长度最大150字符
         */
        public static final int IVS_BOOKMARK_NAME_LEN = 612;
        
        /**
         * 录像锁定信息长度
         */
        public static final int IVS_RECORD_LOCK_DESC_LEN = 260;
        
        /**
         * 预置位名称长度
         */
        public static final int IVS_RECORD_PTZ_PRESET_NAME_LEN = 64;
    }
    
    /**
     * 用户模块常量
     */
    interface UserModule
    {
        /**
         * 名称长度
         */
        public static final int IVS_NAME_LEN = 128;
        
        /**
         * 密码长度(网络传输使用密文)
         */
        public static final int IVS_PWD_LEN = 64;
        
        /**
         * 用户首次登录需要修改密码
         */
        public static final int IVS_SMU_USER_FIRST_LOGIN = 119101308;
        
        /**
         * 用户密码已过期，需要修改
         */
        public static final int IVS_SMU_USER_PWD_NEED_MOD = 119101305;
        
        /**
         * session id 无效
         */
        public static final int IVS_SMU_USER_SESSION_INVALID = 999115312;
    }
    
    /**
     * 业务模块常量
     */
    interface BusinessModule
    {
        /**
         * 预置位名称长度
         */
        public static final int IVS_PRESET_NAME_LEN = 84;
        
        /**
         * 预置位信息列表长度
         */
        public static final int IVS_PRESET_LIST_LEN = 128;
    }
}
