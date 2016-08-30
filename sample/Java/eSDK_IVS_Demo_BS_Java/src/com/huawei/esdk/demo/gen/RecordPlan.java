
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecordPlan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecordPlan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordMethod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="enableRecordPlan" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recordPlanType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="planInfoNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="planInfoList" type="{esdk_ivs_professional_server}PlanInfoList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordPlan", propOrder = {
    "recordMethod",
    "enableRecordPlan",
    "recordPlanType",
    "reserve",
    "planInfoNum",
    "planInfoList"
})
public class RecordPlan {

    protected int recordMethod;
    protected int enableRecordPlan;
    protected int recordPlanType;
    @XmlElement(required = true)
    protected String reserve;
    protected int planInfoNum;
    @XmlElement(required = true)
    protected PlanInfoList planInfoList;

    /**
     * Gets the value of the recordMethod property.
     * 
     */
    public int getRecordMethod() {
        return recordMethod;
    }

    /**
     * Sets the value of the recordMethod property.
     * 
     */
    public void setRecordMethod(int value) {
        this.recordMethod = value;
    }

    /**
     * Gets the value of the enableRecordPlan property.
     * 
     */
    public int getEnableRecordPlan() {
        return enableRecordPlan;
    }

    /**
     * Sets the value of the enableRecordPlan property.
     * 
     */
    public void setEnableRecordPlan(int value) {
        this.enableRecordPlan = value;
    }

    /**
     * Gets the value of the recordPlanType property.
     * 
     */
    public int getRecordPlanType() {
        return recordPlanType;
    }

    /**
     * Sets the value of the recordPlanType property.
     * 
     */
    public void setRecordPlanType(int value) {
        this.recordPlanType = value;
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
     * Gets the value of the planInfoNum property.
     * 
     */
    public int getPlanInfoNum() {
        return planInfoNum;
    }

    /**
     * Sets the value of the planInfoNum property.
     * 
     */
    public void setPlanInfoNum(int value) {
        this.planInfoNum = value;
    }

    /**
     * Gets the value of the planInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link PlanInfoList }
     *     
     */
    public PlanInfoList getPlanInfoList() {
        return planInfoList;
    }

    /**
     * Sets the value of the planInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanInfoList }
     *     
     */
    public void setPlanInfoList(PlanInfoList value) {
        this.planInfoList = value;
    }

}
