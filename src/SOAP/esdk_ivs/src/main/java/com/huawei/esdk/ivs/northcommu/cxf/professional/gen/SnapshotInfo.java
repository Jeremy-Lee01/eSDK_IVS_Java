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
 * <p>Java class for SnapshotInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SnapshotInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cameraCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="snapTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="snapType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pictureID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pictureName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pictureSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="previewUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pictureUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "SnapshotInfo", propOrder = {
    "cameraCode",
    "snapTime",
    "snapType",
    "pictureID",
    "pictureName",
    "pictureSize",
    "previewUrl",
    "pictureUrl",
    "reserve"
})
public class SnapshotInfo {

    @XmlElement(required = true)
    protected String cameraCode;
    @XmlElement(required = true)
    protected String snapTime;
    protected int snapType;
    protected int pictureID;
    @XmlElement(required = true)
    protected String pictureName;
    protected int pictureSize;
    @XmlElement(required = true)
    protected String previewUrl;
    @XmlElement(required = true)
    protected String pictureUrl;
    @XmlElement(required = true)
    protected String reserve;

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
     * Gets the value of the snapTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSnapTime() {
        return snapTime;
    }

    /**
     * Sets the value of the snapTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSnapTime(String value) {
        this.snapTime = value;
    }

    /**
     * Gets the value of the snapType property.
     * 
     */
    public int getSnapType() {
        return snapType;
    }

    /**
     * Sets the value of the snapType property.
     * 
     */
    public void setSnapType(int value) {
        this.snapType = value;
    }

    /**
     * Gets the value of the pictureID property.
     * 
     */
    public int getPictureID() {
        return pictureID;
    }

    /**
     * Sets the value of the pictureID property.
     * 
     */
    public void setPictureID(int value) {
        this.pictureID = value;
    }

    /**
     * Gets the value of the pictureName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPictureName() {
        return pictureName;
    }

    /**
     * Sets the value of the pictureName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureName(String value) {
        this.pictureName = value;
    }

    /**
     * Gets the value of the pictureSize property.
     * 
     */
    public int getPictureSize() {
        return pictureSize;
    }

    /**
     * Sets the value of the pictureSize property.
     * 
     */
    public void setPictureSize(int value) {
        this.pictureSize = value;
    }

    /**
     * Gets the value of the previewUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * Sets the value of the previewUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviewUrl(String value) {
        this.previewUrl = value;
    }

    /**
     * Gets the value of the pictureUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * Sets the value of the pictureUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureUrl(String value) {
        this.pictureUrl = value;
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
