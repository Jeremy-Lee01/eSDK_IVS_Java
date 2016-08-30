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
package com.huawei.esdk.ivs.northcommu.cxf.professional.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlarmBriefInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmBriefInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deviceGroupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="channelType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parentCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isExDomain" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "AlarmBriefInfo", propOrder = {
    "deviceGroupCode",
    "alarmCode",
    "domainCode",
    "alarmName",
    "channelType",
    "parentCode",
    "isExDomain",
    "reserve"
})
public class AlarmBriefInfo {

    @XmlElement(required = true)
    protected String deviceGroupCode;
    @XmlElement(required = true)
    protected String alarmCode;
    @XmlElement(required = true)
    protected String domainCode;
    @XmlElement(required = true)
    protected String alarmName;
    protected int channelType;
    @XmlElement(required = true)
    protected String parentCode;
    protected int isExDomain;
    @XmlElement(required = true)
    protected String reserve;

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
     * Gets the value of the alarmCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmCode() {
        return alarmCode;
    }

    /**
     * Sets the value of the alarmCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmCode(String value) {
        this.alarmCode = value;
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
     * Gets the value of the alarmName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmName() {
        return alarmName;
    }

    /**
     * Sets the value of the alarmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmName(String value) {
        this.alarmName = value;
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
