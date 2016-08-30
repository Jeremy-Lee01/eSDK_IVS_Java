
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceOperResultInfos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceOperResultInfos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deviceOperResultList" type="{esdk_ivs_professional_server}DeviceOperResultList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceOperResultInfos", propOrder = {
    "number",
    "deviceOperResultList"
})
public class DeviceOperResultInfos {

    protected int number;
    @XmlElement(required = true)
    protected DeviceOperResultList deviceOperResultList;

    /**
     * Gets the value of the number property.
     * 
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     */
    public void setNumber(int value) {
        this.number = value;
    }

    /**
     * Gets the value of the deviceOperResultList property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceOperResultList }
     *     
     */
    public DeviceOperResultList getDeviceOperResultList() {
        return deviceOperResultList;
    }

    /**
     * Sets the value of the deviceOperResultList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceOperResultList }
     *     
     */
    public void setDeviceOperResultList(DeviceOperResultList value) {
        this.deviceOperResultList = value;
    }

}
