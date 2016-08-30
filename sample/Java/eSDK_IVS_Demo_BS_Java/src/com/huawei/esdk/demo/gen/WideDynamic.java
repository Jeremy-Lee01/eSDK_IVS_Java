
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WideDynamic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WideDynamic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wideDynamicMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="wideDynamicLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "WideDynamic", propOrder = {
    "wideDynamicMode",
    "wideDynamicLevel",
    "reserve"
})
public class WideDynamic {

    protected int wideDynamicMode;
    protected int wideDynamicLevel;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the wideDynamicMode property.
     * 
     */
    public int getWideDynamicMode() {
        return wideDynamicMode;
    }

    /**
     * Sets the value of the wideDynamicMode property.
     * 
     */
    public void setWideDynamicMode(int value) {
        this.wideDynamicMode = value;
    }

    /**
     * Gets the value of the wideDynamicLevel property.
     * 
     */
    public int getWideDynamicLevel() {
        return wideDynamicLevel;
    }

    /**
     * Sets the value of the wideDynamicLevel property.
     * 
     */
    public void setWideDynamicLevel(int value) {
        this.wideDynamicLevel = value;
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
