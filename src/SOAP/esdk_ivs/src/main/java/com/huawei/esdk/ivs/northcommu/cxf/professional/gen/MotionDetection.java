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

    protected int motionDetectionEnable;
    protected int platformMotionDetection;
    protected int detectInterval;
    protected int sensitivity;
    protected int autoClearAlarmTime;
    protected int rectNum;
    @XmlElement(required = true)
    protected RectInfoList rectDetectionList;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the motionDetectionEnable property.
     * 
     */
    public int getMotionDetectionEnable() {
        return motionDetectionEnable;
    }

    /**
     * Sets the value of the motionDetectionEnable property.
     * 
     */
    public void setMotionDetectionEnable(int value) {
        this.motionDetectionEnable = value;
    }

    /**
     * Gets the value of the platformMotionDetection property.
     * 
     */
    public int getPlatformMotionDetection() {
        return platformMotionDetection;
    }

    /**
     * Sets the value of the platformMotionDetection property.
     * 
     */
    public void setPlatformMotionDetection(int value) {
        this.platformMotionDetection = value;
    }

    /**
     * Gets the value of the detectInterval property.
     * 
     */
    public int getDetectInterval() {
        return detectInterval;
    }

    /**
     * Sets the value of the detectInterval property.
     * 
     */
    public void setDetectInterval(int value) {
        this.detectInterval = value;
    }

    /**
     * Gets the value of the sensitivity property.
     * 
     */
    public int getSensitivity() {
        return sensitivity;
    }

    /**
     * Sets the value of the sensitivity property.
     * 
     */
    public void setSensitivity(int value) {
        this.sensitivity = value;
    }

    /**
     * Gets the value of the autoClearAlarmTime property.
     * 
     */
    public int getAutoClearAlarmTime() {
        return autoClearAlarmTime;
    }

    /**
     * Sets the value of the autoClearAlarmTime property.
     * 
     */
    public void setAutoClearAlarmTime(int value) {
        this.autoClearAlarmTime = value;
    }

    /**
     * Gets the value of the rectNum property.
     * 
     */
    public int getRectNum() {
        return rectNum;
    }

    /**
     * Sets the value of the rectNum property.
     * 
     */
    public void setRectNum(int value) {
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
