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
import com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr.TimeSpanSouth;
import com.sun.jna.Structure;

/**
 * 图像遮挡
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class VideoHideAlarmSouth extends Structure
{
    public VideoHideAlarmSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends VideoHideAlarmSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends VideoHideAlarmSouth implements Structure.ByValue
    {
    }
    
    /**
     * 0-关闭视频遮挡告警，1-启用视频遮挡告警
     */
    public int enableVideoHide;
    
    /**
     * 图像遮挡监测的灵敏度，共分5级：1-5，数字越高表示灵敏度越高
     */
    public int sensitivity;
    
    /**
     * 告警检测时间间隔1-255，单位：秒。默认为120秒，即每隔120秒检测一次是否在告警状态，并上报
     */
    public int autoClearAlarmTime;
    
    /**
     * 实际告警时间个数
     */
    public int guardTimeNum;
    
    /**
     * 视频遮挡布防时间段
     */
    public TimeSpanSouth[] guardTime = new TimeSpanSouth[CommonConstant.DeviceModule.IVS_MAX_VIDEO_HIDE_GUARD_TIME_NUM];
    
    /**
     * 实际设置的图像遮挡告警区域个数
     */
    public int areaNum;
    
    /**
     * 图像遮挡告警区域数组
     */
    public RectFloatSouth[] rectArea = new RectFloatSouth[CommonConstant.DeviceModule.IVS_MAX_VIDEO_HIDE_AREA_NUM];
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("enableVideoHide");
        list.add("sensitivity");
        list.add("autoClearAlarmTime");
        list.add("guardTimeNum");
        list.add("guardTime");
        list.add("areaNum");
        list.add("rectArea");
        list.add("reserve");
        return list;
    }
    
}
