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
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.IPInfoSouth;
import com.sun.jna.Structure;

/**
 * 通用设备信息（NVR/TAS）（主设备 DVR/DVS/IPC）
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class DeviceBasicInfoSouth extends Structure
{
    public DeviceBasicInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends DeviceBasicInfoSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends DeviceBasicInfoSouth implements Structure.ByValue
    {
    }
    
    /**
     * 主设备类型：参考 IVS_MAIN_DEVICE_TYPE
     */
    public int type;
    
    /**
     * 序列号(SN/IMEI)
     */
    public byte[] serialNumber = new byte[CommonConstant.DeviceModule.IVS_DEV_SERIALNO_LEN];
    
    /**
     * 设备编码
     */
    public byte[] code = new byte[CommonConstant.DeviceModule.IVS_DEV_CODE_LEN];
    
    /**
     * 设备名称
     */
    public byte[] name = new byte[CommonConstant.DeviceModule.IVS_DEVICE_NAME_LEN];
    
    /**
     * 父设备编码，如果不为空，表示通过eNVR接入
     */
    public byte[] parentCode = new byte[CommonConstant.DeviceModule.IVS_DEV_CODE_LEN];
    
    /**
     * 域编码
     */
    public byte[] domainCode = new byte[CommonConstant.DeviceModule.IVS_DOMAIN_CODE_LEN];
    
    /**
     * 设备提供商类型: "HUAWEI" "HIK"
     */
    public byte[] vendorType = new byte[CommonConstant.DeviceModule.IVS_MAX_VENDOR_TYPE_NAME_LEN];
    
    /**
     * 设备型号
     */
    public byte[] model = new byte[CommonConstant.DeviceModule.IVS_DEV_MODEL_LEN];
    
    /**
     * 设备IP信息
     */
    public IPInfoSouth stIP = new IPInfoSouth();
    
    /**
     * 设备连接端口
     */
    public int port;
    
    public byte[] reserve = new byte[32];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("type");
        list.add("serialNumber");
        list.add("code");
        list.add("name");
        list.add("parentCode");
        list.add("domainCode");
        list.add("vendorType");
        list.add("model");
        list.add("stIP");
        list.add("port");
        list.add("reserve");
        return list;
    }
}
