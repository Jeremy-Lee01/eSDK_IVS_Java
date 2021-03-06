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
 * <p>Java class for AlarmLevel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmLevel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmLevelId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmLevelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isUserDefined" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "AlarmLevel", propOrder = {
    "alarmLevelId",
    "alarmLevelName",
    "value",
    "color",
    "description",
    "isUserDefined",
    "reserve"
})
public class AlarmLevel {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer alarmLevelId;
    @XmlElement(required = true)
    protected String alarmLevelName;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer value;
    @XmlElement(required = true)
    protected String color;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer isUserDefined;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the alarmLevelId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAlarmLevelId() {
        return alarmLevelId;
    }

    /**
     * Sets the value of the alarmLevelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmLevelId(Integer value) {
        this.alarmLevelId = value;
    }

    /**
     * Gets the value of the alarmLevelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmLevelName() {
        return alarmLevelName;
    }

    /**
     * Sets the value of the alarmLevelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmLevelName(String value) {
        this.alarmLevelName = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the isUserDefined property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsUserDefined() {
        return isUserDefined;
    }

    /**
     * Sets the value of the isUserDefined property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsUserDefined(Integer value) {
        this.isUserDefined = value;
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
