
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="queryFormat" type="{esdk_ivs_professional_server}QueryUnifiedFormat"/>
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
    "domainCode",
    "deviceType",
    "queryFormat"
})
@XmlRootElement(name = "queryDeviceList")
public class QueryDeviceList {

    @XmlElement(required = true)
    protected String domainCode;
    protected int deviceType;
    @XmlElement(required = true)
    protected QueryUnifiedFormat queryFormat;

    /**
     * Gets the value of the domainCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainCode() {
        return domainCode;
    }

    /**
     * Sets the value of the domainCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainCode(String value) {
        this.domainCode = value;
    }

    /**
     * Gets the value of the deviceType property.
     * 
     */
    public int getDeviceType() {
        return deviceType;
    }

    /**
     * Sets the value of the deviceType property.
     * 
     */
    public void setDeviceType(int value) {
        this.deviceType = value;
    }

    /**
     * Gets the value of the queryFormat property.
     * 
     * @return
     *     possible object is
     *     {@link QueryUnifiedFormat }
     *     
     */
    public QueryUnifiedFormat getQueryFormat() {
        return queryFormat;
    }

    /**
     * Sets the value of the queryFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryUnifiedFormat }
     *     
     */
    public void setQueryFormat(QueryUnifiedFormat value) {
        this.queryFormat = value;
    }

}
