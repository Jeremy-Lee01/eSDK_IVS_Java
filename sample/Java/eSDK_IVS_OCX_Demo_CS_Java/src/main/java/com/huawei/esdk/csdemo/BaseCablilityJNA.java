package com.huawei.esdk.csdemo;

import com.huawei.esdk.csdemo.model.IndexRange;
import com.huawei.esdk.csdemo.model.LoginInfo;
import com.huawei.esdk.csdemo.model.RealplayParam;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.ByReference;

/**
 * 告警JNA底层库调用管理接口
 * <p>
 * @author  likun/l00295065
 * @see  [相关类/方法]
 * @since  eSDK IVS V100R005C30
 */
public interface BaseCablilityJNA extends Library
{
    
    BaseCablilityJNA INSTANCE = (BaseCablilityJNA)Native.loadLibrary("dll/IVS_SDK", BaseCablilityJNA.class);
        
    int IVS_SDK_Init();
    
    int IVS_SDK_Cleanup();
    
    int IVS_SDK_Login(LoginInfo loginInfo, ByReference pSessionId);
    
    int IVS_SDK_Logout(int sessionId);
    
    /** 
    * 获取设备列表（摄像机、音频、告警设备）
    * 目前支持获取摄像机、语音和告警设置列表获取
    *
    * @param iSessionID[in] 登录成功后的会话ID
    * @param uiDeviceType[in] 设备类型
    * @param pIndexRange[in] 分页信息
    * @param pDeviceList[out] 设备列表指针
    * @param uiBufferSize[in] 缓存大小
    * @return 成功  0/失败，参见错误码
    * @attention 无
    * @par 示例
    * @code
    * <示例代码(示例代码如果添加注释,请使用//)>
    * @endcode 
    * @since <V100R003>
    */
    int IVS_SDK_GetDeviceList(int iSessionID, int uiDeviceType, IndexRange indexRange, Pointer pDeviceList,
        int uiBufferSize);
        
    /** 
     * 开始实况浏览
     *
     * @param sessionId 登录成功后的会话ID
     * @param realplayParam 实况浏览媒体参数
     * @param cameraCode 摄像机编码
     * @param hWnd 窗口句柄
     * @param handle 播放句柄
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R005C30]
     */
    int IVS_SDK_StartRealPlay(int sessionId, RealplayParam realplayParam, byte[] cameraCode, HWND hWnd,
        ByReference handle);
        
    /** 
     * 停止实况浏览
     *
     * @param sessionId 登录成功后的会话ID
     * @param handle 播放句柄
     * @return 成功  0/失败，参见错误码
     * @attention <无>
     * @par 示例
     * @code
     * 
     * @endcode
     * @see \ref function1Example | fuction2Example
     * @since [eSDK IVS V100R005C30]
     */
    int IVS_SDK_StopRealPlay(int sessionId, NativeLong handle);
    
    /******************************************************************
    function      : IVS_SDK_PtzControl
    description   : 云镜控制
    input         : iSessionID    登录成功后的会话ID
                        cameraCode   摄像机编码
                        controlCode  云台控制码，值参考IVS_PTZ_CODE
                        controlPara1 参数1
                        controlPara2 参数2
    output            : lockStatus   云台锁定状态：0-解锁，1-锁定
    return            : 成功返回0（IVS_SUCCEED）；失败返回错误码
    *******************************************************************/
    int IVS_SDK_PtzControl(int iSessionID, byte[] cameraCode, int controlCode, String pControlPara1,
        String pControlPara2, ByReference lockStatus);
}
