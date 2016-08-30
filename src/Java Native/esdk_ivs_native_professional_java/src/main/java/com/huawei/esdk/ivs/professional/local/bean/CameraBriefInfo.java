/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.ivs.professional.local.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.huawei.esdk.ivs.professional.local.impl.autogen.Adapter3;


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
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer deviceFormType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer type;
    @XmlElement(required = true)
    protected String cameraLocation;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer cameraStatus;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer status;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer netType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer isSupportIntelligent;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableVoice;
    @XmlElement(required = true)
    protected String nvrCode;
    @XmlElement(required = true)
    protected String deviceCreateTime;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer isExDomain;
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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDeviceFormType() {
        return deviceFormType;
    }

    /**
     * Sets the value of the deviceFormType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceFormType(Integer value) {
        this.deviceFormType = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(Integer value) {
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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getCameraStatus() {
        return cameraStatus;
    }

    /**
     * Sets the value of the cameraStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCameraStatus(Integer value) {
        this.cameraStatus = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    /**
     * Gets the value of the netType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getNetType() {
        return netType;
    }

    /**
     * Sets the value of the netType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetType(Integer value) {
        this.netType = value;
    }

    /**
     * Gets the value of the isSupportIntelligent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsSupportIntelligent() {
        return isSupportIntelligent;
    }

    /**
     * Sets the value of the isSupportIntelligent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsSupportIntelligent(Integer value) {
        this.isSupportIntelligent = value;
    }

    /**
     * Gets the value of the enableVoice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableVoice() {
        return enableVoice;
    }

    /**
     * Sets the value of the enableVoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableVoice(Integer value) {
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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsExDomain() {
        return isExDomain;
    }

    /**
     * Sets the value of the isExDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsExDomain(Integer value) {
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
