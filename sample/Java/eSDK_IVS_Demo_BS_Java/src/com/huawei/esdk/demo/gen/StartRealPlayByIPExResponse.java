
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="mediaAddrSrc" type="{esdk_ivs_professional_server}MediaAddress"/>
 *         &lt;element name="handle" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
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
    "mediaAddrSrc",
    "handle"
})
@XmlRootElement(name = "startRealPlayByIPExResponse")
public class StartRealPlayByIPExResponse {

    protected int resultCode;
    @XmlElement(required = true)
    protected MediaAddress mediaAddrSrc;
    @XmlSchemaType(name = "unsignedInt")
    protected long handle;

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
     * Gets the value of the mediaAddrSrc property.
     * 
     * @return
     *     possible object is
     *     {@link MediaAddress }
     *     
     */
    public MediaAddress getMediaAddrSrc() {
        return mediaAddrSrc;
    }

    /**
     * Sets the value of the mediaAddrSrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaAddress }
     *     
     */
    public void setMediaAddrSrc(MediaAddress value) {
        this.mediaAddrSrc = value;
    }

    /**
     * Gets the value of the handle property.
     * 
     */
    public long getHandle() {
        return handle;
    }

    /**
     * Sets the value of the handle property.
     * 
     */
    public void setHandle(long value) {
        this.handle = value;
    }

}
