
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
 *         &lt;element name="alarmTypeInfos" type="{esdk_ivs_professional_server}AlarmTypeInfos"/>
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
    "alarmTypeInfos"
})
@XmlRootElement(name = "setAlarmTypeLevel")
public class SetAlarmTypeLevel {

    @XmlElement(required = true)
    protected AlarmTypeInfos alarmTypeInfos;

    /**
     * Gets the value of the alarmTypeInfos property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmTypeInfos }
     *     
     */
    public AlarmTypeInfos getAlarmTypeInfos() {
        return alarmTypeInfos;
    }

    /**
     * Sets the value of the alarmTypeInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmTypeInfos }
     *     
     */
    public void setAlarmTypeInfos(AlarmTypeInfos value) {
        this.alarmTypeInfos = value;
    }

}
