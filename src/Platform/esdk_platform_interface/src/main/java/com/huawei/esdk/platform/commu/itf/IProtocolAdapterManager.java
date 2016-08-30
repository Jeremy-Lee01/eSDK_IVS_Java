package com.huawei.esdk.platform.commu.itf;

public interface IProtocolAdapterManager
{
    /**
     * 根据适配的协议类型及服务地址获取协议实例
     * 
     * @param protocolAdapterType 协议类型
     * @param sap 协议访问的服务地址
     * @return 协议实例
     * 
     */
    ISDKProtocolAdapter getProtocolInstanceByType(
            String protocolAdapterType, String sap);

}
