
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
 *         &lt;element name="newCameraName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "newCameraName"
})
@XmlRootElement(name = "setCameraName")
public class SetCameraName {

    @XmlElement(required = true)
    protected String cameraCode;
    @XmlElement(required = true)
    protected String newCameraName;

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
     * Gets the value of the newCameraName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewCameraName() {
        return newCameraName;
    }

    /**
     * Sets the value of the newCameraName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewCameraName(String value) {
        this.newCameraName = value;
    }

}
