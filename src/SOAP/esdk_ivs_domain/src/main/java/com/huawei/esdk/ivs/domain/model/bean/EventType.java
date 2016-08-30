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
package com.huawei.esdk.ivs.domain.model.bean;

public class EventType
{
    /**
     * 重新登录成功事件上报
     */
    public static final int IVS_EVENT_AUTO_CONNECT_SUCCEED = 10001;
    
    /**
     * 保活失败事件上报
     */
    public static final int IVS_EVENT_KEEP_ALIVE_FAILED = 10002;
    
    /**
     * 实时浏览异常事件上报
     */
    public static final int IVS_EVENT_REALPLAY_FAILED = 10003;
    
    /**
     * 录像异常事件上报
     */
    public static final int IVS_EVENT_RECORD_FAILED = 10004;
    
    /**
     * 录像下载异常事件上报
     */
    public static final int IVS_EVENT_DOWNLOAD_FAILED = 10005;
    
    /**
     * 远程录像回放异常事件上报
     */
    public static final int IVS_EVENT_REMOTE_PLAYBACK_FAILED = 10006;
    
    /**
     * 本地录像回放异常事件上报
     */
    public static final int IVS_EVENT_LOCAL_PLAYBACK_FAILED = 10007;
    
    /**
     * 语音广播异常事件上报
     */
    public static final int IVS_EVENT_BROADCAST_FAILED = 10009;
    
    /**
     * 告警上报
     */
    public static final int IVS_EVENT_REPORT_ALARM = 10013;
    
    /**
     * 本地文件广播结束事件上报
     */
    public static final int IVS_EVENT_FILE_BROADCAST_END = 10014;
    
    /**
     * 告警状态上报
     */
    public static final int IVS_EVENT_REPORT_ALARM_STATUS = 10017;
    
    /**
     * 用户下线通知
     */
    public static final int IVS_EVENT_USER_OFFLINE = 10019;
    
    /**
     * 恢复实况浏览
     */
    public static final int IVS_EVENT_RESUME_REALPLAY_OK = 10021;
    
    /**
     * 本地录像成功事件
     */
    public static final int IVS_EVENT_LOCAL_RECORD_SUCCESS = 10022;
    
    /**
     * 本地录像通用事件
     */
    public static final int IVS_EVENT_LOCAL_RECORD_EGENERIC = 10023;
    
    /**
     * 告警联动动作执行通知
     */
    public static final int IVS_EVENT_DO_LINKAGE_ACTION = 10024;
    
    /**
     * 前端设备发现事件
     */
    public static final int IVS_EVENT_FIND_DEVICE = 10025;
    
    /**
     * OMU将设备类告警发给CU的接口消息
     */
    public static final int IVS_EVENT_OMU_REPORT_ALARM = 10026;
    
    /**
     * 发现水印篡改提示（只有篡改开始时间）
     */
    public static final int IVS_EVENT_REPORT_WATERMARK_TIP = 10027;
    
    /**
     * 水印告警记录产生通知（有篡改开始时间和停止时间）
     */
    public static final int IVS_EVENT_REPORT_WATERMARK_ALARM = 10028;
    
    /**
     * 云镜锁定上报（云镜操作结果返回时告知客户端）
     */
    public static final int IVS_EVENT_PTZ_LOCK = 10029;
    
    /**
     * 手动录像状态通知
     */
    public static final int IVS_EVENT_MANUAL_RECORD_STATE = 10031;
    
    /**
     * 告警联动动作停止通知
     */
    public static final int IVS_EVENT_STOP_LINKAGE_ACTION = 10032;
    
    /**
     * 录像下载完成事件上报
     */
    public static final int IVS_EVENT_DOWNLOAD_SUCCESS = 10033;
    
    /**
     * 客户端缓存通知
     */
    public static final int IVS_EVENT_PLAYER_BUFFER = 10035;
    
    /**
     * 智能分析学习进度上报
     */
    public static final int IVS_EVENT_IA_BA_LEARNING_SCHEDULE_REPORT = 10100;
    
    /**
     * 智能分析人脸批量注册进度上报
     */
    public static final int IVS_EVENT_IA_FR_SCHEDULE_REPORT = 10101;
    
    /**
     * 智能分析轨迹推送
     */
    public static final int IVS_EVENT_IA_PUSH_ALARM_LOCUS = 10102;
    
    /**
     * 智能分析绘图结束
     */
    public static final int IVS_EVENT_IA_DRAW_OVER = 10103;
    
    /**
     * 模式轨迹录制结束通知
     */
    public static final int IVS_EVENT_MODE_CRUISE_RECORD_OVER = 10203;
    
    /**
     * 客户端登录失败（例如，重连时密码改变）
     */
    public static final int IVS_EVENT_LOGIN_FAILED = 10301;
    
}
