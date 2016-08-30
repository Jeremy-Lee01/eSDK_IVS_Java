
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Focus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Focus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="focusMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="focusSpeed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nearLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="farLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "Focus", propOrder = {
    "focusMode",
    "focusSpeed",
    "nearLimit",
    "farLimit",
    "reserve"
})
public class Focus {

    protected int focusMode;
    protected int focusSpeed;
    protected int nearLimit;
    protected int farLimit;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the focusMode property.
     * 
     */
    public int getFocusMode() {
        return focusMode;
    }

    /**
     * Sets the value of the focusMode property.
     * 
     */
    public void setFocusMode(int value) {
        this.focusMode = value;
    }

    /**
     * Gets the value of the focusSpeed property.
     * 
     */
    public int getFocusSpeed() {
        return focusSpeed;
    }

    /**
     * Sets the value of the focusSpeed property.
     * 
     */
    public void setFocusSpeed(int value) {
        this.focusSpeed = value;
    }

    /**
     * Gets the value of the nearLimit property.
     * 
     */
    public int getNearLimit() {
        return nearLimit;
    }

    /**
     * Sets the value of the nearLimit property.
     * 
     */
    public void setNearLimit(int value) {
        this.nearLimit = value;
    }

    /**
     * Gets the value of the farLimit property.
     * 
     */
    public int getFarLimit() {
        return farLimit;
    }

    /**
     * Sets the value of the farLimit property.
     * 
     */
    public void setFarLimit(int value) {
        this.farLimit = value;
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
