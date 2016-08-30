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
package com.huawei.esdk.ivs.test.service.impl;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.test.bean.DeviceCodeList;
import com.huawei.esdk.ivs.test.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.test.bean.IndexRange;
import com.huawei.esdk.ivs.test.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.test.bean.RecordInfos;
import com.huawei.esdk.ivs.test.bean.RecordPlan;
import com.huawei.esdk.ivs.test.bean.ResultInfos;
import com.huawei.esdk.ivs.test.bean.TimeSpan;
import com.huawei.esdk.ivs.test.service.RecordManagerServiceEx;
import com.huawei.esdk.ivs.test.service.impl.autogen.IVSProfessionalRecordManager;
import com.huawei.esdk.ivs.test.utils.ClientProvider;
import com.huawei.esdk.ivs.test.utils.ExceptionUtils;

public class RecordManagerServiceExImpl implements RecordManagerServiceEx
{
    private static final Logger LOGGER = Logger.getLogger(RecordManagerServiceExImpl.class);
    
    private IVSProfessionalRecordManager ivsProfessionalRecordManager =
        (IVSProfessionalRecordManager)ClientProvider.getClient(IVSProfessionalRecordManager.class);
    
    private static RecordManagerServiceExImpl instance = null;
    
    public static synchronized RecordManagerServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new RecordManagerServiceExImpl();
        }
        return instance;
    }
    
    @Override
    public IVSSDKResponse<ResultInfos> addRecordPlan(Integer deviceNum, DeviceCodeList deviceCodes,
        RecordPlan recordPlan)
    {
        LOGGER.info("begin to execute addRecordPlan method");
        
        IVSSDKResponse<ResultInfos> result = new IVSSDKResponse<ResultInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<ResultInfos> resultList = new Holder<ResultInfos>();
        try
        {
            ivsProfessionalRecordManager.addRecordPlan(deviceNum, deviceCodes, recordPlan, resultCode, resultList);
        }
        catch (Exception e)
        {
            LOGGER.error("addRecordPlan method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(resultList.value);
        
        LOGGER.info("execute addRecordPlan method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<ResultInfos> deleteRecordPlan(Integer deviceNum, DeviceCodeList deviceCodes,
        Integer recordMethod)
    {
        LOGGER.info("begin to execute deleteRecordPlan method");
        
        IVSSDKResponse<ResultInfos> result = new IVSSDKResponse<ResultInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<ResultInfos> resultList = new Holder<ResultInfos>();
        try
        {
            ivsProfessionalRecordManager.deleteRecordPlan(deviceNum, deviceCodes, recordMethod, resultCode, resultList);
        }
        catch (Exception e)
        {
            LOGGER.error("deleteRecordPlan method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(resultList.value);
        
        LOGGER.info("execute deleteRecordPlan method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<RecordPlan> getRecordPlan(String cameraCode, Integer recordMethod)
    {
        LOGGER.info("begin to execute getRecordPlan method");
        
        IVSSDKResponse<RecordPlan> result = new IVSSDKResponse<RecordPlan>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<RecordPlan> recordPlan = new Holder<RecordPlan>();
        try
        {
            ivsProfessionalRecordManager.getRecordPlan(cameraCode, recordMethod, resultCode, recordPlan);
        }
        catch (Exception e)
        {
            LOGGER.error("getRecordPlan method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(recordPlan.value);
        
        LOGGER.info("execute getRecordPlan method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<ResultInfos> modifyRecordPlan(Integer deviceNum, DeviceCodeList deviceCodes,
        RecordPlan recordPlan)
    {
        LOGGER.info("begin to execute modifyRecordPlan method");
        
        IVSSDKResponse<ResultInfos> result = new IVSSDKResponse<ResultInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<ResultInfos> resultList = new Holder<ResultInfos>();
        try
        {
            ivsProfessionalRecordManager.modifyRecordPlan(deviceNum, deviceCodes, recordPlan, resultCode, resultList);
        }
        catch (Exception e)
        {
            LOGGER.error("modifyRecordPlan method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(resultList.value);
        
        LOGGER.info("execute modifyRecordPlan method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<RecordInfos> getRecordList(String cameraCode, Integer recordMethod, TimeSpan timeSpan,
        IndexRange indexRange)
    {
        LOGGER.info("begin to execute getRecordList method");
        
        IVSSDKResponse<RecordInfos> result = new IVSSDKResponse<RecordInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<RecordInfos> recordInfos = new Holder<RecordInfos>();
        try
        {
            ivsProfessionalRecordManager.getRecordList(cameraCode,
                recordMethod,
                timeSpan,
                indexRange,
                resultCode,
                recordInfos);
        }
        catch (Exception e)
        {
            LOGGER.error("getRecordList method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(recordInfos.value);
        
        LOGGER.info("execute getRecordList method completed");
        
        return result;
    }
    
    @Override
    public IVSSDKResponse<RecordInfos> queryRecordList(QueryUnifiedFormat queryFormat)
    {
        LOGGER.info("begin to execute queryRecordList method");
        
        IVSSDKResponse<RecordInfos> result = new IVSSDKResponse<RecordInfos>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<RecordInfos> recordInfos = new Holder<RecordInfos>();
        try
        {
            ivsProfessionalRecordManager.queryRecordList(queryFormat, resultCode, recordInfos);
        }
        catch (Exception e)
        {
            LOGGER.error("queryRecordList method exception happened", e);
            
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(recordInfos.value);
        
        LOGGER.info("execute queryRecordList method completed");
        
        return result;
    }
    
}
