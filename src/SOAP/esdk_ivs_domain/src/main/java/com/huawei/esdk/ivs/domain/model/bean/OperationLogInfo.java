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
 * 查询日志信息
 * <p>
 * @author  wWX202775
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C10
 */
public class OperationLogInfo
{
    private String account;
    
    private String clientIp;
    
    private int logGrade;
    
    private String serviceCode;
    
    private String moduleType;
    
    private String moduleCode;
    
    private String operationCode;
    
    private String operationObjectCode;
    
    private String occurTime;
    
    private String errorCode;
    
    private String result;
    
    private String additionalInfo;
    
    private String reserve;
    
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        this.account = account;
    }
    
    public String getClientIp()
    {
        return clientIp;
    }
    
    public void setClientIp(String clientIp)
    {
        this.clientIp = clientIp;
    }
    
    public int getLogGrade()
    {
        return logGrade;
    }
    
    public void setLogGrade(int logGrade)
    {
        this.logGrade = logGrade;
    }
    
    public String getServiceCode()
    {
        return serviceCode;
    }
    
    public void setServiceCode(String serviceCode)
    {
        this.serviceCode = serviceCode;
    }
    
    public String getModuleType()
    {
        return moduleType;
    }
    
    public void setModuleType(String moduleType)
    {
        this.moduleType = moduleType;
    }
    
    public String getModuleCode()
    {
        return moduleCode;
    }
    
    public void setModuleCode(String moduleCode)
    {
        this.moduleCode = moduleCode;
    }
    
    public String getOperationCode()
    {
        return operationCode;
    }
    
    public void setOperationCode(String operationCode)
    {
        this.operationCode = operationCode;
    }
    
    public String getOperationObjectCode()
    {
        return operationObjectCode;
    }
    
    public void setOperationObjectCode(String operationObjectCode)
    {
        this.operationObjectCode = operationObjectCode;
    }
    
    public String getOccurTime()
    {
        return occurTime;
    }
    
    public void setOccurTime(String occurTime)
    {
        this.occurTime = occurTime;
    }
    
    public String getErrorCode()
    {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }
    
    public String getResult()
    {
        return result;
    }
    
    public void setResult(String result)
    {
        this.result = result;
    }
    
    public String getAdditionalInfo()
    {
        return additionalInfo;
    }
    
    public void setAdditionalInfo(String additionalInfo)
    {
        this.additionalInfo = additionalInfo;
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
