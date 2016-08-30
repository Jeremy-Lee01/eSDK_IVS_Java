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
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import java.util.List;

import com.sun.jna.Structure;

/**
 * 摄像机OSD参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CameraOSDConfigSouth extends Structure
{
    public CameraOSDConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends CameraOSDConfigSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends CameraOSDConfigSouth implements Structure.ByValue
    {
    }
    
    /**
     * 是否启用：0-停用 1-启用
     */
    public int enableOSD; 
    
    /**
     * OSD时间信息
     */
    public OSDTimeSouth osdTime; 
    
    /**
     * OSD文字信息
     */
    public OSDNameSouth osdName; 
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("enableOSD");
        list.add("osdTime");
        list.add("osdName");
        list.add("reserve");
        return list;
    }
    
}
