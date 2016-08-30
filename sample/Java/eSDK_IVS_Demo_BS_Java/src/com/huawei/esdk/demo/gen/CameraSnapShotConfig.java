
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CameraSnapShotConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CameraSnapShotConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="snapCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="snapInterval" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "CameraSnapShotConfig", propOrder = {
    "snapCount",
    "snapInterval",
    "reserve"
})
public class CameraSnapShotConfig {

    protected int snapCount;
    protected int snapInterval;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the snapCount property.
     * 
     */
    public int getSnapCount() {
        return snapCount;
    }

    /**
     * Sets the value of the snapCount property.
     * 
     */
    public void setSnapCount(int value) {
        this.snapCount = value;
    }

    /**
     * Gets the value of the snapInterval property.
     * 
     */
    public int getSnapInterval() {
        return snapInterval;
    }

    /**
     * Sets the value of the snapInterval property.
     * 
     */
    public void setSnapInterval(int value) {
        this.snapInterval = value;
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
