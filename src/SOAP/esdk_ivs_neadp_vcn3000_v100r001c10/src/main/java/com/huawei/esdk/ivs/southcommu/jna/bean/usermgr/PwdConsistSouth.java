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
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.CommonConstant;
import com.sun.jna.Structure;

public class PwdConsistSouth extends Structure
{
    // 大写字母，是否选中
    public int    bCapital; 
    // 小写字母，是否选中
    public int    bLowercase;  
    // 数字，是否选中
    public int    bFigure;    
    // 特殊字符，是否选中
    public int    bSpecialChar;   
    // 保留字段
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("bCapital");
        list.add("bLowercase");
        list.add("bFigure");
        list.add("bSpecialChar");
        list.add("reserve");
        return list;
    }    
}
