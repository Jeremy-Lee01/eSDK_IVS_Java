
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
    protected int userNum;
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
     */
    public int getUserNum() {
        return userNum;
    }

    /**
     * Sets the value of the userNum property.
     * 
     */
    public void setUserNum(int value) {
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
