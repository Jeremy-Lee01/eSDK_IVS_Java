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
 * 录像锁定信息，查询方式为按锁定状态时有效
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class RecordLockInfo
{
    /**
     * 锁定记录ID
     */
    private int lockId;
    
    /**
     * 执行锁定操作的时间
     */
    private String lockTime;
    
    /**
     * 锁定的录像时段
     */
    public TimeSpan lockTimeSpan;
    
    /**
     * 锁定描述
     */
    private String lockDesc;
    
    /**
     * 执行锁定操作的用户ID
     */
    public int operatorId;
    
    /**
     * 执行锁定操作的用户名
     */
    private String operatorName;
    
    /**
     * 保留字段
     */
    private String reserve;
    
    public int getLockId()
    {
        return lockId;
    }
    
    public void setLockId(int lockId)
    {
        this.lockId = lockId;
    }
    
    public String getLockTime()
    {
        return lockTime;
    }
    
    public void setLockTime(String lockTime)
    {
        this.lockTime = lockTime;
    }
    
    public TimeSpan getLockTimeSpan()
    {
        return lockTimeSpan;
    }
    
    public void setLockTimeSpan(TimeSpan lockTimeSpan)
    {
        this.lockTimeSpan = lockTimeSpan;
    }
    
    public String getLockDesc()
    {
        return lockDesc;
    }
    
    public void setLockDesc(String lockDesc)
    {
        this.lockDesc = lockDesc;
    }
    
    public int getOperatorId()
    {
        return operatorId;
    }
    
    public void setOperatorId(int operatorId)
    {
        this.operatorId = operatorId;
    }
    
    public String getOperatorName()
    {
        return operatorName;
    }
    
    public void setOperatorName(String operatorName)
    {
        this.operatorName = operatorName;
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
