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
 * <p>Java class for CameraExtendConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CameraExtendConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableWatermark" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reliableTransmission" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fecMatrix" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableBandwidthAdaptive" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableCache" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mediaSecurityConfig" type="{esdk_ivs_professional_server}MediaSecurityConfig"/>
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
@XmlType(name = "CameraExtendConfig", propOrder = {
    "enableWatermark",
    "reliableTransmission",
    "fecMatrix",
    "enableBandwidthAdaptive",
    "enableCache",
    "mediaSecurityConfig",
    "reserve"
})
public class CameraExtendConfig {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableWatermark;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer reliableTransmission;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer fecMatrix;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableBandwidthAdaptive;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableCache;
    @XmlElement(required = true)
    protected MediaSecurityConfig mediaSecurityConfig;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enableWatermark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableWatermark() {
        return enableWatermark;
    }

    /**
     * Sets the value of the enableWatermark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableWatermark(Integer value) {
        this.enableWatermark = value;
    }

    /**
     * Gets the value of the reliableTransmission property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getReliableTransmission() {
        return reliableTransmission;
    }

    /**
     * Sets the value of the reliableTransmission property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReliableTransmission(Integer value) {
        this.reliableTransmission = value;
    }

    /**
     * Gets the value of the fecMatrix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getFecMatrix() {
        return fecMatrix;
    }

    /**
     * Sets the value of the fecMatrix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecMatrix(Integer value) {
        this.fecMatrix = value;
    }

    /**
     * Gets the value of the enableBandwidthAdaptive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableBandwidthAdaptive() {
        return enableBandwidthAdaptive;
    }

    /**
     * Sets the value of the enableBandwidthAdaptive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableBandwidthAdaptive(Integer value) {
        this.enableBandwidthAdaptive = value;
    }

    /**
     * Gets the value of the enableCache property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableCache() {
        return enableCache;
    }

    /**
     * Sets the value of the enableCache property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableCache(Integer value) {
        this.enableCache = value;
    }

    /**
     * Gets the value of the mediaSecurityConfig property.
     * 
     * @return
     *     possible object is
     *     {@link MediaSecurityConfig }
     *     
     */
    public MediaSecurityConfig getMediaSecurityConfig() {
        return mediaSecurityConfig;
    }

    /**
     * Sets the value of the mediaSecurityConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaSecurityConfig }
     *     
     */
    public void setMediaSecurityConfig(MediaSecurityConfig value) {
        this.mediaSecurityConfig = value;
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
