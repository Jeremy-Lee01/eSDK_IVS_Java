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
 * 摄像机扩展参数设置
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CameraExtendConfigSouth extends Structure
{
    public CameraExtendConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends CameraExtendConfigSouth implements Structure.ByReference
    {
    }
    
    /**
     * 注释内容
     */
    public int enableWatermark; // 是否启用水印：0-关闭 1-开启
    
    /**
     * 注释内容
     */
    public int reliableTransmission; // 可靠传输类型，值参考 IVS_RELIABLE_TRANSMISSION_TYPE
    
    /**
     * 可靠传输类型FEC模式下，矩阵模式 
     * 0:  5x5矩阵 
     * 1:  7x7矩阵 
     * 2:  8x4矩阵 
     * 3:  9x6矩阵 
     * 4:  10x4矩阵
     * 5:  11x4矩阵
     * 6:  12x6矩阵
     * 7:  15x5矩阵
     * 8:  18x6矩阵
     * 9:  19x5矩阵
     * 10: 24x7矩阵
     * 11: 26x6矩阵
     * 12: 34x1矩阵
     */
    public int fecMatrix;
    
    /**
     * 是否启用带宽自适应：0-关闭 1-开启
     */
    public int enableBandwidthAdaptive;
    
    /**
     * 是否启用缓存：0-关闭 1-开启
     */
    public int enableCache;
    
    /**
     * 安全相关参数
     */
    public MediaSecurityConfigSouth mediaSecurityCfg;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("enableWatermark");
        list.add("reliableTransmission");
        list.add("fecMatrix");
        list.add("enableBandwidthAdaptive");
        list.add("enableCache");
        list.add("mediaSecurityCfg");
        list.add("reserve");
        return list;
    }
    
}
