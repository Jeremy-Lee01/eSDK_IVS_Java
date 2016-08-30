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
package com.huawei.esdk.ivs.professional.local.impl.service.callback;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.huawei.esdk.ivs.professional.local.bean.callback.EventCallBack;
import com.huawei.esdk.ivs.professional.local.bean.callback.EventCallBackResponse;
import com.huawei.esdk.ivs.professional.local.impl.autogen.IVSProfessionalCallBack;
import com.huawei.esdk.ivs.professional.local.impl.autogen.ObjectFactory;
import com.huawei.esdk.ivs.professional.local.service.callback.IVSEventCallBack;

@WebService(targetNamespace = "esdk_ivs_professional_server", name = "IVSProfessional.CallBack")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class IVSProfessionalEventCallBackImpl implements IVSProfessionalCallBack
{
    
    @Override
    @WebResult(name = "eventCallBackResponse", targetNamespace = "esdk_ivs_professional_server", partName = "parameters")
    @WebMethod(action = "esdk_ivs_professional_server.eventCallBack")
    public EventCallBackResponse eventCallBack(
        @WebParam(partName = "parameters", name = "eventCallBack", targetNamespace = "esdk_ivs_professional_server") EventCallBack parameters)
    {
        
        IVSEventCallBack eventCallback =
            (IVSEventCallBack)IVSCallbackServiceExImpl.callbacks.get(IVSEventCallBack.class);
        
        eventCallback.eventCallBack(parameters);
        
        return new EventCallBackResponse();
    }
}
