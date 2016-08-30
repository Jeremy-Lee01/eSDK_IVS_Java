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
 * <p>Java class for MotionDetection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MotionDetection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="motionDetectionEnable" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="platformMotionDetection" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="detectInterval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sensitivity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="autoClearAlarmTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rectNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rectDetectionList" type="{esdk_ivs_professional_server}RectInfoList"/>
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
@XmlType(name = "MotionDetection", propOrder = {
    "motionDetectionEnable",
    "platformMotionDetection",
    "detectInterval",
    "sensitivity",
    "autoClearAlarmTime",
    "rectNum",
    "rectDetectionList",
    "reserve"
})
public class MotionDetection {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer motionDetectionEnable;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer platformMotionDetection;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer detectInterval;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer sensitivity;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer autoClearAlarmTime;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer rectNum;
    @XmlElement(required = true)
    protected RectInfoList rectDetectionList;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the motionDetectionEnable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getMotionDetectionEnable() {
        return motionDetectionEnable;
    }

    /**
     * Sets the value of the motionDetectionEnable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotionDetectionEnable(Integer value) {
        this.motionDetectionEnable = value;
    }

    /**
     * Gets the value of the platformMotionDetection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPlatformMotionDetection() {
        return platformMotionDetection;
    }

    /**
     * Sets the value of the platformMotionDetection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatformMotionDetection(Integer value) {
        this.platformMotionDetection = value;
    }

    /**
     * Gets the value of the detectInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDetectInterval() {
        return detectInterval;
    }

    /**
     * Sets the value of the detectInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetectInterval(Integer value) {
        this.detectInterval = value;
    }

    /**
     * Gets the value of the sensitivity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getSensitivity() {
        return sensitivity;
    }

    /**
     * Sets the value of the sensitivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSensitivity(Integer value) {
        this.sensitivity = value;
    }

    /**
     * Gets the value of the autoClearAlarmTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAutoClearAlarmTime() {
        return autoClearAlarmTime;
    }

    /**
     * Sets the value of the autoClearAlarmTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoClearAlarmTime(Integer value) {
        this.autoClearAlarmTime = value;
    }

    /**
     * Gets the value of the rectNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getRectNum() {
        return rectNum;
    }

    /**
     * Sets the value of the rectNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRectNum(Integer value) {
        this.rectNum = value;
    }

    /**
     * Gets the value of the rectDetectionList property.
     * 
     * @return
     *     possible object is
     *     {@link RectInfoList }
     *     
     */
    public RectInfoList getRectDetectionList() {
        return rectDetectionList;
    }

    /**
     * Sets the value of the rectDetectionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RectInfoList }
     *     
     */
    public void setRectDetectionList(RectInfoList value) {
        this.rectDetectionList = value;
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
