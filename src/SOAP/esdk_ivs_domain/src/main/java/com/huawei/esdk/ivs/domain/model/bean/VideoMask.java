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

import java.util.List;

public class VideoMask
{
    private int enableVideoMask; // 0-关闭隐私保护，1-启用隐私保护
    
    private int areaNum; // 实际设置的图像遮挡告警区域个数
    
    private List<RectFloat> rectAreas; // 图像遮挡告警区域数组
    
    private String reserve;
    
    public int getEnableVideoMask()
    {
        return enableVideoMask;
    }
    
    public void setEnableVideoMask(int enableVideoMask)
    {
        this.enableVideoMask = enableVideoMask;
    }
    
    public int getAreaNum()
    {
        return areaNum;
    }
    
    public void setAreaNum(int areaNum)
    {
        this.areaNum = areaNum;
    }
    
    public List<RectFloat> getRectAreas()
    {
        return rectAreas;
    }

    public void setRectAreas(List<RectFloat> rectAreas)
    {
        this.rectAreas = rectAreas;
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
