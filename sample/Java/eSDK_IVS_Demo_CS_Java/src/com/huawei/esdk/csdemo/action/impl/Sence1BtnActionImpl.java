package com.huawei.esdk.csdemo.action.impl;

import com.huawei.esdk.csdemo.action.DemoAction;
import com.huawei.esdk.csdemo.common.DemoException;
import com.huawei.esdk.csdemo.common.PropertiesUtils;
import com.huawei.esdk.csdemo.common.ServiceFactory;
import com.huawei.esdk.csdemo.convert.Sence1Convert;
import com.huawei.esdk.ivs.professional.local.bean.GetDeviceListResponse;
import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.professional.local.bean.IndexRange;
import com.huawei.esdk.ivs.professional.local.service.common.CommonServiceEx;
import com.huawei.esdk.ivs.professional.local.service.devicemanager.DeviceManagerServiceEx;

public class Sence1BtnActionImpl implements DemoAction
{
    @Override
    public void executeNativeMethod()
    {
        //初始化公共服务 ，该服务中包含login，logout等接口
        CommonServiceEx commonService = ServiceFactory.getInstance().getCommonServiceEx();
        
        //初始化告警管理服务，该服务中包含告警管理的相关接口
        DeviceManagerServiceEx deviceManagerService = ServiceFactory.getInstance().getDeviceManagerServiceEx();
        
        //登录成功后才能调用其他接口
        int loginErrorCode = commonService.login(PropertiesUtils.getValue("userName"), 
            PropertiesUtils.getValue("password"));
        if(0 != loginErrorCode)
        {
            Sence1Convert.loginFailInGetDeviceListFrame(loginErrorCode);
            return;
        }
        
        //设置入参
        StringBuffer deviceType = new StringBuffer();
        IndexRange indexRange = new IndexRange();
        
        //从面板中拿到所有参数
        try
        {
            Sence1Convert.getParametersFromFrame(deviceType, indexRange);
        }
        catch (DemoException e)
        {
            //界面上输入参数类型错误时，显示错误信息
            Sence1Convert.showConvertErrInfo(e.getErrInfo());
            return;
        }
 
        //调用getAlarmEventInfo native接口。
        //返回查询结果，result包含错误码及查询信息
        IVSSDKResponse<GetDeviceListResponse> result = deviceManagerService.getDeviceList(Integer.parseInt(deviceType.toString()),
            indexRange);
        
        //把返回结果渲染到面板中
        result.getResult().setResultCode(result.getResultCode());
        Sence1Convert.showResultInFrame(result.getResult());

        commonService.logout();
    }
}
