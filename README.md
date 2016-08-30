## eSDK\_IVS\_SDK\_Java  ##
华为VCN3000(Video Cloud Node)是基于行业视频监控业务需求，结合华为eSpace IVS智能视频监控平台和专业存储产品而定制开发的一体化智能视频监控产品，具有高度集成、安全可靠、开放易集成特点。华为VCN3000集实时监控、录像检索、录像回放、云镜控制、告警联动、语音对讲等多种视频监控业务于一身，并可配套IVS转码服务器提供移动监控业务，为政府、交通、教育部门及不同规模的企业客户构建安全、便捷、实用的系列化视频监控产品解决方案。

华为视频监控**eSDK\_IVS\_SDK\_Java**提供基于Windows动态库标准化API接口和OCX控件，为您提供用户管理、设备管理、告警管理、实时浏览、视频录像、实时语音、智能分析、电视墙等业务集成能力。

## 版本更新 ##
eSDK IVS最新版本v1.5.70

## 开发环境 ##

- 操作系统： Windows7专业版
- Microsoft Visual Studio：Visual Studio 2010专业版
- Eclipse for Java EE：Eclipse 4.4.2或以上版本

## 文件指引 ##

- src文件夹：eSDK\_IVS\_SDK\_Java源码
- sample文件夹：eSDK IVS SDK的代码样例
- doc：eSDK IVS SDK的接口参考、开发指南
- third-party:eSDK IVS SDK中使用的第三方库


## 入门指导 ##
编译SOAP工程：

- 把src/Platform目录下的六个工程导入eclipse，修正其Java Build Path中引用jar包的路径。
- 把src/SOAP目录下的五个工程导入eclipse之后，修正其Java Build Path中引用jar包的路径。
- 编译运行：编译工作空间中的这11个工程，将esdk_platform_web添加到在eclipse上配置的Server中，并在该Server的Lauch configuration中添加其余9个工程及其引用的类库，保存配置并运行Server。
- 详细的开发指南请参考doc中的开发指南

编译Java Native及Sample Code：

- 将这些工程导入eclipse，直接编译运行即可。

###登录IVS平台###
要体验华为IVS系统的能力，首先要登录IVS系统,以下代码演示如何登录IVS系统

    Step1：填充配置文件esdk_ivs_config.properties
        sdkserver.url=http://172.24.4.205:8086/esdk/services
    Step2：编写代码
        //Username
    	String userName = "admin";
        //Password
		String pwd = "Huawei@123";
        
        //get commonService Instance
		CommonServiceEx commonServiceEx = ServiceFactoryEx.getService(CommonServiceEx.class);
        //execute Login method
		Integer resultCode = commonServiceEx.login(userName, pwd);

## 获取帮助 ##

在开发过程中，您有任何问题均可以至[DevCenter](https://devcenter.huawei.com)中提单跟踪。也可以在[华为开发者社区](http://bbs.csdn.net/forums/hwucdeveloper)中查找或提问。另外，华为技术支持热线电话：400-822-9999（转二次开发）