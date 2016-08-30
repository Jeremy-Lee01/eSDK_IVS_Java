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
package com.huawei.esdk.ivs.device.vcn3000.common;

import com.huawei.esdk.ivs.domain.model.bean.LoginInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * 鉴权接口
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public interface ICommonCapability
{
    public SDKErrorCode init();
    
    public SDKErrorCode cleanup();
    
    public SDKResult<Integer> login(LoginInfo loginInfo);
    
    public SDKErrorCode logout(int sessionId);
    
    public SDKErrorCode registerNotification(String esdkSessionId, boolean register);
    
    public SDKResult<Integer> passwdValidation(int sessionId, String userName, String password);
    
    
    /** 
    * 获取SDK的版本号
    * @return 成功返回SDK版本号，高16位表示主版本号，低16位表示次版本号，失败返回负数错误码
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<String> getVersion();
}
