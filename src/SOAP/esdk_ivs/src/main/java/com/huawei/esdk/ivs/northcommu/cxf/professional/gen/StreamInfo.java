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

    protected int streamType;
    protected int encodeType;
    protected int profile;
    protected int frameInterval;
    @XmlElement(required = true)
    protected String resolution;
    protected int picQuality;
    protected int transProtocol;
    protected int pktProtocol;
    protected int bitRateType;
    protected int bitRate;
    protected int frameRate;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the streamType property.
     * 
     */
    public int getStreamType() {
        return streamType;
    }

    /**
     * Sets the value of the streamType property.
     * 
     */
    public void setStreamType(int value) {
        this.streamType = value;
    }

    /**
     * Gets the value of the encodeType property.
     * 
     */
    public int getEncodeType() {
        return encodeType;
    }

    /**
     * Sets the value of the encodeType property.
     * 
     */
    public void setEncodeType(int value) {
        this.encodeType = value;
    }

    /**
     * Gets the value of the profile property.
     * 
     */
    public int getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     * 
     */
    public void setProfile(int value) {
        this.profile = value;
    }

    /**
     * Gets the value of the frameInterval property.
     * 
     */
    public int getFrameInterval() {
        return frameInterval;
    }

    /**
     * Sets the value of the frameInterval property.
     * 
     */
    public void setFrameInterval(int value) {
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
     */
    public int getPicQuality() {
        return picQuality;
    }

    /**
     * Sets the value of the picQuality property.
     * 
     */
    public void setPicQuality(int value) {
        this.picQuality = value;
    }

    /**
     * Gets the value of the transProtocol property.
     * 
     */
    public int getTransProtocol() {
        return transProtocol;
    }

    /**
     * Sets the value of the transProtocol property.
     * 
     */
    public void setTransProtocol(int value) {
        this.transProtocol = value;
    }

    /**
     * Gets the value of the pktProtocol property.
     * 
     */
    public int getPktProtocol() {
        return pktProtocol;
    }

    /**
     * Sets the value of the pktProtocol property.
     * 
     */
    public void setPktProtocol(int value) {
        this.pktProtocol = value;
    }

    /**
     * Gets the value of the bitRateType property.
     * 
     */
    public int getBitRateType() {
        return bitRateType;
    }

    /**
     * Sets the value of the bitRateType property.
     * 
     */
    public void setBitRateType(int value) {
        this.bitRateType = value;
    }

    /**
     * Gets the value of the bitRate property.
     * 
     */
    public int getBitRate() {
        return bitRate;
    }

    /**
     * Sets the value of the bitRate property.
     * 
     */
    public void setBitRate(int value) {
        this.bitRate = value;
    }

    /**
     * Gets the value of the frameRate property.
     * 
     */
    public int getFrameRate() {
        return frameRate;
    }

    /**
     * Sets the value of the frameRate property.
     * 
     */
    public void setFrameRate(int value) {
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
