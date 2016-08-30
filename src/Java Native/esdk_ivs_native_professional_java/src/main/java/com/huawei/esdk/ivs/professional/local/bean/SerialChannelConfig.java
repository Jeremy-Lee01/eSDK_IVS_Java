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
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer serialIndex;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer serialType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer baudRate;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer dataBit;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer parity;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer stopBit;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer flowControl;
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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getSerialIndex() {
        return serialIndex;
    }

    /**
     * Sets the value of the serialIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialIndex(Integer value) {
        this.serialIndex = value;
    }

    /**
     * Gets the value of the serialType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getSerialType() {
        return serialType;
    }

    /**
     * Sets the value of the serialType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialType(Integer value) {
        this.serialType = value;
    }

    /**
     * Gets the value of the baudRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getBaudRate() {
        return baudRate;
    }

    /**
     * Sets the value of the baudRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaudRate(Integer value) {
        this.baudRate = value;
    }

    /**
     * Gets the value of the dataBit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDataBit() {
        return dataBit;
    }

    /**
     * Sets the value of the dataBit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataBit(Integer value) {
        this.dataBit = value;
    }

    /**
     * Gets the value of the parity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getParity() {
        return parity;
    }

    /**
     * Sets the value of the parity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParity(Integer value) {
        this.parity = value;
    }

    /**
     * Gets the value of the stopBit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getStopBit() {
        return stopBit;
    }

    /**
     * Sets the value of the stopBit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopBit(Integer value) {
        this.stopBit = value;
    }

    /**
     * Gets the value of the flowControl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getFlowControl() {
        return flowControl;
    }

    /**
     * Sets the value of the flowControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlowControl(Integer value) {
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
