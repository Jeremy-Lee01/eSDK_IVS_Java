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
 * <p>Java class for LockInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LockInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lockId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lockTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lockTimeSpan" type="{esdk_ivs_professional_server}TimeSpan"/>
 *         &lt;element name="lockDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operatorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operatorName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "LockInfo", propOrder = {
    "lockId",
    "lockTime",
    "lockTimeSpan",
    "lockDesc",
    "operatorId",
    "operatorName",
    "reserve"
})
public class LockInfo {

    protected int lockId;
    @XmlElement(required = true)
    protected String lockTime;
    @XmlElement(required = true)
    protected TimeSpan lockTimeSpan;
    @XmlElement(required = true)
    protected String lockDesc;
    protected int operatorId;
    @XmlElement(required = true)
    protected String operatorName;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the lockId property.
     * 
     */
    public int getLockId() {
        return lockId;
    }

    /**
     * Sets the value of the lockId property.
     * 
     */
    public void setLockId(int value) {
        this.lockId = value;
    }

    /**
     * Gets the value of the lockTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLockTime() {
        return lockTime;
    }

    /**
     * Sets the value of the lockTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLockTime(String value) {
        this.lockTime = value;
    }

    /**
     * Gets the value of the lockTimeSpan property.
     * 
     * @return
     *     possible object is
     *     {@link TimeSpan }
     *     
     */
    public TimeSpan getLockTimeSpan() {
        return lockTimeSpan;
    }

    /**
     * Sets the value of the lockTimeSpan property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeSpan }
     *     
     */
    public void setLockTimeSpan(TimeSpan value) {
        this.lockTimeSpan = value;
    }

    /**
     * Gets the value of the lockDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLockDesc() {
        return lockDesc;
    }

    /**
     * Sets the value of the lockDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLockDesc(String value) {
        this.lockDesc = value;
    }

    /**
     * Gets the value of the operatorId property.
     * 
     */
    public int getOperatorId() {
        return operatorId;
    }

    /**
     * Sets the value of the operatorId property.
     * 
     */
    public void setOperatorId(int value) {
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
