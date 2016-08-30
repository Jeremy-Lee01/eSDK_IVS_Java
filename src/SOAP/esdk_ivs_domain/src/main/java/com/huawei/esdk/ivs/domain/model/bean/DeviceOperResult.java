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

/**
 * 
 * 设备编码信息
 * @author  zWX144115
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DeviceOperResult
{
    private String    code;    // 设备编码
    private String    nvrCode; // 设备所属NVR编码, 表示该设备被该NVR管理  

    private int  sequence; // 序号
    private int  result;   // 操作结果

    private String    reserve;   // 保留字段

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getNvrCode()
    {
        return nvrCode;
    }

    public void setNvrCode(String nvrCode)
    {
        this.nvrCode = nvrCode;
    }

    public int getSequence()
    {
        return sequence;
    }

    public void setSequence(int sequence)
    {
        this.sequence = sequence;
    }

    public int getResult()
    {
        return result;
    }

    public void setResult(int result)
    {
        this.result = result;
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
