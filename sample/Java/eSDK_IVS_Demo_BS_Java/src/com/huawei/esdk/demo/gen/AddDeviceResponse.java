
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deviceOperResultInfos" type="{esdk_ivs_professional_server}DeviceOperResultInfos" minOccurs="0"/>
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
    "resultCode",
    "deviceOperResultInfos"
})
@XmlRootElement(name = "addDeviceResponse")
public class AddDeviceResponse {

    protected int resultCode;
    protected DeviceOperResultInfos deviceOperResultInfos;

    /**
     * Gets the value of the resultCode property.
     * 
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     */
    public void setResultCode(int value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the deviceOperResultInfos property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceOperResultInfos }
     *     
     */
    public DeviceOperResultInfos getDeviceOperResultInfos() {
        return deviceOperResultInfos;
    }

    /**
     * Sets the value of the deviceOperResultInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceOperResultInfos }
     *     
     */
    public void setDeviceOperResultInfos(DeviceOperResultInfos value) {
        this.deviceOperResultInfos = value;
    }

}
