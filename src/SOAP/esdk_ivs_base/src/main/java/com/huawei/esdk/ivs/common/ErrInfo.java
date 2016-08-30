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
package com.huawei.esdk.ivs.common;

import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;

public interface ErrInfo
{
    /**
     *  通用服务
     */
    int SDK_SYSTEM_ERRORCODE = ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR;
    String SDK_SYSTEM_ERRORDESC = "SDK SYSTEM INTERNAL ERROR!";
      
    /**
     * 重复登录
     */
    int LOGIN_REPETITIVE_ERRORCODE = 0x00000002;
    String LOGIN_REPETITIVE_ERRORDESC = "LOGIN REPETITIVE ERROR!";
   
    /**
     * 账号或密码错误
     */
    int APPPWD_ERRORCODE = 0x50200032;
    String APPPWD_ERRORDESC = "ACCOUNT OR PASSWORD ERROR!";
    
    /**
     * 密码错误
     */
    int PWD_ERRORCODE = 0x50200033;
    String PWD_ERRORDESC = "PASSWORD ERROR!";
    
    /**
     *  参数错误
     */
    int DATA_ERRORCODE = 0x50000001;
    String DATA_ERRORDESC = "DATA ERROR!";
    
    /**
     *  必填参数不全
     */
    int SDK_PARAM_NOT_COMPLETE_ERRORCODE = 0x22009002;
    String SDK_PARAM_NOT_COMPLETE_ERRORDESC = "SDK PARAM NOT COMPLETE ERROR!";
    
    /**
     *  参数超范围
     */
    int PARAM_OUTOFRANGE_ERRORCODE = 0x22009003;
    String PARAM_OUTOFRANGE_ERRORDESC = "FUNC PARAMS ARE NOT IN THE RANGE!";
    
    /**
     * 参数为保留字段
     */
    int PARAM_IS_RESERVE_ERRORCODE = 0x22009004;
    String PARAM_IS_RESERVE_ERRORDESC = "PARAM IS RESERVE NOW!";
    
    /**
     * 设备连接失败
     */
    int DEVICE_CONNECT_ERROR = ESDKErrorCodeConstant.ERROR_CODE_DEVICE_CONN_ERROR;
    String DEVICE_CONNECT_ERROR_ERRORDESC = "CONNECTING DEVICE ERROR!";
    
    /**
     * 数据类型错误
     */
    int DATE_TYPE_ERROR = 0x22009001;
    String DATE_TYPE_ERRDESC = "DATE TYPE ERROR!";

    /**
     * sessionId 不正确
     */
    int AUTHORIZE_ERRORCODE = 0x22099000;
    String AUTHORIZE_ERRORDESC = "SESSIONID IS ERROR OR USER DID NOT LOGIN!";
    
    /**
     *  配置文件参数非法
     */
    int SDK_CONFIGDATA_INCORRECT_ERRORCODE = 2130000024;
    String SDK_CONFIGDATA_INCORRECT_ERRORDESC = "CONFIGURATION DATE INCORRECT!";
    
    /**
     * update 2014.1.2，统一查询参数中的Fromindex、Toindex不正确
     */
    int IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR = 119105216;
    String IVS_SMU_XML_UNIFIEDQUERY_INDEX_ERROR_ERRORDESC = "FROM INDEX OR TO INDEX ERROR";
    
    /**
     * update 2014.1.19，查询条件中fieldNum的大小和QueryFieldList中查询条件个数不相同
     */
    int IVS_XML_INVALID_ERROR = 109100027;
    String IVS_XML_INVALID_ERRORDESC = "SDK PARAM INVALID";
    
    /**
     * update 2014.1.19，数值非法或超过取值范围
     */
    int IVS_DATA_INVALID_ERROR = 109100053;
    String IVS_DATA_INVALID_ERRORDESC = "DATA INVALID OR OUT OF RANGE";
    
    /**
     * update 2014.10.09，获取视频句柄失败
     */
    int IVS_HANDLE_INVALID_ERROR = 999115313;
    
    /**
     *  密码解密失败
     */
    int SDK_IVS_PASSWORD_DECODE_ERRORCODE = 2130000030;
    String SDK_IVS_PASSWORD_DECODE_ERRORDESC = "PASSWORD DECODE FAILED!";
    
    /**
     *  密码加密失败
     */
    int SDK_IVS_PASSWORD_ENCODE_ERRORCODE = 2130000031;
    String SDK_IVS_PASSWORD_ENCODE_ERRORDESC = "PASSWORD ENCODE FAILED!";
}
