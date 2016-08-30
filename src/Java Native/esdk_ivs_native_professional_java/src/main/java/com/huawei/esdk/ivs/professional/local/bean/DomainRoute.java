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
 * <p>Java class for DomainRoute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DomainRoute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="domainType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isAgent" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="domainName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="domainIPInfo" type="{esdk_ivs_professional_server}IPInfo"/>
 *         &lt;element name="domainPort" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="superDomain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isLocalDomain" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "DomainRoute", propOrder = {
    "domainType",
    "isAgent",
    "domainCode",
    "domainName",
    "domainIPInfo",
    "domainPort",
    "superDomain",
    "isLocalDomain",
    "reserve"
})
public class DomainRoute {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer domainType;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer isAgent;
    @XmlElement(required = true)
    protected String domainCode;
    @XmlElement(required = true)
    protected String domainName;
    @XmlElement(required = true)
    protected IPInfo domainIPInfo;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer domainPort;
    @XmlElement(required = true)
    protected String superDomain;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer isLocalDomain;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the domainType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDomainType() {
        return domainType;
    }

    /**
     * Sets the value of the domainType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainType(Integer value) {
        this.domainType = value;
    }

    /**
     * Gets the value of the isAgent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsAgent() {
        return isAgent;
    }

    /**
     * Sets the value of the isAgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAgent(Integer value) {
        this.isAgent = value;
    }

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
     * Gets the value of the domainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Sets the value of the domainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainName(String value) {
        this.domainName = value;
    }

    /**
     * Gets the value of the domainIPInfo property.
     * 
     * @return
     *     possible object is
     *     {@link IPInfo }
     *     
     */
    public IPInfo getDomainIPInfo() {
        return domainIPInfo;
    }

    /**
     * Sets the value of the domainIPInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPInfo }
     *     
     */
    public void setDomainIPInfo(IPInfo value) {
        this.domainIPInfo = value;
    }

    /**
     * Gets the value of the domainPort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDomainPort() {
        return domainPort;
    }

    /**
     * Sets the value of the domainPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainPort(Integer value) {
        this.domainPort = value;
    }

    /**
     * Gets the value of the superDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuperDomain() {
        return superDomain;
    }

    /**
     * Sets the value of the superDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuperDomain(String value) {
        this.superDomain = value;
    }

    /**
     * Gets the value of the isLocalDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsLocalDomain() {
        return isLocalDomain;
    }

    /**
     * Sets the value of the isLocalDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsLocalDomain(Integer value) {
        this.isLocalDomain = value;
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
