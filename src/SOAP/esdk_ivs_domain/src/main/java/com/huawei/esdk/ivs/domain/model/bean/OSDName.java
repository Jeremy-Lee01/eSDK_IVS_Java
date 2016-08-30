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
package com.huawei.esdk.ivs.domain.model.bean;

public class OSDName
{
    private int enableOSDName; // 是否显示文字：0-不显示，1-显示
    
    private String osdNameText; // 文字内容
    
    private RectFloat rectText; // 文字区域
    
    private int enableSwitch; // 是否交替显示：0-不交替，1-交替
    
    private int switchInterval; // 交替显示时间间隔，单位为秒
    
    private int enableTextBlink; // 是否允许闪烁：0-不闪烁，1-闪烁
    
    private int enableTextTranslucent; // 是否允许透明：0-不透明，1-透明
    
    private int textTranslucentPercent; // 文字透明度：0-100
    
    private String reserve;

    public int getEnableOSDName()
    {
        return enableOSDName;
    }

    public void setEnableOSDName(int enableOSDName)
    {
        this.enableOSDName = enableOSDName;
    }

    public String getOsdNameText()
    {
        return osdNameText;
    }

    public void setOsdNameText(String osdNameText)
    {
        this.osdNameText = osdNameText;
    }

    public RectFloat getRectText()
    {
        return rectText;
    }

    public void setRectText(RectFloat rectText)
    {
        this.rectText = rectText;
    }

    public int getEnableSwitch()
    {
        return enableSwitch;
    }

    public void setEnableSwitch(int enableSwitch)
    {
        this.enableSwitch = enableSwitch;
    }

    public int getSwitchInterval()
    {
        return switchInterval;
    }

    public void setSwitchInterval(int switchInterval)
    {
        this.switchInterval = switchInterval;
    }

    public int getEnableTextBlink()
    {
        return enableTextBlink;
    }

    public void setEnableTextBlink(int enableTextBlink)
    {
        this.enableTextBlink = enableTextBlink;
    }

    public int getEnableTextTranslucent()
    {
        return enableTextTranslucent;
    }

    public void setEnableTextTranslucent(int enableTextTranslucent)
    {
        this.enableTextTranslucent = enableTextTranslucent;
    }

    public int getTextTranslucentPercent()
    {
        return textTranslucentPercent;
    }

    public void setTextTranslucentPercent(int textTranslucentPercent)
    {
        this.textTranslucentPercent = textTranslucentPercent;
    }

    public String getReserve()
    {
        return reserve;
    }

    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
}
