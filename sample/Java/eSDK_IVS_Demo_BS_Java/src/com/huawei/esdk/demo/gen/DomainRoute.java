
package com.huawei.esdk.demo.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DomainRoute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DomainRoute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="domainType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isAgent" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="domainCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="domainName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="domainIPInfo" type="{esdk_ivs_professional_server}IPInfo"/>
 *         &lt;element name="domainPort" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="superDomain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isLocalDomain" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "DomainRoute", propOrder = {
    "domainType",
    "isAgent",
    "domainCode",
    "domainName",
    "domainIPInfo",
    "domainPort",
    "superDomain",
    "isLocalDomain",
    "reserve"
})
public class DomainRoute {

    protected int domainType;
    protected int isAgent;
    @XmlElement(required = true)
    protected String domainCode;
    @XmlElement(required = true)
    protected String domainName;
    @XmlElement(required = true)
    protected IPInfo domainIPInfo;
    protected int domainPort;
    @XmlElement(required = true)
    protected String superDomain;
    protected int isLocalDomain;
    @XmlElement(required = true)
    protected String reserve;

    /**
     * Gets the value of the domainType property.
     * 
     */
    public int getDomainType() {
        return domainType;
    }

    /**
     * Sets the value of the domainType property.
     * 
     */
    public void setDomainType(int value) {
        this.domainType = value;
    }

    /**
     * Gets the value of the isAgent property.
     * 
     */
    public int getIsAgent() {
        return isAgent;
    }

    /**
     * Sets the value of the isAgent property.
     * 
     */
    public void setIsAgent(int value) {
        this.isAgent = value;
    }

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
     * Gets the value of the domainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Sets the value of the domainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainName(String value) {
        this.domainName = value;
    }

    /**
     * Gets the value of the domainIPInfo property.
     * 
     * @return
     *     possible object is
     *     {@link IPInfo }
     *     
     */
    public IPInfo getDomainIPInfo() {
        return domainIPInfo;
    }

    /**
     * Sets the value of the domainIPInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPInfo }
     *     
     */
    public void setDomainIPInfo(IPInfo value) {
        this.domainIPInfo = value;
    }

    /**
     * Gets the value of the domainPort property.
     * 
     */
    public int getDomainPort() {
        return domainPort;
    }

    /**
     * Sets the value of the domainPort property.
     * 
     */
    public void setDomainPort(int value) {
        this.domainPort = value;
    }

    /**
     * Gets the value of the superDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuperDomain() {
        return superDomain;
    }

    /**
     * Sets the value of the superDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuperDomain(String value) {
        this.superDomain = value;
    }

    /**
     * Gets the value of the isLocalDomain property.
     * 
     */
    public int getIsLocalDomain() {
        return isLocalDomain;
    }

    /**
     * Sets the value of the isLocalDomain property.
     * 
     */
    public void setIsLocalDomain(int value) {
        this.isLocalDomain = value;
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
