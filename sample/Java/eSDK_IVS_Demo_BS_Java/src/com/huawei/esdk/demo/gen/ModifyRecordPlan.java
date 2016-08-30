
package com.huawei.esdk.demo.gen;

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
 *         &lt;element name="deviceNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deviceCodeList" type="{esdk_ivs_professional_server}DeviceCodeList"/>
 *         &lt;element name="recordPlan" type="{esdk_ivs_professional_server}RecordPlan"/>
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
    "deviceNum",
    "deviceCodeList",
    "recordPlan"
})
@XmlRootElement(name = "modifyRecordPlan")
public class ModifyRecordPlan {

    protected int deviceNum;
    @XmlElement(required = true)
    protected DeviceCodeList deviceCodeList;
    @XmlElement(required = true)
    protected RecordPlan recordPlan;

    /**
     * Gets the value of the deviceNum property.
     * 
     */
    public int getDeviceNum() {
        return deviceNum;
    }

    /**
     * Sets the value of the deviceNum property.
     * 
     */
    public void setDeviceNum(int value) {
        this.deviceNum = value;
    }

    /**
     * Gets the value of the deviceCodeList property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceCodeList }
     *     
     */
    public DeviceCodeList getDeviceCodeList() {
        return deviceCodeList;
    }

    /**
     * Sets the value of the deviceCodeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceCodeList }
     *     
     */
    public void setDeviceCodeList(DeviceCodeList value) {
        this.deviceCodeList = value;
    }

    /**
     * Gets the value of the recordPlan property.
     * 
     * @return
     *     possible object is
     *     {@link RecordPlan }
     *     
     */
    public RecordPlan getRecordPlan() {
        return recordPlan;
    }

    /**
     * Sets the value of the recordPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordPlan }
     *     
     */
    public void setRecordPlan(RecordPlan value) {
        this.recordPlan = value;
    }

}
