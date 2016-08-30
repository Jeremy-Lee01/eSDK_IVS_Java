
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PTZControlInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PTZControlInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lockStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ip" type="{esdk_ivs_professional_server}IPInfo"/>
 *         &lt;element name="releaseTimeRemain" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "PTZControlInfo", propOrder = {
    "lockStatus",
    "userId",
    "userName",
    "ip",
    "releaseTimeRemain",
    "reserve"
})
public class PTZControlInfo {

    protected int lockStatus;
    protected int userId;
    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected IPInfo ip;
    protected int releaseTimeRemain;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the lockStatus property.
     * 
     */
    public int getLockStatus() {
        return lockStatus;
    }

    /**
     * Sets the value of the lockStatus property.
     * 
     */
    public void setLockStatus(int value) {
        this.lockStatus = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the ip property.
     * 
     * @return
     *     possible object is
     *     {@link IPInfo }
     *     
     */
    public IPInfo getIp() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPInfo }
     *     
     */
    public void setIp(IPInfo value) {
        this.ip = value;
    }

    /**
     * Gets the value of the releaseTimeRemain property.
     * 
     */
    public int getReleaseTimeRemain() {
        return releaseTimeRemain;
    }

    /**
     * Sets the value of the releaseTimeRemain property.
     * 
     */
    public void setReleaseTimeRemain(int value) {
        this.releaseTimeRemain = value;
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
