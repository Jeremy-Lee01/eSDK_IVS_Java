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
 * 
 * 实况浏览
 * <p>
 * @author  zWX144115
 * @see  [相关类/方法]
 * @since  [V100R003]
 */
public class RealPlay
{
    /**
     * 码流类型
     */
    private int streamType;
    
    /**
     * 协议类型
     */
    private int protocolType;
    
    /**
     * 是否直连优先
     */
    private int directFirst;
    
    /**
     * 是否开启组播
     */
    private int multiCast;
    
    /**
     * 播放句柄
     */
    private long handle;
    
    /**
     * 保留字段
     */
    private String reserve;
    
    /**
     * 媒体流地址
     */
    private MediaAddress mediaAddress;
    
    public int getStreamType()
    {
        return streamType;
    }
    
    public void setStreamType(int streamType)
    {
        this.streamType = streamType;
    }
    
    public int getProtocolType()
    {
        return protocolType;
    }
    
    public void setProtocolType(int protocolType)
    {
        this.protocolType = protocolType;
    }
    
    public int getDirectFirst()
    {
        return directFirst;
    }
    
    public void setDirectFirst(int directFirst)
    {
        this.directFirst = directFirst;
    }
    
    public int getMultiCast()
    {
        return multiCast;
    }
    
    public void setMultiCast(int multiCast)
    {
        this.multiCast = multiCast;
    }
    
    public long getHandle()
    {
        return handle;
    }
    
    public void setHandle(long handle)
    {
        this.handle = handle;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
    
    public MediaAddress getMediaAddress()
    {
        return mediaAddress;
    }
    
    public void setMediaAddress(MediaAddress mediaAddress)
    {
        this.mediaAddress = mediaAddress;
    }
}
