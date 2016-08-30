/**
 * TPCommonServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.huawei.smc;

public class TPCommonServiceLocator extends org.apache.axis.client.Service implements com.huawei.smc.TPCommonService {

    public TPCommonServiceLocator() {
    }


    public TPCommonServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TPCommonServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TPCommonPort
    private java.lang.String TPCommonPort_address = "http://10.45.4.214:8086/esdk/services/tpCommon";

    public java.lang.String getTPCommonPortAddress() {
        return TPCommonPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TPCommonPortWSDDServiceName = "TP.CommonPort";

    public java.lang.String getTPCommonPortWSDDServiceName() {
        return TPCommonPortWSDDServiceName;
    }

    public void setTPCommonPortWSDDServiceName(java.lang.String name) {
        TPCommonPortWSDDServiceName = name;
    }

    public com.huawei.smc.TPCommon getTPCommonPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TPCommonPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTPCommonPort(endpoint);
    }

    public com.huawei.smc.TPCommon getTPCommonPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.huawei.smc.TPCommonServiceSoapBindingStub _stub = new com.huawei.smc.TPCommonServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getTPCommonPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTPCommonPortEndpointAddress(java.lang.String address) {
        TPCommonPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.huawei.smc.TPCommon.class.isAssignableFrom(serviceEndpointInterface)) {
                com.huawei.smc.TPCommonServiceSoapBindingStub _stub = new com.huawei.smc.TPCommonServiceSoapBindingStub(new java.net.URL(TPCommonPort_address), this);
                _stub.setPortName(getTPCommonPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TP.CommonPort".equals(inputPortName)) {
            return getTPCommonPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://smc.huawei.com/", "TPCommonService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://smc.huawei.com/", "TP.CommonPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TPCommonPort".equals(portName)) {
            setTPCommonPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
