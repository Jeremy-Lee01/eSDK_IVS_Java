/**
 * Copyright 2016 Huawei Technologies Co., Ltd. All rights reserved.
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
package com.huawei.esdk.ivs.professional.local.impl.autogen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>DeviceAlarmNotify complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DeviceAlarmNotify">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmEventID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="alarmInCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmInType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmInName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nodeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmLevelValue" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmCategory" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="occurFirstTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="occurEndTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="occurNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reserver" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="locationInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="netEleID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="netName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmDest" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "DeviceAlarmNotify", propOrder = {
    "alarmEventID",
    "alarmInCode",
    "alarmInType",
    "alarmInName",
    "nodeType",
    "alarmLevelValue",
    "alarmType",
    "alarmCategory",
    "occurFirstTime",
    "occurEndTime",
    "occurNumber",
    "reserver",
    "locationInfo",
    "netEleID",
    "netName",
    "alarmDest",
    "extParam"
})
public class DeviceAlarmNotify {

    @XmlSchemaType(name = "unsignedInt")
    protected long alarmEventID;
    @XmlElement(required = true)
    protected String alarmInCode;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer alarmInType;
    @XmlElement(required = true)
    protected String alarmInName;
    @XmlElement(required = true)
    protected String nodeType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer alarmLevelValue;
    @XmlElement(required = true)
    protected String alarmType;
    @XmlElement(required = true)
    protected String alarmCategory;
    @XmlElement(required = true)
    protected String occurFirstTime;
    @XmlElement(required = true)
    protected String occurEndTime;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer occurNumber;
    @XmlElement(required = true)
    protected String reserver;
    @XmlElement(required = true)
    protected String locationInfo;
    @XmlElement(required = true)
    protected String netEleID;
    @XmlElement(required = true)
    protected String netName;
    @XmlElement(required = true)
    protected String alarmDest;
    @XmlElement(required = true)
    protected String extParam;

    /**
     * 获取alarmEventID属性的值。
     * 
     */
    public long getAlarmEventID() {
        return alarmEventID;
    }

    /**
     * 设置alarmEventID属性的值。
     * 
     */
    public void setAlarmEventID(long value) {
        this.alarmEventID = value;
    }

    /**
     * 获取alarmInCode属性的值。
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
     * 设置alarmInCode属性的值。
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
     * 获取alarmInType属性的值。
     * 
     */
    public Integer getAlarmInType() {
        return alarmInType;
    }

    /**
     * 设置alarmInType属性的值。
     * 
     */
    public void setAlarmInType(Integer value) {
        this.alarmInType = value;
    }

    /**
     * 获取alarmInName属性的值。
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
     * 设置alarmInName属性的值。
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
     * 获取nodeType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeType() {
        return nodeType;
    }

    /**
     * 设置nodeType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeType(String value) {
        this.nodeType = value;
    }

    /**
     * 获取alarmLevelValue属性的值。
     * 
     */
    public Integer getAlarmLevelValue() {
        return alarmLevelValue;
    }

    /**
     * 设置alarmLevelValue属性的值。
     * 
     */
    public void setAlarmLevelValue(Integer value) {
        this.alarmLevelValue = value;
    }

    /**
     * 获取alarmType属性的值。
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
     * 设置alarmType属性的值。
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
     * 获取alarmCategory属性的值。
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
     * 设置alarmCategory属性的值。
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
     * 获取occurFirstTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccurFirstTime() {
        return occurFirstTime;
    }

    /**
     * 设置occurFirstTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurFirstTime(String value) {
        this.occurFirstTime = value;
    }

    /**
     * 获取occurEndTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccurEndTime() {
        return occurEndTime;
    }

    /**
     * 设置occurEndTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurEndTime(String value) {
        this.occurEndTime = value;
    }

    /**
     * 获取occurNumber属性的值。
     * 
     */
    public Integer getOccurNumber() {
        return occurNumber;
    }

    /**
     * 设置occurNumber属性的值。
     * 
     */
    public void setOccurNumber(Integer value) {
        this.occurNumber = value;
    }

    /**
     * 获取reserver属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserver() {
        return reserver;
    }

    /**
     * 设置reserver属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserver(String value) {
        this.reserver = value;
    }

    /**
     * 获取locationInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationInfo() {
        return locationInfo;
    }

    /**
     * 设置locationInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationInfo(String value) {
        this.locationInfo = value;
    }

    /**
     * 获取netEleID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetEleID() {
        return netEleID;
    }

    /**
     * 设置netEleID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetEleID(String value) {
        this.netEleID = value;
    }

    /**
     * 获取netName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetName() {
        return netName;
    }

    /**
     * 设置netName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetName(String value) {
        this.netName = value;
    }

    /**
     * 获取alarmDest属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmDest() {
        return alarmDest;
    }

    /**
     * 设置alarmDest属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmDest(String value) {
        this.alarmDest = value;
    }

    /**
     * 获取extParam属性的值。
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
     * 设置extParam属性的值。
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
