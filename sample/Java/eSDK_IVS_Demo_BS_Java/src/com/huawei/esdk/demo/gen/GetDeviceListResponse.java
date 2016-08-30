
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cameraBriefInfos" type="{esdk_ivs_professional_server}CameraBriefInfos" minOccurs="0"/>
 *         &lt;element name="audioBriefInfos" type="{esdk_ivs_professional_server}AudioBriefInfos" minOccurs="0"/>
 *         &lt;element name="alarmBriefInfos" type="{esdk_ivs_professional_server}AlarmBriefInfos" minOccurs="0"/>
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
    "resultCode",
    "cameraBriefInfos",
    "audioBriefInfos",
    "alarmBriefInfos"
})
@XmlRootElement(name = "getDeviceListResponse")
public class GetDeviceListResponse {

    protected int resultCode;
    protected CameraBriefInfos cameraBriefInfos;
    protected AudioBriefInfos audioBriefInfos;
    protected AlarmBriefInfos alarmBriefInfos;

    /**
     * Gets the value of the resultCode property.
     * 
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     */
    public void setResultCode(int value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the cameraBriefInfos property.
     * 
     * @return
     *     possible object is
     *     {@link CameraBriefInfos }
     *     
     */
    public CameraBriefInfos getCameraBriefInfos() {
        return cameraBriefInfos;
    }

    /**
     * Sets the value of the cameraBriefInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraBriefInfos }
     *     
     */
    public void setCameraBriefInfos(CameraBriefInfos value) {
        this.cameraBriefInfos = value;
    }

    /**
     * Gets the value of the audioBriefInfos property.
     * 
     * @return
     *     possible object is
     *     {@link AudioBriefInfos }
     *     
     */
    public AudioBriefInfos getAudioBriefInfos() {
        return audioBriefInfos;
    }

    /**
     * Sets the value of the audioBriefInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link AudioBriefInfos }
     *     
     */
    public void setAudioBriefInfos(AudioBriefInfos value) {
        this.audioBriefInfos = value;
    }

    /**
     * Gets the value of the alarmBriefInfos property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmBriefInfos }
     *     
     */
    public AlarmBriefInfos getAlarmBriefInfos() {
        return alarmBriefInfos;
    }

    /**
     * Sets the value of the alarmBriefInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmBriefInfos }
     *     
     */
    public void setAlarmBriefInfos(AlarmBriefInfos value) {
        this.alarmBriefInfos = value;
    }

}
