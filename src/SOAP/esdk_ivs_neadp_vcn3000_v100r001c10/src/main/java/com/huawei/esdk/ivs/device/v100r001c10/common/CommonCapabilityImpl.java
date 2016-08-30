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
package com.huawei.esdk.ivs.device.v100r001c10.common;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.huawei.esdk.ivs.common.ErrInfo;
import com.huawei.esdk.ivs.device.BaseCability;
import com.huawei.esdk.ivs.device.v100r001c10.callback.CallbackEventImpl;
import com.huawei.esdk.ivs.device.v100r001c10.callback.CallbackThread;
import com.huawei.esdk.ivs.device.v100r001c10.common.convert.CommonCapabilityConvert;
import com.huawei.esdk.ivs.device.vcn3000.common.ICommonCapability;
import com.huawei.esdk.ivs.domain.model.CommonConstant;
import com.huawei.esdk.ivs.domain.model.bean.LoginInfo;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.EventCallBackSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.LoginInfoSouth;
import com.huawei.esdk.ivs.southcommu.jna.bean.commonmgr.UserDataSouth;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

/**
 * 通用模块
 * <p>
 * @author  sWX198756
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R003C00
 */
public class CommonCapabilityImpl extends BaseCability implements ICommonCapability
{
    
    private CommonCapabilityConvert commonCapabilityConvert = ApplicationContextUtil.getBean("commonCapabilityConvert");
    
    private CallbackEventImpl callbackEventImpl = ApplicationContextUtil.getBean("callbackEventImpl");
    
    private static final Logger LOGGER = Logger.getLogger(CommonCapabilityImpl.class);
    
    public static final Map<Integer, List<String>> relativeMap = new ConcurrentHashMap<Integer, List<String>>();
    
    /**
     * callbackSouthList虽然是static属性，没有被外部使用过，在自身类里也仅仅做了赋值和移除的操作，删除这个成员及相关操作之后整个程序不会报错。
     * 但是删除之后会导致 底层类库的告警Notification回调在开始一段时间之后自动停止。
     * ——by likun/00295065
     */
    public static final Map<String, EventCallBackSouth> callbackSouthList =
        new ConcurrentHashMap<String, EventCallBackSouth>();
        
    /**
     * 同callbackSouthList，不可删除
     */
    public static final Map<String, UserDataSouth> userDateSouthList = new ConcurrentHashMap<String, UserDataSouth>();
    
    private ExecutorService pool = Executors.newFixedThreadPool(30);
    
    @Override
    public SDKErrorCode init()
    {
        LOGGER.info("init start --->>> ");
        
        SDKErrorCode result = new SDKErrorCode();
        int resultCode = super.getBaseCablilityJNA().IVS_SDK_Init();
        result.setErrCode(resultCode);
        
        LOGGER.info("init result code: " + resultCode);
        LOGGER.info("init end --->>> ");
        
        for (int i = 0; i < 30; i++)
        {
            pool.submit(new CallbackThread());
        }
        return result;
    }
    
    @Override
    public SDKErrorCode cleanup()
    {
        LOGGER.info("cleanup start --->>> ");
        
        SDKErrorCode result = new SDKErrorCode();
        int resultCode = super.getBaseCablilityJNA().IVS_SDK_Cleanup();
        result.setErrCode(resultCode);
        
        LOGGER.info("cleanup result code: " + resultCode);
        LOGGER.info("cleanup end --->>> ");
        
        pool.shutdownNow();
        
        return result;
    }
    
    /**
     * 用户登录
     * @loginInfo 用户登录信息
     * @return SDKErrorCode 登录结果
     * @exception  SDKException  SDK异常
     * @since eSDK IVS V100R003C00
     */
    @Override
    public SDKResult<Integer> login(LoginInfo loginInfo)
    {
        LOGGER.info("login start --->>> ");
        
        SDKResult<Integer> result = new SDKResult<Integer>();
        LoginInfoSouth loginInfoSouth = commonCapabilityConvert.getLoginInfoModel2South(loginInfo);
        IntByReference ref = new IntByReference();
        
        int resultCode = super.getBaseCablilityJNA().IVS_SDK_Login(loginInfoSouth, ref);
        
        LOGGER.info("login result code: " + resultCode);
        LOGGER.info("login end --->>> ");
        
        int sessionId = ref.getValue();
        result.setErrCode(resultCode);
        if (0 == resultCode || CommonConstant.UserModule.IVS_SMU_USER_FIRST_LOGIN == resultCode
            || CommonConstant.UserModule.IVS_SMU_USER_PWD_NEED_MOD == resultCode)
        {
            result.setResult(sessionId);
        }
        
        return result;
    }
    
