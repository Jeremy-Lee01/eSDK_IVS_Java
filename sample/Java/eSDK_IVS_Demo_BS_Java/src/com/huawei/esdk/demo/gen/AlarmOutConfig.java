
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlarmOutConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmOutConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmOutName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmOutChanIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="switchType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmOutMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="holdTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlarmOutConfig", propOrder = {
    "alarmOutName",
    "alarmOutChanIndex",
    "switchType",
    "alarmOutMode",
    "holdTime",
    "reserve"
})
public class AlarmOutConfig {

    @XmlElement(required = true)
    protected String alarmOutName;
    protected int alarmOutChanIndex;
    protected int switchType;
    protected int alarmOutMode;
    protected int holdTime;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the alarmOutName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmOutName() {
        return alarmOutName;
    }

    /**
     * Sets the value of the alarmOutName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmOutName(String value) {
        this.alarmOutName = value;
    }

    /**
     * Gets the value of the alarmOutChanIndex property.
     * 
     */
    public int getAlarmOutChanIndex() {
        return alarmOutChanIndex;
    }

    /**
     * Sets the value of the alarmOutChanIndex property.
     * 
     */
    public void setAlarmOutChanIndex(int value) {
        this.alarmOutChanIndex = value;
    }

    /**
     * Gets the value of the switchType property.
     * 
     */
    public int getSwitchType() {
        return switchType;
    }

    /**
     * Sets the value of the switchType property.
     * 
     */
    public void setSwitchType(int value) {
        this.switchType = value;
    }

    /**
     * Gets the value of the alarmOutMode property.
     * 
     */
    public int getAlarmOutMode() {
        return alarmOutMode;
    }

    /**
     * Sets the value of the alarmOutMode property.
     * 
     */
    public void setAlarmOutMode(int value) {
        this.alarmOutMode = value;
    }

    /**
     * Gets the value of the holdTime property.
     * 
     */
    public int getHoldTime() {
        return holdTime;
    }

    /**
     * Sets the value of the holdTime property.
     * 
     */
    public void setHoldTime(int value) {
        this.holdTime = value;
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

}
