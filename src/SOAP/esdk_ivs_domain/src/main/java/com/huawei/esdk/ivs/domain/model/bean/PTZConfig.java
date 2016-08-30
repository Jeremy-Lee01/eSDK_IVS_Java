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

public class PTZConfig
{
    private int decoderType; // 云台解码器类型
    
    private int decoderAddress; // 云台解码器地址(1,2...) ，最大长度4，正整数
    
    private int posNegDirectControl; // 正反向控制，取值范围：0-正向 1-反向
    
    private String serialCode; // 串口编码
    
    private String reserve;
    
    public int getDecoderType()
    {
        return decoderType;
    }
    
    public void setDecoderType(int decoderType)
    {
        this.decoderType = decoderType;
    }
    
    public int getDecoderAddress()
    {
        return decoderAddress;
    }
    
    public void setDecoderAddress(int decoderAddress)
    {
        this.decoderAddress = decoderAddress;
    }
    
    public int getPosNegDirectControl()
    {
        return posNegDirectControl;
    }
    
    public void setPosNegDirectControl(int posNegDirectControl)
    {
        this.posNegDirectControl = posNegDirectControl;
    }
    
    public String getSerialCode()
    {
        return serialCode;
    }
    
    public void setSerialCode(String serialCode)
    {
        this.serialCode = serialCode;
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
