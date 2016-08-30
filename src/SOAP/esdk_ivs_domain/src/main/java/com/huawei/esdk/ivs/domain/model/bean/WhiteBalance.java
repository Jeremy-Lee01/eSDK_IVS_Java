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

public class WhiteBalance
{
    private int whiteBalanceMode; // 白平衡模式 0-自动；1-手动
    
    private int crGain; // 红色增益
    
    private int cbGain; // 蓝色增益
    
    private String reserve; // 保留字段
    
    public int getWhiteBalanceMode()
    {
        return whiteBalanceMode;
    }
    
    public void setWhiteBalanceMode(int whiteBalanceMode)
    {
        this.whiteBalanceMode = whiteBalanceMode;
    }
    
    public int getCrGain()
    {
        return crGain;
    }
    
    public void setCrGain(int crGain)
    {
        this.crGain = crGain;
    }
    
    public int getCbGain()
    {
        return cbGain;
    }
    
    public void setCbGain(int cbGain)
    {
        this.cbGain = cbGain;
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
