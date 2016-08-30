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

public class CameraDisplayConfig
{
    private int brightness; // 亮度，范围：0-255
    
    private int contrast; // 对比度，范围：0-255
    
    private int hue; // 色度，范围：0-255
    
    private int saturation; // 饱和度，范围：0-255
    
    private String reserve; // 保留字段
    
    public int getBrightness()
    {
        return brightness;
    }
    
    public void setBrightness(int brightness)
    {
        this.brightness = brightness;
    }
    
    public int getContrast()
    {
        return contrast;
    }
    
    public void setContrast(int contrast)
    {
        this.contrast = contrast;
    }
    
    public int getHue()
    {
        return hue;
    }
    
    public void setHue(int hue)
    {
        this.hue = hue;
    }
    
    public int getSaturation()
    {
        return saturation;
    }
    
    public void setSaturation(int saturation)
    {
        this.saturation = saturation;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
}
