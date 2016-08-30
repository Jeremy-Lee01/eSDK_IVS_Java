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
 * 串口子设备信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class SerialChannelConfigSouth extends Structure
{
    public SerialChannelConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends SerialChannelConfigSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends SerialChannelConfigSouth implements Structure.ByValue
    {
    }
    
    /**
     * 串口设备名称，汉字和字母（a-z和A-Z），数字，中划线和下划线，1~20个字符
     */
    public byte[] serialName = new byte[CommonConstant.DeviceModule.IVS_SERIAL_NAME_LEN];
    
    /**
     * 串口索引
     */
    public int serialIndex;
    
    /**
     * 串口类型，值参考 IVS_SERIAL_TYPE
     */
    public int serialType;
    
    /**
     * 波特率(bps) (50, 75, 110, 150, 300, 600, 1200, 2400, 4800, 9600, 19200 38400, 57600, 115200)
     */
    public int baudRate;
    
    /**
     * 数据位 （5、6、7、8）
     */
    public int dataBit;
    
    /**
     * 校验，值参考IVS_PARITY_TYPE（0－无校验，1－奇校验，2－偶校验，3: 标记校验，4:空校验）
     */
    public int parity;
    
    /**
     * 停止位 （1、2）
     */
    public int stopBit;
    
    /**
     * 流控，值参考 IVS_FLOW_CONTROL_TYPE
     */
    public int flowControl;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("serialName");
        list.add("serialIndex");
        list.add("serialType");
        list.add("baudRate");
        list.add("dataBit");
        list.add("parity");
        list.add("stopBit");
        list.add("flowControl");
        list.add("reserve");
        return list;
    }
    
}
