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
package com.huawei.esdk.ivs.test;

import com.huawei.esdk.ivs.test.service.AlarmManagerServiceEx;
import com.huawei.esdk.ivs.test.service.BusinessManagerServiceEx;
import com.huawei.esdk.ivs.test.service.ClusterManagerServiceEx;
import com.huawei.esdk.ivs.test.service.CommonServiceEx;
import com.huawei.esdk.ivs.test.service.DeviceManagerServiceEx;
import com.huawei.esdk.ivs.test.service.IVSCallbackServiceEx;
import com.huawei.esdk.ivs.test.service.RecordManagerServiceEx;
import com.huawei.esdk.ivs.test.service.UserManagerServiceEx;
import com.huawei.esdk.ivs.test.service.impl.AlarmManagerServiceExImpl;
import com.huawei.esdk.ivs.test.service.impl.BusinessManagerServiceExImpl;
import com.huawei.esdk.ivs.test.service.impl.ClusterManagerServiceExImpl;
import com.huawei.esdk.ivs.test.service.impl.CommonServiceExImpl;
import com.huawei.esdk.ivs.test.service.impl.DeviceManagerServiceExImpl;
import com.huawei.esdk.ivs.test.service.impl.RecordManagerServiceExImpl;
import com.huawei.esdk.ivs.test.service.impl.UserManagerServiceExImpl;
import com.huawei.esdk.ivs.test.service.impl.callback.IVSCallbackServiceExImpl;

public class ServiceFactoryEx
{
    static
    {
        System.setProperty("org.apache.cxf.JDKBugHacks.defaultUsesCaches", "true");
        System.setProperty( "com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize", "true");
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getService(Class<? extends T> interfaceClass)
    {
        if (interfaceClass.getName().equals(UserManagerServiceEx.class.getName()))
        {
            return (T)UserManagerServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(CommonServiceEx.class.getName()))
        {
            return (T)CommonServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(AlarmManagerServiceEx.class.getName()))
        {
            return (T)AlarmManagerServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(ClusterManagerServiceEx.class.getName()))
        {
            return (T)ClusterManagerServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(DeviceManagerServiceEx.class.getName()))
        {
            return (T)DeviceManagerServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(RecordManagerServiceEx.class.getName()))
        {
            return (T)RecordManagerServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(IVSCallbackServiceEx.class.getName()))
        {
            return (T)IVSCallbackServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(BusinessManagerServiceEx.class.getName()))
        {
            return (T)BusinessManagerServiceExImpl.getInstance();
        }
        else
        {
            return null;
        }
        
    }
    
}
