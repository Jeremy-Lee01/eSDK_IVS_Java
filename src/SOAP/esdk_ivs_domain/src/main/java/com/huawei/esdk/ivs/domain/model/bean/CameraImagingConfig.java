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

public class CameraImagingConfig
{
    private BackLight backlight; // 背光
    
    private Exposure exposure; // 曝光
    
    private Focus focus; // 变焦
    
    private WideDynamic wideDynamic; // 宽动态
    
    private WhiteBalance whiteBalance; // 白平衡
    
    private Stabilization stabilization; // 防抖动
    
    private int irCutFilter; // 红外过滤 0-关闭；1-打开；2-自动
    
    private int sharpness; // 锐度
    
    private String reserve; // 保留字段

    public BackLight getBacklight()
    {
        return backlight;
    }

    public void setBacklight(BackLight backlight)
    {
        this.backlight = backlight;
    }

    public Exposure getExposure()
    {
        return exposure;
    }

    public void setExposure(Exposure exposure)
    {
        this.exposure = exposure;
    }

    public Focus getFocus()
    {
        return focus;
    }

    public void setFocus(Focus focus)
    {
        this.focus = focus;
    }

    public WideDynamic getWideDynamic()
    {
        return wideDynamic;
    }

    public void setWideDynamic(WideDynamic wideDynamic)
    {
        this.wideDynamic = wideDynamic;
    }

    public WhiteBalance getWhiteBalance()
    {
        return whiteBalance;
    }

    public void setWhiteBalance(WhiteBalance whiteBalance)
    {
        this.whiteBalance = whiteBalance;
    }

    public Stabilization getStabilization()
    {
        return stabilization;
    }

    public void setStabilization(Stabilization stabilization)
    {
        this.stabilization = stabilization;
    }

    public int getIrCutFilter()
    {
        return irCutFilter;
    }

    public void setIrCutFilter(int irCutFilter)
    {
        this.irCutFilter = irCutFilter;
    }

    public int getSharpness()
    {
        return sharpness;
    }

    public void setSharpness(int sharpness)
    {
        this.sharpness = sharpness;
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
