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
 * <p>Java class for WhiteBalance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WhiteBalance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="whiteBalanceMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="redGain" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="blueGain" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "WhiteBalance", propOrder = {
    "whiteBalanceMode",
    "redGain",
    "blueGain",
    "reserve"
})
public class WhiteBalance {

    protected int whiteBalanceMode;
    protected int redGain;
    protected int blueGain;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the whiteBalanceMode property.
     * 
     */
    public int getWhiteBalanceMode() {
        return whiteBalanceMode;
    }

    /**
     * Sets the value of the whiteBalanceMode property.
     * 
     */
    public void setWhiteBalanceMode(int value) {
        this.whiteBalanceMode = value;
    }

    /**
     * Gets the value of the redGain property.
     * 
     */
    public int getRedGain() {
        return redGain;
    }

    /**
     * Sets the value of the redGain property.
     * 
     */
    public void setRedGain(int value) {
        this.redGain = value;
    }

    /**
     * Gets the value of the blueGain property.
     * 
     */
    public int getBlueGain() {
        return blueGain;
    }

    /**
     * Sets the value of the blueGain property.
     * 
     */
    public void setBlueGain(int value) {
        this.blueGain = value;
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
