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
 * 告警处理信息
 * <p>
 * 
 * @author sWX198756
 * @see [相关类/方法]
 * @since eSDK IVS V100R003C00
 */
public class AlarmOperateInfo
{
    /**
     * 处理人ID 参考 IVS_USER_INFO
     */
    private int operatorId;
    
    /**
     * 处理人名
     */
    private String operatorName;
    
    /**
     * 告警处理时间
     */
    private String operateTime;
    
    /**
     * 
     */
    private String reserve;
    
    /**
     * 告警处理人员输入的信息
     */
    private String operateInfo;
    
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
    
    public String getOperateTime()
    {
        return operateTime;
    }
    
    public void setOperateTime(String operateTime)
    {
        this.operateTime = operateTime;
    }
    
    public String getReserve()
    {
        return reserve;
    }
    
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
    
    public String getOperateInfo()
    {
        return operateInfo;
    }
    
    public void setOperateInfo(String operateInfo)
    {
        this.operateInfo = operateInfo;
    }
    
}
