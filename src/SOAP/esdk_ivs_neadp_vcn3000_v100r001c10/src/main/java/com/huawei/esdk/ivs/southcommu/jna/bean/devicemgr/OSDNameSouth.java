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
 * 前端OSD文字
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class OSDNameSouth extends Structure
{
    public OSDNameSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    public static class ByReference extends OSDNameSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends OSDNameSouth implements Structure.ByValue
    {
    }
    
    /**
     * 是否显示文字：0-不显示，1-显示
     */
    public int enableOSDName;
    
    /**
     * 文字内容
     */
    public byte[] osdNameText = new byte[CommonConstant.DeviceModule.IVS_MAX_OSD_TEXT_LEN];
    
    /**
     * 文字区域
     */
    public RectFloatSouth rectText;
    
    /**
     * 是否交替显示：0-不交替，1-交替
     */
    public int enableSwitch;
    
    /**
     * 交替显示时间间隔，单位为秒
     */
    public int switchInterval;
    
    /**
     * 是否允许闪烁：0-不闪烁，1-闪烁
     */
    public int enableTextBlink;
    
    /**
     * 是否允许透明：0-不透明，1-透明
     */
    public int enableTextTranslucent;
    
    /**
     * 文字透明度：0-100
     */
    public int textTranslucentPercent;
    
    public byte[] reserve = new byte[64];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("enableOSDName");
        list.add("osdNameText");
        list.add("rectText");
        list.add("enableSwitch");
        list.add("switchInterval");
        list.add("enableTextBlink");
        list.add("enableTextTranslucent");
        list.add("textTranslucentPercent");
        list.add("reserve");
        return list;
    }
    
}
