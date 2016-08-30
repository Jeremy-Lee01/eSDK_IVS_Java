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
 * 摄像机安全参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class MediaSecurityConfigSouth extends Structure
{
    public MediaSecurityConfigSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends MediaSecurityConfigSouth implements Structure.ByReference
    {
    }
    
    /**
     * 是否启用媒体安全：0-关闭 1-开启
     */
    public int enableMediaSecurity;
    
    /**
     * 是否启用安全存储：0-关闭 1-开启
     */
    public int enableSecureStorage;
    
    /**
     * 媒体安全算法：1-AES256 2-媒体扰码
     */
    public int mediaSecurityAlgorithm;
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("enableMediaSecurity");
        list.add("enableSecureStorage");
        list.add("mediaSecurityAlgorithm");
        list.add("reserve");
        return list;
    }
    
}
