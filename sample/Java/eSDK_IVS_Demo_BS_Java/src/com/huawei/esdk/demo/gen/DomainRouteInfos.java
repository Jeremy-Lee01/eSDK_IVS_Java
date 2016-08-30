
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DomainRouteInfos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DomainRouteInfos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="domainRouteList" type="{esdk_ivs_professional_server}DomainRouteList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DomainRouteInfos", propOrder = {
    "total",
    "domainRouteList"
})
public class DomainRouteInfos {

    protected int total;
    @XmlElement(required = true)
    protected DomainRouteList domainRouteList;

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
     * Gets the value of the domainRouteList property.
     * 
     * @return
     *     possible object is
     *     {@link DomainRouteList }
     *     
     */
    public DomainRouteList getDomainRouteList() {
        return domainRouteList;
    }

    /**
     * Sets the value of the domainRouteList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DomainRouteList }
     *     
     */
    public void setDomainRouteList(DomainRouteList value) {
        this.domainRouteList = value;
    }

}
