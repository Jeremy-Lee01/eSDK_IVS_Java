
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaSecurityConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaSecurityConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableMediaSecurity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableSecureStorage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mediaSecurityAlgorithm" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "MediaSecurityConfig", propOrder = {
    "enableMediaSecurity",
    "enableSecureStorage",
    "mediaSecurityAlgorithm",
    "reserve"
})
public class MediaSecurityConfig {

    protected int enableMediaSecurity;
    protected int enableSecureStorage;
    protected int mediaSecurityAlgorithm;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enableMediaSecurity property.
     * 
     */
    public int getEnableMediaSecurity() {
        return enableMediaSecurity;
    }

    /**
     * Sets the value of the enableMediaSecurity property.
     * 
     */
    public void setEnableMediaSecurity(int value) {
        this.enableMediaSecurity = value;
    }

    /**
     * Gets the value of the enableSecureStorage property.
     * 
     */
    public int getEnableSecureStorage() {
        return enableSecureStorage;
    }

    /**
     * Sets the value of the enableSecureStorage property.
     * 
     */
    public void setEnableSecureStorage(int value) {
        this.enableSecureStorage = value;
    }

    /**
     * Gets the value of the mediaSecurityAlgorithm property.
     * 
     */
    public int getMediaSecurityAlgorithm() {
        return mediaSecurityAlgorithm;
    }

    /**
     * Sets the value of the mediaSecurityAlgorithm property.
     * 
     */
    public void setMediaSecurityAlgorithm(int value) {
        this.mediaSecurityAlgorithm = value;
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
