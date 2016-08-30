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
 * 音频子设备参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AudioConfigSouth extends Structure
{
    public AudioConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends AudioConfigSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends AudioConfigSouth implements Structure.ByValue
    {
    }
    
    /**
     * 语音通道名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符。
     */
    public byte[] audioName = new byte[CommonConstant.DeviceModule.IVS_AUDIO_NAME_LEN];
    
    /**
     * 通道类型 0-语音输入 1-语音输出
     */
    public int channelType;
    
    /**
     * 语音通道索引，正整数。
     */
    public int audioIndex;
    
    /**
     * 音频参数
     */
    public AudioParamSouth audioParam;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("audioName");
        list.add("channelType");
        list.add("audioIndex");
        list.add("audioParam");
        list.add("reserve");
        return list;
    }
    
}
