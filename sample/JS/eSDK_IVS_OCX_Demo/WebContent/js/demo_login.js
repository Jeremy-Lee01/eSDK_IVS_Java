/**
 * 初始化OCX控件
 */
function setInit()
{
	var result;
	if (ocx)
	{
		result = ocx.IVS_OCX_Init();
		
		// 设置OCX界面色调： "1"为黑色(暗色调) ，"2"为白色(亮色调)
		ocx.IVS_OCX_SetSkin(1);
		ocx.IVS_OCX_SetLanguage("zh-CN");
	}
	
	return result;
}

/**
 * 清理OCX控件  
 */
function setCleanUp()
{
	if (ocx)
	{
		// 清理OCX前，可以先调用用户注销方法
		var result = ocx.IVS_OCX_Logout();
		result = ocx.IVS_OCX_CleanUp();
	}
}

/**
 * 用户登录
 */
function setLogin(user, password, ip, port)
{
	var result;
	if (ocx)
	{
		result = ocx.IVS_OCX_Login(user, password, ip, port, 1);
	}
	return result;
}

/**
 * 用户注销
 */
function setLogout()
{
	if (ocx)
	{
		ocx.IVS_OCX_Logout();
	}
}