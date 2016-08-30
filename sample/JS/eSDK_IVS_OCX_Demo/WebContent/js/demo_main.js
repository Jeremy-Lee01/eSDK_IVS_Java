/**
 * 初始化
 */
function init()
{
	var userName = "ivsCommon";
	var password = "huawei.123";
	var serverAddr = "172.22.8.102";
	var serverPort = "9900";
	var result;
	
	result = setInit();
	
	if (result == 0)
	{
		result = setLogin(userName, password, serverAddr, serverPort);
		
		if (result == 0)
		{
			ocx.IVS_OCX_SetWndLayout(11);
			
			ocx.IVS_OCX_ShowTitlebar(0);
			
			getLivePlay();
		}
		else
		{
			alert("登录失败 : " + result);
		}
	}
	else
	{
		alert("初始化失败 : " + result);
	}
}

/**
 * 退出时使用中断，防止OCX卸载异常，造成浏览器崩溃
 * 
 */
function closeSession()
{
	if (ocx)
	{
		try
		{
			event.returnValue = alert(langs[lang]["exitDemo"]);
			logout();
		}
		catch (e)
		{
		}
	}
}

/**
 * 退出界面关闭所有资源
 * Release Ocx Object
 */
function logout()
{
	try
	{
		ocx.IVS_OCX_StopAllRealPlay();
		ocx.IVS_OCX_Logout();
		ocx.IVS_OCX_CleanUp();
		ocx = null;
		$("#ocx").remove();
	} 
	catch (e)
	{
	}
}
