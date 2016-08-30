package com.huawei.esdk.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.huawei.esdk.demo.factory.ServiceFactory;
import com.huawei.esdk.demo.utils.PropertiesUtils;
import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;

/**
 * 告警模块处理类
 * 查询告警事件信息、告警订阅接口
 * 
 * @author  xxxxxx
 * @see  [无]
 * @since  [eSDK IVS V100R003C00]
 */
public class AlarmServlet extends HttpServlet
{
    /**
     * 序列号
     */
    private static final long serialVersionUID = 6749720431926648350L;
    
    /**
     * log日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(AlarmServlet.class);
    
    /**
     * 登录用户
     */
    private static String userName;
    
    /**
     * 登录密码，明文
     */
    private static String password;
    
    /**
     * gson，用于转换String和json之间的转换
     */
    private Gson gson = new Gson();
    
    /**
     * 从esdk_ivs_config.properties中读取用户名和密码
     */
    static
    {
        userName = PropertiesUtils.getValue("userName");
        password = PropertiesUtils.getValue("password");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        // 获取需要调用的方法名
        String methodName = request.getParameter("method");
        String resp = "";
        
        if ("getAlarmEventInfo".equals(methodName))
        {
            // 获取告警事件信息
            resp = getAlarmEventInfo(request);
        }
        else if ("subscribeAlarm".equals(methodName))
        {
            // 告警订阅
            resp = subscribeAlarm(request);
        }
        
        // 输出流
        PrintWriter pw = response.getWriter();
        pw.print(resp);
        pw.close();
    }
    
    /** 
    * 查询告警事件信息
    * 
    * @param request HttpServletRequest对象
    * @return json格式的字符串
    * @see [无]
    * @since  [eSDK IVS V100R003C00]
    */
    public String getAlarmEventInfo(HttpServletRequest request)
    {
        // 定义返回结果
        String response = null;
        try
        { 
        
        // 用户登录
        Integer loginResult = ServiceFactory.getCommonServiceEx().login(userName, password);
        
        // 登录失败，返回给页面
        if (0 != loginResult)
        {
            LOGGER.info("Get AlarmEventInfo failed due to login failed, errorCode is : " + loginResult);
            response = gson.toJson(loginResult);
            return response;
        }
        
        LOGGER.info("Begin to getAlarmEventInfo");
        
        // 获取输入参数
        Long alarmEventId = Long.parseLong(request.getParameter("alarmEventId"));
        String alarmInCode = request.getParameter("alarmInCode");
        
        // 调用接口获取告警事件信息，alarmEventId必须为long型，alarmInCode必须为String
        IVSSDKResponse<?> ivssdkResponse =
            ServiceFactory.getAlarmManagerServiceEx().getAlarmEventInfo(alarmEventId, alarmInCode);
        
        // 根据接口返回数据生成JSON字符串，以便于页面展示
        response = gson.toJson(ivssdkResponse);
        LOGGER.info("Finish to getAlarmEventInfo, response is : " + response);
        
        // 用户登出
        ServiceFactory.getCommonServiceEx().logout();
        }
        catch (SOAPFaultException e)
        {
            LOGGER.error("Get deviceList failed due to soap fault");
          
            // SDK内部服务错误
            return gson.toJson(2130000010);
        }
        catch (Exception e)
        {
            LOGGER.error("Get deviceList failed due to soap fault");
            
            // SDK内部服务错误
            return gson.toJson(2130000010);
        } 
            
        return response;
    }
    
    /** 
    * 订阅告警
    * 
    * @param request HttpServletRequest对象
    * @return json格式的字符串
    * @see [无]
    * @since  [eSDK IVS V100R003C00]
    */
    public String subscribeAlarm(HttpServletRequest request)
    {
        // 定义返回结果
        String response = null;
       
        try
        { 
            // 用户登录
            Integer loginResult = ServiceFactory.getCommonServiceEx().login(userName, password);
            
            // 登录失败，返回给页面
            if (0 != loginResult)
            {
                LOGGER.info("Subscribe alarm failed due to login failed, errorCode is : " + loginResult);
                response = gson.toJson(loginResult);
                return response;
            }
            
            LOGGER.info("Begin to subscribeAlarm");
            
            // 获取订阅告警xml消息字符串
            String subscribeAlarmReq = request.getParameter("subscribeAlarmReq");
            
            // 调用订阅告警接口，subscribeAlarmReq为String类型，将xmlString透传即可
            int result = ServiceFactory.getAlarmManagerServiceEx().subscribeAlarm(subscribeAlarmReq);
            
            // 根据接口返回数据生成JSON字符串，以便于页面展示
            response = gson.toJson(result);
            LOGGER.info("Finish to subscribeAlarm, response is : " + response);
            
            // 用户登出
            ServiceFactory.getCommonServiceEx().logout();
        }
        catch (SOAPFaultException e)
        {
            LOGGER.error("Get deviceList failed due to soap fault");
          
            // SDK内部服务错误
            return gson.toJson(2130000010);
        }
        catch (Exception e)
        {
            LOGGER.error("Get deviceList failed due to soap fault");
            
            // SDK内部服务错误
            return gson.toJson(2130000010);
        }  
        return response;
    }
    
}
