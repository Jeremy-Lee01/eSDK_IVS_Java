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
 * <p>Java class for BookmarkInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BookmarkInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookmarkId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bookmarkName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bookmarkTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cameraCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cameraName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userDomain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bookmarkCreatorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bookmarkCreatorName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nvrCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mbuDomain" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "BookmarkInfo", propOrder = {
    "bookmarkId",
    "bookmarkName",
    "bookmarkTime",
    "cameraCode",
    "cameraName",
    "userDomain",
    "bookmarkCreatorId",
    "bookmarkCreatorName",
    "nvrCode",
    "mbuDomain",
    "reserve"
})
public class BookmarkInfo {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer bookmarkId;
    @XmlElement(required = true)
    protected String bookmarkName;
    @XmlElement(required = true)
    protected String bookmarkTime;
    @XmlElement(required = true)
    protected String cameraCode;
    @XmlElement(required = true)
    protected String cameraName;
    @XmlElement(required = true)
    protected String userDomain;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer bookmarkCreatorId;
    @XmlElement(required = true)
    protected String bookmarkCreatorName;
    @XmlElement(required = true)
    protected String nvrCode;
    @XmlElement(required = true)
    protected String mbuDomain;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the bookmarkId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getBookmarkId() {
        return bookmarkId;
    }

    /**
     * Sets the value of the bookmarkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookmarkId(Integer value) {
        this.bookmarkId = value;
    }

    /**
     * Gets the value of the bookmarkName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookmarkName() {
        return bookmarkName;
    }

    /**
     * Sets the value of the bookmarkName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookmarkName(String value) {
        this.bookmarkName = value;
    }

    /**
     * Gets the value of the bookmarkTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookmarkTime() {
        return bookmarkTime;
    }

    /**
     * Sets the value of the bookmarkTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookmarkTime(String value) {
        this.bookmarkTime = value;
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
     * Gets the value of the cameraName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCameraName() {
        return cameraName;
    }

    /**
     * Sets the value of the cameraName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCameraName(String value) {
        this.cameraName = value;
    }

    /**
     * Gets the value of the userDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserDomain() {
        return userDomain;
    }

    /**
     * Sets the value of the userDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserDomain(String value) {
        this.userDomain = value;
    }

    /**
     * Gets the value of the bookmarkCreatorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getBookmarkCreatorId() {
        return bookmarkCreatorId;
    }

    /**
     * Sets the value of the bookmarkCreatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookmarkCreatorId(Integer value) {
        this.bookmarkCreatorId = value;
    }

    /**
     * Gets the value of the bookmarkCreatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookmarkCreatorName() {
        return bookmarkCreatorName;
    }

    /**
     * Sets the value of the bookmarkCreatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookmarkCreatorName(String value) {
        this.bookmarkCreatorName = value;
    }

    /**
     * Gets the value of the nvrCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNvrCode() {
        return nvrCode;
    }

    /**
     * Sets the value of the nvrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNvrCode(String value) {
        this.nvrCode = value;
    }

    /**
     * Gets the value of the mbuDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMbuDomain() {
        return mbuDomain;
    }

    /**
     * Sets the value of the mbuDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMbuDomain(String value) {
        this.mbuDomain = value;
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
