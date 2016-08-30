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
package com.huawei.esdk.ivs.professional.local;

import com.huawei.esdk.ivs.professional.local.impl.service.AlarmManagerServiceExImpl;
import com.huawei.esdk.ivs.professional.local.impl.service.BusinessManagerServiceExImpl;
import com.huawei.esdk.ivs.professional.local.impl.service.ClusterManagerServiceExImpl;
import com.huawei.esdk.ivs.professional.local.impl.service.CommonServiceExImpl;
import com.huawei.esdk.ivs.professional.local.impl.service.DeviceManagerServiceExImpl;
import com.huawei.esdk.ivs.professional.local.impl.service.RecordManagerServiceExImpl;
import com.huawei.esdk.ivs.professional.local.impl.service.UserManagerServiceExImpl;
import com.huawei.esdk.ivs.professional.local.impl.service.callback.IVSCallbackServiceExImpl;
import com.huawei.esdk.ivs.professional.local.service.alarmmanager.AlarmManagerServiceEx;
import com.huawei.esdk.ivs.professional.local.service.bussinessmanager.BusinessManagerServiceEx;
import com.huawei.esdk.ivs.professional.local.service.callback.IVSCallbackServiceEx;
import com.huawei.esdk.ivs.professional.local.service.clusterManager.ClusterManagerServiceEx;
import com.huawei.esdk.ivs.professional.local.service.common.CommonServiceEx;
import com.huawei.esdk.ivs.professional.local.service.devicemanager.DeviceManagerServiceEx;
import com.huawei.esdk.ivs.professional.local.service.recordmanager.RecordManagerServiceEx;
import com.huawei.esdk.ivs.professional.local.service.usermanager.UserManagerServiceEx;

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
