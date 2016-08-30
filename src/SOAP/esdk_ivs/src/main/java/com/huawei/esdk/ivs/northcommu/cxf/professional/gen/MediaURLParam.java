/**
 * Copyright 2016 Huawei Technologies Co., Ltd. All rights reserved.
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
 * <p>Java class for MediaURLParam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaURLParam">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="packProtocolType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeSpan" type="{esdk_ivs_professional_server}TimeSpan" minOccurs="0"/>
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="streamType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="protocolType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="broadCastType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="videoDecType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="audioDecType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NVRCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaURLParam", propOrder = {
    "serviceType",
    "packProtocolType",
    "timeSpan",
    "fileName",
    "clientType",
    "streamType",
    "protocolType",
    "transMode",
    "broadCastType",
    "videoDecType",
    "audioDecType",
    "nvrCode",
    "reserve"
})
public class MediaURLParam {

    protected int serviceType;
    protected int packProtocolType;
    protected TimeSpan timeSpan;
    protected String fileName;
    protected int clientType;
    protected int streamType;
    protected int protocolType;
    protected int transMode;
    protected int broadCastType;
    protected int videoDecType;
    protected int audioDecType;
    @XmlElement(name = "NVRCode", required = true)
    protected String nvrCode;
    protected String reserve;

    /**
     * Gets the value of the serviceType property.
     * 
     */
    public int getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     */
    public void setServiceType(int value) {
        this.serviceType = value;
    }

    /**
     *Gets the value of the packProtocolType property.
     * 
     */
    public int getPackProtocolType() {
        return packProtocolType;
    }

    /**
     * Sets the value of the packProtocolType property.
     * 
     */
    public void setPackProtocolType(int value) {
        this.packProtocolType = value;
    }

    /**
     *Gets the value of the timeSpan property.
     * 
     * @return
     *     possible object is
     *     {@link TimeSpan }
     *     
     */
    public TimeSpan getTimeSpan() {
        return timeSpan;
    }

    /**
     * Sets the value of the timeSpan property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeSpan }
     *     
     */
    public void setTimeSpan(TimeSpan value) {
        this.timeSpan = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the clientType property.
     * 
     */
    public int getClientType() {
        return clientType;
    }

    /**
     * Sets the value of the clientType property.
     * 
     */
    public void setClientType(int value) {
        this.clientType = value;
    }

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
     * Gets the value of the protocolType property.
     * 
     */
    public int getProtocolType() {
        return protocolType;
    }

    /**
     * Sets the value of the protocolType property.
     * 
     */
    public void setProtocolType(int value) {
        this.protocolType = value;
    }

    /**
     * Gets the value of the transMode property.
     * 
     */
    public int getTransMode() {
        return transMode;
    }

    /**
     * Sets the value of the transMode property.
     * 
     */
    public void setTransMode(int value) {
        this.transMode = value;
    }

    /**
     * Gets the value of the broadCastType property.
     * 
     */
    public int getBroadCastType() {
        return broadCastType;
    }

    /**
     * Sets the value of the broadCastType property.
     * 
     */
    public void setBroadCastType(int value) {
        this.broadCastType = value;
    }

    /**
     * Gets the value of the videoDecType property.
     * 
     */
    public int getVideoDecType() {
        return videoDecType;
    }

    /**
     * Sets the value of the videoDecType property.
     * 
     */
    public void setVideoDecType(int value) {
        this.videoDecType = value;
    }

    /**
     * Gets the value of the audioDecType property.
     * 
     */
    public int getAudioDecType() {
        return audioDecType;
    }

    /**
     * Sets the value of the audioDecType property.
     * 
     */
    public void setAudioDecType(int value) {
        this.audioDecType = value;
    }

    /**
     * Gets the value of the nvrCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNVRCode() {
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
    public void setNVRCode(String value) {
        this.nvrCode = value;
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
