
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
 *         &lt;element name="deviceCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="configType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="configItem" type="{esdk_ivs_professional_server}ConfigItem"/>
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
    "deviceCode",
    "configType",
    "configItem"
})
@XmlRootElement(name = "setDeviceConfig")
public class SetDeviceConfig {

    @XmlElement(required = true)
    protected String deviceCode;
    protected int configType;
    @XmlElement(required = true)
    protected ConfigItem configItem;

    /**
     * Gets the value of the deviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceCode() {
        return deviceCode;
    }

    /**
     * Sets the value of the deviceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceCode(String value) {
        this.deviceCode = value;
    }

    /**
     * Gets the value of the configType property.
     * 
     */
    public int getConfigType() {
        return configType;
    }

    /**
     * Sets the value of the configType property.
     * 
     */
    public void setConfigType(int value) {
        this.configType = value;
    }

    /**
     * Gets the value of the configItem property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigItem }
     *     
     */
    public ConfigItem getConfigItem() {
        return configItem;
    }

    /**
     * Sets the value of the configItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigItem }
     *     
     */
    public void setConfigItem(ConfigItem value) {
        this.configItem = value;
    }

}
