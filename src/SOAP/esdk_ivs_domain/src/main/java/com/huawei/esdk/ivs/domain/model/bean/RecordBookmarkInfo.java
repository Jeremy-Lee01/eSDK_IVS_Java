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
 * 录像标签信息，查询方式为按书签时有效
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class RecordBookmarkInfo
{
    /**
     * 录像标签ID
     */
    private int bookmarkId;
    
    /**
     * 标签名
     */
    private String bookmarkName;
    
    /**
     * 标签时间：yyyyMMddHHmmss
     */
    private String bookmarkTime;
    
    /**
     * 摄像头编码
     */
    private String cameraCode;
    
    /**
     * 摄像头名称
     */
    private String cameraName;
    
    /**
     * 操作用户所在域编码
     */
    private String userDomain;
    
    /**
     * 创建书签的用户ID
     */
    public int bookmarkCreatorId;
    
    /**
     * 创建书签的用户名
     */
    private String bookmarkCreatorName;
    
    /**
     * NVR编码
     */
    private String nvrCode;
    
    /**
     * 备份服务器域编码备份录像检索结果中带此字段
     */
    private String mbuDomain;
    
    private String reserve;
    
    public int getBookmarkId()
    {
        return bookmarkId;
    }
    
    public void setBookmarkId(int bookmarkId)
    {
        this.bookmarkId = bookmarkId;
    }
    
    public String getBookmarkName()
    {
        return bookmarkName;
    }
    
    public void setBookmarkName(String bookmarkName)
    {
        this.bookmarkName = bookmarkName;
    }
    
    public String getBookmarkTime()
    {
        return bookmarkTime;
    }
    
    public void setBookmarkTime(String bookmarkTime)
    {
        this.bookmarkTime = bookmarkTime;
    }
    
    public String getCameraCode()
    {
        return cameraCode;
    }
    
    public void setCameraCode(String cameraCode)
    {
        this.cameraCode = cameraCode;
    }
    
    public String getCameraName()
    {
        return cameraName;
    }
    
    public void setCameraName(String cameraName)
    {
        this.cameraName = cameraName;
    }
    
    public String getUserDomain()
    {
        return userDomain;
    }
    
    public void setUserDomain(String userDomain)
    {
        this.userDomain = userDomain;
    }
    
    public int getBookmarkCreatorId()
    {
        return bookmarkCreatorId;
    }
    
    public void setBookmarkCreatorId(int bookmarkCreatorId)
    {
        this.bookmarkCreatorId = bookmarkCreatorId;
    }
    
    public String getBookmarkCreatorName()
    {
        return bookmarkCreatorName;
    }
    
    public void setBookmarkCreatorName(String bookmarkCreatorName)
    {
        this.bookmarkCreatorName = bookmarkCreatorName;
    }
    
    public String getNvrCode()
    {
        return nvrCode;
    }
    
    public void setNvrCode(String nvrCode)
    {
        this.nvrCode = nvrCode;
    }
    
    public String getMbuDomain()
    {
        return mbuDomain;
    }
    
    public void setMbuDomain(String mbuDomain)
    {
        this.mbuDomain = mbuDomain;
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
