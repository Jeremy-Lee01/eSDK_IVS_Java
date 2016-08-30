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
package com.huawei.esdk.ivs.test.service.impl.autogen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.huawei.esdk.ivs.test.bean.AlarmCommissionInfo;


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
 *         &lt;element name="alarmInCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmCommissionInfo" type="{esdk_ivs_professional_server}AlarmCommissionInfo"/>
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
    "alarmInCode",
    "alarmCommissionInfo"
})
@XmlRootElement(name = "alarmCommission")
public class AlarmCommission {

    @XmlElement(required = true)
    protected String alarmInCode;
    @XmlElement(required = true)
    protected AlarmCommissionInfo alarmCommissionInfo;

    /**
     * Gets the value of the alarmInCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmInCode() {
        return alarmInCode;
    }

    /**
     * Sets the value of the alarmInCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmInCode(String value) {
        this.alarmInCode = value;
    }

    /**
     * Gets the value of the alarmCommissionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmCommissionInfo }
     *     
     */
    public AlarmCommissionInfo getAlarmCommissionInfo() {
        return alarmCommissionInfo;
    }

    /**
     * Sets the value of the alarmCommissionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmCommissionInfo }
     *     
     */
    public void setAlarmCommissionInfo(AlarmCommissionInfo value) {
        this.alarmCommissionInfo = value;
    }

}
