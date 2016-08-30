
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
