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

public class MediaSecurityConfig
{
    private int enableMediaSecurity; // 是否启用媒体安全：0-关闭 1-开启
    
    private int enableSecureStorage; // 是否启用安全存储：0-关闭 1-开启
    
    private int mediaSecurityAlgorithm; // 媒体安全算法：1-AES256 2-媒体扰码
    
    private String reserve;
    
    public int getEnableMediaSecurity()
    {
        return enableMediaSecurity;
    }
    
    public void setEnableMediaSecurity(int enableMediaSecurity)
    {
        this.enableMediaSecurity = enableMediaSecurity;
    }
    
    public int getEnableSecureStorage()
    {
        return enableSecureStorage;
    }
    
    public void setEnableSecureStorage(int enableSecureStorage)
    {
        this.enableSecureStorage = enableSecureStorage;
    }
    
    public int getMediaSecurityAlgorithm()
    {
        return mediaSecurityAlgorithm;
    }
    
    public void setMediaSecurityAlgorithm(int mediaSecurityAlgorithm)
    {
        this.mediaSecurityAlgorithm = mediaSecurityAlgorithm;
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
