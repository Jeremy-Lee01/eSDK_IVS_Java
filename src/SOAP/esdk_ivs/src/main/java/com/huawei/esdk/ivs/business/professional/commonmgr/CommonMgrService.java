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
package com.huawei.esdk.ivs.business.professional.commonmgr;

import com.huawei.esdk.ivs.domain.model.Authenticate;
import com.huawei.esdk.ivs.domain.model.Version;
import com.huawei.esdk.ivs.domain.model.bean.LoginInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * ivs通用模块
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CommonMgrService
{
    
    /** 
    * 获取SDK的版本号
    * @return 成功返回SDK版本号，高16位表示主版本号，低16位表示次版本号，失败返回负数错误码
    * @throws SDKException SDK异常
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public SDKResult<String> getVersion()
        throws SDKException
    {
        return new Version().getVersion();
    }
    
    /**
     * 用户登录
     * @param name 用户名 
     * @param password 密码
     * @return SDKErrorCode 登录结果
     * @exception  SDKException  SDK异常
     * @since eSDK IVS V100R003C00
     */
    public SDKErrorCode login(LoginInfo loginInfo)
        throws SDKException
    {
        return new Authenticate().login(loginInfo);
    }
    
    /** 
    * 用户注销
    * @return
    * @see [类、类#方法、类#成员]
    * @exception  SDKException  SDK异常
    * @since  eSDK IVS V100R003C00
    */
    public SDKErrorCode logout()
        throws SDKException
    {
        return new Authenticate().logout();
    }
    
    
}
