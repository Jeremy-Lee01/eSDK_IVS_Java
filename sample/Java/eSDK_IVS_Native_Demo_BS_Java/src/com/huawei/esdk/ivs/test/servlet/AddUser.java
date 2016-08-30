package com.huawei.esdk.ivs.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.huawei.esdk.ivs.professional.local.ServiceFactoryEx;
import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.professional.local.bean.UserInfo;
import com.huawei.esdk.ivs.professional.local.service.common.CommonServiceEx;
import com.huawei.esdk.ivs.professional.local.service.usermanager.UserManagerServiceEx;

public class AddUser extends HttpServlet {

	public static final Logger log = Logger.getLogger(AddUser.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * gson，用于转换String和json之间的转换
	 */
	private static final Gson GSON = new Gson();

	public static CommonServiceEx commonServiceEx = ServiceFactoryEx.getService(CommonServiceEx.class);
	public static UserManagerServiceEx userManagerServiceEx = ServiceFactoryEx.getService(UserManagerServiceEx.class);

	public Integer login() {
		String userName = "admin";
		String pwd = "Huawei@123";
		return commonServiceEx.login(userName, pwd);
	}

	public UserInfo addUser(HttpServletRequest req) {
		UserInfo userInfo = new UserInfo();
		userInfo.setDomainCode(req.getParameter("domainCode"));
		userInfo.setMail(req.getParameter("mail"));
		userInfo.setGroupId(Integer.valueOf(req.getParameter("groupId")));
		userInfo.setIsFirstLogin(Integer.valueOf(req.getParameter("isFirstLogin")));
		userInfo.setLockTime(req.getParameter("lockTime"));
		userInfo.setLoginName(req.getParameter("loginName"));
		userInfo.setMaxSessionCount(Integer.valueOf(req.getParameter("maxSessionCount")));
		userInfo.setMaxVideoCount(Integer.valueOf(req.getParameter("maxVideoCount")));
		userInfo.setPassword(req.getParameter("password"));
		userInfo.setPhone(req.getParameter("phone"));
		userInfo.setPtzLevel(Integer.valueOf(req.getParameter("ptzLevel")));
		userInfo.setPwdModifyDate(req.getParameter("pwdModifyDate"));
		userInfo.setRegisterDate(req.getParameter("registerDate"));
		userInfo.setReserve(req.getParameter("reserve"));
		userInfo.setRoleId(Integer.valueOf(req.getParameter("roleId")));
		userInfo.setSex(Integer.valueOf(req.getParameter("sex")));
		userInfo.setStatus(Integer.valueOf(req.getParameter("status")));
		userInfo.setUserDesc(req.getParameter("userDesc"));
		userInfo.setUserDomain(req.getParameter("userDomain"));
		userInfo.setUserName(req.getParameter("userName"));
		userInfo.setUserType(Integer.valueOf(req.getParameter("userType")));
		userInfo.setValidDateFlag(Integer.valueOf(req.getParameter("validDateFlag")));
		return userInfo;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer resultCode = login();
		IVSSDKResponse<Integer> result = new IVSSDKResponse<Integer>();
		if (0 == resultCode) {
			UserInfo userInfo = addUser(req);
			result = userManagerServiceEx.addUser(userInfo);

		} else {
			result.setResultCode(-1);
		}

		resp.getWriter().print(GSON.toJson(result));
		commonServiceEx.logout();
	}

}
