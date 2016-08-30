
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="alarmEventId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="alarmInCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operateInfo" type="{esdk_ivs_professional_server}AlarmOperateInfo"/>
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
    "alarmEventId",
    "alarmInCode",
    "operateInfo"
})
@XmlRootElement(name = "alarmCancel")
public class AlarmCancel {

    @XmlSchemaType(name = "unsignedInt")
    protected long alarmEventId;
    @XmlElement(required = true)
    protected String alarmInCode;
    @XmlElement(required = true)
    protected AlarmOperateInfo operateInfo;

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
     * Gets the value of the operateInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmOperateInfo }
     *     
     */
    public AlarmOperateInfo getOperateInfo() {
        return operateInfo;
    }

    /**
     * Sets the value of the operateInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmOperateInfo }
     *     
     */
    public void setOperateInfo(AlarmOperateInfo value) {
        this.operateInfo = value;
    }

}
