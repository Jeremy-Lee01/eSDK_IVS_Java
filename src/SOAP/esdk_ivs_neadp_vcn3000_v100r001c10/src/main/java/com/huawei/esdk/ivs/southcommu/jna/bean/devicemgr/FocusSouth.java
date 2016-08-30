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
 * 变焦参数
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class FocusSouth extends Structure
{
    public FocusSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends FocusSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends FocusSouth implements Structure.ByValue
    {
    }
    
    /**
     * 变焦模式 0-自动；1-手动
     */
    public int focusMode;
    
    /**
     * 变焦速度
     */
    public int focusSpeed;
    
    /**
     * 最小变焦范围
     */
    public int nearLimit;
    
    /**
     * 最大变焦范围
     */
    public int farLimit;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("focusMode");
        list.add("focusSpeed");
        list.add("nearLimit");
        list.add("farLimit");
        list.add("reserve");
        return list;
    }
    
}
