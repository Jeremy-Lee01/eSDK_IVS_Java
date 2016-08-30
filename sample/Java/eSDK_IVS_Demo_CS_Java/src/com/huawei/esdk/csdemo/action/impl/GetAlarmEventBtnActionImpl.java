package com.huawei.esdk.csdemo.action.impl;

import com.huawei.esdk.csdemo.action.DemoAction;
import com.huawei.esdk.csdemo.common.DemoException;
import com.huawei.esdk.csdemo.common.PropertiesUtils;
import com.huawei.esdk.csdemo.common.ServiceFactory;
import com.huawei.esdk.csdemo.convert.AlarmManagerConvert;
import com.huawei.esdk.ivs.professional.local.bean.AlarmEvent;
import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.professional.local.service.alarmmanager.AlarmManagerServiceEx;
import com.huawei.esdk.ivs.professional.local.service.common.CommonServiceEx;

public class GetAlarmEventBtnActionImpl implements DemoAction
{
    
    @Override
    public void executeNativeMethod()
    {
        //初始化公共服务 ，该服务中包含login，logout等接口
        CommonServiceEx commonService = ServiceFactory.getInstance().getCommonServiceEx();
        
        //初始化告警管理服务，该服务中包含告警管理的相关接口
        AlarmManagerServiceEx alarmManagerService = ServiceFactory.getInstance().getAlarmManagerServiceEx();
        
        //登录成功后才能调用其他接口
        int loginErrorCode =
            commonService.login(PropertiesUtils.getValue("userName"), PropertiesUtils.getValue("password"));
        if (0 != loginErrorCode)
        {
            AlarmManagerConvert.loginFailInGetAlarmEventFrame(loginErrorCode);
            return;
        }
        
        //设置入参
        StringBuffer alarmEventId = new StringBuffer();
        StringBuffer alarmInCode = new StringBuffer();

        //从面板中拿到所有参数
        try
        {
            AlarmManagerConvert.getParametersFromGetAlarmEventFrame(alarmEventId, alarmInCode);
        }
        catch (DemoException e)
        {
            //界面上输入参数类型错误时，显示错误信息
            AlarmManagerConvert.showGetAlarmEventConvertErrInfo(e.getErrInfo());
            return;
        }
        
        //调用getAlarmEventInfo native接口。
        //返回查询结果，result包含错误码及查询信息
        IVSSDKResponse<AlarmEvent> result =
            alarmManagerService.getAlarmEventInfo(Long.parseLong(alarmEventId.toString()), alarmInCode.toString());
        
        //把返回结果渲染到面板中
        AlarmManagerConvert.showResultInGetAlarmEventFrame(result);
        
        commonService.logout();
    }
}
