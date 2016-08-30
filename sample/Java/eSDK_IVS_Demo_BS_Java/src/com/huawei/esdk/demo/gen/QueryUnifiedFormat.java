
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryUnifiedFormat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryUnifiedFormat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="index" type="{esdk_ivs_professional_server}IndexRange"/>
 *         &lt;element name="orderCondition" type="{esdk_ivs_professional_server}OrderCondition"/>
 *         &lt;element name="fieldNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="queryFieldList" type="{esdk_ivs_professional_server}QueryFieldList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryUnifiedFormat", propOrder = {
    "index",
    "orderCondition",
    "fieldNum",
    "queryFieldList"
})
public class QueryUnifiedFormat {

    @XmlElement(required = true)
    protected IndexRange index;
    @XmlElement(required = true)
    protected OrderCondition orderCondition;
    protected int fieldNum;
    @XmlElement(required = true)
    protected QueryFieldList queryFieldList;

    /**
     * Gets the value of the index property.
     * 
     * @return
     *     possible object is
     *     {@link IndexRange }
     *     
     */
    public IndexRange getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndexRange }
     *     
     */
    public void setIndex(IndexRange value) {
        this.index = value;
    }

    /**
     * Gets the value of the orderCondition property.
     * 
     * @return
     *     possible object is
     *     {@link OrderCondition }
     *     
     */
    public OrderCondition getOrderCondition() {
        return orderCondition;
    }

    /**
     * Sets the value of the orderCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderCondition }
     *     
     */
    public void setOrderCondition(OrderCondition value) {
        this.orderCondition = value;
    }

    /**
     * Gets the value of the fieldNum property.
     * 
     */
    public int getFieldNum() {
        return fieldNum;
    }

    /**
     * Sets the value of the fieldNum property.
     * 
     */
    public void setFieldNum(int value) {
        this.fieldNum = value;
    }

    /**
     * Gets the value of the queryFieldList property.
     * 
     * @return
     *     possible object is
     *     {@link QueryFieldList }
     *     
     */
    public QueryFieldList getQueryFieldList() {
        return queryFieldList;
    }

    /**
     * Sets the value of the queryFieldList property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryFieldList }
     *     
     */
    public void setQueryFieldList(QueryFieldList value) {
        this.queryFieldList = value;
    }

}
