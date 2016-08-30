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
 * <p>Java class for StreamInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StreamInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="streamType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="encodeType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="profile" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="frameInterval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="resolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="picQuality" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transProtocol" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pktProtocol" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bitRateType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bitRate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="frameRate" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "StreamInfo", propOrder = {
    "streamType",
    "encodeType",
    "profile",
    "frameInterval",
    "resolution",
    "picQuality",
    "transProtocol",
    "pktProtocol",
    "bitRateType",
    "bitRate",
    "frameRate",
    "reserve"
})
public class StreamInfo {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer streamType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer encodeType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer profile;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer frameInterval;
    @XmlElement(required = true)
    protected String resolution;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer picQuality;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer transProtocol;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer pktProtocol;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer bitRateType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer bitRate;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer frameRate;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the streamType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getStreamType() {
        return streamType;
    }

    /**
     * Sets the value of the streamType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreamType(Integer value) {
        this.streamType = value;
    }

    /**
     * Gets the value of the encodeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEncodeType() {
        return encodeType;
    }

    /**
     * Sets the value of the encodeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncodeType(Integer value) {
        this.encodeType = value;
    }

    /**
     * Gets the value of the profile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfile(Integer value) {
        this.profile = value;
    }

    /**
     * Gets the value of the frameInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getFrameInterval() {
        return frameInterval;
    }

    /**
     * Sets the value of the frameInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrameInterval(Integer value) {
        this.frameInterval = value;
    }

    /**
     * Gets the value of the resolution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Sets the value of the resolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolution(String value) {
        this.resolution = value;
    }

    /**
     * Gets the value of the picQuality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPicQuality() {
        return picQuality;
    }

    /**
     * Sets the value of the picQuality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPicQuality(Integer value) {
        this.picQuality = value;
    }

    /**
     * Gets the value of the transProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getTransProtocol() {
        return transProtocol;
    }

    /**
     * Sets the value of the transProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransProtocol(Integer value) {
        this.transProtocol = value;
    }

    /**
     * Gets the value of the pktProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPktProtocol() {
        return pktProtocol;
    }

    /**
     * Sets the value of the pktProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPktProtocol(Integer value) {
        this.pktProtocol = value;
    }

    /**
     * Gets the value of the bitRateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getBitRateType() {
        return bitRateType;
    }

    /**
     * Sets the value of the bitRateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBitRateType(Integer value) {
        this.bitRateType = value;
    }

    /**
     * Gets the value of the bitRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getBitRate() {
        return bitRate;
    }

    /**
     * Sets the value of the bitRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBitRate(Integer value) {
        this.bitRate = value;
    }

    /**
     * Gets the value of the frameRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getFrameRate() {
        return frameRate;
    }

    /**
     * Sets the value of the frameRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrameRate(Integer value) {
        this.frameRate = value;
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
