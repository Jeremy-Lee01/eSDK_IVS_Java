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
 * <p>Java class for MediaSecurityConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaSecurityConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableMediaSecurity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableSecureStorage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mediaSecurityAlgorithm" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "MediaSecurityConfig", propOrder = {
    "enableMediaSecurity",
    "enableSecureStorage",
    "mediaSecurityAlgorithm",
    "reserve"
})
public class MediaSecurityConfig {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableMediaSecurity;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableSecureStorage;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer mediaSecurityAlgorithm;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enableMediaSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableMediaSecurity() {
        return enableMediaSecurity;
    }

    /**
     * Sets the value of the enableMediaSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableMediaSecurity(Integer value) {
        this.enableMediaSecurity = value;
    }

    /**
     * Gets the value of the enableSecureStorage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableSecureStorage() {
        return enableSecureStorage;
    }

    /**
     * Sets the value of the enableSecureStorage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableSecureStorage(Integer value) {
        this.enableSecureStorage = value;
    }

    /**
     * Gets the value of the mediaSecurityAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getMediaSecurityAlgorithm() {
        return mediaSecurityAlgorithm;
    }

    /**
     * Sets the value of the mediaSecurityAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMediaSecurityAlgorithm(Integer value) {
        this.mediaSecurityAlgorithm = value;
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
