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
package com.huawei.esdk.ivs.business.professional.callback.register;

import com.huawei.esdk.ivs.authorize.SessionManager;
import com.huawei.esdk.ivs.business.professional.callback.IVSNotifyCallback;
import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.domain.model.Notify;
import com.huawei.esdk.platform.callback.itf.ICallback;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.StringUtils;
import com.huawei.esdk.platform.nemgr.base.NotifyCollector;

/**
 * 注册回调信息services层
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CallbackRegisterService
{

    private NotifyCollector notifyCollector;

    private NotifyCallback notifyCallback;
    
    SessionManager sessionMgr = SessionManager.getInstance();

    
    /** 
    * 注册回调方法
    * @param wsUri 回调url
    * @return
    * @throws SDKException SDK异常
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public SDKErrorCode register(String wsUri)
        throws SDKException
    {
        String esdkSessionId = sessionMgr.getESDKSessionId();
        
        if(null == esdkSessionId)
        {
            SDKErrorCode errorCode = new SDKErrorCode();
            errorCode.setErrCode(ErrInfo.AUTHORIZE_ERRORCODE);
            return errorCode;
        }
        
        if (StringUtils.isEmpty(wsUri))
        {
            unRegister(esdkSessionId);
            return new Notify().registerNotification(esdkSessionId, false);
        }
        else
        {
            ICallback callback = new IVSNotifyCallback(wsUri);
            notifyCollector.subscribeNotify(esdkSessionId, callback);
            notifyCallback.registerCallback(esdkSessionId, callback);
            return new Notify().registerNotification(esdkSessionId, true);
        }
    }
    
    public void unRegister(String esdkSessionId)
    {
        notifyCollector.unsubscribeNotify(esdkSessionId);
        notifyCallback.unRegisterCallback(esdkSessionId);
    }

    public void setNotifyCollector(NotifyCollector notifyCollector)
    {
        this.notifyCollector = notifyCollector;
    }

    public void setNotifyCallback(NotifyCallback notifyCallback)
    {
        this.notifyCallback = notifyCallback;
    }
}
