using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Net;
using System.IO;
using System.Threading;
using System.Text.RegularExpressions;

namespace eSDK_IVS_Demo_Soap
{
    public partial class MainWindow : Window
    {
        Thread thread;
        public delegate void KeepAliveResult();
        //保活的计时器
        private System.Timers.Timer timer = null;
        //保活的间隔
        private double aliveTime = 0;

        //调用login接口时eSDK在Cookie中返回的Session ID值
        string cookie = string.Empty;

        public MainWindow()
        {
            InitializeComponent();

        }

        //登录的请求消息
        public string LoginSoapXml()
        {
            //构造soap请求信息
            StringBuilder soap = new StringBuilder();
            soap.Append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:esdk=\"esdk_ivs_professional_server\">");
            soap.Append("<soapenv:Header/>");
            soap.Append("<soapenv:Body>");
            soap.Append("<esdk:login>");
            soap.Append("<userName>admin</userName>");
            soap.Append("<password>LwzSfEtrgBhhWVD1f6DalQ==</password>");
            soap.Append("</esdk:login>");
            soap.Append("</soapenv:Body>");
            soap.Append("</soapenv:Envelope>");
            return soap.ToString();
        }

        //会话保活的请求消息
        public string KeepAliveSoapXml()
        {
            //构造soap请求信息
            StringBuilder soap = new StringBuilder();
            soap.Append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:esdk=\"esdk_ivs_professional_server\">");
            soap.Append("<soapenv:Header/>");
            soap.Append("<soapenv:Body>");
            soap.Append("<esdk:keepAlive/>");
            soap.Append("</soapenv:Body>");
            soap.Append("</soapenv:Envelope>");
            return soap.ToString();
        }

        //获取设备列表的请求消息
        public string GetDeviceListSoapXml()
        {
            //构造soap请求信息
            StringBuilder soap = new StringBuilder();
            soap.Append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:esdk=\"esdk_ivs_professional_server\">");
            soap.Append("<soapenv:Header/>");
            soap.Append("<soapenv:Body>");
            soap.Append("<esdk:getDeviceList>");
            soap.Append("<deviceType>2</deviceType>");
            soap.Append("<indexRange><fromIndex>1</fromIndex><toIndex>2</toIndex></indexRange>");
            soap.Append("</esdk:getDeviceList>");
            soap.Append("</soapenv:Body>");
            soap.Append("</soapenv:Envelope>");
            return soap.ToString();
        }

        //登录的具体实现
        public void Login()
        {
            //获取Http认证
            Util.SetCertificatePolicy();


            HttpWebRequest webRequest = (HttpWebRequest)HttpWebRequest.Create(this.eSDKURIText.Text + "/esdk/services/ivsProfessionalCommon?wsdl");
            webRequest.ContentType = "text/xml; charset=utf-8";
            //设置请求的头
            WebHeaderCollection webHeader = new WebHeaderCollection();
            //访问的位置，此处要对应所访问的接口
            webHeader.Add("SOAPAction:esdk_ivs_professional_server.login");
            webRequest.Headers = webHeader;
            //请求方式为POST
            webRequest.Method = "POST";

            //发送请求
            using (Stream requestStream = webRequest.GetRequestStream())
            {
                byte[] paramBytes = Encoding.UTF8.GetBytes(LoginSoapXml());
                requestStream.Write(paramBytes, 0, paramBytes.Length);
            }

            //响应
            WebResponse webResponse = webRequest.GetResponse();

            //获取返回值中HTTP Header的Cookie，在后面的接口中需要
            string headers = webResponse.Headers.Get(0);
            string[] temp = Regex.Split(headers, ";", RegexOptions.IgnoreCase);
            cookie = temp[0];

            //获取返回值
            StreamReader myStreamReader = new StreamReader(webResponse.GetResponseStream(), Encoding.UTF8);
            string result = myStreamReader.ReadToEnd();
            //分割出返回码
            string[] temp1 = Regex.Split(result, "<resultCode>", RegexOptions.IgnoreCase);
            string[] temp2 = Regex.Split(temp1[1], "</resultCode>", RegexOptions.IgnoreCase);
            if (temp2[0].Equals("0"))
            {
                this.LoginText.Text = "登录成功";
                //请动保活线程
                aliveTime = 30 * 1000;
                thread = new Thread(new ThreadStart(KeepAliveThread));
                thread.Start();
            }
            else
            {
                this.LoginText.Text = "登录失败：" + temp2[0];
            }

        }

        //启动线程；使用计时器来完成心跳，每30秒一次
        private void KeepAliveThread()
        {
            timer = new System.Timers.Timer();
            timer.Interval = aliveTime;
            timer.Elapsed += new System.Timers.ElapsedEventHandler(AliveCode);
            timer.AutoReset = true;
            timer.Enabled = true;
        }

        //调用AuthorizeServiceEx中的KeepAlive接口实现会话处于存活状态
        private void AliveCode(object source, System.Timers.ElapsedEventArgs e)
        {
            Dispatcher.BeginInvoke(System.Windows.Threading.DispatcherPriority.Normal, new KeepAliveResult(KeepAlive));

        }

        // 会话保活
        private void KeepAlive()
        {
            Util.SetCertificatePolicy();

            HttpWebRequest hwr = (HttpWebRequest)HttpWebRequest.Create(this.eSDKURIText.Text + "/esdk/services/ivsProfessionalCommon?wsdl");
            hwr.ContentType = "text/xml; charset=utf-8";
            //设置请求的头
            WebHeaderCollection webHeader = new WebHeaderCollection();
            //访问的位置，此处要对应所访问的接口
            webHeader.Add("SOAPAction:esdk_ivs_professional_server.keepAlive");
            //Cookie是调用login接口时eSDK在Cookie中返回的Session ID值
            webHeader.Add("Cookie:" + cookie);
            hwr.Headers = webHeader;
            hwr.Method = "POST";
            using (Stream requestStream = hwr.GetRequestStream())
            {
                byte[] paramBytes = Encoding.UTF8.GetBytes(KeepAliveSoapXml());
                requestStream.Write(paramBytes, 0, paramBytes.Length);
            }

            //响应
            WebResponse webResponse = hwr.GetResponse();
            StreamReader myStreamReader = new StreamReader(webResponse.GetResponseStream(), Encoding.UTF8);
            string result = myStreamReader.ReadToEnd();
            string[] temp1 = Regex.Split(result, "<resultCode>", RegexOptions.IgnoreCase);
            string[] temp2 = Regex.Split(temp1[1], "</resultCode>", RegexOptions.IgnoreCase);
            if (temp2[0].Equals("0"))
            {
                this.LoginText.Text = "会话保活中...";
            }
        }

        //获取设备列表
        public void GetDeviceList()
        {
            Util.SetCertificatePolicy();

            HttpWebRequest hwr = (HttpWebRequest)HttpWebRequest.Create(this.eSDKURIText.Text + "/esdk/services/ivsProfessionalDeviceManager?wsdl");
            hwr.ContentType = "text/xml; charset=utf-8";
            WebHeaderCollection webHeader = new WebHeaderCollection();
            webHeader.Add("SOAPAction:esdk_ivs_professional_server.getDeviceList");
            webHeader.Add("Cookie:" + cookie);
            hwr.Headers = webHeader;
            hwr.Method = "POST";
            //请求
            using (Stream requestStream = hwr.GetRequestStream())
            {
                byte[] paramBytes = Encoding.UTF8.GetBytes(GetDeviceListSoapXml());
                requestStream.Write(paramBytes, 0, paramBytes.Length);
            }

            //响应
            WebResponse webResponse = hwr.GetResponse();
            StreamReader myStreamReader = new StreamReader(webResponse.GetResponseStream(), Encoding.UTF8);
            string result = myStreamReader.ReadToEnd();
            this.DeviceListText.Text = result;
        }

        private void Login_Click(object sender, RoutedEventArgs e)
        {
            Login();
        }

        private void DeviceList_Click(object sender, RoutedEventArgs e)
        {
            GetDeviceList();
        }

    }

    public static class Util
    {
        /// <summary>   
        /// Sets the cert policy.   
        /// </summary>   
        public static void SetCertificatePolicy()
        {
            ServicePointManager.ServerCertificateValidationCallback += RemoteCertificateValidate;
        }

        /// <summary>   
        /// Remotes the certificate validate.   
        /// </summary>   
        private static bool RemoteCertificateValidate(
            object sender, System.Security.Cryptography.X509Certificates.X509Certificate cert,
              System.Security.Cryptography.X509Certificates.X509Chain chain, System.Net.Security.SslPolicyErrors error)
        {
            // trust any certificate!!!   
            System.Console.WriteLine("Warning, trust any certificate");
            return true;
        }
    } 
}
