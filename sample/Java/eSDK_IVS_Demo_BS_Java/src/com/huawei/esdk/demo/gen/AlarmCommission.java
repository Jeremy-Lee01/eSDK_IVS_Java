
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
