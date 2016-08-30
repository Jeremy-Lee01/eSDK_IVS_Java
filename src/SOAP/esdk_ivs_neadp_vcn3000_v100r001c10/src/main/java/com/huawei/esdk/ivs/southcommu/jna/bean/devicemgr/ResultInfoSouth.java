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
 * 南向主设备对象类
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class ResultInfoSouth extends Structure
{
    public ResultInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    /**
     * 批量操作序号
     */
    public int sequence;
    
    /**
     * 错误返回代码（批量添加时）
     */
    public int result;
    
    /**
     * 设备编码
     */
    public byte[] code = new byte[CommonConstant.DeviceModule.IVS_DEV_CODE_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("sequence");
        list.add("result");
        list.add("code");
        return list;
    }
    
}
