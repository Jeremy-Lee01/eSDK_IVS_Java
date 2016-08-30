package com.huawei.esdk.ivs.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.huawei.esdk.ivs.professional.local.ServiceFactoryEx;
import com.huawei.esdk.ivs.professional.local.bean.GetDeviceListResponse;
import com.huawei.esdk.ivs.professional.local.bean.IVSSDKResponse;
import com.huawei.esdk.ivs.professional.local.bean.IndexRange;
import com.huawei.esdk.ivs.professional.local.service.common.CommonServiceEx;
import com.huawei.esdk.ivs.professional.local.service.devicemanager.DeviceManagerServiceEx;

public class GetDeviceList extends HttpServlet {

	public static final Logger log = Logger.getLogger(GetDeviceList.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * gson，用于转换String和json之间的转换
	 */
	private static final Gson GSON = new Gson();

	public static CommonServiceEx commonServiceEx = ServiceFactoryEx.getService(CommonServiceEx.class);
	public static DeviceManagerServiceEx deviceManagerServiceEx = ServiceFactoryEx
			.getService(DeviceManagerServiceEx.class);

	public Integer login() {
		String userName = "admin";
		String pwd = "Huawei@123";
		return commonServiceEx.login(userName, pwd);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IVSSDKResponse<GetDeviceListResponse> result = new IVSSDKResponse<GetDeviceListResponse>();

		Integer resultCode = login();

		if (0 == resultCode) {
			Integer deviceType = Integer.valueOf(req.getParameter("deviceType"));

			IndexRange indexRange = new IndexRange();
			indexRange.setFromIndex(Integer.valueOf(req.getParameter("fromIndex")));
			indexRange.setToIndex(Integer.valueOf(req.getParameter("toIndex")));

			result = deviceManagerServiceEx.getDeviceList(deviceType, indexRange);
		} else {
			result.setResultCode(-1);
		}

		resp.getWriter().print(GSON.toJson(result));
		commonServiceEx.logout();
	}

}
