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
 * <p>Java class for SerialChannelConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SerialChannelConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serialIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serialType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="baudRate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dataBit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stopBit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="flowControl" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "SerialChannelConfig", propOrder = {
    "serialName",
    "serialIndex",
    "serialType",
    "baudRate",
    "dataBit",
    "parity",
    "stopBit",
    "flowControl",
    "reserve"
})
public class SerialChannelConfig {

    @XmlElement(required = true)
    protected String serialName;
    protected int serialIndex;
    protected int serialType;
    protected int baudRate;
    protected int dataBit;
    protected int parity;
    protected int stopBit;
    protected int flowControl;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the serialName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialName() {
        return serialName;
    }

    /**
     * Sets the value of the serialName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialName(String value) {
        this.serialName = value;
    }

    /**
     * Gets the value of the serialIndex property.
     * 
     */
    public int getSerialIndex() {
        return serialIndex;
    }

    /**
     * Sets the value of the serialIndex property.
     * 
     */
    public void setSerialIndex(int value) {
        this.serialIndex = value;
    }

    /**
     * Gets the value of the serialType property.
     * 
     */
    public int getSerialType() {
        return serialType;
    }

    /**
     * Sets the value of the serialType property.
     * 
     */
    public void setSerialType(int value) {
        this.serialType = value;
    }

    /**
     * Gets the value of the baudRate property.
     * 
     */
    public int getBaudRate() {
        return baudRate;
    }

    /**
     * Sets the value of the baudRate property.
     * 
     */
    public void setBaudRate(int value) {
        this.baudRate = value;
    }

    /**
     * Gets the value of the dataBit property.
     * 
     */
    public int getDataBit() {
        return dataBit;
    }

    /**
     * Sets the value of the dataBit property.
     * 
     */
    public void setDataBit(int value) {
        this.dataBit = value;
    }

    /**
     * Gets the value of the parity property.
     * 
     */
    public int getParity() {
        return parity;
    }

    /**
     * Sets the value of the parity property.
     * 
     */
    public void setParity(int value) {
        this.parity = value;
    }

    /**
     * Gets the value of the stopBit property.
     * 
     */
    public int getStopBit() {
        return stopBit;
    }

    /**
     * Sets the value of the stopBit property.
     * 
     */
    public void setStopBit(int value) {
        this.stopBit = value;
    }

    /**
     * Gets the value of the flowControl property.
     * 
     */
    public int getFlowControl() {
        return flowControl;
    }

    /**
     * Sets the value of the flowControl property.
     * 
     */
    public void setFlowControl(int value) {
        this.flowControl = value;
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
