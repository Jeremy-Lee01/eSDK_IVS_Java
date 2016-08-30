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

public class CameraSnapShotConfig
{
    private int snapCount; // 抓拍数量，范围1-5
    
    private int snapInterval; // 抓拍时间间隔，范围1-5秒
    
    private String reserve;
    
    public int getSnapCount()
    {
        return snapCount;
    }
    
    public void setSnapCount(int snapCount)
    {
        this.snapCount = snapCount;
    }
    
    public int getSnapInterval()
    {
        return snapInterval;
    }
    
    public void setSnapInterval(int snapInterval)
    {
        this.snapInterval = snapInterval;
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
