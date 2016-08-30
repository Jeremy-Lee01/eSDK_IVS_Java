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
 * <p>Java class for DeviceOperResultInfos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceOperResultInfos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deviceOperResultList" type="{esdk_ivs_professional_server}DeviceOperResultList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceOperResultInfos", propOrder = {
    "number",
    "deviceOperResultList"
})
public class DeviceOperResultInfos {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer number;
    @XmlElement(required = true)
    protected DeviceOperResultList deviceOperResultList;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

    /**
     * Gets the value of the deviceOperResultList property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceOperResultList }
     *     
     */
    public DeviceOperResultList getDeviceOperResultList() {
        return deviceOperResultList;
    }

    /**
     * Sets the value of the deviceOperResultList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceOperResultList }
     *     
     */
    public void setDeviceOperResultList(DeviceOperResultList value) {
        this.deviceOperResultList = value;
    }

}
