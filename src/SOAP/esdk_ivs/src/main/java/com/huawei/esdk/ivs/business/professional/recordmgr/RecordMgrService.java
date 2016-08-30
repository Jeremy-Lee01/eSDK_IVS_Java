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
package com.huawei.esdk.ivs.business.professional.recordmgr;

import java.util.List;

import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.Record;
import com.huawei.esdk.ivs.domain.model.bean.DeviceCode;
import com.huawei.esdk.ivs.domain.model.bean.DeviceOperResultList;
import com.huawei.esdk.ivs.domain.model.bean.IndexRange;
import com.huawei.esdk.ivs.domain.model.bean.QueryUnifiedFormat;
import com.huawei.esdk.ivs.domain.model.bean.RecordInfoList;
import com.huawei.esdk.ivs.domain.model.bean.RecordPlan;
import com.huawei.esdk.ivs.domain.model.bean.TimeSpan;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 录像管理模块
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class RecordMgrService
{
    
    /** 
    * 获取录像计划
    * @param cameraCode 摄像机编码
    * @param recordMethod 录像类型
    * @return SDKResult<RecordPlan>  封装领域层的SDKResult对象
    * @throws SDKException SDK异常
    * @since eSDK IVS V100R003C00
    */
    public SDKResult<RecordPlan> getRecordPlan(String cameraCode, int recordMethod)
        throws SDKException
    {
        SDKResult<RecordPlan> result = null;
        if (null == cameraCode)
        {
            result = new SDKResult<RecordPlan>();
            result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        result = new Record().getRecordPlan(cameraCode, recordMethod);
        return result;
    }
    
    
    /** 
    * 删除录像计划
    * @param deviceNum 设备数量
    * @param deviceCodes 录像机编码
    * @param recordMethod 录像类型
    * @return SDKResult<DeviceOperResultList> 封装领域层的SDKResult对象
    * @throws SDKException SDK异常
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<DeviceOperResultList> deleteRecordPlan(int deviceNum, List<DeviceCode> deviceCodes,
        int recordMethod)
        throws SDKException
    {
        SDKResult<DeviceOperResultList> result = new SDKResult<DeviceOperResultList>();
        if (null == deviceCodes)
        {
            result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        if (deviceNum != deviceCodes.size())
        {
            result.setErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return result;
        }
        result = new Record().deleteRecordPlan(deviceNum, deviceCodes, recordMethod);
        return result;
    }
    
    
    public SDKResult<DeviceOperResultList> addRecordPlan(int deviceNum, List<DeviceCode> deviceCodes, RecordPlan recordPlan) 
    throws SDKException
    {
	    SDKResult<DeviceOperResultList> result = new SDKResult<DeviceOperResultList>();
	    if (null == deviceCodes || null == recordPlan) 
	    {
		    result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
		    return result;
	    }
	
	    if (deviceNum != deviceCodes.size())
	    {
	        result.setErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
	        return result;
	    }
	    
        if (null != recordPlan.getPlanInfos()
            && recordPlan.getPlanInfoNum() != recordPlan.getPlanInfos().size())
        {
            result.setErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return result;
        }
	    
	    Record record = new Record();
	    result = record.addRecordPlan(deviceNum, deviceCodes, recordPlan);
	
	    return result; 	
    }
    
    
    /** 
    * 修改录像计划
    * @param deviceNum  设备数量
    * @param deviceCodes 录像机编码
    * @param recordPlan 录像计划
    * @return SDKResult<DeviceOperResultList> 封装领域层的SDKResult对象
    * @throws SDKException SDK异常
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<DeviceOperResultList> modifyRecordPlan(int deviceNum, List<DeviceCode> deviceCodes,
        RecordPlan recordPlan)
        throws SDKException
    {
        SDKResult<DeviceOperResultList> result = new SDKResult<DeviceOperResultList>();
        if (null == deviceCodes || null == recordPlan)
        {
            result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        
        if (deviceNum != deviceCodes.size())
        {
            result.setErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return result;
        }
        
        if (null != recordPlan.getPlanInfos()
            && recordPlan.getPlanInfoNum() != recordPlan.getPlanInfos().size())
        {
            result.setErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return result;
        }
        
        result = new Record().modifyRecordPlan(deviceNum, deviceCodes, recordPlan);
        return result;
    }
    
    /** 
     * 查询录像列表
     * @param queryUnifiedFormat 通用查询结构
     * @return 返回录像查询结构列表
     * @see [类、类#方法、类#成员]
     * @throws SDKException SDK异常
     * @since  eSDK IVS V100R003C00
     */
    public SDKResult<RecordInfoList> queryRecordList(QueryUnifiedFormat queryUnifiedFormat)
        throws SDKException
    {
        SDKResult<RecordInfoList> result = new SDKResult<RecordInfoList>();
        if (null == queryUnifiedFormat || null == queryUnifiedFormat.getIndex()
            || null == queryUnifiedFormat.getOrderCondition() || null == queryUnifiedFormat.getQueryField())
        {
            result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        
        if (queryUnifiedFormat.getFieldNum() != queryUnifiedFormat.getQueryField().size())
        {
            result = new SDKResult<RecordInfoList>();
            result.setErrCode(ErrInfo.IVS_XML_INVALID_ERROR);
            return result;
        }
        
        result = new Record().queryRecordList(queryUnifiedFormat);
        return result;
    }
    
    /** 
     * 查询录像列表
     * @param cameraCode 摄像机ID
     * @param recordMethod 录像存储位置
     * @param timeSpan 时间段信息
     * @param indexRange 分页信息
     * @return 录像查询结构列表
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    public SDKResult<RecordInfoList> getRecordList(String cameraCode, int recordMethod, TimeSpan timeSpan,
        IndexRange indexRange)
        throws SDKException
    {
        SDKResult<RecordInfoList> result = null;
        if (null == cameraCode || null == timeSpan || null == indexRange)
        {
            result = new SDKResult<RecordInfoList>();
            result.setErrCode(ErrInfo.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
            return result;
        }
        result = new Record().getRecordList(cameraCode, recordMethod, timeSpan, indexRange);
        return result;
    }
}
