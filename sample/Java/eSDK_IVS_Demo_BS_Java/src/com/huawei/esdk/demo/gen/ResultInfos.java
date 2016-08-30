
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultInfos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultInfos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="resultInfoList" type="{esdk_ivs_professional_server}ResultInfoList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultInfos", propOrder = {
    "number",
    "resultInfoList"
})
public class ResultInfos {

    protected int number;
    @XmlElement(required = true)
    protected ResultInfoList resultInfoList;

    /**
     * Gets the value of the number property.
     * 
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     */
    public void setNumber(int value) {
        this.number = value;
    }

    /**
     * Gets the value of the resultInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link ResultInfoList }
     *     
     */
    public ResultInfoList getResultInfoList() {
        return resultInfoList;
    }

    /**
     * Sets the value of the resultInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultInfoList }
     *     
     */
    public void setResultInfoList(ResultInfoList value) {
        this.resultInfoList = value;
    }

}
