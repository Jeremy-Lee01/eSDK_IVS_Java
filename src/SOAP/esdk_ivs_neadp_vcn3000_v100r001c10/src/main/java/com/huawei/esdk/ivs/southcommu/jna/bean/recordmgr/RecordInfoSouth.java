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
 * 录像检索信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class RecordInfoSouth extends Structure
{
    
    public static class ByReference extends RecordInfoSouth implements Structure.ByReference
    {
    }
    
    public static class ByValue extends RecordInfoSouth implements Structure.ByValue
    {
    }
    
    public RecordInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    /**
     * 录像文件名
     */
    public byte[] recordFileName = new byte[CommonConstant.RecordModule.IVS_FILE_NAME_LEN];
    
    /**
     * 录像存储位置
     */
    public int recordMethod;
    
    /**
     * NVR编码，仅在平台录像检索结果中带此字段（内部处理）
     */
    public byte[] nvrCode = new byte[CommonConstant.DeviceModule.IVS_NVR_CODE_LEN];
    
    /**
     * 备份服务器域编码备份录像检索结果中带此字段
     */
    public byte[] mbuDomain = new byte[CommonConstant.DeviceModule.IVS_DOMAIN_CODE_LEN];
    
    /**
     * 录像类型
     */
    public int recordType;
    
    /**
     * 告警类型，录像类型为告警录像时有效（英文字符串）
     */
    public byte[] alarmType = new byte[CommonConstant.AlarmModule.IVS_QUERY_VALUE_LEN];
    
    /**
     * 录像起止时间
     */
    public TimeSpanSouth timeSpan;
    
    /**
     * 录像抽帧次数
     */
    public int frameExtractionTimes;
    
    /**
     * 录像标签信息，查询方式为按书签时有效
     */
    public RecordBookmarkInfoSouth bookmarkInfo;
    
    /**
     * 锁定信息，查询方式为按锁定状态时有效
     */
    public RecordLockInfoSouth lockInfo;
    
    /**
     * 录像预置位信息，查询方式为按预置位查询时有效
     */
    public RecordPTZPresetInfoSouth ptzPresetInfo;
    
    /**
     * 保留字段
     */
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_64_LEN];
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("recordFileName");
        list.add("recordMethod");
        list.add("nvrCode");
        list.add("mbuDomain");
        list.add("recordType");
        list.add("alarmType");
        list.add("timeSpan");
        list.add("frameExtractionTimes");
        list.add("bookmarkInfo");
        list.add("lockInfo");
        list.add("ptzPresetInfo");
        list.add("reserve");
        return list;
    }
    
}
