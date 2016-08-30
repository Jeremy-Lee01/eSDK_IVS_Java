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
 * <p>Java class for DeviceNetConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceNetConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="puIP" type="{esdk_ivs_professional_server}IPInfo"/>
 *         &lt;element name="puGateway" type="{esdk_ivs_professional_server}IPInfo"/>
 *         &lt;element name="puPort" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxMtu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="subNetMask" type="{esdk_ivs_professional_server}IPInfo"/>
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
@XmlType(name = "DeviceNetConfig", propOrder = {
    "puIP",
    "puGateway",
    "puPort",
    "maxMtu",
    "subNetMask",
    "reserve"
})
public class DeviceNetConfig {

    @XmlElement(required = true)
    protected IPInfo puIP;
    @XmlElement(required = true)
    protected IPInfo puGateway;
    protected int puPort;
    protected int maxMtu;
    @XmlElement(required = true)
    protected IPInfo subNetMask;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the puIP property.
     * 
     * @return
     *     possible object is
     *     {@link IPInfo }
     *     
     */
    public IPInfo getPuIP() {
        return puIP;
    }

    /**
     * Sets the value of the puIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPInfo }
     *     
     */
    public void setPuIP(IPInfo value) {
        this.puIP = value;
    }

    /**
     * Gets the value of the puGateway property.
     * 
     * @return
     *     possible object is
     *     {@link IPInfo }
     *     
     */
    public IPInfo getPuGateway() {
        return puGateway;
    }

    /**
     * Sets the value of the puGateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPInfo }
     *     
     */
    public void setPuGateway(IPInfo value) {
        this.puGateway = value;
    }

    /**
     * Gets the value of the puPort property.
     * 
     */
    public int getPuPort() {
        return puPort;
    }

    /**
     * Sets the value of the puPort property.
     * 
     */
    public void setPuPort(int value) {
        this.puPort = value;
    }

    /**
     * Gets the value of the maxMtu property.
     * 
     */
    public int getMaxMtu() {
        return maxMtu;
    }

    /**
     * Sets the value of the maxMtu property.
     * 
     */
    public void setMaxMtu(int value) {
        this.maxMtu = value;
    }

    /**
     * Gets the value of the subNetMask property.
     * 
     * @return
     *     possible object is
     *     {@link IPInfo }
     *     
     */
    public IPInfo getSubNetMask() {
        return subNetMask;
    }

    /**
     * Sets the value of the subNetMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPInfo }
     *     
     */
    public void setSubNetMask(IPInfo value) {
        this.subNetMask = value;
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
