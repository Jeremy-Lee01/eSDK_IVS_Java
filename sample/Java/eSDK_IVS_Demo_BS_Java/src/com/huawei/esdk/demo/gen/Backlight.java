
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Backlight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Backlight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="backlightMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="backlightLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "Backlight", propOrder = {
    "backlightMode",
    "backlightLevel",
    "reserve"
})
public class Backlight {

    protected int backlightMode;
    protected int backlightLevel;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the backlightMode property.
     * 
     */
    public int getBacklightMode() {
        return backlightMode;
    }

    /**
     * Sets the value of the backlightMode property.
     * 
     */
    public void setBacklightMode(int value) {
        this.backlightMode = value;
    }

    /**
     * Gets the value of the backlightLevel property.
     * 
     */
    public int getBacklightLevel() {
        return backlightLevel;
    }

    /**
     * Sets the value of the backlightLevel property.
     * 
     */
    public void setBacklightLevel(int value) {
        this.backlightLevel = value;
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
