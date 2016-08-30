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

public class SerialChannelConfig
{
    private String serialName; // 串口设备名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符。
    
    private int serialIndex; // 串口索引
    
    private int serialType; // 串口类型，值参考 IVS_SERIAL_TYPE
    
    private int baudRate; // 波特率(bps) (50, 75, 110, 150, 300, 600, 1200, 2400, 4800, 9600, 19200 38400, 57600, 115200)
    
    private int dataBit; // 数据位 （5、6、7、8）
    
    private int parity; // 校验，值参考IVS_PARITY_TYPE（0－无校验，1－奇校验，2－偶校验，3: 标记校验，4:空校验）
    
    private int stopBit; // 停止位 （1、2）
    
    private int flowControl; // 流控，值参考 IVS_FLOW_CONTROL_TYPE
    
    private String reserve;
    
    public String getSerialName()
    {
        return serialName;
    }
    
    public void setSerialName(String serialName)
    {
        this.serialName = serialName;
    }
    
    public int getSerialIndex()
    {
        return serialIndex;
    }
    
    public void setSerialIndex(int serialIndex)
    {
        this.serialIndex = serialIndex;
    }
    
    public int getSerialType()
    {
        return serialType;
    }
    
    public void setSerialType(int serialType)
    {
        this.serialType = serialType;
    }
    
    public int getBaudRate()
    {
        return baudRate;
    }
    
    public void setBaudRate(int baudRate)
    {
        this.baudRate = baudRate;
    }
    
    public int getDataBit()
    {
        return dataBit;
    }
    
    public void setDataBit(int dataBit)
    {
        this.dataBit = dataBit;
    }
    
    public int getParity()
    {
        return parity;
    }
    
    public void setParity(int parity)
    {
        this.parity = parity;
    }
    
    public int getStopBit()
    {
        return stopBit;
    }
    
    public void setStopBit(int stopBit)
    {
        this.stopBit = stopBit;
    }
    
    public int getFlowControl()
    {
        return flowControl;
    }
    
    public void setFlowControl(int flowControl)
    {
        this.flowControl = flowControl;
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
