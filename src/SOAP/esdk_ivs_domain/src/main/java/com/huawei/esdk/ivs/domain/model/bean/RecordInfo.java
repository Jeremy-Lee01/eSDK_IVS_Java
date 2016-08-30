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
 * 录像检索信息
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class RecordInfo
{
    /**
     * 录像文件名
     */
    private String recordFileName;
    
    /**
     * 录像存储位置
     */
    private int recordMethod;
    
    /**
     * NVR编码，仅在平台录像检索结果中带此字段（内部处理）
     */
    private String nvrCode;
    
    /**
     * 备份服务器域编码备份录像检索结果中带此字段
     */
    private String mbuDomain;
    
    /**
     * 录像类型
     */
    private int recordType;
    
    /**
     * 告警类型，录像类型为告警录像时有效（英文字符串）
     */
    private String alarmType;
    
    /**
     * 录像起止时间
     */
    private TimeSpan timeSpan;
    
    /**
     * 录像抽帧次数
     */
    private int frameExtractionTimes;
    
    /**
     * 录像标签信息，查询方式为按书签时有效
     */
    private RecordBookmarkInfo bookmarkInfo;
    
    /**
     * 锁定信息，查询方式为按锁定状态时有效
     */
    private RecordLockInfo lockInfo;
    
    /**
     * 录像预置位信息，查询方式为按预置位查询时有效
     */
    private RecordPTZPresetInfo ptzPresetInfo;
    
    /**
     * 保留字段
     */
    private String reserve;
    
    public String getRecordFileName()
    {
        return recordFileName;
    }
    
    public void setRecordFileName(String recordFileName)
    {
        this.recordFileName = recordFileName;
    }
    
    public int getRecordMethod()
    {
        return recordMethod;
    }
    
    public void setRecordMethod(int recordMethod)
    {
        this.recordMethod = recordMethod;
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
    
    public int getRecordType()
    {
        return recordType;
    }
    
    public void setRecordType(int recordType)
    {
        this.recordType = recordType;
    }
    
    public String getAlarmType()
    {
        return alarmType;
    }
    
    public void setAlarmType(String alarmType)
    {
        this.alarmType = alarmType;
    }
    
    public TimeSpan getTimeSpan()
    {
        return timeSpan;
    }
    
    public void setTimeSpan(TimeSpan timeSpan)
    {
        this.timeSpan = timeSpan;
    }
    
    public int getFrameExtractionTimes()
    {
        return frameExtractionTimes;
    }
    
    public void setFrameExtractionTimes(int frameExtractionTimes)
    {
        this.frameExtractionTimes = frameExtractionTimes;
    }
    
    public RecordBookmarkInfo getBookmarkInfo()
    {
        return bookmarkInfo;
    }
    
    public void setBookmarkInfo(RecordBookmarkInfo bookmarkInfo)
    {
        this.bookmarkInfo = bookmarkInfo;
    }
    
    public RecordLockInfo getLockInfo()
    {
        return lockInfo;
    }
    
    public void setLockInfo(RecordLockInfo lockInfo)
    {
        this.lockInfo = lockInfo;
    }
    
    public RecordPTZPresetInfo getPtzPresetInfo()
    {
        return ptzPresetInfo;
    }
    
    public void setPtzPresetInfo(RecordPTZPresetInfo ptzPresetInfo)
    {
        this.ptzPresetInfo = ptzPresetInfo;
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
