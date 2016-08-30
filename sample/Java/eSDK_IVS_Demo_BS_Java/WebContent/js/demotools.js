function getServerPath()
{
	var url = window.document.location.pathname;
	return url.substring(0,url.substr(1).indexOf('/') + 1);
}

function changeLang()
{
	lang = $("#changeLang").val();
	
	if (lang == "en-us")
	{
		controller = new LanguageControllerEN();
	}
	else
	{
		controller = new LanguageControllerZH();
	}
	
	// 自动切换所有的label
	var arrayOfLabel;        
	if (document.all || document.getElementById)
	{            
		arrayOfLabel = document.getElementsByTagName("label");        
	}
	
	for(var i=0;i<arrayOfLabel.length;i++)    
	{   
		var labelId = arrayOfLabel[i].id;
		if(labelId!="" && labelId.indexOf("Tree") == -1)
		{
			document.getElementById(labelId).innerHTML=controller.language.titles[labelId];
		}
	}
	
	// 自动切换所有span
	var arrayOfSpan;        
	if (document.all || document.getElementById)
	{            
		arrayOfSpan = document.getElementsByTagName("span");        
	}
	
	for(var i=0;i<arrayOfSpan.length;i++)    
	{   
		var spanId = arrayOfSpan[i].id;
		if(spanId!="" && spanId.indexOf("Tree") == -1)
		{
			document.getElementById(spanId).innerHTML=controller.language.titles[spanId];
		}
	}
	
	// 自动切换所有li
	var arrayOfli;        
	if (document.all || document.getElementById)
	{            
		arrayOfli = document.getElementsByTagName("li");        
	}
	
	for(var i=0;i<arrayOfli.length;i++)    
	{   
		var liId = arrayOfli[i].id;
		if(liId!="" && liId.indexOf("Tree") == -1)
		{
			document.getElementById(liId).innerHTML=controller.language.titles[liId];
		}
	}
	
	// 自动切换所有button
	var arrayOfButton;        
	if (document.all || document.getElementById)
	{            
		arrayOfButton = document.getElementsByTagName("input");        
	}
	
	for(var i=0;i<arrayOfButton.length;i++)    
	{   
		var buttonId = arrayOfButton[i].id;
		if(buttonId!="" && buttonId.indexOf("Btn") > 0)
		{
			document.getElementById(buttonId).value=controller.language.buttons[buttonId];
		}
	}
	
	// zTree加载时自动生成ID，这边得特殊处理
	if (exist('ivsTree_1_span')) $("#ivsTree_1_span").html(controller.language.titles["ivsTree_1_span"]);
	if (exist('ivsTree_2_span')) $("#ivsTree_2_span").html(controller.language.titles["ivsTree_2_span"]);
	// 冒泡提示
	if (exist('ivsTree_3_span')) $("#ivsTree_3_span").html(controller.language.titles["ivsTree_3_span"]);$("#ivsTree_3_span").attr("title", controller.language.titles["ivsTree_3_span_tag"]);
	if (exist('ivsTree_4_span')) $("#ivsTree_4_span").html(controller.language.titles["ivsTree_4_span"]);$("#ivsTree_4_span").attr("title", controller.language.titles["ivsTree_4_span_tag"]);
	if (exist('ivsTree_5_span')) $("#ivsTree_5_span").html(controller.language.titles["ivsTree_5_span"]);
	if (exist('ivsTree_6_span')) $("#ivsTree_6_span").html(controller.language.titles["ivsTree_6_span"]);$("#ivsTree_6_span").attr("title", controller.language.titles["ivsTree_6_span_tag"]);
	
	// 状态显示特殊处理，因只有调用接口后才会展示，这边需要作判断是否显示
	statusChange();
	
	// 页面参数校验错误信息在切换语言时清空
	clearTip();
}

