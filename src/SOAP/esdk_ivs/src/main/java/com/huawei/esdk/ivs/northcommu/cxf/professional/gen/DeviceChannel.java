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
 * <p>Java class for DeviceChannel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceChannel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maxVideoNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxAudioInNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxAudioOutNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxAlarmInNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxAlarmOutNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxSerialNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "DeviceChannel", propOrder = {
    "maxVideoNum",
    "maxAudioInNum",
    "maxAudioOutNum",
    "maxAlarmInNum",
    "maxAlarmOutNum",
    "maxSerialNum",
    "reserve"
})
public class DeviceChannel {

    protected int maxVideoNum;
    protected int maxAudioInNum;
    protected int maxAudioOutNum;
    protected int maxAlarmInNum;
    protected int maxAlarmOutNum;
    protected int maxSerialNum;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the maxVideoNum property.
     * 
     */
    public int getMaxVideoNum() {
        return maxVideoNum;
    }

    /**
     * Sets the value of the maxVideoNum property.
     * 
     */
    public void setMaxVideoNum(int value) {
        this.maxVideoNum = value;
    }

    /**
     * Gets the value of the maxAudioInNum property.
     * 
     */
    public int getMaxAudioInNum() {
        return maxAudioInNum;
    }

    /**
     * Sets the value of the maxAudioInNum property.
     * 
     */
    public void setMaxAudioInNum(int value) {
        this.maxAudioInNum = value;
    }

    /**
     * Gets the value of the maxAudioOutNum property.
     * 
     */
    public int getMaxAudioOutNum() {
        return maxAudioOutNum;
    }

    /**
     * Sets the value of the maxAudioOutNum property.
     * 
     */
    public void setMaxAudioOutNum(int value) {
        this.maxAudioOutNum = value;
    }

    /**
     * Gets the value of the maxAlarmInNum property.
     * 
     */
    public int getMaxAlarmInNum() {
        return maxAlarmInNum;
    }

    /**
     * Sets the value of the maxAlarmInNum property.
     * 
     */
    public void setMaxAlarmInNum(int value) {
        this.maxAlarmInNum = value;
    }

    /**
     * Gets the value of the maxAlarmOutNum property.
     * 
     */
    public int getMaxAlarmOutNum() {
        return maxAlarmOutNum;
    }

    /**
     * Sets the value of the maxAlarmOutNum property.
     * 
     */
    public void setMaxAlarmOutNum(int value) {
        this.maxAlarmOutNum = value;
    }

    /**
     * Gets the value of the maxSerialNum property.
     * 
     */
    public int getMaxSerialNum() {
        return maxSerialNum;
    }

    /**
     * Sets the value of the maxSerialNum property.
     * 
     */
    public void setMaxSerialNum(int value) {
        this.maxSerialNum = value;
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
