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
 * <p>Java class for AlarmCommissionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmCommissionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmEventId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="userNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userIdInfoList" type="{esdk_ivs_professional_server}UserIdInfoList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlarmCommissionInfo", propOrder = {
    "alarmEventId",
    "userNum",
    "userIdInfoList"
})
public class AlarmCommissionInfo {

    @XmlSchemaType(name = "unsignedInt")
    protected long alarmEventId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer userNum;
    @XmlElement(required = true)
    protected UserIdInfoList userIdInfoList;

    /**
     * Gets the value of the alarmEventId property.
     * 
     */
    public long getAlarmEventId() {
        return alarmEventId;
    }

    /**
     * Sets the value of the alarmEventId property.
     * 
     */
    public void setAlarmEventId(long value) {
        this.alarmEventId = value;
    }

    /**
     * Gets the value of the userNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getUserNum() {
        return userNum;
    }

    /**
     * Sets the value of the userNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserNum(Integer value) {
        this.userNum = value;
    }

    /**
     * Gets the value of the userIdInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link UserIdInfoList }
     *     
     */
    public UserIdInfoList getUserIdInfoList() {
        return userIdInfoList;
    }

    /**
     * Sets the value of the userIdInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserIdInfoList }
     *     
     */
    public void setUserIdInfoList(UserIdInfoList value) {
        this.userIdInfoList = value;
    }

}
