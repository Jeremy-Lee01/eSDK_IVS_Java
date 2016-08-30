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
 * <p>Java class for PlanInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlanInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dayType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeSpanInfoNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeSpanInfoList" type="{esdk_ivs_professional_server}TimeSpanList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlanInfo", propOrder = {
    "dayType",
    "timeSpanInfoNum",
    "reserve",
    "timeSpanInfoList"
})
public class PlanInfo {

    protected int dayType;
    protected int timeSpanInfoNum;
    @XmlElement(required = true)
    protected String reserve;
    @XmlElement(required = true)
    protected TimeSpanList timeSpanInfoList;

    /**
     * Gets the value of the dayType property.
     * 
     */
    public int getDayType() {
        return dayType;
    }

    /**
     * Sets the value of the dayType property.
     * 
     */
    public void setDayType(int value) {
        this.dayType = value;
    }

    /**
     * Gets the value of the timeSpanInfoNum property.
     * 
     */
    public int getTimeSpanInfoNum() {
        return timeSpanInfoNum;
    }

    /**
     * Sets the value of the timeSpanInfoNum property.
     * 
     */
    public void setTimeSpanInfoNum(int value) {
        this.timeSpanInfoNum = value;
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

    /**
     * Gets the value of the timeSpanInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link TimeSpanList }
     *     
     */
    public TimeSpanList getTimeSpanInfoList() {
        return timeSpanInfoList;
    }

    /**
     * Sets the value of the timeSpanInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeSpanList }
     *     
     */
    public void setTimeSpanInfoList(TimeSpanList value) {
        this.timeSpanInfoList = value;
    }

}
