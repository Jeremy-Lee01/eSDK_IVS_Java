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
package com.huawei.esdk.ivs.southcommu.jna.bean.usermgr;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Structure;

/**
 * 南向分页信息类
 * <p>
 * @author  gWX169839
 * @see  [相关类/方法]
 * @since  eSDK Solution V100R003C00
 */
public class IndexRangeSouth extends Structure
{
 
    public int fromIndex;
    
    public int toIndex;

    public IndexRangeSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("fromIndex");
        list.add("toIndex");
        return list;
    }
}
