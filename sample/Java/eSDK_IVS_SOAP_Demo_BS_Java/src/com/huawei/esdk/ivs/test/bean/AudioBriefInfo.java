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
package com.huawei.esdk.ivs.test.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.huawei.esdk.ivs.test.service.impl.autogen.Adapter3;


/**
 * <p>Java class for AudioBriefInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AudioBriefInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deviceGroupId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="audioCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="audioName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="channelType" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "AudioBriefInfo", propOrder = {
    "deviceGroupId",
    "audioCode",
    "domainCode",
    "audioName",
    "channelType",
    "reserve"
})
public class AudioBriefInfo {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer deviceGroupId;
    @XmlElement(required = true)
    protected String audioCode;
    @XmlElement(required = true)
    protected String domainCode;
    @XmlElement(required = true)
    protected String audioName;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer channelType;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the deviceGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDeviceGroupId() {
        return deviceGroupId;
    }

    /**
     * Sets the value of the deviceGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceGroupId(Integer value) {
        this.deviceGroupId = value;
    }

    /**
     * Gets the value of the audioCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAudioCode() {
        return audioCode;
    }

    /**
     * Sets the value of the audioCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAudioCode(String value) {
        this.audioCode = value;
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
     * Gets the value of the audioName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAudioName() {
        return audioName;
    }

    /**
     * Sets the value of the audioName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAudioName(String value) {
        this.audioName = value;
    }

    /**
     * Gets the value of the channelType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getChannelType() {
        return channelType;
    }

    /**
     * Sets the value of the channelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelType(Integer value) {
        this.channelType = value;
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
