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

import com.sun.jna.Structure;
import com.huawei.esdk.ivs.domain.model.CommonConstant;

/**
 * 音频参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AudioParamSouth extends Structure
{
    public AudioParamSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends AudioParamSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends AudioParamSouth implements Structure.ByValue
    {
    }
    
    /**
     * 定调
     */
    public int pitch;
    
    /**
     * 声道
     */
    public int volume;
    
    /**
     * 输入类型
     */
    public int inputType;
    
    /**
     * 数据格式，参考 IVS_PAYLOAD_TYPE
     */
    public int dataFormat;
    
    /**
     * 采样率
     */
    public int sampleRate;
    
    /**
     * 频道
     */
    public int channel;
    
    /**
     * 增益
     */
    public int gain;
    
    /**
     * 比特率
     */
    public int sampleBits;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("pitch");
        list.add("volume");
        list.add("inputType");
        list.add("dataFormat");
        list.add("sampleRate");
        list.add("channel");
        list.add("gain");
        list.add("sampleBits");
        list.add("reserve");
        return list;
    }
    
}
