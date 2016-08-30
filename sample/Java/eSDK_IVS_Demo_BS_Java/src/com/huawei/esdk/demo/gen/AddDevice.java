
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deviceOperInfos" type="{esdk_ivs_professional_server}DeviceOperInfoList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "domainCode",
    "deviceNum",
    "deviceOperInfos"
})
@XmlRootElement(name = "addDevice")
public class AddDevice {

    @XmlElement(required = true)
    protected String domainCode;
    protected int deviceNum;
    @XmlElement(required = true)
    protected DeviceOperInfoList deviceOperInfos;

    /**
     * Gets the value of the domainCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainCode() {
        return domainCode;
    }

    /**
     * Sets the value of the domainCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainCode(String value) {
        this.domainCode = value;
    }

    /**
     * Gets the value of the deviceNum property.
     * 
     */
    public int getDeviceNum() {
        return deviceNum;
    }

    /**
     * Sets the value of the deviceNum property.
     * 
     */
    public void setDeviceNum(int value) {
        this.deviceNum = value;
    }

    /**
     * Gets the value of the deviceOperInfos property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceOperInfoList }
     *     
     */
    public DeviceOperInfoList getDeviceOperInfos() {
        return deviceOperInfos;
    }

    /**
     * Sets the value of the deviceOperInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceOperInfoList }
     *     
     */
    public void setDeviceOperInfos(DeviceOperInfoList value) {
        this.deviceOperInfos = value;
    }

}
