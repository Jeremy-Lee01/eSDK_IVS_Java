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
package com.huawei.esdk.ivs.southcommu.jna.bean.recordmgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.sun.jna.Structure;

/**
 * 录像标签信息，查询方式为按书签时有效
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class RecordBookmarkInfoSouth extends Structure
{
    public static class ByReference extends RecordBookmarkInfoSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends RecordBookmarkInfoSouth implements Structure.ByValue
    {
    }
    
    public RecordBookmarkInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    /**
     * 录像标签ID
     */
    public int bookmarkId;
    
    /**
     * 标签名
     */
    public byte[] bookmarkName = new byte[CommonConstant.RecordModule.IVS_BOOKMARK_NAME_LEN];
    
    /**
     * 标签时间：yyyyMMddHHmmss
     */
    public byte[] bookmarkTime = new byte[CommonConstant.IVS_TIME_LEN];
    
    /**
     * 摄像头编码
     */
    public byte[] cameraCode = new byte[CommonConstant.DeviceModule.IVS_DEV_CODE_LEN];
    
    /**
     * 摄像头名称
     */
    public byte[] cameraName = new byte[CommonConstant.DeviceModule.IVS_NAME_LEN];
    
    /**
     * 操作用户所在域编码
     */
    public byte[] userDomain = new byte[CommonConstant.DeviceModule.IVS_DOMAIN_CODE_LEN];
    
    /**
     * 创建书签的用户ID
     */
    public int bookmarkCreatorId;
    
    /**
     * 创建书签的用户名
     */
    public byte[] bookmarkCreatorName = new byte[CommonConstant.UserModule.IVS_NAME_LEN];
    
    /**
     * NVR编码
     */
    public byte[] nvrCode = new byte[CommonConstant.DeviceModule.IVS_NVR_CODE_LEN];
    
    /**
     * 备份服务器域编码备份录像检索结果中带此字段
     */
    public byte[] mbuDomain = new byte[CommonConstant.DeviceModule.IVS_DOMAIN_CODE_LEN];
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("bookmarkId");
        list.add("bookmarkName");
        list.add("bookmarkTime");
        list.add("cameraCode");
        list.add("cameraName");
        list.add("userDomain");
        list.add("bookmarkCreatorId");
        list.add("bookmarkCreatorName");
        list.add("nvrCode");
        list.add("mbuDomain");
        list.add("reserve");
        return list;
    }
    
}
