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
package com.huawei.esdk.ivs.interceptor;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.common.constants.InfoKeys;
import com.huawei.esdk.platform.common.ThreadLocalHolder;

public class IVSOutInterceptor extends AbstractPhaseInterceptor<Message>
{
    private static final Logger logger = Logger
            .getLogger(IVSOutInterceptor.class);

    public IVSOutInterceptor()
    {
        super(Phase.PRE_STREAM);
    }

    public void handleMessage(Message message) throws Fault
    {
        @SuppressWarnings("unchecked")
        Map<String, List<String>> headers = (Map<String, List<String>>) message
                .get(Message.PROTOCOL_HEADERS);
        if (headers == null)
        {
            headers = new HashMap<String, List<String>>();
        }

        try
        {
            if (null != ThreadLocalHolder.get() 
                && (null != ThreadLocalHolder.get().getEntities().get(InfoKeys.SDK_SESSION_ID.toString())))
            {
                headers.put(
                        "Set-Cookie",
                        Collections.singletonList("JSESSIONID="
                                + ThreadLocalHolder
                                        .get()
                                        .getEntities()
                                        .get(InfoKeys.SDK_SESSION_ID.toString())));
                message.put(Message.PROTOCOL_HEADERS, headers);
                
                ThreadLocalHolder.unset();
            }

        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new Fault(e);
        }

    }

}
