
package com.huawei.esdk.demo.gen;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DomainRouteList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DomainRouteList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="domainRoute" type="{esdk_ivs_professional_server}DomainRoute" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DomainRouteList", propOrder = {
    "domainRoute"
})
public class DomainRouteList {

    @XmlElement(required = true)
    protected List<DomainRoute> domainRoute;

    /**
     * Gets the value of the domainRoute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the domainRoute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDomainRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DomainRoute }
     * 
     * 
     */
    public List<DomainRoute> getDomainRoute() {
        if (domainRoute == null) {
            domainRoute = new ArrayList<DomainRoute>();
        }
        return this.domainRoute;
    }

}
