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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlarmEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmNotify" type="{esdk_ivs_professional_server}AlarmNotify"/>
 *         &lt;element name="operateInfo" type="{esdk_ivs_professional_server}AlarmOperateInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlarmEvent", propOrder = {
    "alarmNotify",
    "operateInfo"
})
public class AlarmEvent {

    @XmlElement(required = true)
    protected AlarmNotify alarmNotify;
    @XmlElement(required = true)
    protected AlarmOperateInfo operateInfo;

    /**
     * Gets the value of the alarmNotify property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmNotify }
     *     
     */
    public AlarmNotify getAlarmNotify() {
        return alarmNotify;
    }

    /**
     * Sets the value of the alarmNotify property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmNotify }
     *     
     */
    public void setAlarmNotify(AlarmNotify value) {
        this.alarmNotify = value;
    }

    /**
     * Gets the value of the operateInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmOperateInfo }
     *     
     */
    public AlarmOperateInfo getOperateInfo() {
        return operateInfo;
    }

    /**
     * Sets the value of the operateInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmOperateInfo }
     *     
     */
    public void setOperateInfo(AlarmOperateInfo value) {
        this.operateInfo = value;
    }

}
