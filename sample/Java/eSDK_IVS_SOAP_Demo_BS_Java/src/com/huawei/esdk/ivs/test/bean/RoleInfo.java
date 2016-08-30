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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoleInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="roleID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="roleName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="roleDescribe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="roleType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="right" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accountRule" type="{esdk_ivs_professional_server}AccountRule"/>
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
@XmlType(name = "RoleInfo", propOrder = {
    "domainCode",
    "roleID",
    "roleName",
    "roleDescribe",
    "roleType",
    "right",
    "accountRule",
    "reserve"
})
public class RoleInfo {

    @XmlElement(required = true)
    protected String domainCode;
    @XmlElement(required = true)
    protected String roleID;
    @XmlElement(required = true)
    protected String roleName;
    @XmlElement(required = true)
    protected String roleDescribe;
    @XmlElement(required = true)
    protected String roleType;
    @XmlElement(required = true)
    protected String right;
    @XmlElement(required = true)
    protected AccountRule accountRule;
    @XmlElement(required = true)
    protected String reserve;

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
     * Gets the value of the roleID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleID() {
        return roleID;
    }

    /**
     * Sets the value of the roleID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleID(String value) {
        this.roleID = value;
    }

    /**
     * Gets the value of the roleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the value of the roleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleName(String value) {
        this.roleName = value;
    }

    /**
     * Gets the value of the roleDescribe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleDescribe() {
        return roleDescribe;
    }

    /**
     * Sets the value of the roleDescribe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleDescribe(String value) {
        this.roleDescribe = value;
    }

    /**
     * Gets the value of the roleType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * Sets the value of the roleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleType(String value) {
        this.roleType = value;
    }

    /**
     * Gets the value of the right property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRight() {
        return right;
    }

    /**
     * Sets the value of the right property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRight(String value) {
        this.right = value;
    }

    /**
     * Gets the value of the accountRule property.
     * 
     * @return
     *     possible object is
     *     {@link AccountRule }
     *     
     */
    public AccountRule getAccountRule() {
        return accountRule;
    }

    /**
     * Sets the value of the accountRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountRule }
     *     
     */
    public void setAccountRule(AccountRule value) {
        this.accountRule = value;
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
