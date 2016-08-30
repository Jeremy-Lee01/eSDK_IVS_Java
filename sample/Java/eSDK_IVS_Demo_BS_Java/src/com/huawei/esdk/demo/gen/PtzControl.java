
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
 *         &lt;element name="cameraCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="controlCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="controlPara1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="controlPara2" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "cameraCode",
    "controlCode",
    "controlPara1",
    "controlPara2"
})
@XmlRootElement(name = "ptzControl")
public class PtzControl {

    @XmlElement(required = true)
    protected String cameraCode;
    protected int controlCode;
    @XmlElement(required = true)
    protected String controlPara1;
    @XmlElement(required = true)
    protected String controlPara2;

    /**
     * Gets the value of the cameraCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCameraCode() {
        return cameraCode;
    }

    /**
     * Sets the value of the cameraCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCameraCode(String value) {
        this.cameraCode = value;
    }

    /**
     * Gets the value of the controlCode property.
     * 
     */
    public int getControlCode() {
        return controlCode;
    }

    /**
     * Sets the value of the controlCode property.
     * 
     */
    public void setControlCode(int value) {
        this.controlCode = value;
    }

    /**
     * Gets the value of the controlPara1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlPara1() {
        return controlPara1;
    }

    /**
     * Sets the value of the controlPara1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlPara1(String value) {
        this.controlPara1 = value;
    }

    /**
     * Gets the value of the controlPara2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlPara2() {
        return controlPara2;
    }

    /**
     * Sets the value of the controlPara2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlPara2(String value) {
        this.controlPara2 = value;
    }

}
