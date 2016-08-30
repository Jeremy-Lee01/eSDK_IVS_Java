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
 * 背光补偿参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class BacklightSouth extends Structure
{
    public BacklightSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends BacklightSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends BacklightSouth implements Structure.ByValue
    {
    }
    
    /**
     * 背光补偿模式 0-关闭；1-开启
     */
    public int backlightMode;
    
    /**
     * 背光补偿等级 0-3
     */
    public int backlightLevel;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("backlightMode");
        list.add("backlightLevel");
        list.add("reserve");
        return list;
    }
    
}
