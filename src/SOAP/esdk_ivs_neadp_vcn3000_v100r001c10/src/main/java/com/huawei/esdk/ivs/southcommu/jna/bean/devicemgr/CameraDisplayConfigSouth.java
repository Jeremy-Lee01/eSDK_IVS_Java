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
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import java.util.List;

import com.sun.jna.Structure;

/**
 * 摄像机显示参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CameraDisplayConfigSouth extends Structure
{
    public CameraDisplayConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends CameraDisplayConfigSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends CameraDisplayConfigSouth implements Structure.ByValue
    {
    }
    
    /**
     * 亮度，范围：0-255
     */
    public int brightness;
    
    /**
     * 对比度，范围：0-255
     */
    public int contrast;
    
    /**
     * 色度，范围：0-255
     */
    public int hue;
    
    /**
     * 饱和度，范围：0-255
     */
    public int saturation;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("brightness");
        list.add("contrast");
        list.add("hue");
        list.add("saturation");
        list.add("reserve");
        return list;
    }
    
}
