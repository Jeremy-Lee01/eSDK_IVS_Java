
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PwdConsist complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PwdConsist">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capital" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lowercase" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="figure" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="specialChar" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "PwdConsist", propOrder = {
    "capital",
    "lowercase",
    "figure",
    "specialChar",
    "reserve"
})
public class PwdConsist {

    protected int capital;
    protected int lowercase;
    protected int figure;
    protected int specialChar;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the capital property.
     * 
     */
    public int getCapital() {
        return capital;
    }

    /**
     * Sets the value of the capital property.
     * 
     */
    public void setCapital(int value) {
        this.capital = value;
    }

    /**
     * Gets the value of the lowercase property.
     * 
     */
    public int getLowercase() {
        return lowercase;
    }

    /**
     * Sets the value of the lowercase property.
     * 
     */
    public void setLowercase(int value) {
        this.lowercase = value;
    }

    /**
     * Gets the value of the figure property.
     * 
     */
    public int getFigure() {
        return figure;
    }

    /**
     * Sets the value of the figure property.
     * 
     */
    public void setFigure(int value) {
        this.figure = value;
    }

    /**
     * Gets the value of the specialChar property.
     * 
     */
    public int getSpecialChar() {
        return specialChar;
    }

    /**
     * Sets the value of the specialChar property.
     * 
     */
    public void setSpecialChar(int value) {
        this.specialChar = value;
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
