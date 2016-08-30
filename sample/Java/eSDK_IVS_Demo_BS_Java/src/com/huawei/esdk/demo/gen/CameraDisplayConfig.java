
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CameraDisplayConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CameraDisplayConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="brightness" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="contrast" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hue" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="saturation" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "CameraDisplayConfig", propOrder = {
    "brightness",
    "contrast",
    "hue",
    "saturation",
    "reserve"
})
public class CameraDisplayConfig {

    protected int brightness;
    protected int contrast;
    protected int hue;
    protected int saturation;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the brightness property.
     * 
     */
    public int getBrightness() {
        return brightness;
    }

    /**
     * Sets the value of the brightness property.
     * 
     */
    public void setBrightness(int value) {
        this.brightness = value;
    }

    /**
     * Gets the value of the contrast property.
     * 
     */
    public int getContrast() {
        return contrast;
    }

    /**
     * Sets the value of the contrast property.
     * 
     */
    public void setContrast(int value) {
        this.contrast = value;
    }

    /**
     * Gets the value of the hue property.
     * 
     */
    public int getHue() {
        return hue;
    }

    /**
     * Sets the value of the hue property.
     * 
     */
    public void setHue(int value) {
        this.hue = value;
    }

    /**
     * Gets the value of the saturation property.
     * 
     */
    public int getSaturation() {
        return saturation;
    }

    /**
     * Sets the value of the saturation property.
     * 
     */
    public void setSaturation(int value) {
        this.saturation = value;
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
