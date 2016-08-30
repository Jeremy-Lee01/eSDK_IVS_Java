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
 * 隐私保护
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since eSDK IVS V100R003C00
 */
public class VideoMaskSouth extends Structure
{
    public VideoMaskSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends VideoMaskSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends VideoMaskSouth implements Structure.ByValue
    {
    }
    
    /**
     * 0-关闭隐私保护，1-启用隐私保护
     */
    public int enableVideoMask;
    
    /**
     * 实际设置的图像遮挡告警区域个数
     */
    public int areaNum;
    
    /**
     * 图像遮挡告警区域数组
     */
    public RectFloatSouth[] rectArea = new RectFloatSouth[CommonConstant.DeviceModule.IVS_MAX_VIDEO_MASK_AREA_NUM];
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("enableVideoMask");
        list.add("areaNum");
        list.add("rectArea");
        list.add("reserve");
        return list;
    }
}
