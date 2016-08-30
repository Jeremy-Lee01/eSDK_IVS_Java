
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceNetConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceNetConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="puIP" type="{esdk_ivs_professional_server}IPInfo"/>
 *         &lt;element name="puGateway" type="{esdk_ivs_professional_server}IPInfo"/>
 *         &lt;element name="puPort" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxMtu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="subNetMask" type="{esdk_ivs_professional_server}IPInfo"/>
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
@XmlType(name = "DeviceNetConfig", propOrder = {
    "puIP",
    "puGateway",
    "puPort",
    "maxMtu",
    "subNetMask",
    "reserve"
})
public class DeviceNetConfig {

    @XmlElement(required = true)
    protected IPInfo puIP;
    @XmlElement(required = true)
    protected IPInfo puGateway;
    protected int puPort;
    protected int maxMtu;
    @XmlElement(required = true)
    protected IPInfo subNetMask;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the puIP property.
     * 
     * @return
     *     possible object is
     *     {@link IPInfo }
     *     
     */
    public IPInfo getPuIP() {
        return puIP;
    }

    /**
     * Sets the value of the puIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPInfo }
     *     
     */
    public void setPuIP(IPInfo value) {
        this.puIP = value;
    }

    /**
     * Gets the value of the puGateway property.
     * 
     * @return
     *     possible object is
     *     {@link IPInfo }
     *     
     */
    public IPInfo getPuGateway() {
        return puGateway;
    }

    /**
     * Sets the value of the puGateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPInfo }
     *     
     */
    public void setPuGateway(IPInfo value) {
        this.puGateway = value;
    }

    /**
     * Gets the value of the puPort property.
     * 
     */
    public int getPuPort() {
        return puPort;
    }

    /**
     * Sets the value of the puPort property.
     * 
     */
    public void setPuPort(int value) {
        this.puPort = value;
    }

    /**
     * Gets the value of the maxMtu property.
     * 
     */
    public int getMaxMtu() {
        return maxMtu;
    }

    /**
     * Sets the value of the maxMtu property.
     * 
     */
    public void setMaxMtu(int value) {
        this.maxMtu = value;
    }

    /**
     * Gets the value of the subNetMask property.
     * 
     * @return
     *     possible object is
     *     {@link IPInfo }
     *     
     */
    public IPInfo getSubNetMask() {
        return subNetMask;
    }

    /**
     * Sets the value of the subNetMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPInfo }
     *     
     */
    public void setSubNetMask(IPInfo value) {
        this.subNetMask = value;
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
