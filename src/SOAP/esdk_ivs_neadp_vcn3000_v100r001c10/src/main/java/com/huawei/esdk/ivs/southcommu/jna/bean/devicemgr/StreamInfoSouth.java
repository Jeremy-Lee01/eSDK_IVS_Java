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
 * 视频流信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class StreamInfoSouth extends Structure
{
    public StreamInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends StreamInfoSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends StreamInfoSouth implements Structure.ByValue
    {
    }
    
    /**
     * 码流类型
     */
    public int streamType;
    
    /**
     * 编码格式
     */
    public int encodeType;
    
    /**
     * 根据uiEncodeType确定，如果是H.264：参考IVS_H264_PROFILE；如果是MJPEG：参考IVS_MJPEG_PROFILE
     */
    public int profile;
    
    /**
     * I帧间隔
     */
    public int frameInterval;
    
    /**
     * 分辨率，如“177*144”
     */
    public byte[] resolution = new byte[CommonConstant.DeviceModule.IVS_RESOLUTION_LEN];
    
    /**
     * 图像质量 （0-高 1-中 2-低）
     */
    public int picQuality;
    
    /**
     * 传输协议
     */
    public int transProtocol;
    
    /**
     * 打包协议
     */
    public int pktProtocol;
    
    /**
     * 码率类型
     */
    public int bitRateType;
    
    /**
     * 码率，单位(kbps)
     */
    public int bitRate;
    
    /**
     * 帧率，单位(fps)，范围1-60
     */
    public int frameRate;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("streamType");
        list.add("encodeType");
        list.add("profile");
        list.add("frameInterval");
        list.add("resolution");
        list.add("picQuality");
        list.add("transProtocol");
        list.add("pktProtocol");
        list.add("bitRateType");
        list.add("bitRate");
        list.add("frameRate");
        list.add("reserve");
        return list;
    }
}
