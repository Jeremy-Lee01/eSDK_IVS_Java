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
 * <p>Java class for AudioConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AudioConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="audioName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="channelType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="audioIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="audioParam" type="{esdk_ivs_professional_server}AudioParam"/>
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
@XmlType(name = "AudioConfig", propOrder = {
    "audioName",
    "channelType",
    "audioIndex",
    "audioParam",
    "reserve"
})
public class AudioConfig {

    @XmlElement(required = true)
    protected String audioName;
    protected int channelType;
    protected int audioIndex;
    @XmlElement(required = true)
    protected AudioParam audioParam;
    @XmlElement(required = true)
    protected String reserve;

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
     * Gets the value of the audioIndex property.
     * 
     */
    public int getAudioIndex() {
        return audioIndex;
    }

    /**
     * Sets the value of the audioIndex property.
     * 
     */
    public void setAudioIndex(int value) {
        this.audioIndex = value;
    }

    /**
     * Gets the value of the audioParam property.
     * 
     * @return
     *     possible object is
     *     {@link AudioParam }
     *     
     */
    public AudioParam getAudioParam() {
        return audioParam;
    }

    /**
     * Sets the value of the audioParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link AudioParam }
     *     
     */
    public void setAudioParam(AudioParam value) {
        this.audioParam = value;
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
