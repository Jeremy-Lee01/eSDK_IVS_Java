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
 * 曝光参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class ExposureSouth extends Structure
{
    public ExposureSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends ExposureSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends ExposureSouth implements Structure.ByValue
    {
    }
    
    /**
     * 曝光模式 0-自动；1-手动
     */
    public int exposureMode;
    
    /**
     * 曝光优先模式 0-低噪优先；1-帧率优先
     */
    public int exposurePriority;
    
    /**
     * 曝光窗口
     */
    public RectFloatSouth rectWindow;
    
    /**
     * 曝光时间（单位微秒us）
     */
    public int exposureTime;
    
    /**
     * 曝光增益（单位dB）
     */
    public int exposureGain;
    
    /**
     * 光圈
     */
    public int exposureIris;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("exposureMode");
        list.add("exposurePriority");
        list.add("rectWindow");
        list.add("exposureTime");
        list.add("exposureGain");
        list.add("exposureIris");
        list.add("reserve");
        return list;
    }
    
}
