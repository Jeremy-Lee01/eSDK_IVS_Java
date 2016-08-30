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
package com.huawei.esdk.ivs.professional.local.impl.interceptor;

import java.util.List;

@SuppressWarnings("rawtypes")
public class MsgSessionHolder
{
    private List session;
    private static final MsgSessionHolder msgSessionHolder = new MsgSessionHolder();

    private MsgSessionHolder()
    {
    }

    public static MsgSessionHolder getInstance()
    {
        return msgSessionHolder;
    }

    public List getSession()
    {
        return session;
    }

    public void setSession(List session)
    {
        this.session = session;
    }
}
