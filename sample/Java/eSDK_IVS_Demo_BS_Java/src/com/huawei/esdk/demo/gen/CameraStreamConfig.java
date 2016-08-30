
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CameraStreamConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CameraStreamConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="streamInfoNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="streamInfoList" type="{esdk_ivs_professional_server}StreamInfoList"/>
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
@XmlType(name = "CameraStreamConfig", propOrder = {
    "streamInfoNum",
    "streamInfoList",
    "reserve"
})
public class CameraStreamConfig {

    protected int streamInfoNum;
    @XmlElement(required = true)
    protected StreamInfoList streamInfoList;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the streamInfoNum property.
     * 
     */
    public int getStreamInfoNum() {
        return streamInfoNum;
    }

    /**
     * Sets the value of the streamInfoNum property.
     * 
     */
    public void setStreamInfoNum(int value) {
        this.streamInfoNum = value;
    }

    /**
     * Gets the value of the streamInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link StreamInfoList }
     *     
     */
    public StreamInfoList getStreamInfoList() {
        return streamInfoList;
    }

    /**
     * Sets the value of the streamInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link StreamInfoList }
     *     
     */
    public void setStreamInfoList(StreamInfoList value) {
        this.streamInfoList = value;
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
