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
 * <p>Java class for DeviceTimeConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceTimeConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableNTP" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ntp" type="{esdk_ivs_professional_server}NTPInfo"/>
 *         &lt;element name="timezone" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableDST" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "DeviceTimeConfig", propOrder = {
    "enableNTP",
    "ntp",
    "timezone",
    "enableDST",
    "reserve"
})
public class DeviceTimeConfig {

    protected int enableNTP;
    @XmlElement(required = true)
    protected NTPInfo ntp;
    protected int timezone;
    protected int enableDST;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the enableNTP property.
     * 
     */
    public int getEnableNTP() {
        return enableNTP;
    }

    /**
     * Sets the value of the enableNTP property.
     * 
     */
    public void setEnableNTP(int value) {
        this.enableNTP = value;
    }

    /**
     * Gets the value of the ntp property.
     * 
     * @return
     *     possible object is
     *     {@link NTPInfo }
     *     
     */
    public NTPInfo getNtp() {
        return ntp;
    }

    /**
     * Sets the value of the ntp property.
     * 
     * @param value
     *     allowed object is
     *     {@link NTPInfo }
     *     
     */
    public void setNtp(NTPInfo value) {
        this.ntp = value;
    }

    /**
     * Gets the value of the timezone property.
     * 
     */
    public int getTimezone() {
        return timezone;
    }

    /**
     * Sets the value of the timezone property.
     * 
     */
    public void setTimezone(int value) {
        this.timezone = value;
    }

    /**
     * Gets the value of the enableDST property.
     * 
     */
    public int getEnableDST() {
        return enableDST;
    }

    /**
     * Sets the value of the enableDST property.
     * 
     */
    public void setEnableDST(int value) {
        this.enableDST = value;
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
