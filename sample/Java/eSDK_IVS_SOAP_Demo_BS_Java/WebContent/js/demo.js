var number = /^[0-9]*$/;

//添加用户
function addUser()
{
	var domainCode = $("#domainCode").val();
	
	var isFirstLogin = $("#isFirstLogin").val();
	if(!number.test(isFirstLogin) || isFirstLogin == ""){
		alert("请输入数字:isFirstLogin");
		return;
	}
	var roleId = $("#roleId").val();
	if(!number.test(roleId) || roleId == ""){
		alert("请输入数字:roleId");
		return;
	}
	var groupId = $("#groupId").val();
	if(!number.test(groupId) || groupId == ""){
		alert("请输入数字:groupId");
		return;
	}
	var loginName = $("#loginName").val();
	var password = $("#password").val();
	var pwdModifyDate = $("#pwdModifyDate").val();
	
	var userType = $("#userType").val();
	if(!number.test(userType) || userType == ""){
		alert("请输入数字:userType");
		return;
	}
	var userDomain = $("#userDomain").val();
	var status = $("#status").val();
	if(!number.test(status) || status == ""){
		alert("请输入数字:status");
		return;
	}
	var registerDate = $("#registerDate").val();
	var userDesc = $("#userDesc").val();
	var ptzLevel = $("#ptzLevel").val();
	if(!number.test(ptzLevel) || ptzLevel == ""){
		alert("请输入数字:ptzLevel");
		return;
	}
	var maxSessionCount = $("#maxSessionCount").val();
	if(!number.test(maxSessionCount) || maxSessionCount == ""){
		alert("请输入数字:maxSessionCount");
		return;
	}
	var maxVideoCount = $("#maxVideoCount").val();
	if(!number.test(maxVideoCount) || maxVideoCount == ""){
		alert("请输入数字:maxVideoCount");
		return;
	}
	var lockTime = $("#lockTime").val();
	var userName = $("#userName").val();
	var phone = $("#phone").val();
	var sex = $("#sex").val();
	if(!number.test(sex) || sex == ""){
		alert("请输入数字:sex");
		return;
	}
	var validDateFlag = $("#validDateFlag").val();
	if(!number.test(validDateFlag) || validDateFlag == ""){
		alert("请输入数字:validDateFlag");
		return;
	}
	var reserve = $("#reserve").val();
	var mail = $("#mail").val();
	
	$.ajax({
		url :"/eSDK_IVS_SOAP_Demo_BS_Java/addUser",
		type : "post",
		dataType : "json",
		data : "domainCode=" + domainCode + "&mail=" + mail + "&groupId=" + groupId + "&isFirstLogin=" + isFirstLogin + "&lockTime=" + lockTime
		+ "&loginName=" + loginName + "&maxSessionCount=" + maxSessionCount + "&maxVideoCount=" + maxVideoCount + "&password=" + password
		+ "&phone=" + phone + "&ptzLevel=" + ptzLevel + "&pwdModifyDate=" + pwdModifyDate + "&registerDate=" + registerDate + "&roleId=" + roleId
		+ "&sex=" + sex + "&status=" + status + "&userDesc=" + userDesc + "&userDomain=" + userDomain + "&userName=" + userName + "&userType=" + userType
		+ "&reserve=" + reserve + "&validDateFlag=" + validDateFlag,
		async : false,
		success : function(data)
		{	// 登录登出异常
			if(-1 == data.resultCode)
			{
				alert("鉴权失败！");
			}
			else
			{
				var jsonText = JSON.stringify(data);
				document.getElementById('addUserTextarea').innerHTML = jsonText;
			}
		},
	    error : function(data)
	    {
	    	alert("操作失败！！");	
	    }
	});

	
}

//设备管理：获取子设备列表
function getDeviceList()
{
	var deviceType = $("#deviceType").val();
	var fromIndex = $("#fromIndex").val();
	if(!number.test(fromIndex) || fromIndex==""){
		alert("请输入数字:fromIndex");
		return;
	}
	var toIndex = $("#toIndex").val();
	if(!number.test(toIndex) || toIndex==""){
		alert("请输入数字:toIndex");
		return;
	}
	
	$.ajax({
		url :"/eSDK_IVS_SOAP_Demo_BS_Java/getDeviceList",
		type : "post",
		dataType : "json",
		data : "deviceType=" + deviceType + "&fromIndex=" + fromIndex + "&toIndex=" + toIndex,
		async : false,
		success : function(data)
		{	
			// 登录登出异常
			if(-1 == data.resultCode)
			{
				alert("鉴权失败！");
			}
			else
			{
				var jsonText = JSON.stringify(data);
				document.getElementById('getDeviceListTextarea').innerHTML = jsonText;
			}
		},
	    error : function(data)
	    {
	    	alert("操作失败！");	
	    }
	});
}

//录像管理接口：开始平台录像、停止平台录像
function platformRecord()
{
	var buttonType;
	var cameraCode = $("#cameraCode").val();
	var recordTime = $("#recordTime").val();
	if(document.getElementById('start').checked == true){
		buttonType= document.getElementById('start').value;
		if(!number.test(recordTime) || recordTime == ""){
			alert("请输入数字:recordTime");
			return;
		}
	}else{
		buttonType= document.getElementById('stop').value;
	}
	
	$.ajax({
		url :"/eSDK_IVS_SOAP_Demo_BS_Java/platformRecord",
		type : "post",
		dataType : "json",
		data : "buttonType=" + buttonType + "&cameraCode=" + cameraCode + "&recordTime=" + recordTime,
		async : false,
		success : function(data)
		{	
			// 登录登出异常
			if(-1 == data.resultCode)
			{
				alert("鉴权失败！");
			}
			else
			{
				var jsonText = JSON.stringify(data);
				document.getElementById('platTextarea').innerHTML = jsonText;
			}
		},
	    error : function(data)
	    {
	    	alert("操作失败！");	
	    }
	});
}