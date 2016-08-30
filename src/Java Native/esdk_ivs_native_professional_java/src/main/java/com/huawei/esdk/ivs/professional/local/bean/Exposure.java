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
 * <p>Java class for Exposure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Exposure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exposureMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="exposurePriority" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rectWindow" type="{esdk_ivs_professional_server}RectInfo"/>
 *         &lt;element name="exposureTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="exposureGain" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="exposureIris" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "Exposure", propOrder = {
    "exposureMode",
    "exposurePriority",
    "rectWindow",
    "exposureTime",
    "exposureGain",
    "exposureIris",
    "reserve"
})
public class Exposure {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer exposureMode;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer exposurePriority;
    @XmlElement(required = true)
    protected RectInfo rectWindow;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer exposureTime;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer exposureGain;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer exposureIris;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the exposureMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getExposureMode() {
        return exposureMode;
    }

    /**
     * Sets the value of the exposureMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExposureMode(Integer value) {
        this.exposureMode = value;
    }

    /**
     * Gets the value of the exposurePriority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getExposurePriority() {
        return exposurePriority;
    }

    /**
     * Sets the value of the exposurePriority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExposurePriority(Integer value) {
        this.exposurePriority = value;
    }

    /**
     * Gets the value of the rectWindow property.
     * 
     * @return
     *     possible object is
     *     {@link RectInfo }
     *     
     */
    public RectInfo getRectWindow() {
        return rectWindow;
    }

    /**
     * Sets the value of the rectWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link RectInfo }
     *     
     */
    public void setRectWindow(RectInfo value) {
        this.rectWindow = value;
    }

    /**
     * Gets the value of the exposureTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getExposureTime() {
        return exposureTime;
    }

    /**
     * Sets the value of the exposureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExposureTime(Integer value) {
        this.exposureTime = value;
    }

    /**
     * Gets the value of the exposureGain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getExposureGain() {
        return exposureGain;
    }

    /**
     * Sets the value of the exposureGain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExposureGain(Integer value) {
        this.exposureGain = value;
    }

    /**
     * Gets the value of the exposureIris property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getExposureIris() {
        return exposureIris;
    }

    /**
     * Sets the value of the exposureIris property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExposureIris(Integer value) {
        this.exposureIris = value;
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
