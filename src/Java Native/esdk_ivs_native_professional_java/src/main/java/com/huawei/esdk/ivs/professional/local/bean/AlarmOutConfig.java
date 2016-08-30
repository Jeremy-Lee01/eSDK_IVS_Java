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
 * <p>Java class for AlarmOutConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmOutConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmOutName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmOutChanIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="switchType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmOutMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="holdTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "AlarmOutConfig", propOrder = {
    "alarmOutName",
    "alarmOutChanIndex",
    "switchType",
    "alarmOutMode",
    "holdTime",
    "reserve"
})
public class AlarmOutConfig {

    @XmlElement(required = true)
    protected String alarmOutName;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer alarmOutChanIndex;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer switchType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer alarmOutMode;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer holdTime;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the alarmOutName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmOutName() {
        return alarmOutName;
    }

    /**
     * Sets the value of the alarmOutName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmOutName(String value) {
        this.alarmOutName = value;
    }

    /**
     * Gets the value of the alarmOutChanIndex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAlarmOutChanIndex() {
        return alarmOutChanIndex;
    }

    /**
     * Sets the value of the alarmOutChanIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmOutChanIndex(Integer value) {
        this.alarmOutChanIndex = value;
    }

    /**
     * Gets the value of the switchType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getSwitchType() {
        return switchType;
    }

    /**
     * Sets the value of the switchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchType(Integer value) {
        this.switchType = value;
    }

    /**
     * Gets the value of the alarmOutMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAlarmOutMode() {
        return alarmOutMode;
    }

    /**
     * Sets the value of the alarmOutMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmOutMode(Integer value) {
        this.alarmOutMode = value;
    }

    /**
     * Gets the value of the holdTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getHoldTime() {
        return holdTime;
    }

    /**
     * Sets the value of the holdTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoldTime(Integer value) {
        this.holdTime = value;
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
