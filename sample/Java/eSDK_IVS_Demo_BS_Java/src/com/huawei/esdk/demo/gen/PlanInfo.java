
package com.huawei.esdk.demo.gen;

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
