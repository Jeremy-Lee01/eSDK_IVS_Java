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
package com.huawei.esdk.ivs.professional.local.constant;

public interface NativeConstant {
	/**
	 * 系统错误
	 */
	int SYSTEM_ERRORCODE = 2130000010;
	/**
	 * 鉴权错误
	 */
	int AUTHORIZE_ERRORCODE = 0x22099000;
	/**
	 * 参数不合法
	 */
	int SDK_DATA_INCORRECT_ERRORCODE = 1342177281;
	/**
	 * 必填参数不能为空
	 */
	int SDK_PARAM_NOT_COMPLETE_ERRORCODE =0x22009002;
	/**
	 * native网络异常
	 */
	int ERROR_CODE_NETWORK_ERROR = 2130000023;
	/**
	 * SSL握手失败
	 */
	int SSL_HANDSHAKE_FAILURE=2130000019;
	/**
	 * native处理异常
	 */
	int NATIVE_EXCEPTION = 2130000020;
	/**
	 * URL格式错误
	 */
	int NATIVE_URL_FORMAT_ERRORCODE = 2130000021;
	/**
	 * 注册回调失败
	 */
	int REDEGIT_CALLBAK_ERRORCODE = 2130000025;
	/**
	 * 取消注册回调失败
	 */
	int UNREDEGIT_CALLBAK_ERRORCODE = 2130000026;
	/**
	 * 密码输入错误次数超过限定值，账户被锁定
	 */
	int ACCOUNT_LOCKED = 2130000027;
	
    /**
     * 账号或密码错误
     */
    int PWD_ERRORCODE = 0x50200033;
    String PWD_ERRORDESC = "PASSWORD ERROR!";
    
    /**
     *  参数错误
     */
    int DATA_ERRORCODE = 0x50000001;
    String DATA_ERRORDESC = "DATA ERROR!";
}
