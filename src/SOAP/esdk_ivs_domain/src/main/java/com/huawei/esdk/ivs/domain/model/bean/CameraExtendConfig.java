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

public class CameraExtendConfig
{
    private int enableWatermark; // 是否启用水印：0-关闭 1-开启
    
    private int reliableTransmission; // 可靠传输类型，值参考 IVS_RELIABLE_TRANSMISSION_TYPE
    
    private int fecMatrix; // 可靠传输类型FEC模式下，矩阵模式 
    
    /*
    0:  5x5矩阵 
    1:  7x7矩阵 
    2:  8x4矩阵 
    3:  9x6矩阵 
    4:  10x4矩阵
    5:  11x4矩阵
    6:  12x6矩阵
    7:  15x5矩阵
    8:  18x6矩阵
    9:  19x5矩阵
    10: 24x7矩阵
    11: 26x6矩阵
    12: 34x1矩阵
    */
    private int enableBandwidthAdaptive; // 是否启用带宽自适应：0-关闭 1-开启
    
    private int enableCache; // 是否启用缓存：0-关闭 1-开启
    
    private MediaSecurityConfig mediaSecurityCfg; // 安全相关参数
    
    private String reserve;
    
    public int getEnableWatermark()
    {
        return enableWatermark;
    }
    
    public void setEnableWatermark(int enableWatermark)
    {
        this.enableWatermark = enableWatermark;
    }
    
    public int getReliableTransmission()
    {
        return reliableTransmission;
    }
    
    public void setReliableTransmission(int reliableTransmission)
    {
        this.reliableTransmission = reliableTransmission;
    }
    
    public int getFecMatrix()
    {
        return fecMatrix;
    }
    
    public void setFecMatrix(int fecMatrix)
    {
        this.fecMatrix = fecMatrix;
    }
    
    public int getEnableBandwidthAdaptive()
    {
        return enableBandwidthAdaptive;
    }
    
    public void setEnableBandwidthAdaptive(int enableBandwidthAdaptive)
    {
        this.enableBandwidthAdaptive = enableBandwidthAdaptive;
    }
    
    public int getEnableCache()
    {
        return enableCache;
    }
    
    public void setEnableCache(int enableCache)
    {
        this.enableCache = enableCache;
    }
    
    public MediaSecurityConfig getMediaSecurityCfg()
    {
        return mediaSecurityCfg;
    }
    
    public void setMediaSecurityCfg(MediaSecurityConfig mediaSecurityCfg)
    {
        this.mediaSecurityCfg = mediaSecurityCfg;
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
