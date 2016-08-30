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
 * 摄像机图像参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CameraImagingConfigSouth extends Structure
{
    public CameraImagingConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends CameraImagingConfigSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends CameraImagingConfigSouth implements Structure.ByValue
    {
    }
    
    /**
     * 背光
     */
    public BacklightSouth backlight;
    
    /**
     * 曝光
     */
    public ExposureSouth exposure;
    
    /**
     * 变焦
     */
    public FocusSouth focus;
    
    /**
     * 宽动态
     */
    public WideDynamicSouth wideDynamic;
    
    /**
     * 白平衡
     */
    public WhiteBalanceSouth whiteBalance;
    
    /**
     * 防抖动
     */
    public StabilizationSouth stabilization;
    
    /**
     * 红外过滤 0-关闭；1-打开；2-自动
     */
    public int irCutFilter;
    
    /**
     * 锐度
     */
    public int sharpness;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("backlight");
        list.add("exposure");
        list.add("focus");
        list.add("wideDynamic");
        list.add("whiteBalance");
        list.add("stabilization");
        list.add("irCutFilter");
        list.add("sharpness");
        list.add("reserve");
        return list;
    }
    
}
