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
package com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.sun.jna.Structure;

public class SnapshotInfoSouth extends Structure
{
    
    public static class ByReference extends SnapshotInfoSouth implements Structure.ByReference
    {
    
    }
    
    public static class ByValue extends SnapshotInfoSouth implements Structure.ByValue
    {
    
    }
    
    public SnapshotInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public byte[] cameraCode = new byte[CommonConstant.ClusterModule.IVS_DEV_CODE_LEN];
    
    public byte[] snapTime = new byte[CommonConstant.IVS_TIME_LEN];
    
    public int snapType;
    
    public int pictureID;
    
    public byte[] pictureName = new byte[CommonConstant.IVS_FILE_NAME_LEN];
    
    public int pictureSize;
    
    public byte[] previewUrl = new byte[CommonConstant.IVS_URL_LEN];
    
    public byte[] pictureUrl = new byte[CommonConstant.IVS_URL_LEN];
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("cameraCode");
        list.add("snapTime");
        list.add("snapType");
        list.add("pictureID");
        list.add("pictureName");
        list.add("pictureSize");
        list.add("previewUrl");
        list.add("pictureUrl");
        list.add("reserve");
        return list;
    }
    
}
