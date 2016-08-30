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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="realplayParam" type="{esdk_ivs_professional_server}RealplayParam"/>
 *         &lt;element name="cameraCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mediaAddrDst" type="{esdk_ivs_professional_server}MediaAddress"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "realplayParam",
    "cameraCode",
    "mediaAddrDst"
})
@XmlRootElement(name = "startRealPlayByIPEx")
public class StartRealPlayByIPEx {

    @XmlElement(required = true)
    protected RealplayParam realplayParam;
    @XmlElement(required = true)
    protected String cameraCode;
    @XmlElement(required = true)
    protected MediaAddress mediaAddrDst;

    /**
     * Gets the value of the realplayParam property.
     * 
     * @return
     *     possible object is
     *     {@link RealplayParam }
     *     
     */
    public RealplayParam getRealplayParam() {
        return realplayParam;
    }

    /**
     * Sets the value of the realplayParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealplayParam }
     *     
     */
    public void setRealplayParam(RealplayParam value) {
        this.realplayParam = value;
    }

    /**
     * Gets the value of the cameraCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCameraCode() {
        return cameraCode;
    }

    /**
     * Sets the value of the cameraCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCameraCode(String value) {
        this.cameraCode = value;
    }

    /**
     * Gets the value of the mediaAddrDst property.
     * 
     * @return
     *     possible object is
     *     {@link MediaAddress }
     *     
     */
    public MediaAddress getMediaAddrDst() {
        return mediaAddrDst;
    }

    /**
     * Sets the value of the mediaAddrDst property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaAddress }
     *     
     */
    public void setMediaAddrDst(MediaAddress value) {
        this.mediaAddrDst = value;
    }

}
