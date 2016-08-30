
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CameraBriefInfos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CameraBriefInfos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="indexRange" type="{esdk_ivs_professional_server}IndexRange"/>
 *         &lt;element name="cameraBriefInfoList" type="{esdk_ivs_professional_server}CameraBriefInfoList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CameraBriefInfos", propOrder = {
    "total",
    "indexRange",
    "cameraBriefInfoList"
})
public class CameraBriefInfos {

    protected int total;
    @XmlElement(required = true)
    protected IndexRange indexRange;
    @XmlElement(required = true)
    protected CameraBriefInfoList cameraBriefInfoList;

    /**
     * Gets the value of the total property.
     * 
     */
    public int getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     */
    public void setTotal(int value) {
        this.total = value;
    }

    /**
     * Gets the value of the indexRange property.
     * 
     * @return
     *     possible object is
     *     {@link IndexRange }
     *     
     */
    public IndexRange getIndexRange() {
        return indexRange;
    }

    /**
     * Sets the value of the indexRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndexRange }
     *     
     */
    public void setIndexRange(IndexRange value) {
        this.indexRange = value;
    }

    /**
     * Gets the value of the cameraBriefInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link CameraBriefInfoList }
     *     
     */
    public CameraBriefInfoList getCameraBriefInfoList() {
        return cameraBriefInfoList;
    }

    /**
     * Sets the value of the cameraBriefInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CameraBriefInfoList }
     *     
     */
    public void setCameraBriefInfoList(CameraBriefInfoList value) {
        this.cameraBriefInfoList = value;
    }

}
