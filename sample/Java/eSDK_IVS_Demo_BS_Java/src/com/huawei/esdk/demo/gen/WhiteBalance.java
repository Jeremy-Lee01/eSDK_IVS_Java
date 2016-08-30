
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WhiteBalance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WhiteBalance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="whiteBalanceMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="redGain" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="blueGain" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "WhiteBalance", propOrder = {
    "whiteBalanceMode",
    "redGain",
    "blueGain",
    "reserve"
})
public class WhiteBalance {

    protected int whiteBalanceMode;
    protected int redGain;
    protected int blueGain;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the whiteBalanceMode property.
     * 
     */
    public int getWhiteBalanceMode() {
        return whiteBalanceMode;
    }

    /**
     * Sets the value of the whiteBalanceMode property.
     * 
     */
    public void setWhiteBalanceMode(int value) {
        this.whiteBalanceMode = value;
    }

    /**
     * Gets the value of the redGain property.
     * 
     */
    public int getRedGain() {
        return redGain;
    }

    /**
     * Sets the value of the redGain property.
     * 
     */
    public void setRedGain(int value) {
        this.redGain = value;
    }

    /**
     * Gets the value of the blueGain property.
     * 
     */
    public int getBlueGain() {
        return blueGain;
    }

    /**
     * Sets the value of the blueGain property.
     * 
     */
    public void setBlueGain(int value) {
        this.blueGain = value;
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
