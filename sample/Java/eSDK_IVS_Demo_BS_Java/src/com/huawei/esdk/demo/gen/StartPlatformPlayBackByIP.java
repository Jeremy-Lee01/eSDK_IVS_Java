
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
 *         &lt;element name="playbackParam" type="{esdk_ivs_professional_server}PlaybackParam"/>
 *         &lt;element name="cameraCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mediaAddrDst" type="{esdk_ivs_professional_server}MediaAddress"/>
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
    "playbackParam",
    "cameraCode",
    "mediaAddrDst"
})
@XmlRootElement(name = "startPlatformPlayBackByIP")
public class StartPlatformPlayBackByIP {

    @XmlElement(required = true)
    protected PlaybackParam playbackParam;
    @XmlElement(required = true)
    protected String cameraCode;
    @XmlElement(required = true)
    protected MediaAddress mediaAddrDst;

    /**
     * Gets the value of the playbackParam property.
     * 
     * @return
     *     possible object is
     *     {@link PlaybackParam }
     *     
     */
    public PlaybackParam getPlaybackParam() {
        return playbackParam;
    }

    /**
     * Sets the value of the playbackParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlaybackParam }
     *     
     */
    public void setPlaybackParam(PlaybackParam value) {
        this.playbackParam = value;
    }

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
     * Gets the value of the mediaAddrDst property.
     * 
     * @return
     *     possible object is
     *     {@link MediaAddress }
     *     
     */
    public MediaAddress getMediaAddrDst() {
        return mediaAddrDst;
    }

    /**
     * Sets the value of the mediaAddrDst property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaAddress }
     *     
     */
    public void setMediaAddrDst(MediaAddress value) {
        this.mediaAddrDst = value;
    }

}
