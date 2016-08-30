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

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * 用户下线通知
 * <p>
 * 
 * @author sWX198756
 * @see [相关类/方法]
 * @since eSDK IVS V100R003C00
 */
public class UserOfflineInfoSouth extends Structure
{
    public UserOfflineInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public UserOfflineInfoSouth(Pointer p)
    {
        super(p, Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends UserOfflineInfoSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends UserOfflineInfoSouth implements Structure.ByValue
    {
    }
    
    /**
     * 下线用户的SessionID
     */
    public int sessionId;
    
    /**
     * 下线类型
     */
    public int offlineType;
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("sessionId");
        list.add("offlineType");
        return list;
    }
    
}
