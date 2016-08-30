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

    protected int enable;
    @XmlElement(required = true)
    protected PwdConsist pwdConsist;
    protected int firstModify;
    protected int checkOldPwd;
    protected int accountNotFit;
    protected int accountBackNotFit;
    protected int domainAccCheckPwd;
    protected int pwdMinLen;
    protected int pwdDifferentNum;
    protected int accountLockNum;
    protected int accountLockElapse;
    protected int accountLockInterval;
    protected int pwdExpireTime;
    protected int pwdExpireNotifyTime;
    protected int pwdExpireForceNotify;
    @XmlElement(required = true)
    protected String reserve;

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
     */
    public int getFirstModify() {
        return firstModify;
    }

    /**
     * Sets the value of the firstModify property.
     * 
     */
    public void setFirstModify(int value) {
        this.firstModify = value;
    }

    /**
     * Gets the value of the checkOldPwd property.
     * 
     */
    public int getCheckOldPwd() {
        return checkOldPwd;
    }

    /**
     * Sets the value of the checkOldPwd property.
     * 
     */
    public void setCheckOldPwd(int value) {
        this.checkOldPwd = value;
    }

    /**
     * Gets the value of the accountNotFit property.
     * 
     */
    public int getAccountNotFit() {
        return accountNotFit;
    }

    /**
     * Sets the value of the accountNotFit property.
     * 
     */
    public void setAccountNotFit(int value) {
        this.accountNotFit = value;
    }

    /**
     * Gets the value of the accountBackNotFit property.
     * 
     */
    public int getAccountBackNotFit() {
        return accountBackNotFit;
    }

    /**
     * Sets the value of the accountBackNotFit property.
     * 
     */
    public void setAccountBackNotFit(int value) {
        this.accountBackNotFit = value;
    }

    /**
     * Gets the value of the domainAccCheckPwd property.
     * 
     */
    public int getDomainAccCheckPwd() {
        return domainAccCheckPwd;
    }

    /**
     * Sets the value of the domainAccCheckPwd property.
     * 
     */
    public void setDomainAccCheckPwd(int value) {
        this.domainAccCheckPwd = value;
    }

    /**
     * Gets the value of the pwdMinLen property.
     * 
     */
    public int getPwdMinLen() {
        return pwdMinLen;
    }

    /**
     * Sets the value of the pwdMinLen property.
     * 
     */
    public void setPwdMinLen(int value) {
        this.pwdMinLen = value;
    }

    /**
     * Gets the value of the pwdDifferentNum property.
     * 
     */
    public int getPwdDifferentNum() {
        return pwdDifferentNum;
    }

    /**
     * Sets the value of the pwdDifferentNum property.
     * 
     */
    public void setPwdDifferentNum(int value) {
        this.pwdDifferentNum = value;
    }

    /**
     * Gets the value of the accountLockNum property.
     * 
     */
    public int getAccountLockNum() {
        return accountLockNum;
    }

    /**
     * Sets the value of the accountLockNum property.
     * 
     */
    public void setAccountLockNum(int value) {
        this.accountLockNum = value;
    }

    /**
     * Gets the value of the accountLockElapse property.
     * 
     */
    public int getAccountLockElapse() {
        return accountLockElapse;
    }

    /**
     * Sets the value of the accountLockElapse property.
     * 
     */
    public void setAccountLockElapse(int value) {
        this.accountLockElapse = value;
    }

    /**
     * Gets the value of the accountLockInterval property.
     * 
     */
    public int getAccountLockInterval() {
        return accountLockInterval;
    }

    /**
     * Sets the value of the accountLockInterval property.
     * 
     */
    public void setAccountLockInterval(int value) {
        this.accountLockInterval = value;
    }

    /**
     * Gets the value of the pwdExpireTime property.
     * 
     */
    public int getPwdExpireTime() {
        return pwdExpireTime;
    }

    /**
     * Sets the value of the pwdExpireTime property.
     * 
     */
    public void setPwdExpireTime(int value) {
        this.pwdExpireTime = value;
    }

    /**
     * Gets the value of the pwdExpireNotifyTime property.
     * 
     */
    public int getPwdExpireNotifyTime() {
        return pwdExpireNotifyTime;
    }

    /**
     * Sets the value of the pwdExpireNotifyTime property.
     * 
     */
    public void setPwdExpireNotifyTime(int value) {
        this.pwdExpireNotifyTime = value;
    }

    /**
     * Gets the value of the pwdExpireForceNotify property.
     * 
     */
    public int getPwdExpireForceNotify() {
        return pwdExpireForceNotify;
    }

    /**
     * Sets the value of the pwdExpireForceNotify property.
     * 
     */
    public void setPwdExpireForceNotify(int value) {
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
