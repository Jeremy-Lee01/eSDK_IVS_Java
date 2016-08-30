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
 * <p>Java class for AlarmNotify complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmNotify">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmEventId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="alarmInCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceDomainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmInType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmInName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmLevelValue" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmLevelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmLevelColor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmCategory" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="occurTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="occurNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isCommission" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="previewUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="existsRecord" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nvrCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="extParam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlarmNotify", propOrder = {
    "alarmEventId",
    "alarmInCode",
    "deviceDomainCode",
    "alarmInType",
    "alarmInName",
    "alarmLevelValue",
    "alarmLevelName",
    "alarmLevelColor",
    "alarmType",
    "alarmTypeName",
    "alarmCategory",
    "occurTime",
    "occurNumber",
    "alarmStatus",
    "isCommission",
    "previewUrl",
    "existsRecord",
    "nvrCode",
    "reserve",
    "alarmDesc",
    "extParam"
})
public class AlarmNotify {

    @XmlSchemaType(name = "unsignedInt")
    protected long alarmEventId;
    @XmlElement(required = true)
    protected String alarmInCode;
    @XmlElement(required = true)
    protected String deviceDomainCode;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer alarmInType;
    @XmlElement(required = true)
    protected String alarmInName;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer alarmLevelValue;
    @XmlElement(required = true)
    protected String alarmLevelName;
    @XmlElement(required = true)
    protected String alarmLevelColor;
    @XmlElement(required = true)
    protected String alarmType;
    @XmlElement(required = true)
    protected String alarmTypeName;
    @XmlElement(required = true)
    protected String alarmCategory;
    @XmlElement(required = true)
    protected String occurTime;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer occurNumber;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer alarmStatus;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer isCommission;
    @XmlElement(required = true)
    protected String previewUrl;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer existsRecord;
    @XmlElement(required = true)
    protected String nvrCode;
    @XmlElement(required = true)
    protected String reserve;
    @XmlElement(required = true)
    protected String alarmDesc;
    @XmlElement(required = true)
    protected String extParam;

    /**
     * Gets the value of the alarmEventId property.
     * 
     */
    public long getAlarmEventId() {
        return alarmEventId;
    }

    /**
     * Sets the value of the alarmEventId property.
     * 
     */
    public void setAlarmEventId(long value) {
        this.alarmEventId = value;
    }

    /**
     * Gets the value of the alarmInCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmInCode() {
        return alarmInCode;
    }

    /**
     * Sets the value of the alarmInCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmInCode(String value) {
        this.alarmInCode = value;
    }

    /**
     * Gets the value of the deviceDomainCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceDomainCode() {
        return deviceDomainCode;
    }

    /**
     * Sets the value of the deviceDomainCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceDomainCode(String value) {
        this.deviceDomainCode = value;
    }

    /**
     * Gets the value of the alarmInType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAlarmInType() {
        return alarmInType;
    }

    /**
     * Sets the value of the alarmInType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmInType(Integer value) {
        this.alarmInType = value;
    }

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
     * Gets the value of the alarmLevelValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAlarmLevelValue() {
        return alarmLevelValue;
    }

    /**
     * Sets the value of the alarmLevelValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmLevelValue(Integer value) {
        this.alarmLevelValue = value;
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
     * Gets the value of the alarmLevelColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmLevelColor() {
        return alarmLevelColor;
    }

    /**
     * Sets the value of the alarmLevelColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmLevelColor(String value) {
        this.alarmLevelColor = value;
    }

    /**
     * Gets the value of the alarmType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmType() {
        return alarmType;
    }

    /**
     * Sets the value of the alarmType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmType(String value) {
        this.alarmType = value;
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
     * Gets the value of the alarmCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmCategory() {
        return alarmCategory;
    }

    /**
     * Sets the value of the alarmCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmCategory(String value) {
        this.alarmCategory = value;
    }

    /**
     * Gets the value of the occurTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccurTime() {
        return occurTime;
    }

    /**
     * Sets the value of the occurTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurTime(String value) {
        this.occurTime = value;
    }

    /**
     * Gets the value of the occurNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getOccurNumber() {
        return occurNumber;
    }

    /**
     * Sets the value of the occurNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurNumber(Integer value) {
        this.occurNumber = value;
    }

    /**
     * Gets the value of the alarmStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAlarmStatus() {
        return alarmStatus;
    }

    /**
     * Sets the value of the alarmStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmStatus(Integer value) {
        this.alarmStatus = value;
    }

    /**
     * Gets the value of the isCommission property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsCommission() {
        return isCommission;
    }

    /**
     * Sets the value of the isCommission property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCommission(Integer value) {
        this.isCommission = value;
    }

    /**
     * Gets the value of the previewUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * Sets the value of the previewUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviewUrl(String value) {
        this.previewUrl = value;
    }

    /**
     * Gets the value of the existsRecord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getExistsRecord() {
        return existsRecord;
    }

    /**
     * Sets the value of the existsRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExistsRecord(Integer value) {
        this.existsRecord = value;
    }

    /**
     * Gets the value of the nvrCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNvrCode() {
        return nvrCode;
    }

    /**
     * Sets the value of the nvrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNvrCode(String value) {
        this.nvrCode = value;
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

    /**
     * Gets the value of the alarmDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmDesc() {
        return alarmDesc;
    }

    /**
     * Sets the value of the alarmDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmDesc(String value) {
        this.alarmDesc = value;
    }

    /**
     * Gets the value of the extParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtParam() {
        return extParam;
    }

    /**
     * Sets the value of the extParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtParam(String value) {
        this.extParam = value;
    }

}
