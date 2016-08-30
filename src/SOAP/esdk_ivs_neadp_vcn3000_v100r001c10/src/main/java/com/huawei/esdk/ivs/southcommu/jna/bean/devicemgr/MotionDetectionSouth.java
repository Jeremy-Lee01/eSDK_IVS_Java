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

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.sun.jna.Structure;

/**
 * 运动检测
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class MotionDetectionSouth extends Structure
{
    public MotionDetectionSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends MotionDetectionSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends MotionDetectionSouth implements Structure.ByValue
    {
    }
    
    /**
     * 设备运动检测告警使能 0-停用运动检测 1-启用运动检测
     */
    public int motionDetectionEnable;
    
    /**
     * 平台运动检测告警使能 0-停用运动检测 1-启用运动检测
     */
    public int platformMotionDetection;
    
    /**
     * 运动监测的时间间隔，在该间隔内的运动都作为同一个运动，取值范围：1~30秒 单位:秒 默认为：10秒
     */
    public int detectInterval;
    
    /**
     * 运动监测的灵敏度，共分5级：1-5，数字越高表示灵敏度越高
     */
    public int sensitivity;
    
    /**
     * 告警检测时间间隔1-255，单位：秒。默认为120秒，即每隔120秒检测一次是否在告警状态，并上报
     */
    public int autoClearAlarmTime;
    
    /**
     * 有效区域信息的个数
     */
    public int rectNum;
    
    /**
     * 运动检测区域列表
     */
    public RectFloatSouth[] rectDetection =
        new RectFloatSouth[CommonConstant.DeviceModule.IVS_MAX_MOTION_DETECTION_AREA_NUM];
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("motionDetectionEnable");
        list.add("platformMotionDetection");
        list.add("detectInterval");
        list.add("sensitivity");
        list.add("autoClearAlarmTime");
        list.add("rectNum");
        list.add("rectDetection");
        list.add("reserve");
        return list;
    }
    
}
