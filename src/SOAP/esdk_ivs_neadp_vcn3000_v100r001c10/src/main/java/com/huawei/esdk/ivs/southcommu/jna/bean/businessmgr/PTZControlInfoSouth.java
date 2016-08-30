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
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.IPInfoSouth;
import com.sun.jna.Structure;

/**
 * 云台控制信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class PTZControlInfoSouth extends Structure
{
    public static class ByReference extends PTZControlInfoSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends PTZControlInfoSouth implements Structure.ByValue
    {
    }
    
    public PTZControlInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    /**
     * 云台锁定状态
     */
    public int lockStatus;
    
    /**
     * 用户ID
     */
    public int userId;
    
    /**
     * 用户登录账号
     */
    public byte[] userName = new byte[CommonConstant.UserModule.IVS_NAME_LEN];
    
    /**
     * 登录的客户端IP
     */
    public IPInfoSouth ipInfo;
    
    /**
     * 释放时长
     */
    public int releaseTimeRemain;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("lockStatus");
        list.add("userId");
        list.add("userName");
        list.add("ipInfo");
        list.add("releaseTimeRemain");
        list.add("reserve");
        return list;
    }
    
}
