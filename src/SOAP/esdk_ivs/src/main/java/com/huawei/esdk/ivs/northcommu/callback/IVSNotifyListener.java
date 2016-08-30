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
package com.huawei.esdk.ivs.northcommu.callback;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.northcommu.callback.convert.IVSEventCallbackConvert;
import com.huawei.esdk.ivs.northcommu.callback.cxf.gen.EventCallBack;
import com.huawei.esdk.ivs.northcommu.callback.cxf.gen.IVSProfessionalCallBack;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.commu.itf.ICXFSOAPProtocolAdapter;
import com.huawei.esdk.platform.commu.itf.IProtocolAdapterManager;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

/**
 * 回调消息发送
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class IVSNotifyListener extends SOAPListener
{
    private static final Logger LOGGER = Logger.getLogger(IVSNotifyListener.class);
    
    private ICXFSOAPProtocolAdapter cxfSOAPProtocolAdapter;
    
    private IVSEventCallbackConvert ivsEventCallbackConvert = ApplicationContextUtil.getBean("ivsEventCallbackConvert");
    
    private IProtocolAdapterManager protocolAdapterManager = ApplicationContextUtil.getBean("protocolAdapterManager");
    
    public IVSNotifyListener(String url)
    {
        cxfSOAPProtocolAdapter =
            (ICXFSOAPProtocolAdapter)protocolAdapterManager.getProtocolInstanceByType("SOAP_CXF", url);
    }
    
    /** 
    * 向客户端发送回调消息
    * @param domain 消息体
    * @param eventType 事件类型
    * @see [类、类#方法、类#成员]
    * @since  eSDK IVS V100R003C00
    */
    public void notify(Object domain, String eventType)
    {
        
        EventCallBack parameters = ivsEventCallbackConvert.getNotifyModel2Soap(domain, eventType);
        try
        {
            cxfSOAPProtocolAdapter.syncSendMessageWithCxf(parameters,
                IVSProfessionalCallBack.class.getName(),
                "eventCallBack");
        }
        catch (ProtocolAdapterException e)
        {
            LOGGER.error("notify callback error", e);
        }
        catch (Exception e)
        {
            LOGGER.error("system error", e);
        }
    }
}
