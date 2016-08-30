
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AudioBriefInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AudioBriefInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deviceGroupId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="audioCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="audioName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="channelType" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "AudioBriefInfo", propOrder = {
    "deviceGroupId",
    "audioCode",
    "domainCode",
    "audioName",
    "channelType",
    "reserve"
})
public class AudioBriefInfo {

    protected int deviceGroupId;
    @XmlElement(required = true)
    protected String audioCode;
    @XmlElement(required = true)
    protected String domainCode;
    @XmlElement(required = true)
    protected String audioName;
    protected int channelType;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the deviceGroupId property.
     * 
     */
    public int getDeviceGroupId() {
        return deviceGroupId;
    }

    /**
     * Sets the value of the deviceGroupId property.
     * 
     */
    public void setDeviceGroupId(int value) {
        this.deviceGroupId = value;
    }

    /**
     * Gets the value of the audioCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAudioCode() {
        return audioCode;
    }

    /**
     * Sets the value of the audioCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAudioCode(String value) {
        this.audioCode = value;
    }

    /**
     * Gets the value of the domainCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainCode() {
        return domainCode;
    }

    /**
     * Sets the value of the domainCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainCode(String value) {
        this.domainCode = value;
    }

    /**
     * Gets the value of the audioName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAudioName() {
        return audioName;
    }

    /**
     * Sets the value of the audioName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAudioName(String value) {
        this.audioName = value;
    }

    /**
     * Gets the value of the channelType property.
     * 
     */
    public int getChannelType() {
        return channelType;
    }

    /**
     * Sets the value of the channelType property.
     * 
     */
    public void setChannelType(int value) {
        this.channelType = value;
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
