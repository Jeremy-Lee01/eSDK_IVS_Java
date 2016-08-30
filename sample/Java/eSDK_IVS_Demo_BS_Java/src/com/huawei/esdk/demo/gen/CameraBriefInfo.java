
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CameraBriefInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CameraBriefInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceGroupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parentCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceModelType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vendorType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceFormType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cameraLocation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cameraStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="netType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isSupportIntelligent" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableVoice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nvrCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceCreateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isExDomain" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deviceIP" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "CameraBriefInfo", propOrder = {
    "code",
    "name",
    "deviceGroupCode",
    "parentCode",
    "domainCode",
    "deviceModelType",
    "vendorType",
    "deviceFormType",
    "type",
    "cameraLocation",
    "cameraStatus",
    "status",
    "netType",
    "isSupportIntelligent",
    "enableVoice",
    "nvrCode",
    "deviceCreateTime",
    "isExDomain",
    "deviceIP",
    "reserve"
})
public class CameraBriefInfo {

    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String deviceGroupCode;
    @XmlElement(required = true)
    protected String parentCode;
    @XmlElement(required = true)
    protected String domainCode;
    @XmlElement(required = true)
    protected String deviceModelType;
    @XmlElement(required = true)
    protected String vendorType;
    protected int deviceFormType;
    protected int type;
    @XmlElement(required = true)
    protected String cameraLocation;
    protected int cameraStatus;
    protected int status;
    protected int netType;
    protected int isSupportIntelligent;
    protected int enableVoice;
    @XmlElement(required = true)
    protected String nvrCode;
    @XmlElement(required = true)
    protected String deviceCreateTime;
    protected int isExDomain;
    @XmlElement(required = true)
    protected String deviceIP;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the deviceGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceGroupCode() {
        return deviceGroupCode;
    }

    /**
     * Sets the value of the deviceGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceGroupCode(String value) {
        this.deviceGroupCode = value;
    }

    /**
     * Gets the value of the parentCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * Sets the value of the parentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentCode(String value) {
        this.parentCode = value;
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
     * Gets the value of the deviceModelType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceModelType() {
        return deviceModelType;
    }

    /**
     * Sets the value of the deviceModelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceModelType(String value) {
        this.deviceModelType = value;
    }

    /**
     * Gets the value of the vendorType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorType() {
        return vendorType;
    }

    /**
     * Sets the value of the vendorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorType(String value) {
        this.vendorType = value;
    }

    /**
     * Gets the value of the deviceFormType property.
     * 
     */
    public int getDeviceFormType() {
        return deviceFormType;
    }

    /**
     * Sets the value of the deviceFormType property.
     * 
     */
    public void setDeviceFormType(int value) {
        this.deviceFormType = value;
    }

    /**
     * Gets the value of the type property.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

    /**
     * Gets the value of the cameraLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCameraLocation() {
        return cameraLocation;
    }

    /**
     * Sets the value of the cameraLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCameraLocation(String value) {
        this.cameraLocation = value;
    }

    /**
     * Gets the value of the cameraStatus property.
     * 
     */
    public int getCameraStatus() {
        return cameraStatus;
    }

    /**
     * Sets the value of the cameraStatus property.
     * 
     */
    public void setCameraStatus(int value) {
        this.cameraStatus = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the netType property.
     * 
     */
    public int getNetType() {
        return netType;
    }

    /**
     * Sets the value of the netType property.
     * 
     */
    public void setNetType(int value) {
        this.netType = value;
    }

    /**
     * Gets the value of the isSupportIntelligent property.
     * 
     */
    public int getIsSupportIntelligent() {
        return isSupportIntelligent;
    }

    /**
     * Sets the value of the isSupportIntelligent property.
     * 
     */
    public void setIsSupportIntelligent(int value) {
        this.isSupportIntelligent = value;
    }

    /**
     * Gets the value of the enableVoice property.
     * 
     */
    public int getEnableVoice() {
        return enableVoice;
    }

    /**
     * Sets the value of the enableVoice property.
     * 
     */
    public void setEnableVoice(int value) {
        this.enableVoice = value;
    }

    /**
     * Gets the value of the nvrCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNvrCode() {
        return nvrCode;
    }

    /**
     * Sets the value of the nvrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNvrCode(String value) {
        this.nvrCode = value;
    }

    /**
     * Gets the value of the deviceCreateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceCreateTime() {
        return deviceCreateTime;
    }

    /**
     * Sets the value of the deviceCreateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceCreateTime(String value) {
        this.deviceCreateTime = value;
    }

    /**
     * Gets the value of the isExDomain property.
     * 
     */
    public int getIsExDomain() {
        return isExDomain;
    }

    /**
     * Sets the value of the isExDomain property.
     * 
     */
    public void setIsExDomain(int value) {
        this.isExDomain = value;
    }

    /**
     * Gets the value of the deviceIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceIP() {
        return deviceIP;
    }

    /**
     * Sets the value of the deviceIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceIP(String value) {
        this.deviceIP = value;
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
