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
 * <p>Java class for AlarmOperateInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmOperateInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operatorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operatorName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reserver" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operateInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlarmOperateInfo", propOrder = {
    "operatorId",
    "operatorName",
    "operateTime",
    "reserver",
    "operateInfo"
})
public class AlarmOperateInfo {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer operatorId;
    @XmlElement(required = true)
    protected String operatorName;
    @XmlElement(required = true)
    protected String operateTime;
    @XmlElement(required = true)
    protected String reserver;
    @XmlElement(required = true)
    protected String operateInfo;

    /**
     * Gets the value of the operatorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     * Sets the value of the operatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorId(Integer value) {
        this.operatorId = value;
    }

    /**
     * Gets the value of the operatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * Sets the value of the operatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorName(String value) {
        this.operatorName = value;
    }

    /**
     * Gets the value of the operateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperateTime() {
        return operateTime;
    }

    /**
     * Sets the value of the operateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperateTime(String value) {
        this.operateTime = value;
    }

    /**
     * Gets the value of the reserver property.
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
     * Sets the value of the reserver property.
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
     * Gets the value of the operateInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperateInfo() {
        return operateInfo;
    }

    /**
     * Sets the value of the operateInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperateInfo(String value) {
        this.operateInfo = value;
    }

}
