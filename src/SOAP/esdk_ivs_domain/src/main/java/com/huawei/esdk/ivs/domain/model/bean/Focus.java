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

public class Focus
{
    private int focusMode; // 变焦模式 0-自动；1-手动
    
    private int focusSpeed; // 变焦速度
    
    private int nearLimit; // 最小变焦范围
    
    private int farLimit; // 最大变焦范围
    
    private String reserve; // 保留字段

    public int getFocusMode()
    {
        return focusMode;
    }

    public void setFocusMode(int focusMode)
    {
        this.focusMode = focusMode;
    }

    public int getFocusSpeed()
    {
        return focusSpeed;
    }

    public void setFocusSpeed(int focusSpeed)
    {
        this.focusSpeed = focusSpeed;
    }

    public int getNearLimit()
    {
        return nearLimit;
    }

    public void setNearLimit(int nearLimit)
    {
        this.nearLimit = nearLimit;
    }

    public int getFarLimit()
    {
        return farLimit;
    }

    public void setFarLimit(int farLimit)
    {
        this.farLimit = farLimit;
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
