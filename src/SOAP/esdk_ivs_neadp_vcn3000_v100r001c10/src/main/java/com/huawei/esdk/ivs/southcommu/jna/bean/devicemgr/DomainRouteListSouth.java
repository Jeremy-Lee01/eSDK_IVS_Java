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
package com.huawei.esdk.ivs.southcommu.jna.bean.devicemgr;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.sun.jna.Structure;

/**
 * 南向域路由对象类
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since eSDK IVS V100R003C00
 */
public class DomainRouteListSouth extends Structure
{
    
    public static class ByReference extends DomainRouteListSouth implements Structure.ByReference
    {
    }
    
    /**
     * 系统实际域路由个数
     */
    public int total;
    
    /**
     * 域路由信息
     */
    public DomainRouteSouth[] domainRoutes = new DomainRouteSouth[CommonConstant.DeviceModule.IVS_MAX_DOMAIN_ROUTE_NUM];
    
    public DomainRouteListSouth()
    {
        super(Structure.ALIGN_NONE);
    }
    
    @Override
    protected List<String> getFieldOrder()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("total");
        list.add("domainRoutes");
        return list;
    }
    
}
