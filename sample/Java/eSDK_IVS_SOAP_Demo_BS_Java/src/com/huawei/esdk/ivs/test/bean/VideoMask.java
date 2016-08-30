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
 * <p>Java class for VideoMask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VideoMask">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableVideoMask" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="areaNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rectAreaList" type="{esdk_ivs_professional_server}RectInfoList"/>
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
@XmlType(name = "VideoMask", propOrder = {
    "enableVideoMask",
    "areaNum",
    "rectAreaList",
    "reserve"
})
public class VideoMask {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer enableVideoMask;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer areaNum;
    @XmlElement(required = true)
    protected RectInfoList rectAreaList;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enableVideoMask property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getEnableVideoMask() {
        return enableVideoMask;
    }

    /**
     * Sets the value of the enableVideoMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableVideoMask(Integer value) {
        this.enableVideoMask = value;
    }

    /**
     * Gets the value of the areaNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAreaNum() {
        return areaNum;
    }

    /**
     * Sets the value of the areaNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaNum(Integer value) {
        this.areaNum = value;
    }

    /**
     * Gets the value of the rectAreaList property.
     * 
     * @return
     *     possible object is
     *     {@link RectInfoList }
     *     
     */
    public RectInfoList getRectAreaList() {
        return rectAreaList;
    }

    /**
     * Sets the value of the rectAreaList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RectInfoList }
     *     
     */
    public void setRectAreaList(RectInfoList value) {
        this.rectAreaList = value;
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
