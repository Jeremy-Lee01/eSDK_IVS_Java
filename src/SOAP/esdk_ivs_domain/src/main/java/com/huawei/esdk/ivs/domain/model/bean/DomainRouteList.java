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
package com.huawei.esdk.ivs.domain.model.bean;

import java.util.List;

/**
 * 系统中的域路由信息列表
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  [V100R003]
 */
public class DomainRouteList
{
    /**
     * 系统实际域路由个数
     */
    private int total;
    
    /**
     * 域路由信息
     */
    private List<DomainRoute> domainRoutes;
    
    public int getTotal()
    {
        return total;
    }
    
    public void setTotal(int total)
    {
        this.total = total;
    }
    
    public List<DomainRoute> getDomainRoutes()
    {
        return domainRoutes;
    }
    
    public void setDomainRoutes(List<DomainRoute> domainRoutes)
    {
        this.domainRoutes = domainRoutes;
    }
    
}
