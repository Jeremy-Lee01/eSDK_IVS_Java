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
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * 云台参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class PTZConfigSouth extends Structure
{
    public PTZConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public PTZConfigSouth(Pointer p)
    {
        super(p, Structure.ALIGN_NONE);
    }
    
    
    /**
     * 云台解码器类型
     */
    public int decoderType;
    
    /**
     * 云台解码器地址(1,2...) ，最大长度4，正整数
     */
    public int decoderAddress;
    
    /**
     * 正反向控制，取值范围：0-正向 1-反向
     */
    public int posNegDirectControl;
    
    /**
     * 串口编码
     */
    public byte[] serialCode = new byte[CommonConstant.DeviceModule.IVS_DEV_SERIALNO_LEN];
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("decoderType");
        list.add("decoderAddress");
        list.add("posNegDirectControl");
        list.add("serialCode");
        list.add("reserve");
        return list;
    }
    
}
