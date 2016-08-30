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
 * <p>Java class for AlarmInConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmInConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmInName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmInChanIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="switchType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="autoClearAlarmTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "AlarmInConfig", propOrder = {
    "alarmInName",
    "alarmInChanIndex",
    "switchType",
    "autoClearAlarmTime",
    "reserve"
})
public class AlarmInConfig {

    @XmlElement(required = true)
    protected String alarmInName;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer alarmInChanIndex;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer switchType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer autoClearAlarmTime;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the alarmInName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmInName() {
        return alarmInName;
    }

    /**
     * Sets the value of the alarmInName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmInName(String value) {
        this.alarmInName = value;
    }

    /**
     * Gets the value of the alarmInChanIndex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAlarmInChanIndex() {
        return alarmInChanIndex;
    }

    /**
     * Sets the value of the alarmInChanIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmInChanIndex(Integer value) {
        this.alarmInChanIndex = value;
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
     * Gets the value of the autoClearAlarmTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAutoClearAlarmTime() {
        return autoClearAlarmTime;
    }

    /**
     * Sets the value of the autoClearAlarmTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoClearAlarmTime(Integer value) {
        this.autoClearAlarmTime = value;
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
