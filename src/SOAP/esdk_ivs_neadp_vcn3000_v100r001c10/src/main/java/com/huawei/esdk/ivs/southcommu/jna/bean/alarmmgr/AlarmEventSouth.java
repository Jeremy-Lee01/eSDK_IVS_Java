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

import com.sun.jna.Structure;

/**
 * 南向AlarmEvent对象类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class AlarmEventSouth extends Structure
{
    public static class ByReference extends AlarmEventSouth implements Structure.ByReference
    {
        
    }
    
    public static class ByValue extends AlarmEventSouth implements Structure.ByValue
    {
        
    }
    
    public AlarmEventSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    /**
     * 业务告警通知信息
     */
    public AlarmNotifySouth alarmNotifySouth;
    
    /**
     * 告警处理信息
     */
    public AlarmOperateInfoSouth alarmOperateInfoSouth;
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("alarmNotifySouth");
        list.add("alarmOperateInfoSouth");
        return list;
    }
}
