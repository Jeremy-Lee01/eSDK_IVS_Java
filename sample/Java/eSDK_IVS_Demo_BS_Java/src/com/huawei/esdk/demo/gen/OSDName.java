
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OSDName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OSDName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableOSDName" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="osdNameText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rectText" type="{esdk_ivs_professional_server}RectInfo"/>
 *         &lt;element name="enableSwitch" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="switchInterval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableTextBlink" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableTextTranslucent" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="textTranslucentPercent" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "OSDName", propOrder = {
    "enableOSDName",
    "osdNameText",
    "rectText",
    "enableSwitch",
    "switchInterval",
    "enableTextBlink",
    "enableTextTranslucent",
    "textTranslucentPercent",
    "reserve"
})
public class OSDName {

    protected int enableOSDName;
    @XmlElement(required = true)
    protected String osdNameText;
    @XmlElement(required = true)
    protected RectInfo rectText;
    protected int enableSwitch;
    protected int switchInterval;
    protected int enableTextBlink;
    protected int enableTextTranslucent;
    protected int textTranslucentPercent;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enableOSDName property.
     * 
     */
    public int getEnableOSDName() {
        return enableOSDName;
    }

    /**
     * Sets the value of the enableOSDName property.
     * 
     */
    public void setEnableOSDName(int value) {
        this.enableOSDName = value;
    }

    /**
     * Gets the value of the osdNameText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsdNameText() {
        return osdNameText;
    }

    /**
     * Sets the value of the osdNameText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsdNameText(String value) {
        this.osdNameText = value;
    }

    /**
     * Gets the value of the rectText property.
     * 
     * @return
     *     possible object is
     *     {@link RectInfo }
     *     
     */
    public RectInfo getRectText() {
        return rectText;
    }

    /**
     * Sets the value of the rectText property.
     * 
     * @param value
     *     allowed object is
     *     {@link RectInfo }
     *     
     */
    public void setRectText(RectInfo value) {
        this.rectText = value;
    }

    /**
     * Gets the value of the enableSwitch property.
     * 
     */
    public int getEnableSwitch() {
        return enableSwitch;
    }

    /**
     * Sets the value of the enableSwitch property.
     * 
     */
    public void setEnableSwitch(int value) {
        this.enableSwitch = value;
    }

    /**
     * Gets the value of the switchInterval property.
     * 
     */
    public int getSwitchInterval() {
        return switchInterval;
    }

    /**
     * Sets the value of the switchInterval property.
     * 
     */
    public void setSwitchInterval(int value) {
        this.switchInterval = value;
    }

    /**
     * Gets the value of the enableTextBlink property.
     * 
     */
    public int getEnableTextBlink() {
        return enableTextBlink;
    }

    /**
     * Sets the value of the enableTextBlink property.
     * 
     */
    public void setEnableTextBlink(int value) {
        this.enableTextBlink = value;
    }

    /**
     * Gets the value of the enableTextTranslucent property.
     * 
     */
    public int getEnableTextTranslucent() {
        return enableTextTranslucent;
    }

    /**
     * Sets the value of the enableTextTranslucent property.
     * 
     */
    public void setEnableTextTranslucent(int value) {
        this.enableTextTranslucent = value;
    }

    /**
     * Gets the value of the textTranslucentPercent property.
     * 
     */
    public int getTextTranslucentPercent() {
        return textTranslucentPercent;
    }

    /**
     * Sets the value of the textTranslucentPercent property.
     * 
     */
    public void setTextTranslucentPercent(int value) {
        this.textTranslucentPercent = value;
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
