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
 *         &lt;element name="alarmReportInfo" type="{esdk_ivs_professional_server}AlarmReportInfo"/>
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
    "alarmReportInfo"
})
@XmlRootElement(name = "alarmReport")
public class AlarmReport {

    @XmlElement(required = true)
    protected AlarmReportInfo alarmReportInfo;

    /**
     * Gets the value of the alarmReportInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmReportInfo }
     *     
     */
    public AlarmReportInfo getAlarmReportInfo() {
        return alarmReportInfo;
    }

    /**
     * Sets the value of the alarmReportInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmReportInfo }
     *     
     */
    public void setAlarmReportInfo(AlarmReportInfo value) {
        this.alarmReportInfo = value;
    }

}
