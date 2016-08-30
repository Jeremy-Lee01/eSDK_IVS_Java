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
package com.huawei.esdk.ivs.domain.util;

import java.util.Collection;

import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.NumberUtils;

/**
 * IVS工具类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK IVS V100R003C00]
 */
public class IVSUtil
{
    /**
     * 分页大小
     */
    private static final int INDEX_RANGE = NumberUtils.parseIntValue(ConfigManager.getInstance().getValue("index.range"));
    
    /** 
    * 校验分页信息是否合法
    * 
    * @param fromIndex 起始索引
    * @param toIndex 结束索引
    * @return true:合法/false：不合法
    * @see [类、类#方法、类#成员]
    * @since  [eSDK IVS V100R003C00]
    */
    public static boolean validateIndexRange(int fromIndex, int toIndex)
    {
        if (fromIndex <= 0 || toIndex <= 0)
        {
            return false;
        }
        
        if (fromIndex > toIndex)
        {
            return false;
        }
        
        if (INDEX_RANGE < (toIndex - fromIndex + 1))
        {
            return false;
        }
        
        return true;
    }
    
    /** 
    * 判断集合是否为空
    * <功能详细描述>
    * @param collection 集合类对象
    * @return true：不为空/false：为空
    * @see [类、类#方法、类#成员]
    * @since  [eSDK IVS V100R001C10B001]
    */
    public static boolean isCollectionEmpty(Collection<?> collection)
    {
        if (null != collection && !collection.isEmpty())
        {
            return false;
        }
        
        return true;
    }
}
