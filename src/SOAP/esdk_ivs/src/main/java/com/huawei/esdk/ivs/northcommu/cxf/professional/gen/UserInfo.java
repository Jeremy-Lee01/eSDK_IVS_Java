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
 * <p>Java class for UserInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isFirstLogin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="roleId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="loginName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pwdModifyDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userDomain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="registerDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ptzLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxSessionCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxVideoCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lockTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="validDateFlag" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="validDateStart" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="validDateEnd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserInfo", propOrder = {
    "domainCode",
    "userId",
    "isFirstLogin",
    "roleId",
    "groupId",
    "loginName",
    "password",
    "pwdModifyDate",
    "userType",
    "userDomain",
    "status",
    "registerDate",
    "userDesc",
    "ptzLevel",
    "maxSessionCount",
    "maxVideoCount",
    "lockTime",
    "userName",
    "mail",
    "phone",
    "sex",
    "reserve",
    "validDateFlag",
    "validDateStart",
    "validDateEnd"
})
public class UserInfo {

    @XmlElement(required = true)
    protected String domainCode;
    protected int userId;
    protected int isFirstLogin;
    protected int roleId;
    protected int groupId;
    @XmlElement(required = true)
    protected String loginName;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected String pwdModifyDate;
    protected int userType;
    @XmlElement(required = true)
    protected String userDomain;
    protected int status;
    @XmlElement(required = true)
    protected String registerDate;
    @XmlElement(required = true)
    protected String userDesc;
    protected int ptzLevel;
    protected int maxSessionCount;
    protected int maxVideoCount;
    @XmlElement(required = true)
    protected String lockTime;
    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected String mail;
    @XmlElement(required = true)
    protected String phone;
    protected int sex;
    @XmlElement(required = true)
    protected String reserve;
    protected int validDateFlag;
    @XmlElement(required = true)
    protected String validDateStart;
    @XmlElement(required = true)
    protected String validDateEnd;

    /**
     * Gets the value of the domainCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainCode() {
        return domainCode;
    }

    /**
     * Sets the value of the domainCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainCode(String value) {
        this.domainCode = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

    /**
     * Gets the value of the isFirstLogin property.
     * 
     */
    public int getIsFirstLogin() {
        return isFirstLogin;
    }

    /**
     * Sets the value of the isFirstLogin property.
     * 
     */
    public void setIsFirstLogin(int value) {
        this.isFirstLogin = value;
    }

    /**
     * Gets the value of the roleId property.
     * 
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the value of the roleId property.
     * 
     */
    public void setRoleId(int value) {
        this.roleId = value;
    }

    /**
     * Gets the value of the groupId property.
     * 
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     */
    public void setGroupId(int value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the loginName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * Sets the value of the loginName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginName(String value) {
        this.loginName = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the pwdModifyDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwdModifyDate() {
        return pwdModifyDate;
    }

    /**
     * Sets the value of the pwdModifyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwdModifyDate(String value) {
        this.pwdModifyDate = value;
    }

    /**
     * Gets the value of the userType property.
     * 
     */
    public int getUserType() {
        return userType;
    }

    /**
     * Sets the value of the userType property.
     * 
     */
    public void setUserType(int value) {
        this.userType = value;
    }

    /**
     * Gets the value of the userDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserDomain() {
        return userDomain;
    }

    /**
     * Sets the value of the userDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserDomain(String value) {
        this.userDomain = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the registerDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * Sets the value of the registerDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterDate(String value) {
        this.registerDate = value;
    }

    /**
     * Gets the value of the userDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserDesc() {
        return userDesc;
    }

    /**
     * Sets the value of the userDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserDesc(String value) {
        this.userDesc = value;
    }

    /**
     * Gets the value of the ptzLevel property.
     * 
     */
    public int getPtzLevel() {
        return ptzLevel;
    }

    /**
     * Sets the value of the ptzLevel property.
     * 
     */
    public void setPtzLevel(int value) {
        this.ptzLevel = value;
    }

    /**
     * Gets the value of the maxSessionCount property.
     * 
     */
    public int getMaxSessionCount() {
        return maxSessionCount;
    }

    /**
     * Sets the value of the maxSessionCount property.
     * 
     */
    public void setMaxSessionCount(int value) {
        this.maxSessionCount = value;
    }

    /**
     * Gets the value of the maxVideoCount property.
     * 
     */
    public int getMaxVideoCount() {
        return maxVideoCount;
    }

    /**
     * Sets the value of the maxVideoCount property.
     * 
     */
    public void setMaxVideoCount(int value) {
        this.maxVideoCount = value;
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
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the mail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets the value of the mail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMail(String value) {
        this.mail = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     */
    public int getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     */
    public void setSex(int value) {
        this.sex = value;
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
     * Gets the value of the validDateFlag property.
     * 
     */
    public int getValidDateFlag() {
        return validDateFlag;
    }

    /**
     * Sets the value of the validDateFlag property.
     * 
     */
    public void setValidDateFlag(int value) {
        this.validDateFlag = value;
    }

    /**
     * Gets the value of the validDateStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidDateStart() {
        return validDateStart;
    }

    /**
     * Sets the value of the validDateStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidDateStart(String value) {
        this.validDateStart = value;
    }

    /**
     * Gets the value of the validDateEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidDateEnd() {
        return validDateEnd;
    }

    /**
     * Sets the value of the validDateEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidDateEnd(String value) {
        this.validDateEnd = value;
    }

}
