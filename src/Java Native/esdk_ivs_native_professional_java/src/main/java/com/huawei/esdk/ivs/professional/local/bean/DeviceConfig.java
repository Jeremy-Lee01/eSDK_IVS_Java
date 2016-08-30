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
 * <p>Java class for DeviceConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DeviceBasicInfo" type="{esdk_ivs_professional_server}DeviceBasicInfo"/>
 *         &lt;element name="protocolType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loginType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableAlarm" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="videoFormat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="directConnectFirst" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxDirectConnectNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableSchedule" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nvrCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tasCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceUser" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="devicePassword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceRegPassword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceChannel" type="{esdk_ivs_professional_server}DeviceChannel"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tasIP" type="{esdk_ivs_professional_server}IPInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceConfig", propOrder = {
    "deviceBasicInfo",
    "protocolType",
    "loginType",
    "enableAlarm",
    "videoFormat",
    "directConnectFirst",
    "maxDirectConnectNum",
    "enableSchedule",
    "nvrCode",
    "tasCode",
    "deviceUser",
    "devicePassword",
    "deviceRegPassword",
    "deviceChannel",
    "reserve",
    "tasIP"
})
public class DeviceConfig {

    @XmlElement(name = "DeviceBasicInfo", required = true)
    protected DeviceBasicInfo deviceBasicInfo;
    @XmlElement(required = true)
    protected String protocolType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer loginType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableAlarm;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer videoFormat;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer directConnectFirst;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer maxDirectConnectNum;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableSchedule;
    @XmlElement(required = true)
    protected String nvrCode;
    @XmlElement(required = true)
    protected String tasCode;
    @XmlElement(required = true)
    protected String deviceUser;
    @XmlElement(required = true)
    protected String devicePassword;
    @XmlElement(required = true)
    protected String deviceRegPassword;
    @XmlElement(required = true)
    protected DeviceChannel deviceChannel;
    @XmlElement(required = true)
    protected String reserve;
    @XmlElement(required = true)
    protected IPInfo tasIP;

    /**
     * Gets the value of the deviceBasicInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceBasicInfo }
     *     
     */
    public DeviceBasicInfo getDeviceBasicInfo() {
        return deviceBasicInfo;
    }

    /**
     * Sets the value of the deviceBasicInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceBasicInfo }
     *     
     */
    public void setDeviceBasicInfo(DeviceBasicInfo value) {
        this.deviceBasicInfo = value;
    }

    /**
     * Gets the value of the protocolType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolType() {
        return protocolType;
    }

    /**
     * Sets the value of the protocolType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolType(String value) {
        this.protocolType = value;
    }

    /**
     * Gets the value of the loginType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getLoginType() {
        return loginType;
    }

    /**
     * Sets the value of the loginType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginType(Integer value) {
        this.loginType = value;
    }

    /**
     * Gets the value of the enableAlarm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableAlarm() {
        return enableAlarm;
    }

    /**
     * Sets the value of the enableAlarm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableAlarm(Integer value) {
        this.enableAlarm = value;
    }

    /**
     * Gets the value of the videoFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getVideoFormat() {
        return videoFormat;
    }

    /**
     * Sets the value of the videoFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVideoFormat(Integer value) {
        this.videoFormat = value;
    }

    /**
     * Gets the value of the directConnectFirst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDirectConnectFirst() {
        return directConnectFirst;
    }

    /**
     * Sets the value of the directConnectFirst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectConnectFirst(Integer value) {
        this.directConnectFirst = value;
    }

    /**
     * Gets the value of the maxDirectConnectNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getMaxDirectConnectNum() {
        return maxDirectConnectNum;
    }

    /**
     * Sets the value of the maxDirectConnectNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxDirectConnectNum(Integer value) {
        this.maxDirectConnectNum = value;
    }

    /**
     * Gets the value of the enableSchedule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableSchedule() {
        return enableSchedule;
    }

    /**
     * Sets the value of the enableSchedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableSchedule(Integer value) {
        this.enableSchedule = value;
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
     * Gets the value of the tasCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTasCode() {
        return tasCode;
    }

    /**
     * Sets the value of the tasCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTasCode(String value) {
        this.tasCode = value;
    }

    /**
     * Gets the value of the deviceUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceUser() {
        return deviceUser;
    }

    /**
     * Sets the value of the deviceUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceUser(String value) {
        this.deviceUser = value;
    }

    /**
     * Gets the value of the devicePassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevicePassword() {
        return devicePassword;
    }

    /**
     * Sets the value of the devicePassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevicePassword(String value) {
        this.devicePassword = value;
    }

    /**
     * Gets the value of the deviceRegPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceRegPassword() {
        return deviceRegPassword;
    }

    /**
     * Sets the value of the deviceRegPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceRegPassword(String value) {
        this.deviceRegPassword = value;
    }

    /**
     * Gets the value of the deviceChannel property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceChannel }
     *     
     */
    public DeviceChannel getDeviceChannel() {
        return deviceChannel;
    }

    /**
     * Sets the value of the deviceChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceChannel }
     *     
     */
    public void setDeviceChannel(DeviceChannel value) {
        this.deviceChannel = value;
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

    /**
     * Gets the value of the tasIP property.
     * 
     * @return
     *     possible object is
     *     {@link IPInfo }
     *     
     */
    public IPInfo getTasIP() {
        return tasIP;
    }

    /**
     * Sets the value of the tasIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPInfo }
     *     
     */
    public void setTasIP(IPInfo value) {
        this.tasIP = value;
    }

}
