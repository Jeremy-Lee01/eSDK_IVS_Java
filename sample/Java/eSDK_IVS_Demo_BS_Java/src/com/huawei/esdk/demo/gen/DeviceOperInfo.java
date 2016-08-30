
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceOperInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceOperInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sequence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deviceConfig" type="{esdk_ivs_professional_server}DeviceConfig"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceOperInfo", propOrder = {
    "sequence",
    "deviceConfig",
    "reserve"
})
public class DeviceOperInfo {

    protected int sequence;
    @XmlElement(required = true)
    protected DeviceConfig deviceConfig;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the sequence property.
     * 
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     */
    public void setSequence(int value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the deviceConfig property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceConfig }
     *     
     */
    public DeviceConfig getDeviceConfig() {
        return deviceConfig;
    }

    /**
     * Sets the value of the deviceConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceConfig }
     *     
     */
    public void setDeviceConfig(DeviceConfig value) {
        this.deviceConfig = value;
    }

    /**
     * Gets the value of the reserve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserve() {
        return reserve;
    }

    /**
     * Sets the value of the reserve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserve(String value) {
        this.reserve = value;
    }

}
