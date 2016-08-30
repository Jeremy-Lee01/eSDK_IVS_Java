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
 * <p>Java class for PTZConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PTZConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="decoderType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="decoderAddress" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="posNegDirectControl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serialCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "PTZConfig", propOrder = {
    "decoderType",
    "decoderAddress",
    "posNegDirectControl",
    "serialCode",
    "reserve"
})
public class PTZConfig {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer decoderType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer decoderAddress;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer posNegDirectControl;
    @XmlElement(required = true)
    protected String serialCode;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the decoderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDecoderType() {
        return decoderType;
    }

    /**
     * Sets the value of the decoderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecoderType(Integer value) {
        this.decoderType = value;
    }

    /**
     * Gets the value of the decoderAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDecoderAddress() {
        return decoderAddress;
    }

    /**
     * Sets the value of the decoderAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecoderAddress(Integer value) {
        this.decoderAddress = value;
    }

    /**
     * Gets the value of the posNegDirectControl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPosNegDirectControl() {
        return posNegDirectControl;
    }

    /**
     * Sets the value of the posNegDirectControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosNegDirectControl(Integer value) {
        this.posNegDirectControl = value;
    }

    /**
     * Gets the value of the serialCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialCode() {
        return serialCode;
    }

    /**
     * Sets the value of the serialCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialCode(String value) {
        this.serialCode = value;
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
