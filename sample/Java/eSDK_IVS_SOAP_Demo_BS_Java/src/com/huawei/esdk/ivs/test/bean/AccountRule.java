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
 * <p>Java class for AccountRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enable" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pwdConsist" type="{esdk_ivs_professional_server}PwdConsist"/>
 *         &lt;element name="firstModify" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="checkOldPwd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="accountNotFit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="accountBackNotFit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="domainAccCheckPwd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pwdMinLen" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pwdDifferentNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="accountLockNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="accountLockElapse" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="accountLockInterval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pwdExpireTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pwdExpireNotifyTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pwdExpireForceNotify" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "AccountRule", propOrder = {
    "enable",
    "pwdConsist",
    "firstModify",
    "checkOldPwd",
    "accountNotFit",
    "accountBackNotFit",
    "domainAccCheckPwd",
    "pwdMinLen",
    "pwdDifferentNum",
    "accountLockNum",
    "accountLockElapse",
    "accountLockInterval",
    "pwdExpireTime",
    "pwdExpireNotifyTime",
    "pwdExpireForceNotify",
    "reserve"
})
public class AccountRule {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enable;
    @XmlElement(required = true)
    protected PwdConsist pwdConsist;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer firstModify;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer checkOldPwd;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer accountNotFit;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer accountBackNotFit;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer domainAccCheckPwd;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer pwdMinLen;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer pwdDifferentNum;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer accountLockNum;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer accountLockElapse;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer accountLockInterval;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer pwdExpireTime;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer pwdExpireNotifyTime;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer pwdExpireForceNotify;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * Sets the value of the enable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnable(Integer value) {
        this.enable = value;
    }

    /**
     * Gets the value of the pwdConsist property.
     * 
     * @return
     *     possible object is
     *     {@link PwdConsist }
     *     
     */
    public PwdConsist getPwdConsist() {
        return pwdConsist;
    }

    /**
     * Sets the value of the pwdConsist property.
     * 
     * @param value
     *     allowed object is
     *     {@link PwdConsist }
     *     
     */
    public void setPwdConsist(PwdConsist value) {
        this.pwdConsist = value;
    }

    /**
     * Gets the value of the firstModify property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getFirstModify() {
        return firstModify;
    }

    /**
     * Sets the value of the firstModify property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstModify(Integer value) {
        this.firstModify = value;
    }

    /**
     * Gets the value of the checkOldPwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getCheckOldPwd() {
        return checkOldPwd;
    }

    /**
     * Sets the value of the checkOldPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckOldPwd(Integer value) {
        this.checkOldPwd = value;
    }

    /**
     * Gets the value of the accountNotFit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAccountNotFit() {
        return accountNotFit;
    }

    /**
     * Sets the value of the accountNotFit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNotFit(Integer value) {
        this.accountNotFit = value;
    }

    /**
     * Gets the value of the accountBackNotFit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAccountBackNotFit() {
        return accountBackNotFit;
    }

    /**
     * Sets the value of the accountBackNotFit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountBackNotFit(Integer value) {
        this.accountBackNotFit = value;
    }

    /**
     * Gets the value of the domainAccCheckPwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDomainAccCheckPwd() {
        return domainAccCheckPwd;
    }

    /**
     * Sets the value of the domainAccCheckPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainAccCheckPwd(Integer value) {
        this.domainAccCheckPwd = value;
    }

    /**
     * Gets the value of the pwdMinLen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPwdMinLen() {
        return pwdMinLen;
    }

    /**
     * Sets the value of the pwdMinLen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwdMinLen(Integer value) {
        this.pwdMinLen = value;
    }

    /**
     * Gets the value of the pwdDifferentNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPwdDifferentNum() {
        return pwdDifferentNum;
    }

    /**
     * Sets the value of the pwdDifferentNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwdDifferentNum(Integer value) {
        this.pwdDifferentNum = value;
    }

    /**
     * Gets the value of the accountLockNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAccountLockNum() {
        return accountLockNum;
    }

    /**
     * Sets the value of the accountLockNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountLockNum(Integer value) {
        this.accountLockNum = value;
    }

    /**
     * Gets the value of the accountLockElapse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAccountLockElapse() {
        return accountLockElapse;
    }

    /**
     * Sets the value of the accountLockElapse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountLockElapse(Integer value) {
        this.accountLockElapse = value;
    }

    /**
     * Gets the value of the accountLockInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAccountLockInterval() {
        return accountLockInterval;
    }

    /**
     * Sets the value of the accountLockInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountLockInterval(Integer value) {
        this.accountLockInterval = value;
    }

    /**
     * Gets the value of the pwdExpireTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPwdExpireTime() {
        return pwdExpireTime;
    }

    /**
     * Sets the value of the pwdExpireTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwdExpireTime(Integer value) {
        this.pwdExpireTime = value;
    }

    /**
     * Gets the value of the pwdExpireNotifyTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPwdExpireNotifyTime() {
        return pwdExpireNotifyTime;
    }

    /**
     * Sets the value of the pwdExpireNotifyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwdExpireNotifyTime(Integer value) {
        this.pwdExpireNotifyTime = value;
    }

    /**
     * Gets the value of the pwdExpireForceNotify property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPwdExpireForceNotify() {
        return pwdExpireForceNotify;
    }

    /**
     * Sets the value of the pwdExpireForceNotify property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwdExpireForceNotify(Integer value) {
        this.pwdExpireForceNotify = value;
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
