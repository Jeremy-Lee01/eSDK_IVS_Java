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
 * <p>Java class for AlarmTypeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmTypeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmTypeID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmInType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isUserDefined" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmLevel" type="{esdk_ivs_professional_server}AlarmLevel"/>
 *         &lt;element name="enable" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "AlarmTypeInfo", propOrder = {
    "alarmTypeID",
    "alarmTypeCode",
    "alarmTypeName",
    "alarmInType",
    "category",
    "isUserDefined",
    "alarmLevel",
    "enable",
    "reserve"
})
public class AlarmTypeInfo {

    protected int alarmTypeID;
    @XmlElement(required = true)
    protected String alarmTypeCode;
    @XmlElement(required = true)
    protected String alarmTypeName;
    protected int alarmInType;
    @XmlElement(required = true)
    protected String category;
    protected int isUserDefined;
    @XmlElement(required = true)
    protected AlarmLevel alarmLevel;
    protected int enable;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the alarmTypeID property.
     * 
     */
    public int getAlarmTypeID() {
        return alarmTypeID;
    }

    /**
     * Sets the value of the alarmTypeID property.
     * 
     */
    public void setAlarmTypeID(int value) {
        this.alarmTypeID = value;
    }

    /**
     * Gets the value of the alarmTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmTypeCode() {
        return alarmTypeCode;
    }

    /**
     * Sets the value of the alarmTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmTypeCode(String value) {
        this.alarmTypeCode = value;
    }

    /**
     * Gets the value of the alarmTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmTypeName() {
        return alarmTypeName;
    }

    /**
     * Sets the value of the alarmTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmTypeName(String value) {
        this.alarmTypeName = value;
    }

    /**
     * Gets the value of the alarmInType property.
     * 
     */
    public int getAlarmInType() {
        return alarmInType;
    }

    /**
     * Sets the value of the alarmInType property.
     * 
     */
    public void setAlarmInType(int value) {
        this.alarmInType = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the isUserDefined property.
     * 
     */
    public int getIsUserDefined() {
        return isUserDefined;
    }

    /**
     * Sets the value of the isUserDefined property.
     * 
     */
    public void setIsUserDefined(int value) {
        this.isUserDefined = value;
    }

    /**
     * Gets the value of the alarmLevel property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmLevel }
     *     
     */
    public AlarmLevel getAlarmLevel() {
        return alarmLevel;
    }

    /**
     * Sets the value of the alarmLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmLevel }
     *     
     */
    public void setAlarmLevel(AlarmLevel value) {
        this.alarmLevel = value;
    }

    /**
     * Gets the value of the enable property.
     * 
     */
    public int getEnable() {
        return enable;
    }

    /**
     * Sets the value of the enable property.
     * 
     */
    public void setEnable(int value) {
        this.enable = value;
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