function statusChange()
{
	// alarm
	if (exist('getAlarm_resultCode') && "" != $("#getAlarm_resultCode").val())
	{
		if ($("#getAlarm_resultCode").val() == 0)
		{
			$("#getAlarm_status").html(controller.language.titles["operationSuccess"]);
		}
		else
		{
			$("#getAlarm_status").html(controller.language.titles["operationFailed"]);
		}
	}
	else
	{
		$("#getAlarm_status").html("");
	}
	
	if (exist('subscribeAlarm_resultCode') && "" != $("#subscribeAlarm_resultCode").val())
	{
		if ($("#subscribeAlarm_resultCode").val() == 0)
		{
			$("#subscribeAlarm_status").html(controller.language.titles["operationSuccess"]);
		}
		else
		{
			$("#subscribeAlarm_status").html(controller.language.titles["operationFailed"]);
		}
	}
	else
	{
		$("#subscribeAlarm_status").html("");
	}
	
	// device
	if (exist('getDeviceList_resultCode') && "" != $("#getDeviceList_resultCode").val())
	{
		if ($("#getDeviceList_resultCode").val() == 0)
		{
			$("#getDeviceList_status").html(controller.language.titles["operationSuccess"]);
		}
		else
		{
			$("#getDeviceList_status").html(controller.language.titles["operationFailed"]);
		}
	}
	else
	{
		$("#getDeviceList_status").html("");
	}
}

function clearTip()
{
	// alarm
	if (exist('alarmEventIdErrTip')) $("#alarmEventIdErrTip").html("");
	if (exist('alarmInCodeErrTip')) $("#alarmInCodeErrTip").html("");
	if (exist('subscribeAlarmReqErrTip')) $("#subscribeAlarmReqErrTip").html("");
	
	// device
	if (exist('deviceTypeErrTip')) $("#deviceTypeErrTip").html("");
	if (exist('fromIndexErrTip')) $("#fromIndexErrTip").html("");
	if (exist('toIndexErrTip')) $("#toIndexErrTip").html("");
}

function appendInterface(functionName)
{
	if ("getAlarmEventInfo" == functionName)
	{
		$(function() {
			$.ajax({
				type : "get",
				cache : false,
				url : "pages/interface/getalarmeventinfo.html",
				async : false,
				success : function(data) {
					$("#main1").html(data);
				}
			});
		});
	}
	else if ("subscribeAlarm" == functionName)
	{
		$(function() {
			$.ajax({
				type : "get",
				cache : false,
				url : "pages/interface/subscribealarm.html",
				async : false,
				success : function(data) {
					$("#main1").html(data);
				}
			});
		});
	}
	else if ("getDeviceList" == functionName)
	{
		$(function() {
			$.ajax({
				type : "get",
				cache : false,
				url : "pages/interface/getdevicelist.html",
				async : false,
				success : function(data) {
					$("#main1").html(data);
				}
			});
		});
	}
	
	setTab(1,0);
	
	changeLang();
}

function setTab(m,n)
{  
	 var tli=document.getElementById("menu"+m).getElementsByTagName("li");  
	 var mli=document.getElementById("main"+m).getElementsByTagName("ul");  
	 for(i=0;i<tli.length;i++)
	 {  
	 	tli[i].className=i==n?"hover":"";  
	  	mli[i].style.display=i==n?"block":"none";  
	 }  
}

function clean()
{
	// 当单击节点时，置空标签页
	$("#main1").html("<ul class='block'><li></li></ul><ul><li></li></ul><ul><li></li></ul>");
	setTab(1,0);
}

function exist(id)
{
    var s=document.getElementById(id);
    if(s)
    {
    	return true;
    }
    else
    {
    	return false;
    }
}

function isEmpty(value)
{
	if (null == value || "" == value)
	{
		return true;
	}
	else
	{
		return false;
	}
}

function isNumber(num)
{
	var reNum=/^\d*$/;
	return(reNum.test(num));
}

/**2014.3.28 新增*/
function textOnF(which)
{
	if (which.style.color == "gray")
	{
		which.style.color = 'black';
		which.value = '';
	}
}


function changeValue(id)
{
	var values = {
			texts : {
				"alarmEventId":"59731",
				"alarmInCode":"10000000000000000101#089d6ae965674667bf7f9e5339f8e76b",
				"subscribeAlarmReq":"<Content><DomainCode>f563c8bc3f8240009637a9edd500ca19</DomainCode><Subscribe><SubscriberInfo><Subscriber>1</Subscriber><SubscriberID>8</SubscriberID><UserDomainCode>f563c8bc3f8240009637a9edd500ca19</UserDomainCode></SubscriberInfo></Subscribe></Content></textarea>",
				"deviceType":"2",
				"fromIndexVal":"1",
				"toIndexVal":"2"
				}
			};
	return values.texts[id];
}

function textOnB(which)
{
	if ('' == which.value || null == which.value)
	{	
		which.value = changeValue(which.id);
		which.style.color = 'gray';
	}
}