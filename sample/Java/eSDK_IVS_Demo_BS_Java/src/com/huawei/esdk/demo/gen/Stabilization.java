
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Stabilization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Stabilization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stabilizationMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stabilizationLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "Stabilization", propOrder = {
    "stabilizationMode",
    "stabilizationLevel",
    "reserve"
})
public class Stabilization {

    protected int stabilizationMode;
    protected int stabilizationLevel;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the stabilizationMode property.
     * 
     */
    public int getStabilizationMode() {
        return stabilizationMode;
    }

    /**
     * Sets the value of the stabilizationMode property.
     * 
     */
    public void setStabilizationMode(int value) {
        this.stabilizationMode = value;
    }

    /**
     * Gets the value of the stabilizationLevel property.
     * 
     */
    public int getStabilizationLevel() {
        return stabilizationLevel;
    }

    /**
     * Sets the value of the stabilizationLevel property.
     * 
     */
    public void setStabilizationLevel(int value) {
        this.stabilizationLevel = value;
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
