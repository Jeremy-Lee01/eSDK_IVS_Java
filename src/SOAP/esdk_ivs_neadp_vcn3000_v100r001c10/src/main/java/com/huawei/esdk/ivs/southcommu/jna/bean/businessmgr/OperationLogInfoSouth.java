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
package com.huawei.esdk.ivs.southcommu.jna.bean.businessmgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.CommonConstant;
import com.sun.jna.Structure;

/**
 * 操作日志
 * <p>
 * @author  wWX202775
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C10
 */
public class OperationLogInfoSouth extends Structure
{
    public byte[] account = new byte[CommonConstant.IVS_NAME_LEN];
    
    public byte[] clientIp = new byte[CommonConstant.IVS_IP_LEN];
    
    public int grade;
    
    public byte[] serviceCode = new byte[CommonConstant.IVS_DESCRIBE_LEN];
    
    public byte[] moduleType = new byte[CommonConstant.IVS_DESCRIBE_LEN];
    
    public byte[] moduleCode = new byte[CommonConstant.IVS_DEV_CODE_LEN];
    
    public byte[] operationCode = new byte[CommonConstant.IVS_DEV_CODE_LEN];
    
    public byte[] operationObjectCode = new byte[CommonConstant.IVS_DESCRIBE_LEN];
    
    public byte[] occurTime = new byte[CommonConstant.IVS_TIME_LEN];
    
    public byte[] errorCode = new byte[CommonConstant.IVS_DESCRIBE_LEN];
    
    public int result;
    
    public byte[] additionalInfo = new byte[CommonConstant.IVS_DESCRIBE_LEN];
    
    public byte[] reserve = new byte[CommonConstant.IVS_RESERVE_32_LEN];
    
    public OperationLogInfoSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    @Override
    protected List<String> getFieldOrder()
    {
        List<String> list = new ArrayList<String>();
        list.add("account");
        list.add("clientIp");
        list.add("grade");
        list.add("serviceCode");
        list.add("moduleType");
        list.add("moduleCode");
        list.add("operationCode");
        list.add("operationObjectCode");
        list.add("occurTime");
        list.add("errorCode");
        list.add("result");
        list.add("additionalInfo");
        list.add("reserve");
        return list;
    }
    
}
