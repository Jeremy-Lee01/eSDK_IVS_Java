
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmLevelNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="alarmLevelList" type="{esdk_ivs_professional_server}AlarmLevelList" minOccurs="0"/>
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
    "resultCode",
    "alarmLevelNum",
    "alarmLevelList"
})
@XmlRootElement(name = "getAlarmLevelListResponse")
public class GetAlarmLevelListResponse {

    protected int resultCode;
    protected Integer alarmLevelNum;
    protected AlarmLevelList alarmLevelList;

    /**
     * Gets the value of the resultCode property.
     * 
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     */
    public void setResultCode(int value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the alarmLevelNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAlarmLevelNum() {
        return alarmLevelNum;
    }

    /**
     * Sets the value of the alarmLevelNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAlarmLevelNum(Integer value) {
        this.alarmLevelNum = value;
    }

    /**
     * Gets the value of the alarmLevelList property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmLevelList }
     *     
     */
    public AlarmLevelList getAlarmLevelList() {
        return alarmLevelList;
    }

    /**
     * Sets the value of the alarmLevelList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmLevelList }
     *     
     */
    public void setAlarmLevelList(AlarmLevelList value) {
        this.alarmLevelList = value;
    }

}
