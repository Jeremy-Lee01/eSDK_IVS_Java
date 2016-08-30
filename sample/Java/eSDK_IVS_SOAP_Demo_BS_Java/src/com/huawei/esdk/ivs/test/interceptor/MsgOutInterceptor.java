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
package com.huawei.esdk.ivs.test.interceptor;

import java.util.List;
import java.util.Map;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.OperationInfo;

public class MsgOutInterceptor extends AbstractPhaseInterceptor<Message>
{
    public MsgOutInterceptor()
    {
        super("pre-stream");
    }
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void handleMessage(Message message)
        throws Fault
    {
        
        OperationInfo operation = message.get(MessageInfo.class).getOperation();
        
        String inputName = operation.getInputName();
        
        if (!"getPublicKey".equals(inputName))
        {
            List session = MsgSessionHolder.getInstance().getSession();
            if (session != null && !session.isEmpty())
            {
                Map headers = (Map)message.get(Message.PROTOCOL_HEADERS);
                headers.put("Cookie", session);
            }
        }
    }
}
