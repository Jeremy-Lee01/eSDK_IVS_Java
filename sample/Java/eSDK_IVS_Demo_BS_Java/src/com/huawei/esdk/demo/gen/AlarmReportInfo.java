
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlarmReportInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmReportInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmInCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceDomainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="occurTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reportTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="action" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alarmId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="occurNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nvrCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alarmDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="extParam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlarmReportInfo", propOrder = {
    "alarmInCode",
    "deviceDomainCode",
    "alarmType",
    "occurTime",
    "reportTime",
    "action",
    "alarmId",
    "occurNumber",
    "nvrCode",
    "reserve",
    "alarmDesc",
    "extParam"
})
public class AlarmReportInfo {

    @XmlElement(required = true)
    protected String alarmInCode;
    @XmlElement(required = true)
    protected String deviceDomainCode;
    @XmlElement(required = true)
    protected String alarmType;
    @XmlElement(required = true)
    protected String occurTime;
    @XmlElement(required = true)
    protected String reportTime;
    protected int action;
    @XmlElement(required = true)
    protected String alarmId;
    protected int occurNumber;
    @XmlElement(required = true)
    protected String nvrCode;
    @XmlElement(required = true)
    protected String reserve;
    @XmlElement(required = true)
    protected String alarmDesc;
    @XmlElement(required = true)
    protected String extParam;

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
     * Gets the value of the deviceDomainCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceDomainCode() {
        return deviceDomainCode;
    }

    /**
     * Sets the value of the deviceDomainCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceDomainCode(String value) {
        this.deviceDomainCode = value;
    }

    /**
     * Gets the value of the alarmType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmType() {
        return alarmType;
    }

    /**
     * Sets the value of the alarmType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmType(String value) {
        this.alarmType = value;
    }

    /**
     * Gets the value of the occurTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccurTime() {
        return occurTime;
    }

    /**
     * Sets the value of the occurTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccurTime(String value) {
        this.occurTime = value;
    }

    /**
     * Gets the value of the reportTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportTime() {
        return reportTime;
    }

    /**
     * Sets the value of the reportTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportTime(String value) {
        this.reportTime = value;
    }

    /**
     * Gets the value of the action property.
     * 
     */
    public int getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     */
    public void setAction(int value) {
        this.action = value;
    }

    /**
     * Gets the value of the alarmId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmId() {
        return alarmId;
    }

    /**
     * Sets the value of the alarmId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmId(String value) {
        this.alarmId = value;
    }

    /**
     * Gets the value of the occurNumber property.
     * 
     */
    public int getOccurNumber() {
        return occurNumber;
    }

    /**
     * Sets the value of the occurNumber property.
     * 
     */
    public void setOccurNumber(int value) {
        this.occurNumber = value;
    }

    /**
     * Gets the value of the nvrCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNvrCode() {
        return nvrCode;
    }

    /**
     * Sets the value of the nvrCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNvrCode(String value) {
        this.nvrCode = value;
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
     * Gets the value of the alarmDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarmDesc() {
        return alarmDesc;
    }

    /**
     * Sets the value of the alarmDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarmDesc(String value) {
        this.alarmDesc = value;
    }

    /**
     * Gets the value of the extParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtParam() {
        return extParam;
    }

    /**
     * Sets the value of the extParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtParam(String value) {
        this.extParam = value;
    }

}
