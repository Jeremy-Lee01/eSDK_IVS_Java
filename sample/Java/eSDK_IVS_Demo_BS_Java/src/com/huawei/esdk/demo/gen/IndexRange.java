
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IndexRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndexRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fromIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="toIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndexRange", propOrder = {
    "fromIndex",
    "toIndex"
})
public class IndexRange {

    protected int fromIndex;
    protected int toIndex;

    /**
     * Gets the value of the fromIndex property.
     * 
     */
    public int getFromIndex() {
        return fromIndex;
    }

    /**
     * Sets the value of the fromIndex property.
     * 
     */
    public void setFromIndex(int value) {
        this.fromIndex = value;
    }

    /**
     * Gets the value of the toIndex property.
     * 
     */
    public int getToIndex() {
        return toIndex;
    }

    /**
     * Sets the value of the toIndex property.
     * 
     */
    public void setToIndex(int value) {
        this.toIndex = value;
    }

}
