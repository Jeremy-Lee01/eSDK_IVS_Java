
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OSDTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OSDTime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableOSDTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeFormat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="timeY" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
@XmlType(name = "OSDTime", propOrder = {
    "enableOSDTime",
    "timeFormat",
    "timeX",
    "timeY",
    "reserve"
})
public class OSDTime {

    protected int enableOSDTime;
    protected int timeFormat;
    protected double timeX;
    protected double timeY;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enableOSDTime property.
     * 
     */
    public int getEnableOSDTime() {
        return enableOSDTime;
    }

    /**
     * Sets the value of the enableOSDTime property.
     * 
     */
    public void setEnableOSDTime(int value) {
        this.enableOSDTime = value;
    }

    /**
     * Gets the value of the timeFormat property.
     * 
     */
    public int getTimeFormat() {
        return timeFormat;
    }

    /**
     * Sets the value of the timeFormat property.
     * 
     */
    public void setTimeFormat(int value) {
        this.timeFormat = value;
    }

    /**
     * Gets the value of the timeX property.
     * 
     */
    public double getTimeX() {
        return timeX;
    }

    /**
     * Sets the value of the timeX property.
     * 
     */
    public void setTimeX(double value) {
        this.timeX = value;
    }

    /**
     * Gets the value of the timeY property.
     * 
     */
    public double getTimeY() {
        return timeY;
    }

    /**
     * Sets the value of the timeY property.
     * 
     */
    public void setTimeY(double value) {
        this.timeY = value;
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
