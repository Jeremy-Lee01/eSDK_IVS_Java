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

/**
 * 预置位信息
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK IVS V100R003C00]
 */
public class PTZPresetInfo
{
    /**
     * 预置位索引号
     */
    private int presetIndex;
    
    /**
     * 预置位名称
     */
    private String presetName;
    
    /**
     * 保留字段
     */
    private String reserve;

    public int getPresetIndex()
    {
        return presetIndex;
    }

    public void setPresetIndex(int presetIndex)
    {
        this.presetIndex = presetIndex;
    }

    public String getPresetName()
    {
        return presetName;
    }

    public void setPresetName(String presetName)
    {
        this.presetName = presetName;
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
