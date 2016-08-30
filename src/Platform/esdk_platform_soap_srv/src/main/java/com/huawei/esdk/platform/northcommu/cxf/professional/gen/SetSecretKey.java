
package com.huawei.esdk.platform.northcommu.cxf.professional.gen;

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
 *         &lt;element name="secretType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="secretKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iv" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "secretType",
    "secretKey",
    "iv"
})
@XmlRootElement(name = "setSecretKey")
public class SetSecretKey {

    @XmlElement(required = true)
    protected String secretType;
    @XmlElement(required = true)
    protected String secretKey;
    @XmlElement(required = true)
    protected String iv;

    /**
     * Gets the value of the secretType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecretType() {
        return secretType;
    }

    /**
     * Sets the value of the secretType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecretType(String value) {
        this.secretType = value;
    }

    /**
     * Gets the value of the secretKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * Sets the value of the secretKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecretKey(String value) {
        this.secretKey = value;
    }

    /**
     * Gets the value of the iv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIv() {
        return iv;
    }

    /**
     * Sets the value of the iv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIv(String value) {
        this.iv = value;
    }

}
