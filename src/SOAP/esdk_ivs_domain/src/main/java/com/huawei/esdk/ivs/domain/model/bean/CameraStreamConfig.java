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

import java.util.List;

public class CameraStreamConfig
{
    private int streamInfoNum; // 有效视频流信息数目
    
    private List<StreamInfo> streamInfos; // 视频流信息
    
    private String reserve;
    
    public int getStreamInfoNum()
    {
        return streamInfoNum;
    }
    
    public void setStreamInfoNum(int streamInfoNum)
    {
        this.streamInfoNum = streamInfoNum;
    }
    
    public List<StreamInfo> getStreamInfos()
    {
        return streamInfos;
    }

    public void setStreamInfos(List<StreamInfo> streamInfos)
    {
        this.streamInfos = streamInfos;
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
