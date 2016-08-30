
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CameraExtendConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CameraExtendConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableWatermark" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reliableTransmission" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fecMatrix" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableBandwidthAdaptive" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableCache" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mediaSecurityConfig" type="{esdk_ivs_professional_server}MediaSecurityConfig"/>
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
@XmlType(name = "CameraExtendConfig", propOrder = {
    "enableWatermark",
    "reliableTransmission",
    "fecMatrix",
    "enableBandwidthAdaptive",
    "enableCache",
    "mediaSecurityConfig",
    "reserve"
})
public class CameraExtendConfig {

    protected int enableWatermark;
    protected int reliableTransmission;
    protected int fecMatrix;
    protected int enableBandwidthAdaptive;
    protected int enableCache;
    @XmlElement(required = true)
    protected MediaSecurityConfig mediaSecurityConfig;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enableWatermark property.
     * 
     */
    public int getEnableWatermark() {
        return enableWatermark;
    }

    /**
     * Sets the value of the enableWatermark property.
     * 
     */
    public void setEnableWatermark(int value) {
        this.enableWatermark = value;
    }

    /**
     * Gets the value of the reliableTransmission property.
     * 
     */
    public int getReliableTransmission() {
        return reliableTransmission;
    }

    /**
     * Sets the value of the reliableTransmission property.
     * 
     */
    public void setReliableTransmission(int value) {
        this.reliableTransmission = value;
    }

    /**
     * Gets the value of the fecMatrix property.
     * 
     */
    public int getFecMatrix() {
        return fecMatrix;
    }

    /**
     * Sets the value of the fecMatrix property.
     * 
     */
    public void setFecMatrix(int value) {
        this.fecMatrix = value;
    }

    /**
     * Gets the value of the enableBandwidthAdaptive property.
     * 
     */
    public int getEnableBandwidthAdaptive() {
        return enableBandwidthAdaptive;
    }

    /**
     * Sets the value of the enableBandwidthAdaptive property.
     * 
     */
    public void setEnableBandwidthAdaptive(int value) {
        this.enableBandwidthAdaptive = value;
    }

    /**
     * Gets the value of the enableCache property.
     * 
     */
    public int getEnableCache() {
        return enableCache;
    }

    /**
     * Sets the value of the enableCache property.
     * 
     */
    public void setEnableCache(int value) {
        this.enableCache = value;
    }

    /**
     * Gets the value of the mediaSecurityConfig property.
     * 
     * @return
     *     possible object is
     *     {@link MediaSecurityConfig }
     *     
     */
    public MediaSecurityConfig getMediaSecurityConfig() {
        return mediaSecurityConfig;
    }

    /**
     * Sets the value of the mediaSecurityConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaSecurityConfig }
     *     
     */
    public void setMediaSecurityConfig(MediaSecurityConfig value) {
        this.mediaSecurityConfig = value;
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
