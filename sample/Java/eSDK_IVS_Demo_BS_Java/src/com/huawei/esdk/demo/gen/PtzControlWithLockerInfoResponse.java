
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
 *         &lt;element name="ptzControlInfo" type="{esdk_ivs_professional_server}PTZControlInfo" minOccurs="0"/>
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
    "ptzControlInfo"
})
@XmlRootElement(name = "ptzControlWithLockerInfoResponse")
public class PtzControlWithLockerInfoResponse {

    protected int resultCode;
    protected PTZControlInfo ptzControlInfo;

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
     * Gets the value of the ptzControlInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PTZControlInfo }
     *     
     */
    public PTZControlInfo getPtzControlInfo() {
        return ptzControlInfo;
    }

    /**
     * Sets the value of the ptzControlInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PTZControlInfo }
     *     
     */
    public void setPtzControlInfo(PTZControlInfo value) {
        this.ptzControlInfo = value;
    }

}
