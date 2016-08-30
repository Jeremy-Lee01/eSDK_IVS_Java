
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Exposure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Exposure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exposureMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="exposurePriority" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rectWindow" type="{esdk_ivs_professional_server}RectInfo"/>
 *         &lt;element name="exposureTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="exposureGain" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="exposureIris" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "Exposure", propOrder = {
    "exposureMode",
    "exposurePriority",
    "rectWindow",
    "exposureTime",
    "exposureGain",
    "exposureIris",
    "reserve"
})
public class Exposure {

    protected int exposureMode;
    protected int exposurePriority;
    @XmlElement(required = true)
    protected RectInfo rectWindow;
    protected int exposureTime;
    protected int exposureGain;
    protected int exposureIris;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the exposureMode property.
     * 
     */
    public int getExposureMode() {
        return exposureMode;
    }

    /**
     * Sets the value of the exposureMode property.
     * 
     */
    public void setExposureMode(int value) {
        this.exposureMode = value;
    }

    /**
     * Gets the value of the exposurePriority property.
     * 
     */
    public int getExposurePriority() {
        return exposurePriority;
    }

    /**
     * Sets the value of the exposurePriority property.
     * 
     */
    public void setExposurePriority(int value) {
        this.exposurePriority = value;
    }

    /**
     * Gets the value of the rectWindow property.
     * 
     * @return
     *     possible object is
     *     {@link RectInfo }
     *     
     */
    public RectInfo getRectWindow() {
        return rectWindow;
    }

    /**
     * Sets the value of the rectWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link RectInfo }
     *     
     */
    public void setRectWindow(RectInfo value) {
        this.rectWindow = value;
    }

    /**
     * Gets the value of the exposureTime property.
     * 
     */
    public int getExposureTime() {
        return exposureTime;
    }

    /**
     * Sets the value of the exposureTime property.
     * 
     */
    public void setExposureTime(int value) {
        this.exposureTime = value;
    }

    /**
     * Gets the value of the exposureGain property.
     * 
     */
    public int getExposureGain() {
        return exposureGain;
    }

    /**
     * Sets the value of the exposureGain property.
     * 
     */
    public void setExposureGain(int value) {
        this.exposureGain = value;
    }

    /**
     * Gets the value of the exposureIris property.
     * 
     */
    public int getExposureIris() {
        return exposureIris;
    }

    /**
     * Sets the value of the exposureIris property.
     * 
     */
    public void setExposureIris(int value) {
        this.exposureIris = value;
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
