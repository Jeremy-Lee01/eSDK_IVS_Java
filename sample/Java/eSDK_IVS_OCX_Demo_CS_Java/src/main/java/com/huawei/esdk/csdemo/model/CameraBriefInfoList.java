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

package com.huawei.esdk.csdemo.model;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * 视频子设备列表
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CameraBriefInfoList extends Structure
{
    public CameraBriefInfoList(int size)
    {
        super(Structure.ALIGN_NONE);
        this.cameraBriefInfo = new CameraBriefInfo[size];
    }
    
    public CameraBriefInfoList(Pointer pointer)
    {
        super(pointer, Structure.ALIGN_NONE);
    }
    
    /**
     * 总记录数
     */
    public int total;
    
    /**
     * 分页信息
     */
    public IndexRange indexRange;
    
    /**
     * 视频子设备列表简要信息
     */
    public CameraBriefInfo[] cameraBriefInfo = null;
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        
        list.add("total");
        list.add("indexRange");
        list.add("cameraBriefInfo");
        return list;
    }
    
}
