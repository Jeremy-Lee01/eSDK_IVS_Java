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
import com.huawei.esdk.ivs.professional.local.service.bussinessmanager.BusinessManagerServiceEx;
import com.huawei.esdk.ivs.professional.local.service.common.CommonServiceEx;

public class PlatformRecord extends HttpServlet {

	public static final Logger log = Logger.getLogger(PlatformRecord.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * gson，用于转换String和json之间的转换
	 */
	private static final Gson GSON = new Gson();

	public static CommonServiceEx commonServiceEx = ServiceFactoryEx.getService(CommonServiceEx.class);
	public static BusinessManagerServiceEx businessManagerServiceEx = ServiceFactoryEx
			.getService(BusinessManagerServiceEx.class);

	public Integer login() {
		String userName = "admin";
		String pwd = "Huawei@123";
		return commonServiceEx.login(userName, pwd);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IVSSDKResponse<Integer> result = new IVSSDKResponse<Integer>();

		Integer resultCode = login();

		if (0 == resultCode) {
			String buttonType = req.getParameter("buttonType");
			String cameraCode = req.getParameter("cameraCode");
			if ("1".equals(buttonType)) {
				Integer recordTime = Integer.valueOf(req.getParameter("recordTime"));
				result.setResultCode(businessManagerServiceEx.startPlatformRecord(cameraCode, recordTime));
			} else {
				result.setResultCode(businessManagerServiceEx.stopPlatformRecord(cameraCode));
			}
		} else {
			result.setResultCode(-1);
		}

		resp.getWriter().print(GSON.toJson(result));
		commonServiceEx.logout();
	}

}
