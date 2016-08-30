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
package com.huawei.esdk.ivs.southcommu.jna.bean.alarmmgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.southcommu.jna.bean.usermgr.UserIdInfoSouth;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * 告警授权信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmCommissionSouth extends Structure
{
    
    public AlarmCommissionSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public AlarmCommissionSouth(Pointer p)
    {
        super(p, Structure.ALIGN_NONE);
    }
    
    public AlarmCommissionSouth(int size)
    {
        super(Structure.ALIGN_NONE);
        this.userInfos = new UserIdInfoSouth[size];
    }
    
    /**
     * 告警事件ID
     */
    public long alarmEventId;
    
    /**
     * 被授权用户数
     */
    public int userNum;
    
    /**
     * 被授权用户ID列表
     */
    public UserIdInfoSouth[] userInfos;
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("alarmEventId");
        list.add("userNum");
        list.add("userInfos");
        return list;
    }
    
}
