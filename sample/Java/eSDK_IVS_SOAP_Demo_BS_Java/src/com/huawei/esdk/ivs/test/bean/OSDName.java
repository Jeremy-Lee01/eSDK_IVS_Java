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
 * <p>Java class for OSDName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OSDName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableOSDName" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="osdNameText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rectText" type="{esdk_ivs_professional_server}RectInfo"/>
 *         &lt;element name="enableSwitch" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="switchInterval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableTextBlink" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableTextTranslucent" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="textTranslucentPercent" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "OSDName", propOrder = {
    "enableOSDName",
    "osdNameText",
    "rectText",
    "enableSwitch",
    "switchInterval",
    "enableTextBlink",
    "enableTextTranslucent",
    "textTranslucentPercent",
    "reserve"
})
public class OSDName {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableOSDName;
    @XmlElement(required = true)
    protected String osdNameText;
    @XmlElement(required = true)
    protected RectInfo rectText;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableSwitch;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer switchInterval;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableTextBlink;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableTextTranslucent;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer textTranslucentPercent;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enableOSDName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableOSDName() {
        return enableOSDName;
    }

    /**
     * Sets the value of the enableOSDName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableOSDName(Integer value) {
        this.enableOSDName = value;
    }

    /**
     * Gets the value of the osdNameText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsdNameText() {
        return osdNameText;
    }

    /**
     * Sets the value of the osdNameText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsdNameText(String value) {
        this.osdNameText = value;
    }

    /**
     * Gets the value of the rectText property.
     * 
     * @return
     *     possible object is
     *     {@link RectInfo }
     *     
     */
    public RectInfo getRectText() {
        return rectText;
    }

    /**
     * Sets the value of the rectText property.
     * 
     * @param value
     *     allowed object is
     *     {@link RectInfo }
     *     
     */
    public void setRectText(RectInfo value) {
        this.rectText = value;
    }

    /**
     * Gets the value of the enableSwitch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableSwitch() {
        return enableSwitch;
    }

    /**
     * Sets the value of the enableSwitch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableSwitch(Integer value) {
        this.enableSwitch = value;
    }

    /**
     * Gets the value of the switchInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getSwitchInterval() {
        return switchInterval;
    }

    /**
     * Sets the value of the switchInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchInterval(Integer value) {
        this.switchInterval = value;
    }

    /**
     * Gets the value of the enableTextBlink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableTextBlink() {
        return enableTextBlink;
    }

    /**
     * Sets the value of the enableTextBlink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableTextBlink(Integer value) {
        this.enableTextBlink = value;
    }

    /**
     * Gets the value of the enableTextTranslucent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableTextTranslucent() {
        return enableTextTranslucent;
    }

    /**
     * Sets the value of the enableTextTranslucent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableTextTranslucent(Integer value) {
        this.enableTextTranslucent = value;
    }

    /**
     * Gets the value of the textTranslucentPercent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getTextTranslucentPercent() {
        return textTranslucentPercent;
    }

    /**
     * Sets the value of the textTranslucentPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextTranslucentPercent(Integer value) {
        this.textTranslucentPercent = value;
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
