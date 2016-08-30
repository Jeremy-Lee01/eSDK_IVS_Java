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

public class PlaybackParam {

    private Integer protocolType;
    
    private TimeSpan recordTime;
    
    private float speed;
    
    private String NVRCode;
    
    public Integer getProtocolType()
    {
        return protocolType;
    }
    public void setProtocolType(Integer protocolType)
    {
        this.protocolType = protocolType;
    }
    public TimeSpan getRecordTime()
    {
        return recordTime;
    }
    public void setRecordTime(TimeSpan recordTime)
    {
        this.recordTime = recordTime;
    }

    public float getSpeed()
    {
        return speed;
    }
    public void setSpeed(float speed)
    {
        this.speed = speed;
    }
    public String getNVRCode()
    {
        return NVRCode;
    }
    public void setNVRCode(String NVRCode)
    {
        this.NVRCode = NVRCode;
    }

}
