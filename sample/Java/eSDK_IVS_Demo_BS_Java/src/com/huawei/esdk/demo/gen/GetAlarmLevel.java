
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
 *         &lt;element name="alarmLevelID" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "alarmLevelID"
})
@XmlRootElement(name = "getAlarmLevel")
public class GetAlarmLevel {

    protected int alarmLevelID;

    /**
     * Gets the value of the alarmLevelID property.
     * 
     */
    public int getAlarmLevelID() {
        return alarmLevelID;
    }

    /**
     * Sets the value of the alarmLevelID property.
     * 
     */
    public void setAlarmLevelID(int value) {
        this.alarmLevelID = value;
    }

}
