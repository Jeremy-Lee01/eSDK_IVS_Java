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
import com.huawei.esdk.demo.gen.GetDeviceList;
import com.huawei.esdk.demo.gen.GetDeviceListResponse;
import com.huawei.esdk.demo.gen.IVSProfessionalCommon;
import com.huawei.esdk.demo.gen.IVSProfessionalDeviceManager;
import com.huawei.esdk.demo.gen.IndexRange;
import com.huawei.esdk.demo.gen.Login;
import com.huawei.esdk.demo.gen.LoginResponse;
import com.huawei.esdk.demo.gen.Logout;
import com.huawei.esdk.demo.gen.LogoutResponse;
import com.huawei.esdk.demo.keygen.GetPublicKey;
import com.huawei.esdk.demo.keygen.GetPublicKeyResponse;
import com.huawei.esdk.demo.keygen.PlatformKeyMgr;
import com.huawei.esdk.demo.keygen.SetSecretKey;
import com.huawei.esdk.demo.keygen.SetSecretKeyResponse;
import com.huawei.esdk.demo.utils.AES128Utils;
import com.huawei.esdk.demo.utils.Base64Utils;
import com.huawei.esdk.demo.utils.ClientProvider;
import com.huawei.esdk.demo.utils.PropertiesUtils;
import com.huawei.esdk.demo.utils.RSA2048Utils;

/**
 * 设备模块处理类
 * 获取子设备列表接口
 * 
 * @author  xxxxxx
 * @see  [无]
 * @since  [eSDK IVS V100R003C00]
 */
public class DeviceServlet extends HttpServlet
{
    /**
     * 序列号
     */
    private static final long serialVersionUID = -1586272300179601609L;
    
    /**
     * log日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(DeviceServlet.class);
    
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
     * 设备管理soap客户端
     */
    private IVSProfessionalDeviceManager ivsProfessionalDeviceManager =
        (IVSProfessionalDeviceManager)ClientProvider.getClient(IVSProfessionalDeviceManager.class);
    
    /**
     * 登录访问soap客户端
     */
    private IVSProfessionalCommon ivsProfessionalCommon =
        (IVSProfessionalCommon)ClientProvider.getClient(IVSProfessionalCommon.class);
    
    /**
     * 密钥协商
     */
    private PlatformKeyMgr platformKeyMgr = (PlatformKeyMgr)ClientProvider.getClient(PlatformKeyMgr.class);
    
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
        
        if ("getDeviceList".equals(methodName))
        {
            // 获取子设备列表
            resp = getDeviceList(request);
        }
        
        // 输出流
        PrintWriter pw = response.getWriter();
        pw.print(resp);
        pw.close();
    }
    
    /** 
     * 获取子设备列表(SOAP方式调用)
     * 
     * @param request HttpServletRequest对象
     * @return json格式的字符串
     * @see [无]
     * @since  [eSDK IVS V100R003C00]
     */
    public String getDeviceList(HttpServletRequest request)
    {
        // 定义返回结果
        String response = null;
        
        try
        {
            int resultCode = 0;
            
            // 获取公钥。后面使用公钥来加密工作密钥和初始向量
            GetPublicKey publicKeyParam = new GetPublicKey();
            publicKeyParam.setSecretType("RSA2048");
            GetPublicKeyResponse publicKeyResponse = platformKeyMgr.getPublicKey(publicKeyParam);
            resultCode = publicKeyResponse.getResultCode();
            if (0 != resultCode)
            {
                LOGGER.info("Get deviceList failed due to getPublicKey failed, errorCode is : " + resultCode);
                response = gson.toJson(resultCode);
                return response;
            }
            RSA2048Utils.setPublicKey(publicKeyResponse.getPublicKey());
            
            // 密钥协商
            byte[] secretKey = AES128Utils.getBT_KEY();
            byte[] iv = AES128Utils.getBT_IV();
            // 使用公钥来加密工作密钥和初始向量
            String secretKeyStr = Base64Utils.encode(RSA2048Utils.encode(AES128Utils.byte2Hex(secretKey).getBytes("UTF-8")));
            String ivStr = Base64Utils.encode(RSA2048Utils.encode(AES128Utils.byte2Hex(iv).getBytes("UTF-8")));
            
            SetSecretKey setSecretKeyParam = new SetSecretKey();
            setSecretKeyParam.setSecretType("AES128");
            setSecretKeyParam.setSecretKey(secretKeyStr);
            setSecretKeyParam.setIv(ivStr);
            SetSecretKeyResponse setSecretKeyResponse = platformKeyMgr.setSecretKey(setSecretKeyParam);
            resultCode = setSecretKeyResponse.getResultCode();
            if (0 != resultCode)
            {
                LOGGER.info("Get deviceList failed due to setSecretKey failed, errorCode is : " + resultCode);
                response = gson.toJson(resultCode);
                return response;
            }
            
            // 拼装登录接口入参
            Login loginParam = new Login();
            loginParam.setUserName(userName);
            loginParam.setPassword(AES128Utils.encryptPwd(password));
            LoginResponse loginResponse = new LoginResponse();
            
            // 调用登录接口
            loginResponse = ivsProfessionalCommon.login(loginParam);
            
            // 登录失败，返回给页面
            resultCode = loginResponse.getResultCode();
            if (0 != resultCode)
            {
                LOGGER.info("Get deviceList failed due to login failed, errorCode is : " + resultCode);
                response = gson.toJson(resultCode);
                return response;
            }
            
            LOGGER.info("Begin to getDeviceList");
            
            // 获取页面参数
            int deviceType = Integer.parseInt(request.getParameter("deviceType"));
            int fromIndex = Integer.parseInt(request.getParameter("fromIndex"));
            int toIndex = Integer.parseInt(request.getParameter("toIndex"));
            
            // 拼装分页对象
            IndexRange indexRange = new IndexRange();
            indexRange.setFromIndex(fromIndex);
            indexRange.setToIndex(toIndex);
            
            // 拼装查询设备列表入参
            GetDeviceList parameters = new GetDeviceList();
            parameters.setDeviceType(deviceType);
            parameters.setIndexRange(indexRange);
            GetDeviceListResponse getDeviceListResponse = new GetDeviceListResponse();
            
            // 调用获取子设备列表接口，indexRange为封装的分页对象，deviceType为int型，只能传入2、3、4
            getDeviceListResponse = ivsProfessionalDeviceManager.getDeviceList(parameters);
            
            // 用户登出
            Logout logoutParam = new Logout();
            LogoutResponse logoutResponse = ivsProfessionalCommon.logout(logoutParam);
            
            resultCode = logoutResponse.getResultCode();
            if (0 != resultCode)
            {
                LOGGER.info("Get deviceList failed due to logout failed, errorCode is : " + resultCode);
                response = gson.toJson(resultCode);
                return response;
            }
            
            // 登出成功后，根据接口返回数据生成JSON字符串
            response = gson.toJson(getDeviceListResponse);
            LOGGER.info("Finish to getDeviceList, response is : " + response);
            
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