    /** 
     * 用户注销
     * @return
     * @see [类、类#方法、类#成员]
     * @exception  SDKException  SDK异常
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public SDKErrorCode logout(int sessionId)
    {
        LOGGER.info("logout start --->>> ");
        
        SDKErrorCode result = new SDKErrorCode();
        
        int resultCode = super.getBaseCablilityJNA().IVS_SDK_Logout(sessionId);
        result.setErrCode(resultCode);
        
        LOGGER.info("logout result code: " + resultCode);
        LOGGER.info("logout end --->>> ");
        
        return result;
    }
    
    /** 
     * 注册回调事件
     * @param esdkSessionId
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public SDKErrorCode registerNotification(String esdkSessionId, boolean register)
    {
        LOGGER.info("registerNotification start --->>> esdkSessionId: ****************" + esdkSessionId.substring(16)
            + ",register: " + register);
            
        EventCallBackSouth eventCallBackSouth = register ? new EventCallBackSouth()
        {
            @Override
            public synchronized void invoke(int eventType, Pointer eventBuf, int bufSize, Pointer userData)
            {
                callbackEventImpl.callBack(eventType, eventBuf, bufSize, userData);
            }
            
        } : null;
        
        int sessionId = getIVSSessionId();
        UserDataSouth userDataSouth = new UserDataSouth();
        userDataSouth.clear();
        try
        {
            userDataSouth.sessionId = esdkSessionId.getBytes(System.getProperty("file.encoding"));
        }
        catch (UnsupportedEncodingException e)
        {
            SDKErrorCode result = new SDKErrorCode();
            result.setErrCode(ErrInfo.DATA_ERRORCODE);
            return result;
        }
        userDataSouth.write();
        
        if (register)
        {
            
            callbackSouthList.put(String.valueOf(sessionId), eventCallBackSouth);
            userDateSouthList.put(String.valueOf(sessionId), userDataSouth);
            
            if (relativeMap.containsKey(sessionId))
            {
                List<String> relative = relativeMap.get(sessionId);
                if (!relative.contains(esdkSessionId))
                {
                    relative.add(esdkSessionId);
                    relativeMap.put(sessionId, relative);
                }
            }
            else
            {
                List<String> relative = new ArrayList<String>();
                relative.add(esdkSessionId);
                relativeMap.put(sessionId, relative);
            }
        }
        else
        {
            if (callbackSouthList.containsKey(String.valueOf(sessionId)))
            {
                callbackSouthList.remove(String.valueOf(sessionId));
            }
            if (userDateSouthList.containsKey(String.valueOf(sessionId)))
            {
                userDateSouthList.remove(String.valueOf(sessionId));
            }
            deleteSdkSessionInRelative(sessionId, esdkSessionId);
        }
        
        int resultCode = super.getBaseCablilityJNA().IVS_SDK_SetEventCallBack(sessionId,
            eventCallBackSouth,
            userDataSouth.getPointer());
        SDKErrorCode result = new SDKErrorCode();
        result.setErrCode(resultCode);
        LOGGER.info("registerNotification result code: " + resultCode);
        LOGGER.info("registerNotification end --->>> ");
        return result;
    }
    
    /** 
     * 获取SDK的版本号
     * @return 成功返回SDK版本号，高16位表示主版本号，低16位表示次版本号，失败返回负数错误码
     * @see [类、类#方法、类#成员]
     * @since  eSDK IVS V100R003C00
     */
    @Override
    public SDKResult<String> getVersion()
    {
        LOGGER.info("getVersion method start --->>> ");
        
        SDKResult<String> result = new SDKResult<String>();
        int resultCode = super.getBaseCablilityJNA().IVS_SDK_GetVersion();
        
        if (0 > resultCode)
        {
            result.setErrCode(resultCode);
            LOGGER.info("getVersion method result code:" + resultCode);
        }
        else
        {
            result.setErrCode(0);
            result.setResult(commonCapabilityConvert.getVersionSouth2Model(resultCode));
            LOGGER.info("getVersion method result code:" + result.getErrCode());
        }
        LOGGER.info("getVersion method end --->>> ");
        return result;
    }
    
    @Override
    public SDKResult<Integer> passwdValidation(int sessionId, String userName, String password)
    {
        LOGGER.info("passwdValidation start --->>> ");
        
        SDKResult<Integer> result = new SDKResult<Integer>();
        
        int resultCode = super.getBaseCablilityJNA().IVS_SDK_PasswdValidation(sessionId, userName, password);
        result.setErrCode(resultCode);
        
        LOGGER.info("passwdValidation result code: " + resultCode);
        LOGGER.info("passwdValidation end --->>> ");
        
        return result;
    }
    
    /**
     * 根据北向eSdkSessionId获取保存在relativeList中的说sessionId
     * @author  likun/l00295065
     * @param eSdkSessionId
     * @return Integer sessionId
     */
    public static Integer getSessionIdByNorth(String eSdkSessionId)
    {
        Iterator<Entry<Integer, List<String>>> iter = relativeMap.entrySet().iterator();
        while (iter.hasNext())
        {
            Entry<Integer, List<String>> entry = (Entry<Integer, List<String>>)iter.next();
            List<String> relative = entry.getValue();
            if (relative.contains(eSdkSessionId))
            {
                return entry.getKey();
            }
        }
        return -1;
    }
    
    /**
     * 删除relativeMap中sessionId对应的relativeList中的esdkSessionId
     * @author  likun/l00295065
     * @parameter sessionId
     * @param esdkSessionId
     */
    public static void deleteSdkSessionInRelative(int sessionId, String esdkSessionId)
    {
        if (relativeMap.containsKey(sessionId))
        {
            List<String> relative = relativeMap.get(sessionId);
            if (null != relative && 0 != relative.size())
            {
                if (relative.contains(esdkSessionId))
                {
                    relative.remove(esdkSessionId);
                    if (0 == relative.size())
                    {
                        relativeMap.remove(sessionId);
                    }
                }
            }
            else
            {
                relativeMap.remove(sessionId);
            }
        }
    }
    
}
