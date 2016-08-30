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
 * IPC位置信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CameraPositionSouth extends Structure
{
    public CameraPositionSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends CameraPositionSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends CameraPositionSouth implements Structure.ByValue
    {
    }
    
    /**
     * 安装经度 20  最多12位小数，-180~180
     */
    public double longitude;
    
    /**
     * 安装纬度 20  最多12位小数，-180~180
     */
    public double latitude;
    
    /**
     * 安装高度 5   单位m，0-99.99
     */
    public double height;
    
    /**
     * 摄像机安装位置描述
     */
    public byte[] cameraLocation = new byte[CommonConstant.DeviceModule.IVS_DESCRIBE_LEN];
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("longitude");
        list.add("latitude");
        list.add("height");
        list.add("cameraLocation");
        list.add("reserve");
        return list;
    }
    
}
