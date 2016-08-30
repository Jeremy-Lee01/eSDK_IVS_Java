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
package com.huawei.esdk.ivs.southcommu.jna.bean.clustermgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.sun.jna.Structure;

/**
 * 主设备列表信息（NVR/TAS）（主设备 DVR/DVS/IPC）
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class DeviceBriefInfoSouth extends Structure
{
    public static class ByReference extends DeviceBriefInfoSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends DeviceBriefInfoSouth implements Structure.ByValue
    {
    }
    
    /**
     * 主设备基本信息
     */
    public DeviceBasicInfoSouth deviceBasicInfoSouth;
    
    /**
     * 主设备协议类型: "TEYES"-千里眼   "ONVIF"  "HWSDK"-华为SDK "HIKSDK"-海康SDK
     */
    public byte[] protocolType = new byte[CommonConstant.ClusterModule.IVS_MAX_PROTOCOLTYPE_NAME_LEN];
    
    /**
     * 认证类型
     */
    public int loginType;
    
    /**
     * 是否启用集群调度：0-否, 1-是(NVR CODE 不为空)
     */
    public int enableSchedule;
    
    /**
     * 设备状态：0-离线，1-在线，2-休眠 参考 IVS_DEV_STATUS
     */
    public int status;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    public DeviceBriefInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("deviceBasicInfoSouth");
        list.add("protocolType");
        list.add("loginType");
        list.add("enableSchedule");
        list.add("status");
        list.add("reserve");
        return list;
    }
}
