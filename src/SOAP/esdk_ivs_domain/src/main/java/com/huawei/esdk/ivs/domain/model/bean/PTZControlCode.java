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

public class PTZControlCode
{
    /**
     * 云台停止转动
     */
    public static final int PTZ_STOP = 1;
    
    /**
     * 云台向上转动
     */
    public static final int PTZ_UP = 2;
    
    /**
     * 云台向下转动
     */
    public static final int PTZ_DOWN = 3;
    
    /**
     * 云台向左转动
     */
    public static final int PTZ_LEFT = 4;
    
    /**
     * 云台左上转动
     */
    public static final int PTZ_UP_LEFT = 5;
    
    /**
     * 云台左下转动
     */
    public static final int PTZ_DOWN_LEFT = 6;
    
    /**
     * 云台向右转动
     */
    public static final int PTZ_RIGHT = 7;
    
    /**
     * 云台右上转动
     */
    public static final int PTZ_UP_RIGHT = 8;
    
    /**
     * 云台右下转动
     */
    public static final int PTZ_DOWN_RIGHT = 9;
    
    /**
     * 云台自动控制
     */
    public static final int PTZ_AUTO = 10;
    
    /**
     * 云台转动到指定预置位
     */
    public static final int PTZ_PREFAB_BIT_RUN = 11;
    
    /**
     * 启动巡航轨迹
     */
    public static final int PTZ_CRUISE_RUN = 12;
    
    /**
     * 停止巡航轨迹
     */
    public static final int PTZ_CRUISE_STOP = 13;
    
    /**
     * 启动模式轨迹
     */
    public static final int PTZ_MODE_CRUISE_RUN = 14;
    
    /**
     * 停止模式轨迹
     */
    public static final int PTZ_MODE_CRUISE_STOP = 15;
    
    /**
     * 打开镜头菜单
     */
    public static final int PTZ_MENU_OPEN = 16;
    
    /**
     * 关闭镜头菜单
     */
    public static final int PTZ_MENU_EXIT = 17;
    
    /**
     * 进入镜头菜单
     */
    public static final int PTZ_MENU_ENTER = 18;
    
    /**
     * 云台翻转180度
     */
    public static final int PTZ_FLIP = 19;
    
    /**
     * 云台转至起始位
     */
    public static final int PTZ_START = 20;
    
    /**
     * 光圈放大
     */
    public static final int PTZ_LENS_APERTURE_OPEN = 21;
    
    /**
     * 光圈缩小
     */
    public static final int PTZ_LENS_APERTURE_CLOSE = 22;
    
    /**
     * 范围放大
     */
    public static final int PTZ_LENS_ZOOM_IN = 23;
    
    /**
     * 范围缩小
     */
    public static final int PTZ_LENS_ZOOM_OUT = 24;
    
    /**
     * 聚焦近
     */
    public static final int PTZ_LENS_FOCAL_NEAT = 25;
    
    /**
     * 聚焦远
     */
    public static final int PTZ_LENS_FOCAL_FAR = 26;
    
    /**
     * 打开辅助设备
     */
    public static final int PTZ_AUX_OPEN = 27;
    
    /**
     * 关闭辅助设备
     */
    public static final int PTZ_AUX_STOP = 28;
    
    /**
     * 模式设置开始
     */
    public static final int MODE_SET_START = 29;
    
    /**
     * 模式设置停止
     */
    public static final int MODE_SET_STOP = 30;
    
    /**
     * 快速定位对焦
     */
    public static final int PTZ_FAST_LOCATE = 31;
    
    /**
     * 开始水平扫描
     */
    public static final int PTZ_HORIZONTAL_SCAN = 32;
    
    /**
     * 开始垂直扫描
     */
    public static final int PTZ_VERTICAL_SCAN = 33;
    
    /**
     * 云台加锁
     */
    public static final int PTZ_LOCK = 34;
    
    /**
     * 云台解锁
     */
    public static final int PTZ_UNLOCK = 35;
    
}
