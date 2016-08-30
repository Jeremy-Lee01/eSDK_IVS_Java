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
 * 摄像机参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CameraConfigSouth extends Structure
{
    public CameraConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends CameraConfigSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends CameraConfigSouth implements Structure.ByValue
    {
    }
    
    /**
     * 视频输入通道号
     */
    public int videoChannel;
    
    /**
     * 设备编码
     */
    public byte[] cameraCode = new byte[CommonConstant.DeviceModule.IVS_DEV_CODE_LEN];
    
    /**
     * 摄像机名称
     */
    public byte[] cameraName = new byte[CommonConstant.DeviceModule.IVS_CAMERA_NAME_LEN];
    
    /**
     * 摄像头位置信息
     */
    public CameraPositionSouth position;
    
    /**
     * 是否支持组播 0: 否 1:是
     */
    public int supportBroadcast;
    
    /**
     * 组播信息
     */
    public BroadcastInfoSouth broadcast;
    
    /**
     * 随路音频是否启用 0-停用 1-启用
     */
    public int enableVoice;
    
    /**
     * 摄像机绑定的音频输出通道，只能为同主设备上的音频输出通道。
     */
    public byte[] voiceOutCode = new byte[CommonConstant.DeviceModule.IVS_DEV_CODE_LEN];
    
    /**
     * 主设备编码
     */
    public byte[] parentCode = new byte[CommonConstant.DeviceModule.IVS_DEV_CODE_LEN];
    
    /**
     * 设备所属NVR编码, 表示该设备被该NVR管理
     */
    public byte[] nvrCode = new byte[CommonConstant.DeviceModule.IVS_NVR_CODE_LEN];
    
    /**
     * 摄像机类型 IVS_CAMERA_TYPE
     */
    public int cameraType;
    
    /**
     * 摄像机扩展状态：1 – 正常   2 – 视频丢失
     */
    public int cameraStatus;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("videoChannel");
        list.add("cameraCode");
        list.add("cameraName");
        list.add("position");
        list.add("supportBroadcast");
        list.add("broadcast");
        list.add("enableVoice");
        list.add("voiceOutCode");
        list.add("parentCode");
        list.add("nvrCode");
        list.add("cameraType");
        list.add("cameraStatus");
        list.add("reserve");
        return list;
    }
    
}
