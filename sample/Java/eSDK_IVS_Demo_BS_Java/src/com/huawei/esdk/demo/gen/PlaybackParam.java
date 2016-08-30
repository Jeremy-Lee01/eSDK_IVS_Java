
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlaybackParam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlaybackParam">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="protocolType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recordTime" type="{esdk_ivs_professional_server}TimeSpan"/>
 *         &lt;element name="speed" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
@XmlType(name = "PlaybackParam", propOrder = {
    "protocolType",
    "recordTime",
    "speed",
    "reserve"
})
public class PlaybackParam {

    protected int protocolType;
    @XmlElement(required = true)
    protected TimeSpan recordTime;
    protected double speed;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the protocolType property.
     * 
     */
    public int getProtocolType() {
        return protocolType;
    }

    /**
     * Sets the value of the protocolType property.
     * 
     */
    public void setProtocolType(int value) {
        this.protocolType = value;
    }

    /**
     * Gets the value of the recordTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeSpan }
     *     
     */
    public TimeSpan getRecordTime() {
        return recordTime;
    }

    /**
     * Sets the value of the recordTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeSpan }
     *     
     */
    public void setRecordTime(TimeSpan value) {
        this.recordTime = value;
    }

    /**
     * Gets the value of the speed property.
     * 
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     * 
     */
    public void setSpeed(double value) {
        this.speed = value;
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
