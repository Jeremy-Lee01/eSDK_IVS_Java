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
 * <p>Java class for OSDTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OSDTime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableOSDTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeFormat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeX" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="timeY" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
@XmlType(name = "OSDTime", propOrder = {
    "enableOSDTime",
    "timeFormat",
    "timeX",
    "timeY",
    "reserve"
})
public class OSDTime {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableOSDTime;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer timeFormat;
    protected double timeX;
    protected double timeY;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enableOSDTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableOSDTime() {
        return enableOSDTime;
    }

    /**
     * Sets the value of the enableOSDTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableOSDTime(Integer value) {
        this.enableOSDTime = value;
    }

    /**
     * Gets the value of the timeFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getTimeFormat() {
        return timeFormat;
    }

    /**
     * Sets the value of the timeFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeFormat(Integer value) {
        this.timeFormat = value;
    }

    /**
     * Gets the value of the timeX property.
     * 
     */
    public double getTimeX() {
        return timeX;
    }

    /**
     * Sets the value of the timeX property.
     * 
     */
    public void setTimeX(double value) {
        this.timeX = value;
    }

    /**
     * Gets the value of the timeY property.
     * 
     */
    public double getTimeY() {
        return timeY;
    }

    /**
     * Sets the value of the timeY property.
     * 
     */
    public void setTimeY(double value) {
        this.timeY = value;
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
